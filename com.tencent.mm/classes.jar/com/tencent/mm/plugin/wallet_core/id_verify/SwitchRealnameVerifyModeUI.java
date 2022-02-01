package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private boolean Bov;
  private int BpK;
  private long BpL;
  private View BpM;
  private View BpN;
  private View BpO;
  private TextView BpP;
  private TextView BpQ;
  private TextView BpR;
  private TextView BpS;
  private TextView BpT;
  private TextView BpU;
  private TextView BpV;
  private TextView BpW;
  private TextView BpX;
  private String BpY;
  private String BpZ;
  private String Bqa;
  private boolean Bqb;
  private boolean Bqc;
  private int mEntryScene;
  private u uCZ;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(70026);
    this.BpK = 500;
    this.BpL = 0L;
    this.mEntryScene = 0;
    this.Bqc = false;
    this.uCZ = new u();
    this.Bov = false;
    AppMethodBeat.o(70026);
  }
  
  private static JSONObject eqM()
  {
    AppMethodBeat.i(70036);
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIz, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bs.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ac.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ac.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            AppMethodBeat.o(70036);
            return null;
          }
          AppMethodBeat.o(70036);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          ac.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          AppMethodBeat.o(70036);
          return null;
        }
      }
    }
    ac.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    AppMethodBeat.o(70036);
    return null;
  }
  
  private boolean tB(boolean paramBoolean)
  {
    AppMethodBeat.i(70037);
    Object localObject2 = eqM();
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
    }
    if (localObject1 != null)
    {
      localObject2 = bs.bG(((JSONObject)localObject1).optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      if (this.Bqc)
      {
        this.BpV.setText(2131765764);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label539;
        }
        this.BpW.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.BpX.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.BpO.setVisibility(0);
        label115:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label551;
        }
        this.BpP.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(2131764332)));
        this.BpQ.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(2131764333)));
        this.BpM.setVisibility(0);
        label175:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label563;
        }
        this.BpR.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(2131764334)));
        this.BpS.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(2131764335)));
        this.BpN.setVisibility(0);
        label236:
        this.BpZ = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.Bqa = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.Bqb = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (bs.isNullOrNil((String)localObject2)) {
          break label575;
        }
        this.BpT.setText((CharSequence)localObject2);
        this.BpT.setVisibility(0);
        label307:
        this.BpZ = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.Bqa = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.Bqb = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.BpY = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!bs.isNullOrNil(this.BpY))) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(70024);
              com.tencent.mm.wallet_core.ui.e.d(18, bs.aNx(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
              com.tencent.mm.wallet_core.ui.e.o(SwitchRealnameVerifyModeUI.this.getContext(), SwitchRealnameVerifyModeUI.d(SwitchRealnameVerifyModeUI.this), false);
              AppMethodBeat.o(70024);
              return true;
            }
          });
        }
        if (!((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false)) {
          break label587;
        }
        localObject1 = new SpannableString("#  " + getContext().getResources().getString(2131765532));
        localObject2 = getContext().getResources().getDrawable(2131232697);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 18);
        this.BpU.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.BpU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70025);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            com.tencent.mm.br.d.b(SwitchRealnameVerifyModeUI.this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            AppMethodBeat.o(70025);
          }
        });
        this.BpU.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(70037);
        return true;
        this.BpV.setText((CharSequence)localObject2);
        break;
        label539:
        this.BpO.setVisibility(8);
        break label115;
        label551:
        this.BpM.setVisibility(8);
        break label175;
        label563:
        this.BpN.setVisibility(8);
        break label236;
        label575:
        this.BpT.setVisibility(8);
        break label307;
        label587:
        this.BpU.setVisibility(8);
      }
    }
    AppMethodBeat.o(70037);
    return paramBoolean;
  }
  
  public int getLayoutId()
  {
    return 2131496018;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70031);
    setMMTitle("");
    this.BpM = findViewById(2131305587);
    this.BpN = findViewById(2131305588);
    this.BpO = findViewById(2131305589);
    this.BpN.setOnClickListener(this);
    this.BpM.setOnClickListener(this);
    this.BpO.setOnClickListener(this);
    this.BpP = ((TextView)findViewById(2131297226));
    this.BpQ = ((TextView)findViewById(2131297225));
    this.BpR = ((TextView)findViewById(2131297230));
    this.BpS = ((TextView)findViewById(2131297229));
    this.BpT = ((TextView)findViewById(2131299639));
    this.BpU = ((TextView)findViewById(2131304276));
    this.BpW = ((TextView)findViewById(2131306283));
    this.BpX = ((TextView)findViewById(2131306282));
    this.BpV = ((TextView)findViewById(2131305583));
    if (this.Bqc) {
      this.BpV.setText(2131765764);
    }
    tB(false);
    com.tencent.mm.plugin.wallet_core.id_verify.model.e locale = new com.tencent.mm.plugin.wallet_core.id_verify.model.e("");
    addSceneEndListener(1666);
    doSceneProgress(locale);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70018);
        paramAnonymousMenuItem = SwitchRealnameVerifyModeUI.this.getProcess();
        if (paramAnonymousMenuItem != null)
        {
          com.tencent.mm.wallet_core.ui.e.d(14, bs.aNx(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
          paramAnonymousMenuItem.g(SwitchRealnameVerifyModeUI.this, 0);
          AppMethodBeat.o(70018);
          return true;
        }
        SwitchRealnameVerifyModeUI.this.finish();
        AppMethodBeat.o(70018);
        return false;
      }
    });
    AppMethodBeat.o(70031);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70033);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.uCZ.dbh();
        AppMethodBeat.o(70033);
        return;
      }
      this.uCZ.cancel();
    }
    AppMethodBeat.o(70033);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(70034);
    if (System.currentTimeMillis() - this.BpL <= this.BpK)
    {
      ac.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      AppMethodBeat.o(70034);
      return;
    }
    this.BpL = System.currentTimeMillis();
    this.uCZ.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(70020);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).daU = false;
        AppMethodBeat.o(70020);
      }
      
      public final void dbh()
      {
        AppMethodBeat.i(70019);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(70019);
      }
      
      public final void dbi()
      {
        AppMethodBeat.i(70021);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(70021);
      }
    }, this.Bov);
    AppMethodBeat.o(70034);
  }
  
  public void onClickImp(final View paramView)
  {
    AppMethodBeat.i(70035);
    int i = paramView.getId();
    paramView = getProcess();
    Bundle localBundle;
    if (paramView != null)
    {
      localBundle = paramView.dmf;
      if (i != 2131305587) {
        break label235;
      }
      com.tencent.mm.wallet_core.ui.e.d(15, bs.aNx(), this.mEntryScene);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (bs.isNullOrNil("")) {
            paramView = getString(2131765901);
          }
          h.a(this, paramView, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70023);
              SwitchRealnameVerifyModeUI.this.finish();
              AppMethodBeat.o(70023);
            }
          });
          AppMethodBeat.o(70035);
          return;
        }
        addSceneEndListener(580);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
        AppMethodBeat.o(70035);
        return;
      }
      localBundle.putInt("real_name_verify_mode", 1);
    }
    for (;;)
    {
      a.k(this, localBundle);
      AppMethodBeat.o(70035);
      return;
      label235:
      if (i == 2131305588)
      {
        com.tencent.mm.wallet_core.ui.e.d(17, bs.aNx(), this.mEntryScene);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == 2131305589)
      {
        com.tencent.mm.wallet_core.ui.e.d(16, bs.aNx(), this.mEntryScene);
        if ((this.Bqb) && (!bs.isNullOrNil(this.Bqa)))
        {
          h.a(this, this.Bqa, "", this.BpZ, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70022);
              paramAnonymousDialogInterface = paramView.dmf;
              paramAnonymousDialogInterface.putInt("real_name_verify_mode", 3);
              paramAnonymousDialogInterface.putString("verify_card_flag", "1");
              a.k(SwitchRealnameVerifyModeUI.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(70022);
            }
          });
          AppMethodBeat.o(70035);
          return;
        }
        localBundle.putInt("real_name_verify_mode", 3);
        localBundle.putString("verify_card_flag", "1");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70030);
    super.onCreate(paramBundle);
    if ((getIntent().getExtras().getBoolean("is_from_new_cashier")) && (getProcess() == null))
    {
      boolean bool1 = getIntent().getExtras().getBoolean("key_process_is_end");
      boolean bool2 = getIntent().getExtras().getBoolean("key_process_is_stay");
      if ((bool1 == true) && (!bool2)) {
        finish();
      }
    }
    this.Bqc = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
    com.tencent.mm.wallet_core.ui.e.d(13, bs.aNx(), this.mEntryScene);
    if (this.Bqc) {
      setMMTitle(2131765763);
    }
    this.uCZ.BJI = new u.b()
    {
      public final int dbj()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return SwitchRealnameVerifyModeUI.this;
      }
    };
    AppMethodBeat.o(70030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70029);
    super.onDestroy();
    AppMethodBeat.o(70029);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70038);
    if (paramInt == 4)
    {
      com.tencent.mm.wallet_core.d locald = getProcess();
      if (locald != null)
      {
        com.tencent.mm.wallet_core.ui.e.d(14, bs.aNx(), this.mEntryScene);
        locald.g(this, 0);
        AppMethodBeat.o(70038);
        return true;
      }
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(70038);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70028);
    super.onPause();
    this.uCZ.onPause();
    AppMethodBeat.o(70028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70027);
    super.onResume();
    this.uCZ.onResume();
    AppMethodBeat.o(70027);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70032);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.e.aIm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eqF());
        removeSceneEndListener(580);
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.dmf;
          paramString.putInt("real_name_verify_mode", 1);
          a.k(this, paramString);
        }
        AppMethodBeat.o(70032);
        return true;
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      removeSceneEndListener(1666);
      tB(true);
      paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramn;
      this.Bov = paramString.Bov;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void dan() {}
          })); paramInt1 = 1)
      {
        AppMethodBeat.o(70032);
        return true;
      }
    }
    AppMethodBeat.o(70032);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI
 * JD-Core Version:    0.7.0.1
 */