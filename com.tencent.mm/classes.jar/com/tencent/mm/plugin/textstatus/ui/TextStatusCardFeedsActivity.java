package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.emoji.panel.layout.a.d;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.j.a;
import com.tencent.mm.plugin.textstatus.h.c.e;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.pulldown.f.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "cardEventListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$cardEventListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$cardEventListener$1;", "pagerSnapHelper", "Lcom/tencent/mm/plugin/textstatus/model/feed/FooterPagerSnapHelper;", "rvCardFeed", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRvCardFeed", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "rvCardFeed$delegate", "Lkotlin/Lazy;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "finish", "", "getCustomBounceId", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TextStatusCardFeedsActivity
  extends MMSecDataActivity
{
  public static final a Txc;
  private static final LinkedList<com.tencent.mm.plugin.textstatus.h.f.b> Txg;
  private final kotlin.j Txd;
  private e Txe;
  private final c Txf;
  
  static
  {
    AppMethodBeat.i(291486);
    Txc = new a((byte)0);
    Txg = new LinkedList();
    AppMethodBeat.o(291486);
  }
  
  public TextStatusCardFeedsActivity()
  {
    AppMethodBeat.i(291423);
    this.Txd = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Txf = new c(this);
    AppMethodBeat.o(291423);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(291454);
    s.u(parame, "$this_apply");
    parame.aVV();
    AppMethodBeat.o(291454);
  }
  
  private static final void a(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity)
  {
    AppMethodBeat.i(291459);
    s.u(paramTextStatusCardFeedsActivity, "this$0");
    paramTextStatusCardFeedsActivity = paramTextStatusCardFeedsActivity.Txe;
    if (paramTextStatusCardFeedsActivity != null) {
      paramTextStatusCardFeedsActivity.aVV();
    }
    AppMethodBeat.o(291459);
  }
  
  private static final boolean a(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291447);
    s.u(paramTextStatusCardFeedsActivity, "this$0");
    paramTextStatusCardFeedsActivity.onBackPressed();
    AppMethodBeat.o(291447);
    return true;
  }
  
  private final WxRecyclerView hID()
  {
    AppMethodBeat.i(291433);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.Txd.getValue();
    AppMethodBeat.o(291433);
    return localWxRecyclerView;
  }
  
  private final g hIE()
  {
    AppMethodBeat.i(291440);
    g localg = (g)new b(this);
    AppMethodBeat.o(291440);
    return localg;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void finish()
  {
    AppMethodBeat.i(291518);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_SCROLL_USER_NAME", ((com.tencent.mm.plugin.textstatus.ui.a.a)component(com.tencent.mm.plugin.textstatus.ui.a.a.class)).TAC);
    ah localah = ah.aiuX;
    setResult(-1, localIntent);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.textstatus.a.a.anim_not_change, com.tencent.mm.plugin.textstatus.a.a.push_down_out);
    AppMethodBeat.o(291518);
  }
  
  public int getCustomBounceId()
  {
    return a.e.TdQ;
  }
  
  public int getLayoutId()
  {
    return a.f.Tfc;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(291572);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    int i;
    try
    {
      i = ((com.tencent.mm.plugin.textstatus.ui.a.a)component(com.tencent.mm.plugin.textstatus.ui.a.a.class)).Ahg;
      paramConfiguration = (j)component(j.class);
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)Txg).iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(new com.tencent.mm.plugin.textstatus.h.c.c((com.tencent.mm.plugin.textstatus.h.f.b)localIterator.next()));
      }
      ((ArrayList)localObject).add(new com.tencent.mm.plugin.textstatus.h.c.a());
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusCardFeedsActivity", paramConfiguration, "onConfigurationChanged err", new Object[0]);
      AppMethodBeat.o(291572);
      return;
    }
    paramConfiguration.mlt = ((RecyclerView.a)new WxRecyclerAdapter(hIE(), (ArrayList)localObject));
    hID().setAdapter(paramConfiguration.mlt);
    paramConfiguration = hID();
    Object localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramConfiguration, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Undefined", "scrollToPosition", "(I)V");
    paramConfiguration.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramConfiguration, "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Undefined", "scrollToPosition", "(I)V");
    hID().post(new TextStatusCardFeedsActivity..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(291572);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291546);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.transparent));
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setBackBtn(new TextStatusCardFeedsActivity..ExternalSyntheticLambda0(this));
    paramBundle = getIntent().getStringExtra("KEY_USER_NAME");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(j.class);
    s.s(localObject1, "UICProvider.of(this).get…pPageDataUIC::class.java)");
    localObject1 = (j)localObject1;
    Object localObject2 = new ArrayList();
    Object localObject3 = ((Iterable)Txg).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.textstatus.h.c.c((com.tencent.mm.plugin.textstatus.h.f.b)((Iterator)localObject3).next()));
    }
    ((ArrayList)localObject2).add(new com.tencent.mm.plugin.textstatus.h.c.a());
    Log.i("MicroMsg.TextStatus.TextStatusCardFeedsActivity", "onCreate");
    hID().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    localObject3 = getBounceView();
    if (localObject3 != null) {
      ((com.tencent.mm.ui.widget.pulldown.f)localObject3).a((f.a)new d(this));
    }
    ((j)localObject1).mlt = ((RecyclerView.a)new WxRecyclerAdapter(hIE(), (ArrayList)localObject2));
    hID().setAdapter(((j)localObject1).mlt);
    localObject1 = (Iterable)localObject2;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (com.tencent.mm.view.recyclerview.a)localObject2;
      if (((localObject2 instanceof com.tencent.mm.plugin.textstatus.h.c.c)) && (s.p(((com.tencent.mm.plugin.textstatus.h.c.c)localObject2).Tmb.field_UserName, paramBundle)))
      {
        localObject2 = hID();
        localObject3 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "scrollToPosition", "(I)V");
        ((WxRecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      i += 1;
    }
    paramBundle = new e((byte)0);
    paramBundle.a((RecyclerView)hID());
    paramBundle.mmb = ((com.tencent.mm.emoji.panel.layout.a.b)new e(this));
    paramBundle.mmc = ((a.c)new f(this));
    paramBundle.mmd = ((a.d)new g());
    hID().post(new TextStatusCardFeedsActivity..ExternalSyntheticLambda1(paramBundle));
    paramBundle.mlW = 20.0F;
    localObject1 = ah.aiuX;
    this.Txe = paramBundle;
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.p.class, 9, (byte)0));
    paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject1 = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)this, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (localObject1 != null)
    {
      paramBundle = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramBundle = com.tencent.mm.plugin.textstatus.i.b.hHY();
      if (paramBundle != null) {
        break label647;
      }
    }
    label647:
    for (paramBundle = null;; paramBundle = paramBundle.sessionId)
    {
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject1).sessionId = paramBundle;
      AppMethodBeat.o(291546);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(291556);
    super.onDestroy();
    AppMethodBeat.o(291556);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(291550);
    setRequestedOrientation(1);
    super.onResume();
    AppMethodBeat.o(291550);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(291564);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(j.class);
    paramHashSet.add(com.tencent.mm.plugin.textstatus.ui.a.a.class);
    paramHashSet.add(com.tencent.mm.plugin.textstatus.i.a.class);
    AppMethodBeat.o(291564);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$Companion;", "", "()V", "KEY_USER_NAME", "", "TAG", "itemsSnapShot", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItemsSnapShot", "()Ljava/util/LinkedList;", "prepareStart", "", "context", "Landroid/content/Context;", "userName", "startForResult", "requestCode", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static void ca(Context paramContext, String paramString)
    {
      AppMethodBeat.i(291837);
      TextStatusCardFeedsActivity.hIF().clear();
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      paramContext = com.tencent.mm.ui.component.k.nq(paramContext).q(j.class);
      s.s(paramContext, "UICProvider.of(context).…pPageDataUIC::class.java)");
      paramContext = (j)paramContext;
      paramContext.Tzm = paramString;
      paramContext = ((Iterable)paramContext.pUj).iterator();
      break label99;
      label54:
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        paramString = (com.tencent.mm.view.recyclerview.a)paramContext.next();
      } while (!(paramString instanceof com.tencent.mm.plugin.textstatus.h.g.b));
      paramString = ((Iterable)((com.tencent.mm.plugin.textstatus.h.g.b)paramString).TnV.bMQ).iterator();
      for (;;)
      {
        label99:
        if (!paramString.hasNext()) {
          break label54;
        }
        localObject = (com.tencent.mm.plugin.textstatus.h.f.b)paramString.next();
        a locala = TextStatusCardFeedsActivity.Txc;
        TextStatusCardFeedsActivity.hIF().add(localObject);
        if (!ac.hGr()) {
          break;
        }
        int i = 0;
        while (i < 20)
        {
          locala = TextStatusCardFeedsActivity.Txc;
          TextStatusCardFeedsActivity.hIF().add(localObject);
          i += 1;
        }
      }
      AppMethodBeat.o(291837);
    }
    
    public static void cb(Context paramContext, String paramString)
    {
      AppMethodBeat.i(291844);
      s.u(paramContext, "context");
      ca(paramContext, paramString);
      Intent localIntent = new Intent(paramContext, TextStatusSameTopicsActivity.class);
      localIntent.putExtra("KEY_USER_NAME", paramString);
      if ((paramContext instanceof Activity))
      {
        paramString = (Activity)paramContext;
        if (paramString != null) {
          com.tencent.mm.hellhoundlib.a.a.a(paramString, com.tencent.mm.hellhoundlib.b.c.a(1002, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$Companion", "startForResult", "(Landroid/content/Context;Ljava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        }
        if (!(paramContext instanceof Activity)) {
          break label125;
        }
      }
      label125:
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        if (paramContext != null) {
          paramContext.overridePendingTransition(com.tencent.mm.plugin.textstatus.a.a.push_up_in, com.tencent.mm.plugin.textstatus.a.a.anim_not_change);
        }
        AppMethodBeat.o(291844);
        return;
        paramString = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    b(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291841);
      if (paramInt == 1)
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.h.c.b();
        AppMethodBeat.o(291841);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.h.c.d((j.a)TextStatusCardFeedsActivity.b(this.Txh));
      AppMethodBeat.o(291841);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$cardEventListener$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "onEvent", "", "event", "", "extra", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements j.a
  {
    c(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity) {}
    
    public final void aok(int paramInt)
    {
      AppMethodBeat.i(291834);
      if (paramInt == 1) {
        this.Txh.onBackPressed();
      }
      AppMethodBeat.o(291834);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$onCreate$2", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "lastOffset", "", "getLastOffset", "()I", "setLastOffset", "(I)V", "onBounceOffsetChanged", "", "offset", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements f.a
  {
    private int ESj;
    
    d(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity) {}
    
    public final void Wm(int paramInt)
    {
      AppMethodBeat.i(291849);
      if ((paramInt != 0) && (this.ESj == 0) && (paramInt > 0))
      {
        localObject = ((com.tencent.mm.plugin.textstatus.ui.a.a)this.Txh.component(com.tencent.mm.plugin.textstatus.ui.a.a.class)).hKd();
        if (localObject != null) {
          break label76;
        }
        localObject = null;
        if (!(localObject instanceof com.tencent.mm.plugin.textstatus.a.j)) {
          break label84;
        }
      }
      label76:
      label84:
      for (Object localObject = (com.tencent.mm.plugin.textstatus.a.j)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((com.tencent.mm.plugin.textstatus.a.j)localObject).Fu(false);
        }
        this.ESj = paramInt;
        AppMethodBeat.o(291849);
        return;
        localObject = ((com.tencent.mm.view.recyclerview.j)localObject).tag;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$onCreate$4$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.emoji.panel.layout.a.b
  {
    e(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(291850);
      Log.d("MicroMsg.TextStatus.TextStatusCardFeedsActivity", s.X("onPageSelected() called with: position = ", Integer.valueOf(paramInt)));
      com.tencent.mm.plugin.textstatus.ui.a.a locala = (com.tencent.mm.plugin.textstatus.ui.a.a)this.Txh.component(com.tencent.mm.plugin.textstatus.ui.a.a.class);
      Object localObject1 = (RecyclerView)TextStatusCardFeedsActivity.c(this.Txh);
      s.u(localObject1, "recyclerView");
      localObject1 = ((RecyclerView)localObject1).fU(paramInt);
      label74:
      label86:
      label93:
      Object localObject2;
      if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j))
      {
        localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
        if (localObject1 != null) {
          break label208;
        }
        localObject1 = null;
        if (!(localObject1 instanceof h)) {
          break label216;
        }
        localObject1 = (h)localObject1;
        if (localObject1 != null) {
          break label221;
        }
        localObject1 = "";
        localObject2 = (CharSequence)locala.TAD;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label241;
        }
        i = 1;
        label118:
        if (i == 0) {
          if (!n.bp((CharSequence)localObject1)) {
            break label246;
          }
        }
      }
      label208:
      label216:
      label221:
      label241:
      label246:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          locala.TAC = ((String)localObject1);
        }
        locala.TAD = ((String)localObject1);
        Log.d("MicroMsg.TextStatus.TextStatusCardFeedUIC", "onPageSelected() called with: position = " + paramInt + ", lastScrollName:" + locala.TAC + " lastSelectUserName:" + locala.TAD);
        AppMethodBeat.o(291850);
        return;
        localObject1 = null;
        break;
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).tag;
        break label74;
        localObject1 = null;
        break label86;
        localObject2 = ((h)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label93;
        }
        localObject1 = "";
        break label93;
        i = 0;
        break label118;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$onCreate$4$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements a.c
  {
    f(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity) {}
    
    public final void rL(int paramInt)
    {
      AppMethodBeat.i(291809);
      com.tencent.mm.plugin.textstatus.ui.a.a locala = (com.tencent.mm.plugin.textstatus.ui.a.a)this.Txh.component(com.tencent.mm.plugin.textstatus.ui.a.a.class);
      RecyclerView localRecyclerView = (RecyclerView)TextStatusCardFeedsActivity.c(this.Txh);
      s.u(localRecyclerView, "recyclerView");
      Log.d("MicroMsg.TextStatus.TextStatusCardFeedUIC", "onPageSettle() called with: position = " + paramInt + " lastPos:" + locala.Ahg);
      label105:
      Object localObject2;
      label140:
      int i;
      if (paramInt != locala.Ahg)
      {
        localObject1 = locala.hKd();
        if (localObject1 != null) {
          break label303;
        }
        localObject1 = null;
        if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.a.j)) {
          break label311;
        }
        localObject1 = (com.tencent.mm.plugin.textstatus.a.j)localObject1;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.textstatus.a.j)localObject1).hFx();
          ((com.tencent.mm.plugin.textstatus.a.j)localObject1).Ft(false);
          if (locala.Ahg <= paramInt) {
            break label316;
          }
          ((com.tencent.mm.plugin.textstatus.a.j)localObject1).wk(202L);
          localObject2 = localRecyclerView.getAdapter();
          if (localObject2 != null) {
            break label337;
          }
          i = 0;
          label154:
          if (paramInt == i - 1)
          {
            localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
            if (com.tencent.mm.plugin.textstatus.b.f.bdN(com.tencent.mm.plugin.auth.a.a.cUx()) == null) {
              break label346;
            }
            i = 1;
            label177:
            if (i == 0)
            {
              localObject2 = com.tencent.mm.plugin.textstatus.i.b.Trt;
              com.tencent.mm.plugin.textstatus.i.b.a(33L, null, null, 0L, null, 30);
            }
            ((com.tencent.mm.plugin.textstatus.a.j)localObject1).Fu(true);
          }
        }
        localObject1 = localRecyclerView.fU(paramInt);
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j))
        {
          locala.TAB = new WeakReference(localObject1);
          localObject1 = locala.hKd();
          if (localObject1 != null) {
            break label351;
          }
          localObject1 = null;
          label244:
          if (!(localObject1 instanceof h)) {
            break label359;
          }
        }
      }
      label303:
      label311:
      label316:
      label337:
      label346:
      label351:
      label359:
      for (Object localObject1 = (h)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          ((h)localObject1).hFw();
          ((h)localObject1).def();
          ((h)localObject1).Ft(locala.TAA);
          if (locala.TAA) {
            locala.TAA = false;
          }
        }
        locala.Ahg = paramInt;
        AppMethodBeat.o(291809);
        return;
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).tag;
        break;
        localObject1 = null;
        break label105;
        if (locala.Ahg >= paramInt) {
          break label140;
        }
        ((com.tencent.mm.plugin.textstatus.a.j)localObject1).wk(201L);
        break label140;
        i = ((RecyclerView.a)localObject2).getItemCount();
        break label154;
        i = 0;
        break label177;
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).tag;
        break label244;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusCardFeedsActivity$onCreate$4$3", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "onPageStartChange", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements a.d
  {
    public final void rM(int paramInt)
    {
      AppMethodBeat.i(291815);
      Log.d("MicroMsg.TextStatus.TextStatusCardFeedsActivity", s.X("onPageStartChange() called with: position = ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(291815);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    h(TextStatusCardFeedsActivity paramTextStatusCardFeedsActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusCardFeedsActivity
 * JD-Core Version:    0.7.0.1
 */