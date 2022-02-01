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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.setting.model.n.1;
import com.tencent.mm.plugin.setting.model.n.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  implements f
{
  public static final String fVA;
  private p fSP;
  private ArrayList<b> iFA;
  private boolean yTd;
  private boolean yTe;
  private boolean yTf;
  private RecyclerView yZX;
  private TextView yZY;
  private View yZZ;
  private View zaa;
  private View zab;
  private View zac;
  private TextView zad;
  private a zae;
  private RealAlphabetScrollBar zaf;
  HashMap<String, Integer> zag;
  private HashMap<Integer, String> zah;
  private HashSet<Integer> zai;
  private d zaj;
  private int zak;
  private HashSet<String> zal;
  private com.tencent.mm.plugin.setting.model.n zam;
  private boolean zan;
  
  static
  {
    AppMethodBeat.i(74619);
    fVA = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.zag = new HashMap();
    this.zah = new HashMap();
    this.iFA = new ArrayList();
    this.zai = new HashSet();
    this.zak = -1;
    this.zal = new HashSet();
    this.fSP = null;
    AppMethodBeat.o(74605);
  }
  
  private void fL(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.zag.clear();
    this.zah.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (fVA.equalsIgnoreCase(((b)localObject).zau)) {
        ((b)localObject).zau = "#";
      }
      localObject = ((b)localObject).zau;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.zag.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.zah.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void js(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    ae.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.fSP = p.a(this, getString(2131764557), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.fSP != null) && (this.fSP.isShowing()))
    {
      this.fSP.dismiss();
      this.fSP = null;
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
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
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
    if (this.yTd)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131304651);
      if (!this.yTf) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131304650);
      if (!this.yTe) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.yZX = ((RecyclerView)findViewById(2131306185));
      this.yZZ = findViewById(2131297432);
      this.yZY = ((TextView)findViewById(2131302229));
      this.zaj = new d(this.zai, new g()
      {
        public final void dRI()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void dRJ()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void hx(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.zaL += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            ae.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(2131764555, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.zaa = findViewById(2131306182);
      this.zaa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(2131764563), UnfamiliarContactDetailUI.this.getContext().getString(2131757641), UnfamiliarContactDetailUI.this.getContext().getString(2131755707), UnfamiliarContactDetailUI.this.getContext().getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74576);
              if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this) != null)
              {
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajQ().gDv.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.vWk = 0;
                paramAnonymous2DialogInterface.zaE = 0;
                paramAnonymous2DialogInterface.zaF.clear();
                paramAnonymous2DialogInterface.zaG.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.zaC != null) {
                  paramAnonymous2DialogInterface.zaC.dRJ();
                }
                com.tencent.e.h.MqF.aO(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, 2131099904, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74577);
        }
      });
      this.zab = findViewById(2131306183);
      this.zab.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2l.a(0, UnfamiliarContactDetailUI.this.getString(2131761631), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689946), false);
              paramAnonymous2l.a(1, UnfamiliarContactDetailUI.this.getString(2131761632), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689947), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.cPF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74580);
        }
      });
      this.zac = findViewById(2131306184);
      this.zac.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
                AppMethodBeat.o(74581);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74582);
            return;
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          }
        }
      });
      this.zad = ((TextView)findViewById(2131305880));
      this.yZX.setLayoutManager(new LinearLayoutManager());
      this.zae = new a();
      this.yZX.setAdapter(this.zae);
      this.zaf = ((RealAlphabetScrollBar)findViewById(2131306186));
      this.zaf.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void vy(String paramAnonymousString)
        {
          AppMethodBeat.i(74583);
          Object localObject = UnfamiliarContactDetailUI.this;
          if ((((UnfamiliarContactDetailUI)localObject).zag != null) && (((UnfamiliarContactDetailUI)localObject).zag.containsKey(paramAnonymousString))) {}
          for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).zag.get(paramAnonymousString)).intValue();; i = -1)
          {
            ae.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramAnonymousString, Integer.valueOf(i) });
            if (i != -1)
            {
              paramAnonymousString = UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this);
              localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
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
    com.tencent.mm.kernel.g.ajj().a(291, this);
    this.yTd = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.yTe = getIntent().getBooleanExtra("half_year_not_response", false);
    this.yTf = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        ae.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.zaJ)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131760709));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.zaI) {
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
          ae.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
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
        ae.e("MicroMsg.UnfamiliarContactUI", "[onError]");
        UnfamiliarContactDetailUI.this.findViewById(2131305874).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131303518).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764564));
        AppMethodBeat.o(74586);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(74585);
        ae.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
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
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.zam = new com.tencent.mm.plugin.setting.model.n(this.yTd, this.yTe, this.yTf, paramBundle);
    paramBundle = this.zam;
    paramBundle.yTn = System.currentTimeMillis();
    paramBundle.yTm.a(UnfamiliarContactDetailUI.e.zaJ);
    paramBundle.oXt.postToWorker(new n.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.yTd)
    {
      i = 1;
      if (!this.yTf) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.yTe) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.g.yxI.f(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.zaM), Integer.valueOf(f.zaL), Integer.valueOf(f.zaQ), Integer.valueOf(f.zaN), Integer.valueOf(f.zaP), Integer.valueOf(f.zaO) });
      ae.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.zaM), Integer.valueOf(f.zaL), Integer.valueOf(f.zaQ), Integer.valueOf(f.zaN), Integer.valueOf(f.zaP), Integer.valueOf(f.zaO) });
      f.zaL = 0;
      f.zaM = 0;
      f.zaN = 0;
      f.zaO = 0;
      f.zaP = 0;
      f.zaQ = 0;
      com.tencent.mm.kernel.g.ajj().b(291, this);
      com.tencent.mm.kernel.g.ajj().b(681, this.zaj);
      com.tencent.mm.plugin.setting.model.n localn = this.zam;
      ae.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localn.yTe), Boolean.valueOf(localn.yTd), Boolean.valueOf(localn.yTf) });
      if (localn.yTl != null)
      {
        n.a locala = localn.yTl;
        com.tencent.mm.kernel.g.ajj().b(292, locala);
      }
      if (localn.yTo != null) {
        localn.yTo.cancel();
      }
      localn.oXt.quit();
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
    if (-1 != this.zak)
    {
      if (-1 != this.zak) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.zaM += 1;
      }
      this.zak = -1;
      this.zal.clear();
      if (this.zae != null) {
        this.zae.asY.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.iFA.get(this.zak);
      an localan1 = localb.contact;
      an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localan1.field_username);
      if ((!com.tencent.mm.contact.c.lO(localan2.field_type)) && (com.tencent.mm.contact.c.lO(localan1.field_type)))
      {
        this.iFA.remove(this.zak);
        i = 1;
      }
      else
      {
        localb.contact = localan2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(74611);
    ae.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(2131764562), 1).show();
    }
    if (paramn.getType() == 291)
    {
      js(false);
      this.zal.clear();
      this.zae.asY.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b PP(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new an());
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
        paramw.zay.setTag(Integer.valueOf(paramInt));
        paramw.auu.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramw.fVG.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramw.ovs.setText(k.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).fXp, paramw.ovs.getTextSize()));
        ImageView localImageView = paramw.zax;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.ady())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramw.zaw;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((o.zsy != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = o.zsy.zT(5L);
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
          paramw.zav.setVisibility(0);
          paramw.zav.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramw.zaz.setPadding(paramw.zaz.getPaddingLeft(), paramw.zaz.getPaddingTop(), 0, paramw.zaz.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramw.iFD.setChecked(true);
        }
        for (;;)
        {
          paramw.zay.setVisibility(0);
          AppMethodBeat.o(74591);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramw.zav.setVisibility(8);
          break label263;
          label365:
          paramw.iFD.setChecked(false);
        }
        label376:
        paramw.zaz.setPadding(paramw.zaz.getPaddingLeft(), paramw.zaz.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(2131165489), paramw.zaz.getPaddingBottom());
        paramw.zay.setVisibility(8);
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
    an contact;
    String fXp;
    String zau;
    
    public b(an paraman)
    {
      this.contact = paraman;
    }
  }
  
  final class c
    extends RecyclerView.w
  {
    View auu;
    MaskLayout fVG;
    CheckBox iFD;
    TextView ovs;
    TextView zav;
    ImageView zaw;
    ImageView zax;
    LinearLayout zay;
    LinearLayout zaz;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.auu = paramView;
      this.fVG = ((MaskLayout)paramView.findViewById(2131298584));
      this.ovs = ((TextView)paramView.findViewById(2131298678));
      this.zav = ((TextView)paramView.findViewById(2131298583));
      this.zaw = ((ImageView)paramView.findViewById(2131298713));
      this.zax = ((ImageView)paramView.findViewById(2131298714));
      this.zay = ((LinearLayout)paramView.findViewById(2131298256));
      this.iFD = ((CheckBox)paramView.findViewById(2131298255));
      this.zaz = ((LinearLayout)paramView.findViewById(2131301145));
      this.zay.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.c.this.iFD;
          boolean bool;
          if (!UnfamiliarContactDetailUI.c.this.iFD.isChecked())
          {
            bool = true;
            paramAnonymousView.setChecked(bool);
            if (!UnfamiliarContactDetailUI.c.this.iFD.isChecked()) {
              break label174;
            }
            UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).add(Integer.valueOf(i));
            label107:
            if (UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size() != 0) {
              break label195;
            }
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74594);
            return;
            bool = false;
            break;
            label174:
            UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).remove(Integer.valueOf(i));
            break label107;
            label195:
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(true);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(true);
          }
        }
      });
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74595);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).PP(i);
          ae.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.fXp });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  final class d
    extends com.tencent.e.i.b
    implements f
  {
    int index;
    int vWk;
    UnfamiliarContactDetailUI.g zaC;
    Collection<Integer> zaD;
    int zaE;
    LinkedList<String> zaF;
    LinkedList<k.b> zaG;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.vWk = 0;
      this.zaE = 0;
      this.index = 0;
      this.zaF = new LinkedList();
      this.zaG = new LinkedList();
      this.zaD = paramg;
      Object localObject;
      this.zaC = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.zaC != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.zaC.dRI();
      }
      AppMethodBeat.o(182596);
      return false;
    }
    
    public final String getKey()
    {
      return "delete_contact_task";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(74601);
      if (paramn.getType() == 681)
      {
        if ((((com.tencent.mm.ba.b)paramn).ilc == null) || ((b.c)((com.tencent.mm.ba.b)paramn).ilc.getRespObj() == null))
        {
          ae.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((b.c)((com.tencent.mm.ba.b)paramn).ilc.getRespObj()).ilh;
        if ((((chg)localObject).Ret != 0) || (((chg)localObject).Htc == null) || (((chg)localObject).Htc.GNm == null))
        {
          ae.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((chg)localObject).Ret) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.ba.b)paramn).ild;
        paramn = ((chg)localObject).Htc.GNm;
        ae.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramn.size()) });
        paramInt1 = 0;
        if (paramInt1 < paramString.size())
        {
          localObject = (k.b)paramString.get(paramInt1);
          if (((k.b)localObject).getCmdId() != 4) {
            ae.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((k.b)localObject).getCmdId()), localObject.toString() });
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            this.vWk -= 1;
            localObject = (ade)((k.b)localObject).vWq;
            if (((Integer)paramn.get(paramInt1)).intValue() == 0)
            {
              this.zaE += 1;
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(z.a(((ade)localObject).GuF));
              if (localObject != null)
              {
                ((an)localObject).acT();
                bl.a(((aw)localObject).field_username, null);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(((aw)localObject).field_username, (an)localObject);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aUY(((aw)localObject).field_username);
                this.zaF.add(((aw)localObject).field_username);
              }
            }
            else
            {
              ae.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramn.get(paramInt1), z.a(((ade)localObject).GuF) });
            }
          }
        }
        if (this.vWk <= 0)
        {
          paramString = this.zaF.iterator();
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
              if (UnfamiliarContactDetailUI.d.this.zaC != null)
              {
                UnfamiliarContactDetailUI.d.this.zaC.hx(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.zaE);
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
      this.vWk = this.zaD.size();
      Iterator localIterator = this.zaD.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.zaD.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          an localan = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).PP(i).contact;
          if (an.aUq(localan.field_username))
          {
            ((r)com.tencent.mm.kernel.g.ab(r.class)).wr(localan.field_username);
          }
          else
          {
            ade localade = new ade();
            localade.GuF = new cxn().aQV(bu.nullAsNil(localan.field_username));
            this.zaG.add(new k.a(4, localade));
            if ((this.zaG.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.ba.b(this.zaG), 0);
              this.zaG.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  static final class f
  {
    static int zaL;
    static int zaM;
    static int zaN;
    static int zaO;
    static int zaP;
    static int zaQ;
  }
  
  static abstract interface g
  {
    public abstract void dRI();
    
    public abstract void dRJ();
    
    public abstract void hx(int paramInt1, int paramInt2);
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