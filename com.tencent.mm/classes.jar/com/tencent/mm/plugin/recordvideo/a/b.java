package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;

public final class b
  implements CaptureDataManager.b
{
  String vgb;
  
  public final void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75021);
    String str = paramIntent.getStringExtra("Select_Conv_User");
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, this.vgb });
    com.tencent.mm.ui.base.p localp = h.b(paramContext, paramContext.getResources().getString(2131761896), false, null);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    com.tencent.mm.aw.l locall = new com.tencent.mm.aw.l(4, u.aqG(), str, this.vgb, 0, null, 0, "", "", true, 2131231564);
    g.aeS().a(locall, 0);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqx, true))
    {
      com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.jdMethod_if(String.valueOf(locall.dbD.field_msgId), this.vgb);
    }
    j.cOB().hm(paramIntent, str);
    if (localp != null) {
      localp.dismiss();
    }
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75021);
  }
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75020);
    paramBundle = new com.tencent.mm.ui.tools.l(paramContext);
    paramBundle.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(75018);
        paramAnonymousl.c(0, paramContext.getResources().getString(2131762566));
        paramAnonymousl.c(1, paramContext.getResources().getString(2131761941));
        paramAnonymousl.c(2, paramContext.getResources().getString(2131762781));
        AppMethodBeat.o(75018);
      }
    };
    paramBundle.HrY = new n.d()
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
          ((b)localObject2).vgb = ((String)localObject1);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("scene", 8);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 0);
          d.c(paramAnonymousMenuItem, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          paramAnonymousMenuItem = paramCaptureVideoNormalModel.thumbPath;
          localObject1 = new cs();
          ((com.tencent.mm.plugin.fav.a.ad)g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a((cs)localObject1, 2, paramAnonymousMenuItem);
          ((cs)localObject1).deQ.deW = 44;
          a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", new Object[] { paramAnonymousMenuItem });
          Toast.makeText(aj.getContext(), paramContext.getResources().getString(2131758829), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 2) {
          com.tencent.mm.platformtools.p.a(paramContext, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(190812);
              Object localObject = Boolean.valueOf(g.afB().afk().getBoolean(ae.a.Fno, true));
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", new Object[] { localObject });
              Boolean localBoolean = (Boolean)b.2.this.rTz.dhD().w("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
              if ((!((Boolean)localObject).booleanValue()) || ((((Boolean)localObject).booleanValue()) && (!localBoolean.booleanValue())))
              {
                localObject = com.tencent.mm.sdk.f.b.ahd("jpg");
                i.lC(b.2.this.rTz.thumbPath, (String)localObject);
                com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
              }
              Toast.makeText(aj.getContext(), b.2.this.val$context.getResources().getString(2131758632, new Object[] { com.tencent.mm.loader.j.b.ais() }), 1).show();
              ((Activity)b.2.this.val$context).finish();
              AppMethodBeat.o(190812);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190813);
              Toast.makeText(aj.getContext(), b.2.this.val$context.getResources().getString(2131762779), 1).show();
              AppMethodBeat.o(190813);
            }
          });
        }
        AppMethodBeat.o(75019);
      }
    };
    h.a(paramContext, paramBundle.fdQ());
    AppMethodBeat.o(75020);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */