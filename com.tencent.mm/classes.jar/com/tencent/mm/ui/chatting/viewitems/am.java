package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class am
  extends c
{
  private a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37304);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493467);
      ((View)localObject).setTag(new a().gJ((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37305);
    this.JBI = parama1;
    a locala = (a)parama;
    Object localObject1 = ao.fag().xH(parambu.field_msgId);
    Object localObject2 = parambu.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.aA((String)localObject2, parambu.field_reserved);
    }
    for (;;)
    {
      bk localbk = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.ofK;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.dlp == 1) || (paramString.hAM == 1))) {
        if (bt.isNullOrNil(paramString.hAH))
        {
          localObject2 = paramString.hAD;
          Object localObject3 = paramString.hAE;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            parambu = (bu)localObject2;
            if (!bt.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            ad.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambu = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambu));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambu = new ColorDrawable(Color.parseColor(parambu));
          ((StateListDrawable)localObject2).addState(new int[0], parambu);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.hAH = "#ffffff";
          parambu = paramString.hAF;
          localObject1 = paramString.hAG;
          j = 2131101179;
          k = 2131101179;
          i = k;
          paramInt = j;
          if (!bt.isNullOrNil(parambu))
          {
            i = k;
            paramInt = j;
            if (!bt.isNullOrNil((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(parambu);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambu = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambu.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambu.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambu.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambu.addState(new int[0], (Drawable)localObject1);
        locala.KeW.setBackgroundDrawable(parambu);
        parambu = paramString.hAH;
        if (locala != null)
        {
          i = 2131101179;
          paramInt = i;
          if (bt.isNullOrNil(parambu)) {}
        }
      }
      catch (IllegalArgumentException parambu)
      {
        try
        {
          paramInt = Color.parseColor(parambu);
          locala.KeT.setTextColor(paramInt);
          locala.KeU.setTextColor(paramInt);
          locala.KeR.setTextColor(paramInt);
          locala.KeS.setTextColor(paramInt);
          locala.KeV.setTextColor(paramInt);
          locala.KeT.setText(paramString.hAz);
          locala.KeU.setText(paramString.hAx);
          locala.KeR.setText(paramString.hAB);
          locala.KeS.setText(paramString.hAA);
          locala.KeV.setText(paramString.hAC);
          if (!bt.isNullOrNil(paramString.hAI))
          {
            locala.KeX.setVisibility(0);
            a.b.v(locala.KeX, paramString.hAI);
            parama.ofK.setOnLongClickListener(c(parama1));
            parama.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
            parama.ofK.setTag(localbk);
            parama.ofK.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              ad.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambu.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambu = parambu;
            ad.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambu)
        {
          for (;;)
          {
            ad.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.KeX.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194482);
    paraml.a(((bk)paramView.getTag()).position, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(194482);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = parambu.field_content;
    paramView = k.b.aA(str, parambu.field_reserved);
    if (paramView == null)
    {
      ad.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    ad.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bt.isNullOrNil(paramView.url))
    {
      parambu = new Intent();
      parambu.putExtra("rawUrl", paramView.url);
      d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!bt.isNullOrNil(paramView.hAy))
    {
      int j = paramView.hAO;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambu.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.hAJ);
        localIntent.putExtra("key_champion_info", paramView.hAK);
        localIntent.putExtra("key_champion_coverimg", paramView.hAK);
        localIntent.putExtra("rank_id", paramView.hAy);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.hAN);
        localIntent.putExtra("key_champioin_username", paramView.hAI);
        d.b(parama.JOR.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.c.ma(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      d.Q(parama.JOR.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView KeR;
    protected TextView KeS;
    protected TextView KeT;
    protected TextView KeU;
    protected TextView KeV;
    protected TextView KeW;
    protected ImageView KeX;
    
    a() {}
    
    public final a gJ(View paramView)
    {
      AppMethodBeat.i(37303);
      super.gn(paramView);
      this.KeR = ((TextView)paramView.findViewById(2131305216));
      this.KeT = ((TextView)paramView.findViewById(2131303722));
      this.KeS = ((TextView)paramView.findViewById(2131305217));
      this.KeU = ((TextView)paramView.findViewById(2131303723));
      this.KeV = ((TextView)paramView.findViewById(2131306435));
      this.KeW = ((TextView)paramView.findViewById(2131300677));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.KeX = ((ImageView)paramView.findViewById(2131306425));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */