package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.kz;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Options;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai.a;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static int WTM;
  private com.tencent.mm.ui.widget.b.a Psk;
  private int VaW;
  private boolean WLY;
  private SendAuth.Req WTK;
  private int WTL;
  private MTimerHandler WTN;
  private a WTO;
  private b WTP;
  private boolean WTQ;
  private aj WTR;
  private boolean WTS;
  private String WTT;
  public LinkedList<String> WTm;
  private boolean WTy;
  private String idu;
  private w lKp;
  private String mAppId;
  private SendAuth.Options options;
  private long startTime;
  private u.i vGU;
  private int x_down;
  private int y_down;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.WTS = true;
    this.WTy = false;
    this.VaW = 2;
    this.WTm = new LinkedList();
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(79738);
        SDKOAuthUI.s(SDKOAuthUI.this);
        AppMethodBeat.o(79738);
      }
    };
    AppMethodBeat.o(79760);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, final eux parameux)
  {
    AppMethodBeat.i(79766);
    Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ddd();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      boolean bool = parameux.abaY;
      if (parameux.abxy != null) {}
      for (paramInt1 = parameux.abxy.Op.length;; paramInt1 = 0)
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b, bufferSize=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        this.WTT = parameux.rHc;
        this.WTR.WMa = parameux.abxy;
        if ((!parameux.abaU) && (!parameux.abaV)) {
          break;
        }
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.oop, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void onPermissionReturn(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.g(SDKOAuthUI.this).a(ai.a.a(parameux), SDKOAuthUI.e(SDKOAuthUI.this).scope, SDKOAuthUI.f(SDKOAuthUI.this));
            com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (parameux.abaY)
      {
        if (aj.b(parameux))
        {
          Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  use New OauthPage");
          paramString = (TextView)findViewById(c.f.auth_content);
          localObject1 = parameux.abaS.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (dve)((Iterator)localObject1).next();
            if (aj.a((dve)localObject2)) {
              paramString.setText(((dve)localObject2).desc);
            }
          }
          paramString = paramString.getPaint();
          paramString.setStyle(Paint.Style.FILL_AND_STROKE);
          paramString.setStrokeWidth(0.8F);
          paramString = (TextView)findViewById(c.f.choose_user_info_title_tv);
          localObject1 = (TextView)findViewById(c.f.create_avatar_tv);
          if (parameux.abba != null)
          {
            if (!Util.isNullOrNil(parameux.abba.abbd)) {
              paramString.setText(parameux.abba.abbd);
            }
            if (!Util.isNullOrNil(parameux.abba.abbe)) {
              ((TextView)localObject1).setText(parameux.abba.abbe);
            }
          }
          paramString = (TextView)findViewById(c.f.auth_content_detail);
          if (!Util.isNullOrNil(parameux.abxJ))
          {
            paramString.setVisibility(0);
            paramString.setText(parameux.abxJ);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(c.f.new_app_icon_iv);
            localObject1 = (TextView)findViewById(c.f.new_app_name_tv);
            localObject2 = new c.a();
            ((c.a)localObject2).oKB = c.h.native_oauth_default_head_img;
            ((c.a)localObject2).oKI = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
            ((c.a)localObject2).nrc = true;
            r.bKe().a(parameux.abaT, paramString, ((c.a)localObject2).bKx());
            ((TextView)localObject1).setText(parameux.nSt);
            ((TextView)localObject1).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            ((TextView)localObject1).getPaint().setStrokeWidth(0.8F);
            localObject2 = (Button)findViewById(c.f.login_btn_agree_new);
            Button localButton = (Button)findViewById(c.f.login_btn_disagree_new);
            localObject1 = aj.f("snsapi_userinfo", parameux.abaS);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = aj.f("snsapi_login", parameux.abaS);
            }
            localObject1 = paramString;
            if (paramString == null) {
              localObject1 = aj.f("group_sns_login", parameux.abaS);
            }
            ((Button)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79742);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.SdkOAuthUI", "fillNewOauthPage click agreeBtn");
                SDKOAuthUI.a(SDKOAuthUI.this, this.WTY, parameux, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79742);
              }
            });
            localButton.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.SdkOAuthUI", "fillNewOauthPage click disagreeBtn");
                SDKOAuthUI.a(SDKOAuthUI.this, this.WTY, parameux, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79743);
              }
            });
            WTM = parameux.rGZ;
            this.Psk = new com.tencent.mm.ui.widget.b.a(this);
            this.WTP = new b(this, parameux.abaX, parameux.rHa);
            ixu();
            paramString = (ListView)findViewById(c.f.avatar_list);
            paramString.setAdapter(this.WTP);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousAdapterView);
                localb.cH(paramAnonymousView);
                localb.sc(paramAnonymousInt);
                localb.hB(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
                SDKOAuthUI.b.a(SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.i(SDKOAuthUI.this).aun(paramAnonymousInt).id);
                SDKOAuthUI.i(SDKOAuthUI.this).notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(79744);
              }
            });
            paramString.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(79745);
                switch (paramAnonymousMotionEvent.getAction())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(79745);
                  return false;
                  SDKOAuthUI.b(SDKOAuthUI.this, (int)paramAnonymousMotionEvent.getRawX());
                  SDKOAuthUI.c(SDKOAuthUI.this, (int)paramAnonymousMotionEvent.getRawY());
                }
              }
            });
            paramString.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
            {
              public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79746);
                SDKOAuthUI.d(SDKOAuthUI.this, paramAnonymousInt);
                int i = SDKOAuthUI.i(SDKOAuthUI.this).aun(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.m(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this), SDKOAuthUI.l(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(c.f.create_avatar).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79747);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.SdkOAuthUI", "fillNewOauthPage click CreateAvatar");
                paramAnonymousView = new Intent(SDKOAuthUI.this, CreateAvatarUI.class);
                paramAnonymousView.putExtra("0", SDKOAuthUI.a(SDKOAuthUI.this));
                paramAnonymousView.putExtra("default_fileid", SDKOAuthUI.n(SDKOAuthUI.this));
                if ((parameux.abba != null) && (!Util.isNullOrNil(parameux.abba.abbe))) {
                  paramAnonymousView.putExtra("title", parameux.abba.abbe);
                }
                SDKOAuthUI.this.startActivityForResult(paramAnonymousView, 6);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79747);
              }
            });
            this.WTQ = parameux.rGY;
            if (parameux.rGY) {
              findViewById(c.f.create_avatar_entry).setVisibility(8);
            }
            findViewById(c.f.new_root).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (aj.f("snsapi_friend", parameux.abaS) != null)
        {
          Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  has scope SCOPE_FRIEND");
          a(parameux, SDKOAuthFriendUI.class, "snsapi_friend");
          aj.bD(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (aj.f("snsapi_wxaapp_info", parameux.abaS) != null)
        {
          Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  has scope SCOPE_GET_WXAAPP_INFO");
          a(parameux, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          aj.bD(this);
          AppMethodBeat.o(79766);
          return;
        }
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  has other scope");
        a(parameux, SDKOAuthOtherUI.class, "");
        aj.bD(this);
        AppMethodBeat.o(79766);
        return;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  use old OauthPage");
      this.WTS = false;
      paramString = (ImageView)findViewById(c.f.app_icon_iv);
      Object localObject1 = (TextView)findViewById(c.f.app_name_tv);
      Object localObject2 = new c.a();
      ((c.a)localObject2).oKB = c.h.native_oauth_default_head_img;
      r.bKe().a(parameux.abaT, paramString, ((c.a)localObject2).bKx());
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, parameux.nSt, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(c.f.auth_content_list);
      this.WTO = new a(this, parameux.abaS);
      paramString.setAdapter(this.WTO);
      ((Button)findViewById(c.f.login_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          com.tencent.mm.model.gdpr.c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.oop, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void onPermissionReturn(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.WTV.abaW)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.blF(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.h(SDKOAuthUI.this).ixw());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.g(SDKOAuthUI.this).a(ai.a.a(SDKOAuthUI.9.this.WTV), SDKOAuthUI.e(SDKOAuthUI.this).scope, SDKOAuthUI.f(SDKOAuthUI.this));
              AppMethodBeat.o(79740);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79741);
        }
      });
      findViewById(c.f.root).setVisibility(0);
      AppMethodBeat.o(79766);
      return;
    }
    if (!atJ(paramInt1))
    {
      Log.e("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  network is not available");
      dL(getString(c.i.wechat_auth_network_failed), true);
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    Log.e("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd  errMsg: %s", new Object[] { paramString });
    com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, 0, 0, paramInt2);
    dL(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(eux parameux, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    Log.i("MicroMsg.SdkOAuthUI", "startScopeActivity  cls:" + paramClass + "  scope:" + paramString);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.WTK != null)
    {
      paramClass.putExtra("1", this.WTK.transaction);
      paramClass.putExtra("4", this.WTK.state);
      paramClass.putExtra("7", this.WTK.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.WTy);
    paramClass.putExtra("auth_raw_url", this.idu);
    paramClass.putExtra("has_selected_scope", this.WTm);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    if ((this.options != null) && (!Util.isNullOrNil(this.options.callbackClassName)))
    {
      paramString = new Bundle();
      this.options.toBundle(paramString);
      paramClass.putExtra("send_auth_option", paramString);
    }
    try
    {
      paramClass.putExtra("2", parameux.toByteArray());
      parameux = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, parameux.aYi(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)parameux.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException parameux)
    {
      for (;;)
      {
        Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(eux parameux, Class<?> paramClass, int paramInt, String paramString)
  {
    AppMethodBeat.i(296450);
    a(parameux, paramClass, paramInt, 0, paramString);
    AppMethodBeat.o(296450);
  }
  
  private void a(eux parameux, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    Log.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    paramClass.putExtra("has_selected_scope", this.WTm);
    if (this.WTK != null)
    {
      paramClass.putExtra("1", this.WTK.transaction);
      paramClass.putExtra("4", this.WTK.state);
      paramClass.putExtra("7", this.WTK.extData);
    }
    paramClass.putExtra("auth_from_scan", this.WTy);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.idu);
    if ((this.options != null) && (!Util.isNullOrNil(this.options.callbackClassName)))
    {
      paramString = new Bundle();
      this.options.toBundle(paramString);
      paramClass.putExtra("send_auth_option", paramString);
    }
    try
    {
      paramClass.putExtra("2", parameux.toByteArray());
      parameux = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, parameux.aYi(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)parameux.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException parameux)
    {
      for (;;)
      {
        Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(79769);
    if (this.WLY)
    {
      Log.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(79769);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.SdkOAuthUI", "doCallback pkg is empty");
      AppMethodBeat.o(79769);
      return;
    }
    this.WLY = true;
    this.WTR.WLY = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    u.bS(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    if ((this.options != null) && (!Util.isNullOrNil(this.options.callbackClassName)))
    {
      Log.i("MicroMsg.SdkOAuthUI", "doCallback options.callbackClassName:" + this.options.callbackClassName + "  options.callbackFlags:" + this.options.callbackFlags);
      paramResp.targetClassName = this.options.callbackClassName;
      paramResp.flags = this.options.callbackFlags;
    }
    Log.i("MicroMsg.SdkOAuthUI", "doCallback pkg:".concat(String.valueOf(paramString)));
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static boolean atJ(int paramInt)
  {
    AppMethodBeat.i(79780);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79780);
      return false;
    }
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79780);
      return false;
    }
    AppMethodBeat.o(79780);
    return true;
  }
  
  private void aum(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    Log.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.WTy)
    {
      localObject = new aa(2, this.idu, null, 0);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.WTK == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = bkl(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.WTK.state;
    if (this.WTO == null) {}
    for (;;)
    {
      localObject = new ac(2, str2, str3, str1, (LinkedList)localObject, this.WTK.extData, this.WTR.WMa);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.WTK.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = "zh_CN";
      ((SendAuth.Resp)localObject).country = "";
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.WTO.ixw();
    }
  }
  
  private static String bkl(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      Log.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void blE(String paramString)
  {
    AppMethodBeat.i(79776);
    k.c(this, paramString, getString(c.i.new_sdk_oauth_login_delavatar_failed), true);
    AppMethodBeat.o(79776);
  }
  
  private void cKs()
  {
    AppMethodBeat.i(79777);
    if ((this.lKp != null) && (!this.lKp.isShowing()))
    {
      this.lKp.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.lKp = k.a(this, getString(c.i.oauth_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79735);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(79735);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79735);
        }
      }
    });
    AppMethodBeat.o(79777);
  }
  
  private void dL(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(79775);
    k.d(this, paramString, getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(79734);
        if (!SDKOAuthUI.o(SDKOAuthUI.this)) {
          SDKOAuthUI.a(SDKOAuthUI.this, paramString);
        }
        if (paramBoolean) {
          SDKOAuthUI.this.finish();
        }
        AppMethodBeat.o(79734);
      }
    });
    AppMethodBeat.o(79775);
  }
  
  private void dN(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = bkl(this.mAppId);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.WTK.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = "zh_CN";
    localResp.country = "";
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private void ddd()
  {
    AppMethodBeat.i(79779);
    if (this.lKp == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.lKp.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private int ixt()
  {
    if (this.WTS) {
      return 2;
    }
    return 1;
  }
  
  private void ixu()
  {
    AppMethodBeat.i(79773);
    if (this.WTQ)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.WTP.getCount() >= WTM)
    {
      findViewById(c.f.create_avatar).setVisibility(8);
      findViewById(c.f.upper_bound_hint).setVisibility(0);
      findViewById(c.f.upper_bound_hint_line).setVisibility(4);
      AppMethodBeat.o(79773);
      return;
    }
    findViewById(c.f.create_avatar).setVisibility(0);
    findViewById(c.f.upper_bound_hint).setVisibility(8);
    findViewById(c.f.upper_bound_hint_line).setVisibility(0);
    AppMethodBeat.o(79773);
  }
  
  private void ixv()
  {
    AppMethodBeat.i(79778);
    ddd();
    this.lKp = k.a(this, getString(c.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79736);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(79736);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79736);
        }
      }
    });
    AppMethodBeat.o(79778);
  }
  
  public final int getLayoutId()
  {
    return c.g.sdk_oauth;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(296786);
    HashSet localHashSet = new HashSet();
    localHashSet.add(h.class);
    AppMethodBeat.o(296786);
    return localHashSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(79774);
    Log.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(79774);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(79774);
      return;
    }
    dvb localdvb = new dvb();
    localdvb.id = paramIntent.getIntExtra("id", -1);
    localdvb.nickname = paramIntent.getStringExtra("nickname");
    localdvb.rHi = paramIntent.getStringExtra("avatarurl");
    localdvb.desc = null;
    if (this.WTP != null)
    {
      paramIntent = this.WTP;
      if ((localdvb.id != -1) && (paramIntent.WUa != null) && (paramIntent.WUa.size() < WTM)) {
        paramIntent.WUa.add(localdvb);
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        b.a(this.WTP, localdvb.id);
        ixu();
        this.WTP.notifyDataSetChanged();
        AppMethodBeat.o(79774);
        return;
      }
    }
    if (this.WTP == null) {}
    for (;;)
    {
      Log.e("MicroMsg.SdkOAuthUI", "onActivityResult mAvatarAdapter == null:%b", new Object[] { Boolean.valueOf(bool) });
      break;
      bool = false;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79761);
    Log.i("MicroMsg.SdkOAuthUI", "onCreate");
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1346, this);
    com.tencent.mm.kernel.h.aZW().a(1388, this);
    com.tencent.mm.kernel.h.aZW().a(2700, this);
    com.tencent.mm.kernel.h.aZW().a(2543, this);
    com.tencent.mm.kernel.h.aZW().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(c.f.leftClose)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296356);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(296356);
      }
    });
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, c.i.account_not_login, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.WLY = false;
    paramBundle = getIntent();
    this.WTy = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    this.options = new SendAuth.Options();
    this.options.fromBundle(paramBundle.getExtras());
    Log.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b  options.callbackClassName:%s, options.callbackFlags:%d", new Object[] { Boolean.valueOf(this.WTy), this.options.callbackClassName, Integer.valueOf(this.options.callbackFlags) });
    if (this.WTy)
    {
      this.VaW = 3;
      this.idu = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.idu;
      Log.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      cKs();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      this.WTR = new aj(this, null, this.idu);
      com.tencent.mm.plugin.webview.k.b.XsD.dQ(3, "");
      AppMethodBeat.o(79761);
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(79761);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (Util.isNullOrNil(this.mAppId))
    {
      Log.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(str1, false, false);
    if ((localObject != null) && (Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      Log.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new kz();
      ((kz)localObject).hMI.appId = str1;
      ((kz)localObject).publish();
    }
    this.WTK = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.k.b.XsD.dQ(2, this.WTK.extData);
    this.WTR = new aj(this, this.mAppId, this.WTK.transaction, this.WTK.state, this.WTK.extData);
    if ((!Util.isNullOrNil(this.WTK.scope)) && (this.WTK.scope.contains("snsapi_wxaapp_info")) && (!this.WTK.scope.equals("snsapi_wxaapp_info")))
    {
      Log.e("MicroMsg.SdkOAuthUI", "init check SCOPE_GET_WXAAPP_INFO fail");
      dN(-1000, String.format(getContext().getResources().getString(c.i.wechat_auth_scope_can_only_authorized_separately), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    Log.e("MicroMsg.SdkOAuthUI", "init success, doSDKOauthAuthorize");
    str1 = this.mAppId;
    localObject = this.WTK.scope;
    String str2 = this.WTK.state;
    String str3 = bkl(this.mAppId);
    Log.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.WTK.extData });
    cKs();
    if (Util.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new ab(str1, (String)localObject, str2, str3, paramBundle, this.WTK.extData);
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = u.cG(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        Log.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
        paramBundle = null;
      }
      else
      {
        paramBundle = com.tencent.mm.b.g.getMessageDigest(paramBundle[0].toByteArray());
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(79785);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(c.i.new_sdk_oauth_login_delavatar));
    AppMethodBeat.o(79785);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79764);
    super.onDestroy();
    Log.i("MicroMsg.SdkOAuthUI", "onDestroy");
    if (this.lKp != null) {
      this.lKp.dismiss();
    }
    if (this.WTN != null) {
      this.WTN.stopTimer();
    }
    com.tencent.mm.kernel.h.aZW().b(1388, this);
    com.tencent.mm.kernel.h.aZW().b(1346, this);
    com.tencent.mm.kernel.h.aZW().b(2700, this);
    com.tencent.mm.kernel.h.aZW().b(2543, this);
    com.tencent.mm.kernel.h.aZW().b(1137, this);
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 0, this.VaW, ixt(), 1, 0);
      aum(-2);
      Log.i("MicroMsg.SdkOAuthUI", "key back click");
      finish();
      AppMethodBeat.o(79765);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(79765);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(79763);
    super.onPause();
    Log.i("MicroMsg.SdkOAuthUI", "onPause");
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    Log.i("MicroMsg.SdkOAuthUI", "onResume");
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramp instanceof ab))
    {
      Log.i("MicroMsg.SdkOAuthUI", "onSceneEnd  NetSceneSDKOauthAuthorize");
      a(paramInt1, paramInt2, paramString, (eux)c.c.b(((ab)paramp).rr.otC));
      com.tencent.mm.plugin.webview.k.b.XsD.bt(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramp instanceof z)) {
        break label910;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onSceneEnd  NetSceneQRCodeOauthAuthorize");
      Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label831;
      }
      localObject = (ejj)c.c.b(((z)paramp).rr.otC);
      this.mAppId = ((ejj)localObject).appid;
      this.WTR.mAppId = ((ejj)localObject).appid;
      if (!((ejj)localObject).abnX) {
        break label655;
      }
      Log.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 1, this.VaW, 0, 0, paramInt2);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      aj.bD(this);
      paramInt1 = 1;
      label213:
      if (paramInt1 == 0) {
        ddd();
      }
      com.tencent.mm.plugin.webview.k.b.XsD.bt(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      ddd();
      AppMethodBeat.o(79784);
      return;
      if ((paramp instanceof ac))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSceneEnd  NetSceneSDKOauthAuthorizeConfirm");
        localObject = this.options;
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.WTN != null) {
          this.WTN.stopTimer();
        }
        ddd();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          euv localeuv = ((ac)paramp).ivg();
          com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 1, this.VaW, ixt(), 1, 0);
          this.WTR.a(ai.a.a(localeuv), this.WTK.scope, (SendAuth.Options)localObject);
          break;
        }
        if (!atJ(paramInt1))
        {
          dL(getString(c.i.wechat_auth_network_failed), false);
          com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, ixt(), 1, paramInt2);
          break;
        }
        dL(paramString, false);
        com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, ixt(), 1, paramInt2);
        break;
      }
      if (!(paramp instanceof j)) {
        break;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onSceneEnd  NetSceneDelAvatar");
      Log.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.WTP.aun(this.WTL).id == b.a(this.WTP)) {
          b.a(this.WTP, this.WTP.aun(0).id);
        }
        localObject = this.WTP;
        int i = this.WTL;
        if (((b)localObject).WUa == null) {}
        for (boolean bool = false;; bool = ((b)localObject).WUa.remove(((b)localObject).aun(i)))
        {
          if (!bool) {
            Log.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          ixu();
          this.WTP.notifyDataSetChanged();
          break;
        }
      }
      if (!atJ(paramInt1))
      {
        blE(getString(c.i.wechat_auth_network_failed));
        break;
      }
      blE(paramString);
      break;
      label655:
      if (localObject == null) {
        paramp = null;
      }
      for (;;)
      {
        a(paramInt1, paramInt2, paramString, paramp);
        paramInt1 = 0;
        break;
        paramp = new eux();
        paramp.BaseResponse = ((ejj)localObject).BaseResponse;
        paramp.abaU = false;
        paramp.abaV = false;
        paramp.abaY = true;
        paramp.abaW = false;
        paramp.abaS = ((ejj)localObject).abaS;
        paramp.nSt = ((ejj)localObject).nSt;
        paramp.abaT = ((ejj)localObject).abaT;
        paramp.ZhF = "";
        paramp.abaX = ((ejj)localObject).abaX;
        paramp.rGY = ((ejj)localObject).rGY;
        paramp.rGZ = ((ejj)localObject).rGZ;
        paramp.rHa = ((ejj)localObject).rHa;
        paramp.rHb = ((ejj)localObject).rHb;
        paramp.rHc = ((ejj)localObject).rHc;
        paramp.abba = ((ejj)localObject).abba;
      }
      label831:
      if (!atJ(paramInt1))
      {
        dL(getString(c.i.wechat_auth_network_failed), true);
        com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, 0, 0, paramInt2);
        paramInt1 = 0;
        break label213;
      }
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, 0, 0, paramInt2);
      dL(paramString, true);
      paramInt1 = 0;
      break label213;
      label910:
      if ((paramp instanceof aa))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSceneEnd  NetSceneQRCodeOauthAuthorizeConfirm");
        Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ddd();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 1, this.VaW, ixt(), 1, 0);
          finish();
        }
        else if (!atJ(paramInt1))
        {
          dL(getString(c.i.wechat_auth_network_failed), false);
          com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, ixt(), 1, paramInt2);
        }
        else
        {
          dL(paramString, false);
          com.tencent.mm.plugin.webview.k.b.XsD.a(this.mAppId, this.startTime, 2, this.VaW, ixt(), 1, paramInt2);
        }
      }
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(296762);
    super.onStart();
    Log.i("MicroMsg.SdkOAuthUI", "onStart");
    AppMethodBeat.o(296762);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(296771);
    super.onStop();
    Log.i("MicroMsg.SdkOAuthUI", "onStop");
    AppMethodBeat.o(296771);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private LinkedList<dve> WTG;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<dve> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.WTG = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private dve aul(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.WTG.size()))
      {
        dve localdve = (dve)this.WTG.get(paramInt);
        AppMethodBeat.o(79752);
        return localdve;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.WTG == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.WTG.size();
      AppMethodBeat.o(79751);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(79753);
      if ((this.WTG == null) || (this.WTG.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final dve localdve = aul(paramInt);
      if (localdve == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(c.g.sdk_authorize_scope_item, null, false);
        paramViewGroup.WTJ = ((ImageView)paramView.findViewById(c.f.app_auth_state));
        paramViewGroup.uBM = ((TextView)paramView.findViewById(c.f.app_auth_desc));
        paramView.setTag(paramViewGroup);
        if (localdve.abbc != 1) {
          break label181;
        }
        paramViewGroup.WTJ.setImageResource(c.h.login_auth_state_not_selected);
      }
      for (;;)
      {
        paramViewGroup.uBM.setText(localdve.desc);
        final ImageView localImageView = paramViewGroup.WTJ;
        paramViewGroup.WTJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (localdve.abbc == 2)
            {
              localImageView.setImageResource(c.h.login_auth_state_not_selected);
              localdve.abbc = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79748);
              return;
              if (localdve.abbc == 1)
              {
                localImageView.setImageResource(c.h.login_auth_state_default_select);
                localdve.abbc = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label181:
        if (localdve.abbc == 3) {
          paramViewGroup.WTJ.setImageResource(c.h.login_auth_state_must_select);
        } else {
          paramViewGroup.WTJ.setImageResource(c.h.login_auth_state_default_select);
        }
      }
    }
    
    public final LinkedList<String> ixw()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.WTG.size())
      {
        dve localdve = (dve)this.WTG.get(i);
        if ((localdve.abbc == 2) || (localdve.abbc == 3)) {
          localLinkedList.add(localdve.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    static final class a
    {
      ImageView WTJ;
      TextView uBM;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    LinkedList<dvb> WUa;
    private c.a WUb;
    private Context WUc;
    private int WUd;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<dvb> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.WUc = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.WUa = paramLinkedList;
      if (this.WUa == null) {
        this.WUa = new LinkedList();
      }
      Log.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.WUa.size()) });
      this.WUb = new c.a();
      this.WUb.oKB = c.h.native_oauth_default_head_img;
      paramContext = this.WUb;
      paramContext.nrc = true;
      paramContext.oKI = this.WUc.getResources().getDimension(c.d.sdk_oauth_avatar_corners_size);
      this.WUd = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final dvb aun(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.WUa != null) && (paramInt >= 0) && (paramInt < this.WUa.size()))
      {
        dvb localdvb = (dvb)this.WUa.get(paramInt);
        AppMethodBeat.o(79757);
        return localdvb;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.WUa == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.WUa.size();
      AppMethodBeat.o(79756);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(79758);
      dvb localdvb = aun(paramInt);
      if (localdvb == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(c.g.avatar_item, null, false);
        paramView.WUe = ((ImageView)localView.findViewById(c.f.avatar_icon));
        paramView.WUf = ((TextView)localView.findViewById(c.f.avatar_name));
        paramView.WUg = ((TextView)localView.findViewById(c.f.avatar_comment));
        paramView.WUh = ((ImageView)localView.findViewById(c.f.avatar_state));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.WUf.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.WUc, localdvb.nickname, paramViewGroup.WUf.getTextSize()));
        r.bKe().a(localdvb.rHi, paramViewGroup.WUe, this.WUb.bKx());
        if (localdvb.desc == null) {
          break label237;
        }
        paramViewGroup.WUg.setText(localdvb.desc);
        paramViewGroup.WUg.setVisibility(0);
        label195:
        if (localdvb.id != this.WUd) {
          break label249;
        }
        paramViewGroup.WUh.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label237:
        paramViewGroup.WUg.setVisibility(8);
        break label195;
        label249:
        paramViewGroup.WUh.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView WUe;
      TextView WUf;
      TextView WUg;
      ImageView WUh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */