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
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.g.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.d;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "ct", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String PUM = "snsapi_userinfo";
  private static b PUN;
  private static int PUO = 0;
  private static WeakReference<ag.c> PUP;
  public static final ah PUQ;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int oDY = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    PUQ = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    oDY = 4;
    PUM = "snsapi_userinfo";
    AppMethodBeat.o(182642);
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, int paramInt, ag.c paramc)
  {
    AppMethodBeat.i(182635);
    p.k(paramContext, "ct");
    p.k(paramBundle, "resp");
    p.k(paramc, "webviewDelegate");
    Context localContext = paramContext;
    if ((paramContext instanceof MutableContextWrapper))
    {
      localContext = ((MutableContextWrapper)paramContext).getBaseContext();
      p.j(localContext, "(ct as MutableContextWrapper).baseContext");
    }
    if (!(localContext instanceof Activity))
    {
      Log.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((PUO != paramInt) && (PUN != null))
    {
      Log.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    PUO = paramInt;
    if (PUN == null) {
      PUN = new b(new WeakReference(localContext));
    }
    paramContext = PUN;
    if (paramContext == null) {
      p.iCn();
    }
    if (paramContext.PVf == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      PUP = new WeakReference(paramc);
      paramContext = PUN;
      if (paramContext != null)
      {
        p.k(paramBundle, "resp");
        paramContext.PVf = paramBundle;
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
          paramBundle = ag.bo((ArrayList)paramBundle);
          p.j(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.PUq = paramBundle;
          ca(paramContext.PUq);
          paramContext.gVE();
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
  
  public static final boolean a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182637);
    p.k(paramActivity, "activity");
    Object localObject = PUN;
    String str;
    ArrayList localArrayList;
    if (localObject != null)
    {
      p.k(paramActivity, "activity");
      if ((paramIntent != null) && (paramInt == oDY) && (paramIntent.getIntExtra("id", -1) != -1))
      {
        Log.i(TAG, "[OauthQueue.onActivityResult] START_CREATE_AVATAR_UI_REQUEST_CODE");
        localObject = ((b)localObject).PVg;
        if (localObject != null)
        {
          p.k(paramIntent, "data");
          paramInt = paramIntent.getIntExtra("id", -1);
          str = paramIntent.getStringExtra("nickname");
          paramIntent = paramIntent.getStringExtra("avatarurl");
          paramActivity = ((a)localObject).oDW.iterator();
          while (paramActivity.hasNext()) {
            ((h.a)paramActivity.next()).msB = false;
          }
          localArrayList = ((a)localObject).oDW;
          paramActivity = ((a)localObject).PUT;
          if (paramActivity == null) {
            break label218;
          }
        }
      }
    }
    label218:
    for (paramActivity = paramActivity.RXY;; paramActivity = null)
    {
      p.j(paramIntent, "avatarurl");
      localArrayList.add(new h.a(0, str, "", paramActivity, null, true, paramIntent, paramInt));
      if (((a)localObject).PUT == null) {
        p.iCn();
      }
      ((a)localObject).a(((a)localObject).PUS, (List)((a)localObject).oDW, ((a)localObject).PUU, ((a)localObject).PUV);
      AppMethodBeat.o(182637);
      return false;
    }
  }
  
  public static final ArrayList<byte[]> bZ(LinkedList<ddg> paramLinkedList)
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
        ddg localddg = (ddg)paramLinkedList.next();
        try
        {
          localArrayList.add(localddg.toByteArray());
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
  
  public static ArrayList<ddg> bp(ArrayList<byte[]> paramArrayList)
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
          ddg localddg = new ddg();
          localddg.parseFrom(arrayOfByte);
          localArrayList.add(localddg);
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
  
  private static void ca(LinkedList<eax> paramLinkedList)
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
        kotlin.a.j.iBO();
      }
      if (!p.h(((eax)localObject).RXY, PUM)) {}
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
    Object localObject = PUN;
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    localObject = PUN;
    if (localObject != null)
    {
      localObject = ((b)localObject).PVg;
      if (localObject != null) {
        ((a)localObject).gVD();
      }
    }
    PUN = null;
    PUP = null;
    AppMethodBeat.o(182638);
  }
  
  public static String gVA()
  {
    return PUM;
  }
  
  public static int gVz()
  {
    return oDY;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    ah.b PUN;
    private final g.b PUR;
    final g PUS;
    eax PUT;
    boolean PUU;
    int PUV;
    int PUW;
    final com.tencent.mm.plugin.appbrand.widget.dialog.d PUX;
    String appid;
    final Context context;
    final ArrayList<h.a> oDW;
    
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.widget.dialog.d paramd)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.PUX = paramd;
      this.PUR = ((g.b)new b(this));
      this.PUS = new g(this.context, (b.d)this.PUR);
      this.oDW = new ArrayList();
      this.appid = "";
      AppMethodBeat.o(182619);
    }
    
    private final void b(g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(182618);
      if (!paramBoolean)
      {
        paramg.setFunctionButtonOnClickListener(null);
        AppMethodBeat.o(182618);
        return;
      }
      paramg.setFunctionButtonOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(182618);
    }
    
    public final void a(Bundle paramBundle, final eax parameax)
    {
      AppMethodBeat.i(182616);
      p.k(paramBundle, "resp");
      p.k(parameax, "scope");
      this.PUT = parameax;
      this.PUS.setPosition(2);
      Object localObject1 = this.PUS;
      ((g)localObject1).setAppBrandName(((g)localObject1).getContext().getString(c.i.login_auth_snsapi_userinfo, new Object[] { paramBundle.getString("appname", "") }));
      ((g)localObject1).setRequestDesc(parameax.CMB);
      ((g)localObject1).setApplyWording("");
      ((g)localObject1).setNegativeButtonText(((g)localObject1).getContext().getResources().getString(c.i.login_reject_button));
      ((g)localObject1).setPositiveButtonText(((g)localObject1).getContext().getResources().getString(c.i.login_accept_button));
      ((g)localObject1).setIconUrl(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.PUQ;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.bp((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.PUU = paramBundle.getBoolean("is_ban_modify_avatar");
      this.PUV = paramBundle.getInt("avatar_limit");
      this.PUW = 0;
      localObject1 = ag.b.bky(paramBundle.getString("oauth_url", ""));
      p.j(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.appid = ((String)localObject1);
      localObject1 = parameax.RXY;
      Object localObject3 = ah.PUQ;
      if (p.h(localObject1, ah.gVA()))
      {
        this.PUW = i;
        paramBundle = this.PUN;
        if (paramBundle != null) {
          paramBundle.anN(this.PUW);
        }
        this.PUS.setItemCheckedListener((h.b)new c(this));
        if (!Util.isNullOrNil((List)localObject2))
        {
          this.oDW.clear();
          paramBundle = this.oDW;
          localObject1 = parameax.RXY;
          p.j(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ddg localddg = (ddg)((Iterator)localObject3).next();
            String str1 = localddg.nickname;
            String str2 = localddg.desc;
            if (i == localddg.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localddg.oDV;
              p.j(str3, "it.avatarurl");
              ((Collection)localObject2).add(new h.a(str1, str2, (String)localObject1, bool, str3, localddg.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.PUS, (List)this.oDW, this.PUU, this.PUV);
          this.PUS.setOnListItemLongClickListener((h.d)new d(this, parameax));
          this.PUX.a((com.tencent.mm.plugin.appbrand.widget.dialog.j)this.PUS);
          AppMethodBeat.o(182616);
          return;
        }
        this.PUW = i;
        paramBundle = this.PUN;
        if (paramBundle != null) {
          paramBundle.anN(this.PUW);
        }
        paramBundle = ah.PUQ;
        Log.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getApplicationId(), null, ah.a.e.PVe.getClass(), (f)new f(this, parameax));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.PUQ;
      Log.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.PUS.setAppBrandName(this.context.getString(c.i.login_auth_non_userinfo, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.PUS;
      parameax = parameax.RXY;
      p.j(parameax, "scope.Scope");
      paramBundle.setScope(parameax);
      this.PUX.a((com.tencent.mm.plugin.appbrand.widget.dialog.j)this.PUS);
      AppMethodBeat.o(182616);
    }
    
    final void a(g paramg, List<h.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(182617);
      paramg.setSelectListItem(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          paramg.setFunctionButtonText(this.context.getResources().getString(c.i.wechat_auth_create_avatar));
          paramg.setFunctionButtonTextColor(this.context.getResources().getColor(c.c.BW_0_Alpha_0_3));
        }
        for (;;)
        {
          b(paramg, false);
          AppMethodBeat.o(182617);
          return;
          paramg.setFunctionButtonText("");
        }
      }
      paramg.setFunctionButtonText(this.context.getResources().getString(c.i.wechat_auth_create_avatar));
      paramg.setFunctionButtonTextColor(this.context.getResources().getColor(c.c.link_color));
      b(paramg, true);
      AppMethodBeat.o(182617);
    }
    
    public final void gVD()
    {
      AppMethodBeat.i(265293);
      this.PUX.b((com.tencent.mm.plugin.appbrand.widget.dialog.j)this.PUS);
      ah.b localb = this.PUN;
      if (localb != null) {
        localb.destroy();
      }
      this.PUN = null;
      AppMethodBeat.o(265293);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Intent localIntent = new Intent();
        localIntent.putExtra("0", this.PUY.appid);
        paramView = this.PUY.context;
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)paramView;
        if (localObject == null)
        {
          paramView = ah.PUQ;
          Log.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182605);
          return;
        }
        if (!(localObject instanceof MMActivity)) {}
        for (paramView = null;; paramView = (View)localObject)
        {
          paramView = (MMActivity)paramView;
          if (paramView != null) {
            paramView.mmSetOnActivityResultCallback((MMActivity.a)new MMActivity.a()
            {
              public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
              {
                AppMethodBeat.i(232367);
                ah.a(this.otc, paramAnonymousInt1, paramAnonymousIntent);
                AppMethodBeat.o(232367);
              }
            });
          }
          paramView = (Context)localObject;
          localObject = ah.PUQ;
          com.tencent.mm.by.c.d(paramView, ".plugin.webview.ui.tools.CreateAvatarUI", localIntent, ah.gVz());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182605);
          return;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
    public static final class b
      implements g.b
    {
      public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
      {
        AppMethodBeat.i(182606);
        p.k(paramArrayList, "select");
        Object localObject;
        switch (paramInt1)
        {
        default: 
          localObject = ah.PUQ;
          Log.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.PUY.PUN;
          if (paramArrayList != null)
          {
            paramArrayList.gVE();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.PUQ;
          Log.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!Util.isNullOrNil((List)paramArrayList))
          {
            localObject = this.PUY.PUN;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              p.j(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              p.k(paramArrayList, "scope");
              ((ah.b)localObject).PVh.add(paramArrayList);
            }
          }
          paramArrayList = this.PUY.PUN;
          if (paramArrayList != null)
          {
            paramArrayList.gVE();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements h.b
    {
      public final void a(h.a parama)
      {
        AppMethodBeat.i(243306);
        p.k(parama, "item");
        this.PUY.PUW = parama.oCE;
        parama = this.PUY.PUN;
        if (parama != null)
        {
          parama.anN(this.PUY.PUW);
          AppMethodBeat.o(243306);
          return;
        }
        AppMethodBeat.o(243306);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements h.d
    {
      d(eax parameax) {}
      
      public final void a(View paramView, final h.a parama, final int paramInt)
      {
        AppMethodBeat.i(268230);
        p.k(paramView, "v");
        p.k(parama, "item");
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
        if (paramInt == 0)
        {
          AppMethodBeat.o(268230);
          return;
        }
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new a(this);
        parama = (q.g)new b(this, paramInt, parama);
        TouchableLayout.a locala1 = TouchableLayout.YOD;
        int i = TouchableLayout.igZ();
        locala1 = TouchableLayout.YOD;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.iha());
        AppMethodBeat.o(268230);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.PVa.PUY.context.getResources().getString(c.i.new_sdk_oauth_login_delavatar));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements q.g
      {
        b(ah.a.d paramd, int paramInt, h.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.PVa.PUY.oDW);
          paramMenuItem.remove(paramInt);
          if (((h.a)this.PVa.PUY.oDW.get(paramInt)).oCE == this.PVa.PUY.PUW) {
            ((h.a)paramMenuItem.get(0)).msB = true;
          }
          ah.a.a(this.PVa.PUY, this.PVa.PUY.PUS, (List)paramMenuItem, this.PVa.PUY.PUU, this.PVa.PUY.PUV);
          Object localObject = ah.PUQ;
          Log.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new afj();
          ((afj)localObject).SrG = parama.oCE;
          d.a locala = new d.a();
          locala.c((com.tencent.mm.cd.a)localObject);
          locala.d((com.tencent.mm.cd.a)new afk());
          locala.TW("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.vD(2700);
          locala.vF(0);
          locala.vG(0);
          IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new IPCRunCgi.a()
          {
            public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
            {
              AppMethodBeat.i(182610);
              MMHandlerThread.postToMainThread((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182609);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    this.PVd.PVc.PVa.PUY.oDW.clear();
                    this.PVd.PVc.PVa.PUY.oDW.addAll((Collection)this.PVd.oEo);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.PVd.PVc.PVa.PUY, this.PVd.PVc.PVa.PUY.PUS, (List)this.PVd.PVc.PVa.PUY.oDW, this.PVd.PVc.PVa.PUY.PUU, this.PVd.PVc.PVa.PUY.PUV);
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements f<ResultType>
    {
      f(ah.a parama, eax parameax) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Ljava/lang/ref/WeakReference;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    private com.tencent.mm.plugin.appbrand.widget.dialog.d PUX;
    LinkedList<eax> PUq;
    Bundle PVf;
    ah.a PVg;
    final ArrayList<String> PVh;
    private int PVi;
    final WeakReference<Context> context;
    private int wzx;
    
    public b(WeakReference<Context> paramWeakReference)
    {
      AppMethodBeat.i(268256);
      this.context = paramWeakReference;
      this.PUq = new LinkedList();
      paramWeakReference = this.context.get();
      if (paramWeakReference == null) {
        p.iCn();
      }
      this.PUX = new com.tencent.mm.plugin.appbrand.widget.dialog.d((Context)paramWeakReference);
      this.PVh = new ArrayList();
      paramWeakReference = this.context.get();
      if (paramWeakReference == null)
      {
        paramWeakReference = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(268256);
        throw paramWeakReference;
      }
      paramWeakReference = ((Activity)paramWeakReference).getWindow();
      p.j(paramWeakReference, "(context.get() as Activity).window");
      View localView = paramWeakReference.getDecorView();
      if (localView != null)
      {
        paramWeakReference = localView;
        if (!(localView instanceof ViewGroup)) {
          paramWeakReference = null;
        }
        paramWeakReference = (ViewGroup)paramWeakReference;
        if (paramWeakReference != null)
        {
          paramWeakReference.addView((View)this.PUX);
          AppMethodBeat.o(268256);
          return;
        }
        AppMethodBeat.o(268256);
        return;
      }
      AppMethodBeat.o(268256);
    }
    
    private final void fwx()
    {
      AppMethodBeat.i(182631);
      Object localObject1 = this.PVf;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getString("oauth_url", "");
        localObject1 = ag.b.bky((String)localObject1);
        if (!Util.isNullOrNil((List)this.PVh)) {
          break label108;
        }
        localObject2 = ah.PUQ;
        Log.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        localObject2 = com.tencent.mm.plugin.webview.k.b.QzJ;
        if (localObject1 != null) {
          break label143;
        }
        localObject1 = "";
      }
      label143:
      for (;;)
      {
        ((com.tencent.mm.plugin.webview.k.b)localObject2).a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.k.b.QzJ.aS(2, (int)(System.currentTimeMillis() - ag.b.PUt), 0);
        gVG();
        AppMethodBeat.o(182631);
        return;
        localObject1 = null;
        break;
        label108:
        com.tencent.mm.model.gdpr.c.a((Context)this.context.get(), com.tencent.mm.model.gdpr.a.lwQ, (String)localObject1, (com.tencent.mm.model.gdpr.b)new b(this, (String)localObject1));
        AppMethodBeat.o(182631);
        return;
      }
    }
    
    private final boolean gVF()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (Util.isNullOrNil((List)this.PUq))
      {
        localah = ah.PUQ;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.wzx >= this.PUq.size())
      {
        localah = ah.PUQ;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    private final void gVG()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.PUQ;
      Log.i(ah.getTAG(), "[OauthQueue.reject] reject");
      anO(2);
      localObject = ah.PUQ;
      localObject = ah.gVC();
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
    
    public final void anN(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.PVi = paramInt;
      ah localah = ah.PUQ;
      Log.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void anO(int paramInt)
    {
      AppMethodBeat.i(182633);
      ddc localddc = new ddc();
      Object localObject = this.PVf;
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
      localddc.TKV = ((String)localObject);
      localddc.TKW = paramInt;
      localddc.TKX.addAll((Collection)this.PVh);
      localddc.SrG = this.PVi;
      localObject = ah.PUQ;
      Log.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localddc.TKX + ", avatarId = " + this.PVi);
      localObject = new d.a();
      ((d.a)localObject).c((com.tencent.mm.cd.a)localddc);
      ((d.a)localObject).d((com.tencent.mm.cd.a)new ddd());
      ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((d.a)localObject).vD(1373);
      ((d.a)localObject).vF(0);
      ((d.a)localObject).vG(0);
      IPCRunCgi.a(((d.a)localObject).bgN(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.PUX != null)
      {
        com.tencent.mm.plugin.appbrand.widget.dialog.d locald = this.PUX;
        if (locald != null) {
          locald.cnJ();
        }
        this.PUX = null;
        this.PVg = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void gVE()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.PVg != null)
      {
        localObject1 = this.PVg;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).PUS;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.PUX;
          if (localObject3 != null)
          {
            ah.a locala = this.PVg;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.PUS;
            }
            ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject3).b((com.tencent.mm.plugin.appbrand.widget.dialog.j)localObject1);
          }
        }
        if (!gVF()) {
          break;
        }
        fwx();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context.get();
      if (localObject1 == null) {
        p.iCn();
      }
      p.j(localObject1, "context.get()!!");
      localObject1 = (Context)localObject1;
      localObject2 = this.PUX;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject1 = new ah.a((Context)localObject1, (com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject2);
      ((ah.a)localObject1).PUN = ((b)this);
      localObject2 = this.PVf;
      if (localObject2 == null) {
        p.iCn();
      }
      Object localObject3 = this.PUq.get(this.wzx);
      p.j(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (eax)localObject3);
      this.PVg = ((ah.a)localObject1);
      this.wzx += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(ah.b paramb) {}
      
      public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.an.d paramd)
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
              p.j(localObject, "rr");
              localObject = ((com.tencent.mm.an.d)localObject).bhY();
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (ddd)localObject;
              if (!Util.isNullOrNil(((ddd)localObject).SjB))
              {
                ah localah = ah.PUQ;
                localObject = ((ddd)localObject).SjB;
                p.j(localObject, "rsp.redirect_url");
                ah.bkz((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            h.d((Context)this.PVk.PVj.context.get(), paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), (DialogInterface.OnClickListener)1.PVl);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void vu(final int paramInt)
      {
        AppMethodBeat.i(182626);
        com.tencent.mm.co.a.y((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182625);
            Object localObject1;
            com.tencent.mm.plugin.webview.k.b localb;
            Object localObject2;
            if (paramInt == 1)
            {
              localObject1 = ah.PUQ;
              Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.k.b.QzJ;
              localObject2 = this.PVn.PVm;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.PUQ;
              ah.gVB();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.k.b.QzJ.aS(2, (int)(System.currentTimeMillis() - ag.b.PUt), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.PUQ;
              Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.k.b.QzJ;
              localObject2 = this.PVn.PVm;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.PVn.PVj;
              localObject2 = ((ah.b)localObject1).PVf;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.PUQ;
                Log.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).anO(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).PVf;
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
              p.j(localObject1, "resp?.getString(Constant…ESULT_REDIRECT_URL) ?: \"\"");
              localObject2 = ah.PUQ;
              ah.bkz((String)localObject1);
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