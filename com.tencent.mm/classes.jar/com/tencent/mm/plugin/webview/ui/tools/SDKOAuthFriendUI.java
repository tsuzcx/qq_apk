package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements i
{
  private int Omq = 2;
  private aj QbL;
  private ebg QbM;
  private boolean QbN = false;
  private String appId;
  private String extData;
  private String fXu;
  private s jhZ;
  private int oCE;
  private String scope;
  private long startTime;
  private String state;
  private String transaction;
  
  private void a(ebg paramebg, Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(79704);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("7", this.extData);
    paramClass.putExtra("6", paramInt);
    paramClass.putExtra("auth_raw_url", this.fXu);
    paramClass.putExtra("auth_from_scan", this.QbN);
    try
    {
      paramClass.putExtra("2", paramebg.toByteArray());
      paramebg = new com.tencent.mm.hellhoundlib.b.a().bm(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramebg.aFh(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramebg.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79704);
      return;
    }
    catch (IOException paramebg)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(ebg paramebg, Class<?> paramClass, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(79705);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("7", this.extData);
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("6", paramInt3);
    paramClass.putExtra("auth_raw_url", this.fXu);
    paramClass.putExtra("auth_from_scan", this.QbN);
    try
    {
      paramClass.putExtra("2", paramebg.toByteArray());
      paramebg = new com.tencent.mm.hellhoundlib.b.a().bm(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramebg.aFh(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramebg.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79705);
      return;
    }
    catch (IOException paramebg)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void aos(final int paramInt)
  {
    AppMethodBeat.i(79703);
    Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.lwQ, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void vu(int paramAnonymousInt)
      {
        AppMethodBeat.i(79693);
        Log.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt != 1) && (paramInt == 7))
        {
          SDKOAuthFriendUI.g(SDKOAuthFriendUI.this);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(SDKOAuthFriendUI.f(SDKOAuthFriendUI.this));
          if (SDKOAuthFriendUI.j(SDKOAuthFriendUI.this))
          {
            SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
            aj.a(localLinkedList, 0, SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
            AppMethodBeat.o(79693);
            return;
          }
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).cb(localLinkedList);
          AppMethodBeat.o(79693);
          return;
        }
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).anP(-4);
        AppMethodBeat.o(79693);
      }
    });
    AppMethodBeat.o(79703);
  }
  
  private void gXr()
  {
    AppMethodBeat.i(79698);
    if (this.jhZ == null)
    {
      AppMethodBeat.o(79698);
      return;
    }
    this.jhZ.dismiss();
    AppMethodBeat.o(79698);
  }
  
  private int gXw()
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
  
  private void lF(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(79702);
    Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.lwQ, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void vu(int paramAnonymousInt)
      {
        AppMethodBeat.i(79692);
        Log.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).anP(-4);
          AppMethodBeat.o(79692);
          return;
        }
        if ((paramInt1 == 8) && (paramInt2 == 8))
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).anP(-4);
          AppMethodBeat.o(79692);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        if (paramInt2 == 7) {
          localLinkedList.add(SDKOAuthFriendUI.f(SDKOAuthFriendUI.this));
        }
        SDKOAuthFriendUI.g(SDKOAuthFriendUI.this);
        if (paramInt1 == 7)
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
          aj.a(SDKOAuthFriendUI.h(SDKOAuthFriendUI.this), localLinkedList);
          if (SDKOAuthFriendUI.i(SDKOAuthFriendUI.this) == -1) {
            Log.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
          }
          if (SDKOAuthFriendUI.j(SDKOAuthFriendUI.this))
          {
            SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
            aj.a(localLinkedList, SDKOAuthFriendUI.i(SDKOAuthFriendUI.this), SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
            AppMethodBeat.o(79692);
            return;
          }
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).l(localLinkedList, SDKOAuthFriendUI.i(SDKOAuthFriendUI.this));
          AppMethodBeat.o(79692);
          return;
        }
        if (SDKOAuthFriendUI.j(SDKOAuthFriendUI.this))
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
          aj.a(localLinkedList, 0, SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
          AppMethodBeat.o(79692);
          return;
        }
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).cb(localLinkedList);
        AppMethodBeat.o(79692);
      }
    });
    AppMethodBeat.o(79702);
  }
  
  public int getLayoutId()
  {
    return c.g.sdkoauth_friend_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79694);
    super.onCreate(paramBundle);
    h.aGY().a(1346, this);
    h.aGY().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(c.f.leftClose)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(238964);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).anP(-2);
        SDKOAuthFriendUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238964);
      }
    });
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.scope = paramBundle.getStringExtra("auth_scope");
    this.transaction = paramBundle.getStringExtra("1");
    Object localObject2;
    Object localObject3;
    Object localObject1;
    try
    {
      this.QbM = ((ebg)new ebg().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.extData = paramBundle.getStringExtra("7");
      this.QbN = paramBundle.getBooleanExtra("auth_from_scan", false);
      if (this.QbN)
      {
        this.Omq = 3;
        this.fXu = paramBundle.getStringExtra("auth_raw_url");
        this.QbL = new aj(this, this.appId, this.fXu);
        this.oCE = paramBundle.getIntExtra("3", -1);
        TextView localTextView = (TextView)findViewById(c.f.auth_content_friendpage);
        localObject2 = this.QbM.TKY.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ddj)((Iterator)localObject2).next();
          if (((ddj)localObject3).scope.equals(this.scope)) {
            localTextView.setText(((ddj)localObject3).desc);
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
        this.QbL = new aj(this, this.appId, this.transaction, this.state, this.extData);
      }
      localIOException.getPaint().setFakeBoldText(true);
      localObject1 = (TextView)findViewById(c.f.auth_content_detail);
      if (Util.isNullOrNil(this.QbM.Ugj)) {
        break label567;
      }
    }
    ((TextView)localObject1).setVisibility(0);
    ((TextView)localObject1).setText(this.QbM.Ugj);
    for (;;)
    {
      this.QbL.PVt = this.QbM.Ugc;
      localObject1 = (ImageView)findViewById(c.f.new_app_icon_iv_friendpage);
      localObject2 = (TextView)findViewById(c.f.new_app_name_tv_friendpage);
      localObject3 = new c.a();
      ((c.a)localObject3).lRP = c.h.native_oauth_default_head_img;
      ((c.a)localObject3).lRW = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
      ((c.a)localObject3).kPz = true;
      com.tencent.mm.ay.q.bml().a(this.QbM.TKZ, (ImageView)localObject1, ((c.a)localObject3).bmL());
      ((TextView)localObject2).setText(this.QbM.lnp);
      localObject1 = (Button)findViewById(c.f.login_btn_agree_friendpage);
      localObject2 = (Button)findViewById(c.f.login_btn_disagree_friendpage);
      localObject3 = aj.f(this.scope, this.QbM.TKY);
      final int i = paramBundle.getIntExtra("5", -1);
      this.startTime = System.currentTimeMillis();
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79690);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 1, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79690);
        }
      });
      ((Button)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, this.QbQ, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79691);
        }
      });
      AppMethodBeat.o(79694);
      return;
      label567:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79697);
    super.onDestroy();
    gXr();
    h.aGY().b(1346, this);
    h.aGY().b(1137, this);
    AppMethodBeat.o(79697);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79699);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.QbL.anP(-2);
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.appId, this.startTime, 0, this.Omq, gXw(), 1, 0);
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
    AppMethodBeat.o(79696);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79695);
    super.onResume();
    AppMethodBeat.o(79695);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(79700);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.appId, this.startTime, 2, this.Omq, gXw(), 1, paramInt2);
    }
    gXr();
    if ((paramq instanceof ac))
    {
      this.QbL.j(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(79700);
      return;
    }
    if ((paramq instanceof aa)) {
      this.QbL.O(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(79700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI
 * JD-Core Version:    0.7.0.1
 */