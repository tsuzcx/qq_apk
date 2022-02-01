package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "iconResId", "getIconResId", "()Ljava/lang/Integer;", "setIconResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mHeaderViewOnClickListener", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$OnHeaderViewClickListener;", "title", "getTitle", "setTitle", "viewHolder", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewHolder;", "getViewHolder", "()Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewHolder;", "viewHolder$delegate", "Lkotlin/Lazy;", "viewItem", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem;", "getViewItem", "()Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem;", "viewItem$delegate", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "baseViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "initData", "setBackground", "id", "setOnHeaderViewClickListener", "listener", "HeaderViewHolder", "HeaderViewItem", "OnHeaderViewClickListener", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  private final j afjL;
  private final j afjM;
  public c afkp;
  Integer afkq;
  String content;
  public Context mContext;
  String title;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(253566);
    this.afjL = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.afjM = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(253566);
  }
  
  private final void ns(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(253575);
    if (this.afey)
    {
      if (paramContext == null) {}
      for (paramContext = localObject1;; paramContext = paramContext.getString(a.h.select_contact_from_contact))
      {
        this.content = paramContext;
        this.afkq = Integer.valueOf(a.g.icons_filled_contacts);
        AppMethodBeat.o(253575);
        return;
      }
    }
    if (paramContext == null) {}
    for (paramContext = localObject2;; paramContext = paramContext.getString(a.h.select_contact_conversation_create))
    {
      this.content = paramContext;
      this.afkq = Integer.valueOf(a.g.icons_filled_add);
      AppMethodBeat.o(253575);
      return;
    }
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(253600);
    this.mContext = paramContext;
    if ((parama instanceof a)) {
      if (paramContext != null) {
        break label39;
      }
    }
    label39:
    for (parama = null;; parama = paramContext.getString(a.h.select_contact_conversation_cur))
    {
      this.title = parama;
      ns(paramContext);
      AppMethodBeat.o(253600);
      return;
    }
  }
  
  public final a.b bVv()
  {
    AppMethodBeat.i(253593);
    a.b localb = (a.b)this.afjL.getValue();
    AppMethodBeat.o(253593);
    return localb;
  }
  
  protected final a.a bVw()
  {
    AppMethodBeat.i(253596);
    a.a locala = (a.a)jzu();
    AppMethodBeat.o(253596);
    return locala;
  }
  
  public final a jzu()
  {
    AppMethodBeat.i(253589);
    a locala = (a)this.afjM.getValue();
    AppMethodBeat.o(253589);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem;)V", "contentLl", "Landroid/widget/LinearLayout;", "getContentLl", "()Landroid/widget/LinearLayout;", "setContentLl", "(Landroid/widget/LinearLayout;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "setContentTv", "(Landroid/widget/TextView;)V", "headerViewRl", "Landroid/widget/RelativeLayout;", "getHeaderViewRl", "()Landroid/widget/RelativeLayout;", "setHeaderViewRl", "(Landroid/widget/RelativeLayout;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    WeImageView Bqk;
    public LinearLayout Rry;
    public RelativeLayout afkr;
    TextView noc;
    TextView titleTv;
    
    public a()
    {
      super();
      AppMethodBeat.i(253592);
      AppMethodBeat.o(253592);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(253591);
      AppMethodBeat.o(253591);
    }
    
    private static final void a(k paramk, View paramView)
    {
      AppMethodBeat.i(253597);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramk);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramk, "this$0");
      paramk = k.a(paramk);
      if (paramk != null) {
        paramk.onClick();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253597);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(253615);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_header_view_item, paramViewGroup, false);
      k.a locala = (k.a)this.afks.jzu();
      paramContext = paramViewGroup.findViewById(a.e.header_view_rl);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(253615);
        throw paramContext;
      }
      locala.afkr = ((RelativeLayout)paramContext);
      paramContext = paramViewGroup.findViewById(a.e.header_title_tv);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(253615);
        throw paramContext;
      }
      locala.titleTv = ((TextView)paramContext);
      paramContext = locala.titleTv;
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.getPaint())
      {
        aw.d((Paint)paramContext);
        paramContext = paramViewGroup.findViewById(a.e.content_ll);
        if (paramContext != null) {
          break;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(253615);
        throw paramContext;
      }
      locala.Rry = ((LinearLayout)paramContext);
      paramContext = paramViewGroup.findViewById(a.e.icon_iv);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
        AppMethodBeat.o(253615);
        throw paramContext;
      }
      locala.Bqk = ((WeImageView)paramContext);
      paramContext = paramViewGroup.findViewById(a.e.content_tv);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(253615);
        throw paramContext;
      }
      locala.noc = ((TextView)paramContext);
      paramViewGroup.setTag(locala);
      s.s(paramViewGroup, "convertView");
      AppMethodBeat.o(253615);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(253609);
      if (((parama instanceof k.a)) && ((parama1 instanceof k)))
      {
        k.a(this.afks, paramContext);
        paramContext = this.afks;
        parama = (k.a)parama;
        TextView localTextView = parama.titleTv;
        if (localTextView != null) {
          localTextView.setText((CharSequence)((k)parama1).title);
        }
        localTextView = parama.noc;
        if (localTextView != null) {
          localTextView.setText((CharSequence)((k)parama1).content);
        }
        parama1 = ((k)parama1).afkq;
        if (parama1 != null)
        {
          int i = ((Number)parama1).intValue();
          parama1 = parama.Bqk;
          if (parama1 != null) {
            parama1.setImageResource(i);
          }
        }
        parama = parama.Rry;
        if (parama != null) {
          parama.setOnClickListener(new k.b..ExternalSyntheticLambda0(paramContext));
        }
      }
      AppMethodBeat.o(253609);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$OnHeaderViewClickListener;", "", "onClick", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void onClick();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewHolder;", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<k.a>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem$HeaderViewItem;", "Lcom/tencent/mm/ui/contact/item/HeaderViewDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<k.b>
  {
    e(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.k
 * JD-Core Version:    0.7.0.1
 */