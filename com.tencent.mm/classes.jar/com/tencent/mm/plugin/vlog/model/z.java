package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.k.e;
import d.k.h;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class z
{
  public static final a BGK;
  yz BGJ;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(195825);
    BGK = new a((byte)0);
    AppMethodBeat.o(195825);
  }
  
  private final Bitmap a(Bitmap paramBitmap, g paramg, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(195824);
    if (!paramg.pZj.contains(paramg.hmm)) {
      ad.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramg.pZj.width();
    float f3 = paramInt1 * 1.0F / paramg.hmm.width();
    float f4 = paramInt2 * 1.0F / paramg.hmm.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramg.hmm.left - paramg.pZj.left) * f2);
      paramInt2 = (int)((paramg.hmm.top - paramg.pZj.top) * f2);
      int i = (int)(paramg.hmm.width() * f2);
      int j = (int)(paramg.hmm.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      ad.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
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
      AppMethodBeat.o(195824);
      return paramg;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final byf b(w paramw)
  {
    AppMethodBeat.i(195823);
    long l4 = paramw.BGw.BMD;
    Object localObject = this.BGJ;
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
      localObject = ((yz)localObject).FYE;
      if (localObject != null)
      {
        l2 = ((dvw)localObject).HIg;
        localObject = this.BGJ;
        if (localObject == null) {
          break label377;
        }
        localObject = ((yz)localObject).FYE;
        if (localObject == null) {
          break label377;
        }
        l1 = ((dvw)localObject).HIf;
        i = Math.min(paramw.BGr, paramw.BGu.pZj.width());
        j = Math.min(paramw.BGs, paramw.BGu.pZj.height());
        locald = n.m(paramw.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.BGJ;
        if (localObject == null) {
          break label383;
        }
        localObject = ((yz)localObject).FYD;
        if (localObject == null) {
          break label383;
        }
        i = (int)((bpm)localObject).bbs;
        localObject = this.BGJ;
        if (localObject == null) {
          break label389;
        }
        localObject = ((yz)localObject).FYD;
        if (localObject == null) {
          break label389;
        }
        j = (int)((bpm)localObject).bbt;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label395;
        }
        localObject = d.k.g.MMu;
        localObject = d.k.g.ggf();
        localObject = h.a((e)localObject, l2);
        l3 = ((e)localObject).first;
        l5 = ((e)localObject).MMp;
        l6 = ((e)localObject).xwe;
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
        localObject = a((Bitmap)localObject, paramw.BGu, i, j);
        m = ((Bitmap)localObject).getWidth();
        k = ((Bitmap)localObject).getHeight();
        localLinkedList.add(new com.tencent.mm.bx.b(com.tencent.mm.sdk.platformtools.g.j((Bitmap)localObject, 20)));
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
      localObject = new d.k.g(100L, l3 - 1L);
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
      localObject = new byf();
      ((byf)localObject).id = paramw.id;
      ((byf)localObject).GSq = localLinkedList;
      paramw = new bpm();
      paramw.bbs = i;
      paramw.bbt = j;
      ((byf)localObject).GSr = paramw;
      ((byf)localObject).dle = 2L;
      ((byf)localObject).GQY = l4;
      AppMethodBeat.o(195823);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<byf> gD(List<w> paramList)
  {
    AppMethodBeat.i(195822);
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
        paramList.inSampleSize = ((int)(((w)localObject1).BGr * ((w)localObject1).BGt / ((w)localObject1).BGu.pZj.width()));
        paramList = MMBitmapFactory.decodeFile(((w)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.BGJ;
          if (localObject2 != null)
          {
            localObject2 = ((yz)localObject2).FYD;
            if (localObject2 != null)
            {
              i = (int)((bpm)localObject2).bbs;
              localObject2 = this.BGJ;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((yz)localObject2).FYD;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((bpm)localObject2).bbt;
              localObject2 = a(paramList, ((w)localObject1).BGu, i, j);
              byte[] arrayOfByte = com.tencent.mm.sdk.platformtools.g.j((Bitmap)localObject2, 20);
              paramList = new byf();
              paramList.id = ((w)localObject1).id;
              paramList.GSq = new LinkedList((Collection)j.listOf(new com.tencent.mm.bx.b(arrayOfByte)));
              localObject1 = new bpm();
              ((bpm)localObject1).bbs = ((Bitmap)localObject2).getWidth();
              ((bpm)localObject1).bbt = ((Bitmap)localObject2).getHeight();
              paramList.GSr = ((bpm)localObject1);
              paramList.dle = 1L;
              paramList.GQY = 0L;
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
    AppMethodBeat.o(195822);
    return localLinkedList;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator$Companion;", "", "()V", "DefaultImageHeight", "", "DefaultImageWidth", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */