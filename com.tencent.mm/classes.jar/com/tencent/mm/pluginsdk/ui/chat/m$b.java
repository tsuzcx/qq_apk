package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

final class m$b
  extends BaseAdapter
{
  ArrayList<EmojiInfo> mData;
  
  m$b(m paramm) {}
  
  public final int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EmojiInfo localEmojiInfo;
    String str;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.sgS.mContext).inflate(a.f.chatting_footer_suggest_emoticon_bubble_item, null);
      paramViewGroup = new m.c(this.sgS, paramView);
      paramView.setTag(paramViewGroup);
      localEmojiInfo = pW(paramInt);
      paramViewGroup.sgT.setSize(this.sgS.sgF);
      paramViewGroup.sgT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      str = "";
      if (localEmojiInfo != null) {
        str = ((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().Aw(localEmojiInfo.Wv());
      }
      if (!bk.bl(str)) {
        break label191;
      }
      paramViewGroup.sgT.setContentDescription(this.sgS.mContext.getString(a.h.emoji_store_title));
    }
    for (;;)
    {
      if (localEmojiInfo != null)
      {
        if (localEmojiInfo.cwC())
        {
          paramViewGroup.sgT.b(EmojiInfo.bv(this.sgS.mContext, localEmojiInfo.getName()), localEmojiInfo.getName());
          return paramView;
          paramViewGroup = (m.c)paramView.getTag();
          break;
          label191:
          paramViewGroup.sgT.setContentDescription(str);
          continue;
        }
        paramViewGroup.sgT.a(localEmojiInfo, "");
        return paramView;
      }
    }
    y.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
    return paramView;
  }
  
  public final EmojiInfo pW(int paramInt)
  {
    if ((this.mData != null) && (this.mData.size() > paramInt)) {
      return (EmojiInfo)this.mData.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.b
 * JD-Core Version:    0.7.0.1
 */