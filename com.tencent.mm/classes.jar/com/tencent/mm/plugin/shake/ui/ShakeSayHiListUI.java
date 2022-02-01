package com.tencent.mm.plugin.shake.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;

public class ShakeSayHiListUI
  extends MMActivity
{
  private int Mpv;
  private int Mpw;
  private cq PBJ;
  private int PEs;
  private b PEt;
  private int limit;
  private ListView pRl;
  private long vaU;
  private u.i vzr;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(28553);
    this.PEs = 0;
    this.PBJ = null;
    this.limit = 0;
    this.Mpv = 0;
    this.Mpw = 0;
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28543);
        com.tencent.mm.modelverify.d.bNK().aLy(String.valueOf(ShakeSayHiListUI.h(ShakeSayHiListUI.this)));
        ShakeSayHiListUI.c(ShakeSayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28543);
      }
    };
    AppMethodBeat.o(28553);
  }
  
  public int getLayoutId()
  {
    return R.i.lbs_say_hi_list;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28559);
    Object localObject = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
    this.pRl = ((ListView)findViewById(R.h.say_hi_lv));
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28542);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ShakeSayHiListUI.a(ShakeSayHiListUI.this);
        Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.b(ShakeSayHiListUI.this));
        ShakeSayHiListUI.c(ShakeSayHiListUI.this).ajh(ShakeSayHiListUI.b(ShakeSayHiListUI.this));
        if (ShakeSayHiListUI.d(ShakeSayHiListUI.this) <= ShakeSayHiListUI.b(ShakeSayHiListUI.this))
        {
          ShakeSayHiListUI.e(ShakeSayHiListUI.this).removeFooterView(this.Mpz);
          Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.b(ShakeSayHiListUI.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28542);
      }
    });
    addTextOptionMenu(0, getString(R.l.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28545);
        k.a(ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(R.l.say_hi_clean_all_title), "", ShakeSayHiListUI.this.getString(R.l.say_hi_clean_all_btn), ShakeSayHiListUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28544);
            ShakeSayHiListUI.f(ShakeSayHiListUI.this).cju();
            ShakeSayHiListUI.c(ShakeSayHiListUI.this).aNy();
            paramAnonymous2DialogInterface = (TextView)ShakeSayHiListUI.this.findViewById(R.h.empty_msg_tip_tv);
            paramAnonymous2DialogInterface.setText(R.l.say_hi_non);
            paramAnonymous2DialogInterface.setVisibility(0);
            ShakeSayHiListUI.this.enableOptionMenu(false);
            paramAnonymous2DialogInterface = new mz();
            com.tencent.mm.plugin.shake.a locala = com.tencent.mm.plugin.shake.a.PyM;
            com.tencent.mm.plugin.shake.a.a(152, paramAnonymous2DialogInterface);
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
    if (this.Mpv == 0)
    {
      TextView localTextView = (TextView)findViewById(R.h.empty_msg_tip_tv);
      localTextView.setText(R.l.say_hi_non);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.Mpv > 0) && (this.limit < this.Mpv)) {
      this.pRl.addFooterView((View)localObject);
    }
    this.PEt = new b(this, this.PBJ, this.limit);
    this.PEt.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(28546);
        int i = ShakeSayHiListUI.e(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(28546);
        return i;
      }
    });
    this.PEt.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28547);
        ShakeSayHiListUI.e(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28547);
      }
    });
    this.PEt.a(new MMSlideDelView.f()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(28548);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(28548);
          return;
        }
        com.tencent.mm.modelverify.d.bNK().aLy(paramAnonymousObject.toString());
        ShakeSayHiListUI.c(ShakeSayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28548);
      }
    });
    this.pRl.setAdapter(this.PEt);
    this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28549);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousAdapterView = (cp)ShakeSayHiListUI.c(ShakeSayHiListUI.this).getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
        paramAnonymousView = cc.f.byv(paramAnonymousAdapterView.field_content);
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.hgk);
        ((Intent)localObject).putExtra("Contact_Encryptusername", paramAnonymousView.adkQ);
        ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.kDc);
        ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
        ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.pTY);
        ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.pTX);
        ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.sex);
        ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
        ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
        ((Intent)localObject).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
        ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
        int i;
        if (Util.isNullOrNil(paramAnonymousAdapterView.field_sayhicontent))
        {
          paramAnonymousAdapterView = ShakeSayHiListUI.this.getString(R.l.chatting_from_verify_lbs_tip);
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.MXS);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.pTZ);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.adkz);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.pPi);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          bh.bCz();
          paramAnonymousAdapterView = c.bzA().JE(paramAnonymousView.hgk);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.maN >= 0) && (!com.tencent.mm.contact.d.rs(paramAnonymousAdapterView.field_type)))
          {
            i = paramAnonymousView.hId;
            if ((i == 0) || (i == 2) || (i == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 31);
          if (!ShakeSayHiListUI.this.getIntent().getBooleanExtra("IntentNewSayHiMsg", false)) {
            break label631;
          }
          i = 3101;
          label512:
          ((Intent)localObject).putExtra("CONTACT_INFO_UI_SUB_SOURCE", i);
          com.tencent.mm.plugin.shake.b.pFn.c((Intent)localObject, ShakeSayHiListUI.this);
          paramAnonymousAdapterView = new mz();
          paramAnonymousAdapterView.jcG = (paramAnonymousInt + 1);
          localObject = paramAnonymousAdapterView.vv(paramAnonymousView.hgk);
          if (!Util.isNullOrNil(paramAnonymousView.signature)) {
            break label639;
          }
        }
        label631:
        label639:
        for (paramAnonymousLong = 1L;; paramAnonymousLong = 2L)
        {
          ((mz)localObject).jcJ = paramAnonymousLong;
          ((mz)localObject).jcH = paramAnonymousView.sex;
          paramAnonymousView = com.tencent.mm.plugin.shake.a.PyM;
          com.tencent.mm.plugin.shake.a.a(151, paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_sayhicontent;
          break;
          i = 3103;
          break label512;
        }
      }
    });
    localObject = new l(this);
    this.pRl.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28550);
        if (paramAnonymousInt < ShakeSayHiListUI.e(ShakeSayHiListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(28550);
          return true;
        }
        this.vzu.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeSayHiListUI.this, ShakeSayHiListUI.g(ShakeSayHiListUI.this));
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = ShakeSayHiListUI.e(ShakeSayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    this.PEs = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.PEs == 1)
    {
      this.PBJ = com.tencent.mm.modelverify.d.bNK();
      setMMTitle(R.l.gUb);
      this.Mpw = this.PBJ.dkF();
      if (this.Mpw != 0) {
        break label163;
      }
    }
    label163:
    for (int i = 8;; i = this.Mpw)
    {
      this.limit = i;
      this.Mpv = this.PBJ.getCount();
      paramBundle = this.PBJ;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(28554);
      return;
      setMMTitle(R.l.say_hi_list_lbs_title);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28560);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.vaU = ((cp)this.PEt.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
    AppMethodBeat.o(28560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28556);
    this.PEt.fSd();
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
    if (this.PEt.vzi != null) {
      this.PEt.vzi.fSm();
    }
    AppMethodBeat.o(28557);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28555);
    super.onResume();
    if (this.Mpv != this.PBJ.getCount())
    {
      this.Mpv = this.PBJ.getCount();
      if (this.Mpv == 0)
      {
        TextView localTextView = (TextView)findViewById(R.h.empty_msg_tip_tv);
        localTextView.setText(R.l.say_hi_non);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.PEt.aNy();
    }
    this.PEt.notifyDataSetChanged();
    AppMethodBeat.o(28555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */