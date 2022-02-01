package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ye;
import com.tencent.mm.f.a.ye.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.b.a;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.c.b;
import com.tencent.mm.plugin.textstatus.k.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "CUSTOM_TEXT_STATUS_LENGTH_LIMIT", "", "getCUSTOM_TEXT_STATUS_LENGTH_LIMIT", "()I", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "btnBack$delegate", "Lkotlin/Lazy;", "configUpdateListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1;", "customDialog", "customET", "Landroid/widget/EditText;", "customETWatcher", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "isCancel", "", "isEnter", "()Z", "setEnter", "(Z)V", "layoutContent", "getLayoutContent", "setLayoutContent", "(Landroid/view/View;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getMDataList", "()Ljava/util/ArrayList;", "onItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "doClickIcon", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "finish", "getCustomBounceId", "getForceOrientation", "getLayoutId", "hideCustomDialog", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "showCustomDialog", "showEducationLayout", "Companion", "PatTextWatcher", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity
  extends MMSecDataActivity
  implements c.a
{
  public static final a MKZ;
  private View MKQ;
  private com.tencent.mm.plugin.textstatus.a.q MKR;
  private final kotlin.f MKS;
  private final e MKT;
  private final j MKU;
  final int MKV;
  private View MKW;
  private EditText MKX;
  private TextStatusDoWhatActivity.b MKY;
  private boolean fxj;
  private boolean kUn;
  final ArrayList<com.tencent.mm.view.recyclerview.a> mDataList;
  WxRecyclerView vnF;
  
  static
  {
    AppMethodBeat.i(235092);
    MKZ = new a((byte)0);
    AppMethodBeat.o(235092);
  }
  
  public TextStatusDoWhatActivity()
  {
    AppMethodBeat.i(235089);
    this.kUn = true;
    this.MKS = g.ar((kotlin.g.a.a)new c(this));
    this.MKT = new e(this);
    this.mDataList = new ArrayList();
    this.MKU = new j(this);
    this.MKV = 8;
    this.MKY = new TextStatusDoWhatActivity.b(this);
    AppMethodBeat.o(235089);
  }
  
  private final View gmD()
  {
    AppMethodBeat.i(235071);
    View localView = (View)this.MKS.getValue();
    AppMethodBeat.o(235071);
    return localView;
  }
  
  private final void gmE()
  {
    AppMethodBeat.i(235082);
    Object localObject = this.vnF;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setVisibility(0);
    }
    gmD().setVisibility(0);
    localObject = this.MKW;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.MKX;
    if (localObject != null) {
      ((EditText)localObject).setText((CharSequence)"");
    }
    hideVKB();
    AppMethodBeat.o(235082);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(235079);
    if (this.kUn)
    {
      com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.d(this.MKR);
    }
    super.finish();
    AppMethodBeat.o(235079);
  }
  
  public final int getCustomBounceId()
  {
    return b.e.MwA;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.MxH;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(235085);
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = this.MKW;
      if (localObject1 != null) {}
      for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject1 == null) {
          break;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix((Context)this, 56) + paramInt);
        AppMethodBeat.o(235085);
        return;
      }
      AppMethodBeat.o(235085);
      return;
    }
    Object localObject1 = this.MKW;
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).getLayoutParams();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject1 == null) {
        break;
      }
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix((Context)this, 160);
      AppMethodBeat.o(235085);
      return;
    }
    AppMethodBeat.o(235085);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(235077);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(235077);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(235084);
    View localView = this.MKW;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      gmE();
      AppMethodBeat.o(235084);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(235084);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(235074);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    d.e(getWindow());
    setNavigationbarColor(getResources().getColor(b.b.transparent));
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.vnF = ((WxRecyclerView)findViewById(b.e.MwA));
    this.MKQ = findViewById(b.e.layout_content);
    paramBundle = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
    if (paramBundle != null)
    {
      localObject1 = new q.a().gkO();
      ((com.tencent.mm.plugin.textstatus.a.q)localObject1).parseFrom(paramBundle);
      this.MKR = ((com.tencent.mm.plugin.textstatus.a.q)localObject1);
    }
    if (this.MKR == null) {
      this.MKR = new q.a().gkO();
    }
    paramBundle = this.MKR;
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(235074);
      return;
    }
    paramBundle.enterTime = cm.bfE();
    Object localObject1 = paramBundle.MEA;
    Object localObject2 = m.MOX;
    localObject2 = getIntent();
    m localm = m.MOX;
    ((TextStatusExtInfo)localObject1).backgroundId = m.ajo(((Intent)localObject2).getIntExtra("KEY_DEFAULT_BACKGROUND_ID", m.gnN()));
    this.fxj = getIntent().getBooleanExtra("KEY_IS_ENTER", false);
    localObject1 = m.MOX;
    paramBundle = BitmapUtil.getBitmapNative(m.beP(paramBundle.MEA.backgroundId));
    localObject1 = this.MKQ;
    if (localObject1 != null) {
      ((View)localObject1).setBackground((Drawable)new BitmapDrawable(getResources(), paramBundle));
    }
    this.mDataList.addAll((Collection)com.tencent.mm.plugin.textstatus.k.c.gnz().getDataList());
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new TextStatusDoWhatActivity.d(this), this.mDataList));
    }
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle = paramBundle.getResources();
    p.j(paramBundle, "context.resources");
    int i = paramBundle.getDisplayMetrics().widthPixels;
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle = paramBundle.getResources();
    p.j(paramBundle, "context.resources");
    int k = Math.min(i, paramBundle.getDisplayMetrics().heightPixels);
    paramBundle = this.vnF;
    if (paramBundle != null)
    {
      i = paramBundle.getPaddingLeft();
      paramBundle = this.vnF;
      if (paramBundle == null) {
        break label666;
      }
    }
    label666:
    for (int j = paramBundle.getPaddingRight();; j = 0)
    {
      float f = getResources().getDimension(b.c.Muw);
      paramBundle = new aa.c();
      paramBundle.aaBz = getResources().getDimension(b.c.Muv);
      f = (k - i - j + paramBundle.aaBz) / (f + paramBundle.aaBz);
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = new GridLayoutManager((int)f);
      ((GridLayoutManager)((aa.f)localObject1).aaBC).a((GridLayoutManager.b)new TextStatusDoWhatActivity.g(this, (aa.f)localObject1));
      localObject2 = this.vnF;
      if (localObject2 != null) {
        ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)((aa.f)localObject1).aaBC);
      }
      localObject1 = this.vnF;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).b((RecyclerView.h)new TextStatusDoWhatActivity.h(paramBundle));
      }
      paramBundle = gmD().getLayoutParams();
      if (paramBundle != null) {
        break label672;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(235074);
      throw paramBundle;
      i = 0;
      break;
    }
    label672:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    i = ax.getStatusBarHeight((Context)getContext());
    paramBundle.topMargin = (aw.fromDPToPix((Context)getContext(), 6) + i);
    gmD().setOnClickListener((View.OnClickListener)new i(this));
    paramBundle = com.tencent.mm.kernel.h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    if (paramBundle.aHp().getInt(ar.a.VDN, 1) == 1) {}
    for (i = 1;; i = 0)
    {
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      boolean bool = paramBundle.aHp().getBoolean(ar.a.VDW, false);
      if ((i != 0) && (!bool))
      {
        paramBundle = this.MKR;
        if (paramBundle != null) {
          paramBundle.MED = 1;
        }
        paramBundle = findViewById(b.e.MuX);
        p.j(paramBundle, "findViewById<View>(R.id.education_layout)");
        paramBundle.setVisibility(0);
        paramBundle = this.vnF;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        gmD().setVisibility(8);
        com.tencent.mm.plugin.textstatus.a.t.gld();
        paramBundle = com.tencent.mm.kernel.h.aHG();
        p.j(paramBundle, "MMKernel.storage()");
        paramBundle.aHp().set(ar.a.VDN, Integer.valueOf(0));
        findViewById(b.e.MuW).setOnClickListener((View.OnClickListener)new m(this));
      }
      this.MKT.alive();
      AppMethodBeat.o(235074);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235075);
    super.onDestroy();
    this.MKT.dead();
    AppMethodBeat.o(235075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setLayoutContent(View paramView)
  {
    this.MKQ = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion;", "", "()V", "KEY_DEFAULT_BACKGROUND_ID", "", "KEY_IS_ENTER", "TAG", "start", "", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "requestCode", "", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "startForResultInEdit", "Landroid/app/Activity;", "defaultBackgroundId", "plugin-textstatus_release"})
  public static final class a
  {
    public static void a(Context paramContext, Bundle paramBundle, Integer paramInteger)
    {
      AppMethodBeat.i(233199);
      p.k(paramContext, "context");
      Intent localIntent = new Intent(paramContext, TextStatusDoWhatActivity.class);
      paramBundle.putBoolean("KEY_IS_ENTER", true);
      localIntent.putExtras(paramBundle);
      if ((paramInteger != null) && ((paramContext instanceof Activity)))
      {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInteger.intValue());
        if ((paramContext instanceof Activity)) {
          break label175;
        }
        paramContext = null;
      }
      label175:
      for (;;)
      {
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          paramContext.overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
          AppMethodBeat.o(233199);
          return;
          if (!(paramContext instanceof Activity)) {
            localIntent.addFlags(268435456);
          }
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramBundle.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$Companion", "start", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        AppMethodBeat.o(233199);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    c(TextStatusDoWhatActivity paramTextStatusDoWhatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StatusIconConfigUpdateEvent;", "callback", "", "event", "plugin-textstatus_release"})
  public static final class e
    extends IListener<ye>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1$callback$1$1"})
    static final class a
      implements Runnable
    {
      a(ye paramye, TextStatusDoWhatActivity.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(232908);
        Log.i("MicroMsg.TextStatus.TextStatusDoWhatActivity", "config update old" + this.MLb.fXv.fXw + " new:" + this.MLb.fXv.fXx);
        this.MLc.MLa.mDataList.clear();
        this.MLc.MLa.mDataList.addAll((Collection)com.tencent.mm.plugin.textstatus.k.c.gnz().getDataList());
        Object localObject = this.MLc.MLa.vnF;
        if (localObject != null)
        {
          localObject = ((WxRecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            ((RecyclerView.a)localObject).notifyDataSetChanged();
            AppMethodBeat.o(232908);
            return;
          }
        }
        AppMethodBeat.o(232908);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(234364);
      TextStatusDoWhatActivity.e(this.MLa);
      this.MLa.finish();
      AppMethodBeat.o(234364);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(236953);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.MLa.onBackPressed();
      this.MLa.getContext().overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236953);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
  public static final class j
    implements c.b
  {
    public final void a(View paramView, com.tencent.mm.plugin.textstatus.g.d.c paramc)
    {
      AppMethodBeat.i(232938);
      p.k(paramView, "v");
      p.k(paramc, "item");
      if (p.h(paramc.iconId, "custom"))
      {
        TextStatusDoWhatActivity.b(this.MLa, paramc);
        AppMethodBeat.o(232938);
        return;
      }
      TextStatusDoWhatActivity.a(this.MLa, paramc);
      AppMethodBeat.o(232938);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, com.tencent.mm.plugin.textstatus.g.d.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233095);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      com.tencent.mm.plugin.textstatus.k.c.gnz();
      paramView = TextStatusDoWhatActivity.a(this.MLa);
      if (paramView != null) {}
      for (paramView = paramView.getText();; paramView = null)
      {
        paramView = String.valueOf(paramView);
        p.k(paramView, "name");
        localObject = com.tencent.mm.kernel.h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VDM, paramView);
        TextStatusDoWhatActivity.a(this.MLa, this.MAd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233095);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234697);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showEducationLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.MLa.findViewById(b.e.MuX);
      p.j(paramView, "findViewById<View>(R.id.education_layout)");
      paramView.setVisibility(8);
      paramView = this.MLa.vnF;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      TextStatusDoWhatActivity.g(this.MLa).setVisibility(0);
      paramView = TextStatusDoWhatActivity.h(this.MLa);
      if (paramView != null) {
        paramView.MEE = 1;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showEducationLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity
 * JD-Core Version:    0.7.0.1
 */