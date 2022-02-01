package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroidx/recyclerview/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hasInit", "", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends LinearLayout
  implements com.tencent.mm.ui.tools.h
{
  private static final c.a UkQ;
  int UkR;
  RecyclerView UkS;
  b UkT;
  m<? super Integer, ? super ArrayList<uq>, ah> UkU;
  private kotlin.g.a.a<ah> UkV;
  int UkW;
  private final Runnable UkX;
  int bVs;
  com.tencent.mm.ui.tools.i lKz;
  
  static
  {
    AppMethodBeat.i(283283);
    UkQ = new c.a((byte)0);
    AppMethodBeat.o(283283);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(283250);
    this.UkT = new b(paramContext);
    this.lKz = new com.tencent.mm.ui.tools.i((Activity)paramContext);
    LayoutInflater.from(paramContext).inflate(b.f.editor_edit_caption_view, (ViewGroup)this, true);
    setBackgroundResource(b.d.bg_black_corner);
    setOrientation(1);
    View localView = findViewById(b.e.caption_list);
    s.s(localView, "findViewById(R.id.caption_list)");
    this.UkS = ((RecyclerView)localView);
    findViewById(b.e.caption_cancel).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    findViewById(b.e.caption_sure).setOnClickListener(new c..ExternalSyntheticLambda1(this));
    this.UkS.setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
    this.UkS.setAdapter((RecyclerView.a)this.UkT);
    this.lKz.afIL = ((com.tencent.mm.ui.tools.h)this);
    this.UkX = new c..ExternalSyntheticLambda2(this, paramContext);
    AppMethodBeat.o(283250);
  }
  
  private static final void a(c paramc, Context paramContext)
  {
    AppMethodBeat.i(283277);
    s.u(paramc, "this$0");
    s.u(paramContext, "$context");
    Object localObject = paramc.UkS.getLayoutManager();
    if (localObject == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(283277);
      throw paramc;
    }
    localObject = ((LinearLayoutManager)localObject).findViewByPosition(paramc.bVs);
    if (localObject == null) {}
    for (localObject = null;; localObject = (MMEditText)((View)localObject).findViewById(b.e.caption_content))
    {
      if (localObject != null) {
        ((MMEditText)localObject).requestFocus();
      }
      if (localObject != null) {
        ((MMEditText)localObject).setSelection(((MMEditText)localObject).getText().length());
      }
      paramc.UkW += 1;
      Log.i("MicroMsg.EditorEditCaptionView", s.X("repeat ", Integer.valueOf(paramc.UkW)));
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      if ((paramContext != null) && (!paramContext.showSoftInput((View)localObject, 0)) && (paramc.UkW < 5)) {
        paramc.wO(50L);
      }
      AppMethodBeat.o(283277);
      return;
    }
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(283262);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.getCancelClickListener();
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283262);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(283266);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramView = paramc.getSureClickListener();
    if (paramView != null) {
      paramView.invoke(Integer.valueOf(paramc.UkR), paramc.UkT.UkY);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283266);
  }
  
  public final kotlin.g.a.a<ah> getCancelClickListener()
  {
    return this.UkV;
  }
  
  public final m<Integer, ArrayList<uq>, ah> getSureClickListener()
  {
    return this.UkU;
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(283343);
    Log.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (getVisibility() == 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = paramInt;
        setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
    }
    AppMethodBeat.o(283343);
  }
  
  public final void setCancelClickListener(kotlin.g.a.a<ah> parama)
  {
    this.UkV = parama;
  }
  
  public final void setSureClickListener(m<? super Integer, ? super ArrayList<uq>, ah> paramm)
  {
    this.UkU = paramm;
  }
  
  final void wO(long paramLong)
  {
    AppMethodBeat.i(283350);
    com.tencent.threadpool.h.ahAA.o(this.UkX, paramLong);
    AppMethodBeat.o(283350);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "listener", "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<uq> UkY;
    private final a UkZ;
    private Context context;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(283140);
      this.context = paramContext;
      this.UkY = new ArrayList();
      this.UkZ = new a(this);
      AppMethodBeat.o(283140);
    }
    
    private static final void a(b paramb, int paramInt, MMEditText paramMMEditText, View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(283154);
      s.u(paramb, "this$0");
      if (paramBoolean)
      {
        paramb.UkZ.position = paramInt;
        paramMMEditText.addTextChangedListener((TextWatcher)paramb.UkZ);
        AppMethodBeat.o(283154);
        return;
      }
      paramMMEditText.removeTextChangedListener((TextWatcher)paramb.UkZ);
      AppMethodBeat.o(283154);
    }
    
    private static String j(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(283148);
      if (paramb == null)
      {
        AppMethodBeat.o(283148);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      s.s(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(283148);
      return paramb;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(283169);
      s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.f.editor_edit_caption_item, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(283169);
        throw paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new b((ViewGroup)paramViewGroup);
      AppMethodBeat.o(283169);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(283187);
      s.u(paramv, "viewHolder");
      paramv = paramv.caK;
      s.s(paramv, "viewHolder.itemView");
      Object localObject = this.UkY.get(paramInt);
      s.s(localObject, "captionItems[position]");
      localObject = (uq)localObject;
      if ((((uq)localObject).YZZ) || (TextUtils.isEmpty((CharSequence)j(((uq)localObject).YZW))))
      {
        paramv.setVisibility(4);
        AppMethodBeat.o(283187);
        return;
      }
      paramv.setVisibility(0);
      paramv = (MMEditText)paramv.findViewById(b.e.caption_content);
      paramv.setOnFocusChangeListener(new c.b..ExternalSyntheticLambda0(this, paramInt, paramv));
      paramv.setText((CharSequence)j(((uq)this.UkY.get(paramInt)).YZW));
      AppMethodBeat.o(283187);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(283176);
      int i = this.UkY.size();
      AppMethodBeat.o(283176);
      return i;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements TextWatcher
    {
      int position;
      
      a(c.b paramb) {}
      
      public final void afterTextChanged(Editable paramEditable)
      {
        AppMethodBeat.i(283118);
        if (paramEditable != null)
        {
          uq localuq = (uq)this.Ula.UkY.get(this.position);
          paramEditable = paramEditable.toString();
          Charset localCharset = d.UTF_8;
          if (paramEditable == null)
          {
            paramEditable = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(283118);
            throw paramEditable;
          }
          paramEditable = paramEditable.getBytes(localCharset);
          s.s(paramEditable, "(this as java.lang.String).getBytes(charset)");
          localuq.YZW = new com.tencent.mm.bx.b(paramEditable);
        }
        AppMethodBeat.o(283118);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends RecyclerView.v
    {
      b(ViewGroup paramViewGroup)
      {
        super();
        AppMethodBeat.i(283183);
        AppMethodBeat.o(283183);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */