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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private boolean Dgp;
  private int DhD;
  private long DhE;
  private View DhF;
  private View DhG;
  private View DhH;
  private TextView DhI;
  private TextView DhJ;
  private TextView DhK;
  private TextView DhL;
  private TextView DhM;
  private TextView DhN;
  private TextView DhO;
  private TextView DhP;
  private TextView DhQ;
  private String DhR;
  private String DhS;
  private String DhT;
  private boolean DhU;
  private boolean DhV;
  private int mEntryScene;
  private u vRV;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(70026);
    this.DhD = 500;
    this.DhE = 0L;
    this.mEntryScene = 0;
    this.DhV = false;
    this.vRV = new u();
    this.Dgp = false;
    AppMethodBeat.o(70026);
  }
  
  private static JSONObject eIt()
  {
    AppMethodBeat.i(70036);
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPp, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bu.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ae.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ae.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            AppMethodBeat.o(70036);
            return null;
          }
          AppMethodBeat.o(70036);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          ae.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          AppMethodBeat.o(70036);
          return null;
        }
      }
    }
    ae.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    AppMethodBeat.o(70036);
    return null;
  }
  
  private boolean ut(boolean paramBoolean)
  {
    AppMethodBeat.i(70037);
    Object localObject2 = eIt();
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
      localObject2 = bu.bI(((JSONObject)localObject1).optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      if (this.DhV)
      {
        this.DhO.setText(2131765764);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label537;
        }
        this.DhP.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.DhQ.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.DhH.setVisibility(0);
        label115:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label549;
        }
        this.DhI.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(2131764332)));
        this.DhJ.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(2131764333)));
        this.DhF.setVisibility(0);
        label173:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label561;
        }
        this.DhK.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(2131764334)));
        this.DhL.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(2131764335)));
        this.DhG.setVisibility(0);
        label234:
        this.DhS = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.DhT = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.DhU = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (bu.isNullOrNil((String)localObject2)) {
          break label573;
        }
        this.DhM.setText((CharSequence)localObject2);
        this.DhM.setVisibility(0);
        label305:
        this.DhS = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.DhT = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.DhU = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.DhR = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!bu.isNullOrNil(this.DhR))) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(70024);
              f.d(18, bu.aRi(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
              f.p(SwitchRealnameVerifyModeUI.this.getContext(), SwitchRealnameVerifyModeUI.d(SwitchRealnameVerifyModeUI.this), false);
              AppMethodBeat.o(70024);
              return true;
            }
          });
        }
        if (!((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false)) {
          break label585;
        }
        localObject1 = new SpannableString("#  " + getContext().getResources().getString(2131765532));
        localObject2 = getContext().getResources().getDrawable(2131232697);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 18);
        this.DhN.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.DhN.setOnClickListener(new SwitchRealnameVerifyModeUI.8(this));
        this.DhN.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(70037);
        return true;
        this.DhO.setText((CharSequence)localObject2);
        break;
        label537:
        this.DhH.setVisibility(8);
        break label115;
        label549:
        this.DhF.setVisibility(8);
        break label173;
        label561:
        this.DhG.setVisibility(8);
        break label234;
        label573:
        this.DhM.setVisibility(8);
        break label305;
        label585:
        this.DhN.setVisibility(8);
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
    this.DhF = findViewById(2131305587);
    this.DhG = findViewById(2131305588);
    this.DhH = findViewById(2131305589);
    this.DhG.setOnClickListener(this);
    this.DhF.setOnClickListener(this);
    this.DhH.setOnClickListener(this);
    this.DhI = ((TextView)findViewById(2131297226));
    this.DhJ = ((TextView)findViewById(2131297225));
    this.DhK = ((TextView)findViewById(2131297230));
    this.DhL = ((TextView)findViewById(2131297229));
    this.DhM = ((TextView)findViewById(2131299639));
    this.DhN = ((TextView)findViewById(2131304276));
    this.DhP = ((TextView)findViewById(2131306283));
    this.DhQ = ((TextView)findViewById(2131306282));
    this.DhO = ((TextView)findViewById(2131305583));
    if (this.DhV) {
      this.DhO.setText(2131765764);
    }
    ut(false);
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
          f.d(14, bu.aRi(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
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
        this.vRV.dnA();
        AppMethodBeat.o(70033);
        return;
      }
      this.vRV.cancel();
    }
    AppMethodBeat.o(70033);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(70034);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (System.currentTimeMillis() - this.DhE <= this.DhD)
    {
      ae.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70034);
      return;
    }
    this.DhE = System.currentTimeMillis();
    this.vRV.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(70020);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).dnq = false;
        AppMethodBeat.o(70020);
      }
      
      public final void dnA()
      {
        AppMethodBeat.i(70019);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(70019);
      }
      
      public final void dnB()
      {
        AppMethodBeat.i(70021);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(70021);
      }
    }, this.Dgp);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      localBundle = paramView.dyY;
      if (i != 2131305587) {
        break label235;
      }
      f.d(15, bu.aRi(), this.mEntryScene);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (bu.isNullOrNil("")) {
            paramView = getString(2131765901);
          }
          h.a(this, paramView, null, false, new SwitchRealnameVerifyModeUI.6(this));
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
      com.tencent.mm.wallet_core.a.k(this, localBundle);
      AppMethodBeat.o(70035);
      return;
      label235:
      if (i == 2131305588)
      {
        f.d(17, bu.aRi(), this.mEntryScene);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == 2131305589)
      {
        f.d(16, bu.aRi(), this.mEntryScene);
        if ((this.DhU) && (!bu.isNullOrNil(this.DhT)))
        {
          h.a(this, this.DhT, "", this.DhS, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70022);
              paramAnonymousDialogInterface = paramView.dyY;
              paramAnonymousDialogInterface.putInt("real_name_verify_mode", 3);
              paramAnonymousDialogInterface.putString("verify_card_flag", "1");
              com.tencent.mm.wallet_core.a.k(SwitchRealnameVerifyModeUI.this, paramAnonymousDialogInterface);
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
    this.DhV = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
    f.d(13, bu.aRi(), this.mEntryScene);
    if (this.DhV) {
      setMMTitle(2131765763);
    }
    this.vRV.DBE = new u.b()
    {
      public final int dnC()
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
        f.d(14, bu.aRi(), this.mEntryScene);
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
    this.vRV.onPause();
    AppMethodBeat.o(70028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70027);
    super.onResume();
    this.vRV.onResume();
    AppMethodBeat.o(70027);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70032);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.e.aPm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eIm());
        removeSceneEndListener(580);
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.dyY;
          paramString.putInt("real_name_verify_mode", 1);
          com.tencent.mm.wallet_core.a.k(this, paramString);
        }
        AppMethodBeat.o(70032);
        return true;
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      removeSceneEndListener(1666);
      ut(true);
      paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramn;
      this.Dgp = paramString.Dgp;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void dmz() {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI
 * JD-Core Version:    0.7.0.1
 */