package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroidx/recyclerview/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hasInit", "", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends LinearLayout
  implements com.tencent.mm.ui.tools.h
{
  @Deprecated
  public static final a NxW;
  int NxP;
  RecyclerView NxQ;
  b NxR;
  m<? super Integer, ? super ArrayList<ta>, x> NxS;
  private kotlin.g.a.a<x> NxT;
  int NxU;
  private final Runnable NxV;
  int agM;
  com.tencent.mm.ui.tools.i jij;
  
  static
  {
    AppMethodBeat.i(243271);
    NxW = new a((byte)0);
    AppMethodBeat.o(243271);
  }
  
  public c(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(243270);
    this.NxR = new b(paramContext);
    this.jij = new com.tencent.mm.ui.tools.i((Activity)paramContext);
    LayoutInflater.from(paramContext).inflate(b.f.editor_edit_caption_view, (ViewGroup)this, true);
    setBackgroundResource(b.d.bg_black_corner);
    setOrientation(1);
    View localView = findViewById(b.e.caption_list);
    p.j(localView, "findViewById(R.id.caption_list)");
    this.NxQ = ((RecyclerView)localView);
    findViewById(b.e.caption_cancel).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(228024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NxX.getCancelClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228024);
      }
    });
    findViewById(b.e.caption_sure).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NxX.getSureClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(c.a(this.NxX)), c.b(this.NxX).NxY);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230687);
      }
    });
    this.NxQ.setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
    this.NxQ.setAdapter((RecyclerView.a)this.NxR);
    this.jij.setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)this);
    this.NxV = ((Runnable)new c(this, paramContext));
    AppMethodBeat.o(243270);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(243267);
    Log.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (getVisibility() == 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = paramInt;
        setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        AppMethodBeat.o(243267);
        return;
      }
    }
    AppMethodBeat.o(243267);
  }
  
  final void SA(long paramLong)
  {
    AppMethodBeat.i(243269);
    com.tencent.e.h.ZvG.n(this.NxV, paramLong);
    AppMethodBeat.o(243269);
  }
  
  public final kotlin.g.a.a<x> getCancelClickListener()
  {
    return this.NxT;
  }
  
  public final m<Integer, ArrayList<ta>, x> getSureClickListener()
  {
    return this.NxS;
  }
  
  public final void setCancelClickListener(kotlin.g.a.a<x> parama)
  {
    this.NxT = parama;
  }
  
  public final void setSureClickListener(m<? super Integer, ? super ArrayList<ta>, x> paramm)
  {
    this.NxS = paramm;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "listener", "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<ta> NxY;
    private final a NxZ;
    private Context context;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(243242);
      this.context = paramContext;
      this.NxY = new ArrayList();
      this.NxZ = new a(this);
      AppMethodBeat.o(243242);
    }
    
    private static String e(com.tencent.mm.cd.b paramb)
    {
      AppMethodBeat.i(243240);
      if (paramb == null)
      {
        AppMethodBeat.o(243240);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.j(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(243240);
      return paramb;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(243235);
      p.k(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.f.editor_edit_caption_item, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(243235);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(243235);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(243238);
      p.k(paramv, "viewHolder");
      paramv = paramv.amk;
      p.j(paramv, "viewHolder.itemView");
      Object localObject = this.NxY.get(paramInt);
      p.j(localObject, "captionItems[position]");
      localObject = (ta)localObject;
      if ((((ta)localObject).Sch) || (TextUtils.isEmpty((CharSequence)e(((ta)localObject).Sce))))
      {
        paramv.setVisibility(4);
        AppMethodBeat.o(243238);
        return;
      }
      paramv.setVisibility(0);
      paramv = (MMEditText)paramv.findViewById(b.e.caption_content);
      paramv.setOnFocusChangeListener((View.OnFocusChangeListener)new b(this, paramInt, paramv));
      paramv.setText((CharSequence)e(((ta)this.NxY.get(paramInt)).Sce));
      AppMethodBeat.o(243238);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(243237);
      int i = this.NxY.size();
      AppMethodBeat.o(243237);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"})
    public static final class a
      implements TextWatcher
    {
      int position;
      
      public final void afterTextChanged(Editable paramEditable)
      {
        AppMethodBeat.i(227594);
        if (paramEditable != null)
        {
          ta localta = (ta)this.Nya.NxY.get(this.position);
          paramEditable = paramEditable.toString();
          Charset localCharset = d.UTF_8;
          if (paramEditable == null)
          {
            paramEditable = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(227594);
            throw paramEditable;
          }
          paramEditable = paramEditable.getBytes(localCharset);
          p.j(paramEditable, "(this as java.lang.String).getBytes(charset)");
          localta.Sce = new com.tencent.mm.cd.b(paramEditable);
        }
        AppMethodBeat.o(227594);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    static final class b
      implements View.OnFocusChangeListener
    {
      b(c.b paramb, int paramInt, MMEditText paramMMEditText) {}
      
      public final void onFocusChange(View paramView, boolean paramBoolean)
      {
        AppMethodBeat.i(224975);
        if (paramBoolean)
        {
          c.b.a(this.Nya).position = paramInt;
          paramv.addTextChangedListener((TextWatcher)c.b.a(this.Nya));
          AppMethodBeat.o(224975);
          return;
        }
        paramv.removeTextChangedListener((TextWatcher)c.b.a(this.Nya));
        AppMethodBeat.o(224975);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class c
      extends RecyclerView.v
    {
      c(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(241135);
      Object localObject1 = c.c(this.NxX).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(241135);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((LinearLayoutManager)localObject1).findViewByPosition(c.d(this.NxX));
      if (localObject1 != null) {}
      for (localObject1 = (MMEditText)((View)localObject1).findViewById(b.e.caption_content);; localObject1 = null)
      {
        if (localObject1 != null) {
          ((MMEditText)localObject1).requestFocus();
        }
        if (localObject1 != null) {
          ((MMEditText)localObject1).setSelection(((MMEditText)localObject1).getText().length());
        }
        Object localObject2 = this.NxX;
        c.a((c)localObject2, c.e((c)localObject2) + 1);
        c.gvW();
        Log.i("MicroMsg.EditorEditCaptionView", "repeat " + c.e(this.NxX));
        localObject2 = (InputMethodManager)paramContext.getSystemService("input_method");
        if ((localObject2 != null) && (!((InputMethodManager)localObject2).showSoftInput((View)localObject1, 0)) && (c.e(this.NxX) < 5)) {
          c.f(this.NxX);
        }
        AppMethodBeat.o(241135);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */