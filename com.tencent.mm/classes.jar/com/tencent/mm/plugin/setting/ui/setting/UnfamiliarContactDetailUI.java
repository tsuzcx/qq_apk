package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.setting.model.o.1;
import com.tencent.mm.plugin.setting.model.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;>;

public class UnfamiliarContactDetailUI
  extends MMActivity
  implements i
{
  public static final String gAH;
  private boolean CXV;
  private boolean CXW;
  private boolean CXX;
  private RecyclerView DeP;
  private TextView DeQ;
  private View DeR;
  private View DeS;
  private View DeT;
  private View DeU;
  private TextView DeV;
  private a DeW;
  private RealAlphabetScrollBar DeX;
  HashMap<String, Integer> DeY;
  private HashMap<Integer, String> DeZ;
  private HashSet<Integer> Dfa;
  private UnfamiliarContactDetailUI.d Dfb;
  private int Dfc;
  private HashSet<String> Dfd;
  private com.tencent.mm.plugin.setting.model.o Dfe;
  private boolean Dff;
  private com.tencent.mm.ui.base.q gxX;
  private ArrayList<b> jBE;
  
  static
  {
    AppMethodBeat.i(74619);
    gAH = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.DeY = new HashMap();
    this.DeZ = new HashMap();
    this.jBE = new ArrayList();
    this.Dfa = new HashSet();
    this.Dfc = -1;
    this.Dfd = new HashSet();
    this.gxX = null;
    AppMethodBeat.o(74605);
  }
  
  private void gJ(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.DeY.clear();
    this.DeZ.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (gAH.equalsIgnoreCase(((b)localObject).Dfm)) {
        ((b)localObject).Dfm = "#";
      }
      localObject = ((b)localObject).Dfm;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.DeY.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.DeZ.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    Log.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131766903), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.gxX != null) && (this.gxX.isShowing()))
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(74613);
  }
  
  public int getLayoutId()
  {
    return 2131496278;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(74609);
    super.initView();
    setMMTitle(2131765667);
    addTextOptionMenu(1, getString(2131766906), new MenuItem.OnMenuItemClickListener()
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
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(2131766900));
        }
        for (;;)
        {
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
          }
          AppMethodBeat.o(74568);
          return true;
          bool = false;
          break;
          label136:
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(2131766906));
        }
      }
    });
    setBackBtn(new UnfamiliarContactDetailUI.5(this));
    View localView = findViewById(2131307702);
    if (this.CXV)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131307704);
      if (!this.CXX) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131307703);
      if (!this.CXW) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.DeP = ((RecyclerView)findViewById(2131309573));
      this.DeR = findViewById(2131297662);
      this.DeQ = ((TextView)findViewById(2131304595));
      this.Dfb = new UnfamiliarContactDetailUI.d(this, this.Dfa, new UnfamiliarContactDetailUI.g()
      {
        public final void eTJ()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131766904) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void eTK()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void il(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.DfD += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131766904) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            Log.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(2131766901, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.DeS = findViewById(2131309570);
      this.DeS.setOnClickListener(new UnfamiliarContactDetailUI.7(this));
      this.DeT = findViewById(2131309571);
      this.DeT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2m.a(0, UnfamiliarContactDetailUI.this.getString(2131763599), UnfamiliarContactDetailUI.this.getString(2131765285), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689967), false);
              paramAnonymous2m.a(1, UnfamiliarContactDetailUI.this.getString(2131763600), UnfamiliarContactDetailUI.this.getString(2131765285), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689968), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              g.aAi();
              g.aAg().hqi.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.dGm();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74580);
        }
      });
      this.DeU = findViewById(2131309572);
      this.DeU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = (CheckBox)UnfamiliarContactDetailUI.i(UnfamiliarContactDetailUI.this).findViewById(2131298639);
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
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
                AppMethodBeat.o(74581);
              }
            });
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74582);
            return;
            UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
            UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          }
        }
      });
      this.DeV = ((TextView)findViewById(2131309163));
      this.DeP.setLayoutManager(new LinearLayoutManager());
      this.DeW = new a();
      this.DeP.setAdapter(this.DeW);
      this.DeX = ((RealAlphabetScrollBar)findViewById(2131309574));
      this.DeX.setOnScrollBarTouchListener(new UnfamiliarContactDetailUI.10(this));
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
    g.azz().a(291, this);
    this.CXV = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.CXW = getIntent().getBooleanExtra("half_year_not_response", false);
    this.CXX = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new UnfamiliarContactDetailUI.h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        Log.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(2131309156).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131306284).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.DfB)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131762446));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.DfA) {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131766911));
        }
        AppMethodBeat.o(74587);
      }
      
      public final void e(HashSet paramAnonymousHashSet)
      {
        AppMethodBeat.i(74588);
        if (paramAnonymousHashSet == null) {}
        for (int i = 0;; i = paramAnonymousHashSet.size())
        {
          Log.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
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
        Log.e("MicroMsg.UnfamiliarContactUI", "[onError]");
        UnfamiliarContactDetailUI.this.findViewById(2131309156).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(2131306284).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131766910));
        AppMethodBeat.o(74586);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(74585);
        Log.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
        UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131766904) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
        if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() == 0)
        {
          UnfamiliarContactDetailUI.this.findViewById(2131309156).setVisibility(0);
          UnfamiliarContactDetailUI.this.findViewById(2131306284).setVisibility(8);
          UnfamiliarContactDetailUI.this.findViewById(2131303234).setVisibility(8);
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131762442));
          AppMethodBeat.o(74585);
          return;
        }
        UnfamiliarContactDetailUI.this.findViewById(2131309156).setVisibility(8);
        UnfamiliarContactDetailUI.this.findViewById(2131303234).setVisibility(0);
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).atj.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.Dfe = new com.tencent.mm.plugin.setting.model.o(this.CXV, this.CXW, this.CXX, paramBundle);
    paramBundle = this.Dfe;
    paramBundle.CYf = System.currentTimeMillis();
    paramBundle.CYe.a(UnfamiliarContactDetailUI.e.DfB);
    paramBundle.qmq.postToWorker(new o.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.CXV)
    {
      i = 1;
      if (!this.CXX) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.CXW) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.h.CyF.a(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.DfE), Integer.valueOf(f.DfD), Integer.valueOf(f.DfI), Integer.valueOf(f.DfF), Integer.valueOf(f.DfH), Integer.valueOf(f.DfG) });
      Log.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.DfE), Integer.valueOf(f.DfD), Integer.valueOf(f.DfI), Integer.valueOf(f.DfF), Integer.valueOf(f.DfH), Integer.valueOf(f.DfG) });
      f.DfD = 0;
      f.DfE = 0;
      f.DfF = 0;
      f.DfG = 0;
      f.DfH = 0;
      f.DfI = 0;
      g.azz().b(291, this);
      g.azz().b(681, this.Dfb);
      com.tencent.mm.plugin.setting.model.o localo = this.Dfe;
      Log.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localo.CXW), Boolean.valueOf(localo.CXV), Boolean.valueOf(localo.CXX) });
      if (localo.CYd != null)
      {
        o.a locala = localo.CYd;
        g.azz().b(292, locala);
      }
      if (localo.CYg != null) {
        localo.CYg.cancel();
      }
      localo.qmq.quit();
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
    if (-1 != this.Dfc)
    {
      if (-1 != this.Dfc) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.DfE += 1;
      }
      this.Dfc = -1;
      this.Dfd.clear();
      if (this.DeW != null) {
        this.DeW.atj.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.jBE.get(this.Dfc);
      as localas1 = localb.contact;
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localas1.field_username);
      if ((!c.oR(localas2.field_type)) && (c.oR(localas1.field_type)))
      {
        this.jBE.remove(this.Dfc);
        i = 1;
      }
      else
      {
        localb.contact = localas2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(74611);
    Log.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(2131766908), 1).show();
    }
    if (paramq.getType() == 291)
    {
      ku(false);
      this.Dfd.clear();
      this.DeW.atj.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b Xs(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new as());
      AppMethodBeat.o(74593);
      return localb;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(74590);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496772, paramViewGroup, false);
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
        paramv.Dfq.setTag(Integer.valueOf(paramInt));
        paramv.aus.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramv.gAN.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramv.pIN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).gCv, paramv.pIN.getTextSize()));
        ImageView localImageView = paramv.Dfp;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.arB())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramv.Dfo;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((com.tencent.mm.plugin.sns.b.o.DCP != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = com.tencent.mm.plugin.sns.b.o.DCP.IZ(5L);
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
          paramv.Dfn.setVisibility(0);
          paramv.Dfn.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramv.Dfr.setPadding(paramv.Dfr.getPaddingLeft(), paramv.Dfr.getPaddingTop(), 0, paramv.Dfr.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramv.checkBox.setChecked(true);
        }
        for (;;)
        {
          paramv.Dfq.setVisibility(0);
          AppMethodBeat.o(74591);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramv.Dfn.setVisibility(8);
          break label263;
          label365:
          paramv.checkBox.setChecked(false);
        }
        label376:
        paramv.Dfr.setPadding(paramv.Dfr.getPaddingLeft(), paramv.Dfr.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(2131165507), paramv.Dfr.getPaddingBottom());
        paramv.Dfq.setVisibility(8);
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
    String Dfm;
    as contact;
    String gCv;
    
    public b(as paramas)
    {
      this.contact = paramas;
    }
  }
  
  final class c
    extends RecyclerView.v
  {
    TextView Dfn;
    ImageView Dfo;
    ImageView Dfp;
    LinearLayout Dfq;
    LinearLayout Dfr;
    View aus;
    CheckBox checkBox;
    MaskLayout gAN;
    TextView pIN;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.aus = paramView;
      this.gAN = ((MaskLayout)paramView.findViewById(2131299021));
      this.pIN = ((TextView)paramView.findViewById(2131299116));
      this.Dfn = ((TextView)paramView.findViewById(2131299020));
      this.Dfo = ((ImageView)paramView.findViewById(2131299151));
      this.Dfp = ((ImageView)paramView.findViewById(2131299152));
      this.Dfq = ((LinearLayout)paramView.findViewById(2131298640));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298639));
      this.Dfr = ((LinearLayout)paramView.findViewById(2131302799));
      this.Dfq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.c.this.checkBox;
          boolean bool;
          if (!UnfamiliarContactDetailUI.c.this.checkBox.isChecked())
          {
            bool = true;
            paramAnonymousView.setChecked(bool);
            if (!UnfamiliarContactDetailUI.c.this.checkBox.isChecked()) {
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
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).Xs(i);
          Log.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.gCv });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  static final class f
  {
    static int DfD;
    static int DfE;
    static int DfF;
    static int DfG;
    static int DfH;
    static int DfI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */