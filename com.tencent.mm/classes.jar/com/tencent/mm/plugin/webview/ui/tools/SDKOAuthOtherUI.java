package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.tencent.mm.ui.ao;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI
  extends MMActivity
  implements i
{
  private aj JeI;
  private drk JeJ;
  private boolean JeK = false;
  private a JeQ;
  private int accountType = 2;
  private String appId;
  private String edo;
  private String extData;
  private com.tencent.mm.ui.base.q gxX;
  private int lGW;
  private long startTime;
  private String state;
  private String transaction;
  
  private void aM(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(79728);
    Log.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.iGO, this.appId, new com.tencent.mm.model.gdpr.b()
    {
      public final void sx(int paramAnonymousInt)
      {
        AppMethodBeat.i(79714);
        Log.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-4);
          AppMethodBeat.o(79714);
          return;
        }
        LinkedList localLinkedList;
        if (paramInt3 == 7)
        {
          SDKOAuthOtherUI.a locala = SDKOAuthOtherUI.e(SDKOAuthOtherUI.this);
          localLinkedList = new LinkedList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < locala.JeV.size())
          {
            cuh localcuh = (cuh)locala.JeV.get(paramAnonymousInt);
            if ((localcuh.MzA == 2) || (localcuh.MzA == 3)) {
              localLinkedList.add(localcuh.scope);
            }
            paramAnonymousInt += 1;
          }
        }
        while ((paramInt1 != -2) && (paramInt2 != -2)) {
          if ((paramInt1 == 8) && (paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-4);
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
                Log.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
              }
              if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
              {
                SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
                aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
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
              aj.a(localLinkedList, 0, SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
              AppMethodBeat.o(79714);
              return;
            }
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bE(localLinkedList);
            AppMethodBeat.o(79714);
            return;
          }
        }
        if (paramInt1 != -2)
        {
          if ((paramInt1 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-4);
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
          if (paramInt1 == 7)
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
            aj.a(SDKOAuthOtherUI.g(SDKOAuthOtherUI.this), localLinkedList);
            if (SDKOAuthOtherUI.h(SDKOAuthOtherUI.this) == -1) {
              Log.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
            }
            if (SDKOAuthOtherUI.i(SDKOAuthOtherUI.this))
            {
              SDKOAuthOtherUI.d(SDKOAuthOtherUI.this);
              aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
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
            aj.a(localLinkedList, SDKOAuthOtherUI.h(SDKOAuthOtherUI.this), SDKOAuthOtherUI.j(SDKOAuthOtherUI.this));
            AppMethodBeat.o(79714);
            return;
          }
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bE(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt2 != -2)
        {
          if ((paramInt2 == 8) && (paramInt3 == 8))
          {
            SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-4);
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
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bE(localLinkedList);
          AppMethodBeat.o(79714);
          return;
        }
        if (paramInt3 == 8)
        {
          SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-4);
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
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).bE(localLinkedList);
        AppMethodBeat.o(79714);
      }
    });
    AppMethodBeat.o(79728);
  }
  
  private void gep()
  {
    AppMethodBeat.i(79725);
    if (this.gxX == null)
    {
      AppMethodBeat.o(79725);
      return;
    }
    this.gxX.dismiss();
    AppMethodBeat.o(79725);
  }
  
  public int getLayoutId()
  {
    return 2131496176;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79721);
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
        AppMethodBeat.i(211043);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
        SDKOAuthOtherUI.d(SDKOAuthOtherUI.this).agb(-2);
        SDKOAuthOtherUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211043);
      }
    });
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    label662:
    for (;;)
    {
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
          Object localObject1 = (TextView)findViewById(2131297094);
          ((TextView)localObject1).setText(2131763532);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          localObject1 = (TextView)findViewById(2131297090);
          if (Util.isNullOrNil(this.JeJ.MUa)) {
            continue;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(this.JeJ.MUa);
          localObject1 = (ImageView)findViewById(2131305282);
          localObject2 = (TextView)findViewById(2131305285);
          Object localObject3 = new c.a();
          ((c.a)localObject3).jbq = 2131691211;
          ((c.a)localObject3).jbx = getResources().getDimension(2131166899);
          ((c.a)localObject3).iaT = true;
          com.tencent.mm.av.q.bcV().a(this.JeJ.Mzt, (ImageView)localObject1, ((c.a)localObject3).bdv());
          ((TextView)localObject2).setText(this.JeJ.ixZ);
          localObject1 = (ListView)findViewById(2131297093);
          localObject2 = new LinkedList();
          localObject3 = this.JeJ.Mzs.iterator();
          bool = false;
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          cuh localcuh = (cuh)((Iterator)localObject3).next();
          if ((localcuh.scope.equals("snsapi_userinfo")) || (localcuh.scope.equals("snsapi_login")) || (localcuh.scope.equals("group_sns_login")) || (localcuh.scope.equals("snsapi_friend"))) {
            break label662;
          }
          ((LinkedList)localObject2).add(localcuh);
          if (localcuh.MzA != 3) {
            break label662;
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
        this.JeI = new aj(this, this.appId, this.transaction, this.state, this.extData);
        continue;
        localIOException.setVisibility(8);
        continue;
        this.JeQ = new a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.JeQ);
        Button localButton = (Button)findViewById(2131303787);
        Object localObject2 = (Button)findViewById(2131303790);
        final int i = paramBundle.getIntExtra("5", -2);
        final int j = paramBundle.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79712);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 1, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
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
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthOtherUI.a(SDKOAuthOtherUI.this), SDKOAuthOtherUI.b(SDKOAuthOtherUI.this), 0, SDKOAuthOtherUI.c(SDKOAuthOtherUI.this), 4, 1, 0);
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
    gep();
    g.azz().b(1346, this);
    g.azz().b(1137, this);
    AppMethodBeat.o(79724);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79726);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
      this.JeI.agb(-2);
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
    AppMethodBeat.o(79723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79722);
    super.onResume();
    AppMethodBeat.o(79722);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(79727);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.appId, this.startTime, 2, this.accountType, 4, 1, paramInt2);
    }
    gep();
    if ((paramq instanceof ac))
    {
      this.JeI.i(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(79727);
      return;
    }
    if ((paramq instanceof aa)) {
      this.JeI.Q(paramInt1, paramInt2, paramString);
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
    LinkedList<cuh> JeV;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<cuh> paramLinkedList)
    {
      AppMethodBeat.i(79716);
      this.mInflater = LayoutInflater.from(paramContext);
      this.JeV = paramLinkedList;
      this.mContext = paramContext;
      AppMethodBeat.o(79716);
    }
    
    private cuh agE(int paramInt)
    {
      AppMethodBeat.i(79718);
      if ((paramInt >= 0) && (paramInt < this.JeV.size()))
      {
        cuh localcuh = (cuh)this.JeV.get(paramInt);
        AppMethodBeat.o(79718);
        return localcuh;
      }
      AppMethodBeat.o(79718);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79717);
      if (this.JeV == null)
      {
        AppMethodBeat.o(79717);
        return 0;
      }
      int i = this.JeV.size();
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
      if ((this.JeV == null) || (this.JeV.size() <= 0))
      {
        AppMethodBeat.o(79719);
        return null;
      }
      final cuh localcuh = agE(paramInt);
      if (localcuh == null)
      {
        AppMethodBeat.o(79719);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131496172, null, false);
        paramViewGroup.JeY = ((ImageView)paramView.findViewById(2131296771));
        paramViewGroup.oqe = ((TextView)paramView.findViewById(2131296770));
        paramView.setTag(paramViewGroup);
        if (localcuh.MzA != 1) {
          break label177;
        }
        paramViewGroup.JeY.setImageResource(2131231827);
      }
      for (;;)
      {
        paramViewGroup.oqe.setText(localcuh.desc);
        final ImageView localImageView = paramViewGroup.JeY;
        paramViewGroup.JeY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79715);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (localcuh.MzA == 2)
            {
              localImageView.setImageResource(2131231827);
              localcuh.MzA = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79715);
              return;
              if (localcuh.MzA == 1)
              {
                localImageView.setImageResource(2131689962);
                localcuh.MzA = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79719);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localcuh.MzA == 3)
        {
          localImageView = paramViewGroup.JeY;
          if (ao.isDarkMode()) {}
          for (paramInt = 2131689956;; paramInt = 2131689957)
          {
            localImageView.setImageResource(paramInt);
            break;
          }
        }
        paramViewGroup.JeY.setImageResource(2131689962);
      }
    }
    
    static final class a
    {
      ImageView JeY;
      TextView oqe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */