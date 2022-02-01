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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
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
  private com.tencent.mm.plugin.welab.d.a.a BBS;
  private int BBT;
  private boolean BBU;
  private WelabRoundCornerImageView BBV;
  private RecyclerView BBW;
  private View BBX;
  private View BBY;
  private View BBZ;
  private View BCa;
  private a BCb;
  private View.OnClickListener BCc;
  private String dlB;
  private TextView lFe;
  private Button qho;
  private MMSwitchBtn sLH;
  private TextView titleTv;
  private TextView uCm;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.BCc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146274);
        Object localObject = paramAnonymousView.getTag().toString();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("nowUrl", (String)localObject);
        paramAnonymousView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(WelabAppInfoUI.this).getAdapter()).nWL.toArray(new String[0]));
        localObject = WelabAppInfoUI.this;
        Intent localIntent = new Intent();
        localIntent.putExtras(paramAnonymousView.getExtras());
        if (paramAnonymousView.getFlags() != 0) {
          localIntent.addFlags(paramAnonymousView.getFlags());
        }
        com.tencent.mm.bs.d.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
        AppMethodBeat.o(146274);
      }
    };
    AppMethodBeat.o(146278);
  }
  
  private String eso()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.BBS.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void esp()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.BBS.aze("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.BBS.aze("field_ImgUrl");
    }
    localObject1 = f.ayZ((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.BBW.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.BBW.setVisibility(0);
    this.BCb.nWL = ((List)localObject1);
    this.BCb.aql.notifyChanged();
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
    if (this.BBS == null)
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
    this.BBV = ((WelabRoundCornerImageView)findViewById(2131296854));
    this.titleTv = ((TextView)findViewById(2131305902));
    this.uCm = ((TextView)findViewById(2131305546));
    this.BBW = ((RecyclerView)findViewById(2131300988));
    this.BBX = findViewById(2131296876);
    this.qho = ((Button)findViewById(2131303020));
    this.BBY = findViewById(2131299888);
    this.sLH = ((MMSwitchBtn)findViewById(2131298255));
    this.lFe = ((TextView)findViewById(2131305579));
    this.BBZ = findViewById(2131305243);
    this.BCa = findViewById(2131303015);
    this.BBW.setLayoutManager(new LinearLayoutManager(0));
    this.BBW.setOverScrollMode(2);
    this.BCb = new a();
    this.BBW.setAdapter(this.BCb);
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
      this.dlB = paramBundle.getStringExtra("para_appid");
      this.BBS = com.tencent.mm.plugin.welab.a.esb().ayW(this.dlB);
      this.BBT = this.BBS.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.BBU = bool;
      initView();
      com.tencent.mm.plugin.welab.d.v(this.dlB, 2, this.BBU);
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
    if (this.BBT != this.BBS.field_Switch)
    {
      ad.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.esb().BBC.update(this.BBS, new String[0])), Integer.valueOf(this.BBT), Integer.valueOf(this.BBS.field_Switch) });
      this.BBT = this.BBS.field_Switch;
      localObject = new bkr();
      bkq localbkq = new bkq();
      if (!this.BBS.esm()) {
        break label268;
      }
      localbkq.DIr = i;
      localbkq.DIs = this.BBS.field_LabsAppId;
      if (this.BBS.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localbkq.CKO = i;
      ((bkr)localObject).fyl.add(localbkq);
      localObject = new j.a(207, (com.tencent.mm.bx.a)localObject);
      ((k)g.ab(k.class)).apL().c((j.b)localObject);
      localObject = this.dlB;
      if (this.BBS.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      com.tencent.mm.plugin.welab.d.v((String)localObject, i, this.BBU);
      if (this.BBS.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.BBS);
        com.tencent.mm.plugin.welab.a.esb();
        com.tencent.mm.plugin.welab.a.gB((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = bt.aGh(this.BBS.field_expId);
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
    if ((this.BBS.esl()) && (this.BBS.field_Type == 1))
    {
      this.BBX.setVisibility(0);
      this.lFe.setText(getResources().getString(2131766201) + this.BBS.aze("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.sLH.setEnabled(true);
      if (this.BBS.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(eso(), true).commit();
        this.sLH.setCheck(true);
        this.sLH.setSwitchListener(new WelabAppInfoUI.2(this));
        label175:
        if (!this.BBS.esl()) {
          break label454;
        }
        this.qho.setText(getResources().getString(2131766199) + this.BBS.aze("field_Title"));
        if (this.BBS.field_Type == 1) {
          break label454;
        }
        this.qho.setVisibility(0);
        this.qho.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            ad.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.a.esb();
            WelabAppInfoUI localWelabAppInfoUI = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            b localb = (b)paramAnonymousView.BBD.get(str);
            if (localb != null)
            {
              ad.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.i(localWelabAppInfoUI, str);
            }
            for (;;)
            {
              com.tencent.mm.plugin.welab.d.v(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              AppMethodBeat.o(146272);
              return;
              ad.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.ayW(str).field_Type == 2)
              {
                if (paramAnonymousView.BBE != null) {
                  paramAnonymousView.BBE.i(localWelabAppInfoUI, str);
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
        com.tencent.mm.plugin.welab.a.esb();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.BBS));
        this.uCm.setText(this.BBS.aze("field_Introduce"));
        if (!this.BBS.esl()) {
          break label466;
        }
        this.BBY.setVisibility(0);
        this.BBY.setOnClickListener(new WelabAppInfoUI.4(this));
        label332:
        if (!this.BBS.esl()) {
          break label478;
        }
        this.BBZ.setVisibility(8);
        this.BCa.setVisibility(0);
      }
    }
    for (;;)
    {
      esp();
      this.BBV.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.aw.a.a.ayO();
      com.tencent.mm.plugin.welab.a.esb();
      ((com.tencent.mm.aw.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.BBS), this.BBV, com.tencent.mm.plugin.welab.a.esb().AJq);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(eso(), false).commit();
      this.sLH.setCheck(false);
      break;
      this.BBX.setVisibility(8);
      break label175;
      label454:
      this.qho.setVisibility(8);
      break label262;
      label466:
      this.BBY.setVisibility(8);
      break label332;
      label478:
      this.BBZ.setVisibility(0);
      this.BCa.setVisibility(8);
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
    public List<String> nWL;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.nWL.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView BCe;
    
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