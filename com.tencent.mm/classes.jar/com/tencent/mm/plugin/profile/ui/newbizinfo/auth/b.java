package com.tencent.mm.plugin.profile.ui.newbizinfo.auth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.webview.jsapi.a.c;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "authScopeRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getAuthScopeRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "authScopeRecyclerView$delegate", "Lkotlin/Lazy;", "curManageBtnState", "", "mainUI", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "getMainUI", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "mainUI$delegate", "manageBtn", "Landroid/widget/Button;", "getManageBtn", "()Landroid/widget/Button;", "manageBtn$delegate", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissProgressDlg", "", "initManageBtnClick", "initManageBtnPos", "initScopeRecyclerView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "sendStateChanged", "privacyItem", "Lcom/tencent/mm/protocal/protobuf/PrivacyScopeItem;", "state", "showProgressDlg", "AuthScopeAdapter", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final b.b Ncg;
  private final j GDP;
  private final j Ncf;
  private final j Nch;
  private int Nci;
  private w psR;
  
  static
  {
    AppMethodBeat.i(305839);
    Ncg = new b.b((byte)0);
    AppMethodBeat.o(305839);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305789);
    this.Nch = kotlin.k.cm((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.GDP = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.Nci = 1;
    this.Ncf = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    AppMethodBeat.o(305789);
  }
  
  private static final void C(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(305831);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(305831);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("NewBizInfoSettingJsApiUIC", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(305831);
    }
  }
  
  private static final ah a(b paramb, ehd paramehd, int paramInt, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(305826);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramehd, "$privacyItem");
    if (paramb.getActivity().isFinishing())
    {
      Log.i("NewBizInfoAuthScopeUIC", "activity.isFinishing");
      paramb = ah.aiuX;
      AppMethodBeat.o(305826);
      return paramb;
    }
    paramb.ddd();
    Log.i("NewBizInfoAuthScopeUIC", "mode: cgi result: " + parama.errType + ", " + parama.errCode);
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      aa.dc((Context)paramb.getContext(), paramb.getContext().getResources().getString(R.l.contact_info_biz_network_failed));
      paramb = ah.aiuX;
      AppMethodBeat.o(305826);
      return paramb;
    }
    aa.db((Context)paramb.getActivity(), paramb.getActivity().getResources().getString(R.l.contact_info_biz_delete_auth_notified_alert));
    parama = com.tencent.mm.plugin.profile.ui.newbizinfo.a.NbT;
    if (com.tencent.mm.plugin.profile.ui.newbizinfo.a.gCt() != null)
    {
      parama = com.tencent.mm.plugin.profile.ui.newbizinfo.a.NbT;
      parama = com.tencent.mm.plugin.profile.ui.newbizinfo.a.gCt();
      kotlin.g.b.s.checkNotNull(parama);
      parama = parama.aaJd;
      kotlin.g.b.s.s(parama, "NewBizInfoSettingJsApiUI…!.privacy_scope_item_list");
      parama = ((Iterable)parama).iterator();
      while (parama.hasNext())
      {
        ehd localehd = (ehd)parama.next();
        if (kotlin.g.b.s.p(localehd.scope, paramehd.scope)) {
          localehd.state = paramInt;
        }
      }
      paramb = paramb.gCu();
      if (paramb != null)
      {
        paramb = paramb.getAdapter();
        if (paramb != null) {
          paramb.bZE.notifyChanged();
        }
      }
    }
    paramb = ah.aiuX;
    AppMethodBeat.o(305826);
    return paramb;
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(305812);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = paramb.gCv().getLayoutParams();
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(305812);
      throw paramb;
    }
    localObject = (ConstraintLayout.LayoutParams)localObject;
    Rect localRect = new Rect();
    paramb.gCv().getGlobalVisibleRect(localRect);
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)paramb.getContext(), 108);
    int j = paramb.getContext().getResources().getDisplayMetrics().heightPixels;
    int k = ((ConstraintLayout.LayoutParams)localObject).topMargin;
    int m = localRect.bottom;
    ((ConstraintLayout.LayoutParams)localObject).setMargins(((ConstraintLayout.LayoutParams)localObject).leftMargin, k - (m - (j - i)), ((ConstraintLayout.LayoutParams)localObject).rightMargin, ((ConstraintLayout.LayoutParams)localObject).bottomMargin);
    paramb.gCv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    Log.i("NewBizInfoAuthScopeUIC", kotlin.g.b.s.X("adjust btn pos, margin top = ", Integer.valueOf(((ConstraintLayout.LayoutParams)localObject).topMargin)));
    AppMethodBeat.o(305812);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(305818);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramb.Nci == 1)
    {
      paramb.Nci = 2;
      paramb.gCv().setText((CharSequence)paramb.getResources().getString(R.l.app_finish));
    }
    for (;;)
    {
      Log.i("NewBizInfoAuthScopeUIC", kotlin.g.b.s.X("btn state switched =  ", paramb.gCv().getText()));
      paramb = paramb.gCu().getAdapter();
      if (paramb != null) {
        paramb.bZE.notifyChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(305818);
      return;
      paramb.Nci = 1;
      paramb.gCv().setText((CharSequence)paramb.getResources().getString(R.l.gMl));
    }
  }
  
  private final void ddd()
  {
    AppMethodBeat.i(305803);
    if (this.psR == null)
    {
      AppMethodBeat.o(305803);
      return;
    }
    w localw = this.psR;
    if (localw != null) {
      localw.dismiss();
    }
    this.psR = null;
    AppMethodBeat.o(305803);
  }
  
  private final RecyclerView gCu()
  {
    AppMethodBeat.i(305795);
    RecyclerView localRecyclerView = (RecyclerView)this.Nch.getValue();
    AppMethodBeat.o(305795);
    return localRecyclerView;
  }
  
  private final Button gCv()
  {
    AppMethodBeat.i(305799);
    Button localButton = (Button)this.GDP.getValue();
    AppMethodBeat.o(305799);
    return localButton;
  }
  
  public final void a(ehd paramehd)
  {
    AppMethodBeat.i(305867);
    kotlin.g.b.s.u(paramehd, "privacyItem");
    ddd();
    this.psR = com.tencent.mm.ui.base.k.a((Context)getContext(), getString(R.l.app_waiting), true, b..ExternalSyntheticLambda0.INSTANCE);
    String str = ((NewBizInfoAuthMainUI)this.Ncf.getValue()).appId;
    if (str != null) {}
    for (;;)
    {
      new a.c(3, str, "", paramehd.scope, 7).bFJ().g(new b..ExternalSyntheticLambda2(this, paramehd, 7));
      AppMethodBeat.o(305867);
      return;
      kotlin.g.b.s.bIx("appId");
      str = null;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305862);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.profile.ui.newbizinfo.a.NbT;
    if (com.tencent.mm.plugin.profile.ui.newbizinfo.a.gCt() == null)
    {
      Log.i("NewBizInfoAuthScopeUIC", "staticResp == null");
      getActivity().finish();
    }
    for (;;)
    {
      gCv().post(new b..ExternalSyntheticLambda3(this));
      gCv().setOnClickListener(new b..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(305862);
      return;
      getContext();
      paramBundle = new LinearLayoutManager();
      paramBundle.setOrientation(1);
      gCu().setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = gCu();
      Object localObject = com.tencent.mm.plugin.profile.ui.newbizinfo.a.NbT;
      localObject = com.tencent.mm.plugin.profile.ui.newbizinfo.a.gCt();
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((ddl)localObject).aaJd;
      kotlin.g.b.s.s(localObject, "NewBizInfoSettingJsApiUI…!.privacy_scope_item_list");
      paramBundle.setAdapter((RecyclerView.a)new a((LinkedList)localObject, this));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PrivacyScopeItem;", "scopeUIC", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC;", "(Ljava/util/LinkedList;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showNotifiedMenu", "", "AuthScopeHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    private final b Ncj;
    private final LinkedList<ehd> vEn;
    
    public a(LinkedList<ehd> paramLinkedList, b paramb)
    {
      AppMethodBeat.i(305750);
      this.vEn = paramLinkedList;
      this.Ncj = paramb;
      AppMethodBeat.o(305750);
    }
    
    private static final void a(a parama, int paramInt1, MenuItem paramMenuItem, int paramInt2)
    {
      AppMethodBeat.i(305794);
      kotlin.g.b.s.u(parama, "this$0");
      paramMenuItem = parama.Ncj;
      parama = parama.vEn.get(paramInt1);
      kotlin.g.b.s.s(parama, "dataList[position]");
      paramMenuItem.a((ehd)parama);
      AppMethodBeat.o(305794);
    }
    
    private static final void a(a parama, int paramInt, View paramView)
    {
      AppMethodBeat.i(305766);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parama, "this$0");
      parama.afS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(305766);
    }
    
    private final boolean afS(int paramInt)
    {
      AppMethodBeat.i(305758);
      Object localObject1 = this.vEn.get(paramInt);
      kotlin.g.b.s.s(localObject1, "dataList[position]");
      Object localObject2 = (ehd)localObject1;
      localObject1 = new com.tencent.mm.ui.widget.a.f((Context)this.Ncj.getContext(), 1, true);
      Object localObject3 = am.aixg;
      localObject3 = this.Ncj.getContext().getResources().getString(R.l.gAM);
      kotlin.g.b.s.s(localObject3, "scopeUIC.context.resourc…act_info_biz_delete_auth)");
      localObject2 = String.format((String)localObject3, Arrays.copyOf(new Object[] { ((ehd)localObject2).desc }, 1));
      kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      ((com.tencent.mm.ui.widget.a.f)localObject1).h((CharSequence)localObject2, 17, com.tencent.mm.cd.a.fromDPToPix((Context)this.Ncj.getContext(), 12));
      ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = b.a..ExternalSyntheticLambda2.INSTANCE;
      ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new b.a..ExternalSyntheticLambda3(this, paramInt);
      ((com.tencent.mm.ui.widget.a.f)localObject1).dDn();
      AppMethodBeat.o(305758);
      return true;
    }
    
    private static final boolean b(a parama, int paramInt, View paramView)
    {
      AppMethodBeat.i(305774);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(parama, "this$0");
      boolean bool = parama.afS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(305774);
      return bool;
    }
    
    private static final void p(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(305783);
      params.oh(0, R.l.gAN);
      AppMethodBeat.o(305783);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(305830);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gie, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(305830);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(305846);
      kotlin.g.b.s.u(paramv, "holder");
      if (!(paramv instanceof a))
      {
        AppMethodBeat.o(305846);
        return;
      }
      Object localObject1;
      ehd localehd;
      if (paramInt == 0)
      {
        ((a)paramv).Nck.setVisibility(0);
        localObject1 = this.vEn.get(paramInt);
        kotlin.g.b.s.s(localObject1, "dataList[position]");
        localehd = (ehd)localObject1;
        if (b.b(this.Ncj) != 1) {
          break label268;
        }
        ((a)paramv).lPb.setVisibility(0);
        if (!aw.isDarkMode()) {
          break label258;
        }
        localObject1 = localehd.abmt;
        label101:
        int i = com.tencent.mm.cd.a.fromDPToPix((Context)this.Ncj.getContext(), 24);
        Object localObject2 = new c.a();
        ((c.a)localObject2).oKp = true;
        ((c.a)localObject2).oKn = true;
        localObject2 = ((c.a)localObject2).eG(i, i).bKx();
        r.bKe().a((String)localObject1, ((a)paramv).lPb, (c)localObject2);
        ((a)paramv).lPb.setOnClickListener(null);
        label178:
        ((a)paramv).descTv.setText((CharSequence)localehd.desc);
        if (localehd.state != 7) {
          break label314;
        }
        ((a)paramv).Dip.setVisibility(0);
      }
      for (;;)
      {
        if (b.b(this.Ncj) != 2) {
          break label329;
        }
        paramv.caK.setOnLongClickListener(null);
        AppMethodBeat.o(305846);
        return;
        ((a)paramv).Nck.setVisibility(8);
        break;
        label258:
        localObject1 = localehd.icon_url;
        break label101;
        label268:
        if (b.b(this.Ncj) != 2) {
          break label178;
        }
        ((a)paramv).lPb.setImageResource(R.k.app_brand_star_delete);
        ((a)paramv).lPb.setOnClickListener(new b.a..ExternalSyntheticLambda0(this, paramInt));
        break label178;
        label314:
        ((a)paramv).Dip.setVisibility(8);
      }
      label329:
      paramv.caK.setOnLongClickListener(new b.a..ExternalSyntheticLambda1(this, paramInt));
      AppMethodBeat.o(305846);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(305851);
      int i = this.vEn.size();
      AppMethodBeat.o(305851);
      return i;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter$AuthScopeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthScopeUIC$AuthScopeAdapter;Landroid/view/View;)V", "bottomLine", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBottomLine", "()Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "iconIv", "getIconIv", "stateTv", "getStateTv", "topLine", "getTopLine", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends RecyclerView.v
    {
      final TextView Dip;
      final ImageView Nck;
      private final ImageView Ncl;
      final TextView descTv;
      final ImageView lPb;
      
      public a()
      {
        super();
        AppMethodBeat.i(305769);
        this.lPb = ((ImageView)localObject.findViewById(R.h.fCc));
        this.descTv = ((TextView)localObject.findViewById(R.h.fCb));
        this.Dip = ((TextView)localObject.findViewById(R.h.fCd));
        this.Nck = ((ImageView)localObject.findViewById(R.h.fCe));
        this.Ncl = ((ImageView)localObject.findViewById(R.h.fCa));
        AppMethodBeat.o(305769);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<NewBizInfoAuthMainUI>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Button>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.auth.b
 * JD-Core Version:    0.7.0.1
 */