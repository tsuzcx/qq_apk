package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.a.j;
import d.l;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "context", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String AXI = "snsapi_userinfo";
  private static b AXJ;
  private static int AXK = 0;
  private static WeakReference<ag.c> AXL;
  public static final ah AXM;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int jEO = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    AXM = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    jEO = 4;
    AXI = "snsapi_userinfo";
    AppMethodBeat.o(182642);
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, int paramInt, ag.c paramc)
  {
    AppMethodBeat.i(182635);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramBundle, "resp");
    d.g.b.k.h(paramc, "webviewDelegate");
    if (!(paramContext instanceof Activity))
    {
      ad.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((AXK != paramInt) && (AXJ != null))
    {
      ad.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    AXK = paramInt;
    if (AXJ == null) {
      AXJ = new b(paramContext);
    }
    paramContext = AXJ;
    if (paramContext == null) {
      d.g.b.k.fvU();
    }
    if (paramContext.AYb == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      AXL = new WeakReference(paramc);
      paramContext = AXJ;
      if (paramContext != null)
      {
        d.g.b.k.h(paramBundle, "resp");
        paramContext.AYb = paramBundle;
        paramBundle = paramBundle.getSerializable("scope_list");
        if (paramBundle == null)
        {
          paramContext = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
          AppMethodBeat.o(182635);
          throw paramContext;
          paramInt = 0;
        }
        else
        {
          paramBundle = ag.ax((ArrayList)paramBundle);
          d.g.b.k.g(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.AXq = paramBundle;
          aZ(paramContext.AXq);
          paramContext.elV();
          AppMethodBeat.o(182635);
        }
      }
      else
      {
        AppMethodBeat.o(182635);
        return;
      }
    }
    ad.i(TAG, "[showDialogQueue] repeat call");
    AppMethodBeat.o(182635);
  }
  
  public static final ArrayList<byte[]> aY(LinkedList<btv> paramLinkedList)
  {
    AppMethodBeat.i(182639);
    ArrayList localArrayList = new ArrayList();
    if (bt.gL((List)paramLinkedList))
    {
      AppMethodBeat.o(182639);
      return localArrayList;
    }
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        btv localbtv = (btv)paramLinkedList.next();
        try
        {
          localArrayList.add(localbtv.toByteArray());
        }
        catch (IOException paramLinkedList)
        {
          ad.w(TAG, "oauthAvatarListToBytesList exception");
          localArrayList.clear();
          AppMethodBeat.o(182639);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182639);
    return localArrayList;
  }
  
  private static void aZ(LinkedList<cmy> paramLinkedList)
  {
    AppMethodBeat.i(182641);
    if ((bt.gL((List)paramLinkedList)) || (paramLinkedList.size() == 1))
    {
      AppMethodBeat.o(182641);
      return;
    }
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      if (!d.g.b.k.g(((cmy)localObject).CLe, AXI)) {}
    }
    for (;;)
    {
      if (i > 0) {
        paramLinkedList.addFirst(paramLinkedList.remove(i));
      }
      AppMethodBeat.o(182641);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static ArrayList<btv> ay(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(182640);
    ArrayList localArrayList = new ArrayList();
    if (bt.gL((List)paramArrayList))
    {
      AppMethodBeat.o(182640);
      return localArrayList;
    }
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramArrayList.next();
        try
        {
          btv localbtv = new btv();
          localbtv.parseFrom(arrayOfByte);
          localArrayList.add(localbtv);
        }
        catch (IOException paramArrayList)
        {
          ad.w(TAG, "bytesListToAvatarList: exception");
          localArrayList.clear();
          AppMethodBeat.o(182640);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182640);
    return localArrayList;
  }
  
  public static final void destroy()
  {
    AppMethodBeat.i(182638);
    b localb = AXJ;
    if (localb != null) {
      localb.destroy();
    }
    AXJ = null;
    AXL = null;
    AppMethodBeat.o(182638);
  }
  
  public static int elR()
  {
    return jEO;
  }
  
  public static String elS()
  {
    return AXI;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    ah.b AXJ;
    private final i.b AXN;
    final i AXO;
    private cmy AXP;
    boolean AXQ;
    int AXR;
    int AXS;
    final e AXT;
    final Context context;
    String dlB;
    final ArrayList<o.a> jEM;
    
    public a(Context paramContext, e parame)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.AXT = parame;
      this.AXN = ((i.b)new b(this));
      this.AXO = new i(this.context, this.AXN);
      this.jEM = new ArrayList();
      this.dlB = "";
      AppMethodBeat.o(182619);
    }
    
    private final void a(i parami, List<o.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(182617);
      parami.dA(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          parami.aUK(this.context.getResources().getString(2131766177));
          parami.agO(this.context.getResources().getColor(2131099660));
        }
        for (;;)
        {
          b(parami, false);
          AppMethodBeat.o(182617);
          return;
          parami.aUK("");
        }
      }
      parami.aUK(this.context.getResources().getString(2131766177));
      parami.agO(this.context.getResources().getColor(2131100547));
      b(parami, true);
      AppMethodBeat.o(182617);
    }
    
    private final void b(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(182618);
      if (!paramBoolean)
      {
        parami.a(null);
        AppMethodBeat.o(182618);
        return;
      }
      parami.a((View.OnClickListener)new a(this));
      AppMethodBeat.o(182618);
    }
    
    public final void a(Bundle paramBundle, final cmy paramcmy)
    {
      AppMethodBeat.i(182616);
      d.g.b.k.h(paramBundle, "resp");
      d.g.b.k.h(paramcmy, "scope");
      this.AXP = paramcmy;
      Object localObject1 = this.AXO;
      ((i)localObject1).aUE(((i)localObject1).getContext().getString(2131760749, new Object[] { paramBundle.getString("appname", "") }));
      ((i)localObject1).aUF(paramcmy.Desc);
      ((i)localObject1).aUH("");
      ((i)localObject1).aUI(((i)localObject1).getContext().getResources().getString(2131760786));
      ((i)localObject1).aUJ(((i)localObject1).getContext().getResources().getString(2131760741));
      ((i)localObject1).nP(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.AXM;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.ay((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.AXQ = paramBundle.getBoolean("is_ban_modify_avatar");
      this.AXR = paramBundle.getInt("avatar_limit");
      this.AXS = 0;
      localObject1 = ag.b.aws(paramBundle.getString("oauth_url", ""));
      d.g.b.k.g(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.dlB = ((String)localObject1);
      localObject1 = paramcmy.CLe;
      Object localObject3 = ah.AXM;
      if (d.g.b.k.g(localObject1, ah.elS()))
      {
        this.AXS = i;
        paramBundle = this.AXJ;
        if (paramBundle != null) {
          paramBundle.SM(this.AXS);
        }
        this.AXO.a((o.b)new c(this));
        if (!bt.gL((List)localObject2))
        {
          this.jEM.clear();
          paramBundle = this.jEM;
          localObject1 = paramcmy.CLe;
          d.g.b.k.g(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            btv localbtv = (btv)((Iterator)localObject3).next();
            String str1 = localbtv.nickname;
            String str2 = localbtv.desc;
            if (i == localbtv.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localbtv.jEL;
              d.g.b.k.g(str3, "it.avatarurl");
              ((Collection)localObject2).add(new o.a(str1, str2, (String)localObject1, bool, str3, localbtv.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.AXO, (List)this.jEM, this.AXQ, this.AXR);
          this.AXO.a((o.c)new d(this, paramcmy));
          this.AXT.b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.AXO);
          AppMethodBeat.o(182616);
          return;
        }
        this.AXS = i;
        paramBundle = this.AXJ;
        if (paramBundle != null) {
          paramBundle.SM(this.AXS);
        }
        paramBundle = ah.AXM;
        ad.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, ah.a.e.AYa.getClass(), (com.tencent.mm.ipcinvoker.d)new f(this, paramcmy));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.AXM;
      ad.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.AXO.aUE(this.context.getString(2131760747, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.AXO;
      paramcmy = paramcmy.CLe;
      d.g.b.k.g(paramcmy, "scope.Scope");
      paramBundle.aUL(paramcmy);
      this.AXT.b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.AXO);
      AppMethodBeat.o(182616);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        paramView = new Intent();
        paramView.putExtra("0", this.AXU.dlB);
        Object localObject = this.AXU.context;
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)localObject;
        if (localObject == null)
        {
          paramView = ah.AXM;
          ad.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          AppMethodBeat.o(182605);
          return;
        }
        localObject = (Context)localObject;
        ah localah = ah.AXM;
        com.tencent.mm.bs.d.c((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, ah.elR());
        AppMethodBeat.o(182605);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
    public static final class b
      implements i.b
    {
      public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
      {
        AppMethodBeat.i(182606);
        d.g.b.k.h(paramArrayList, "select");
        Object localObject;
        switch (paramInt1)
        {
        default: 
          localObject = ah.AXM;
          ad.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.AXU.AXJ;
          if (paramArrayList != null)
          {
            paramArrayList.elV();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.AXM;
          ad.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!bt.gL((List)paramArrayList))
          {
            localObject = this.AXU.AXJ;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              d.g.b.k.g(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              d.g.b.k.h(paramArrayList, "scope");
              ((ah.b)localObject).AYd.add(paramArrayList);
            }
          }
          paramArrayList = this.AXU.AXJ;
          if (paramArrayList != null)
          {
            paramArrayList.elV();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements o.b
    {
      public final void a(o.a parama)
      {
        AppMethodBeat.i(182607);
        d.g.b.k.h(parama, "item");
        this.AXU.AXS = parama.jEi;
        parama = this.AXU.AXJ;
        if (parama != null)
        {
          parama.SM(this.AXU.AXS);
          AppMethodBeat.o(182607);
          return;
        }
        AppMethodBeat.o(182607);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements o.c
    {
      d(cmy paramcmy) {}
      
      public final void a(View paramView, final o.a parama, final int paramInt)
      {
        AppMethodBeat.i(182612);
        d.g.b.k.h(paramView, "v");
        d.g.b.k.h(parama, "item");
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
        if (paramInt == 0)
        {
          AppMethodBeat.o(182612);
          return;
        }
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new a(this);
        parama = (n.d)new b(this, paramInt, parama);
        TouchableLayout.a locala1 = TouchableLayout.HYe;
        int i = TouchableLayout.fiK();
        locala1 = TouchableLayout.HYe;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.fiL());
        AppMethodBeat.o(182612);
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.AXW.AXU.context.getResources().getString(2131761557));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements n.d
      {
        b(ah.a.d paramd, int paramInt, o.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.AXW.AXU.jEM);
          paramMenuItem.remove(paramInt);
          if (((o.a)this.AXW.AXU.jEM.get(paramInt)).jEi == this.AXW.AXU.AXS) {
            ((o.a)paramMenuItem.get(0)).hJN = true;
          }
          ah.a.a(this.AXW.AXU, this.AXW.AXU.AXO, (List)paramMenuItem, this.AXW.AXU.AXQ, this.AXW.AXU.AXR);
          Object localObject = ah.AXM;
          ad.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new zp();
          ((zp)localObject).Dbx = parama.jEi;
          b.a locala = new b.a();
          locala.c((com.tencent.mm.bx.a)localObject);
          locala.d((com.tencent.mm.bx.a)new zq());
          locala.wg("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.nB(2700);
          locala.nD(0);
          locala.nE(0);
          IPCRunCgi.a(locala.atI(), (IPCRunCgi.a)new IPCRunCgi.a()
          {
            public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
            {
              AppMethodBeat.i(182610);
              aq.f((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182609);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    this.AXZ.AXY.AXW.AXU.jEM.clear();
                    this.AXZ.AXY.AXW.AXU.jEM.addAll((Collection)this.AXZ.jEZ);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.AXZ.AXY.AXW.AXU, this.AXZ.AXY.AXW.AXU.AXO, (List)this.AXZ.AXY.AXW.AXU.jEM, this.AXZ.AXY.AXW.AXU.AXQ, this.AXZ.AXY.AXW.AXU.AXR);
                  AppMethodBeat.o(182609);
                }
              });
              AppMethodBeat.o(182610);
            }
          });
          AppMethodBeat.o(182611);
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements com.tencent.mm.ipcinvoker.d<ResultType>
    {
      f(ah.a parama, cmy paramcmy) {}
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    private e AXT;
    LinkedList<cmy> AXq;
    Bundle AYb;
    private ah.a AYc;
    final ArrayList<String> AYd;
    private int AYe;
    final Context context;
    private int goS;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(182634);
      this.context = paramContext;
      this.AXq = new LinkedList();
      this.AXT = new e(this.context);
      this.AYd = new ArrayList();
      paramContext = this.context;
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182634);
        throw paramContext;
      }
      paramContext = ((Activity)paramContext).getWindow();
      d.g.b.k.g(paramContext, "(context as Activity).window");
      View localView = paramContext.getDecorView();
      if (localView != null)
      {
        paramContext = localView;
        if (!(localView instanceof ViewGroup)) {
          paramContext = null;
        }
        paramContext = (ViewGroup)paramContext;
        if (paramContext != null)
        {
          paramContext.addView((View)this.AXT);
          AppMethodBeat.o(182634);
          return;
        }
        AppMethodBeat.o(182634);
        return;
      }
      AppMethodBeat.o(182634);
    }
    
    private final void dhV()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.AYb;
      if (localObject != null) {}
      final String str;
      for (localObject = ((Bundle)localObject).getString("oauth_url", "");; localObject = null)
      {
        str = ag.b.aws((String)localObject);
        if (!bt.gL((List)this.AYd)) {
          break;
        }
        localObject = ah.AXM;
        ad.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.BwR;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.j.b.BwR.aC(2, (int)(System.currentTimeMillis() - ag.b.AXt), 0);
        reject();
        AppMethodBeat.o(182631);
        return;
      }
      c.a(this.context, com.tencent.mm.model.gdpr.a.gQb, str, (com.tencent.mm.model.gdpr.b)new b(this, str));
      AppMethodBeat.o(182631);
    }
    
    private final boolean elW()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (bt.gL((List)this.AXq))
      {
        localah = ah.AXM;
        ad.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.goS >= this.AXq.size())
      {
        localah = ah.AXM;
        ad.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    private final void reject()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.AXM;
      ad.i(ah.getTAG(), "[OauthQueue.reject] reject");
      SN(2);
      localObject = ah.AXM;
      localObject = ah.elU();
      if (localObject != null)
      {
        localObject = (ag.c)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((ag.c)localObject).goBack();
          AppMethodBeat.o(182632);
          return;
        }
      }
      AppMethodBeat.o(182632);
    }
    
    public final void SM(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.AYe = paramInt;
      ah localah = ah.AXM;
      ad.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void SN(int paramInt)
    {
      AppMethodBeat.i(182633);
      btr localbtr = new btr();
      Object localObject = this.AYb;
      if (localObject != null)
      {
        String str = ((Bundle)localObject).getString("oauth_url", "");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localbtr.DRh = ((String)localObject);
      localbtr.DRi = paramInt;
      localbtr.DRj.addAll((Collection)this.AYd);
      localbtr.Dbx = this.AYe;
      localObject = ah.AXM;
      ad.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localbtr.DRj + ", avatarId = " + this.AYe);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)localbtr);
      ((b.a)localObject).d((com.tencent.mm.bx.a)new bts());
      ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((b.a)localObject).nB(1373);
      ((b.a)localObject).nD(0);
      ((b.a)localObject).nE(0);
      IPCRunCgi.a(((b.a)localObject).atI(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.AXT != null)
      {
        e locale = this.AXT;
        if (locale != null) {
          locale.fQX();
        }
        this.AXT = null;
        this.AYc = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void elV()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.AYc != null)
      {
        localObject1 = this.AYc;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).AXO;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.AXT;
          if (localObject3 != null)
          {
            ah.a locala = this.AYc;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.AXO;
            }
            ((e)localObject3).c((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject1);
          }
        }
        if (!elW()) {
          break;
        }
        dhV();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context;
      localObject2 = this.AXT;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = new ah.a((Context)localObject1, (e)localObject2);
      ((ah.a)localObject1).AXJ = ((b)this);
      localObject2 = this.AYb;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      Object localObject3 = this.AXq.get(this.goS);
      d.g.b.k.g(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (cmy)localObject3);
      this.AYc = ((ah.a)localObject1);
      this.goS += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(ah.b paramb) {}
      
      public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
      {
        AppMethodBeat.i(182624);
        aq.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182623);
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              Object localObject = paramb;
              d.g.b.k.g(localObject, "rr");
              localObject = ((com.tencent.mm.al.b)localObject).auM();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (bts)localObject;
              if (!bt.isNullOrNil(((bts)localObject).CzB))
              {
                ah localah = ah.AXM;
                localObject = ((bts)localObject).CzB;
                d.g.b.k.g(localObject, "rsp.redirect_url");
                ah.awt((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.AYg.AYf.context, paramString, aj.getContext().getString(2131766178), (DialogInterface.OnClickListener)1.AYh);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void ns(final int paramInt)
      {
        AppMethodBeat.i(182626);
        com.tencent.mm.cj.a.y((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182625);
            Object localObject1;
            com.tencent.mm.plugin.webview.j.b localb;
            Object localObject2;
            if (paramInt == 1)
            {
              localObject1 = ah.AXM;
              ad.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.j.b.BwR;
              localObject2 = this.AYj.AYi;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.AXM;
              ah.elT();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.j.b.BwR.aC(2, (int)(System.currentTimeMillis() - ag.b.AXt), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.AXM;
              ad.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.j.b.BwR;
              localObject2 = this.AYj.AYi;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.AYj.AYf;
              localObject2 = ((ah.b)localObject1).AYb;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.AXM;
                ad.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).SN(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).AYb;
              if (localObject1 != null)
              {
                localObject2 = ((Bundle)localObject1).getString("redirect_url");
                localObject1 = localObject2;
                if (localObject2 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              localObject2 = ah.AXM;
              ah.awt((String)localObject1);
            }
          }
        });
        AppMethodBeat.o(182626);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */