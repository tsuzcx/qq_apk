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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "context", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String Elu = "snsapi_userinfo";
  private static b Elv;
  private static int Elw = 0;
  private static WeakReference<ag.c> Elx;
  public static final ah Ely;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int kDo = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    Ely = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    kDo = 4;
    Elu = "snsapi_userinfo";
    AppMethodBeat.o(182642);
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, int paramInt, ag.c paramc)
  {
    AppMethodBeat.i(182635);
    p.h(paramContext, "context");
    p.h(paramBundle, "resp");
    p.h(paramc, "webviewDelegate");
    if (!(paramContext instanceof Activity))
    {
      ae.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((Elw != paramInt) && (Elv != null))
    {
      ae.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    Elw = paramInt;
    if (Elv == null) {
      Elv = new b(paramContext);
    }
    paramContext = Elv;
    if (paramContext == null) {
      p.gkB();
    }
    if (paramContext.ElN == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      Elx = new WeakReference(paramc);
      paramContext = Elv;
      if (paramContext != null)
      {
        p.h(paramBundle, "resp");
        paramContext.ElN = paramBundle;
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
          paramBundle = ag.aH((ArrayList)paramBundle);
          p.g(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.Elb = paramBundle;
          bi(paramContext.Elb);
          paramContext.eTV();
          AppMethodBeat.o(182635);
        }
      }
      else
      {
        AppMethodBeat.o(182635);
        return;
      }
    }
    ae.i(TAG, "[showDialogQueue] repeat call");
    AppMethodBeat.o(182635);
  }
  
  public static ArrayList<cdx> aI(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(182640);
    ArrayList localArrayList = new ArrayList();
    if (bu.ht((List)paramArrayList))
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
          cdx localcdx = new cdx();
          localcdx.parseFrom(arrayOfByte);
          localArrayList.add(localcdx);
        }
        catch (IOException paramArrayList)
        {
          ae.w(TAG, "bytesListToAvatarList: exception");
          localArrayList.clear();
          AppMethodBeat.o(182640);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182640);
    return localArrayList;
  }
  
  public static final ArrayList<byte[]> bh(LinkedList<cdx> paramLinkedList)
  {
    AppMethodBeat.i(182639);
    ArrayList localArrayList = new ArrayList();
    if (bu.ht((List)paramLinkedList))
    {
      AppMethodBeat.o(182639);
      return localArrayList;
    }
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        cdx localcdx = (cdx)paramLinkedList.next();
        try
        {
          localArrayList.add(localcdx.toByteArray());
        }
        catch (IOException paramLinkedList)
        {
          ae.w(TAG, "oauthAvatarListToBytesList exception");
          localArrayList.clear();
          AppMethodBeat.o(182639);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182639);
    return localArrayList;
  }
  
  private static void bi(LinkedList<cyg> paramLinkedList)
  {
    AppMethodBeat.i(182641);
    if ((bu.ht((List)paramLinkedList)) || (paramLinkedList.size() == 1))
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
        j.gkd();
      }
      if (!p.i(((cyg)localObject).GcE, Elu)) {}
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
  
  public static final void destroy()
  {
    AppMethodBeat.i(182638);
    b localb = Elv;
    if (localb != null) {
      localb.destroy();
    }
    Elv = null;
    Elx = null;
    AppMethodBeat.o(182638);
  }
  
  public static int eTR()
  {
    return kDo;
  }
  
  public static String eTS()
  {
    return Elu;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    final i ElA;
    private cyg ElB;
    boolean ElC;
    int ElD;
    int ElE;
    final e ElF;
    ah.b Elv;
    private final i.b Elz;
    final Context context;
    String dwb;
    final ArrayList<o.a> kDm;
    
    public a(Context paramContext, e parame)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.ElF = parame;
      this.Elz = ((i.b)new b(this));
      this.ElA = new i(this.context, (b.c)this.Elz);
      this.kDm = new ArrayList();
      this.dwb = "";
      AppMethodBeat.o(182619);
    }
    
    private final void a(i parami, List<o.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(182617);
      parami.setSelectListItem(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          parami.setFunctionButtonText(this.context.getResources().getString(2131766177));
          parami.setFunctionButtonTextColor(this.context.getResources().getColor(2131099660));
        }
        for (;;)
        {
          b(parami, false);
          AppMethodBeat.o(182617);
          return;
          parami.setFunctionButtonText("");
        }
      }
      parami.setFunctionButtonText(this.context.getResources().getString(2131766177));
      parami.setFunctionButtonTextColor(this.context.getResources().getColor(2131100547));
      b(parami, true);
      AppMethodBeat.o(182617);
    }
    
    private final void b(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(182618);
      if (!paramBoolean)
      {
        parami.setFunctionButtonOnClickListener(null);
        AppMethodBeat.o(182618);
        return;
      }
      parami.setFunctionButtonOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(182618);
    }
    
    public final void a(Bundle paramBundle, final cyg paramcyg)
    {
      AppMethodBeat.i(182616);
      p.h(paramBundle, "resp");
      p.h(paramcyg, "scope");
      this.ElB = paramcyg;
      this.ElA.setPosition(2);
      Object localObject1 = this.ElA;
      ((i)localObject1).setAppBrandName(((i)localObject1).getContext().getString(2131760749, new Object[] { paramBundle.getString("appname", "") }));
      ((i)localObject1).setRequestDesc(paramcyg.Desc);
      ((i)localObject1).setApplyWording("");
      ((i)localObject1).setNegativeButtonText(((i)localObject1).getContext().getResources().getString(2131760786));
      ((i)localObject1).setPositiveButtonText(((i)localObject1).getContext().getResources().getString(2131760741));
      ((i)localObject1).setIconUrl(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.Ely;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.aI((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.ElC = paramBundle.getBoolean("is_ban_modify_avatar");
      this.ElD = paramBundle.getInt("avatar_limit");
      this.ElE = 0;
      localObject1 = ag.b.aID(paramBundle.getString("oauth_url", ""));
      p.g(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.dwb = ((String)localObject1);
      localObject1 = paramcyg.GcE;
      Object localObject3 = ah.Ely;
      if (p.i(localObject1, ah.eTS()))
      {
        this.ElE = i;
        paramBundle = this.Elv;
        if (paramBundle != null) {
          paramBundle.Xr(this.ElE);
        }
        this.ElA.setItemCheckedListener((o.b)new c(this));
        if (!bu.ht((List)localObject2))
        {
          this.kDm.clear();
          paramBundle = this.kDm;
          localObject1 = paramcyg.GcE;
          p.g(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            cdx localcdx = (cdx)((Iterator)localObject3).next();
            String str1 = localcdx.nickname;
            String str2 = localcdx.desc;
            if (i == localcdx.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localcdx.kDl;
              p.g(str3, "it.avatarurl");
              ((Collection)localObject2).add(new o.a(str1, str2, (String)localObject1, bool, str3, localcdx.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.ElA, (List)this.kDm, this.ElC, this.ElD);
          this.ElA.setOnListItemLongClickListener((o.c)new d(this, paramcyg));
          this.ElF.b((k)this.ElA);
          AppMethodBeat.o(182616);
          return;
        }
        this.ElE = i;
        paramBundle = this.Elv;
        if (paramBundle != null) {
          paramBundle.Xr(this.ElE);
        }
        paramBundle = ah.Ely;
        ae.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, ah.a.e.ElM.getClass(), (com.tencent.mm.ipcinvoker.d)new f(this, paramcyg));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.Ely;
      ae.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.ElA.setAppBrandName(this.context.getString(2131760747, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.ElA;
      paramcyg = paramcyg.GcE;
      p.g(paramcyg, "scope.Scope");
      paramBundle.setScope(paramcyg);
      this.ElF.b((k)this.ElA);
      AppMethodBeat.o(182616);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = new Intent();
        paramView.putExtra("0", this.ElG.dwb);
        localObject = this.ElG.context;
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)localObject;
        if (localObject == null)
        {
          paramView = ah.Ely;
          ae.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182605);
          return;
        }
        localObject = (Context)localObject;
        ah localah = ah.Ely;
        com.tencent.mm.br.d.c((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, ah.eTR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(182605);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
    public static final class b
      implements i.b
    {
      public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
      {
        AppMethodBeat.i(182606);
        p.h(paramArrayList, "select");
        Object localObject;
        switch (paramInt1)
        {
        default: 
          localObject = ah.Ely;
          ae.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.ElG.Elv;
          if (paramArrayList != null)
          {
            paramArrayList.eTV();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.Ely;
          ae.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!bu.ht((List)paramArrayList))
          {
            localObject = this.ElG.Elv;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              p.g(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              p.h(paramArrayList, "scope");
              ((ah.b)localObject).ElP.add(paramArrayList);
            }
          }
          paramArrayList = this.ElG.Elv;
          if (paramArrayList != null)
          {
            paramArrayList.eTV();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements o.b
    {
      public final void a(o.a parama)
      {
        AppMethodBeat.i(182607);
        p.h(parama, "item");
        this.ElG.ElE = parama.kCD;
        parama = this.ElG.Elv;
        if (parama != null)
        {
          parama.Xr(this.ElG.ElE);
          AppMethodBeat.o(182607);
          return;
        }
        AppMethodBeat.o(182607);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements o.c
    {
      d(cyg paramcyg) {}
      
      public final void a(View paramView, final o.a parama, final int paramInt)
      {
        AppMethodBeat.i(182612);
        p.h(paramView, "v");
        p.h(parama, "item");
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
        if (paramInt == 0)
        {
          AppMethodBeat.o(182612);
          return;
        }
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new a(this);
        parama = (n.e)new b(this, paramInt, parama);
        TouchableLayout.a locala1 = TouchableLayout.LOL;
        int i = TouchableLayout.fUD();
        locala1 = TouchableLayout.LOL;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.fUE());
        AppMethodBeat.o(182612);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.ElI.ElG.context.getResources().getString(2131761557));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements n.e
      {
        b(ah.a.d paramd, int paramInt, o.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.ElI.ElG.kDm);
          paramMenuItem.remove(paramInt);
          if (((o.a)this.ElI.ElG.kDm.get(paramInt)).kCD == this.ElI.ElG.ElE) {
            ((o.a)paramMenuItem.get(0)).iGv = true;
          }
          ah.a.a(this.ElI.ElG, this.ElI.ElG.ElA, (List)paramMenuItem, this.ElI.ElG.ElC, this.ElI.ElG.ElD);
          Object localObject = ah.Ely;
          ae.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new acx();
          ((acx)localObject).GuE = parama.kCD;
          b.a locala = new b.a();
          locala.c((com.tencent.mm.bw.a)localObject);
          locala.d((com.tencent.mm.bw.a)new acy());
          locala.DN("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.oS(2700);
          locala.oU(0);
          locala.oV(0);
          IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new IPCRunCgi.a()
          {
            public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
            {
              AppMethodBeat.i(182610);
              ar.f((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182609);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    this.ElL.ElK.ElI.ElG.kDm.clear();
                    this.ElL.ElK.ElI.ElG.kDm.addAll((Collection)this.ElL.kDz);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.ElL.ElK.ElI.ElG, this.ElL.ElK.ElI.ElG.ElA, (List)this.ElL.ElK.ElI.ElG.kDm, this.ElL.ElK.ElI.ElG.ElC, this.ElL.ElK.ElI.ElG.ElD);
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements com.tencent.mm.ipcinvoker.d<ResultType>
    {
      f(ah.a parama, cyg paramcyg) {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    private e ElF;
    Bundle ElN;
    private ah.a ElO;
    final ArrayList<String> ElP;
    private int ElQ;
    LinkedList<cyg> Elb;
    final Context context;
    private int rss;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(182634);
      this.context = paramContext;
      this.Elb = new LinkedList();
      this.ElF = new e(this.context);
      this.ElP = new ArrayList();
      paramContext = this.context;
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182634);
        throw paramContext;
      }
      paramContext = ((Activity)paramContext).getWindow();
      p.g(paramContext, "(context as Activity).window");
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
          paramContext.addView((View)this.ElF);
          AppMethodBeat.o(182634);
          return;
        }
        AppMethodBeat.o(182634);
        return;
      }
      AppMethodBeat.o(182634);
    }
    
    private final void dJv()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.ElN;
      if (localObject != null) {}
      final String str;
      for (localObject = ((Bundle)localObject).getString("oauth_url", "");; localObject = null)
      {
        str = ag.b.aID((String)localObject);
        if (!bu.ht((List)this.ElP)) {
          break;
        }
        localObject = ah.Ely;
        ae.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.ELt;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.j.b.ELt.aG(2, (int)(System.currentTimeMillis() - ag.b.Ele), 0);
        reject();
        AppMethodBeat.o(182631);
        return;
      }
      c.a(this.context, com.tencent.mm.model.gdpr.a.hLM, str, (com.tencent.mm.model.gdpr.b)new b(this, str));
      AppMethodBeat.o(182631);
    }
    
    private final boolean eTW()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (bu.ht((List)this.Elb))
      {
        localah = ah.Ely;
        ae.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.rss >= this.Elb.size())
      {
        localah = ah.Ely;
        ae.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    private final void reject()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.Ely;
      ae.i(ah.getTAG(), "[OauthQueue.reject] reject");
      Xs(2);
      localObject = ah.Ely;
      localObject = ah.eTU();
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
    
    public final void Xr(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.ElQ = paramInt;
      ah localah = ah.Ely;
      ae.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void Xs(int paramInt)
    {
      AppMethodBeat.i(182633);
      cdt localcdt = new cdt();
      Object localObject = this.ElN;
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
      localcdt.HqI = ((String)localObject);
      localcdt.HqJ = paramInt;
      localcdt.HqK.addAll((Collection)this.ElP);
      localcdt.GuE = this.ElQ;
      localObject = ah.Ely;
      ae.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localcdt.HqK + ", avatarId = " + this.ElQ);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bw.a)localcdt);
      ((b.a)localObject).d((com.tencent.mm.bw.a)new cdu());
      ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((b.a)localObject).oS(1373);
      ((b.a)localObject).oU(0);
      ((b.a)localObject).oV(0);
      IPCRunCgi.a(((b.a)localObject).aDS(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.ElF != null)
      {
        e locale = this.ElF;
        if (locale != null) {
          locale.bEI();
        }
        this.ElF = null;
        this.ElO = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void eTV()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.ElO != null)
      {
        localObject1 = this.ElO;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).ElA;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.ElF;
          if (localObject3 != null)
          {
            ah.a locala = this.ElO;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.ElA;
            }
            ((e)localObject3).c((k)localObject1);
          }
        }
        if (!eTW()) {
          break;
        }
        dJv();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context;
      localObject2 = this.ElF;
      if (localObject2 == null) {
        p.gkB();
      }
      localObject1 = new ah.a((Context)localObject1, (e)localObject2);
      ((ah.a)localObject1).Elv = ((b)this);
      localObject2 = this.ElN;
      if (localObject2 == null) {
        p.gkB();
      }
      Object localObject3 = this.Elb.get(this.rss);
      p.g(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (cyg)localObject3);
      this.ElO = ((ah.a)localObject1);
      this.rss += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(ah.b paramb) {}
      
      public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
      {
        AppMethodBeat.i(182624);
        ar.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182623);
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              Object localObject = paramb;
              p.g(localObject, "rr");
              localObject = ((com.tencent.mm.ak.b)localObject).aEV();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (cdu)localObject;
              if (!bu.isNullOrNil(((cdu)localObject).FPO))
              {
                ah localah = ah.Ely;
                localObject = ((cdu)localObject).FPO;
                p.g(localObject, "rsp.redirect_url");
                ah.aIE((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.ElS.ElR.context, paramString, ak.getContext().getString(2131766178), (DialogInterface.OnClickListener)1.ElT);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void oJ(final int paramInt)
      {
        AppMethodBeat.i(182626);
        com.tencent.mm.ch.a.x((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182625);
            Object localObject1;
            com.tencent.mm.plugin.webview.j.b localb;
            Object localObject2;
            if (paramInt == 1)
            {
              localObject1 = ah.Ely;
              ae.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.j.b.ELt;
              localObject2 = this.ElV.ElU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.Ely;
              ah.eTT();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.j.b.ELt.aG(2, (int)(System.currentTimeMillis() - ag.b.Ele), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.Ely;
              ae.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.j.b.ELt;
              localObject2 = this.ElV.ElU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.ElV.ElR;
              localObject2 = ((ah.b)localObject1).ElN;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.Ely;
                ae.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).Xs(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).ElN;
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
              localObject2 = ah.Ely;
              ah.aIE((String)localObject1);
            }
          }
        });
        AppMethodBeat.o(182626);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */