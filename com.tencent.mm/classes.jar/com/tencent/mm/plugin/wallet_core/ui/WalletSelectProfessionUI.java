package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class WalletSelectProfessionUI
  extends MMPreference
{
  private f dnn;
  private Profession[] qrb = null;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.startsWith("index_"))
    {
      paramf = paramPreference.mKey.split("_");
      if (paramf.length != 2) {
        break label71;
      }
      int i = bk.getInt(paramf[1], 0);
      paramf = this.qrb[i];
      paramPreference = new Intent();
      paramPreference.putExtra("key_select_profession", paramf);
      setResult(-1, paramPreference);
    }
    for (;;)
    {
      finish();
      return true;
      label71:
      y.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", new Object[] { paramPreference.mKey, paramPreference.getTitle() });
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_select_profession_title);
    this.dnn = this.vdd;
    paramBundle = new PreferenceTitleCategory(this.mController.uMN);
    paramBundle.setTitle(getString(a.i.wallet_select_profession_tips));
    paramBundle.setKey("title_category");
    this.dnn.a(paramBundle);
    paramBundle = getIntent().getParcelableArrayExtra("key_profession_list");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.qrb = new Profession[paramBundle.length];
      i = 0;
      while (i < this.qrb.length)
      {
        this.qrb[i] = ((Profession)paramBundle[i]);
        i += 1;
      }
    }
    if (this.qrb != null)
    {
      paramBundle = this.qrb;
      int k = paramBundle.length;
      i = 0;
      int j = 0;
      while (i < k)
      {
        Object localObject = paramBundle[i];
        if ((localObject != null) && (!bk.bl(localObject.qst)))
        {
          Preference localPreference = new Preference(this.mController.uMN);
          localPreference.setTitle(localObject.qst);
          localPreference.setKey("index_" + j);
          this.dnn.a(localPreference);
        }
        j += 1;
        i += 1;
      }
    }
    setBackBtn(new WalletSelectProfessionUI.1(this));
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI
 * JD-Core Version:    0.7.0.1
 */