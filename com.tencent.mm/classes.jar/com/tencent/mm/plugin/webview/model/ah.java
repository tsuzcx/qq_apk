package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.MutableContextWrapper;
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
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "ct", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String IYu = "snsapi_userinfo";
  private static b IYv;
  private static int IYw = 0;
  private static WeakReference<ag.c> IYx;
  public static final ah IYy;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int lHP = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    IYy = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    lHP = 4;
    IYu = "snsapi_userinfo";
    AppMethodBeat.o(182642);
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, int paramInt, ag.c paramc)
  {
    AppMethodBeat.i(182635);
    p.h(paramContext, "ct");
    p.h(paramBundle, "resp");
    p.h(paramc, "webviewDelegate");
    Context localContext = paramContext;
    if ((paramContext instanceof MutableContextWrapper))
    {
      localContext = ((MutableContextWrapper)paramContext).getBaseContext();
      p.g(localContext, "(ct as MutableContextWrapper).baseContext");
    }
    if (!(localContext instanceof Activity))
    {
      Log.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((IYw != paramInt) && (IYv != null))
    {
      Log.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    IYw = paramInt;
    if (IYv == null) {
      IYv = new b(localContext);
    }
    paramContext = IYv;
    if (paramContext == null) {
      p.hyc();
    }
    if (paramContext.IYN == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      IYx = new WeakReference(paramc);
      paramContext = IYv;
      if (paramContext != null)
      {
        p.h(paramBundle, "resp");
        paramContext.IYN = paramBundle;
        paramBundle = paramBundle.getSerializable("scope_list");
        if (paramBundle == null)
        {
          paramContext = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
          AppMethodBeat.o(182635);
          throw paramContext;
          paramInt = 0;
        }
        else
        {
          paramBundle = ag.aZ((ArrayList)paramBundle);
          p.g(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.IXZ = paramBundle;
          bD(paramContext.IXZ);
          paramContext.gcI();
          AppMethodBeat.o(182635);
        }
      }
      else
      {
        AppMethodBeat.o(182635);
        return;
      }
    }
    Log.i(TAG, "[showDialogQueue] repeat call");
    AppMethodBeat.o(182635);
  }
  
  public static final ArrayList<byte[]> bC(LinkedList<cue> paramLinkedList)
  {
    AppMethodBeat.i(182639);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil((List)paramLinkedList))
    {
      AppMethodBeat.o(182639);
      return localArrayList;
    }
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        cue localcue = (cue)paramLinkedList.next();
        try
        {
          localArrayList.add(localcue.toByteArray());
        }
        catch (IOException paramLinkedList)
        {
          Log.w(TAG, "oauthAvatarListToBytesList exception");
          localArrayList.clear();
          AppMethodBeat.o(182639);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182639);
    return localArrayList;
  }
  
  private static void bD(LinkedList<drb> paramLinkedList)
  {
    AppMethodBeat.i(182641);
    if ((Util.isNullOrNil((List)paramLinkedList)) || (paramLinkedList.size() == 1))
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
        j.hxH();
      }
      if (!p.j(((drb)localObject).KWK, IYu)) {}
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
  
  public static ArrayList<cue> ba(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(182640);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil((List)paramArrayList))
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
          cue localcue = new cue();
          localcue.parseFrom(arrayOfByte);
          localArrayList.add(localcue);
        }
        catch (IOException paramArrayList)
        {
          Log.w(TAG, "bytesListToAvatarList: exception");
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
    b localb = IYv;
    if (localb != null) {
      localb.destroy();
    }
    IYv = null;
    IYx = null;
    AppMethodBeat.o(182638);
  }
  
  public static int gcE()
  {
    return lHP;
  }
  
  public static String gcF()
  {
    return IYu;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.appbrand.widget.dialog.h IYA;
    private drb IYB;
    boolean IYC;
    int IYD;
    int IYE;
    final e IYF;
    ah.b IYv;
    private final h.b IYz;
    final Context context;
    String dNI;
    final ArrayList<i.a> lHN;
    
    public a(Context paramContext, e parame)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.IYF = parame;
      this.IYz = ((h.b)new b(this));
      this.IYA = new com.tencent.mm.plugin.appbrand.widget.dialog.h(this.context, (b.c)this.IYz);
      this.lHN = new ArrayList();
      this.dNI = "";
      AppMethodBeat.o(182619);
    }
    
    private final void a(com.tencent.mm.plugin.appbrand.widget.dialog.h paramh, List<i.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(182617);
      paramh.setSelectListItem(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          paramh.setFunctionButtonText(this.context.getResources().getString(2131768653));
          paramh.setFunctionButtonTextColor(this.context.getResources().getColor(2131099662));
        }
        for (;;)
        {
          b(paramh, false);
          AppMethodBeat.o(182617);
          return;
          paramh.setFunctionButtonText("");
        }
      }
      paramh.setFunctionButtonText(this.context.getResources().getString(2131768653));
      paramh.setFunctionButtonTextColor(this.context.getResources().getColor(2131100685));
      b(paramh, true);
      AppMethodBeat.o(182617);
    }
    
    private final void b(com.tencent.mm.plugin.appbrand.widget.dialog.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(182618);
      if (!paramBoolean)
      {
        paramh.setFunctionButtonOnClickListener(null);
        AppMethodBeat.o(182618);
        return;
      }
      paramh.setFunctionButtonOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(182618);
    }
    
    public final void a(Bundle paramBundle, final drb paramdrb)
    {
      AppMethodBeat.i(182616);
      p.h(paramBundle, "resp");
      p.h(paramdrb, "scope");
      this.IYB = paramdrb;
      this.IYA.setPosition(2);
      Object localObject1 = this.IYA;
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setAppBrandName(((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).getContext().getString(2131762495, new Object[] { paramBundle.getString("appname", "") }));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setRequestDesc(paramdrb.Desc);
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setApplyWording("");
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setNegativeButtonText(((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).getContext().getResources().getString(2131762538));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setPositiveButtonText(((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).getContext().getResources().getString(2131762482));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.h)localObject1).setIconUrl(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.IYy;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.ba((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.IYC = paramBundle.getBoolean("is_ban_modify_avatar");
      this.IYD = paramBundle.getInt("avatar_limit");
      this.IYE = 0;
      localObject1 = ag.b.aYE(paramBundle.getString("oauth_url", ""));
      p.g(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.dNI = ((String)localObject1);
      localObject1 = paramdrb.KWK;
      Object localObject3 = ah.IYy;
      if (p.j(localObject1, ah.gcF()))
      {
        this.IYE = i;
        paramBundle = this.IYv;
        if (paramBundle != null) {
          paramBundle.afZ(this.IYE);
        }
        this.IYA.setItemCheckedListener((i.b)new c(this));
        if (!Util.isNullOrNil((List)localObject2))
        {
          this.lHN.clear();
          paramBundle = this.lHN;
          localObject1 = paramdrb.KWK;
          p.g(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            cue localcue = (cue)((Iterator)localObject3).next();
            String str1 = localcue.nickname;
            String str2 = localcue.desc;
            if (i == localcue.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localcue.lHM;
              p.g(str3, "it.avatarurl");
              ((Collection)localObject2).add(new i.a(str1, str2, (String)localObject1, bool, str3, localcue.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.IYA, (List)this.lHN, this.IYC, this.IYD);
          this.IYA.setOnListItemLongClickListener((i.d)new d(this, paramdrb));
          this.IYF.b((k)this.IYA);
          AppMethodBeat.o(182616);
          return;
        }
        this.IYE = i;
        paramBundle = this.IYv;
        if (paramBundle != null) {
          paramBundle.afZ(this.IYE);
        }
        paramBundle = ah.IYy;
        Log.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getApplicationId(), null, ah.a.e.IYM.getClass(), (com.tencent.mm.ipcinvoker.d)new f(this, paramdrb));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.IYy;
      Log.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.IYA.setAppBrandName(this.context.getString(2131762493, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.IYA;
      paramdrb = paramdrb.KWK;
      p.g(paramdrb, "scope.Scope");
      paramBundle.setScope(paramdrb);
      this.IYF.b((k)this.IYA);
      AppMethodBeat.o(182616);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = new Intent();
        paramView.putExtra("0", this.IYG.dNI);
        localObject = this.IYG.context;
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)localObject;
        if (localObject == null)
        {
          paramView = ah.IYy;
          Log.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182605);
          return;
        }
        localObject = (Context)localObject;
        ah localah = ah.IYy;
        com.tencent.mm.br.c.c((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, ah.gcE());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(182605);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
    public static final class b
      implements h.b
    {
      public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
      {
        AppMethodBeat.i(182606);
        p.h(paramArrayList, "select");
        Object localObject;
        switch (paramInt1)
        {
        default: 
          localObject = ah.IYy;
          Log.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.IYG.IYv;
          if (paramArrayList != null)
          {
            paramArrayList.gcI();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.IYy;
          Log.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!Util.isNullOrNil((List)paramArrayList))
          {
            localObject = this.IYG.IYv;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              p.g(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              p.h(paramArrayList, "scope");
              ((ah.b)localObject).IYP.add(paramArrayList);
            }
          }
          paramArrayList = this.IYG.IYv;
          if (paramArrayList != null)
          {
            paramArrayList.gcI();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements i.b
    {
      public final void a(i.a parama)
      {
        AppMethodBeat.i(210346);
        p.h(parama, "item");
        this.IYG.IYE = parama.lGW;
        parama = this.IYG.IYv;
        if (parama != null)
        {
          parama.afZ(this.IYG.IYE);
          AppMethodBeat.o(210346);
          return;
        }
        AppMethodBeat.o(210346);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements i.d
    {
      d(drb paramdrb) {}
      
      public final void a(View paramView, final i.a parama, final int paramInt)
      {
        AppMethodBeat.i(210347);
        p.h(paramView, "v");
        p.h(parama, "item");
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
        if (paramInt == 0)
        {
          AppMethodBeat.o(210347);
          return;
        }
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new a(this);
        parama = (o.g)new b(this, paramInt, parama);
        TouchableLayout.a locala1 = TouchableLayout.Rni;
        int i = TouchableLayout.hfC();
        locala1 = TouchableLayout.Rni;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.hfD());
        AppMethodBeat.o(210347);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.IYI.IYG.context.getResources().getString(2131763523));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements o.g
      {
        b(ah.a.d paramd, int paramInt, i.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.IYI.IYG.lHN);
          paramMenuItem.remove(paramInt);
          if (((i.a)this.IYI.IYG.lHN.get(paramInt)).lGW == this.IYI.IYG.IYE) {
            ((i.a)paramMenuItem.get(0)).jCx = true;
          }
          ah.a.a(this.IYI.IYG, this.IYI.IYG.IYA, (List)paramMenuItem, this.IYI.IYG.IYC, this.IYI.IYG.IYD);
          Object localObject = ah.IYy;
          Log.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new afa();
          ((afa)localObject).Lqj = parama.lGW;
          d.a locala = new d.a();
          locala.c((com.tencent.mm.bw.a)localObject);
          locala.d((com.tencent.mm.bw.a)new afb());
          locala.MB("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.sG(2700);
          locala.sI(0);
          locala.sJ(0);
          IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)new IPCRunCgi.a()
          {
            public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
            {
              AppMethodBeat.i(182610);
              MMHandlerThread.postToMainThread((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182609);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    this.IYL.IYK.IYI.IYG.lHN.clear();
                    this.IYL.IYK.IYI.IYG.lHN.addAll((Collection)this.IYL.lIa);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.IYL.IYK.IYI.IYG, this.IYL.IYK.IYI.IYG.IYA, (List)this.IYL.IYK.IYI.IYG.lHN, this.IYL.IYK.IYI.IYG.IYC, this.IYL.IYK.IYI.IYG.IYD);
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements com.tencent.mm.ipcinvoker.d<ResultType>
    {
      f(ah.a parama, drb paramdrb) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    LinkedList<drb> IXZ;
    private e IYF;
    Bundle IYN;
    private ah.a IYO;
    final ArrayList<String> IYP;
    private int IYQ;
    final Context context;
    private int sTB;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(182634);
      this.context = paramContext;
      this.IXZ = new LinkedList();
      this.IYF = new e(this.context);
      this.IYP = new ArrayList();
      paramContext = this.context;
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.app.Activity");
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
          paramContext.addView((View)this.IYF);
          AppMethodBeat.o(182634);
          return;
        }
        AppMethodBeat.o(182634);
        return;
      }
      AppMethodBeat.o(182634);
    }
    
    private final void eKh()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.IYN;
      if (localObject != null) {}
      final String str;
      for (localObject = ((Bundle)localObject).getString("oauth_url", "");; localObject = null)
      {
        str = ag.b.aYE((String)localObject);
        if (!Util.isNullOrNil((List)this.IYP)) {
          break;
        }
        localObject = ah.IYy;
        Log.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.JBk;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.k.b.JBk.aO(2, (int)(System.currentTimeMillis() - ag.b.IYc), 0);
        reject();
        AppMethodBeat.o(182631);
        return;
      }
      com.tencent.mm.model.gdpr.c.a(this.context, com.tencent.mm.model.gdpr.a.iGO, str, (com.tencent.mm.model.gdpr.b)new b(this, str));
      AppMethodBeat.o(182631);
    }
    
    private final boolean gcJ()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (Util.isNullOrNil((List)this.IXZ))
      {
        localah = ah.IYy;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.sTB >= this.IXZ.size())
      {
        localah = ah.IYy;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    private final void reject()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.IYy;
      Log.i(ah.getTAG(), "[OauthQueue.reject] reject");
      aga(2);
      localObject = ah.IYy;
      localObject = ah.gcH();
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
    
    public final void afZ(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.IYQ = paramInt;
      ah localah = ah.IYy;
      Log.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void aga(int paramInt)
    {
      AppMethodBeat.i(182633);
      cua localcua = new cua();
      Object localObject = this.IYN;
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
      localcua.Mzp = ((String)localObject);
      localcua.Mzq = paramInt;
      localcua.Mzr.addAll((Collection)this.IYP);
      localcua.Lqj = this.IYQ;
      localObject = ah.IYy;
      Log.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localcua.Mzr + ", avatarId = " + this.IYQ);
      localObject = new d.a();
      ((d.a)localObject).c((com.tencent.mm.bw.a)localcua);
      ((d.a)localObject).d((com.tencent.mm.bw.a)new cub());
      ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((d.a)localObject).sG(1373);
      ((d.a)localObject).sI(0);
      ((d.a)localObject).sJ(0);
      IPCRunCgi.a(((d.a)localObject).aXF(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.IYF != null)
      {
        e locale = this.IYF;
        if (locale != null) {
          locale.caW();
        }
        this.IYF = null;
        this.IYO = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void gcI()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.IYO != null)
      {
        localObject1 = this.IYO;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).IYA;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.IYF;
          if (localObject3 != null)
          {
            ah.a locala = this.IYO;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.IYA;
            }
            ((e)localObject3).c((k)localObject1);
          }
        }
        if (!gcJ()) {
          break;
        }
        eKh();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context;
      localObject2 = this.IYF;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject1 = new ah.a((Context)localObject1, (e)localObject2);
      ((ah.a)localObject1).IYv = ((b)this);
      localObject2 = this.IYN;
      if (localObject2 == null) {
        p.hyc();
      }
      Object localObject3 = this.IXZ.get(this.sTB);
      p.g(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (drb)localObject3);
      this.IYO = ((ah.a)localObject1);
      this.sTB += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(ah.b paramb) {}
      
      public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.d paramd)
      {
        AppMethodBeat.i(182624);
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182623);
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              Object localObject = paramd;
              p.g(localObject, "rr");
              localObject = ((com.tencent.mm.ak.d)localObject).aYK();
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (cub)localObject;
              if (!Util.isNullOrNil(((cub)localObject).KJw))
              {
                ah localah = ah.IYy;
                localObject = ((cub)localObject).KJw;
                p.g(localObject, "rsp.redirect_url");
                ah.aYF((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.IYS.IYR.context, paramString, MMApplicationContext.getContext().getString(2131768654), (DialogInterface.OnClickListener)1.IYT);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void sx(final int paramInt)
      {
        AppMethodBeat.i(182626);
        com.tencent.mm.ch.a.y((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182625);
            Object localObject1;
            com.tencent.mm.plugin.webview.k.b localb;
            Object localObject2;
            if (paramInt == 1)
            {
              localObject1 = ah.IYy;
              Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.k.b.JBk;
              localObject2 = this.IYV.IYU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.IYy;
              ah.gcG();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.k.b.JBk.aO(2, (int)(System.currentTimeMillis() - ag.b.IYc), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.IYy;
              Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.k.b.JBk;
              localObject2 = this.IYV.IYU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.IYV.IYR;
              localObject2 = ((ah.b)localObject1).IYN;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.IYy;
                Log.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).aga(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).IYN;
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
              p.g(localObject1, "resp?.getString(Constant…ESULT_REDIRECT_URL) ?: \"\"");
              localObject2 = ah.IYy;
              ah.aYF((String)localObject1);
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