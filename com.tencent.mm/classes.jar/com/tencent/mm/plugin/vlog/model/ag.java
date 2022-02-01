package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.o;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.fxq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.h;
import kotlin.k.h.a;
import kotlin.k.j;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", "origin", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ag.a UaU;
  private final String TAG = "MicroMsg.VLogGenerator";
  acw UaV;
  
  static
  {
    AppMethodBeat.i(283631);
    UaU = new ag.a((byte)0);
    AppMethodBeat.o(283631);
  }
  
  private final Bitmap a(Bitmap paramBitmap, i parami, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(283628);
    if (!parami.yok.contains(parami.Gl)) {
      Log.i(this.TAG, "cropBitmap: cropInfo is Error?");
    }
    float f2 = paramBitmap.getWidth() * 1.0F / parami.yok.width();
    float f3 = paramInt1 * 1.0F / parami.Gl.width();
    float f4 = paramInt2 * 1.0F / parami.Gl.height();
    if ((f3 >= 1.0F) && (f4 >= 1.0F)) {}
    for (;;)
    {
      paramInt1 = (int)((parami.Gl.left - parami.yok.left) * f2);
      paramInt2 = (int)((parami.Gl.top - parami.yok.top) * f2);
      int i = (int)(parami.Gl.width() * f2);
      int j = (int)(parami.Gl.height() * f2);
      Matrix localMatrix = new Matrix();
      f3 = f1 / f2;
      f1 /= f2;
      localMatrix.setScale(f3, f1);
      Log.i(this.TAG, "cropBitmap, left:" + paramInt1 + ", top:" + paramInt2 + ", width:" + i + ", height:" + j + ", scaleX:" + f3 + ", scaleY:" + f1 + ", bitmap size:[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + ']');
      parami = paramBitmap;
      if (paramInt1 >= 0)
      {
        parami = paramBitmap;
        if (paramInt2 >= 0)
        {
          parami = paramBitmap;
          if (paramInt1 + i <= paramBitmap.getWidth())
          {
            parami = paramBitmap;
            if (paramInt2 + j <= paramBitmap.getHeight())
            {
              parami = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i, j, localMatrix, true);
              s.s(parami, "createBitmap(origin, cro…eight, scaleMatrix, true)");
            }
          }
        }
      }
      AppMethodBeat.o(283628);
      return parami;
      f1 = Math.min(f3, f4);
    }
  }
  
  private final dmr a(ad paramad)
  {
    AppMethodBeat.i(283619);
    long l4 = paramad.UaI.UjZ;
    Object localObject1 = this.UaV;
    long l1;
    long l2;
    label44:
    int i;
    int j;
    d locald;
    Object localObject2;
    label116:
    long l3;
    label130:
    label157:
    boolean bool;
    label181:
    label223:
    int k;
    if (localObject1 == null)
    {
      l1 = 100L;
      localObject1 = this.UaV;
      if (localObject1 != null) {
        break label519;
      }
      l2 = 1L;
      i = Math.min(paramad.UaC, paramad.UaF.yok.width());
      j = Math.min(paramad.UaD, paramad.UaF.yok.height());
      locald = o.q(paramad.path, 100, i, j);
      localObject2 = new LinkedList();
      localObject1 = this.UaV;
      if (localObject1 != null) {
        break label547;
      }
      i = 120;
      localObject1 = this.UaV;
      if (localObject1 != null) {
        break label575;
      }
      j = 120;
      l3 = l4 - 100L;
      if (l3 > -9223372036854775808L) {
        break label603;
      }
      localObject1 = j.aixD;
      localObject1 = j.klM();
      localObject1 = (h)localObject1;
      s.u(localObject1, "$this$step");
      if (l1 <= 0L) {
        break label622;
      }
      bool = true;
      k.a(bool, (Number)Long.valueOf(l1));
      h.a locala = h.aixz;
      l3 = ((h)localObject1).first;
      long l5 = ((h)localObject1).aixy;
      if (((h)localObject1).NFM <= 0L) {
        break label628;
      }
      localObject1 = new h(l3, l5, l1);
      l3 = ((h)localObject1).first;
      l5 = ((h)localObject1).aixy;
      long l6 = ((h)localObject1).NFM;
      if (l6 > 0L)
      {
        l1 = l3;
        if (l3 <= l5) {}
      }
      else
      {
        if ((l6 >= 0L) || (l5 > l3)) {
          break label636;
        }
        l1 = l3;
      }
      int m;
      do
      {
        l3 = l1;
        l1 = l3 + l6;
        localObject1 = locald.getFrameAtTime(l3);
        s.s(localObject1, "bitmap");
        localObject1 = a((Bitmap)localObject1, paramad.UaF, i, j);
        k = ((Bitmap)localObject1).getWidth();
        m = ((Bitmap)localObject1).getHeight();
        ((LinkedList)localObject2).add(new com.tencent.mm.bx.b(BitmapUtil.Bitmap2Bytes((Bitmap)localObject1, 20)));
      } while ((((LinkedList)localObject2).size() < l2) && (l3 != l5));
      i = m;
      j = i;
    }
    for (;;)
    {
      locald.release();
      localObject1 = new dmr();
      ((dmr)localObject1).id = paramad.id;
      ((dmr)localObject1).msn = ((LinkedList)localObject2);
      paramad = new dbi();
      paramad.width = k;
      paramad.height = j;
      localObject2 = ah.aiuX;
      ((dmr)localObject1).aaSU = paramad;
      ((dmr)localObject1).beV = 2L;
      ((dmr)localObject1).aaRH = l4;
      AppMethodBeat.o(283619);
      return localObject1;
      localObject1 = ((acw)localObject1).Zlv;
      if (localObject1 == null)
      {
        l1 = 100L;
        break;
      }
      l1 = ((fxq)localObject1).abVp;
      break;
      label519:
      localObject1 = ((acw)localObject1).Zlv;
      if (localObject1 == null)
      {
        l2 = 1L;
        break label44;
      }
      l2 = ((fxq)localObject1).abVo;
      break label44;
      label547:
      localObject1 = ((acw)localObject1).Zlu;
      if (localObject1 == null)
      {
        i = 120;
        break label116;
      }
      i = (int)((dbi)localObject1).width;
      break label116;
      label575:
      localObject1 = ((acw)localObject1).Zlu;
      if (localObject1 == null)
      {
        j = 120;
        break label130;
      }
      j = (int)((dbi)localObject1).height;
      break label130;
      label603:
      localObject1 = new j(100L, l3 - 1L);
      break label157;
      label622:
      bool = false;
      break label181;
      label628:
      l1 = -l1;
      break label223;
      label636:
      k = i;
    }
  }
  
  public final LinkedList<dmr> lJ(List<ad> paramList)
  {
    AppMethodBeat.i(283643);
    s.u(paramList, "trackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label138:
    label152:
    label313:
    label368:
    while (localIterator.hasNext())
    {
      Object localObject1 = (ad)localIterator.next();
      s.u(localObject1, "track");
      Object localObject2;
      int i;
      int j;
      if (((ad)localObject1).type == 1)
      {
        paramList = new BitmapFactory.Options();
        paramList.inSampleSize = ((int)(((ad)localObject1).UaC * ((ad)localObject1).UaE / ((ad)localObject1).UaF.yok.width()));
        paramList = MMBitmapFactory.decodeFile(((ad)localObject1).path, paramList);
        if (paramList != null)
        {
          localObject2 = this.UaV;
          if (localObject2 == null)
          {
            i = 120;
            localObject2 = this.UaV;
            if (localObject2 != null) {
              break label313;
            }
            j = 120;
            localObject2 = a(paramList, ((ad)localObject1).UaF, i, j);
            byte[] arrayOfByte = BitmapUtil.Bitmap2Bytes((Bitmap)localObject2, 20);
            paramList = new dmr();
            paramList.id = ((ad)localObject1).id;
            paramList.msn = new LinkedList((Collection)p.listOf(new com.tencent.mm.bx.b(arrayOfByte)));
            localObject1 = new dbi();
            ((dbi)localObject1).width = ((Bitmap)localObject2).getWidth();
            ((dbi)localObject1).height = ((Bitmap)localObject2).getHeight();
            localObject2 = ah.aiuX;
            paramList.aaSU = ((dbi)localObject1);
            paramList.beV = 1L;
            paramList.aaRH = 0L;
          }
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label368;
        }
        localLinkedList.add(paramList);
        break;
        localObject2 = ((acw)localObject2).Zlu;
        if (localObject2 == null)
        {
          i = 120;
          break label138;
        }
        i = (int)((dbi)localObject2).width;
        break label138;
        localObject2 = ((acw)localObject2).Zlu;
        if (localObject2 == null)
        {
          j = 120;
          break label152;
        }
        j = (int)((dbi)localObject2).height;
        break label152;
        paramList = null;
        continue;
        if (((ad)localObject1).type == 2) {
          paramList = a((ad)localObject1);
        } else {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(283643);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ag
 * JD-Core Version:    0.7.0.1
 */