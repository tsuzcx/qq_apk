package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.f;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.sns.b.o;
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
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnlyChatContactMgrUI
  extends MMActivity
  implements i, MStorageEx.IOnStorageChange, n
{
  private EditText FNd;
  private ContactCountView PTa;
  private final String PXH;
  private OnlyChatContactMgrUI.a PXI;
  private SelectMemberScrollBar PXJ;
  private Button PXK;
  private final int PXL;
  private final int PXM;
  private com.tencent.mm.g.b.a.u PXN;
  private final int PXO;
  private final int PXP;
  private final int PXQ;
  private final int PXR;
  private TextView hSx;
  private Button kid;
  private Button kjo;
  private ListView krb;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(234013);
    this.PXH = "intent_status_mgr";
    this.PXL = com.tencent.mm.n.h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.PXM = com.tencent.mm.n.h.aqJ().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.PXO = 0;
    this.PXP = 1;
    this.PXQ = 2;
    this.PXR = 3;
    AppMethodBeat.o(234013);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(180071);
    if ((parama instanceof com.tencent.mm.ui.contact.a.e))
    {
      boolean bool = OnlyChatContactMgrUI.a.a(this.PXI).contains(((com.tencent.mm.ui.contact.a.e)parama).username);
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
    return this.krb;
  }
  
  public int getLayoutId()
  {
    return 2131495885;
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
      paramIntent = com.tencent.mm.plugin.label.e.ecf().bjA(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.PXM);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.PXN;
        paramIntent.elq = paramIntent.x("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.PXN;
        paramIntent.elp = paramIntent.x("selecttagname", com.tencent.mm.plugin.label.e.ecf().aCG(String.valueOf(paramInt1)), true);
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
      com.tencent.mm.ui.base.h.a(this, getString(2131755208), "", getString(2131755209), getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234009);
          paramAnonymousDialogInterface = new com.tencent.mm.modelmulti.c(paramIntent, 8388608, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          g.aAg().hqi.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).elj = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).elm = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).elr = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).elr);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(2131755998);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(2131755210), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(234008);
              g.aAg().hqi.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(234008);
            }
          }));
          AppMethodBeat.o(234009);
        }
      }, null, 2131099922);
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
      paramIntent = new com.tencent.mm.modelmulti.c((List)localObject, 8388608, 1, this.PXL);
      g.aAg().hqi.a(paramIntent, 0);
      this.PXN.elj = ((List)localObject).size();
      this.PXN.elm = this.PXI.getContactCount();
      this.PXN.elr = (System.currentTimeMillis() - this.PXN.elr);
      localObject = getContext();
      getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131755206), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(234010);
          g.aAg().hqi.a(paramIntent);
          AppMethodBeat.o(234010);
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
    setMMTitle(2131755201);
    this.krb = ((ListView)findViewById(2131304594));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.hSx = ((TextView)findViewById(2131300105));
    this.PXI = new OnlyChatContactMgrUI.a(this, this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.PXI.PWh = true;
    }
    this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).anH(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).eWh())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.PXY.contains(paramAnonymousAdapterView))
          {
            paramAnonymousView.PXY.remove(paramAnonymousAdapterView);
            paramAnonymousView.notifyDataSetChanged();
            if (OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() <= 0) {
              break label275;
            }
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755209) + "(" + OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() + ")");
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(true);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
          paramAnonymousView.PXY.add(paramAnonymousAdapterView);
          break;
          label275:
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755209));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          continue;
          if (ab.Js(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).anH(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).eWh()) {
          new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new o.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(180049);
              paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, 2131757968);
              AppMethodBeat.o(180049);
            }
          }, new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(180050);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              ((Intent)localObject).putExtra("view_mode", true);
              paramAnonymous2MenuItem = OnlyChatContactMgrUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.krb.setOnTouchListener(new View.OnTouchListener()
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
    this.krb.setAdapter(this.PXI);
    paramBundle = this.krb;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.PTa = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.PTa.setFixedContactCount(this.PXI.getContactCount());
    paramBundle = this.hSx;
    if (this.PXI.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.PXJ = ((SelectMemberScrollBar)findViewById(2131304597));
      this.PXJ.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void DP(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.PTD.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.PTD.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.FNd = ((MMEditText)findViewById(2131307538));
      this.FNd.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler gAF;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.gAF.stopTimer();
          this.gAF.startTimer(500L);
          AppMethodBeat.o(180056);
        }
      });
      this.kid = ((Button)findViewById(2131296528));
      this.PXK = ((Button)findViewById(2131302936));
      this.kjo = ((Button)findViewById(2131299448));
      this.kjo.setEnabled(false);
      paramBundle = this.kid;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.PXK;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.kjo;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.PXK;
      if (this.PXI.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.kid.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180057);
        }
      });
      this.PXK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new com.tencent.mm.g.b.a.u());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).eli = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).elr = System.currentTimeMillis();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(234012);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(234012);
          return false;
        }
      });
      g.aAi();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this);
      g.aAi();
      g.aAg().hqi.a(3990, this);
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
    g.aAi();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
    g.aAi();
    g.aAg().hqi.b(3990, this);
    this.PXI.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.PXI.and();
    int i = this.PXI.getContactCount();
    this.PTa.setFixedContactCount(i);
    paramMStorageEx = this.hSx;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramMStorageEx.setVisibility(paramInt);
      paramMStorageEx = this.PXK;
      if (i > 0) {
        bool = true;
      }
      paramMStorageEx.setEnabled(bool);
      AppMethodBeat.o(180072);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
        paramInt1 = 2131755216;
        Toast.makeText(this, getString(paramInt1), 0).show();
        this.PXN.elk = this.PXN.elj;
        paramString = this.PXN;
        paramString.ell = paramString.x("modifiedsucfriendlist", Util.listToString(localc.jcs, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.PXN.eln = (this.PXN.elm + localc.jcs.size());; this.PXN.eln = (this.PXN.elm - localc.jcs.size()))
      {
        this.PXN.elo = 1L;
        paramString = this.PXN;
        paramString.els = paramString.x("sessionid", hashCode(), true);
        this.PXN.bfK();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = 2131755219;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.bow(Util.nullAs(paramq.getReqResp().getRespObj().getErrMsg(), getString(2131755214))).Dq(true).boB(getString(2131764037)).apa(2131764038);
      paramString.c(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(234011);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(234011);
        }
      }).show();
      AppMethodBeat.o(180074);
      return;
    }
    f.a locala = new f.a(this);
    if (paramInt2 == -3500) {
      if (localc.op == 1)
      {
        paramInt1 = 2131755215;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.jcu - localc.jcs.size()) });
      }
    }
    for (;;)
    {
      paramString = locala.bow(paramString);
      paramString.JnN = true;
      paramString.apa(2131755921);
      locala.b(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = 2131755218;
      break;
      paramString = paramq.getReqResp().getRespObj().getErrMsg();
      if (Util.isNullOrNil(paramString))
      {
        if (localc.op == 1) {}
        for (paramInt1 = 2131755214;; paramInt1 = 2131755217)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */