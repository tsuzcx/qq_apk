package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ai CvR;
  private csl CvS;
  private boolean CvT = false;
  private a CvZ;
  private int accountType = 2;
  private String appId;
  private String dxX;
  private String extData;
  private p fxw;
  private int keF;
  private long startTime;
  private String state;
  private String transaction;
  
  private void aB(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(79728);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.hqB, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void og(int paramAnonymousInt)
      {
        AppMethodBeat.i(79714);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-4);
          AppMethodBeat.o(79714);
          return;
        }
        LinkedList localLinkedList;
        if (paramInt3 == 7)
        {
          SDKOAuthOtherUI.a locala = SDKOAuthOtherUI.e(SDKOAuthOtherUI.this);
          localLinkedList = new LinkedList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < locala.Cwe.size())
          {
            byp localbyp = (byp)locala.Cwe.get(paramAnonymousInt);
            if ((localbyp.FnK == 2) || (localbyp.FnK == 3)) {
              localLinkedList.add(localbyp.scope);
            }
            paramAnonymousInt += 1;
          }
        }
        while ((paramInt1 != -2) && (paramInt2 != -2)) {
          if ((paramInt1 == 8) && (paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-4);
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
              ai.a(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this), localLinkedList);
              if (SDKOAuthOtherUI.h(SDKOAuthOtherUI.this) == -1) {
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
              }
              if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
              {
                SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
                ai.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
                AppMethodBeat.o(79714);
                return;
              }
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).k(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              ai.a(localLinkedList, 0, SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bh(localLinkedList);
            AppMethodBeat.o(79714);
            return;
          }
        }
        if (paramInt1 != -2)
        {
          if ((paramInt1 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-4);
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
          if (paramInt1 == 7)
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            ai.a(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this), localLinkedList);
            if (SDKOAuthOtherUI.h(SDKOAuthOtherUI.this) == -1) {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
            }
            if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              ai.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).k(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            ai.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bh(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt2 != -2)
        {
          if ((paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-4);
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
            ai.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bh(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt3 == 8)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-4);
          AppMethodBeat.o(79714);
          return;
        }
        SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
        if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
          ai.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
          AppMethodBeat.o(79714);
          return;
        }
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bh(localLinkedList);
        AppMethodBeat.o(79714);
      }
    });
    AppMethodBeat.o(79728);
  }
  
  private void eCU()
  {
    AppMethodBeat.i(79725);
    if (this.fxw == null)
    {
      AppMethodBeat.o(79725);
      return;
    }
    this.fxw.dismiss();
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
        com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).UW(-2);
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
        this.CvS = ((csl)new csl().parseFrom(paramBundle.getByteArrayExtra("2")));
        this.state = paramBundle.getStringExtra("4");
        this.extData = paramBundle.getStringExtra("7");
        this.CvT = paramBundle.getBooleanExtra("auth_from_scan", false);
        if (this.CvT)
        {
          this.accountType = 3;
          this.dxX = paramBundle.getStringExtra("auth_raw_url");
          this.CvR = new ai(this, this.appId, this.dxX);
          this.keF = paramBundle.getIntExtra("3", -1);
          Object localObject1 = (TextView)findViewById(2131296975);
          ((TextView)localObject1).setText(2131761566);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          localObject1 = (TextView)findViewById(2131296971);
          if (bs.isNullOrNil(this.CvS.FEM)) {
            continue;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(this.CvS.FEM);
          localObject1 = (ImageView)findViewById(2131302715);
          localObject2 = (TextView)findViewById(2131302718);
          Object localObject3 = new c.a();
          ((c.a)localObject3).hKI = 2131690915;
          ((c.a)localObject3).hKP = getResources().getDimension(2131166776);
          ((c.a)localObject3).gLt = true;
          o.aFB().a(this.CvS.FnD, (ImageView)localObject1, ((c.a)localObject3).aFT());
          ((TextView)localObject2).setText(this.CvS.hiX);
          localObject1 = (ListView)findViewById(2131296974);
          localObject2 = new LinkedList();
          localObject3 = this.CvS.FnC.iterator();
          bool = false;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          byp localbyp = (byp)((Iterator)localObject3).next();
          if ((localbyp.scope.equals("snsapi_userinfo")) || (localbyp.scope.equals("snsapi_login")) || (localbyp.scope.equals("group_sns_login")) || (localbyp.scope.equals("snsapi_friend"))) {
            break label655;
          }
          ((LinkedList)localObject2).add(localbyp);
          if (localbyp.FnK != 3) {
            break label655;
          }
          bool = true;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        final boolean bool;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.CvR = new ai(this, this.appId, this.transaction, this.state, this.extData);
        continue;
        localIOException.setVisibility(8);
        continue;
        this.CvZ = new a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.CvZ);
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
            com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 1, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, i, j);
            AppMethodBeat.o(79712);
          }
        });
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79713);
            com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
            SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, bool, i, j);
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
    eCU();
    AppMethodBeat.o(79724);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79726);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
      this.CvR.UW(-2);
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
    com.tencent.mm.kernel.g.agi().b(1346, this);
    com.tencent.mm.kernel.g.agi().b(1137, this);
    AppMethodBeat.o(79723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79722);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(1346, this);
    com.tencent.mm.kernel.g.agi().a(1137, this);
    AppMethodBeat.o(79722);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79727);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.appId, this.startTime, 2, this.accountType, 4, 1, paramInt2);
    }
    eCU();
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.ac))
    {
      this.CvR.j(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(79727);
      return;
    }
    if ((paramn instanceof aa)) {
      this.CvR.M(paramInt1, paramInt2, paramString);
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
    LinkedList<byp> Cwe;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<byp> paramLinkedList)
    {
      AppMethodBeat.i(79716);
      this.mInflater = LayoutInflater.from(paramContext);
      this.Cwe = paramLinkedList;
      this.mContext = paramContext;
      AppMethodBeat.o(79716);
    }
    
    private byp VC(int paramInt)
    {
      AppMethodBeat.i(79718);
      if ((paramInt >= 0) && (paramInt < this.Cwe.size()))
      {
        byp localbyp = (byp)this.Cwe.get(paramInt);
        AppMethodBeat.o(79718);
        return localbyp;
      }
      AppMethodBeat.o(79718);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79717);
      if (this.Cwe == null)
      {
        AppMethodBeat.o(79717);
        return 0;
      }
      int i = this.Cwe.size();
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
      if ((this.Cwe == null) || (this.Cwe.size() <= 0))
      {
        AppMethodBeat.o(79719);
        return null;
      }
      final byp localbyp = VC(paramInt);
      if (localbyp == null)
      {
        AppMethodBeat.o(79719);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495314, null, false);
        paramViewGroup.Cwh = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.mAB = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localbyp.FnK != 1) {
          break label177;
        }
        paramViewGroup.Cwh.setImageResource(2131231750);
      }
      for (;;)
      {
        paramViewGroup.mAB.setText(localbyp.desc);
        final ImageView localImageView = paramViewGroup.Cwh;
        paramViewGroup.Cwh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79715);
            if (localbyp.FnK == 2)
            {
              localImageView.setImageResource(2131231750);
              localbyp.FnK = 1;
              AppMethodBeat.o(79715);
              return;
            }
            if (localbyp.FnK == 1)
            {
              localImageView.setImageResource(2131689936);
              localbyp.FnK = 2;
            }
            AppMethodBeat.o(79715);
          }
        });
        AppMethodBeat.o(79719);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localbyp.FnK == 3)
        {
          localImageView = paramViewGroup.Cwh;
          if (aj.DT()) {}
          for (paramInt = 2131689939;; paramInt = 2131689938)
          {
            localImageView.setImageResource(paramInt);
            break;
          }
        }
        paramViewGroup.Cwh.setImageResource(2131689936);
      }
    }
    
    static final class a
    {
      ImageView Cwh;
      TextView mAB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */