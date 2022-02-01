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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.f.b.a.ap;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.label.ui.ContactLabelManagerUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.contact.ContactCountView;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class ContactMgrUIBase
  extends MMActivity
  implements i, MStorageEx.IOnStorageChange, o
{
  private TextView KJC;
  private ContactCountView XpL;
  public final String XuA = "intent_status_mgr";
  private SelectMemberScrollBar XuC;
  public Button XuD;
  protected final int XuE = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
  protected final int XuF = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForClient", 30);
  private final int XuJ = 0;
  private final int XuK = 2;
  private final int XyA = 1;
  protected List<String> Xys = new ArrayList();
  public a Xyt;
  private View Xyu;
  protected String Xyv;
  protected boolean Xyw;
  protected boolean Xyx;
  private Runnable Xyy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(290222);
      ContactMgrUIBase.this.Xyt.ate();
      ContactMgrUIBase.this.updateTitle();
      ContactMgrUIBase.this.hVF();
      ContactMgrUIBase.this.hVG();
      AppMethodBeat.o(290222);
    }
  };
  protected a Xyz = new a(this);
  protected TextView kGU;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  public Button mZC;
  public Button nbe;
  private ListView niO;
  protected int sxZ;
  private int syc;
  private int syd;
  protected s tipDialog = null;
  protected List<String> unc = new ArrayList();
  private EditText xZi;
  
  protected abstract a a(o paramo);
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.ui.contact.a.f)) {
      return this.Xyt.Eec.contains(((com.tencent.mm.ui.contact.a.f)parama).username);
    }
    return false;
  }
  
  public abstract void awS(int paramInt);
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public void bH(Intent paramIntent) {}
  
  public void bI(Intent paramIntent) {}
  
  protected final void bJ(Intent paramIntent)
  {
    paramIntent.putExtra("already_select_contact", (String[])this.unc.toArray(new String[0]));
    paramIntent.putExtra("privacy_del_tips", this.Xyv);
    paramIntent.putExtra("privacy_source_type", this.Xyt.hVC());
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
    return R.i.ejV;
  }
  
  protected abstract void hVA();
  
  protected abstract void hVB();
  
  protected final void hVD()
  {
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(this.Xyy);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void hVE()
  {
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.postDelayed(this.Xyy, 350L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void hVF()
  {
    boolean bool = false;
    this.XpL.setFixedContactCount(this.Xyt.getContactCount());
    Object localObject = this.kGU;
    if (this.Xyt.getContactCount() == 0) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      localObject = this.XuD;
      if (this.Xyt.getContactCount() > 0) {
        bool = true;
      }
      ((Button)localObject).setEnabled(bool);
      return;
    }
  }
  
  protected void hVG() {}
  
  protected final void hVH()
  {
    if (this.Xyw)
    {
      this.Xyw = false;
      Toast.makeText(this, getString(R.l.enp), 0).show();
    }
    if (this.Xyx)
    {
      this.Xyx = false;
      Toast.makeText(this, getString(R.l.ens), 0).show();
    }
  }
  
  protected final void hVI()
  {
    if (this.Xyw)
    {
      this.Xyw = false;
      Toast.makeText(this, getString(R.l.ePh), 0).show();
    }
    if (this.Xyx)
    {
      this.Xyx = false;
      Toast.makeText(this, getString(R.l.ePi), 0).show();
    }
  }
  
  public CharSequence hVz()
  {
    return getResources().getString(R.l.ePj);
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
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
        {
          paramInt2 = com.tencent.mm.kernel.h.aGY().bih();
          if ((paramInt2 == 4) || (paramInt2 == 6)) {
            paramInt2 = 1;
          }
        }
        while (paramInt2 == 0)
        {
          w.makeText(this, c.g.top_story_setting_loading_fail, 0).show();
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
          bI(paramIntent);
          return;
        }
      } while ((paramInt1 != 1) && (paramInt1 != 3) && (paramInt1 != 4));
      bH(paramIntent);
    } while (paramInt1 != 1);
    if ((this.sxZ <= 0) && (paramIntent != null)) {
      this.sxZ = paramIntent.getIntExtra("show_all_select_contact_count", 0);
    }
    ap localap = new ap();
    String str = this.Xyt.hVC();
    paramInt1 = -1;
    if ("@sns.black.android".equals(str))
    {
      paramInt1 = 1;
      paramInt2 = 2;
    }
    for (;;)
    {
      localap.geB = 1L;
      localap.gjp = paramInt2;
      localap.gjq = paramInt1;
      localap.gjr = 1L;
      localap.gjs = 0L;
      localap.gjt = (this.sxZ - this.unc.size());
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = Util.stringsToList(paramIntent.split(","));
        if (paramIntent != null) {
          localap.gjv = paramIntent.size();
        }
      }
      localap.gju = this.sxZ;
      localap.bpa();
      ar.a(localap);
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
    setMMTitle(hVz());
    this.niO = ((ListView)findViewById(R.h.dMv));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279275);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = ContactMgrUIBase.a(ContactMgrUIBase.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279275);
      }
    });
    this.kGU = ((TextView)findViewById(R.h.empty_tip_tv));
    this.KJC = ((TextView)findViewById(R.h.duB));
    this.Xyt = a(this);
    this.Xyu = findViewById(R.h.dTq);
    paramBundle = getIntent().getStringExtra("intent_status_show_bottom_tips");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.KJC.setText(paramBundle);
      this.KJC.setVisibility(0);
    }
    for (;;)
    {
      this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(281881);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          ContactMgrUIBase.this.awS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(281881);
        }
      });
      this.niO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(271855);
          paramAnonymousAdapterView = ContactMgrUIBase.this.Xyt.awM(paramAnonymousInt);
          if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
          {
            AppMethodBeat.o(271855);
            return true;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.ui.contact.a.f)paramAnonymousAdapterView).username;
          if (!ContactMgrUIBase.this.Xyt.fJk()) {
            new com.tencent.mm.ui.widget.b.a(ContactMgrUIBase.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new q.g
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(274708);
                paramAnonymous2ContextMenu.add(paramAnonymousInt, 0, 0, R.l.eyI);
                AppMethodBeat.o(274708);
              }
            }, new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(266164);
                Object localObject = new Intent();
                ((Intent)localObject).setClass(ContactMgrUIBase.this.getContext(), ContactRemarkInfoModUI.class);
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("view_mode", true);
                paramAnonymous2MenuItem = ContactMgrUIBase.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2MenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2MenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2MenuItem, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(266164);
              }
            }, ContactMgrUIBase.b(ContactMgrUIBase.this), ContactMgrUIBase.c(ContactMgrUIBase.this));
          }
          AppMethodBeat.o(271855);
          return true;
        }
      });
      this.niO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(289342);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(289342);
            return false;
            ContactMgrUIBase.this.hideVKB();
            ContactMgrUIBase.a(ContactMgrUIBase.this, (int)paramAnonymousMotionEvent.getRawX());
            ContactMgrUIBase.b(ContactMgrUIBase.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.niO.setAdapter(this.Xyt);
      paramBundle = this.niO;
      ContactCountView localContactCountView = new ContactCountView(this);
      this.XpL = localContactCountView;
      paramBundle.addFooterView(localContactCountView, null, false);
      this.XpL.setVisible(false);
      this.XuC = ((SelectMemberScrollBar)findViewById(R.h.dMw));
      this.XuC.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void KH(String paramAnonymousString)
        {
          AppMethodBeat.i(241606);
          if ("↑".equals(paramAnonymousString))
          {
            ContactMgrUIBase.a(ContactMgrUIBase.this).setSelection(0);
            AppMethodBeat.o(241606);
            return;
          }
          int i = ContactMgrUIBase.this.Xyt.bAl(paramAnonymousString);
          if (i != -1) {
            ContactMgrUIBase.a(ContactMgrUIBase.this).setSelection(i);
          }
          AppMethodBeat.o(241606);
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
          AppMethodBeat.i(197354);
          this.jkK.stopTimer();
          this.jkK.startTimer(500L);
          AppMethodBeat.o(197354);
        }
      });
      this.Xyu.setVisibility(8);
      this.mZC = ((Button)findViewById(R.h.add_btn));
      this.XuD = ((Button)findViewById(R.h.dKw));
      this.nbe = ((Button)findViewById(R.h.del_btn));
      this.nbe.setEnabled(false);
      this.mZC.setVisibility(0);
      this.XuD.setVisibility(0);
      this.nbe.setVisibility(8);
      this.mZC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(224374);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ContactMgrUIBase.f(ContactMgrUIBase.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(224374);
        }
      });
      this.XuD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(288264);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ContactMgrUIBase.this.hVA();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/ContactMgrUIBase$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(288264);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(196797);
          ContactMgrUIBase.this.hideVKB();
          ContactMgrUIBase.this.finish();
          AppMethodBeat.o(196797);
          return false;
        }
      });
      hVF();
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(3990, this);
      return;
      this.KJC.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    this.Xyz.dismiss();
    com.tencent.mm.kernel.h.aHH();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(3990, this);
    this.Xyt.finish();
    super.onDestroy();
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    Log.i("MicroMsg.ContactMgrUIBase", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      hVE();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Log.i("MicroMsg.ContactMgrUIBase", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + ", scene type = " + paramq.getType());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void updateTitle() {}
  
  protected abstract class a
    extends r
  {
    protected List<String> Eec = new LinkedList();
    protected List<as> MWw = new ArrayList();
    protected HashMap<String, Integer> Xqo = new HashMap();
    protected SparseArray<String> Xqp = new SparseArray();
    protected List<String> fMr = new ArrayList();
    protected Cursor mNt;
    protected String query = "";
    
    public a(o paramo)
    {
      super(com.tencent.mm.pluginsdk.j.a.hhV(), true, false);
    }
    
    private static int hVJ()
    {
      if (!Util.isNullOrNil("")) {
        return 1;
      }
      return 0;
    }
    
    public final void aIi(String paramString)
    {
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      ate();
    }
    
    public void ate()
    {
      super.ate();
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      this.Xqo.clear();
      this.Xqp.clear();
      com.tencent.mm.kernel.h.aHH();
      this.mNt = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(null, this.query, hVC(), "", csq());
      String[] arrayOfString = ab.a(null, hVC(), "", this.query, csq());
      int[] arrayOfInt = ab.a(null, hVC(), "", csq(), this.query);
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        int j = hVJ();
        int i = 0;
        while (i < arrayOfString.length)
        {
          int k = j;
          if (i < arrayOfInt.length)
          {
            this.Xqo.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
            this.Xqp.put(arrayOfInt[i] + j, arrayOfString[i]);
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      Log.i("MicroMsg.ContactMgrUIBase", "datacount:%d headerPosMap=%s, getdat: %s, this.query: %s.", new Object[] { Integer.valueOf(this.mNt.getCount()), this.Xqo.toString(), hVC(), this.query });
      clearCache();
      notifyDataSetChanged();
    }
    
    public final void bAh(String paramString)
    {
      if (this.Eec.contains(paramString)) {
        this.Eec.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        this.Eec.add(paramString);
      }
    }
    
    public final int bAl(String paramString)
    {
      if (this.Xqo.get(paramString) == null) {
        return -1;
      }
      return ((Integer)this.Xqo.get(paramString)).intValue();
    }
    
    public final int bzR(String paramString)
    {
      int j = -1;
      int i = j;
      if (this.Xqo != null)
      {
        i = j;
        if (this.Xqo.containsKey(paramString)) {
          i = ((Integer)this.Xqo.get(paramString)).intValue() + this.XsW.getContentLV().getHeaderViewsCount();
        }
      }
      return i;
    }
    
    protected com.tencent.mm.ui.contact.a.a dm(int paramInt, String paramString)
    {
      j localj = new j(paramInt);
      localj.header = paramString;
      return localj;
    }
    
    public final void finish()
    {
      super.finish();
      Log.i("MicroMsg.ContactMgrUIBase", "finish!");
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
    }
    
    public final int getContactCount()
    {
      if (this.mNt != null) {
        return this.mNt.getCount();
      }
      return 0;
    }
    
    public int getCount()
    {
      int j = 0;
      int i;
      if (this.mNt == null)
      {
        i = 0;
        if (this.Xqp != null) {
          break label39;
        }
      }
      for (;;)
      {
        return i + j + hVJ();
        i = this.mNt.getCount();
        break;
        label39:
        j = this.Xqp.size();
      }
    }
    
    public abstract String hVC();
    
    public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      if ((hVJ() == 1) && (paramInt == 0)) {
        return dm(paramInt, "");
      }
      if (this.Xqp.indexOfKey(paramInt) >= 0) {
        return dm(paramInt, (String)this.Xqp.get(paramInt));
      }
      int i = hVJ();
      int k = paramInt;
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
        Log.d("MicroMsg.ContactMgrUIBase", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        as localas = new as();
        localas.convertFrom(this.mNt);
        com.tencent.mm.ui.contact.a.f localf = new com.tencent.mm.ui.contact.a.f(paramInt);
        localf.contact = localas;
        if (ab.Lj(localas.field_username))
        {
          localf.XsX = false;
          localf.XsY = false;
          localf.Xxs = false;
          localf.XxM = true;
          return localf;
        }
        localf.XsX = fJk();
        localf.XsY = hUO();
        localf.XxM = false;
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