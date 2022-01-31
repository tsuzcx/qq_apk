package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.a;
import com.tencent.filter.m.f;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransformFilter
  extends VideoFilterBase
{
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, -1.0F, 1.0F, -1.0F, 1.0F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, 0.0F, 1.0F, 0.0F, 1.0F);
  private float[] flatMesh = new float['ð'];
  private List<DistortionItem> items;
  private MeshDistortionType[] meshs = new MeshDistortionType[30];
  private List<StickerItem> stickerItems;
  
  public TransformFilter(List<DistortionItem> paramList, List<StickerItem> paramList1)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.TRANSFORM);
    this.items = paramList;
    this.stickerItems = paramList1;
    initParams();
  }
  
  private float getStrengthAdjust()
  {
    if ("OPPO_X909".equals(DeviceInstance.getInstance().getDeviceName())) {
      return 0.2F;
    }
    return 1.0F;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public List<DistortionItem> getDistortionItems()
  {
    return this.items;
  }
  
  public void initAttribParams()
  {
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(6651);
  }
  
  public void initParams()
  {
    addParam(new m.f("screenRatio", 0.0F));
    addParam(new m.a("item", this.flatMesh));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      i += 1;
    }
  }
  
  public void setDistortionItems(List<DistortionItem> paramList)
  {
    this.items = paramList;
  }
  
  public void updateFaceFeatures(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 131)) {}
    for (;;)
    {
      return;
      float f3 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
      float f4 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
      float f1 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
      float f2 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
      f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      f1 = (float)Math.sqrt(f2 * f2 + f1 * f1) / f3;
      f2 = ((PointF)paramList.get(9)).x;
      f3 = ((PointF)paramList.get(84)).x;
      f4 = -((PointF)paramList.get(9)).y;
      float f5 = ((PointF)paramList.get(84)).y;
      f2 = (float)(Math.atan2(f2 - f3, f5 + f4) + 3.141592653589793D);
      f3 = this.height / this.width;
      f4 = (float)(2.0D / (this.width * this.mFaceDetScale));
      f5 = (float)(2.0D / (this.height * this.mFaceDetScale));
      int i = 0;
      while (i < 131)
      {
        if ((i < 99) || (i > 106))
        {
          PointF localPointF1 = new PointF(((PointF)paramList.get(i)).x * f4 - 1.0F, ((PointF)paramList.get(i)).y * f5 - 1.0F);
          int j = 0;
          if (j < this.meshs.length)
          {
            float f8;
            float f7;
            if (this.meshs[j].type > 0)
            {
              localPointF2 = new PointF(this.meshs[j].point.x * f4 - 1.0F, (this.meshs[j].point.y * f5 - 1.0F) * f3);
              PointF localPointF3 = new PointF(localPointF1.x, localPointF1.y * f3);
              f6 = AlgoUtils.getDistance(localPointF2, localPointF3);
              if (f6 < this.meshs[j].radius)
              {
                f8 = f6 / this.meshs[j].radius;
                f6 = localPointF2.x - localPointF3.x;
                f7 = (localPointF2.y - localPointF3.y) / f3;
                if (this.meshs[j].type != 1) {
                  break label639;
                }
                f8 = (float)(1.5D * (1.0D - Math.sin(f8 * 3.1415D * 0.5D)) * this.meshs[j].strength);
                localPointF1.x -= f6 * f8;
                localPointF1.y -= f7 * f8;
              }
            }
            label639:
            do
            {
              for (;;)
              {
                j += 1;
                break;
                if (this.meshs[j].type != 2) {
                  break label713;
                }
                f8 = (float)(Math.cos(1.57075D * f8) * this.meshs[j].strength);
                localPointF1.x += f6 * f8;
                localPointF1.y = (f7 * f8 + localPointF1.y);
              }
            } while (this.meshs[j].type != 3);
            label713:
            float f6 = (float)(Math.cos(1.57075D * f8) * this.meshs[j].radius * 0.5D / f1 * this.meshs[j].strength);
            PointF localPointF2 = new PointF(f1, f1 / f3);
            if (this.meshs[j].direction == 1)
            {
              f7 = localPointF2.x;
              localPointF2.x = (-f6 * f7);
              localPointF2.y = 0.0F;
            }
            for (;;)
            {
              localPointF1.x = ((float)(localPointF1.x + (localPointF2.x * Math.cos(f2) - localPointF2.y * Math.sin(f2))));
              double d1 = localPointF1.y;
              double d2 = localPointF2.y;
              double d3 = Math.cos(f2);
              localPointF1.y = ((float)((localPointF2.x * Math.sin(f2) + d2 * d3) / f3 + d1));
              break;
              if (this.meshs[j].direction == 2)
              {
                localPointF2.x = 0.0F;
                f7 = localPointF2.y;
                localPointF2.y = (-f6 * f7);
              }
              else if (this.meshs[j].direction == 3)
              {
                localPointF2.x = (f6 * localPointF2.x);
                localPointF2.y = 0.0F;
              }
              else if (this.meshs[j].direction == 4)
              {
                localPointF2.x = 0.0F;
                localPointF2.y = (f6 * localPointF2.y);
              }
              else if (this.meshs[j].direction == 5)
              {
                localPointF2.x *= -f6;
                f7 = localPointF2.y;
                localPointF2.y = (-f6 * f7);
              }
              else if (this.meshs[j].direction == 6)
              {
                localPointF2.x *= f6;
                f7 = localPointF2.y;
                localPointF2.y = (-f6 * f7);
              }
              else if (this.meshs[j].direction == 7)
              {
                localPointF2.x *= -f6;
                localPointF2.y = (f6 * localPointF2.y);
              }
              else if (this.meshs[j].direction == 8)
              {
                localPointF2.x *= f6;
                localPointF2.y = (f6 * localPointF2.y);
              }
              else
              {
                localPointF2.x = 0.0F;
                localPointF2.y = 0.0F;
              }
            }
          }
          ((PointF)paramList.get(i)).x = ((localPointF1.x + 1.0F) / f4);
          ((PointF)paramList.get(i)).y = ((localPointF1.y + 1.0F) / f5);
        }
        i += 1;
      }
    }
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble)
  {
    List localList = VideoMaterialUtil.copyList(paramList);
    Arrays.fill(this.flatMesh, -1.0F);
    if ((localList != null) && (localList.size() >= 90) && (!VideoUtil.isEmpty(this.items)) && ((VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet)) || (this.mIsRenderForBitmap)))
    {
      paramList = TransformUtil.getFullPoints(localList);
      float f1 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
      float f4 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
      float f2 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
      float f3 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
      f1 = (float)Math.sqrt(f1 * f1 + f4 * f4);
      f2 = (float)Math.sqrt(f3 * f3 + f2 * f2) / f1;
      f3 = ((PointF)paramList.get(9)).x;
      f4 = ((PointF)paramList.get(84)).x;
      float f5 = -((PointF)paramList.get(9)).y;
      float f6 = ((PointF)paramList.get(84)).y;
      f3 = (float)(Math.atan2(f3 - f4, f6 + f5) + 3.141592653589793D);
      f4 = getStrengthAdjust();
      int j = paramList.size();
      int i = 0;
      while (i < this.items.size())
      {
        paramSet = (DistortionItem)this.items.get(i);
        this.meshs[i].type = paramSet.distortion;
        this.meshs[i].strength = (paramSet.strength * f4);
        if (paramSet.position < j) {
          this.meshs[i].point = ((PointF)paramList.get(paramSet.position));
        }
        this.meshs[i].radius = ((float)(paramSet.radius * f1 / paramDouble / Math.min(this.width, this.height) / 375.0D));
        this.meshs[i].offsetX = (paramSet.x * f1 / 375.0F);
        this.meshs[i].offsetY = (-(paramSet.y * f1 / 375.0F));
        this.meshs[i].direction = paramSet.direction;
        this.meshs[i].faceDegree = f3;
        this.meshs[i].faceRatio = f2;
        i += 1;
      }
      i = this.items.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      j = 0;
      i = 0;
      while (i < this.items.size())
      {
        paramList = this.flatMesh;
        int k = j + 1;
        paramList[j] = this.meshs[i].type;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].strength;
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = ((float)(2.0F * (this.meshs[i].point.x + this.meshs[i].offsetX) / paramDouble / this.width - 1.0D));
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = ((float)(2.0F * (this.meshs[i].point.y + this.meshs[i].offsetY) / paramDouble / this.height - 1.0D));
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = this.meshs[i].radius;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].direction;
        paramList = this.flatMesh;
        k = j + 1;
        paramList[j] = this.meshs[i].faceDegree;
        paramList = this.flatMesh;
        j = k + 1;
        paramList[k] = this.meshs[i].faceRatio;
        i += 1;
      }
    }
    addParam(new m.a("item", this.flatMesh));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    updateParams(paramList1, paramSet, this.mFaceDetScale);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.f("screenRatio", this.height / this.width));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilter
 * JD-Core Version:    0.7.0.1
 */