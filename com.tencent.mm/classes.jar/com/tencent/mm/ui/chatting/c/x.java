package com.tencent.mm.ui.chatting.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=u.class)
public class x
  extends a
  implements u
{
  private a Ccx;
  private RecyclerView Gvk;
  private ImageView Gvl;
  private ImageView Gvm;
  private x.e Gvn;
  private List<com.tencent.mm.chatroom.storage.a> Gvo;
  private HashMap<String, com.tencent.mm.chatroom.storage.a> Gvp;
  private ArrayList<f> Gvq;
  private boolean Gvr;
  private ObjectAnimator Gvs;
  private ObjectAnimator Gvt;
  private x.b Gvu;
  private com.tencent.mm.sdk.b.c<mk> fpz;
  private LinearLayoutManager fsR;
  private View hIZ;
  
  public x()
  {
    AppMethodBeat.i(184990);
    this.Gvo = new ArrayList();
    this.Gvp = new HashMap();
    this.Ccx = null;
    this.Gvq = new ArrayList();
    this.Gvr = true;
    this.Gvs = null;
    this.Gvt = null;
    this.fpz = new com.tencent.mm.sdk.b.c() {};
    this.Gvu = new x.b()
    {
      public final void M(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(191529);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.a))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.a)paramAnonymousView;
          if (paramAnonymousView.UY())
          {
            y.f(x.this.cOd.GzJ.getContext(), paramAnonymousView.field_roomname, false);
            localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ac(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = y.e((com.tencent.mm.chatroom.storage.a)localObject);
            if (localObject == null) {
              break label329;
            }
            bool2 = y.b((com.tencent.mm.chatroom.storage.a)localObject);
            bool1 = bool2;
            if (bool2) {
              aq.n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(191523);
                  x.a(x.this).add(new x.f(this.Gvw, paramAnonymousInt + 1));
                  AppMethodBeat.o(191523);
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
          String str = x.this.cOd.getTalkerUserName();
          if (paramAnonymousView.UY())
          {
            paramAnonymousInt = 1;
            z.a(str, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject != null) {
              break label281;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.a)localObject).field_todoid)
          {
            ad.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(191529);
            return;
            localObject = new f();
            ((f)localObject).username = paramAnonymousView.field_username;
            ((f)localObject).iJb = paramAnonymousView.field_path;
            ((f)localObject).scene = 1160;
            ((f)localObject).iJl = paramAnonymousView.field_roomname;
            ((n)g.ab(n.class)).a(x.this.cOd.GzJ.getContext(), (f)localObject);
            break;
            paramAnonymousInt = 0;
            break label142;
          }
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
          {
            ad.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", new Object[] { paramAnonymousView });
            AppMethodBeat.o(191529);
            return;
          }
        }
      }
      
      public final boolean aA(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(191531);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.a))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.a)paramAnonymousView;
          boolean bool = y.c(paramAnonymousView);
          ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
            str1 = x.this.cOd.getTalkerUserName();
            String str2 = paramAnonymousView.field_creator;
            String str3 = paramAnonymousView.field_todoid;
            clz localclz = y.d(paramAnonymousView);
            g.aeS().a(new t(str1, str2, str3, localclz), 0);
            x.d(x.this, paramAnonymousView);
            x.b(x.this).cm(paramAnonymousInt);
            x.c(x.this);
          }
          String str1 = x.this.cOd.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.UY()) {
            paramAnonymousInt = 1;
          }
          z.a(str1, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
          AppMethodBeat.o(191531);
          return true;
        }
        if (paramAnonymousView == null) {}
        for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
        {
          ad.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", new Object[] { paramAnonymousView });
          break;
        }
      }
      
      public final boolean az(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(191530);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.a))
        {
          localObject = (com.tencent.mm.chatroom.storage.a)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(x.this.cOd.GzJ.getContext(), paramAnonymousView);
          locala.HIv = true;
          locala.HIw = true;
          locala.HIx = true;
          locala.HIu = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(191524);
              paramAnonymous2ContextMenu.clear();
              if (w.sr(x.this.cOd.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, x.this.cOd.GzJ.getContext().getResources().getString(2131757234));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, x.this.cOd.GzJ.getContext().getResources().getString(2131757058));
              AppMethodBeat.o(191524);
            }
          };
          locala.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(191527);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(191527);
                return;
              case 1: 
                paramAnonymous2MenuItem = x.this.cOd.GzJ.getContext();
                String str1 = x.this.cOd.getTalkerUserName();
                String str2 = this.Gvz.field_todoid;
                String str3 = this.Gvz.field_username;
                if (this.Gvz.UY()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void US()
                    {
                      AppMethodBeat.i(191525);
                      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(191525);
                    }
                    
                    public final void UT()
                    {
                      AppMethodBeat.i(191526);
                      Pair localPair = y.a(x.8.3.this.Gvz);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        x.d(x.this, x.8.3.this.Gvz);
                        x.b(x.this).cm(x.8.3.this.Gvx);
                        x.c(x.this);
                      }
                      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(191526);
                    }
                  });
                  AppMethodBeat.o(191527);
                  return;
                }
              }
              boolean bool = y.c(this.Gvz);
              ad.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.Gvz.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                x.d(x.this, this.Gvz);
                x.b(x.this).cm(paramAnonymousInt);
                x.c(x.this);
              }
              paramAnonymous2MenuItem = x.this.cOd.getTalkerUserName();
              if (this.Gvz.UY()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.Gvz.field_todoid, this.Gvz.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(x.this.cOd.GzJ.getContext())) {
            break label266;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(x.this.cOd.GzJ.getContext()) - 16;
        }
        label266:
        for (;;)
        {
          locala.Hua = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(191528);
              paramAnonymousView.setBackgroundResource(2131231662);
              AppMethodBeat.o(191528);
            }
          };
          locala.HIt = paramAnonymousView;
          locala.eh(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(2131231664);
          paramAnonymousView = x.this.cOd.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.a)localObject).UY()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.a)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.a)localObject).field_username);
            AppMethodBeat.o(191530);
            return true;
          }
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
    if (this.Gvo.contains(parama))
    {
      if (paramBoolean)
      {
        if (this.Gvo.indexOf(parama) != -1) {
          this.Gvq.add(new f(parama, this.Gvo.indexOf(parama) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(parama);
      if (i != -1) {
        this.Gvn.ao(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (parama != null)
    {
      this.Gvo.add(0, parama);
      this.Gvp.put(parama.field_todoid, parama);
      this.Gvn.cl(0);
    }
    if (this.Gvo.size() > 20) {
      h.Iye.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191522);
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
          AppMethodBeat.o(191522);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private void cE()
  {
    AppMethodBeat.i(184997);
    if (this.hIZ != null) {
      if (this.Gvo.size() == 0)
      {
        this.hIZ.setVisibility(8);
        if (this.Ccx != null)
        {
          this.Ccx.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.Gvr)
      {
        this.hIZ.setVisibility(0);
        if (this.Ccx != null) {
          this.Ccx.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  private boolean eXH()
  {
    AppMethodBeat.i(184995);
    boolean bool = w.sm(this.cOd.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void eXI()
  {
    AppMethodBeat.i(184996);
    am localam = ((k)g.ab(k.class)).apR().aIn(this.cOd.getTalkerUserName());
    if ((localam != null) && (localam.field_hasTodo == 1))
    {
      localam.kc(0);
      az.arV();
      com.tencent.mm.model.c.apR().a(localam, localam.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void eXJ()
  {
    AppMethodBeat.i(185873);
    this.Gvo.clear();
    this.Gvp.clear();
    AppMethodBeat.o(185873);
  }
  
  private int i(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(184998);
    if (parama != null)
    {
      if (this.Gvo.contains(parama))
      {
        int i = this.Gvo.indexOf(parama);
        this.Gvo.remove(parama);
        this.Gvp.remove(parama.field_todoid);
        AppMethodBeat.o(184998);
        return i;
      }
      ad.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
    }
    AppMethodBeat.o(184998);
    return -1;
  }
  
  private int j(com.tencent.mm.chatroom.storage.a parama)
  {
    AppMethodBeat.i(184999);
    if (parama != null)
    {
      if (this.Gvo.contains(parama))
      {
        int i = this.Gvo.indexOf(parama);
        this.Gvo.remove(i);
        this.Gvo.add(0, parama);
        this.Gvp.put(parama.field_todoid, parama);
        AppMethodBeat.o(184999);
        return i;
      }
      ad.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  public final void a(a parama)
  {
    this.Ccx = parama;
  }
  
  public final int cFo()
  {
    AppMethodBeat.i(185871);
    if ((y.UQ()) && (this.hIZ != null) && (this.Gvo.size() > 0))
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(this.cOd.GzJ.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(184991);
    super.eQB();
    if (!y.UQ())
    {
      AppMethodBeat.o(184991);
      return;
    }
    ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.hIZ == null)
    {
      l1 = ce.asR();
      this.hIZ = this.cOd.findViewById(2131298091);
      this.Gvk = ((RecyclerView)this.hIZ.findViewById(2131305972));
      this.Gvl = ((ImageView)this.hIZ.findViewById(2131305967));
      this.Gvm = ((ImageView)this.hIZ.findViewById(2131305971));
      this.Gvk.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(204954);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(204954);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(184966);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousRecyclerView.canScrollHorizontally(-1)) });
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
      this.cOd.GzJ.getContext();
      this.fsR = new LinearLayoutManager();
      this.fsR.setOrientation(0);
      this.Gvk.setLayoutManager(this.fsR);
      this.Gvn = new x.e(this.cOd.GzJ.getContext(), this.Gvo, this.Gvu);
      this.Gvk.setAdapter(this.Gvn);
      this.Gvn.aql.notifyChanged();
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(ce.asR() - l1) });
    }
    long l1 = ce.asR();
    if (eXH())
    {
      this.fpz.alive();
      if (this.hIZ != null)
      {
        eXJ();
        Iterator localIterator = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().oP(this.cOd.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.a locala = (com.tencent.mm.chatroom.storage.a)localIterator.next();
          this.Gvo.add(locala);
          this.Gvp.put(locala.field_todoid, locala);
        }
        Collections.sort(this.Gvo, new Comparator() {});
        this.Gvn.aql.notifyChanged();
        cE();
      }
      eXI();
      h.Iye.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184967);
          ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume() batch delete expire data!!");
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().UZ();
          AppMethodBeat.o(184967);
        }
      }, 30000L);
    }
    for (;;)
    {
      long l2 = ce.asR();
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.cOd.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      eXJ();
      this.hIZ.setVisibility(8);
    }
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(185867);
    super.eQD();
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.Gvq.size() > 0)
    {
      Iterator localIterator = this.Gvq.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.dbV == 1)
        {
          j(localf.GvK);
          this.Gvn.ao(localf.ahb, localf.ahd);
        }
      }
      this.Gvq.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(185868);
    super.eQE();
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void eQG()
  {
    AppMethodBeat.i(184992);
    super.eQG();
    if (!y.UQ())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (eXH())
    {
      ad.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.fpz.dead();
      if (this.hIZ != null) {
        this.hIZ.setVisibility(8);
      }
      eXI();
    }
    ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
    AppMethodBeat.o(184992);
  }
  
  public final void we(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!y.UQ())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!eXH())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.Gvr = true;
    if (this.hIZ.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.Gvo.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.Gvt == null)
    {
      this.Gvt = ObjectAnimator.ofFloat(this.hIZ, "alpha", new float[] { 0.0F, 1.0F });
      this.Gvt.addListener(new Animator.AnimatorListener()
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
      this.Gvt.setDuration(100L);
    }
    for (;;)
    {
      this.Gvt.start();
      AppMethodBeat.o(185870);
      return;
      this.Gvt.setDuration(200L);
    }
  }
  
  public final void wf(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!y.UQ())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!eXH())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.Gvr = false;
    if (this.hIZ.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.Gvs == null)
    {
      this.Gvs = ObjectAnimator.ofFloat(this.hIZ, "alpha", new float[] { 1.0F, 0.0F });
      this.Gvs.addListener(new Animator.AnimatorListener()
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
      this.Gvs.setDuration(100L);
    }
    for (;;)
    {
      this.Gvs.start();
      AppMethodBeat.o(185869);
      return;
      this.Gvs.setDuration(200L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hide();
    
    public abstract void show();
  }
  
  static final class f
  {
    public com.tencent.mm.chatroom.storage.a GvK;
    public int ahb;
    public int ahd;
    public int dbV = 0;
    
    public f(com.tencent.mm.chatroom.storage.a parama, int paramInt)
    {
      this.GvK = parama;
      this.dbV = 1;
      this.ahb = 0;
      this.ahd = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.x
 * JD-Core Version:    0.7.0.1
 */