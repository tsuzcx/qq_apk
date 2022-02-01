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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private boolean HPI;
  private int HQW;
  private long HQX;
  private View HQY;
  private View HQZ;
  private View HRa;
  private TextView HRb;
  private TextView HRc;
  private TextView HRd;
  private TextView HRe;
  private TextView HRf;
  private TextView HRg;
  private TextView HRh;
  private TextView HRi;
  private TextView HRj;
  private String HRk;
  private String HRl;
  private String HRm;
  private boolean HRn;
  private boolean HRo;
  private int mEntryScene;
  private u zmb;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(70026);
    this.HQW = 500;
    this.HQX = 0L;
    this.mEntryScene = 0;
    this.HRo = false;
    this.zmb = new u();
    this.HPI = false;
    AppMethodBeat.o(70026);
  }
  
  private static JSONObject fPW()
  {
    AppMethodBeat.i(70036);
    com.tencent.mm.kernel.g.aAi();
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXq, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!Util.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          Log.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            AppMethodBeat.o(70036);
            return null;
          }
          AppMethodBeat.o(70036);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          AppMethodBeat.o(70036);
          return null;
        }
      }
    }
    Log.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    AppMethodBeat.o(70036);
    return null;
  }
  
  private boolean yg(boolean paramBoolean)
  {
    AppMethodBeat.i(70037);
    Object localObject2 = fPW();
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
      localObject2 = Util.nullAs(((JSONObject)localObject1).optString("cache_header_titles", getString(2131766590)), getString(2131766590));
      if (this.HRo)
      {
        this.HRh.setText(2131768217);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label537;
        }
        this.HRi.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.HRj.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.HRa.setVisibility(0);
        label115:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label549;
        }
        this.HRb.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(2131766591)));
        this.HRc.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(2131766592)));
        this.HQY.setVisibility(0);
        label173:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label561;
        }
        this.HRd.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(2131766593)));
        this.HRe.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(2131766594)));
        this.HQZ.setVisibility(0);
        label234:
        this.HRl = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.HRm = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.HRn = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (Util.isNullOrNil((String)localObject2)) {
          break label573;
        }
        this.HRf.setText((CharSequence)localObject2);
        this.HRf.setVisibility(0);
        label305:
        this.HRl = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.HRm = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.HRn = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.HRk = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!Util.isNullOrNil(this.HRk))) {
          addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(70024);
              f.d(18, Util.nowSecond(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
              f.p(SwitchRealnameVerifyModeUI.this.getContext(), SwitchRealnameVerifyModeUI.d(SwitchRealnameVerifyModeUI.this), false);
              AppMethodBeat.o(70024);
              return true;
            }
          });
        }
        if (!((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false)) {
          break label585;
        }
        localObject1 = new SpannableString("#  " + getContext().getResources().getString(2131767981));
        localObject2 = getContext().getResources().getDrawable(2131233114);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 18);
        this.HRg.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.HRg.setOnClickListener(new SwitchRealnameVerifyModeUI.8(this));
        this.HRg.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(70037);
        return true;
        this.HRh.setText((CharSequence)localObject2);
        break;
        label537:
        this.HRa.setVisibility(8);
        break label115;
        label549:
        this.HQY.setVisibility(8);
        break label173;
        label561:
        this.HQZ.setVisibility(8);
        break label234;
        label573:
        this.HRf.setVisibility(8);
        break label305;
        label585:
        this.HRg.setVisibility(8);
      }
    }
    AppMethodBeat.o(70037);
    return paramBoolean;
  }
  
  public int getLayoutId()
  {
    return 2131496998;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70031);
    setMMTitle("");
    this.HQY = findViewById(2131308809);
    this.HQZ = findViewById(2131308810);
    this.HRa = findViewById(2131308811);
    this.HQZ.setOnClickListener(this);
    this.HQY.setOnClickListener(this);
    this.HRa.setOnClickListener(this);
    this.HRb = ((TextView)findViewById(2131297381));
    this.HRc = ((TextView)findViewById(2131297380));
    this.HRd = ((TextView)findViewById(2131297385));
    this.HRe = ((TextView)findViewById(2131297384));
    this.HRf = ((TextView)findViewById(2131300273));
    this.HRg = ((TextView)findViewById(2131307204));
    this.HRi = ((TextView)findViewById(2131309694));
    this.HRj = ((TextView)findViewById(2131309693));
    this.HRh = ((TextView)findViewById(2131308807));
    if (this.HRo) {
      this.HRh.setText(2131768217);
    }
    yg(false);
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
          f.d(14, Util.nowSecond(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
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
        this.zmb.ehm();
        AppMethodBeat.o(70033);
        return;
      }
      this.zmb.cancel();
    }
    AppMethodBeat.o(70033);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(70034);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (System.currentTimeMillis() - this.HQX <= this.HQW)
    {
      Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70034);
      return;
    }
    this.HQX = System.currentTimeMillis();
    this.zmb.a(new u.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(70020);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).dEF = false;
        AppMethodBeat.o(70020);
      }
      
      public final void ehm()
      {
        AppMethodBeat.i(70019);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(70019);
      }
      
      public final void ehn()
      {
        AppMethodBeat.i(70021);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(70021);
      }
    }, this.HPI);
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
      localBundle = paramView.dQL;
      if (i != 2131308809) {
        break label235;
      }
      f.d(15, Util.nowSecond(), this.mEntryScene);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (Util.isNullOrNil("")) {
            paramView = getString(2131768354);
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
      com.tencent.mm.wallet_core.a.l(this, localBundle);
      AppMethodBeat.o(70035);
      return;
      label235:
      if (i == 2131308810)
      {
        f.d(17, Util.nowSecond(), this.mEntryScene);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == 2131308811)
      {
        f.d(16, Util.nowSecond(), this.mEntryScene);
        if ((this.HRn) && (!Util.isNullOrNil(this.HRm)))
        {
          h.a(this, this.HRm, "", this.HRl, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70022);
              paramAnonymousDialogInterface = paramView.dQL;
              paramAnonymousDialogInterface.putInt("real_name_verify_mode", 3);
              paramAnonymousDialogInterface.putString("verify_card_flag", "1");
              com.tencent.mm.wallet_core.a.l(SwitchRealnameVerifyModeUI.this, paramAnonymousDialogInterface);
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
    this.HRo = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
    f.d(13, Util.nowSecond(), this.mEntryScene);
    if (this.HRo) {
      setMMTitle(2131768216);
    }
    this.zmb.IkQ = new u.b()
    {
      public final int eho()
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
        f.d(14, Util.nowSecond(), this.mEntryScene);
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
    this.zmb.onPause();
    AppMethodBeat.o(70028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70027);
    super.onResume();
    this.zmb.onResume();
    AppMethodBeat.o(70027);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70032);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.e.bfP(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPP());
        removeSceneEndListener(580);
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.dQL;
          paramString.putInt("real_name_verify_mode", 1);
          com.tencent.mm.wallet_core.a.l(this, paramString);
        }
        AppMethodBeat.o(70032);
        return true;
      }
    }
    else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e))
    {
      removeSceneEndListener(1666);
      yg(true);
      paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramq;
      this.HPI = paramString.HPI;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eeY() {}
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