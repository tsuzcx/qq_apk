package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.o;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import d.a.j;
import d.g.b.k;
import d.k.e;
import d.k.g;
import d.k.h;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class aa
{
  public static final a LrH;
  wp LrG;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(200952);
    LrH = new a((byte)0);
    AppMethodBeat.o(200952);
  }
  
  private final Bitmap a(Bitmap paramBitmap, n paramn, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(200951);
    if (!paramn.oSt.contains(paramn.gtE)) {
      ad.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramn.oSt.width();
    float f3 = paramInt1 * 1.0F / paramn.gtE.width();
    float f4 = paramInt2 * 1.0F / paramn.gtE.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramn.gtE.left - paramn.oSt.left) * f2);
      paramInt2 = (int)((paramn.gtE.top - paramn.oSt.top) * f2);
      int i = (int)(paramn.gtE.width() * f2);
      int j = (int)(paramn.gtE.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      ad.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
      paramn = paramBitmap;
      if (paramInt1 >= 0)
      {
        paramn = paramBitmap;
        if (paramInt2 >= 0)
        {
          paramn = paramBitmap;
          if (paramInt1 + i <= paramBitmap.getWidth())
          {
            paramn = paramBitmap;
            if (paramInt2 + j <= paramBitmap.getHeight())
            {
              paramn = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i, j, localMatrix, true);
              k.g(paramn, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(200951);
      return paramn;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final bpb d(y paramy)
  {
    AppMethodBeat.i(200950);
    long l4 = paramy.Lrq;
    Object localObject = this.LrG;
    long l2;
    long l1;
    label72:
    int i;
    int j;
    d locald;
    LinkedList localLinkedList;
    label160:
    label190:
    long l3;
    label217:
    long l5;
    long l6;
    if (localObject != null)
    {
      localObject = ((wp)localObject).CYK;
      if (localObject != null)
      {
        l2 = ((dko)localObject).EAd;
        localObject = this.LrG;
        if (localObject == null) {
          break label374;
        }
        localObject = ((wp)localObject).CYK;
        if (localObject == null) {
          break label374;
        }
        l1 = ((dko)localObject).EAc;
        i = Math.min(paramy.Lrr, paramy.Lru.oSt.width());
        j = Math.min(paramy.Lrs, paramy.Lru.oSt.height());
        locald = o.m(paramy.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.LrG;
        if (localObject == null) {
          break label380;
        }
        localObject = ((wp)localObject).CYJ;
        if (localObject == null) {
          break label380;
        }
        i = (int)((bhk)localObject).aQh;
        localObject = this.LrG;
        if (localObject == null) {
          break label386;
        }
        localObject = ((wp)localObject).CYJ;
        if (localObject == null) {
          break label386;
        }
        j = (int)((bhk)localObject).aQi;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label392;
        }
        localObject = g.JhU;
        localObject = g.fwb();
        localObject = h.a((e)localObject, l2);
        l3 = ((e)localObject).first;
        l5 = ((e)localObject).JhP;
        l6 = ((e)localObject).vfC;
        if (l6 < 0L) {
          break label411;
        }
        if (l3 > l5) {
          break label423;
        }
        l2 = l3;
      }
    }
    int m;
    int k;
    label374:
    label380:
    do
    {
      for (;;)
      {
        localObject = locald.getFrameAtTime(l2);
        k.g(localObject, "bitmap");
        localObject = a((Bitmap)localObject, paramy.Lru, i, j);
        m = ((Bitmap)localObject).getWidth();
        k = ((Bitmap)localObject).getHeight();
        localLinkedList.add(new b(f.j((Bitmap)localObject, 20)));
        if ((localLinkedList.size() >= l1) || (l2 == l5)) {
          break;
        }
        l2 += l6;
      }
      l2 = 100L;
      break;
      l1 = 1L;
      break label72;
      i = 120;
      break label160;
      j = 120;
      break label190;
      localObject = new g(100L, l3 - 1L);
      break label217;
      l2 = l3;
    } while (l3 >= l5);
    for (;;)
    {
      label386:
      label392:
      label411:
      label423:
      locald.release();
      localObject = new bpb();
      ((bpb)localObject).id = paramy.id;
      ((bpb)localObject).DMz = localLinkedList;
      paramy = new bhk();
      paramy.aQh = i;
      paramy.aQi = j;
      ((bpb)localObject).DMA = paramy;
      ((bpb)localObject).dcn = 2L;
      ((bpb)localObject).DLh = l4;
      AppMethodBeat.o(200950);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<bpb> jb(List<y> paramList)
  {
    AppMethodBeat.i(200949);
    k.h(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label154:
    label184:
    label318:
    label351:
    while (localIterator.hasNext())
    {
      Object localObject1 = (y)localIterator.next();
      k.h(localObject1, "track");
      int i;
      int j;
      if (((y)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((y)localObject1).Lrr * ((y)localObject1).Lrt / ((y)localObject1).Lru.oSt.width()));
        paramList = MMBitmapFactory.decodeFile(((y)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.LrG;
          if (localObject2 != null)
          {
            localObject2 = ((wp)localObject2).CYJ;
            if (localObject2 != null)
            {
              i = (int)((bhk)localObject2).aQh;
              localObject2 = this.LrG;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((wp)localObject2).CYJ;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((bhk)localObject2).aQi;
              localObject2 = a(paramList, ((y)localObject1).Lru, i, j);
              byte[] arrayOfByte = f.j((Bitmap)localObject2, 20);
              paramList = new bpb();
              paramList.id = ((y)localObject1).id;
              paramList.DMz = new LinkedList((Collection)j.listOf(new b(arrayOfByte)));
              localObject1 = new bhk();
              ((bhk)localObject1).aQh = ((Bitmap)localObject2).getWidth();
              ((bhk)localObject1).aQi = ((Bitmap)localObject2).getHeight();
              paramList.DMA = ((bhk)localObject1);
              paramList.dcn = 1L;
              paramList.DLh = 0L;
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
        if (((y)localObject1).type == 2) {
          paramList = d((y)localObject1);
        } else {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(200949);
    return localLinkedList;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator$Companion;", "", "()V", "DefaultImageHeight", "", "DefaultImageWidth", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.aa
 * JD-Core Version:    0.7.0.1
 */