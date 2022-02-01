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
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiSubTypeScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIEmojiSubTypeSelectListener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "typeName", "", "initView", "", "onSubTypeClick", "position", "itemView", "Landroid/view/View;", "setIEmojiSubTypeSelectListener", "listener", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEmojiSubTypeScrollView
  extends RecyclerView
  implements g.a
{
  public static final TextStatusEmojiSubTypeScrollView.a TkT;
  private b TkU;
  private String typeName;
  
  static
  {
    AppMethodBeat.i(290752);
    TkT = new TextStatusEmojiSubTypeScrollView.a((byte)0);
    AppMethodBeat.o(290752);
  }
  
  public TextStatusEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(290730);
    AppMethodBeat.o(290730);
  }
  
  public TextStatusEmojiSubTypeScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290744);
    this.typeName = "emoji";
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ImeEmojiSubTypeScrollView, paramInt, 0);
    s.s(paramContext, "context!!.obtainStyledAt…eScrollView, defStyle, 0)");
    switch (paramContext.getInt(a.j.ImeEmojiSubTypeScrollView_emoji_type, 1))
    {
    default: 
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "initView");
      getContext();
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      paramAttributeSet = m.TkV;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      paramContext.bXK = m.bg(paramAttributeSet, this.typeName).size();
      paramContext.setItemPrefetchEnabled(true);
      setLayoutManager((RecyclerView.LayoutManager)paramContext);
      paramContext = m.TkV;
      paramContext = m.aIz(this.typeName);
      paramAttributeSet = m.TkV;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      paramAttributeSet = ((List)m.bg(paramAttributeSet, this.typeName)).iterator();
      paramInt = i;
      label191:
      if (paramAttributeSet.hasNext()) {
        if (!s.p(((f)paramAttributeSet.next()).typeName, paramContext)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramAttributeSet = this.typeName;
      Object localObject = m.TkV;
      localObject = getContext();
      s.s(localObject, "context");
      setAdapter((RecyclerView.a)new l(paramAttributeSet, m.bg((Context)localObject, this.typeName), paramInt, (g.a)this));
      paramAttributeSet = m.TkV;
      paramAttributeSet = getContext();
      s.s(paramAttributeSet, "context");
      setItemViewCacheSize(m.bg(paramAttributeSet, this.typeName).size());
      Log.d("WxIme.ImeEmojiSubTypeScrollView", "init " + this.typeName + ' ' + paramContext + ' ' + paramInt);
      AppMethodBeat.o(290744);
      return;
      this.typeName = "emoji";
      break;
      this.typeName = "kaoemoji";
      break;
      paramInt += 1;
      break label191;
      paramInt = -1;
    }
  }
  
  public final void r(int paramInt, View paramView)
  {
    AppMethodBeat.i(290772);
    s.u(paramView, "itemView");
    Log.d("WxIme.ImeEmojiSubTypeScrollView", s.X("onSubTypeClick ", Integer.valueOf(paramInt)));
    b localb = this.TkU;
    if (localb != null) {
      localb.q(paramInt, paramView);
    }
    AppMethodBeat.o(290772);
  }
  
  public final void setIEmojiSubTypeSelectListener(b paramb)
  {
    AppMethodBeat.i(290762);
    s.u(paramb, "listener");
    this.TkU = paramb;
    AppMethodBeat.o(290762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiSubTypeScrollView
 * JD-Core Version:    0.7.0.1
 */