package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Options;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int VaW;
  private aj WTf;
  private eux WTg;
  public LinkedList<String> WTm;
  private boolean WTy;
  private String appId;
  private String extData;
  private String idu;
  private w lKp;
  private SendAuth.Options options;
  private int rFX;
  private String scope;
  private long startTime;
  private String state;
  private String transaction;
  
  public SDKOAuthFriendUI()
  {
    AppMethodBeat.i(297008);
    this.WTy = false;
    this.VaW = 2;
    this.WTm = new LinkedList();
    AppMethodBeat.o(297008);
  }
  
  private void a(eux parameux, Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(79704);
    Log.i("MicroMsg.SDKOAuthFriendUI", "startScopeActivity  cls:".concat(String.valueOf(paramClass)));
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("7", this.extData);
    paramClass.putExtra("3", paramInt);
    paramClass.putExtra("auth_raw_url", this.idu);
    paramClass.putExtra("has_selected_scope", this.WTm);
    paramClass.putExtra("auth_from_scan", this.WTy);
    if ((this.options != null) && (!Util.isNullOrNil(this.options.callbackClassName)))
    {
      Bundle localBundle = new Bundle();
      this.options.toBundle(localBundle);
      paramClass.putExtra("send_auth_option", localBundle);
    }
    try
    {
      paramClass.putExtra("2", parameux.toByteArray());
      parameux = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, parameux.aYi(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)parameux.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79704);
      return;
    }
    catch (IOException parameux)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void ddd()
  {
    AppMethodBeat.i(79698);
    if (this.lKp == null)
    {
      AppMethodBeat.o(79698);
      return;
    }
    this.lKp.dismiss();
    AppMethodBeat.o(79698);
  }
  
  private int ixs()
  {
    AppMethodBeat.i(79701);
    if ("snsapi_friend".equals(this.scope))
    {
      AppMethodBeat.o(79701);
      return 3;
    }
    AppMethodBeat.o(79701);
    return 4;
  }
  
  public int getLayoutId()
  {
    return c.g.sdkoauth_friend_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79694);
    Log.i("MicroMsg.SDKOAuthFriendUI", "onCreate");
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1346, this);
    com.tencent.mm.kernel.h.aZW().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(c.f.leftClose)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
        SDKOAuthFriendUI.f(SDKOAuthFriendUI.this).a(-2, SDKOAuthFriendUI.e(SDKOAuthFriendUI.this));
        SDKOAuthFriendUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(296377);
      }
    });
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.scope = paramBundle.getStringExtra("auth_scope");
    this.transaction = paramBundle.getStringExtra("1");
    this.WTm = new LinkedList(paramBundle.getStringArrayListExtra("has_selected_scope"));
    Object localObject2;
    try
    {
      this.WTg = ((eux)new eux().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.extData = paramBundle.getStringExtra("7");
      this.WTy = paramBundle.getBooleanExtra("auth_from_scan", false);
      if (this.WTy)
      {
        this.VaW = 3;
        this.idu = paramBundle.getStringExtra("auth_raw_url");
        this.WTf = new aj(this, this.appId, this.idu);
        this.rFX = paramBundle.getIntExtra("3", -1);
        paramBundle = paramBundle.getBundleExtra("send_auth_option");
        if (paramBundle == null) {
          break label416;
        }
        this.options = new SendAuth.Options();
        this.options.fromBundle(paramBundle);
        Log.i("MicroMsg.SDKOAuthFriendUI", "options.callbackClassName: " + this.options.callbackClassName + "  options.callbackFlags: " + this.options.callbackFlags);
        paramBundle = (TextView)findViewById(c.f.auth_content_friendpage);
        Iterator localIterator = this.WTg.abaS.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (dve)localIterator.next();
          if (((dve)localObject2).scope.equals(this.scope)) {
            paramBundle.setText(((dve)localObject2).desc);
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.WTf = new aj(this, this.appId, this.transaction, this.state, this.extData);
        continue;
        label416:
        Log.i("MicroMsg.SDKOAuthFriendUI", "SendAuth.options, bundle is null");
      }
      paramBundle.getPaint().setFakeBoldText(true);
      paramBundle = (TextView)findViewById(c.f.auth_content_detail);
      if (Util.isNullOrNil(this.WTg.abxJ)) {
        break label651;
      }
    }
    paramBundle.setVisibility(0);
    paramBundle.setText(this.WTg.abxJ);
    for (;;)
    {
      this.WTf.WMa = this.WTg.abxy;
      paramBundle = (ImageView)findViewById(c.f.new_app_icon_iv_friendpage);
      Object localObject1 = (TextView)findViewById(c.f.new_app_name_tv_friendpage);
      localObject2 = new c.a();
      ((c.a)localObject2).oKB = c.h.native_oauth_default_head_img;
      ((c.a)localObject2).oKI = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
      ((c.a)localObject2).nrc = true;
      r.bKe().a(this.WTg.abaT, paramBundle, ((c.a)localObject2).bKx());
      ((TextView)localObject1).setText(this.WTg.nSt);
      paramBundle = (Button)findViewById(c.f.login_btn_agree_friendpage);
      localObject1 = (Button)findViewById(c.f.login_btn_disagree_friendpage);
      localObject2 = aj.f(this.scope, this.WTg.abaS);
      this.startTime = System.currentTimeMillis();
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79690);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 1, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, true, this.WTA);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79690);
        }
      });
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, false, this.WTA);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79691);
        }
      });
      AppMethodBeat.o(79694);
      return;
      label651:
      paramBundle.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79697);
    super.onDestroy();
    ddd();
    com.tencent.mm.kernel.h.aZW().b(1346, this);
    com.tencent.mm.kernel.h.aZW().b(1137, this);
    Log.i("MicroMsg.SDKOAuthFriendUI", "onDestroy");
    AppMethodBeat.o(79697);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79699);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.WTf.a(-2, this.options);
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 0, this.VaW, ixs(), 1, 0);
      finish();
      AppMethodBeat.o(79699);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(79699);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79696);
    super.onPause();
    Log.i("MicroMsg.SDKOAuthFriendUI", "onPause");
    AppMethodBeat.o(79696);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79695);
    super.onResume();
    Log.i("MicroMsg.SDKOAuthFriendUI", "onResume");
    AppMethodBeat.o(79695);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(79700);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 2, this.VaW, ixs(), 1, paramInt2);
    }
    ddd();
    if ((paramp instanceof ac))
    {
      this.WTf.a(paramInt1, paramInt2, paramString, paramp, this.options);
      AppMethodBeat.o(79700);
      return;
    }
    if ((paramp instanceof aa)) {
      this.WTf.a(paramInt1, paramInt2, paramString, this.options);
    }
    AppMethodBeat.o(79700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI
 * JD-Core Version:    0.7.0.1
 */