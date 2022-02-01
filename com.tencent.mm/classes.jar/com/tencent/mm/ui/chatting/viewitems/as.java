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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class as
  extends c
{
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493569);
      ((View)localObject).setTag(new a().he((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37305);
    this.PhN = parama1;
    a locala = (a)parama;
    Object localObject1 = ao.gnf().GL(paramca.field_msgId);
    Object localObject2 = paramca.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.aD((String)localObject2, paramca.field_reserved);
    }
    for (;;)
    {
      bq localbq = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.clickArea;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.dDG == 1) || (paramString.ixF == 1))) {
        if (Util.isNullOrNil(paramString.ixA))
        {
          localObject2 = paramString.ixw;
          Object localObject3 = paramString.ixx;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            paramca = (ca)localObject2;
            if (!Util.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            Log.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            paramca = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(paramca));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          paramca = new ColorDrawable(Color.parseColor(paramca));
          ((StateListDrawable)localObject2).addState(new int[0], paramca);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.ixA = "#ffffff";
          paramca = paramString.ixy;
          localObject1 = paramString.ixz;
          j = 2131101424;
          k = 2131101424;
          i = k;
          paramInt = j;
          if (!Util.isNullOrNil(paramca))
          {
            i = k;
            paramInt = j;
            if (!Util.isNullOrNil((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(paramca);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        paramca = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        paramca.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        paramca.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        paramca.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        paramca.addState(new int[0], (Drawable)localObject1);
        locala.PNX.setBackgroundDrawable(paramca);
        paramca = paramString.ixA;
        if (locala != null)
        {
          i = 2131101424;
          paramInt = i;
          if (Util.isNullOrNil(paramca)) {}
        }
      }
      catch (IllegalArgumentException paramca)
      {
        try
        {
          paramInt = Color.parseColor(paramca);
          locala.PNU.setTextColor(paramInt);
          locala.PNV.setTextColor(paramInt);
          locala.PNS.setTextColor(paramInt);
          locala.PNT.setTextColor(paramInt);
          locala.PNW.setTextColor(paramInt);
          locala.PNU.setText(paramString.ixs);
          locala.PNV.setText(paramString.ixq);
          locala.PNS.setText(paramString.ixu);
          locala.PNT.setText(paramString.ixt);
          locala.PNW.setText(paramString.ixv);
          if (!Util.isNullOrNil(paramString.ixB))
          {
            locala.PNY.setVisibility(0);
            a.b.z(locala.PNY, paramString.ixB);
            parama.clickArea.setOnLongClickListener(c(parama1));
            parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
            parama.clickArea.setTag(localbq);
            parama.clickArea.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              Log.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(paramca.field_msgId), paramString });
              paramString = null;
              break;
            }
            paramca = paramca;
            Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException paramca)
        {
          for (;;)
          {
            Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.PNY.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233907);
    paramm.a(((bq)paramView.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    AppMethodBeat.o(233907);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = paramca.field_content;
    paramView = k.b.aD(str, paramca.field_reserved);
    if (paramView == null)
    {
      Log.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    Log.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!Util.isNullOrNil(paramView.url))
    {
      paramca = new Intent();
      paramca.putExtra("rawUrl", paramView.url);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!Util.isNullOrNil(paramView.ixr))
    {
      int j = paramView.ixH;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", paramca.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.ixC);
        localIntent.putExtra("key_champion_info", paramView.ixD);
        localIntent.putExtra("key_champion_coverimg", paramView.ixD);
        localIntent.putExtra("rank_id", paramView.ixr);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.ixG);
        localIntent.putExtra("key_champioin_username", paramView.ixB);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.c.pl(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      com.tencent.mm.br.c.V(parama.Pwc.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView PNS;
    protected TextView PNT;
    protected TextView PNU;
    protected TextView PNV;
    protected TextView PNW;
    protected TextView PNX;
    protected ImageView PNY;
    
    a() {}
    
    public final a he(View paramView)
    {
      AppMethodBeat.i(37303);
      super.create(paramView);
      this.PNS = ((TextView)paramView.findViewById(2131308414));
      this.PNU = ((TextView)paramView.findViewById(2131306508));
      this.PNT = ((TextView)paramView.findViewById(2131308415));
      this.PNV = ((TextView)paramView.findViewById(2131306509));
      this.PNW = ((TextView)paramView.findViewById(2131309867));
      this.PNX = ((TextView)paramView.findViewById(2131302246));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.PNY = ((ImageView)paramView.findViewById(2131309857));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */