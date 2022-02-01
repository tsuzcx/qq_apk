package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.welab.a.a;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.a.e;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WelabAppInfoUI
  extends MMActivity
{
  private TextView GZI;
  private View.OnClickListener QFA;
  private com.tencent.mm.plugin.welab.d.a.a QFq;
  private int QFr;
  private boolean QFs;
  private WelabRoundCornerImageView QFt;
  private RecyclerView QFu;
  private View QFv;
  private View QFw;
  private View QFx;
  private View QFy;
  private a QFz;
  private String appid;
  private TextView rbA;
  private TextView titleTv;
  private Button wNZ;
  private MMSwitchBtn wrR;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.QFA = new WelabAppInfoUI.5(this);
    AppMethodBeat.o(146278);
  }
  
  private String hde()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.QFq.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void hdf()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.QFq.bnH("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.QFq.bnH("field_ImgUrl");
    }
    localObject1 = f.bnC((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.QFu.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.QFu.setVisibility(0);
    this.QFz.tYs = ((List)localObject1);
    this.QFz.alc.notifyChanged();
    AppMethodBeat.o(146284);
  }
  
  public int getLayoutId()
  {
    return a.d.QEV;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146280);
    super.initView();
    if (this.QFq == null)
    {
      Log.e("WelabAppInfoUI", "info is null");
      AppMethodBeat.o(146280);
      return;
    }
    setMMTitleVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.clearFlags(201326592);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(getResources().getColor(a.a.QEG));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(a.a.QEG));
    }
    setBackBtn(new WelabAppInfoUI.1(this));
    this.QFt = ((WelabRoundCornerImageView)findViewById(a.c.app_img));
    this.titleTv = ((TextView)findViewById(a.c.title));
    this.GZI = ((TextView)findViewById(a.c.summary));
    this.QFu = ((RecyclerView)findViewById(a.c.QEK));
    this.QFv = findViewById(a.c.QEI);
    this.wNZ = ((Button)findViewById(a.c.open_btn));
    this.QFw = findViewById(a.c.QEJ);
    this.wrR = ((MMSwitchBtn)findViewById(a.c.checkbox));
    this.rbA = ((TextView)findViewById(a.c.switch_desc));
    this.QFx = findViewById(a.c.QEQ);
    this.QFy = findViewById(a.c.online_view_container);
    this.QFu.setLayoutManager(new LinearLayoutManager(0, false));
    this.QFu.setOverScrollMode(2);
    this.QFz = new a();
    this.QFu.setAdapter(this.QFz);
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
      this.appid = paramBundle.getStringExtra("para_appid");
      this.QFq = com.tencent.mm.plugin.welab.b.hcS().bnz(this.appid);
      this.QFr = this.QFq.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.QFs = bool;
      initView();
      e.C(this.appid, 2, this.QFs);
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
    if (this.QFr != this.QFq.field_Switch)
    {
      Log.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.b.hcS().QFd.update(this.QFq, new String[0])), Integer.valueOf(this.QFr), Integer.valueOf(this.QFq.field_Switch) });
      this.QFr = this.QFq.field_Switch;
      localObject = new cps();
      cpr localcpr = new cpr();
      if (!this.QFq.hdc()) {
        break label268;
      }
      localcpr.TwX = i;
      localcpr.TwY = this.QFq.field_LabsAppId;
      if (this.QFq.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localcpr.RXp = i;
      ((cps)localObject).jmy.add(localcpr);
      localObject = new k.a(207, (com.tencent.mm.cd.a)localObject);
      ((n)h.ae(n.class)).bbK().d((k.b)localObject);
      localObject = this.appid;
      if (this.QFq.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      e.C((String)localObject, i, this.QFs);
      if (this.QFq.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.QFq);
        com.tencent.mm.plugin.welab.b.hcS();
        com.tencent.mm.plugin.welab.b.jf((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = Util.safeParseInt(this.QFq.field_expId);
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
    if ((this.QFq.hdb()) && (this.QFq.field_Type == 1))
    {
      this.QFv.setVisibility(0);
      this.rbA.setText(getResources().getString(a.e.QFa) + this.QFq.bnH("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.wrR.setEnabled(true);
      if (this.QFq.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(hde(), true).commit();
        this.wrR.setCheck(true);
        this.wrR.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(146271);
            if (WelabAppInfoUI.a(WelabAppInfoUI.this).field_Switch == 2)
            {
              WelabAppInfoUI.a(WelabAppInfoUI.this).field_Switch = 1;
              AppMethodBeat.o(146271);
              return;
            }
            if (WelabAppInfoUI.a(WelabAppInfoUI.this).field_Switch == 1) {
              WelabAppInfoUI.a(WelabAppInfoUI.this).field_Switch = 2;
            }
            AppMethodBeat.o(146271);
          }
        });
        label175:
        if (!this.QFq.hdb()) {
          break label454;
        }
        this.wNZ.setText(getResources().getString(a.e.QEY) + this.QFq.bnH("field_Title"));
        if (this.QFq.field_Type == 1) {
          break label454;
        }
        this.wNZ.setVisibility(0);
        this.wNZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            Log.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.b.hcS();
            localObject = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramAnonymousView.QFe.get(str);
            if (localb != null)
            {
              Log.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.m((Activity)localObject, str);
            }
            for (;;)
            {
              e.C(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146272);
              return;
              Log.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.bnz(str).field_Type == 2)
              {
                if (paramAnonymousView.QFf != null) {
                  paramAnonymousView.QFf.m((Activity)localObject, str);
                } else {
                  Log.e("WelabMgr", "defaultWeAppOpener is null!");
                }
              }
              else {
                Log.e("WelabMgr", "can not find opener for ".concat(String.valueOf(str)));
              }
            }
          }
        });
        label262:
        localObject = this.titleTv;
        com.tencent.mm.plugin.welab.b.hcS();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.b.a(this.QFq));
        this.GZI.setText(this.QFq.bnH("field_Introduce"));
        if (!this.QFq.hdb()) {
          break label466;
        }
        this.QFw.setVisibility(0);
        this.QFw.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.QFq.hdb()) {
          break label478;
        }
        this.QFx.setVisibility(8);
        this.QFy.setVisibility(0);
      }
    }
    for (;;)
    {
      hdf();
      this.QFt.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.ay.a.a.bms();
      com.tencent.mm.plugin.welab.b.hcS();
      ((com.tencent.mm.ay.a.a)localObject).a(com.tencent.mm.plugin.welab.b.b(this.QFq), this.QFt, com.tencent.mm.plugin.welab.b.hcS().PCP);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(hde(), false).commit();
      this.wrR.setCheck(false);
      break;
      this.QFv.setVisibility(8);
      break label175;
      label454:
      this.wNZ.setVisibility(8);
      break label262;
      label466:
      this.QFw.setVisibility(8);
      break label332;
      label478:
      this.QFx.setVisibility(0);
      this.QFy.setVisibility(8);
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
    public List<String> tYs;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.tYs.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView QFC;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */