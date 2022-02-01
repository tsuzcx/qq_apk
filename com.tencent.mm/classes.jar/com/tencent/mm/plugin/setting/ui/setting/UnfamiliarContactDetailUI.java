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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.c.av;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.model.m.1;
import com.tencent.mm.plugin.setting.model.m.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
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
  implements com.tencent.mm.ak.g
{
  public static final String fAe;
  private p fxw;
  private ArrayList<b> ijq;
  private boolean xot;
  private boolean xou;
  private boolean xov;
  private RecyclerView xvc;
  private TextView xvd;
  private View xve;
  private View xvf;
  private View xvg;
  private View xvh;
  private TextView xvi;
  private a xvj;
  private RealAlphabetScrollBar xvk;
  HashMap<String, Integer> xvl;
  private HashMap<Integer, String> xvm;
  private HashSet<Integer> xvn;
  private d xvo;
  private int xvp;
  private HashSet<String> xvq;
  private m xvr;
  private boolean xvs;
  
  static
  {
    AppMethodBeat.i(74619);
    fAe = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.xvl = new HashMap();
    this.xvm = new HashMap();
    this.ijq = new ArrayList();
    this.xvn = new HashSet();
    this.xvp = -1;
    this.xvq = new HashSet();
    this.fxw = null;
    AppMethodBeat.o(74605);
  }
  
  private void fq(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.xvl.clear();
    this.xvm.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (fAe.equalsIgnoreCase(((b)localObject).xvz)) {
        ((b)localObject).xvz = "#";
      }
      localObject = ((b)localObject).xvz;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.xvl.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.xvm.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    ac.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.fxw = p.a(this, getString(2131764557), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
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
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
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
    if (this.xot)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131304651);
      if (!this.xov) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131304650);
      if (!this.xou) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.xvc = ((RecyclerView)findViewById(2131306185));
      this.xve = findViewById(2131297432);
      this.xvd = ((TextView)findViewById(2131302229));
      this.xvo = new d(this.xvn, new g()
      {
        public final void dCI()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void dCJ()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void he(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.xvQ += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            ac.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(2131764555, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.xvf = findViewById(2131306182);
      this.xvf.setOnClickListener(new View.OnClickListener()
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
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agQ().ghe.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.uHd = 0;
                paramAnonymous2DialogInterface.xvJ = 0;
                paramAnonymous2DialogInterface.xvK.clear();
                paramAnonymous2DialogInterface.xvL.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.xvH != null) {
                  paramAnonymous2DialogInterface.xvH.dCJ();
                }
                com.tencent.e.h.JZN.aS(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, 2131099904, 0);
          AppMethodBeat.o(74577);
        }
      });
      this.xvg = findViewById(2131306183);
      this.xvg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2l.a(0, UnfamiliarContactDetailUI.this.getString(2131761631), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689946), false);
              paramAnonymous2l.a(1, UnfamiliarContactDetailUI.this.getString(2131761632), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689947), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.cED();
          AppMethodBeat.o(74580);
        }
      });
      this.xvh = findViewById(2131306184);
      this.xvh.setOnClickListener(new View.OnClickListener()
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
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
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
      this.xvi = ((TextView)findViewById(2131305880));
      this.xvc.setLayoutManager(new LinearLayoutManager());
      this.xvj = new a();
      this.xvc.setAdapter(this.xvj);
      this.xvk = ((RealAlphabetScrollBar)findViewById(2131306186));
      this.xvk.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void sn(String paramAnonymousString)
        {
          AppMethodBeat.i(74583);
          Object localObject = UnfamiliarContactDetailUI.this;
          if ((((UnfamiliarContactDetailUI)localObject).xvl != null) && (((UnfamiliarContactDetailUI)localObject).xvl.containsKey(paramAnonymousString))) {}
          for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).xvl.get(paramAnonymousString)).intValue();; i = -1)
          {
            ac.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramAnonymousString, Integer.valueOf(i) });
            if (i != -1)
            {
              paramAnonymousString = UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this);
              localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
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
    com.tencent.mm.kernel.g.agi().a(291, this);
    this.xot = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.xou = getIntent().getBooleanExtra("half_year_not_response", false);
    this.xov = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        ac.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.xvO)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131760709));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.xvN) {
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
          ac.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
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
        ac.e("MicroMsg.UnfamiliarContactUI", "[onError]");
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764564));
        AppMethodBeat.o(74586);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(74585);
        ac.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
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
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).arg.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.xvr = new m(this.xot, this.xou, this.xov, paramBundle);
    paramBundle = this.xvr;
    paramBundle.xoD = System.currentTimeMillis();
    paramBundle.xoC.a(UnfamiliarContactDetailUI.e.xvO);
    paramBundle.onw.postToWorker(new m.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.xot)
    {
      i = 1;
      if (!this.xov) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.xou) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.h.wUl.f(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.xvR), Integer.valueOf(f.xvQ), Integer.valueOf(f.xvV), Integer.valueOf(f.xvS), Integer.valueOf(f.xvU), Integer.valueOf(f.xvT) });
      ac.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.xvR), Integer.valueOf(f.xvQ), Integer.valueOf(f.xvV), Integer.valueOf(f.xvS), Integer.valueOf(f.xvU), Integer.valueOf(f.xvT) });
      f.xvQ = 0;
      f.xvR = 0;
      f.xvS = 0;
      f.xvT = 0;
      f.xvU = 0;
      f.xvV = 0;
      com.tencent.mm.kernel.g.agi().b(291, this);
      com.tencent.mm.kernel.g.agi().b(681, this.xvo);
      m localm = this.xvr;
      ac.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localm.xou), Boolean.valueOf(localm.xot), Boolean.valueOf(localm.xov) });
      if (localm.xoB != null)
      {
        m.a locala = localm.xoB;
        com.tencent.mm.kernel.g.agi().b(292, locala);
      }
      if (localm.xoE != null) {
        localm.xoE.cancel();
      }
      localm.onw.quit();
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
    if (-1 != this.xvp)
    {
      if (-1 != this.xvp) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.xvR += 1;
      }
      this.xvp = -1;
      this.xvq.clear();
      if (this.xvj != null) {
        this.xvj.arg.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.ijq.get(this.xvp);
      ai localai1 = localb.contact;
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localai1.field_username);
      if ((!com.tencent.mm.n.b.ln(localai2.field_type)) && (com.tencent.mm.n.b.ln(localai1.field_type)))
      {
        this.ijq.remove(this.xvp);
        i = 1;
      }
      else
      {
        localb.contact = localai2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74611);
    ac.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(2131764562), 1).show();
    }
    if (paramn.getType() == 291)
    {
      ji(false);
      this.xvq.clear();
      this.xvj.arg.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b NF(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new ai());
      AppMethodBeat.o(74593);
      return localb;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(74590);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495814, paramViewGroup, false);
      paramViewGroup = new UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, paramViewGroup);
      AppMethodBeat.o(74590);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(74591);
      if ((paramw instanceof UnfamiliarContactDetailUI.c))
      {
        paramw = (UnfamiliarContactDetailUI.c)paramw;
        paramw.xvD.setTag(Integer.valueOf(paramInt));
        paramw.asD.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramw.fAk.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramw.nMU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).fBV, paramw.nMU.getTextSize()));
        ImageView localImageView = paramw.xvC;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.aaK())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramw.xvB;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((o.xMd != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = o.xMd.wU(5L);
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
          paramw.xvA.setVisibility(0);
          paramw.xvA.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramw.xvE.setPadding(paramw.xvE.getPaddingLeft(), paramw.xvE.getPaddingTop(), 0, paramw.xvE.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramw.ijt.setChecked(true);
        }
        for (;;)
        {
          paramw.xvD.setVisibility(0);
          AppMethodBeat.o(74591);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramw.xvA.setVisibility(8);
          break label263;
          label365:
          paramw.ijt.setChecked(false);
        }
        label376:
        paramw.xvE.setPadding(paramw.xvE.getPaddingLeft(), paramw.xvE.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(2131165489), paramw.xvE.getPaddingBottom());
        paramw.xvD.setVisibility(8);
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
    ai contact;
    String fBV;
    String xvz;
    
    public b(ai paramai)
    {
      this.contact = paramai;
    }
  }
  
  final class c
    extends RecyclerView.w
  {
    View asD;
    MaskLayout fAk;
    CheckBox ijt;
    TextView nMU;
    TextView xvA;
    ImageView xvB;
    ImageView xvC;
    LinearLayout xvD;
    LinearLayout xvE;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.asD = paramView;
      this.fAk = ((MaskLayout)paramView.findViewById(2131298584));
      this.nMU = ((TextView)paramView.findViewById(2131298678));
      this.xvA = ((TextView)paramView.findViewById(2131298583));
      this.xvB = ((ImageView)paramView.findViewById(2131298713));
      this.xvC = ((ImageView)paramView.findViewById(2131298714));
      this.xvD = ((LinearLayout)paramView.findViewById(2131298256));
      this.ijt = ((CheckBox)paramView.findViewById(2131298255));
      this.xvE = ((LinearLayout)paramView.findViewById(2131301145));
      this.xvD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.c.this.ijt;
          boolean bool;
          if (!UnfamiliarContactDetailUI.c.this.ijt.isChecked())
          {
            bool = true;
            paramAnonymousView.setChecked(bool);
            if (!UnfamiliarContactDetailUI.c.this.ijt.isChecked()) {
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
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).NF(i);
          ac.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.fBV });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  final class d
    extends com.tencent.e.i.b
    implements com.tencent.mm.ak.g
  {
    int index;
    int uHd;
    UnfamiliarContactDetailUI.g xvH;
    Collection<Integer> xvI;
    int xvJ;
    LinkedList<String> xvK;
    LinkedList<j.b> xvL;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.uHd = 0;
      this.xvJ = 0;
      this.index = 0;
      this.xvK = new LinkedList();
      this.xvL = new LinkedList();
      this.xvI = paramg;
      Object localObject;
      this.xvH = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.xvH != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.xvH.dCI();
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
        if ((((com.tencent.mm.ba.b)paramn).hOV == null) || ((b.c)((com.tencent.mm.ba.b)paramn).hOV.getRespObj() == null))
        {
          ac.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((b.c)((com.tencent.mm.ba.b)paramn).hOV.getRespObj()).hPa;
        if ((((cbv)localObject).Ret != 0) || (((cbv)localObject).FpR == null) || (((cbv)localObject).FpR.EKK == null))
        {
          ac.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((cbv)localObject).Ret) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.ba.b)paramn).hOW;
        paramn = ((cbv)localObject).FpR.EKK;
        ac.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramn.size()) });
        paramInt1 = 0;
        if (paramInt1 < paramString.size())
        {
          localObject = (j.b)paramString.get(paramInt1);
          if (((j.b)localObject).getCmdId() != 4) {
            ac.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((j.b)localObject).getCmdId()), localObject.toString() });
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            this.uHd -= 1;
            localObject = (aav)((j.b)localObject).uHj;
            if (((Integer)paramn.get(paramInt1)).intValue() == 0)
            {
              this.xvJ += 1;
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(z.a(((aav)localObject).EuE));
              if (localObject != null)
              {
                ((ai)localObject).aag();
                bi.a(((av)localObject).field_username, null);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(((av)localObject).field_username, (ai)localObject);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNG(((av)localObject).field_username);
                this.xvK.add(((av)localObject).field_username);
              }
            }
            else
            {
              ac.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramn.get(paramInt1), z.a(((aav)localObject).EuE) });
            }
          }
        }
        if (this.uHd <= 0)
        {
          paramString = this.xvK.iterator();
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
              if (UnfamiliarContactDetailUI.d.this.xvH != null)
              {
                UnfamiliarContactDetailUI.d.this.xvH.he(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.xvJ);
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
      this.uHd = this.xvI.size();
      Iterator localIterator = this.xvI.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.xvI.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          ai localai = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).NF(i).contact;
          if (ai.aNc(localai.field_username))
          {
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Fj(localai.field_username);
          }
          else
          {
            aav localaav = new aav();
            localaav.EuE = new crm().aJV(bs.nullAsNil(localai.field_username));
            this.xvL.add(new j.a(4, localaav));
            if ((this.xvL.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.ba.b(this.xvL), 0);
              this.xvL.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  static final class f
  {
    static int xvQ;
    static int xvR;
    static int xvS;
    static int xvT;
    static int xvU;
    static int xvV;
  }
  
  static abstract interface g
  {
    public abstract void dCI();
    
    public abstract void dCJ();
    
    public abstract void he(int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract void a(UnfamiliarContactDetailUI.e parame);
    
    public abstract void f(HashSet paramHashSet);
    
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */