package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private TextView kPB;
  private Button mFl;
  private boolean ubw;
  private TextView udU;
  private s udV;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(142463);
    this.udV = new s();
    AppMethodBeat.o(142463);
  }
  
  private static JSONObject cTc()
  {
    AppMethodBeat.i(142469);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yCo, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bo.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ab.i("MicroMsg.WcPayRealnameVerifyMainUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ab.e("MicroMsg.WcPayRealnameVerifyMainUI", "wording data from cache is out of date");
            AppMethodBeat.o(142469);
            return null;
          }
          AppMethodBeat.o(142469);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", localJSONException, "", new Object[0]);
          ab.e("MicroMsg.WcPayRealnameVerifyMainUI", "parse wording data form cache error");
          AppMethodBeat.o(142469);
          return null;
        }
      }
    }
    ab.i("MicroMsg.WcPayRealnameVerifyMainUI", "cache is null");
    AppMethodBeat.o(142469);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2130971286;
  }
  
  public void initView()
  {
    AppMethodBeat.i(142465);
    this.mFl = ((Button)findViewById(2131829506));
    this.kPB = ((TextView)findViewById(2131829505));
    this.udU = ((TextView)findViewById(2131829507));
    this.mFl.setOnClickListener(new WcPayRealnameVerifyMainUI.3(this));
    Object localObject1 = cTc();
    if (localObject1 != null)
    {
      Object localObject2 = bo.bf(((JSONObject)localObject1).optString("cache_header_titles", getString(2131304213)), getString(2131304213));
      this.kPB.setText((CharSequence)localObject2);
      if (((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false))
      {
        this.udU.setText(2131305318);
        localObject1 = com.tencent.mm.svg.a.a.g(getResources(), 2131231934);
        ((Drawable)localObject1).setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
        localObject2 = com.tencent.mm.svg.a.a.g(getResources(), 2131230928);
        ((Drawable)localObject2).setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 9));
        ((Drawable)localObject2).setColorFilter(getResources().getColor(2131689764), PorterDuff.Mode.SRC_ATOP);
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
        this.udU.setCompoundDrawables((Drawable)localObject1, null, (Drawable)localObject2, null);
        this.udU.setCompoundDrawablePadding(i);
        this.udU.setOnClickListener(new WcPayRealnameVerifyMainUI.4(this));
        this.udU.setVisibility(0);
        AppMethodBeat.o(142465);
        return;
      }
      this.udU.setVisibility(8);
    }
    AppMethodBeat.o(142465);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(142468);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label37;
      }
      this.udV.bOM();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(142468);
      return;
      label37:
      this.udV.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142464);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    setMMTitle("");
    this.udV.uuu = new WcPayRealnameVerifyMainUI.1(this);
    setBackBtn(new WcPayRealnameVerifyMainUI.2(this));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bo.isNullOrNil(paramBundle))
      {
        paramBundle = (aoy)new aoy().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.ubw = paramBundle.ubw;
        if (paramBundle.xeX != null) {
          k.a(paramBundle.xeX).a(this, new WcPayRealnameVerifyMainUI.5(this));
        }
      }
      initView();
      AppMethodBeat.o(142464);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(142467);
    super.onPause();
    this.udV.onPause();
    AppMethodBeat.o(142467);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(142466);
    super.onResume();
    this.udV.onResume();
    AppMethodBeat.o(142466);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI
 * JD-Core Version:    0.7.0.1
 */