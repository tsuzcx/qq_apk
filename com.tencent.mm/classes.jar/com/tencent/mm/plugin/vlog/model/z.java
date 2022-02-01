package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.p;
import d.k.i;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class z
{
  public static final a BYj;
  zc BYi;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(191284);
    BYj = new a((byte)0);
    AppMethodBeat.o(191284);
  }
  
  private final Bitmap a(Bitmap paramBitmap, g paramg, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(191283);
    if (!paramg.qfO.contains(paramg.hpa)) {
      ae.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramg.qfO.width();
    float f3 = paramInt1 * 1.0F / paramg.hpa.width();
    float f4 = paramInt2 * 1.0F / paramg.hpa.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramg.hpa.left - paramg.qfO.left) * f2);
      paramInt2 = (int)((paramg.hpa.top - paramg.qfO.top) * f2);
      int i = (int)(paramg.hpa.width() * f2);
      int j = (int)(paramg.hpa.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      ae.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
      paramg = paramBitmap;
      if (paramInt1 >= 0)
      {
        paramg = paramBitmap;
        if (paramInt2 >= 0)
        {
          paramg = paramBitmap;
          if (paramInt1 + i <= paramBitmap.getWidth())
          {
            paramg = paramBitmap;
            if (paramInt2 + j <= paramBitmap.getHeight())
            {
              paramg = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i, j, localMatrix, true);
              p.g(paramg, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(191283);
      return paramg;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final byz b(w paramw)
  {
    AppMethodBeat.i(191282);
    long l4 = paramw.BXV.Cec;
    Object localObject = this.BYi;
    long l2;
    long l1;
    label75:
    int i;
    int j;
    d locald;
    LinkedList localLinkedList;
    label163:
    label193:
    long l3;
    label220:
    long l5;
    long l6;
    if (localObject != null)
    {
      localObject = ((zc)localObject).Grd;
      if (localObject != null)
      {
        l2 = ((dwr)localObject).IbS;
        localObject = this.BYi;
        if (localObject == null) {
          break label377;
        }
        localObject = ((zc)localObject).Grd;
        if (localObject == null) {
          break label377;
        }
        l1 = ((dwr)localObject).IbR;
        i = Math.min(paramw.BXQ, paramw.BXT.qfO.width());
        j = Math.min(paramw.BXR, paramw.BXT.qfO.height());
        locald = n.m(paramw.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.BYi;
        if (localObject == null) {
          break label383;
        }
        localObject = ((zc)localObject).Grc;
        if (localObject == null) {
          break label383;
        }
        i = (int)((bqe)localObject).bbs;
        localObject = this.BYi;
        if (localObject == null) {
          break label389;
        }
        localObject = ((zc)localObject).Grc;
        if (localObject == null) {
          break label389;
        }
        j = (int)((bqe)localObject).bbt;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label395;
        }
        localObject = i.Njz;
        localObject = i.gkH();
        localObject = d.k.j.a((d.k.g)localObject, l2);
        l3 = ((d.k.g)localObject).first;
        l5 = ((d.k.g)localObject).Nju;
        l6 = ((d.k.g)localObject).xMb;
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
        localObject = a((Bitmap)localObject, paramw.BXT, i, j);
        m = ((Bitmap)localObject).getWidth();
        k = ((Bitmap)localObject).getHeight();
        localLinkedList.add(new com.tencent.mm.bw.b(h.j((Bitmap)localObject, 20)));
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
      localObject = new byz();
      ((byz)localObject).id = paramw.id;
      ((byz)localObject).HlR = localLinkedList;
      paramw = new bqe();
      paramw.bbs = i;
      paramw.bbt = j;
      ((byz)localObject).HlS = paramw;
      ((byz)localObject).dmg = 2L;
      ((byz)localObject).Hkz = l4;
      AppMethodBeat.o(191282);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<byz> gM(List<w> paramList)
  {
    AppMethodBeat.i(191281);
    p.h(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label154:
    label184:
    label318:
    label351:
    while (localIterator.hasNext())
    {
      Object localObject1 = (w)localIterator.next();
      p.h(localObject1, "track");
      int i;
      int j;
      if (((w)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((w)localObject1).BXQ * ((w)localObject1).BXS / ((w)localObject1).BXT.qfO.width()));
        paramList = MMBitmapFactory.decodeFile(((w)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.BYi;
          if (localObject2 != null)
          {
            localObject2 = ((zc)localObject2).Grc;
            if (localObject2 != null)
            {
              i = (int)((bqe)localObject2).bbs;
              localObject2 = this.BYi;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((zc)localObject2).Grc;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((bqe)localObject2).bbt;
              localObject2 = a(paramList, ((w)localObject1).BXT, i, j);
              byte[] arrayOfByte = h.j((Bitmap)localObject2, 20);
              paramList = new byz();
              paramList.id = ((w)localObject1).id;
              paramList.HlR = new LinkedList((Collection)d.a.j.listOf(new com.tencent.mm.bw.b(arrayOfByte)));
              localObject1 = new bqe();
              ((bqe)localObject1).bbs = ((Bitmap)localObject2).getWidth();
              ((bqe)localObject1).bbt = ((Bitmap)localObject2).getHeight();
              paramList.HlS = ((bqe)localObject1);
              paramList.dmg = 1L;
              paramList.Hkz = 0L;
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
        if (((w)localObject1).type == 2) {
          paramList = b((w)localObject1);
        } else {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(191281);
    return localLinkedList;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator$Companion;", "", "()V", "DefaultImageHeight", "", "DefaultImageWidth", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */