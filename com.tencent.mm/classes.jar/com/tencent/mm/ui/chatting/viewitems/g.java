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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class g
{
  static Drawable aJ(Bitmap paramBitmap)
  {
    AppMethodBeat.i(36873);
    Object localObject = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk((byte[])localObject))
    {
      localObject = new NinePatchDrawable(ak.getResources(), paramBitmap, (byte[])localObject, new Rect(), null);
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
    public int KwJ = 0;
    public ImageView Kxg;
    public TextView Kxh;
    public TextView Kxi;
    public TextView Kxj;
    public int Kxo = 0;
    public int maxSize = 0;
    
    public final a gx(View paramView)
    {
      AppMethodBeat.i(36861);
      super.gs(paramView);
      this.fVV = ((TextView)this.uan.findViewById(2131298178));
      this.iFD = ((CheckBox)this.uan.findViewById(2131298068));
      this.hcH = this.uan.findViewById(2131298147);
      this.yUp = ((TextView)this.uan.findViewById(2131298185));
      this.Kxg = ((ImageView)this.uan.findViewById(2131296913));
      this.Kxh = ((TextView)this.uan.findViewById(2131296919));
      this.Kxi = ((TextView)this.uan.findViewById(2131296911));
      this.Kxj = ((TextView)this.uan.findViewById(2131296922));
      this.olI = this.uan.findViewById(2131298069);
      this.KwJ = c.ku(ak.getContext());
      this.Kxo = com.tencent.mm.cb.a.ax(ak.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cb.a.ay(ak.getContext(), 2131165217) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        localObject = new ah(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new g.a().gx((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(36863);
      this.JWz = parama1;
      g.a locala = (g.a)parama;
      paramString = parambv.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aB(paramString, parambv.field_reserved);; localObject = null)
      {
        com.tencent.mm.ah.b localb;
        if (localObject != null)
        {
          g.a(parama.olI, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.Kxh.setTypeface(Typeface.defaultFromStyle(0));
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.olI.setPadding(0, 0, 0, 0);
          g.a.aI(locala.olI, locala.KwJ);
          localb = (com.tencent.mm.ah.b)((k.b)localObject).ao(com.tencent.mm.ah.b.class);
          if (parambv.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hBw;
          if (!bu.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.Kxh.setSingleLine(false);
          locala.Kxh.setMaxLines(3);
          label187:
          locala.Kxh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), paramString, locala.Kxo));
          locala.Kxh.setTextSize(0, locala.Kxo);
          if (!bu.isNullOrNil(localb.hBx)) {
            locala.Kxh.setTextColor(Color.parseColor(localb.hBx));
          }
          localObject = locala.Kxi;
          if (parambv.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hBA;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bu.isNullOrNil(localb.hBC)) {
            locala.Kxi.setTextColor(Color.parseColor(localb.hBC));
          }
          localObject = locala.Kxj;
          if (parambv.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hBy;; paramString = localb.hBz)
        {
          ((TextView)localObject).setText(paramString);
          locala.Kxg.setImageBitmap(null);
          if (!bu.isNullOrNil(localb.hBq))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            bc.aCg();
            paramString.prefixPath = com.tencent.mm.model.c.azR();
            paramString.igk = true;
            paramString.hgL = true;
            paramString = paramString.aJu();
            q.aJb().a(localb.hBq, locala.Kxg, paramString);
          }
          parama.olI.setOnClickListener(d(parama1));
          parama.olI.setOnLongClickListener(c(parama1));
          parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama1 = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          parama.olI.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label499:
          paramString = localb.hBv;
          break;
          label509:
          locala.Kxh.setSingleLine(true);
          break label187;
          paramString = localb.hBB;
          break label277;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
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
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187728);
      paraml.a(((bk)paramView.getTag()).position, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      AppMethodBeat.o(187728);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      String str = parambv.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aB(str, parambv.field_reserved);
      }
      if (paramView != null)
      {
        ae.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ah.b)paramView.ao(com.tencent.mm.ah.b.class)).hBp).getQueryParameter("cardNo");
        parambv = new Intent();
        parambv.putExtra("key_is_payer", false);
        parambv.putExtra("key_card_no", paramView);
        d.b(parama.Kkd.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambv);
        com.tencent.mm.plugin.report.service.g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        localObject = new ah(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new g.a().gx((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(36869);
      this.JWz = parama1;
      g.a locala = (g.a)parama;
      paramString = parambv.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aB(paramString, parambv.field_reserved);; localObject = null)
      {
        com.tencent.mm.ah.b localb;
        if (localObject != null)
        {
          g.a(parama.olI, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.Kxh.setTypeface(Typeface.defaultFromStyle(0));
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.Kkd.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.olI.setPadding(0, 0, 0, 0);
          g.a.aI(locala.olI, locala.KwJ);
          localb = (com.tencent.mm.ah.b)((k.b)localObject).ao(com.tencent.mm.ah.b.class);
          if (parambv.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hBw;
          if (!bu.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.Kxh.setSingleLine(false);
          locala.Kxh.setMaxLines(3);
          label187:
          locala.Kxh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), paramString, locala.Kxo));
          locala.Kxh.setTextSize(0, locala.Kxo);
          if (!bu.isNullOrNil(localb.hBx)) {
            locala.Kxh.setTextColor(Color.parseColor(localb.hBx));
          }
          localObject = locala.Kxi;
          if (parambv.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hBA;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bu.isNullOrNil(localb.hBC)) {
            locala.Kxi.setTextColor(Color.parseColor(localb.hBC));
          }
          localObject = locala.Kxj;
          if (parambv.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hBy;; paramString = localb.hBz)
        {
          ((TextView)localObject).setText(paramString);
          locala.Kxg.setImageBitmap(null);
          if (!bu.isNullOrNil(localb.hBq))
          {
            paramString = new com.tencent.mm.av.a.a.c.a();
            bc.aCg();
            paramString.prefixPath = com.tencent.mm.model.c.azR();
            paramString.igk = true;
            paramString.hgL = true;
            paramString = paramString.aJu();
            q.aJb().a(localb.hBq, locala.Kxg, paramString);
          }
          parama.olI.setOnClickListener(d(parama1));
          parama.olI.setOnLongClickListener(c(parama1));
          parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama1 = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          parama.olI.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label499:
          paramString = localb.hBv;
          break;
          label509:
          locala.Kxh.setSingleLine(true);
          break label187;
          paramString = localb.hBB;
          break label277;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bv parambv)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = parambv.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.aB(str1, parambv.field_reserved);
      }
      if (paramMenuItem != null)
      {
        parambv = parambv.field_talker;
        str1 = paramMenuItem.hEe;
        final String str2 = paramMenuItem.hEf;
        final String str3 = paramMenuItem.hEg;
        final String str4 = paramMenuItem.hEh;
        final String str5 = paramMenuItem.hEc;
        final String str6 = paramMenuItem.hEj;
        paramMenuItem = paramMenuItem.hEk;
        h.e(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131757285), parama.Kkd.getMMResources().getString(2131755873), parama.Kkd.getMMResources().getString(2131757286), parama.Kkd.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", parambv);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            d.b(parama.Kkd.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187729);
      paraml.a(((bk)paramView.getTag()).position, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      AppMethodBeat.o(187729);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      String str = parambv.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aB(str, parambv.field_reserved);
      }
      if (paramView != null)
      {
        ae.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ah.b)paramView.ao(com.tencent.mm.ah.b.class)).hBn).getQueryParameter("cardNo");
        parambv = new Intent();
        parambv.putExtra("key_is_payer", true);
        parambv.putExtra("key_card_no", paramView);
        d.b(parama.Kkd.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambv);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */