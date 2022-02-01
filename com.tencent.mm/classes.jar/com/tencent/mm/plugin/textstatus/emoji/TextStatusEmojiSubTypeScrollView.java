package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIEmojiSubTypeSelectListener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "typeName", "", "initView", "", "onSubTypeClick", "position", "itemView", "Landroid/view/View;", "setIEmojiSubTypeSelectListener", "listener", "Companion", "plugin-textstatus_release"})
public final class TextStatusEmojiSubTypeScrollView
  extends RecyclerView
  implements g.a
{
  public static final a MBo;
  private b MBn;
  private String typeName;
  
  static
  {
    AppMethodBeat.i(233740);
    MBo = new a((byte)0);
    AppMethodBeat.o(233740);
  }
  
  public TextStatusEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(233734);
    AppMethodBeat.o(233734);
  }
  
  public TextStatusEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233738);
    this.typeName = "emoji";
    switch (paramContext.obtainStyledAttributes(paramAttributeSet, b.j.ImeEmojiSubTypeScrollView, paramInt, 0).getInt(b.j.ImeEmojiSubTypeScrollView_emoji_type, 1))
    {
    default: 
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "initView");
      getContext();
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      paramAttributeSet = m.MBp;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramContext.cC(m.be(paramAttributeSet, this.typeName).size());
      paramContext.setItemPrefetchEnabled(true);
      setLayoutManager((RecyclerView.LayoutManager)paramContext);
      paramContext = m.MBp;
      paramContext = m.aLG(this.typeName);
      paramAttributeSet = m.MBp;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramAttributeSet = ((List)m.be(paramAttributeSet, this.typeName)).iterator();
      paramInt = i;
      label183:
      if (paramAttributeSet.hasNext()) {
        if (!p.h(((f)paramAttributeSet.next()).typeName, paramContext)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramAttributeSet = this.typeName;
      Object localObject = m.MBp;
      localObject = getContext();
      p.j(localObject, "context");
      setAdapter((RecyclerView.a)new l(paramAttributeSet, m.be((Context)localObject, this.typeName), paramInt, (g.a)this));
      paramAttributeSet = m.MBp;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      setItemViewCacheSize(m.be(paramAttributeSet, this.typeName).size());
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "init " + this.typeName + ' ' + paramContext + ' ' + paramInt);
      AppMethodBeat.o(233738);
      return;
      this.typeName = "emoji";
      break;
      this.typeName = "kaoemoji";
      break;
      paramInt += 1;
      break label183;
      paramInt = -1;
    }
  }
  
  public final void k(int paramInt, View paramView)
  {
    AppMethodBeat.i(233731);
    p.k(paramView, "itemView");
    Log.d("WxIme.ImeEmojiSubTypeScrollView", "onSubTypeClick ".concat(String.valueOf(paramInt)));
    b localb = this.MBn;
    if (localb != null)
    {
      localb.j(paramInt, paramView);
      AppMethodBeat.o(233731);
      return;
    }
    AppMethodBeat.o(233731);
  }
  
  public final void setIEmojiSubTypeSelectListener(b paramb)
  {
    AppMethodBeat.i(233730);
    p.k(paramb, "listener");
    this.MBn = paramb;
    AppMethodBeat.o(233730);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiSubTypeScrollView
 * JD-Core Version:    0.7.0.1
 */