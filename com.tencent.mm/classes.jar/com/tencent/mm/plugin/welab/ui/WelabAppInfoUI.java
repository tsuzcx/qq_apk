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
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
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
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private TextView BfZ;
  private com.tencent.mm.plugin.welab.d.a.a JGe;
  private int JGf;
  private boolean JGg;
  private WelabRoundCornerImageView JGh;
  private RecyclerView JGi;
  private View JGj;
  private View JGk;
  private View JGl;
  private View JGm;
  private a JGn;
  private View.OnClickListener JGo;
  private String dNI;
  private TextView nZP;
  private MMSwitchBtn sLW;
  private Button thI;
  private TextView titleTv;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.JGo = new WelabAppInfoUI.5(this);
    AppMethodBeat.o(146278);
  }
  
  private String gjr()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.JGe.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void gjs()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.JGe.bbH("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.JGe.bbH("field_ImgUrl");
    }
    localObject1 = e.bbC((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.JGi.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.JGi.setVisibility(0);
    this.JGn.qzs = ((List)localObject1);
    this.JGn.atj.notifyChanged();
    AppMethodBeat.o(146284);
  }
  
  public int getLayoutId()
  {
    return 2131497085;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146280);
    super.initView();
    if (this.JGe == null)
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
      localWindow.setStatusBarColor(getResources().getColor(2131101423));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101423));
    }
    setBackBtn(new WelabAppInfoUI.1(this));
    this.JGh = ((WelabRoundCornerImageView)findViewById(2131296946));
    this.titleTv = ((TextView)findViewById(2131309195));
    this.BfZ = ((TextView)findViewById(2131308767));
    this.JGi = ((RecyclerView)findViewById(2131302629));
    this.JGj = findViewById(2131296969);
    this.thI = ((Button)findViewById(2131305616));
    this.JGk = findViewById(2131300587);
    this.sLW = ((MMSwitchBtn)findViewById(2131298639));
    this.nZP = ((TextView)findViewById(2131308802));
    this.JGl = findViewById(2131308447);
    this.JGm = findViewById(2131305609);
    this.JGi.setLayoutManager(new LinearLayoutManager(0, false));
    this.JGi.setOverScrollMode(2);
    this.JGn = new a();
    this.JGi.setAdapter(this.JGn);
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
      this.dNI = paramBundle.getStringExtra("para_appid");
      this.JGe = com.tencent.mm.plugin.welab.a.gjg().bbz(this.dNI);
      this.JGf = this.JGe.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.JGg = bool;
      initView();
      d.y(this.dNI, 2, this.JGg);
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
    if (this.JGf != this.JGe.field_Switch)
    {
      Log.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.gjg().JFR.update(this.JGe, new String[0])), Integer.valueOf(this.JGf), Integer.valueOf(this.JGe.field_Switch) });
      this.JGf = this.JGe.field_Switch;
      localObject = new cgw();
      cgv localcgv = new cgv();
      if (!this.JGe.gjp()) {
        break label268;
      }
      localcgv.Mmd = i;
      localcgv.Mme = this.JGe.field_LabsAppId;
      if (this.JGe.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localcgv.KWb = i;
      ((cgw)localObject).gCs.add(localcgv);
      localObject = new k.a(207, (com.tencent.mm.bw.a)localObject);
      ((l)g.af(l.class)).aSM().d((k.b)localObject);
      localObject = this.dNI;
      if (this.JGe.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      d.y((String)localObject, i, this.JGg);
      if (this.JGe.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.JGe);
        com.tencent.mm.plugin.welab.a.gjg();
        com.tencent.mm.plugin.welab.a.io((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = Util.safeParseInt(this.JGe.field_expId);
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
    if ((this.JGe.gjo()) && (this.JGe.field_Type == 1))
    {
      this.JGj.setVisibility(0);
      this.nZP.setText(getResources().getString(2131768709) + this.JGe.bbH("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.sLW.setEnabled(true);
      if (this.JGe.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(gjr(), true).commit();
        this.sLW.setCheck(true);
        this.sLW.setSwitchListener(new WelabAppInfoUI.2(this));
        label175:
        if (!this.JGe.gjo()) {
          break label454;
        }
        this.thI.setText(getResources().getString(2131768707) + this.JGe.bbH("field_Title"));
        if (this.JGe.field_Type == 1) {
          break label454;
        }
        this.thI.setVisibility(0);
        this.thI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            Log.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.a.gjg();
            localObject = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramAnonymousView.JFS.get(str);
            if (localb != null)
            {
              Log.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.m((Activity)localObject, str);
            }
            for (;;)
            {
              d.y(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146272);
              return;
              Log.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.bbz(str).field_Type == 2)
              {
                if (paramAnonymousView.JFT != null) {
                  paramAnonymousView.JFT.m((Activity)localObject, str);
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
        com.tencent.mm.plugin.welab.a.gjg();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.JGe));
        this.BfZ.setText(this.JGe.bbH("field_Introduce"));
        if (!this.JGe.gjo()) {
          break label466;
        }
        this.JGk.setVisibility(0);
        this.JGk.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.JGe.gjo()) {
          break label478;
        }
        this.JGl.setVisibility(8);
        this.JGm.setVisibility(0);
      }
    }
    for (;;)
    {
      gjs();
      this.JGh.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.av.a.a.bdb();
      com.tencent.mm.plugin.welab.a.gjg();
      ((com.tencent.mm.av.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.JGe), this.JGh, com.tencent.mm.plugin.welab.a.gjg().IIu);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(gjr(), false).commit();
      this.sLW.setCheck(false);
      break;
      this.JGj.setVisibility(8);
      break label175;
      label454:
      this.thI.setVisibility(8);
      break label262;
      label466:
      this.JGk.setVisibility(8);
      break label332;
      label478:
      this.JGl.setVisibility(0);
      this.JGm.setVisibility(8);
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
    public List<String> qzs;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.qzs.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView JGq;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */