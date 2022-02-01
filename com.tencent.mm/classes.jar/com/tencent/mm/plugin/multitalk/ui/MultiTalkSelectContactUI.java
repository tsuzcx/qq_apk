package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.autogen.a.ot;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.bc.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p.12;
import com.tencent.mm.plugin.multitalk.model.u;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.plugin.multitalk.ui.widget.l;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkSelectContactUI
  extends MMBaseSelectContactUI
{
  boolean LrP;
  private ArrayList<String> LrQ;
  private Activity LrR;
  private boolean LrS;
  private l LrT;
  private RecyclerView LrU;
  private FrameLayout LrV;
  private boolean LrW;
  private d LrX;
  private View.OnClickListener LrY;
  private String chatroomName;
  private IListener nnP;
  private HashSet<String> pJP;
  private HashSet<String> pJQ;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.LrP = true;
    this.LrW = false;
    this.LrY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView instanceof ImageView))
        {
          localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.jyE();
          if (z.bAM().equals(localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).Kf((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
          MultiTalkSelectContactUI.k(MultiTalkSelectContactUI.this).setContentDescription(((com.tencent.mm.plugin.multitalk.ui.widget.q)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).ghT().toString());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178897);
      }
    };
    this.nnP = new IListener(com.tencent.mm.app.f.hfK) {};
    this.LrR = this;
    AppMethodBeat.o(114694);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(114706);
    if (this.pJQ.size() > 0)
    {
      updateOptionMenuText(1, getString(a.h.multitalk_ok, new Object[] { Integer.valueOf(this.pJP.size() + this.pJQ.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    updateOptionMenuText(1, getString(a.h.multitalk_ok_without_number));
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(285443);
    paramAdapterView = jyE();
    paramView = paramAdapterView.aDt(paramInt - getContentLV().getHeaderViewsCount());
    if (paramView == null)
    {
      AppMethodBeat.o(285443);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(285443);
      return;
    }
    Log.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { paramView.contact.field_username });
    paramView = paramView.contact.field_username;
    if (z.bAM().equals(paramView))
    {
      AppMethodBeat.o(285443);
      return;
    }
    iKA();
    if (this.pJP.contains(paramView))
    {
      AppMethodBeat.o(285443);
      return;
    }
    int j;
    Object localObject1;
    View.OnClickListener localOnClickListener;
    int k;
    if (this.pJQ.contains(paramView))
    {
      if (this.LrS) {
        this.LrT.Kf(paramView);
      }
      this.pJQ.remove(paramView);
      j = this.LrQ.indexOf(paramView);
      this.LrQ.remove(paramView);
      paramView = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter();
      localObject1 = this.LrQ;
      localOnClickListener = this.LrY;
      s.u(localObject1, "userNameList");
      s.u(localOnClickListener, "onClickListener");
      paramView.BmO.clear();
      paramView.BmO.add(z.bAM());
      k = ((ArrayList)localObject1).size() - 1;
      if (k < 0) {}
    }
    int i;
    for (paramInt = 0;; paramInt = i)
    {
      i = paramInt + 1;
      Object localObject2 = ((ArrayList)localObject1).get(paramInt);
      s.s(localObject2, "userNameList[i]");
      if ((!paramView.aNI((String)localObject2)) && (!s.p(((ArrayList)localObject1).get(paramInt), z.bAM()))) {
        paramView.BmO.add(((ArrayList)localObject1).get(paramInt));
      }
      if (i > k)
      {
        paramView.LwS = localOnClickListener;
        if (paramView.BmO.size() < 5) {}
        for (paramInt = 0;; paramInt = i)
        {
          i = paramInt + 1;
          paramView.fV(paramInt + paramView.xZt);
          if (i >= 5)
          {
            paramView.fX(paramView.xZt + j);
            this.LrV.setContentDescription(((com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter()).ghT().toString());
            paramView = this.LrU;
            localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.LrU.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
            paramAdapterView.notifyDataSetChanged();
            aNr();
            AppMethodBeat.o(285443);
            return;
            if (this.pJP.size() + this.pJQ.size() == com.tencent.mm.plugin.multitalk.e.f.giS())
            {
              this.LrW = true;
              com.tencent.mm.plugin.multitalk.e.b.je(this);
              AppMethodBeat.o(285443);
              return;
            }
            if (this.LrS) {
              this.LrT.aNE(paramView);
            }
            this.pJQ.add(paramView);
            this.LrQ.add(paramView);
            paramView = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter();
            localObject1 = this.LrQ;
            localOnClickListener = this.LrY;
            s.u(localObject1, "userNameList");
            s.u(localOnClickListener, "onClickListener");
            paramView.BmO.clear();
            paramView.BmO.add(z.bAM());
            j = ((ArrayList)localObject1).size() - 1;
            if (j >= 0) {}
            for (paramInt = 0;; paramInt = i)
            {
              i = paramInt + 1;
              localObject2 = ((ArrayList)localObject1).get(paramInt);
              s.s(localObject2, "userNameList[i]");
              if ((!paramView.aNI((String)localObject2)) && (!s.p(((ArrayList)localObject1).get(paramInt), z.bAM()))) {
                paramView.BmO.add(((ArrayList)localObject1).get(paramInt));
              }
              if (i > j)
              {
                paramView.LwS = localOnClickListener;
                if (paramView.BmO.size() < 5) {}
                for (paramInt = 0;; paramInt = i)
                {
                  i = paramInt + 1;
                  paramView.fV(paramInt + paramView.xZt);
                  if (i >= 5)
                  {
                    paramView.fW(paramView.getItemCount());
                    this.LrV.setContentDescription(((com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter()).ghT().toString());
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(114695);
    super.aNi();
    this.LrS = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!au.bwE(this.chatroomName)) {
      finish();
    }
    this.pJQ = new HashSet();
    this.pJP = new HashSet();
    this.LrQ = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJP.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public final com.tencent.mm.ui.contact.r bVA()
  {
    AppMethodBeat.i(114700);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return localb;
  }
  
  public final com.tencent.mm.ui.contact.p bVB()
  {
    AppMethodBeat.i(114701);
    c localc = new c(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localc;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public void fYZ()
  {
    AppMethodBeat.i(114703);
    super.fYZ();
    hideVKB();
    if (this.LrP) {
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    }
    AppMethodBeat.o(114703);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.f.multitalk_select_contact_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(114696);
    super.initView();
    this.LrX = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.LrX.Ltx) && (com.tencent.mm.plugin.multitalk.e.b.giB()))
    {
      localObject = this.LrX;
      localListView = this.Nnk;
      ((d)localObject).plc = ListView.inflate(((d)localObject).mContext, a.f.multitalk_link_meeting, null);
      ((d)localObject).plc.getViewTreeObserver().addOnDrawListener(((d)localObject).LtD);
      ((d)localObject).plc.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).Lty = ((WxImageView)((d)localObject).plc.findViewById(a.e.metting_link_icon));
      ((d)localObject).LtA = ((TextView)((d)localObject).plc.findViewById(a.e.meeting_detail_tv));
      ((d)localObject).Ltz = ((TextView)((d)localObject).plc.findViewById(a.e.meeting_link_tv));
      ((d)localObject).LtB = ((WxImageView)((d)localObject).plc.findViewById(a.e.more_arrow));
      ((d)localObject).LtB.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
      if ((Util.isNullOrNil(com.tencent.mm.plugin.multitalk.e.b.giI())) || (Util.isNullOrNil(com.tencent.mm.plugin.multitalk.e.b.giJ()))) {
        break label437;
      }
      ((d)localObject).Ltz.setText(com.tencent.mm.plugin.multitalk.e.b.giI());
      ((d)localObject).LtA.setText(com.tencent.mm.plugin.multitalk.e.b.giJ());
      i = 1;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(com.tencent.mm.plugin.multitalk.e.b.getIconUrl()))
      {
        com.tencent.mm.modelimage.r.bKe().a(com.tencent.mm.plugin.multitalk.e.b.getIconUrl(), null, new d.3((d)localObject));
        label244:
        localListView.removeFooterView(((d)localObject).plc);
        if (i == 0) {
          break label551;
        }
        ((d)localObject).Ltx = true;
        localListView.addFooterView(((d)localObject).plc);
        label270:
        setActionbarColor(getResources().getColor(a.b.dark_actionbar_color));
        hideActionbarLine();
        setNavigationbarColor(Color.parseColor("#232323"));
        this.LrT = new l(this);
        localObject = getString(a.h.multitalk_ok, new Object[] { Integer.valueOf(this.pJP.size() + this.pJQ.size()) });
        if (!this.LrS) {
          break label568;
        }
        localObject = getString(a.h.multitalk_start_talk, new Object[] { Integer.valueOf(this.pJP.size() + this.pJQ.size()) });
      }
      label437:
      label568:
      for (;;)
      {
        addTextOptionMenu(1, (String)localObject, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(114692);
            if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
              e.a(MultiTalkSelectContactUI.this, a.h.voip_net_unavailable, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(z.bAM());
              paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                com.tencent.mm.plugin.multitalk.model.o.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).Lvq);
                com.tencent.mm.plugin.multitalk.model.p localp = ac.ggS();
                Object localObject = MultiTalkSelectContactUI.this;
                String str1 = MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this);
                boolean bool2 = localp.lAj;
                boolean bool3 = localp.snA;
                boolean bool4 = localp.Loe;
                String str2 = localp.Lok.toString();
                if (localp.Lol == null) {}
                for (boolean bool1 = true;; bool1 = false)
                {
                  Log.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), str2, Boolean.valueOf(bool1) });
                  com.tencent.mm.plugin.multitalk.model.o.gfJ();
                  if (!com.tencent.mm.plugin.multitalk.model.p.fwe()) {
                    break label259;
                  }
                  k.s((Context)localObject, a.h.in_phone_tip, a.h.app_tip);
                  break;
                }
                label259:
                if (m.icd())
                {
                  k.s((Context)localObject, a.h.in_wechat_out_tip, a.h.app_tip);
                }
                else if (m.isVoipStarted())
                {
                  k.s((Context)localObject, a.h.in_voip_tip, a.h.app_tip);
                }
                else if (e.bNC())
                {
                  k.s((Context)localObject, a.h.in_new_share_location_tip, a.h.app_tip);
                }
                else if (m.ice())
                {
                  k.s((Context)localObject, a.h.in_voip_cs_tip, a.h.app_tip);
                }
                else if (localp.geX())
                {
                  e.a((Context)localObject, a.h.multitalk_exit_tip, null);
                }
                else
                {
                  long l = Util.milliSecondsToNow(localp.Lov);
                  int i;
                  if ((localp.Lou) && (l < localp.Low))
                  {
                    Log.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk, isOverLoadFail is true! elapsedWaitMs:" + l + ", overLoadFailTimeLimit:" + localp.Low);
                    i = (int)Math.ceil((localp.Low - l) / 1000.0D);
                    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.multitalk_overload_fail_seconds_tips, new Object[] { Integer.valueOf(i) }), 0).show();
                  }
                  else
                  {
                    localp.Lou = false;
                    localObject = Util.stringsToList(paramAnonymousMenuItem.split(","));
                    i = com.tencent.mm.plugin.multitalk.e.f.giV();
                    Log.i("MicroMsg.MT.MultiTalkManager", "getMultiTalkSDKMode sdk mode:%d", new Object[] { Integer.valueOf(i) });
                    if (i == 1) {
                      localp.as(paramAnonymousMenuItem, str1, 2);
                    }
                    for (;;)
                    {
                      paramAnonymousMenuItem = new ot();
                      paramAnonymousMenuItem.hRA.hRB = true;
                      paramAnonymousMenuItem.publish();
                      break;
                      com.tencent.mm.plugin.multitalk.c.o.Ljn.a((ArrayList)localObject, str1, new p.12(localp, paramAnonymousMenuItem, str1));
                    }
                  }
                }
              }
              else
              {
                com.tencent.mm.plugin.multitalk.model.o.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, u.ggB(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.LrP = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, y.b.adEJ);
        aNr();
        this.KOt.setBackgroundResource(a.b.default_bg_color);
        this.KOt.getInputText().setTextColor(-1);
        jyI();
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.e.b.giC())
        {
          ((d)localObject).Ltz.setText(a.h.multitalk_use_meeting);
          ((d)localObject).LtA.setText(a.h.meeting_detail);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.e.b.giD()) {
          break label571;
        }
        ((d)localObject).Ltz.setText(a.h.multitalk_use_work);
        ((d)localObject).LtA.setText(a.h.wework_detail);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.e.b.giC())
        {
          ((d)localObject).Lty.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_tencentmeeting_logo, -1));
          break label244;
        }
        if (!com.tencent.mm.plugin.multitalk.e.b.giD()) {
          break label244;
        }
        ((d)localObject).Lty.setBackground(bb.m(MMApplicationContext.getContext(), a.g.icons_outlined_wxwork_logo, -1));
        break label244;
        ((d)localObject).Ltx = true;
        Log.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
        break label270;
      }
      label551:
      label571:
      i = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114697);
    super.onCreate(paramBundle);
    AppMethodBeat.o(114697);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114698);
    d locald = this.LrX;
    if ((locald.plc != null) && (locald.LtD != null))
    {
      locald.plc.getViewTreeObserver().removeOnDrawListener(locald.LtD);
      locald.mContext = null;
    }
    this.nnP.dead();
    super.onDestroy();
    AppMethodBeat.o(114698);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178901);
    super.onPause();
    AppMethodBeat.o(178901);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(178902);
    super.onResume();
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(178902);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(178900);
    super.onStart();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.pJP.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    this.pJP.add(z.bAM());
    this.LrQ.addAll(this.pJP);
    if (this.LrS) {
      this.LrT.aNE(z.bAM());
    }
    this.LrU = ((RecyclerView)findViewById(a.e.small_avatar_list));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.LrU.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.LrU.setAdapter(new com.tencent.mm.plugin.multitalk.ui.widget.q(this));
    ((com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter()).b(this.LrQ, this.LrY);
    this.nnP.alive();
    this.LrV = ((FrameLayout)findViewById(a.e.small_avatar_list_container));
    this.LrV.setContentDescription(((com.tencent.mm.plugin.multitalk.ui.widget.q)this.LrU.getAdapter()).ghT().toString());
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(285371);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.multitalk.a.b.class);
    AppMethodBeat.o(285371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */