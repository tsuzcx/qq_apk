package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private int gyl;
  private s oAh;
  private boolean ubw;
  private long ucA;
  private View ucB;
  private View ucC;
  private View ucD;
  private TextView ucE;
  private TextView ucF;
  private TextView ucG;
  private TextView ucH;
  private TextView ucI;
  private TextView ucJ;
  private TextView ucK;
  private TextView ucL;
  private TextView ucM;
  private String ucN;
  private String ucO;
  private String ucP;
  private boolean ucQ;
  private boolean ucR;
  private int ucz;
  
  public SwitchRealnameVerifyModeUI()
  {
    AppMethodBeat.i(46598);
    this.ucz = 500;
    this.ucA = 0L;
    this.gyl = 0;
    this.ucR = false;
    this.oAh = new s();
    this.ubw = false;
    AppMethodBeat.o(46598);
  }
  
  private static JSONObject cTc()
  {
    AppMethodBeat.i(46609);
    com.tencent.mm.kernel.g.RM();
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCo, "");
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
          ab.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
            AppMethodBeat.o(46609);
            return null;
          }
          AppMethodBeat.o(46609);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", localJSONException, "", new Object[0]);
          ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
          AppMethodBeat.o(46609);
          return null;
        }
      }
    }
    ab.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
    AppMethodBeat.o(46609);
    return null;
  }
  
  private boolean nF(boolean paramBoolean)
  {
    AppMethodBeat.i(46610);
    Object localObject2 = cTc();
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
      localObject2 = bo.bf(((JSONObject)localObject1).optString("cache_header_titles", getString(2131304213)), getString(2131304213));
      if (this.ucR)
      {
        this.ucK.setText(2131305549);
        if (!((JSONObject)localObject1).optBoolean("isShowBindCardVerify", false)) {
          break label536;
        }
        this.ucL.setText(((JSONObject)localObject1).optString("bindCardVerifyTitle"));
        this.ucM.setText(((JSONObject)localObject1).optString("bindCardVerifySubtitle"));
        this.ucD.setVisibility(0);
        label115:
        if (!((JSONObject)localObject1).optBoolean("isShowBindCard", false)) {
          break label548;
        }
        this.ucE.setText(((JSONObject)localObject1).optString("bindcardTitle", getString(2131304214)));
        this.ucF.setText(((JSONObject)localObject1).optString("bindcardSubTitle", getString(2131304215)));
        this.ucB.setVisibility(0);
        label172:
        if (!((JSONObject)localObject1).optBoolean("isShowBindId", false)) {
          break label560;
        }
        this.ucG.setText(((JSONObject)localObject1).optString("bindIdTitle", getString(2131304216)));
        this.ucH.setText(((JSONObject)localObject1).optString("bindIdSubTitle", getString(2131304217)));
        this.ucC.setVisibility(0);
        label233:
        this.ucO = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.ucP = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent", "");
        this.ucQ = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        localObject2 = ((JSONObject)localObject1).optString("extral_wording", "");
        if (bo.isNullOrNil((String)localObject2)) {
          break label572;
        }
        this.ucI.setText((CharSequence)localObject2);
        this.ucI.setVisibility(0);
        label304:
        this.ucO = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.ucP = ((JSONObject)localObject1).optString("bindCardVerifyAlertViewContent");
        this.ucQ = ((JSONObject)localObject1).optBoolean("isShowBindCardVerifyAlertView", false);
        paramBoolean = ((JSONObject)localObject1).optBoolean("question_answer_switch", false);
        this.ucN = ((JSONObject)localObject1).optString("question_answer_url", "");
        if ((paramBoolean) && (!bo.isNullOrNil(this.ucN))) {
          addIconOptionMenu(0, 2130840873, new SwitchRealnameVerifyModeUI.7(this));
        }
        if (!((JSONObject)localObject1).optBoolean("isShowCapitalSecurity", false)) {
          break label584;
        }
        localObject1 = new SpannableString("#  " + getContext().getResources().getString(2131305318));
        localObject2 = getContext().getResources().getDrawable(2130839138);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 18);
        this.ucJ.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.ucJ.setOnClickListener(new SwitchRealnameVerifyModeUI.8(this));
        this.ucJ.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(46610);
        return true;
        this.ucK.setText((CharSequence)localObject2);
        break;
        label536:
        this.ucD.setVisibility(8);
        break label115;
        label548:
        this.ucB.setVisibility(8);
        break label172;
        label560:
        this.ucC.setVisibility(8);
        break label233;
        label572:
        this.ucI.setVisibility(8);
        break label304;
        label584:
        this.ucJ.setVisibility(8);
      }
    }
    AppMethodBeat.o(46610);
    return paramBoolean;
  }
  
  public int getLayoutId()
  {
    return 2130971241;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46608);
    setMMTitle("");
    this.ucB = findViewById(2131829375);
    this.ucC = findViewById(2131829379);
    this.ucD = findViewById(2131829371);
    this.ucC.setOnClickListener(this);
    this.ucB.setOnClickListener(this);
    this.ucD.setOnClickListener(this);
    this.ucE = ((TextView)findViewById(2131829376));
    this.ucF = ((TextView)findViewById(2131829377));
    this.ucG = ((TextView)findViewById(2131829380));
    this.ucH = ((TextView)findViewById(2131829381));
    this.ucI = ((TextView)findViewById(2131829382));
    this.ucJ = ((TextView)findViewById(2131829253));
    this.ucL = ((TextView)findViewById(2131829372));
    this.ucM = ((TextView)findViewById(2131829373));
    this.ucK = ((TextView)findViewById(2131829370));
    if (this.ucR) {
      this.ucK.setText(2131305549);
    }
    nF(false);
    b localb = new b();
    addSceneEndListener(1666);
    doSceneProgress(localb);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(46590);
        paramAnonymousMenuItem = SwitchRealnameVerifyModeUI.this.getProcess();
        if (paramAnonymousMenuItem != null)
        {
          com.tencent.mm.wallet_core.ui.e.a(14, bo.aox(), SwitchRealnameVerifyModeUI.a(SwitchRealnameVerifyModeUI.this));
          paramAnonymousMenuItem.e(SwitchRealnameVerifyModeUI.this, 0);
          AppMethodBeat.o(46590);
          return true;
        }
        SwitchRealnameVerifyModeUI.this.finish();
        AppMethodBeat.o(46590);
        return false;
      }
    });
    AppMethodBeat.o(46608);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.oAh.bOM();
        AppMethodBeat.o(46605);
        return;
      }
      this.oAh.cancel();
    }
    AppMethodBeat.o(46605);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(46606);
    if (System.currentTimeMillis() - this.ucA <= this.ucz)
    {
      ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
      AppMethodBeat.o(46606);
      return;
    }
    this.ucA = System.currentTimeMillis();
    this.oAh.a(new s.a()
    {
      public final void bOM()
      {
        AppMethodBeat.i(46591);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        SwitchRealnameVerifyModeUI.b(SwitchRealnameVerifyModeUI.this);
        AppMethodBeat.o(46591);
      }
      
      public final void bON()
      {
        AppMethodBeat.i(46593);
        SwitchRealnameVerifyModeUI.this.onClickImp(paramView);
        AppMethodBeat.o(46593);
      }
      
      public final void cancel()
      {
        AppMethodBeat.i(46592);
        SwitchRealnameVerifyModeUI.c(SwitchRealnameVerifyModeUI.this).coy = false;
        AppMethodBeat.o(46592);
      }
    }, this.ubw);
    AppMethodBeat.o(46606);
  }
  
  public void onClickImp(View paramView)
  {
    AppMethodBeat.i(46607);
    int i = paramView.getId();
    paramView = getProcess();
    Bundle localBundle;
    if (paramView != null)
    {
      localBundle = paramView.mEJ;
      if (i != 2131829375) {
        break label235;
      }
      com.tencent.mm.wallet_core.ui.e.a(15, bo.aox(), this.gyl);
      if (localBundle.getInt("realname_scene") == 1)
      {
        if (getIntent() == null)
        {
          paramView = "";
          if (bo.isNullOrNil("")) {
            paramView = getString(2131305682);
          }
          h.a(this, paramView, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(46595);
              SwitchRealnameVerifyModeUI.this.finish();
              AppMethodBeat.o(46595);
            }
          });
          AppMethodBeat.o(46607);
          return;
        }
        addSceneEndListener(580);
        doSceneForceProgress(new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
        AppMethodBeat.o(46607);
        return;
      }
      localBundle.putInt("real_name_verify_mode", 1);
    }
    for (;;)
    {
      a.j(this, localBundle);
      AppMethodBeat.o(46607);
      return;
      label235:
      if (i == 2131829379)
      {
        com.tencent.mm.wallet_core.ui.e.a(17, bo.aox(), this.gyl);
        localBundle.putInt("real_name_verify_mode", 2);
      }
      else if (i == 2131829371)
      {
        com.tencent.mm.wallet_core.ui.e.a(16, bo.aox(), this.gyl);
        if ((this.ucQ) && (!bo.isNullOrNil(this.ucP)))
        {
          h.a(this, this.ucP, "", this.ucO, false, new SwitchRealnameVerifyModeUI.5(this, paramView));
          AppMethodBeat.o(46607);
          return;
        }
        localBundle.putInt("real_name_verify_mode", 3);
        localBundle.putString("verify_card_flag", "1");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46602);
    super.onCreate(paramBundle);
    if ((getIntent().getExtras().getBoolean("is_from_new_cashier")) && (getProcess() == null))
    {
      boolean bool1 = getIntent().getExtras().getBoolean("key_process_is_end");
      boolean bool2 = getIntent().getExtras().getBoolean("key_process_is_stay");
      if ((bool1 == true) && (!bool2)) {
        finish();
      }
    }
    this.ucR = getInput().getBoolean("key_from_set_pwd", false);
    initView();
    getProcess();
    this.gyl = getInput().getInt("entry_scene", this.gyl);
    com.tencent.mm.wallet_core.ui.e.a(13, bo.aox(), this.gyl);
    if (this.ucR) {
      setMMTitle(2131305548);
    }
    this.oAh.uuu = new SwitchRealnameVerifyModeUI.1(this);
    AppMethodBeat.o(46602);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46601);
    super.onDestroy();
    AppMethodBeat.o(46601);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(46611);
    if (paramInt == 4)
    {
      c localc = getProcess();
      if (localc != null)
      {
        com.tencent.mm.wallet_core.ui.e.a(14, bo.aox(), this.gyl);
        localc.e(this, 0);
        AppMethodBeat.o(46611);
        return true;
      }
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(46611);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(46600);
    super.onPause();
    this.oAh.onPause();
    AppMethodBeat.o(46600);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46599);
    super.onResume();
    this.oAh.onResume();
    AppMethodBeat.o(46599);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46604);
    if ((paramm instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.pluginsdk.wallet.g.ana(((d)paramm).cSW());
        removeSceneEndListener(580);
        paramString = getProcess();
        if (paramString != null)
        {
          paramString = paramString.mEJ;
          paramString.putInt("real_name_verify_mode", 1);
          a.j(this, paramString);
        }
        AppMethodBeat.o(46604);
        return true;
      }
    }
    else if ((paramm instanceof b))
    {
      removeSceneEndListener(1666);
      nF(true);
      paramString = (b)paramm;
      this.ubw = paramString.ubw;
      if (paramString.jumpRemind == null) {}
      for (paramInt1 = 0; (paramInt1 != 0) && (paramString.jumpRemind.a(this, new f()
          {
            public final void bOi() {}
          })); paramInt1 = 1)
      {
        AppMethodBeat.o(46604);
        return true;
      }
    }
    AppMethodBeat.o(46604);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI
 * JD-Core Version:    0.7.0.1
 */