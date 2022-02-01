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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class g
{
  static Drawable aE(Bitmap paramBitmap)
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
    public int GJV = 0;
    public int GKA = 0;
    public ImageView GKs;
    public TextView GKt;
    public TextView GKu;
    public TextView GKv;
    public int maxSize = 0;
    
    public final a fO(View paramView)
    {
      AppMethodBeat.i(36861);
      super.fK(paramView);
      this.fwS = ((TextView)this.rLd.findViewById(2131298178));
      this.hIS = ((CheckBox)this.rLd.findViewById(2131298068));
      this.lRB = this.rLd.findViewById(2131298147);
      this.wet = ((TextView)this.rLd.findViewById(2131298185));
      this.GKs = ((ImageView)this.rLd.findViewById(2131296913));
      this.GKt = ((TextView)this.rLd.findViewById(2131296919));
      this.GKu = ((TextView)this.rLd.findViewById(2131296911));
      this.GKv = ((TextView)this.rLd.findViewById(2131296922));
      this.naN = this.rLd.findViewById(2131298069);
      this.GJV = c.jQ(aj.getContext());
      this.GKA = com.tencent.mm.cd.a.ao(aj.getContext(), 2131165217);
      this.maxSize = ((int)(com.tencent.mm.cd.a.ap(aj.getContext(), 2131165217) * 1.45F));
      AppMethodBeat.o(36861);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493432);
        ((View)localObject).setTag(new g.a().fO((View)localObject));
      }
      AppMethodBeat.o(36862);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36863);
      this.Gob = parama1;
      g.a locala = (g.a)parama;
      paramString = parambl.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.ar(paramString, parambl.field_reserved);; localObject = null)
      {
        com.tencent.mm.ai.b localb;
        if (localObject != null)
        {
          g.a(parama.naN, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
          locala.GKt.setTypeface(Typeface.defaultFromStyle(0));
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.naN.setPadding(0, 0, 0, 0);
          g.a.aE(locala.naN, locala.GJV);
          localb = (com.tencent.mm.ai.b)((k.b)localObject).ao(com.tencent.mm.ai.b.class);
          if (parambl.field_isSend != 1) {
            break label499;
          }
          paramString = localb.gFY;
          if (!bt.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.GKt.setSingleLine(false);
          locala.GKt.setMaxLines(3);
          label187:
          locala.GKt.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), paramString, locala.GKA));
          locala.GKt.setTextSize(0, locala.GKA);
          if (!bt.isNullOrNil(localb.gFZ)) {
            locala.GKt.setTextColor(Color.parseColor(localb.gFZ));
          }
          localObject = locala.GKu;
          if (parambl.field_isSend != 1) {
            break label521;
          }
          paramString = localb.gGc;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bt.isNullOrNil(localb.gGe)) {
            locala.GKu.setTextColor(Color.parseColor(localb.gGe));
          }
          localObject = locala.GKv;
          if (parambl.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.gGa;; paramString = localb.gGb)
        {
          ((TextView)localObject).setText(paramString);
          locala.GKs.setImageBitmap(null);
          if (!bt.isNullOrNil(localb.gFS))
          {
            paramString = new com.tencent.mm.aw.a.a.c.a();
            az.arV();
            paramString.prefixPath = com.tencent.mm.model.c.apX();
            paramString.hjU = true;
            paramString.gjA = true;
            paramString = paramString.azc();
            o.ayJ().a(localb.gFS, locala.GKs, paramString);
          }
          parama.naN.setOnClickListener(d(parama1));
          parama.naN.setOnLongClickListener(c(parama1));
          parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parama1 = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          parama.naN.setTag(parama1);
          AppMethodBeat.o(36863);
          return;
          label499:
          paramString = localb.gFX;
          break;
          label509:
          locala.GKt.setSingleLine(true);
          break label187;
          paramString = localb.gGd;
          break label277;
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36864);
      paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      AppMethodBeat.o(36864);
      return false;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
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
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36866);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      String str = parambl.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.ar(str, parambl.field_reserved);
      }
      if (paramView != null)
      {
        ad.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ai.b)paramView.ao(com.tencent.mm.ai.b.class)).gFR).getQueryParameter("cardNo");
        parambl = new Intent();
        parambl.putExtra("key_is_payer", false);
        parambl.putExtra("key_card_no", paramView);
        d.b(parama.GzJ.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambl);
        com.tencent.mm.plugin.report.service.h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      AppMethodBeat.o(36866);
      return true;
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493477);
        ((View)localObject).setTag(new g.a().fO((View)localObject));
      }
      AppMethodBeat.o(36868);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36869);
      this.Gob = parama1;
      g.a locala = (g.a)parama;
      paramString = parambl.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.ar(paramString, parambl.field_reserved);; localObject = null)
      {
        com.tencent.mm.ai.b localb;
        if (localObject != null)
        {
          g.a(parama.naN, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CTo", true);
          locala.GKt.setTypeface(Typeface.defaultFromStyle(0));
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131165568);
          parama1.GzJ.getContext().getResources().getDimensionPixelSize(2131166006);
          locala.naN.setPadding(0, 0, 0, 0);
          g.a.aE(locala.naN, locala.GJV);
          localb = (com.tencent.mm.ai.b)((k.b)localObject).ao(com.tencent.mm.ai.b.class);
          if (parambl.field_isSend != 1) {
            break label499;
          }
          paramString = localb.gFY;
          if (!bt.isNullOrNil(paramString)) {
            break label509;
          }
          paramString = ((k.b)localObject).description;
          locala.GKt.setSingleLine(false);
          locala.GKt.setMaxLines(3);
          label187:
          locala.GKt.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), paramString, locala.GKA));
          locala.GKt.setTextSize(0, locala.GKA);
          if (!bt.isNullOrNil(localb.gFZ)) {
            locala.GKt.setTextColor(Color.parseColor(localb.gFZ));
          }
          localObject = locala.GKu;
          if (parambl.field_isSend != 1) {
            break label521;
          }
          paramString = localb.gGc;
          label277:
          ((TextView)localObject).setText(paramString);
          if (!bt.isNullOrNil(localb.gGe)) {
            locala.GKu.setTextColor(Color.parseColor(localb.gGe));
          }
          localObject = locala.GKv;
          if (parambl.field_isSend != 1) {
            break label531;
          }
        }
        label521:
        label531:
        for (paramString = localb.gGa;; paramString = localb.gGb)
        {
          ((TextView)localObject).setText(paramString);
          locala.GKs.setImageBitmap(null);
          if (!bt.isNullOrNil(localb.gFS))
          {
            paramString = new com.tencent.mm.aw.a.a.c.a();
            az.arV();
            paramString.prefixPath = com.tencent.mm.model.c.apX();
            paramString.hjU = true;
            paramString.gjA = true;
            paramString = paramString.azc();
            o.ayJ().a(localb.gFS, locala.GKs, paramString);
          }
          parama.naN.setOnClickListener(d(parama1));
          parama.naN.setOnLongClickListener(c(parama1));
          parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parama1 = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          parama.naN.setTag(parama1);
          AppMethodBeat.o(36869);
          return;
          label499:
          paramString = localb.gFX;
          break;
          label509:
          locala.GKt.setSingleLine(true);
          break label187;
          paramString = localb.gGd;
          break label277;
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36870);
      paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      AppMethodBeat.o(36870);
      return false;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36871);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36871);
        return false;
      }
      final String str1 = parambl.field_content;
      paramMenuItem = null;
      if (str1 != null) {
        paramMenuItem = k.b.ar(str1, parambl.field_reserved);
      }
      if (paramMenuItem != null)
      {
        parambl = parambl.field_talker;
        str1 = paramMenuItem.gIH;
        final String str2 = paramMenuItem.gII;
        final String str3 = paramMenuItem.gIJ;
        final String str4 = paramMenuItem.gIK;
        final String str5 = paramMenuItem.gIF;
        final String str6 = paramMenuItem.gIM;
        paramMenuItem = paramMenuItem.gIN;
        com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getMMResources().getString(2131757285), parama.GzJ.getMMResources().getString(2131755873), parama.GzJ.getMMResources().getString(2131757286), parama.GzJ.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(36867);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("key_scene", 1);
            paramAnonymousDialogInterface.putExtra("key_receiver", parambl);
            paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
            paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
            paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
            paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
            paramAnonymousDialogInterface.putExtra("key_url", str5);
            paramAnonymousDialogInterface.putExtra("key_templateid", str6);
            paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
            d.b(parama.GzJ.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
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
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536870961);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36872);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      String str = parambl.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.ar(str, parambl.field_reserved);
      }
      if (paramView != null)
      {
        ad.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
        paramView = Uri.parse(((com.tencent.mm.ai.b)paramView.ao(com.tencent.mm.ai.b.class)).gFP).getQueryParameter("cardNo");
        parambl = new Intent();
        parambl.putExtra("key_is_payer", true);
        parambl.putExtra("key_card_no", paramView);
        d.b(parama.GzJ.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", parambl);
      }
      AppMethodBeat.o(36872);
      return true;
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g
 * JD-Core Version:    0.7.0.1
 */