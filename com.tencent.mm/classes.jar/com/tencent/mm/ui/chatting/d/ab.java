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
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.y.class)
public class ab
  extends a
  implements com.tencent.mm.ui.chatting.d.b.y
{
  private a Kjq;
  private RecyclerView Pqm;
  private ImageView Pqn;
  private ImageView Pqo;
  private e Pqp;
  private List<com.tencent.mm.chatroom.storage.c> Pqq;
  private HashMap<String, com.tencent.mm.chatroom.storage.c> Pqr;
  private ArrayList<f> Pqs;
  private boolean Pqt;
  private ObjectAnimator Pqu;
  private ObjectAnimator Pqv;
  private b Pqw;
  private IListener<nt> gsQ;
  private LinearLayoutManager gxa;
  private View jBN;
  
  public ab()
  {
    AppMethodBeat.i(184990);
    this.Pqq = new ArrayList();
    this.Pqr = new HashMap();
    this.Kjq = null;
    this.Pqs = new ArrayList();
    this.Pqt = true;
    this.Pqu = null;
    this.Pqv = null;
    this.gsQ = new IListener() {};
    this.Pqw = new b()
    {
      public final void K(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184977);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          if (paramAnonymousView.aml())
          {
            com.tencent.mm.chatroom.d.y.f(ab.this.dom.Pwc.getContext(), paramAnonymousView.field_roomname, false);
            localObject = ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = com.tencent.mm.chatroom.d.y.e((com.tencent.mm.chatroom.storage.c)localObject);
            if (localObject == null) {
              break label347;
            }
            bool2 = com.tencent.mm.chatroom.d.y.b((com.tencent.mm.chatroom.storage.c)localObject);
            bool1 = bool2;
            if (bool2) {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184971);
                  ab.a(ab.this).add(new ab.f(this.Pqy, paramAnonymousInt + 1));
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
          String str = ab.this.dom.getTalkerUserName();
          if (paramAnonymousView.aml())
          {
            paramAnonymousInt = 1;
            z.a(str, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject != null) {
              break label299;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid)
          {
            Log.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(184977);
            return;
            localObject = new com.tencent.mm.plugin.appbrand.api.g();
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).username = paramAnonymousView.field_username;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHw = paramAnonymousView.field_path;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).scene = 1160;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHG = paramAnonymousView.field_roomname;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).cyr = paramAnonymousView.field_shareKey;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).cyq = paramAnonymousView.field_shareName;
            ((r)com.tencent.mm.kernel.g.af(r.class)).a(ab.this.dom.Pwc.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject);
            break;
            paramAnonymousInt = 0;
            break label142;
          }
          if (paramAnonymousView == null) {}
          for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
          {
            Log.e("MicroMsg.roomTodo.GroupTodoComponent", "onClick %s", new Object[] { paramAnonymousView });
            AppMethodBeat.o(184977);
            return;
          }
        }
      }
      
      public final boolean aI(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184978);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.c))
        {
          localObject = (com.tencent.mm.chatroom.storage.c)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(ab.this.dom.Pwc.getContext(), paramAnonymousView);
          locala.QSu = true;
          locala.QSw = true;
          locala.QSx = true;
          locala.QSs = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(184972);
              paramAnonymous2ContextMenu.clear();
              if (com.tencent.mm.model.ab.IE(ab.this.dom.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, ab.this.dom.Pwc.getContext().getResources().getString(2131757446));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, ab.this.dom.Pwc.getContext().getResources().getString(2131757255));
              AppMethodBeat.o(184972);
            }
          };
          locala.HLY = new o.g()
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
                paramAnonymous2MenuItem = ab.this.dom.Pwc.getContext();
                String str1 = ab.this.dom.getTalkerUserName();
                String str2 = this.PqB.field_todoid;
                String str3 = this.PqB.field_username;
                if (this.PqB.aml()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  com.tencent.mm.chatroom.d.y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void amc()
                    {
                      AppMethodBeat.i(184973);
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(184973);
                    }
                    
                    public final void amd()
                    {
                      AppMethodBeat.i(184974);
                      Pair localPair = com.tencent.mm.chatroom.d.y.a(ab.7.3.this.PqB);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        ab.d(ab.this, ab.7.3.this.PqB);
                        ab.b(ab.this).ck(ab.7.3.this.Pqz);
                        ab.c(ab.this);
                      }
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(184974);
                    }
                  });
                  AppMethodBeat.o(184975);
                  return;
                }
              }
              boolean bool = com.tencent.mm.chatroom.d.y.c(this.PqB);
              Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.PqB.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                ab.d(ab.this, this.PqB);
                ab.b(ab.this).ck(paramAnonymousInt);
                ab.c(ab.this);
              }
              paramAnonymous2MenuItem = ab.this.dom.getTalkerUserName();
              if (this.PqB.aml()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.PqB.field_todoid, this.PqB.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(ab.this.dom.Pwc.getContext())) {
            break label266;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(ab.this.dom.Pwc.getContext()) - 16;
        }
        label266:
        for (;;)
        {
          locala.QwU = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(184976);
              paramAnonymousView.setBackgroundResource(2131231728);
              AppMethodBeat.o(184976);
            }
          };
          locala.QSr = paramAnonymousView;
          locala.ez(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(2131231730);
          paramAnonymousView = ab.this.dom.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.c)localObject).aml()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.c)localObject).field_username);
            AppMethodBeat.o(184978);
            return true;
          }
        }
      }
      
      public final boolean aJ(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(184979);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          boolean bool = com.tencent.mm.chatroom.d.y.c(paramAnonymousView);
          Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getRoomTodoMsgService();
            str1 = ab.this.dom.getTalkerUserName();
            String str2 = paramAnonymousView.field_creator;
            String str3 = paramAnonymousView.field_todoid;
            dqb localdqb = com.tencent.mm.chatroom.d.y.d(paramAnonymousView);
            com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.chatroom.d.t(str1, str2, str3, localdqb), 0);
            ab.d(ab.this, paramAnonymousView);
            ab.b(ab.this).ck(paramAnonymousInt);
            ab.c(ab.this);
          }
          String str1 = ab.this.dom.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.aml()) {
            paramAnonymousInt = 1;
          }
          z.a(str1, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
          AppMethodBeat.o(184979);
          return true;
        }
        if (paramAnonymousView == null) {}
        for (paramAnonymousView = "null";; paramAnonymousView = paramAnonymousView.getClass().getSimpleName())
        {
          Log.e("MicroMsg.roomTodo.GroupTodoComponent", "onFinish %s", new Object[] { paramAnonymousView });
          break;
        }
      }
    };
    AppMethodBeat.o(184990);
  }
  
  private void a(com.tencent.mm.chatroom.storage.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(185872);
    if (!com.tencent.mm.chatroom.d.y.e(paramc))
    {
      AppMethodBeat.o(185872);
      return;
    }
    if (this.Pqq.contains(paramc))
    {
      if (paramBoolean)
      {
        if (this.Pqq.indexOf(paramc) != -1) {
          this.Pqs.add(new f(paramc, this.Pqq.indexOf(paramc) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(paramc);
      if (i != -1) {
        this.Pqp.aq(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (paramc != null)
    {
      this.Pqq.add(0, paramc);
      this.Pqr.put(paramc.field_todoid, paramc);
      this.Pqp.cj(0);
    }
    if (this.Pqq.size() > 20) {
      h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233112);
          int i = ab.g(ab.this).size() - 1;
          while (i >= 20)
          {
            com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)ab.g(ab.this).remove(i);
            if (localc != null) {
              ab.h(ab.this).remove(localc);
            }
            i -= 1;
          }
          ab.b(ab.this).at(20, ab.g(ab.this).size() - 20);
          AppMethodBeat.o(233112);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private boolean gQd()
  {
    AppMethodBeat.i(184995);
    boolean bool = com.tencent.mm.model.ab.Ix(this.dom.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void gQe()
  {
    AppMethodBeat.i(184996);
    az localaz = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(this.dom.getTalkerUserName());
    if ((localaz != null) && (localaz.field_hasTodo == 1))
    {
      localaz.nC(0);
      bg.aVF();
      com.tencent.mm.model.c.aST().a(localaz, localaz.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void gQf()
  {
    AppMethodBeat.i(185873);
    this.Pqq.clear();
    this.Pqr.clear();
    AppMethodBeat.o(185873);
  }
  
  private int i(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184998);
    if (paramc != null)
    {
      if (this.Pqq.contains(paramc))
      {
        int i = this.Pqq.indexOf(paramc);
        this.Pqq.remove(paramc);
        this.Pqr.remove(paramc.field_todoid);
        AppMethodBeat.o(184998);
        return i;
      }
      Log.e("MicroMsg.roomTodo.GroupTodoComponent", "removeTodoItemList todo no exist???");
    }
    AppMethodBeat.o(184998);
    return -1;
  }
  
  private int j(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184999);
    if (paramc != null)
    {
      if (this.Pqq.contains(paramc))
      {
        int i = this.Pqq.indexOf(paramc);
        this.Pqq.remove(i);
        this.Pqq.add(0, paramc);
        this.Pqr.put(paramc.field_todoid, paramc);
        AppMethodBeat.o(184999);
        return i;
      }
      Log.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  private void updateView()
  {
    AppMethodBeat.i(184997);
    if (this.jBN != null) {
      if (this.Pqq.size() == 0)
      {
        this.jBN.setVisibility(8);
        if (this.Kjq != null)
        {
          this.Kjq.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.Pqt)
      {
        this.jBN.setVisibility(0);
        if (this.Kjq != null) {
          this.Kjq.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  public final void BP(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!com.tencent.mm.chatroom.d.y.ama())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!gQd())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.Pqt = true;
    if (this.jBN.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.Pqq.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.Pqv == null)
    {
      this.Pqv = ObjectAnimator.ofFloat(this.jBN, "alpha", new float[] { 0.0F, 1.0F });
      this.Pqv.addListener(new Animator.AnimatorListener()
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
          AppMethodBeat.i(233110);
          if (ab.f(ab.this) != null) {
            ab.f(ab.this).setVisibility(0);
          }
          AppMethodBeat.o(233110);
        }
      });
    }
    if (paramBoolean) {
      this.Pqv.setDuration(100L);
    }
    for (;;)
    {
      this.Pqv.start();
      AppMethodBeat.o(185870);
      return;
      this.Pqv.setDuration(200L);
    }
  }
  
  public final void BQ(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!com.tencent.mm.chatroom.d.y.ama())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!gQd())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.Pqt = false;
    if (this.jBN.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.Pqu == null)
    {
      this.Pqu = ObjectAnimator.ofFloat(this.jBN, "alpha", new float[] { 1.0F, 0.0F });
      this.Pqu.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(233109);
          if (ab.f(ab.this) != null) {
            ab.f(ab.this).setVisibility(4);
          }
          AppMethodBeat.o(233109);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.Pqu.setDuration(100L);
    }
    for (;;)
    {
      this.Pqu.start();
      AppMethodBeat.o(185869);
      return;
      this.Pqu.setDuration(200L);
    }
  }
  
  public final void a(a parama)
  {
    this.Kjq = parama;
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(185867);
    super.cFx();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.Pqs.size() > 0)
    {
      Iterator localIterator = this.Pqs.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.dDe == 1)
        {
          j(localf.PqM);
          this.Pqp.aq(localf.ajZ, localf.akb);
        }
      }
      this.Pqs.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(185868);
    super.cFy();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final int dYg()
  {
    AppMethodBeat.i(185871);
    if ((com.tencent.mm.chatroom.d.y.ama()) && (this.jBN != null) && (this.Pqq.size() > 0))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this.dom.Pwc.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(184991);
    super.gIl();
    if (!com.tencent.mm.chatroom.d.y.ama())
    {
      AppMethodBeat.o(184991);
      return;
    }
    Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.jBN == null)
    {
      l1 = cl.aWz();
      this.jBN = this.dom.findViewById(2131298435);
      this.Pqm = ((RecyclerView)this.jBN.findViewById(2131309276));
      this.Pqn = ((ImageView)this.jBN.findViewById(2131309271));
      this.Pqo = ((ImageView)this.jBN.findViewById(2131309275));
      this.Pqm.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(184966);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousRecyclerView.canScrollHorizontally(-1)) });
          if ((paramAnonymousInt == 0) && (!paramAnonymousRecyclerView.canScrollHorizontally(-1)))
          {
            ab.d(ab.this).setVisibility(8);
            ab.e(ab.this).setVisibility(8);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(184966);
            return;
            ab.d(ab.this).setVisibility(0);
            ab.e(ab.this).setVisibility(0);
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(233108);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(233108);
        }
      });
      this.dom.Pwc.getContext();
      this.gxa = new LinearLayoutManager();
      this.gxa.setOrientation(0);
      this.Pqm.setLayoutManager(this.gxa);
      this.Pqp = new e(this.dom.Pwc.getContext(), this.Pqq, this.Pqw);
      this.Pqm.setAdapter(this.Pqp);
      this.Pqp.atj.notifyChanged();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(cl.aWz() - l1) });
    }
    long l1 = cl.aWz();
    if (gQd())
    {
      this.gsQ.alive();
      if (this.jBN != null)
      {
        gQf();
        Iterator localIterator = ((PluginChatroomUI)com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DC(this.dom.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)localIterator.next();
          this.Pqq.add(localc);
          this.Pqr.put(localc.field_todoid, localc);
        }
        Collections.sort(this.Pqq, new Comparator() {});
        this.Pqp.atj.notifyChanged();
        updateView();
      }
      gQe();
    }
    for (;;)
    {
      long l2 = cl.aWz();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.dom.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      gQf();
      this.jBN.setVisibility(8);
    }
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(184992);
    super.gIo();
    if (!com.tencent.mm.chatroom.d.y.ama())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (gQd())
    {
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.gsQ.dead();
      if (this.jBN != null) {
        this.jBN.setVisibility(8);
      }
      gQe();
    }
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingExitAnimEnd");
    AppMethodBeat.o(184992);
  }
  
  public static abstract interface a
  {
    public abstract void hide();
    
    public abstract void show();
  }
  
  static abstract interface b
  {
    public abstract void K(View paramView, int paramInt);
    
    public abstract boolean aI(View paramView, int paramInt);
    
    public abstract boolean aJ(View paramView, int paramInt);
  }
  
  static final class d
    extends RecyclerView.v
  {
    static final com.tencent.mm.av.a.a.c gvY;
    RelativeLayout PqD;
    TextView PqE;
    RelativeLayout PqF;
    RelativeLayout PqG;
    TextView PqH;
    ImageView gBZ;
    View gvQ;
    
    static
    {
      AppMethodBeat.i(184981);
      c.a locala1 = new c.a();
      locala1.jbq = 2131689602;
      c.a locala2 = locala1.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.iaT = true;
      locala2.jbf = true;
      locala2.jbd = true;
      gvY = locala1.bdv();
      AppMethodBeat.o(184981);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(184980);
      this.gvQ = paramView;
      this.PqD = ((RelativeLayout)paramView.findViewById(2131309264));
      this.gBZ = ((ImageView)paramView.findViewById(2131309268));
      this.PqE = ((TextView)paramView.findViewById(2131309278));
      this.PqF = ((RelativeLayout)paramView.findViewById(2131309266));
      this.PqG = ((RelativeLayout)paramView.findViewById(2131309272));
      this.PqH = ((TextView)paramView.findViewById(2131309274));
      AppMethodBeat.o(184980);
    }
  }
  
  static final class e
    extends RecyclerView.a
  {
    private List<com.tencent.mm.chatroom.storage.c> PqI;
    private ab.b Pqw;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.c> paramList, ab.b paramb)
    {
      this.context = paramContext;
      this.PqI = paramList;
      this.Pqw = paramb;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(184987);
      paramViewGroup = new ab.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493495, paramViewGroup, false));
      AppMethodBeat.o(184987);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(184988);
      final ab.d locald;
      final com.tencent.mm.chatroom.storage.c localc;
      if ((this.PqI != null) && (paramInt >= 0) && (paramInt < this.PqI.size()))
      {
        locald = (ab.d)paramv;
        localc = (com.tencent.mm.chatroom.storage.c)this.PqI.get(paramInt);
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.gvQ.setVisibility(0);
        if (!localc.aml()) {
          break label263;
        }
        locald.gBZ.setImageResource(2131231660);
        locald.PqE.setText(Util.nullAs(localc.field_title, this.context.getString(2131757254)));
        if (paramInt != 0) {
          break label406;
        }
        paramv = (RelativeLayout.LayoutParams)locald.PqD.getLayoutParams();
        if (paramv.leftMargin == 0)
        {
          paramv.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
          locald.PqD.setLayoutParams(paramv);
        }
        label158:
        if (localc.field_state != 0) {
          break label452;
        }
        locald.PqF.setVisibility(8);
        if (localc.field_nreply <= 0) {
          break label440;
        }
        locald.PqG.setVisibility(0);
        locald.PqH.setText(localc.field_nreply);
      }
      for (;;)
      {
        locald.PqD.setTag(localc);
        locald.PqD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (ab.e.a(ab.e.this) != null) {
              ab.e.a(ab.e.this).K(paramAnonymousView, locald.lR());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184985);
          }
        });
        locald.PqD.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
            if (ab.e.a(ab.e.this) != null)
            {
              boolean bool = ab.e.a(ab.e.this).aI(paramAnonymousView, locald.lR());
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
        WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localc.field_username);
        if (localWxaAttributes == null)
        {
          ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(localc.field_username, new q.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, ab.e.1.this.PqJ.gBZ, ab.d.gvY);
                    if ((Util.isNullOrNil(ab.e.1.this.PqB.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      ab.e.1.this.PqJ.PqE.setText(paramAnonymousWxaAttributes.field_nickname);
                    }
                    AppMethodBeat.o(184982);
                    return;
                  }
                }
              });
              AppMethodBeat.o(184983);
            }
          });
          if (Util.isNullOrNil(localc.field_title)) {
            break;
          }
          locald.PqE.setText(Util.nullAs(localc.field_title, ""));
          break;
        }
        com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
        if (localWxaAttributes != null) {}
        for (paramv = localWxaAttributes.field_smallHeadURL;; paramv = "")
        {
          locala.a(paramv, locald.gBZ, ab.d.gvY);
          locald.PqE.setText(Util.nullAs(localc.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label406:
        paramv = (RelativeLayout.LayoutParams)locald.PqD.getLayoutParams();
        if (paramv.leftMargin == 0) {
          break label158;
        }
        paramv.leftMargin = 0;
        locald.PqD.setLayoutParams(paramv);
        break label158;
        label440:
        locald.PqG.setVisibility(8);
        continue;
        label452:
        if (localc.field_state == 1)
        {
          locald.PqF.setVisibility(0);
          locald.PqG.setVisibility(8);
          locald.PqF.setTag(localc);
          locald.PqF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (ab.e.a(ab.e.this) != null) {
                ab.e.a(ab.e.this).aJ(paramAnonymousView, locald.lR());
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
      int i = this.PqI.size();
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
    public com.tencent.mm.chatroom.storage.c PqM;
    public int ajZ;
    public int akb;
    public int dDe = 0;
    
    public f(com.tencent.mm.chatroom.storage.c paramc, int paramInt)
    {
      this.PqM = paramc;
      this.dDe = 1;
      this.ajZ = 0;
      this.akb = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ab
 * JD-Core Version:    0.7.0.1
 */