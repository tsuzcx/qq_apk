package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.ui.q.f;
import com.tencent.mm.plugin.account.ui.q.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI
  extends MMActivity
{
  private String dqS;
  private String hcm;
  private int jsT;
  private String lyg;
  private int mType;
  private String rZg;
  private BioHelperUI.b rZh;
  
  protected final int getLayoutId()
  {
    return q.g.bio_help;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      y.i("MicroMsg.BioHelperUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      this.rZh.f(paramInt1, paramInt2, paramIntent);
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("k_type", 1);
    y.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[] { Integer.valueOf(this.mType) });
    this.hcm = bk.aM(getIntent().getStringExtra("Kusername"), null);
    this.dqS = bk.aM(getIntent().getStringExtra("Kvertify_key"), null);
    this.rZg = bk.aM(getIntent().getStringExtra("KVoiceHelpUrl"), null);
    this.lyg = bk.aM(getIntent().getStringExtra("KVoiceHelpWording"), null);
    this.jsT = getIntent().getIntExtra("KVoiceHelpCode", 0);
    if (this.mType == 0) {
      paramBundle = new BioHelperUI.c(this, (byte)0);
    }
    for (;;)
    {
      this.rZh = paramBundle;
      if ((this.rZh != null) && (!bk.bl(this.hcm)) && (!bk.bl(this.dqS))) {
        break;
      }
      y.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
      finish();
      return;
      if (this.mType == 1)
      {
        paramBundle = new BioHelperUI.a(this, (byte)0);
      }
      else
      {
        y.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        paramBundle = localObject;
      }
    }
    paramBundle = (TextView)findViewById(q.f.bio_help_tip);
    if (!bk.bl(this.lyg)) {
      paramBundle.setText(this.lyg);
    }
    for (;;)
    {
      setMMTitle(this.rZh.cme());
      ((ImageView)findViewById(q.f.bio_help_icon)).setImageResource(this.rZh.cmf());
      setBackBtn(new BioHelperUI.1(this));
      this.rZh.ah(getIntent());
      paramBundle = (Button)findViewById(q.f.bio_help_verify_btn);
      paramBundle.setText(this.rZh.cmg());
      paramBundle.setOnClickListener(new BioHelperUI.2(this));
      findViewById(q.f.bio_help_other_verify_btn).setOnClickListener(new BioHelperUI.3(this));
      return;
      paramBundle.setText(this.rZh.cmh());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.BioHelperUI
 * JD-Core Version:    0.7.0.1
 */