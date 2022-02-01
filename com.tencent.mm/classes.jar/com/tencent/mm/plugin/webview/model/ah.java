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
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", "context", "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah
{
  private static final String CpV = "snsapi_userinfo";
  private static b CpW;
  private static int CpX = 0;
  private static WeakReference<ag.c> CpY;
  public static final ah CpZ;
  private static final String TAG = "MicroMsg.OauthMultiAccountMgr";
  private static final int kfl = 4;
  
  static
  {
    AppMethodBeat.i(182642);
    CpZ = new ah();
    TAG = "MicroMsg.OauthMultiAccountMgr";
    kfl = 4;
    CpV = "snsapi_userinfo";
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
      ac.v(TAG, "[showDialogQueue] context !is Activity");
      AppMethodBeat.o(182635);
      return;
    }
    if ((CpX != paramInt) && (CpW != null))
    {
      ac.v(TAG, "[showDialogQueue] destroy last oauthQueue");
      destroy();
    }
    CpX = paramInt;
    if (CpW == null) {
      CpW = new b(paramContext);
    }
    paramContext = CpW;
    if (paramContext == null) {
      d.g.b.k.fOy();
    }
    if (paramContext.Cqo == null) {
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      CpY = new WeakReference(paramc);
      paramContext = CpW;
      if (paramContext != null)
      {
        d.g.b.k.h(paramBundle, "resp");
        paramContext.Cqo = paramBundle;
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
          paramBundle = ag.aJ((ArrayList)paramBundle);
          d.g.b.k.g(paramBundle, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
          paramContext.CpD = paramBundle;
          bg(paramContext.CpD);
          paramContext.eBr();
          AppMethodBeat.o(182635);
        }
      }
      else
      {
        AppMethodBeat.o(182635);
        return;
      }
    }
    ac.i(TAG, "[showDialogQueue] repeat call");
    AppMethodBeat.o(182635);
  }
  
  public static ArrayList<bym> aK(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(182640);
    ArrayList localArrayList = new ArrayList();
    if (bs.gY((List)paramArrayList))
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
          bym localbym = new bym();
          localbym.parseFrom(arrayOfByte);
          localArrayList.add(localbym);
        }
        catch (IOException paramArrayList)
        {
          ac.w(TAG, "bytesListToAvatarList: exception");
          localArrayList.clear();
          AppMethodBeat.o(182640);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182640);
    return localArrayList;
  }
  
  public static final ArrayList<byte[]> bf(LinkedList<bym> paramLinkedList)
  {
    AppMethodBeat.i(182639);
    ArrayList localArrayList = new ArrayList();
    if (bs.gY((List)paramLinkedList))
    {
      AppMethodBeat.o(182639);
      return localArrayList;
    }
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        bym localbym = (bym)paramLinkedList.next();
        try
        {
          localArrayList.add(localbym.toByteArray());
        }
        catch (IOException paramLinkedList)
        {
          ac.w(TAG, "oauthAvatarListToBytesList exception");
          localArrayList.clear();
          AppMethodBeat.o(182639);
          return localArrayList;
        }
      }
    }
    AppMethodBeat.o(182639);
    return localArrayList;
  }
  
  private static void bg(LinkedList<csf> paramLinkedList)
  {
    AppMethodBeat.i(182641);
    if ((bs.gY((List)paramLinkedList)) || (paramLinkedList.size() == 1))
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
        j.fOc();
      }
      if (!d.g.b.k.g(((csf)localObject).EdG, CpV)) {}
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
    b localb = CpW;
    if (localb != null) {
      localb.destroy();
    }
    CpW = null;
    CpY = null;
    AppMethodBeat.o(182638);
  }
  
  public static int eBn()
  {
    return kfl;
  }
  
  public static String eBo()
  {
    return CpV;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
  public static final class a
  {
    ah.b CpW;
    private final i.b Cqa;
    final i Cqb;
    private csf Cqc;
    boolean Cqd;
    int Cqe;
    int Cqf;
    final e Cqg;
    final Context context;
    String djj;
    final ArrayList<o.a> kfj;
    
    public a(Context paramContext, e parame)
    {
      AppMethodBeat.i(182619);
      this.context = paramContext;
      this.Cqg = parame;
      this.Cqa = ((i.b)new b(this));
      this.Cqb = new i(this.context, this.Cqa);
      this.kfj = new ArrayList();
      this.djj = "";
      AppMethodBeat.o(182619);
    }
    
    private final void a(i parami, List<o.a> paramList, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(182617);
      parami.bG(paramList);
      if ((paramBoolean) || (paramInt <= paramList.size()))
      {
        if (!paramBoolean)
        {
          parami.aBP(this.context.getResources().getString(2131766177));
          parami.MP(this.context.getResources().getColor(2131099660));
        }
        for (;;)
        {
          b(parami, false);
          AppMethodBeat.o(182617);
          return;
          parami.aBP("");
        }
      }
      parami.aBP(this.context.getResources().getString(2131766177));
      parami.MP(this.context.getResources().getColor(2131100547));
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
    
    public final void a(Bundle paramBundle, final csf paramcsf)
    {
      AppMethodBeat.i(182616);
      d.g.b.k.h(paramBundle, "resp");
      d.g.b.k.h(paramcsf, "scope");
      this.Cqc = paramcsf;
      Object localObject1 = this.Cqb;
      ((i)localObject1).RP(((i)localObject1).getContext().getString(2131760749, new Object[] { paramBundle.getString("appname", "") }));
      ((i)localObject1).RQ(paramcsf.Desc);
      ((i)localObject1).RS("");
      ((i)localObject1).Us(((i)localObject1).getContext().getResources().getString(2131760786));
      ((i)localObject1).asC(((i)localObject1).getContext().getResources().getString(2131760741));
      ((i)localObject1).qV(paramBundle.getString("appicon_url", ""));
      localObject1 = ah.CpZ;
      localObject1 = paramBundle.getSerializable("avatar_list");
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
        AppMethodBeat.o(182616);
        throw paramBundle;
      }
      Object localObject2 = ah.aK((ArrayList)localObject1);
      int i = paramBundle.getInt("default_avatar_id");
      this.Cqd = paramBundle.getBoolean("is_ban_modify_avatar");
      this.Cqe = paramBundle.getInt("avatar_limit");
      this.Cqf = 0;
      localObject1 = ag.b.aBK(paramBundle.getString("oauth_url", ""));
      d.g.b.k.g(localObject1, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
      this.djj = ((String)localObject1);
      localObject1 = paramcsf.EdG;
      Object localObject3 = ah.CpZ;
      if (d.g.b.k.g(localObject1, ah.eBo()))
      {
        this.Cqf = i;
        paramBundle = this.CpW;
        if (paramBundle != null) {
          paramBundle.UU(this.Cqf);
        }
        this.Cqb.a((o.b)new c(this));
        if (!bs.gY((List)localObject2))
        {
          this.kfj.clear();
          paramBundle = this.kfj;
          localObject1 = paramcsf.EdG;
          d.g.b.k.g(localObject1, "scope.Scope");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            bym localbym = (bym)((Iterator)localObject3).next();
            String str1 = localbym.nickname;
            String str2 = localbym.desc;
            if (i == localbym.id) {}
            for (boolean bool = true;; bool = false)
            {
              String str3 = localbym.kfi;
              d.g.b.k.g(str3, "it.avatarurl");
              ((Collection)localObject2).add(new o.a(str1, str2, (String)localObject1, bool, str3, localbym.id));
              break;
            }
          }
          paramBundle.addAll((Collection)localObject2);
          a(this.Cqb, (List)this.kfj, this.Cqd, this.Cqe);
          this.Cqb.a((o.c)new d(this, paramcsf));
          this.Cqg.b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.Cqb);
          AppMethodBeat.o(182616);
          return;
        }
        this.Cqf = i;
        paramBundle = this.CpW;
        if (paramBundle != null) {
          paramBundle.UU(this.Cqf);
        }
        paramBundle = ah.CpZ;
        ac.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, ah.a.e.Cqn.getClass(), (com.tencent.mm.ipcinvoker.d)new f(this, paramcsf));
        AppMethodBeat.o(182616);
        return;
      }
      localObject1 = ah.CpZ;
      ac.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
      this.Cqb.RP(this.context.getString(2131760747, new Object[] { paramBundle.getString("appname", "") }));
      paramBundle = this.Cqb;
      paramcsf = paramcsf.EdG;
      d.g.b.k.g(paramcsf, "scope.Scope");
      paramBundle.aBQ(paramcsf);
      this.Cqg.b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.Cqb);
      AppMethodBeat.o(182616);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(182605);
        paramView = new Intent();
        paramView.putExtra("0", this.Cqh.djj);
        Object localObject = this.Cqh.context;
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182605);
          throw paramView;
        }
        localObject = (Activity)localObject;
        if (localObject == null)
        {
          paramView = ah.CpZ;
          ac.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
          AppMethodBeat.o(182605);
          return;
        }
        localObject = (Context)localObject;
        ah localah = ah.CpZ;
        com.tencent.mm.br.d.c((Context)localObject, ".plugin.webview.ui.tools.CreateAvatarUI", paramView, ah.eBn());
        AppMethodBeat.o(182605);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
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
          localObject = ah.CpZ;
          ac.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + (String)paramArrayList.get(0));
          paramArrayList = this.Cqh.CpW;
          if (paramArrayList != null)
          {
            paramArrayList.eBr();
            AppMethodBeat.o(182606);
            return;
          }
          break;
        case 1: 
          localObject = ah.CpZ;
          ac.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + (String)paramArrayList.get(0));
          if (!bs.gY((List)paramArrayList))
          {
            localObject = this.Cqh.CpW;
            if (localObject != null)
            {
              paramArrayList = paramArrayList.get(0);
              d.g.b.k.g(paramArrayList, "select.get(0)");
              paramArrayList = (String)paramArrayList;
              d.g.b.k.h(paramArrayList, "scope");
              ((ah.b)localObject).Cqq.add(paramArrayList);
            }
          }
          paramArrayList = this.Cqh.CpW;
          if (paramArrayList != null)
          {
            paramArrayList.eBr();
            AppMethodBeat.o(182606);
            return;
          }
          AppMethodBeat.o(182606);
          return;
        }
        AppMethodBeat.o(182606);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "plugin-webview_release"})
    public static final class c
      implements o.b
    {
      public final void a(o.a parama)
      {
        AppMethodBeat.i(182607);
        d.g.b.k.h(parama, "item");
        this.Cqh.Cqf = parama.keF;
        parama = this.Cqh.CpW;
        if (parama != null)
        {
          parama.UU(this.Cqh.Cqf);
          AppMethodBeat.o(182607);
          return;
        }
        AppMethodBeat.o(182607);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
    public static final class d
      implements o.c
    {
      d(csf paramcsf) {}
      
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
        TouchableLayout.a locala1 = TouchableLayout.JyS;
        int i = TouchableLayout.fyY();
        locala1 = TouchableLayout.JyS;
        locala.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, parama, i, TouchableLayout.fyZ());
        AppMethodBeat.o(182612);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
      static final class a
        implements View.OnCreateContextMenuListener
      {
        a(ah.a.d paramd) {}
        
        public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
        {
          AppMethodBeat.i(182608);
          paramContextMenu.add(0, 1, 0, (CharSequence)this.Cqj.Cqh.context.getResources().getString(2131761557));
          AppMethodBeat.o(182608);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
      static final class b
        implements n.d
      {
        b(ah.a.d paramd, int paramInt, o.a parama) {}
        
        public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
        {
          AppMethodBeat.i(182611);
          paramMenuItem = new ArrayList((Collection)this.Cqj.Cqh.kfj);
          paramMenuItem.remove(paramInt);
          if (((o.a)this.Cqj.Cqh.kfj.get(paramInt)).keF == this.Cqj.Cqh.Cqf) {
            ((o.a)paramMenuItem.get(0)).ikl = true;
          }
          ah.a.a(this.Cqj.Cqh, this.Cqj.Cqh.Cqb, (List)paramMenuItem, this.Cqj.Cqh.Cqd, this.Cqj.Cqh.Cqe);
          Object localObject = ah.CpZ;
          ac.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + paramInt);
          localObject = new aao();
          ((aao)localObject).EuD = parama.keF;
          b.a locala = new b.a();
          locala.c((com.tencent.mm.bw.a)localObject);
          locala.d((com.tencent.mm.bw.a)new aap());
          locala.Am("/cgi-bin/mmbiz-bin/oauth_delavatar");
          locala.op(2700);
          locala.or(0);
          locala.os(0);
          IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)new IPCRunCgi.a()
          {
            public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
            {
              AppMethodBeat.i(182610);
              ap.f((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182609);
                  if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                  {
                    this.Cqm.Cql.Cqj.Cqh.kfj.clear();
                    this.Cqm.Cql.Cqj.Cqh.kfj.addAll((Collection)this.Cqm.kfw);
                    AppMethodBeat.o(182609);
                    return;
                  }
                  ah.a.a(this.Cqm.Cql.Cqj.Cqh, this.Cqm.Cql.Cqj.Cqh.Cqb, (List)this.Cqm.Cql.Cqj.Cqh.kfj, this.Cqm.Cql.Cqj.Cqh.Cqd, this.Cqm.Cql.Cqj.Cqh.Cqe);
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
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class f<T>
      implements com.tencent.mm.ipcinvoker.d<ResultType>
    {
      f(ah.a parama, csf paramcsf) {}
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
  public static final class b
  {
    LinkedList<csf> CpD;
    private e Cqg;
    Bundle Cqo;
    private ah.a Cqp;
    final ArrayList<String> Cqq;
    private int Cqr;
    final Context context;
    private int gPA;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(182634);
      this.context = paramContext;
      this.CpD = new LinkedList();
      this.Cqg = new e(this.context);
      this.Cqq = new ArrayList();
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
          paramContext.addView((View)this.Cqg);
          AppMethodBeat.o(182634);
          return;
        }
        AppMethodBeat.o(182634);
        return;
      }
      AppMethodBeat.o(182634);
    }
    
    private final void dvG()
    {
      AppMethodBeat.i(182631);
      Object localObject = this.Cqo;
      if (localObject != null) {}
      final String str;
      for (localObject = ((Bundle)localObject).getString("oauth_url", "");; localObject = null)
      {
        str = ag.b.aBK((String)localObject);
        if (!bs.gY((List)this.Cqq)) {
          break;
        }
        localObject = ah.CpZ;
        ac.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
        com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.COZ;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.a((String)localObject, ag.b.startTime, 0, 1, 0, 1, 0);
        com.tencent.mm.plugin.webview.j.b.COZ.aD(2, (int)(System.currentTimeMillis() - ag.b.CpG), 0);
        reject();
        AppMethodBeat.o(182631);
        return;
      }
      c.a(this.context, com.tencent.mm.model.gdpr.a.hqB, str, (com.tencent.mm.model.gdpr.b)new b(this, str));
      AppMethodBeat.o(182631);
    }
    
    private final boolean eBs()
    {
      AppMethodBeat.i(182630);
      ah localah;
      if (bs.gY((List)this.CpD))
      {
        localah = ah.CpZ;
        ac.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
        AppMethodBeat.o(182630);
        return true;
      }
      if (this.gPA >= this.CpD.size())
      {
        localah = ah.CpZ;
        ac.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
        AppMethodBeat.o(182630);
        return true;
      }
      AppMethodBeat.o(182630);
      return false;
    }
    
    private final void reject()
    {
      AppMethodBeat.i(182632);
      Object localObject = ah.CpZ;
      ac.i(ah.getTAG(), "[OauthQueue.reject] reject");
      UV(2);
      localObject = ah.CpZ;
      localObject = ah.eBq();
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
    
    public final void UU(int paramInt)
    {
      AppMethodBeat.i(182627);
      this.Cqr = paramInt;
      ah localah = ah.CpZ;
      ac.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(182627);
    }
    
    final void UV(int paramInt)
    {
      AppMethodBeat.i(182633);
      byi localbyi = new byi();
      Object localObject = this.Cqo;
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
      localbyi.Fnz = ((String)localObject);
      localbyi.FnA = paramInt;
      localbyi.FnB.addAll((Collection)this.Cqq);
      localbyi.EuD = this.Cqr;
      localObject = ah.CpZ;
      ac.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + localbyi.FnB + ", avatarId = " + this.Cqr);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bw.a)localbyi);
      ((b.a)localObject).d((com.tencent.mm.bw.a)new byj());
      ((b.a)localObject).Am("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
      ((b.a)localObject).op(1373);
      ((b.a)localObject).or(0);
      ((b.a)localObject).os(0);
      IPCRunCgi.a(((b.a)localObject).aAz(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(182633);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(182629);
      if (this.Cqg != null)
      {
        e locale = this.Cqg;
        if (locale != null) {
          locale.blW();
        }
        this.Cqg = null;
        this.Cqp = null;
      }
      AppMethodBeat.o(182629);
    }
    
    public final void eBr()
    {
      Object localObject2 = null;
      AppMethodBeat.i(182628);
      if (this.Cqp != null)
      {
        localObject1 = this.Cqp;
        if (localObject1 == null) {
          break label87;
        }
      }
      label87:
      for (Object localObject1 = ((ah.a)localObject1).Cqb;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = this.Cqg;
          if (localObject3 != null)
          {
            ah.a locala = this.Cqp;
            localObject1 = localObject2;
            if (locala != null) {
              localObject1 = locala.Cqb;
            }
            ((e)localObject3).c((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject1);
          }
        }
        if (!eBs()) {
          break;
        }
        dvG();
        AppMethodBeat.o(182628);
        return;
      }
      localObject1 = this.context;
      localObject2 = this.Cqg;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = new ah.a((Context)localObject1, (e)localObject2);
      ((ah.a)localObject1).CpW = ((b)this);
      localObject2 = this.Cqo;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      Object localObject3 = this.CpD.get(this.gPA);
      d.g.b.k.g(localObject3, "scopeList[curIndex]");
      ((ah.a)localObject1).a((Bundle)localObject2, (csf)localObject3);
      this.Cqp = ((ah.a)localObject1);
      this.gPA += 1;
      AppMethodBeat.o(182628);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      a(ah.b paramb) {}
      
      public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
      {
        AppMethodBeat.i(182624);
        ap.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182623);
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              Object localObject = paramb;
              d.g.b.k.g(localObject, "rr");
              localObject = ((com.tencent.mm.ak.b)localObject).aBD();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                AppMethodBeat.o(182623);
                throw ((Throwable)localObject);
              }
              localObject = (byj)localObject;
              if (!bs.isNullOrNil(((byj)localObject).DRX))
              {
                ah localah = ah.CpZ;
                localObject = ((byj)localObject).DRX;
                d.g.b.k.g(localObject, "rsp.redirect_url");
                ah.aBL((String)localObject);
                AppMethodBeat.o(182623);
                return;
              }
              ah.destroy();
              AppMethodBeat.o(182623);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.Cqt.Cqs.context, paramString, ai.getContext().getString(2131766178), (DialogInterface.OnClickListener)1.Cqu);
            AppMethodBeat.o(182623);
          }
        });
        AppMethodBeat.o(182624);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "", "onPermissionReturn"})
    static final class b
      implements com.tencent.mm.model.gdpr.b
    {
      b(ah.b paramb, String paramString) {}
      
      public final void og(final int paramInt)
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
              localObject1 = ah.CpZ;
              ac.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
              localb = com.tencent.mm.plugin.webview.j.b.COZ;
              localObject2 = this.Cqw.Cqv;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 0, 1, 0, 1, 0);
              localObject1 = ah.CpZ;
              ah.eBp();
            }
            for (;;)
            {
              com.tencent.mm.plugin.webview.j.b.COZ.aD(2, (int)(System.currentTimeMillis() - ag.b.CpG), 0);
              AppMethodBeat.o(182625);
              return;
              localObject1 = ah.CpZ;
              ac.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
              localb = com.tencent.mm.plugin.webview.j.b.COZ;
              localObject2 = this.Cqw.Cqv;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localb.a((String)localObject1, ag.b.startTime, 1, 1, 0, 1, 0);
              localObject1 = this.Cqw.Cqs;
              localObject2 = ((ah.b)localObject1).Cqo;
              if (localObject2 != null) {}
              for (boolean bool = ((Bundle)localObject2).getBoolean("is_call_server_when_confirm");; bool = false)
              {
                localObject2 = ah.CpZ;
                ac.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(bool)));
                if (!bool) {
                  break label198;
                }
                ((ah.b)localObject1).UV(1);
                break;
              }
              label198:
              localObject1 = ((ah.b)localObject1).Cqo;
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
              localObject2 = ah.CpZ;
              ah.aBL((String)localObject1);
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