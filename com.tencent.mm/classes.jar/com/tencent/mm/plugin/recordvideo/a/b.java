package com.tencent.mm.plugin.recordvideo.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.n;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.h;
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
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.vfs.u;

public final class b
  implements CaptureDataManager.b
{
  String HIS;
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75020);
    paramBundle = new m(paramContext);
    paramBundle.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(75018);
        paramAnonymouso.d(0, paramContext.getResources().getString(b.h.retransmits));
        paramAnonymouso.d(1, paramContext.getResources().getString(b.h.plugin_favorite_opt));
        paramAnonymouso.d(2, paramContext.getResources().getString(b.h.save_img_to_local));
        AppMethodBeat.o(75018);
      }
    };
    paramBundle.ODU = new q.g()
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
          ((b)localObject2).HIS = ((String)localObject1);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("scene", 8);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 0);
          c.d(paramAnonymousMenuItem, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          paramAnonymousMenuItem = paramCaptureVideoNormalModel.thumbPath;
          localObject1 = new dd();
          ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a((dd)localObject1, 2, paramAnonymousMenuItem);
          ((dd)localObject1).fyI.fyP = 44;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", new Object[] { paramAnonymousMenuItem });
          Toast.makeText(MMApplicationContext.getContext(), paramContext.getResources().getString(b.h.fav_edit_photo_successfully), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 2) {
          p.a(paramContext, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(227477);
              Boolean localBoolean1 = Boolean.valueOf(com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VnW, true));
              Log.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", new Object[] { localBoolean1 });
              Boolean localBoolean2 = (Boolean)b.2.this.CGC.fvU().x("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
              if ((!localBoolean1.booleanValue()) || (!localBoolean2.booleanValue())) {
                com.tencent.e.h.ZvG.be(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(227995);
                    String str = AndroidMediaUtil.getExportImagePath("jpg");
                    u.on(b.2.this.CGC.thumbPath, str);
                    u.deleteFile(b.2.this.CGC.thumbPath);
                    AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
                    AppMethodBeat.o(227995);
                  }
                });
              }
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(b.h.exports_saved, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
              ((Activity)b.2.this.val$context).finish();
              AppMethodBeat.o(227477);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216229);
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(b.h.save_image_err), 1).show();
              AppMethodBeat.o(216229);
            }
          });
        }
        AppMethodBeat.o(75019);
      }
    };
    com.tencent.mm.ui.base.h.a(paramContext, paramBundle.hYu());
    AppMethodBeat.o(75020);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void aw(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75021);
    String str = paramIntent.getStringExtra("Select_Conv_User");
    Log.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, this.HIS });
    s locals = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(b.h.photo_edit_forward_tips), false, null);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    Object localObject1 = com.tencent.mm.modelmulti.o.a(o.d.lUk).wb(4);
    ((o.e)localObject1).fLi = z.bcZ();
    ((o.e)localObject1).toUser = str;
    ((o.e)localObject1).lPO = this.HIS;
    ((o.e)localObject1).lNK = 0;
    ((o.e)localObject1).lUr = null;
    ((o.e)localObject1).fJu = 0;
    ((o.e)localObject1).lNS = "";
    ((o.e)localObject1).thumbPath = "";
    ((o.e)localObject1).lUu = true;
    ((o.e)localObject1).lUt = b.d.chat_img_template;
    ((o.e)localObject1).lUq = 11;
    Object localObject2 = ((o.e)localObject1).bnl();
    localObject1 = (n)((o.b)localObject2).lUi;
    ((o.b)localObject2).aEv();
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGh, true))
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      com.tencent.mm.plugin.recordvideo.e.d.jR(String.valueOf(((n)localObject1).blT().field_msgId), this.HIS);
    }
    g.eRW().iQ(paramIntent, str);
    if (locals != null) {
      locals.dismiss();
    }
    ((Activity)paramContext).finish();
    AppMethodBeat.o(75021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */