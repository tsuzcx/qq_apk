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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=w.class)
public class z
  extends a
  implements w
{
  private a Fsw;
  private HashMap<String, com.tencent.mm.chatroom.storage.c> KeA;
  private ArrayList<f> KeB;
  private boolean KeC;
  private ObjectAnimator KeD;
  private ObjectAnimator KeE;
  private b KeF;
  private RecyclerView Kev;
  private ImageView Kew;
  private ImageView Kex;
  private e Key;
  private List<com.tencent.mm.chatroom.storage.c> Kez;
  private com.tencent.mm.sdk.b.c<nc> fNF;
  private LinearLayoutManager fRR;
  private View iFK;
  
  public z()
  {
    AppMethodBeat.i(184990);
    this.Kez = new ArrayList();
    this.KeA = new HashMap();
    this.Fsw = null;
    this.KeB = new ArrayList();
    this.KeC = true;
    this.KeD = null;
    this.KeE = null;
    this.fNF = new com.tencent.mm.sdk.b.c() {};
    this.KeF = new b()
    {
      public final void M(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184977);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          if (paramAnonymousView.Yy())
          {
            y.f(z.this.cXJ.Kkd.getContext(), paramAnonymousView.field_roomname, false);
            localObject = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().ag(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = y.e((com.tencent.mm.chatroom.storage.c)localObject);
            if (localObject == null) {
              break label347;
            }
            bool2 = y.b((com.tencent.mm.chatroom.storage.c)localObject);
            bool1 = bool2;
            if (bool2) {
              ar.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184971);
                  z.a(z.this).add(new z.f(this.KeH, paramAnonymousInt + 1));
                  AppMethodBeat.o(184971);
                }
              }, 300L);
            }
          }
        }
        label142:
        label299:
        label347:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          String str = z.this.cXJ.getTalkerUserName();
          if (paramAnonymousView.Yy())
          {
            paramAnonymousInt = 1;
            com.tencent.mm.chatroom.d.z.a(str, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject != null) {
              break label299;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid)
          {
            ae.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(184977);
            return;
            localObject = new f();
            ((f)localObject).username = paramAnonymousView.field_username;
            ((f)localObject).jFL = paramAnonymousView.field_path;
            ((f)localObject).scene = 1160;
            ((f)localObject).jFV = paramAnonymousView.field_roomname;
            ((f)localObject).cmw = paramAnonymousView.field_shareKey;
            ((f)localObject).cmv = paramAnonymousView.field_shareName;
            ((p)g.ab(p.class)).a(z.this.cXJ.Kkd.getContext(), (f)localObject);
            break;
            paramAnonymousInt = 0;
            break label142;
          }
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
          {
            ae.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", new Object[] { paramAnonymousView });
            AppMethodBeat.o(184977);
            return;
          }
        }
      }
      
      public final boolean aD(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184978);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.c))
        {
          localObject = (com.tencent.mm.chatroom.storage.c)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(z.this.cXJ.Kkd.getContext(), paramAnonymousView);
          locala.LwI = true;
          locala.LwK = true;
          locala.LwL = true;
          locala.LwG = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(184972);
              paramAnonymous2ContextMenu.clear();
              if (x.Aa(z.this.cXJ.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, z.this.cXJ.Kkd.getContext().getResources().getString(2131757234));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, z.this.cXJ.Kkd.getContext().getResources().getString(2131757058));
              AppMethodBeat.o(184972);
            }
          };
          locala.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(184975);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(184975);
                return;
              case 1: 
                paramAnonymous2MenuItem = z.this.cXJ.Kkd.getContext();
                String str1 = z.this.cXJ.getTalkerUserName();
                String str2 = this.KeK.field_todoid;
                String str3 = this.KeK.field_username;
                if (this.KeK.Yy()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void Yp()
                    {
                      AppMethodBeat.i(184973);
                      ae.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(184973);
                    }
                    
                    public final void Yq()
                    {
                      AppMethodBeat.i(184974);
                      Pair localPair = y.a(z.7.3.this.KeK);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        z.d(z.this, z.7.3.this.KeK);
                        z.b(z.this).cl(z.7.3.this.KeI);
                        z.c(z.this);
                      }
                      ae.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(184974);
                    }
                  });
                  AppMethodBeat.o(184975);
                  return;
                }
              }
              boolean bool = y.c(this.KeK);
              ae.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.KeK.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                z.d(z.this, this.KeK);
                z.b(z.this).cl(paramAnonymousInt);
                z.c(z.this);
              }
              paramAnonymous2MenuItem = z.this.cXJ.getTalkerUserName();
              if (this.KeK.Yy()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                com.tencent.mm.chatroom.d.z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.KeK.field_todoid, this.KeK.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(z.this.cXJ.Kkd.getContext())) {
            break label265;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(z.this.cXJ.Kkd.getContext()) - 16;
        }
        label265:
        for (;;)
        {
          locala.LhV = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(184976);
              paramAnonymousView.setBackgroundResource(2131231662);
              AppMethodBeat.o(184976);
            }
          };
          locala.LwF = paramAnonymousView;
          locala.el(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(2131231664);
          paramAnonymousView = z.this.cXJ.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.c)localObject).Yy()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            com.tencent.mm.chatroom.d.z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.c)localObject).field_username);
            AppMethodBeat.o(184978);
            return true;
          }
        }
      }
      
      public final boolean aE(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(184979);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          boolean bool = y.c(paramAnonymousView);
          ae.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getRoomTodoMsgService();
            str1 = z.this.cXJ.getTalkerUserName();
            String str2 = paramAnonymousView.field_creator;
            String str3 = paramAnonymousView.field_todoid;
            cxh localcxh = y.d(paramAnonymousView);
            g.ajj().a(new t(str1, str2, str3, localcxh), 0);
            z.d(z.this, paramAnonymousView);
            z.b(z.this).cl(paramAnonymousInt);
            z.c(z.this);
          }
          String str1 = z.this.cXJ.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.Yy()) {
            paramAnonymousInt = 1;
          }
          com.tencent.mm.chatroom.d.z.a(str1, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
          AppMethodBeat.o(184979);
          return true;
        }
        if (paramAnonymousView == null) {}
        for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
        {
          ae.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", new Object[] { paramAnonymousView });
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
    if (this.Kez.contains(paramc))
    {
      if (paramBoolean)
      {
        if (this.Kez.indexOf(paramc) != -1) {
          this.KeB.add(new f(paramc, this.Kez.indexOf(paramc) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(paramc);
      if (i != -1) {
        this.Key.ap(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (paramc != null)
    {
      this.Kez.add(0, paramc);
      this.KeA.put(paramc.field_todoid, paramc);
      this.Key.ck(0);
    }
    if (this.Kez.size() > 20) {
      h.MqF.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187342);
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
          AppMethodBeat.o(187342);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private boolean fHU()
  {
    AppMethodBeat.i(184995);
    boolean bool = x.zU(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void fHV()
  {
    AppMethodBeat.i(184996);
    au localau = ((l)g.ab(l.class)).azL().aVa(this.cXJ.getTalkerUserName());
    if ((localau != null) && (localau.field_hasTodo == 1))
    {
      localau.kA(0);
      bc.aCg();
      com.tencent.mm.model.c.azL().a(localau, localau.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void fHW()
  {
    AppMethodBeat.i(185873);
    this.Kez.clear();
    this.KeA.clear();
    AppMethodBeat.o(185873);
  }
  
  private int i(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184998);
    if (paramc != null)
    {
      if (this.Kez.contains(paramc))
      {
        int i = this.Kez.indexOf(paramc);
        this.Kez.remove(paramc);
        this.KeA.remove(paramc.field_todoid);
        AppMethodBeat.o(184998);
        return i;
      }
      ae.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
    }
    AppMethodBeat.o(184998);
    return -1;
  }
  
  private int j(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184999);
    if (paramc != null)
    {
      if (this.Kez.contains(paramc))
      {
        int i = this.Kez.indexOf(paramc);
        this.Kez.remove(i);
        this.Kez.add(0, paramc);
        this.KeA.put(paramc.field_todoid, paramc);
        AppMethodBeat.o(184999);
        return i;
      }
      ae.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(184997);
    if (this.iFK != null) {
      if (this.Kez.size() == 0)
      {
        this.iFK.setVisibility(8);
        if (this.Fsw != null)
        {
          this.Fsw.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.KeC)
      {
        this.iFK.setVisibility(0);
        if (this.Fsw != null) {
          this.Fsw.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  public final void a(a parama)
  {
    this.Fsw = parama;
  }
  
  public final int dew()
  {
    AppMethodBeat.i(185871);
    if ((y.Yn()) && (this.iFK != null) && (this.Kez.size() > 0))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this.cXJ.Kkd.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(184991);
    super.fAt();
    if (!y.Yn())
    {
      AppMethodBeat.o(184991);
      return;
    }
    ae.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.iFK == null)
    {
      l1 = ch.aDb();
      this.iFK = this.cXJ.findViewById(2131298091);
      this.Kev = ((RecyclerView)this.iFK.findViewById(2131305972));
      this.Kew = ((ImageView)this.iFK.findViewById(2131305967));
      this.Kex = ((ImageView)this.iFK.findViewById(2131305971));
      this.Kev.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(187338);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(187338);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(184966);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          ae.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousRecyclerView.canScrollHorizontally(-1)) });
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
      this.cXJ.Kkd.getContext();
      this.fRR = new LinearLayoutManager();
      this.fRR.setOrientation(0);
      this.Kev.setLayoutManager(this.fRR);
      this.Key = new e(this.cXJ.Kkd.getContext(), this.Kez, this.KeF);
      this.Kev.setAdapter(this.Key);
      this.Key.asY.notifyChanged();
      ae.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(ch.aDb() - l1) });
    }
    long l1 = ch.aDb();
    if (fHU())
    {
      this.fNF.alive();
      if (this.iFK != null)
      {
        fHW();
        Iterator localIterator = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupTodoStorage().vl(this.cXJ.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)localIterator.next();
          this.Kez.add(localc);
          this.KeA.put(localc.field_todoid, localc);
        }
        Collections.sort(this.Kez, new Comparator() {});
        this.Key.asY.notifyChanged();
        updateView();
      }
      fHV();
    }
    for (;;)
    {
      long l2 = ch.aDb();
      ae.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.cXJ.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      fHW();
      this.iFK.setVisibility(8);
    }
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(185867);
    super.fAv();
    ae.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.KeB.size() > 0)
    {
      Iterator localIterator = this.KeB.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.dlO == 1)
        {
          j(localf.KeV);
          this.Key.ap(localf.ajM, localf.ajO);
        }
      }
      this.KeB.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(185868);
    super.fAw();
    ae.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(184992);
    super.fAy();
    if (!y.Yn())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (fHU())
    {
      ae.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.fNF.dead();
      if (this.iFK != null) {
        this.iFK.setVisibility(8);
      }
      fHV();
    }
    ae.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
    AppMethodBeat.o(184992);
  }
  
  public final void ya(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!y.Yn())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!fHU())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.KeC = true;
    if (this.iFK.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.Kez.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.KeE == null)
    {
      this.KeE = ObjectAnimator.ofFloat(this.iFK, "alpha", new float[] { 0.0F, 1.0F });
      this.KeE.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(184968);
          AppMethodBeat.o(184968);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(187340);
          if (z.f(z.this) != null) {
            z.f(z.this).setVisibility(0);
          }
          AppMethodBeat.o(187340);
        }
      });
    }
    if (paramBoolean) {
      this.KeE.setDuration(100L);
    }
    for (;;)
    {
      this.KeE.start();
      AppMethodBeat.o(185870);
      return;
      this.KeE.setDuration(200L);
    }
  }
  
  public final void yb(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!y.Yn())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!fHU())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.KeC = false;
    if (this.iFK.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.KeD == null)
    {
      this.KeD = ObjectAnimator.ofFloat(this.iFK, "alpha", new float[] { 1.0F, 0.0F });
      this.KeD.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(187339);
          if (z.f(z.this) != null) {
            z.f(z.this).setVisibility(4);
          }
          AppMethodBeat.o(187339);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.KeD.setDuration(100L);
    }
    for (;;)
    {
      this.KeD.start();
      AppMethodBeat.o(185869);
      return;
      this.KeD.setDuration(200L);
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
    public abstract int dew();
    
    public abstract void ya(boolean paramBoolean);
    
    public abstract void yb(boolean paramBoolean);
  }
  
  static final class d
    extends RecyclerView.w
  {
    static final com.tencent.mm.av.a.a.c fQP;
    RelativeLayout KeM;
    TextView KeN;
    RelativeLayout KeO;
    RelativeLayout KeP;
    TextView KeQ;
    View fQH;
    ImageView fWT;
    
    static
    {
      AppMethodBeat.i(184981);
      c.a locala1 = new c.a();
      locala1.igv = 2131689599;
      c.a locala2 = locala1.dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20));
      locala2.hhW = true;
      locala2.igk = true;
      locala2.igi = true;
      fQP = locala1.aJu();
      AppMethodBeat.o(184981);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(184980);
      this.fQH = paramView;
      this.KeM = ((RelativeLayout)paramView.findViewById(2131305960));
      this.fWT = ((ImageView)paramView.findViewById(2131305964));
      this.KeN = ((TextView)paramView.findViewById(2131305974));
      this.KeO = ((RelativeLayout)paramView.findViewById(2131305962));
      this.KeP = ((RelativeLayout)paramView.findViewById(2131305968));
      this.KeQ = ((TextView)paramView.findViewById(2131305970));
      AppMethodBeat.o(184980);
    }
  }
  
  static final class e
    extends RecyclerView.a
  {
    private z.b KeF;
    private List<com.tencent.mm.chatroom.storage.c> KeR;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.c> paramList, z.b paramb)
    {
      this.context = paramContext;
      this.KeR = paramList;
      this.KeF = paramb;
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
      if ((this.KeR != null) && (paramInt >= 0) && (paramInt < this.KeR.size()))
      {
        locald = (z.d)paramw;
        localc = (com.tencent.mm.chatroom.storage.c)this.KeR.get(paramInt);
        ae.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.fQH.setVisibility(0);
        if (!localc.Yy()) {
          break label263;
        }
        locald.fWT.setImageResource(2131231596);
        locald.KeN.setText(bu.bI(localc.field_title, this.context.getString(2131757057)));
        if (paramInt != 0) {
          break label406;
        }
        paramw = (RelativeLayout.LayoutParams)locald.KeM.getLayoutParams();
        if (paramw.leftMargin == 0)
        {
          paramw.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
          locald.KeM.setLayoutParams(paramw);
        }
        label158:
        if (localc.field_state != 0) {
          break label452;
        }
        locald.KeO.setVisibility(8);
        if (localc.field_nreply <= 0) {
          break label440;
        }
        locald.KeP.setVisibility(0);
        locald.KeQ.setText(localc.field_nreply);
      }
      for (;;)
      {
        locald.KeM.setTag(localc);
        locald.KeM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (z.e.a(z.e.this) != null) {
              z.e.a(z.e.this).M(paramAnonymousView, locald.lN());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184985);
          }
        });
        locald.KeM.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
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
        WxaAttributes localWxaAttributes = ((o)g.ab(o.class)).Ob(localc.field_username);
        if (localWxaAttributes == null)
        {
          ((o)g.ab(o.class)).a(localc.field_username, new o.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.aJb();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, z.e.1.this.KeS.fWT, z.d.fQP);
                    if ((bu.isNullOrNil(z.e.1.this.KeK.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      z.e.1.this.KeS.KeN.setText(paramAnonymousWxaAttributes.field_nickname);
                    }
                    AppMethodBeat.o(184982);
                    return;
                  }
                }
              });
              AppMethodBeat.o(184983);
            }
          });
          if (bu.isNullOrNil(localc.field_title)) {
            break;
          }
          locald.KeN.setText(bu.bI(localc.field_title, ""));
          break;
        }
        com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.aJb();
        if (localWxaAttributes != null) {}
        for (paramw = localWxaAttributes.field_smallHeadURL;; paramw = "")
        {
          locala.a(paramw, locald.fWT, z.d.fQP);
          locald.KeN.setText(bu.bI(localc.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label406:
        paramw = (RelativeLayout.LayoutParams)locald.KeM.getLayoutParams();
        if (paramw.leftMargin == 0) {
          break label158;
        }
        paramw.leftMargin = 0;
        locald.KeM.setLayoutParams(paramw);
        break label158;
        label440:
        locald.KeP.setVisibility(8);
        continue;
        label452:
        if (localc.field_state == 1)
        {
          locald.KeO.setVisibility(0);
          locald.KeP.setVisibility(8);
          locald.KeO.setTag(localc);
          locald.KeO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      int i = this.KeR.size();
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
    public com.tencent.mm.chatroom.storage.c KeV;
    public int ajM;
    public int ajO;
    public int dlO = 0;
    
    public f(com.tencent.mm.chatroom.storage.c paramc, int paramInt)
    {
      this.KeV = paramc;
      this.dlO = 1;
      this.ajM = 0;
      this.ajO = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.z
 * JD-Core Version:    0.7.0.1
 */