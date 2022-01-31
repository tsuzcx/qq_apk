package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.HorizontalListView.a;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m
{
  private View QR;
  private AdapterView.OnItemClickListener ajR = new m.3(this);
  private int hAH = 3;
  ArrayList<EmojiInfo> jeL = new ArrayList();
  Context mContext;
  ah mHandler = new m.1(this);
  m.a sfs;
  int sgF;
  int sgG;
  o sgH;
  View sgI;
  j sgJ;
  String sgK;
  public String sgL = "";
  public boolean sgM = true;
  private HorizontalListView sgN;
  m.b sgO;
  private boolean sgP = true;
  private Comparator sgQ = new m.2(this);
  private HorizontalListView.a sgR = new m.4(this);
  
  public m(Context paramContext)
  {
    this.mContext = paramContext;
    this.QR = View.inflate(this.mContext, a.f.chatting_footer_suggest_emoticon_bubble, null);
    this.sgN = ((HorizontalListView)this.QR.findViewById(a.e.suggest_list_view));
    this.sgO = new m.b(this);
    this.sgN.setAdapter(this.sgO);
    this.sgN.setOnItemClickListener(this.ajR);
    this.sgN.setOnItemSelectedListener(new m.5(this));
    this.sgN.setDispatchTouchListener(this.sgR);
    this.sgF = a.aa(this.mContext, a.c.emoji_suggest_image_size);
    this.sgG = a.aa(this.mContext, a.c.MiddlePadding);
    this.sgH = new o(this.QR, this.sgF + this.sgG * 2, this.sgF + this.sgG * 2, true);
    this.sgH.setBackgroundDrawable(new ColorDrawable(0));
    this.sgH.setOutsideTouchable(true);
    this.sgH.setFocusable(false);
  }
  
  public final boolean cd(String paramString)
  {
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (!bk.bl(paramString))
        {
          localObject = ((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().Ay(paramString);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            this.sgK = paramString.replaceAll(",", "");
            if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
              break label342;
            }
            paramString = new ArrayList();
            this.jeL.clear();
            int j = ((ArrayList)localObject).size();
            i = 0;
            if ((i < j) && (i < 100))
            {
              localEmojiInfo = ((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().As((String)((ArrayList)localObject).get(i));
              if (localEmojiInfo == null) {
                break label344;
              }
              paramString.add(localEmojiInfo);
              break label344;
            }
            if (paramString.isEmpty())
            {
              y.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
              return false;
            }
            if (!this.sgP) {
              break label267;
            }
            localObject = (EmojiInfo)Collections.max(paramString, this.sgQ);
            this.jeL.add(localObject);
            paramString = paramString.iterator();
            if (!paramString.hasNext()) {
              break label317;
            }
            EmojiInfo localEmojiInfo = (EmojiInfo)paramString.next();
            if ((localEmojiInfo.bX(localObject)) || (this.jeL.contains(localEmojiInfo))) {
              continue;
            }
            this.jeL.add(localEmojiInfo);
            continue;
          }
        }
        paramString = paramString.iterator();
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.emoji.SuggestEmoticonBubble", bk.j(paramString));
        this.sgK = "";
        return false;
      }
      label267:
      while (paramString.hasNext())
      {
        localObject = (EmojiInfo)paramString.next();
        if (!this.jeL.contains(localObject)) {
          this.jeL.add(localObject);
        }
      }
      label317:
      boolean bool;
      if (this.jeL != null) {
        bool = this.jeL.isEmpty();
      }
      return !bool;
      label342:
      return false;
      label344:
      i += 1;
    }
  }
  
  public final void cnO()
  {
    if (this.sgI != null)
    {
      int[] arrayOfInt = new int[2];
      this.sgI.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = (this.sgH.getWidth() - this.sgI.getWidth()) / 2;
      int k = arrayOfInt[1];
      int m = this.sgH.getHeight();
      this.sgH.showAtLocation(this.sgI, 0, i - j, k - m);
    }
  }
  
  public final void hide()
  {
    if (this.sgH == null) {}
    while (!this.sgH.isShowing()) {
      return;
    }
    this.sgH.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */