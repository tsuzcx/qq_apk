package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=u.class)
public class x
  extends a
  implements u
{
  private a DuP;
  private RecyclerView HVb;
  private ImageView HVc;
  private ImageView HVd;
  private e HVe;
  private List<com.tencent.mm.chatroom.storage.a> HVf;
  private HashMap<String, com.tencent.mm.chatroom.storage.a> HVg;
  private ArrayList<f> HVh;
  private boolean HVi;
  private ObjectAnimator HVj;
  private ObjectAnimator HVk;
  private b HVl;
  private com.tencent.mm.sdk.b.c<mt> ftb;
  private LinearLayoutManager fwy;
  private View ijA;
  
  public x()
  {
    AppMethodBeat.i(184990);
    this.HVf = new ArrayList();
    this.HVg = new HashMap();
    this.DuP = null;
    this.HVh = new ArrayList();
    this.HVi = true;
    this.HVj = null;
    this.HVk = null;
    this.ftb = new com.tencent.mm.sdk.b.c() {};
    this.HVl = new b()
    {
      public final void M(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(196487);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.a))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.a)paramAnonymousView;
          if (paramAnonymousView.VU())
          {
            y.f(x.this.cLy.HZF.getContext(), paramAnonymousView.field_roomname, false);
            localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().af(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = y.e((com.tencent.mm.chatroom.storage.a)localObject);
            if (localObject == null) {
              break label329;
            }
            bool2 = y.b((com.tencent.mm.chatroom.storage.a)localObject);
            bool1 = bool2;
            if (bool2) {
              com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196481);
                  x.a(x.this).add(new x.f(this.HVn, paramAnonymousInt + 1));
                  AppMethodBeat.o(196481);
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
          String str = x.this.cLy.getTalkerUserName();
          if (paramAnonymousView.VU())
          {
            paramAnonymousInt = 1;
            z.a(str, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject != null) {
              break label281;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.a)localObject).field_todoid)
          {
            ac.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(196487);
            return;
            localObject = new f();
            ((f)localObject).username = paramAnonymousView.field_username;
            ((f)localObject).jjf = paramAnonymousView.field_path;
            ((f)localObject).scene = 1160;
            ((f)localObject).jjp = paramAnonymousView.field_roomname;
            ((n)g.ab(n.class)).a(x.this.cLy.HZF.getContext(), (f)localObject);
            break;
            paramAnonymousInt = 0;
            break label142;
          }
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
          {
            ac.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", new Object[] { paramAnonymousView });
            AppMethodBeat.o(196487);
            return;
          }
        }
      }
      
      public final boolean aB(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(196488);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.a))
        {
          localObject = (com.tencent.mm.chatroom.storage.a)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(x.this.cLy.HZF.getContext(), paramAnonymousView);
          locala.JiS = true;
          locala.JiT = true;
          locala.JiU = true;
          locala.JiR = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(196482);
              paramAnonymous2ContextMenu.clear();
              if (w.wu(x.this.cLy.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, x.this.cLy.HZF.getContext().getResources().getString(2131757234));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, x.this.cLy.HZF.getContext().getResources().getString(2131757058));
              AppMethodBeat.o(196482);
            }
          };
          locala.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(196485);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(196485);
                return;
              case 1: 
                paramAnonymous2MenuItem = x.this.cLy.HZF.getContext();
                String str1 = x.this.cLy.getTalkerUserName();
                String str2 = this.HVq.field_todoid;
                String str3 = this.HVq.field_username;
                if (this.HVq.VU()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void VO()
                    {
                      AppMethodBeat.i(196483);
                      ac.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(196483);
                    }
                    
                    public final void VP()
                    {
                      AppMethodBeat.i(196484);
                      Pair localPair = y.a(x.8.3.this.HVq);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        x.d(x.this, x.8.3.this.HVq);
                        x.b(x.this).cl(x.8.3.this.HVo);
                        x.c(x.this);
                      }
                      ac.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(196484);
                    }
                  });
                  AppMethodBeat.o(196485);
                  return;
                }
              }
              boolean bool = y.c(this.HVq);
              ac.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.HVq.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                x.d(x.this, this.HVq);
                x.b(x.this).cl(paramAnonymousInt);
                x.c(x.this);
              }
              paramAnonymous2MenuItem = x.this.cLy.getTalkerUserName();
              if (this.HVq.VU()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.HVq.field_todoid, this.HVq.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(x.this.cLy.HZF.getContext())) {
            break label265;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(x.this.cLy.HZF.getContext()) - 16;
        }
        label265:
        for (;;)
        {
          locala.IUx = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(196486);
              paramAnonymousView.setBackgroundResource(2131231662);
              AppMethodBeat.o(196486);
            }
          };
          locala.JiQ = paramAnonymousView;
          locala.ej(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(2131231664);
          paramAnonymousView = x.this.cLy.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.a)localObject).VU()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.a)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.a)localObject).field_username);
            AppMethodBeat.o(196488);
            return true;
          }
        }
      }
      
      public final boolean aC(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(196489);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.a))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.a)paramAnonymousView;
          boolean bool = y.c(paramAnonymousView);
          ac.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
            str1 = x.this.cLy.getTalkerUserName();
            String str2 = paramAnonymousView.field_creator;
            String str3 = paramAnonymousView.field_todoid;
            crg localcrg = y.d(paramAnonymousView);
            g.agi().a(new t(str1, str2, str3, localcrg), 0);
            x.d(x.this, paramAnonymousView);
            x.b(x.this).cl(paramAnonymousInt);
            x.c(x.this);
          }
          String str1 = x.this.cLy.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.VU()) {
            paramAnonymousInt = 1;
          }
          z.a(str1, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
          AppMethodBeat.o(196489);
          return true;
        }
        if (paramAnonymousView == null) {}
        for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
        {
          ac.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", new Object[] { paramAnonymousView });
          break;
        }
      }
    };
    AppMethodBeat.o(184990);
  }
  
  private void a(com.tencent.mm.chatroom.storage.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(185872);
    if (!y.e(parama))
    {
      AppMethodBeat.o(185872);
      return;
    }
    if (this.HVf.contains(parama))
    {
      if (paramBoolean)
      {
        if (this.HVf.indexOf(parama) != -1) {
          this.HVh.add(new f(parama, this.HVf.indexOf(parama) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(parama);
      if (i != -1) {
        this.HVe.ao(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (parama != null)
    {
      this.HVf.add(0, parama);
      this.HVg.put(parama.field_todoid, parama);
      this.HVe.ck(0);
    }
    if (this.HVf.size() > 20) {
      h.JZN.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196480);
          int i = x.g(x.this).size() - 1;
          while (i >= 20)
          {
            com.tencent.mm.chatroom.storage.a locala = (com.tencent.mm.chatroom.storage.a)x.g(x.this).remove(i);
            if (locala != null) {
              x.h(x.this).remove(locala);
            }
            i -= 1;
          }
          x.b(x.this).ar(20, x.g(x.this).size() - 20);
          AppMethodBeat.o(196480);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private void cL()
  {
    AppMethodBeat.i(184997);
    if (this.ijA != null) {
      if (this.HVf.size() == 0)
      {
        this.ijA.setVisibility(8);
        if (this.DuP != null)
        {
          this.DuP.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.HVi)
      {
        this.ijA.setVisibility(0);
        if (this.DuP != null) {
          this.DuP.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  private boolean fnt()
  {
    AppMethodBeat.i(184995);
    boolean bool = w.wp(this.cLy.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void fnu()
  {
    AppMethodBeat.i(184996);
    com.tencent.mm.storage.ap localap = ((k)g.ab(k.class)).awG().aNI(this.cLy.getTalkerUserName());
    if ((localap != null) && (localap.field_hasTodo == 1))
    {
      localap.ka(0);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(localap, localap.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void fnv()
  {
    AppMethodBeat.i(185873);
    this.HVf.clear();
    this.HVg.clear();
    AppMethodBeat.o(185873);
  }
  
  private int i(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(184998);
    if (parama != null)
    {
      if (this.HVf.contains(parama))
      {
        int i = this.HVf.indexOf(parama);
        this.HVf.remove(parama);
        this.HVg.remove(parama.field_todoid);
        AppMethodBeat.o(184998);
        return i;
      }
      ac.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
    }
    AppMethodBeat.o(184998);
    return -1;
  }
  
  private int j(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(184999);
    if (parama != null)
    {
      if (this.HVf.contains(parama))
      {
        int i = this.HVf.indexOf(parama);
        this.HVf.remove(i);
        this.HVf.add(0, parama);
        this.HVg.put(parama.field_todoid, parama);
        AppMethodBeat.o(184999);
        return i;
      }
      ac.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  public final void a(a parama)
  {
    this.DuP = parama;
  }
  
  public final int cSy()
  {
    AppMethodBeat.i(185871);
    if ((y.VM()) && (this.ijA != null) && (this.HVf.size() > 0))
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(this.cLy.HZF.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(184991);
    super.fgh();
    if (!y.VM())
    {
      AppMethodBeat.o(184991);
      return;
    }
    ac.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.ijA == null)
    {
      l1 = ce.azI();
      this.ijA = this.cLy.findViewById(2131298091);
      this.HVb = ((RecyclerView)this.ijA.findViewById(2131305972));
      this.HVc = ((ImageView)this.ijA.findViewById(2131305967));
      this.HVd = ((ImageView)this.ijA.findViewById(2131305971));
      this.HVb.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196479);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt1);
          localb.lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(196479);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(184966);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ac.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousRecyclerView.canScrollHorizontally(-1)) });
          if ((paramAnonymousInt == 0) && (!paramAnonymousRecyclerView.canScrollHorizontally(-1)))
          {
            x.d(x.this).setVisibility(8);
            x.e(x.this).setVisibility(8);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(184966);
            return;
            x.d(x.this).setVisibility(0);
            x.e(x.this).setVisibility(0);
          }
        }
      });
      this.cLy.HZF.getContext();
      this.fwy = new LinearLayoutManager();
      this.fwy.setOrientation(0);
      this.HVb.setLayoutManager(this.fwy);
      this.HVe = new e(this.cLy.HZF.getContext(), this.HVf, this.HVl);
      this.HVb.setAdapter(this.HVe);
      this.HVe.arg.notifyChanged();
      ac.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(ce.azI() - l1) });
    }
    long l1 = ce.azI();
    if (fnt())
    {
      this.ftb.alive();
      if (this.ijA != null)
      {
        fnv();
        Iterator localIterator = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().sa(this.cLy.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.a locala = (com.tencent.mm.chatroom.storage.a)localIterator.next();
          this.HVf.add(locala);
          this.HVg.put(locala.field_todoid, locala);
        }
        Collections.sort(this.HVf, new Comparator() {});
        this.HVe.arg.notifyChanged();
        cL();
      }
      fnu();
      h.JZN.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184967);
          ac.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume() batch delete expire data!!");
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().VV();
          AppMethodBeat.o(184967);
        }
      }, 30000L);
    }
    for (;;)
    {
      long l2 = ce.azI();
      ac.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.cLy.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      fnv();
      this.ijA.setVisibility(8);
    }
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(185867);
    super.fgj();
    ac.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.HVh.size() > 0)
    {
      Iterator localIterator = this.HVh.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.cZu == 1)
        {
          j(localf.HVB);
          this.HVe.ao(localf.ahV, localf.ahX);
        }
      }
      this.HVh.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(185868);
    super.fgk();
    ac.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(184992);
    super.fgm();
    if (!y.VM())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (fnt())
    {
      ac.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.ftb.dead();
      if (this.ijA != null) {
        this.ijA.setVisibility(8);
      }
      fnu();
    }
    ac.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
    AppMethodBeat.o(184992);
  }
  
  public final void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!y.VM())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!fnt())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.HVi = true;
    if (this.ijA.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.HVf.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.HVk == null)
    {
      this.HVk = ObjectAnimator.ofFloat(this.ijA, "alpha", new float[] { 0.0F, 1.0F });
      this.HVk.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(184969);
          if (x.f(x.this) != null) {
            x.f(x.this).setVisibility(0);
          }
          AppMethodBeat.o(184969);
        }
      });
    }
    if (paramBoolean) {
      this.HVk.setDuration(100L);
    }
    for (;;)
    {
      this.HVk.start();
      AppMethodBeat.o(185870);
      return;
      this.HVk.setDuration(200L);
    }
  }
  
  public final void xj(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!y.VM())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!fnt())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.HVi = false;
    if (this.ijA.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.HVj == null)
    {
      this.HVj = ObjectAnimator.ofFloat(this.ijA, "alpha", new float[] { 1.0F, 0.0F });
      this.HVj.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(184968);
          if (x.f(x.this) != null) {
            x.f(x.this).setVisibility(4);
          }
          AppMethodBeat.o(184968);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.HVj.setDuration(100L);
    }
    for (;;)
    {
      this.HVj.start();
      AppMethodBeat.o(185869);
      return;
      this.HVj.setDuration(200L);
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
    
    public abstract boolean aB(View paramView, int paramInt);
    
    public abstract boolean aC(View paramView, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract int cSy();
    
    public abstract void xi(boolean paramBoolean);
    
    public abstract void xj(boolean paramBoolean);
  }
  
  static final class d
    extends RecyclerView.w
  {
    static final com.tencent.mm.av.a.a.c fvC;
    RelativeLayout HVs;
    TextView HVt;
    RelativeLayout HVu;
    RelativeLayout HVv;
    TextView HVw;
    ImageView fBA;
    View fvu;
    
    static
    {
      AppMethodBeat.i(184981);
      c.a locala1 = new c.a();
      locala1.hKI = 2131689599;
      c.a locala2 = locala1.de(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20));
      locala2.gLt = true;
      locala2.hKx = true;
      locala2.hKv = true;
      fvC = locala1.aFT();
      AppMethodBeat.o(184981);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(184980);
      this.fvu = paramView;
      this.HVs = ((RelativeLayout)paramView.findViewById(2131305960));
      this.fBA = ((ImageView)paramView.findViewById(2131305964));
      this.HVt = ((TextView)paramView.findViewById(2131305974));
      this.HVu = ((RelativeLayout)paramView.findViewById(2131305962));
      this.HVv = ((RelativeLayout)paramView.findViewById(2131305968));
      this.HVw = ((TextView)paramView.findViewById(2131305970));
      AppMethodBeat.o(184980);
    }
  }
  
  static final class e
    extends RecyclerView.a
  {
    private x.b HVl;
    private List<com.tencent.mm.chatroom.storage.a> HVx;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.a> paramList, x.b paramb)
    {
      this.context = paramContext;
      this.HVx = paramList;
      this.HVl = paramb;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(184987);
      paramViewGroup = new x.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493401, paramViewGroup, false));
      AppMethodBeat.o(184987);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(184988);
      final x.d locald;
      final com.tencent.mm.chatroom.storage.a locala;
      if ((this.HVx != null) && (paramInt >= 0) && (paramInt < this.HVx.size()))
      {
        locald = (x.d)paramw;
        locala = (com.tencent.mm.chatroom.storage.a)this.HVx.get(paramInt);
        ac.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.fvu.setVisibility(0);
        if (!locala.VU()) {
          break label263;
        }
        locald.fBA.setImageResource(2131231596);
        locald.HVt.setText(bs.bG(locala.field_title, this.context.getString(2131757057)));
        if (paramInt != 0) {
          break label406;
        }
        paramw = (RelativeLayout.LayoutParams)locald.HVs.getLayoutParams();
        if (paramw.leftMargin == 0)
        {
          paramw.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 2);
          locald.HVs.setLayoutParams(paramw);
        }
        label158:
        if (locala.field_state != 0) {
          break label452;
        }
        locald.HVu.setVisibility(8);
        if (locala.field_nreply <= 0) {
          break label440;
        }
        locald.HVv.setVisibility(0);
        locald.HVw.setText(locala.field_nreply);
      }
      for (;;)
      {
        locald.HVs.setTag(locala);
        locald.HVs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            if (x.e.a(x.e.this) != null) {
              x.e.a(x.e.this).M(paramAnonymousView, locald.lv());
            }
            AppMethodBeat.o(184985);
          }
        });
        locald.HVs.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            if (x.e.a(x.e.this) != null)
            {
              boolean bool = x.e.a(x.e.this).aB(paramAnonymousView, locald.lv());
              AppMethodBeat.o(184986);
              return bool;
            }
            AppMethodBeat.o(184986);
            return false;
          }
        });
        AppMethodBeat.o(184988);
        return;
        label263:
        WxaAttributes localWxaAttributes = ((m)g.ab(m.class)).Ka(locala.field_username);
        if (localWxaAttributes == null)
        {
          ((m)g.ab(m.class)).a(locala.field_username, new m.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.av.a.a locala = o.aFB();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, x.e.1.this.HVy.fBA, x.d.fvC);
                    if ((bs.isNullOrNil(x.e.1.this.HVq.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      x.e.1.this.HVy.HVt.setText(paramAnonymousWxaAttributes.field_nickname);
                    }
                    AppMethodBeat.o(184982);
                    return;
                  }
                }
              });
              AppMethodBeat.o(184983);
            }
          });
          if (bs.isNullOrNil(locala.field_title)) {
            break;
          }
          locald.HVt.setText(bs.bG(locala.field_title, ""));
          break;
        }
        com.tencent.mm.av.a.a locala1 = o.aFB();
        if (localWxaAttributes != null) {}
        for (paramw = localWxaAttributes.field_smallHeadURL;; paramw = "")
        {
          locala1.a(paramw, locald.fBA, x.d.fvC);
          locald.HVt.setText(bs.bG(locala.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label406:
        paramw = (RelativeLayout.LayoutParams)locald.HVs.getLayoutParams();
        if (paramw.leftMargin == 0) {
          break label158;
        }
        paramw.leftMargin = 0;
        locald.HVs.setLayoutParams(paramw);
        break label158;
        label440:
        locald.HVv.setVisibility(8);
        continue;
        label452:
        if (locala.field_state == 1)
        {
          locald.HVu.setVisibility(0);
          locald.HVv.setVisibility(8);
          locald.HVu.setTag(locala);
          locald.HVu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              if (x.e.a(x.e.this) != null) {
                x.e.a(x.e.this).aC(paramAnonymousView, locald.lv());
              }
              AppMethodBeat.o(184984);
            }
          });
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(184989);
      int i = this.HVx.size();
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
    public com.tencent.mm.chatroom.storage.a HVB;
    public int ahV;
    public int ahX;
    public int cZu = 0;
    
    public f(com.tencent.mm.chatroom.storage.a parama, int paramInt)
    {
      this.HVB = parama;
      this.cZu = 1;
      this.ahV = 0;
      this.ahX = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.x
 * JD-Core Version:    0.7.0.1
 */