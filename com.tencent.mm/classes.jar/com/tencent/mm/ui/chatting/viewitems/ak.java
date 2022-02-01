package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class ak
  extends c
{
  private a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493467);
      ((View)localObject).setTag(new a().gf((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37305);
    this.Gob = parama1;
    a locala = (a)parama;
    Object localObject1 = ap.evR().vk(parambl.field_msgId);
    Object localObject2 = parambl.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.ar((String)localObject2, parambl.field_reserved);
    }
    for (;;)
    {
      bi localbi = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.naN;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.dcz == 1) || (paramString.gIc == 1))) {
        if (bt.isNullOrNil(paramString.gHX))
        {
          localObject2 = paramString.gHT;
          Object localObject3 = paramString.gHU;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            parambl = (bl)localObject2;
            if (!bt.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            ad.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambl = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambl));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambl = new ColorDrawable(Color.parseColor(parambl));
          ((StateListDrawable)localObject2).addState(new int[0], parambl);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.gHX = "#ffffff";
          parambl = paramString.gHV;
          localObject1 = paramString.gHW;
          j = 2131101179;
          k = 2131101179;
          i = k;
          paramInt = j;
          if (!bt.isNullOrNil(parambl))
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
        i = Color.parseColor(parambl);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambl = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambl.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambl.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambl.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambl.addState(new int[0], (Drawable)localObject1);
        locala.GOu.setBackgroundDrawable(parambl);
        parambl = paramString.gHX;
        if (locala != null)
        {
          i = 2131101179;
          paramInt = i;
          if (bt.isNullOrNil(parambl)) {}
        }
      }
      catch (IllegalArgumentException parambl)
      {
        try
        {
          paramInt = Color.parseColor(parambl);
          locala.GOr.setTextColor(paramInt);
          locala.GOs.setTextColor(paramInt);
          locala.GOp.setTextColor(paramInt);
          locala.GOq.setTextColor(paramInt);
          locala.GOt.setTextColor(paramInt);
          locala.GOr.setText(paramString.gHP);
          locala.GOs.setText(paramString.gHN);
          locala.GOp.setText(paramString.gHR);
          locala.GOq.setText(paramString.gHQ);
          locala.GOt.setText(paramString.gHS);
          if (!bt.isNullOrNil(paramString.gHY))
          {
            locala.GOv.setVisibility(0);
            a.b.v(locala.GOv, paramString.gHY);
            parama.naN.setOnLongClickListener(c(parama1));
            parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
            parama.naN.setTag(localbi);
            parama.naN.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              ad.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambl.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambl = parambl;
            ad.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambl)
        {
          for (;;)
          {
            ad.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.GOv.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37306);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    AppMethodBeat.o(37306);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = parambl.field_content;
    paramView = k.b.ar(str, parambl.field_reserved);
    if (paramView == null)
    {
      ad.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    ad.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bt.isNullOrNil(paramView.url))
    {
      parambl = new Intent();
      parambl.putExtra("rawUrl", paramView.url);
      d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!bt.isNullOrNil(paramView.gHO))
    {
      int j = paramView.gIe;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambl.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.gHZ);
        localIntent.putExtra("key_champion_info", paramView.gIa);
        localIntent.putExtra("key_champion_coverimg", paramView.gIa);
        localIntent.putExtra("rank_id", paramView.gHO);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.gId);
        localIntent.putExtra("key_champioin_username", paramView.gHY);
        d.b(parama.GzJ.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.c.lI(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      d.O(parama.GzJ.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView GOp;
    protected TextView GOq;
    protected TextView GOr;
    protected TextView GOs;
    protected TextView GOt;
    protected TextView GOu;
    protected ImageView GOv;
    
    a() {}
    
    public final a gf(View paramView)
    {
      AppMethodBeat.i(37303);
      super.fK(paramView);
      this.GOp = ((TextView)paramView.findViewById(2131305216));
      this.GOr = ((TextView)paramView.findViewById(2131303722));
      this.GOq = ((TextView)paramView.findViewById(2131305217));
      this.GOs = ((TextView)paramView.findViewById(2131303723));
      this.GOt = ((TextView)paramView.findViewById(2131306435));
      this.GOu = ((TextView)paramView.findViewById(2131300677));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.GOv = ((ImageView)paramView.findViewById(2131306425));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak
 * JD-Core Version:    0.7.0.1
 */