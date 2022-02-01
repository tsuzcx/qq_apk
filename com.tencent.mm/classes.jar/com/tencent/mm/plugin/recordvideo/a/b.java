package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.n;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class b
  implements CaptureDataManager.b
{
  String xMA;
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75020);
    paramBundle = new com.tencent.mm.ui.tools.l(paramContext);
    paramBundle.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(75018);
        paramAnonymousl.d(0, paramContext.getResources().getString(2131762566));
        paramAnonymousl.d(1, paramContext.getResources().getString(2131761941));
        paramAnonymousl.d(2, paramContext.getResources().getString(2131762781));
        AppMethodBeat.o(75018);
      }
    };
    paramBundle.LfT = new n.e()
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
          ((b)localObject2).xMA = ((String)localObject1);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("scene", 8);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 0);
          com.tencent.mm.br.d.c(paramAnonymousMenuItem, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          paramAnonymousMenuItem = paramCaptureVideoNormalModel.thumbPath;
          localObject1 = new cw();
          ((ad)com.tencent.mm.kernel.g.ab(ad.class)).a((cw)localObject1, 2, paramAnonymousMenuItem);
          ((cw)localObject1).doL.doR = 44;
          a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          ae.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", new Object[] { paramAnonymousMenuItem });
          Toast.makeText(ak.getContext(), paramContext.getResources().getString(2131758829), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 2) {
          com.tencent.mm.platformtools.p.a(paramContext, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(206495);
              Object localObject = Boolean.valueOf(com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IRT, true));
              ae.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", new Object[] { localObject });
              Boolean localBoolean = (Boolean)b.2.this.ukj.dIW().v("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
              if ((!((Boolean)localObject).booleanValue()) || ((((Boolean)localObject).booleanValue()) && (!localBoolean.booleanValue())))
              {
                localObject = com.tencent.mm.sdk.f.b.arS("jpg");
                com.tencent.mm.vfs.o.mF(b.2.this.ukj.thumbPath, (String)localObject);
                com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
              }
              Toast.makeText(ak.getContext(), b.2.this.val$context.getResources().getString(2131758632, new Object[] { com.tencent.mm.loader.j.b.asv() }), 1).show();
              ((Activity)b.2.this.val$context).finish();
              AppMethodBeat.o(206495);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(206496);
              Toast.makeText(ak.getContext(), b.2.this.val$context.getResources().getString(2131762779), 1).show();
              AppMethodBeat.o(206496);
            }
          });
        }
        AppMethodBeat.o(75019);
      }
    };
    h.a(paramContext, paramBundle.fOP());
    AppMethodBeat.o(75020);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75021);
    String str = paramIntent.getStringExtra("Select_Conv_User");
    ae.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, this.xMA });
    com.tencent.mm.ui.base.p localp = h.b(paramContext, paramContext.getResources().getString(2131761896), false, null);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    Object localObject1 = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
    ((o.e)localObject1).dzZ = v.aAC();
    ((o.e)localObject1).toUser = str;
    ((o.e)localObject1).iey = this.xMA;
    ((o.e)localObject1).icr = 0;
    ((o.e)localObject1).iiW = null;
    ((o.e)localObject1).dyw = 0;
    ((o.e)localObject1).icA = "";
    ((o.e)localObject1).thumbPath = "";
    ((o.e)localObject1).iiZ = true;
    ((o.e)localObject1).iiY = 2131231564;
    ((o.e)localObject1).iiV = 11;
    Object localObject2 = ((o.e)localObject1).aJO();
    localObject1 = (n)((o.b)localObject2).iiO;
    ((o.b)localObject2).execute();
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFW, true))
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.iR(String.valueOf(((n)localObject1).aIJ().field_msgId), this.xMA);
    }
    com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str);
    if (localp != null) {
      localp.dismiss();
    }
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */