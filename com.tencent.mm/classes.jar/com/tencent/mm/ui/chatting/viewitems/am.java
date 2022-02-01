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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class am
  extends c
{
  private a JWz;
  
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
      ((View)localObject).setTag(new a().gO((View)localObject));
    }
    AppMethodBeat.o(37304);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37305);
    this.JWz = parama1;
    a locala = (a)parama;
    Object localObject1 = ao.fdU().yb(parambv.field_msgId);
    Object localObject2 = parambv.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = k.b.aB((String)localObject2, parambv.field_reserved);
    }
    for (;;)
    {
      bk localbk = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.olI;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.dmr == 1) || (paramString.hDA == 1))) {
        if (bu.isNullOrNil(paramString.hDv))
        {
          localObject2 = paramString.hDr;
          Object localObject3 = paramString.hDs;
          if (!bu.isNullOrNil((String)localObject2))
          {
            localObject1 = localObject3;
            parambv = (bv)localObject2;
            if (!bu.isNullOrNil((String)localObject3)) {}
          }
          else
          {
            ae.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambv = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambv));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambv = new ColorDrawable(Color.parseColor(parambv));
          ((StateListDrawable)localObject2).addState(new int[0], parambv);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.hDv = "#ffffff";
          parambv = paramString.hDt;
          localObject1 = paramString.hDu;
          j = 2131101179;
          k = 2131101179;
          i = k;
          paramInt = j;
          if (!bu.isNullOrNil(parambv))
          {
            i = k;
            paramInt = j;
            if (!bu.isNullOrNil((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(parambv);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambv = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambv.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambv.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambv.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambv.addState(new int[0], (Drawable)localObject1);
        locala.KBp.setBackgroundDrawable(parambv);
        parambv = paramString.hDv;
        if (locala != null)
        {
          i = 2131101179;
          paramInt = i;
          if (bu.isNullOrNil(parambv)) {}
        }
      }
      catch (IllegalArgumentException parambv)
      {
        try
        {
          paramInt = Color.parseColor(parambv);
          locala.KBm.setTextColor(paramInt);
          locala.KBn.setTextColor(paramInt);
          locala.KBk.setTextColor(paramInt);
          locala.KBl.setTextColor(paramInt);
          locala.KBo.setTextColor(paramInt);
          locala.KBm.setText(paramString.hDn);
          locala.KBn.setText(paramString.hDl);
          locala.KBk.setText(paramString.hDp);
          locala.KBl.setText(paramString.hDo);
          locala.KBo.setText(paramString.hDq);
          if (!bu.isNullOrNil(paramString.hDw))
          {
            locala.KBq.setVisibility(0);
            a.b.v(locala.KBq, paramString.hDw);
            parama.olI.setOnLongClickListener(c(parama1));
            parama.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
            parama.olI.setTag(localbk);
            parama.olI.setOnClickListener(d(parama1));
            AppMethodBeat.o(37305);
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              ae.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambv.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambv = parambv;
            ae.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambv)
        {
          for (;;)
          {
            ae.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.KBq.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37307);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37307);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187877);
    paraml.a(((bk)paramView.getTag()).position, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(187877);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    int i = 0;
    AppMethodBeat.i(37308);
    String str = parambv.field_content;
    paramView = k.b.aB(str, parambv.field_reserved);
    if (paramView == null)
    {
      ae.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      AppMethodBeat.o(37308);
      return false;
    }
    ae.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bu.isNullOrNil(paramView.url))
    {
      parambv = new Intent();
      parambv.putExtra("rawUrl", paramView.url);
      d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
      AppMethodBeat.o(37308);
      return true;
    }
    if (!bu.isNullOrNil(paramView.hDm))
    {
      int j = paramView.hDC;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambv.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.hDx);
        localIntent.putExtra("key_champion_info", paramView.hDy);
        localIntent.putExtra("key_champion_coverimg", paramView.hDy);
        localIntent.putExtra("rank_id", paramView.hDm);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.hDB);
        localIntent.putExtra("key_champioin_username", paramView.hDw);
        d.b(parama.Kkd.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.a.c.md(28);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37308);
      return true;
      d.Q(parama.Kkd.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048185;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected TextView KBk;
    protected TextView KBl;
    protected TextView KBm;
    protected TextView KBn;
    protected TextView KBo;
    protected TextView KBp;
    protected ImageView KBq;
    
    a() {}
    
    public final a gO(View paramView)
    {
      AppMethodBeat.i(37303);
      super.gs(paramView);
      this.KBk = ((TextView)paramView.findViewById(2131305216));
      this.KBm = ((TextView)paramView.findViewById(2131303722));
      this.KBl = ((TextView)paramView.findViewById(2131305217));
      this.KBn = ((TextView)paramView.findViewById(2131303723));
      this.KBo = ((TextView)paramView.findViewById(2131306435));
      this.KBp = ((TextView)paramView.findViewById(2131300677));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.KBq = ((ImageView)paramView.findViewById(2131306425));
      AppMethodBeat.o(37303);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */