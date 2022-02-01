package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;

public class ShakeSayHiListUI
  extends MMActivity
{
  private ListView jci;
  private int limit;
  private n.e nUI;
  private long nxr;
  private int wpA;
  private int wpz;
  private ce yOi;
  private int yQq;
  private b yQr;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(28553);
    this.yQq = 0;
    this.yOi = null;
    this.limit = 0;
    this.wpz = 0;
    this.wpA = 0;
    this.nUI = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28543);
        d.aMq().apP(String.valueOf(ShakeSayHiListUI.g(ShakeSayHiListUI.this)));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).a(null, null);
        AppMethodBeat.o(28543);
      }
    };
    AppMethodBeat.o(28553);
  }
  
  public int getLayoutId()
  {
    return 2131494580;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28559);
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    this.jci = ((ListView)findViewById(2131304293));
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28542);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ShakeSayHiListUI.a(ShakeSayHiListUI.this, ShakeSayHiListUI.a(ShakeSayHiListUI.this) + 8);
        ad.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).Pr(ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        if (ShakeSayHiListUI.c(ShakeSayHiListUI.this) <= ShakeSayHiListUI.a(ShakeSayHiListUI.this))
        {
          ShakeSayHiListUI.d(ShakeSayHiListUI.this).removeFooterView(this.wpD);
          ad.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28542);
      }
    });
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28545);
        h.a(ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(2131762787), "", ShakeSayHiListUI.this.getString(2131762786), ShakeSayHiListUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28544);
            ShakeSayHiListUI.e(ShakeSayHiListUI.this).bcD();
            ShakeSayHiListUI.b(ShakeSayHiListUI.this).Zu();
            paramAnonymous2DialogInterface = (TextView)ShakeSayHiListUI.this.findViewById(2131299468);
            paramAnonymous2DialogInterface.setText(2131762792);
            paramAnonymous2DialogInterface.setVisibility(0);
            ShakeSayHiListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(28544);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(28545);
        return true;
      }
    });
    if (this.wpz == 0)
    {
      TextView localTextView = (TextView)findViewById(2131299468);
      localTextView.setText(2131762792);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.wpz > 0) && (this.limit < this.wpz)) {
      this.jci.addFooterView((View)localObject);
    }
    this.yQr = new b(this, this.yOi, this.limit);
    this.yQr.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(28546);
        int i = ShakeSayHiListUI.d(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(28546);
        return i;
      }
    });
    this.yQr.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28547);
        ShakeSayHiListUI.d(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28547);
      }
    });
    this.yQr.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
      {
        AppMethodBeat.i(28548);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(28548);
          return;
        }
        d.aMq().apP(paramAnonymousObject.toString());
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).a(null, null);
        AppMethodBeat.o(28548);
      }
    });
    this.jci.setAdapter(this.yQr);
    this.jci.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28549);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousAdapterView = (cd)ShakeSayHiListUI.b(ShakeSayHiListUI.this).getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
        paramAnonymousView = bu.d.aUe(paramAnonymousAdapterView.field_content);
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.dHm);
        ((Intent)localObject).putExtra("Contact_Encryptusername", paramAnonymousView.IMB);
        ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ffB);
        ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
        ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.jeV);
        ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.jeU);
        ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.ePk);
        ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
        ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
        ((Intent)localObject).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
        ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
        if (bt.isNullOrNil(paramAnonymousAdapterView.field_sayhicontent)) {}
        for (paramAnonymousAdapterView = ShakeSayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = paramAnonymousAdapterView.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.wSt);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.jeW);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.IMm);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.txJ);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          ba.aBQ();
          paramAnonymousAdapterView = c.azp().Bf(paramAnonymousView.dHm);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.gfj >= 0) && (!com.tencent.mm.o.b.lM(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dsi;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.shake.a.iRG.c((Intent)localObject, ShakeSayHiListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
      }
    });
    localObject = new l(this);
    this.jci.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28550);
        if (paramAnonymousInt < ShakeSayHiListUI.d(ShakeSayHiListUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(28550);
          return true;
        }
        this.nUL.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeSayHiListUI.this, ShakeSayHiListUI.f(ShakeSayHiListUI.this));
        AppMethodBeat.o(28550);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28551);
        ShakeSayHiListUI.this.hideVKB();
        ShakeSayHiListUI.this.finish();
        AppMethodBeat.o(28551);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28552);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = ShakeSayHiListUI.d(ShakeSayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28552);
      }
    });
    AppMethodBeat.o(28559);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28554);
    super.onCreate(paramBundle);
    this.yQq = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.yQq == 1)
    {
      this.yOi = d.aMq();
      setMMTitle(2131762791);
      this.wpA = this.yOi.bUJ();
      if (this.wpA != 0) {
        break label161;
      }
    }
    label161:
    for (int i = 8;; i = this.wpA)
    {
      this.limit = i;
      this.wpz = this.yOi.getCount();
      paramBundle = this.yOi;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(28554);
      return;
      setMMTitle(2131762789);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28560);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.nxr = ((cd)this.yQr.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28556);
    this.yQr.det();
    super.onDestroy();
    AppMethodBeat.o(28556);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28558);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(28558);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28557);
    super.onPause();
    if (this.yQr.nUz != null) {
      this.yQr.nUz.deC();
    }
    AppMethodBeat.o(28557);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28555);
    super.onResume();
    if (this.wpz != this.yOi.getCount())
    {
      this.wpz = this.yOi.getCount();
      if (this.wpz == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.yQr.Zu();
    }
    this.yQr.notifyDataSetChanged();
    AppMethodBeat.o(28555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */