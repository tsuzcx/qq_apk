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
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

public final class g
{
  static Drawable bf(Bitmap paramBitmap)
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
    public ImageView aeOS;
    public TextView aeOT;
    public TextView aeOU;
    public TextView aeOV;
    public int aeOt = 0;
    public int aePb = 0;
    public int maxSize = 0;
    
    public final a lu(View paramView)
    {
      AppMethodBeat.i(36861);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
      this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
      this.maskView = this.convertView.findViewById(R.h.fzn);
      this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
      this.aeOS = ((ImageView)this.convertView.findViewById(R.h.frS));
      this.aeOT = ((TextView)this.convertView.findViewById(R.h.frY));
      this.aeOU = ((TextView)this.convertView.findViewById(R.h.frQ));
      this.aeOV = ((TextView)this.convertView.findViewById(R.h.fsc));
      this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
      this.aeOt = c.nn(MMApplicationContext.getContext());
      this.aePb = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize);
      this.maxSize = ((int)(com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.gfx);
        ((View)localObject).setTag(new g.a().lu((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36863);
      this.aeiK = parama1;
      g.a locala = (g.a)parama;
      paramString = paramcc.field_content;
      if (paramString != null) {}
      b localb;
      label191:
      label577:
      label707:
      label721:
      for (Object localObject = k.b.aP(paramString, paramcc.field_reserved);; localObject = null)
      {
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.aeOT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          localb = (b)((k.b)localObject).aK(b.class);
          if (paramcc.field_isSend != 1) {
            break label567;
          }
          paramString = localb.nPy;
          if (!Util.isNullOrNil(paramString)) {
            break label577;
          }
          paramString = ((k.b)localObject).description;
          locala.aeOT.setSingleLine(false);
          locala.aeOT.setMaxLines(3);
          locala.aeOT.setText(p.d(parama1.aezO.getContext(), paramString, locala.aePb));
          locala.aeOT.setTextSize(0, locala.aePb);
        }
        for (;;)
        {
          try
          {
            if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPO))) {
              continue;
            }
            l = Util.getLong(localb.nPO, -1L);
            if (l >= 0L) {
              locala.aeOT.setTextColor((int)l);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            long l;
            Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgC2CFrom", paramString, "", new Object[0]);
            continue;
            paramString = localb.nPD;
            continue;
            if (Util.isNullOrNil(localb.nPE)) {
              continue;
            }
            locala.aeOU.setTextColor(Color.parseColor(localb.nPE));
            continue;
          }
          localObject = locala.aeOU;
          if (paramcc.field_isSend != 1) {
            continue;
          }
          paramString = localb.nPC;
          ((TextView)localObject).setText(paramString);
          try
          {
            if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPP))) {
              continue;
            }
            l = Util.getLong(localb.nPP, -1L);
            if (l >= 0L) {
              locala.aeOU.setTextColor((int)l);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgC2CFrom", paramString, "", new Object[0]);
            continue;
            paramString = localb.nPB;
            continue;
            locala.aeOV.setAlpha(0.8F);
            continue;
            if (Util.isNullOrNil(localb.nPr)) {
              continue;
            }
            paramString = new com.tencent.mm.modelimage.loader.a.c.a();
            bh.bCz();
            paramString.prefixPath = com.tencent.mm.model.c.bzM();
            paramString.oKp = true;
            paramString.nqa = true;
            paramString = paramString.bKx();
            r.bKe().a(localb.nPr, locala.aeOS, paramString);
            continue;
          }
          localObject = locala.aeOV;
          if (paramcc.field_isSend != 1) {
            break label697;
          }
          paramString = localb.nPA;
          ((TextView)localObject).setText(paramString);
          if (!aw.isDarkMode()) {
            break label707;
          }
          locala.aeOV.setAlpha(0.5F);
          locala.aeOS.setImageBitmap(null);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPs))) {
            break label721;
          }
          paramString = new com.tencent.mm.modelimage.loader.a.c.a();
          bh.bCz();
          paramString.prefixPath = com.tencent.mm.model.c.bzM();
          paramString.oKp = true;
          paramString.nqa = true;
          paramString = paramString.bKx();
          r.bKe().a(localb.nPs, locala.aeOS, paramString);
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          paramString = localb.nPx;
          break;
          locala.aeOT.setSingleLine(true);
          break label191;
          if (!Util.isNullOrNil(localb.nPz)) {
            locala.aeOT.setTextColor(Color.parseColor(localb.nPz));
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
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
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255230);
      params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      AppMethodBeat.o(255230);
      return false;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      String str = paramcc.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.aP(str, paramcc.field_reserved);
      }
      if (localObject != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramcc = Uri.parse(((b)((k.b)localObject).aK(b.class)).nPq).getQueryParameter("cardNo");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_payer", false);
        ((Intent)localObject).putExtra("key_card_no", paramcc);
        if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(paramView.getContext()))
        {
          AppMethodBeat.o(36866);
          return true;
        }
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", (Intent)localObject);
        com.tencent.mm.plugin.report.service.h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.ggy);
        ((View)localObject).setTag(new g.a().lu((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36869);
      this.aeiK = parama1;
      g.a locala = (g.a)parama;
      paramString = paramcc.field_content;
      if (paramString != null) {}
      b localb;
      label191:
      label577:
      label707:
      label721:
      for (Object localObject = k.b.aP(paramString, paramcc.field_reserved);; localObject = null)
      {
        if (localObject != null)
        {
          g.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.aeOT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          localb = (b)((k.b)localObject).aK(b.class);
          if (paramcc.field_isSend != 1) {
            break label567;
          }
          paramString = localb.nPy;
          if (!Util.isNullOrNil(paramString)) {
            break label577;
          }
          paramString = ((k.b)localObject).description;
          locala.aeOT.setSingleLine(false);
          locala.aeOT.setMaxLines(3);
          locala.aeOT.setText(p.d(parama1.aezO.getContext(), paramString, locala.aePb));
          locala.aeOT.setTextSize(0, locala.aePb);
        }
        for (;;)
        {
          try
          {
            if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPO))) {
              continue;
            }
            l = Util.getLong(localb.nPO, -1L);
            if (l >= 0L) {
              locala.aeOT.setTextColor((int)l);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            long l;
            Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgC2CTo", paramString, "", new Object[0]);
            continue;
            paramString = localb.nPD;
            continue;
            if (Util.isNullOrNil(localb.nPE)) {
              continue;
            }
            locala.aeOU.setTextColor(Color.parseColor(localb.nPE));
            continue;
          }
          localObject = locala.aeOU;
          if (paramcc.field_isSend != 1) {
            continue;
          }
          paramString = localb.nPC;
          ((TextView)localObject).setText(paramString);
          try
          {
            if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPP))) {
              continue;
            }
            l = Util.getLong(localb.nPP, -1L);
            if (l >= 0L) {
              locala.aeOU.setTextColor((int)l);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgC2CTo", paramString, "", new Object[0]);
            continue;
            paramString = localb.nPB;
            continue;
            locala.aeOV.setAlpha(0.8F);
            continue;
            if (Util.isNullOrNil(localb.nPr)) {
              continue;
            }
            paramString = new com.tencent.mm.modelimage.loader.a.c.a();
            bh.bCz();
            paramString.prefixPath = com.tencent.mm.model.c.bzM();
            paramString.oKp = true;
            paramString.nqa = true;
            paramString = paramString.bKx();
            r.bKe().a(localb.nPr, locala.aeOS, paramString);
            continue;
          }
          localObject = locala.aeOV;
          if (paramcc.field_isSend != 1) {
            break label697;
          }
          paramString = localb.nPA;
          ((TextView)localObject).setText(paramString);
          if (!aw.isDarkMode()) {
            break label707;
          }
          locala.aeOV.setAlpha(0.5F);
          locala.aeOS.setImageBitmap(null);
          if ((!aw.isDarkMode()) || (Util.isNullOrNil(localb.nPs))) {
            break label721;
          }
          paramString = new com.tencent.mm.modelimage.loader.a.c.a();
          bh.bCz();
          paramString.prefixPath = com.tencent.mm.model.c.bzM();
          paramString.oKp = true;
          paramString.nqa = true;
          paramString = paramString.bKx();
          r.bKe().a(localb.nPs, locala.aeOS, paramString);
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          paramString = localb.nPx;
          break;
          locala.aeOT.setSingleLine(true);
          break label191;
          if (!Util.isNullOrNil(localb.nPz)) {
            locala.aeOT.setTextColor(Color.parseColor(localb.nPz));
          }
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = paramcc.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.aP(str1, paramcc.field_reserved);
      }
      if (paramMenuItem != null)
      {
        paramcc = paramcc.field_talker;
        str1 = paramMenuItem.nSE;
        final String str2 = paramMenuItem.nSF;
        final String str3 = paramMenuItem.nSG;
        final String str4 = paramMenuItem.nSH;
        final String str5 = paramMenuItem.nSC;
        final String str6 = paramMenuItem.nSJ;
        paramMenuItem = paramMenuItem.nSK;
        k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.gzl), parama.aezO.getMMResources().getString(R.l.app_remind), parama.aezO.getMMResources().getString(R.l.gzm), parama.aezO.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", paramcc);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            com.tencent.mm.br.c.b(parama.aezO.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255228);
      params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      AppMethodBeat.o(255228);
      return false;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      if (paramView != null)
      {
        Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((b)paramView.aK(b.class)).nPo).getQueryParameter("cardNo");
        paramcc = new Intent();
        paramcc.putExtra("key_is_payer", true);
        paramcc.putExtra("key_card_no", paramView);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", paramcc);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */