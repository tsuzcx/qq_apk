package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.List;

public final class b$4
  implements Runnable
{
  public b$4(b paramb, String paramString1, List paramList, String paramString2, b.a parama, int paramInt) {}
  
  public final void run()
  {
    String str1 = d.ME(this.gwa);
    Object localObject1;
    if (!com.tencent.mm.a.e.bK(str1))
    {
      y.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
      localObject1 = d.ab(this.gwa, 320, 240);
    }
    try
    {
      c.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, str1, true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)this.ohu.get(0));
      i = 1;
      while (i < this.ohu.size())
      {
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append((String)this.ohu.get(i));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
        y.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
      }
      String str2 = localException.toString();
      Object localObject2 = o.Sr().dXo.a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
      long l1;
      label189:
      String str3;
      String str4;
      Object localObject3;
      long l2;
      if (localObject2 == null)
      {
        l1 = 0L;
        l1 = 1L + l1;
        i = 0;
        if (i >= this.ohu.size()) {
          break label809;
        }
        str3 = (String)this.ohu.get(i);
        y.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", new Object[] { str3, Long.valueOf(l1), str2, this.ohv });
        localObject2 = t.nR(str3);
        o.Sr();
        str4 = t.nT((String)localObject2);
        o.Sr();
        localObject3 = t.nS((String)localObject2);
        l2 = com.tencent.mm.a.e.r(str1, str4);
        y.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", new Object[] { str3, Long.valueOf(l2) });
        if (l2 > 0L) {
          break label395;
        }
        y.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", new Object[] { str1, str4, Integer.valueOf(i) });
        b.a(this.ohr, i);
      }
      for (;;)
      {
        i += 1;
        break label189;
        l1 = 0L;
        if (((Cursor)localObject2).moveToFirst()) {
          l1 = ((Cursor)localObject2).getLong(0);
        }
        ((Cursor)localObject2).close();
        break;
        label395:
        l2 = com.tencent.mm.a.e.r(this.gwa, (String)localObject3);
        y.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[] { str3, Long.valueOf(l2) });
        if (l2 <= 0L)
        {
          y.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", new Object[] { this.gwa, localObject3, Integer.valueOf(i) });
          b.a(this.ohr, i);
        }
        else
        {
          int j = this.ohs;
          str4 = this.ohv;
          localObject3 = new s();
          ((s)localObject3).fileName = ((String)localObject2);
          ((s)localObject3).eHH = j;
          ((s)localObject3).bVI = str3;
          ((s)localObject3).eHA = ((String)g.DP().Dz().get(2, ""));
          ((s)localObject3).createTime = bk.UX();
          ((s)localObject3).eHF = bk.UX();
          ((s)localObject3).eHN = null;
          ((s)localObject3).eFj = null;
          ((s)localObject3).eHL = 0;
          ((s)localObject3).eHO = 3;
          o.Sr();
          j = t.nU(t.nS((String)localObject2));
          if (j <= 0)
          {
            y.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:" + (String)localObject2);
          }
          else
          {
            ((s)localObject3).ebK = j;
            o.Sr();
            str3 = t.nT((String)localObject2);
            j = t.nU(str3);
            if (j <= 0)
            {
              y.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str3 + " size:" + j);
            }
            else
            {
              ((s)localObject3).eHE = j;
              y.i("MicroMsg.VideoLogic", "initMassSendSight file:" + (String)localObject2 + " thumbsize:" + ((s)localObject3).eHE + " videosize:" + ((s)localObject3).ebK);
              ((s)localObject3).status = 200;
              y.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", new Object[] { Long.valueOf(l1), str4, str2 });
              ((s)localObject3).eHP = str2;
              ((s)localObject3).eFV = l1;
              ((s)localObject3).bZs = str4;
              o.Sr().b((s)localObject3);
            }
          }
        }
      }
      label809:
      u.cj(l1);
      com.tencent.mm.a.e.deleteFile(this.gwa);
      com.tencent.mm.a.e.deleteFile(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b.4
 * JD-Core Version:    0.7.0.1
 */