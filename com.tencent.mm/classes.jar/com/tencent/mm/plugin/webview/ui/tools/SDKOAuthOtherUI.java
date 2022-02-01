package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Options;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int VaW;
  private a WTB;
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
  private long startTime;
  private String state;
  private String transaction;
  
  public SDKOAuthOtherUI()
  {
    AppMethodBeat.i(296761);
    this.WTy = false;
    this.VaW = 2;
    this.WTm = new LinkedList();
    AppMethodBeat.o(296761);
  }
  
  private void IK(boolean paramBoolean)
  {
    AppMethodBeat.i(296775);
    Log.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if (paramBoolean)
    {
      localObject1 = this.WTm;
      localObject2 = this.WTB;
      localObject3 = new LinkedList();
      i = 0;
      while (i < ((a)localObject2).WTG.size())
      {
        dve localdve = (dve)((a)localObject2).WTG.get(i);
        if ((localdve.abbc == 2) || (localdve.abbc == 3)) {
          ((LinkedList)localObject3).add(localdve.scope);
        }
        i += 1;
      }
      ((LinkedList)localObject1).addAll((Collection)localObject3);
      Log.i("MicroMsg.SDKOAuthOtherUI", "add scopes to userHasSelectedScopes, userHasSelectedScopes = %s", new Object[] { aj.cm(this.WTm) });
    }
    if (aj.a(this.WTg, this.WTy).booleanValue())
    {
      Log.i("MicroMsg.SDKOAuthOtherUI", "go to SDKOAuthAppDataUI");
      localObject2 = this.WTg;
      localObject3 = this.WTm;
      i = this.rFX;
      Log.i("MicroMsg.SDKOAuthOtherUI", "startScopeActivity  cls:".concat(String.valueOf(SDKOAuthAppDataUI.class)));
      localObject1 = new Intent(this, SDKOAuthAppDataUI.class);
      ((Intent)localObject1).putExtra("0", this.appId);
      ((Intent)localObject1).putExtra("1", this.transaction);
      ((Intent)localObject1).putExtra("4", this.state);
      ((Intent)localObject1).putExtra("7", this.extData);
      ((Intent)localObject1).putExtra("3", i);
      ((Intent)localObject1).putExtra("auth_raw_url", this.idu);
      ((Intent)localObject1).putExtra("auth_from_scan", this.WTy);
      ((Intent)localObject1).putExtra("has_selected_scope", (Serializable)localObject3);
      if ((this.options != null) && (!Util.isNullOrNil(this.options.callbackClassName)))
      {
        localObject3 = new Bundle();
        this.options.toBundle((Bundle)localObject3);
        ((Intent)localObject1).putExtra("send_auth_option", (Bundle)localObject3);
      }
      try
      {
        ((Intent)localObject1).putExtra("2", ((eux)localObject2).toByteArray());
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aj.bD(this);
        AppMethodBeat.o(296775);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
      }
    }
    Log.i("MicroMsg.SDKOAuthOtherUI", "check policy and try to send result");
    Log.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.oop, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void onPermissionReturn(int paramAnonymousInt)
      {
        AppMethodBeat.i(79714);
        Log.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt != 1) && (SDKOAuthOtherUI.this.WTm.size() > 0))
        {
          Log.i("MicroMsg.SDKOAuthOtherUI", "try to send result, isFromQRCodeScan = %s, scopeSize = %s", new Object[] { Boolean.valueOf(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this)), Integer.valueOf(SDKOAuthOtherUI.this.WTm.size()) });
          SDKOAuthOtherUI.h(SDKOAuthOtherUI.this);
          if (SDKOAuthOtherUI.g(SDKOAuthOtherUI.this))
          {
            SDKOAuthOtherUI.e(SDKOAuthOtherUI.this);
            aj.a(SDKOAuthOtherUI.this.WTm, SDKOAuthOtherUI.i(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.e(SDKOAuthOtherUI.this).o(SDKOAuthOtherUI.this.WTm, SDKOAuthOtherUI.i(SDKOAuthOtherUI.this));
          AppMethodBeat.o(79714);
          return;
        }
        SDKOAuthOtherUI.e(SDKOAuthOtherUI.this).a(-4, SDKOAuthOtherUI.d(SDKOAuthOtherUI.this));
        AppMethodBeat.o(79714);
      }
    });
    AppMethodBeat.o(296775);
  }
  
  private void ddd()
  {
    AppMethodBeat.i(79725);
    if (this.lKp == null)
    {
      AppMethodBeat.o(79725);
      return;
    }
    this.lKp.dismiss();
    AppMethodBeat.o(79725);
  }
  
  public int getLayoutId()
  {
    return c.g.sdkoauth_other_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79721);
    Log.i("MicroMsg.SDKOAuthOtherUI", "onCreate");
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
        AppMethodBeat.i(296142);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
        SDKOAuthOtherUI.e(SDKOAuthOtherUI.this).a(-2, SDKOAuthOtherUI.d(SDKOAuthOtherUI.this));
        SDKOAuthOtherUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(296142);
      }
    });
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    label794:
    for (;;)
    {
      try
      {
        this.WTg = ((eux)new eux().parseFrom(paramBundle.getByteArrayExtra("2")));
        this.state = paramBundle.getStringExtra("4");
        this.extData = paramBundle.getStringExtra("7");
        this.WTy = paramBundle.getBooleanExtra("auth_from_scan", false);
        this.WTm = new LinkedList(paramBundle.getStringArrayListExtra("has_selected_scope"));
        if (this.WTy)
        {
          this.VaW = 3;
          this.idu = paramBundle.getStringExtra("auth_raw_url");
          this.WTf = new aj(this, this.appId, this.idu);
          this.rFX = paramBundle.getIntExtra("3", -1);
          Object localObject1 = paramBundle.getBundleExtra("send_auth_option");
          if (localObject1 == null) {
            continue;
          }
          this.options = new SendAuth.Options();
          this.options.fromBundle((Bundle)localObject1);
          Log.i("MicroMsg.SDKOAuthOtherUI", "options.callbackClassName: " + this.options.callbackClassName + "  options.callbackFlags: " + this.options.callbackFlags);
          localObject1 = (TextView)findViewById(c.f.auth_content_otherpage);
          ((TextView)localObject1).setText(c.i.new_sdk_oauth_login_third_scope_auth_content);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          localObject1 = (TextView)findViewById(c.f.auth_content_detail);
          if (Util.isNullOrNil(this.WTg.abxJ)) {
            continue;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(this.WTg.abxJ);
          this.WTf.WMa = this.WTg.abxy;
          localObject1 = (ImageView)findViewById(c.f.new_app_icon_iv_otherpage);
          localObject2 = (TextView)findViewById(c.f.new_app_name_tv_otherpage);
          Object localObject3 = new c.a();
          ((c.a)localObject3).oKB = c.h.native_oauth_default_head_img;
          ((c.a)localObject3).oKI = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
          ((c.a)localObject3).nrc = true;
          r.bKe().a(this.WTg.abaT, (ImageView)localObject1, ((c.a)localObject3).bKx());
          ((TextView)localObject2).setText(this.WTg.nSt);
          localObject1 = (ListView)findViewById(c.f.auth_content_list_otherpage);
          localObject2 = new LinkedList();
          localObject3 = this.WTg.abaS.iterator();
          bool = false;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          dve localdve = (dve)((Iterator)localObject3).next();
          if ((localdve.scope.equals("snsapi_userinfo")) || (localdve.scope.equals("snsapi_login")) || (localdve.scope.equals("group_sns_login")) || (localdve.scope.equals("snsapi_friend"))) {
            break label794;
          }
          ((LinkedList)localObject2).add(localdve);
          if (localdve.abbc != 3) {
            break label794;
          }
          bool = true;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        final boolean bool;
        Log.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.WTf = new aj(this, this.appId, this.transaction, this.state, this.extData);
        continue;
        Log.i("MicroMsg.SDKOAuthOtherUI", "SendAuth.options, bundle is null");
        continue;
        localIOException.setVisibility(8);
        continue;
        this.WTB = new a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.WTB);
        Button localButton = (Button)findViewById(c.f.login_btn_agree_otherpage);
        Object localObject2 = (Button)findViewById(c.f.login_btn_disagree_otherpage);
        final int i = paramBundle.getIntExtra("5", -2);
        final int j = paramBundle.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79712);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 1, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79712);
          }
        });
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79713);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.plugin.webview.k.b.XsD.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79713);
          }
        });
        AppMethodBeat.o(79721);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79724);
    super.onDestroy();
    ddd();
    com.tencent.mm.kernel.h.aZW().b(1346, this);
    com.tencent.mm.kernel.h.aZW().b(1137, this);
    Log.i("MicroMsg.SDKOAuthOtherUI", "onDestroy");
    AppMethodBeat.o(79724);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79726);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 0, this.VaW, 4, 1, 0);
      this.WTf.a(-2, this.options);
      finish();
      AppMethodBeat.o(79726);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(79726);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79723);
    super.onPause();
    Log.i("MicroMsg.SDKOAuthOtherUI", "onPause");
    AppMethodBeat.o(79723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79722);
    super.onResume();
    Log.i("MicroMsg.SDKOAuthOtherUI", "onResume");
    AppMethodBeat.o(79722);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(79727);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.XsD.a(this.appId, this.startTime, 2, this.VaW, 4, 1, paramInt2);
    }
    ddd();
    if ((paramp instanceof ac))
    {
      this.WTf.a(paramInt1, paramInt2, paramString, paramp, this.options);
      AppMethodBeat.o(79727);
      return;
    }
    if ((paramp instanceof aa)) {
      this.WTf.a(paramInt1, paramInt2, paramString, this.options);
    }
    AppMethodBeat.o(79727);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<dve> WTG;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<dve> paramLinkedList)
    {
      AppMethodBeat.i(79716);
      this.mInflater = LayoutInflater.from(paramContext);
      this.WTG = paramLinkedList;
      this.mContext = paramContext;
      AppMethodBeat.o(79716);
    }
    
    private dve aul(int paramInt)
    {
      AppMethodBeat.i(79718);
      if ((paramInt >= 0) && (paramInt < this.WTG.size()))
      {
        dve localdve = (dve)this.WTG.get(paramInt);
        AppMethodBeat.o(79718);
        return localdve;
      }
      AppMethodBeat.o(79718);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79717);
      if (this.WTG == null)
      {
        AppMethodBeat.o(79717);
        return 0;
      }
      int i = this.WTG.size();
      AppMethodBeat.o(79717);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(79719);
      if ((this.WTG == null) || (this.WTG.size() <= 0))
      {
        AppMethodBeat.o(79719);
        return null;
      }
      final dve localdve = aul(paramInt);
      if (localdve == null)
      {
        AppMethodBeat.o(79719);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(c.g.sdk_authorize_scope_item_new, null, false);
        paramViewGroup.WTJ = ((ImageView)paramView.findViewById(c.f.app_auth_state));
        paramViewGroup.uBM = ((TextView)paramView.findViewById(c.f.app_auth_desc));
        paramView.setTag(paramViewGroup);
        if (localdve.abbc != 1) {
          break label181;
        }
        paramViewGroup.WTJ.setImageResource(c.e.checkbox_unselected_small);
      }
      for (;;)
      {
        paramViewGroup.uBM.setText(localdve.desc);
        final ImageView localImageView = paramViewGroup.WTJ;
        paramViewGroup.WTJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79715);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (localdve.abbc == 2)
            {
              localImageView.setImageResource(c.e.checkbox_unselected_small);
              localdve.abbc = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79715);
              return;
              if (localdve.abbc == 1)
              {
                localImageView.setImageResource(c.h.checkbox_selected_small);
                localdve.abbc = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79719);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label181:
        if (localdve.abbc == 3)
        {
          localImageView = paramViewGroup.WTJ;
          if (aw.isDarkMode()) {}
          for (paramInt = c.h.checkbox_selected_grey_dark_small;; paramInt = c.h.checkbox_selected_grey_small)
          {
            localImageView.setImageResource(paramInt);
            break;
          }
        }
        paramViewGroup.WTJ.setImageResource(c.h.checkbox_selected_small);
      }
    }
    
    static final class a
    {
      ImageView WTJ;
      TextView uBM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */