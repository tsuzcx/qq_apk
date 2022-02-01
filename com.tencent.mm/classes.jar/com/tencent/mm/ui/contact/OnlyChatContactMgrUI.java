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
import com.tencent.mm.br.d;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.g.j;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g, n.b, n
{
  private ContactCountView Ite;
  private final String IxE;
  private a IxF;
  private SelectMemberScrollBar IxG;
  private Button IxH;
  private final int IxI;
  private final int IxJ;
  private com.tencent.mm.g.b.a.e IxK;
  private final int IxL;
  private final int IxM;
  private final int IxN;
  private final int IxO;
  private TextView gDf;
  private Button iNZ;
  private Button iPj;
  private ListView iWK;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.base.p tipDialog;
  private EditText zTn;
  
  public OnlyChatContactMgrUI()
  {
    AppMethodBeat.i(196759);
    this.IxE = "intent_status_mgr";
    this.IxI = com.tencent.mm.m.g.ZY().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    this.IxJ = com.tencent.mm.m.g.ZY().getInt("MMBatchModContactTypeMaxNumForClient", 30);
    this.IxL = 0;
    this.IxM = 1;
    this.IxN = 2;
    this.IxO = 3;
    AppMethodBeat.o(196759);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(180072);
    this.IxF.WN();
    int i = this.IxF.getContactCount();
    this.Ite.setFixedContactCount(i);
    paramn = this.gDf;
    if (i == 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramn.setVisibility(paramInt);
      paramn = this.IxH;
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
      boolean bool = a.a(this.IxF).contains(((com.tencent.mm.ui.contact.a.e)parama).username);
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
    return this.iWK;
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
      paramIntent = com.tencent.mm.plugin.label.e.cWc().aNi(String.valueOf(paramInt1));
      localObject = new Intent(this, SelectContactsFromRangeUI.class);
      ((Intent)localObject).putExtra("list_type", 1);
      ((Intent)localObject).putExtra("filter_type", "@all.contact.android");
      if (paramIntent == null) {}
      for (paramIntent = new String[0];; paramIntent = (String[])paramIntent.toArray(new String[0]))
      {
        ((Intent)localObject).putExtra("already_select_contact", paramIntent);
        ((Intent)localObject).putExtra("max_limit_num", this.IxJ);
        startActivityForResult((Intent)localObject, 1);
        paramIntent = this.IxK;
        paramIntent.dDu = paramIntent.t("selecttagid", String.valueOf(paramInt1), true);
        paramIntent = this.IxK;
        paramIntent.dDt = paramIntent.t("selecttagname", com.tencent.mm.plugin.label.e.cWc().ajz(String.valueOf(paramInt1)), true);
        AppMethodBeat.o(180073);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      paramIntent = bs.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((paramIntent == null) || (paramIntent.isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131755184), "", getString(2131755185), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196755);
          paramAnonymousDialogInterface = new c(paramIntent, 2, OnlyChatContactMgrUI.k(OnlyChatContactMgrUI.this));
          com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface, 0);
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDn = paramIntent.size();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDq = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).getContactCount();
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDv = (System.currentTimeMillis() - OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDv);
          OnlyChatContactMgrUI localOnlyChatContactMgrUI = OnlyChatContactMgrUI.this;
          AppCompatActivity localAppCompatActivity = OnlyChatContactMgrUI.this.getContext();
          OnlyChatContactMgrUI.this.getString(2131755906);
          OnlyChatContactMgrUI.a(localOnlyChatContactMgrUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, OnlyChatContactMgrUI.this.getString(2131755504), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(196754);
              com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousDialogInterface);
              AppMethodBeat.o(196754);
            }
          }));
          AppMethodBeat.o(196755);
        }
      }, null, 2131099904);
      AppMethodBeat.o(180073);
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = bs.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(180073);
        return;
      }
      paramIntent = new c((List)localObject, 1, this.IxI);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramIntent, 0);
      this.IxK.dDn = ((List)localObject).size();
      this.IxK.dDq = this.IxF.getContactCount();
      this.IxK.dDv = (System.currentTimeMillis() - this.IxK.dDv);
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755502), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(196756);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramIntent);
          AppMethodBeat.o(196756);
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
    this.iWK = ((ListView)findViewById(2131302228));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180044);
        paramAnonymousView = OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(180044);
      }
    });
    this.gDf = ((TextView)findViewById(2131299475));
    this.IxF = new a(this);
    boolean bool2 = getIntent().getBooleanExtra("intent_status_mgr", false);
    if (bool2) {
      this.IxF.Iwh = true;
    }
    this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180048);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).abQ(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180048);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dFi())
        {
          paramAnonymousView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (paramAnonymousView.IxV.contains(paramAnonymousAdapterView)) {
            paramAnonymousView.IxV.remove(paramAnonymousAdapterView);
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
            paramAnonymousView.IxV.add(paramAnonymousAdapterView);
          }
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setText(OnlyChatContactMgrUI.this.getString(2131755185));
          OnlyChatContactMgrUI.c(OnlyChatContactMgrUI.this).setEnabled(false);
          AppMethodBeat.o(180048);
          return;
        }
        if (w.xg(paramAnonymousAdapterView))
        {
          paramAnonymousView = new Intent(OnlyChatContactMgrUI.this.getContext(), AddressUI.class);
          paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
          paramAnonymousAdapterView = OnlyChatContactMgrUI.this;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
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
    this.iWK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(180051);
        paramAnonymousAdapterView = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).abQ(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.e)))
        {
          AppMethodBeat.o(180051);
          return true;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.e)paramAnonymousAdapterView).username;
        if (!OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this).dFi()) {
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
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/OnlyChatContactMgrUI$3$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(180050);
            }
          }, OnlyChatContactMgrUI.d(OnlyChatContactMgrUI.this), OnlyChatContactMgrUI.e(OnlyChatContactMgrUI.this));
        }
        AppMethodBeat.o(180051);
        return true;
      }
    });
    this.iWK.setOnTouchListener(new View.OnTouchListener()
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
    this.iWK.setAdapter(this.IxF);
    paramBundle = this.iWK;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.Ite = localContactCountView;
    paramBundle.addFooterView(localContactCountView, null, false);
    this.Ite.setFixedContactCount(this.IxF.getContactCount());
    paramBundle = this.gDf;
    if (this.IxF.getContactCount() == 0)
    {
      i = 0;
      paramBundle.setVisibility(i);
      this.IxG = ((SelectMemberScrollBar)findViewById(2131302231));
      this.IxG.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void sn(String paramAnonymousString)
        {
          AppMethodBeat.i(180053);
          if ("↑".equals(paramAnonymousString))
          {
            OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(0);
            AppMethodBeat.o(180053);
            return;
          }
          OnlyChatContactMgrUI.a locala = OnlyChatContactMgrUI.b(OnlyChatContactMgrUI.this);
          if (locala.ItG.get(paramAnonymousString) == null) {}
          for (int i = -1;; i = ((Integer)locala.ItG.get(paramAnonymousString)).intValue())
          {
            if (i != -1) {
              OnlyChatContactMgrUI.a(OnlyChatContactMgrUI.this).setSelection(i);
            }
            AppMethodBeat.o(180053);
            return;
          }
        }
      });
      this.zTn = ((MMEditText)findViewById(2131304523));
      this.zTn.addTextChangedListener(new TextWatcher()
      {
        private au fAc;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(180056);
          this.fAc.stopTimer();
          this.fAc.au(500L, 500L);
          AppMethodBeat.o(180056);
        }
      });
      this.iNZ = ((Button)findViewById(2131296456));
      this.IxH = ((Button)findViewById(2131301242));
      this.iPj = ((Button)findViewById(2131298954));
      this.iPj.setEnabled(false);
      paramBundle = this.iNZ;
      if (!bool2) {
        break label506;
      }
      i = 8;
      label344:
      paramBundle.setVisibility(i);
      paramBundle = this.IxH;
      if (!bool2) {
        break label511;
      }
    }
    label506:
    label511:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle = this.iPj;
      i = j;
      if (bool2) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle = this.IxH;
      if (this.IxF.getContactCount() > 0) {
        bool1 = true;
      }
      paramBundle.setEnabled(bool1);
      this.iNZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(180057);
          OnlyChatContactMgrUI.h(OnlyChatContactMgrUI.this);
          AppMethodBeat.o(180057);
        }
      });
      this.IxH.setOnClickListener(new View.OnClickListener()
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
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDm = 5L;
          OnlyChatContactMgrUI.i(OnlyChatContactMgrUI.this).dDv = System.currentTimeMillis();
          AppMethodBeat.o(180058);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(196758);
          OnlyChatContactMgrUI.this.hideVKB();
          OnlyChatContactMgrUI.this.finish();
          AppMethodBeat.o(196758);
          return false;
        }
      });
      com.tencent.mm.kernel.g.agS();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(3990, this);
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
    com.tencent.mm.kernel.g.agS();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(3990, this);
    this.IxF.finish();
    super.onDestroy();
    AppMethodBeat.o(180070);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(180074);
    ac.i("MicroMsg.OnlyChatContactMgrUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
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
        this.IxK.dDo = this.IxK.dDn;
        paramString = this.IxK;
        paramString.dDp = paramString.t("modifiedsucfriendlist", bs.n(localc.hLL, "#"), true);
        if (localc.op != 1) {
          break label279;
        }
      }
      label279:
      for (this.IxK.dDr = (this.IxK.dDq + localc.hLL.size());; this.IxK.dDr = (this.IxK.dDq - localc.hLL.size()))
      {
        this.IxK.dDs = 1L;
        paramString = this.IxK;
        paramString.dDw = paramString.t("sessionid", hashCode(), true);
        this.IxK.aHZ();
        AppMethodBeat.o(180074);
        return;
        paramInt1 = 2131755667;
        break;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.aRQ(bs.bG(paramn.getReqResp().getRespObj().getErrMsg(), getString(2131755570))).yi(true).aRV(getString(2131762023)).acQ(2131762024);
      paramString.c(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(196757);
          OnlyChatContactMgrUI.this.hideVKB();
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ab.iC(OnlyChatContactMgrUI.this.getContext());
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            d.b(OnlyChatContactMgrUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(196757);
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
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.hLN - localc.hLL.size()) });
      }
    }
    for (;;)
    {
      paramString = locala.aRQ(paramString);
      paramString.JfY = true;
      paramString.acQ(2131755835);
      locala.b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }).show();
      AppMethodBeat.o(180074);
      return;
      paramInt1 = 2131755666;
      break;
      paramString = paramn.getReqResp().getRespObj().getErrMsg();
      if (bs.isNullOrNil(paramString))
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
    HashMap<String, Integer> ItG;
    private SparseArray<String> ItH;
    List<String> IxV;
    private Cursor iCz;
    String query;
    
    public a(n paramn)
    {
      super(null, true, false);
      AppMethodBeat.i(180061);
      this.ItG = new HashMap();
      this.ItH = new SparseArray();
      this.query = "";
      this.IxV = new LinkedList();
      WN();
      AppMethodBeat.o(180061);
    }
    
    private static com.tencent.mm.ui.contact.a.a cL(int paramInt, String paramString)
    {
      AppMethodBeat.i(180065);
      com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
      localh.header = paramString;
      AppMethodBeat.o(180065);
      return localh;
    }
    
    public final void WN()
    {
      AppMethodBeat.i(180062);
      super.WN();
      if (this.iCz != null)
      {
        this.iCz.close();
        this.iCz = null;
      }
      this.ItG.clear();
      this.ItH.clear();
      com.tencent.mm.kernel.g.agS();
      this.iCz = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().d(null, this.query, "@social.black.android", "", this.fzw);
      String[] arrayOfString = w.a(null, "@social.black.android", "", this.query, this.fzw);
      int[] arrayOfInt = w.a(null, "@social.black.android", "", this.fzw, this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int i = 0;
        int k;
        for (int j = 1; i < arrayOfString.length; j = k)
        {
          k = j;
          if (i < arrayOfInt.length)
          {
            this.ItG.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.ItH.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
        }
      }
      ac.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iCz.getCount()), this.ItG.toString() });
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(180062);
    }
    
    public final int aQR(String paramString)
    {
      AppMethodBeat.i(180063);
      if (this.ItG != null)
      {
        if (this.ItG.containsKey(paramString))
        {
          int i = ((Integer)this.ItG.get(paramString)).intValue();
          int j = this.Iwg.getContentLV().getHeaderViewsCount();
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
      ac.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
      if (this.iCz != null)
      {
        this.iCz.close();
        this.iCz = null;
      }
      AppMethodBeat.o(180067);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(180068);
      if (this.iCz != null)
      {
        int i = this.iCz.getCount();
        AppMethodBeat.o(180068);
        return i;
      }
      AppMethodBeat.o(180068);
      return 0;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(180066);
      int j = this.iCz.getCount();
      if (this.ItH == null) {}
      for (int i = 0;; i = this.ItH.size())
      {
        AppMethodBeat.o(180066);
        return i + j + 1;
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a qH(int paramInt)
    {
      AppMethodBeat.i(180064);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = cL(paramInt, OnlyChatContactMgrUI.this.getString(2131755186));
        AppMethodBeat.o(180064);
        return localObject;
      }
      if (this.ItH.indexOfKey(paramInt) >= 0)
      {
        localObject = cL(paramInt, (String)this.ItH.get(paramInt));
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
        if (i > this.ItH.size()) {
          break;
        }
        j = i;
        if (this.ItH.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        k = m;
        i = j;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iCz.moveToPosition(i))
      {
        ac.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject = new ai();
        ((ai)localObject).convertFrom(this.iCz);
        com.tencent.mm.ui.contact.a.e locale = new com.tencent.mm.ui.contact.a.e(paramInt);
        locale.contact = ((ai)localObject);
        if (w.sQ(((av)localObject).field_username))
        {
          locale.Iwh = false;
          locale.Iwi = false;
          locale.IzA = false;
        }
        for (locale.IzP = true;; locale.IzP = false)
        {
          AppMethodBeat.o(180064);
          return locale;
          locale.Iwh = dFi();
          locale.Iwi = this.Iwi;
        }
      }
      ac.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(180064);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI
 * JD-Core Version:    0.7.0.1
 */