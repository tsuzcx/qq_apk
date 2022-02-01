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
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WelabAppInfoUI
  extends MMActivity
{
  private com.tencent.mm.plugin.welab.d.a.a CTY;
  private int CTZ;
  private boolean CUa;
  private WelabRoundCornerImageView CUb;
  private RecyclerView CUc;
  private View CUd;
  private View CUe;
  private View CUf;
  private View CUg;
  private a CUh;
  private View.OnClickListener CUi;
  private String djj;
  private TextView mgY;
  private Button qPQ;
  private MMSwitchBtn tTm;
  private TextView titleTv;
  private TextView vLf;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.CUi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146274);
        Object localObject = paramAnonymousView.getTag().toString();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("nowUrl", (String)localObject);
        paramAnonymousView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(WelabAppInfoUI.this).getAdapter()).oAg.toArray(new String[0]));
        localObject = WelabAppInfoUI.this;
        Intent localIntent = new Intent();
        localIntent.putExtras(paramAnonymousView.getExtras());
        if (paramAnonymousView.getFlags() != 0) {
          localIntent.addFlags(paramAnonymousView.getFlags());
        }
        com.tencent.mm.br.d.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
        AppMethodBeat.o(146274);
      }
    };
    AppMethodBeat.o(146278);
  }
  
  private String eHH()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.CTY.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void eHI()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.CTY.aEv("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.CTY.aEv("field_ImgUrl");
    }
    localObject1 = f.aEq((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.CUc.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.CUc.setVisibility(0);
    this.CUh.oAg = ((List)localObject1);
    this.CUh.arg.notifyChanged();
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
    if (this.CTY == null)
    {
      ac.e("WelabAppInfoUI", "info is null");
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
    this.CUb = ((WelabRoundCornerImageView)findViewById(2131296854));
    this.titleTv = ((TextView)findViewById(2131305902));
    this.vLf = ((TextView)findViewById(2131305546));
    this.CUc = ((RecyclerView)findViewById(2131300988));
    this.CUd = findViewById(2131296876);
    this.qPQ = ((Button)findViewById(2131303020));
    this.CUe = findViewById(2131299888);
    this.tTm = ((MMSwitchBtn)findViewById(2131298255));
    this.mgY = ((TextView)findViewById(2131305579));
    this.CUf = findViewById(2131305243);
    this.CUg = findViewById(2131303015);
    this.CUc.setLayoutManager(new LinearLayoutManager(0));
    this.CUc.setOverScrollMode(2);
    this.CUh = new a();
    this.CUc.setAdapter(this.CUh);
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
      this.djj = paramBundle.getStringExtra("para_appid");
      this.CTY = com.tencent.mm.plugin.welab.a.eHv().aEn(this.djj);
      this.CTZ = this.CTY.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.CUa = bool;
      initView();
      com.tencent.mm.plugin.welab.d.v(this.djj, 2, this.CUa);
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
    if (this.CTZ != this.CTY.field_Switch)
    {
      ac.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.a.eHv().CTI.update(this.CTY, new String[0])), Integer.valueOf(this.CTZ), Integer.valueOf(this.CTY.field_Switch) });
      this.CTZ = this.CTY.field_Switch;
      localObject = new bon();
      bom localbom = new bom();
      if (!this.CTY.eHF()) {
        break label268;
      }
      localbom.FdM = i;
      localbom.FdN = this.CTY.field_LabsAppId;
      if (this.CTY.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localbom.Edq = i;
      ((bon)localObject).fBS.add(localbom);
      localObject = new j.a(207, (com.tencent.mm.bw.a)localObject);
      ((k)g.ab(k.class)).awA().c((j.b)localObject);
      localObject = this.djj;
      if (this.CTY.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      com.tencent.mm.plugin.welab.d.v((String)localObject, i, this.CUa);
      if (this.CTY.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.CTY);
        com.tencent.mm.plugin.welab.a.eHv();
        com.tencent.mm.plugin.welab.a.gM((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = bs.aLy(this.CTY.field_expId);
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
    if ((this.CTY.eHE()) && (this.CTY.field_Type == 1))
    {
      this.CUd.setVisibility(0);
      this.mgY.setText(getResources().getString(2131766201) + this.CTY.aEv("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.tTm.setEnabled(true);
      if (this.CTY.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(eHH(), true).commit();
        this.tTm.setCheck(true);
        this.tTm.setSwitchListener(new MMSwitchBtn.a()
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
        if (!this.CTY.eHE()) {
          break label454;
        }
        this.qPQ.setText(getResources().getString(2131766199) + this.CTY.aEv("field_Title"));
        if (this.CTY.field_Type == 1) {
          break label454;
        }
        this.qPQ.setVisibility(0);
        this.qPQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            ac.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.a.eHv();
            WelabAppInfoUI localWelabAppInfoUI = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            b localb = (b)paramAnonymousView.CTJ.get(str);
            if (localb != null)
            {
              ac.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.i(localWelabAppInfoUI, str);
            }
            for (;;)
            {
              com.tencent.mm.plugin.welab.d.v(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              AppMethodBeat.o(146272);
              return;
              ac.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.aEn(str).field_Type == 2)
              {
                if (paramAnonymousView.CTK != null) {
                  paramAnonymousView.CTK.i(localWelabAppInfoUI, str);
                } else {
                  ac.e("WelabMgr", "defaultWeAppOpener is null!");
                }
              }
              else {
                ac.e("WelabMgr", "can not find opener for ".concat(String.valueOf(str)));
              }
            }
          }
        });
        label262:
        localObject = this.titleTv;
        com.tencent.mm.plugin.welab.a.eHv();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.a.a(this.CTY));
        this.vLf.setText(this.CTY.aEv("field_Introduce"));
        if (!this.CTY.eHE()) {
          break label466;
        }
        this.CUe.setVisibility(0);
        this.CUe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146273);
            try
            {
              g.agP();
              int i = com.tencent.mm.kernel.a.getUin();
              paramAnonymousView = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
              Object localObject = URLEncoder.encode(bs.eWc(), "utf-8");
              String str1 = URLEncoder.encode(q.cF(true), "utf-8");
              String str2 = URLEncoder.encode(com.tencent.mm.protocal.d.DHW, "utf-8");
              String str3 = URLEncoder.encode(com.tencent.mm.protocal.d.DHX, "utf-8");
              String str4 = URLEncoder.encode(com.tencent.mm.protocal.d.DHY, "utf-8");
              g.agP();
              String str5 = URLEncoder.encode(com.tencent.mm.kernel.a.agc(), "utf-8");
              String str6 = URLEncoder.encode(bs.iZ(ai.getContext()), "utf-8");
              paramAnonymousView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramAnonymousView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
              if (bs.isNullOrNil("")) {}
              for (i = 0;; i = 1)
              {
                paramAnonymousView = i;
                paramAnonymousView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(WelabAppInfoUI.this).field_expId).append("|").append(WelabAppInfoUI.b(WelabAppInfoUI.this)).toString()) + "&version=" + com.tencent.mm.protocal.d.DIc + "&lang=" + ab.iC(ai.getContext()) + "&" + bs.nullAsNil("") + paramAnonymousView;
                paramAnonymousView = paramAnonymousView + "#/comment/4134";
                localObject = new Intent();
                ((Intent)localObject).putExtra("showShare", false);
                ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject).putExtra("title", "意见反馈");
                ((Intent)localObject).putExtra("neverGetA8Key", true);
                ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
                ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
                com.tencent.mm.br.d.b(WelabAppInfoUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                AppMethodBeat.o(146273);
                return;
              }
              return;
            }
            catch (UnsupportedEncodingException paramAnonymousView)
            {
              ac.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramAnonymousView.getMessage() });
              AppMethodBeat.o(146273);
            }
          }
        });
        label332:
        if (!this.CTY.eHE()) {
          break label478;
        }
        this.CUf.setVisibility(8);
        this.CUg.setVisibility(0);
      }
    }
    for (;;)
    {
      eHI();
      this.CUb.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.av.a.a.aFG();
      com.tencent.mm.plugin.welab.a.eHv();
      ((com.tencent.mm.av.a.a)localObject).a(com.tencent.mm.plugin.welab.a.b(this.CTY), this.CUb, com.tencent.mm.plugin.welab.a.eHv().CbH);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(eHH(), false).commit();
      this.tTm.setCheck(false);
      break;
      this.CUd.setVisibility(8);
      break label175;
      label454:
      this.qPQ.setVisibility(8);
      break label262;
      label466:
      this.CUe.setVisibility(8);
      break label332;
      label478:
      this.CUf.setVisibility(0);
      this.CUg.setVisibility(8);
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
    public List<String> oAg;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.oAg.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    public ImageView CUk;
    
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