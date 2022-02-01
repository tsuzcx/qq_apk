package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionCheckBox", "Landroid/widget/CheckBox;", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "", "onTouchingView", "", "videoPauseListener", "Lkotlin/Function0;", "", "getVideoPauseListener", "()Lkotlin/jvm/functions/Function0;", "setVideoPauseListener", "(Lkotlin/jvm/functions/Function0;)V", "videoSeekListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "timestampMs", "getVideoSeekListener", "()Lkotlin/jvm/functions/Function1;", "setVideoSeekListener", "(Lkotlin/jvm/functions/Function1;)V", "buildTestData", "ifCenter", "view", "Landroid/view/View;", "onClick", "v", "scrollToTimeMs", "timeStampMs", "time2Pos", "CaptionItemData", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends LinearLayout
  implements View.OnClickListener
{
  @Deprecated
  public static final b LuR;
  private RecyclerView LuM;
  private CheckBox LuN;
  private d.g.a.a<y> LuO;
  private d.g.a.b<? super Long, y> LuP;
  private boolean LuQ;
  private int aay;
  
  static
  {
    AppMethodBeat.i(201204);
    LuR = new b((byte)0);
    AppMethodBeat.o(201204);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(201203);
    if (LayoutInflater.from(paramContext).inflate(2131496168, (ViewGroup)this, true) == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    findViewById(2131307269).setOnClickListener((View.OnClickListener)this);
    findViewById(2131307274).setOnClickListener((View.OnClickListener)this);
    View localView = findViewById(2131307272);
    k.g(localView, "findViewById(R.id.caption_list)");
    this.LuM = ((RecyclerView)localView);
    localView = findViewById(2131307273);
    k.g(localView, "findViewById(R.id.caption_select)");
    this.LuN = ((CheckBox)localView);
    this.LuM.setLayoutManager((RecyclerView.i)new EditorCaptionLayoutManager(paramContext));
    this.LuM.setAdapter((RecyclerView.a)new c(paramContext));
    this.LuM.a((RecyclerView.m)new RecyclerView.m()
    {
      private int LuS = -1;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201192);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (!c.a(this.LuT))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(201192);
          return;
        }
        paramAnonymousInt2 = c.c(this.LuT);
        paramAnonymousRecyclerView = c.b(this.LuT).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(201192);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView;
        int i = (paramAnonymousRecyclerView.jO() + paramAnonymousRecyclerView.jQ()) / 2;
        if (i == this.LuS)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(201192);
          return;
        }
        this.LuS = i;
        paramAnonymousInt1 = i - 1;
        i += 1;
        if (paramAnonymousInt1 <= i) {}
        for (;;)
        {
          if (c.a(this.LuT, paramAnonymousRecyclerView.bY(paramAnonymousInt1)))
          {
            c.a(this.LuT, paramAnonymousInt1);
            localObject = c.b(this.LuT).getAdapter();
            if (localObject == null)
            {
              paramAnonymousRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
              AppMethodBeat.o(201192);
              throw paramAnonymousRecyclerView;
            }
            ((c.c)localObject).aay = c.c(this.LuT);
            localObject = paramAnonymousRecyclerView.bY(paramAnonymousInt2);
            if (localObject != null)
            {
              c.fZq();
              ((View)localObject).setAlpha(0.5F);
            }
            paramAnonymousRecyclerView = paramAnonymousRecyclerView.bY(c.c(this.LuT));
            if (paramAnonymousRecyclerView != null) {
              paramAnonymousRecyclerView.setAlpha(1.0F);
            }
            c.fZq();
            ad.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + c.c(this.LuT) + ' ' + paramAnonymousInt2);
          }
          while (paramAnonymousInt1 == i)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(201192);
            return;
          }
          paramAnonymousInt1 += 1;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(201191);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(201191);
          return;
          c.fZq();
          ad.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          c.a(this.LuT, true);
          paramAnonymousRecyclerView = this.LuT.getVideoPauseListener();
          if (paramAnonymousRecyclerView != null)
          {
            paramAnonymousRecyclerView.invoke();
            continue;
            c.fZq();
            ad.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_IDLE");
            if (c.a(this.LuT))
            {
              paramAnonymousRecyclerView = c.b(this.LuT).getAdapter();
              if (paramAnonymousRecyclerView == null)
              {
                paramAnonymousRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
                AppMethodBeat.o(201191);
                throw paramAnonymousRecyclerView;
              }
              long l = ((c.a)((c.c)paramAnonymousRecyclerView).LuU.get(c.c(this.LuT))).bxw;
              paramAnonymousRecyclerView = this.LuT.getVideoSeekListener();
              if (paramAnonymousRecyclerView != null) {
                paramAnonymousRecyclerView.aA(Long.valueOf(l));
              }
            }
            c.a(this.LuT, false);
          }
        }
      }
    });
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(-2L, -1L, ""));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(-1L, 0L, ""));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(1000L, 3000L, "j测试as的逻辑发来的"));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(5000L, 7000L, "j测试as的逻辑发来的"));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(8000L, 10000L, "j测试asj测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的的逻辑发来的"));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(10000L, 12000L, "j测试as的逻辑发来的"));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(13000L, 15000L, "j测试asj测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的的逻辑发来的"));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(999999L, 9999999L, ""));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(201203);
      throw paramContext;
    }
    ((c)paramContext).LuU.add(new a(9999999L, 99999990L, ""));
    paramContext = this.LuM.getAdapter();
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.notifyDataSetChanged();
    AppMethodBeat.o(201203);
  }
  
  public final d.g.a.a<y> getVideoPauseListener()
  {
    return this.LuO;
  }
  
  public final d.g.a.b<Long, y> getVideoSeekListener()
  {
    return this.LuP;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201202);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    while (paramView.intValue() != 2131307269)
    {
      if (paramView != null) {
        break label54;
      }
      AppMethodBeat.o(201202);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(201202);
      return;
      label54:
      paramView.intValue();
    }
  }
  
  public final void setVideoPauseListener(d.g.a.a<y> parama)
  {
    this.LuO = parama;
  }
  
  public final void setVideoSeekListener(d.g.a.b<? super Long, y> paramb)
  {
    this.LuP = paramb;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionItemData;", "", "startTimeMs", "", "endTimeMs", "caption", "", "(JJLjava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "getStartTimeMs", "setStartTimeMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
  public static final class a
  {
    long bxw;
    String caption;
    private long gnO;
    
    public a(long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(201193);
      this.bxw = paramLong1;
      this.gnO = paramLong2;
      this.caption = paramString;
      AppMethodBeat.o(201193);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(201196);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.bxw != paramObject.bxw) || (this.gnO != paramObject.gnO) || (!k.g(this.caption, paramObject.caption))) {}
        }
      }
      else
      {
        AppMethodBeat.o(201196);
        return true;
      }
      AppMethodBeat.o(201196);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(201195);
      long l = this.bxw;
      int j = (int)(l ^ l >>> 32);
      l = this.gnO;
      int k = (int)(l ^ l >>> 32);
      String str = this.caption;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(201195);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201194);
      String str = "CaptionItemData(startTimeMs=" + this.bxw + ", endTimeMs=" + this.gnO + ", caption=" + this.caption + ")";
      AppMethodBeat.o(201194);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$Companion;", "", "()V", "LIST_ROW", "", "TAG", "", "UNSELELCT_ALPHA", "", "plugin-vlog_release"})
  static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionItemData;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<c.a> LuU;
    int aay;
    private Context context;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(201201);
      this.context = paramContext;
      this.LuU = new ArrayList();
      AppMethodBeat.o(201201);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(201198);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496167, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(201198);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(201198);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(201200);
      k.h(paramv, "viewHolder");
      Object localObject = paramv.arI;
      k.g(localObject, "viewHolder.itemView");
      if (TextUtils.isEmpty((CharSequence)((c.a)this.LuU.get(paramInt)).caption))
      {
        ((View)localObject).setVisibility(4);
        AppMethodBeat.o(201200);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.aay == paramInt) {}
      for (float f = 1.0F;; f = 0.5F)
      {
        ((View)localObject).setAlpha(f);
        localObject = (TextView)((View)localObject).findViewById(2131307270);
        k.g(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)((c.a)this.LuU.get(paramInt)).caption);
        paramv.arI.findViewById(2131307271).setOnClickListener((View.OnClickListener)a.LuV);
        AppMethodBeat.o(201200);
        return;
        c.fZq();
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(201199);
      int i = this.LuU.size();
      AppMethodBeat.o(201199);
      return i;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      public static final a LuV;
      
      static
      {
        AppMethodBeat.i(201197);
        LuV = new a();
        AppMethodBeat.o(201197);
      }
      
      public final void onClick(View paramView) {}
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.v
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */