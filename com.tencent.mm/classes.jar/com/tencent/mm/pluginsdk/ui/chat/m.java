package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  private View Qz;
  private AdapterView.OnItemClickListener amh;
  private int jsW;
  ArrayList<EmojiInfo> lnB;
  Context mContext;
  ak mHandler;
  m.a vWL;
  int vYY;
  int vYZ;
  o vZa;
  View vZb;
  j vZc;
  String vZd;
  public String vZe;
  public boolean vZf;
  private HorizontalListView vZg;
  m.b vZh;
  private boolean vZi;
  private Comparator vZj;
  private HorizontalListView.a vZk;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(62465);
    this.vZe = "";
    this.vZf = true;
    this.lnB = new ArrayList();
    this.jsW = 3;
    this.vZi = true;
    this.mHandler = new m.1(this);
    this.vZj = new Comparator() {};
    this.amh = new m.3(this);
    this.vZk = new m.4(this);
    this.mContext = paramContext;
    this.Qz = View.inflate(this.mContext, 2130969041, null);
    this.vZg = ((HorizontalListView)this.Qz.findViewById(2131822504));
    this.vZh = new m.b(this);
    this.vZg.setAdapter(this.vZh);
    this.vZg.setOnItemClickListener(this.amh);
    this.vZg.setOnItemSelectedListener(new m.5(this));
    this.vZg.setDispatchTouchListener(this.vZk);
    this.vYY = a.ao(this.mContext, 2131428394);
    this.vYZ = a.ao(this.mContext, 2131427792);
    this.vZa = new o(this.Qz, this.vYY + this.vYZ * 2, this.vYY + this.vYZ * 2, true);
    this.vZa.setBackgroundDrawable(new ColorDrawable(0));
    this.vZa.setOutsideTouchable(true);
    this.vZa.setFocusable(false);
    this.vZa.setAnimationStyle(2131493513);
    AppMethodBeat.o(62465);
  }
  
  public final boolean jdMethod_do(String paramString)
  {
    AppMethodBeat.i(62468);
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (!bo.isNullOrNil(paramString))
        {
          localObject = ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().Kz(paramString);
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            this.vZd = paramString.replaceAll(",", "");
            if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
            {
              AppMethodBeat.o(62468);
              return false;
            }
            paramString = new ArrayList();
            this.lnB.clear();
            int j = ((ArrayList)localObject).size();
            i = 0;
            if ((i < j) && (i < 100))
            {
              localEmojiInfo = ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().Kt((String)((ArrayList)localObject).get(i));
              if (localEmojiInfo == null) {
                break label367;
              }
              paramString.add(localEmojiInfo);
              break label367;
            }
            if (paramString.isEmpty())
            {
              ab.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
              AppMethodBeat.o(62468);
              return false;
            }
            if (!this.vZi) {
              break label286;
            }
            localObject = (EmojiInfo)Collections.max(paramString, this.vZj);
            this.lnB.add(localObject);
            paramString = paramString.iterator();
            if (!paramString.hasNext()) {
              break label336;
            }
            EmojiInfo localEmojiInfo = (EmojiInfo)paramString.next();
            if ((localEmojiInfo.cC(localObject)) || (this.lnB.contains(localEmojiInfo))) {
              continue;
            }
            this.lnB.add(localEmojiInfo);
            continue;
          }
        }
        paramString = paramString.iterator();
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.emoji.SuggestEmoticonBubble", bo.l(paramString));
        this.vZd = "";
        AppMethodBeat.o(62468);
        return false;
      }
      label286:
      while (paramString.hasNext())
      {
        localObject = (EmojiInfo)paramString.next();
        if (!this.lnB.contains(localObject)) {
          this.lnB.add(localObject);
        }
      }
      label336:
      if ((this.lnB == null) || (this.lnB.isEmpty()))
      {
        AppMethodBeat.o(62468);
        return false;
      }
      AppMethodBeat.o(62468);
      return true;
      label367:
      i += 1;
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(62467);
    if (this.vZa == null)
    {
      AppMethodBeat.o(62467);
      return;
    }
    if (this.vZa.isShowing()) {
      this.vZa.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(62467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */