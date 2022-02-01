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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.model.m.1;
import com.tencent.mm.plugin.setting.model.m.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  public static final String fTu;
  private p fQJ;
  private ArrayList<b> iCH;
  private boolean yCY;
  private boolean yCZ;
  private boolean yDa;
  private RecyclerView yJN;
  private TextView yJO;
  private View yJP;
  private View yJQ;
  private View yJR;
  private View yJS;
  private TextView yJT;
  private a yJU;
  private RealAlphabetScrollBar yJV;
  HashMap<String, Integer> yJW;
  private HashMap<Integer, String> yJX;
  private HashSet<Integer> yJY;
  private d yJZ;
  private int yKa;
  private HashSet<String> yKb;
  private m yKc;
  private boolean yKd;
  
  static
  {
    AppMethodBeat.i(74619);
    fTu = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.yJW = new HashMap();
    this.yJX = new HashMap();
    this.iCH = new ArrayList();
    this.yJY = new HashSet();
    this.yKa = -1;
    this.yKb = new HashSet();
    this.fQJ = null;
    AppMethodBeat.o(74605);
  }
  
  private void fD(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.yJW.clear();
    this.yJX.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (fTu.equalsIgnoreCase(((b)localObject).yKk)) {
        ((b)localObject).yKk = "#";
      }
      localObject = ((b)localObject).yKk;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.yJW.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.yJX.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    ad.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.fQJ = p.a(this, getString(2131764557), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing()))
    {
      this.fQJ.dismiss();
      this.fQJ = null;
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
    if (this.yCY)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131304651);
      if (!this.yDa) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131304650);
      if (!this.yCZ) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.yJN = ((RecyclerView)findViewById(2131306185));
      this.yJP = findViewById(2131297432);
      this.yJO = ((TextView)findViewById(2131302229));
      this.yJZ = new d(this.yJY, new g()
      {
        public final void dOl()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void dOm()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void hv(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.yKB += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131764558) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            ad.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(2131764555, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.yJQ = findViewById(2131306182);
      this.yJQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(2131764563), UnfamiliarContactDetailUI.this.getContext().getString(2131757641), UnfamiliarContactDetailUI.this.getContext().getString(2131755707), UnfamiliarContactDetailUI.this.getContext().getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74576);
              if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this) != null)
              {
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajB().gAO.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.vKg = 0;
                paramAnonymous2DialogInterface.yKu = 0;
                paramAnonymous2DialogInterface.yKv.clear();
                paramAnonymous2DialogInterface.yKw.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.yKs != null) {
                  paramAnonymous2DialogInterface.yKs.dOm();
                }
                com.tencent.e.h.LTJ.aR(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, 2131099904, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74577);
        }
      });
      this.yJR = findViewById(2131306183);
      this.yJR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2l.a(0, UnfamiliarContactDetailUI.this.getString(2131761631), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689946), false);
              paramAnonymous2l.a(1, UnfamiliarContactDetailUI.this.getString(2131761632), UnfamiliarContactDetailUI.this.getString(2131763119), UnfamiliarContactDetailUI.this.getResources().getDrawable(2131689947), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.cMW();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74580);
        }
      });
      this.yJS = findViewById(2131306184);
      this.yJS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      this.yJT = ((TextView)findViewById(2131305880));
      this.yJN.setLayoutManager(new LinearLayoutManager());
      this.yJU = new a();
      this.yJN.setAdapter(this.yJU);
      this.yJV = ((RealAlphabetScrollBar)findViewById(2131306186));
      this.yJV.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void vc(String paramAnonymousString)
        {
          AppMethodBeat.i(74583);
          Object localObject = UnfamiliarContactDetailUI.this;
          if ((((UnfamiliarContactDetailUI)localObject).yJW != null) && (((UnfamiliarContactDetailUI)localObject).yJW.containsKey(paramAnonymousString))) {}
          for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).yJW.get(paramAnonymousString)).intValue();; i = -1)
          {
            ad.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramAnonymousString, Integer.valueOf(i) });
            if (i != -1)
            {
              paramAnonymousString = UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this);
              localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
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
    com.tencent.mm.kernel.g.aiU().a(291, this);
    this.yCY = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.yCZ = getIntent().getBooleanExtra("half_year_not_response", false);
    this.yDa = getIntent().getBooleanExtra("has_not_same_chatroom", false);
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
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.yKz)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(2131760709));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.yKy) {
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
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).asY.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.yKc = new m(this.yCY, this.yCZ, this.yDa, paramBundle);
    paramBundle = this.yKc;
    paramBundle.yDi = System.currentTimeMillis();
    paramBundle.yDh.a(UnfamiliarContactDetailUI.e.yKz);
    paramBundle.oQR.postToWorker(new m.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.yCY)
    {
      i = 1;
      if (!this.yDa) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.yCZ) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.g.yhR.f(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.yKC), Integer.valueOf(f.yKB), Integer.valueOf(f.yKG), Integer.valueOf(f.yKD), Integer.valueOf(f.yKF), Integer.valueOf(f.yKE) });
      ad.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.yKC), Integer.valueOf(f.yKB), Integer.valueOf(f.yKG), Integer.valueOf(f.yKD), Integer.valueOf(f.yKF), Integer.valueOf(f.yKE) });
      f.yKB = 0;
      f.yKC = 0;
      f.yKD = 0;
      f.yKE = 0;
      f.yKF = 0;
      f.yKG = 0;
      com.tencent.mm.kernel.g.aiU().b(291, this);
      com.tencent.mm.kernel.g.aiU().b(681, this.yJZ);
      m localm = this.yKc;
      ad.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localm.yCZ), Boolean.valueOf(localm.yCY), Boolean.valueOf(localm.yDa) });
      if (localm.yDg != null)
      {
        m.a locala = localm.yDg;
        com.tencent.mm.kernel.g.aiU().b(292, locala);
      }
      if (localm.yDj != null) {
        localm.yDj.cancel();
      }
      localm.oQR.quit();
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
    if (-1 != this.yKa)
    {
      if (-1 != this.yKa) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.yKC += 1;
      }
      this.yKa = -1;
      this.yKb.clear();
      if (this.yJU != null) {
        this.yJU.asY.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.iCH.get(this.yKa);
      am localam1 = localb.contact;
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(localam1.field_username);
      if ((!com.tencent.mm.o.b.lM(localam2.field_type)) && (com.tencent.mm.o.b.lM(localam1.field_type)))
      {
        this.iCH.remove(this.yKa);
        i = 1;
      }
      else
      {
        localb.contact = localam2;
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
      jt(false);
      this.yKb.clear();
      this.yJU.asY.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b Pi(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new am());
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
        paramw.yKo.setTag(Integer.valueOf(paramInt));
        paramw.auu.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramw.fTA.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramw.opA.setText(k.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).fVj, paramw.opA.getTextSize()));
        ImageView localImageView = paramw.yKn;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.adn())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramw.yKm;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((o.zbV != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = o.zbV.zu(5L);
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
          paramw.yKl.setVisibility(0);
          paramw.yKl.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramw.yKp.setPadding(paramw.yKp.getPaddingLeft(), paramw.yKp.getPaddingTop(), 0, paramw.yKp.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramw.iCK.setChecked(true);
        }
        for (;;)
        {
          paramw.yKo.setVisibility(0);
          AppMethodBeat.o(74591);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramw.yKl.setVisibility(8);
          break label263;
          label365:
          paramw.iCK.setChecked(false);
        }
        label376:
        paramw.yKp.setPadding(paramw.yKp.getPaddingLeft(), paramw.yKp.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(2131165489), paramw.yKp.getPaddingBottom());
        paramw.yKo.setVisibility(8);
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
    am contact;
    String fVj;
    String yKk;
    
    public b(am paramam)
    {
      this.contact = paramam;
    }
  }
  
  final class c
    extends RecyclerView.w
  {
    View auu;
    MaskLayout fTA;
    CheckBox iCK;
    TextView opA;
    TextView yKl;
    ImageView yKm;
    ImageView yKn;
    LinearLayout yKo;
    LinearLayout yKp;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.auu = paramView;
      this.fTA = ((MaskLayout)paramView.findViewById(2131298584));
      this.opA = ((TextView)paramView.findViewById(2131298678));
      this.yKl = ((TextView)paramView.findViewById(2131298583));
      this.yKm = ((ImageView)paramView.findViewById(2131298713));
      this.yKn = ((ImageView)paramView.findViewById(2131298714));
      this.yKo = ((LinearLayout)paramView.findViewById(2131298256));
      this.iCK = ((CheckBox)paramView.findViewById(2131298255));
      this.yKp = ((LinearLayout)paramView.findViewById(2131301145));
      this.yKo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.c.this.iCK;
          boolean bool;
          if (!UnfamiliarContactDetailUI.c.this.iCK.isChecked())
          {
            bool = true;
            paramAnonymousView.setChecked(bool);
            if (!UnfamiliarContactDetailUI.c.this.iCK.isChecked()) {
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).Pi(i);
          ad.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.fVj });
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
    int vKg;
    UnfamiliarContactDetailUI.g yKs;
    Collection<Integer> yKt;
    int yKu;
    LinkedList<String> yKv;
    LinkedList<k.b> yKw;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.vKg = 0;
      this.yKu = 0;
      this.index = 0;
      this.yKv = new LinkedList();
      this.yKw = new LinkedList();
      this.yKt = paramg;
      Object localObject;
      this.yKs = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.yKs != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.yKs.dOl();
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
        if ((((com.tencent.mm.bb.b)paramn).iij == null) || ((b.c)((com.tencent.mm.bb.b)paramn).iij.getRespObj() == null))
        {
          ad.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((b.c)((com.tencent.mm.bb.b)paramn).iij.getRespObj()).iio;
        if ((((cgm)localObject).Ret != 0) || (((cgm)localObject).GZB == null) || (((cgm)localObject).GZB.GtN == null))
        {
          ad.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((cgm)localObject).Ret) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.bb.b)paramn).iik;
        paramn = ((cgm)localObject).GZB.GtN;
        ad.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramn.size()) });
        paramInt1 = 0;
        if (paramInt1 < paramString.size())
        {
          localObject = (k.b)paramString.get(paramInt1);
          if (((k.b)localObject).getCmdId() != 4) {
            ad.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((k.b)localObject).getCmdId()), localObject.toString() });
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            this.vKg -= 1;
            localObject = (acv)((k.b)localObject).vKm;
            if (((Integer)paramn.get(paramInt1)).intValue() == 0)
            {
              this.yKu += 1;
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(z.a(((acv)localObject).GbY));
              if (localObject != null)
              {
                ((am)localObject).acI();
                bj.a(((aw)localObject).field_username, null);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(((aw)localObject).field_username, (am)localObject);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTx(((aw)localObject).field_username);
                this.yKv.add(((aw)localObject).field_username);
              }
            }
            else
            {
              ad.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramn.get(paramInt1), z.a(((acv)localObject).GbY) });
            }
          }
        }
        if (this.vKg <= 0)
        {
          paramString = this.yKv.iterator();
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
              if (UnfamiliarContactDetailUI.d.this.yKs != null)
              {
                UnfamiliarContactDetailUI.d.this.yKs.hv(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.yKu);
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
      this.vKg = this.yKt.size();
      Iterator localIterator = this.yKt.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.yKt.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          am localam = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).Pi(i).contact;
          if (am.aSQ(localam.field_username))
          {
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Iz(localam.field_username);
          }
          else
          {
            acv localacv = new acv();
            localacv.GbY = new cwt().aPy(bt.nullAsNil(localam.field_username));
            this.yKw.add(new k.a(4, localacv));
            if ((this.yKw.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.bb.b(this.yKw), 0);
              this.yKw.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  static final class f
  {
    static int yKB;
    static int yKC;
    static int yKD;
    static int yKE;
    static int yKF;
    static int yKG;
  }
  
  static abstract interface g
  {
    public abstract void dOl();
    
    public abstract void dOm();
    
    public abstract void hv(int paramInt1, int paramInt2);
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