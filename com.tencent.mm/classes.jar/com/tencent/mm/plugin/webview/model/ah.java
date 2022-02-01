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
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "context", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String DTu = "snsapi_userinfo";
  private static b DTv;
  private static int DTw = 0;
  private static WeakReference<ag.c> DTx;
  public static final ah DTy;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int kzZ = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    DTy = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    kzZ = 4;
    DTu = "snsapi_userinfo";
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
      ad.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((DTw != paramInt) && (DTv != null))
    {
      ad.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    DTw = paramInt;
    if (DTv == null) {
      DTv = new b(paramContext);
    }
    paramContext = DTv;
    if (paramContext == null) {
      p.gfZ();
    }
    if (paramContext.DTN == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      DTx = new WeakReference(paramc);
      paramContext = DTv;
      if (paramContext != null)
      {
        p.h(paramBundle, "resp");
        paramContext.DTN = paramBundle;
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
          paramBundle = ag.aG((ArrayList)paramBundle);
          p.g(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.DTb = paramBundle;
          bh(paramContext.DTb);
          paramContext.eQj();
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
  
  public static ArrayList<cdd> aH(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(182640);
    ArrayList localArrayList = new ArrayList();
    if (bt.hj((List)paramArrayList))
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
          cdd localcdd = new cdd();
          localcdd.parseFrom(arrayOfByte);
          localArrayList.add(localcdd);
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
  
  public static final ArrayList<byte[]> bg(LinkedList<cdd> paramLinkedList)
  {
    AppMethodBeat.i(182639);
    ArrayList localArrayList = new ArrayList();
    if (bt.hj((List)paramLinkedList))
    {
      AppMethodBeat.o(182639);
      return localArrayList;
    }
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        cdd localcdd = (cdd)paramLinkedList.next();
        try
        {
          localArrayList.add(localcdd.toByteArray());
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
  
  private static void bh(LinkedList<cxm> paramLinkedList)
  {
    AppMethodBeat.i(182641);
    if ((bt.hj((List)paramLinkedList)) || (paramLinkedList.size() == 1))
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
        j.gfB();
      }
      if (!p.i(((cxm)localObject).FKf, DTu)) {}
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
    b localb = DTv;
    if (localb != null) {
      localb.destroy();
    }
    DTv = null;
    DTx = null;
    AppMethodBeat.o(182638);
  }
  
  public static int eQf()
  {
    return kzZ;
  }
  
  public static String eQg()
  {
    return DTu;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    final i DTA;
    private cxm DTB;
    boolean DTC;
    int DTD;
    int DTE;
    final e DTF;
    ah.b DTv;
    private final i.b DTz;
    final Context context;
    String duW;
    final ArrayList<o.a> kzX;
    
    public a(Context paramContext, e parame)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.DTF = parame;
      this.DTz = ((i.b)new b(this));
      this.DTA = new i(this.context, (b.c)this.DTz);
      this.kzX = new ArrayList();
      this.duW = "";
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
    
    public final void a(Bundle paramBundle, final cxm paramcxm)
    {
      AppMethodBeat.i(182616);
      p.h(paramBundle, "resp");
      p.h(paramcxm, "scope");
      this.DTB = paramcxm;
      this.DTA.setPosition(2);
      Object localObject1 = this.DTA;
      ((i)localObject1).setAppBrandName(((i)localObject1).getContext().getString(2131760749, new Object[] { paramBundle.getString("appname", "") }));
      ((i)localObject1).setRequestDesc(paramcxm.Desc);
      ((i)localObject1).setApplyWording("");
      ((i)localObject1).setNegativeButtonText(((i)localObject1).getContext().getResources().getString(2131760786));
      ((i)localObject1).setPositiveButtonText(((i)localObject1).getContext().getResources().getString(2131760741));
      ((i)localObject1).setIconUrl(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.DTy;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.aH((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.DTC = paramBundle.getBoolean("is_ban_modify_avatar");
      this.DTD = paramBundle.getInt("avatar_limit");
      this.DTE = 0;
      localObject1 = ag.b.aHj(paramBundle.getString("oauth_url", ""));
      p.g(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.duW = ((String)localObject1);
      localObject1 = paramcxm.FKf;
      Object localObject3 = ah.DTy;
      if (p.i(localObject1, ah.eQg()))
      {
        this.DTE = i;
        paramBundle = this.DTv;
        if (paramBundle != null) {
          paramBundle.WK(this.DTE);
        }
        this.DTA.setItemCheckedListener((o.b)new c(this));
        if (!bt.hj((List)localObject2))
        {
          this.kzX.clear();
          paramBundle = this.kzX;
          localObject1 = paramcxm.FKf;
          p.g(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            cdd localcdd = (cdd)((Iterator)localObject3).next();
            String str1 = localcdd.nickname;
            String str2 = localcdd.desc;
            if (i == localcdd.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localcdd.kzW;
              p.g(str3, "it.avatarurl");
              ((Collection)localObject2).add(new o.a(str1, str2, (String)localObject1, bool, str3, localcdd.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.DTA, (List)this.kzX, this.DTC, this.DTD);
          this.DTA.setOnListItemLongClickListener((o.c)new d(this, paramcxm));
          this.DTF.b((k)this.DTA);
          AppMethodBeat.o(182616);
          return;
        }
        this.DTE = i;
        paramBundle = this.DTv;
        if (paramBundle != null) {
          paramBundle.WK(this.DTE);
        }
        paramBundle = ah.DTy;
        ad.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, ah.a.e.DTM.getClass(), (com.tencent.mm.ipcinvoker.d)new f(this, paramcxm));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.DTy;
      ad.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.DTA.setAppBrandName(this.context.getString(2131760747, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.DTA;
      paramcxm = paramcxm.FKf;
      p.g(paramcxm, "scope.Scope");
      paramBundle.setScope(paramcxm);
      this.DTF.b((k)this.DTA);
      AppMethodBeat.o(182616);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = new Intent();
        paramView.putExtra("0", this.DTG.duW);
        localObject = this.DTG.context;
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)localObject;
        if (localObject == null)
        {
          paramView = ah.DTy;
          ad.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182605);
          return;
        }
        localObject = (Context)localObject;
        ah localah = ah.DTy;
        com.tencent.mm.bs.d.c((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, ah.eQf());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(182605);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
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
          localObject = ah.DTy;
          ad.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.DTG.DTv;
          if (paramArrayList != null)
          {
            paramArrayList.eQj();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.DTy;
          ad.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!bt.hj((List)paramArrayList))
          {
            localObject = this.DTG.DTv;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              p.g(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              p.h(paramArrayList, "scope");
              ((ah.b)localObject).DTP.add(paramArrayList);
            }
          }
          paramArrayList = this.DTG.DTv;
          if (paramArrayList != null)
          {
            paramArrayList.eQj();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements o.b
    {
      public final void a(o.a parama)
      {
        AppMethodBeat.i(182607);
        p.h(parama, "item");
        this.DTG.DTE = parama.kzo;
        parama = this.DTG.DTv;
        if (parama != null)
        {
          parama.WK(this.DTG.DTE);
          AppMethodBeat.o(182607);
          return;
        }
        AppMethodBeat.o(182607);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements o.c
    {
      d(cxm paramcxm) {}
      
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
        TouchableLayout.a locala1 = TouchableLayout.LrZ;
        int i = TouchableLayout.fQh();
        locala1 = TouchableLayout.LrZ;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.fQi());
        AppMethodBeat.o(182612);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.DTI.DTG.context.getResources().getString(2131761557));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements n.e
      {
        b(ah.a.d paramd, int paramInt, o.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.DTI.DTG.kzX);
          paramMenuItem.remove(paramInt);
          if (((o.a)this.DTI.DTG.kzX.get(paramInt)).kzo == this.DTI.DTG.DTE) {
            ((o.a)paramMenuItem.get(0)).iDC = true;
          }
          ah.a.a(this.DTI.DTG, this.DTI.DTG.DTA, (List)paramMenuItem, this.DTI.DTG.DTC, this.DTI.DTG.DTD);
          Object localObject = ah.DTy;
          ad.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new aco();
          ((aco)localObject).GbX = parama.kzo;
          b.a locala = new b.a();
          locala.c((com.tencent.mm.bx.a)localObject);
          locala.d((com.tencent.mm.bx.a)new acp());
          locala.Dl("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.oP(2700);
          locala.oR(0);
          locala.oS(0);
          IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new IPCRunCgi.a()
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
                    this.DTL.DTK.DTI.DTG.kzX.clear();
                    this.DTL.DTK.DTI.DTG.kzX.addAll((Collection)this.DTL.kAk);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.DTL.DTK.DTI.DTG, this.DTL.DTK.DTI.DTG.DTA, (List)this.DTL.DTK.DTI.DTG.kzX, this.DTL.DTK.DTI.DTG.DTC, this.DTL.DTK.DTI.DTG.DTD);
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements com.tencent.mm.ipcinvoker.d<ResultType>
    {
      f(ah.a parama, cxm paramcxm) {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    private e DTF;
    Bundle DTN;
    private ah.a DTO;
    final ArrayList<String> DTP;
    private int DTQ;
    LinkedList<cxm> DTb;
    final Context context;
    private int rko;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(182634);
      this.context = paramContext;
      this.DTb = new LinkedList();
      this.DTF = new e(this.context);
      this.DTP = new ArrayList();
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
          paramContext.addView((View)this.DTF);
          AppMethodBeat.o(182634);
          return;
        }
        AppMethodBeat.o(182634);
        return;
      }
      AppMethodBeat.o(182634);
    }
    
    private final void dGe()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.DTN;
      if (localObject != null) {}
      final String str;
      for (localObject = ((Bundle)localObject).getString("oauth_url", "");; localObject = null)
      {
        str = ag.b.aHj((String)localObject);
        if (!bt.hj((List)this.DTP)) {
          break;
        }
        localObject = ah.DTy;
        ad.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.EsZ;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.j.b.EsZ.aF(2, (int)(System.currentTimeMillis() - ag.b.DTe), 0);
        reject();
        AppMethodBeat.o(182631);
        return;
      }
      c.a(this.context, com.tencent.mm.model.gdpr.a.hIT, str, (com.tencent.mm.model.gdpr.b)new b(this, str));
      AppMethodBeat.o(182631);
    }
    
    private final boolean eQk()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (bt.hj((List)this.DTb))
      {
        localah = ah.DTy;
        ad.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.rko >= this.DTb.size())
      {
        localah = ah.DTy;
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
      Object localObject = ah.DTy;
      ad.i(ah.getTAG(), "[OauthQueue.reject] reject");
      WL(2);
      localObject = ah.DTy;
      localObject = ah.eQi();
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
    
    public final void WK(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.DTQ = paramInt;
      ah localah = ah.DTy;
      ad.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void WL(int paramInt)
    {
      AppMethodBeat.i(182633);
      ccz localccz = new ccz();
      Object localObject = this.DTN;
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
      localccz.GXi = ((String)localObject);
      localccz.GXj = paramInt;
      localccz.GXk.addAll((Collection)this.DTP);
      localccz.GbX = this.DTQ;
      localObject = ah.DTy;
      ad.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localccz.GXk + ", avatarId = " + this.DTQ);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)localccz);
      ((b.a)localObject).d((com.tencent.mm.bx.a)new cda());
      ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((b.a)localObject).oP(1373);
      ((b.a)localObject).oR(0);
      ((b.a)localObject).oS(0);
      IPCRunCgi.a(((b.a)localObject).aDC(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.DTF != null)
      {
        e locale = this.DTF;
        if (locale != null) {
          locale.My();
        }
        this.DTF = null;
        this.DTO = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void eQj()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.DTO != null)
      {
        localObject1 = this.DTO;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).DTA;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.DTF;
          if (localObject3 != null)
          {
            ah.a locala = this.DTO;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.DTA;
            }
            ((e)localObject3).c((k)localObject1);
          }
        }
        if (!eQk()) {
          break;
        }
        dGe();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context;
      localObject2 = this.DTF;
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject1 = new ah.a((Context)localObject1, (e)localObject2);
      ((ah.a)localObject1).DTv = ((b)this);
      localObject2 = this.DTN;
      if (localObject2 == null) {
        p.gfZ();
      }
      Object localObject3 = this.DTb.get(this.rko);
      p.g(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (cxm)localObject3);
      this.DTO = ((ah.a)localObject1);
      this.rko += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
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
              p.g(localObject, "rr");
              localObject = ((com.tencent.mm.al.b)localObject).aEF();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (cda)localObject;
              if (!bt.isNullOrNil(((cda)localObject).Fxq))
              {
                ah localah = ah.DTy;
                localObject = ((cda)localObject).Fxq;
                p.g(localObject, "rsp.redirect_url");
                ah.aHk((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.DTS.DTR.context, paramString, aj.getContext().getString(2131766178), (DialogInterface.OnClickListener)1.DTT);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void oG(final int paramInt)
      {
        AppMethodBeat.i(182626);
        com.tencent.mm.ci.a.z((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182625);
            Object localObject1;
            com.tencent.mm.plugin.webview.j.b localb;
            Object localObject2;
            if (paramInt == 1)
            {
              localObject1 = ah.DTy;
              ad.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.j.b.EsZ;
              localObject2 = this.DTV.DTU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.DTy;
              ah.eQh();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.j.b.EsZ.aF(2, (int)(System.currentTimeMillis() - ag.b.DTe), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.DTy;
              ad.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.j.b.EsZ;
              localObject2 = this.DTV.DTU;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.DTV.DTR;
              localObject2 = ((ah.b)localObject1).DTN;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.DTy;
                ad.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).WL(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).DTN;
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
              localObject2 = ah.DTy;
              ah.aHk((String)localObject1);
            }
          }
        });
        AppMethodBeat.o(182626);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */