package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.bm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getEmojiList", "()Ljava/util/ArrayList;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/OnTextEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiStr", "", "setOnKeyboardActionListener", "listener", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEmojiContentScrollView
  extends RecyclerView
  implements a
{
  public static final TextStatusEmojiContentScrollView.a TkK;
  private final ArrayList<f> Jpd;
  private h TkL;
  private c TkM;
  
  static
  {
    AppMethodBeat.i(290847);
    TkK = new TextStatusEmojiContentScrollView.a((byte)0);
    AppMethodBeat.o(290847);
  }
  
  public TextStatusEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(290825);
    AppMethodBeat.o(290825);
  }
  
  public TextStatusEmojiContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290830);
    this.Jpd = new ArrayList();
    initView();
    AppMethodBeat.o(290830);
  }
  
  private void initView()
  {
    AppMethodBeat.i(290839);
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.ImeEmojiContentScrollView", s.X("initView ", Long.valueOf(l1)));
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = this.Jpd;
    Object localObject2 = m.TkV;
    localObject2 = getContext();
    s.s(localObject2, "context");
    ((ArrayList)localObject1).addAll((Collection)m.bg((Context)localObject2, "emoji"));
    localObject1 = getContext();
    s.s(localObject1, "context");
    setAdapter((RecyclerView.a)new i((Context)localObject1, this.Jpd, (a)this));
    localObject1 = m.TkV;
    localObject1 = m.aIz("emoji");
    localObject2 = ((List)this.Jpd).iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext()) {
      if (!s.p(((f)((Iterator)localObject2).next()).typeName, localObject1)) {}
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
      long l2 = System.currentTimeMillis();
      Log.i("WxIme.ImeEmojiContentScrollView", "initView " + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
      AppMethodBeat.o(290839);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void bdQ(String paramString)
  {
    AppMethodBeat.i(290864);
    s.u(paramString, "emojiStr");
    Log.d("WxIme.ImeEmojiContentScrollView", s.X("onEmojiClick ", paramString));
    new bm().content = paramString;
    c localc = this.TkM;
    if (localc != null) {
      localc.aIj(paramString);
    }
    AppMethodBeat.o(290864);
  }
  
  public final ArrayList<f> getEmojiList()
  {
    return this.Jpd;
  }
  
  public final h getRecentSelectedListener()
  {
    return this.TkL;
  }
  
  public final void setOnKeyboardActionListener(c paramc)
  {
    this.TkM = paramc;
  }
  
  public final void setRecentSelectedListener(h paramh)
  {
    this.TkL = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiContentScrollView
 * JD-Core Version:    0.7.0.1
 */