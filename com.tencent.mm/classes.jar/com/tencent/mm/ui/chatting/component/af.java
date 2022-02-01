package com.tencent.mm.ui.chatting.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.qa;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.c.c.a;
import com.tencent.mm.chatroom.d.ab.a;
import com.tencent.mm.chatroom.d.ac;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.ab.class)
public class af
  extends a
  implements com.tencent.mm.ui.chatting.component.api.ab
{
  private a Ygn;
  private RecyclerView aesM;
  private ImageView aesN;
  private ImageView aesO;
  private e aesP;
  private List<com.tencent.mm.chatroom.storage.c> aesQ;
  private HashMap<String, com.tencent.mm.chatroom.storage.c> aesR;
  private ArrayList<f> aesS;
  private ObjectAnimator aesT;
  private ObjectAnimator aesU;
  private b aesV;
  private LinearLayoutManager lDn;
  private IListener<qa> lzf;
  private View plc;
  private boolean shouldShow;
  
  public af()
  {
    AppMethodBeat.i(184990);
    this.aesQ = new ArrayList();
    this.aesR = new HashMap();
    this.Ygn = null;
    this.aesS = new ArrayList();
    this.shouldShow = true;
    this.aesT = null;
    this.aesU = null;
    this.lzf = new GroupTodoComponent.1(this, f.hfK);
    this.aesV = new b()
    {
      public final void Q(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184977);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject1;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          if (paramAnonymousView.aMg())
          {
            com.tencent.mm.chatroom.d.ab.f(af.this.hlc.aezO.getContext(), paramAnonymousView.field_roomname, false);
            localObject1 = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupTodoStorage().ar(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = com.tencent.mm.chatroom.d.ab.e((com.tencent.mm.chatroom.storage.c)localObject1);
            if (localObject1 == null) {
              break label443;
            }
            bool2 = com.tencent.mm.chatroom.d.ab.b((com.tencent.mm.chatroom.storage.c)localObject1);
            bool1 = bool2;
            if (bool2) {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184971);
                  af.a(af.this).add(new af.f(this.aesX, paramAnonymousInt + 1));
                  AppMethodBeat.o(184971);
                }
              }, 300L);
            }
          }
        }
        label144:
        label443:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Object localObject2 = af.this.hlc.getTalkerUserName();
          if (paramAnonymousView.aMg())
          {
            paramAnonymousInt = 1;
            ac.a((String)localObject2, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject1 != null) {
              break label395;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.c)localObject1).field_todoid)
          {
            Log.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(184977);
            return;
            localObject1 = new g();
            ((g)localObject1).username = paramAnonymousView.field_username;
            ((g)localObject1).qAF = paramAnonymousView.field_path;
            ((g)localObject1).scene = 1160;
            ((g)localObject1).icX = paramAnonymousView.field_roomname;
            ((g)localObject1).eoU = paramAnonymousView.field_shareKey;
            ((g)localObject1).eoT = paramAnonymousView.field_shareName;
            localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramAnonymousView.field_roomname, paramAnonymousView.aMf());
            int i;
            if (localObject2 == null) {
              i = 0;
            }
            for (;;)
            {
              ((g)localObject1).opX = i;
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(af.this.hlc.aezO.getContext(), (g)localObject1);
              break;
              String str = ((fi)localObject2).field_content;
              if (str == null)
              {
                i = 0;
              }
              else
              {
                localObject2 = k.b.Hf(br.a(true, str, ((fi)localObject2).field_isSend));
                if (localObject2 == null) {
                  i = 0;
                } else {
                  i = ((k.b)localObject2).nTP;
                }
              }
            }
            paramAnonymousInt = 0;
            break label144;
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
      
      public final boolean bk(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184978);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.c))
        {
          localObject = (com.tencent.mm.chatroom.storage.c)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(af.this.hlc.aezO.getContext(), paramAnonymousView);
          locala.agjv = true;
          locala.agjz = true;
          locala.agjA = true;
          locala.agjt = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(184972);
              paramAnonymous2ContextMenu.clear();
              if (com.tencent.mm.model.ab.IL(af.this.hlc.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, af.this.hlc.aezO.getContext().getResources().getString(R.l.gyA));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, af.this.hlc.aezO.getContext().getResources().getString(R.l.gwt));
              AppMethodBeat.o(184972);
            }
          };
          locala.GAC = new u.i()
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
                paramAnonymous2MenuItem = af.this.hlc.aezO.getContext();
                String str1 = af.this.hlc.getTalkerUserName();
                String str2 = this.aeta.field_todoid;
                String str3 = this.aeta.field_username;
                if (this.aeta.aMg()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  com.tencent.mm.chatroom.d.ab.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new ab.a()
                  {
                    public final void aLZ()
                    {
                      AppMethodBeat.i(184973);
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(184973);
                    }
                    
                    public final void aMa()
                    {
                      AppMethodBeat.i(184974);
                      Pair localPair = com.tencent.mm.chatroom.d.ab.a(af.6.3.this.aeta);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        af.d(af.this, af.6.3.this.aeta);
                        af.b(af.this).fX(af.6.3.this.aesY);
                        af.c(af.this);
                      }
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(184974);
                    }
                  });
                  AppMethodBeat.o(184975);
                  return;
                }
              }
              boolean bool = com.tencent.mm.chatroom.d.ab.c(this.aeta);
              Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.aeta.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                af.d(af.this, this.aeta);
                af.b(af.this).fX(paramAnonymousInt);
                af.c(af.this);
              }
              paramAnonymous2MenuItem = af.this.hlc.getTalkerUserName();
              if (this.aeta.aMg()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                ac.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.aeta.field_todoid, this.aeta.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(af.this.hlc.aezO.getContext())) {
            break label266;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(af.this.hlc.aezO.getContext()) - 16;
        }
        label266:
        for (;;)
        {
          locala.afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(184976);
              paramAnonymousView.setBackgroundResource(R.g.fni);
              AppMethodBeat.o(184976);
            }
          };
          locala.agjs = paramAnonymousView;
          locala.fQ(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(R.g.fnj);
          paramAnonymousView = af.this.hlc.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.c)localObject).aMg()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            ac.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.c)localObject).field_username);
            AppMethodBeat.o(184978);
            return true;
          }
        }
      }
      
      public final boolean bl(View paramAnonymousView, int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(184979);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          boolean bool = com.tencent.mm.chatroom.d.ab.c(paramAnonymousView);
          Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onFinish finish(%s %s)", new Object[] { paramAnonymousView.field_todoid, Boolean.valueOf(bool) });
          if (bool)
          {
            ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getRoomTodoMsgService();
            c.a.a(af.this.hlc.getTalkerUserName(), paramAnonymousView.field_creator, paramAnonymousView.field_todoid, com.tencent.mm.chatroom.d.ab.d(paramAnonymousView));
            af.d(af.this, paramAnonymousView);
            af.b(af.this).fX(paramAnonymousInt);
            af.c(af.this);
          }
          String str = af.this.hlc.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.aMg()) {
            paramAnonymousInt = 1;
          }
          ac.a(str, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
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
    if (!com.tencent.mm.chatroom.d.ab.e(paramc))
    {
      AppMethodBeat.o(185872);
      return;
    }
    if (this.aesQ.contains(paramc))
    {
      if (paramBoolean)
      {
        if (this.aesQ.indexOf(paramc) != -1) {
          this.aesS.add(new f(paramc, this.aesQ.indexOf(paramc) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(paramc);
      if (i != -1) {
        this.aesP.by(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (paramc != null)
    {
      this.aesQ.add(0, paramc);
      this.aesR.put(paramc.field_todoid, paramc);
      this.aesP.fW(0);
    }
    if (this.aesQ.size() > 20) {
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(255861);
          int i = af.g(af.this).size() - 1;
          while (i >= 20)
          {
            com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)af.g(af.this).remove(i);
            if (localc != null) {
              af.h(af.this).remove(localc);
            }
            i -= 1;
          }
          af.b(af.this).bB(20, af.g(af.this).size() - 20);
          AppMethodBeat.o(255861);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private int i(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184998);
    if (paramc != null)
    {
      if (this.aesQ.contains(paramc))
      {
        int i = this.aesQ.indexOf(paramc);
        this.aesQ.remove(paramc);
        this.aesR.remove(paramc.field_todoid);
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
      if (this.aesQ.contains(paramc))
      {
        int i = this.aesQ.indexOf(paramc);
        this.aesQ.remove(i);
        this.aesQ.add(0, paramc);
        this.aesR.put(paramc.field_todoid, paramc);
        AppMethodBeat.o(184999);
        return i;
      }
      Log.e("MicroMsg.roomTodo.GroupTodoComponent", "updateItem todo no exist???");
    }
    AppMethodBeat.o(184999);
    return -1;
  }
  
  private boolean jsu()
  {
    AppMethodBeat.i(184995);
    boolean bool = au.bwG(this.hlc.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void jsv()
  {
    AppMethodBeat.i(184996);
    bb localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(this.hlc.getTalkerUserName());
    if ((localbb != null) && (localbb.field_hasTodo == 1))
    {
      localbb.pP(0);
      bh.bCz();
      com.tencent.mm.model.c.bzG().a(localbb, localbb.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private void jsw()
  {
    AppMethodBeat.i(185873);
    this.aesQ.clear();
    this.aesR.clear();
    AppMethodBeat.o(185873);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(184997);
    if (this.plc != null) {
      if (this.aesQ.size() == 0)
      {
        this.plc.setVisibility(8);
        if (this.Ygn != null)
        {
          this.Ygn.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.shouldShow)
      {
        this.plc.setVisibility(0);
        if (this.Ygn != null) {
          this.Ygn.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  public final void LW(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!jsu())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.shouldShow = true;
    if (this.plc.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.aesQ.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.aesU == null)
    {
      this.aesU = ObjectAnimator.ofFloat(this.plc, "alpha", new float[] { 0.0F, 1.0F });
      this.aesU.addListener(new Animator.AnimatorListener()
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
          AppMethodBeat.i(255856);
          if (af.f(af.this) != null) {
            af.f(af.this).setVisibility(0);
          }
          AppMethodBeat.o(255856);
        }
      });
    }
    if (paramBoolean) {
      this.aesU.setDuration(100L);
    }
    for (;;)
    {
      this.aesU.start();
      AppMethodBeat.o(185870);
      return;
      this.aesU.setDuration(200L);
    }
  }
  
  public final void LX(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!jsu())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.shouldShow = false;
    if (this.plc.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.aesT == null)
    {
      this.aesT = ObjectAnimator.ofFloat(this.plc, "alpha", new float[] { 1.0F, 0.0F });
      this.aesT.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(255857);
          if (af.f(af.this) != null) {
            af.f(af.this).setVisibility(4);
          }
          AppMethodBeat.o(255857);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.aesT.setDuration(100L);
    }
    for (;;)
    {
      this.aesT.start();
      AppMethodBeat.o(185869);
      return;
      this.aesT.setDuration(200L);
    }
  }
  
  public final void a(a parama)
  {
    this.Ygn = parama;
  }
  
  public final int fJG()
  {
    AppMethodBeat.i(185871);
    if ((com.tencent.mm.chatroom.d.ab.aLX()) && (this.plc != null) && (this.aesQ.size() > 0))
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(this.hlc.aezO.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(184991);
    super.jjg();
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(184991);
      return;
    }
    Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.plc == null)
    {
      l1 = cn.bDv();
      this.plc = this.hlc.findViewById(R.h.fxQ);
      this.aesM = ((RecyclerView)this.plc.findViewById(R.h.gau));
      this.aesN = ((ImageView)this.plc.findViewById(R.h.gaq));
      this.aesO = ((ImageView)this.plc.findViewById(R.h.gat));
      this.aesM.a(new af.1(this));
      this.hlc.aezO.getContext();
      this.lDn = new LinearLayoutManager();
      this.lDn.setOrientation(0);
      this.aesM.setLayoutManager(this.lDn);
      this.aesP = new e(this.hlc.aezO.getContext(), this.aesQ, this.aesV);
      this.aesM.setAdapter(this.aesP);
      this.aesP.bZE.notifyChanged();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(cn.bDv() - l1) });
    }
    long l1 = cn.bDv();
    if (jsu())
    {
      this.lzf.alive();
      if (this.plc != null)
      {
        jsw();
        Object localObject = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupTodoStorage().CZ(this.hlc.getTalkerUserName());
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)((Iterator)localObject).next();
            this.aesQ.add(localc);
            this.aesR.put(localc.field_todoid, localc);
          }
        }
        Collections.sort(this.aesQ, new Comparator() {});
        this.aesP.bZE.notifyChanged();
        updateView();
      }
      jsv();
    }
    for (;;)
    {
      long l2 = cn.bDv();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.hlc.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      jsw();
      this.plc.setVisibility(8);
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(185867);
    super.jji();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.aesS.size() > 0)
    {
      Iterator localIterator = this.aesS.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.hAf == 1)
        {
          j(localf.aetl);
          this.aesP.by(localf.bUm, localf.bUo);
        }
      }
      this.aesS.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(185868);
    super.jjj();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(184992);
    super.jjl();
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (jsu())
    {
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.lzf.dead();
      if (this.plc != null) {
        this.plc.setVisibility(8);
      }
      jsv();
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
    public abstract void Q(View paramView, int paramInt);
    
    public abstract boolean bk(View paramView, int paramInt);
    
    public abstract boolean bl(View paramView, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void LW(boolean paramBoolean);
    
    public abstract void LX(boolean paramBoolean);
    
    public abstract int fJG();
  }
  
  static final class e
    extends RecyclerView.a
  {
    private af.b aesV;
    private List<com.tencent.mm.chatroom.storage.c> aeth;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.c> paramList, af.b paramb)
    {
      this.context = paramContext;
      this.aeth = paramList;
      this.aesV = paramb;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(255901);
      paramViewGroup = new af.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.geY, paramViewGroup, false));
      AppMethodBeat.o(255901);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(255910);
      final af.d locald;
      final com.tencent.mm.chatroom.storage.c localc;
      if ((this.aeth != null) && (paramInt >= 0) && (paramInt < this.aeth.size()))
      {
        locald = (af.d)paramv;
        localc = (com.tencent.mm.chatroom.storage.c)this.aeth.get(paramInt);
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.lBX.setVisibility(0);
        if (!localc.aMg()) {
          break label265;
        }
        locald.lPb.setImageResource(R.g.chat_todo_card);
        locald.aetd.setText(Util.nullAs(localc.field_title, this.context.getString(R.l.gws)));
        if (paramInt != 0) {
          break label410;
        }
        paramv = (RelativeLayout.LayoutParams)locald.aetc.getLayoutParams();
        if (paramv.leftMargin == 0)
        {
          paramv.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
          locald.aetc.setLayoutParams(paramv);
        }
        label160:
        if (localc.field_state != 0) {
          break label456;
        }
        locald.aete.setVisibility(8);
        if (localc.field_nreply <= 0) {
          break label444;
        }
        locald.aetf.setVisibility(0);
        locald.aetg.setText(localc.field_nreply);
      }
      for (;;)
      {
        locald.aetc.setTag(localc);
        locald.aetc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (af.e.a(af.e.this) != null) {
              af.e.a(af.e.this).Q(paramAnonymousView, locald.KJ());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184985);
          }
        });
        locald.aetc.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
            if (af.e.a(af.e.this) != null)
            {
              boolean bool = af.e.a(af.e.this).bk(paramAnonymousView, locald.KJ());
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(184986);
              return bool;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(184986);
            return false;
          }
        });
        AppMethodBeat.o(255910);
        return;
        label265:
        WxaAttributes localWxaAttributes = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(localc.field_username);
        if (localWxaAttributes == null)
        {
          ((s)com.tencent.mm.kernel.h.ax(s.class)).a(localc.field_username, new s.a()
          {
            public final void onGetWeAppInfo(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.modelimage.loader.a locala = r.bKe();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, af.e.1.this.aeti.lPb, af.d.lCf);
                    if ((Util.isNullOrNil(af.e.1.this.aeta.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      af.e.1.this.aeti.aetd.setText(paramAnonymousWxaAttributes.field_nickname);
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
          locald.aetd.setText(Util.nullAs(localc.field_title, ""));
          break;
        }
        com.tencent.mm.modelimage.loader.a locala = r.bKe();
        if (localWxaAttributes != null) {}
        for (paramv = localWxaAttributes.field_smallHeadURL;; paramv = "")
        {
          locala.a(paramv, locald.lPb, af.d.lCf);
          locald.aetd.setText(Util.nullAs(localc.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label410:
        paramv = (RelativeLayout.LayoutParams)locald.aetc.getLayoutParams();
        if (paramv.leftMargin == 0) {
          break label160;
        }
        paramv.leftMargin = 0;
        locald.aetc.setLayoutParams(paramv);
        break label160;
        label444:
        locald.aetf.setVisibility(8);
        continue;
        label456:
        if (localc.field_state == 1)
        {
          locald.aete.setVisibility(0);
          locald.aetf.setVisibility(8);
          locald.aete.setTag(localc);
          locald.aete.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (af.e.a(af.e.this) != null) {
                af.e.a(af.e.this).bl(paramAnonymousView, locald.KJ());
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
      int i = this.aeth.size();
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
    public com.tencent.mm.chatroom.storage.c aetl;
    public int bUm;
    public int bUo;
    public int hAf = 0;
    
    public f(com.tencent.mm.chatroom.storage.c paramc, int paramInt)
    {
      this.aetl = paramc;
      this.hAf = 1;
      this.bUm = 0;
      this.bUo = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.af
 * JD-Core Version:    0.7.0.1
 */