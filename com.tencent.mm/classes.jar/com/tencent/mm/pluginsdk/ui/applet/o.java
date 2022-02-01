package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.c;
import com.tencent.mm.api.j;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.ui.widget.a.d.a.c;
import com.tencent.mm.ui.widget.a.d.a.d;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o
  implements y
{
  private static int[] BYu = { 2131305923, 2131305924, 2131305925, 2131305926, 2131305927, 2131305928, 2131305929, 2131305930, 2131305931 };
  
  public static com.tencent.mm.ui.base.o a(r paramr, long paramLong, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31396);
    final View localView = ak(paramr.FNL, 2131493591);
    final com.tencent.mm.ui.base.o localo = fo(localView);
    a(localView, parama, localo);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31396);
      return null;
    }
    a(localView, 2131298571, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(2131298568);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, paramr.FNL.getResources().getDimension(2131165192) * com.tencent.mm.cd.a.dT(paramr.FNL));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cd.a.m(paramr.FNL, 2131100711));
    Object localObject = ((j)g.ab(j.class)).bg(paramLong);
    String str1;
    if ((localObject != null) && (((c)localObject).isGroup()))
    {
      paramString1 = ((c)localObject).field_chatName;
      str1 = ((c)localObject).field_headImageUrl;
      localObject = ((c)localObject).field_brandUserName;
      String str2 = paramString1;
      if (paramString1 == null) {
        str2 = paramString2;
      }
      if (bt.isNullOrNil(str2)) {
        break label407;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131298565, null, true, 8);
      paramString1 = (Button)localView.findViewById(2131298557);
      if (!bt.isNullOrNil(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31356);
          if (this.BYy != null) {
            this.BYy.a(true, o.fp(localView), o.fq(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(31356);
        }
      });
      paramString1 = new c.a();
      paramString1.prefixPath = com.tencent.mm.api.a.dH((String)localObject);
      paramString1.hjU = true;
      paramString1.gjA = true;
      paramString1.hkf = 2131690013;
      paramString1 = paramString1.azc();
      if (!bt.isNullOrNil(str1)) {
        com.tencent.mm.aw.o.ayJ().a(str1, (ImageView)localView.findViewById(2131298570), paramString1);
      }
      a(paramr, localo);
      AppMethodBeat.o(31396);
      return localo;
      localObject = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).ea(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.am.a.k)localObject).field_userName;
        str1 = ((com.tencent.mm.am.a.k)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.am.a.k)localObject).field_brandUserName;
        break;
      }
      ad.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(31396);
      return null;
      label407:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.base.o a(r paramr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31395);
    final View localView = ak(paramr.FNL, 2131493591);
    final com.tencent.mm.ui.base.o localo = fo(localView);
    a(localView, parama, localo);
    if (bt.isNullOrNil(paramString2))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31395);
      return null;
    }
    a(localView, 2131298571, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(2131298568);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, paramr.FNL.getResources().getDimension(2131165192) * com.tencent.mm.cd.a.dT(paramr.FNL));
    paramString2.setTextColor(com.tencent.mm.cd.a.m(paramr.FNL, 2131100711));
    if (!bt.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).b(paramr.FNL, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131298565, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(2131298557);
      if (!bt.isNullOrNil(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31355);
          if (this.BYy != null) {
            this.BYy.a(true, o.fp(localView), o.fq(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(31355);
        }
      });
      if (!bt.isNullOrNil(paramString1)) {
        a.b.c((ImageView)localView.findViewById(2131298570), paramString1);
      }
      a(paramr, localo);
      AppMethodBeat.o(31395);
      return localo;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).b(paramr.FNL, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static d a(r paramr, int paramInt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31388);
    paramr = a(paramr, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31388);
    return paramr;
  }
  
  public static d a(r paramr, int paramInt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31389);
    d.a locala = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bt.S(((String)localObject).split(","));
      a(paramr.FNL, locala, localObject);
    }
    locala.wV(true);
    if (paramInt == 2131689559) {
      localObject = paramr.FNL.getResources().getString(2131755773);
    }
    for (;;)
    {
      locala.at((String)localObject + paramString1).wX(false).wY(false);
      if (paramBoolean) {
        locala.wW(true);
      }
      paramString1 = locala.fft();
      a(paramr.FNL, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(31389);
      return paramString1;
      if (paramInt == 2131689564) {
        localObject = paramr.FNL.getResources().getString(2131755820);
      } else if (paramInt == 2131689581) {
        localObject = paramr.FNL.getResources().getString(2131755926);
      } else {
        localObject = paramr.FNL.getResources().getString(2131755278);
      }
    }
  }
  
  public static d a(r paramr, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31392);
    View localView = ak(paramr.FNL, 2131493588);
    d.a locala = new d.a(paramr.FNL);
    locala.wX(false);
    locala.wY(false);
    u(localView, true);
    a(paramr, locala, parama, localView, paramr.FNL.getResources().getString(2131757562));
    parama = (TextView)localView.findViewById(2131298571);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString2, paramString1.getTextSize()));
    paramr = (TextView)localView.findViewById(2131298564);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramr.setVisibility(8);
      paramr = (ImageView)localView.findViewById(2131298570);
      if (paramr != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label242;
        }
        ad.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        paramr.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.gs(localView);
      paramr = locala.fft();
      paramr.show();
      AppMethodBeat.o(31392);
      return paramr;
      paramr.setText(paramString3);
      paramr.setVisibility(0);
      break;
      label242:
      paramr.setVisibility(0);
      paramr.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static d a(r paramr, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(191282);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(191282);
      return null;
    }
    View localView = ak(paramr.FNL, 2131493589);
    d.a locala = new d.a(paramr.FNL);
    locala.wX(false);
    locala.wY(false);
    u(localView, false);
    a(paramr, locala, parama, localView, paramr.FNL.getResources().getString(2131757589));
    parama = (TextView)localView.findViewById(2131298571);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString1, parama.getTextSize()));
    parama.getPaint().setFakeBoldText(true);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString2, paramString1.getTextSize()));
    paramr = (ImageView)localView.findViewById(2131298570);
    if (paramr != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label241;
      }
      paramr.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
    for (;;)
    {
      locala.gs(localView);
      paramr = locala.fft();
      paramr.show();
      AppMethodBeat.o(191282);
      return paramr;
      label241:
      if (!bt.isNullOrNil(paramString3))
      {
        paramString1 = com.tencent.mm.aw.o.ayJ();
        paramBitmap = new c.a();
        paramBitmap.hkf = 2131231342;
        paramBitmap.hjT = true;
        paramBitmap.gkG = true;
        paramString1.a(paramString3, paramr, paramBitmap.azc());
      }
      else
      {
        paramr.setImageResource(2131231342);
      }
    }
  }
  
  public static d a(r paramr, String paramString1, View paramView, String paramString2, y.b paramb)
  {
    AppMethodBeat.i(31398);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31398);
      return null;
    }
    d.a locala = new d.a(paramr.FNL);
    locala.wX(false);
    locala.wY(false);
    a(locala, paramr.FNL, paramString1);
    if (!bt.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramr.FNL.getResources().getString(2131757562);
    }
    locala.aMm(paramString1).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31343);
        if (this.BYx != null) {
          this.BYx.mB(true);
        }
        AppMethodBeat.o(31343);
      }
    });
    locala.aaC(2131755691).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31344);
        if (this.BYx != null) {
          this.BYx.mB(false);
        }
        AppMethodBeat.o(31344);
      }
    });
    locala.gs(paramView);
    paramString1 = locala.fft();
    paramString1.Wc(paramr.FNL.getResources().getColor(2131100035));
    paramString1.show();
    AppMethodBeat.o(31398);
    return paramString1;
  }
  
  public static d a(r paramr, String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31381);
    paramr = a(paramr, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(31381);
    return paramr;
  }
  
  public static d a(r paramr, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, y.a parama)
  {
    AppMethodBeat.i(31377);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31377);
      return null;
    }
    View localView = View.inflate(paramr.FNL, 2131493587, null);
    d.a locala = new d.a(paramr.FNL);
    locala.wX(false);
    locala.wY(false);
    a(locala, paramr.FNL, paramString1);
    u(localView, paramBoolean);
    a(paramr, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298564).setVisibility(8);
    int i = BackwardSupportUtil.b.g(paramr.FNL, 120.0F);
    paramr = (CdnImageView)localView.findViewById(2131298570);
    if (paramr != null) {
      paramr.aB(paramString2, i, i);
    }
    locala.gs(localView);
    paramr = locala.fft();
    paramr.show();
    AppMethodBeat.o(31377);
    return paramr;
  }
  
  public static d a(r paramr, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31378);
    paramr = a(paramr, paramString1, paramString2, paramBoolean, paramString3, parama, paramr.FNL.getResources().getString(2131755920));
    AppMethodBeat.o(31378);
    return paramr;
  }
  
  public static d a(r paramr, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama, String paramString4)
  {
    AppMethodBeat.i(31379);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31379);
      return null;
    }
    paramString2 = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bt.S(((String)localObject).split(","));
      a(paramr.FNL, paramString2, localObject);
    }
    paramString2.wV(true);
    paramString2.at(paramString4 + paramString1).wX(false).wY(false);
    if (paramBoolean) {
      paramString2.wW(true);
    }
    paramString1 = paramString2.fft();
    a(paramr.FNL, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31379);
    return paramString1;
  }
  
  public static d a(r paramr, String paramString, boolean paramBoolean, int paramInt, y.a parama)
  {
    AppMethodBeat.i(31390);
    paramr = a(paramr, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(31390);
    return paramr;
  }
  
  public static d a(r paramr, String paramString1, boolean paramBoolean, int paramInt, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31391);
    d.a locala = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = bt.S(((String)localObject).split(","));; localObject = null)
    {
      a(paramr.FNL, locala, localObject);
      locala.wV(true);
      switch (paramInt)
      {
      default: 
        localObject = paramr.FNL.getResources().getString(2131755278);
      }
      for (;;)
      {
        locala.at((String)localObject + paramString1).wX(false).wY(false);
        if (paramBoolean) {
          locala.wW(true);
        }
        paramString1 = locala.fft();
        a(paramr.FNL, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(31391);
        return paramString1;
        localObject = paramr.FNL.getResources().getString(2131755926);
        continue;
        localObject = paramr.FNL.getResources().getString(2131755820);
      }
    }
  }
  
  public static d a(r paramr, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31382);
    paramr = a(paramr, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31382);
    return paramr;
  }
  
  public static d a(r paramr, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31383);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(31383);
      return null;
    }
    d.a locala = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bt.S(((String)localObject).split(","));
      a(paramr.FNL, locala, localObject);
    }
    locala.wV(true);
    locala.at(paramString1).wX(false).wY(false);
    if (paramBoolean) {
      locala.wW(true);
    }
    paramString1 = locala.fft();
    a(paramr.FNL, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31383);
    return paramString1;
  }
  
  public static d a(r paramr, byte[] paramArrayOfByte, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31386);
    paramr = a(paramr, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(31386);
    return paramr;
  }
  
  public static d a(r paramr, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, y.a parama)
  {
    AppMethodBeat.i(31387);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(31387);
      return null;
    }
    d.a locala = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bt.S(((String)localObject).split(","));
      a(paramr.FNL, locala, localObject);
    }
    locala.wV(true);
    locala.wX(false).wY(false);
    if (paramBoolean) {
      locala.wW(true);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      Exif localExif = new Exif();
      localExif.parseFrom(paramArrayOfByte);
      int i = localExif.getOrientationInDegree();
      if (localObject != null)
      {
        paramArrayOfByte = (byte[])localObject;
        if (i != 0) {
          paramArrayOfByte = f.a((Bitmap)localObject, i);
        }
        locala.a(paramArrayOfByte, true, 3);
        a(locala, paramArrayOfByte);
        locala.wV(false);
      }
    }
    paramArrayOfByte = locala.fft();
    a(paramr.FNL, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    AppMethodBeat.o(31387);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, d.a parama, final Object paramObject)
  {
    AppMethodBeat.i(31374);
    if (paramObject != null) {
      if ((paramObject instanceof String)) {
        paramObject = bt.S(((String)paramObject).split(","));
      }
    }
    for (;;)
    {
      if (bt.gL(paramObject))
      {
        AppMethodBeat.o(31374);
        return;
        if ((paramObject instanceof List)) {
          paramObject = (List)paramObject;
        }
      }
      else
      {
        if (paramObject.size() == 1)
        {
          paramObject = (String)paramObject.get(0);
          int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cd.a.dT(paramContext)));
          Object localObject1 = paramContext.getString(2131762564);
          parama.ar(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i)).aax(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramObject);
          i = com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cd.a.dT(paramContext)));
          if (w.pF(paramObject))
          {
            Object localObject2 = paramContext.getString(2131762993, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).rY(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = com.tencent.mm.ui.y.js(paramContext).inflate(2131493711, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(2131297961);
            final ArrayList localArrayList = new ArrayList();
            final List localList = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).rW(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new d.a.c()new o.6
            {
              public final void eyg()
              {
                AppMethodBeat.i(31342);
                bt.hideVKB(this.BYv);
                if ((localArrayList.size() == 0) && (!bt.isNullOrNil(paramObject))) {
                  o.a(localArrayList, localList);
                }
                AppMethodBeat.o(31342);
              }
            }, new o.6());
            localGridView.setAdapter(new t(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(2131101053)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label450;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.ao(paramContext, 2131165265)));
              localGridView.setPadding(com.tencent.mm.cd.a.ao(paramContext, 2131165261), 0, com.tencent.mm.cd.a.ao(paramContext, 2131165261), 0);
            }
            for (;;)
            {
              parama.HEO.ERI = ((View)localObject2);
              AppMethodBeat.o(31374);
              return;
              label450:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cd.a.ao(paramContext, 2131165258));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new o.9());
          AppMethodBeat.o(31374);
          return;
        }
        parama.gt(d(paramContext, paramObject));
        parama.aMf(paramContext.getString(2131761383)).aax(3);
        AppMethodBeat.o(31374);
        return;
      }
      paramObject = null;
    }
  }
  
  private static void a(Context paramContext, d paramd, String paramString1, String paramString2, y.a parama1, y.a parama2)
  {
    AppMethodBeat.i(31376);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      paramString2 = paramContext.getResources().getString(2131757562);
    }
    if (!bt.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    paramContext = paramContext.getResources().getString(2131755691);
    paramd.a(paramString2, true, new o.10(paramd, parama1));
    paramd.b(paramContext, true, new o.11(paramd, parama2));
    AppMethodBeat.o(31376);
  }
  
  private static void a(View paramView, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(31405);
    paramView = (TextView)paramView.findViewById(paramInt1);
    if (paramView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((!paramBoolean) || (!bt.isNullOrNil(paramString))) {
        break;
      }
      paramView.setVisibility(paramInt2);
      AppMethodBeat.o(31405);
      return;
    }
    paramView.setText(paramString);
    AppMethodBeat.o(31405);
  }
  
  private static void a(final View paramView, y.a parama, final com.tencent.mm.ui.base.o paramo)
  {
    AppMethodBeat.i(31403);
    ((Button)paramView.findViewById(2131298557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191279);
        if (this.BYy != null) {
          this.BYy.a(true, o.fp(paramView), o.fq(paramView));
        }
        paramo.dismiss();
        paramo.setFocusable(false);
        paramo.setTouchable(false);
        AppMethodBeat.o(191279);
      }
    });
    paramView = (Button)paramView.findViewById(2131298558);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31346);
          if (this.BYy != null) {
            this.BYy.a(false, null, 0);
          }
          paramo.dismiss();
          paramo.setFocusable(false);
          paramo.setTouchable(false);
          AppMethodBeat.o(31346);
        }
      });
    }
    AppMethodBeat.o(31403);
  }
  
  private static void a(r paramr, com.tencent.mm.ui.base.o paramo)
  {
    AppMethodBeat.i(31406);
    try
    {
      if (!paramr.FNL.isFinishing())
      {
        paramo.setInputMethodMode(1);
        paramo.setSoftInputMode(16);
        paramo.setFocusable(true);
        paramo.setTouchable(true);
        paramo.showAtLocation(paramr.FNL.getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(31406);
      return;
    }
    catch (Exception paramr)
    {
      ad.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paramr.getMessage() });
      ad.printErrStackTrace("MicroMsg.MMConfirmDialog", paramr, "", new Object[0]);
      AppMethodBeat.o(31406);
    }
  }
  
  private static void a(r paramr, d.a parama, y.a parama1, final View paramView, String paramString)
  {
    AppMethodBeat.i(31401);
    String str;
    if (!bt.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = paramr.FNL.getResources().getString(2131757562);
    }
    parama.aMm(str).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(191281);
        if (this.BYy != null) {
          this.BYy.a(true, o.fp(paramView), o.fq(paramView));
        }
        AppMethodBeat.o(191281);
      }
    });
    parama.aaC(2131755691).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31358);
        if (this.BYy != null) {
          this.BYy.a(false, null, 0);
        }
        AppMethodBeat.o(31358);
      }
    });
    AppMethodBeat.o(31401);
  }
  
  public static void a(r paramr, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31397);
    paramr = new a(paramr.FNL).dL(paramString1).aBX(paramString2).i(Boolean.FALSE);
    paramr.BYB = paramString3;
    paramr.a(parama).ijc.show();
    AppMethodBeat.o(31397);
  }
  
  private static void a(d.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(31402);
    parama.aMf(paramString);
    parama.aav(paramContext.getResources().getColor(2131100711));
    parama.aaw(2);
    AppMethodBeat.o(31402);
  }
  
  private static void a(d.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31407);
    parama.a(new o.7(paramBitmap));
    AppMethodBeat.o(31407);
  }
  
  private static View ak(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31399);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(31399);
    return paramContext;
  }
  
  public static d b(r paramr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31380);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31380);
      return null;
    }
    View localView = View.inflate(paramr.FNL, 2131493587, null);
    d.a locala = new d.a(paramr.FNL);
    locala.wX(false);
    locala.wY(false);
    a(locala, paramr.FNL, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(2131298569);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paramr, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramr.FNL, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298564).setVisibility(8);
    int i = BackwardSupportUtil.b.g(paramr.FNL, 120.0F);
    paramr = (CdnImageView)localView.findViewById(2131298570);
    if (paramr != null) {
      paramr.aB(paramString2, i, i);
    }
    locala.gs(localView);
    paramr = locala.fft();
    paramr.show();
    AppMethodBeat.o(31380);
    return paramr;
  }
  
  public static d b(r paramr, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31384);
    paramr = b(paramr, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31384);
    return paramr;
  }
  
  public static d b(r paramr, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31385);
    if ((paramString1 == null) || (!i.eK(paramString1)))
    {
      ad.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(31385);
      return null;
    }
    d.a locala = new d.a(paramr.FNL);
    Object localObject = paramr.FNL.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bt.S(((String)localObject).split(","));
      a(paramr.FNL, locala, localObject);
    }
    locala.wV(true);
    locala.wX(false).wY(false);
    if (paramBoolean) {
      locala.wW(true);
    }
    if (!bt.isNullOrNil(paramString1))
    {
      localObject = f.aFi(paramString1);
      int i = BackwardSupportUtil.ExifHelper.co(paramString1);
      if (localObject != null)
      {
        paramString1 = (String)localObject;
        if (i != 0) {
          paramString1 = f.a((Bitmap)localObject, i);
        }
        locala.a(paramString1, true, 3);
        a(locala, paramString1);
        locala.wV(false);
      }
    }
    paramString1 = locala.fft();
    a(paramr.FNL, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31385);
    return paramString1;
  }
  
  private static View d(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(31375);
    paramContext = View.inflate(paramContext, 2131493594, null);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((i > 8) || (paramContext == null)) {
          break label102;
        }
        ImageView localImageView = (ImageView)paramContext.findViewById(BYu[i]);
        if (str == null) {
          break label102;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.f.a.a.c(localImageView, str);
        i += 1;
      }
    }
    label102:
    for (;;)
    {
      break;
      AppMethodBeat.o(31375);
      return paramContext;
    }
  }
  
  private static com.tencent.mm.ui.base.o fo(View paramView)
  {
    AppMethodBeat.i(31400);
    paramView = new com.tencent.mm.ui.base.o(paramView, -1, -1);
    AppMethodBeat.o(31400);
    return paramView;
  }
  
  private static void u(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(31404);
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(2131298569);
      if (paramView != null) {
        if (!paramBoolean) {
          break label43;
        }
      }
    }
    label43:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(31404);
      return;
    }
  }
  
  public static final class a
  {
    final d.a BYA;
    public String BYB;
    public d ijc;
    public DialogInterface.OnDismissListener lYl;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(31360);
      this.BYB = null;
      this.mContext = paramContext;
      this.BYA = new d.a(this.mContext);
      this.BYA.wX(false);
      this.BYA.wY(false);
      this.BYA.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(31359);
          paramAnonymousCharSequence = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(o.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(31359);
          return paramAnonymousCharSequence;
        }
      });
      AppMethodBeat.o(31360);
    }
    
    public final a UL(int paramInt)
    {
      AppMethodBeat.i(31372);
      this.BYB = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(31372);
      return this;
    }
    
    public final a a(y.a parama)
    {
      AppMethodBeat.i(31373);
      this.ijc = this.BYA.fft();
      if (this.lYl != null) {
        this.ijc.setOnDismissListener(this.lYl);
      }
      o.a(this.mContext, this.ijc, this.BYB, parama, parama);
      AppMethodBeat.o(31373);
      return this;
    }
    
    public final a a(d.a.b paramb)
    {
      AppMethodBeat.i(31368);
      this.BYA.c(paramb);
      AppMethodBeat.o(31368);
      return this;
    }
    
    public final a aBW(String paramString)
    {
      AppMethodBeat.i(31362);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, (int)(20.0F * com.tencent.mm.cd.a.dT(this.mContext)));
      if (!bt.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.BYA.ar(paramString);
      }
      AppMethodBeat.o(31362);
      return this;
    }
    
    public final a aBX(String paramString)
    {
      AppMethodBeat.i(31364);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cd.a.dT(this.mContext)));
      if (!bt.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.BYA.at(paramString);
      }
      AppMethodBeat.o(31364);
      return this;
    }
    
    public final a aBY(String paramString)
    {
      AppMethodBeat.i(31365);
      this.BYA.aMi(paramString);
      AppMethodBeat.o(31365);
      return this;
    }
    
    public final a aBZ(String paramString)
    {
      AppMethodBeat.i(31367);
      o.a(this.mContext, this.BYA, paramString);
      this.BYA.wV(false);
      AppMethodBeat.o(31367);
      return this;
    }
    
    public final a dL(Object paramObject)
    {
      AppMethodBeat.i(31361);
      o.b(this.mContext, this.BYA, paramObject);
      this.BYA.wV(true);
      AppMethodBeat.o(31361);
      return this;
    }
    
    public final a eyh()
    {
      AppMethodBeat.i(31363);
      this.BYA.aaz(2);
      AppMethodBeat.o(31363);
      return this;
    }
    
    public final a eyi()
    {
      this.BYA.HEO.ERO = 8;
      return this;
    }
    
    public final a eyj()
    {
      AppMethodBeat.i(31371);
      this.BYA.wV(false);
      AppMethodBeat.o(31371);
      return this;
    }
    
    public final a fr(View paramView)
    {
      AppMethodBeat.i(31369);
      this.BYA.gs(paramView);
      AppMethodBeat.o(31369);
      return this;
    }
    
    public final a i(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(31366);
      this.BYA.a(paramBitmap, true, paramInt);
      this.BYA.wV(false);
      o.b(this.BYA, paramBitmap);
      AppMethodBeat.o(31366);
      return this;
    }
    
    public final a i(Boolean paramBoolean)
    {
      AppMethodBeat.i(31370);
      this.BYA.wW(paramBoolean.booleanValue());
      if (paramBoolean.booleanValue()) {
        this.BYA.aMk(this.mContext.getString(2131757559));
      }
      AppMethodBeat.o(31370);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o
 * JD-Core Version:    0.7.0.1
 */