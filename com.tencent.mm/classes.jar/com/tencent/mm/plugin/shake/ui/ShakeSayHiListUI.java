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
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
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
  private ListView jfb;
  private int limit;
  private long nCM;
  private n.e oao;
  private int wFi;
  private int wFj;
  private cf zes;
  private int zgA;
  private b zgB;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(28553);
    this.zgA = 0;
    this.zes = null;
    this.limit = 0;
    this.wFi = 0;
    this.wFj = 0;
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28543);
        d.aMO().aqU(String.valueOf(ShakeSayHiListUI.g(ShakeSayHiListUI.this)));
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
    this.jfb = ((ListView)findViewById(2131304293));
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28542);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ShakeSayHiListUI.a(ShakeSayHiListUI.this, ShakeSayHiListUI.a(ShakeSayHiListUI.this) + 8);
        ae.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).PY(ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        if (ShakeSayHiListUI.c(ShakeSayHiListUI.this) <= ShakeSayHiListUI.a(ShakeSayHiListUI.this))
        {
          ShakeSayHiListUI.d(ShakeSayHiListUI.this).removeFooterView(this.wFm);
          ae.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
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
            ShakeSayHiListUI.e(ShakeSayHiListUI.this).bdi();
            ShakeSayHiListUI.b(ShakeSayHiListUI.this).ZD();
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
    if (this.wFi == 0)
    {
      TextView localTextView = (TextView)findViewById(2131299468);
      localTextView.setText(2131762792);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.wFi > 0) && (this.limit < this.wFi)) {
      this.jfb.addFooterView((View)localObject);
    }
    this.zgB = new b(this, this.zes, this.limit);
    this.zgB.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(28546);
        int i = ShakeSayHiListUI.d(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(28546);
        return i;
      }
    });
    this.zgB.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28547);
        ShakeSayHiListUI.d(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28547);
      }
    });
    this.zgB.a(new MMSlideDelView.f()
    {
      public final void cQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(28548);
        if (paramAnonymousObject == null)
        {
          ae.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(28548);
          return;
        }
        d.aMO().aqU(paramAnonymousObject.toString());
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).a(null, null);
        AppMethodBeat.o(28548);
      }
    });
    this.jfb.setAdapter(this.zgB);
    this.jfb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28549);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousAdapterView = (ce)ShakeSayHiListUI.b(ShakeSayHiListUI.this).getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
        paramAnonymousView = bv.d.aVF(paramAnonymousAdapterView.field_content);
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.cUA);
        ((Intent)localObject).putExtra("Contact_Encryptusername", paramAnonymousView.Jhi);
        ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.fhy);
        ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
        ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.jhO);
        ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.jhN);
        ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.eQV);
        ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
        ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
        ((Intent)localObject).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
        ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
        if (bu.isNullOrNil(paramAnonymousAdapterView.field_sayhicontent)) {}
        for (paramAnonymousAdapterView = ShakeSayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = paramAnonymousAdapterView.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.xik);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.jhP);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.JgT);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.tIA);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          bc.aCg();
          paramAnonymousAdapterView = com.tencent.mm.model.c.azF().BH(paramAnonymousView.cUA);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.ght >= 0) && (!com.tencent.mm.contact.c.lO(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dto;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.shake.a.iUz.c((Intent)localObject, ShakeSayHiListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
      }
    });
    localObject = new l(this);
    this.jfb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28550);
        if (paramAnonymousInt < ShakeSayHiListUI.d(ShakeSayHiListUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(28550);
          return true;
        }
        this.oar.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeSayHiListUI.this, ShakeSayHiListUI.f(ShakeSayHiListUI.this));
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = ShakeSayHiListUI.d(ShakeSayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
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
    this.zgA = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.zgA == 1)
    {
      this.zes = d.aMO();
      setMMTitle(2131762791);
      this.wFj = this.zes.bVY();
      if (this.wFj != 0) {
        break label161;
      }
    }
    label161:
    for (int i = 8;; i = this.wFj)
    {
      this.limit = i;
      this.wFi = this.zes.getCount();
      paramBundle = this.zes;
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
    this.nCM = ((ce)this.zgB.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28556);
    this.zgB.dhl();
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
    if (this.zgB.oaf != null) {
      this.zgB.oaf.dhu();
    }
    AppMethodBeat.o(28557);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28555);
    super.onResume();
    if (this.wFi != this.zes.getCount())
    {
      this.wFi = this.zes.getCount();
      if (this.wFi == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.zgB.ZD();
    }
    this.zgB.notifyDataSetChanged();
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