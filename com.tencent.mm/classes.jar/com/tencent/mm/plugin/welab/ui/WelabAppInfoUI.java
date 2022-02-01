package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WelabAppInfoUI
  extends MMActivity
{
  private a EQA;
  private View.OnClickListener EQB;
  private com.tencent.mm.plugin.welab.d.a.a EQr;
  private int EQs;
  private boolean EQt;
  private WelabRoundCornerImageView EQu;
  private RecyclerView EQv;
  private View EQw;
  private View EQx;
  private View EQy;
  private View EQz;
  private String dwb;
  private TextView mMC;
  private Button rIb;
  private MMSwitchBtn rkq;
  private TextView titleTv;
  private TextView xif;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.EQB = new WelabAppInfoUI.5(this);
    AppMethodBeat.o(146278);
  }
  
  private String fam()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.EQr.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void fan()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.EQr.aLr("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.EQr.aLr("field_ImgUrl");
    }
    localObject1 = f.aLm((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.EQv.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.EQv.setVisibility(0);
    this.EQA.pkh = ((List)localObject1);
    this.EQA.asY.notifyChanged();
    AppMethodBeat.o(146284);
  }
  
  public int getLayoutId()
  {
    return 2131496097;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146280);
    super.initView();
    if (this.EQr == null)
    {
      ae.e("WelabAppInfoUI", "info is null");
      AppMethodBeat.o(146280);
      return;
    }
    setMMTitleVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(201326592);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(getResources().getColor(2131101178));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101178));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(146270);
        WelabAppInfoUI.this.hideVKB();
        WelabAppInfoUI.this.finish();
        AppMethodBeat.o(146270);
        return true;
      }
    });
    this.EQu = ((WelabRoundCornerImageView)findViewById(2131296854));
    this.titleTv = ((TextView)findViewById(2131305902));
    this.xif = ((TextView)findViewById(2131305546));
    this.EQv = ((RecyclerView)findViewById(2131300988));
    this.EQw = findViewById(2131296876);
    this.rIb = ((Button)findViewById(2131303020));
    this.EQx = findViewById(2131299888);
    this.rkq = ((MMSwitchBtn)findViewById(2131298255));
    this.mMC = ((TextView)findViewById(2131305579));
    this.EQy = findViewById(2131305243);
    this.EQz = findViewById(2131303015);
    this.EQv.setLayoutManager(new LinearLayoutManager(0));
    this.EQv.setOverScrollMode(2);
    this.EQA = new a();
    this.EQv.setAdapter(this.EQA);
    AppMethodBeat.o(146280);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(146279);
    super.onCreate(paramBundle);
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.dwb = paramBundle.getStringExtra("para_appid");
      this.EQr = com.tencent.mm.plugin.welab.a.faa().aLj(this.dwb);
      this.EQs = this.EQr.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.EQt = bool;
      initView();
      d.v(this.dwb, 2, this.EQt);
      AppMethodBeat.o(146279);
      return;
      label110:
      bool = false;
    }
  }
  
  public void onPause()
  {
    int i = 0;
    AppMethodBeat.i(146281);
    super.onPause();
    Object localObject;
    if (this.EQs != this.EQr.field_Switch)
    {
      ae.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.faa().EQe.update(this.EQr, new String[0])), Integer.valueOf(this.EQs), Integer.valueOf(this.EQr.field_Switch) });
      this.EQs = this.EQr.field_Switch;
      localObject = new btu();
      btt localbtt = new btt();
      if (!this.EQr.fak()) {
        break label268;
      }
      localbtt.HgQ = i;
      localbtt.HgR = this.EQr.field_LabsAppId;
      if (this.EQr.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localbtt.GbY = i;
      ((btu)localObject).fXm.add(localbtt);
      localObject = new k.a(207, (com.tencent.mm.bw.a)localObject);
      ((l)g.ab(l.class)).azE().d((k.b)localObject);
      localObject = this.dwb;
      if (this.EQr.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      d.v((String)localObject, i, this.EQt);
      if (this.EQr.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.EQr);
        com.tencent.mm.plugin.welab.a.faa();
        com.tencent.mm.plugin.welab.a.hi((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = bu.aSB(this.EQr.field_expId);
      break;
      i = 2;
      break label150;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146282);
    super.onResume();
    Object localObject;
    if ((this.EQr.faj()) && (this.EQr.field_Type == 1))
    {
      this.EQw.setVisibility(0);
      this.mMC.setText(getResources().getString(2131766201) + this.EQr.aLr("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.rkq.setEnabled(true);
      if (this.EQr.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(fam(), true).commit();
        this.rkq.setCheck(true);
        this.rkq.setSwitchListener(new WelabAppInfoUI.2(this));
        label175:
        if (!this.EQr.faj()) {
          break label454;
        }
        this.rIb.setText(getResources().getString(2131766199) + this.EQr.aLr("field_Title"));
        if (this.EQr.field_Type == 1) {
          break label454;
        }
        this.rIb.setVisibility(0);
        this.rIb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            ae.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.a.faa();
            localObject = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramAnonymousView.EQf.get(str);
            if (localb != null)
            {
              ae.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.i((Activity)localObject, str);
            }
            for (;;)
            {
              d.v(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146272);
              return;
              ae.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.aLj(str).field_Type == 2)
              {
                if (paramAnonymousView.EQg != null) {
                  paramAnonymousView.EQg.i((Activity)localObject, str);
                } else {
                  ae.e("WelabMgr", "defaultWeAppOpener is null!");
                }
              }
              else {
                ae.e("WelabMgr", "can not find opener for ".concat(String.valueOf(str)));
              }
            }
          }
        });
        label262:
        localObject = this.titleTv;
        com.tencent.mm.plugin.welab.a.faa();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.EQr));
        this.xif.setText(this.EQr.aLr("field_Introduce"));
        if (!this.EQr.faj()) {
          break label466;
        }
        this.EQx.setVisibility(0);
        this.EQx.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.EQr.faj()) {
          break label478;
        }
        this.EQy.setVisibility(8);
        this.EQz.setVisibility(0);
      }
    }
    for (;;)
    {
      fan();
      this.EQu.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.av.a.a.aJh();
      com.tencent.mm.plugin.welab.a.faa();
      ((com.tencent.mm.av.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.EQr), this.EQu, com.tencent.mm.plugin.welab.a.faa().DWD);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(fam(), false).commit();
      this.rkq.setCheck(false);
      break;
      this.EQw.setVisibility(8);
      break label175;
      label454:
      this.rIb.setVisibility(8);
      break label262;
      label466:
      this.EQx.setVisibility(8);
      break label332;
      label478:
      this.EQy.setVisibility(0);
      this.EQz.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<WelabAppInfoUI.b>
  {
    public List<String> pkh;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.pkh.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView EQD;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */