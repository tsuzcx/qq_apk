package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet_core.ui.v;
import com.tencent.mm.plugin.wallet_core.ui.v.a;
import com.tencent.mm.plugin.wallet_core.ui.v.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private v ERr;
  private boolean OHR;
  private int OJe;
  private long OJf;
  private View OJg;
  private View OJh;
  private View OJi;
  private TextView OJj;
  private TextView OJk;
  private TextView OJl;
  private TextView OJm;
  private TextView OJn;
  private TextView OJo;
  private TextView OJp;
  private TextView OJq;
  private TextView OJr;
  private String OJs;
  private String OJt;
  private String OJu;
  private boolean OJv;
  private boolean OJw;
  private int mEntryScene;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(70026);
    this.OJe = 500;
    this.OJf = 0L;
    this.mEntryScene = 0;
    this.OJw = false;
    this.ERr = new v();
    this.OHR = false;
    AppMethodBeat.o(70026);
  }
  
  private boolean Cb(boolean paramBoolean)
  {
    AppMethodBeat.i(70037);
    Object localObject2 = gIC();
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
      localObject2 = Util.nullAs(((JSONObject)localObject1).optString("cache_header_titles", getString(a.i.switch_realname_default_tip)), getString(a.i.switch_realname_default_tip));
      if (this.OJw)
      {
        this.OJp.setText(a.i.wallet_real_name_verify_title_from_pwd_desc);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label526;
        }
        this.OJq.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.OJr.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.OJi.setVisibility(0);
        label118:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label538;
        }
        this.OJj.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(a.i.switch_realname_verify_mode_bindcard)));
        this.OJk.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(a.i.switch_realname_verify_mode_bindcard_tip)));
        this.OJg.setVisibility(0);
        label176:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label550;
        }
        this.OJl.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(a.i.switch_realname_verify_mode_id_verify)));
        this.OJm.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(a.i.switch_realname_verify_mode_id_verify_tip)));
        this.OJh.setVisibility(0);
        label234:
        this.OJt = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.OJu = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.OJv = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (Util.isNullOrNil((String)localObject2)) {
          break label562;
        }
        this.OJn.setText((CharSequence)localObject2);
        this.OJn.setVisibility(0);
        label301:
        this.OJt = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.OJu = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.OJv = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.OJs = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!Util.isNullOrNil(this.OJs))) {
          addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(70024);
              com.tencent.mm.wallet_core.ui.g.d(18, Util.nowSecond(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
              com.tencent.mm.wallet_core.ui.g.p(SwitchRealnameVerifyModeUI.this.getContext(), SwitchRealnameVerifyModeUI.d(SwitchRealnameVerifyModeUI.this), false);
              AppMethodBeat.o(70024);
              return true;
            }
          });
        }
        if (!((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false)) {
          break label574;
        }
        localObject1 = new SpannableString("#  " + getContext().getResources().getString(a.i.wallet_offline_un_open_tip));
        localObject2 = getContext().getResources().getDrawable(a.e.icon_shield_pay);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 18);
        this.OJo.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.OJo.setOnClickListener(new SwitchRealnameVerifyModeUI.8(this));
        this.OJo.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(70037);
        return true;
        this.OJp.setText((CharSequence)localObject2);
        break;
        label526:
        this.OJi.setVisibility(8);
        break label118;
        label538:
        this.OJg.setVisibility(8);
        break label176;
        label550:
        this.OJh.setVisibility(8);
        break label234;
        label562:
        this.OJn.setVisibility(8);
        break label301;
        label574:
        this.OJo.setVisibility(8);
      }
    }
    AppMethodBeat.o(70037);
    return paramBoolean;
  }
  
  private static JSONObject gIC()
  {
    AppMethodBeat.i(70036);
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlq, "");
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
  
  public int getLayoutId()
  {
    return a.g.wallet_realname_verify_mode_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70031);
    setMMTitle("");
    this.OJg = findViewById(a.f.switch_to_bindcard);
    this.OJh = findViewById(a.f.switch_to_verify_id);
    this.OJi = findViewById(a.f.switch_to_verifycard);
    this.OJh.setOnClickListener(this);
    this.OJg.setOnClickListener(this);
    this.OJi.setOnClickListener(this);
    this.OJj = ((TextView)findViewById(a.f.bind_card_title));
    this.OJk = ((TextView)findViewById(a.f.bind_card_sub_title));
    this.OJl = ((TextView)findViewById(a.f.bind_id_title));
    this.OJm = ((TextView)findViewById(a.f.bind_id_sub_title));
    this.OJn = ((TextView)findViewById(a.f.extral_wording));
    this.OJo = ((TextView)findViewById(a.f.safe_pay_tip));
    this.OJq = ((TextView)findViewById(a.f.verify_card_title));
    this.OJr = ((TextView)findViewById(a.f.verify_card_sub_title));
    this.OJp = ((TextView)findViewById(a.f.switch_real_name_tv));
    if (this.OJw) {
      this.OJp.setText(a.i.wallet_real_name_verify_title_from_pwd_desc);
    }
    Cb(false);
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
          com.tencent.mm.wallet_core.ui.g.d(14, Util.nowSecond(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
          paramAnonymousMenuItem.h(SwitchRealnameVerifyModeUI.this, 0);
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
        this.ERr.eQT();
        AppMethodBeat.o(70033);
        return;
      }
      this.ERr.cancel();
    }
    AppMethodBeat.o(70033);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(70034);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (System.currentTimeMillis() - this.OJf <= this.OJe)
    {
      Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70034);
      return;
    }
    this.OJf = System.currentTimeMillis();
    this.ERr.a(new v.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(70020);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).fxt = false;
        AppMethodBeat.o(70020);
      }
      
      public final void eQT()
      {
        AppMethodBeat.i(70019);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(70019);
      }
      
      public final void eQU()
      {
        AppMethodBeat.i(70021);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(70021);
      }
    }, this.OHR);
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
      localBundle = paramView.fKb;
      if (i != a.f.switch_to_bindcard) {
        break label235;
      }
      com.tencent.mm.wallet_core.ui.g.d(15, Util.nowSecond(), this.mEntryScene);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (Util.isNullOrNil("")) {
            paramView = getString(a.i.wallet_unknown_err);
          }
          com.tencent.mm.ui.base.h.a(this, paramView, null, false, new SwitchRealnameVerifyModeUI.6(this));
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
      if (i == a.f.switch_to_verify_id)
      {
        com.tencent.mm.wallet_core.ui.g.d(17, Util.nowSecond(), this.mEntryScene);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == a.f.switch_to_verifycard)
      {
        com.tencent.mm.wallet_core.ui.g.d(16, Util.nowSecond(), this.mEntryScene);
        if ((this.OJv) && (!Util.isNullOrNil(this.OJu)))
        {
          com.tencent.mm.ui.base.h.a(this, this.OJu, "", this.OJt, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70022);
              paramAnonymousDialogInterface = paramView.fKb;
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
    this.OJw = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
    com.tencent.mm.wallet_core.ui.g.d(13, Util.nowSecond(), this.mEntryScene);
    if (this.OJw) {
      setMMTitle(a.i.wallet_real_name_verify_title_from_pwd);
    }
    this.ERr.Pdi = new v.b()
    {
      public final int eQV()
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
        com.tencent.mm.wallet_core.ui.g.d(14, Util.nowSecond(), this.mEntryScene);
        locald.h(this, 0);
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
    this.ERr.onPause();
    AppMethodBeat.o(70028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70027);
    super.onResume();
    this.ERr.onResume();
    AppMethodBeat.o(70027);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70032);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.e.bsi(((com.tencent.mm.plugin.wallet_core.c.d)paramq).gIv());
        removeSceneEndListener(580);
        ((com.tencent.mm.plugin.wallet_core.c.d)paramq).getToken();
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.fKb;
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
      Cb(true);
      paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.e)paramq;
      this.OHR = paramString.OHR;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eOt() {}
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