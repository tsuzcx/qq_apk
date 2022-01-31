package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public final class e
  extends a
{
  private int ARR;
  ArrayList<EmojiInfo> lnB;
  int scene;
  
  public e(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(62982);
    this.ARR = com.tencent.mm.emoji.e.a.A(paramContext, 2130771986);
    this.scene = parama.mScene;
    AppMethodBeat.o(62982);
  }
  
  private EmojiInfo ur(int paramInt)
  {
    AppMethodBeat.i(62983);
    int i = this.ARN * this.ARM + paramInt;
    paramInt = i;
    if (this.AQI == 25)
    {
      paramInt = i;
      if (com.tencent.mm.view.f.a.RS(this.AQU.mScene)) {
        paramInt = i - 1;
      }
    }
    if ((this.lnB == null) || (paramInt < 0) || (paramInt >= this.lnB.size()))
    {
      AppMethodBeat.o(62983);
      return null;
    }
    EmojiInfo localEmojiInfo = (EmojiInfo)this.lnB.get(paramInt);
    AppMethodBeat.o(62983);
    return localEmojiInfo;
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
    AppMethodBeat.i(62985);
    Object localObject1;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970760, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.AQU.getColumnWidth(), this.AQU.AUK));
      paramViewGroup = new e.a(this, paramView);
      paramView.setTag(paramViewGroup);
      if ((this.AQI != 25) || (this.ARN != 0) || (paramInt != 0) || (!com.tencent.mm.view.f.a.RS(this.AQU.mScene))) {
        break label254;
      }
      paramViewGroup.ivs.setImageResource(2131231258);
      paramViewGroup.ivs.setContentDescription(paramView.getContext().getString(2131303244));
      int i = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().y(false, true);
      com.tencent.mm.ca.a.dqM();
      localObject1 = com.tencent.mm.ca.a.yiI;
      if (!((h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
        break label230;
      }
      paramInt = bo.getInt(com.tencent.mm.m.g.Nq().getValue("CustomEmojiMaxSize"), 300);
      label189:
      if (i <= paramInt) {
        break label242;
      }
      paramViewGroup.ARY.setVisibility(0);
      paramViewGroup.ARY.setText(2131299156);
    }
    for (;;)
    {
      AppMethodBeat.o(62985);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
      break;
      label230:
      paramInt = ((a.c)localObject1).getInt("EmotionRecommandCount", 3);
      break label189;
      label242:
      paramViewGroup.ARY.setVisibility(8);
      continue;
      label254:
      paramViewGroup.ARY.setVisibility(8);
      localObject1 = ur(paramInt);
      if (localObject1 != null) {
        break label311;
      }
      ab.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
      paramViewGroup.ivs.setVisibility(8);
      paramViewGroup.gpM.setVisibility(8);
      paramViewGroup.ivs.setImageDrawable(null);
    }
    label311:
    paramViewGroup.ivs.setVisibility(0);
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().Kx(((EmojiInfo)localObject1).Al());
    if ((!bo.isNullOrNil((String)localObject2)) && (this.AQI == 23))
    {
      paramViewGroup.gpM.setText((CharSequence)localObject2);
      paramViewGroup.gpM.setVisibility(0);
      label378:
      paramViewGroup.ivs.setBackgroundResource(this.ARR);
      if (this.AQI == 25)
      {
        if ((((EmojiInfo)localObject1).field_catalog != EmojiGroupInfo.yPe) && (((EmojiInfo)localObject1).field_catalog != EmojiInfo.yPl) && (((EmojiInfo)localObject1).field_catalog != EmojiInfo.yPk)) {
          break label546;
        }
        localObject2 = ((EmojiInfo)localObject1).getName();
        if (bo.isNullOrNil((String)localObject2)) {
          break label535;
        }
        if (!((String)localObject2).equalsIgnoreCase("dice")) {
          break label504;
        }
        paramViewGroup.ivs.setContentDescription(paramView.getContext().getString(2131299139));
      }
    }
    label535:
    label546:
    for (;;)
    {
      localObject2 = com.tencent.mm.emoji.loader.a.evk;
      com.tencent.mm.emoji.loader.a.a((EmojiInfo)localObject1, paramViewGroup.ivs);
      break;
      paramViewGroup.gpM.setVisibility(8);
      break label378;
      label504:
      if (((String)localObject2).equalsIgnoreCase("jsb"))
      {
        paramViewGroup.ivs.setContentDescription(paramView.getContext().getString(2131299148));
        continue;
        ab.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
        continue;
        localObject2 = ((EmojiInfo)localObject1).dzx();
        switch (e.1.AQP[localObject2.ordinal()])
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
  }
  
  public final boolean uu(int paramInt)
  {
    AppMethodBeat.i(62984);
    if ((com.tencent.mm.view.f.a.RS(this.AQU.mScene)) && ((this.AQI != 25) || (this.ARN != 0) || (paramInt != 0)))
    {
      AppMethodBeat.o(62984);
      return true;
    }
    AppMethodBeat.o(62984);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.a.e
 * JD-Core Version:    0.7.0.1
 */