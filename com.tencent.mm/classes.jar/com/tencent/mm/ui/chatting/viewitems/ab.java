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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

public final class ab
  extends c
{
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33213);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969094);
      ((View)localObject).setTag(new ab.a(this).fm((View)localObject));
    }
    AppMethodBeat.o(33213);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33214);
    this.zzP = parama1;
    ab.a locala = (ab.a)parama;
    Object localObject1 = al.dlL().nx(parambi.field_msgId);
    Object localObject2 = parambi.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = j.b.ab((String)localObject2, parambi.field_reserved);
    }
    for (;;)
    {
      az localaz = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.jYu;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.showType == 1) || (paramString.fhv == 1))) {
        if (ah.isNullOrNil(paramString.fhq))
        {
          localObject2 = paramString.color;
          Object localObject3 = paramString.fhn;
          if (!bo.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            parambi = (bi)localObject2;
            if (!bo.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambi = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambi));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambi = new ColorDrawable(Color.parseColor(parambi));
          ((StateListDrawable)localObject2).addState(new int[0], parambi);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.fhq = "#ffffff";
          parambi = paramString.fho;
          localObject1 = paramString.fhp;
          j = 2131690709;
          k = 2131690709;
          i = k;
          paramInt = j;
          if (!ah.isNullOrNil(parambi))
          {
            i = k;
            paramInt = j;
            if (!ah.isNullOrNil((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(parambi);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambi = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambi.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambi.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambi.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambi.addState(new int[0], (Drawable)localObject1);
        locala.zWd.setBackgroundDrawable(parambi);
        parambi = paramString.fhq;
        if (locala != null)
        {
          i = 2131690709;
          paramInt = i;
          if (ah.isNullOrNil(parambi)) {}
        }
      }
      catch (IllegalArgumentException parambi)
      {
        try
        {
          paramInt = Color.parseColor(parambi);
          locala.zWa.setTextColor(paramInt);
          locala.zWb.setTextColor(paramInt);
          locala.zVY.setTextColor(paramInt);
          locala.zVZ.setTextColor(paramInt);
          locala.zWc.setTextColor(paramInt);
          locala.zWa.setText(paramString.fhj);
          locala.zWb.setText(paramString.fhh);
          locala.zVY.setText(paramString.fhl);
          locala.zVZ.setText(paramString.fhk);
          locala.zWc.setText(paramString.fhm);
          if (!ah.isNullOrNil(paramString.fhr))
          {
            locala.zWe.setVisibility(0);
            a.b.t(locala.zWe, paramString.fhr);
            parama.jYu.setOnLongClickListener(c(parama1));
            parama.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
            parama.jYu.setTag(localaz);
            parama.jYu.setOnClickListener(d(parama1));
            AppMethodBeat.o(33214);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambi.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambi = parambi;
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambi)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.zWe.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33215);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(33215);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33216);
    paramMenuItem.getItemId();
    AppMethodBeat.o(33216);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    int i = 0;
    AppMethodBeat.i(33217);
    String str = parambi.field_content;
    paramView = j.b.ab(str, parambi.field_reserved);
    if (paramView == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(33217);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!ah.isNullOrNil(paramView.url))
    {
      parambi = new Intent();
      parambi.putExtra("rawUrl", paramView.url);
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
      AppMethodBeat.o(33217);
      return true;
    }
    if (!ah.isNullOrNil(paramView.fhi))
    {
      int j = paramView.fhx;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambi.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.fhs);
        localIntent.putExtra("key_champion_info", paramView.fht);
        localIntent.putExtra("key_champion_coverimg", paramView.fht);
        localIntent.putExtra("rank_id", paramView.fhi);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.fhw);
        localIntent.putExtra("key_champioin_username", paramView.fhr);
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.d.kS(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33217);
      return true;
      com.tencent.mm.bq.d.H(parama.zJz.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab
 * JD-Core Version:    0.7.0.1
 */