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
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends RelativeLayout
  implements g
{
  @Deprecated
  public static final c.a BQl;
  int BQe;
  private RecyclerView BQf;
  b BQg;
  private m<? super Integer, ? super ArrayList<rt>, z> BQh;
  private d.g.a.a<z> BQi;
  private int BQj;
  private final Runnable BQk;
  private int adl;
  com.tencent.mm.ui.tools.h fQT;
  
  static
  {
    AppMethodBeat.i(196513);
    BQl = new c.a((byte)0);
    AppMethodBeat.o(196513);
  }
  
  public c(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196512);
    this.BQg = new b(paramContext);
    this.fQT = new com.tencent.mm.ui.tools.h((Activity)paramContext);
    LayoutInflater.from(paramContext).inflate(2131496445, (ViewGroup)this, true);
    View localView = findViewById(2131307291);
    p.g(localView, "findViewById(R.id.caption_list)");
    this.BQf = ((RecyclerView)localView);
    findViewById(2131307288).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196496);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BQm.getCancelClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196496);
      }
    });
    findViewById(2131307293).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196497);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BQm.getSureClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.p(Integer.valueOf(c.a(this.BQm)), c.b(this.BQm).BQn);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196497);
      }
    });
    this.BQf.setLayoutManager((RecyclerView.i)new EditorCaptionLayoutManager(paramContext));
    this.BQf.setAdapter((RecyclerView.a)this.BQg);
    this.fQT.setKeyboardHeightObserver((g)this);
    this.BQk = ((Runnable)new c(this, paramContext));
    AppMethodBeat.o(196512);
  }
  
  private final void Bt(long paramLong)
  {
    AppMethodBeat.i(196510);
    com.tencent.e.h.LTJ.q(this.BQk, paramLong);
    AppMethodBeat.o(196510);
  }
  
  private final int Bu(long paramLong)
  {
    AppMethodBeat.i(196511);
    Object localObject1 = (Iterable)this.BQg.BQn;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      if (((rt)localObject2).FNR == paramLong)
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
    AppMethodBeat.o(196511);
    return i;
  }
  
  public final void a(rt paramrt)
  {
    AppMethodBeat.i(196509);
    p.h(paramrt, "transResult");
    this.BQj = 0;
    int i = Bu(paramrt.FNR);
    ad.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + paramrt.FNR + ' ' + this.adl);
    paramrt = this.BQf.getLayoutManager();
    if (paramrt != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramrt, locala.ahp(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
      paramrt.ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramrt, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    Bt(0L);
    AppMethodBeat.o(196509);
  }
  
  public final void etJ()
  {
    AppMethodBeat.i(196507);
    this.BQg.BQn.clear();
    AppMethodBeat.o(196507);
  }
  
  public final void gG(List<? extends rt> paramList)
  {
    AppMethodBeat.i(196508);
    p.h(paramList, "items");
    this.BQg.BQn.addAll((Collection)paramList);
    AppMethodBeat.o(196508);
  }
  
  public final d.g.a.a<z> getCancelClickListener()
  {
    return this.BQi;
  }
  
  public final m<Integer, ArrayList<rt>, z> getSureClickListener()
  {
    return this.BQh;
  }
  
  public final void setCancelClickListener(d.g.a.a<z> parama)
  {
    this.BQi = parama;
  }
  
  public final void setSureClickListener(m<? super Integer, ? super ArrayList<rt>, z> paramm)
  {
    this.BQh = paramm;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196506);
    ad.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (getVisibility() == 0)
    {
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(196506);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt;
      setLayoutParams(getLayoutParams());
    }
    AppMethodBeat.o(196506);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "listener", "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<rt> BQn;
    private final a BQo;
    private Context context;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(196504);
      this.context = paramContext;
      this.BQn = new ArrayList();
      this.BQo = new a(this);
      AppMethodBeat.o(196504);
    }
    
    private static String b(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(196503);
      if (paramb == null)
      {
        AppMethodBeat.o(196503);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(196503);
      return paramb;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196500);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496444, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(196500);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(196500);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(196502);
      p.h(paramw, "viewHolder");
      paramw = paramw.auu;
      p.g(paramw, "viewHolder.itemView");
      Object localObject = this.BQn.get(paramInt);
      p.g(localObject, "captionItems[position]");
      localObject = (rt)localObject;
      if ((((rt)localObject).FNT) || (TextUtils.isEmpty((CharSequence)b(((rt)localObject).FNQ))))
      {
        paramw.setVisibility(4);
        AppMethodBeat.o(196502);
        return;
      }
      paramw.setVisibility(0);
      paramw = (MMEditText)paramw.findViewById(2131307289);
      paramw.setOnFocusChangeListener((View.OnFocusChangeListener)new b(this, paramInt, paramw));
      paramw.setText((CharSequence)b(((rt)this.BQn.get(paramInt)).FNQ));
      AppMethodBeat.o(196502);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(196501);
      int i = this.BQn.size();
      AppMethodBeat.o(196501);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"})
    public static final class a
      implements TextWatcher
    {
      int position;
      
      public final void afterTextChanged(Editable paramEditable)
      {
        AppMethodBeat.i(196498);
        if (paramEditable != null)
        {
          rt localrt = (rt)this.BQp.BQn.get(this.position);
          paramEditable = paramEditable.toString();
          Charset localCharset = d.UTF_8;
          if (paramEditable == null)
          {
            paramEditable = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(196498);
            throw paramEditable;
          }
          paramEditable = paramEditable.getBytes(localCharset);
          p.g(paramEditable, "(this as java.lang.String).getBytes(charset)");
          localrt.FNQ = new com.tencent.mm.bx.b(paramEditable);
        }
        AppMethodBeat.o(196498);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    static final class b
      implements View.OnFocusChangeListener
    {
      b(c.b paramb, int paramInt, MMEditText paramMMEditText) {}
      
      public final void onFocusChange(View paramView, boolean paramBoolean)
      {
        AppMethodBeat.i(196499);
        if (paramBoolean)
        {
          c.b.a(this.BQp).position = paramInt;
          paramw.addTextChangedListener((TextWatcher)c.b.a(this.BQp));
          AppMethodBeat.o(196499);
          return;
        }
        paramw.removeTextChangedListener((TextWatcher)c.b.a(this.BQp));
        AppMethodBeat.o(196499);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class c
      extends RecyclerView.w
    {
      c(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(196505);
      Object localObject1 = c.c(this.BQm).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(196505);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((LinearLayoutManager)localObject1).bY(c.d(this.BQm));
      if (localObject1 != null) {}
      for (localObject1 = (MMEditText)((View)localObject1).findViewById(2131307289);; localObject1 = null)
      {
        if (localObject1 != null) {
          ((MMEditText)localObject1).requestFocus();
        }
        if (localObject1 != null) {
          ((MMEditText)localObject1).setSelection(((MMEditText)localObject1).getText().length());
        }
        Object localObject2 = this.BQm;
        c.a((c)localObject2, c.e((c)localObject2) + 1);
        c.etK();
        ad.i("MicroMsg.EditorEditCaptionView", "repeat " + c.e(this.BQm));
        localObject2 = (InputMethodManager)paramContext.getSystemService("input_method");
        if ((localObject2 != null) && (!((InputMethodManager)localObject2).showSoftInput((View)localObject1, 0)) && (c.e(this.BQm) < 5)) {
          c.f(this.BQm);
        }
        AppMethodBeat.o(196505);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */