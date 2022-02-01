package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ac;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class x
{
  public static final x.a AoT;
  xa AoS;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(207638);
    AoT = new x.a((byte)0);
    AppMethodBeat.o(207638);
  }
  
  private final Bitmap a(Bitmap paramBitmap, d paramd, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(207637);
    if (!paramd.pvE.contains(paramd.gUl)) {
      ac.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramd.pvE.width();
    float f3 = paramInt1 * 1.0F / paramd.gUl.width();
    float f4 = paramInt2 * 1.0F / paramd.gUl.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramd.gUl.left - paramd.pvE.left) * f2);
      paramInt2 = (int)((paramd.gUl.top - paramd.pvE.top) * f2);
      int i = (int)(paramd.gUl.width() * f2);
      int j = (int)(paramd.gUl.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      ac.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
      paramd = paramBitmap;
      if (paramInt1 >= 0)
      {
        paramd = paramBitmap;
        if (paramInt2 >= 0)
        {
          paramd = paramBitmap;
          if (paramInt1 + i <= paramBitmap.getWidth())
          {
            paramd = paramBitmap;
            if (paramInt2 + j <= paramBitmap.getHeight())
            {
              paramd = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i, j, localMatrix, true);
              k.g(paramd, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(207637);
      return paramd;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final btr d(u paramu)
  {
    AppMethodBeat.i(207636);
    long l4 = paramu.Aoz;
    Object localObject = this.AoS;
    long l2;
    long l1;
    label72:
    int i;
    int j;
    com.tencent.mm.plugin.mmsight.segment.d locald;
    LinkedList localLinkedList;
    label160:
    label190:
    long l3;
    label217:
    long l5;
    long l6;
    if (localObject != null)
    {
      localObject = ((xa)localObject).Eru;
      if (localObject != null)
      {
        l2 = ((dqf)localObject).FXr;
        localObject = this.AoS;
        if (localObject == null) {
          break label374;
        }
        localObject = ((xa)localObject).Eru;
        if (localObject == null) {
          break label374;
        }
        l1 = ((dqf)localObject).FXq;
        i = Math.min(paramu.AoA, paramu.AoD.pvE.width());
        j = Math.min(paramu.AoB, paramu.AoD.pvE.height());
        locald = n.m(paramu.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.AoS;
        if (localObject == null) {
          break label380;
        }
        localObject = ((xa)localObject).Ert;
        if (localObject == null) {
          break label380;
        }
        i = (int)((blc)localObject).aQX;
        localObject = this.AoS;
        if (localObject == null) {
          break label386;
        }
        localObject = ((xa)localObject).Ert;
        if (localObject == null) {
          break label386;
        }
        j = (int)((blc)localObject).aQY;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label392;
        }
        localObject = g.KVo;
        localObject = g.fOF();
        localObject = h.a((e)localObject, l2);
        l3 = ((e)localObject).first;
        l5 = ((e)localObject).KVj;
        l6 = ((e)localObject).woo;
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
        localObject = a((Bitmap)localObject, paramu.AoD, i, j);
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
      localObject = new btr();
      ((btr)localObject).id = paramu.id;
      ((btr)localObject).FiP = localLinkedList;
      paramu = new blc();
      paramu.aQX = i;
      paramu.aQY = j;
      ((btr)localObject).FiQ = paramu;
      ((btr)localObject).cZM = 2L;
      ((btr)localObject).Fhw = l4;
      AppMethodBeat.o(207636);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<btr> gs(List<u> paramList)
  {
    AppMethodBeat.i(207635);
    k.h(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label154:
    label184:
    label318:
    label351:
    while (localIterator.hasNext())
    {
      Object localObject1 = (u)localIterator.next();
      k.h(localObject1, "track");
      int i;
      int j;
      if (((u)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((u)localObject1).AoA * ((u)localObject1).AoC / ((u)localObject1).AoD.pvE.width()));
        paramList = MMBitmapFactory.decodeFile(((u)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.AoS;
          if (localObject2 != null)
          {
            localObject2 = ((xa)localObject2).Ert;
            if (localObject2 != null)
            {
              i = (int)((blc)localObject2).aQX;
              localObject2 = this.AoS;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((xa)localObject2).Ert;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((blc)localObject2).aQY;
              localObject2 = a(paramList, ((u)localObject1).AoD, i, j);
              byte[] arrayOfByte = f.j((Bitmap)localObject2, 20);
              paramList = new btr();
              paramList.id = ((u)localObject1).id;
              paramList.FiP = new LinkedList((Collection)j.listOf(new b(arrayOfByte)));
              localObject1 = new blc();
              ((blc)localObject1).aQX = ((Bitmap)localObject2).getWidth();
              ((blc)localObject1).aQY = ((Bitmap)localObject2).getHeight();
              paramList.FiQ = ((blc)localObject1);
              paramList.cZM = 1L;
              paramList.Fhw = 0L;
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
        if (((u)localObject1).type == 2) {
          paramList = d((u)localObject1);
        } else {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(207635);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.x
 * JD-Core Version:    0.7.0.1
 */