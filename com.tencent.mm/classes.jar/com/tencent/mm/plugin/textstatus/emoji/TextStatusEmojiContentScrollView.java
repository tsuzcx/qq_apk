package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getEmojiList", "()Ljava/util/ArrayList;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiStr", "", "setOnKeyboardActionListener", "listener", "Companion", "plugin-textstatus_release"})
public final class TextStatusEmojiContentScrollView
  extends RecyclerView
  implements a
{
  public static final a MBg;
  private final ArrayList<f> DvW;
  private h MBe;
  private c MBf;
  
  static
  {
    AppMethodBeat.i(237325);
    MBg = new a((byte)0);
    AppMethodBeat.o(237325);
  }
  
  public TextStatusEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(237323);
    AppMethodBeat.o(237323);
  }
  
  public TextStatusEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237324);
    this.DvW = new ArrayList();
    initView();
    AppMethodBeat.o(237324);
  }
  
  private void initView()
  {
    AppMethodBeat.i(237320);
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.ImeEmojiContentScrollView", "initView ".concat(String.valueOf(l1)));
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.DvW;
    Object localObject2 = m.MBp;
    localObject2 = getContext();
    p.j(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)m.be((Context)localObject2, "emoji"));
    localObject1 = getContext();
    p.j(localObject1, "context");
    setAdapter((RecyclerView.a)new i((Context)localObject1, this.DvW, (a)this));
    localObject1 = m.MBp;
    localObject1 = m.aLG("emoji");
    localObject2 = ((List)this.DvW).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!p.h(((f)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      long l2 = System.currentTimeMillis();
      Log.i("WxIme.ImeEmojiContentScrollView", "initView " + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
      AppMethodBeat.o(237320);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void beq(String paramString)
  {
    AppMethodBeat.i(237321);
    p.k(paramString, "emojiStr");
    Log.d("WxIme.ImeEmojiContentScrollView", "onEmojiClick ".concat(String.valueOf(paramString)));
    new ap().content = paramString;
    c localc = this.MBf;
    if (localc != null)
    {
      localc.aLs(paramString);
      AppMethodBeat.o(237321);
      return;
    }
    AppMethodBeat.o(237321);
  }
  
  public final ArrayList<f> getEmojiList()
  {
    return this.DvW;
  }
  
  public final h getRecentSelectedListener()
  {
    return this.MBe;
  }
  
  public final void setOnKeyboardActionListener(c paramc)
  {
    this.MBf = paramc;
  }
  
  public final void setRecentSelectedListener(h paramh)
  {
    this.MBe = paramh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */