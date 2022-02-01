package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ai BdF;
  private cne BdG;
  private boolean BdH = false;
  private int accountType = 2;
  private String appId;
  private String dAl;
  private String extData;
  private p ftP;
  private int jEi;
  private String scope;
  private long startTime;
  private String state;
  private String transaction;
  
  private void Tt(final int paramInt)
  {
    AppMethodBeat.i(79703);
    ad.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.gQb, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void ns(int paramAnonymousInt)
      {
        AppMethodBeat.i(79693);
        ad.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt != 1) && (paramInt == 7))
        {
          SDKOAuthFriendUI.g(SDKOAuthFriendUI.this);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(SDKOAuthFriendUI.f(SDKOAuthFriendUI.this));
          if (SDKOAuthFriendUI.j(SDKOAuthFriendUI.this))
          {
            SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
            ai.a(localLinkedList, 0, SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
            AppMethodBeat.o(79693);
            return;
          }
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).ba(localLinkedList);
          AppMethodBeat.o(79693);
          return;
        }
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).SO(-4);
        AppMethodBeat.o(79693);
      }
    });
    AppMethodBeat.o(79703);
  }
  
  private void a(cne paramcne, Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(79704);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("7", this.extData);
    paramClass.putExtra("6", paramInt);
    paramClass.putExtra("auth_raw_url", this.dAl);
    paramClass.putExtra("auth_from_scan", this.BdH);
    try
    {
      paramClass.putExtra("2", paramcne.toByteArray());
      paramcne = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcne.adn(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcne.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79704);
      return;
    }
    catch (IOException paramcne)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(cne paramcne, Class<?> paramClass, int paramInt1, int paramInt2, int paramInt3)
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
    paramClass.putExtra("auth_raw_url", this.dAl);
    paramClass.putExtra("auth_from_scan", this.BdH);
    try
    {
      paramClass.putExtra("2", paramcne.toByteArray());
      paramcne = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcne.adn(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcne.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79705);
      return;
    }
    catch (IOException paramcne)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void enB()
  {
    AppMethodBeat.i(79698);
    if (this.ftP == null)
    {
      AppMethodBeat.o(79698);
      return;
    }
    this.ftP.dismiss();
    AppMethodBeat.o(79698);
  }
  
  private int enF()
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
  
  private void iB(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(79702);
    ad.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.gQb, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void ns(int paramAnonymousInt)
      {
        AppMethodBeat.i(79692);
        ad.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).SO(-4);
          AppMethodBeat.o(79692);
          return;
        }
        if ((paramInt1 == 8) && (paramInt2 == 8))
        {
          SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).SO(-4);
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
          ai.a(SDKOAuthFriendUI.h(SDKOAuthFriendUI.this), localLinkedList);
          if (SDKOAuthFriendUI.i(SDKOAuthFriendUI.this) == -1) {
            ad.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
          }
          if (SDKOAuthFriendUI.j(SDKOAuthFriendUI.this))
          {
            SDKOAuthFriendUI.e(SDKOAuthFriendUI.this);
            ai.a(localLinkedList, SDKOAuthFriendUI.i(SDKOAuthFriendUI.this), SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
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
          ai.a(localLinkedList, 0, SDKOAuthFriendUI.k(SDKOAuthFriendUI.this));
          AppMethodBeat.o(79692);
          return;
        }
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).ba(localLinkedList);
        AppMethodBeat.o(79692);
      }
    });
    AppMethodBeat.o(79702);
  }
  
  public int getLayoutId()
  {
    return 2131495317;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79694);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle(getString(2131761567));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79689);
        com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
        SDKOAuthFriendUI.e(SDKOAuthFriendUI.this).SO(-2);
        SDKOAuthFriendUI.this.finish();
        AppMethodBeat.o(79689);
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
      this.BdG = ((cne)new cne().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.extData = paramBundle.getStringExtra("7");
      this.BdH = paramBundle.getBooleanExtra("auth_from_scan", false);
      if (this.BdH)
      {
        this.accountType = 3;
        this.dAl = paramBundle.getStringExtra("auth_raw_url");
        this.BdF = new ai(this, this.appId, this.dAl);
        this.jEi = paramBundle.getIntExtra("3", -1);
        TextView localTextView = (TextView)findViewById(2131296972);
        localObject2 = this.BdG.DRk.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bty)((Iterator)localObject2).next();
          if (((bty)localObject3).scope.equals(this.scope)) {
            localTextView.setText(((bty)localObject3).desc);
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.BdF = new ai(this, this.appId, this.transaction, this.state, this.extData);
      }
      localIOException.getPaint().setFakeBoldText(true);
      localObject1 = (TextView)findViewById(2131296971);
      if (bt.isNullOrNil(this.BdG.EhO)) {
        break label546;
      }
    }
    ((TextView)localObject1).setVisibility(0);
    ((TextView)localObject1).setText(this.BdG.EhO);
    for (;;)
    {
      localObject1 = (ImageView)findViewById(2131302714);
      localObject2 = (TextView)findViewById(2131302717);
      localObject3 = new c.a();
      ((c.a)localObject3).hkf = 2131690915;
      ((c.a)localObject3).hkm = getResources().getDimension(2131166776);
      ((c.a)localObject3).gkG = true;
      o.ayJ().a(this.BdG.DRl, (ImageView)localObject1, ((c.a)localObject3).azc());
      ((TextView)localObject2).setText(this.BdG.gIw);
      localObject1 = (Button)findViewById(2131301563);
      localObject2 = (Button)findViewById(2131301566);
      localObject3 = ai.e(this.scope, this.BdG.DRk);
      final int i = paramBundle.getIntExtra("5", -1);
      this.startTime = System.currentTimeMillis();
      ((Button)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79690);
          com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 1, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, i);
          AppMethodBeat.o(79690);
        }
      });
      ((Button)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79691);
          com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthFriendUI.a(SDKOAuthFriendUI.this), SDKOAuthFriendUI.b(SDKOAuthFriendUI.this), 0, SDKOAuthFriendUI.c(SDKOAuthFriendUI.this), SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
          SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, this.BdK, i);
          AppMethodBeat.o(79691);
        }
      });
      AppMethodBeat.o(79694);
      return;
      label546:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79697);
    super.onDestroy();
    enB();
    AppMethodBeat.o(79697);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79699);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.BdF.SO(-2);
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.appId, this.startTime, 0, this.accountType, enF(), 1, 0);
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
    com.tencent.mm.kernel.g.aeS().b(1346, this);
    com.tencent.mm.kernel.g.aeS().b(1137, this);
    AppMethodBeat.o(79696);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79695);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(1346, this);
    com.tencent.mm.kernel.g.aeS().a(1137, this);
    AppMethodBeat.o(79695);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79700);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.appId, this.startTime, 2, this.accountType, enF(), 1, paramInt2);
    }
    enB();
    if ((paramn instanceof ac))
    {
      this.BdF.j(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(79700);
      return;
    }
    if ((paramn instanceof aa)) {
      this.BdF.N(paramInt1, paramInt2, paramString);
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