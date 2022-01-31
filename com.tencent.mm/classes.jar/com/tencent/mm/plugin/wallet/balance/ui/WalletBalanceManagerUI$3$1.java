package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class WalletBalanceManagerUI$3$1
  implements n.c
{
  WalletBalanceManagerUI$3$1(WalletBalanceManagerUI.3 param3) {}
  
  public final void a(l paraml)
  {
    JSONArray localJSONArray = this.qhn.qhm.optJSONArray("balance_menu_item");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          WalletBalanceManagerUI.a locala = new WalletBalanceManagerUI.a();
          locala.title = localJSONObject.optString("title");
          locala.qho = localJSONObject.optInt("jump_type", 0);
          locala.qhp = localJSONObject.optString("jump_h5_url");
          locala.qhq = localJSONObject.optString("tinyapp_username");
          locala.qhr = localJSONObject.optString("tinyapp_path");
          paraml.add(0, i, 0, locala.title);
          this.qhn.kOC.add(locala);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3.1
 * JD-Core Version:    0.7.0.1
 */