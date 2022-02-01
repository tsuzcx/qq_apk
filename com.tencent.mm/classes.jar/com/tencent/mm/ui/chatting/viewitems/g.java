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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class g
{
  static Drawable aI(Bitmap paramBitmap)
  {
    AppMethodBeat.i(36873);
    Object localObject = paramBitmap.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk((byte[])localObject))
    {
      localObject = new NinePatchDrawable(aj.getResources(), paramBitmap, (byte[])localObject, new Rect(), null);
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
    public ImageView KaN;
    public TextView KaO;
    public TextView KaP;
    public TextView KaQ;
    public int KaV = 0;
    public int Kaq = 0;
    public int maxSize = 0;
    
    public final a gs(View paramView)
    {
      AppMethodBeat.i(36861);
      super.gn(paramView);
      this.fTP = ((TextView)this.tPw.findViewById(2131298178));
      this.iCK = ((CheckBox)this.tPw.findViewById(2131298068));
      this.gZU = this.tPw.findViewById(2131298147);
      this.yEk = ((TextView)this.tPw.findViewById(2131298185));
      this.KaN = ((ImageView)this.tPw.findViewById(2131296913));
      this.KaO = ((TextView)this.tPw.findViewById(2131296919));
      this.KaP = ((TextView)this.tPw.findViewById(2131296911));
      this.KaQ = ((TextView)this.tPw.findViewById(2131296922));
      this.ofK = this.tPw.findViewById(2131298069);
      this.Kaq = c.kn(aj.getContext());
      this.KaV = com.tencent.mm.cc.a.ax(aj.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cc.a.ay(aj.getContext(), 2131165217) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        ((View)localObject).setTag(new g.a().gs((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(36863);
      this.JBI = parama1;
      g.a locala = (g.a)parama;
      paramString = parambu.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aA(paramString, parambu.field_reserved);; localObject = null)
      {
        com.tencent.mm.ai.b localb;
        if (localObject != null)
        {
          g.a(parama.ofK, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.KaO.setTypeface(Typeface.defaultFromStyle(0));
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.ofK.setPadding(0, 0, 0, 0);
          g.a.aI(locala.ofK, locala.Kaq);
          localb = (com.tencent.mm.ai.b)((k.b)localObject).ao(com.tencent.mm.ai.b.class);
          if (parambu.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hyI;
          if (!bt.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.KaO.setSingleLine(false);
          locala.KaO.setMaxLines(3);
          label187:
          locala.KaO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), paramString, locala.KaV));
          locala.KaO.setTextSize(0, locala.KaV);
          if (!bt.isNullOrNil(localb.hyJ)) {
            locala.KaO.setTextColor(Color.parseColor(localb.hyJ));
          }
          localObject = locala.KaP;
          if (parambu.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hyM;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bt.isNullOrNil(localb.hyO)) {
            locala.KaP.setTextColor(Color.parseColor(localb.hyO));
          }
          localObject = locala.KaQ;
          if (parambu.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hyK;; paramString = localb.hyL)
        {
          ((TextView)localObject).setText(paramString);
          locala.KaN.setImageBitmap(null);
          if (!bt.isNullOrNil(localb.hyC))
          {
            paramString = new com.tencent.mm.aw.a.a.c.a();
            ba.aBQ();
            paramString.prefixPath = com.tencent.mm.model.c.azB();
            paramString.idr = true;
            paramString.hdX = true;
            paramString = paramString.aJc();
            q.aIJ().a(localb.hyC, locala.KaN, paramString);
          }
          parama.ofK.setOnClickListener(d(parama1));
          parama.ofK.setOnLongClickListener(c(parama1));
          parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          parama1 = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          parama.ofK.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label499:
          paramString = localb.hyH;
          break;
          label509:
          locala.KaO.setSingleLine(true);
          break label187;
          paramString = localb.hyN;
          break label277;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
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
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194333);
      paraml.a(((bk)paramView.getTag()).position, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      AppMethodBeat.o(194333);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      String str = parambu.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aA(str, parambu.field_reserved);
      }
      if (paramView != null)
      {
        ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ai.b)paramView.ao(com.tencent.mm.ai.b.class)).hyB).getQueryParameter("cardNo");
        parambu = new Intent();
        parambu.putExtra("key_is_payer", false);
        parambu.putExtra("key_card_no", paramView);
        d.b(parama.JOR.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambu);
        com.tencent.mm.plugin.report.service.g.yhR.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        ((View)localObject).setTag(new g.a().gs((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(36869);
      this.JBI = parama1;
      g.a locala = (g.a)parama;
      paramString = parambu.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aA(paramString, parambu.field_reserved);; localObject = null)
      {
        com.tencent.mm.ai.b localb;
        if (localObject != null)
        {
          g.a(parama.ofK, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.KaO.setTypeface(Typeface.defaultFromStyle(0));
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.JOR.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.ofK.setPadding(0, 0, 0, 0);
          g.a.aI(locala.ofK, locala.Kaq);
          localb = (com.tencent.mm.ai.b)((k.b)localObject).ao(com.tencent.mm.ai.b.class);
          if (parambu.field_isSend != 1) {
            break label499;
          }
          paramString = localb.hyI;
          if (!bt.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.KaO.setSingleLine(false);
          locala.KaO.setMaxLines(3);
          label187:
          locala.KaO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), paramString, locala.KaV));
          locala.KaO.setTextSize(0, locala.KaV);
          if (!bt.isNullOrNil(localb.hyJ)) {
            locala.KaO.setTextColor(Color.parseColor(localb.hyJ));
          }
          localObject = locala.KaP;
          if (parambu.field_isSend != 1) {
            break label521;
          }
          paramString = localb.hyM;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bt.isNullOrNil(localb.hyO)) {
            locala.KaP.setTextColor(Color.parseColor(localb.hyO));
          }
          localObject = locala.KaQ;
          if (parambu.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.hyK;; paramString = localb.hyL)
        {
          ((TextView)localObject).setText(paramString);
          locala.KaN.setImageBitmap(null);
          if (!bt.isNullOrNil(localb.hyC))
          {
            paramString = new com.tencent.mm.aw.a.a.c.a();
            ba.aBQ();
            paramString.prefixPath = com.tencent.mm.model.c.azB();
            paramString.idr = true;
            paramString.hdX = true;
            paramString = paramString.aJc();
            q.aIJ().a(localb.hyC, locala.KaN, paramString);
          }
          parama.ofK.setOnClickListener(d(parama1));
          parama.ofK.setOnLongClickListener(c(parama1));
          parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          parama1 = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          parama.ofK.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label499:
          paramString = localb.hyH;
          break;
          label509:
          locala.KaO.setSingleLine(true);
          break label187;
          paramString = localb.hyN;
          break label277;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = parambu.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.aA(str1, parambu.field_reserved);
      }
      if (paramMenuItem != null)
      {
        parambu = parambu.field_talker;
        str1 = paramMenuItem.hBq;
        final String str2 = paramMenuItem.hBr;
        final String str3 = paramMenuItem.hBs;
        final String str4 = paramMenuItem.hBt;
        final String str5 = paramMenuItem.hBo;
        final String str6 = paramMenuItem.hBv;
        paramMenuItem = paramMenuItem.hBw;
        h.e(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131757285), parama.JOR.getMMResources().getString(2131755873), parama.JOR.getMMResources().getString(2131757286), parama.JOR.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", parambu);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            d.b(parama.JOR.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194334);
      paraml.a(((bk)paramView.getTag()).position, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      AppMethodBeat.o(194334);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      String str = parambu.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aA(str, parambu.field_reserved);
      }
      if (paramView != null)
      {
        ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ai.b)paramView.ao(com.tencent.mm.ai.b.class)).hyz).getQueryParameter("cardNo");
        parambu = new Intent();
        parambu.putExtra("key_is_payer", true);
        parambu.putExtra("key_card_no", paramView);
        d.b(parama.JOR.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambu);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */