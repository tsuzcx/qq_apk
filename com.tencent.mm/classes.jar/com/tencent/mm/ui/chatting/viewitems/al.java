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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class al
  extends c
{
  private a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493467);
      ((View)localObject).setTag(new a().gs((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37305);
    this.HNS = parama1;
    a locala = (a)parama;
    Object localObject1 = ap.eLl().zN(parambo.field_msgId);
    Object localObject2 = parambo.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.az((String)localObject2, parambo.field_reserved);
    }
    for (;;)
    {
      bj localbj = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.nDl;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.cZX == 1) || (paramString.hiD == 1))) {
        if (bs.isNullOrNil(paramString.hiy))
        {
          localObject2 = paramString.hiu;
          Object localObject3 = paramString.hiv;
          if (!bs.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            parambo = (bo)localObject2;
            if (!bs.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            ac.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambo = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambo));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambo = new ColorDrawable(Color.parseColor(parambo));
          ((StateListDrawable)localObject2).addState(new int[0], parambo);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.hiy = "#ffffff";
          parambo = paramString.hiw;
          localObject1 = paramString.hix;
          j = 2131101179;
          k = 2131101179;
          i = k;
          paramInt = j;
          if (!bs.isNullOrNil(parambo))
          {
            i = k;
            paramInt = j;
            if (!bs.isNullOrNil((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(parambo);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambo = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambo.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambo.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambo.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambo.addState(new int[0], (Drawable)localObject1);
        locala.Iow.setBackgroundDrawable(parambo);
        parambo = paramString.hiy;
        if (locala != null)
        {
          i = 2131101179;
          paramInt = i;
          if (bs.isNullOrNil(parambo)) {}
        }
      }
      catch (IllegalArgumentException parambo)
      {
        try
        {
          paramInt = Color.parseColor(parambo);
          locala.Iot.setTextColor(paramInt);
          locala.Iou.setTextColor(paramInt);
          locala.Ior.setTextColor(paramInt);
          locala.Ios.setTextColor(paramInt);
          locala.Iov.setTextColor(paramInt);
          locala.Iot.setText(paramString.hiq);
          locala.Iou.setText(paramString.hio);
          locala.Ior.setText(paramString.his);
          locala.Ios.setText(paramString.hir);
          locala.Iov.setText(paramString.hit);
          if (!bs.isNullOrNil(paramString.hiz))
          {
            locala.Iox.setVisibility(0);
            a.b.v(locala.Iox, paramString.hiz);
            parama.nDl.setOnLongClickListener(c(parama1));
            parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
            parama.nDl.setTag(localbj);
            parama.nDl.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              ac.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambo.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambo = parambo;
            ac.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambo)
        {
          for (;;)
          {
            ac.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.Iox.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37306);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    AppMethodBeat.o(37306);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = parambo.field_content;
    paramView = k.b.az(str, parambo.field_reserved);
    if (paramView == null)
    {
      ac.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    ac.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bs.isNullOrNil(paramView.url))
    {
      parambo = new Intent();
      parambo.putExtra("rawUrl", paramView.url);
      d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!bs.isNullOrNil(paramView.hip))
    {
      int j = paramView.hiF;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambo.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.hiA);
        localIntent.putExtra("key_champion_info", paramView.hiB);
        localIntent.putExtra("key_champion_coverimg", paramView.hiB);
        localIntent.putExtra("rank_id", paramView.hip);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.hiE);
        localIntent.putExtra("key_champioin_username", paramView.hiz);
        d.b(parama.HZF.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.c.lA(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      d.N(parama.HZF.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView Ior;
    protected TextView Ios;
    protected TextView Iot;
    protected TextView Iou;
    protected TextView Iov;
    protected TextView Iow;
    protected ImageView Iox;
    
    a() {}
    
    public final a gs(View paramView)
    {
      AppMethodBeat.i(37303);
      super.fX(paramView);
      this.Ior = ((TextView)paramView.findViewById(2131305216));
      this.Iot = ((TextView)paramView.findViewById(2131303722));
      this.Ios = ((TextView)paramView.findViewById(2131305217));
      this.Iou = ((TextView)paramView.findViewById(2131303723));
      this.Iov = ((TextView)paramView.findViewById(2131306435));
      this.Iow = ((TextView)paramView.findViewById(2131300677));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.Iox = ((ImageView)paramView.findViewById(2131306425));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al
 * JD-Core Version:    0.7.0.1
 */