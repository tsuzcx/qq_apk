package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.np;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$27
  implements View.OnClickListener
{
  SnsCommentDetailUI$27(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.ui.base.h.a(this.oWW, i.j.sns_timeline_ui_confirm_del, i.j.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(SnsCommentDetailUI.27.this.oWW));
        paramAnonymousDialogInterface = com.tencent.mm.plugin.sns.storage.h.OB(SnsCommentDetailUI.k(SnsCommentDetailUI.27.this.oWW));
        if (paramAnonymousDialogInterface == null) {
          y.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(SnsCommentDetailUI.27.this.oWW) });
        }
        while (paramAnonymousDialogInterface.yr(32)) {
          return;
        }
        Object localObject;
        if (paramAnonymousDialogInterface.field_snsId == 0L)
        {
          af.bDF().yu(paramAnonymousDialogInterface.oLk);
          localObject = new Intent();
          ((Intent)localObject).putExtra("sns_gallery_op_id", v.OV(SnsCommentDetailUI.k(SnsCommentDetailUI.27.this.oWW)));
          SnsCommentDetailUI.27.this.oWW.setResult(-1, (Intent)localObject);
          if ((SnsCommentDetailUI.s(SnsCommentDetailUI.27.this.oWW)) && (!paramAnonymousDialogInterface.isValid())) {
            ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
          }
          localObject = paramAnonymousDialogInterface.bGe();
          if (localObject != null) {
            if (((bxk)localObject).tNq != null) {
              break label347;
            }
          }
        }
        label347:
        for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((bxk)localObject).tNq.lsK)
        {
          if ((!bk.bl(paramAnonymousDialogInterface)) && (com.tencent.mm.plugin.sns.c.a.eUS.cu(paramAnonymousDialogInterface)))
          {
            String str = com.tencent.mm.plugin.sns.c.a.eUS.cs(paramAnonymousDialogInterface);
            np localnp = new np();
            localnp.bXk.appId = paramAnonymousDialogInterface;
            localnp.bXk.bXl = ((bxk)localObject).hPY;
            localnp.bXk.bwQ = str;
            com.tencent.mm.sdk.b.a.udP.m(localnp);
          }
          SnsCommentDetailUI.27.this.oWW.finish();
          return;
          af.bDE().gd(paramAnonymousDialogInterface.field_snsId);
          g.DQ();
          g.DO().dJT.a(new r(paramAnonymousDialogInterface.field_snsId, 1), 0);
          af.bDF().delete(paramAnonymousDialogInterface.field_snsId);
          af.bDK().go(paramAnonymousDialogInterface.field_snsId);
          i.gn(paramAnonymousDialogInterface.field_snsId);
          break;
        }
      }
    }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.27
 * JD-Core Version:    0.7.0.1
 */