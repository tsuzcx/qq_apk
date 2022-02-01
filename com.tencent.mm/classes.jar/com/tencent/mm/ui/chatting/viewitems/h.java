package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class h
{
  static final class a
    extends c.a
  {
    public ImageView XeS;
    public TextView XeT;
    public TextView XeU;
    public TextView XeV;
    public int Xev = 0;
    public int Xfa = 0;
    public int maxSize = 0;
    
    public final a hZ(View paramView)
    {
      AppMethodBeat.i(282923);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
      this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.dwZ));
      this.maskView = this.convertView.findViewById(R.h.dyD);
      this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
      this.XeS = ((ImageView)this.convertView.findViewById(R.h.drA));
      this.XeT = ((TextView)this.convertView.findViewById(R.h.drG));
      this.XeU = ((TextView)this.convertView.findViewById(R.h.dry));
      this.XeV = ((TextView)this.convertView.findViewById(R.h.drK));
      this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
      this.Xev = c.lj(MMApplicationContext.getContext());
      this.Xfa = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize);
      this.maxSize = ((int)(com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
      AppMethodBeat.o(282923);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(287426);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecI);
        ((View)localObject).setTag(new h.a().hZ((View)localObject));
      }
      AppMethodBeat.o(287426);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(287427);
      this.WBq = parama1;
      h.a locala = (h.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aG(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.aj.b localb;
        label193:
        long l;
        if (localObject != null)
        {
          h.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CNewFrom", false, locala);
          locala.XeT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          localb = (com.tencent.mm.aj.b)((k.b)localObject).ar(com.tencent.mm.aj.b.class);
          if (paramca.field_isSend != 1) {
            break label538;
          }
          paramString = localb.lkL;
          if (!Util.isNullOrNil(paramString)) {
            break label548;
          }
          paramString = ((k.b)localObject).description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!ar.isDarkMode()) {
            break label560;
          }
          l = Util.getLong(localb.lkX, -1L);
          if (l >= 0L) {
            locala.XeT.setTextColor((int)l);
          }
          label270:
          localObject = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label594;
          }
          paramString = localb.lkP;
          label293:
          ((TextView)localObject).setText(paramString);
          if (!ar.isDarkMode()) {
            break label604;
          }
          l = Util.getLong(localb.lkY, -1L);
          if (l >= 0L) {
            locala.XeU.setTextColor((int)l);
          }
          label337:
          localObject = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label638;
          }
          paramString = localb.lkN;
          label360:
          ((TextView)localObject).setText(paramString);
          locala.XeS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.lkF))
          {
            if (!localb.lkF.startsWith("http")) {
              break label648;
            }
            paramString = new com.tencent.mm.ay.a.a.c.a();
            bh.beI();
            paramString.prefixPath = com.tencent.mm.model.c.bbX();
            paramString.lRD = true;
            paramString.kOl = true;
            paramString = paramString.bmL();
            q.bml().a(localb.lkF, locala.XeS, paramString);
          }
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama1 = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(287427);
          return;
          label538:
          paramString = localb.lkK;
          break;
          label548:
          locala.XeT.setSingleLine(true);
          break label193;
          label560:
          l = Util.getLong(localb.lkM, -1L);
          if (l < 0L) {
            break label270;
          }
          locala.XeT.setTextColor((int)l);
          break label270;
          label594:
          paramString = localb.lkQ;
          break label293;
          label604:
          l = Util.getLong(localb.lkR, -1L);
          if (l < 0L) {
            break label337;
          }
          locala.XeU.setTextColor((int)l);
          break label337;
          label638:
          paramString = localb.lkO;
          break label360;
          label648:
          int i = MMApplicationContext.getResources().getIdentifier(localb.lkF, "drawable", MMApplicationContext.getPackageName());
          if (i > 0) {
            locala.XeS.setImageResource(i);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(287429);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(287429);
        return false;
      }
      AppMethodBeat.o(287429);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(287428);
      paramo.a(((by)paramView.getTag()).position, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      AppMethodBeat.o(287428);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536936497);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(287430);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      if (paramView != null) {
        if (!Util.isNullOrNil(paramView.lny)) {
          break label115;
        }
      }
      label115:
      for (paramView = paramView.url;; paramView = paramView.lny)
      {
        if (!Util.isNullOrNil(paramView))
        {
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramView);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
        }
        AppMethodBeat.o(287430);
        return true;
      }
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(216529);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edJ);
        ((View)localObject).setTag(new h.a().hZ((View)localObject));
      }
      AppMethodBeat.o(216529);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(216534);
      this.WBq = parama1;
      h.a locala = (h.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aG(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.aj.b localb;
        label193:
        long l;
        if (localObject != null)
        {
          h.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CNewTo", true, locala);
          locala.XeT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          localb = (com.tencent.mm.aj.b)((k.b)localObject).ar(com.tencent.mm.aj.b.class);
          if (paramca.field_isSend != 1) {
            break label538;
          }
          paramString = localb.lkL;
          if (!Util.isNullOrNil(paramString)) {
            break label548;
          }
          paramString = ((k.b)localObject).description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!ar.isDarkMode()) {
            break label560;
          }
          l = Util.getLong(localb.lkX, -1L);
          if (l >= 0L) {
            locala.XeT.setTextColor((int)l);
          }
          label270:
          localObject = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label594;
          }
          paramString = localb.lkP;
          label293:
          ((TextView)localObject).setText(paramString);
          if (!ar.isDarkMode()) {
            break label604;
          }
          l = Util.getLong(localb.lkY, -1L);
          if (l >= 0L) {
            locala.XeU.setTextColor((int)l);
          }
          label337:
          localObject = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label638;
          }
          paramString = localb.lkN;
          label360:
          ((TextView)localObject).setText(paramString);
          locala.XeS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.lkF))
          {
            if (!localb.lkF.startsWith("http")) {
              break label648;
            }
            paramString = new com.tencent.mm.ay.a.a.c.a();
            bh.beI();
            paramString.prefixPath = com.tencent.mm.model.c.bbX();
            paramString.lRD = true;
            paramString.kOl = true;
            paramString = paramString.bmL();
            q.bml().a(localb.lkF, locala.XeS, paramString);
          }
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama1 = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(216534);
          return;
          label538:
          paramString = localb.lkK;
          break;
          label548:
          locala.XeT.setSingleLine(true);
          break label193;
          label560:
          l = Util.getLong(localb.lkM, -1L);
          if (l < 0L) {
            break label270;
          }
          locala.XeT.setTextColor((int)l);
          break label270;
          label594:
          paramString = localb.lkQ;
          break label293;
          label604:
          l = Util.getLong(localb.lkR, -1L);
          if (l < 0L) {
            break label337;
          }
          locala.XeU.setTextColor((int)l);
          break label337;
          label638:
          paramString = localb.lkO;
          break label360;
          label648:
          int i = MMApplicationContext.getResources().getIdentifier(localb.lkF, "drawable", MMApplicationContext.getPackageName());
          if (i > 0) {
            locala.XeS.setImageResource(i);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(216538);
      paramMenuItem.getItemId();
      AppMethodBeat.o(216538);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(216536);
      int i = ((by)paramView.getTag()).position;
      if (bs.D(paramca)) {
        paramo.clear();
      }
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      AppMethodBeat.o(216536);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536936497);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(216539);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      if (paramView != null) {
        if (!Util.isNullOrNil(paramView.lny)) {
          break label115;
        }
      }
      label115:
      for (paramView = paramView.url;; paramView = paramView.lny)
      {
        if (!Util.isNullOrNil(paramView))
        {
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramView);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
        }
        AppMethodBeat.o(216539);
        return true;
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h
 * JD-Core Version:    0.7.0.1
 */