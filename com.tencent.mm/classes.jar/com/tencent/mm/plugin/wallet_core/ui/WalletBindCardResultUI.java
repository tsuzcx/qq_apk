package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.s.a;
import com.tencent.mm.plugin.wallet_core.model.s.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(3)
public class WalletBindCardResultUI
  extends WalletBaseUI
{
  private IListener AMo;
  private String APz;
  private String Cvu;
  private TextView CwQ;
  private int HYK;
  private BindCardOrder IdC;
  private boolean IdD;
  private String IdE;
  private String IdF;
  private s.b IdG;
  private WalletOrderInfoNewUI.b IdH;
  private HashMap<String, WalletOrderInfoNewUI.a> IdI;
  private String IdJ;
  private BindCardOrder IdK;
  private String IdL;
  private Button IdM;
  private ImageView IdN;
  private ViewGroup IdO;
  private CdnImageView IdP;
  private TextView IdQ;
  private TextView IdR;
  private View IdS;
  private Button IdT;
  private ViewGroup IdU;
  private boolean IdV;
  private boolean IdW;
  private boolean IdX;
  private com.tencent.mm.wallet_core.d IdY;
  private PayInfo mPayInfo;
  
  public WalletBindCardResultUI()
  {
    AppMethodBeat.i(70755);
    this.APz = null;
    this.IdD = false;
    this.IdI = new HashMap();
    this.IdK = null;
    this.IdL = "-1";
    this.IdV = false;
    this.IdW = false;
    this.IdX = false;
    this.AMo = new IListener() {};
    AppMethodBeat.o(70755);
  }
  
  private void ahM(String paramString)
  {
    AppMethodBeat.i(70762);
    fSE();
    f.p(this, paramString, false);
    AppMethodBeat.o(70762);
  }
  
  private void fSB()
  {
    AppMethodBeat.i(70759);
    this.IdU.setVisibility(0);
    AppMethodBeat.o(70759);
  }
  
  private void fSC()
  {
    AppMethodBeat.i(70760);
    this.CwQ.setText(this.IdC.HWu);
    AppMethodBeat.o(70760);
  }
  
  private void fSD()
  {
    AppMethodBeat.i(70761);
    this.IdO.setVisibility(4);
    this.IdW = false;
    this.IdV = false;
    if (this.IdC != null) {
      if (this.IdC.HWA != null)
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[] { this.IdK });
        if ((this.IdC == null) || ((!this.IdC.fQi()) && (!this.IdC.fQk())) || (this.IdC.HWA.crw <= 0L) || (Util.isNullOrNil(this.IdC.HWB.HYF))) {
          break label854;
        }
        this.IdK = this.IdC;
        this.IdS.setVisibility(8);
        this.IdP.setRoundCorner(true);
        this.IdT.setEnabled(true);
        this.IdT.setBackgroundResource(2131231429);
        this.IdR.setCompoundDrawables(null, null, null, null);
        localObject = (WalletOrderInfoNewUI.a)this.IdI.get(this.IdK.HWA.crw);
        if (localObject == null) {
          break label639;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).icon)) {
          this.IdP.setUrl(((WalletOrderInfoNewUI.a)localObject).icon);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).dQx)) {
          this.IdQ.setText(((WalletOrderInfoNewUI.a)localObject).dQx);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).IhY))
        {
          this.IdT.setText(((WalletOrderInfoNewUI.a)localObject).IhY);
          this.IdT.setBackgroundResource(2131235656);
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.IdR.getLayoutParams();
        if ((localObject == null) || (Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).title))) {
          break label693;
        }
        this.IdR.setText(((WalletOrderInfoNewUI.a)localObject).title);
        localLayoutParams.addRule(15, 0);
        this.IdR.setLayoutParams(localLayoutParams);
        this.IdT.setVisibility(0);
        this.IdT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70750);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.WalletBindCardResultUI", "click activity button");
            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70750);
          }
        });
        if (this.IdK.HWA.HYA != 1L) {
          this.IdO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(70751);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
              WalletBindCardResultUI.b(WalletBindCardResultUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(70751);
            }
          });
        }
        localObject = this.IdL;
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = this.IdQ.getText();
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (((CharSequence)localObject).length() > 9))
            {
              this.IdQ.setText(((CharSequence)localObject).subSequence(0, 9));
              this.IdQ.append("...");
            }
            localObject = (ViewGroup.MarginLayoutParams)this.IdO.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 50);
            this.IdO.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.IdO.setVisibility(0);
          }
          break;
        }
      }
    }
    label639:
    while ((this.IdC.HWC == null) || (Util.isNullOrNil(this.IdC.HWC.Hwr)) || (!this.IdC.fQj())) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i;
        if (this.IdQ.getVisibility() == 0) {
          this.IdQ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70753);
              if ((WalletBindCardResultUI.g(WalletBindCardResultUI.this).getVisibility() == 0) && (WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() >= WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) && (!Util.isNullOrNil(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText())))
              {
                float f1 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getTextSize();
                Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[] { Integer.valueOf(WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight()), Integer.valueOf(WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft()) });
                Paint localPaint = new Paint();
                localPaint.setTextSize(f1);
                String str = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getText().toString();
                f1 = localPaint.measureText(str);
                float f2 = WalletBindCardResultUI.h(WalletBindCardResultUI.this).getRight() - WalletBindCardResultUI.g(WalletBindCardResultUI.this).getLeft();
                int i = 1;
                while ((localPaint.measureText(str.substring(0, str.length() - i - 1)) > f1 - f2) && (i <= str.length() - 1)) {
                  i += 1;
                }
                Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()) });
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).setText(str.substring(0, str.length() - i - 1));
                WalletBindCardResultUI.h(WalletBindCardResultUI.this).append("...");
              }
              AppMethodBeat.o(70753);
            }
          });
        }
        if (this.IdO.getVisibility() == 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.IdN.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 91);
          this.IdN.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(70761);
        return;
        this.IdP.setUrl(this.IdC.HWB.Bah);
        this.IdQ.setText(this.IdC.HWB.name);
        this.IdT.setText(this.IdC.HWB.HYF);
        continue;
        if (!Util.isNullOrNil(this.IdC.HWB.title))
        {
          this.IdR.setText(this.IdC.HWB.title);
          localLayoutParams.addRule(15, 0);
        }
        else
        {
          this.IdR.setVisibility(8);
          localLayoutParams.addRule(15, -1);
          continue;
          if (((String)localObject).equals("0"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("-1"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("3"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("4"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("2"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("1"))
                    {
                      i = 5;
                      continue;
                      this.IdT.setEnabled(false);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label693:
    label854:
    this.IdE = this.IdC.HWC.Hwr;
    this.IdF = this.IdC.HWC.Hws;
    this.HYK = this.IdC.HWC.HYK;
    this.IdG = this.IdC.HWC;
    this.IdP.setUrl(this.IdC.HWC.HYH);
    this.IdQ.setText(this.IdC.HWC.HYI);
    this.IdR.setText(getString(2131767410));
    this.IdR.setVisibility(0);
    this.IdP.setRoundCorner(true);
    this.IdT.setEnabled(true);
    this.IdT.setBackgroundResource(2131231429);
    Object localObject = (RelativeLayout.LayoutParams)this.IdR.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    this.IdR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.IdC.HWA.crw > 0L)
    {
      if (!Util.isNullOrNil(this.IdC.HWC.HYJ))
      {
        this.IdT.setVisibility(0);
        this.IdT.setText(this.IdC.HWC.HYJ);
        this.IdS.setVisibility(8);
      }
      localObject = (WalletOrderInfoNewUI.a)this.IdI.get(this.IdC.HWA.crw);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).HYH)) {
          this.IdP.setUrl(((WalletOrderInfoNewUI.a)localObject).HYH);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).HYI)) {
          this.IdQ.setText(((WalletOrderInfoNewUI.a)localObject).HYI);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).HYJ))
        {
          this.IdT.setText(((WalletOrderInfoNewUI.a)localObject).HYJ);
          this.IdT.setBackgroundResource(2131235656);
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Hwr)) {
          this.IdE = ((WalletOrderInfoNewUI.a)localObject).Hwr;
        }
        if (!Util.isNullOrNil(((WalletOrderInfoNewUI.a)localObject).Hws)) {
          this.IdF = ((WalletOrderInfoNewUI.a)localObject).Hws;
        }
      }
    }
    for (;;)
    {
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70752);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(WalletBindCardResultUI.this), WalletBindCardResultUI.d(WalletBindCardResultUI.this), Integer.valueOf(WalletBindCardResultUI.e(WalletBindCardResultUI.this)) });
          WalletBindCardResultUI.this.qn(2);
          paramAnonymousView = new wq();
          paramAnonymousView.ecI.userName = WalletBindCardResultUI.c(WalletBindCardResultUI.this);
          paramAnonymousView.ecI.ecK = Util.nullAs(WalletBindCardResultUI.d(WalletBindCardResultUI.this), "");
          paramAnonymousView.ecI.scene = 1034;
          paramAnonymousView.ecI.ecL = 0;
          if (WalletBindCardResultUI.e(WalletBindCardResultUI.this) > 0) {
            paramAnonymousView.ecI.appVersion = WalletBindCardResultUI.e(WalletBindCardResultUI.this);
          }
          EventCenter.instance.publish(paramAnonymousView);
          if ((!Util.isNullOrNil(WalletBindCardResultUI.f(WalletBindCardResultUI.this).HWC.HYJ)) && (WalletBindCardResultUI.f(WalletBindCardResultUI.this).HWA.crw > 0L)) {
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, true);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70752);
            return;
            WalletBindCardResultUI.a(WalletBindCardResultUI.this, false);
          }
        }
      };
      this.IdO.setOnClickListener((View.OnClickListener)localObject);
      this.IdT.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.IdQ.getText();
      if ((Util.isNullOrNil((CharSequence)localObject)) || (((CharSequence)localObject).length() <= 9)) {
        break;
      }
      this.IdQ.setText(((CharSequence)localObject).subSequence(0, 9));
      this.IdQ.append("...");
      break;
      this.IdT.setVisibility(8);
      this.IdS.setVisibility(8);
    }
  }
  
  private void fSE()
  {
    int i = 0;
    AppMethodBeat.i(70768);
    if (!this.IdD)
    {
      le localle = new le();
      localle.dQr.requestCode = 4;
      le.a locala = localle.dQr;
      if (getInput().getBoolean("intent_pay_end", false)) {
        i = -1;
      }
      locala.resultCode = i;
      EventCenter.instance.publish(localle);
      this.IdD = true;
    }
    AppMethodBeat.o(70768);
  }
  
  public final void done()
  {
    AppMethodBeat.i(70765);
    Bundle localBundle = new Bundle();
    if (this.IdY != null)
    {
      this.IdY.a(this, 0, localBundle);
      AppMethodBeat.o(70765);
      return;
    }
    finish();
    AppMethodBeat.o(70765);
  }
  
  public int getLayoutId()
  {
    return 2131496907;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70758);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.IdN = ((ImageView)findViewById(2131310649));
    this.CwQ = ((TextView)findViewById(2131305813));
    this.IdM = ((Button)findViewById(2131305809));
    showHomeBtn(false);
    enableBackMenu(false);
    String str = getString(2131755858);
    if ((this.IdC != null) && (!Util.isNullOrNil(this.IdC.HWt))) {
      this.IdM.setText(this.IdC.HWt);
    }
    for (;;)
    {
      this.IdM.setOnClickListener(new WalletBindCardResultUI.2(this));
      this.IdU = ((ViewGroup)findViewById(2131310234));
      this.IdO = ((ViewGroup)findViewById(2131309134));
      this.IdP = ((CdnImageView)findViewById(2131309136));
      this.IdP.setUseSdcardCache(true);
      this.IdQ = ((TextView)findViewById(2131309133));
      this.IdR = ((TextView)findViewById(2131309138));
      this.IdT = ((Button)findViewById(2131309131));
      this.IdS = findViewById(2131309135);
      this.IdU.setVisibility(4);
      fSC();
      fSD();
      fSB();
      if ((!Util.isNullOrNil(this.IdC.HWv)) && (!Util.isNullOrNil(this.IdC.HWw))) {
        ((TextView)findViewById(2131305814)).setText(getString(2131767508, new Object[] { this.IdC.HWv, this.IdC.HWw }));
      }
      AppMethodBeat.o(70758);
      return;
      this.IdM.setText(str);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70763);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      Log.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
      doSceneProgress(new ac(this.IdH.HQn, this.IdH.Iia, this.IdH.Iib, this.IdH.Iic, this.IdH.Ian, this.IdH.Iid, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
    }
    AppMethodBeat.o(70763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70756);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      if (!com.tencent.mm.compatible.util.d.oD(23)) {
        break label172;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101424));
    }
    for (;;)
    {
      setContentViewVisibility(4);
      com.tencent.mm.wallet_core.a.by(this);
      this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      getInput().getInt("key_pay_type", -1);
      BindCardOrder localBindCardOrder = (BindCardOrder)getInput().getParcelable("key_bindcard_value_result");
      paramBundle = localBindCardOrder;
      if (localBindCardOrder == null) {
        paramBundle = new BindCardOrder();
      }
      this.IdC = paramBundle;
      setContentViewVisibility(0);
      initView();
      this.IdY = getProcess();
      fSC();
      qn(1);
      addSceneEndListener(1979);
      EventCenter.instance.addListener(this.AMo);
      this.IdX = true;
      AppMethodBeat.o(70756);
      return;
      label172:
      getWindow().setStatusBarColor(getResources().getColor(2131099687));
    }
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70764);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131768014), getResources().getStringArray(2130903100), "", new WalletBindCardResultUI.7(this));
    AppMethodBeat.o(70764);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70767);
    super.onDestroy();
    EventCenter.instance.removeListener(this.AMo);
    removeSceneEndListener(1979);
    AppMethodBeat.o(70767);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70766);
    if (paramInt == 4)
    {
      done();
      AppMethodBeat.o(70766);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(70766);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70757);
    super.onResume();
    Log.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[] { Boolean.valueOf(this.IdX), this.IdK, Boolean.valueOf(this.IdV), Boolean.valueOf(this.IdW), this.IdG });
    if (this.IdX)
    {
      this.IdX = false;
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.IdK != null) && (this.IdW))
    {
      doSceneProgress(new ac(this.IdK.HWA.crw, this.IdK.HWA.HYB, this.IdK.HWA.HYC, this.IdK.HWA.HYD, this.IdK.HWA.HYA, this.IdK.HWA.HYE, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
      AppMethodBeat.o(70757);
      return;
    }
    if ((this.IdV) && (this.IdG != null)) {
      doSceneProgress(new ac(this.IdC.HWA.crw, this.IdC.HWA.HYB, this.IdC.HWA.HYC, this.IdC.HWA.HYD, this.IdC.HWA.HYE, this.IdC.HWA.HYA, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
    }
    AppMethodBeat.o(70757);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70769);
    if ((paramq instanceof ac)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ac)paramq;
        paramq = new WalletOrderInfoNewUI.a(paramString.lxS);
        if (this.IdH == null) {
          break label78;
        }
        this.IdI.put(paramString.HQn, paramq);
        fSD();
        fSB();
      }
    }
    label78:
    while (!(paramq instanceof r)) {
      for (;;)
      {
        AppMethodBeat.o(70769);
        return false;
        if (this.IdV)
        {
          this.IdI.put(paramString.HQn, paramq);
          fSD();
          fSB();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (r)paramq;
      paramq = paramString.HPV;
      if ((this.IdK != null) && (this.IdK.HWA.crw == paramString.HPX.HWA.crw))
      {
        Log.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[] { this.IdK });
        this.IdL = paramq;
        fSD();
        fSB();
        if ((!Util.isNullOrNil(paramString.resultMsg)) && (!"3".equals(paramq))) {
          this.IdT.setText(paramString.resultMsg);
        }
      }
      if ((!"-1".equals(paramq)) && (!"0".equals(paramq)) && (!Util.isNullOrNil(paramString.HPW))) {
        com.tencent.mm.ui.base.h.c(this, paramString.HPW, "", true);
      }
      while (!"0".equals(paramq))
      {
        AppMethodBeat.o(70769);
        return true;
      }
      if (!Util.isNullOrNil(paramString.HPW)) {}
      for (paramString = paramString.HPW;; paramString = getString(2131768111))
      {
        Toast.makeText(this, paramString, 0).show();
        break;
      }
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131768354);
    }
    com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(70769);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qn(int paramInt)
  {
    AppMethodBeat.i(70771);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    if (this.IdC.HWA == null) {}
    for (String str = "";; str = Util.nullAs(this.IdC.HWA.crw, ""))
    {
      localh.a(14877, new Object[] { str, this.IdC.HWx, Integer.valueOf(paramInt), this.IdC.dDj });
      AppMethodBeat.o(70771);
      return;
    }
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    AppMethodBeat.i(70770);
    getContentView().setVisibility(paramInt);
    AppMethodBeat.o(70770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI
 * JD-Core Version:    0.7.0.1
 */