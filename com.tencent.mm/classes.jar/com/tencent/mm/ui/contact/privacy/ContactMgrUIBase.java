package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.contact.ContactCountView;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class ContactMgrUIBase
  extends MMActivity
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange, o
{
  private EditText Cxu;
  private View DKT;
  public final String JUI = "intent_status_mgr";
  private SelectMemberScrollBar JUz;
  protected final int JXM = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
  private TextView Rje;
  private ContactCountView afbn;
  public Button afgC;
  protected final int afgD = i.aRC().getInt("MMBatchModContactTypeMaxNumForClient", 30);
  private final int afgH = 0;
  private final int afgI = 2;
  protected List<String> afkJ = new ArrayList();
  public a afkK;
  protected String afkL;
  protected boolean afkM;
  protected boolean afkN;
  private Runnable afkO = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(253322);
      ContactMgrUIBase.this.afkK.aNm();
      ContactMgrUIBase.this.aMl();
      ContactMgrUIBase.this.jzB();
      ContactMgrUIBase.this.jzC();
      AppMethodBeat.o(253322);
    }
  };
  protected a afkP = new a(this);
  private final int afkQ = 1;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  protected TextView njO;
  public Button pWl;
  public Button pYm;
  private ListView qgc;
  protected w tipDialog = null;
  protected int vDI;
  private int x_down;
  protected List<String> xtu = new ArrayList();
  private int y_down;
  
  protected abstract a a(o paramo);
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.ui.contact.a.f)) {
      return this.afkK.JXy.contains(((com.tencent.mm.ui.contact.a.f)parama).username);
    }
    return false;
  }
  
  public abstract void aDz(int paramInt);
  
  protected void aMl() {}
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public void ck(Intent paramIntent) {}
  
  public void cl(Intent paramIntent) {}
  
  protected final void cm(Intent paramIntent)
  {
    paramIntent.putExtra("already_select_contact", (String[])this.xtu.toArray(new String[0]));
    paramIntent.putExtra("privacy_del_tips", this.afkL);
    paramIntent.putExtra("privacy_source_type", this.afkK.jzy());
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
    return R.i.gmY;
  }
  
  protected final void jzA()
  {
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.postDelayed(this.afkO, 350L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void jzB()
  {
    boolean bool = false;
    this.afbn.setFixedContactCount(this.afkK.getContactCount());
    Object localObject = this.njO;
    if (this.afkK.getContactCount() == 0) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      localObject = this.afgC;
      if (this.afkK.getContactCount() > 0) {
        bool = true;
      }
      ((Button)localObject).setEnabled(bool);
      return;
    }
  }
  
  protected void jzC() {}
  
  protected final void jzD()
  {
    if (this.afkM)
    {
      this.afkM = false;
      Toast.makeText(this, getString(R.l.gqq), 0).show();
    }
    if (this.afkN)
    {
      this.afkN = false;
      Toast.makeText(this, getString(R.l.gqt), 0).show();
    }
  }
  
  protected final void jzE()
  {
    if (this.afkM)
    {
      this.afkM = false;
      Toast.makeText(this, getString(R.l.gRJ), 0).show();
    }
    if (this.afkN)
    {
      this.afkN = false;
      Toast.makeText(this, getString(R.l.gRK), 0).show();
    }
  }
  
  public CharSequence jzv()
  {
    return getResources().getString(R.l.gRL);
  }
  
  protected abstract void jzw();
  
  protected abstract void jzx();
  
  protected final void jzz()
  {
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(this.afkO);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 4;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    label104:
    do
    {
      do
      {
        return;
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
        {
          paramInt2 = com.tencent.mm.kernel.h.aZW().bFQ();
          if ((paramInt2 == 4) || (paramInt2 == 6)) {
            paramInt2 = 1;
          }
        }
        while (paramInt2 == 0)
        {
          aa.makeText(this, c.g.top_story_setting_loading_fail, 0).show();
          return;
          paramInt2 = 0;
          continue;
          if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
          for (paramInt2 = 6;; paramInt2 = 0)
          {
            if (paramInt2 != 6) {
              break label104;
            }
            paramInt2 = 1;
            break;
          }
          paramInt2 = 0;
        }
        if (paramInt1 == 2)
        {
          cl(paramIntent);
          return;
        }
      } while ((paramInt1 != 1) && (paramInt1 != 3) && (paramInt1 != 4));
      ck(paramIntent);
    } while (paramInt1 != 1);
    if ((this.vDI <= 0) && (paramIntent != null)) {
      this.vDI = paramIntent.getIntExtra("show_all_select_contact_count", 0);
    }
    com.tencent.mm.autogen.mmdata.rpt.az localaz = new com.tencent.mm.autogen.mmdata.rpt.az();
    String str = this.afkK.jzy();
    paramInt1 = -1;
    if ("@sns.black.android".equals(str))
    {
      paramInt1 = 1;
      paramInt2 = 2;
    }
    for (;;)
    {
      localaz.ila = 1L;
      localaz.iqd = paramInt2;
      localaz.iqe = paramInt1;
      localaz.iqf = 1L;
      localaz.iqg = 0L;
      localaz.iqh = (this.vDI - this.xtu.size());
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = Util.stringsToList(paramIntent.split(","));
        if (paramIntent != null) {
          localaz.iqj = paramIntent.size();
        }
      }
      localaz.iqi = this.vDI;
      localaz.bMH();
      as.a(localaz);
      return;
      if ("@sns.unlike.android".equals(str))
      {
        paramInt1 = 2;
        paramInt2 = 2;
      }
      else if ("@werun.black.android".equals(str))
      {
        paramInt1 = 0;
        paramInt2 = 5;
      }
      else if ("@tophistory.black.android".equals(str))
      {
        paramInt1 = 1;
        paramInt2 = i;
      }
      else if ("@tophistory.unlike.android".equals(str))
      {
        paramInt1 = 2;
        paramInt2 = i;
      }
      else if ("@finder.block.his.liked.android".equals(str))
      {
        paramInt1 = 2;
        paramInt2 = 3;
      }
      else if ("@finder.block.my.liked.android".equals(str))
      {
        paramInt1 = 1;
        paramInt2 = 3;
      }
      else if ("@social.black.android".equals(str))
      {
        paramInt1 = 0;
        paramInt2 = 1;
      }
      else
      {
        paramInt2 = 0;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(jzv());
    this.qgc = ((ListView)findViewById(R.h.fOe));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253316);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = ContactMgrUIBase.a(ContactMgrUIBase.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253316);
      }
    });
    this.njO = ((TextView)findViewById(R.h.empty_tip_tv));
    this.Rje = ((TextView)findViewById(R.h.fuT));
    this.afkK = a(this);
    this.DKT = findViewById(R.h.fVy);
    paramBundle = getIntent().getStringExtra("intent_status_show_bottom_tips");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.Rje.setText(paramBundle);
      this.Rje.setVisibility(0);
    }
    for (;;)
    {
      this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(253305);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          ContactMgrUIBase.this.aDz(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(253305);
        }
      });
      this.qgc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(253307);
          paramAnonymousAdapterView = ContactMgrUIBase.this.afkK.aDt(paramAnonymousInt);
          if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
          {
            AppMethodBeat.o(253307);
            return true;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
          if (!ContactMgrUIBase.this.afkK.gZe()) {
            new com.tencent.mm.ui.widget.b.a(ContactMgrUIBase.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new u.i
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(253290);
                paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, R.l.gBA);
                AppMethodBeat.o(253290);
              }
            }, new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(253299);
                Object localObject = new Intent();
                ((Intent)localObject).setClass(ContactMgrUIBase.this.getContext(), ContactRemarkInfoModUI.class);
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("view_mode", true);
                paramAnonymous2MenuItem = ContactMgrUIBase.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(253299);
              }
            }, ContactMgrUIBase.b(ContactMgrUIBase.this), ContactMgrUIBase.c(ContactMgrUIBase.this));
          }
          AppMethodBeat.o(253307);
          return true;
        }
      });
      this.qgc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(253297);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(253297);
            return false;
            ContactMgrUIBase.this.hideVKB();
            ContactMgrUIBase.a(ContactMgrUIBase.this, (int)paramAnonymousMotionEvent.getRawX());
            ContactMgrUIBase.b(ContactMgrUIBase.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.qgc.setAdapter(this.afkK);
      paramBundle = this.qgc;
      ContactCountView localContactCountView = new ContactCountView(this);
      this.afbn = localContactCountView;
      paramBundle.addFooterView(localContactCountView, null, false);
      this.afbn.setVisible(false);
      this.JUz = ((SelectMemberScrollBar)findViewById(R.h.fOf));
      this.JUz.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void onScollBarTouch(String paramAnonymousString)
        {
          AppMethodBeat.i(253296);
          if ("↑".equals(paramAnonymousString))
          {
            ContactMgrUIBase.a(ContactMgrUIBase.this).setSelection(0);
            AppMethodBeat.o(253296);
            return;
          }
          int i = ContactMgrUIBase.this.afkK.bCd(paramAnonymousString);
          if (i != -1) {
            ContactMgrUIBase.a(ContactMgrUIBase.this).setSelection(i);
          }
          AppMethodBeat.o(253296);
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
          AppMethodBeat.i(253333);
          this.lNo.stopTimer();
          this.lNo.startTimer(500L);
          AppMethodBeat.o(253333);
        }
      });
      this.DKT.setVisibility(8);
      this.pWl = ((Button)findViewById(R.h.add_btn));
      this.afgC = ((Button)findViewById(R.h.fLU));
      this.pYm = ((Button)findViewById(R.h.del_btn));
      this.pYm.setEnabled(false);
      this.pWl.setVisibility(0);
      this.afgC.setVisibility(0);
      this.pYm.setVisibility(8);
      this.pWl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(253342);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactMgrUIBase.f(ContactMgrUIBase.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253342);
        }
      });
      this.afgC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(253332);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactMgrUIBase.this.jzw();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253332);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253315);
          ContactMgrUIBase.this.hideVKB();
          ContactMgrUIBase.this.finish();
          AppMethodBeat.o(253315);
          return false;
        }
      });
      jzB();
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(3990, this);
      return;
      this.Rje.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    this.afkP.dismiss();
    com.tencent.mm.kernel.h.baF();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(3990, this);
    this.afkK.finish();
    super.onDestroy();
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    Log.i("MicroMsg.ContactMgrUIBase", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      jzA();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.i("MicroMsg.ContactMgrUIBase", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + ", scene type = " + paramp.getType());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected abstract class a
    extends r
  {
    protected HashMap<String, Integer> JUK = new HashMap();
    protected SparseArray<String> JUL = new SparseArray();
    protected List<String> JXy = new LinkedList();
    protected List<au> TJa = new ArrayList();
    protected List<String> hSb = new ArrayList();
    protected Cursor pKb;
    protected String query = "";
    
    public a(o paramo)
    {
      super(com.tencent.mm.pluginsdk.platformtools.a.iIW(), true, false);
    }
    
    private static int jzF()
    {
      if (!Util.isNullOrNil("")) {
        return 1;
      }
      return 0;
    }
    
    public final void aEJ(String paramString)
    {
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      aNm();
    }
    
    public final int aJM(String paramString)
    {
      int j = -1;
      int i = j;
      if (this.JUK != null)
      {
        i = j;
        if (this.JUK.containsKey(paramString)) {
          i = ((Integer)this.JUK.get(paramString)).intValue() + this.afex.getContentLV().getHeaderViewsCount();
        }
      }
      return i;
    }
    
    public void aNm()
    {
      super.aNm();
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      this.JUK.clear();
      this.JUL.clear();
      com.tencent.mm.kernel.h.baF();
      this.pKb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(null, this.query, jzy(), "", cVa());
      String[] arrayOfString = ab.a(null, jzy(), "", this.query, cVa());
      int[] arrayOfInt = ab.a(null, jzy(), "", cVa(), this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int j = jzF();
        int i = 0;
        while (i < arrayOfString.length)
        {
          int k = j;
          if (i < arrayOfInt.length)
          {
            this.JUK.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.JUL.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      Log.i("MicroMsg.ContactMgrUIBase", "datacount:%d headerPosMap=%s, getdat: %s, this.query: %s.", new Object[] { Integer.valueOf(this.pKb.getCount()), this.JUK.toString(), jzy(), this.query });
      clearCache();
      notifyDataSetChanged();
    }
    
    public final void bCa(String paramString)
    {
      if (this.JXy.contains(paramString)) {
        this.JXy.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        this.JXy.add(paramString);
      }
    }
    
    public final int bCd(String paramString)
    {
      if (this.JUK.get(paramString) == null) {
        return -1;
      }
      return ((Integer)this.JUK.get(paramString)).intValue();
    }
    
    protected com.tencent.mm.ui.contact.a.a cf(int paramInt, String paramString)
    {
      j localj = new j(paramInt);
      localj.header = paramString;
      return localj;
    }
    
    public final void finish()
    {
      super.finish();
      Log.i("MicroMsg.ContactMgrUIBase", "finish!");
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
    }
    
    public final int getContactCount()
    {
      if (this.pKb != null) {
        return this.pKb.getCount();
      }
      return 0;
    }
    
    public int getCount()
    {
      int j = 0;
      int i;
      if (this.pKb == null)
      {
        i = 0;
        if (this.JUL != null) {
          break label39;
        }
      }
      for (;;)
      {
        return i + j + jzF();
        i = this.pKb.getCount();
        break;
        label39:
        j = this.JUL.size();
      }
    }
    
    public abstract String jzy();
    
    public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      if ((jzF() == 1) && (paramInt == 0)) {
        return cf(paramInt, "");
      }
      if (this.JUL.indexOfKey(paramInt) >= 0) {
        return cf(paramInt, (String)this.JUL.get(paramInt));
      }
      int i = jzF();
      int k = paramInt;
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
        Log.d("MicroMsg.ContactMgrUIBase", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        au localau = new au();
        localau.convertFrom(this.pKb);
        com.tencent.mm.ui.contact.a.f localf = new com.tencent.mm.ui.contact.a.f(paramInt);
        localf.contact = localau;
        if (au.bwE(localau.field_username))
        {
          localf.afey = false;
          localf.afez = false;
          localf.afjA = false;
          localf.afjT = true;
          return localf;
        }
        localf.afey = gZe();
        localf.afez = jyD();
        localf.afjT = false;
        return localf;
      }
      Log.i("MicroMsg.ContactMgrUIBase", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.ContactMgrUIBase
 * JD-Core Version:    0.7.0.1
 */