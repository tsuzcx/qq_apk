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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class aw
  extends c
{
  private a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edy);
      ((View)localObject).setTag(new a().iq((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37305);
    this.WBq = parama1;
    a locala = (a)parama;
    Object localObject1 = ao.hhH().NR(paramca.field_msgId);
    Object localObject2 = paramca.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.aG((String)localObject2, paramca.field_reserved);
    }
    for (;;)
    {
      by localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.clickArea;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.fwp == 1) || (paramString.lmU == 1))) {
        if (Util.isNullOrNil(paramString.lmP))
        {
          localObject2 = paramString.lmL;
          Object localObject3 = paramString.lmM;
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
          paramString.lmP = "#ffffff";
          paramca = paramString.lmN;
          localObject1 = paramString.lmO;
          j = R.e.white;
          k = R.e.white;
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
        locala.XjZ.setBackgroundDrawable(paramca);
        paramca = paramString.lmP;
        if (locala != null)
        {
          i = R.e.white;
          paramInt = i;
          if (Util.isNullOrNil(paramca)) {}
        }
      }
      catch (IllegalArgumentException paramca)
      {
        try
        {
          paramInt = Color.parseColor(paramca);
          locala.XjW.setTextColor(paramInt);
          locala.XjX.setTextColor(paramInt);
          locala.XjU.setTextColor(paramInt);
          locala.XjV.setTextColor(paramInt);
          locala.XjY.setTextColor(paramInt);
          locala.XjW.setText(paramString.lmH);
          locala.XjX.setText(paramString.lmF);
          locala.XjU.setText(paramString.lmJ);
          locala.XjV.setText(paramString.lmI);
          locala.XjY.setText(paramString.lmK);
          if (!Util.isNullOrNil(paramString.lmQ))
          {
            locala.Xka.setVisibility(0);
            a.b.B(locala.Xka, paramString.lmQ);
            parama.clickArea.setOnLongClickListener(c(parama1));
            parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama.clickArea.setTag(localby);
            parama.clickArea.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              Log.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), Util.secPrint((String)localObject2), Long.valueOf(paramca.field_msgId), paramString });
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
            locala.Xka.setVisibility(8);
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
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(278367);
    paramo.a(((by)paramView.getTag()).position, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(278367);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = paramca.field_content;
    paramView = k.b.aG(str, paramca.field_reserved);
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
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!Util.isNullOrNil(paramView.lmG))
    {
      int j = paramView.lmW;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", paramca.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.lmR);
        localIntent.putExtra("key_champion_info", paramView.lmS);
        localIntent.putExtra("key_champion_coverimg", paramView.lmS);
        localIntent.putExtra("rank_id", paramView.lmG);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.lmV);
        localIntent.putExtra("key_champioin_username", paramView.lmQ);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        d.rE(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      com.tencent.mm.by.c.ad(parama.WQv.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView XjU;
    protected TextView XjV;
    protected TextView XjW;
    protected TextView XjX;
    protected TextView XjY;
    protected TextView XjZ;
    protected ImageView Xka;
    
    a() {}
    
    public final a iq(View paramView)
    {
      AppMethodBeat.i(37303);
      super.create(paramView);
      this.XjU = ((TextView)paramView.findViewById(R.h.dVL));
      this.XjW = ((TextView)paramView.findViewById(R.h.dSa));
      this.XjV = ((TextView)paramView.findViewById(R.h.dVM));
      this.XjX = ((TextView)paramView.findViewById(R.h.dSb));
      this.XjY = ((TextView)paramView.findViewById(R.h.dZh));
      this.XjZ = ((TextView)paramView.findViewById(R.h.dIq));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.Xka = ((ImageView)paramView.findViewById(R.h.dZe));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw
 * JD-Core Version:    0.7.0.1
 */