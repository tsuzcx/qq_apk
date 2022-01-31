package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.g;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;
import java.util.ArrayList;

public final class h
  extends BaseAdapter
{
  public static final String wxi = File.separator;
  private Context mContext;
  public ArrayList<EmojiGroupInfo> mData = new ArrayList();
  private com.tencent.mm.view.f.a wvQ;
  c wxh = null;
  
  public h(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    this.mContext = paramContext;
    this.wvQ = parama;
    paramContext = new c.a();
    paramContext.erd = true;
    paramContext.erk = 4;
    paramContext.ery = a.d.bottom_btn_bg;
    paramContext.erl = this.wvQ.wzn;
    paramContext.erl = this.wvQ.wzn;
    this.wxh = paramContext.OV();
  }
  
  private static String I(String paramString1, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString2)) && (bk.bl(paramString3))) {
      y.w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
    }
    for (;;)
    {
      return null;
      if ((bk.bl(paramString2)) && (bk.bl(paramString3)))
      {
        y.e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
        paramString3 = null;
      }
      while (!bk.bl(paramString3))
      {
        if (!bk.bl(paramString2)) {
          break label108;
        }
        return paramString1 + paramString3;
        if (bk.bl(paramString3)) {
          paramString3 = com.tencent.mm.a.g.o(paramString2.getBytes());
        } else {
          paramString3 = com.tencent.mm.a.g.o(paramString3.getBytes());
        }
      }
    }
    label108:
    return paramString1 + paramString2 + wxi + paramString3;
  }
  
  public final EmojiGroupInfo IQ(int paramInt)
  {
    if ((this.mData == null) || (this.mData.isEmpty()) || (this.mData.size() < paramInt)) {
      return null;
    }
    return (EmojiGroupInfo)this.mData.get(paramInt);
  }
  
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
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(a.f.smiley_panel_listview_item, null);
      paramViewGroup = new h.a(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    EmojiGroupInfo localEmojiGroupInfo;
    for (;;)
    {
      localEmojiGroupInfo = IQ(paramInt);
      if (localEmojiGroupInfo != null) {
        break;
      }
      paramViewGroup.bNu.setVisibility(8);
      paramViewGroup.bNu.setTag("");
      y.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "emoji group info is null. position:%d", new Object[] { Integer.valueOf(paramInt) });
      return paramView;
      paramViewGroup = (h.a)paramView.getTag();
    }
    paramViewGroup.bNu.setVisibility(0);
    paramViewGroup.xwg.setVisibility(8);
    if ("TAG_DEFAULT_TAB".equals(localEmojiGroupInfo.field_productID)) {
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
      {
        o.ON().a(a.g.emotionstore_emoji_icon, paramViewGroup.bNu, this.wxh);
        paramViewGroup.bNu.setContentDescription(this.mContext.getString(a.h.emoji_system));
      }
    }
    for (;;)
    {
      paramViewGroup.bNu.setBackgroundResource(a.d.bottom_btn_bg);
      paramViewGroup.bNu.setPadding(this.wvQ.wzo, this.wvQ.wzo, this.wvQ.wzo, this.wvQ.wzo);
      if (paramInt != this.wvQ.cMa()) {
        break label1161;
      }
      paramViewGroup.bNu.setSelected(true);
      return paramView;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(a.g.emotionstore_emoji_icon, paramViewGroup.bNu, this.wxh);
      break;
      if (String.valueOf(EmojiGroupInfo.uCR).equals(localEmojiGroupInfo.field_productID))
      {
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
          o.ON().a(a.g.emotionstore_custom_icon, paramViewGroup.bNu, this.wxh);
        }
        for (;;)
        {
          paramViewGroup.bNu.setContentDescription(this.mContext.getString(a.h.emotion_custom));
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().bNy()) {
            break;
          }
          paramViewGroup.xwg.setVisibility(0);
          break;
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(a.g.emotionstore_custom_icon, paramViewGroup.bNu, this.wxh);
        }
      }
      if (String.valueOf(EmojiGroupInfo.uCQ).equals(localEmojiGroupInfo.field_productID))
      {
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
          o.ON().a(a.d.emotions_bagcover, paramViewGroup.bNu, this.wxh);
        }
        for (;;)
        {
          paramViewGroup.bNu.setContentDescription(this.mContext.getString(a.h.emoji_store_tuzi_title));
          break;
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(a.d.emotions_bagcover, paramViewGroup.bNu, this.wxh);
        }
      }
      if ("TAG_STORE_MANEGER_TAB".equals(localEmojiGroupInfo.field_productID))
      {
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
          o.ON().a(a.g.emotionstore_manager_icon, paramViewGroup.bNu, this.wxh);
        }
        for (;;)
        {
          paramViewGroup.bNu.setContentDescription(this.mContext.getString(a.h.settings_emoji_manager));
          break;
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(a.g.emotionstore_manager_icon, paramViewGroup.bNu, this.wxh);
        }
      }
      String str;
      Object localObject;
      if (!com.tencent.mm.view.f.a.d(localEmojiGroupInfo))
      {
        str = localEmojiGroupInfo.field_packGrayIconUrl;
        localObject = I(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().FU() + "emoji/", localEmojiGroupInfo.field_productID, str);
        c.a locala = new c.a();
        locala.erh = ((String)localObject);
        locala.erd = true;
        locala.erf = true;
        locala.ery = a.d.bottom_btn_bg;
        locala.ero = true;
        locala.erl = this.wvQ.wzn;
        locala.erl = this.wvQ.wzn;
        localObject = locala.OV();
        if (!bk.bl(str)) {
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(str, paramViewGroup.bNu, (c)localObject);
        }
      }
      for (;;)
      {
        if (!bk.bl(localEmojiGroupInfo.field_packName)) {
          break label1146;
        }
        paramViewGroup.bNu.setContentDescription(this.mContext.getString(a.h.emoji_store_title));
        break;
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a("", paramViewGroup.bNu, (c)localObject);
        y.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "empty url.");
        continue;
        str = I(new StringBuilder().append(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().FU()).append("emoji/").toString(), localEmojiGroupInfo.field_productID, "") + "_panel_enable";
        localObject = new c.a();
        ((c.a)localObject).erh = str;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).ery = a.d.bottom_btn_bg;
        ((c.a)localObject).erk = 1;
        ((c.a)localObject).erl = this.wvQ.wzn;
        ((c.a)localObject).erl = this.wvQ.wzn;
        localObject = ((c.a)localObject).OV();
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a(str, paramViewGroup.bNu, (c)localObject);
      }
      label1146:
      paramViewGroup.bNu.setContentDescription(localEmojiGroupInfo.field_packName);
    }
    label1161:
    paramViewGroup.bNu.setSelected(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.h
 * JD-Core Version:    0.7.0.1
 */