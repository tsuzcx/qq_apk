package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class g
{
  static Drawable aL(Bitmap paramBitmap)
  {
    AppMethodBeat.i(36873);
    Object localObject = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk((byte[])localObject))
    {
      localObject = new NinePatchDrawable(MMApplicationContext.getResources(), paramBitmap, (byte[])localObject, new Rect(), null);
      ((NinePatchDrawable)localObject).setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      AppMethodBeat.o(36873);
      return localObject;
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    AppMethodBeat.o(36873);
    return paramBitmap;
  }
  
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
    
    public final a hY(View paramView)
    {
      AppMethodBeat.i(36861);
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
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36862);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecH);
        ((View)localObject).setTag(new g.a().hY((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36863);
      this.WBq = parama1;
      g.a locala = (g.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aG(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.aj.b localb;
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.XeT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          localb = (com.tencent.mm.aj.b)((k.b)localObject).ar(com.tencent.mm.aj.b.class);
          if (paramca.field_isSend != 1) {
            break label503;
          }
          paramString = localb.lkL;
          if (!Util.isNullOrNil(paramString)) {
            break label513;
          }
          paramString = ((k.b)localObject).description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          label191:
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!Util.isNullOrNil(localb.lkM)) {
            locala.XeT.setTextColor(Color.parseColor(localb.lkM));
          }
          localObject = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label525;
          }
          paramString = localb.lkP;
          label281:
          ((TextView)localObject).setText(paramString);
          if (!Util.isNullOrNil(localb.lkR)) {
            locala.XeU.setTextColor(Color.parseColor(localb.lkR));
          }
          localObject = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label535;
          }
        }
        label513:
        label525:
        label535:
        for (paramString = localb.lkN;; paramString = localb.lkO)
        {
          ((TextView)localObject).setText(paramString);
          locala.XeS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.lkF))
          {
            paramString = new com.tencent.mm.ay.a.a.c.a();
            bh.beI();
            paramString.prefixPath = com.tencent.mm.model.c.bbX();
            paramString.lRD = true;
            paramString.kOl = true;
            paramString = paramString.bmL();
            q.bml().a(localb.lkF, locala.XeS, paramString);
          }
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          parama1 = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label503:
          paramString = localb.lkK;
          break;
          locala.XeT.setSingleLine(true);
          break label191;
          paramString = localb.lkQ;
          break label281;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36865);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36865);
        return false;
      }
      AppMethodBeat.o(36865);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(262473);
      paramo.a(((by)paramView.getTag()).position, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      AppMethodBeat.o(262473);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      String str = paramca.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.aG(str, paramca.field_reserved);
      }
      if (localObject != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramca = Uri.parse(((com.tencent.mm.aj.b)((k.b)localObject).ar(com.tencent.mm.aj.b.class)).lkE).getQueryParameter("cardNo");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_payer", false);
        ((Intent)localObject).putExtra("key_card_no", paramca);
        if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(paramView.getContext()))
        {
          AppMethodBeat.o(36866);
          return true;
        }
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", (Intent)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
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
      AppMethodBeat.i(36868);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edI);
        ((View)localObject).setTag(new g.a().hY((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36869);
      this.WBq = parama1;
      g.a locala = (g.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aG(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.aj.b localb;
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.XeT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.WQv.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          localb = (com.tencent.mm.aj.b)((k.b)localObject).ar(com.tencent.mm.aj.b.class);
          if (paramca.field_isSend != 1) {
            break label503;
          }
          paramString = localb.lkL;
          if (!Util.isNullOrNil(paramString)) {
            break label513;
          }
          paramString = ((k.b)localObject).description;
          locala.XeT.setSingleLine(false);
          locala.XeT.setMaxLines(3);
          label191:
          locala.XeT.setText(l.d(parama1.WQv.getContext(), paramString, locala.Xfa));
          locala.XeT.setTextSize(0, locala.Xfa);
          if (!Util.isNullOrNil(localb.lkM)) {
            locala.XeT.setTextColor(Color.parseColor(localb.lkM));
          }
          localObject = locala.XeU;
          if (paramca.field_isSend != 1) {
            break label525;
          }
          paramString = localb.lkP;
          label281:
          ((TextView)localObject).setText(paramString);
          if (!Util.isNullOrNil(localb.lkR)) {
            locala.XeU.setTextColor(Color.parseColor(localb.lkR));
          }
          localObject = locala.XeV;
          if (paramca.field_isSend != 1) {
            break label535;
          }
        }
        label513:
        label525:
        label535:
        for (paramString = localb.lkN;; paramString = localb.lkO)
        {
          ((TextView)localObject).setText(paramString);
          locala.XeS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.lkF))
          {
            paramString = new com.tencent.mm.ay.a.a.c.a();
            bh.beI();
            paramString.prefixPath = com.tencent.mm.model.c.bbX();
            paramString.lRD = true;
            paramString.kOl = true;
            paramString = paramString.bmL();
            q.bml().a(localb.lkF, locala.XeS, paramString);
          }
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          parama1 = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label503:
          paramString = localb.lkK;
          break;
          locala.XeT.setSingleLine(true);
          break label191;
          paramString = localb.lkQ;
          break label281;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      String str1 = paramca.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.aG(str1, paramca.field_reserved);
      }
      if (paramMenuItem != null)
      {
        paramca = paramca.field_talker;
        str1 = paramMenuItem.lnA;
        String str2 = paramMenuItem.lnB;
        String str3 = paramMenuItem.lnC;
        String str4 = paramMenuItem.lnD;
        String str5 = paramMenuItem.lny;
        String str6 = paramMenuItem.lnF;
        paramMenuItem = paramMenuItem.lnG;
        com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.ewI), parama.WQv.getMMResources().getString(R.l.app_remind), parama.WQv.getMMResources().getString(R.l.ewJ), parama.WQv.getMMResources().getString(R.l.app_cancel), new g.c.1(this, paramca, str1, str2, str3, str4, str5, str6, paramMenuItem, parama), new g.c.2(this));
      }
      AppMethodBeat.o(36871);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(290525);
      paramo.a(((by)paramView.getTag()).position, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      AppMethodBeat.o(290525);
      return false;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      if (paramView != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.aj.b)paramView.ar(com.tencent.mm.aj.b.class)).lkC).getQueryParameter("cardNo");
        paramca = new Intent();
        paramca.putExtra("key_is_payer", true);
        paramca.putExtra("key_card_no", paramView);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", paramca);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */