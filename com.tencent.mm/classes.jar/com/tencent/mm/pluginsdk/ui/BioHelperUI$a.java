package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.ui.q.e;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BioHelperUI$a
  implements BioHelperUI.b
{
  private BioHelperUI$a(BioHelperUI paramBioHelperUI) {}
  
  public final void ah(Intent paramIntent) {}
  
  public final String cme()
  {
    return this.rZi.getString(q.j.bio_face_title);
  }
  
  public final int cmf()
  {
    return q.e.face_icon;
  }
  
  public final String cmg()
  {
    return this.rZi.getString(q.j.bio_help_face_verify);
  }
  
  public final String cmh()
  {
    return this.rZi.getString(q.j.bio_default_tips_face_wording);
  }
  
  public final void eX(Context paramContext)
  {
    paramContext = new Intent();
    paramContext.putExtra("k_user_name", BioHelperUI.c(this.rZi));
    paramContext.putExtra("k_purpose", 2);
    paramContext.putExtra("k_need_signature", true);
    paramContext.putExtra("k_ticket", BioHelperUI.d(this.rZi));
    d.b(this.rZi.mController.uMN, "facedetect", ".ui.FaceDetectUI", paramContext, 1025);
  }
  
  public final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramInt1 = 0;
    boolean bool;
    if ((paramInt2 == 2) && (paramIntent != null))
    {
      this.rZi.finish();
      paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
      bool = bk.bl(paramIntent);
      if (!bk.bl(paramIntent)) {
        break label65;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.BioHelperUI", "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      return;
      label65:
      paramInt1 = paramIntent.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI.a
 * JD-Core Version:    0.7.0.1
 */