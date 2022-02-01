package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.y.class)
public class ac
  extends a
  implements com.tencent.mm.ui.chatting.d.b.y
{
  private a Rkd;
  private RecyclerView WKI;
  private ImageView WKJ;
  private ImageView WKK;
  private e WKL;
  private List<com.tencent.mm.chatroom.storage.c> WKM;
  private HashMap<String, com.tencent.mm.chatroom.storage.c> WKN;
  private ArrayList<f> WKO;
  private boolean WKP;
  private ObjectAnimator WKQ;
  private ObjectAnimator WKR;
  private b WKS;
  private IListener<oq> iXc;
  private LinearLayoutManager jbn;
  private View mrI;
  
  public ac()
  {
    AppMethodBeat.i(184990);
    this.WKM = new ArrayList();
    this.WKN = new HashMap();
    this.Rkd = null;
    this.WKO = new ArrayList();
    this.WKP = true;
    this.WKQ = null;
    this.WKR = null;
    this.iXc = new IListener() {};
    this.WKS = new b()
    {
      public final void L(View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184977);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject1;
        boolean bool3;
        boolean bool2;
        if ((paramAnonymousView instanceof com.tencent.mm.chatroom.storage.c))
        {
          paramAnonymousView = (com.tencent.mm.chatroom.storage.c)paramAnonymousView;
          if (paramAnonymousView.asm())
          {
            com.tencent.mm.chatroom.d.y.f(ac.this.fgR.WQv.getContext(), paramAnonymousView.field_roomname, false);
            localObject1 = ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getGroupTodoStorage().am(paramAnonymousView.field_roomname, paramAnonymousView.field_todoid);
            bool3 = com.tencent.mm.chatroom.d.y.e((com.tencent.mm.chatroom.storage.c)localObject1);
            if (localObject1 == null) {
              break label433;
            }
            bool2 = com.tencent.mm.chatroom.d.y.b((com.tencent.mm.chatroom.storage.c)localObject1);
            bool1 = bool2;
            if (bool2) {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184971);
                  ac.a(ac.this).add(new ac.f(this.WKU, paramAnonymousInt + 1));
                  AppMethodBeat.o(184971);
                }
              }, 300L);
            }
          }
        }
        label144:
        label433:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Object localObject2 = ac.this.fgR.getTalkerUserName();
          if (paramAnonymousView.asm())
          {
            paramAnonymousInt = 1;
            z.a((String)localObject2, paramAnonymousInt, 1, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
            if (localObject1 != null) {
              break label385;
            }
          }
          for (paramAnonymousView = "null";; paramAnonymousView = ((com.tencent.mm.chatroom.storage.c)localObject1).field_todoid)
          {
            Log.i("MicroMsg.roomTodo.GroupTodoComponent", "click update to finish(%s %s %s)", new Object[] { paramAnonymousView, Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
            AppMethodBeat.o(184977);
            return;
            localObject1 = new g();
            ((g)localObject1).username = paramAnonymousView.field_username;
            ((g)localObject1).nBq = paramAnonymousView.field_path;
            ((g)localObject1).scene = 1160;
            ((g)localObject1).fWY = paramAnonymousView.field_roomname;
            ((g)localObject1).cwU = paramAnonymousView.field_shareKey;
            ((g)localObject1).cwT = paramAnonymousView.field_shareName;
            localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(paramAnonymousView.field_roomname, paramAnonymousView.asl());
            String str = ((et)localObject2).field_content;
            int i;
            if (str == null) {
              i = 0;
            }
            for (;;)
            {
              ((g)localObject1).lyw = i;
              ((r)com.tencent.mm.kernel.h.ae(r.class)).a(ac.this.fgR.WQv.getContext(), (g)localObject1);
              break;
              localObject2 = k.b.OQ(bq.b(true, str, ((et)localObject2).field_isSend));
              if (localObject2 == null) {
                i = 0;
              } else {
                i = ((k.b)localObject2).loM;
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
      
      public final boolean aN(final View paramAnonymousView, final int paramAnonymousInt)
      {
        AppMethodBeat.i(184978);
        Object localObject = paramAnonymousView.getTag();
        com.tencent.mm.ui.widget.b.a locala;
        int i;
        if ((localObject instanceof com.tencent.mm.chatroom.storage.c))
        {
          localObject = (com.tencent.mm.chatroom.storage.c)localObject;
          locala = new com.tencent.mm.ui.widget.b.a(ac.this.fgR.WQv.getContext(), paramAnonymousView);
          locala.Yrh = true;
          locala.Yrj = true;
          locala.Yrk = true;
          locala.Yrf = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(184972);
              paramAnonymous2ContextMenu.clear();
              if (ab.PW(ac.this.fgR.getTalkerUserName())) {
                paramAnonymous2ContextMenu.add(0, 1, 0, ac.this.fgR.WQv.getContext().getResources().getString(R.l.ewa));
              }
              paramAnonymous2ContextMenu.add(0, 2, 0, ac.this.fgR.WQv.getContext().getResources().getString(R.l.etV));
              AppMethodBeat.o(184972);
            }
          };
          locala.ODU = new q.g()
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
                paramAnonymous2MenuItem = ac.this.fgR.WQv.getContext();
                String str1 = ac.this.fgR.getTalkerUserName();
                String str2 = this.WKX.field_todoid;
                String str3 = this.WKX.field_username;
                if (this.WKX.asm()) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  com.tencent.mm.chatroom.d.y.a(paramAnonymous2MenuItem, str1, str2, str3, false, 1, paramAnonymous2Int, 0, new y.a()
                  {
                    public final void asd()
                    {
                      AppMethodBeat.i(184973);
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp addtodo");
                      AppMethodBeat.o(184973);
                    }
                    
                    public final void ase()
                    {
                      AppMethodBeat.i(184974);
                      Pair localPair = com.tencent.mm.chatroom.d.y.a(ac.7.3.this.WKX);
                      if (((Boolean)localPair.first).booleanValue())
                      {
                        ac.d(ac.this, ac.7.3.this.WKX);
                        ac.b(ac.this).cN(ac.7.3.this.WKV);
                        ac.c(ac.this);
                      }
                      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp recall result:%s", new Object[] { localPair });
                      AppMethodBeat.o(184974);
                    }
                  });
                  AppMethodBeat.o(184975);
                  return;
                }
              }
              boolean bool = com.tencent.mm.chatroom.d.y.c(this.WKX);
              Log.i("MicroMsg.roomTodo.GroupTodoComponent", "handleTodoLongClickImp delete(%s) result:%s", new Object[] { this.WKX.field_todoid, Boolean.valueOf(bool) });
              if (bool)
              {
                ac.d(ac.this, this.WKX);
                ac.b(ac.this).cN(paramAnonymousInt);
                ac.c(ac.this);
              }
              paramAnonymous2MenuItem = ac.this.fgR.getTalkerUserName();
              if (this.WKX.asm()) {}
              for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
              {
                z.a(paramAnonymous2MenuItem, paramAnonymous2Int, 2, 2, this.WKX.field_todoid, this.WKX.field_username);
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
          if (paramAnonymousInt <= com.tencent.mm.ui.widget.textview.b.getScreenWidth(ac.this.fgR.WQv.getContext())) {
            break label266;
          }
          paramAnonymousInt = com.tencent.mm.ui.widget.textview.b.getScreenWidth(ac.this.fgR.WQv.getContext()) - 16;
        }
        label266:
        for (;;)
        {
          locala.XVa = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(184976);
              paramAnonymousView.setBackgroundResource(R.g.dmW);
              AppMethodBeat.o(184976);
            }
          };
          locala.Yre = paramAnonymousView;
          locala.eY(paramAnonymousInt, i);
          paramAnonymousView.setBackgroundResource(R.g.dmX);
          paramAnonymousView = ac.this.fgR.getTalkerUserName();
          if (((com.tencent.mm.chatroom.storage.c)localObject).asm()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            z.a(paramAnonymousView, paramAnonymousInt, 4, 2, ((com.tencent.mm.chatroom.storage.c)localObject).field_todoid, ((com.tencent.mm.chatroom.storage.c)localObject).field_username);
            AppMethodBeat.o(184978);
            return true;
          }
        }
      }
      
      public final boolean aO(View paramAnonymousView, int paramAnonymousInt)
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
            ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getRoomTodoMsgService();
            com.tencent.mm.chatroom.c.c.a.a(ac.this.fgR.getTalkerUserName(), paramAnonymousView.field_creator, paramAnonymousView.field_todoid, com.tencent.mm.chatroom.d.y.d(paramAnonymousView));
            ac.d(ac.this, paramAnonymousView);
            ac.b(ac.this).cN(paramAnonymousInt);
            ac.c(ac.this);
          }
          String str = ac.this.fgR.getTalkerUserName();
          paramAnonymousInt = i;
          if (paramAnonymousView.asm()) {
            paramAnonymousInt = 1;
          }
          z.a(str, paramAnonymousInt, 1, 2, paramAnonymousView.field_todoid, paramAnonymousView.field_username);
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
    if (this.WKM.contains(paramc))
    {
      if (paramBoolean)
      {
        if (this.WKM.indexOf(paramc) != -1) {
          this.WKO.add(new f(paramc, this.WKM.indexOf(paramc) + 1));
        }
        AppMethodBeat.o(185872);
        return;
      }
      int i = j(paramc);
      if (i != -1) {
        this.WKL.aE(0, i + 1);
      }
      AppMethodBeat.o(185872);
      return;
    }
    if (paramc != null)
    {
      this.WKM.add(0, paramc);
      this.WKN.put(paramc.field_todoid, paramc);
      this.WKL.cM(0);
    }
    if (this.WKM.size() > 20) {
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(243948);
          int i = ac.g(ac.this).size() - 1;
          while (i >= 20)
          {
            com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)ac.g(ac.this).remove(i);
            if (localc != null) {
              ac.h(ac.this).remove(localc);
            }
            i -= 1;
          }
          ac.b(ac.this).aH(20, ac.g(ac.this).size() - 20);
          AppMethodBeat.o(243948);
        }
      }, 300L);
    }
    AppMethodBeat.o(185872);
  }
  
  private void hPA()
  {
    AppMethodBeat.i(185873);
    this.WKM.clear();
    this.WKN.clear();
    AppMethodBeat.o(185873);
  }
  
  private boolean hPy()
  {
    AppMethodBeat.i(184995);
    boolean bool = ab.PP(this.fgR.getTalkerUserName());
    AppMethodBeat.o(184995);
    return bool;
  }
  
  private void hPz()
  {
    AppMethodBeat.i(184996);
    az localaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(this.fgR.getTalkerUserName());
    if ((localaz != null) && (localaz.field_hasTodo == 1))
    {
      localaz.pQ(0);
      bh.beI();
      com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username, false);
    }
    AppMethodBeat.o(184996);
  }
  
  private int i(com.tencent.mm.chatroom.storage.c paramc)
  {
    AppMethodBeat.i(184998);
    if (paramc != null)
    {
      if (this.WKM.contains(paramc))
      {
        int i = this.WKM.indexOf(paramc);
        this.WKM.remove(paramc);
        this.WKN.remove(paramc.field_todoid);
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
      if (this.WKM.contains(paramc))
      {
        int i = this.WKM.indexOf(paramc);
        this.WKM.remove(i);
        this.WKM.add(0, paramc);
        this.WKN.put(paramc.field_todoid, paramc);
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
    if (this.mrI != null) {
      if (this.WKM.size() == 0)
      {
        this.mrI.setVisibility(8);
        if (this.Rkd != null)
        {
          this.Rkd.hide();
          AppMethodBeat.o(184997);
        }
      }
      else if (this.WKP)
      {
        this.mrI.setVisibility(0);
        if (this.Rkd != null) {
          this.Rkd.show();
        }
      }
    }
    AppMethodBeat.o(184997);
  }
  
  public final void Gk(boolean paramBoolean)
  {
    AppMethodBeat.i(185870);
    if (!com.tencent.mm.chatroom.d.y.asb())
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (!hPy())
    {
      AppMethodBeat.o(185870);
      return;
    }
    this.WKP = true;
    if (this.mrI.getVisibility() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.WKM.size() == 0)
    {
      AppMethodBeat.o(185870);
      return;
    }
    if (this.WKR == null)
    {
      this.WKR = ObjectAnimator.ofFloat(this.mrI, "alpha", new float[] { 0.0F, 1.0F });
      this.WKR.addListener(new Animator.AnimatorListener()
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
          AppMethodBeat.i(266778);
          if (ac.f(ac.this) != null) {
            ac.f(ac.this).setVisibility(0);
          }
          AppMethodBeat.o(266778);
        }
      });
    }
    if (paramBoolean) {
      this.WKR.setDuration(100L);
    }
    for (;;)
    {
      this.WKR.start();
      AppMethodBeat.o(185870);
      return;
      this.WKR.setDuration(200L);
    }
  }
  
  public final void Gl(boolean paramBoolean)
  {
    AppMethodBeat.i(185869);
    if (!com.tencent.mm.chatroom.d.y.asb())
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (!hPy())
    {
      AppMethodBeat.o(185869);
      return;
    }
    this.WKP = false;
    if (this.mrI.getVisibility() != 0)
    {
      AppMethodBeat.o(185869);
      return;
    }
    if (this.WKQ == null)
    {
      this.WKQ = ObjectAnimator.ofFloat(this.mrI, "alpha", new float[] { 1.0F, 0.0F });
      this.WKQ.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(290506);
          if (ac.f(ac.this) != null) {
            ac.f(ac.this).setVisibility(4);
          }
          AppMethodBeat.o(290506);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    if (paramBoolean) {
      this.WKQ.setDuration(100L);
    }
    for (;;)
    {
      this.WKQ.start();
      AppMethodBeat.o(185869);
      return;
      this.WKQ.setDuration(200L);
    }
  }
  
  public final void a(a parama)
  {
    this.Rkd = parama;
  }
  
  public final int eBE()
  {
    AppMethodBeat.i(185871);
    if ((com.tencent.mm.chatroom.d.y.asb()) && (this.mrI != null) && (this.WKM.size() > 0))
    {
      int i = com.tencent.mm.ci.a.fromDPToPix(this.fgR.WQv.getContext(), 48);
      AppMethodBeat.o(185871);
      return i;
    }
    AppMethodBeat.o(185871);
    return 0;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(184991);
    super.hGV();
    if (!com.tencent.mm.chatroom.d.y.asb())
    {
      AppMethodBeat.o(184991);
      return;
    }
    Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onChattingEnterAnimStart: user %s hashCode:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(hashCode()) });
    if (this.mrI == null)
    {
      l1 = cm.bfD();
      this.mrI = this.fgR.findViewById(R.h.dxv);
      this.WKI = ((RecyclerView)this.mrI.findViewById(R.h.dXO));
      this.WKJ = ((ImageView)this.mrI.findViewById(R.h.dXK));
      this.WKK = ((ImageView)this.mrI.findViewById(R.h.dXN));
      this.WKI.a(new ac.2(this));
      this.fgR.WQv.getContext();
      this.jbn = new LinearLayoutManager();
      this.jbn.setOrientation(0);
      this.WKI.setLayoutManager(this.jbn);
      this.WKL = new e(this.fgR.WQv.getContext(), this.WKM, this.WKS);
      this.WKI.setAdapter(this.WKL);
      this.WKL.alc.notifyChanged();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "constructor interTime:%s", new Object[] { Long.valueOf(cm.bfD() - l1) });
    }
    long l1 = cm.bfD();
    if (hPy())
    {
      this.iXc.alive();
      if (this.mrI != null)
      {
        hPA();
        Iterator localIterator = ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getGroupTodoStorage().Kt(this.fgR.getTalkerUserName()).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.chatroom.storage.c localc = (com.tencent.mm.chatroom.storage.c)localIterator.next();
          this.WKM.add(localc);
          this.WKN.put(localc.field_todoid, localc);
        }
        Collections.sort(this.WKM, new Comparator() {});
        this.WKL.alc.notifyChanged();
        updateView();
      }
      hPz();
    }
    for (;;)
    {
      long l2 = cm.bfD();
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onResume chatroomUsername:%s interTime:%s", new Object[] { this.fgR.getTalkerUserName(), Long.valueOf(l2 - l1) });
      AppMethodBeat.o(184991);
      return;
      hPA();
      this.mrI.setVisibility(8);
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(185867);
    super.hGX();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingResume");
    if (this.WKO.size() > 0)
    {
      Iterator localIterator = this.WKO.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.fvK == 1)
        {
          j(localf.WLi);
          this.WKL.aE(localf.afG, localf.afI);
        }
      }
      this.WKO.clear();
    }
    AppMethodBeat.o(185867);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(185868);
    super.hGY();
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onChattingPause");
    AppMethodBeat.o(185868);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(184992);
    super.hHa();
    if (!com.tencent.mm.chatroom.d.y.asb())
    {
      AppMethodBeat.o(184992);
      return;
    }
    if (hPy())
    {
      Log.i("MicroMsg.roomTodo.GroupTodoComponent", "onPause");
      this.iXc.dead();
      if (this.mrI != null) {
        this.mrI.setVisibility(8);
      }
      hPz();
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
    public abstract void L(View paramView, int paramInt);
    
    public abstract boolean aN(View paramView, int paramInt);
    
    public abstract boolean aO(View paramView, int paramInt);
  }
  
  static final class d
    extends RecyclerView.v
  {
    static final com.tencent.mm.ay.a.a.c jak;
    RelativeLayout WKZ;
    TextView WLa;
    RelativeLayout WLb;
    RelativeLayout WLc;
    TextView WLd;
    View jac;
    ImageView jmf;
    
    static
    {
      AppMethodBeat.i(184981);
      com.tencent.mm.ay.a.a.c.a locala1 = new com.tencent.mm.ay.a.a.c.a();
      locala1.lRP = R.k.app_brand_app_default_icon_for_tail;
      com.tencent.mm.ay.a.a.c.a locala2 = locala1.dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.kPz = true;
      locala2.lRD = true;
      locala2.lRB = true;
      jak = locala1.bmL();
      AppMethodBeat.o(184981);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(184980);
      this.jac = paramView;
      this.WKZ = ((RelativeLayout)paramView.findViewById(R.h.todo_container));
      this.jmf = ((ImageView)paramView.findViewById(R.h.dXH));
      this.WLa = ((TextView)paramView.findViewById(R.h.dXP));
      this.WLb = ((RelativeLayout)paramView.findViewById(R.h.dXG));
      this.WLc = ((RelativeLayout)paramView.findViewById(R.h.dXL));
      this.WLd = ((TextView)paramView.findViewById(R.h.dXM));
      AppMethodBeat.o(184980);
    }
  }
  
  static final class e
    extends RecyclerView.a
  {
    private ac.b WKS;
    private List<com.tencent.mm.chatroom.storage.c> WLe;
    private Context context;
    
    public e(Context paramContext, List<com.tencent.mm.chatroom.storage.c> paramList, ac.b paramb)
    {
      this.context = paramContext;
      this.WLe = paramList;
      this.WKS = paramb;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(286122);
      paramViewGroup = new ac.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ecq, paramViewGroup, false));
      AppMethodBeat.o(286122);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(286123);
      final ac.d locald;
      final com.tencent.mm.chatroom.storage.c localc;
      if ((this.WLe != null) && (paramInt >= 0) && (paramInt < this.WLe.size()))
      {
        locald = (ac.d)paramv;
        localc = (com.tencent.mm.chatroom.storage.c)this.WLe.get(paramInt);
        Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        locald.jac.setVisibility(0);
        if (!localc.asm()) {
          break label265;
        }
        locald.jmf.setImageResource(R.g.chat_todo_card);
        locald.WLa.setText(Util.nullAs(localc.field_title, this.context.getString(R.l.etU)));
        if (paramInt != 0) {
          break label410;
        }
        paramv = (RelativeLayout.LayoutParams)locald.WKZ.getLayoutParams();
        if (paramv.leftMargin == 0)
        {
          paramv.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 2);
          locald.WKZ.setLayoutParams(paramv);
        }
        label160:
        if (localc.field_state != 0) {
          break label456;
        }
        locald.WLb.setVisibility(8);
        if (localc.field_nreply <= 0) {
          break label444;
        }
        locald.WLc.setVisibility(0);
        locald.WLd.setText(localc.field_nreply);
      }
      for (;;)
      {
        locald.WKZ.setTag(localc);
        locald.WKZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184985);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (ac.e.a(ac.e.this) != null) {
              ac.e.a(ac.e.this).L(paramAnonymousView, locald.md());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184985);
          }
        });
        locald.WKZ.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184986);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            if (ac.e.a(ac.e.this) != null)
            {
              boolean bool = ac.e.a(ac.e.this).aN(paramAnonymousView, locald.md());
              com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(184986);
              return bool;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(184986);
            return false;
          }
        });
        AppMethodBeat.o(286123);
        return;
        label265:
        WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localc.field_username);
        if (localWxaAttributes == null)
        {
          ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a(localc.field_username, new q.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(184983);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184982);
                  com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.q.bml();
                  if (paramAnonymousWxaAttributes != null) {}
                  for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                  {
                    locala.a(str, ac.e.1.this.WLf.jmf, ac.d.jak);
                    if ((Util.isNullOrNil(ac.e.1.this.WKX.field_title)) && (paramAnonymousWxaAttributes != null)) {
                      ac.e.1.this.WLf.WLa.setText(paramAnonymousWxaAttributes.field_nickname);
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
          locald.WLa.setText(Util.nullAs(localc.field_title, ""));
          break;
        }
        com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.q.bml();
        if (localWxaAttributes != null) {}
        for (paramv = localWxaAttributes.field_smallHeadURL;; paramv = "")
        {
          locala.a(paramv, locald.jmf, ac.d.jak);
          locald.WLa.setText(Util.nullAs(localc.field_title, localWxaAttributes.field_nickname));
          break;
        }
        label410:
        paramv = (RelativeLayout.LayoutParams)locald.WKZ.getLayoutParams();
        if (paramv.leftMargin == 0) {
          break label160;
        }
        paramv.leftMargin = 0;
        locald.WKZ.setLayoutParams(paramv);
        break label160;
        label444:
        locald.WLc.setVisibility(8);
        continue;
        label456:
        if (localc.field_state == 1)
        {
          locald.WLb.setVisibility(0);
          locald.WLc.setVisibility(8);
          locald.WLb.setTag(localc);
          locald.WLb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(184984);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$ToDoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (ac.e.a(ac.e.this) != null) {
                ac.e.a(ac.e.this).aO(paramAnonymousView, locald.md());
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
      int i = this.WLe.size();
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
    public com.tencent.mm.chatroom.storage.c WLi;
    public int afG;
    public int afI;
    public int fvK = 0;
    
    public f(com.tencent.mm.chatroom.storage.c paramc, int paramInt)
    {
      this.WLi = paramc;
      this.fvK = 1;
      this.afG = 0;
      this.afI = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac
 * JD-Core Version:    0.7.0.1
 */