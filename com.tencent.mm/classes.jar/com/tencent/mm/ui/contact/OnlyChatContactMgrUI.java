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
import com.tencent.mm.al.f;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bp;
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
  private EditText BkS;
  private ContactCountView KjK;
  private final String Kom;
  private a Kon;
  private SelectMemberScrollBar Koo;
  private Button Kop;
  private final int Koq;
  private final int Kor;
  private com.tencent.mm.g.b.a.g Kos;
  private final int Kot;
  private final int Kou;
  private final int Kov;
  private final int Kow;
  private TextView gWP;
  private Button jhi;
  private Button jis;
  private ListView jpT;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(194554);
    this.Kom = "intent_status_mgr";
    this.Koq = com.tencent.mm.n.g.acA().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.Kor = com.tencent.mm.n.g.acA().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.Kot = 0;
    this.Kou = 1;
    this.Kov = 2;
    this.Kow = 3;
    AppMethodBeat.o(194554);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.Kon.Zh();
    int i = this.Kon.getContactCount();
    this.KjK.setFixedContactCount(i);
    paramn = this.gWP;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramn.setVisibility(paramInt);
      paramn = this.Kop;
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
      boolean bool = a.a(this.Kon).contains(((com.tencent.mm.ui.contact.a.e)parama).username);
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
    return this.jpT;
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
      paramIntent = com.tencent.mm.plugin.label.e.dfn().aTa(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.Kor);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.Kos;
        paramIntent.dQr = paramIntent.t("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.Kos;
        paramIntent.dQq = paramIntent.t("selecttagname", com.tencent.mm.plugin.label.e.dfn().aol(String.valueOf(paramInt1)), true);
        AppMethodBeat.o(180073);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      paramIntent = bt.U(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((paramIntent == null) || (paramIntent.isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131755184), "", getString(2131755185), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194550);
          paramAnonymousDialogInterface = new c(paramIntent, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQk = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQn = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQs = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQs);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(2131755906);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(2131755504), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(194549);
              com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(194549);
            }
          }));
          AppMethodBeat.o(194550);
        }
      }, null, 2131099904);
      AppMethodBeat.o(180073);
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = bt.U(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      paramIntent = new c((List)localObject, 1, this.Koq);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramIntent, 0);
      this.Kos.dQk = ((List)localObject).size();
      this.Kos.dQn = this.Kon.getContactCount();
      this.Kos.dQs = (System.currentTimeMillis() - this.Kos.dQs);
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755502), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194551);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramIntent);
          AppMethodBeat.o(194551);
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
    this.jpT = ((ListView)findViewById(2131302228));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.gWP = ((TextView)findViewById(2131299475));
    this.Kon = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.Kon.KmP = true;
    }
    this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aen(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dQK())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.KoD.contains(paramAnonymousAdapterView))
          {
            paramAnonymousView.KoD.remove(paramAnonymousAdapterView);
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
          paramAnonymousView.KoD.add(paramAnonymousAdapterView);
          break;
          label275:
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          continue;
          if (w.Ad(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
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
            com.tencent.mm.bs.d.b(OnlyChatContactMgrUI.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
        }
      }
    });
    this.jpT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).aen(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dQK()) {
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
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.jpT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(180052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
    this.jpT.setAdapter(this.Kon);
    paramBundle = this.jpT;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.KjK = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.KjK.setFixedContactCount(this.Kon.getContactCount());
    paramBundle = this.gWP;
    if (this.Kon.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.Koo = ((SelectMemberScrollBar)findViewById(2131302231));
      this.Koo.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void vc(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.Kkm.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.Kkm.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.BkS = ((MMEditText)findViewById(2131304523));
      this.BkS.addTextChangedListener(new TextWatcher()
      {
        private av fTs;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.fTs.stopTimer();
          this.fTs.az(500L, 500L);
          AppMethodBeat.o(180056);
        }
      });
      this.jhi = ((Button)findViewById(2131296456));
      this.Kop = ((Button)findViewById(2131301242));
      this.jis = ((Button)findViewById(2131298954));
      this.jis.setEnabled(false);
      paramBundle = this.jhi;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.Kop;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.jis;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.Kop;
      if (this.Kon.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.jhi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180057);
        }
      });
      this.Kop.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new com.tencent.mm.g.b.a.g());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQj = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dQs = System.currentTimeMillis();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(194553);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(194553);
          return false;
        }
      });
      com.tencent.mm.kernel.g.ajD();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().a(this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(3990, this);
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
    com.tencent.mm.kernel.g.ajD();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(3990, this);
    this.Kon.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(180074);
    ad.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
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
        this.Kos.dQl = this.Kos.dQk;
        paramString = this.Kos;
        paramString.dQm = paramString.t("modifiedsucfriendlist", bt.m(localc.ieF, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.Kos.dQo = (this.Kos.dQn + localc.ieF.size());; this.Kos.dQo = (this.Kos.dQn - localc.ieF.size()))
      {
        this.Kos.dQp = 1L;
        paramString = this.Kos;
        paramString.dQt = paramString.t("sessionid", hashCode(), true);
        this.Kos.aLk();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = 2131755667;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.aXO(bt.bI(paramn.getReqResp().getRespObj().getErrMsg(), getString(2131755570))).yU(true).aXT(getString(2131762023)).afp(2131762024);
      paramString.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(194552);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.iM(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.bs.d.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(194552);
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
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.ieH - localc.ieF.size()) });
      }
    }
    for (;;)
    {
      paramString = locala.aXO(paramString);
      paramString.EgK = true;
      paramString.afp(2131755835);
      locala.b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = 2131755666;
      break;
      paramString = paramn.getReqResp().getRespObj().getErrMsg();
      if (bt.isNullOrNil(paramString))
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
    HashMap<String, Integer> Kkm;
    private SparseArray<String> Kkn;
    List<String> KoD;
    private Cursor iVJ;
    String query;
    
    public a(n paramn)
    {
      super(null, true, false);
      AppMethodBeat.i(180061);
      this.Kkm = new HashMap();
      this.Kkn = new SparseArray();
      this.query = "";
      this.KoD = new LinkedList();
      Zh();
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
    
    public final void Zh()
    {
      AppMethodBeat.i(180062);
      super.Zh();
      if (this.iVJ != null)
      {
        this.iVJ.close();
        this.iVJ = null;
      }
      this.Kkm.clear();
      this.Kkn.clear();
      com.tencent.mm.kernel.g.ajD();
      this.iVJ = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().d(null, this.query, "@social.black.android", "", this.fSL);
      String[] arrayOfString = w.a(null, "@social.black.android", "", this.query, this.fSL);
      int[] arrayOfInt = w.a(null, "@social.black.android", "", this.fSL, this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.Kkm.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.Kkn.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      ad.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iVJ.getCount()), this.Kkm.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final int aWM(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.Kkm != null)
      {
        if (this.Kkm.containsKey(paramString))
        {
          int i = ((Integer)this.Kkm.get(paramString)).intValue();
          int j = this.KmO.getContentLV().getHeaderViewsCount();
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
      ad.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
      if (this.iVJ != null)
      {
        this.iVJ.close();
        this.iVJ = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.iVJ != null)
      {
        int i = this.iVJ.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.iVJ.getCount();
      if (this.Kkn == null) {}
      for (int i = 0;; i = this.Kkn.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a rh(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = cS(paramInt, OnlyChatContactMgrUI.this.getString(2131755186));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.Kkn.indexOfKey(paramInt) >= 0)
      {
        localObject = cS(paramInt, (String)this.Kkn.get(paramInt));
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
        if (i > this.Kkn.size()) {
          break;
        }
        j = i;
        if (this.Kkn.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iVJ.moveToPosition(i))
      {
        ad.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new am();
        ((am)localObject).convertFrom(this.iVJ);
        com.tencent.mm.ui.contact.a.e locale = new com.tencent.mm.ui.contact.a.e(paramInt);
        locale.contact = ((am)localObject);
        if (w.vF(((aw)localObject).field_username))
        {
          locale.KmP = false;
          locale.KmQ = false;
          locale.KqG = false;
        }
        for (locale.KqV = true;; locale.KqV = false)
        {
          AppMethodBeat.o(180064);
          return locale;
          locale.KmP = dQK();
          locale.KmQ = this.KmQ;
        }
      }
      ad.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(180064);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */