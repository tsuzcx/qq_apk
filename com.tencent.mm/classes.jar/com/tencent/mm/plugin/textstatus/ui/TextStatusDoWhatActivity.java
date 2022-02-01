package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zx;
import com.tencent.mm.autogen.a.zx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.b.c.b;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "CUSTOM_TEXT_STATUS_LENGTH_LIMIT", "", "getCUSTOM_TEXT_STATUS_LENGTH_LIMIT", "()I", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "btnBack$delegate", "Lkotlin/Lazy;", "callback", "Landroid/os/ResultReceiver;", "getCallback", "()Landroid/os/ResultReceiver;", "callback$delegate", "configUpdateListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$configUpdateListener$1;", "customDialog", "customET", "Landroid/widget/EditText;", "customETWatcher", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "customTitle", "", "getCustomTitle", "()Ljava/lang/String;", "setCustomTitle", "(Ljava/lang/String;)V", "isCancel", "", "isEnter", "()Z", "setEnter", "(Z)V", "layoutContent", "getLayoutContent", "setLayoutContent", "(Landroid/view/View;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getMDataList", "()Ljava/util/ArrayList;", "onItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1;", "profileController", "Lcom/tencent/mm/ui/vas/IContactProfileController;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "testToggle", "getTestToggle", "setTestToggle", "vCustomDialogMask", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkConfirmEnable", "", "doClickIcon", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "finish", "getCustomBounceId", "getForceOrientation", "getLayoutId", "hideCustomDialog", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onPause", "showCustomDialog", "showEducationLayout", "Companion", "PatTextWatcher", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusDoWhatActivity
  extends MMSecDataActivity
  implements c.a
{
  public static final TextStatusDoWhatActivity.a Txk;
  private View Txl;
  private String Txm;
  private w Txn;
  private final j Txo;
  private final configUpdateListener.1 Txp;
  private final h Txq;
  final int Txr;
  private View Txs;
  private EditText Txt;
  private b Txu;
  private View Txv;
  private final j cEV;
  private boolean hBO;
  final ArrayList<com.tencent.mm.view.recyclerview.a> mDataList;
  private boolean nzW;
  WxRecyclerView yAg;
  
  static
  {
    AppMethodBeat.i(291791);
    Txk = new TextStatusDoWhatActivity.a((byte)0);
    AppMethodBeat.o(291791);
  }
  
  public TextStatusDoWhatActivity()
  {
    AppMethodBeat.i(291677);
    this.Txm = "";
    this.nzW = true;
    this.Txo = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.cEV = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Txp = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static final void a(zx paramAnonymouszx, TextStatusDoWhatActivity paramAnonymousTextStatusDoWhatActivity)
      {
        AppMethodBeat.i(291252);
        s.u(paramAnonymouszx, "$it");
        s.u(paramAnonymousTextStatusDoWhatActivity, "this$0");
        Log.i("MicroMsg.TextStatus.TextStatusDoWhatActivity", "config update old" + paramAnonymouszx.idv.idw + " new:" + paramAnonymouszx.idv.idy);
        paramAnonymousTextStatusDoWhatActivity.mDataList.clear();
        paramAnonymousTextStatusDoWhatActivity.mDataList.addAll((Collection)com.tencent.mm.plugin.textstatus.util.b.hKh().getDataList());
        paramAnonymouszx = paramAnonymousTextStatusDoWhatActivity.yAg;
        if (paramAnonymouszx != null)
        {
          paramAnonymouszx = paramAnonymouszx.getAdapter();
          if (paramAnonymouszx != null) {
            paramAnonymouszx.bZE.notifyChanged();
          }
        }
        AppMethodBeat.o(291252);
      }
    };
    this.mDataList = new ArrayList();
    this.Txq = new h(this);
    this.Txr = 8;
    this.Txu = new b();
    AppMethodBeat.o(291677);
  }
  
  private final void a(com.tencent.mm.plugin.textstatus.h.e.c paramc)
  {
    AppMethodBeat.i(291697);
    if (this.hBO)
    {
      localObject1 = this.Txn;
      if (localObject1 != null) {
        ((w)localObject1).Tog.topicInfo.iconId = paramc.iconId;
      }
      for (;;)
      {
        if (s.p(paramc.iconId, "userdefine")) {
          ((w)localObject1).Tog.topicInfo.title = this.Txm;
        }
        paramc = (ResultReceiver)getIntent().getParcelableExtra("CALLBACK");
        Object localObject2 = TextStatusEditActivity.Txz;
        localObject2 = (Context)this;
        s.s(localObject1, "param");
        TextStatusEditActivity.a.a((Context)localObject2, (w)localObject1, true, paramc);
        com.tencent.threadpool.h.ahAA.o(new TextStatusDoWhatActivity..ExternalSyntheticLambda5(this), 50L);
        AppMethodBeat.o(291697);
        return;
        localObject1 = new w.a().bdr(paramc.iconId);
        ((w.a)localObject1).ThS.enterTime = 0L;
        localObject1 = ((w.a)localObject1).ThS;
        ((w)localObject1).sessionId = "";
        ((w)localObject1).Toi = 0L;
        ((w)localObject1).Toj = 0;
        ((w)localObject1).Tok = 0;
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("STATUS_TYPE_CUSTOM_TITLE", this.Txm);
    ((Intent)localObject1).putExtra("STATUS_TYPE_IMG", paramc.iconId);
    paramc = this.Txn;
    if (paramc == null)
    {
      i = 0;
      ((Intent)localObject1).putExtra("ClkCustomIconCount", i);
      paramc = this.Txn;
      if (paramc != null) {
        break label292;
      }
    }
    label292:
    for (int i = 0;; i = paramc.Tom)
    {
      ((Intent)localObject1).putExtra("CustomTitleTooLongCount", i);
      setResult(-1, (Intent)localObject1);
      this.nzW = false;
      finish();
      getContext().overridePendingTransition(0, a.a.push_down_out);
      AppMethodBeat.o(291697);
      return;
      i = paramc.Tol;
      break;
    }
  }
  
  private static final void a(TextStatusDoWhatActivity paramTextStatusDoWhatActivity)
  {
    AppMethodBeat.i(291720);
    s.u(paramTextStatusDoWhatActivity, "this$0");
    paramTextStatusDoWhatActivity.nzW = false;
    paramTextStatusDoWhatActivity.finish();
    AppMethodBeat.o(291720);
  }
  
  private static final void a(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, View paramView)
  {
    AppMethodBeat.i(291713);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusDoWhatActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusDoWhatActivity, "this$0");
    paramTextStatusDoWhatActivity.onBackPressed();
    paramTextStatusDoWhatActivity.getContext().overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291713);
  }
  
  private static final void a(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, com.tencent.mm.plugin.textstatus.h.e.c paramc, View paramView)
  {
    AppMethodBeat.i(291734);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusDoWhatActivity);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusDoWhatActivity, "this$0");
    s.u(paramc, "$item");
    paramView = paramTextStatusDoWhatActivity.Txt;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getText())
    {
      paramView = String.valueOf(paramView);
      if (paramView != null) {
        break;
      }
      paramTextStatusDoWhatActivity = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(291734);
      throw paramTextStatusDoWhatActivity;
    }
    paramView = n.bq((CharSequence)paramView).toString();
    s.u(paramView, "<set-?>");
    paramTextStatusDoWhatActivity.Txm = paramView;
    paramTextStatusDoWhatActivity.a(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291734);
  }
  
  private static final void b(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, View paramView)
  {
    AppMethodBeat.i(291725);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusDoWhatActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusDoWhatActivity, "this$0");
    paramTextStatusDoWhatActivity.hIK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291725);
  }
  
  private static final void c(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, View paramView)
  {
    AppMethodBeat.i(291728);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusDoWhatActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusDoWhatActivity, "this$0");
    paramTextStatusDoWhatActivity.hIK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291728);
  }
  
  private static final void d(TextStatusDoWhatActivity paramTextStatusDoWhatActivity, View paramView)
  {
    AppMethodBeat.i(291739);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusDoWhatActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusDoWhatActivity, "this$0");
    paramTextStatusDoWhatActivity.findViewById(a.e.Tcj).setVisibility(8);
    paramView = paramTextStatusDoWhatActivity.yAg;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramTextStatusDoWhatActivity.hII().setVisibility(0);
    paramTextStatusDoWhatActivity = paramTextStatusDoWhatActivity.Txn;
    if (paramTextStatusDoWhatActivity != null) {
      paramTextStatusDoWhatActivity.Tok = 1;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291739);
  }
  
  private final View hII()
  {
    AppMethodBeat.i(291686);
    View localView = (View)this.Txo.getValue();
    AppMethodBeat.o(291686);
    return localView;
  }
  
  private final void hIK()
  {
    AppMethodBeat.i(291704);
    Object localObject = this.Txs;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.Txv;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.Txt;
    if (localObject != null) {
      ((EditText)localObject).setText((CharSequence)"");
    }
    hideVKB();
    AppMethodBeat.o(291704);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(291881);
    Object localObject;
    w localw;
    if (this.nzW)
    {
      if (this.hBO)
      {
        localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.e(this.Txn);
        localObject = (ResultReceiver)this.cEV.getValue();
        if (localObject != null) {
          ((ResultReceiver)localObject).send(0, null);
        }
      }
      localObject = new Intent();
      localw = this.Txn;
      if (localw != null) {
        break label119;
      }
      i = 0;
      ((Intent)localObject).putExtra("ClkCustomIconCount", i);
      localw = this.Txn;
      if (localw != null) {
        break label127;
      }
    }
    label119:
    label127:
    for (int i = 0;; i = localw.Tom)
    {
      ((Intent)localObject).putExtra("CustomTitleTooLongCount", i);
      setResult(0, (Intent)localObject);
      super.finish();
      AppMethodBeat.o(291881);
      return;
      i = localw.Tol;
      break;
    }
  }
  
  public final int getCustomBounceId()
  {
    return a.e.TdR;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfl;
  }
  
  public final void hIJ()
  {
    AppMethodBeat.i(291887);
    Object localObject1 = this.Txs;
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.Txt;
        if (localObject2 != null) {
          break label66;
        }
        i = 0;
        label34:
        if (i <= 0) {
          break label114;
        }
      }
    }
    label66:
    label114:
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      AppMethodBeat.o(291887);
      return;
      localObject1 = (Button)((View)localObject1).findViewById(a.e.btn_ok);
      break;
      localObject2 = ((EditText)localObject2).getText();
      if (localObject2 == null)
      {
        i = 0;
        break label34;
      }
      localObject2 = n.bq((CharSequence)localObject2);
      if (localObject2 == null)
      {
        i = 0;
        break label34;
      }
      i = ((CharSequence)localObject2).length();
      break label34;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(291871);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(291871);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(291892);
    View localView = this.Txs;
    if ((localView != null) && (localView.getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      hIK();
      AppMethodBeat.o(291892);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(291892);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291854);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    d.g(getWindow());
    setNavigationbarColor(getResources().getColor(a.b.transparent));
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.yAg = ((WxRecyclerView)findViewById(a.e.TdR));
    this.Txl = findViewById(a.e.layout_content);
    Object localObject1 = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
    if (localObject1 != null)
    {
      paramBundle = new w.a().ThS;
      paramBundle.parseFrom((byte[])localObject1);
      localObject1 = ah.aiuX;
      this.Txn = paramBundle;
    }
    if (this.Txn == null) {
      this.Txn = new w.a().ThS;
    }
    Object localObject2 = this.Txn;
    if (localObject2 == null)
    {
      finish();
      AppMethodBeat.o(291854);
      return;
    }
    localObject1 = getIntent().getStringExtra("KEY_CUSTOM_TITLE");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.Txm = paramBundle;
    ((w)localObject2).enterTime = cn.bDw();
    paramBundle = ((w)localObject2).Tog;
    localObject1 = com.tencent.mm.plugin.textstatus.util.k.TBx;
    localObject1 = getIntent();
    com.tencent.mm.plugin.textstatus.util.k localk = com.tencent.mm.plugin.textstatus.util.k.TBx;
    paramBundle.backgroundId = com.tencent.mm.plugin.textstatus.util.k.aoC(((Intent)localObject1).getIntExtra("KEY_DEFAULT_BACKGROUND_ID", com.tencent.mm.plugin.textstatus.util.k.hKA()));
    this.hBO = getIntent().getBooleanExtra("KEY_IS_ENTER", false);
    paramBundle = com.tencent.mm.plugin.textstatus.util.k.TBx;
    paramBundle = BitmapUtil.getBitmapNative(com.tencent.mm.plugin.textstatus.util.k.bep(((w)localObject2).Tog.backgroundId));
    localObject1 = this.Txl;
    if (localObject1 != null) {
      ((View)localObject1).setBackground((Drawable)new BitmapDrawable(getResources(), paramBundle));
    }
    this.mDataList.addAll((Collection)com.tencent.mm.plugin.textstatus.util.b.hKh().getDataList());
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new d(this), this.mDataList));
    }
    int k = Math.min(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());
    paramBundle = this.yAg;
    if (paramBundle == null)
    {
      i = 0;
      paramBundle = this.yAg;
      if (paramBundle != null) {
        break label636;
      }
    }
    label636:
    for (int j = 0;; j = paramBundle.getPaddingRight())
    {
      float f = getResources().getDimension(a.c.TbF);
      paramBundle = new ah.c();
      paramBundle.aixa = getResources().getDimension(a.c.TbE);
      f = (k - i - j + paramBundle.aixa) / (f + paramBundle.aixa);
      localObject1 = new ah.f();
      ((ah.f)localObject1).aqH = new GridLayoutManager((int)f);
      ((GridLayoutManager)((ah.f)localObject1).aqH).bWq = ((GridLayoutManager.b)new TextStatusDoWhatActivity.f(this, (ah.f)localObject1));
      localObject2 = this.yAg;
      if (localObject2 != null) {
        ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)((ah.f)localObject1).aqH);
      }
      localObject1 = this.yAg;
      if (localObject1 != null) {
        ((RecyclerView)localObject1).a((RecyclerView.h)new TextStatusDoWhatActivity.g(paramBundle));
      }
      paramBundle = hII().getLayoutParams();
      if (paramBundle != null) {
        break label645;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(291854);
      throw paramBundle;
      i = paramBundle.getPaddingLeft();
      break;
    }
    label645:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    int i = bf.getStatusBarHeight((Context)getContext());
    paramBundle.topMargin = (bd.fromDPToPix((Context)getContext(), 6) + i);
    hII().setOnClickListener(new TextStatusDoWhatActivity..ExternalSyntheticLambda1(this));
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgO, 1) == 1) {}
    for (i = 1;; i = 0)
    {
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgX, false);
      if ((i != 0) && (!bool))
      {
        paramBundle = this.Txn;
        if (paramBundle != null) {
          paramBundle.Toj = 1;
        }
        findViewById(a.e.Tcj).setVisibility(0);
        paramBundle = this.yAg;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        hII().setVisibility(8);
        ac.hFX();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgO, Integer.valueOf(0));
        findViewById(a.e.Tci).setOnClickListener(new TextStatusDoWhatActivity..ExternalSyntheticLambda0(this));
      }
      this.Txp.alive();
      AppMethodBeat.o(291854);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291859);
    super.onDestroy();
    this.Txp.dead();
    AppMethodBeat.o(291859);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(291896);
    if (paramBoolean)
    {
      localObject = this.Txs;
      if (localObject == null)
      {
        localObject = null;
        if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
          break label57;
        }
      }
      label57:
      for (localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label94;
        }
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
        AppMethodBeat.o(291896);
        return;
        localObject = ((View)localObject).getLayoutParams();
        break;
      }
    }
    Object localObject = this.Txs;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label109;
      }
    }
    label94:
    label109:
    for (localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
      }
      AppMethodBeat.o(291896);
      return;
      localObject = ((View)localObject).getLayoutParams();
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291864);
    super.onPause();
    AppMethodBeat.o(291864);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setLayoutContent(View paramView)
  {
    this.Txl = paramView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements TextWatcher
  {
    public b()
    {
      AppMethodBeat.i(291199);
      AppMethodBeat.o(291199);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(291213);
      Object localObject = TextStatusDoWhatActivity.c(this.Txw);
      if (localObject != null) {
        ((EditText)localObject).removeTextChangedListener((TextWatcher)TextStatusDoWhatActivity.d(this.Txw));
      }
      int i = com.tencent.mm.ui.tools.g.a(String.valueOf(paramEditable), g.a.afII);
      this.Txw.hIJ();
      Log.i("MicroMsg.TextStatus.TextStatusDoWhatActivity", s.X("afterTextChanged inputCount:", Integer.valueOf(i)));
      localObject = String.valueOf(paramEditable);
      if (i > this.Txw.Txr)
      {
        String str = com.tencent.mm.ui.tools.g.jd((String)localObject, this.Txw.Txr);
        if (paramEditable != null) {
          paramEditable.replace(str.length(), ((String)localObject).length(), (CharSequence)"");
        }
        aa.y((Context)this.Txw, this.Txw.getString(a.h.settings_modify_custom_text_status_invalid_more), a.g.icons_outlined_info);
        localObject = TextStatusDoWhatActivity.e(this.Txw);
        if (localObject != null) {
          ((w)localObject).Tom += 1;
        }
      }
      localObject = TextStatusDoWhatActivity.c(this.Txw);
      if (localObject != null) {
        ((EditText)localObject).addTextChangedListener((TextWatcher)TextStatusDoWhatActivity.d(this.Txw));
      }
      localObject = TextStatusDoWhatActivity.f(this.Txw);
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null)
        {
          if ((paramEditable == null) || (paramEditable.length() != 0)) {
            break label272;
          }
          i = 1;
          label238:
          if (i != 0) {
            break label277;
          }
        }
      }
      label272:
      label277:
      for (boolean bool = true;; bool = false)
      {
        ((Button)localObject).setEnabled(bool);
        AppMethodBeat.o(291213);
        return;
        localObject = (Button)((View)localObject).findViewById(a.e.confirm_btn);
        break;
        i = 0;
        break label238;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(TextStatusDoWhatActivity paramTextStatusDoWhatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.recyclerview.g
  {
    d(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291121);
      switch (paramInt)
      {
      case 0: 
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.c((c.b)TextStatusDoWhatActivity.b(this.Txw));
        AppMethodBeat.o(291121);
        return localf;
      case -1: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.b();
        AppMethodBeat.o(291121);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.a();
      AppMethodBeat.o(291121);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/ResultReceiver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ResultReceiver>
  {
    e(TextStatusDoWhatActivity paramTextStatusDoWhatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements c.b
  {
    h(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final void a(View paramView, com.tencent.mm.plugin.textstatus.h.e.c paramc)
    {
      AppMethodBeat.i(291162);
      s.u(paramView, "v");
      s.u(paramc, "item");
      if (s.p(paramc.iconId, "userdefine"))
      {
        paramView = TextStatusDoWhatActivity.e(this.Txw);
        if (paramView != null) {
          paramView.Tol += 1;
        }
        TextStatusDoWhatActivity.a(this.Txw, paramc);
        AppMethodBeat.o(291162);
        return;
      }
      TextStatusDoWhatActivity.b(this.Txw, paramc);
      AppMethodBeat.o(291162);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity
 * JD-Core Version:    0.7.0.1
 */