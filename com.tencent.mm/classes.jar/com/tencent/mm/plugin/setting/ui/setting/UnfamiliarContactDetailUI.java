package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.bd.b.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.qp;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.o.1;
import com.tencent.mm.plugin.setting.model.o.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
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
  implements com.tencent.mm.an.i
{
  public static final String jkN;
  private boolean JdB;
  private boolean JdC;
  private boolean JdD;
  private View JkA;
  private TextView JkB;
  private a JkC;
  private RealAlphabetScrollBar JkD;
  HashMap<String, Integer> JkE;
  private HashMap<Integer, String> JkF;
  private HashSet<Integer> JkG;
  private d JkH;
  private int JkI;
  private HashSet<String> JkJ;
  private com.tencent.mm.plugin.setting.model.o JkK;
  private boolean JkL;
  private RecyclerView Jkv;
  private TextView Jkw;
  private View Jkx;
  private View Jky;
  private View Jkz;
  private s jhZ;
  private ArrayList<b> mrs;
  
  static
  {
    AppMethodBeat.i(74619);
    jkN = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.JkE = new HashMap();
    this.JkF = new HashMap();
    this.mrs = new ArrayList();
    this.JkG = new HashSet();
    this.JkI = -1;
    this.JkJ = new HashSet();
    this.jhZ = null;
    AppMethodBeat.o(74605);
  }
  
  private void hp(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.JkE.clear();
    this.JkF.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (jkN.equalsIgnoreCase(((b)localObject).JkS)) {
        ((b)localObject).JkS = "#";
      }
      localObject = ((b)localObject).JkS;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.JkE.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.JkF.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    Log.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.jhZ = s.a(this, getString(b.i.unfamiliar_contact_member_handling), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(74613);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_unfamiliar_contact_detail_ui;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(74609);
    super.initView();
    setMMTitle(b.i.settings_unfamiliar_contact);
    addTextOptionMenu(1, getString(b.i.unfamiliar_contact_member_multi_select), new MenuItem.OnMenuItemClickListener()
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
            break label137;
          }
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this).setEnabled(false);
          UnfamiliarContactDetailUI.d(UnfamiliarContactDetailUI.this).setEnabled(false);
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_cancel_contact_member_multi_select));
        }
        for (;;)
        {
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
          }
          AppMethodBeat.o(74568);
          return true;
          bool = false;
          break;
          label137:
          UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_multi_select));
        }
      }
    });
    setBackBtn(new UnfamiliarContactDetailUI.5(this));
    View localView = findViewById(b.f.settings_half_year_not_chat_title);
    if (this.JdB)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(b.f.settings_has_not_same_chatroom_title);
      if (!this.JdD) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(b.f.settings_half_year_not_response_title);
      if (!this.JdC) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.Jkv = ((RecyclerView)findViewById(b.f.unfamiliar_member_list));
      this.Jkx = findViewById(b.f.bottom_bar);
      this.Jkw = ((TextView)findViewById(b.f.member_list_title));
      this.JkH = new d(this.JkG, new g()
      {
        public final void fGM()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void fGN()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void jt(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.Jlj += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            Log.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            com.tencent.mm.ui.base.h.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_delete_err, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.Jky = findViewById(b.f.unfamiliar_contact_member_delete);
      this.Jky.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(b.i.unfamiliar_delete_contact_tip), UnfamiliarContactDetailUI.this.getContext().getString(b.i.contact_info_delete_contact), UnfamiliarContactDetailUI.this.getContext().getString(b.i.app_delete), UnfamiliarContactDetailUI.this.getContext().getString(b.i.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74576);
              if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this) != null)
              {
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHF().kcd.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.EVO = 0;
                paramAnonymous2DialogInterface.Jlc = 0;
                paramAnonymous2DialogInterface.Jld.clear();
                paramAnonymous2DialogInterface.Jle.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.Jla != null) {
                  paramAnonymous2DialogInterface.Jla.fGN();
                }
                com.tencent.e.h.ZvG.be(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, com.tencent.mm.plugin.setting.b.c.alert_btn_color_warn, 0);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74577);
        }
      });
      this.Jkz = findViewById(b.f.unfamiliar_contact_member_more);
      this.Jkz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new e(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2o.a(0, UnfamiliarContactDetailUI.this.getString(b.i.not_receive_her_sns_title), UnfamiliarContactDetailUI.this.getString(b.i.setting_sns_desc), UnfamiliarContactDetailUI.this.getResources().getDrawable(b.h.circle_notreceive), false);
              paramAnonymous2o.a(1, UnfamiliarContactDetailUI.this.getString(b.i.not_visible_my_sns_title), UnfamiliarContactDetailUI.this.getString(b.i.setting_sns_desc), UnfamiliarContactDetailUI.this.getResources().getDrawable(b.h.circle_notvisible), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.eik();
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74580);
        }
      });
      this.JkA = findViewById(b.f.unfamiliar_contact_member_select_all_area);
      this.JkA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = (CheckBox)UnfamiliarContactDetailUI.i(UnfamiliarContactDetailUI.this).findViewById(b.f.checkbox);
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
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
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
      this.JkB = ((TextView)findViewById(b.f.tip_tv));
      this.Jkv.setLayoutManager(new LinearLayoutManager());
      this.JkC = new a();
      this.Jkv.setAdapter(this.JkC);
      this.JkD = ((RealAlphabetScrollBar)findViewById(b.f.unfamiliar_member_scrollbar));
      this.JkD.setOnScrollBarTouchListener(new UnfamiliarContactDetailUI.10(this));
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
    com.tencent.mm.kernel.h.aGY().a(291, this);
    this.JdB = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.JdC = getIntent().getBooleanExtra("half_year_not_response", false);
    this.JdD = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new UnfamiliarContactDetailUI.h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        Log.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(b.f.progress_bar).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.Jlh)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.loading_tips));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.Jlg) {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_loading_about_one_min));
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
        UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(b.f.progress_bar).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_load_err));
        AppMethodBeat.o(74586);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(74585);
        Log.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
        UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
        if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() == 0)
        {
          UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(0);
          UnfamiliarContactDetailUI.this.findViewById(b.f.progress_bar).setVisibility(8);
          UnfamiliarContactDetailUI.this.findViewById(b.f.list_layout).setVisibility(8);
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.loaded_empty));
          AppMethodBeat.o(74585);
          return;
        }
        UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(8);
        UnfamiliarContactDetailUI.this.findViewById(b.f.list_layout).setVisibility(0);
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).alc.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.JkK = new com.tencent.mm.plugin.setting.model.o(this.JdB, this.JdC, this.JdD, paramBundle);
    paramBundle = this.JkK;
    paramBundle.JdL = System.currentTimeMillis();
    paramBundle.JdK.a(UnfamiliarContactDetailUI.e.Jlh);
    paramBundle.tLh.postToWorker(new o.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.JdB)
    {
      i = 1;
      if (!this.JdD) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.JdC) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.h.IzE.a(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.Jlk), Integer.valueOf(f.Jlj), Integer.valueOf(f.Jlo), Integer.valueOf(f.Jll), Integer.valueOf(f.Jln), Integer.valueOf(f.Jlm) });
      Log.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.Jlk), Integer.valueOf(f.Jlj), Integer.valueOf(f.Jlo), Integer.valueOf(f.Jll), Integer.valueOf(f.Jln), Integer.valueOf(f.Jlm) });
      f.Jlj = 0;
      f.Jlk = 0;
      f.Jll = 0;
      f.Jlm = 0;
      f.Jln = 0;
      f.Jlo = 0;
      com.tencent.mm.kernel.h.aGY().b(291, this);
      com.tencent.mm.kernel.h.aGY().b(681, this.JkH);
      com.tencent.mm.plugin.setting.model.o localo = this.JkK;
      Log.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(localo.JdC), Boolean.valueOf(localo.JdB), Boolean.valueOf(localo.JdD) });
      if (localo.JdJ != null)
      {
        o.a locala = localo.JdJ;
        com.tencent.mm.kernel.h.aGY().b(292, locala);
      }
      if (localo.JdM != null) {
        localo.JdM.cancel();
      }
      localo.tLh.quit();
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
    if (-1 != this.JkI)
    {
      if (-1 != this.JkI) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.Jlk += 1;
      }
      this.JkI = -1;
      this.JkJ.clear();
      if (this.JkC != null) {
        this.JkC.alc.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.mrs.get(this.JkI);
      as localas1 = localb.contact;
      as localas2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localas1.field_username);
      if ((!d.rk(localas2.field_type)) && (d.rk(localas1.field_type)))
      {
        this.mrs.remove(this.JkI);
        i = 1;
      }
      else
      {
        localb.contact = localas2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74611);
    Log.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(b.i.unfamiliar_contact_setting_err), 1).show();
    }
    if (paramq.getType() == 291)
    {
      lG(false);
      this.JkJ.clear();
      this.JkC.alc.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b aer(int paramInt)
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
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(264439);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.unfamiliar_contact_item_layout, paramViewGroup, false);
      paramViewGroup = new UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, paramViewGroup);
      AppMethodBeat.o(264439);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(264440);
      if ((paramv instanceof UnfamiliarContactDetailUI.c))
      {
        paramv = (UnfamiliarContactDetailUI.c)paramv;
        paramv.JkW.setTag(Integer.valueOf(paramInt));
        paramv.amk.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.c((ImageView)paramv.jkT.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramv.xoK.setText(l.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).jmB, paramv.xoK.getTextSize()));
        ImageView localImageView = paramv.JkV;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.ayi())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramv.JkU;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((p.JPf != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = p.JPf.Qs(5L);
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
          paramv.JkT.setVisibility(0);
          paramv.JkT.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramv.JkX.setPadding(paramv.JkX.getPaddingLeft(), paramv.JkX.getPaddingTop(), 0, paramv.JkX.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramv.checkBox.setChecked(true);
        }
        for (;;)
        {
          paramv.JkW.setVisibility(0);
          AppMethodBeat.o(264440);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramv.JkT.setVisibility(8);
          break label263;
          label365:
          paramv.checkBox.setChecked(false);
        }
        label376:
        paramv.JkX.setPadding(paramv.JkX.getPaddingLeft(), paramv.JkX.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(b.d.ListPadding), paramv.JkX.getPaddingBottom());
        paramv.JkW.setVisibility(8);
      }
      AppMethodBeat.o(264440);
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
    String JkS;
    as contact;
    String jmB;
    
    public b(as paramas)
    {
      this.contact = paramas;
    }
  }
  
  final class c
    extends RecyclerView.v
  {
    TextView JkT;
    ImageView JkU;
    ImageView JkV;
    LinearLayout JkW;
    LinearLayout JkX;
    View amk;
    CheckBox checkBox;
    MaskLayout jkT;
    TextView xoK;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.amk = paramView;
      this.jkT = ((MaskLayout)paramView.findViewById(b.f.contact_avatar));
      this.xoK = ((TextView)paramView.findViewById(b.f.contact_nick));
      this.JkT = ((TextView)paramView.findViewById(b.f.contact_alphabet));
      this.JkU = ((ImageView)paramView.findViewById(b.f.contact_sns_notreceive_iv));
      this.JkV = ((ImageView)paramView.findViewById(b.f.contact_sns_notvisible_iv));
      this.JkW = ((LinearLayout)paramView.findViewById(b.f.checkbox_area));
      this.checkBox = ((CheckBox)paramView.findViewById(b.f.checkbox));
      this.JkX = ((LinearLayout)paramView.findViewById(b.f.item_content));
      this.JkW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aer(i);
          Log.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.jmB });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  final class d
    extends com.tencent.e.i.b
    implements com.tencent.mm.an.i
  {
    int EVO;
    UnfamiliarContactDetailUI.g Jla;
    Collection<Integer> Jlb;
    int Jlc;
    LinkedList<String> Jld;
    LinkedList<k.b> Jle;
    int index;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.EVO = 0;
      this.Jlc = 0;
      this.index = 0;
      this.Jld = new LinkedList();
      this.Jle = new LinkedList();
      this.Jlb = paramg;
      Object localObject;
      this.Jla = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.Jla != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.Jla.fGM();
      }
      AppMethodBeat.o(182596);
      return false;
    }
    
    public final String getKey()
    {
      return "delete_contact_task";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(74601);
      if (paramq.getType() == 681)
      {
        if ((((com.tencent.mm.bd.b)paramq).lWE == null) || ((com.tencent.mm.bd.b.c)((com.tencent.mm.bd.b)paramq).lWE.getRespObj() == null))
        {
          Log.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((com.tencent.mm.bd.b.c)((com.tencent.mm.bd.b)paramq).lWE.getRespObj()).lWJ;
        if ((((dgx)localObject).CqV != 0) || (((dgx)localObject).TNE == null) || (((dgx)localObject).TNE.SZW == null))
        {
          Log.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((dgx)localObject).CqV) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.bd.b)paramq).lWF;
        paramq = ((dgx)localObject).TNE.SZW;
        Log.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramq.size()) });
        paramInt1 = 0;
        if (paramInt1 < paramString.size())
        {
          localObject = (k.b)paramString.get(paramInt1);
          if (((k.b)localObject).getCmdId() != 4) {
            Log.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((k.b)localObject).getCmdId()), localObject.toString() });
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            this.EVO -= 1;
            localObject = (afq)((k.b)localObject).EVU;
            if (((Integer)paramq.get(paramInt1)).intValue() == 0)
            {
              this.Jlc += 1;
              localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(z.a(((afq)localObject).SrH));
              if (localObject != null)
              {
                ((as)localObject).axl();
                bq.a(((ax)localObject).field_username, null);
                ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(((ax)localObject).field_username, (as)localObject);
                ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv(((ax)localObject).field_username);
                this.Jld.add(((ax)localObject).field_username);
              }
            }
            else
            {
              Log.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramq.get(paramInt1), z.a(((afq)localObject).SrH) });
            }
          }
        }
        if (this.EVO <= 0)
        {
          paramString = this.Jld.iterator();
          while (paramString.hasNext())
          {
            paramq = (String)paramString.next();
            localObject = UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).contact.field_username.equals(paramq)) {
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
              if (UnfamiliarContactDetailUI.d.this.Jla != null)
              {
                UnfamiliarContactDetailUI.d.this.Jla.jt(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.Jlc);
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
      this.EVO = this.Jlb.size();
      Iterator localIterator = this.Jlb.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.Jlb.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          as localas = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aer(i).contact;
          if (as.bvK(localas.field_username))
          {
            ((u)com.tencent.mm.kernel.h.ae(u.class)).Lz(localas.field_username);
          }
          else
          {
            afq localafq = new afq();
            localafq.SrH = new eaf().btQ(Util.nullAsNil(localas.field_username));
            this.Jle.add(new k.a(4, localafq));
            if ((this.Jle.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.bd.b(this.Jle), 0);
              this.Jle.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  static final class f
  {
    static int Jlj;
    static int Jlk;
    static int Jll;
    static int Jlm;
    static int Jln;
    static int Jlo;
  }
  
  static abstract interface g
  {
    public abstract void fGM();
    
    public abstract void fGN();
    
    public abstract void jt(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */