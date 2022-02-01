package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class g
{
  static Drawable aG(Bitmap paramBitmap)
  {
    AppMethodBeat.i(36873);
    Object localObject = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk((byte[])localObject))
    {
      localObject = new NinePatchDrawable(ai.getResources(), paramBitmap, (byte[])localObject, new Rect(), null);
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
    public int IjS = 0;
    public ImageView Ikp;
    public TextView Ikq;
    public TextView Ikr;
    public TextView Iks;
    public int Ikx = 0;
    public int maxSize = 0;
    
    public final a gb(View paramView)
    {
      AppMethodBeat.i(36861);
      super.fX(paramView);
      this.fAz = ((TextView)this.sSS.findViewById(2131298178));
      this.ijt = ((CheckBox)this.sSS.findViewById(2131298068));
      this.gGk = this.sSS.findViewById(2131298147);
      this.xpH = ((TextView)this.sSS.findViewById(2131298185));
      this.Ikp = ((ImageView)this.sSS.findViewById(2131296913));
      this.Ikq = ((TextView)this.sSS.findViewById(2131296919));
      this.Ikr = ((TextView)this.sSS.findViewById(2131296911));
      this.Iks = ((TextView)this.sSS.findViewById(2131296922));
      this.nDl = this.sSS.findViewById(2131298069);
      this.IjS = c.kb(ai.getContext());
      this.Ikx = com.tencent.mm.cc.a.au(ai.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cc.a.av(ai.getContext(), 2131165217) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
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
        localObject = new ag(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new g.a().gb((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36863);
      this.HNS = parama1;
      g.a locala = (g.a)parama;
      paramString = parambo.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.az(paramString, parambo.field_reserved);; localObject = null)
      {
        com.tencent.mm.ah.b localb;
        if (localObject != null)
        {
          g.a(parama.nDl, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.Ikq.setTypeface(Typeface.defaultFromStyle(0));
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.nDl.setPadding(0, 0, 0, 0);
          g.a.aG(locala.nDl, locala.IjS);
          localb = (com.tencent.mm.ah.b)((k.b)localObject).ao(com.tencent.mm.ah.b.class);
          if (parambo.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hgz;
          if (!bs.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.Ikq.setSingleLine(false);
          locala.Ikq.setMaxLines(3);
          label187:
          locala.Ikq.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), paramString, locala.Ikx));
          locala.Ikq.setTextSize(0, locala.Ikx);
          if (!bs.isNullOrNil(localb.hgA)) {
            locala.Ikq.setTextColor(Color.parseColor(localb.hgA));
          }
          localObject = locala.Ikr;
          if (parambo.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hgD;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bs.isNullOrNil(localb.hgF)) {
            locala.Ikr.setTextColor(Color.parseColor(localb.hgF));
          }
          localObject = locala.Iks;
          if (parambo.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hgB;; paramString = localb.hgC)
        {
          ((TextView)localObject).setText(paramString);
          locala.Ikp.setImageBitmap(null);
          if (!bs.isNullOrNil(localb.hgt))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            az.ayM();
            paramString.prefixPath = com.tencent.mm.model.c.awM();
            paramString.hKx = true;
            paramString.gKm = true;
            paramString = paramString.aFT();
            o.aFB().a(localb.hgt, locala.Ikp, paramString);
          }
          parama.nDl.setOnClickListener(d(parama1));
          parama.nDl.setOnLongClickListener(c(parama1));
          parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          parama1 = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          parama.nDl.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label499:
          paramString = localb.hgy;
          break;
          label509:
          locala.Ikq.setSingleLine(true);
          break label187;
          paramString = localb.hgE;
          break label277;
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36864);
      paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      AppMethodBeat.o(36864);
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
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
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      String str = parambo.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.az(str, parambo.field_reserved);
      }
      if (paramView != null)
      {
        ac.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ah.b)paramView.ao(com.tencent.mm.ah.b.class)).hgs).getQueryParameter("cardNo");
        parambo = new Intent();
        parambo.putExtra("key_is_payer", false);
        parambo.putExtra("key_card_no", paramView);
        d.b(parama.HZF.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambo);
        com.tencent.mm.plugin.report.service.h.wUl.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
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
        localObject = new ag(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new g.a().gb((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36869);
      this.HNS = parama1;
      g.a locala = (g.a)parama;
      paramString = parambo.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.az(paramString, parambo.field_reserved);; localObject = null)
      {
        com.tencent.mm.ah.b localb;
        if (localObject != null)
        {
          g.a(parama.nDl, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.Ikq.setTypeface(Typeface.defaultFromStyle(0));
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.HZF.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.nDl.setPadding(0, 0, 0, 0);
          g.a.aG(locala.nDl, locala.IjS);
          localb = (com.tencent.mm.ah.b)((k.b)localObject).ao(com.tencent.mm.ah.b.class);
          if (parambo.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hgz;
          if (!bs.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.Ikq.setSingleLine(false);
          locala.Ikq.setMaxLines(3);
          label187:
          locala.Ikq.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), paramString, locala.Ikx));
          locala.Ikq.setTextSize(0, locala.Ikx);
          if (!bs.isNullOrNil(localb.hgA)) {
            locala.Ikq.setTextColor(Color.parseColor(localb.hgA));
          }
          localObject = locala.Ikr;
          if (parambo.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hgD;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bs.isNullOrNil(localb.hgF)) {
            locala.Ikr.setTextColor(Color.parseColor(localb.hgF));
          }
          localObject = locala.Iks;
          if (parambo.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hgB;; paramString = localb.hgC)
        {
          ((TextView)localObject).setText(paramString);
          locala.Ikp.setImageBitmap(null);
          if (!bs.isNullOrNil(localb.hgt))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            az.ayM();
            paramString.prefixPath = com.tencent.mm.model.c.awM();
            paramString.hKx = true;
            paramString.gKm = true;
            paramString = paramString.aFT();
            o.aFB().a(localb.hgt, locala.Ikp, paramString);
          }
          parama.nDl.setOnClickListener(d(parama1));
          parama.nDl.setOnLongClickListener(c(parama1));
          parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          parama1 = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          parama.nDl.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label499:
          paramString = localb.hgy;
          break;
          label509:
          locala.Ikq.setSingleLine(true);
          break label187;
          paramString = localb.hgE;
          break label277;
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36870);
      paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      AppMethodBeat.o(36870);
      return false;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = parambo.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.az(str1, parambo.field_reserved);
      }
      if (paramMenuItem != null)
      {
        parambo = parambo.field_talker;
        str1 = paramMenuItem.hjh;
        final String str2 = paramMenuItem.hji;
        final String str3 = paramMenuItem.hjj;
        final String str4 = paramMenuItem.hjk;
        final String str5 = paramMenuItem.hjf;
        final String str6 = paramMenuItem.hjm;
        paramMenuItem = paramMenuItem.hjn;
        com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131757285), parama.HZF.getMMResources().getString(2131755873), parama.HZF.getMMResources().getString(2131757286), parama.HZF.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", parambo);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            d.b(parama.HZF.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
            AppMethodBeat.o(36867);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(36871);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      String str = parambo.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.az(str, parambo.field_reserved);
      }
      if (paramView != null)
      {
        ac.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ah.b)paramView.ao(com.tencent.mm.ah.b.class)).hgq).getQueryParameter("cardNo");
        parambo = new Intent();
        parambo.putExtra("key_is_payer", true);
        parambo.putExtra("key_card_no", paramView);
        d.b(parama.HZF.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambo);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */