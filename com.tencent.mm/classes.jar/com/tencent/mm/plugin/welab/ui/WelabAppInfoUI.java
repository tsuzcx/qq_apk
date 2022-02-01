package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
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
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
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
  private Button AkB;
  private TextView MXN;
  private com.tencent.mm.plugin.welab.d.a.a XyO;
  private int XyP;
  private boolean XyQ;
  private WelabRoundCornerImageView XyR;
  private RecyclerView XyS;
  private View XyT;
  private View XyU;
  private View XyV;
  private View XyW;
  private a XyX;
  private View.OnClickListener XyY;
  private String appid;
  private TextView titleTv;
  private TextView uhp;
  private MMSwitchBtn zNX;
  
  public WelabAppInfoUI()
  {
    AppMethodBeat.i(146278);
    this.XyY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146274);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = paramAnonymousView.getTag().toString();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("nowUrl", (String)localObject);
        paramAnonymousView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(WelabAppInfoUI.this).getAdapter()).bMf.toArray(new String[0]));
        localObject = WelabAppInfoUI.this;
        Intent localIntent = new Intent();
        localIntent.putExtras(paramAnonymousView.getExtras());
        if (paramAnonymousView.getFlags() != 0) {
          localIntent.addFlags(paramAnonymousView.getFlags());
        }
        c.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(146274);
      }
    };
    AppMethodBeat.o(146278);
  }
  
  private String iDL()
  {
    AppMethodBeat.i(146283);
    String str = "switch_" + this.XyO.field_LabsAppId;
    AppMethodBeat.o(146283);
    return str;
  }
  
  private void iDM()
  {
    AppMethodBeat.i(146284);
    Object localObject2 = this.XyO.bnv("field_ImgUrl_android");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.XyO.bnv("field_ImgUrl");
    }
    localObject1 = f.bnq((String)localObject1);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (TextUtils.isEmpty((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).isEmpty())
    {
      this.XyS.setVisibility(8);
      AppMethodBeat.o(146284);
      return;
    }
    this.XyS.setVisibility(0);
    this.XyX.bMf = ((List)localObject1);
    this.XyX.bZE.notifyChanged();
    AppMethodBeat.o(146284);
  }
  
  public int getLayoutId()
  {
    return a.d.Xyt;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146280);
    super.initView();
    if (this.XyO == null)
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
      localWindow.setStatusBarColor(getResources().getColor(a.a.Xye));
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(a.a.Xye));
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
    this.XyR = ((WelabRoundCornerImageView)findViewById(a.c.app_img));
    this.titleTv = ((TextView)findViewById(a.c.title));
    this.MXN = ((TextView)findViewById(a.c.summary));
    this.XyS = ((RecyclerView)findViewById(a.c.Xyi));
    this.XyT = findViewById(a.c.Xyg);
    this.AkB = ((Button)findViewById(a.c.open_btn));
    this.XyU = findViewById(a.c.Xyh);
    this.zNX = ((MMSwitchBtn)findViewById(a.c.checkbox));
    this.uhp = ((TextView)findViewById(a.c.switch_desc));
    this.XyV = findViewById(a.c.Xyo);
    this.XyW = findViewById(a.c.online_view_container);
    this.XyS.setLayoutManager(new LinearLayoutManager(0, false));
    this.XyS.setOverScrollMode(2);
    this.XyX = new a();
    this.XyS.setAdapter(this.XyX);
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
      this.XyO = com.tencent.mm.plugin.welab.b.iDA().bnn(this.appid);
      this.XyP = this.XyO.field_Switch;
      if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
        break label110;
      }
    }
    for (;;)
    {
      this.XyQ = bool;
      initView();
      e.E(this.appid, 2, this.XyQ);
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
    if (this.XyP != this.XyO.field_Switch)
    {
      Log.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.welab.b.iDA().XyB.update(this.XyO, new String[0])), Integer.valueOf(this.XyP), Integer.valueOf(this.XyO.field_Switch) });
      this.XyP = this.XyO.field_Switch;
      localObject = new dgm();
      dgl localdgl = new dgl();
      if (!this.XyO.iDJ()) {
        break label268;
      }
      localdgl.aaLC = i;
      localdgl.aaLD = this.XyO.field_LabsAppId;
      if (this.XyO.field_Switch != 2) {
        break label282;
      }
      i = 1;
      label150:
      localdgl.YVh = i;
      ((dgm)localObject).lPK.add(localdgl);
      localObject = new k.a(207, (com.tencent.mm.bx.a)localObject);
      ((n)h.ax(n.class)).bzz().d((k.b)localObject);
      localObject = this.appid;
      if (this.XyO.field_Switch != 2) {
        break label287;
      }
    }
    label268:
    label282:
    label287:
    for (i = 4;; i = 5)
    {
      e.E((String)localObject, i, this.XyQ);
      if (this.XyO.field_Switch == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.XyO);
        com.tencent.mm.plugin.welab.b.iDA();
        com.tencent.mm.plugin.welab.b.mo((List)localObject);
      }
      AppMethodBeat.o(146281);
      return;
      i = Util.safeParseInt(this.XyO.field_expId);
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
    if ((this.XyO.MX()) && (this.XyO.field_Type == 1))
    {
      this.XyT.setVisibility(0);
      this.uhp.setText(getResources().getString(a.e.Xyy) + this.XyO.bnv("field_Title"));
      localObject = getSharedPreferences(getPackageName() + "_preferences", 0);
      this.zNX.setEnabled(true);
      if (this.XyO.field_Switch == 2)
      {
        ((SharedPreferences)localObject).edit().putBoolean(iDL(), true).commit();
        this.zNX.setCheck(true);
        this.zNX.setSwitchListener(new MMSwitchBtn.a()
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
        if (!this.XyO.MX()) {
          break label454;
        }
        this.AkB.setText(getResources().getString(a.e.Xyw) + this.XyO.bnv("field_Title"));
        if (this.XyO.field_Type == 1) {
          break label454;
        }
        this.AkB.setVisibility(0);
        this.AkB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146272);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            Log.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(WelabAppInfoUI.this));
            paramAnonymousView = com.tencent.mm.plugin.welab.b.iDA();
            localObject = WelabAppInfoUI.this;
            String str = WelabAppInfoUI.b(WelabAppInfoUI.this);
            com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramAnonymousView.XyC.get(str);
            if (localb != null)
            {
              Log.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
              localb.p((Activity)localObject, str);
            }
            for (;;)
            {
              e.E(WelabAppInfoUI.b(WelabAppInfoUI.this), 7, WelabAppInfoUI.c(WelabAppInfoUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146272);
              return;
              Log.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
              if (paramAnonymousView.bnn(str).field_Type == 2)
              {
                if (paramAnonymousView.XyD != null) {
                  paramAnonymousView.XyD.p((Activity)localObject, str);
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
        com.tencent.mm.plugin.welab.b.iDA();
        ((TextView)localObject).setText(com.tencent.mm.plugin.welab.b.a(this.XyO));
        this.MXN.setText(this.XyO.bnv("field_Introduce"));
        if (!this.XyO.MX()) {
          break label466;
        }
        this.XyU.setVisibility(0);
        this.XyU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(146273);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            for (;;)
            {
              try
              {
                h.baC();
                i = com.tencent.mm.kernel.b.getUin();
                paramAnonymousView = URLEncoder.encode(d.Yxf, "utf-8");
                localObject = URLEncoder.encode(Util.getTimeZoneOffset(), "utf-8");
                String str1 = URLEncoder.encode(q.eD(true), "utf-8");
                String str2 = URLEncoder.encode(d.Yxa, "utf-8");
                String str3 = URLEncoder.encode(d.Yxb, "utf-8");
                String str4 = URLEncoder.encode(d.Yxc, "utf-8");
                h.baC();
                String str5 = URLEncoder.encode(com.tencent.mm.kernel.b.aZR(), "utf-8");
                String str6 = URLEncoder.encode(Util.getSourceeMd5(MMApplicationContext.getContext()), "utf-8");
                paramAnonymousView = new StringBuilder("&uin=").append(i).append("&deviceName=").append(paramAnonymousView).append("&timeZone=").append((String)localObject).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append(str5).append("&signature=").append(str6).append("&scene=");
                if (!Util.isNullOrNil("")) {
                  continue;
                }
                i = 0;
                paramAnonymousView = i;
                localObject = "https://" + WeChatHosts.domainString(a.e.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index";
                paramAnonymousView = (String)localObject + "&from=" + URLEncoder.encode(new StringBuilder().append(WelabAppInfoUI.a(WelabAppInfoUI.this).field_expId).append("|").append(WelabAppInfoUI.b(WelabAppInfoUI.this)).toString()) + "&version=" + d.Yxh + "&lang=" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) + "&" + Util.nullAsNil("") + paramAnonymousView;
                paramAnonymousView = paramAnonymousView + "#/comment/4134";
                localObject = new Intent();
                ((Intent)localObject).putExtra("showShare", false);
                ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject).putExtra("title", "意见反馈");
                ((Intent)localObject).putExtra("neverGetA8Key", true);
                ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
                ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
                c.b(WelabAppInfoUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              }
              catch (UnsupportedEncodingException paramAnonymousView)
              {
                int i;
                Log.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramAnonymousView.getMessage() });
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(146273);
              return;
              i = 1;
            }
          }
        });
        label332:
        if (!this.XyO.MX()) {
          break label478;
        }
        this.XyV.setVisibility(8);
        this.XyW.setVisibility(0);
      }
    }
    for (;;)
    {
      iDM();
      this.XyR.setCornerRadiusPercent(0.5F);
      localObject = com.tencent.mm.modelimage.loader.a.bKl();
      com.tencent.mm.plugin.welab.b.iDA();
      ((com.tencent.mm.modelimage.loader.a)localObject).a(com.tencent.mm.plugin.welab.b.b(this.XyO), this.XyR, com.tencent.mm.plugin.welab.b.iDA().Wtu);
      AppMethodBeat.o(146282);
      return;
      ((SharedPreferences)localObject).edit().putBoolean(iDL(), false).commit();
      this.zNX.setCheck(false);
      break;
      this.XyT.setVisibility(8);
      break label175;
      label454:
      this.AkB.setVisibility(8);
      break label262;
      label466:
      this.XyU.setVisibility(8);
      break label332;
      label478:
      this.XyV.setVisibility(0);
      this.XyW.setVisibility(8);
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
    public List<String> bMf;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(146275);
      int i = this.bMf.size();
      AppMethodBeat.o(146275);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public ImageView Xza;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI
 * JD-Core Version:    0.7.0.1
 */