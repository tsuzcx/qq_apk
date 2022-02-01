package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.o;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.h;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class ag
{
  public static final a Nnu;
  aaw Nnt;
  private final String TAG = "MicroMsg.VLogGenerator";
  
  static
  {
    AppMethodBeat.i(230606);
    Nnu = new a((byte)0);
    AppMethodBeat.o(230606);
  }
  
  private final Bitmap a(Bitmap paramBitmap, j paramj, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(230604);
    if (!paramj.vcr.contains(paramj.kXj)) {
      Log.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / paramj.vcr.width();
    float f3 = paramInt1 * 1.0F / paramj.kXj.width();
    float f4 = paramInt2 * 1.0F / paramj.kXj.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((paramj.kXj.left - paramj.vcr.left) * f2);
      paramInt2 = (int)((paramj.kXj.top - paramj.vcr.top) * f2);
      int i = (int)(paramj.kXj.width() * f2);
      int j = (int)(paramj.kXj.height() * f2);
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
              p.j(paramj, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(230604);
      return paramj;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final cvl a(ad paramad)
  {
    AppMethodBeat.i(230602);
    long l4 = paramad.Nng.NwS;
    Object localObject = this.Nnt;
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
      localObject = ((aaw)localObject).Snj;
      if (localObject != null)
      {
        l2 = ((fbi)localObject).UBn;
        localObject = this.Nnt;
        if (localObject == null) {
          break label377;
        }
        localObject = ((aaw)localObject).Snj;
        if (localObject == null) {
          break label377;
        }
        l1 = ((fbi)localObject).UBm;
        i = Math.min(paramad.Nna, paramad.Nnd.vcr.width());
        j = Math.min(paramad.Nnb, paramad.Nnd.vcr.height());
        locald = o.p(paramad.path, 100, i, j);
        localLinkedList = new LinkedList();
        localObject = this.Nnt;
        if (localObject == null) {
          break label383;
        }
        localObject = ((aaw)localObject).Sni;
        if (localObject == null) {
          break label383;
        }
        i = (int)((cla)localObject).width;
        localObject = this.Nnt;
        if (localObject == null) {
          break label389;
        }
        localObject = ((aaw)localObject).Sni;
        if (localObject == null) {
          break label389;
        }
        j = (int)((cla)localObject).height;
        l3 = l4 - 100L;
        if (l3 > -9223372036854775808L) {
          break label395;
        }
        localObject = h.aaCb;
        localObject = h.iCv();
        localObject = i.a((f)localObject, l2);
        l3 = ((f)localObject).first;
        l5 = ((f)localObject).aaBW;
        l6 = ((f)localObject).HIt;
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
        p.j(localObject, "bitmap");
        localObject = a((Bitmap)localObject, paramad.Nnd, i, j);
        m = ((Bitmap)localObject).getWidth();
        k = ((Bitmap)localObject).getHeight();
        localLinkedList.add(new com.tencent.mm.cd.b(BitmapUtil.Bitmap2Bytes((Bitmap)localObject, 20)));
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
      localObject = new h(100L, l3 - 1L);
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
      localObject = new cvl();
      ((cvl)localObject).id = paramad.id;
      ((cvl)localObject).TDn = localLinkedList;
      paramad = new cla();
      paramad.width = i;
      paramad.height = j;
      ((cvl)localObject).TDo = paramad;
      ((cvl)localObject).fwf = 2L;
      ((cvl)localObject).TCb = l4;
      AppMethodBeat.o(230602);
      return localObject;
      i = m;
      j = k;
    }
  }
  
  public final LinkedList<cvl> iD(List<ad> paramList)
  {
    AppMethodBeat.i(230598);
    p.k(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label154:
    label184:
    label318:
    label351:
    while (localIterator.hasNext())
    {
      Object localObject1 = (ad)localIterator.next();
      p.k(localObject1, "track");
      int i;
      int j;
      if (((ad)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((ad)localObject1).Nna * ((ad)localObject1).Nnc / ((ad)localObject1).Nnd.vcr.width()));
        paramList = MMBitmapFactory.decodeFile(((ad)localObject1).path, paramList);
        if (paramList != null)
        {
          Object localObject2 = this.Nnt;
          if (localObject2 != null)
          {
            localObject2 = ((aaw)localObject2).Sni;
            if (localObject2 != null)
            {
              i = (int)((cla)localObject2).width;
              localObject2 = this.Nnt;
              if (localObject2 == null) {
                break label318;
              }
              localObject2 = ((aaw)localObject2).Sni;
              if (localObject2 == null) {
                break label318;
              }
              j = (int)((cla)localObject2).height;
              localObject2 = a(paramList, ((ad)localObject1).Nnd, i, j);
              byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes((Bitmap)localObject2, 20);
              paramList = new cvl();
              paramList.id = ((ad)localObject1).id;
              paramList.TDn = new LinkedList((Collection)kotlin.a.j.listOf(new com.tencent.mm.cd.b(arrayOfByte)));
              localObject1 = new cla();
              ((cla)localObject1).width = ((Bitmap)localObject2).getWidth();
              ((cla)localObject1).height = ((Bitmap)localObject2).getHeight();
              paramList.TDo = ((cla)localObject1);
              paramList.fwf = 1L;
              paramList.TCb = 0L;
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
    AppMethodBeat.o(230598);
    return localLinkedList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator$Companion;", "", "()V", "DefaultImageHeight", "", "DefaultImageWidth", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ag
 * JD-Core Version:    0.7.0.1
 */