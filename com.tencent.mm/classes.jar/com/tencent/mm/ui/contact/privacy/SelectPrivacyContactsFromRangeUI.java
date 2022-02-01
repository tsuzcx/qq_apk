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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.p.a;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SelectPrivacyContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements i
{
  private String EdO;
  private String KTitle;
  private String XoS;
  private int XpC;
  private String[] XwA;
  private a XyL;
  private b XyM;
  private View XyN;
  private ImageView XyO;
  private boolean XyP;
  private boolean XyQ;
  private Set<String> XyR;
  private Set<String> XyS;
  private boolean XyT;
  private boolean XyU;
  private a Xyz;
  private boolean unp;
  
  public SelectPrivacyContactsFromRangeUI()
  {
    AppMethodBeat.i(292249);
    this.XyQ = true;
    this.XyR = new HashSet();
    this.XyS = new HashSet();
    this.Xyz = new a(this);
    this.XyT = false;
    AppMethodBeat.o(292249);
  }
  
  private boolean aG(as paramas)
  {
    boolean bool = true;
    AppMethodBeat.i(292262);
    if (paramas != null)
    {
      int i;
      if (this.XpC != 16)
      {
        i = 1;
        if (!"@sns.black.android".equals(this.EdO)) {
          break label62;
        }
        if ((i == 0) || (!paramas.ayi())) {
          break label57;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(292262);
        return bool;
        i = 0;
        break;
        label57:
        bool = false;
        continue;
        label62:
        if ("@sns.unlike.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.ayg())) {
            bool = false;
          }
        }
        else if ("@werun.black.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.ayd())) {
            bool = false;
          }
        }
        else if ("@tophistory.black.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.aye())) {
            bool = false;
          }
        }
        else if ("@tophistory.unlike.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.ayf())) {
            bool = false;
          }
        }
        else if ("@social.black.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.ayk())) {
            bool = false;
          }
        }
        else if ("@finder.block.his.liked.android".equals(this.EdO))
        {
          if ((i == 0) || (!paramas.ayl())) {
            bool = false;
          }
        }
        else
        {
          if (!"@finder.block.my.liked.android".equals(this.EdO)) {
            break label258;
          }
          if ((i == 0) || (!paramas.aym())) {
            bool = false;
          }
        }
      }
      label258:
      AppMethodBeat.o(292262);
      return false;
    }
    AppMethodBeat.o(292262);
    return false;
  }
  
  private void atk()
  {
    AppMethodBeat.i(292255);
    if (this.XyP)
    {
      AppMethodBeat.o(292255);
      return;
    }
    if (a.a(this.XyL).size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_finish) + "(" + a.a(this.XyL).size() + ")");
      enableOptionMenu(1, true);
    }
    while (this.XyU) {
      if (a.a(this.XyL).size() == this.XyL.getContactCount())
      {
        if (!this.unp)
        {
          this.unp = true;
          hVN();
          AppMethodBeat.o(292255);
          return;
          updateOptionMenuText(1, getString(R.l.app_finish));
          enableOptionMenu(1, false);
        }
      }
      else if (this.unp)
      {
        this.unp = false;
        hVN();
      }
    }
    AppMethodBeat.o(292255);
  }
  
  private void hVN()
  {
    AppMethodBeat.i(292256);
    if (this.unp)
    {
      com.tencent.mm.plugin.downloader_app.b.e(this.XyO, "checkbox_cell_on");
      AppMethodBeat.o(292256);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.e(this.XyO, "checkbox_cell_off");
    AppMethodBeat.o(292256);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(292260);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(292260);
      return;
    }
    paramView = hUP().awM(i);
    if ((paramView == null) || (!(paramView instanceof f)))
    {
      AppMethodBeat.o(292260);
      return;
    }
    if (b(paramView))
    {
      AppMethodBeat.o(292260);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "ClickUser=%s", new Object[] { paramView });
    this.XyL.bAh(paramView);
    atk();
    if ((hUP() instanceof b))
    {
      hUZ();
      hideVKB();
    }
    AppMethodBeat.o(292260);
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(292253);
    if ((paramInt == 1) && (paramString != null))
    {
      this.XyL.bAh(paramString);
      atk();
      this.XyL.notifyDataSetChanged();
    }
    AppMethodBeat.o(292253);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(292264);
    if ((parama instanceof f))
    {
      boolean bool = a.a(this.XyL).contains(((f)parama).username);
      AppMethodBeat.o(292264);
      return bool;
    }
    AppMethodBeat.o(292264);
    return false;
  }
  
  public final void ata()
  {
    boolean bool2 = false;
    AppMethodBeat.i(292251);
    super.ata();
    this.XpC = getIntent().getIntExtra("list_type", 0);
    this.XoS = getIntent().getStringExtra("filter_type");
    this.XwA = getIntent().getStringArrayExtra("already_select_contact");
    int i = getIntent().getIntExtra("max_limit_num", 100);
    this.EdO = getIntent().getStringExtra("privacy_source_type");
    this.XyL = new a(this, i);
    this.XyP = getIntent().getBooleanExtra("only_show_contact", false);
    Object localObject = this.XyL;
    boolean bool1;
    if (!this.XyP)
    {
      bool1 = true;
      ((com.tencent.mm.ui.contact.q)localObject).XsX = bool1;
      if (this.XyP) {
        this.XyQ = false;
      }
      if ((!this.XyP) && (("@all.contact.android".equals(this.XoS)) || ("@all.contact.without.chatroom.without.openim".equals(this.XoS))))
      {
        localObject = aj.fOw();
        if ((this.XwA == null) || (this.XwA.length == 0)) {
          break label302;
        }
        String[] arrayOfString = this.XwA;
        int j = arrayOfString.length;
        i = 0;
        label210:
        if (i >= j) {
          break label302;
        }
        if (!d.rk(((bv)localObject).RG(arrayOfString[i]).field_type)) {
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
      this.XyT = bool1;
      this.XyM = new b(this, this.XyL);
      this.XyM.XsX = true;
      this.XyL.notifyDataSetChanged();
      AppMethodBeat.o(292251);
      return;
      bool1 = false;
      break;
      i += 1;
      break label210;
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(292261);
    if (((parama instanceof f)) && (parama.contact != null))
    {
      if ((this.XpC != 16) && (aG(parama.contact)))
      {
        AppMethodBeat.o(292261);
        return true;
      }
      AppMethodBeat.o(292261);
      return false;
    }
    AppMethodBeat.o(292261);
    return false;
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return true;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(292258);
    if (Util.isNullOrNil(this.KTitle))
    {
      str = getString(R.l.address_title_select_contact);
      AppMethodBeat.o(292258);
      return str;
    }
    String str = this.KTitle;
    AppMethodBeat.o(292258);
    return str;
  }
  
  public final r bwK()
  {
    return this.XyL;
  }
  
  public final p bwL()
  {
    return this.XyM;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public int getLayoutId()
  {
    return R.i.ejX;
  }
  
  public final r hUQ()
  {
    AppMethodBeat.i(292266);
    r localr = super.hUQ();
    Object localObject = localr;
    if (localr == null)
    {
      localObject = this.XyL;
      getContentLV().setAdapter((ListAdapter)localObject);
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "getInitAdapter is null");
    }
    AppMethodBeat.o(292266);
    return localObject;
  }
  
  public final boolean hVc()
  {
    return this.XyQ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(292250);
    super.onCreate(paramBundle);
    this.KTitle = getIntent().getStringExtra("titile");
    setMMTitle(bwJ());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(279477);
        SelectPrivacyContactsFromRangeUI.this.hideVKB();
        SelectPrivacyContactsFromRangeUI.this.finish();
        AppMethodBeat.o(279477);
        return false;
      }
    });
    Object localObject;
    if (!this.XyP)
    {
      localObject = getString(R.l.app_finish);
      MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(281525);
          if (SelectPrivacyContactsFromRangeUI.a(SelectPrivacyContactsFromRangeUI.this) == 16)
          {
            paramAnonymousMenuItem = SelectPrivacyContactsFromRangeUI.d(SelectPrivacyContactsFromRangeUI.this);
            String str = SelectPrivacyContactsFromRangeUI.this.getIntent().getStringExtra("privacy_del_tips");
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(267563);
                SelectPrivacyContactsFromRangeUI.b(SelectPrivacyContactsFromRangeUI.this);
                Intent localIntent = new Intent();
                localIntent.putExtra("Select_Contact", Util.listToString(SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)), ","));
                SelectPrivacyContactsFromRangeUI.this.setResult(-1, localIntent);
                SelectPrivacyContactsFromRangeUI.this.finish();
                AppMethodBeat.o(267563);
              }
            };
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem.mContext, str, "", paramAnonymousMenuItem.mContext.getResources().getString(R.l.enj), paramAnonymousMenuItem.mContext.getResources().getString(R.l.app_cancel), new a.3(paramAnonymousMenuItem, local1), null, R.e.Link);
          }
          for (;;)
          {
            AppMethodBeat.o(281525);
            return true;
            SelectPrivacyContactsFromRangeUI.b(SelectPrivacyContactsFromRangeUI.this);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectPrivacyContactsFromRangeUI.a.a(SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this)), ","));
            SelectPrivacyContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
            SelectPrivacyContactsFromRangeUI.this.finish();
          }
        }
      };
      if (this.XpC == 16)
      {
        paramBundle = w.b.Wap;
        addTextOptionMenu(1, (String)localObject, local2, null, paramBundle);
        enableOptionMenu(1, false);
      }
    }
    else
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(681, this);
      this.XyU = getIntent().getBooleanExtra("need_show_all_selected", false);
      if (!this.XyU) {
        break label371;
      }
      this.XyN = findViewById(R.h.dzX);
      this.XyO = ((ImageView)this.XyN.findViewById(e.e.ujS));
      this.XyO.setVisibility(0);
      this.unp = true;
      hVN();
      this.XyN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(288790);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/privacy/SelectPrivacyContactsFromRangeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
          AppMethodBeat.o(288790);
        }
      });
      if (this.XyT) {
        break label364;
      }
      com.tencent.mm.kernel.h.aHH();
      paramBundle = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(this.XwA, "", this.XoS, "", new ArrayList());
      if (paramBundle == null) {
        break label343;
      }
      paramBundle.moveToFirst();
      label259:
      if (paramBundle.isAfterLast()) {
        break label337;
      }
      localObject = new as();
      ((as)localObject).convertFrom(paramBundle);
      if (aG((as)localObject)) {
        break label320;
      }
      this.XyS.add(((ax)localObject).field_username);
    }
    for (;;)
    {
      paramBundle.moveToNext();
      break label259;
      paramBundle = w.b.Wao;
      break;
      label320:
      this.XyR.add(((ax)localObject).field_username);
    }
    label337:
    paramBundle.close();
    label343:
    a.a(this.XyL).addAll(this.XyS);
    atk();
    label364:
    AppMethodBeat.o(292250);
    return;
    label371:
    this.XyN = findViewById(R.h.dzX);
    this.XyN.setVisibility(8);
    AppMethodBeat.o(292250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(292257);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(681, this);
    this.XyL.finish();
    super.onDestroy();
    AppMethodBeat.o(292257);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(292265);
    Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    AppMethodBeat.o(292265);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r
  {
    private int AYg;
    private List<String> Eec;
    private HashMap<String, Integer> Xqo;
    private SparseArray<String> Xqp;
    private Cursor mNt;
    private String query;
    
    public a(o paramo, int paramInt)
    {
      super(com.tencent.mm.pluginsdk.j.a.hhV(), true, false);
      AppMethodBeat.i(279180);
      this.Xqo = new HashMap();
      this.Xqp = new SparseArray();
      this.query = "";
      this.Eec = new LinkedList();
      this.AYg = paramInt;
      ate();
      AppMethodBeat.o(279180);
    }
    
    public final void aIi(String paramString)
    {
      AppMethodBeat.i(279181);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      ate();
      AppMethodBeat.o(279181);
    }
    
    public final void ate()
    {
      AppMethodBeat.i(279184);
      super.ate();
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      this.Xqo.clear();
      this.Xqp.clear();
      if ((("@all.contact.android".equals(SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this)))) && ((SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this) == null) || (SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(279184);
        return;
      }
      com.tencent.mm.kernel.h.aHH();
      this.mNt = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), this.query, SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", csq());
      String[] arrayOfString = ab.a(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", this.query, csq());
      int[] arrayOfInt = ab.a(SelectPrivacyContactsFromRangeUI.k(SelectPrivacyContactsFromRangeUI.this), SelectPrivacyContactsFromRangeUI.j(SelectPrivacyContactsFromRangeUI.this), "", csq(), this.query);
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
          this.Xqo.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.Xqp.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(279184);
        return;
      }
    }
    
    public final void bAh(String paramString)
    {
      AppMethodBeat.i(279182);
      if (this.Eec.contains(paramString)) {
        this.Eec.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(279182);
        return;
        if (this.Eec.size() >= this.AYg)
        {
          com.tencent.mm.ui.base.h.d(SelectPrivacyContactsFromRangeUI.this.getContext(), SelectPrivacyContactsFromRangeUI.this.getString(R.l.enh, new Object[] { Integer.valueOf(this.AYg) }), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(279182);
          return;
        }
        this.Eec.add(paramString);
      }
    }
    
    public final int bzR(String paramString)
    {
      AppMethodBeat.i(279185);
      if (this.Xqo != null)
      {
        if (this.Xqo.containsKey(paramString))
        {
          int i = ((Integer)this.Xqo.get(paramString)).intValue();
          int j = this.XsW.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(279185);
          return i + j;
        }
        AppMethodBeat.o(279185);
        return -1;
      }
      AppMethodBeat.o(279185);
      return -1;
    }
    
    public final boolean fJk()
    {
      AppMethodBeat.i(279183);
      if (SelectPrivacyContactsFromRangeUI.i(SelectPrivacyContactsFromRangeUI.this))
      {
        AppMethodBeat.o(279183);
        return false;
      }
      AppMethodBeat.o(279183);
      return true;
    }
    
    public final void finish()
    {
      AppMethodBeat.i(279189);
      super.finish();
      Log.i("MicroMsg.SelectPrivacyContactsFromRangeUI", "finish!");
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      AppMethodBeat.o(279189);
    }
    
    public final int getContactCount()
    {
      AppMethodBeat.i(279191);
      if (this.mNt != null)
      {
        int i = this.mNt.getCount();
        AppMethodBeat.o(279191);
        return i;
      }
      AppMethodBeat.o(279191);
      return 0;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(279188);
      if (this.mNt == null)
      {
        AppMethodBeat.o(279188);
        return 0;
      }
      int j = this.mNt.getCount();
      if (this.Xqp == null) {}
      for (;;)
      {
        AppMethodBeat.o(279188);
        return i + j;
        i = this.Xqp.size();
      }
    }
    
    public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      AppMethodBeat.i(279187);
      Object localObject2;
      if (this.Xqp.indexOfKey(paramInt) >= 0)
      {
        localObject2 = (String)this.Xqp.get(paramInt);
        localObject1 = new j(paramInt);
        ((j)localObject1).header = ((String)localObject2);
        AppMethodBeat.o(279187);
        return localObject1;
      }
      int i = 0;
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
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.mNt.moveToPosition(i))
      {
        Log.d("MicroMsg.SelectPrivacyContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        as localas = new as();
        localas.convertFrom(this.mNt);
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = localas;
        if (ab.Lj(localas.field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Xxs = false;
          ((f)localObject2).XxM = true;
          label222:
          localObject1 = localObject2;
          if (SelectPrivacyContactsFromRangeUI.this.b((com.tencent.mm.ui.contact.a.a)localObject2)) {
            SelectPrivacyContactsFromRangeUI.c(SelectPrivacyContactsFromRangeUI.this).Eec.remove(localas.field_username);
          }
        }
      }
      for (Object localObject1 = localObject2;; localObject1 = null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject1).XsX = true;
        break;
        ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
        ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = hUO();
        ((f)localObject2).XxM = false;
        break label222;
      }
    }
  }
  
  final class b
    extends p
  {
    private SelectPrivacyContactsFromRangeUI.a XyY;
    
    public b(o paramo, SelectPrivacyContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.XyY = parama;
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(279902);
      clearCache();
      this.XyY.aIi(paramString);
      if (this.XsV != null) {
        this.XsV.g(paramString, getCount(), true);
      }
      AppMethodBeat.o(279902);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(279903);
      this.XyY.aIi("");
      AppMethodBeat.o(279903);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(279905);
      int i = this.XyY.getCount();
      AppMethodBeat.o(279905);
      return i;
    }
    
    public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      AppMethodBeat.i(279904);
      com.tencent.mm.ui.contact.a.a locala = this.XyY.ye(paramInt);
      AppMethodBeat.o(279904);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.SelectPrivacyContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */