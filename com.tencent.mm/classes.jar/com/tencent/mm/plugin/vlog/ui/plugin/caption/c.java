package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionCheckBox", "Landroid/widget/CheckBox;", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "", "onTouchingView", "", "videoPauseListener", "Lkotlin/Function0;", "", "getVideoPauseListener", "()Lkotlin/jvm/functions/Function0;", "setVideoPauseListener", "(Lkotlin/jvm/functions/Function0;)V", "videoSeekListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "timestampMs", "getVideoSeekListener", "()Lkotlin/jvm/functions/Function1;", "setVideoSeekListener", "(Lkotlin/jvm/functions/Function1;)V", "buildTestData", "ifCenter", "view", "Landroid/view/View;", "onClick", "v", "scrollToTimeMs", "timeStampMs", "time2Pos", "CaptionItemData", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c
  extends LinearLayout
  implements View.OnClickListener
{
  @Deprecated
  public static final b Auk;
  private RecyclerView Auf;
  private CheckBox Aug;
  private d.g.a.a<y> Auh;
  private d.g.a.b<? super Long, y> Aui;
  private boolean Auj;
  private int abu;
  
  static
  {
    AppMethodBeat.i(207889);
    Auk = new b((byte)0);
    AppMethodBeat.o(207889);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207888);
    if (LayoutInflater.from(paramContext).inflate(2131496169, (ViewGroup)this, true) == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    findViewById(2131307288).setOnClickListener((View.OnClickListener)this);
    findViewById(2131307293).setOnClickListener((View.OnClickListener)this);
    View localView = findViewById(2131307291);
    k.g(localView, "findViewById(R.id.caption_list)");
    this.Auf = ((RecyclerView)localView);
    localView = findViewById(2131307292);
    k.g(localView, "findViewById(R.id.caption_select)");
    this.Aug = ((CheckBox)localView);
    this.Auf.setLayoutManager((RecyclerView.i)new EditorCaptionLayoutManager(paramContext));
    this.Auf.setAdapter((RecyclerView.a)new c(paramContext));
    this.Auf.a((RecyclerView.m)new RecyclerView.m()
    {
      private int Aul = -1;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(207877);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (!c.a(this.Aum))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(207877);
          return;
        }
        paramAnonymousInt2 = c.c(this.Aum);
        paramAnonymousRecyclerView = c.b(this.Aum).getLayoutManager();
        if (paramAnonymousRecyclerView == null)
        {
          paramAnonymousRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(207877);
          throw paramAnonymousRecyclerView;
        }
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView;
        int i = (paramAnonymousRecyclerView.jW() + paramAnonymousRecyclerView.jY()) / 2;
        if (i == this.Aul)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(207877);
          return;
        }
        this.Aul = i;
        paramAnonymousInt1 = i - 1;
        i += 1;
        if (paramAnonymousInt1 <= i) {}
        for (;;)
        {
          if (c.a(this.Aum, paramAnonymousRecyclerView.bY(paramAnonymousInt1)))
          {
            c.a(this.Aum, paramAnonymousInt1);
            localObject = c.b(this.Aum).getAdapter();
            if (localObject == null)
            {
              paramAnonymousRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
              AppMethodBeat.o(207877);
              throw paramAnonymousRecyclerView;
            }
            ((c.c)localObject).abu = c.c(this.Aum);
            localObject = paramAnonymousRecyclerView.bY(paramAnonymousInt2);
            if (localObject != null)
            {
              c.egr();
              ((View)localObject).setAlpha(0.5F);
            }
            paramAnonymousRecyclerView = paramAnonymousRecyclerView.bY(c.c(this.Aum));
            if (paramAnonymousRecyclerView != null) {
              paramAnonymousRecyclerView.setAlpha(1.0F);
            }
            c.egr();
            ac.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + c.c(this.Aum) + ' ' + paramAnonymousInt2);
          }
          while (paramAnonymousInt1 == i)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(207877);
            return;
          }
          paramAnonymousInt1 += 1;
        }
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(207876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(207876);
          return;
          c.egr();
          ac.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          c.a(this.Aum, true);
          paramAnonymousRecyclerView = this.Aum.getVideoPauseListener();
          if (paramAnonymousRecyclerView != null)
          {
            paramAnonymousRecyclerView.invoke();
            continue;
            c.egr();
            ac.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_IDLE");
            if (c.a(this.Aum))
            {
              paramAnonymousRecyclerView = c.b(this.Aum).getAdapter();
              if (paramAnonymousRecyclerView == null)
              {
                paramAnonymousRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
                AppMethodBeat.o(207876);
                throw paramAnonymousRecyclerView;
              }
              long l = ((c.a)((c.c)paramAnonymousRecyclerView).Aun.get(c.c(this.Aum))).bvf;
              paramAnonymousRecyclerView = this.Aum.getVideoSeekListener();
              if (paramAnonymousRecyclerView != null) {
                paramAnonymousRecyclerView.ay(Long.valueOf(l));
              }
            }
            c.a(this.Aum, false);
          }
        }
      }
    });
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(-2L, -1L, ""));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(-1L, 0L, ""));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(1000L, 3000L, "j测试as的逻辑发来的"));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(5000L, 7000L, "j测试as的逻辑发来的"));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(8000L, 10000L, "j测试asj测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的的逻辑发来的"));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(10000L, 12000L, "j测试as的逻辑发来的"));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(13000L, 15000L, "j测试asj测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的j测试as的逻辑发来的的逻辑发来的"));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(999999L, 9999999L, ""));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.EditorTextCaptionView.EditorCaptionAdapter");
      AppMethodBeat.o(207888);
      throw paramContext;
    }
    ((c)paramContext).Aun.add(new a(9999999L, 99999990L, ""));
    paramContext = this.Auf.getAdapter();
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.notifyDataSetChanged();
    AppMethodBeat.o(207888);
  }
  
  public final d.g.a.a<y> getVideoPauseListener()
  {
    return this.Auh;
  }
  
  public final d.g.a.b<Long, y> getVideoSeekListener()
  {
    return this.Aui;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207887);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    while (paramView.intValue() != 2131307288)
    {
      if (paramView != null) {
        break label54;
      }
      AppMethodBeat.o(207887);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(207887);
      return;
      label54:
      paramView.intValue();
    }
  }
  
  public final void setVideoPauseListener(d.g.a.a<y> parama)
  {
    this.Auh = parama;
  }
  
  public final void setVideoSeekListener(d.g.a.b<? super Long, y> paramb)
  {
    this.Aui = paramb;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionItemData;", "", "startTimeMs", "", "endTimeMs", "caption", "", "(JJLjava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "getStartTimeMs", "setStartTimeMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
  public static final class a
  {
    long bvf;
    String caption;
    private long gOz;
    
    public a(long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(207878);
      this.bvf = paramLong1;
      this.gOz = paramLong2;
      this.caption = paramString;
      AppMethodBeat.o(207878);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(207881);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.bvf != paramObject.bvf) || (this.gOz != paramObject.gOz) || (!k.g(this.caption, paramObject.caption))) {}
        }
      }
      else
      {
        AppMethodBeat.o(207881);
        return true;
      }
      AppMethodBeat.o(207881);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(207880);
      long l = this.bvf;
      int j = (int)(l ^ l >>> 32);
      l = this.gOz;
      int k = (int)(l ^ l >>> 32);
      String str = this.caption;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(207880);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207879);
      String str = "CaptionItemData(startTimeMs=" + this.bvf + ", endTimeMs=" + this.gOz + ", caption=" + this.caption + ")";
      AppMethodBeat.o(207879);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$Companion;", "", "()V", "LIST_ROW", "", "TAG", "", "UNSELELCT_ALPHA", "", "plugin-vlog_release"})
  static final class b {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionItemData;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<c.a> Aun;
    int abu;
    private Context context;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(207886);
      this.context = paramContext;
      this.Aun = new ArrayList();
      AppMethodBeat.o(207886);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(207883);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496168, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(207883);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(207883);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(207885);
      k.h(paramw, "viewHolder");
      Object localObject = paramw.asD;
      k.g(localObject, "viewHolder.itemView");
      if (TextUtils.isEmpty((CharSequence)((c.a)this.Aun.get(paramInt)).caption))
      {
        ((View)localObject).setVisibility(4);
        AppMethodBeat.o(207885);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.abu == paramInt) {}
      for (float f = 1.0F;; f = 0.5F)
      {
        ((View)localObject).setAlpha(f);
        localObject = (TextView)((View)localObject).findViewById(2131307289);
        k.g(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)((c.a)this.Aun.get(paramInt)).caption);
        paramw.asD.findViewById(2131307290).setOnClickListener((View.OnClickListener)a.Auo);
        AppMethodBeat.o(207885);
        return;
        c.egr();
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(207884);
      int i = this.Aun.size();
      AppMethodBeat.o(207884);
      return i;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      public static final a Auo;
      
      static
      {
        AppMethodBeat.i(207882);
        Auo = new a();
        AppMethodBeat.o(207882);
      }
      
      public final void onClick(View paramView) {}
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.w
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.c
 * JD-Core Version:    0.7.0.1
 */