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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private boolean COK;
  private int CPZ;
  private long CQa;
  private View CQb;
  private View CQc;
  private View CQd;
  private TextView CQe;
  private TextView CQf;
  private TextView CQg;
  private TextView CQh;
  private TextView CQi;
  private TextView CQj;
  private TextView CQk;
  private TextView CQl;
  private TextView CQm;
  private String CQn;
  private String CQo;
  private String CQp;
  private boolean CQq;
  private boolean CQr;
  private int mEntryScene;
  private u vFR;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(70026);
    this.CPZ = 500;
    this.CQa = 0L;
    this.mEntryScene = 0;
    this.CQr = false;
    this.vFR = new u();
    this.COK = false;
    AppMethodBeat.o(70026);
  }
  
  private static JSONObject eEM()
  {
    AppMethodBeat.i(70036);
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuR, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bt.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ad.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ad.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            AppMethodBeat.o(70036);
            return null;
          }
          AppMethodBeat.o(70036);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          ad.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          AppMethodBeat.o(70036);
          return null;
        }
      }
    }
    ad.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    AppMethodBeat.o(70036);
    return null;
  }
  
  private boolean ul(boolean paramBoolean)
  {
    AppMethodBeat.i(70037);
    Object localObject2 = eEM();
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
      localObject2 = bt.bI(((JSONObject)localObject1).optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      if (this.CQr)
      {
        this.CQk.setText(2131765764);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label539;
        }
        this.CQl.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.CQm.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.CQd.setVisibility(0);
        label115:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label551;
        }
        this.CQe.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(2131764332)));
        this.CQf.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(2131764333)));
        this.CQb.setVisibility(0);
        label175:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label563;
        }
        this.CQg.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(2131764334)));
        this.CQh.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(2131764335)));
        this.CQc.setVisibility(0);
        label236:
        this.CQo = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.CQp = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.CQq = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (bt.isNullOrNil((String)localObject2)) {
          break label575;
        }
        this.CQi.setText((CharSequence)localObject2);
        this.CQi.setVisibility(0);
        label307:
        this.CQo = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.CQp = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.CQq = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.CQn = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!bt.isNullOrNil(this.CQn))) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(70024);
              com.tencent.mm.wallet_core.ui.e.d(18, bt.aQJ(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
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
        this.CQj.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.CQj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70025);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            com.tencent.mm.bs.d.b(SwitchRealnameVerifyModeUI.this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70025);
          }
        });
        this.CQj.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(70037);
        return true;
        this.CQk.setText((CharSequence)localObject2);
        break;
        label539:
        this.CQd.setVisibility(8);
        break label115;
        label551:
        this.CQb.setVisibility(8);
        break label175;
        label563:
        this.CQc.setVisibility(8);
        break label236;
        label575:
        this.CQi.setVisibility(8);
        break label307;
        label587:
        this.CQj.setVisibility(8);
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
    this.CQb = findViewById(2131305587);
    this.CQc = findViewById(2131305588);
    this.CQd = findViewById(2131305589);
    this.CQc.setOnClickListener(this);
    this.CQb.setOnClickListener(this);
    this.CQd.setOnClickListener(this);
    this.CQe = ((TextView)findViewById(2131297226));
    this.CQf = ((TextView)findViewById(2131297225));
    this.CQg = ((TextView)findViewById(2131297230));
    this.CQh = ((TextView)findViewById(2131297229));
    this.CQi = ((TextView)findViewById(2131299639));
    this.CQj = ((TextView)findViewById(2131304276));
    this.CQl = ((TextView)findViewById(2131306283));
    this.CQm = ((TextView)findViewById(2131306282));
    this.CQk = ((TextView)findViewById(2131305583));
    if (this.CQr) {
      this.CQk.setText(2131765764);
    }
    ul(false);
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
          com.tencent.mm.wallet_core.ui.e.d(14, bt.aQJ(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
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
        this.vFR.dkA();
        AppMethodBeat.o(70033);
        return;
      }
      this.vFR.cancel();
    }
    AppMethodBeat.o(70033);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(70034);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (System.currentTimeMillis() - this.CQa <= this.CPZ)
    {
      ad.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70034);
      return;
    }
    this.CQa = System.currentTimeMillis();
    this.vFR.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(70020);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).dmo = false;
        AppMethodBeat.o(70020);
      }
      
      public final void dkA()
      {
        AppMethodBeat.i(70019);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(70019);
      }
      
      public final void dkB()
      {
        AppMethodBeat.i(70021);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(70021);
      }
    }, this.COK);
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
      localBundle = paramView.dxT;
      if (i != 2131305587) {
        break label235;
      }
      com.tencent.mm.wallet_core.ui.e.d(15, bt.aQJ(), this.mEntryScene);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (bt.isNullOrNil("")) {
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
      com.tencent.mm.wallet_core.a.k(this, localBundle);
      AppMethodBeat.o(70035);
      return;
      label235:
      if (i == 2131305588)
      {
        com.tencent.mm.wallet_core.ui.e.d(17, bt.aQJ(), this.mEntryScene);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == 2131305589)
      {
        com.tencent.mm.wallet_core.ui.e.d(16, bt.aQJ(), this.mEntryScene);
        if ((this.CQq) && (!bt.isNullOrNil(this.CQp)))
        {
          h.a(this, this.CQp, "", this.CQo, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70022);
              paramAnonymousDialogInterface = paramView.dxT;
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
    this.CQr = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
    com.tencent.mm.wallet_core.ui.e.d(13, bt.aQJ(), this.mEntryScene);
    if (this.CQr) {
      setMMTitle(2131765763);
    }
    this.vFR.Dka = new u.b()
    {
      public final int dkC()
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
        com.tencent.mm.wallet_core.ui.e.d(14, bt.aQJ(), this.mEntryScene);
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
    this.vFR.onPause();
    AppMethodBeat.o(70028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70027);
    super.onResume();
    this.vFR.onResume();
    AppMethodBeat.o(70027);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70032);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.e.aNP(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eEF());
        removeSceneEndListener(580);
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.dxT;
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
      ul(true);
      paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramn;
      this.COK = paramString.COK;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void djA() {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI
 * JD-Core Version:    0.7.0.1
 */