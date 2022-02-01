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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.f.b.a.aa;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OnlyChatContactMgrUI
  extends MMActivity
  implements i, MStorageEx.IOnStorageChange, o
{
  private ContactCountView XpL;
  private final String XuA;
  private a XuB;
  private SelectMemberScrollBar XuC;
  private Button XuD;
  private final int XuE;
  private final int XuF;
  private aa XuG;
  private final int XuH;
  private final int XuI;
  private final int XuJ;
  private final int XuK;
  private TextView kGU;
  private Button mZC;
  private Button nbe;
  private ListView niO;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.base.s tipDialog;
  private EditText xZi;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(284379);
    this.XuA = "intent_status_mgr";
    this.XuE = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.XuF = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.XuH = 0;
    this.XuI = 1;
    this.XuJ = 2;
    this.XuK = 3;
    AppMethodBeat.o(284379);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(180071);
    if ((parama instanceof com.tencent.mm.ui.contact.a.f))
    {
      boolean bool = a.a(this.XuB).contains(((com.tencent.mm.ui.contact.a.f)parama).username);
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
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.niO;
  }
  
  public int getLayoutId()
  {
    return R.i.ejJ;
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
      paramIntent = e.eLd().bvX(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.XuF);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.XuG;
        paramIntent.ggy = paramIntent.z("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.XuG;
        paramIntent.ggx = paramIntent.z("selecttagname", e.eLd().aMN(String.valueOf(paramInt1)), true);
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
      com.tencent.mm.ui.base.h.a(this, getString(R.l.eni), "", getString(R.l.enj), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(279675);
          paramAnonymousDialogInterface = new com.tencent.mm.modelmulti.c(paramIntent, 8388608, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggr = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggu = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggz = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggz);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(R.l.app_tip);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(R.l.enk), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(283456);
              com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(283456);
            }
          }));
          AppMethodBeat.o(279675);
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
      paramIntent = new com.tencent.mm.modelmulti.c((List)localObject, 8388608, 1, this.XuE);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
      this.XuG.ggr = ((List)localObject).size();
      this.XuG.ggu = this.XuB.getContactCount();
      this.XuG.ggz = (System.currentTimeMillis() - this.XuG.ggz);
      localObject = getContext();
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(R.l.eng), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(291496);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent);
          AppMethodBeat.o(291496);
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
    setMMTitle(R.l.ena);
    this.niO = ((ListView)findViewById(R.h.dMv));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.kGU = ((TextView)findViewById(R.h.empty_tip_tv));
    this.XuB = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.XuB.XsX = true;
    }
    this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).awM(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).fJk())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.Eec.contains(paramAnonymousAdapterView))
          {
            paramAnonymousView.Eec.remove(paramAnonymousAdapterView);
            paramAnonymousView.notifyDataSetChanged();
            if (OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() <= 0) {
              break label276;
            }
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(R.l.enj) + "(" + OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() + ")");
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(true);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
          paramAnonymousView.Eec.add(paramAnonymousAdapterView);
          break;
          label276:
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(R.l.enj));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          continue;
          if (ab.QL(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
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
            com.tencent.mm.by.c.b(OnlyChatContactMgrUI.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
        }
      }
    });
    this.niO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).awM(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).fJk()) {
          new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new q.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(180049);
              paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, R.l.eyI);
              AppMethodBeat.o(180049);
            }
          }, new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(180050);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              ((Intent)localObject).putExtra("view_mode", true);
              paramAnonymous2MenuItem = OnlyChatContactMgrUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.niO.setOnTouchListener(new View.OnTouchListener()
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
    this.niO.setAdapter(this.XuB);
    paramBundle = this.niO;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.XpL = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.XpL.setFixedContactCount(this.XuB.getContactCount());
    paramBundle = this.kGU;
    if (this.XuB.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.XuC = ((SelectMemberScrollBar)findViewById(R.h.dMw));
      this.XuC.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void KH(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.Xqo.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.Xqo.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.xZi = ((MMEditText)findViewById(R.h.dTD));
      this.xZi.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler jkK;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.jkK.stopTimer();
          this.jkK.startTimer(500L);
          AppMethodBeat.o(180056);
        }
      });
      this.mZC = ((Button)findViewById(R.h.add_btn));
      this.XuD = ((Button)findViewById(R.h.dKw));
      this.nbe = ((Button)findViewById(R.h.del_btn));
      this.nbe.setEnabled(false);
      paramBundle = this.mZC;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.XuD;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.nbe;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.XuD;
      if (this.XuB.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.mZC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180057);
        }
      });
      this.XuD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new aa());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggq = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).ggz = System.currentTimeMillis();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(288051);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(288051);
          return false;
        }
      });
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(3990, this);
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
    com.tencent.mm.kernel.h.aHH();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(3990, this);
    this.XuB.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.XuB.ate();
    int i = this.XuB.getContactCount();
    this.XpL.setFixedContactCount(i);
    paramMStorageEx = this.kGU;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramMStorageEx.setVisibility(paramInt);
      paramMStorageEx = this.XuD;
      if (i > 0) {
        bool = true;
      }
      paramMStorageEx.setEnabled(bool);
      AppMethodBeat.o(180072);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(180074);
    Log.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    if (!(paramq instanceof com.tencent.mm.modelmulti.c))
    {
      AppMethodBeat.o(180074);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.modelmulti.c localc = (com.tencent.mm.modelmulti.c)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localc.op == 1)
      {
        paramInt1 = R.l.enp;
        Toast.makeText(this, getString(paramInt1), 0).show();
        this.XuG.ggs = this.XuG.ggr;
        paramString = this.XuG;
        paramString.ggt = paramString.z("modifiedsucfriendlist", Util.listToString(localc.lSS, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.XuG.ggv = (this.XuG.ggu + localc.lSS.size());; this.XuG.ggv = (this.XuG.ggu - localc.lSS.size()))
      {
        this.XuG.ggw = 1L;
        paramString = this.XuG;
        paramString.ggA = paramString.z("sessionid", hashCode(), true);
        this.XuG.bpa();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = R.l.ens;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.bBl(Util.nullAs(paramq.getReqResp().getRespObj().getErrMsg(), getString(R.l.enn))).HL(true).bBq(getString(R.l.ePC)).ayp(R.l.ePD);
      paramString.c(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(284799);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.by.c.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(284799);
        }
      }).show();
      AppMethodBeat.o(180074);
      return;
    }
    f.a locala = new f.a(this);
    if (paramInt2 == -3500) {
      if (localc.op == 1)
      {
        paramInt1 = R.l.eno;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.bnc()) });
      }
    }
    for (;;)
    {
      paramString = locala.bBl(paramString);
      paramString.Qlf = true;
      paramString.ayp(R.l.app_ok);
      locala.b(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = R.l.enr;
      break;
      paramString = paramq.getReqResp().getRespObj().getErrMsg();
      if (Util.isNullOrNil(paramString))
      {
        if (localc.op == 1) {}
        for (paramInt1 = R.l.enn;; paramInt1 = R.l.enq)
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
    List<String> Eec;
    HashMap<String, Integer> Xqo;
    private SparseArray<String> Xqp;
    private Cursor mNt;
    String query;
    
    public a(o paramo)
    {
      super(com.tencent.mm.pluginsdk.j.a.hhV(), true, false);
      AppMethodBeat.i(180061);
      this.Xqo = new HashMap();
      this.Xqp = new SparseArray();
      this.query = "";
      this.Eec = new LinkedList();
      ate();
      AppMethodBeat.o(180061);
    }
    
    private static com.tencent.mm.ui.contact.a.a dm(int paramInt, String paramString)
    {
      AppMethodBeat.i(180065);
      j localj = new j(paramInt);
      localj.header = paramString;
      AppMethodBeat.o(180065);
      return localj;
    }
    
    public final void ate()
    {
      AppMethodBeat.i(180062);
      super.ate();
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      this.Xqo.clear();
      this.Xqp.clear();
      com.tencent.mm.kernel.h.aHH();
      this.mNt = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(null, this.query, "@social.black.android", "", csq());
      String[] arrayOfString = ab.a(null, "@social.black.android", "", this.query, csq());
      int[] arrayOfInt = ab.a(null, "@social.black.android", "", csq(), this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.Xqo.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.Xqp.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      Log.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.mNt.getCount()), this.Xqo.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final int bzR(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.Xqo != null)
      {
        if (this.Xqo.containsKey(paramString))
        {
          int i = ((Integer)this.Xqo.get(paramString)).intValue();
          int j = this.XsW.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(180063);
          return i + j;
        }
        AppMethodBeat.o(180063);
        return -1;
      }
      AppMethodBeat.o(180063);
      return -1;
    }
    
    public final void finish()
    {
      AppMethodBeat.i(180067);
      super.finish();
      Log.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.mNt != null)
      {
        int i = this.mNt.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.mNt.getCount();
      if (this.Xqp == null) {}
      for (int i = 0;; i = this.Xqp.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = dm(paramInt, OnlyChatContactMgrUI.this.getString(R.l.enl));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.Xqp.indexOfKey(paramInt) >= 0)
      {
        localObject = dm(paramInt, (String)this.Xqp.get(paramInt));
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
        if (i > this.Xqp.size()) {
          break;
        }
        j = i;
        if (this.Xqp.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.mNt.moveToPosition(i))
      {
        Log.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new as();
        ((as)localObject).convertFrom(this.mNt);
        com.tencent.mm.ui.contact.a.f localf = new com.tencent.mm.ui.contact.a.f(paramInt);
        localf.contact = ((as)localObject);
        if (ab.Lj(((com.tencent.mm.f.c.ax)localObject).field_username))
        {
          localf.XsX = false;
          localf.XsY = false;
          localf.Xxs = false;
        }
        for (localf.XxM = true;; localf.XxM = false)
        {
          AppMethodBeat.o(180064);
          return localf;
          localf.XsX = fJk();
          localf.XsY = hUO();
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