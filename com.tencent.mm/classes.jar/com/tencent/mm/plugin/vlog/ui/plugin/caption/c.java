package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import android.widget.LinearLayout;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends LinearLayout
  implements g
{
  @Deprecated
  public static final c.a GKw;
  int GKp;
  private RecyclerView GKq;
  b GKr;
  private m<? super Integer, ? super ArrayList<sy>, x> GKs;
  private kotlin.g.a.a<x> GKt;
  private int GKu;
  private final Runnable GKv;
  private int ady;
  com.tencent.mm.ui.tools.h gyh;
  
  static
  {
    AppMethodBeat.i(191661);
    GKw = new c.a((byte)0);
    AppMethodBeat.o(191661);
  }
  
  public c(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191660);
    this.GKr = new b(paramContext);
    this.gyh = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    LayoutInflater.from(paramContext).inflate(2131493879, (ViewGroup)this, true);
    setBackgroundResource(2131231174);
    setOrientation(1);
    View localView = findViewById(2131297981);
    p.g(localView, "findViewById(R.id.caption_list)");
    this.GKq = ((RecyclerView)localView);
    findViewById(2131297974).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GKx.getCancelClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191644);
      }
    });
    findViewById(2131297989).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191645);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GKx.getSureClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(c.a(this.GKx)), c.b(this.GKx).GKy);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191645);
      }
    });
    this.GKq.setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
    this.GKq.setAdapter((RecyclerView.a)this.GKr);
    this.gyh.setKeyboardHeightObserver((g)this);
    this.GKv = ((Runnable)new c(this, paramContext));
    AppMethodBeat.o(191660);
  }
  
  private final void Le(long paramLong)
  {
    AppMethodBeat.i(191658);
    com.tencent.f.h.RTc.n(this.GKv, paramLong);
    AppMethodBeat.o(191658);
  }
  
  private final int Lf(long paramLong)
  {
    AppMethodBeat.i(191659);
    Object localObject1 = (Iterable)this.GKr.GKy;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      if (((sy)localObject2).LaT == paramLong)
      {
        this.ady = i;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    i = this.ady;
    AppMethodBeat.o(191659);
    return i;
  }
  
  public final void a(sy paramsy)
  {
    AppMethodBeat.i(191657);
    p.h(paramsy, "transResult");
    this.GKu = 0;
    int i = Lf(paramsy.LaT);
    Log.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + paramsy.LaT + ' ' + this.ady);
    paramsy = this.GKq.getLayoutManager();
    if (paramsy != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramsy, locala.axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
      paramsy.scrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramsy, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    Le(0L);
    AppMethodBeat.o(191657);
  }
  
  public final void fDV()
  {
    AppMethodBeat.i(191655);
    this.GKr.GKy.clear();
    AppMethodBeat.o(191655);
  }
  
  public final kotlin.g.a.a<x> getCancelClickListener()
  {
    return this.GKt;
  }
  
  public final m<Integer, ArrayList<sy>, x> getSureClickListener()
  {
    return this.GKs;
  }
  
  public final void hU(List<? extends sy> paramList)
  {
    AppMethodBeat.i(191656);
    p.h(paramList, "items");
    this.GKr.GKy.addAll((Collection)paramList);
    AppMethodBeat.o(191656);
  }
  
  public final void setCancelClickListener(kotlin.g.a.a<x> parama)
  {
    this.GKt = parama;
  }
  
  public final void setSureClickListener(m<? super Integer, ? super ArrayList<sy>, x> paramm)
  {
    this.GKs = paramm;
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(191654);
    Log.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (getVisibility() == 0)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(191654);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt;
      setLayoutParams(getLayoutParams());
    }
    AppMethodBeat.o(191654);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "listener", "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<sy> GKy;
    private final a GKz;
    private Context context;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(191652);
      this.context = paramContext;
      this.GKy = new ArrayList();
      this.GKz = new a(this);
      AppMethodBeat.o(191652);
    }
    
    private static String d(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(191651);
      if (paramb == null)
      {
        AppMethodBeat.o(191651);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(191651);
      return paramb;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(191648);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131493878, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191648);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(191648);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(191650);
      p.h(paramv, "viewHolder");
      paramv = paramv.aus;
      p.g(paramv, "viewHolder.itemView");
      Object localObject = this.GKy.get(paramInt);
      p.g(localObject, "captionItems[position]");
      localObject = (sy)localObject;
      if ((((sy)localObject).LaV) || (TextUtils.isEmpty((CharSequence)d(((sy)localObject).LaS))))
      {
        paramv.setVisibility(4);
        AppMethodBeat.o(191650);
        return;
      }
      paramv.setVisibility(0);
      paramv = (MMEditText)paramv.findViewById(2131297976);
      paramv.setOnFocusChangeListener((View.OnFocusChangeListener)new b(this, paramInt, paramv));
      paramv.setText((CharSequence)d(((sy)this.GKy.get(paramInt)).LaS));
      AppMethodBeat.o(191650);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(191649);
      int i = this.GKy.size();
      AppMethodBeat.o(191649);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"})
    public static final class a
      implements TextWatcher
    {
      int position;
      
      public final void afterTextChanged(Editable paramEditable)
      {
        AppMethodBeat.i(191646);
        if (paramEditable != null)
        {
          sy localsy = (sy)this.GKA.GKy.get(this.position);
          paramEditable = paramEditable.toString();
          Charset localCharset = d.UTF_8;
          if (paramEditable == null)
          {
            paramEditable = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(191646);
            throw paramEditable;
          }
          paramEditable = paramEditable.getBytes(localCharset);
          p.g(paramEditable, "(this as java.lang.String).getBytes(charset)");
          localsy.LaS = new com.tencent.mm.bw.b(paramEditable);
        }
        AppMethodBeat.o(191646);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    static final class b
      implements View.OnFocusChangeListener
    {
      b(c.b paramb, int paramInt, MMEditText paramMMEditText) {}
      
      public final void onFocusChange(View paramView, boolean paramBoolean)
      {
        AppMethodBeat.i(191647);
        if (paramBoolean)
        {
          c.b.a(this.GKA).position = paramInt;
          paramv.addTextChangedListener((TextWatcher)c.b.a(this.GKA));
          AppMethodBeat.o(191647);
          return;
        }
        paramv.removeTextChangedListener((TextWatcher)c.b.a(this.GKA));
        AppMethodBeat.o(191647);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class c
      extends RecyclerView.v
    {
      c(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(191653);
      Object localObject1 = c.c(this.GKx).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(191653);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((LinearLayoutManager)localObject1).findViewByPosition(c.d(this.GKx));
      if (localObject1 != null) {}
      for (localObject1 = (MMEditText)((View)localObject1).findViewById(2131297976);; localObject1 = null)
      {
        if (localObject1 != null) {
          ((MMEditText)localObject1).requestFocus();
        }
        if (localObject1 != null) {
          ((MMEditText)localObject1).setSelection(((MMEditText)localObject1).getText().length());
        }
        Object localObject2 = this.GKx;
        c.a((c)localObject2, c.e((c)localObject2) + 1);
        c.fDW();
        Log.i("MicroMsg.EditorEditCaptionView", "repeat " + c.e(this.GKx));
        localObject2 = (InputMethodManager)paramContext.getSystemService("input_method");
        if ((localObject2 != null) && (!((InputMethodManager)localObject2).showSoftInput((View)localObject1, 0)) && (c.e(this.GKx) < 5)) {
          c.f(this.GKx);
        }
        AppMethodBeat.o(191653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */