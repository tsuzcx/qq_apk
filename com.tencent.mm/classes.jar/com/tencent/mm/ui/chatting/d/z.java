package com.tencent.mm.ui.chatting.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.w.class)
public class z
  extends a
  implements com.tencent.mm.ui.chatting.d.b.w
{
  private a EZY;
  private ImageView JJA;
  private ImageView JJB;
  private e JJC;
  private List<com.tencent.mm.chatroom.storage.c> JJD;
  private HashMap<String, com.tencent.mm.chatroom.storage.c> JJE;
  private ArrayList<f> JJF;
  private boolean JJG;
  private ObjectAnimator JJH;
  private ObjectAnimator JJI;
  private b JJJ;
  private RecyclerView JJz;
  private com.tencent.mm.sdk.b.c<nb> fLB;
  private LinearLayoutManager fPL;
  private View iCR;
  
  public z()
  {
    AppMethodBeat.i(184990);
    this.JJD = new ArrayList();
    this.JJE = new HashMap();
    this.EZY = null;
    this.JJF = new ArrayList();
    this.JJG = true;
    this.JJH = null;
    this.JJI = null;
    this.fLB = new com.tencent.mm.sdk.b.c() {};
    this.JJJ = new b()
    {
      public final void M(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(194032);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          if (paramAnonymousView.Yo())
          {
            y.f(z.this.cWM.JOR.getContext(), paramAnonymousView.field_roomname, false);
            localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = y.e((com.tencent.mm.chatroom.storage.c)localObject);
            if (localObject == null) {
              break label329;
            }
            bool2 = y.b((com.tencent.mm.chatroom.storage.c)localObject);
            bool1 = bool2;
            if (bool2) {
              aq.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(194026);
                  z.a(z.this).add(new z.f(this.JJL, paramAnonymousInt + 1));
                  AppMethodBeat.o(194026);
                }
              }, 300L);
            }
          }
        }
        label142:
        label281:
        label329:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          String str = z.this.cWM.getTalkerUserName();
          if (paramAnonymousView.Yo())
          {
            paramAnonymousInt = 1;
            com.tencent.mm.chatroom.d.z.a(str, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject != null) {
              break label281;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid)
          {
            ad.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(194032);
            return;
            localObject = new f();
            ((f)localObject).username = paramAnonymousView.field_username;
            ((f)localObject).jCN = paramAnonymousView.field_path;
            ((f)localObject).scene = 1160;
            ((f)localObject).jCX = paramAnonymousView.field_roomname;
            ((o)g.ab(o.class)).a(z.this.cWM.JOR.getContext(), (f)localObject);
            break;
            paramAnonymousInt = 0;
            break label142;
          }
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
          {
            ad.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", new Object[] { paramAnonymousView });
            AppMethodBeat.o(194032);
            return;
          }
        }
      }
      
      public final boolean aD(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(194033);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.c))
        {
          localObject = (com.tencent.mm.chatroom.storage.c)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(z.this.cWM.JOR.getContext(), paramAnonymousView);
          locala.Lak = true;
          locala.Lam = true;
          locala.Lan = true;
          locala.Lai = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(194027);
              paramAnonymous2ContextMenu.clear();
              if (com.tencent.mm.model.w.zq(z.this.cWM.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, z.this.cWM.JOR.getContext().getResources().getString(2131757234));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, z.this.cWM.JOR.getContext().getResources().getString(2131757058));
              AppMethodBeat.o(194027);
            }
          };
          locala.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(194030);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(194030);
                return;
              case 1: 
                paramAnonymous2MenuItem = z.this.cWM.JOR.getContext();
                String str1 = z.this.cWM.getTalkerUserName();
                String str2 = this.JJO.field_todoid;
                String str3 = this.JJO.field_username;
                if (this.JJO.Yo()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void Yf()
                    {
                      AppMethodBeat.i(194028);
                      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(194028);
                    }
                    
                    public final void Yg()
                    {
                      AppMethodBeat.i(194029);
                      Pair localPair = y.a(z.8.3.this.JJO);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        z.d(z.this, z.8.3.this.JJO);
                        z.b(z.this).cl(z.8.3.this.JJM);
                        z.c(z.this);
                      }
                      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(194029);
                    }
                  });
                  AppMethodBeat.o(194030);
                  return;
                }
              }
              boolean bool = y.c(this.JJO);
              ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.JJO.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                z.d(z.this, this.JJO);
                z.b(z.this).cl(paramAnonymousInt);
                z.c(z.this);
              }
              paramAnonymous2MenuItem = z.this.cWM.getTalkerUserName();
              if (this.JJO.Yo()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                com.tencent.mm.chatroom.d.z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.JJO.field_todoid, this.JJO.field_username);
                break;
              }
            }
          };
          int[] arrayOfInt = new int[2];
          paramAnonymousView.getLocationInWindow(arrayOfInt);
          i = arrayOfInt[0];
          int j = arrayOfInt[1] - 32;
          paramAnonymousInt = i;
          if (i <= 0) {
            paramAnonymousInt = 16;
          }
          i = j;
          if (j < 0) {
            i = 16;
          }
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(z.this.cWM.JOR.getContext())) {
            break label265;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(z.this.cWM.JOR.getContext()) - 16;
        }
        label265:
        for (;;)
        {
          locala.KLB = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(194031);
              paramAnonymousView.setBackgroundResource(2131231662);
              AppMethodBeat.o(194031);
            }
          };
          locala.Lah = paramAnonymousView;
          locala.el(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(2131231664);
          paramAnonymousView = z.this.cWM.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.c)localObject).Yo()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            com.tencent.mm.chatroom.d.z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.c)localObject).field_username);
            AppMethodBeat.o(194033);
            return true;
          }
        }
      }
      
      public final boolean aE(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(194034);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          boolean bool = y.c(paramAnonymousView);
          ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
            str1 = z.this.cWM.getTalkerUserName();
            String str2 = paramAnonymousView.field_creator;
            String str3 = paramAnonymousView.field_todoid;
            cwn localcwn = y.d(paramAnonymousView);
            g.aiU().a(new t(str1, str2, str3, localcwn), 0);
            z.d(z.this, paramAnonymousView);
            z.b(z.this).cl(paramAnonymousInt);
            z.c(z.this);
          }
          String str1 = z.this.cWM.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.Yo()) {
            paramAnonymousInt = 1;
          }
          com.tencent.mm.chatroom.d.z.a(str1, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
          AppMethodBeat.o(194034);
          return true;
        }
        if (paramAnonymousView == null) {}
        for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
        {
          ad.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", new Object[] { paramAnonymousView });
          break;
        }
      }
    };
    AppMethodBeat.o(184990);
  }
  
  private void a(com.tencent.mm.chatroom.storage.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(185872);
    if (!y.e(paramc))
    {
      AppMethodBeat.o(185872);
      return;
    }
    if (this.JJD.contains(paramc))
    {
      if (paramBoolean)
      {
        if (this.JJD.indexOf(paramc) != -1) {
          this.JJF.add(new f(paramc, this.JJD.indexOf(paramc) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(paramc);
      if (i != -1) {
        this.JJC.ap(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (paramc != null)
    {
      this.JJD.add(0, paramc);
      this.JJE.put(paramc.field_todoid, paramc);
      this.JJC.ck(0);
    }
    if (this.JJD.size() > 20) {
      h.LTJ.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194025);
          int i = z.g(z.this).size() - 1;
          while (i >= 20)
          {
            com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)z.g(z.this).remove(i);
            if (localc != null) {
              z.h(z.this).remove(localc);
            }
            i -= 1;
          }
          z.b(z.this).as(20, z.g(z.this).size() - 20);
          AppMethodBeat.o(194025);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private boolean fDR()
  {
    AppMethodBeat.i(184995);
    boolean bool = com.tencent.mm.model.w.zk(this.cWM.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void fDS()
  {
    AppMethodBeat.i(184996);
    at localat = ((l)g.ab(l.class)).azv().aTz(this.cWM.getTalkerUserName());
    if ((localat != null) && (localat.field_hasTodo == 1))
    {
      localat.ky(0);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(localat, localat.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void fDT()
  {
    AppMethodBeat.i(185873);
    this.JJD.clear();
    this.JJE.clear();
    AppMethodBeat.o(185873);
  }
  
  private int i(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184998);
    if (paramc != null)
    {
      if (this.JJD.contains(paramc))
      {
        int i = this.JJD.indexOf(paramc);
        this.JJD.remove(paramc);
        this.JJE.remove(paramc.field_todoid);
        AppMethodBeat.o(184998);
        return i;
      }
      ad.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
    }
    AppMethodBeat.o(184998);
    return -1;
  }
  
  private int j(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184999);
    if (paramc != null)
    {
      if (this.JJD.contains(paramc))
      {
        int i = this.JJD.indexOf(paramc);
        this.JJD.remove(i);
        this.JJD.add(0, paramc);
        this.JJE.put(paramc.field_todoid, paramc);
        AppMethodBeat.o(184999);
        return i;
      }
      ad.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(184997);
    if (this.iCR != null) {
      if (this.JJD.size() == 0)
      {
        this.iCR.setVisibility(8);
        if (this.EZY != null)
        {
          this.EZY.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.JJG)
      {
        this.iCR.setVisibility(0);
        if (this.EZY != null) {
          this.EZY.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  public final void a(a parama)
  {
    this.EZY = parama;
  }
  
  public final int dbF()
  {
    AppMethodBeat.i(185871);
    if ((y.Yd()) && (this.iCR != null) && (this.JJD.size() > 0))
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(this.cWM.JOR.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(184991);
    super.fwt();
    if (!y.Yd())
    {
      AppMethodBeat.o(184991);
      return;
    }
    ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.iCR == null)
    {
      l1 = cf.aCL();
      this.iCR = this.cWM.findViewById(2131298091);
      this.JJz = ((RecyclerView)this.iCR.findViewById(2131305972));
      this.JJA = ((ImageView)this.iCR.findViewById(2131305967));
      this.JJB = ((ImageView)this.iCR.findViewById(2131305971));
      this.JJz.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(194024);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(194024);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(184966);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousRecyclerView.canScrollHorizontally(-1)) });
          if ((paramAnonymousInt == 0) && (!paramAnonymousRecyclerView.canScrollHorizontally(-1)))
          {
            z.d(z.this).setVisibility(8);
            z.e(z.this).setVisibility(8);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(184966);
            return;
            z.d(z.this).setVisibility(0);
            z.e(z.this).setVisibility(0);
          }
        }
      });
      this.cWM.JOR.getContext();
      this.fPL = new LinearLayoutManager();
      this.fPL.setOrientation(0);
      this.JJz.setLayoutManager(this.fPL);
      this.JJC = new e(this.cWM.JOR.getContext(), this.JJD, this.JJJ);
      this.JJz.setAdapter(this.JJC);
      this.JJC.asY.notifyChanged();
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(cf.aCL() - l1) });
    }
    long l1 = cf.aCL();
    if (fDR())
    {
      this.fLB.alive();
      if (this.iCR != null)
      {
        fDT();
        Iterator localIterator = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().uQ(this.cWM.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)localIterator.next();
          this.JJD.add(localc);
          this.JJE.put(localc.field_todoid, localc);
        }
        Collections.sort(this.JJD, new Comparator() {});
        this.JJC.asY.notifyChanged();
        updateView();
      }
      fDS();
      h.LTJ.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184967);
          ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume() batch delete expire data!!");
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().Yp();
          AppMethodBeat.o(184967);
        }
      }, 30000L);
    }
    for (;;)
    {
      long l2 = cf.aCL();
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.cWM.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      fDT();
      this.iCR.setVisibility(8);
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(185867);
    super.fwv();
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.JJF.size() > 0)
    {
      Iterator localIterator = this.JJF.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.dkM == 1)
        {
          j(localf.JJZ);
          this.JJC.ap(localf.ajM, localf.ajO);
        }
      }
      this.JJF.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(185868);
    super.fww();
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(184992);
    super.fwy();
    if (!y.Yd())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (fDR())
    {
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.fLB.dead();
      if (this.iCR != null) {
        this.iCR.setVisibility(8);
      }
      fDS();
    }
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
    AppMethodBeat.o(184992);
  }
  
  public final void xT(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!y.Yd())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!fDR())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.JJG = true;
    if (this.iCR.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.JJD.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.JJI == null)
    {
      this.JJI = ObjectAnimator.ofFloat(this.iCR, "alpha", new float[] { 0.0F, 1.0F });
      this.JJI.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(184969);
          if (z.f(z.this) != null) {
            z.f(z.this).setVisibility(0);
          }
          AppMethodBeat.o(184969);
        }
      });
    }
    if (paramBoolean) {
      this.JJI.setDuration(100L);
    }
    for (;;)
    {
      this.JJI.start();
      AppMethodBeat.o(185870);
      return;
      this.JJI.setDuration(200L);
    }
  }
  
  public final void xU(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!y.Yd())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!fDR())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.JJG = false;
    if (this.iCR.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.JJH == null)
    {
      this.JJH = ObjectAnimator.ofFloat(this.iCR, "alpha", new float[] { 1.0F, 0.0F });
      this.JJH.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(184968);
          if (z.f(z.this) != null) {
            z.f(z.this).setVisibility(4);
          }
          AppMethodBeat.o(184968);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.JJH.setDuration(100L);
    }
    for (;;)
    {
      this.JJH.start();
      AppMethodBeat.o(185869);
      return;
      this.JJH.setDuration(200L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hide();
    
    public abstract void show();
  }
  
  static abstract interface b
  {
    public abstract void M(View paramView, int paramInt);
    
    public abstract boolean aD(View paramView, int paramInt);
    
    public abstract boolean aE(View paramView, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract int dbF();
    
    public abstract void xT(boolean paramBoolean);
    
    public abstract void xU(boolean paramBoolean);
  }
  
  static final class d
    extends RecyclerView.w
  {
    static final com.tencent.mm.aw.a.a.c fOJ;
    RelativeLayout JJQ;
    TextView JJR;
    RelativeLayout JJS;
    RelativeLayout JJT;
    TextView JJU;
    View fOB;
    ImageView fUN;
    
    static
    {
      AppMethodBeat.i(184981);
      c.a locala1 = new c.a();
      locala1.idD = 2131689599;
      c.a locala2 = locala1.dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20));
      locala2.hfi = true;
      locala2.idr = true;
      locala2.idp = true;
      fOJ = locala1.aJc();
      AppMethodBeat.o(184981);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(184980);
      this.fOB = paramView;
      this.JJQ = ((RelativeLayout)paramView.findViewById(2131305960));
      this.fUN = ((ImageView)paramView.findViewById(2131305964));
      this.JJR = ((TextView)paramView.findViewById(2131305974));
      this.JJS = ((RelativeLayout)paramView.findViewById(2131305962));
      this.JJT = ((RelativeLayout)paramView.findViewById(2131305968));
      this.JJU = ((TextView)paramView.findViewById(2131305970));
      AppMethodBeat.o(184980);
    }
  }
  
  static final class e
    extends RecyclerView.a
  {
    private z.b JJJ;
    private List<com.tencent.mm.chatroom.storage.c> JJV;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.c> paramList, z.b paramb)
    {
      this.context = paramContext;
      this.JJV = paramList;
      this.JJJ = paramb;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(184987);
      paramViewGroup = new z.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493401, paramViewGroup, false));
      AppMethodBeat.o(184987);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(184988);
      final z.d locald;
      final com.tencent.mm.chatroom.storage.c localc;
      if ((this.JJV != null) && (paramInt >= 0) && (paramInt < this.JJV.size()))
      {
        locald = (z.d)paramw;
        localc = (com.tencent.mm.chatroom.storage.c)this.JJV.get(paramInt);
        ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.fOB.setVisibility(0);
        if (!localc.Yo()) {
          break label263;
        }
        locald.fUN.setImageResource(2131231596);
        locald.JJR.setText(bt.bI(localc.field_title, this.context.getString(2131757057)));
        if (paramInt != 0) {
          break label406;
        }
        paramw = (RelativeLayout.LayoutParams)locald.JJQ.getLayoutParams();
        if (paramw.leftMargin == 0)
        {
          paramw.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
          locald.JJQ.setLayoutParams(paramw);
        }
        label158:
        if (localc.field_state != 0) {
          break label452;
        }
        locald.JJS.setVisibility(8);
        if (localc.field_nreply <= 0) {
          break label440;
        }
        locald.JJT.setVisibility(0);
        locald.JJU.setText(localc.field_nreply);
      }
      for (;;)
      {
        locald.JJQ.setTag(localc);
        locald.JJQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (z.e.a(z.e.this) != null) {
              z.e.a(z.e.this).M(paramAnonymousView, locald.lN());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184985);
          }
        });
        locald.JJQ.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
            if (z.e.a(z.e.this) != null)
            {
              boolean bool = z.e.a(z.e.this).aD(paramAnonymousView, locald.lN());
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(184986);
              return bool;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(184986);
            return false;
          }
        });
        AppMethodBeat.o(184988);
        return;
        label263:
        WxaAttributes localWxaAttributes = ((n)g.ab(n.class)).Nt(localc.field_username);
        if (localWxaAttributes == null)
        {
          ((n)g.ab(n.class)).a(localc.field_username, new n.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.q.aIJ();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, z.e.1.this.JJW.fUN, z.d.fOJ);
                    if ((bt.isNullOrNil(z.e.1.this.JJO.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      z.e.1.this.JJW.JJR.setText(paramAnonymousWxaAttributes.field_nickname);
                    }
                    AppMethodBeat.o(184982);
                    return;
                  }
                }
              });
              AppMethodBeat.o(184983);
            }
          });
          if (bt.isNullOrNil(localc.field_title)) {
            break;
          }
          locald.JJR.setText(bt.bI(localc.field_title, ""));
          break;
        }
        com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.q.aIJ();
        if (localWxaAttributes != null) {}
        for (paramw = localWxaAttributes.field_smallHeadURL;; paramw = "")
        {
          locala.a(paramw, locald.fUN, z.d.fOJ);
          locald.JJR.setText(bt.bI(localc.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label406:
        paramw = (RelativeLayout.LayoutParams)locald.JJQ.getLayoutParams();
        if (paramw.leftMargin == 0) {
          break label158;
        }
        paramw.leftMargin = 0;
        locald.JJQ.setLayoutParams(paramw);
        break label158;
        label440:
        locald.JJT.setVisibility(8);
        continue;
        label452:
        if (localc.field_state == 1)
        {
          locald.JJS.setVisibility(0);
          locald.JJT.setVisibility(8);
          locald.JJS.setTag(localc);
          locald.JJS.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (z.e.a(z.e.this) != null) {
                z.e.a(z.e.this).aE(paramAnonymousView, locald.lN());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(184984);
            }
          });
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(184989);
      int i = this.JJV.size();
      AppMethodBeat.o(184989);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  static final class f
  {
    public com.tencent.mm.chatroom.storage.c JJZ;
    public int ajM;
    public int ajO;
    public int dkM = 0;
    
    public f(com.tencent.mm.chatroom.storage.c paramc, int paramInt)
    {
      this.JJZ = paramc;
      this.dkM = 1;
      this.ajM = 0;
      this.ajO = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.z
 * JD-Core Version:    0.7.0.1
 */