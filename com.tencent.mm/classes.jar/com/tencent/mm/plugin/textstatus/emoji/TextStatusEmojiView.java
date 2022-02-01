package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentEmojiType", "", "deleteContainerRv", "getDeleteContainerRv", "()Landroid/widget/RelativeLayout;", "deleteContainerRv$delegate", "Lkotlin/Lazy;", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "emojiContentContainerRv$delegate", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "pageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "initView", "", "onClick", "v", "Landroid/view/View;", "onEmojiSubTypeClick", "position", "itemView", "setOnKeyboardActionListener", "listener", "setTabSelected", "groupIndex", "Companion", "plugin-textstatus_release"})
public final class TextStatusEmojiView
  extends RelativeLayout
  implements View.OnClickListener, b
{
  public static final a MBt;
  private String Dwu;
  private final kotlin.f Dwv;
  private final kotlin.f Dww;
  private final h MBe;
  private c MBf;
  private final kotlin.f MBq;
  private final k MBr;
  private final k.a MBs;
  
  static
  {
    AppMethodBeat.i(234573);
    MBt = new a((byte)0);
    AppMethodBeat.o(234573);
  }
  
  public TextStatusEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextStatusEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private TextStatusEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(234572);
    this.Dwu = "emoji";
    this.Dwv = g.ar((kotlin.g.a.a)new d(this));
    this.Dww = g.ar((kotlin.g.a.a)new c(this));
    this.MBq = g.ar((kotlin.g.a.a)new b(this));
    this.MBr = new k();
    this.MBs = ((k.a)new e(this));
    this.MBe = ((h)new f(this));
    Log.d("WxIme.ImeEmojiView", "initView");
    ad.kS(getContext()).inflate(b.f.Mym, (ViewGroup)this, true);
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.MBe);
    this.MBr.MBk = this.MBs;
    this.MBr.a((RecyclerView)getEmojiContentContainerRv());
    getDeleteContainerRv().setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(234572);
  }
  
  private final RelativeLayout getDeleteContainerRv()
  {
    AppMethodBeat.i(234562);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.MBq.getValue();
    AppMethodBeat.o(234562);
    return localRelativeLayout;
  }
  
  private final TextStatusEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(234560);
    TextStatusEmojiContentScrollView localTextStatusEmojiContentScrollView = (TextStatusEmojiContentScrollView)this.Dww.getValue();
    AppMethodBeat.o(234560);
    return localTextStatusEmojiContentScrollView;
  }
  
  private final TextStatusEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(234558);
    TextStatusEmojiSubTypeScrollView localTextStatusEmojiSubTypeScrollView = (TextStatusEmojiSubTypeScrollView)this.Dwv.getValue();
    AppMethodBeat.o(234558);
    return localTextStatusEmojiSubTypeScrollView;
  }
  
  public final void j(int paramInt, View paramView)
  {
    AppMethodBeat.i(234569);
    p.k(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = getEmojiContentContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
    paramView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(234569);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234570);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.MBf;
    if (paramView != null) {
      paramView.glC();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(234570);
  }
  
  public final void setOnKeyboardActionListener(c paramc)
  {
    AppMethodBeat.i(234564);
    this.MBf = paramc;
    TextStatusEmojiContentScrollView localTextStatusEmojiContentScrollView = getEmojiContentContainerRv();
    if (localTextStatusEmojiContentScrollView != null)
    {
      localTextStatusEmojiContentScrollView.setOnKeyboardActionListener(paramc);
      AppMethodBeat.o(234564);
      return;
    }
    AppMethodBeat.o(234564);
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(234568);
    Log.i("WxIme.ImeEmojiView", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = m.MBp;
    localObject1 = getContext();
    p.j(localObject1, "context");
    localObject1 = m.be((Context)localObject1, this.Dwu);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = getEmojiSubTypeContainerRv().getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiSubTypeAdapter");
        AppMethodBeat.o(234568);
        throw ((Throwable)localObject1);
      }
      localObject1 = (l)localObject1;
      Object localObject2 = getContext();
      p.j(localObject2, "context");
      p.k(localObject2, "context");
      Log.i("WxIme.ImeEmojiSubTypeAdapter", "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
      if (((l)localObject1).bFx != paramInt)
      {
        ((l)localObject1).cL(((l)localObject1).bFx);
        ((l)localObject1).bFx = paramInt;
        ((l)localObject1).cL(((l)localObject1).bFx);
        Object localObject3 = m.MBp;
        localObject3 = ((l)localObject1).typeName;
        m localm = m.MBp;
        m.ir((String)localObject3, ((f)m.be((Context)localObject2, ((l)localObject1).typeName).get(paramInt)).typeName);
      }
      localObject1 = getEmojiSubTypeContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((TextStatusEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(234568);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<TextStatusEmojiContentScrollView>
  {
    c(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextStatusEmojiSubTypeScrollView>
  {
    d(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView$pageSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-textstatus_release"})
  public static final class e
    implements k.a
  {
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(234358);
      if ((paramInt < 0) || (paramInt >= TextStatusEmojiView.a(this.MBu).getEmojiList().size()))
      {
        AppMethodBeat.o(234358);
        return;
      }
      this.MBu.setTabSelected(paramInt);
      AppMethodBeat.o(234358);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView$recentSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-textstatus_release"})
  public static final class f
    implements h
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView
 * JD-Core Version:    0.7.0.1
 */