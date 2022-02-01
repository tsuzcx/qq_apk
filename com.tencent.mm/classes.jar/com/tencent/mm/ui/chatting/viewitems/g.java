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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class g
{
  static Drawable aM(Bitmap paramBitmap)
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
    public int PJE = 0;
    public int PJa = 0;
    public ImageView PJw;
    public TextView PJx;
    public TextView PJy;
    public TextView PJz;
    public int maxSize = 0;
    
    public final a gN(View paramView)
    {
      AppMethodBeat.i(36861);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
      this.checkBox = ((CheckBox)this.convertView.findViewById(2131298410));
      this.maskView = this.convertView.findViewById(2131298508);
      this.userTV = ((TextView)this.convertView.findViewById(2131298566));
      this.PJw = ((ImageView)this.convertView.findViewById(2131297017));
      this.PJx = ((TextView)this.convertView.findViewById(2131297023));
      this.PJy = ((TextView)this.convertView.findViewById(2131297015));
      this.PJz = ((TextView)this.convertView.findViewById(2131297027));
      this.clickArea = this.convertView.findViewById(2131298411);
      this.PJa = c.kl(MMApplicationContext.getContext());
      this.PJE = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165220);
      this.maxSize = ((int)(com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131165220) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493527);
        ((View)localObject).setTag(new g.a().gN((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36863);
      this.PhN = parama1;
      g.a locala = (g.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aD(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.ag.b localb;
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.PJx.setTypeface(Typeface.defaultFromStyle(0));
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131165586);
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131166038);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
          localb = (com.tencent.mm.ag.b)((k.b)localObject).as(com.tencent.mm.ag.b.class);
          if (paramca.field_isSend != 1) {
            break label501;
          }
          paramString = localb.ivC;
          if (!Util.isNullOrNil(paramString)) {
            break label511;
          }
          paramString = ((k.b)localObject).description;
          locala.PJx.setSingleLine(false);
          locala.PJx.setMaxLines(3);
          label189:
          locala.PJx.setText(l.e(parama1.Pwc.getContext(), paramString, locala.PJE));
          locala.PJx.setTextSize(0, locala.PJE);
          if (!Util.isNullOrNil(localb.ivD)) {
            locala.PJx.setTextColor(Color.parseColor(localb.ivD));
          }
          localObject = locala.PJy;
          if (paramca.field_isSend != 1) {
            break label523;
          }
          paramString = localb.ivG;
          label279:
          ((TextView)localObject).setText(paramString);
          if (!Util.isNullOrNil(localb.ivI)) {
            locala.PJy.setTextColor(Color.parseColor(localb.ivI));
          }
          localObject = locala.PJz;
          if (paramca.field_isSend != 1) {
            break label533;
          }
        }
        label523:
        label533:
        for (paramString = localb.ivE;; paramString = localb.ivF)
        {
          ((TextView)localObject).setText(paramString);
          locala.PJw.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.ivw))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            bg.aVF();
            paramString.prefixPath = com.tencent.mm.model.c.aSZ();
            paramString.jbf = true;
            paramString.hZF = true;
            paramString = paramString.bdv();
            q.bcV().a(localb.ivw, locala.PJw, paramString);
          }
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
          parama1 = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label501:
          paramString = localb.ivB;
          break;
          label511:
          locala.PJx.setSingleLine(true);
          break label189;
          paramString = localb.ivH;
          break label279;
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
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233618);
      paramm.a(((bq)paramView.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      AppMethodBeat.o(233618);
      return false;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      String str = paramca.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.aD(str, paramca.field_reserved);
      }
      if (localObject != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramca = Uri.parse(((com.tencent.mm.ag.b)((k.b)localObject).as(com.tencent.mm.ag.b.class)).ivv).getQueryParameter("cardNo");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_payer", false);
        ((Intent)localObject).putExtra("key_card_no", paramca);
        if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(paramView.getContext()))
        {
          AppMethodBeat.o(36866);
          return true;
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", (Intent)localObject);
        com.tencent.mm.plugin.report.service.h.CyF.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493579);
        ((View)localObject).setTag(new g.a().gN((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36869);
      this.PhN = parama1;
      g.a locala = (g.a)parama;
      paramString = paramca.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aD(paramString, paramca.field_reserved);; localObject = null)
      {
        com.tencent.mm.ag.b localb;
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.PJx.setTypeface(Typeface.defaultFromStyle(0));
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131165586);
          parama1.Pwc.getContext().getResources().getDimensionPixelSize(2131166038);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
          localb = (com.tencent.mm.ag.b)((k.b)localObject).as(com.tencent.mm.ag.b.class);
          if (paramca.field_isSend != 1) {
            break label501;
          }
          paramString = localb.ivC;
          if (!Util.isNullOrNil(paramString)) {
            break label511;
          }
          paramString = ((k.b)localObject).description;
          locala.PJx.setSingleLine(false);
          locala.PJx.setMaxLines(3);
          label189:
          locala.PJx.setText(l.e(parama1.Pwc.getContext(), paramString, locala.PJE));
          locala.PJx.setTextSize(0, locala.PJE);
          if (!Util.isNullOrNil(localb.ivD)) {
            locala.PJx.setTextColor(Color.parseColor(localb.ivD));
          }
          localObject = locala.PJy;
          if (paramca.field_isSend != 1) {
            break label523;
          }
          paramString = localb.ivG;
          label279:
          ((TextView)localObject).setText(paramString);
          if (!Util.isNullOrNil(localb.ivI)) {
            locala.PJy.setTextColor(Color.parseColor(localb.ivI));
          }
          localObject = locala.PJz;
          if (paramca.field_isSend != 1) {
            break label533;
          }
        }
        label523:
        label533:
        for (paramString = localb.ivE;; paramString = localb.ivF)
        {
          ((TextView)localObject).setText(paramString);
          locala.PJw.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.ivw))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            bg.aVF();
            paramString.prefixPath = com.tencent.mm.model.c.aSZ();
            paramString.jbf = true;
            paramString.hZF = true;
            paramString = paramString.bdv();
            q.bcV().a(localb.ivw, locala.PJw, paramString);
          }
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
          parama1 = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label501:
          paramString = localb.ivB;
          break;
          label511:
          locala.PJx.setSingleLine(true);
          break label189;
          paramString = localb.ivH;
          break label279;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = paramca.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.aD(str1, paramca.field_reserved);
      }
      if (paramMenuItem != null)
      {
        paramca = paramca.field_talker;
        str1 = paramMenuItem.iyk;
        final String str2 = paramMenuItem.iyl;
        final String str3 = paramMenuItem.iym;
        final String str4 = paramMenuItem.iyn;
        final String str5 = paramMenuItem.iyi;
        final String str6 = paramMenuItem.iyp;
        paramMenuItem = paramMenuItem.iyq;
        com.tencent.mm.ui.base.h.c(parama.Pwc.getContext(), parama.Pwc.getMMResources().getString(2131757499), parama.Pwc.getMMResources().getString(2131755962), parama.Pwc.getMMResources().getString(2131757500), parama.Pwc.getMMResources().getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", paramca);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233619);
      paramm.a(((bq)paramView.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      AppMethodBeat.o(233619);
      return false;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aD(str, paramca.field_reserved);
      }
      if (paramView != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ag.b)paramView.as(com.tencent.mm.ag.b.class)).ivt).getQueryParameter("cardNo");
        paramca = new Intent();
        paramca.putExtra("key_is_payer", true);
        paramca.putExtra("key_card_no", paramView);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", paramca);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */