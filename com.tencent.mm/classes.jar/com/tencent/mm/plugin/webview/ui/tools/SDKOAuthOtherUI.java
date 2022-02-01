package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI
  extends MMActivity
  implements f
{
  private aj ErB;
  private cyp ErC;
  private boolean ErD = false;
  private a ErJ;
  private int accountType = 2;
  private String appId;
  private String dLz;
  private String extData;
  private p fSP;
  private int kCD;
  private long startTime;
  private String state;
  private String transaction;
  
  private void aE(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(79728);
    ae.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.hLM, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void oJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(79714);
        ae.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-4);
          AppMethodBeat.o(79714);
          return;
        }
        LinkedList localLinkedList;
        if (paramInt3 == 7)
        {
          SDKOAuthOtherUI.a locala = SDKOAuthOtherUI.e(SDKOAuthOtherUI.this);
          localLinkedList = new LinkedList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < locala.ErO.size())
          {
            cea localcea = (cea)locala.ErO.get(paramAnonymousInt);
            if ((localcea.HqT == 2) || (localcea.HqT == 3)) {
              localLinkedList.add(localcea.scope);
            }
            paramAnonymousInt += 1;
          }
        }
        while ((paramInt1 != -2) && (paramInt2 != -2)) {
          if ((paramInt1 == 8) && (paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-4);
            AppMethodBeat.o(79714);
            return;
            localLinkedList = new LinkedList();
          }
          else
          {
            if (paramInt2 == 7) {
              localLinkedList.add("snsapi_friend");
            }
            SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
            if (paramInt1 == 7)
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              aj.a(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this), localLinkedList);
              if (SDKOAuthOtherUI.h(SDKOAuthOtherUI.this) == -1) {
                ae.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
              }
              if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
              {
                SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
                aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
                AppMethodBeat.o(79714);
                return;
              }
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).l(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              aj.a(localLinkedList, 0, SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bj(localLinkedList);
            AppMethodBeat.o(79714);
            return;
          }
        }
        if (paramInt1 != -2)
        {
          if ((paramInt1 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-4);
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
          if (paramInt1 == 7)
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            aj.a(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this), localLinkedList);
            if (SDKOAuthOtherUI.h(SDKOAuthOtherUI.this) == -1) {
              ae.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
            }
            if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).l(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bj(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt2 != -2)
        {
          if ((paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-4);
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
          if (paramInt2 == 7) {
            localLinkedList.add("snsapi_friend");
          }
          if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bj(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt3 == 8)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-4);
          AppMethodBeat.o(79714);
          return;
        }
        SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
        if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
          aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
          AppMethodBeat.o(79714);
          return;
        }
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bj(localLinkedList);
        AppMethodBeat.o(79714);
      }
    });
    AppMethodBeat.o(79728);
  }
  
  private void eVx()
  {
    AppMethodBeat.i(79725);
    if (this.fSP == null)
    {
      AppMethodBeat.o(79725);
      return;
    }
    this.fSP.dismiss();
    AppMethodBeat.o(79725);
  }
  
  public int getLayoutId()
  {
    return 2131495318;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79721);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle(getString(2131761567));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79711);
        com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).Xt(-2);
        SDKOAuthOtherUI.this.finish();
        AppMethodBeat.o(79711);
      }
    });
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    label655:
    for (;;)
    {
      try
      {
        this.ErC = ((cyp)new cyp().parseFrom(paramBundle.getByteArrayExtra("2")));
        this.state = paramBundle.getStringExtra("4");
        this.extData = paramBundle.getStringExtra("7");
        this.ErD = paramBundle.getBooleanExtra("auth_from_scan", false);
        if (this.ErD)
        {
          this.accountType = 3;
          this.dLz = paramBundle.getStringExtra("auth_raw_url");
          this.ErB = new aj(this, this.appId, this.dLz);
          this.kCD = paramBundle.getIntExtra("3", -1);
          Object localObject1 = (TextView)findViewById(2131296975);
          ((TextView)localObject1).setText(2131761566);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          localObject1 = (TextView)findViewById(2131296971);
          if (bu.isNullOrNil(this.ErC.HIN)) {
            continue;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(this.ErC.HIN);
          localObject1 = (ImageView)findViewById(2131302715);
          localObject2 = (TextView)findViewById(2131302718);
          Object localObject3 = new c.a();
          ((c.a)localObject3).igv = 2131690915;
          ((c.a)localObject3).igC = getResources().getDimension(2131166776);
          ((c.a)localObject3).hhW = true;
          com.tencent.mm.av.q.aJb().a(this.ErC.HqM, (ImageView)localObject1, ((c.a)localObject3).aJu());
          ((TextView)localObject2).setText(this.ErC.hDU);
          localObject1 = (ListView)findViewById(2131296974);
          localObject2 = new LinkedList();
          localObject3 = this.ErC.HqL.iterator();
          bool = false;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          cea localcea = (cea)((Iterator)localObject3).next();
          if ((localcea.scope.equals("snsapi_userinfo")) || (localcea.scope.equals("snsapi_login")) || (localcea.scope.equals("group_sns_login")) || (localcea.scope.equals("snsapi_friend"))) {
            break label655;
          }
          ((LinkedList)localObject2).add(localcea);
          if (localcea.HqT != 3) {
            break label655;
          }
          bool = true;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        final boolean bool;
        ae.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.ErB = new aj(this, this.appId, this.transaction, this.state, this.extData);
        continue;
        localIOException.setVisibility(8);
        continue;
        this.ErJ = new a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.ErJ);
        Button localButton = (Button)findViewById(2131301565);
        Object localObject2 = (Button)findViewById(2131301568);
        final int i = paramBundle.getIntExtra("5", -2);
        final int j = paramBundle.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79712);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 1, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, i, j);
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
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, bool, i, j);
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
    eVx();
    AppMethodBeat.o(79724);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79726);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
      this.ErB.Xt(-2);
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
    g.ajj().b(1346, this);
    g.ajj().b(1137, this);
    AppMethodBeat.o(79723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79722);
    super.onResume();
    g.ajj().a(1346, this);
    g.ajj().a(1137, this);
    AppMethodBeat.o(79722);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79727);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.appId, this.startTime, 2, this.accountType, 4, 1, paramInt2);
    }
    eVx();
    if ((paramn instanceof ac))
    {
      this.ErB.j(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(79727);
      return;
    }
    if ((paramn instanceof aa)) {
      this.ErB.O(paramInt1, paramInt2, paramString);
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
    LinkedList<cea> ErO;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<cea> paramLinkedList)
    {
      AppMethodBeat.i(79716);
      this.mInflater = LayoutInflater.from(paramContext);
      this.ErO = paramLinkedList;
      this.mContext = paramContext;
      AppMethodBeat.o(79716);
    }
    
    private cea XX(int paramInt)
    {
      AppMethodBeat.i(79718);
      if ((paramInt >= 0) && (paramInt < this.ErO.size()))
      {
        cea localcea = (cea)this.ErO.get(paramInt);
        AppMethodBeat.o(79718);
        return localcea;
      }
      AppMethodBeat.o(79718);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79717);
      if (this.ErO == null)
      {
        AppMethodBeat.o(79717);
        return 0;
      }
      int i = this.ErO.size();
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
      if ((this.ErO == null) || (this.ErO.size() <= 0))
      {
        AppMethodBeat.o(79719);
        return null;
      }
      final cea localcea = XX(paramInt);
      if (localcea == null)
      {
        AppMethodBeat.o(79719);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495314, null, false);
        paramViewGroup.ErR = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.ngr = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localcea.HqT != 1) {
          break label177;
        }
        paramViewGroup.ErR.setImageResource(2131235025);
      }
      for (;;)
      {
        paramViewGroup.ngr.setText(localcea.desc);
        final ImageView localImageView = paramViewGroup.ErR;
        paramViewGroup.ErR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79715);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (localcea.HqT == 2)
            {
              localImageView.setImageResource(2131235025);
              localcea.HqT = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79715);
              return;
              if (localcea.HqT == 1)
              {
                localImageView.setImageResource(2131689655);
                localcea.HqT = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79719);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localcea.HqT == 3)
        {
          localImageView = paramViewGroup.ErR;
          if (al.isDarkMode()) {}
          for (paramInt = 2131689632;; paramInt = 2131689634)
          {
            localImageView.setImageResource(paramInt);
            break;
          }
        }
        paramViewGroup.ErR.setImageResource(2131689655);
      }
    }
    
    static final class a
    {
      ImageView ErR;
      TextView ngr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */