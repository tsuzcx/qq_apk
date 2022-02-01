package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.mm.plugin.welab.d.a.a ExV;
  private int ExW;
  private boolean ExX;
  private WelabRoundCornerImageView ExY;
  private RecyclerView ExZ;
  private View Eya;
  private View Eyb;
  private View Eyc;
  private View Eyd;
  private a Eye;
  private View.OnClickListener Eyf;
  private String duW;
  private TextView mHy;
  private MMSwitchBtn rck;
  private Button rzQ;
  private TextView titleTv;
  private TextView wSo;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.Eyf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146274);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = paramAnonymousView.getTag().toString();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("nowUrl", (String)localObject);
        paramAnonymousView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(WelabAppInfoUI.this).getAdapter()).pdB.toArray(new String[0]));
        localObject = WelabAppInfoUI.this;
        Intent localIntent = new Intent();
        localIntent.putExtras(paramAnonymousView.getExtras());
        if (paramAnonymousView.getFlags() != 0) {
          localIntent.addFlags(paramAnonymousView.getFlags());
        }
        com.tencent.mm.bs.d.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(146274);
      }
    };
    AppMethodBeat.o(146278);
  }
  
  private String eWA()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.ExV.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void eWB()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.ExV.aJV("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.ExV.aJV("field_ImgUrl");
    }
    localObject1 = f.aJQ((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.ExZ.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.ExZ.setVisibility(0);
    this.Eye.pdB = ((List)localObject1);
    this.Eye.asY.notifyChanged();
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
    if (this.ExV == null)
    {
      ad.e("WelabAppInfoUI", "info is null");
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
    this.ExY = ((WelabRoundCornerImageView)findViewById(2131296854));
    this.titleTv = ((TextView)findViewById(2131305902));
    this.wSo = ((TextView)findViewById(2131305546));
    this.ExZ = ((RecyclerView)findViewById(2131300988));
    this.Eya = findViewById(2131296876);
    this.rzQ = ((Button)findViewById(2131303020));
    this.Eyb = findViewById(2131299888);
    this.rck = ((MMSwitchBtn)findViewById(2131298255));
    this.mHy = ((TextView)findViewById(2131305579));
    this.Eyc = findViewById(2131305243);
    this.Eyd = findViewById(2131303015);
    this.ExZ.setLayoutManager(new LinearLayoutManager(0));
    this.ExZ.setOverScrollMode(2);
    this.Eye = new a();
    this.ExZ.setAdapter(this.Eye);
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
      this.duW = paramBundle.getStringExtra("para_appid");
      this.ExV = com.tencent.mm.plugin.welab.a.eWo().aJN(this.duW);
      this.ExW = this.ExV.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.ExX = bool;
      initView();
      com.tencent.mm.plugin.welab.d.v(this.duW, 2, this.ExX);
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
    if (this.ExW != this.ExV.field_Switch)
    {
      ad.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.eWo().ExI.update(this.ExV, new String[0])), Integer.valueOf(this.ExW), Integer.valueOf(this.ExV.field_Switch) });
      this.ExW = this.ExV.field_Switch;
      localObject = new bta();
      bsz localbsz = new bsz();
      if (!this.ExV.eWy()) {
        break label268;
      }
      localbsz.GNq = i;
      localbsz.GNr = this.ExV.field_LabsAppId;
      if (this.ExV.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localbsz.FJz = i;
      ((bta)localObject).fVg.add(localbsz);
      localObject = new k.a(207, (com.tencent.mm.bx.a)localObject);
      ((l)g.ab(l.class)).azo().c((k.b)localObject);
      localObject = this.duW;
      if (this.ExV.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      com.tencent.mm.plugin.welab.d.v((String)localObject, i, this.ExX);
      if (this.ExV.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.ExV);
        com.tencent.mm.plugin.welab.a.eWo();
        com.tencent.mm.plugin.welab.a.gY((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = bt.aRe(this.ExV.field_expId);
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
    if ((this.ExV.eWx()) && (this.ExV.field_Type == 1))
    {
      this.Eya.setVisibility(0);
      this.mHy.setText(getResources().getString(2131766201) + this.ExV.aJV("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.rck.setEnabled(true);
      if (this.ExV.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(eWA(), true).commit();
        this.rck.setCheck(true);
        this.rck.setSwitchListener(new WelabAppInfoUI.2(this));
        label175:
        if (!this.ExV.eWx()) {
          break label454;
        }
        this.rzQ.setText(getResources().getString(2131766199) + this.ExV.aJV("field_Title"));
        if (this.ExV.field_Type == 1) {
          break label454;
        }
        this.rzQ.setVisibility(0);
        this.rzQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            ad.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.a.eWo();
            localObject = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramAnonymousView.ExJ.get(str);
            if (localb != null)
            {
              ad.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.i((Activity)localObject, str);
            }
            for (;;)
            {
              com.tencent.mm.plugin.welab.d.v(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146272);
              return;
              ad.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.aJN(str).field_Type == 2)
              {
                if (paramAnonymousView.ExK != null) {
                  paramAnonymousView.ExK.i((Activity)localObject, str);
                } else {
                  ad.e("WelabMgr", "defaultWeAppOpener is null!");
                }
              }
              else {
                ad.e("WelabMgr", "can not find opener for ".concat(String.valueOf(str)));
              }
            }
          }
        });
        label262:
        localObject = this.titleTv;
        com.tencent.mm.plugin.welab.a.eWo();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.ExV));
        this.wSo.setText(this.ExV.aJV("field_Introduce"));
        if (!this.ExV.eWx()) {
          break label466;
        }
        this.Eyb.setVisibility(0);
        this.Eyb.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.ExV.eWx()) {
          break label478;
        }
        this.Eyc.setVisibility(8);
        this.Eyd.setVisibility(0);
      }
    }
    for (;;)
    {
      eWB();
      this.ExY.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.aw.a.a.aIP();
      com.tencent.mm.plugin.welab.a.eWo();
      ((com.tencent.mm.aw.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.ExV), this.ExY, com.tencent.mm.plugin.welab.a.eWo().DEF);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(eWA(), false).commit();
      this.rck.setCheck(false);
      break;
      this.Eya.setVisibility(8);
      break label175;
      label454:
      this.rzQ.setVisibility(8);
      break label262;
      label466:
      this.Eyb.setVisibility(8);
      break label332;
      label478:
      this.Eyc.setVisibility(0);
      this.Eyd.setVisibility(8);
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
    public List<String> pdB;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.pdB.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView Eyh;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */