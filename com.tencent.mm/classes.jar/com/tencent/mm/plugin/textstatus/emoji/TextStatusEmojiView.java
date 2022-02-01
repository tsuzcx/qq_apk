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
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentEmojiType", "", "deleteContainerRv", "getDeleteContainerRv", "()Landroid/widget/RelativeLayout;", "deleteContainerRv$delegate", "Lkotlin/Lazy;", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "emojiContentContainerRv$delegate", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "pageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "initView", "", "onClick", "v", "Landroid/view/View;", "onEmojiSubTypeClick", "position", "itemView", "setOnKeyboardActionListener", "listener", "setTabSelected", "groupIndex", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEmojiView
  extends RelativeLayout
  implements View.OnClickListener, b
{
  public static final TextStatusEmojiView.a TkW;
  private String JpB;
  private final j JpC;
  private final j JpD;
  private final h TkL;
  private c TkM;
  private final j TkX;
  private final k TkY;
  private final k.a TkZ;
  
  static
  {
    AppMethodBeat.i(290773);
    TkW = new TextStatusEmojiView.a((byte)0);
    AppMethodBeat.o(290773);
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
    AppMethodBeat.i(290734);
    this.JpB = "emoji";
    this.JpC = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.JpD = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.TkX = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.TkY = new k();
    this.TkZ = ((k.a)new e(this));
    this.TkL = ((h)new f(this));
    Log.d("WxIme.ImeEmojiView", "initView");
    af.mU(getContext()).inflate(a.f.TfP, (ViewGroup)this, true);
    getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener((b)this);
    getEmojiContentContainerRv().setRecentSelectedListener(this.TkL);
    this.TkY.TkQ = this.TkZ;
    this.TkY.a((RecyclerView)getEmojiContentContainerRv());
    getDeleteContainerRv().setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(290734);
  }
  
  private final RelativeLayout getDeleteContainerRv()
  {
    AppMethodBeat.i(290754);
    Object localObject = this.TkX.getValue();
    s.s(localObject, "<get-deleteContainerRv>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(290754);
    return localObject;
  }
  
  private final TextStatusEmojiContentScrollView getEmojiContentContainerRv()
  {
    AppMethodBeat.i(290747);
    Object localObject = this.JpD.getValue();
    s.s(localObject, "<get-emojiContentContainerRv>(...)");
    localObject = (TextStatusEmojiContentScrollView)localObject;
    AppMethodBeat.o(290747);
    return localObject;
  }
  
  private final TextStatusEmojiSubTypeScrollView getEmojiSubTypeContainerRv()
  {
    AppMethodBeat.i(290739);
    Object localObject = this.JpC.getValue();
    s.s(localObject, "<get-emojiSubTypeContainerRv>(...)");
    localObject = (TextStatusEmojiSubTypeScrollView)localObject;
    AppMethodBeat.o(290739);
    return localObject;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290811);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.TkM;
    if (paramView != null) {
      paramView.hGY();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290811);
  }
  
  public final void q(int paramInt, View paramView)
  {
    AppMethodBeat.i(290804);
    s.u(paramView, "itemView");
    setTabSelected(paramInt);
    paramView = getEmojiContentContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
    paramView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(290804);
  }
  
  public final void setOnKeyboardActionListener(c paramc)
  {
    AppMethodBeat.i(290783);
    this.TkM = paramc;
    TextStatusEmojiContentScrollView localTextStatusEmojiContentScrollView = getEmojiContentContainerRv();
    if (localTextStatusEmojiContentScrollView != null) {
      localTextStatusEmojiContentScrollView.setOnKeyboardActionListener(paramc);
    }
    AppMethodBeat.o(290783);
  }
  
  public final void setTabSelected(int paramInt)
  {
    AppMethodBeat.i(290797);
    Log.i("WxIme.ImeEmojiView", "setTabSelected: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = m.TkV;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = m.bg((Context)localObject1, this.JpB);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = getEmojiSubTypeContainerRv().getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiSubTypeAdapter");
        AppMethodBeat.o(290797);
        throw ((Throwable)localObject1);
      }
      localObject1 = (l)localObject1;
      Object localObject2 = getContext();
      s.s(localObject2, "context");
      s.u(localObject2, "context");
      Log.i("WxIme.ImeEmojiSubTypeAdapter", "setSelection: %s", new Object[] { Integer.valueOf(paramInt) });
      if (((l)localObject1).dyx != paramInt)
      {
        ((l)localObject1).fV(((l)localObject1).dyx);
        ((l)localObject1).dyx = paramInt;
        ((l)localObject1).fV(((l)localObject1).dyx);
        Object localObject3 = m.TkV;
        localObject3 = ((l)localObject1).typeName;
        m localm = m.TkV;
        m.jA((String)localObject3, ((f)m.bg((Context)localObject2, ((l)localObject1).typeName).get(paramInt)).typeName);
      }
      localObject1 = getEmojiSubTypeContainerRv();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((TextStatusEmojiSubTypeScrollView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(290797);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextStatusEmojiContentScrollView>
  {
    c(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextStatusEmojiSubTypeScrollView>
  {
    d(TextStatusEmojiView paramTextStatusEmojiView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView$pageSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements k.a
  {
    e(TextStatusEmojiView paramTextStatusEmojiView) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(290813);
      if ((paramInt < 0) || (paramInt >= TextStatusEmojiView.a(this.Tla).getEmojiList().size()))
      {
        AppMethodBeat.o(290813);
        return;
      }
      this.Tla.setTabSelected(paramInt);
      AppMethodBeat.o(290813);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView$recentSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements h
  {
    f(TextStatusEmojiView paramTextStatusEmojiView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView
 * JD-Core Version:    0.7.0.1
 */