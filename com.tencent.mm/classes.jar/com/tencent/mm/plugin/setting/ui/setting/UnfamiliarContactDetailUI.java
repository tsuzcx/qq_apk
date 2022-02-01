package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.c.au;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.model.m.1;
import com.tencent.mm.plugin.setting.model.m.a;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;>;

public class UnfamiliarContactDetailUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  public static final String fwx;
  private p ftP;
  private ArrayList<b> hIP;
  private boolean wdf;
  private boolean wdg;
  private boolean wdh;
  private RecyclerView wjM;
  private TextView wjN;
  private View wjO;
  private View wjP;
  private View wjQ;
  private View wjR;
  private TextView wjS;
  private a wjT;
  private RealAlphabetScrollBar wjU;
  HashMap<String, Integer> wjV;
  private HashMap<Integer, String> wjW;
  private HashSet<Integer> wjX;
  private d wjY;
  private int wjZ;
  private HashSet<String> wka;
  private m wkb;
  private boolean wkc;
  
  static
  {
    AppMethodBeat.i(74619);
    fwx = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.wjV = new HashMap();
    this.wjW = new HashMap();
    this.hIP = new ArrayList();
    this.wjX = new HashSet();
    this.wjZ = -1;
    this.wka = new HashSet();
    this.ftP = null;
    AppMethodBeat.o(74605);
  }
  
  private void fi(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.wjV.clear();
    this.wjW.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (fwx.equalsIgnoreCase(((b)localObject).wkj)) {
        ((b)localObject).wkj = "#";
      }
      localObject = ((b)localObject).wkj;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.wjV.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.wjW.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    ad.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ftP = p.a(this, getString(2131764557), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.ftP != null) && (this.ftP.isShowing()))
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(74613);
  }
  
  public int getLayoutId()
  {
    return 2131495410;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(74609);
    super.initView();
    setMMTitle(2131763483);
    addTextOptionMenu(1, getString(2131764560), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74568);
        paramAnonymousMenuItem = UnfamiliarContactDetailUI.this;
        boolean bool;
        if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this))
        {
          bool = true;
          UnfamiliarContactDetailUI.a(paramAnonymousMenuItem, bool);
          UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
          UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this));
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label136;
          }
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(2131764554));
        }
        for (;;)
        {
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
          }
          AppMethodBeat.o(74568);
          return true;
          bool = false;
          break;
          label136:
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(2131764560));
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74573);
        UnfamiliarContactDetailUI.this.finish();
        AppMethodBeat.o(74573);
        return true;
      }
    });
    View localView = findViewById(2131304649);
    if (this.wdf)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131304651);
      if (!this.wdh) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131304650);
      if (!this.wdg) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.wjM = ((RecyclerView)findViewById(2131306185));
      this.wjO = findViewById(2131297432);
      this.wjN = ((TextView)findViewById(2131302229));
      this.wjY = new d(this.wjX, new g()
      {
        public final void doy()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void doz()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void gV(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.wkA += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            ad.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(2131764555, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.wjP = findViewById(2131306182);
      this.wjP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74577);
          com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(2131764563), UnfamiliarContactDetailUI.this.getContext().getString(2131757641), UnfamiliarContactDetailUI.this.getContext().getString(2131755707), UnfamiliarContactDetailUI.this.getContext().getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74576);
              if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this) != null)
              {
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afA().gcy.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.tyG = 0;
                paramAnonymous2DialogInterface.wkt = 0;
                paramAnonymous2DialogInterface.wku.clear();
                paramAnonymous2DialogInterface.wkv.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.wkr != null) {
                  paramAnonymous2DialogInterface.wkr.doz();
                }
                com.tencent.e.h.Iye.aP(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, 2131099904, 0);
          AppMethodBeat.o(74577);
        }
      });
      this.wjQ = findViewById(2131306183);
      this.wjQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2l.a(0, UnfamiliarContactDetailUI.this.getString(2131761631), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689946), false);
              paramAnonymous2l.a(1, UnfamiliarContactDetailUI.this.getString(2131761632), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689947), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.csG();
          AppMethodBeat.o(74580);
        }
      });
      this.wjR = findViewById(2131306184);
      this.wjR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          paramAnonymousView = (CheckBox)UnfamiliarContactDetailUI.i(UnfamiliarContactDetailUI.this).findViewById(2131298255);
          if (!paramAnonymousView.isChecked()) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            if (!paramAnonymousView.isChecked()) {
              break;
            }
            int i = 0;
            while (i < UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size())
            {
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).add(Integer.valueOf(i));
              i += 1;
            }
          }
          UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
          if (UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size() > 0)
          {
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(true);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(true);
          }
          for (;;)
          {
            UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74581);
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
                AppMethodBeat.o(74581);
              }
            });
            AppMethodBeat.o(74582);
            return;
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          }
        }
      });
      this.wjS = ((TextView)findViewById(2131305880));
      this.wjM.setLayoutManager(new LinearLayoutManager());
      this.wjT = new a();
      this.wjM.setAdapter(this.wjT);
      this.wjU = ((RealAlphabetScrollBar)findViewById(2131306186));
      this.wjU.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void pb(String paramAnonymousString)
        {
          AppMethodBeat.i(74583);
          Object localObject = UnfamiliarContactDetailUI.this;
          if ((((UnfamiliarContactDetailUI)localObject).wjV != null) && (((UnfamiliarContactDetailUI)localObject).wjV.containsKey(paramAnonymousString))) {}
          for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).wjV.get(paramAnonymousString)).intValue();; i = -1)
          {
            ad.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramAnonymousString, Integer.valueOf(i) });
            if (i != -1)
            {
              paramAnonymousString = UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this);
              localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
            }
            AppMethodBeat.o(74583);
            return;
          }
        }
      });
      AppMethodBeat.o(74609);
      return;
      i = 8;
      break;
      i = 8;
      break label90;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74606);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(291, this);
    this.wdf = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.wdg = getIntent().getBooleanExtra("half_year_not_response", false);
    this.wdh = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        ad.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.wky)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131760709));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.wkx) {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764565));
        }
        AppMethodBeat.o(74587);
      }
      
      public final void f(HashSet paramAnonymousHashSet)
      {
        AppMethodBeat.i(74588);
        if (paramAnonymousHashSet == null) {}
        for (int i = 0;; i = paramAnonymousHashSet.size())
        {
          ad.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
          if (paramAnonymousHashSet != null) {
            UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, paramAnonymousHashSet);
          }
          AppMethodBeat.o(74588);
          return;
        }
      }
      
      public final void onError()
      {
        AppMethodBeat.i(74586);
        ad.e("MicroMsg.UnfamiliarContactUI", "[onError]");
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764564));
        AppMethodBeat.o(74586);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(74585);
        ad.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
        UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
        if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() == 0)
        {
          UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
          UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(8);
          UnfamiliarContactDetailUI.this.findViewById(2131301449).setVisibility(8);
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131760705));
          AppMethodBeat.o(74585);
          return;
        }
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(8);
        UnfamiliarContactDetailUI.this.findViewById(2131301449).setVisibility(0);
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aql.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.wkb = new m(this.wdf, this.wdg, this.wdh, paramBundle);
    paramBundle = this.wkb;
    paramBundle.wdp = System.currentTimeMillis();
    paramBundle.wdo.a(e.wky);
    paramBundle.nKw.postToWorker(new m.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.wdf)
    {
      i = 1;
      if (!this.wdh) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.wdg) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.h.vKh.f(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.wkB), Integer.valueOf(f.wkA), Integer.valueOf(f.wkF), Integer.valueOf(f.wkC), Integer.valueOf(f.wkE), Integer.valueOf(f.wkD) });
      ad.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.wkB), Integer.valueOf(f.wkA), Integer.valueOf(f.wkF), Integer.valueOf(f.wkC), Integer.valueOf(f.wkE), Integer.valueOf(f.wkD) });
      f.wkA = 0;
      f.wkB = 0;
      f.wkC = 0;
      f.wkD = 0;
      f.wkE = 0;
      f.wkF = 0;
      com.tencent.mm.kernel.g.aeS().b(291, this);
      com.tencent.mm.kernel.g.aeS().b(681, this.wjY);
      m localm = this.wkb;
      ad.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localm.wdg), Boolean.valueOf(localm.wdf), Boolean.valueOf(localm.wdh) });
      if (localm.wdn != null)
      {
        m.a locala = localm.wdn;
        com.tencent.mm.kernel.g.aeS().b(292, locala);
      }
      if (localm.wdq != null) {
        localm.wdq.cancel();
      }
      localm.nKw.quit();
      AppMethodBeat.o(74608);
      return;
      i = 0;
      break;
      j = 0;
      break label28;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74610);
    if (paramInt == 4)
    {
      onBackPressed();
      AppMethodBeat.o(74610);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74610);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74607);
    super.onResume();
    int i;
    if (-1 != this.wjZ)
    {
      if (-1 != this.wjZ) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.wkB += 1;
      }
      this.wjZ = -1;
      this.wka.clear();
      if (this.wjT != null) {
        this.wjT.aql.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.hIP.get(this.wjZ);
      af localaf1 = localb.contact;
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localaf1.field_username);
      if ((!com.tencent.mm.n.b.ls(localaf2.field_type)) && (com.tencent.mm.n.b.ls(localaf1.field_type)))
      {
        this.hIP.remove(this.wjZ);
        i = 1;
      }
      else
      {
        localb.contact = localaf2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74611);
    ad.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(2131764562), 1).show();
    }
    if (paramn.getType() == 291)
    {
      iF(false);
      this.wka.clear();
      this.wjT.aql.notifyChanged();
    }
    AppMethodBeat.o(74611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a
  {
    a() {}
    
    public final UnfamiliarContactDetailUI.b LF(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new af());
      AppMethodBeat.o(74593);
      return localb;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(74590);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495814, paramViewGroup, false);
      paramViewGroup = new UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, paramViewGroup);
      AppMethodBeat.o(74590);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(74591);
      if ((paramv instanceof UnfamiliarContactDetailUI.c))
      {
        paramv = (UnfamiliarContactDetailUI.c)paramv;
        paramv.wkn.setTag(Integer.valueOf(paramInt));
        paramv.arI.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramv.fwD.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramv.nkb.setText(com.tencent.mm.pluginsdk.ui.span.k.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).fyo, paramv.nkb.getTextSize()));
        ImageView localImageView = paramv.wkm;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.ZP())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramv.wkl;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((o.wzJ != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = o.wzJ.sr(5L);
            UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).addAll(localList);
          }
          if (!UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).contains(localObject)) {
            break label347;
          }
          i = 0;
          label208:
          localImageView.setVisibility(i);
          if (!UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).containsKey(Integer.valueOf(paramInt))) {
            break label353;
          }
          paramv.wkk.setVisibility(0);
          paramv.wkk.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramv.wko.setPadding(paramv.wko.getPaddingLeft(), paramv.wko.getPaddingTop(), 0, paramv.wko.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramv.hIS.setChecked(true);
        }
        for (;;)
        {
          paramv.wkn.setVisibility(0);
          AppMethodBeat.o(74591);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramv.wkk.setVisibility(8);
          break label263;
          label365:
          paramv.hIS.setChecked(false);
        }
        label376:
        paramv.wko.setPadding(paramv.wko.getPaddingLeft(), paramv.wko.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(2131165489), paramv.wko.getPaddingBottom());
        paramv.wkn.setVisibility(8);
      }
      AppMethodBeat.o(74591);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(74592);
      int i = UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size();
      AppMethodBeat.o(74592);
      return i;
    }
  }
  
  final class b
  {
    af contact;
    String fyo;
    String wkj;
    
    public b(af paramaf)
    {
      this.contact = paramaf;
    }
  }
  
  final class c
    extends RecyclerView.v
  {
    View arI;
    MaskLayout fwD;
    CheckBox hIS;
    TextView nkb;
    TextView wkk;
    ImageView wkl;
    ImageView wkm;
    LinearLayout wkn;
    LinearLayout wko;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.arI = paramView;
      this.fwD = ((MaskLayout)paramView.findViewById(2131298584));
      this.nkb = ((TextView)paramView.findViewById(2131298678));
      this.wkk = ((TextView)paramView.findViewById(2131298583));
      this.wkl = ((ImageView)paramView.findViewById(2131298713));
      this.wkm = ((ImageView)paramView.findViewById(2131298714));
      this.wkn = ((LinearLayout)paramView.findViewById(2131298256));
      this.hIS = ((CheckBox)paramView.findViewById(2131298255));
      this.wko = ((LinearLayout)paramView.findViewById(2131301145));
      this.wkn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.c.this.hIS;
          boolean bool;
          if (!UnfamiliarContactDetailUI.c.this.hIS.isChecked())
          {
            bool = true;
            paramAnonymousView.setChecked(bool);
            if (!UnfamiliarContactDetailUI.c.this.hIS.isChecked()) {
              break label130;
            }
            UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).add(Integer.valueOf(i));
          }
          for (;;)
          {
            if (UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size() != 0) {
              break label151;
            }
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
            AppMethodBeat.o(74594);
            return;
            bool = false;
            break;
            label130:
            UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).remove(Integer.valueOf(i));
          }
          label151:
          UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(true);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(true);
          AppMethodBeat.o(74594);
        }
      });
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74595);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).LF(i);
          ad.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.fyo });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  final class d
    extends com.tencent.e.i.b
    implements com.tencent.mm.al.g
  {
    int index;
    int tyG;
    UnfamiliarContactDetailUI.g wkr;
    Collection<Integer> wks;
    int wkt;
    LinkedList<String> wku;
    LinkedList<j.b> wkv;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.tyG = 0;
      this.wkt = 0;
      this.index = 0;
      this.wku = new LinkedList();
      this.wkv = new LinkedList();
      this.wks = paramg;
      Object localObject;
      this.wkr = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.wkr != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.wkr.doy();
      }
      AppMethodBeat.o(182596);
      return false;
    }
    
    public final String getKey()
    {
      return "delete_contact_task";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(74601);
      if (paramn.getType() == 681)
      {
        if ((((com.tencent.mm.bb.b)paramn).hos == null) || ((b.c)((com.tencent.mm.bb.b)paramn).hos.getRespObj() == null))
        {
          ad.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((b.c)((com.tencent.mm.bb.b)paramn).hos.getRespObj()).hox;
        if ((((bxb)localObject).Ret != 0) || (((bxb)localObject).DTv == null) || (((bxb)localObject).DTv.DpH == null))
        {
          ad.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bxb)localObject).Ret) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.bb.b)paramn).hot;
        paramn = ((bxb)localObject).DTv.DpH;
        ad.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramn.size()) });
        paramInt1 = 0;
        if (paramInt1 < paramString.size())
        {
          localObject = (j.b)paramString.get(paramInt1);
          if (((j.b)localObject).getCmdId() != 4) {
            ad.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((j.b)localObject).getCmdId()), localObject.toString() });
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            this.tyG -= 1;
            localObject = (zw)((j.b)localObject).tyM;
            if (((Integer)paramn.get(paramInt1)).intValue() == 0)
            {
              this.wkt += 1;
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(z.a(((zw)localObject).Dby));
              if (localObject != null)
              {
                ((af)localObject).Zl();
                bi.a(((au)localObject).field_username, null);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(((au)localObject).field_username, (af)localObject);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIl(((au)localObject).field_username);
                this.wku.add(((au)localObject).field_username);
              }
            }
            else
            {
              ad.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramn.get(paramInt1), z.a(((zw)localObject).Dby) });
            }
          }
        }
        if (this.tyG <= 0)
        {
          paramString = this.wku.iterator();
          while (paramString.hasNext())
          {
            paramn = (String)paramString.next();
            localObject = UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).contact.field_username.equals(paramn)) {
                ((Iterator)localObject).remove();
              }
            }
          }
          UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this));
          UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74598);
              if (UnfamiliarContactDetailUI.d.this.wkr != null)
              {
                UnfamiliarContactDetailUI.d.this.wkr.gV(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.wkt);
                UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
              }
              AppMethodBeat.o(74598);
            }
          });
        }
      }
      AppMethodBeat.o(74601);
    }
    
    public final void run()
    {
      AppMethodBeat.i(74600);
      this.tyG = this.wks.size();
      Iterator localIterator = this.wks.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.wks.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          af localaf = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).LF(i).contact;
          if (af.aHH(localaf.field_username))
          {
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Be(localaf.field_username);
          }
          else
          {
            zw localzw = new zw();
            localzw.Dby = new cmf().aEE(bt.nullAsNil(localaf.field_username));
            this.wkv.add(new j.a(4, localzw));
            if ((this.wkv.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.bb.b(this.wkv), 0);
              this.wkv.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  public static enum e
  {
    static
    {
      AppMethodBeat.i(74604);
      wkx = new e("OVER_ONE_MIN", 0);
      wky = new e("NORMAL", 1);
      wkz = new e[] { wkx, wky };
      AppMethodBeat.o(74604);
    }
    
    private e() {}
  }
  
  static final class f
  {
    static int wkA;
    static int wkB;
    static int wkC;
    static int wkD;
    static int wkE;
    static int wkF;
  }
  
  static abstract interface g
  {
    public abstract void doy();
    
    public abstract void doz();
    
    public abstract void gV(int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract void a(UnfamiliarContactDetailUI.e parame);
    
    public abstract void f(HashSet paramHashSet);
    
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */