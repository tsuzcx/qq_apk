package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ly;
import com.tencent.mm.autogen.mmdata.rpt.ae;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.label.d;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OnlyChatContactMgrUI
  extends MMActivity
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange, o
{
  private EditText Cxu;
  private final String JUI;
  private SelectMemberScrollBar JUz;
  private final int JXM;
  private ContactCountView afbn;
  private a afgB;
  private Button afgC;
  private final int afgD;
  private ae afgE;
  private final int afgF;
  private final int afgG;
  private final int afgH;
  private final int afgI;
  private TextView njO;
  private Button pWl;
  private Button pYm;
  private ListView qgc;
  private com.tencent.mm.ui.base.w tipDialog;
  private int x_down;
  private int y_down;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(252767);
    this.JUI = "intent_status_mgr";
    this.JXM = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.afgD = i.aRC().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.afgF = 0;
    this.afgG = 1;
    this.afgH = 2;
    this.afgI = 3;
    AppMethodBeat.o(252767);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(180071);
    if ((parama instanceof com.tencent.mm.ui.contact.a.f))
    {
      boolean bool = a.a(this.afgB).contains(((com.tencent.mm.ui.contact.a.f)parama).username);
      AppMethodBeat.o(180071);
      return bool;
    }
    AppMethodBeat.o(180071);
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.qgc;
  }
  
  public int getLayoutId()
  {
    return R.i.gmK;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(180073);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(180073);
      return;
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      paramInt1 = paramIntent.getIntExtra("label_id", 0);
      paramIntent = d.fTa().bxk(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.afgD);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.afgE;
        paramIntent.inv = paramIntent.F("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.afgE;
        paramIntent.inu = paramIntent.F("selecttagname", d.fTa().aJG(String.valueOf(paramInt1)), true);
        AppMethodBeat.o(180073);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((paramIntent == null) || (paramIntent.isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      k.a(this, getString(R.l.gqj), "", getString(R.l.gqk), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(252987);
          paramAnonymousDialogInterface = new com.tencent.mm.modelmulti.h(paramIntent, 8388608, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ino = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).inr = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).inw = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).inw);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(R.l.app_tip);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, k.a(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(R.l.gql), true, new OnlyChatContactMgrUI.4.1(this, paramAnonymousDialogInterface)));
          AppMethodBeat.o(252987);
        }
      }, null, R.e.alert_btn_color_warn);
      AppMethodBeat.o(180073);
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      paramIntent = new com.tencent.mm.modelmulti.h((List)localObject, 8388608, 1, this.JXM);
      com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
      this.afgE.ino = ((List)localObject).size();
      this.afgE.inr = this.afgB.getContactCount();
      this.afgE.inw = (System.currentTimeMillis() - this.afgE.inw);
      localObject = getContext();
      getString(R.l.app_tip);
      this.tipDialog = k.a((Context)localObject, getString(R.l.gqh), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(252977);
          com.tencent.mm.kernel.h.baD().mCm.a(paramIntent);
          AppMethodBeat.o(252977);
        }
      });
    }
    AppMethodBeat.o(180073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 8;
    boolean bool1 = false;
    AppMethodBeat.i(180069);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gqc);
    this.qgc = ((ListView)findViewById(R.h.fOe));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.njO = ((TextView)findViewById(R.h.empty_tip_tv));
    this.afgB = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.afgB.afey = true;
    }
    this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aDt(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).gZe())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.JXy.contains(paramAnonymousAdapterView))
          {
            paramAnonymousView.JXy.remove(paramAnonymousAdapterView);
            paramAnonymousView.notifyDataSetChanged();
            if (OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() <= 0) {
              break label276;
            }
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(R.l.gqk) + "(" + OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() + ")");
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(true);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
          paramAnonymousView.JXy.add(paramAnonymousAdapterView);
          break;
          label276:
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(R.l.gqk));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          continue;
          if (au.bwp(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(180048);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Contact_Scene", 3);
          paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
            com.tencent.mm.br.c.b(OnlyChatContactMgrUI.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
        }
      }
    });
    this.qgc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aDt(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).gZe()) {
          new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new u.i
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(180049);
              paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, R.l.gBA);
              AppMethodBeat.o(180049);
            }
          }, new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(180050);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              ((Intent)localObject).putExtra("view_mode", true);
              paramAnonymous2MenuItem = OnlyChatContactMgrUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.qgc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(180052);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(180052);
          return false;
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, (int)paramAnonymousMotionEvent.getRawX());
          OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.qgc.setAdapter(this.afgB);
    paramBundle = this.qgc;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.afbn = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.afbn.setFixedContactCount(this.afgB.getContactCount());
    paramBundle = this.njO;
    if (this.afgB.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.JUz = ((SelectMemberScrollBar)findViewById(R.h.fOf));
      this.JUz.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void onScollBarTouch(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.JUK.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.JUK.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.Cxu = ((MMEditText)findViewById(R.h.fVL));
      this.Cxu.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler lNo;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.lNo.stopTimer();
          this.lNo.startTimer(500L);
          AppMethodBeat.o(180056);
        }
      });
      this.pWl = ((Button)findViewById(R.h.add_btn));
      this.afgC = ((Button)findViewById(R.h.fLU));
      this.pYm = ((Button)findViewById(R.h.del_btn));
      this.pYm.setEnabled(false);
      paramBundle = this.pWl;
      if (!bool2) {
        break label541;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.afgC;
      if (!bool2) {
        break label546;
      }
    }
    label541:
    label546:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.pYm;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.afgC;
      if (this.afgB.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.pWl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180057);
        }
      });
      this.afgC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new ae());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).inn = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).inw = System.currentTimeMillis();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253013);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(253013);
          return false;
        }
      });
      com.tencent.mm.kernel.h.baF();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(3990, this);
      if (al.hgI().hlo().size() == 0)
      {
        paramBundle = new ly();
        paramBundle.hNP.hId = 1;
        paramBundle.publish();
      }
      AppMethodBeat.o(180069);
      return;
      i = 8;
      break;
      i = 0;
      break label344;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(180070);
    com.tencent.mm.kernel.h.baF();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(3990, this);
    this.afgB.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.afgB.aNm();
    int i = this.afgB.getContactCount();
    this.afbn.setFixedContactCount(i);
    paramMStorageEx = this.njO;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramMStorageEx.setVisibility(paramInt);
      paramMStorageEx = this.afgC;
      if (i > 0) {
        bool = true;
      }
      paramMStorageEx.setEnabled(bool);
      AppMethodBeat.o(180072);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(180074);
    Log.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    if (!(paramp instanceof com.tencent.mm.modelmulti.h))
    {
      AppMethodBeat.o(180074);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.modelmulti.h localh = (com.tencent.mm.modelmulti.h)paramp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localh.op == 1)
      {
        paramInt1 = R.l.gqq;
        Toast.makeText(this, getString(paramInt1), 0).show();
        this.afgE.inp = this.afgE.ino;
        paramString = this.afgE;
        paramString.inq = paramString.F("modifiedsucfriendlist", Util.listToString(localh.oLL, "#"), true);
        if (localh.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.afgE.ins = (this.afgE.inr + localh.oLL.size());; this.afgE.ins = (this.afgE.inr - localh.oLL.size()))
      {
        this.afgE.jdField_int = 1L;
        paramString = this.afgE;
        paramString.inx = paramString.F("sessionid", hashCode(), true);
        this.afgE.bMH();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = R.l.gqt;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new g.a(this);
      paramString.bDE(Util.nullAs(paramp.getReqResp().getRespObj().getErrMsg(), getString(R.l.gqo))).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
      paramString.c(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(252981);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(252981);
        }
      }).show();
      AppMethodBeat.o(180074);
      return;
    }
    g.a locala = new g.a(this);
    if (paramInt2 == -3500) {
      if (localh.op == 1)
      {
        paramInt1 = R.l.gqp;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localh.bKN()) });
      }
    }
    for (;;)
    {
      paramString = locala.bDE(paramString);
      paramString.Xdm = true;
      paramString.aEX(R.l.app_ok);
      locala.b(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = R.l.gqs;
      break;
      paramString = paramp.getReqResp().getRespObj().getErrMsg();
      if (Util.isNullOrNil(paramString))
      {
        if (localh.op == 1) {}
        for (paramInt1 = R.l.gqo;; paramInt1 = R.l.gqr)
        {
          paramString = getString(paramInt1);
          break;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r
  {
    HashMap<String, Integer> JUK;
    private SparseArray<String> JUL;
    List<String> JXy;
    private Cursor pKb;
    String query;
    
    public a(o paramo)
    {
      super(com.tencent.mm.pluginsdk.platformtools.a.iIW(), true, false);
      AppMethodBeat.i(180061);
      this.JUK = new HashMap();
      this.JUL = new SparseArray();
      this.query = "";
      this.JXy = new LinkedList();
      aNm();
      AppMethodBeat.o(180061);
    }
    
    private static com.tencent.mm.ui.contact.a.a cf(int paramInt, String paramString)
    {
      AppMethodBeat.i(180065);
      j localj = new j(paramInt);
      localj.header = paramString;
      AppMethodBeat.o(180065);
      return localj;
    }
    
    public final int aJM(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.JUK != null)
      {
        if (this.JUK.containsKey(paramString))
        {
          int i = ((Integer)this.JUK.get(paramString)).intValue();
          int j = this.afex.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(180063);
          return i + j;
        }
        AppMethodBeat.o(180063);
        return -1;
      }
      AppMethodBeat.o(180063);
      return -1;
    }
    
    public final void aNm()
    {
      AppMethodBeat.i(180062);
      super.aNm();
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      this.JUK.clear();
      this.JUL.clear();
      com.tencent.mm.kernel.h.baF();
      this.pKb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d(null, this.query, "@social.black.android", "", cVa());
      String[] arrayOfString = ab.a(null, "@social.black.android", "", this.query, cVa());
      int[] arrayOfInt = ab.a(null, "@social.black.android", "", cVa(), this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.JUK.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.JUL.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      Log.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.pKb.getCount()), this.JUK.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(180067);
      super.finish();
      Log.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.pKb != null)
      {
        int i = this.pKb.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.pKb.getCount();
      if (this.JUL == null) {}
      for (int i = 0;; i = this.JUL.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = cf(paramInt, OnlyChatContactMgrUI.this.getString(R.l.gqm));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.JUL.indexOfKey(paramInt) >= 0)
      {
        localObject = cf(paramInt, (String)this.JUL.get(paramInt));
        AppMethodBeat.o(180064);
        return localObject;
      }
      int k = paramInt;
      int i = 1;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.JUL.size()) {
          break;
        }
        j = i;
        if (this.JUL.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.pKb.moveToPosition(i))
      {
        Log.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new au();
        ((au)localObject).convertFrom(this.pKb);
        com.tencent.mm.ui.contact.a.f localf = new com.tencent.mm.ui.contact.a.f(paramInt);
        localf.contact = ((au)localObject);
        if (au.bwE(((com.tencent.mm.autogen.b.az)localObject).field_username))
        {
          localf.afey = false;
          localf.afez = false;
          localf.afjA = false;
        }
        for (localf.afjT = true;; localf.afjT = false)
        {
          AppMethodBeat.o(180064);
          return localf;
          localf.afey = gZe();
          localf.afez = jyD();
        }
      }
      Log.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(180064);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */