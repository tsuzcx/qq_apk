package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import d.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends RelativeLayout
  implements g
{
  @Deprecated
  public static final c.a ChK;
  int ChD;
  private RecyclerView ChE;
  b ChF;
  private m<? super Integer, ? super ArrayList<rv>, z> ChG;
  private d.g.a.a<z> ChH;
  private int ChI;
  private final Runnable ChJ;
  private int adl;
  com.tencent.mm.ui.tools.h fSZ;
  
  static
  {
    AppMethodBeat.i(191972);
    ChK = new c.a((byte)0);
    AppMethodBeat.o(191972);
  }
  
  public c(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191971);
    this.ChF = new b(paramContext);
    this.fSZ = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    LayoutInflater.from(paramContext).inflate(2131496445, (ViewGroup)this, true);
    View localView = findViewById(2131307291);
    p.g(localView, "findViewById(R.id.caption_list)");
    this.ChE = ((RecyclerView)localView);
    findViewById(2131307288).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191955);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.ChL.getCancelClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191955);
      }
    });
    findViewById(2131307293).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191956);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.ChL.getSureClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.p(Integer.valueOf(c.a(this.ChL)), c.b(this.ChL).ChM);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191956);
      }
    });
    this.ChE.setLayoutManager((RecyclerView.i)new EditorCaptionLayoutManager(paramContext));
    this.ChE.setAdapter((RecyclerView.a)this.ChF);
    this.fSZ.setKeyboardHeightObserver((g)this);
    this.ChJ = ((Runnable)new c(this, paramContext));
    AppMethodBeat.o(191971);
  }
  
  private final void BR(long paramLong)
  {
    AppMethodBeat.i(191969);
    com.tencent.e.h.MqF.q(this.ChJ, paramLong);
    AppMethodBeat.o(191969);
  }
  
  private final int BS(long paramLong)
  {
    AppMethodBeat.i(191970);
    Object localObject1 = (Iterable)this.ChF.ChM;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      if (((rv)localObject2).Ggq == paramLong)
      {
        this.adl = i;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    i = this.adl;
    AppMethodBeat.o(191970);
    return i;
  }
  
  public final void a(rv paramrv)
  {
    AppMethodBeat.i(191968);
    p.h(paramrv, "transResult");
    this.ChI = 0;
    int i = BS(paramrv.Ggq);
    ae.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + paramrv.Ggq + ' ' + this.adl);
    paramrv = this.ChE.getLayoutManager();
    if (paramrv != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramrv, locala.ahE(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
      paramrv.ca(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramrv, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    BR(0L);
    AppMethodBeat.o(191968);
  }
  
  public final void exq()
  {
    AppMethodBeat.i(191966);
    this.ChF.ChM.clear();
    AppMethodBeat.o(191966);
  }
  
  public final void gP(List<? extends rv> paramList)
  {
    AppMethodBeat.i(191967);
    p.h(paramList, "items");
    this.ChF.ChM.addAll((Collection)paramList);
    AppMethodBeat.o(191967);
  }
  
  public final d.g.a.a<z> getCancelClickListener()
  {
    return this.ChH;
  }
  
  public final m<Integer, ArrayList<rv>, z> getSureClickListener()
  {
    return this.ChG;
  }
  
  public final void setCancelClickListener(d.g.a.a<z> parama)
  {
    this.ChH = parama;
  }
  
  public final void setSureClickListener(m<? super Integer, ? super ArrayList<rv>, z> paramm)
  {
    this.ChG = paramm;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(191965);
    ae.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (getVisibility() == 0)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(191965);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt;
      setLayoutParams(getLayoutParams());
    }
    AppMethodBeat.o(191965);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "listener", "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<rv> ChM;
    private final a ChN;
    private Context context;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(191963);
      this.context = paramContext;
      this.ChM = new ArrayList();
      this.ChN = new a(this);
      AppMethodBeat.o(191963);
    }
    
    private static String b(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(191962);
      if (paramb == null)
      {
        AppMethodBeat.o(191962);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(191962);
      return paramb;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(191959);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496444, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191959);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(191959);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(191961);
      p.h(paramw, "viewHolder");
      paramw = paramw.auu;
      p.g(paramw, "viewHolder.itemView");
      Object localObject = this.ChM.get(paramInt);
      p.g(localObject, "captionItems[position]");
      localObject = (rv)localObject;
      if ((((rv)localObject).Ggs) || (TextUtils.isEmpty((CharSequence)b(((rv)localObject).Ggp))))
      {
        paramw.setVisibility(4);
        AppMethodBeat.o(191961);
        return;
      }
      paramw.setVisibility(0);
      paramw = (MMEditText)paramw.findViewById(2131307289);
      paramw.setOnFocusChangeListener((View.OnFocusChangeListener)new b(this, paramInt, paramw));
      paramw.setText((CharSequence)b(((rv)this.ChM.get(paramInt)).Ggp));
      AppMethodBeat.o(191961);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(191960);
      int i = this.ChM.size();
      AppMethodBeat.o(191960);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"})
    public static final class a
      implements TextWatcher
    {
      int position;
      
      public final void afterTextChanged(Editable paramEditable)
      {
        AppMethodBeat.i(191957);
        if (paramEditable != null)
        {
          rv localrv = (rv)this.ChO.ChM.get(this.position);
          paramEditable = paramEditable.toString();
          Charset localCharset = d.UTF_8;
          if (paramEditable == null)
          {
            paramEditable = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(191957);
            throw paramEditable;
          }
          paramEditable = paramEditable.getBytes(localCharset);
          p.g(paramEditable, "(this as java.lang.String).getBytes(charset)");
          localrv.Ggp = new com.tencent.mm.bw.b(paramEditable);
        }
        AppMethodBeat.o(191957);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    static final class b
      implements View.OnFocusChangeListener
    {
      b(c.b paramb, int paramInt, MMEditText paramMMEditText) {}
      
      public final void onFocusChange(View paramView, boolean paramBoolean)
      {
        AppMethodBeat.i(191958);
        if (paramBoolean)
        {
          c.b.a(this.ChO).position = paramInt;
          paramw.addTextChangedListener((TextWatcher)c.b.a(this.ChO));
          AppMethodBeat.o(191958);
          return;
        }
        paramw.removeTextChangedListener((TextWatcher)c.b.a(this.ChO));
        AppMethodBeat.o(191958);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class c
      extends RecyclerView.w
    {
      c(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(191964);
      Object localObject1 = c.c(this.ChL).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(191964);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((LinearLayoutManager)localObject1).bY(c.d(this.ChL));
      if (localObject1 != null) {}
      for (localObject1 = (MMEditText)((View)localObject1).findViewById(2131307289);; localObject1 = null)
      {
        if (localObject1 != null) {
          ((MMEditText)localObject1).requestFocus();
        }
        if (localObject1 != null) {
          ((MMEditText)localObject1).setSelection(((MMEditText)localObject1).getText().length());
        }
        Object localObject2 = this.ChL;
        c.a((c)localObject2, c.e((c)localObject2) + 1);
        c.exr();
        ae.i("MicroMsg.EditorEditCaptionView", "repeat " + c.e(this.ChL));
        localObject2 = (InputMethodManager)paramContext.getSystemService("input_method");
        if ((localObject2 != null) && (!((InputMethodManager)localObject2).showSoftInput((View)localObject1, 0)) && (c.e(this.ChL) < 5)) {
          c.f(this.ChL);
        }
        AppMethodBeat.o(191964);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */