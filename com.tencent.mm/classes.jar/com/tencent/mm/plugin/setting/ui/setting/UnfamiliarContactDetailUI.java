package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.autogen.a.sd;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ay.b.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.s.1;
import com.tencent.mm.plugin.setting.model.s.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.threadpool.i;
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
  implements com.tencent.mm.am.h
{
  public static final String lNr;
  private boolean PnU;
  private boolean PnV;
  private boolean PnW;
  private RecyclerView PwU;
  private TextView PwV;
  private View PwW;
  private View PwX;
  private View PwY;
  private View PwZ;
  private TextView Pxa;
  private a Pxb;
  private RealAlphabetScrollBar Pxc;
  HashMap<String, Integer> Pxd;
  private HashMap<Integer, String> Pxe;
  private HashSet<Integer> Pxf;
  private d Pxg;
  private int Pxh;
  private HashSet<String> Pxi;
  private com.tencent.mm.plugin.setting.model.s Pxj;
  private boolean Pxk;
  private com.tencent.mm.ui.base.w lKp;
  private ArrayList<b> pkR;
  
  static
  {
    AppMethodBeat.i(74619);
    lNr = new String(Character.toChars(123));
    AppMethodBeat.o(74619);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(74605);
    this.Pxd = new HashMap();
    this.Pxe = new HashMap();
    this.pkR = new ArrayList();
    this.Pxf = new HashSet();
    this.Pxh = -1;
    this.Pxi = new HashSet();
    this.lKp = null;
    AppMethodBeat.o(74605);
  }
  
  private void kr(List<b> paramList)
  {
    AppMethodBeat.i(74612);
    this.Pxd.clear();
    this.Pxe.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<b>)localObject)
    {
      localObject = (b)localIterator.next();
      if (lNr.equalsIgnoreCase(((b)localObject).Pxr)) {
        ((b)localObject).Pxr = "#";
      }
      localObject = ((b)localObject).Pxr;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.Pxd.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.Pxe.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(74612);
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(74613);
    Log.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.lKp = com.tencent.mm.ui.base.w.a(this, getString(b.i.unfamiliar_contact_member_handling), true, 0, null);
      AppMethodBeat.o(74613);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
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
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
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
    View localView = findViewById(b.f.settings_half_year_not_chat_title);
    if (this.PnU)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(b.f.settings_has_not_same_chatroom_title);
      if (!this.PnW) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(b.f.settings_half_year_not_response_title);
      if (!this.PnV) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.PwU = ((RecyclerView)findViewById(b.f.unfamiliar_member_list));
      this.PwW = findViewById(b.f.bottom_bar);
      this.PwV = ((TextView)findViewById(b.f.member_list_title));
      this.Pxg = new d(this.Pxf, new g()
      {
        public final void gWx()
        {
          AppMethodBeat.i(182595);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
          }
          AppMethodBeat.o(182595);
        }
        
        public final void gWy()
        {
          AppMethodBeat.i(74575);
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
          AppMethodBeat.o(74575);
        }
        
        public final void lb(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(74574);
          UnfamiliarContactDetailUI.f.PxI += paramAnonymousInt1;
          UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
          UnfamiliarContactDetailUI.g(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() + ")");
          if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
            UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
          }
          if (paramAnonymousInt2 < paramAnonymousInt1)
          {
            Log.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
            k.c(UnfamiliarContactDetailUI.this.getContext(), UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_contact_delete_err, new Object[] { Integer.valueOf(paramAnonymousInt1 - paramAnonymousInt2) }), "", true);
          }
          AppMethodBeat.o(74574);
        }
      });
      this.PwX = findViewById(b.f.unfamiliar_contact_member_delete);
      this.PwX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74577);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.a(UnfamiliarContactDetailUI.this.getContext(), true, UnfamiliarContactDetailUI.this.getContext().getString(b.i.unfamiliar_delete_contact_tip), UnfamiliarContactDetailUI.this.getContext().getString(b.i.contact_info_delete_contact), UnfamiliarContactDetailUI.this.getContext().getString(b.i.app_delete), UnfamiliarContactDetailUI.this.getContext().getString(b.i.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74576);
              if (UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this) != null)
              {
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
                paramAnonymous2DialogInterface = UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this);
                paramAnonymous2DialogInterface.index = 0;
                paramAnonymous2DialogInterface.KRo = 0;
                paramAnonymous2DialogInterface.PxB = 0;
                paramAnonymous2DialogInterface.PxC.clear();
                paramAnonymous2DialogInterface.PxD.clear();
                paramAnonymous2DialogInterface.cancel();
                if (paramAnonymous2DialogInterface.Pxz != null) {
                  paramAnonymous2DialogInterface.Pxz.gWy();
                }
                com.tencent.threadpool.h.ahAA.bm(paramAnonymous2DialogInterface);
              }
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              AppMethodBeat.o(74576);
            }
          }, null, com.tencent.mm.plugin.setting.b.c.alert_btn_color_warn, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74577);
        }
      });
      this.PwY = findViewById(b.f.unfamiliar_contact_member_more);
      this.PwY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new f(UnfamiliarContactDetailUI.this, 1, false);
          paramAnonymousView.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(74578);
              paramAnonymous2s.a(0, UnfamiliarContactDetailUI.this.getString(b.i.not_receive_her_sns_title), UnfamiliarContactDetailUI.this.getString(b.i.setting_sns_desc), UnfamiliarContactDetailUI.this.getResources().getDrawable(b.h.circle_notreceive), false);
              paramAnonymous2s.a(1, UnfamiliarContactDetailUI.this.getString(b.i.not_visible_my_sns_title), UnfamiliarContactDetailUI.this.getString(b.i.setting_sns_desc), UnfamiliarContactDetailUI.this.getResources().getDrawable(b.h.circle_notvisible), false);
              AppMethodBeat.o(74578);
            }
          };
          paramAnonymousView.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74579);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.b(681, UnfamiliarContactDetailUI.h(UnfamiliarContactDetailUI.this));
              UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this), paramAnonymous2Int);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
              if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null) {
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
              }
              AppMethodBeat.o(74579);
            }
          };
          paramAnonymousView.dDn();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74580);
        }
      });
      this.PwZ = findViewById(b.f.unfamiliar_contact_member_select_all_area);
      this.PwZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
                UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
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
      this.Pxa = ((TextView)findViewById(b.f.tip_tv));
      this.PwU.setLayoutManager(new LinearLayoutManager());
      this.Pxb = new a();
      this.PwU.setAdapter(this.Pxb);
      this.Pxc = ((RealAlphabetScrollBar)findViewById(b.f.unfamiliar_member_scrollbar));
      this.Pxc.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void onScollBarTouch(String paramAnonymousString)
        {
          AppMethodBeat.i(74583);
          Object localObject = UnfamiliarContactDetailUI.this;
          if ((((UnfamiliarContactDetailUI)localObject).Pxd != null) && (((UnfamiliarContactDetailUI)localObject).Pxd.containsKey(paramAnonymousString))) {}
          for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).Pxd.get(paramAnonymousString)).intValue();; i = -1)
          {
            Log.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramAnonymousString, Integer.valueOf(i) });
            if (i != -1)
            {
              paramAnonymousString = UnfamiliarContactDetailUI.j(UnfamiliarContactDetailUI.this);
              localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
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
    com.tencent.mm.kernel.h.aZW().a(291, this);
    this.PnU = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.PnV = getIntent().getBooleanExtra("half_year_not_response", false);
    this.PnW = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new h()
    {
      long start;
      
      public final void a(UnfamiliarContactDetailUI.e paramAnonymouse)
      {
        AppMethodBeat.i(74587);
        Log.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { paramAnonymouse.name() });
        UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(b.f.progress_bar).setVisibility(0);
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.PxG)
        {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.loading_tips));
          AppMethodBeat.o(74587);
          return;
        }
        if (paramAnonymouse == UnfamiliarContactDetailUI.e.PxF) {
          UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_loading_about_one_min));
        }
        AppMethodBeat.o(74587);
      }
      
      public final void atR()
      {
        AppMethodBeat.i(74586);
        Log.e("MicroMsg.UnfamiliarContactUI", "[onError]");
        UnfamiliarContactDetailUI.this.findViewById(b.f.tip_layout).setVisibility(0);
        UnfamiliarContactDetailUI.this.findViewById(b.f.progress_bar).setVisibility(8);
        UnfamiliarContactDetailUI.k(UnfamiliarContactDetailUI.this).setText(UnfamiliarContactDetailUI.this.getString(b.i.unfamiliar_load_err));
        AppMethodBeat.o(74586);
      }
      
      public final void g(HashSet paramAnonymousHashSet)
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
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).bZE.notifyChanged();
        }
        AppMethodBeat.o(74585);
      }
    };
    this.Pxj = new com.tencent.mm.plugin.setting.model.s(this.PnU, this.PnV, this.PnW, paramBundle);
    paramBundle = this.Pxj;
    paramBundle.Poe = System.currentTimeMillis();
    paramBundle.Pod.a(UnfamiliarContactDetailUI.e.PxG);
    paramBundle.wOw.postToWorker(new s.1(paramBundle));
    AppMethodBeat.o(74606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74608);
    super.onDestroy();
    int i;
    int j;
    if (this.PnU)
    {
      i = 1;
      if (!this.PnW) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.PnV) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      com.tencent.mm.plugin.report.service.h.OAn.b(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.PxJ), Integer.valueOf(f.PxI), Integer.valueOf(f.PxN), Integer.valueOf(f.PxK), Integer.valueOf(f.PxM), Integer.valueOf(f.PxL) });
      Log.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.PxJ), Integer.valueOf(f.PxI), Integer.valueOf(f.PxN), Integer.valueOf(f.PxK), Integer.valueOf(f.PxM), Integer.valueOf(f.PxL) });
      f.PxI = 0;
      f.PxJ = 0;
      f.PxK = 0;
      f.PxL = 0;
      f.PxM = 0;
      f.PxN = 0;
      com.tencent.mm.kernel.h.aZW().b(291, this);
      com.tencent.mm.kernel.h.aZW().b(681, this.Pxg);
      com.tencent.mm.plugin.setting.model.s locals = this.Pxj;
      Log.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(locals.PnV), Boolean.valueOf(locals.PnU), Boolean.valueOf(locals.PnW) });
      if (locals.Poc != null)
      {
        s.a locala = locals.Poc;
        com.tencent.mm.kernel.h.aZW().b(292, locala);
      }
      if (locals.Pof != null) {
        locals.Pof.cancel();
      }
      locals.wOw.quit();
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
    if (-1 != this.Pxh)
    {
      if (-1 != this.Pxh) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.PxJ += 1;
      }
      this.Pxh = -1;
      this.Pxi.clear();
      if (this.Pxb != null) {
        this.Pxb.bZE.notifyChanged();
      }
      AppMethodBeat.o(74607);
      return;
      label76:
      b localb = (b)this.pkR.get(this.Pxh);
      au localau1 = localb.contact;
      au localau2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localau1.field_username);
      if ((!d.rs(localau2.field_type)) && (d.rs(localau1.field_type)))
      {
        this.pkR.remove(this.Pxh);
        i = 1;
      }
      else
      {
        localb.contact = localau2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(74611);
    Log.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(b.i.unfamiliar_contact_setting_err), 1).show();
    }
    if (paramp.getType() == 291)
    {
      na(false);
      this.Pxi.clear();
      this.Pxb.bZE.notifyChanged();
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
    
    public final UnfamiliarContactDetailUI.b aiY(int paramInt)
    {
      AppMethodBeat.i(74593);
      if (UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).size() > paramInt)
      {
        localb = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        AppMethodBeat.o(74593);
        return localb;
      }
      UnfamiliarContactDetailUI.b localb = new UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, new au());
      AppMethodBeat.o(74593);
      return localb;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(299125);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.unfamiliar_contact_item_layout, paramViewGroup, false);
      paramViewGroup = new UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, paramViewGroup);
      AppMethodBeat.o(299125);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(299136);
      if ((paramv instanceof UnfamiliarContactDetailUI.c))
      {
        paramv = (UnfamiliarContactDetailUI.c)paramv;
        paramv.Pxv.setTag(Integer.valueOf(paramInt));
        paramv.caK.setTag(Integer.valueOf(paramInt));
        Object localObject = (UnfamiliarContactDetailUI.b)UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).get(paramInt);
        a.b.g((ImageView)paramv.lNy.getContentView(), ((UnfamiliarContactDetailUI.b)localObject).contact.field_username);
        paramv.nicknameTv.setText(com.tencent.mm.pluginsdk.ui.span.p.b(UnfamiliarContactDetailUI.this.getContext(), ((UnfamiliarContactDetailUI.b)localObject).displayName, paramv.nicknameTv.getTextSize()));
        ImageView localImageView = paramv.Pxu;
        int i;
        if (((UnfamiliarContactDetailUI.b)localObject).contact.aSL())
        {
          i = 0;
          localImageView.setVisibility(i);
          localImageView = paramv.Pxt;
          localObject = ((UnfamiliarContactDetailUI.b)localObject).contact.field_username;
          if ((q.Qkl != null) && (UnfamiliarContactDetailUI.n(UnfamiliarContactDetailUI.this).size() == 0))
          {
            List localList = q.Qkl.ux(5L);
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
          paramv.Pxs.setVisibility(0);
          paramv.Pxs.setText((CharSequence)UnfamiliarContactDetailUI.m(UnfamiliarContactDetailUI.this).get(Integer.valueOf(paramInt)));
          label263:
          if (!UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this)) {
            break label376;
          }
          paramv.Pxw.setPadding(paramv.Pxw.getPaddingLeft(), paramv.Pxw.getPaddingTop(), 0, paramv.Pxw.getPaddingBottom());
          if (!UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).contains(Integer.valueOf(paramInt))) {
            break label365;
          }
          paramv.checkBox.setChecked(true);
        }
        for (;;)
        {
          paramv.Pxv.setVisibility(0);
          AppMethodBeat.o(299136);
          return;
          i = 8;
          break;
          label347:
          i = 8;
          break label208;
          label353:
          paramv.Pxs.setVisibility(8);
          break label263;
          label365:
          paramv.checkBox.setChecked(false);
        }
        label376:
        paramv.Pxw.setPadding(paramv.Pxw.getPaddingLeft(), paramv.Pxw.getPaddingTop(), (int)UnfamiliarContactDetailUI.this.getResources().getDimension(b.d.ListPadding), paramv.Pxw.getPaddingBottom());
        paramv.Pxv.setVisibility(8);
      }
      AppMethodBeat.o(299136);
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
    String Pxr;
    au contact;
    String displayName;
    
    public b(au paramau)
    {
      this.contact = paramau;
    }
  }
  
  final class c
    extends RecyclerView.v
  {
    TextView Pxs;
    ImageView Pxt;
    ImageView Pxu;
    LinearLayout Pxv;
    LinearLayout Pxw;
    View caK;
    CheckBox checkBox;
    MaskLayout lNy;
    TextView nicknameTv;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(74596);
      this.caK = paramView;
      this.lNy = ((MaskLayout)paramView.findViewById(b.f.contact_avatar));
      this.nicknameTv = ((TextView)paramView.findViewById(b.f.contact_nick));
      this.Pxs = ((TextView)paramView.findViewById(b.f.contact_alphabet));
      this.Pxt = ((ImageView)paramView.findViewById(b.f.contact_sns_notreceive_iv));
      this.Pxu = ((ImageView)paramView.findViewById(b.f.contact_sns_notvisible_iv));
      this.Pxv = ((LinearLayout)paramView.findViewById(b.f.checkbox_area));
      this.checkBox = ((CheckBox)paramView.findViewById(b.f.checkbox));
      this.Pxw = ((LinearLayout)paramView.findViewById(b.f.item_content));
      this.Pxv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aiY(i);
          Log.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramAnonymousView.displayName });
          UnfamiliarContactDetailUI.c.a(UnfamiliarContactDetailUI.c.this, paramAnonymousView, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$ContactViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74595);
        }
      });
      AppMethodBeat.o(74596);
    }
  }
  
  final class d
    extends com.tencent.threadpool.i.b
    implements com.tencent.mm.am.h
  {
    int KRo;
    Collection<Integer> PxA;
    int PxB;
    LinkedList<String> PxC;
    LinkedList<k.b> PxD;
    UnfamiliarContactDetailUI.g Pxz;
    int index;
    
    d(UnfamiliarContactDetailUI.g paramg)
    {
      AppMethodBeat.i(74599);
      this.KRo = 0;
      this.PxB = 0;
      this.index = 0;
      this.PxC = new LinkedList();
      this.PxD = new LinkedList();
      this.PxA = paramg;
      Object localObject;
      this.Pxz = localObject;
      AppMethodBeat.o(74599);
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(182596);
      super.cancel();
      if (this.Pxz != null)
      {
        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).clear();
        this.Pxz.gWx();
      }
      AppMethodBeat.o(182596);
      return false;
    }
    
    public final String getKey()
    {
      return "delete_contact_task";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(74601);
      if (paramp.getType() == 681)
      {
        if ((((com.tencent.mm.ay.b)paramp).oPG == null) || ((com.tencent.mm.ay.b.c)((com.tencent.mm.ay.b)paramp).oPG.getRespObj() == null))
        {
          Log.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
          AppMethodBeat.o(74601);
          return;
        }
        Object localObject = ((com.tencent.mm.ay.b.c)((com.tencent.mm.ay.b)paramp).oPG.getRespObj()).oPL;
        if ((((dze)localObject).Idd != 0) || (((dze)localObject).abdX == null) || (((dze)localObject).abdX.aamU == null))
        {
          Log.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((dze)localObject).Idd) });
          AppMethodBeat.o(74601);
          return;
        }
        paramString = ((com.tencent.mm.ay.b)paramp).oPH;
        paramp = ((dze)localObject).abdX.aamU;
        Log.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramp.size()) });
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
            this.KRo -= 1;
            localObject = (aid)((k.b)localObject).KRu;
            if (((Integer)paramp.get(paramInt1)).intValue() == 0)
            {
              this.PxB += 1;
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(com.tencent.mm.platformtools.w.a(((aid)localObject).ZqL));
              if (localObject != null)
              {
                ((au)localObject).aRL();
                br.a(((az)localObject).field_username, null);
                ac.aY(((az)localObject).field_username, 15);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d(((az)localObject).field_username, (au)localObject);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK(((az)localObject).field_username);
                this.PxC.add(((az)localObject).field_username);
              }
            }
            else
            {
              Log.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramp.get(paramInt1), com.tencent.mm.platformtools.w.a(((aid)localObject).ZqL) });
            }
          }
        }
        if (this.KRo <= 0)
        {
          paramString = this.PxC.iterator();
          while (paramString.hasNext())
          {
            paramp = (String)paramString.next();
            localObject = UnfamiliarContactDetailUI.f(UnfamiliarContactDetailUI.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).contact.field_username.equals(paramp)) {
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
              if (UnfamiliarContactDetailUI.d.this.Pxz != null)
              {
                UnfamiliarContactDetailUI.d.this.Pxz.lb(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this).size(), UnfamiliarContactDetailUI.d.this.PxB);
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
      this.KRo = this.PxA.size();
      Iterator localIterator = this.PxA.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.index += 1;
        int j = this.PxA.size();
        int k = this.index;
        if (UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this) != null)
        {
          au localau = UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.this).aiY(i).contact;
          if (au.bwO(localau.field_username))
          {
            ((u)com.tencent.mm.kernel.h.ax(u.class)).Eg(localau.field_username);
          }
          else
          {
            aid localaid = new aid();
            localaid.ZqL = new etl().btH(Util.nullAsNil(localau.field_username));
            this.PxD.add(new k.a(4, localaid));
            if ((this.PxD.size() % 20 == 0) || (k == j))
            {
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.ay.b(this.PxD), 0);
              this.PxD.clear();
            }
          }
        }
      }
      AppMethodBeat.o(74600);
    }
  }
  
  static final class f
  {
    static int PxI;
    static int PxJ;
    static int PxK;
    static int PxL;
    static int PxM;
    static int PxN;
  }
  
  static abstract interface g
  {
    public abstract void gWx();
    
    public abstract void gWy();
    
    public abstract void lb(int paramInt1, int paramInt2);
  }
  
  public static abstract interface h
  {
    public abstract void a(UnfamiliarContactDetailUI.e parame);
    
    public abstract void atR();
    
    public abstract void g(HashSet paramHashSet);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */