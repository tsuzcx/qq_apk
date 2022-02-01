package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements i
{
  private aj JeI;
  private drk JeJ;
  private boolean JeK = false;
  private int accountType = 2;
  private String appId;
  private String edo;
  private String extData;
  private com.tencent.mm.ui.base.q gxX;
  private int lGW;
  private String scope;
  private long startTime;
  private String state;
  private String transaction;
  
  private void a(drk paramdrk, Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(79704);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("7", this.extData);
    paramClass.putExtra("6", paramInt);
    paramClass.putExtra("auth_raw_url", this.edo);
    paramClass.putExtra("auth_from_scan", this.JeK);
    try
    {
      paramClass.putExtra("2", paramdrk.toByteArray());
      paramdrk = new com.tencent.mm.hellhoundlib.b.a().bl(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramdrk.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramdrk.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79704);
      return;
    }
    catch (IOException paramdrk)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(drk paramdrk, Class<?> paramClass, int paramInt1, int paramInt2, int paramInt3)
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
    paramClass.putExtra("auth_raw_url", this.edo);
    paramClass.putExtra("auth_from_scan", this.JeK);
    try
    {
      paramClass.putExtra("2", paramdrk.toByteArray());
      paramdrk = new com.tencent.mm.hellhoundlib.b.a().bl(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramdrk.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramdrk.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79705);
      return;
    }
    catch (IOException paramdrk)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void agD(final int paramInt)
  {
    AppMethodBeat.i(79703);
    Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.iGO, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void sx(int paramAnonymousInt)
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
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).bE(localLinkedList);
          AppMethodBeat.o(79693);
          return;
        }
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).agb(-4);
        AppMethodBeat.o(79693);
      }
    });
    AppMethodBeat.o(79703);
  }
  
  private void gep()
  {
    AppMethodBeat.i(79698);
    if (this.gxX == null)
    {
      AppMethodBeat.o(79698);
      return;
    }
    this.gxX.dismiss();
    AppMethodBeat.o(79698);
  }
  
  private int gev()
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
  
  private void kn(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(79702);
    Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.iGO, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void sx(int paramAnonymousInt)
      {
        AppMethodBeat.i(79692);
        Log.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).agb(-4);
          AppMethodBeat.o(79692);
          return;
        }
        if ((paramInt1 == 8) && (paramInt2 == 8))
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).agb(-4);
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
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).k(localLinkedList, SDKOAuthFriendUI.i(SDKOAuthFriendUI.this));
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
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).bE(localLinkedList);
        AppMethodBeat.o(79692);
      }
    });
    AppMethodBeat.o(79702);
  }
  
  public int getLayoutId()
  {
    return 2131496175;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79694);
    super.onCreate(paramBundle);
    g.azz().a(1346, this);
    g.azz().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(2131303133)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211042);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).agb(-2);
        SDKOAuthFriendUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211042);
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
      this.JeJ = ((drk)new drk().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.extData = paramBundle.getStringExtra("7");
      this.JeK = paramBundle.getBooleanExtra("auth_from_scan", false);
      if (this.JeK)
      {
        this.accountType = 3;
        this.edo = paramBundle.getStringExtra("auth_raw_url");
        this.JeI = new aj(this, this.appId, this.edo);
        this.lGW = paramBundle.getIntExtra("3", -1);
        TextView localTextView = (TextView)findViewById(2131297091);
        localObject2 = this.JeJ.Mzs.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (cuh)((Iterator)localObject2).next();
          if (((cuh)localObject3).scope.equals(this.scope)) {
            localTextView.setText(((cuh)localObject3).desc);
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
        this.JeI = new aj(this, this.appId, this.transaction, this.state, this.extData);
      }
      localIOException.getPaint().setFakeBoldText(true);
      localObject1 = (TextView)findViewById(2131297090);
      if (Util.isNullOrNil(this.JeJ.MUa)) {
        break label553;
      }
    }
    ((TextView)localObject1).setVisibility(0);
    ((TextView)localObject1).setText(this.JeJ.MUa);
    for (;;)
    {
      localObject1 = (ImageView)findViewById(2131305281);
      localObject2 = (TextView)findViewById(2131305284);
      localObject3 = new c.a();
      ((c.a)localObject3).jbq = 2131691211;
      ((c.a)localObject3).jbx = getResources().getDimension(2131166899);
      ((c.a)localObject3).iaT = true;
      com.tencent.mm.av.q.bcV().a(this.JeJ.Mzt, (ImageView)localObject1, ((c.a)localObject3).bdv());
      ((TextView)localObject2).setText(this.JeJ.ixZ);
      localObject1 = (Button)findViewById(2131303785);
      localObject2 = (Button)findViewById(2131303788);
      localObject3 = aj.e(this.scope, this.JeJ.Mzs);
      final int i = paramBundle.getIntExtra("5", -1);
      this.startTime = System.currentTimeMillis();
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79690);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 1, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, this.JeN, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79691);
        }
      });
      AppMethodBeat.o(79694);
      return;
      label553:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79697);
    super.onDestroy();
    gep();
    g.azz().b(1346, this);
    g.azz().b(1137, this);
    AppMethodBeat.o(79697);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79699);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.JeI.agb(-2);
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.appId, this.startTime, 0, this.accountType, gev(), 1, 0);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(79700);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.appId, this.startTime, 2, this.accountType, gev(), 1, paramInt2);
    }
    gep();
    if ((paramq instanceof ac))
    {
      this.JeI.i(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(79700);
      return;
    }
    if ((paramq instanceof aa)) {
      this.JeI.Q(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(79700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI
 * JD-Core Version:    0.7.0.1
 */