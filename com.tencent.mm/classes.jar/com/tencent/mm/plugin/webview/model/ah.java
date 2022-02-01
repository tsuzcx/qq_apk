package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.d.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "ct", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "uiDialog", "Landroid/app/Dialog;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  private static final String TAG;
  public static final ah WLA;
  private static b WLB;
  private static int WLC;
  private static WeakReference<ag.c> WLD;
  
  static
  {
    AppMethodBeat.i(182642);
    WLA = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    AppMethodBeat.o(182642);
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, int paramInt, ag.c paramc, Dialog paramDialog)
  {
    AppMethodBeat.i(298333);
    s.u(paramContext, "ct");
    s.u(paramBundle, "resp");
    s.u(paramc, "webviewDelegate");
    Object localObject = paramContext;
    if ((paramContext instanceof MutableContextWrapper))
    {
      localObject = ((MutableContextWrapper)paramContext).getBaseContext();
      s.s(localObject, "ct as MutableContextWrapper).baseContext");
    }
    if (!(localObject instanceof Activity))
    {
      Log.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(298333);
      return;
    }
    if ((WLC != paramInt) && (WLB != null))
    {
      Log.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    WLC = paramInt;
    if (WLB == null)
    {
      localObject = new WeakReference(localObject);
      if (paramDialog != null)
      {
        paramContext = new WeakReference(paramDialog);
        WLB = new b((WeakReference)localObject, paramContext);
      }
    }
    else
    {
      paramContext = WLB;
      s.checkNotNull(paramContext);
      if (paramContext.WLP != null) {
        break label228;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        WLD = new WeakReference(paramc);
        paramContext = WLB;
        if (paramContext == null) {
          break label277;
        }
        s.u(paramBundle, "resp");
        paramContext.WLP = paramBundle;
        paramBundle = paramBundle.getSerializable("scope_list");
        if (paramBundle == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
          AppMethodBeat.o(298333);
          throw paramContext;
          paramContext = null;
          break;
          label228:
          paramInt = 0;
          continue;
        }
        paramBundle = ag.bP((ArrayList)paramBundle);
        s.s(paramBundle, "bytesListToBytesListScopeInfoList(bytesList)");
        paramContext.WLc = paramBundle;
        cl(paramContext.WLc);
        paramContext.ivn();
        AppMethodBeat.o(298333);
        return;
      }
    }
    Log.i(TAG, "[showDialogQueue] repeat call");
    label277:
    AppMethodBeat.o(298333);
  }
  
  public static final boolean a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182637);
    s.u(paramActivity, "activity");
    Object localObject = WLB;
    String str;
    ArrayList localArrayList;
    if (localObject != null)
    {
      s.u(paramActivity, "activity");
      if ((paramIntent != null) && (paramInt == 204))
      {
        if (paramIntent.getIntExtra("id", -1) == -1) {
          paramInt = 1;
        }
        while (paramInt == 0)
        {
          Log.i(TAG, "[OauthQueue.onActivityResult] START_CREATE_AVATAR_UI_REQUEST_CODE");
          localObject = ((b)localObject).WLQ;
          if (localObject != null)
          {
            s.u(paramIntent, "data");
            paramInt = paramIntent.getIntExtra("id", -1);
            str = paramIntent.getStringExtra("nickname");
            paramIntent = paramIntent.getStringExtra("avatarurl");
            paramActivity = ((a)localObject).rHo.iterator();
            for (;;)
            {
              if (paramActivity.hasNext())
              {
                ((k.a)paramActivity.next()).plZ = false;
                continue;
                paramInt = 0;
                break;
              }
            }
            localArrayList = ((a)localObject).rHo;
            paramActivity = ((a)localObject).WLH;
            if (paramActivity != null) {
              break label218;
            }
          }
        }
      }
    }
    label218:
    for (paramActivity = null;; paramActivity = paramActivity.YVX)
    {
      s.checkNotNull(paramIntent);
      localArrayList.add(new k.a(0, str, "", paramActivity, null, true, paramIntent, paramInt));
      s.checkNotNull(((a)localObject).WLH);
      ((a)localObject).a(((a)localObject).WLG, (List)((a)localObject).rHo, ((a)localObject).WLI, ((a)localObject).WLJ);
      AppMethodBeat.o(182637);
      return false;
    }
  }
  
  public static ArrayList<dvb> bQ(ArrayList<byte[]> paramArrayList)
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
        Object localObject = (byte[])paramArrayList.next();
        try
        {
          dvb localdvb = new dvb();
          localdvb.parseFrom((byte[])localObject);
          localObject = kotlin.ah.aiuX;
          localArrayList.add(localdvb);
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
  
  public static final ArrayList<byte[]> ck(LinkedList<dvb> paramLinkedList)
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
        dvb localdvb = (dvb)paramLinkedList.next();
        try
        {
          localArrayList.add(localdvb.toByteArray());
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
  
  private static void cl(LinkedList<eul> paramLinkedList)
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
        p.kkW();
      }
      if (!s.p(((eul)localObject).YVX, "snsapi_userinfo")) {}
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
    Object localObject = WLB;
    if (localObject != null) {
      ((b)localObject).destroy();
    }
    localObject = WLB;
    if (localObject != null)
    {
      localObject = ((b)localObject).WLQ;
      if (localObject != null) {
        ((a)localObject).ivm();
      }
    }
    WLB = null;
    WLD = null;
    AppMethodBeat.o(182638);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "createAvatarTitle", "getCreateAvatarTitle", "setCreateAvatarTitle", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    ah.b WLB;
    private final g WLE;
    private final d.b WLF;
    final com.tencent.mm.plugin.appbrand.widget.dialog.d WLG;
    eul WLH;
    boolean WLI;
    int WLJ;
    int WLK;
    private String WLL;
    private String appid;
    final Context context;
    final ArrayList<k.a> rHo;
    
    public a(Context paramContext, g paramg)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.WLE = paramg;
      this.WLF = ((d.b)new a(this));
      this.WLG = new com.tencent.mm.plugin.appbrand.widget.dialog.d(this.context, (b.d)this.WLF);
      this.rHo = new ArrayList();
      this.appid = "";
      this.WLL = "";
      AppMethodBeat.o(182619);
    }
    
    private final void a(com.tencent.mm.plugin.appbrand.widget.dialog.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(298430);
      if (!paramBoolean)
      {
        paramd.setFunctionButtonOnClickListener(null);
        AppMethodBeat.o(298430);
        return;
      }
      paramd.setFunctionButtonOnClickListener(new ah.a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(298430);
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(298451);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      paramView = new Intent();
      paramView.putExtra("0", parama.appid);
      paramView.putExtra("title", parama.WLL);
      localObject = (Activity)parama.context;
      if (localObject == null)
      {
        parama = ah.WLA;
        Log.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298451);
        return;
      }
      if ((localObject instanceof MMActivity)) {}
      for (parama = (MMActivity)localObject;; parama = null)
      {
        if (parama != null) {
          parama.mmSetOnActivityResultCallback(new ah.a..ExternalSyntheticLambda3((Activity)localObject));
        }
        com.tencent.mm.br.c.d((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, 204);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298451);
        return;
      }
    }
    
    private static final void a(a parama, eul parameul, Bundle paramBundle)
    {
      AppMethodBeat.i(298440);
      s.u(parama, "this$0");
      s.u(parameul, "$scope");
      com.tencent.mm.plugin.appbrand.widget.dialog.d locald = parama.WLG;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new k.a(paramBundle.getString("userName", ""), parama.context.getResources().getString(c.i.appbrand_authorize_item_decs_personal_information), parameul.YVX, AvatarStorage.LL(paramBundle.getString("userIcon", "")), (byte)0));
      parameul = kotlin.ah.aiuX;
      locald.setSelectListItem((List)localArrayList);
      parama.WLE.b((n)parama.WLG);
      AppMethodBeat.o(298440);
    }
    
    private static final void c(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(298443);
      s.u(paramActivity, "$activity");
      ah.a(paramActivity, paramInt1, paramIntent);
      AppMethodBeat.o(298443);
    }
    
    private static List<k.a> d(String paramString, int paramInt, ArrayList<dvb> paramArrayList)
    {
      AppMethodBeat.i(298424);
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        dvb localdvb = (dvb)((Iterator)localObject).next();
        String str1 = localdvb.nickname;
        String str2 = localdvb.desc;
        if (paramInt == localdvb.id) {}
        for (boolean bool = true;; bool = false)
        {
          String str3 = localdvb.rHi;
          s.s(str3, "it.avatarurl");
          paramArrayList.add(new k.a(str1, str2, paramString, bool, str3, localdvb.id));
          break;
        }
      }
      paramString = (List)paramArrayList;
      AppMethodBeat.o(298424);
      return paramString;
    }
    
    private static final void f(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
    {
      AppMethodBeat.i(298436);
      paramBundle = new Bundle();
      paramBundle.putString("userName", z.bAO());
      Object localObject = h.baE().ban().d(2, null);
      if (localObject == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(298436);
        throw paramBundle;
      }
      paramBundle.putString("userIcon", com.tencent.mm.modelavatar.d.Lz(Util.nullAs((String)localObject, "")));
      paramf.onCallback(paramBundle);
      AppMethodBeat.o(298436);
    }
    
    public final void a(Bundle paramBundle, final eul parameul)
    {
      AppMethodBeat.i(182616);
      s.u(paramBundle, "resp");
      s.u(parameul, "scope");
      this.WLH = parameul;
      this.WLG.setPosition(2);
      Object localObject = this.WLG;
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setAppBrandName(((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).getContext().getString(c.i.login_auth_snsapi_userinfo, new Object[] { paramBundle.getString("appname", "") }));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setRequestDesc(parameul.IGG);
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setApplyWording("");
      if (!Util.isNullOrNil(parameul.abxn)) {
        ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setSimpleDetailDesc(parameul.abxn);
      }
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setNegativeButtonText(((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).getContext().getResources().getString(c.i.login_reject_button));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setPositiveButtonText(((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).getContext().getResources().getString(c.i.login_accept_button));
      ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).setIconUrl(paramBundle.getString("appicon_url", ""));
      localObject = ah.WLA;
      localObject = paramBundle.getSerializable("avatar_list");
      if (localObject == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      localObject = ah.bQ((ArrayList)localObject);
      int i = paramBundle.getInt("default_avatar_id");
      this.WLI = paramBundle.getBoolean("is_ban_modify_avatar");
      String str = paramBundle.getString("create_avatar_title", "");
      s.s(str, "resp.getString(Constants…_CREATE_AVATAR_TITLE, \"\")");
      this.WLL = str;
      this.WLJ = paramBundle.getInt("avatar_limit");
      this.WLK = 0;
      str = ag.b.bkj(paramBundle.getString("oauth_url", ""));
      s.s(str, "parseAppId(resp.getStrin…ZE_RESULT_OAUTH_URL, \"\"))");
      this.appid = str;
      if (s.p(parameul.YVX, "snsapi_userinfo"))
      {
        this.WLK = i;
        paramBundle = this.WLB;
        if (paramBundle != null) {
          paramBundle.atH(this.WLK);
        }
        this.WLG.setItemCheckedListener((k.b)new b(this));
        if (!Util.isNullOrNil((List)localObject))
        {
          this.rHo.clear();
          paramBundle = this.rHo;
          str = parameul.YVX;
          s.s(str, "scope.Scope");
          paramBundle.addAll((Collection)d(str, i, (ArrayList)localObject));
          a(this.WLG, (List)this.rHo, this.WLI, this.WLJ);
          this.WLG.setOnListItemLongClickListener((k.d)new c(this, parameul));
          this.WLE.b((n)this.WLG);
          AppMethodBeat.o(182616);
          return;
        }
        this.WLK = i;
        paramBundle = this.WLB;
        if (paramBundle != null) {
          paramBundle.atH(this.WLK);
        }
        paramBundle = ah.WLA;
        Log.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        j.a(MMApplicationContext.getApplicationId(), null, ah.a..ExternalSyntheticLambda1.INSTANCE.getClass(), new ah.a..ExternalSyntheticLambda2(this, parameul));
        AppMethodBeat.o(182616);
        return;
      }
      localObject = ah.WLA;
      Log.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.WLG.setAppBrandName(this.context.getString(c.i.login_auth_non_userinfo, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.WLG;
      parameul = parameul.YVX;
      s.s(parameul, "scope.Scope");
      paramBundle.setScope(parameul);
      this.WLE.b((n)this.WLG);
      AppMethodBeat.o(182616);
    }
    
    final void a(com.tencent.mm.plugin.appbrand.widget.dialog.d paramd, List<k.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(298478);
      paramd.setSelectListItem(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          paramd.setFunctionButtonText(this.context.getResources().getString(c.i.wechat_auth_create_avatar));
          paramd.setFunctionButtonTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.BW_0_Alpha_0_3));
        }
        for (;;)
        {
          a(paramd, false);
          AppMethodBeat.o(298478);
          return;
          paramd.setFunctionButtonText("");
        }
      }
      paramd.setFunctionButtonText(this.context.getResources().getString(c.i.wechat_auth_create_avatar));
      paramd.setFunctionButtonTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.link_color));
      a(paramd, true);
      AppMethodBeat.o(298478);
    }
    
    public final void ivm()
    {
      AppMethodBeat.i(298475);
      this.WLE.c((n)this.WLG);
      ah.b localb = this.WLB;
      if (localb != null) {
        localb.destroy();
      }
      this.WLB = null;
      AppMethodBeat.o(298475);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "userAgreementChecked", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements d.b
    {
      a(ah.a parama) {}
      
      public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, boolean paramBoolean)
      {
        AppMethodBeat.i(298300);
        s.u(paramArrayList, "select");
        Object localObject;
        if (paramInt1 == 1)
        {
          localObject = ah.WLA;
          Log.i(ah.getTAG(), s.X("[OauthDialog.revnListener] ACCEPT, scope = ", paramArrayList.get(0)));
          if (!Util.isNullOrNil((List)paramArrayList))
          {
            localObject = this.WLM.WLB;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              s.s(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              s.u(paramArrayList, "scope");
              ((ah.b)localObject).WLR.add(paramArrayList);
            }
          }
          paramArrayList = this.WLM.WLB;
          if (paramArrayList != null)
          {
            paramArrayList.ivn();
            AppMethodBeat.o(298300);
          }
        }
        else
        {
          localObject = ah.WLA;
          Log.i(ah.getTAG(), s.X("[OauthDialog.revnListener] REJECT, scope = ", paramArrayList.get(0)));
          paramArrayList = this.WLM.WLB;
          if (paramArrayList != null) {
            paramArrayList.ivn();
          }
        }
        AppMethodBeat.o(298300);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements k.b
    {
      b(ah.a parama) {}
      
      public final void a(k.a parama)
      {
        AppMethodBeat.i(298302);
        s.u(parama, "item");
        this.WLM.WLK = parama.rFX;
        parama = this.WLM.WLB;
        if (parama != null) {
          parama.atH(this.WLM.WLK);
        }
        AppMethodBeat.o(298302);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements k.d
    {
      c(ah.a parama, eul parameul) {}
      
      private static final void a(int paramInt1, int paramInt2, ah.a parama, ArrayList paramArrayList, eul parameul)
      {
        AppMethodBeat.i(298322);
        s.u(parama, "this$0");
        s.u(paramArrayList, "$itemsAfterDelete");
        s.u(parameul, "$scope");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          parama.rHo.clear();
          parama.rHo.addAll((Collection)paramArrayList);
          AppMethodBeat.o(298322);
          return;
        }
        ah.a.a(parama, parama.WLG, (List)parama.rHo, parama.WLI, parama.WLJ);
        AppMethodBeat.o(298322);
      }
      
      private static final void a(ah.a parama, int paramInt1, eul parameul, k.a parama1, MenuItem paramMenuItem, int paramInt2)
      {
        AppMethodBeat.i(298338);
        s.u(parama, "this$0");
        s.u(parameul, "$scope");
        s.u(parama1, "$item");
        paramMenuItem = new ArrayList((Collection)parama.rHo);
        paramMenuItem.remove(paramInt1);
        if (((k.a)parama.rHo.get(paramInt1)).rFX == parama.WLK) {
          ((k.a)paramMenuItem.get(0)).plZ = true;
        }
        ah.a.a(parama, parama.WLG, (List)paramMenuItem, parama.WLI, parama.WLJ);
        Object localObject = ah.WLA;
        Log.i(ah.getTAG(), s.X("[[OauthDialog.showDialog] try delete avatarIdx = ", Integer.valueOf(paramInt1)));
        localObject = new ahw();
        ((ahw)localObject).ZqK = parama1.rFX;
        parama1 = new c.a();
        parama1.otE = ((com.tencent.mm.bx.a)localObject);
        parama1.otF = ((com.tencent.mm.bx.a)new ahx());
        parama1.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
        parama1.funcId = 2700;
        parama1.otG = 0;
        parama1.respCmdId = 0;
        IPCRunCgi.a(parama1.bEF(), new ah.a.c..ExternalSyntheticLambda1(parama, paramMenuItem, parameul));
        AppMethodBeat.o(298338);
      }
      
      private static final void a(ah.a parama, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(298312);
        s.u(parama, "this$0");
        paramContextMenu.add(0, 1, 0, (CharSequence)parama.context.getResources().getString(c.i.new_sdk_oauth_login_delavatar));
        AppMethodBeat.o(298312);
      }
      
      private static final void a(ah.a parama, ArrayList paramArrayList, eul parameul, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
      {
        AppMethodBeat.i(298329);
        s.u(parama, "this$0");
        s.u(paramArrayList, "$itemsAfterDelete");
        s.u(parameul, "$scope");
        MMHandlerThread.postToMainThread(new ah.a.c..ExternalSyntheticLambda3(paramInt1, paramInt2, parama, paramArrayList, parameul));
        AppMethodBeat.o(298329);
      }
      
      public final void a(View paramView, k.a parama, int paramInt)
      {
        AppMethodBeat.i(298367);
        s.u(paramView, "v");
        s.u(parama, "item");
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
        if (paramInt == 0)
        {
          AppMethodBeat.o(298367);
          return;
        }
        ah.a.c..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new ah.a.c..ExternalSyntheticLambda0(this.WLM);
        parama = new ah.a.c..ExternalSyntheticLambda2(this.WLM, paramInt, parameul, parama);
        TouchableLayout.a locala1 = TouchableLayout.agKp;
        int i = TouchableLayout.jMn();
        locala1 = TouchableLayout.agKp;
        locala.a(paramView, paramInt, 0L, localExternalSyntheticLambda0, parama, i, TouchableLayout.jMo());
        AppMethodBeat.o(298367);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "uiDialog", "Landroid/app/Dialog;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Ljava/lang/ref/WeakReference;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "getUiDialog", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private g WLE;
    private final WeakReference<Dialog> WLO;
    Bundle WLP;
    ah.a WLQ;
    final ArrayList<String> WLR;
    private int WLS;
    LinkedList<eul> WLc;
    private final WeakReference<Context> context;
    private int zVI;
    
    public b(WeakReference<Context> paramWeakReference, WeakReference<Dialog> paramWeakReference1)
    {
      AppMethodBeat.i(298417);
      this.context = paramWeakReference;
      this.WLO = paramWeakReference1;
      this.WLc = new LinkedList();
      paramWeakReference = this.context.get();
      s.checkNotNull(paramWeakReference);
      this.WLE = new g((Context)paramWeakReference);
      this.WLR = new ArrayList();
      paramWeakReference = this.WLO;
      if (paramWeakReference == null) {
        paramWeakReference = null;
      }
      for (;;)
      {
        paramWeakReference1 = paramWeakReference;
        if (paramWeakReference != null) {
          break label155;
        }
        paramWeakReference = this.context.get();
        if (paramWeakReference != null) {
          break;
        }
        paramWeakReference = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(298417);
        throw paramWeakReference;
        paramWeakReference = (Dialog)paramWeakReference.get();
        if (paramWeakReference == null) {
          paramWeakReference = null;
        } else {
          paramWeakReference = paramWeakReference.getWindow();
        }
      }
      paramWeakReference1 = ((Activity)paramWeakReference).getWindow();
      label155:
      paramWeakReference1 = paramWeakReference1.getDecorView();
      if (paramWeakReference1 != null)
      {
        paramWeakReference = localObject;
        if ((paramWeakReference1 instanceof ViewGroup)) {
          paramWeakReference = (ViewGroup)paramWeakReference1;
        }
        if (paramWeakReference != null) {
          paramWeakReference.addView((View)this.WLE);
        }
      }
      AppMethodBeat.o(298417);
    }
    
    private static final void R(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(298428);
      paramDialogInterface = ah.WLA;
      ah.ivl();
      AppMethodBeat.o(298428);
    }
    
    private static final void a(int paramInt1, int paramInt2, com.tencent.mm.am.c paramc, b paramb, String paramString)
    {
      AppMethodBeat.i(298432);
      s.u(paramb, "this$0");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramc = com.tencent.mm.am.c.c.b(paramc.otC);
        if (paramc == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
          AppMethodBeat.o(298432);
          throw paramc;
        }
        paramc = (duy)paramc;
        if (!Util.isNullOrNil(paramc.ZhF))
        {
          paramb = ah.WLA;
          paramc = paramc.ZhF;
          s.s(paramc, "rsp.redirect_url");
          ah.bkk(paramc);
          AppMethodBeat.o(298432);
          return;
        }
        ah.destroy();
        AppMethodBeat.o(298432);
        return;
      }
      try
      {
        k.d((Context)paramb.context.get(), paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), ah.b..ExternalSyntheticLambda0.INSTANCE);
        AppMethodBeat.o(298432);
        return;
      }
      catch (Exception paramc)
      {
        paramb = ah.WLA;
        Log.e(ah.getTAG(), s.X("showAlert ex ", paramc.getMessage()));
        AppMethodBeat.o(298432);
      }
    }
    
    private static final void a(b paramb, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(298435);
      s.u(paramb, "this$0");
      MMHandlerThread.postToMainThread(new ah.b..ExternalSyntheticLambda3(paramInt1, paramInt2, paramc, paramb, paramString));
      AppMethodBeat.o(298435);
    }
    
    private static final void a(final String paramString, final b paramb, int paramInt)
    {
      AppMethodBeat.i(298425);
      s.u(paramb, "this$0");
      MMHandlerThread.postToMainThread((Runnable)new a(paramInt, paramString, paramb));
      AppMethodBeat.o(298425);
    }
    
    private final void atI(int paramInt)
    {
      AppMethodBeat.i(182633);
      dux localdux = new dux();
      Object localObject = this.WLP;
      if (localObject == null) {
        localObject = "";
      }
      for (;;)
      {
        localdux.abaO = ((String)localObject);
        localdux.abaP = paramInt;
        localdux.abaQ.addAll((Collection)this.WLR);
        localdux.ZqK = this.WLS;
        localObject = ah.WLA;
        Log.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localdux.abaQ + ", avatarId = " + this.WLS);
        localObject = new c.a();
        ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localdux);
        ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new duy());
        ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        ((c.a)localObject).funcId = 1373;
        ((c.a)localObject).otG = 0;
        ((c.a)localObject).respCmdId = 0;
        IPCRunCgi.a(((c.a)localObject).bEF(), new ah.b..ExternalSyntheticLambda1(this));
        AppMethodBeat.o(182633);
        return;
        String str = ((Bundle)localObject).getString("oauth_url", "");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    
    private final void gIg()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.WLP;
      if (localObject == null) {}
      String str;
      for (localObject = null;; localObject = ((Bundle)localObject).getString("oauth_url", ""))
      {
        str = ag.b.bkj((String)localObject);
        if (!Util.isNullOrNil((List)this.WLR)) {
          break;
        }
        localObject = ah.WLA;
        Log.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.XsD;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.k.b.XsD.bt(2, (int)(System.currentTimeMillis() - ag.b.WLf), 0);
        ggv();
        AppMethodBeat.o(182631);
        return;
      }
      com.tencent.mm.model.gdpr.c.a((Context)this.context.get(), com.tencent.mm.model.gdpr.a.oop, str, new ah.b..ExternalSyntheticLambda2(str, this));
      AppMethodBeat.o(182631);
    }
    
    private final void ggv()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.WLA;
      Log.i(ah.getTAG(), "[OauthQueue.reject] reject");
      atI(2);
      localObject = ah.ivk();
      if (localObject != null)
      {
        localObject = (ag.c)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ag.c)localObject).goBack();
        }
      }
      AppMethodBeat.o(182632);
    }
    
    private final boolean ivo()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (Util.isNullOrNil((List)this.WLc))
      {
        localah = ah.WLA;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.zVI >= this.WLc.size())
      {
        localah = ah.WLA;
        Log.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    public final void atH(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.WLS = paramInt;
      ah localah = ah.WLA;
      Log.v(ah.getTAG(), s.X("[QauthQueue] selectAvatartId = ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.WLE != null)
      {
        g localg = this.WLE;
        if (localg != null) {
          localg.cQI();
        }
        this.WLE = null;
        this.WLQ = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void ivn()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.WLQ != null)
      {
        localObject1 = this.WLQ;
        if (localObject1 != null) {
          break label76;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject3 = this.WLE;
          if (localObject3 != null)
          {
            localObject1 = this.WLQ;
            if (localObject1 != null) {
              break label84;
            }
          }
        }
      }
      label76:
      label84:
      for (Object localObject1 = localObject2;; localObject1 = ((ah.a)localObject1).WLG)
      {
        ((g)localObject3).c((n)localObject1);
        if (!ivo()) {
          break label92;
        }
        gIg();
        AppMethodBeat.o(182628);
        return;
        localObject1 = ((ah.a)localObject1).WLG;
        break;
      }
      label92:
      localObject1 = this.context.get();
      s.checkNotNull(localObject1);
      s.s(localObject1, "context.get()!!");
      localObject1 = (Context)localObject1;
      localObject2 = this.WLE;
      s.checkNotNull(localObject2);
      localObject1 = new ah.a((Context)localObject1, (g)localObject2);
      ((ah.a)localObject1).WLB = this;
      localObject2 = this.WLP;
      s.checkNotNull(localObject2);
      Object localObject3 = this.WLc.get(this.zVI);
      s.s(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (eul)localObject3);
      localObject2 = kotlin.ah.aiuX;
      this.WLQ = ((ah.a)localObject1);
      this.zVI += 1;
      AppMethodBeat.o(182628);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue$sendResult$1$1", "Ljava/lang/Runnable;", "run", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Runnable
    {
      a(int paramInt, String paramString, ah.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(182625);
        Object localObject;
        com.tencent.mm.plugin.webview.k.b localb;
        String str;
        if (this.rxa == 1)
        {
          localObject = ah.WLA;
          Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
          localb = com.tencent.mm.plugin.webview.k.b.XsD;
          str = paramString;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
          localObject = ah.WLA;
          ah.ivl();
        }
        for (;;)
        {
          com.tencent.mm.plugin.webview.k.b.XsD.bt(2, (int)(System.currentTimeMillis() - ag.b.WLf), 0);
          AppMethodBeat.o(182625);
          return;
          localObject = ah.WLA;
          Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
          localb = com.tencent.mm.plugin.webview.k.b.XsD;
          str = paramString;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localb.a((String)localObject, ag.b.startTime, 1, 1, 0, 1, 0);
          ah.b.a(paramb);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */