package com.tencent.mm.view.a;

import a.l;
import a.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/view/adapter/CaptureEmojiAdapter;", "Lcom/tencent/mm/view/adapter/BaseSmileyAdapter;", "context", "Landroid/content/Context;", "stg", "Lcom/tencent/mm/view/storage/SmileyPanelStg;", "(Landroid/content/Context;Lcom/tencent/mm/view/storage/SmileyPanelStg;)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "itemBgId", "", "canPreview", "", "position", "getCount", "getItem", "getItemId", "", "getRealPosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "update", "", "emoji", "Companion", "ViewHolder", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a ARS;
  ArrayList<EmojiInfo> ARQ;
  private final int ARR;
  
  static
  {
    AppMethodBeat.i(63334);
    ARS = new b.a((byte)0);
    AppMethodBeat.o(63334);
  }
  
  public b(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(63333);
    this.ARQ = new ArrayList();
    this.ARR = com.tencent.mm.emoji.e.a.A(paramContext, 2130771986);
    AppMethodBeat.o(63333);
  }
  
  private int RI(int paramInt)
  {
    return this.ARN * this.ARM + paramInt;
  }
  
  private EmojiInfo ur(int paramInt)
  {
    AppMethodBeat.i(63331);
    paramInt = RI(paramInt);
    Object localObject = this.AQU;
    a.f.b.j.p(localObject, "mSmileyPanelStg");
    if (((com.tencent.mm.view.f.a)localObject).dRH()) {
      paramInt -= 1;
    }
    for (;;)
    {
      localObject = (EmojiInfo)a.a.j.w((List)this.ARQ, paramInt);
      AppMethodBeat.o(63331);
      return localObject;
    }
  }
  
  public final int getCount()
  {
    if (this.ARN == this.AQK - 1)
    {
      int j = this.ejZ - this.ARN * this.ARM;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      return i;
    }
    return this.ARM;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63330);
    a.f.b.j.q(paramViewGroup, "parent");
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = paramView.getTag();
      if (localObject1 != null) {
        break label194;
      }
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969376, null);
      a.f.b.j.p(paramView, "LayoutInflater.from(pare…panel_item_capture, null)");
      paramViewGroup = this.AQU;
      a.f.b.j.p(paramViewGroup, "mSmileyPanelStg");
      int i = paramViewGroup.getColumnWidth();
      paramViewGroup = this.AQU;
      a.f.b.j.p(paramViewGroup, "mSmileyPanelStg");
      paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(i, paramViewGroup.dRs()));
      paramViewGroup = new b.b(this, paramView);
      paramView.setTag(paramViewGroup);
      label109:
      if ((this.ARN != 0) || (paramInt != 0)) {
        break label228;
      }
      localObject1 = this.AQU;
      a.f.b.j.p(localObject1, "mSmileyPanelStg");
      if (!((com.tencent.mm.view.f.a)localObject1).dRH()) {
        break label228;
      }
      paramViewGroup.ivs.setImageResource(2131231257);
      paramViewGroup.ivs.setContentDescription((CharSequence)paramViewGroup.ivs.getContext().getString(2131297849));
      paramViewGroup.ART.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(63330);
      return paramView;
      localObject1 = null;
      break;
      label194:
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.view.adapter.CaptureEmojiAdapter.ViewHolder");
        AppMethodBeat.o(63330);
        throw paramView;
      }
      paramViewGroup = (b.b)paramViewGroup;
      break label109;
      label228:
      localObject1 = ur(paramInt);
      if (localObject1 != null) {
        break label261;
      }
      paramViewGroup.ivs.setVisibility(8);
      paramViewGroup.ART.setVisibility(8);
    }
    label261:
    paramViewGroup.ivs.setVisibility(0);
    paramViewGroup.ivs.setBackgroundResource(this.ARR);
    Object localObject2 = ((EmojiInfo)localObject1).dzx();
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = com.tencent.mm.emoji.loader.a.evk;
      com.tencent.mm.emoji.loader.a.a((EmojiInfo)localObject1, paramViewGroup.ivs);
      break;
      switch (c.bLo[localObject2.ordinal()])
      {
      default: 
        break;
      case 1: 
        paramViewGroup.ART.setVisibility(8);
        break;
      case 2: 
      case 3: 
        paramViewGroup.ART.setVisibility(0);
        paramViewGroup.ARU.setVisibility(0);
        paramViewGroup.ARV.setVisibility(8);
        break;
      case 4: 
      case 5: 
        paramViewGroup.ART.setVisibility(0);
        paramViewGroup.ARU.setVisibility(8);
        paramViewGroup.ARV.setVisibility(0);
      }
    }
  }
  
  public final boolean uu(int paramInt)
  {
    AppMethodBeat.i(63329);
    com.tencent.mm.view.f.a locala = this.AQU;
    a.f.b.j.p(locala, "mSmileyPanelStg");
    if ((locala.dRH()) && ((this.AQI != 26) || (this.ARN != 0) || (paramInt != 0)))
    {
      AppMethodBeat.o(63329);
      return true;
    }
    AppMethodBeat.o(63329);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.b
 * JD-Core Version:    0.7.0.1
 */