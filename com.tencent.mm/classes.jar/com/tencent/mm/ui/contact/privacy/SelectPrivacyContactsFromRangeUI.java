package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SelectPrivacyContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.am.h
{
  private String JVl;
  private String KTitle;
  private String afau;
  private int afbe;
  private String[] afiB;
  private a afkP;
  private a aflb;
  private b aflc;
  private View afld;
  private ImageView afle;
  private boolean aflf;
  private boolean aflg;
  private Set<String> aflh;
  private Set<String> afli;
  private boolean aflj;
  private boolean aflk;
  private boolean afll;
  private boolean xtL;
  
  public SelectPrivacyContactsFromRangeUI()
  {
    AppMethodBeat.i(253383);
    this.aflg = true;
    this.aflh = new HashSet();
    this.afli = new HashSet();
    this.afkP = new a(this);
    this.aflj = false;
    AppMethodBeat.o(253383);
  }
  
  private boolean aL(au paramau)
  {
    boolean bool = true;
    AppMethodBeat.i(253411);
    if (paramau != null)
    {
      int i;
      if (this.afbe != 16)
      {
        i = 1;
        if (!"@sns.black.android".equals(this.JVl)) {
          break label62;
        }
        if ((i == 0) || (!paramau.aSL())) {
          break label57;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(253411);
        return bool;
        i = 0;
        break;
        label57:
        bool = false;
        continue;
        label62:
        if ("@sns.unlike.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSJ())) {
            bool = false;
          }
        }
        else if ("@werun.black.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSG())) {
            bool = false;
          }
        }
        else if ("@tophistory.black.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSH())) {
            bool = false;
          }
        }
        else if ("@tophistory.unlike.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSI())) {
            bool = false;
          }
        }
        else if ("@social.black.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSN())) {
            bool = false;
          }
        }
        else if ("@finder.block.his.liked.android".equals(this.JVl))
        {
          if ((i == 0) || (!paramau.aSO())) {
            bool = false;
          }
        }
        else
        {
          if (!"@finder.block.my.liked.android".equals(this.JVl)) {
            break label258;
          }
          if ((i == 0) || (!paramau.aSP())) {
            bool = false;
          }
        }
      }
      label258:
      AppMethodBeat.o(253411);
      return false;
    }
    AppMethodBeat.o(253411);
    return false;
  }
  
  private void aNr()
  {
    AppMethodBeat.i(253393);
    if (this.aflf)
    {
      AppMethodBeat.o(253393);
      return;
    }
    if (a.a(this.aflb).size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_finish) + "(" + a.a(this.aflb).size() + ")");
      enableOptionMenu(1, true);
    }
    while (this.aflk) {
      if (a.a(this.aflb).size() == this.aflb.getContactCount())
      {
        if (!this.xtL)
        {
          this.xtL = true;
          jzJ();
          AppMethodBeat.o(253393);
          return;
          updateOptionMenuText(1, getString(R.l.app_finish));
          enableOptionMenu(1, false);
        }
      }
      else if (this.xtL)
      {
        this.xtL = false;
        jzJ();
      }
    }
    AppMethodBeat.o(253393);
  }
  
  private void jzJ()
  {
    AppMethodBeat.i(253401);
    if (this.xtL)
    {
      com.tencent.mm.plugin.downloader_app.b.i(this.afle, "checkbox_cell_on");
      AppMethodBeat.o(253401);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.i(this.afle, "checkbox_cell_off");
    AppMethodBeat.o(253401);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253533);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(253533);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof f)))
    {
      AppMethodBeat.o(253533);
      return;
    }
    if (b(paramAdapterView))
    {
      AppMethodBeat.o(253533);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "ClickUser=%s", new Object[] { paramAdapterView });
    this.aflb.bCa(paramAdapterView);
    aNr();
    if ((jyE() instanceof b))
    {
      iKA();
      hideVKB();
    }
    if (this.afll)
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView);
      paramView.putExtra("Contact_Scene", 3);
      paramView.putExtra("key_label_click_source", getIntent().getIntExtra("key_label_click_source", 0));
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
      if (!Util.isNullOrNil(paramAdapterView)) {
        com.tencent.mm.br.c.b(getActivity(), "profile", ".ui.ContactInfoUI", paramView);
      }
    }
    AppMethodBeat.o(253533);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(253545);
    if ((parama instanceof f))
    {
      boolean bool = a.a(this.aflb).contains(((f)parama).username);
      AppMethodBeat.o(253545);
      return bool;
    }
    AppMethodBeat.o(253545);
    return false;
  }
  
  public final void aNi()
  {
    boolean bool2 = false;
    AppMethodBeat.i(253503);
    super.aNi();
    this.afbe = getIntent().getIntExtra("list_type", 0);
    this.afau = getIntent().getStringExtra("filter_type");
    this.afiB = getIntent().getStringArrayExtra("already_select_contact");
    int i = getIntent().getIntExtra("max_limit_num", 100);
    this.JVl = getIntent().getStringExtra("privacy_source_type");
    this.aflb = new a(this, i);
    this.aflf = getIntent().getBooleanExtra("only_show_contact", false);
    Object localObject = this.aflb;
    boolean bool1;
    if (!this.aflf)
    {
      bool1 = true;
      ((q)localObject).afey = bool1;
      if (this.aflf) {
        this.aflg = false;
      }
      if ((!this.aflf) && (("@all.contact.android".equals(this.afau)) || ("@all.contact.without.chatroom.without.openim".equals(this.afau))))
      {
        localObject = al.hgp();
        if ((this.afiB == null) || (this.afiB.length == 0)) {
          break label302;
        }
        String[] arrayOfString = this.afiB;
        int j = arrayOfString.length;
        i = 0;
        label210:
        if (i >= j) {
          break label302;
        }
        if (!d.rs(((bx)localObject).JE(arrayOfString[i]).field_type)) {
          break label295;
        }
      }
    }
    label295:
    label302:
    for (i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      this.aflj = bool1;
      this.aflc = new b(this, this.aflb);
      this.aflc.afey = true;
      this.aflb.notifyDataSetChanged();
      AppMethodBeat.o(253503);
      return;
      bool1 = false;
      break;
      i += 1;
      break label210;
    }
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(253508);
    if ((paramInt == 1) && (paramString != null))
    {
      this.aflb.bCa(paramString);
      aNr();
      this.aflb.notifyDataSetChanged();
    }
    AppMethodBeat.o(253508);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(253541);
    if (((parama instanceof f)) && (parama.contact != null))
    {
      if ((this.afbe != 16) && (aL(parama.contact)))
      {
        AppMethodBeat.o(253541);
        return true;
      }
      AppMethodBeat.o(253541);
      return false;
    }
    AppMethodBeat.o(253541);
    return false;
  }
  
  public final r bVA()
  {
    return this.aflb;
  }
  
  public final com.tencent.mm.ui.contact.p bVB()
  {
    return this.aflc;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return true;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(253523);
    if (Util.isNullOrNil(this.KTitle))
    {
      str = getString(R.l.address_title_select_contact);
      AppMethodBeat.o(253523);
      return str;
    }
    String str = this.KTitle;
    AppMethodBeat.o(253523);
    return str;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public int getLayoutId()
  {
    return R.i.gna;
  }
  
  public final r jyF()
  {
    AppMethodBeat.i(253552);
    r localr = super.jyF();
    Object localObject = localr;
    if (localr == null)
    {
      localObject = this.aflb;
      getContentLV().setAdapter((ListAdapter)localObject);
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "getInitAdapter is null");
    }
    AppMethodBeat.o(253552);
    return localObject;
  }
  
  public final boolean jyP()
  {
    return this.aflg;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253490);
    super.onCreate(paramBundle);
    this.KTitle = getIntent().getStringExtra("titile");
    this.afll = getIntent().getBooleanExtra("can_go_to_profile", false);
    setMMTitle(bVz());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253430);
        SelectPrivacyContactsFromRangeUI.this.hideVKB();
        SelectPrivacyContactsFromRangeUI.this.finish();
        AppMethodBeat.o(253430);
        return false;
      }
    });
    Object localObject;
    if (!this.aflf)
    {
      localObject = getString(R.l.app_finish);
      MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253414);
          if (SelectPrivacyContactsFromRangeUI.a(SelectPrivacyContactsFromRangeUI.this) == 16)
          {
            paramAnonymousMenuItem = SelectPrivacyContactsFromRangeUI.d(SelectPrivacyContactsFromRangeUI.this);
            String str = SelectPrivacyContactsFromRangeUI.this.getIntent().getStringExtra("privacy_del_tips");
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(253403);
                SelectPrivacyContactsFromRangeUI.b(SelectPrivacyContactsFromRangeUI.this);
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Contact", Util.listToString(SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)), ","));
                SelectPrivacyContactsFromRangeUI.this.setResult(-1, localIntent);
                SelectPrivacyContactsFromRangeUI.this.finish();
                AppMethodBeat.o(253403);
              }
            };
            k.a(paramAnonymousMenuItem.mContext, str, "", paramAnonymousMenuItem.mContext.getResources().getString(R.l.gqk), paramAnonymousMenuItem.mContext.getResources().getString(R.l.app_cancel), new a.3(paramAnonymousMenuItem, local1), null, R.e.Link);
          }
          for (;;)
          {
            AppMethodBeat.o(253414);
            return true;
            SelectPrivacyContactsFromRangeUI.b(SelectPrivacyContactsFromRangeUI.this);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)), ","));
            SelectPrivacyContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
            SelectPrivacyContactsFromRangeUI.this.finish();
          }
        }
      };
      if (this.afbe == 16)
      {
        paramBundle = y.b.adEK;
        addTextOptionMenu(1, (String)localObject, local2, null, paramBundle);
        enableOptionMenu(1, false);
      }
    }
    else
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(681, this);
      this.aflk = getIntent().getBooleanExtra("need_show_all_selected", false);
      if (!this.aflk) {
        break label422;
      }
      this.afld = findViewById(R.h.fAS);
      this.afle = ((ImageView)this.afld.findViewById(e.e.xpY));
      this.afle.setVisibility(0);
      this.xtL = true;
      jzJ();
      this.afld.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(253412);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/SelectPrivacyContactsFromRangeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = SelectPrivacyContactsFromRangeUI.this;
          if (!SelectPrivacyContactsFromRangeUI.e(SelectPrivacyContactsFromRangeUI.this)) {}
          for (boolean bool = true;; bool = false)
          {
            SelectPrivacyContactsFromRangeUI.a(paramAnonymousView, bool);
            SelectPrivacyContactsFromRangeUI.f(SelectPrivacyContactsFromRangeUI.this);
            if (!SelectPrivacyContactsFromRangeUI.e(SelectPrivacyContactsFromRangeUI.this)) {
              break;
            }
            paramAnonymousView = SelectPrivacyContactsFromRangeUI.g(SelectPrivacyContactsFromRangeUI.this).iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (String)paramAnonymousView.next();
              if (!SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)).contains(localObject)) {
                SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)).add(localObject);
              }
            }
          }
          SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)).clear();
          SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this).notifyDataSetChanged();
          SelectPrivacyContactsFromRangeUI.h(SelectPrivacyContactsFromRangeUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/privacy/SelectPrivacyContactsFromRangeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253412);
        }
      });
      if (this.aflj) {
        break label379;
      }
      com.tencent.mm.kernel.h.baF();
      paramBundle = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(this.afiB, "", this.afau, "", new ArrayList());
      if (paramBundle == null) {
        break label358;
      }
      paramBundle.moveToFirst();
      label274:
      if (paramBundle.isAfterLast()) {
        break label352;
      }
      localObject = new au();
      ((au)localObject).convertFrom(paramBundle);
      if (aL((au)localObject)) {
        break label335;
      }
      this.afli.add(((az)localObject).field_username);
    }
    for (;;)
    {
      paramBundle.moveToNext();
      break label274;
      paramBundle = y.b.adEJ;
      break;
      label335:
      this.aflh.add(((az)localObject).field_username);
    }
    label352:
    paramBundle.close();
    label358:
    a.a(this.aflb).addAll(this.afli);
    aNr();
    for (;;)
    {
      label379:
      if (getIntent().getIntExtra("last_page_source_type", 0) == 1) {
        com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 5L, 0L, 0L, 0L);
      }
      AppMethodBeat.o(253490);
      return;
      label422:
      this.afld = findViewById(R.h.fAS);
      this.afld.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253512);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(681, this);
    this.aflb.finish();
    super.onDestroy();
    AppMethodBeat.o(253512);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(253548);
    Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    AppMethodBeat.o(253548);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r
  {
    private int GzH;
    private HashMap<String, Integer> JUK;
    private SparseArray<String> JUL;
    private List<String> JXy;
    private Cursor pKb;
    private String query;
    
    public a(o paramo, int paramInt)
    {
      super(com.tencent.mm.pluginsdk.platformtools.a.iIW(), true, false);
      AppMethodBeat.i(253347);
      this.JUK = new HashMap();
      this.JUL = new SparseArray();
      this.query = "";
      this.JXy = new LinkedList();
      this.GzH = paramInt;
      aNm();
      AppMethodBeat.o(253347);
    }
    
    public final void aEJ(String paramString)
    {
      AppMethodBeat.i(253363);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      aNm();
      AppMethodBeat.o(253363);
    }
    
    public final int aJM(String paramString)
    {
      AppMethodBeat.i(253404);
      if (this.JUK != null)
      {
        if (this.JUK.containsKey(paramString))
        {
          int i = ((Integer)this.JUK.get(paramString)).intValue();
          int j = this.afex.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(253404);
          return i + j;
        }
        AppMethodBeat.o(253404);
        return -1;
      }
      AppMethodBeat.o(253404);
      return -1;
    }
    
    public final void aNm()
    {
      AppMethodBeat.i(253394);
      super.aNm();
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      this.JUK.clear();
      this.JUL.clear();
      if ((("@all.contact.android".equals(SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this)))) && ((SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this) == null) || (SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(253394);
        return;
      }
      com.tencent.mm.kernel.h.baF();
      this.pKb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), this.query, SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", cVa());
      String[] arrayOfString = ab.a(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", this.query, cVa());
      int[] arrayOfInt = ab.a(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", cVa(), this.query);
      int j;
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        j = 0;
        int i = 0;
        if (j < arrayOfString.length)
        {
          if (j >= arrayOfInt.length) {
            break label295;
          }
          this.JUK.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.JUL.put(arrayOfInt[j] + i, arrayOfString[j]);
          i += 1;
        }
      }
      label295:
      for (;;)
      {
        j += 1;
        break;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(253394);
        return;
      }
    }
    
    public final void bCa(String paramString)
    {
      AppMethodBeat.i(253372);
      if (this.JXy.contains(paramString)) {
        this.JXy.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(253372);
        return;
        if (this.JXy.size() >= this.GzH)
        {
          k.d(SelectPrivacyContactsFromRangeUI.this.getContext(), SelectPrivacyContactsFromRangeUI.this.getString(R.l.gqi, new Object[] { Integer.valueOf(this.GzH) }), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(253372);
          return;
        }
        this.JXy.add(paramString);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(253428);
      super.finish();
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "finish!");
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      AppMethodBeat.o(253428);
    }
    
    public final boolean gZe()
    {
      AppMethodBeat.i(253381);
      if (SelectPrivacyContactsFromRangeUI.i(SelectPrivacyContactsFromRangeUI.this))
      {
        AppMethodBeat.o(253381);
        return false;
      }
      AppMethodBeat.o(253381);
      return true;
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(253435);
      if (this.pKb != null)
      {
        int i = this.pKb.getCount();
        AppMethodBeat.o(253435);
        return i;
      }
      AppMethodBeat.o(253435);
      return 0;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(253422);
      if (this.pKb == null)
      {
        AppMethodBeat.o(253422);
        return 0;
      }
      int j = this.pKb.getCount();
      if (this.JUL == null) {}
      for (;;)
      {
        AppMethodBeat.o(253422);
        return i + j;
        i = this.JUL.size();
      }
    }
    
    public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(253415);
      Object localObject2;
      if (this.JUL.indexOfKey(paramInt) >= 0)
      {
        localObject2 = (String)this.JUL.get(paramInt);
        localObject1 = new j(paramInt);
        ((j)localObject1).header = ((String)localObject2);
        AppMethodBeat.o(253415);
        return localObject1;
      }
      int i = 0;
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
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.pKb.moveToPosition(i))
      {
        Log.d("MicroMsg.SelectPrivacyContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        au localau = new au();
        localau.convertFrom(this.pKb);
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = localau;
        if (au.bwE(localau.field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).afey = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afez = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afjA = false;
          ((f)localObject2).afjT = true;
          label222:
          localObject1 = localObject2;
          if (SelectPrivacyContactsFromRangeUI.this.b((com.tencent.mm.ui.contact.a.a)localObject2)) {
            SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this).JXy.remove(localau.field_username);
          }
        }
      }
      for (Object localObject1 = localObject2;; localObject1 = null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject1).afey = true;
        break;
        ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
        ((com.tencent.mm.ui.contact.a.a)localObject2).afez = jyD();
        ((f)localObject2).afjT = false;
        break label222;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.ui.contact.p
  {
    private SelectPrivacyContactsFromRangeUI.a aflp;
    
    public b(o paramo, SelectPrivacyContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.aflp = parama;
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(253339);
      clearCache();
      this.aflp.aEJ(paramString);
      if (this.afew != null) {
        this.afew.h(paramString, getCount(), true);
      }
      AppMethodBeat.o(253339);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(253343);
      this.aflp.aEJ("");
      AppMethodBeat.o(253343);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(253360);
      int i = this.aflp.getCount();
      AppMethodBeat.o(253360);
      return i;
    }
    
    public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(253351);
      com.tencent.mm.ui.contact.a.a locala = this.aflp.yk(paramInt);
      AppMethodBeat.o(253351);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.SelectPrivacyContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */