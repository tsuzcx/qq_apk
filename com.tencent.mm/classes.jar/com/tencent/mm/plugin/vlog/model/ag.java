package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.eqx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.g;
import kotlin.k.i;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class ag
{
  public static final ag.a GzO;
  aar GzN;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(190723);
    GzO = new ag.a((byte)0);
    AppMethodBeat.o(190723);
  }
  
  private final Bitmap a(Bitmap paramBitmap, j paramj, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(190722);
    if (!paramj.rwL.contains(paramj.iiw)) {
      Log.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramj.rwL.width();
    float f3 = paramInt1 * 1.0F / paramj.iiw.width();
    float f4 = paramInt2 * 1.0F / paramj.iiw.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramj.iiw.left - paramj.rwL.left) * f2);
      paramInt2 = (int)((paramj.iiw.top - paramj.rwL.top) * f2);
      int i = (int)(paramj.iiw.width() * f2);
      int j = (int)(paramj.iiw.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      Log.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
      paramj = paramBitmap;
      if (paramInt1 >= 0)
      {
        paramj = paramBitmap;
        if (paramInt2 >= 0)
        {
          paramj = paramBitmap;
          if (paramInt1 + i <= paramBitmap.getWidth())
          {
            paramj = paramBitmap;
            if (paramInt2 + j <= paramBitmap.getHeight())
            {
              paramj = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i, j, localMatrix, true);
              p.g(paramj, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(190722);
      return paramj;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final cmt a(ad paramad)
  {
    AppMethodBeat.i(190721);
    long l4 = paramad.GzA.GJB;
    Object localObject = this.GzN;
    long l2;
    long l1;
    label75:
    int i;
    int j;
    com.tencent.mm.plugin.mmsight.segment.d locald;
    LinkedList localLinkedList;
    label163:
    label193:
    long l3;
    label220:
    long l5;
    long l6;
    if (localObject != null)
    {
      localObject = ((aar)localObject).LlZ;
      if (localObject != null)
      {
        l2 = ((eqx)localObject).Noq;
        localObject = this.GzN;
        if (localObject == null) {
          break label377;
        }
        localObject = ((aar)localObject).LlZ;
        if (localObject == null) {
          break label377;
        }
        l1 = ((eqx)localObject).Nop;
        i = Math.min(paramad.Gzu, paramad.Gzx.rwL.width());
        j = Math.min(paramad.Gzv, paramad.Gzx.rwL.height());
        locald = n.m(paramad.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.GzN;
        if (localObject == null) {
          break label383;
        }
        localObject = ((aar)localObject).LlY;
        if (localObject == null) {
          break label383;
        }
        i = (int)((ccw)localObject).width;
        localObject = this.GzN;
        if (localObject == null) {
          break label389;
        }
        localObject = ((aar)localObject).LlY;
        if (localObject == null) {
          break label389;
        }
        j = (int)((ccw)localObject).height;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label395;
        }
        localObject = i.SZh;
        localObject = i.hyk();
        localObject = kotlin.k.j.a((g)localObject, l2);
        l3 = ((g)localObject).first;
        l5 = ((g)localObject).SZc;
        l6 = ((g)localObject).BMh;
        if (l6 < 0L) {
          break label414;
        }
        if (l3 > l5) {
          break label426;
        }
        l2 = l3;
      }
    }
    int m;
    int k;
    label377:
    label383:
    do
    {
      for (;;)
      {
        localObject = locald.getFrameAtTime(l2);
        p.g(localObject, "bitmap");
        localObject = a((Bitmap)localObject, paramad.Gzx, i, j);
        m = ((Bitmap)localObject).getWidth();
        k = ((Bitmap)localObject).getHeight();
        localLinkedList.add(new b(BitmapUtil.Bitmap2Bytes((Bitmap)localObject, 20)));
        if ((localLinkedList.size() >= l1) || (l2 == l5)) {
          break;
        }
        l2 += l6;
      }
      l2 = 100L;
      break;
      l1 = 1L;
      break label75;
      i = 120;
      break label163;
      j = 120;
      break label193;
      localObject = new i(100L, l3 - 1L);
      break label220;
      l2 = l3;
    } while (l3 >= l5);
    for (;;)
    {
      label389:
      label395:
      label414:
      label426:
      locald.release();
      localObject = new cmt();
      ((cmt)localObject).id = paramad.id;
      ((cmt)localObject).Msh = localLinkedList;
      paramad = new ccw();
      paramad.width = i;
      paramad.height = j;
      ((cmt)localObject).Msi = paramad;
      ((cmt)localObject).dDw = 2L;
      ((cmt)localObject).MqN = l4;
      AppMethodBeat.o(190721);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<cmt> hO(List<ad> paramList)
  {
    AppMethodBeat.i(190720);
    p.h(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label154:
    label184:
    label318:
    label351:
    while (localIterator.hasNext())
    {
      Object localObject1 = (ad)localIterator.next();
      p.h(localObject1, "track");
      int i;
      int j;
      if (((ad)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((ad)localObject1).Gzu * ((ad)localObject1).Gzw / ((ad)localObject1).Gzx.rwL.width()));
        paramList = MMBitmapFactory.decodeFile(((ad)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.GzN;
          if (localObject2 != null)
          {
            localObject2 = ((aar)localObject2).LlY;
            if (localObject2 != null)
            {
              i = (int)((ccw)localObject2).width;
              localObject2 = this.GzN;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((aar)localObject2).LlY;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((ccw)localObject2).height;
              localObject2 = a(paramList, ((ad)localObject1).Gzx, i, j);
              byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes((Bitmap)localObject2, 20);
              paramList = new cmt();
              paramList.id = ((ad)localObject1).id;
              paramList.Msh = new LinkedList((Collection)kotlin.a.j.listOf(new b(arrayOfByte)));
              localObject1 = new ccw();
              ((ccw)localObject1).width = ((Bitmap)localObject2).getWidth();
              ((ccw)localObject1).height = ((Bitmap)localObject2).getHeight();
              paramList.Msi = ((ccw)localObject1);
              paramList.dDw = 1L;
              paramList.MqN = 0L;
            }
          }
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label351;
        }
        localLinkedList.add(paramList);
        break;
        i = 120;
        break label154;
        j = 120;
        break label184;
        paramList = null;
        continue;
        if (((ad)localObject1).type == 2) {
          paramList = a((ad)localObject1);
        } else {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(190720);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ag
 * JD-Core Version:    0.7.0.1
 */