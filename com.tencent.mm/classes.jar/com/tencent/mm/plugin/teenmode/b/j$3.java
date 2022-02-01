package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.a.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;

final class j$3
  implements y.a
{
  j$3(j paramj, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, au paramau, byte[] paramArrayOfByte, Context paramContext, y.b paramb) {}
  
  public final void onDialogClick(final boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(278856);
    if (paramBoolean)
    {
      Object localObject = new k.b();
      ((k.b)localObject).title = this.eSG;
      ((k.b)localObject).description = this.rnM;
      ((k.b)localObject).url = "https://support.weixin.qq.com/update/";
      ((k.b)localObject).thumburl = "http://wxapp.tc.qq.com/251/20304/stodownload?m=adb36df21d075a4c2148a2c0fc361304&filekey=30450201010420301e020200fb0402535a0410adb36df21d075a4c2148a2c0fc3613040202188a041e000000046274667300000001310000000861707073746f72650000000131&hy=SZ&storeid=32303231303932383030353631353030303362636238303062633631346565633763333930613030303030306662&dotrans=0&sourceflag=1&bizid=1023&adaptivelytrans=0";
      ((k.b)localObject).type = 84;
      c localc = new c();
      localc.nVI = this.val$type;
      localc.nVH = this.val$key;
      localc.nVJ = Util.nullAsNil(this.val$content);
      ((k.b)localObject).a(localc);
      localObject = w.a.bwq().a((k.b)localObject, "", "", this.lMP.field_username, "", this.nMM);
      if (!Util.isNullOrNil(paramString)) {
        g.gaI().ap(this.lMP.field_username, paramString, ab.IX(this.lMP.field_username));
      }
      final long l = ((Long)((Pair)localObject).second).longValue();
      if (l > 0L)
      {
        new MTimerHandler(new MTimerHandler.CallBack()
        {
          private int count = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(278933);
            cc localcc = ((n)h.ax(n.class)).gaZ().sl(l);
            if ((localcc.field_msgSvrId > 0L) || (this.count >= 10))
            {
              paramBoolean.dismiss();
              if (localcc.field_msgSvrId > 0L) {
                j.3.this.SYW.a(j.3.this.val$context, j.3.this.lMP.field_username, z.bAM(), localcc.getCreateTime(), localcc.field_msgSvrId, localcc.field_content, localcc.field_imgPath, Boolean.FALSE);
              }
              j.a(j.3.this.SZa, this.SZb);
              AppMethodBeat.o(278933);
              return false;
            }
            this.count += 1;
            AppMethodBeat.o(278933);
            return true;
          }
        }, true).startTimer(0L, 1000L);
        AppMethodBeat.o(278856);
        return;
      }
      j.a(this.SZa, false);
      AppMethodBeat.o(278856);
      return;
    }
    j.a(this.SZa, false);
    AppMethodBeat.o(278856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.j.3
 * JD-Core Version:    0.7.0.1
 */