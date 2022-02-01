package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.n;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.s;

public final class b
  implements CaptureDataManager.b
{
  String BMG;
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75020);
    paramBundle = new l(paramContext);
    paramBundle.HLX = new b.1(this, paramContext);
    paramBundle.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(75019);
        Object localObject1;
        if (paramAnonymousInt == 0)
        {
          Object localObject2 = b.this;
          paramAnonymousMenuItem = paramContext;
          localObject1 = paramCaptureVideoNormalModel.thumbPath;
          ((b)localObject2).BMG = ((String)localObject1);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("scene", 8);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 0);
          com.tencent.mm.br.c.c(paramAnonymousMenuItem, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          paramAnonymousMenuItem = paramCaptureVideoNormalModel.thumbPath;
          localObject1 = new cz();
          ((ad)com.tencent.mm.kernel.g.af(ad.class)).a((cz)localObject1, 2, paramAnonymousMenuItem);
          ((cz)localObject1).dFZ.dGf = 44;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", new Object[] { paramAnonymousMenuItem });
          Toast.makeText(MMApplicationContext.getContext(), paramContext.getResources().getString(2131759152), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 2) {
          p.a(paramContext, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(237200);
              Boolean localBoolean1 = Boolean.valueOf(com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.NZV, true));
              Log.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", new Object[] { localBoolean1 });
              Boolean localBoolean2 = (Boolean)b.2.this.xCC.eJJ().y("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
              if ((!localBoolean1.booleanValue()) || (!localBoolean2.booleanValue())) {
                com.tencent.f.h.RTc.aX(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(237199);
                    String str = AndroidMediaUtil.getExportImagePath("jpg");
                    s.nw(b.2.this.xCC.thumbPath, str);
                    s.deleteFile(b.2.this.xCC.thumbPath);
                    AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
                    AppMethodBeat.o(237199);
                  }
                });
              }
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(2131758940, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
              ((Activity)b.2.this.val$context).finish();
              AppMethodBeat.o(237200);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(237201);
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(2131764864), 1).show();
              AppMethodBeat.o(237201);
            }
          });
        }
        AppMethodBeat.o(75019);
      }
    };
    com.tencent.mm.ui.base.h.a(paramContext, paramBundle.gXI());
    AppMethodBeat.o(75020);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void an(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75021);
    String str = paramIntent.getStringExtra("Select_Conv_User");
    Log.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, this.BMG });
    q localq = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(2131763901), false, null);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    Object localObject1 = o.a(o.d.jdL).tc(4);
    ((o.e)localObject1).dRL = z.aTY();
    ((o.e)localObject1).toUser = str;
    ((o.e)localObject1).iZt = this.BMG;
    ((o.e)localObject1).iXp = 0;
    ((o.e)localObject1).jdS = null;
    ((o.e)localObject1).dQd = 0;
    ((o.e)localObject1).iXy = "";
    ((o.e)localObject1).thumbPath = "";
    ((o.e)localObject1).jdV = true;
    ((o.e)localObject1).jdU = 2131231628;
    ((o.e)localObject1).jdR = 11;
    Object localObject2 = ((o.e)localObject1).bdQ();
    localObject1 = (n)((o.b)localObject2).jdJ;
    ((o.b)localObject2).execute();
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZj, true))
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      com.tencent.mm.plugin.recordvideo.e.c.jD(String.valueOf(((n)localObject1).bcD().field_msgId), this.BMG);
    }
    com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str);
    if (localq != null) {
      localq.dismiss();
    }
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */