package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.List;

public final class b$4
  implements Runnable
{
  public b$4(b paramb, String paramString1, List paramList, String paramString2, b.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(70361);
    String str1 = com.tencent.mm.plugin.sight.base.d.TW(this.hRL);
    Object localObject1;
    if (!com.tencent.mm.a.e.cN(str1))
    {
      ab.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
      localObject1 = com.tencent.mm.plugin.sight.base.d.as(this.hRL, 320, 240);
    }
    try
    {
      com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, str1, true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)this.qVJ.get(0));
      i = 1;
      while (i < this.qVJ.size())
      {
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append((String)this.qVJ.get(i));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
        ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
      }
      String str2 = localException.toString();
      Object localObject2 = o.alE().fnw.a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
      long l1;
      label194:
      String str3;
      String str4;
      Object localObject3;
      long l2;
      if (localObject2 == null)
      {
        l1 = 0L;
        l1 = 1L + l1;
        i = 0;
        if (i >= this.qVJ.size()) {
          break label812;
        }
        str3 = (String)this.qVJ.get(i);
        ab.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", new Object[] { str3, Long.valueOf(l1), str2, this.hZA });
        localObject2 = t.ve(str3);
        o.alE();
        str4 = t.vg((String)localObject2);
        o.alE();
        localObject3 = t.vf((String)localObject2);
        l2 = com.tencent.mm.a.e.C(str1, str4);
        ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", new Object[] { str3, Long.valueOf(l2) });
        if (l2 > 0L) {
          break label400;
        }
        ab.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", new Object[] { str1, str4, Integer.valueOf(i) });
        b.a(this.qVG, i);
      }
      for (;;)
      {
        i += 1;
        break label194;
        l1 = 0L;
        if (((Cursor)localObject2).moveToFirst()) {
          l1 = ((Cursor)localObject2).getLong(0);
        }
        ((Cursor)localObject2).close();
        break;
        label400:
        l2 = com.tencent.mm.a.e.C(this.hRL, (String)localObject3);
        ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[] { str3, Long.valueOf(l2) });
        if (l2 <= 0L)
        {
          ab.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", new Object[] { this.hRL, localObject3, Integer.valueOf(i) });
          b.a(this.qVG, i);
        }
        else
        {
          int j = this.qVH;
          str4 = this.hZA;
          localObject3 = new s();
          ((s)localObject3).fileName = ((String)localObject2);
          ((s)localObject3).fXx = j;
          ((s)localObject3).cDt = str3;
          ((s)localObject3).fXq = ((String)g.RL().Ru().get(2, ""));
          ((s)localObject3).createTime = bo.aox();
          ((s)localObject3).fXv = bo.aox();
          ((s)localObject3).fXD = null;
          ((s)localObject3).fVa = null;
          ((s)localObject3).fXB = 0;
          ((s)localObject3).fXE = 3;
          o.alE();
          j = t.vh(t.vf((String)localObject2));
          if (j <= 0)
          {
            ab.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:".concat(String.valueOf(localObject2)));
          }
          else
          {
            ((s)localObject3).fsd = j;
            o.alE();
            str3 = t.vg((String)localObject2);
            j = t.vh(str3);
            if (j <= 0)
            {
              ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str3 + " size:" + j);
            }
            else
            {
              ((s)localObject3).fXu = j;
              ab.i("MicroMsg.VideoLogic", "initMassSendSight file:" + (String)localObject2 + " thumbsize:" + ((s)localObject3).fXu + " videosize:" + ((s)localObject3).fsd);
              ((s)localObject3).status = 200;
              ab.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", new Object[] { Long.valueOf(l1), str4, str2 });
              ((s)localObject3).fXF = str2;
              ((s)localObject3).fVM = l1;
              ((s)localObject3).cHH = str4;
              o.alE().b((s)localObject3);
            }
          }
        }
      }
      label812:
      u.hf(l1);
      com.tencent.mm.a.e.deleteFile(this.hRL);
      com.tencent.mm.a.e.deleteFile(str1);
      AppMethodBeat.o(70361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b.4
 * JD-Core Version:    0.7.0.1
 */