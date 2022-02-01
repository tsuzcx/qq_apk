package com.tencent.mm.ui.contact.address;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/AddressItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "()V", "onRightTextLableMergeCallback", "Lcom/tencent/mm/ui/base/NoMeasuredTextView$OnRightTextLableMergeCallback;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "app_release"})
public final class c
  extends e<d>
{
  public static final c.a Xxa;
  private final NoMeasuredTextView.c Xpk;
  
  static
  {
    AppMethodBeat.i(259921);
    Xxa = new c.a((byte)0);
    AppMethodBeat.o(259921);
  }
  
  public c()
  {
    AppMethodBeat.i(259920);
    this.Xpk = ((NoMeasuredTextView.c)b.Xxb);
    AppMethodBeat.o(259920);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(259918);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(259918);
  }
  
  public final int getLayoutId()
  {
    return R.i.ebs;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "textView", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "mText", "", "rightLableText", "", "rightLableColorID", "", "rightLableSize", "onRightTextLableMerge"})
  static final class b
    implements NoMeasuredTextView.c
  {
    public static final b Xxb;
    
    static
    {
      AppMethodBeat.i(275915);
      Xxb = new b();
      AppMethodBeat.o(275915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.c
 * JD-Core Version:    0.7.0.1
 */