package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

final class m$b
  extends BaseAdapter
{
  ArrayList<EmojiInfo> mData;
  
  m$b(m paramm) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(62460);
    if (this.mData == null)
    {
      AppMethodBeat.o(62460);
      return 0;
    }
    int i = this.mData.size();
    AppMethodBeat.o(62460);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62462);
    EmojiInfo localEmojiInfo;
    String str;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.vZl.mContext).inflate(2130969042, null);
      paramViewGroup = new m.c(this.vZl, paramView);
      paramView.setTag(paramViewGroup);
      localEmojiInfo = ur(paramInt);
      paramViewGroup.vZm.setSize(this.vZl.vYY);
      paramViewGroup.vZm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      str = "";
      if (localEmojiInfo != null) {
        str = ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().Kx(localEmojiInfo.Al());
      }
      if (!bo.isNullOrNil(str)) {
        break label199;
      }
      paramViewGroup.vZm.setContentDescription(this.vZl.mContext.getString(2131299253));
      label141:
      if (localEmojiInfo == null) {
        break label225;
      }
      if (!localEmojiInfo.dzq()) {
        break label211;
      }
      paramViewGroup.vZm.b(EmojiInfo.bI(this.vZl.mContext, localEmojiInfo.getName()), localEmojiInfo.getName());
    }
    for (;;)
    {
      AppMethodBeat.o(62462);
      return paramView;
      paramViewGroup = (m.c)paramView.getTag();
      break;
      label199:
      paramViewGroup.vZm.setContentDescription(str);
      break label141;
      label211:
      paramViewGroup.vZm.a(localEmojiInfo, "");
      continue;
      label225:
      ab.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
    }
  }
  
  public final EmojiInfo ur(int paramInt)
  {
    AppMethodBeat.i(62461);
    if ((this.mData != null) && (this.mData.size() > paramInt))
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)this.mData.get(paramInt);
      AppMethodBeat.o(62461);
      return localEmojiInfo;
    }
    AppMethodBeat.o(62461);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.b
 * JD-Core Version:    0.7.0.1
 */