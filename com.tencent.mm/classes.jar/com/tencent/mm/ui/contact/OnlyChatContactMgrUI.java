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
import com.tencent.mm.bs.d;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OnlyChatContactMgrUI
  extends MMActivity
  implements com.tencent.mm.al.g, n.b, n
{
  private ContactCountView GSS;
  private final int GXA;
  private final String GXq;
  private a GXr;
  private SelectMemberScrollBar GXs;
  private Button GXt;
  private final int GXu;
  private final int GXv;
  private com.tencent.mm.g.b.a.e GXw;
  private final int GXx;
  private final int GXy;
  private final int GXz;
  private Button inT;
  private Button ipd;
  private ListView iwH;
  private int mUE;
  private int mUF;
  private TextView qcD;
  private com.tencent.mm.ui.base.p tipDialog;
  private EditText yFZ;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(191675);
    this.GXq = "intent_status_mgr";
    this.GXu = com.tencent.mm.m.g.Zd().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.GXv = com.tencent.mm.m.g.Zd().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.GXx = 0;
    this.GXy = 1;
    this.GXz = 2;
    this.GXA = 3;
    AppMethodBeat.o(191675);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.GXr.VP();
    int i = this.GXr.getContactCount();
    this.GSS.setFixedContactCount(i);
    paramn = this.qcD;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramn.setVisibility(paramInt);
      paramn = this.GXt;
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
      boolean bool = a.a(this.GXr).contains(((com.tencent.mm.ui.contact.a.e)parama).username);
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
    return this.iwH;
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
      paramIntent = com.tencent.mm.plugin.label.e.cIR().aHN(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.GXv);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.GXw;
        paramIntent.dFH = paramIntent.t("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.GXw;
        paramIntent.dFG = paramIntent.t("selecttagname", com.tencent.mm.plugin.label.e.cIR().aeH(String.valueOf(paramInt1)), true);
        AppMethodBeat.o(180073);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      paramIntent = bt.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((paramIntent == null) || (paramIntent.isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131755184), "", getString(2131755185), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191671);
          paramAnonymousDialogInterface = new c(paramIntent, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFA = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFD = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFI = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFI);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(2131755906);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(2131755504), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(191670);
              com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(191670);
            }
          }));
          AppMethodBeat.o(191671);
        }
      }, null, 2131099904);
      AppMethodBeat.o(180073);
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = bt.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      paramIntent = new c((List)localObject, 1, this.GXu);
      com.tencent.mm.kernel.g.afA().gcy.a(paramIntent, 0);
      this.GXw.dFA = ((List)localObject).size();
      this.GXw.dFD = this.GXr.getContactCount();
      this.GXw.dFI = (System.currentTimeMillis() - this.GXw.dFI);
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755502), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(191672);
          com.tencent.mm.kernel.g.afA().gcy.a(paramIntent);
          AppMethodBeat.o(191672);
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
    this.iwH = ((ListView)findViewById(2131302228));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.qcD = ((TextView)findViewById(2131299475));
    this.GXr = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.GXr.GVT = true;
    }
    this.iwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).ZC(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dqZ())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.GXH.contains(paramAnonymousAdapterView)) {
            paramAnonymousView.GXH.remove(paramAnonymousAdapterView);
          }
          for (;;)
          {
            paramAnonymousView.notifyDataSetChanged();
            if (OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() <= 0) {
              break;
            }
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185) + "(" + OnlyChatContactMgrUI.a.a(OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this)).size() + ")");
            OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(true);
            AppMethodBeat.o(180048);
            return;
            paramAnonymousView.GXH.add(paramAnonymousAdapterView);
          }
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          AppMethodBeat.o(180048);
          return;
        }
        if (w.td(paramAnonymousAdapterView))
        {
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
          paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
          paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
        paramAnonymousView.putExtra("Contact_Scene", 3);
        paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
        if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
          d.b(OnlyChatContactMgrUI.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
        }
        AppMethodBeat.o(180048);
      }
    });
    this.iwH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).ZC(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dqZ()) {
          new com.tencent.mm.ui.widget.b.a(OnlyChatContactMgrUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new n.d
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(180049);
              paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, 2131757731);
              AppMethodBeat.o(180049);
            }
          }, new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(180050);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(OnlyChatContactMgrUI.this.getContext(), ContactRemarkInfoModUI.class);
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              ((Intent)localObject).putExtra("view_mode", true);
              paramAnonymous2MenuItem = OnlyChatContactMgrUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.iwH.setOnTouchListener(new View.OnTouchListener()
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
    this.iwH.setAdapter(this.GXr);
    paramBundle = this.iwH;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.GSS = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.GSS.setFixedContactCount(this.GXr.getContactCount());
    paramBundle = this.qcD;
    if (this.GXr.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.GXs = ((SelectMemberScrollBar)findViewById(2131302231));
      this.GXs.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void pb(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.GTv.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.GTv.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.yFZ = ((MMEditText)findViewById(2131304523));
      this.yFZ.addTextChangedListener(new TextWatcher()
      {
        private av fwv;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.fwv.stopTimer();
          this.fwv.av(500L, 500L);
          AppMethodBeat.o(180056);
        }
      });
      this.inT = ((Button)findViewById(2131296456));
      this.GXt = ((Button)findViewById(2131301242));
      this.ipd = ((Button)findViewById(2131298954));
      this.ipd.setEnabled(false);
      paramBundle = this.inT;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.GXt;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.ipd;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.GXt;
      if (this.GXr.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.inT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          AppMethodBeat.o(180057);
        }
      });
      this.GXt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180058);
          OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this, new com.tencent.mm.g.b.a.e());
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this, SelectContactsFromRangeUI.class);
          paramAnonymousView.putExtra("intent_status_mgr", true);
          paramAnonymousView.putExtra("list_type", 16);
          paramAnonymousView.putExtra("filter_type", "@social.black.android");
          OnlyChatContactMgrUI.this.startActivityForResult(paramAnonymousView, 2);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFz = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dFI = System.currentTimeMillis();
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(191674);
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(191674);
          return false;
        }
      });
      com.tencent.mm.kernel.g.afC();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(3990, this);
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
    com.tencent.mm.kernel.g.afC();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(3990, this);
    this.GXr.finish();
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
        this.GXw.dFB = this.GXw.dFA;
        paramString = this.GXw;
        paramString.dFC = paramString.t("modifiedsucfriendlist", bt.n(localc.hli, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.GXw.dFE = (this.GXw.dFD + localc.hli.size());; this.GXw.dFE = (this.GXw.dFD - localc.hli.size()))
      {
        this.GXw.dFF = 1L;
        paramString = this.GXw;
        paramString.dFJ = paramString.t("sessionid", hashCode(), true);
        this.GXw.aBj();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = 2131755667;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.aMo(bt.by(paramn.getReqResp().getRespObj().getErrMsg(), getString(2131755570))).wZ(true).aMt(getString(2131762023)).aaF(2131762024);
      paramString.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(191673);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.ir(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            d.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(191673);
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
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.hlk - localc.hli.size()) });
      }
    }
    for (;;)
    {
      paramString = locala.aMo(paramString);
      paramString.HFB = true;
      paramString.aaF(2131755835);
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
    HashMap<String, Integer> GTv;
    private SparseArray<String> GTw;
    List<String> GXH;
    private Cursor icq;
    String query;
    
    public a(n paramn)
    {
      super(null, true, false);
      AppMethodBeat.i(180061);
      this.GTv = new HashMap();
      this.GTw = new SparseArray();
      this.query = "";
      this.GXH = new LinkedList();
      VP();
      AppMethodBeat.o(180061);
    }
    
    private static com.tencent.mm.ui.contact.a.a cI(int paramInt, String paramString)
    {
      AppMethodBeat.i(180065);
      com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
      localh.header = paramString;
      AppMethodBeat.o(180065);
      return localh;
    }
    
    public final void VP()
    {
      AppMethodBeat.i(180062);
      super.VP();
      if (this.icq != null)
      {
        this.icq.close();
        this.icq = null;
      }
      this.GTv.clear();
      this.GTw.clear();
      com.tencent.mm.kernel.g.afC();
      this.icq = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().d(null, this.query, "@social.black.android", "", this.fvP);
      String[] arrayOfString = w.a(null, "@social.black.android", "", this.query, this.fvP);
      int[] arrayOfInt = w.a(null, "@social.black.android", "", this.fvP, this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.GTv.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.GTw.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      ad.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.icq.getCount()), this.GTv.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final int aLn(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.GTv != null)
      {
        if (this.GTv.containsKey(paramString))
        {
          int i = ((Integer)this.GTv.get(paramString)).intValue();
          int j = this.GVS.getContentLV().getHeaderViewsCount();
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
      if (this.icq != null)
      {
        this.icq.close();
        this.icq = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.icq != null)
      {
        int i = this.icq.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.icq.getCount();
      if (this.GTw == null) {}
      for (int i = 0;; i = this.GTw.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a pU(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = cI(paramInt, OnlyChatContactMgrUI.this.getString(2131755186));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.GTw.indexOfKey(paramInt) >= 0)
      {
        localObject = cI(paramInt, (String)this.GTw.get(paramInt));
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
        if (i > this.GTw.size()) {
          break;
        }
        j = i;
        if (this.GTw.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.icq.moveToPosition(i))
      {
        ad.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new af();
        ((af)localObject).convertFrom(this.icq);
        com.tencent.mm.ui.contact.a.e locale = new com.tencent.mm.ui.contact.a.e(paramInt);
        locale.contact = ((af)localObject);
        if (w.pF(((au)localObject).field_username))
        {
          locale.GVT = false;
          locale.GVU = false;
          locale.GZk = false;
        }
        for (locale.GZx = true;; locale.GZx = false)
        {
          AppMethodBeat.o(180064);
          return locale;
          locale.GVT = dqZ();
          locale.GVU = this.GVU;
        }
      }
      ad.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(180064);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */