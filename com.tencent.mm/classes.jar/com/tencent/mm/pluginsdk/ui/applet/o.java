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
import com.tencent.mm.al.a.c;
import com.tencent.mm.api.j;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.d.a.a;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.ui.widget.a.d.a.c;
import com.tencent.mm.ui.widget.a.d.a.d;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o
  implements y
{
  private static int[] DqL = { 2131305923, 2131305924, 2131305925, 2131305926, 2131305927, 2131305928, 2131305929, 2131305930, 2131305931 };
  
  public static com.tencent.mm.ui.base.o a(s params, long paramLong, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31396);
    final View localView = aq(params.Hnw, 2131493591);
    final com.tencent.mm.ui.base.o localo = fB(localView);
    a(localView, parama, localo);
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31396);
      return null;
    }
    a(localView, 2131298571, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(2131298568);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, params.Hnw.getResources().getDimension(2131165192) * com.tencent.mm.cc.a.eb(params.Hnw));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cc.a.m(params.Hnw, 2131100711));
    Object localObject = ((j)g.ab(j.class)).bd(paramLong);
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
      if (bs.isNullOrNil(str2)) {
        break label407;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131298565, null, true, 8);
      paramString1 = (Button)localView.findViewById(2131298557);
      if (!bs.isNullOrNil(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31356);
          if (this.DqP != null) {
            this.DqP.a(true, o.fC(localView), o.fD(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(31356);
        }
      });
      paramString1 = new c.a();
      paramString1.prefixPath = com.tencent.mm.api.a.dw((String)localObject);
      paramString1.hKx = true;
      paramString1.gKm = true;
      paramString1.hKI = 2131690013;
      paramString1 = paramString1.aFT();
      if (!bs.isNullOrNil(str1)) {
        com.tencent.mm.av.o.aFB().a(str1, (ImageView)localView.findViewById(2131298570), paramString1);
      }
      a(params, localo);
      AppMethodBeat.o(31396);
      return localo;
      localObject = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).dP(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.al.a.k)localObject).field_userName;
        str1 = ((com.tencent.mm.al.a.k)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.al.a.k)localObject).field_brandUserName;
        break;
      }
      ac.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(31396);
      return null;
      label407:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.base.o a(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31395);
    final View localView = aq(params.Hnw, 2131493591);
    final com.tencent.mm.ui.base.o localo = fB(localView);
    a(localView, parama, localo);
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31395);
      return null;
    }
    a(localView, 2131298571, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(2131298568);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, params.Hnw.getResources().getDimension(2131165192) * com.tencent.mm.cc.a.eb(params.Hnw));
    paramString2.setTextColor(com.tencent.mm.cc.a.m(params.Hnw, 2131100711));
    if (!bs.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).b(params.Hnw, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131298565, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(2131298557);
      if (!bs.isNullOrNil(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31355);
          if (this.DqP != null) {
            this.DqP.a(true, o.fC(localView), o.fD(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(31355);
        }
      });
      if (!bs.isNullOrNil(paramString1)) {
        a.b.c((ImageView)localView.findViewById(2131298570), paramString1);
      }
      a(params, localo);
      AppMethodBeat.o(31395);
      return localo;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).b(params.Hnw, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static d a(s params, int paramInt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31388);
    params = a(params, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31388);
    return params;
  }
  
  public static d a(s params, int paramInt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31389);
    d.a locala = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bs.S(((String)localObject).split(","));
      a(params.Hnw, locala, localObject);
    }
    locala.yd(true);
    if (paramInt == 2131689559) {
      localObject = params.Hnw.getResources().getString(2131755773);
    }
    for (;;)
    {
      locala.au((String)localObject + paramString1).yf(false).yg(false);
      if (paramBoolean) {
        locala.ye(true);
      }
      paramString1 = locala.fvp();
      a(params.Hnw, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(31389);
      return paramString1;
      if (paramInt == 2131689564) {
        localObject = params.Hnw.getResources().getString(2131755820);
      } else if (paramInt == 2131689581) {
        localObject = params.Hnw.getResources().getString(2131755926);
      } else {
        localObject = params.Hnw.getResources().getString(2131755278);
      }
    }
  }
  
  public static d a(s params, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31392);
    View localView = aq(params.Hnw, 2131493588);
    d.a locala = new d.a(params.Hnw);
    locala.yf(false);
    locala.yg(false);
    u(localView, true);
    a(params, locala, parama, localView, params.Hnw.getResources().getString(2131757562));
    parama = (TextView)localView.findViewById(2131298571);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString2, paramString1.getTextSize()));
    params = (TextView)localView.findViewById(2131298564);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      params.setVisibility(8);
      params = (ImageView)localView.findViewById(2131298570);
      if (params != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label242;
        }
        ac.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        params.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.gH(localView);
      params = locala.fvp();
      params.show();
      AppMethodBeat.o(31392);
      return params;
      params.setText(paramString3);
      params.setVisibility(0);
      break;
      label242:
      params.setVisibility(0);
      params.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static d a(s params, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(196120);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(196120);
      return null;
    }
    View localView = aq(params.Hnw, 2131493589);
    d.a locala = new d.a(params.Hnw);
    locala.yf(false);
    locala.yg(false);
    u(localView, false);
    a(params, locala, parama, localView, params.Hnw.getResources().getString(2131757589));
    parama = (TextView)localView.findViewById(2131298571);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString1, parama.getTextSize()));
    parama.getPaint().setFakeBoldText(true);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString2, paramString1.getTextSize()));
    params = (ImageView)localView.findViewById(2131298570);
    if (params != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label241;
      }
      params.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
    for (;;)
    {
      locala.gH(localView);
      params = locala.fvp();
      params.show();
      AppMethodBeat.o(196120);
      return params;
      label241:
      if (!bs.isNullOrNil(paramString3))
      {
        paramString1 = com.tencent.mm.av.o.aFB();
        paramBitmap = new c.a();
        paramBitmap.hKI = 2131231342;
        paramBitmap.hKw = true;
        paramBitmap.gLt = true;
        paramString1.a(paramString3, params, paramBitmap.aFT());
      }
      else
      {
        params.setImageResource(2131231342);
      }
    }
  }
  
  public static d a(s params, String paramString1, View paramView, String paramString2, y.b paramb)
  {
    AppMethodBeat.i(31398);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31398);
      return null;
    }
    d.a locala = new d.a(params.Hnw);
    locala.yf(false);
    locala.yg(false);
    a(locala, params.Hnw, paramString1);
    if (!bs.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = params.Hnw.getResources().getString(2131757562);
    }
    locala.aRO(paramString1).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31343);
        if (this.DqO != null) {
          this.DqO.nu(true);
        }
        AppMethodBeat.o(31343);
      }
    });
    locala.acN(2131755691).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31344);
        if (this.DqO != null) {
          this.DqO.nu(false);
        }
        AppMethodBeat.o(31344);
      }
    });
    locala.gH(paramView);
    paramString1 = locala.fvp();
    paramString1.Yl(params.Hnw.getResources().getColor(2131100035));
    paramString1.show();
    AppMethodBeat.o(31398);
    return paramString1;
  }
  
  public static d a(s params, String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31381);
    params = a(params, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(31381);
    return params;
  }
  
  public static d a(s params, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, y.a parama)
  {
    AppMethodBeat.i(31377);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31377);
      return null;
    }
    View localView = View.inflate(params.Hnw, 2131493587, null);
    d.a locala = new d.a(params.Hnw);
    locala.yf(false);
    locala.yg(false);
    a(locala, params.Hnw, paramString1);
    u(localView, paramBoolean);
    a(params, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298564).setVisibility(8);
    int i = BackwardSupportUtil.b.g(params.Hnw, 120.0F);
    params = (CdnImageView)localView.findViewById(2131298570);
    if (params != null) {
      params.aE(paramString2, i, i);
    }
    locala.gH(localView);
    params = locala.fvp();
    params.show();
    AppMethodBeat.o(31377);
    return params;
  }
  
  public static d a(s params, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31378);
    params = a(params, paramString1, paramString2, paramBoolean, paramString3, parama, params.Hnw.getResources().getString(2131755920));
    AppMethodBeat.o(31378);
    return params;
  }
  
  public static d a(s params, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama, String paramString4)
  {
    AppMethodBeat.i(31379);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31379);
      return null;
    }
    paramString2 = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bs.S(((String)localObject).split(","));
      a(params.Hnw, paramString2, localObject);
    }
    paramString2.yd(true);
    paramString2.au(paramString4 + paramString1).yf(false).yg(false);
    if (paramBoolean) {
      paramString2.ye(true);
    }
    paramString1 = paramString2.fvp();
    a(params.Hnw, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31379);
    return paramString1;
  }
  
  public static d a(s params, String paramString, boolean paramBoolean, int paramInt, y.a parama)
  {
    AppMethodBeat.i(31390);
    params = a(params, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(31390);
    return params;
  }
  
  public static d a(s params, String paramString1, boolean paramBoolean, int paramInt, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31391);
    d.a locala = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = bs.S(((String)localObject).split(","));; localObject = null)
    {
      a(params.Hnw, locala, localObject);
      locala.yd(true);
      switch (paramInt)
      {
      default: 
        localObject = params.Hnw.getResources().getString(2131755278);
      }
      for (;;)
      {
        locala.au((String)localObject + paramString1).yf(false).yg(false);
        if (paramBoolean) {
          locala.ye(true);
        }
        paramString1 = locala.fvp();
        a(params.Hnw, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(31391);
        return paramString1;
        localObject = params.Hnw.getResources().getString(2131755926);
        continue;
        localObject = params.Hnw.getResources().getString(2131755820);
      }
    }
  }
  
  public static d a(s params, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31382);
    params = a(params, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31382);
    return params;
  }
  
  public static d a(s params, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31383);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(31383);
      return null;
    }
    d.a locala = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bs.S(((String)localObject).split(","));
      a(params.Hnw, locala, localObject);
    }
    locala.yd(true);
    locala.au(paramString1).yf(false).yg(false);
    if (paramBoolean) {
      locala.ye(true);
    }
    paramString1 = locala.fvp();
    a(params.Hnw, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31383);
    return paramString1;
  }
  
  public static d a(s params, byte[] paramArrayOfByte, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31386);
    params = a(params, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(31386);
    return params;
  }
  
  public static d a(s params, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, y.a parama)
  {
    AppMethodBeat.i(31387);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(31387);
      return null;
    }
    d.a locala = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bs.S(((String)localObject).split(","));
      a(params.Hnw, locala, localObject);
    }
    locala.yd(true);
    locala.yf(false).yg(false);
    if (paramBoolean) {
      locala.ye(true);
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
        locala.yd(false);
      }
    }
    paramArrayOfByte = locala.fvp();
    a(params.Hnw, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    AppMethodBeat.o(31387);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, d.a parama, final Object paramObject)
  {
    AppMethodBeat.i(31374);
    if (paramObject != null) {
      if ((paramObject instanceof String)) {
        paramObject = bs.S(((String)paramObject).split(","));
      }
    }
    for (;;)
    {
      if (bs.gY(paramObject))
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
          int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cc.a.eb(paramContext)));
          Object localObject1 = paramContext.getString(2131762564);
          parama.as(((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i)).acI(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramObject);
          i = com.tencent.mm.cc.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cc.a.eb(paramContext)));
          if (w.sQ(paramObject))
          {
            Object localObject2 = paramContext.getString(2131762993, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).wb(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = z.jD(paramContext).inflate(2131493711, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(2131297961);
            final ArrayList localArrayList = new ArrayList();
            final List localList = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).vZ(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new d.a.c()new d.a.a
            {
              public final void eNA()
              {
                AppMethodBeat.i(31342);
                bs.hideVKB(this.DqM);
                if ((localArrayList.size() == 0) && (!bs.isNullOrNil(paramObject))) {
                  o.a(localArrayList, localList);
                }
                AppMethodBeat.o(31342);
              }
            }, new d.a.a()
            {
              public final void y(ImageView paramAnonymousImageView, String paramAnonymousString)
              {
                AppMethodBeat.i(31348);
                com.tencent.mm.ui.f.a.a.c(paramAnonymousImageView, paramAnonymousString);
                AppMethodBeat.o(31348);
              }
            });
            localGridView.setAdapter(new t(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(2131101053)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label450;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cc.a.au(paramContext, 2131165265)));
              localGridView.setPadding(com.tencent.mm.cc.a.au(paramContext, 2131165261), 0, com.tencent.mm.cc.a.au(paramContext, 2131165261), 0);
            }
            for (;;)
            {
              parama.Jfi.GoV = ((View)localObject2);
              AppMethodBeat.o(31374);
              return;
              label450:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cc.a.au(paramContext, 2131165258));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new d.a.a()
          {
            public final void y(ImageView paramAnonymousImageView, String paramAnonymousString)
            {
              AppMethodBeat.i(31352);
              com.tencent.mm.ui.f.a.a.c(paramAnonymousImageView, paramAnonymousString);
              AppMethodBeat.o(31352);
            }
          });
          AppMethodBeat.o(31374);
          return;
        }
        parama.gI(d(paramContext, paramObject));
        parama.aRH(paramContext.getString(2131761383)).acI(3);
        AppMethodBeat.o(31374);
        return;
      }
      paramObject = null;
    }
  }
  
  private static void a(Context paramContext, d paramd, String paramString1, String paramString2, y.a parama1, y.a parama2)
  {
    AppMethodBeat.i(31376);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      paramString2 = paramContext.getResources().getString(2131757562);
    }
    if (!bs.isNullOrNil(null)) {
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
      if ((!paramBoolean) || (!bs.isNullOrNil(paramString))) {
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
        AppMethodBeat.i(196117);
        if (this.DqP != null) {
          this.DqP.a(true, o.fC(paramView), o.fD(paramView));
        }
        paramo.dismiss();
        paramo.setFocusable(false);
        paramo.setTouchable(false);
        AppMethodBeat.o(196117);
      }
    });
    paramView = (Button)paramView.findViewById(2131298558);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31346);
          if (this.DqP != null) {
            this.DqP.a(false, null, 0);
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
  
  private static void a(s params, com.tencent.mm.ui.base.o paramo)
  {
    AppMethodBeat.i(31406);
    try
    {
      if (!params.Hnw.isFinishing())
      {
        paramo.setInputMethodMode(1);
        paramo.setSoftInputMode(16);
        paramo.setFocusable(true);
        paramo.setTouchable(true);
        paramo.showAtLocation(params.Hnw.getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(31406);
      return;
    }
    catch (Exception params)
    {
      ac.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { params.getMessage() });
      ac.printErrStackTrace("MicroMsg.MMConfirmDialog", params, "", new Object[0]);
      AppMethodBeat.o(31406);
    }
  }
  
  private static void a(s params, d.a parama, y.a parama1, final View paramView, String paramString)
  {
    AppMethodBeat.i(31401);
    String str;
    if (!bs.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = params.Hnw.getResources().getString(2131757562);
    }
    parama.aRO(str).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(196119);
        if (this.DqP != null) {
          this.DqP.a(true, o.fC(paramView), o.fD(paramView));
        }
        AppMethodBeat.o(196119);
      }
    });
    parama.acN(2131755691).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31358);
        if (this.DqP != null) {
          this.DqP.a(false, null, 0);
        }
        AppMethodBeat.o(31358);
      }
    });
    AppMethodBeat.o(31401);
  }
  
  public static void a(s params, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31397);
    params = new a(params.Hnw).dM(paramString1).aHp(paramString2).i(Boolean.FALSE);
    params.DqS = paramString3;
    params.a(parama).iJj.show();
    AppMethodBeat.o(31397);
  }
  
  private static void a(d.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(31402);
    parama.aRH(paramString);
    parama.acG(paramContext.getResources().getColor(2131100711));
    parama.acH(2);
    AppMethodBeat.o(31402);
  }
  
  private static void a(d.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31407);
    parama.a(new o.7(paramBitmap));
    AppMethodBeat.o(31407);
  }
  
  private static View aq(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31399);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(31399);
    return paramContext;
  }
  
  public static d b(s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31380);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31380);
      return null;
    }
    View localView = View.inflate(params.Hnw, 2131493587, null);
    d.a locala = new d.a(params.Hnw);
    locala.yf(false);
    locala.yg(false);
    a(locala, params.Hnw, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(2131298569);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(params, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(2131298568);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(params.Hnw, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298564).setVisibility(8);
    int i = BackwardSupportUtil.b.g(params.Hnw, 120.0F);
    params = (CdnImageView)localView.findViewById(2131298570);
    if (params != null) {
      params.aE(paramString2, i, i);
    }
    locala.gH(localView);
    params = locala.fvp();
    params.show();
    AppMethodBeat.o(31380);
    return params;
  }
  
  public static d b(s params, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31384);
    params = b(params, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31384);
    return params;
  }
  
  public static d b(s params, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31385);
    if ((paramString1 == null) || (!i.eA(paramString1)))
    {
      ac.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(31385);
      return null;
    }
    d.a locala = new d.a(params.Hnw);
    Object localObject = params.Hnw.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bs.S(((String)localObject).split(","));
      a(params.Hnw, locala, localObject);
    }
    locala.yd(true);
    locala.yf(false).yg(false);
    if (paramBoolean) {
      locala.ye(true);
    }
    if (!bs.isNullOrNil(paramString1))
    {
      localObject = f.aKz(paramString1);
      int i = BackwardSupportUtil.ExifHelper.ce(paramString1);
      if (localObject != null)
      {
        paramString1 = (String)localObject;
        if (i != 0) {
          paramString1 = f.a((Bitmap)localObject, i);
        }
        locala.a(paramString1, true, 3);
        a(locala, paramString1);
        locala.yd(false);
      }
    }
    paramString1 = locala.fvp();
    a(params.Hnw, paramString1, paramString2, null, parama, parama);
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
        ImageView localImageView = (ImageView)paramContext.findViewById(DqL[i]);
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
  
  private static com.tencent.mm.ui.base.o fB(View paramView)
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
    final d.a DqR;
    public String DqS;
    public d iJj;
    public DialogInterface.OnDismissListener mAn;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(31360);
      this.DqS = null;
      this.mContext = paramContext;
      this.DqR = new d.a(this.mContext);
      this.DqR.yf(false);
      this.DqR.yg(false);
      this.DqR.a(new d.a.d()
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
    
    public final a WV(int paramInt)
    {
      AppMethodBeat.i(31372);
      this.DqS = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(31372);
      return this;
    }
    
    public final a a(y.a parama)
    {
      AppMethodBeat.i(31373);
      this.iJj = this.DqR.fvp();
      if (this.mAn != null) {
        this.iJj.setOnDismissListener(this.mAn);
      }
      o.a(this.mContext, this.iJj, this.DqS, parama, parama);
      AppMethodBeat.o(31373);
      return this;
    }
    
    public final a a(d.a.b paramb)
    {
      AppMethodBeat.i(31368);
      this.DqR.c(paramb);
      AppMethodBeat.o(31368);
      return this;
    }
    
    public final a aHo(String paramString)
    {
      AppMethodBeat.i(31362);
      int i = com.tencent.mm.cc.a.fromDPToPix(this.mContext, (int)(20.0F * com.tencent.mm.cc.a.eb(this.mContext)));
      if (!bs.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.DqR.as(paramString);
      }
      AppMethodBeat.o(31362);
      return this;
    }
    
    public final a aHp(String paramString)
    {
      AppMethodBeat.i(31364);
      int i = com.tencent.mm.cc.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cc.a.eb(this.mContext)));
      if (!bs.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.ab(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.DqR.au(paramString);
      }
      AppMethodBeat.o(31364);
      return this;
    }
    
    public final a aHq(String paramString)
    {
      AppMethodBeat.i(31365);
      this.DqR.aRK(paramString);
      AppMethodBeat.o(31365);
      return this;
    }
    
    public final a aHr(String paramString)
    {
      AppMethodBeat.i(31367);
      o.a(this.mContext, this.DqR, paramString);
      this.DqR.yd(false);
      AppMethodBeat.o(31367);
      return this;
    }
    
    public final a dM(Object paramObject)
    {
      AppMethodBeat.i(31361);
      o.b(this.mContext, this.DqR, paramObject);
      this.DqR.yd(true);
      AppMethodBeat.o(31361);
      return this;
    }
    
    public final a eNB()
    {
      AppMethodBeat.i(31363);
      this.DqR.acK(2);
      AppMethodBeat.o(31363);
      return this;
    }
    
    public final a eNC()
    {
      this.DqR.Jfi.Gpb = 8;
      return this;
    }
    
    public final a eND()
    {
      AppMethodBeat.i(31371);
      this.DqR.yd(false);
      AppMethodBeat.o(31371);
      return this;
    }
    
    public final a fE(View paramView)
    {
      AppMethodBeat.i(31369);
      this.DqR.gH(paramView);
      AppMethodBeat.o(31369);
      return this;
    }
    
    public final a i(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(31366);
      this.DqR.a(paramBitmap, true, paramInt);
      this.DqR.yd(false);
      o.b(this.DqR, paramBitmap);
      AppMethodBeat.o(31366);
      return this;
    }
    
    public final a i(Boolean paramBoolean)
    {
      AppMethodBeat.i(31370);
      this.DqR.ye(paramBoolean.booleanValue());
      if (paramBoolean.booleanValue()) {
        this.DqR.aRM(this.mContext.getString(2131757559));
      }
      AppMethodBeat.o(31370);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o
 * JD-Core Version:    0.7.0.1
 */