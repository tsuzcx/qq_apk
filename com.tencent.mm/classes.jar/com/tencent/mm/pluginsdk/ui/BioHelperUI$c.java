package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.ui.q.e;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class BioHelperUI$c
  implements BioHelperUI.b
{
  private int fzn;
  
  private BioHelperUI$c(BioHelperUI paramBioHelperUI) {}
  
  public final void ah(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.fzn = paramIntent.getIntExtra("kscene_type", 73);
  }
  
  public final String cme()
  {
    return this.rZi.getString(q.j.bio_voice_title);
  }
  
  public final int cmf()
  {
    return q.e.voice_icon;
  }
  
  public final String cmg()
  {
    return this.rZi.getString(q.j.bio_help_voice_verify);
  }
  
  public final String cmh()
  {
    return this.rZi.getString(q.j.bio_default_tips_voice_wording);
  }
  
  public final void eX(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kscene_type", this.fzn);
    localIntent.putExtra("Kusername", BioHelperUI.c(this.rZi));
    localIntent.putExtra("Kvertify_key", BioHelperUI.d(this.rZi));
    d.b(paramContext, "voiceprint", ".ui.VoiceLoginUI", localIntent, 1024);
  }
  
  public final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    boolean bool;
    if (paramInt2 == -1) {
      if ((paramInt1 == 1024) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        bool = bk.bl(paramIntent);
        if (!bk.bl(paramIntent)) {
          break label119;
        }
      }
    }
    label119:
    for (paramInt1 = i;; paramInt1 = paramIntent.length())
    {
      y.d("MicroMsg.BioHelperUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", paramIntent);
      localIntent.putExtra("KVoiceHelpCode", BioHelperUI.e(this.rZi));
      this.rZi.setResult(-1, localIntent);
      this.rZi.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI.c
 * JD-Core Version:    0.7.0.1
 */