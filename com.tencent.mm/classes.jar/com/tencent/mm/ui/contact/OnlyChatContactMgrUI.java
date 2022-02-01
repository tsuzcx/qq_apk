package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OnlyChatContactMgrUI
  extends MMActivity
  implements f, n.b, n
{
  private EditText BCr;
  private ContactCountView KGe;
  private final String KKG;
  private a KKH;
  private SelectMemberScrollBar KKI;
  private Button KKJ;
  private final int KKK;
  private final int KKL;
  private com.tencent.mm.g.b.a.g KKM;
  private final int KKN;
  private final int KKO;
  private final int KKP;
  private final int KKQ;
  private TextView gZC;
  private Button jkb;
  private Button jll;
  private ListView jsM;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(187955);
    this.KKG = "intent_status_mgr";
    this.KKK = com.tencent.mm.n.g.acL().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.KKL = com.tencent.mm.n.g.acL().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.KKN = 0;
    this.KKO = 1;
    this.KKP = 2;
    this.KKQ = 3;
    AppMethodBeat.o(187955);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.KKH.Zq();
    int i = this.KKH.getContactCount();
    this.KGe.setFixedContactCount(i);
    paramn = this.gZC;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramn.setVisibility(paramInt);
      paramn = this.KKJ;
      if (i > 0) {
        bool = true;
      }
      paramn.setEnabled(bool);
      AppMethodBeat.o(180072);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(180071);
    if ((parama instanceof com.tencent.mm.ui.contact.a.e))
    {
      boolean bool = a.a(this.KKH).contains(((com.tencent.mm.ui.contact.a.e)parama).username);
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
    return this.jsM;
  }
  
  public int getLayoutId()
  {
    return 2131495053;
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
      paramIntent = com.tencent.mm.plugin.label.e.dif().aUB(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.KKL);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.KKM;
        paramIntent.dRH = paramIntent.t("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.KKM;
        paramIntent.dRG = paramIntent.t("selecttagname", com.tencent.mm.plugin.label.e.dif().apn(String.valueOf(paramInt1)), true);
        AppMethodBeat.o(180073);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      paramIntent = bu.U(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((paramIntent == null) || (paramIntent.isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131755184), "", getString(2131755185), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187951);
          paramAnonymousDialogInterface = new c(paramIntent, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRA = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRD = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRI = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRI);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(2131755906);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(2131755504), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(187950);
              com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(187950);
            }
          }));
          AppMethodBeat.o(187951);
        }
      }, null, 2131099904);
      AppMethodBeat.o(180073);
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = bu.U(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      paramIntent = new c((List)localObject, 1, this.KKK);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramIntent, 0);
      this.KKM.dRA = ((List)localObject).size();
      this.KKM.dRD = this.KKH.getContactCount();
      this.KKM.dRI = (System.currentTimeMillis() - this.KKM.dRI);
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755502), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(187952);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramIntent);
          AppMethodBeat.o(187952);
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
    setMMTitle(2131755183);
    this.jsM = ((ListView)findViewById(2131302228));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.gZC = ((TextView)findViewById(2131299475));
    this.KKH = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.KKH.KJj = true;
    }
    this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aeW(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dUh())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.KKX.contains(paramAnonymousAdapterView))
          {
            paramAnonymousView.KKX.remove(paramAnonymousAdapterView);
            paramAnonymousView.notifyDataSetChanged();
            if (OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() <= 0) {
              break label275;
            }
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185) + "(" + OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() + ")");
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(true);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
          paramAnonymousView.KKX.add(paramAnonymousAdapterView);
          break;
          label275:
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          continue;
          if (x.AN(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
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
            com.tencent.mm.br.d.b(OnlyChatContactMgrUI.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
        }
      }
    });
    this.jsM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aeW(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dUh()) {
          new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new n.e
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(180049);
              paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, 2131757731);
              AppMethodBeat.o(180049);
            }
          }, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(180050);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              ((Intent)localObject).putExtra("view_mode", true);
              paramAnonymous2MenuItem = OnlyChatContactMgrUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.jsM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(180052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(180052);
          return false;
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, (int)paramAnonymousMotionEvent.getRawX());
          OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.jsM.setAdapter(this.KKH);
    paramBundle = this.jsM;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.KGe = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.KGe.setFixedContactCount(this.KKH.getContactCount());
    paramBundle = this.gZC;
    if (this.KKH.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.KKI = ((SelectMemberScrollBar)findViewById(2131302231));
      this.KKI.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void vy(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.KGG.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.KGG.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.BCr = ((MMEditText)findViewById(2131304523));
      this.BCr.addTextChangedListener(new TextWatcher()
      {
        private com.tencent.mm.sdk.platformtools.aw fVy;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.fVy.stopTimer();
          this.fVy.ay(500L, 500L);
          AppMethodBeat.o(180056);
        }
      });
      this.jkb = ((Button)findViewById(2131296456));
      this.KKJ = ((Button)findViewById(2131301242));
      this.jll = ((Button)findViewById(2131298954));
      this.jll.setEnabled(false);
      paramBundle = this.jkb;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.KKJ;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.jll;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.KKJ;
      if (this.KKH.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.jkb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180057);
        }
      });
      this.KKJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new com.tencent.mm.g.b.a.g());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRz = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dRI = System.currentTimeMillis();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187954);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(187954);
          return false;
        }
      });
      com.tencent.mm.kernel.g.ajS();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().a(this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(3990, this);
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
    com.tencent.mm.kernel.g.ajS();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(3990, this);
    this.KKH.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(180074);
    ae.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    if (!(paramn instanceof c))
    {
      AppMethodBeat.o(180074);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    c localc = (c)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localc.op == 1)
      {
        paramInt1 = 2131755661;
        Toast.makeText(this, getString(paramInt1), 0).show();
        this.KKM.dRB = this.KKM.dRA;
        paramString = this.KKM;
        paramString.dRC = paramString.t("modifiedsucfriendlist", bu.m(localc.ihx, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.KKM.dRE = (this.KKM.dRD + localc.ihx.size());; this.KKM.dRE = (this.KKM.dRD - localc.ihx.size()))
      {
        this.KKM.dRF = 1L;
        paramString = this.KKM;
        paramString.dRJ = paramString.t("sessionid", hashCode(), true);
        this.KKM.aLH();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = 2131755667;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.aZq(bu.bI(paramn.getReqResp().getRespObj().getErrMsg(), getString(2131755570))).zi(true).aZv(getString(2131762023)).afY(2131762024);
      paramString.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(187953);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ad.iR(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(187953);
        }
      }).show();
      AppMethodBeat.o(180074);
      return;
    }
    f.a locala = new f.a(this);
    if (paramInt2 == -3500) {
      if (localc.op == 1)
      {
        paramInt1 = 2131755619;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.ihz - localc.ihx.size()) });
      }
    }
    for (;;)
    {
      paramString = locala.aZq(paramString);
      paramString.EyN = true;
      paramString.afY(2131755835);
      locala.b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = 2131755666;
      break;
      paramString = paramn.getReqResp().getRespObj().getErrMsg();
      if (bu.isNullOrNil(paramString))
      {
        if (localc.op == 1) {}
        for (paramInt1 = 2131755570;; paramInt1 = 2131755665)
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
    extends q
  {
    HashMap<String, Integer> KGG;
    private SparseArray<String> KGH;
    List<String> KKX;
    private Cursor iYC;
    String query;
    
    public a(n paramn)
    {
      super(null, true, false);
      AppMethodBeat.i(180061);
      this.KGG = new HashMap();
      this.KGH = new SparseArray();
      this.query = "";
      this.KKX = new LinkedList();
      Zq();
      AppMethodBeat.o(180061);
    }
    
    private static com.tencent.mm.ui.contact.a.a cS(int paramInt, String paramString)
    {
      AppMethodBeat.i(180065);
      com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
      localh.header = paramString;
      AppMethodBeat.o(180065);
      return localh;
    }
    
    public final void Zq()
    {
      AppMethodBeat.i(180062);
      super.Zq();
      if (this.iYC != null)
      {
        this.iYC.close();
        this.iYC = null;
      }
      this.KGG.clear();
      this.KGH.clear();
      com.tencent.mm.kernel.g.ajS();
      this.iYC = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().d(null, this.query, "@social.black.android", "", this.fUR);
      String[] arrayOfString = x.a(null, "@social.black.android", "", this.query, this.fUR);
      int[] arrayOfInt = x.a(null, "@social.black.android", "", this.fUR, this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.KGG.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.KGH.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      ae.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iYC.getCount()), this.KGG.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final int aYn(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.KGG != null)
      {
        if (this.KGG.containsKey(paramString))
        {
          int i = ((Integer)this.KGG.get(paramString)).intValue();
          int j = this.KJi.getContentLV().getHeaderViewsCount();
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
      ae.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
      if (this.iYC != null)
      {
        this.iYC.close();
        this.iYC = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.iYC != null)
      {
        int i = this.iYC.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.iYC.getCount();
      if (this.KGH == null) {}
      for (int i = 0;; i = this.KGH.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a rk(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = cS(paramInt, OnlyChatContactMgrUI.this.getString(2131755186));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.KGH.indexOfKey(paramInt) >= 0)
      {
        localObject = cS(paramInt, (String)this.KGH.get(paramInt));
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
        if (i > this.KGH.size()) {
          break;
        }
        j = i;
        if (this.KGH.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iYC.moveToPosition(i))
      {
        ae.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new an();
        ((an)localObject).convertFrom(this.iYC);
        com.tencent.mm.ui.contact.a.e locale = new com.tencent.mm.ui.contact.a.e(paramInt);
        locale.contact = ((an)localObject);
        if (x.wb(((com.tencent.mm.g.c.aw)localObject).field_username))
        {
          locale.KJj = false;
          locale.KJk = false;
          locale.KNa = false;
        }
        for (locale.KNp = true;; locale.KNp = false)
        {
          AppMethodBeat.o(180064);
          return locale;
          locale.KJj = dUh();
          locale.KJk = this.KJk;
        }
      }
      ae.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(180064);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */