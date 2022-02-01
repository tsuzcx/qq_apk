package com.tencent.mm.pluginsdk.e;

import android.content.Context;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.c;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.transmit.recent.ForwardConversationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/forward/RecentForwardMenuHelper;", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "()V", "RECENT_FORWARD_LOG_VERSION", "", "getRECENT_FORWARD_LOG_VERSION", "()I", "RECENT_FORWARD_OFF", "getRECENT_FORWARD_OFF", "RECENT_FORWARD_ON", "getRECENT_FORWARD_ON", "conversationList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo;", "Lkotlin/collections/ArrayList;", "delCount", "delList", "", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "mContext", "Landroid/content/Context;", "mMMMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "menuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "quickShareItemCount", "getQuickShareItemCount", "setQuickShareItemCount", "(I)V", "addMenus", "", "context", "sheet", "overrideAvatarLoader", "Lcom/tencent/mm/ui/base/MMMenuListener$IImageLoader;", "type", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "show", "addQuickShare", "bottomSheet", "clickCb", "userName", "alive", "createRecentForwardMenuHelper", "dead", "deleteInfoInForwardInfoStorage", "username", "disableQuickMenuItems", "getItemCount", "getName", "position", "initData", "onMenuItemSelect", "Lcom/tencent/mm/ui/base/MMMenuItem;", "onMenuLongSelect", "removeConversation", "menuItem", "setMenus", "isDisable", "showLongSelectMenu", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements q
{
  public static final a.a XOn;
  private com.tencent.mm.ui.widget.b.a GAa;
  private ArrayList<ForwardConversationInfo> XOo;
  private int XOp;
  private com.tencent.mm.ui.base.s XOq;
  private String XOr;
  private final int XOs;
  private final int XOt;
  private Context mContext;
  private u.i vGU;
  private com.tencent.mm.ui.widget.a.f vlk;
  
  static
  {
    AppMethodBeat.i(244534);
    XOn = new a.a((byte)0);
    AppMethodBeat.o(244534);
  }
  
  public a()
  {
    AppMethodBeat.i(244514);
    this.XOo = new ArrayList();
    this.XOr = "";
    this.XOs = 1;
    this.XOt = 2;
    AppMethodBeat.o(244514);
  }
  
  private static final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(244521);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(parama, "this$0");
    com.tencent.mm.plugin.secdata.ui.a.a locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c(paramContext, 14, emx.class);
    if (paramContext != null)
    {
      paramContext.abrh = parama.XOt;
      paramContext.startTime = SystemClock.elapsedRealtime();
      paramContext.XOr = null;
      paramContext.abrd = 0;
      paramContext.abre = 0;
      paramContext.abrf = 0;
      paramContext.toUser = null;
      paramContext.Qmp = 0;
      paramContext.lsO = 0;
    }
    AppMethodBeat.o(244521);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(244523);
    kotlin.g.b.s.u(parama, "this$0");
    parama.GAa = null;
    AppMethodBeat.o(244523);
  }
  
  private static final void a(a parama, Context paramContext, com.tencent.mm.ui.widget.a.f paramf, int paramInt, kotlin.g.a.b paramb, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(244529);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    params.clear();
    kotlin.g.b.s.s(params, "it");
    parama.a(paramContext, params, paramf, paramInt, paramb);
    AppMethodBeat.o(244529);
  }
  
  private static final void a(a parama, t paramt, com.tencent.mm.ui.widget.a.f paramf, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(244526);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramt, "$menuItem");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramMenuItem = parama.XOo.iterator();
    kotlin.g.b.s.s(paramMenuItem, "conversationList.iterator()");
    while (paramMenuItem.hasNext())
    {
      Object localObject = paramMenuItem.next();
      kotlin.g.b.s.s(localObject, "iterator.next()");
      if (kotlin.g.b.s.p(((ForwardConversationInfo)localObject).userName, paramt.rDm)) {
        paramMenuItem.remove();
      }
    }
    paramMenuItem = parama.XOq;
    if (paramMenuItem != null) {
      parama.a(paramMenuItem, false);
    }
    paramf.ihf();
    if (parama.XOo.size() == 0)
    {
      if (3 != paramInt1) {
        break label292;
      }
      if (paramf.ageP != null) {
        paramf.ageP.setVisibility(8);
      }
    }
    paramf = paramt.rDm;
    kotlin.g.b.s.s(paramf, "menuItem.webUrl");
    if (MMApplicationContext.isMainProcess())
    {
      paramMenuItem = (PluginMessengerFoundation)h.az(PluginMessengerFoundation.class);
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.getRecentForwardInfoStorage();
        if (paramMenuItem != null) {
          paramMenuItem.bzp(paramf);
        }
      }
      label198:
      paramf = parama.GAa;
      if (paramf != null) {
        paramf.diW();
      }
      parama = parama.mContext;
      if (parama != null)
      {
        paramf = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramf = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c(parama, 14, emx.class);
        if (paramf != null)
        {
          paramf.abrd += 1;
          parama = (CharSequence)paramf.XOr;
          if ((parama != null) && (!n.bp(parama))) {
            break label329;
          }
          paramInt1 = 1;
          label272:
          if (paramInt1 == 0) {
            break label334;
          }
        }
      }
    }
    label292:
    label329:
    label334:
    for (parama = paramt.rDm;; parama = paramf.XOr + 65372 + paramt.rDm)
    {
      paramf.XOr = parama;
      AppMethodBeat.o(244526);
      return;
      if (paramf.VtC == null) {
        break;
      }
      paramf.VtC.setVisibility(8);
      break;
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramf), a..ExternalSyntheticLambda1.INSTANCE, null);
      break label198;
      paramInt1 = 0;
      break label272;
    }
  }
  
  private static final void a(a parama, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(244533);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    if (paramMenuItem == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(244533);
      throw parama;
    }
    parama.a(paramf, (t)paramMenuItem);
    AppMethodBeat.o(244533);
  }
  
  private static final void a(a parama, kotlin.g.a.b paramb, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(244531);
    kotlin.g.b.s.u(parama, "this$0");
    if (paramMenuItem == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(244531);
      throw parama;
    }
    parama.a((t)paramMenuItem, (kotlin.g.a.b)new a.b(paramb));
    AppMethodBeat.o(244531);
  }
  
  private final void a(com.tencent.mm.ui.base.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(244516);
    params.adRW.clear();
    int j = this.XOo.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        params.a(i + 10000, (CharSequence)getName(i), ((ForwardConversationInfo)this.XOo.get(i)).userName, paramBoolean);
        i += 1;
      }
    }
    AppMethodBeat.o(244516);
  }
  
  private final String getName(int paramInt)
  {
    AppMethodBeat.i(244518);
    String str2 = ((ForwardConversationInfo)this.XOo.get(paramInt)).afPR;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = ((ForwardConversationInfo)this.XOo.get(paramInt)).nickName;
    }
    if (!Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(244518);
      return str1;
    }
    str1 = ((ForwardConversationInfo)this.XOo.get(paramInt)).afPQ;
    AppMethodBeat.o(244518);
    return str1;
  }
  
  private static final void p(IPCString paramIPCString, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(244527);
    paramIPCString = paramIPCString.value;
    if (paramIPCString == null)
    {
      Log.w("MircoMsg.RecentForwardMenuHelper", "deleteInfoInForwardInfoStorage, username is null");
      AppMethodBeat.o(244527);
      return;
    }
    paramf = (PluginMessengerFoundation)h.az(PluginMessengerFoundation.class);
    if (paramf != null)
    {
      paramf = paramf.getRecentForwardInfoStorage();
      if (paramf != null) {
        paramf.bzp(paramIPCString);
      }
    }
    AppMethodBeat.o(244527);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf)
  {
    AppMethodBeat.i(244564);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    a(paramContext, params, paramf, 1, null);
    AppMethodBeat.o(244564);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, int paramInt, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(244563);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    a(paramContext, params, paramf, null, paramInt, paramb);
    AppMethodBeat.o(244563);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, u.c paramc, int paramInt, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(244559);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    this.mContext = paramContext;
    this.vlk = paramf;
    this.XOq = params;
    Object localObject = this.mContext;
    if (localObject != null)
    {
      com.tencent.mm.ui.widget.a.f localf = this.vlk;
      if (localf != null) {
        localf.agej = new a..ExternalSyntheticLambda6((Context)localObject, this);
      }
    }
    this.XOo.clear();
    if (MMApplicationContext.isMainProcess()) {}
    for (localObject = new com.tencent.mm.ui.transmit.recent.a().jEc();; localObject = com.tencent.mm.ui.transmit.recent.a.jEd())
    {
      this.XOo = ((ArrayList)localObject);
      this.XOp = this.XOo.size();
      if (this.XOo.size() != 0) {
        break;
      }
      Log.i("MircoMsg.RecentForwardMenuHelper", "addMenus return for conversationList empty!");
      if (paramb != null) {
        paramb.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(244559);
      return;
      new com.tencent.mm.ui.transmit.recent.a();
    }
    localObject = com.tencent.mm.ui.transmit.recent.b.afPU;
    com.tencent.mm.ui.transmit.recent.b.a(paramContext, paramf, paramInt);
    paramContext = com.tencent.mm.ui.transmit.recent.b.afPU;
    com.tencent.mm.ui.transmit.recent.b.a(paramf, paramc);
    a(params, false);
    if (paramb != null) {
      paramb.invoke(Boolean.TRUE);
    }
    AppMethodBeat.o(244559);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.widget.a.f paramf, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(244589);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramf, "bottomSheet");
    paramf.GAx = new a..ExternalSyntheticLambda2(this, paramContext, paramf, 4, null);
    paramf.agen = new a..ExternalSyntheticLambda5(this, paramb);
    paramf.ageo = new a..ExternalSyntheticLambda3(this, paramf);
    AppMethodBeat.o(244589);
  }
  
  public final void a(com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(244583);
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(params, "menu");
    if (paramf.isShowing())
    {
      a(params, true);
      paramf.ihf();
    }
    AppMethodBeat.o(244583);
  }
  
  public final boolean a(t paramt, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(244566);
    kotlin.g.b.s.u(paramt, "menu");
    kotlin.g.b.s.u(paramb, "callback");
    int i = paramt.getItemId() - 10000;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.XOo.size() > i)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        paramt = this.mContext;
        if (paramt != null)
        {
          localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramt = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c(paramt, 14, emx.class);
          if (paramt != null) {
            paramt.abre = (i + 1);
          }
        }
        Object localObject = ((ForwardConversationInfo)this.XOo.get(i)).userName;
        paramt = (t)localObject;
        if (localObject == null) {
          paramt = "";
        }
        paramb.invoke(paramt);
        bool1 = true;
      }
    }
    AppMethodBeat.o(244566);
    return bool1;
  }
  
  public final boolean a(com.tencent.mm.ui.widget.a.f paramf, t paramt)
  {
    AppMethodBeat.i(244577);
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramt, "menu");
    boolean bool = a(paramf, paramt, 1);
    AppMethodBeat.o(244577);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.ui.widget.a.f paramf, t paramt, int paramInt)
  {
    AppMethodBeat.i(244574);
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramt, "menu");
    boolean bool = false;
    int k = this.XOo.size();
    int i;
    int j;
    Object localObject1;
    if (k > 0)
    {
      i = 0;
      j = i + 1;
      if (kotlin.g.b.s.p(((ForwardConversationInfo)this.XOo.get(i)).userName, paramt.rDm))
      {
        localObject1 = this.GAa;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.b.a)localObject1).diW();
        }
        localObject1 = paramf.ageQ;
        if (localObject1 == null)
        {
          localObject1 = null;
          label102:
          if (localObject1 != null)
          {
            Object localObject2 = new com.tencent.mm.ui.widget.b.a(((View)localObject1).getContext());
            ((com.tencent.mm.ui.widget.b.a)localObject2).agjx = true;
            ((com.tencent.mm.ui.widget.b.a)localObject2).afLp = new a..ExternalSyntheticLambda0(this);
            Object localObject3 = ah.aiuX;
            this.GAa = ((com.tencent.mm.ui.widget.b.a)localObject2);
            localObject2 = new int[2];
            localObject2[0] = 0;
            localObject2[1] = 0;
            ((View)localObject1).getLocationInWindow((int[])localObject2);
            this.vGU = new a..ExternalSyntheticLambda4(this, paramt, paramf, paramInt);
            localObject3 = this.GAa;
            if (localObject3 != null)
            {
              com.tencent.mm.ui.transmit.recent.b localb = com.tencent.mm.ui.transmit.recent.b.afPU;
              ((com.tencent.mm.ui.widget.b.a)localObject3).b((View)localObject1, com.tencent.mm.ui.transmit.recent.b.jEe(), this.vGU, (int)(localObject2[0] + ((View)localObject1).getWidth() / 2.0F), localObject2[1]);
            }
          }
          bool = true;
          label240:
          if (j < k) {
            break label286;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(244574);
      return bool;
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label102;
      }
      localObject1 = ((RecyclerView.LayoutManager)localObject1).findViewByPosition(i);
      break label102;
      label286:
      i = j;
      break;
      break label240;
      bool = false;
    }
  }
  
  public final int getItemCount()
  {
    return this.XOp;
  }
  
  public final q iGI()
  {
    AppMethodBeat.i(244553);
    q localq = (q)new a();
    AppMethodBeat.o(244553);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a
 * JD-Core Version:    0.7.0.1
 */