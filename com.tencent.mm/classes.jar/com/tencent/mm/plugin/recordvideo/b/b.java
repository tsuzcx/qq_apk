package com.tencent.mm.plugin.recordvideo.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public final class b
  implements CaptureDataManager.b
{
  public String NGk;
  
  public final void a(final Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(75020);
    paramBundle = new l(paramContext);
    paramBundle.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(75018);
        paramAnonymouss.c(0, paramContext.getResources().getString(b.h.retransmits));
        paramAnonymouss.c(1, paramContext.getResources().getString(b.h.plugin_favorite_opt));
        paramAnonymouss.c(2, paramContext.getResources().getString(b.h.save_img_to_local));
        AppMethodBeat.o(75018);
      }
    };
    paramBundle.GAC = new u.i()
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
          ((b)localObject2).NGk = ((String)localObject1);
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
          localObject1 = new dn();
          ((af)com.tencent.mm.kernel.h.ax(af.class)).a((dn)localObject1, 2, paramAnonymousMenuItem);
          ((dn)localObject1).hDr.hDy = 44;
          ((dn)localObject1).publish();
          Log.i("MicroMsg.MMRecordUI", "[doFavInMM] path:%s", new Object[] { paramAnonymousMenuItem });
          Toast.makeText(MMApplicationContext.getContext(), paramContext.getResources().getString(b.h.fav_edit_photo_successfully), 1).show();
          ((Activity)paramContext).finish();
          AppMethodBeat.o(75019);
          return;
        }
        if (paramAnonymousInt == 2) {
          ExportFileUtil.a(paramContext, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(279388);
              Boolean localBoolean1 = Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPr, true));
              Log.i("MicroMsg.MMRecordUI", "save pic ,imageState : %s", new Object[] { localBoolean1 });
              Boolean localBoolean2 = (Boolean)b.2.this.IAM.gHE().J("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.TRUE);
              if ((!localBoolean1.booleanValue()) || (!localBoolean2.booleanValue())) {
                com.tencent.threadpool.h.ahAA.bm(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(279389);
                    String str = AndroidMediaUtil.getExportImagePath("jpg");
                    y.O(b.2.this.IAM.thumbPath, str, false);
                    y.deleteFile(b.2.this.IAM.thumbPath);
                    AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
                    AppMethodBeat.o(279389);
                  }
                });
              }
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(b.h.exports_saved, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
              ((Activity)b.2.this.val$context).finish();
              AppMethodBeat.o(279388);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279385);
              Toast.makeText(MMApplicationContext.getContext(), b.2.this.val$context.getResources().getString(b.h.save_image_err), 1).show();
              AppMethodBeat.o(279385);
            }
          });
        }
        AppMethodBeat.o(75019);
      }
    };
    k.a(paramContext, paramBundle.jDd());
    AppMethodBeat.o(75020);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.b
 * JD-Core Version:    0.7.0.1
 */