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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.ui.widget.a.d.a.c;
import com.tencent.mm.ui.widget.a.d.a.d;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o
  implements y
{
  private static int[] Kfa = { 2131309221, 2131309222, 2131309223, 2131309224, 2131309225, 2131309226, 2131309227, 2131309228, 2131309229 };
  
  public static p a(com.tencent.mm.ui.t paramt, long paramLong, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31396);
    View localView = aC(paramt.OGe, 2131493708);
    p localp = gi(localView);
    a(localView, parama, localp);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31396);
      return null;
    }
    a(localView, 2131299006, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(2131299003);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, paramt.OGe.getResources().getDimension(2131165195) * com.tencent.mm.cb.a.ez(paramt.OGe));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cb.a.m(paramt.OGe, 2131100904));
    Object localObject = ((com.tencent.mm.api.k)g.af(com.tencent.mm.api.k.class)).bs(paramLong);
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
      if (Util.isNullOrNil(str2)) {
        break label406;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131299000, null, true, 8);
      paramString1 = (Button)localView.findViewById(2131298992);
      if (!Util.isNullOrNil(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new o.13(parama, localView, localp));
      paramString1 = new c.a();
      paramString1.prefixPath = com.tencent.mm.api.a.fe((String)localObject);
      paramString1.jbf = true;
      paramString1.hZF = true;
      paramString1.jbq = 2131690042;
      paramString1 = paramString1.bdv();
      if (!Util.isNullOrNil(str1)) {
        q.bcV().a(str1, (ImageView)localView.findViewById(2131299005), paramString1);
      }
      a(paramt, localp);
      AppMethodBeat.o(31396);
      return localp;
      localObject = ((com.tencent.mm.api.l)g.af(com.tencent.mm.api.l.class)).fB(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.al.a.k)localObject).field_userName;
        str1 = ((com.tencent.mm.al.a.k)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.al.a.k)localObject).field_brandUserName;
        break;
      }
      Log.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(31396);
      return null;
      label406:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static p a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31395);
    View localView = aC(paramt.OGe, 2131493708);
    p localp = gi(localView);
    a(localView, parama, localp);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31395);
      return null;
    }
    a(localView, 2131299006, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(2131299003);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, paramt.OGe.getResources().getDimension(2131165195) * com.tencent.mm.cb.a.ez(paramt.OGe));
    paramString2.setTextColor(com.tencent.mm.cb.a.m(paramt.OGe, 2131100904));
    if (!Util.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).b(paramt.OGe, ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131299000, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(2131298992);
      if (!Util.isNullOrNil(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new o.12(parama, localView, localp));
      if (!Util.isNullOrNil(paramString1)) {
        a.b.c((ImageView)localView.findViewById(2131299005), paramString1);
      }
      a(paramt, localp);
      AppMethodBeat.o(31395);
      return localp;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).b(paramt.OGe, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static d a(com.tencent.mm.ui.t paramt, int paramInt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31388);
    paramt = a(paramt, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31388);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, int paramInt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31389);
    d.a locala = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramt.OGe, locala, localObject);
    }
    locala.Di(true);
    if (paramInt == 2131689562) {
      localObject = paramt.OGe.getResources().getString(2131755851);
    }
    for (;;)
    {
      locala.aB((String)localObject + paramString1).Dk(false).Dl(false);
      if (paramBoolean) {
        locala.Dj(true);
      }
      paramString1 = locala.hbn();
      a(paramt.OGe, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(31389);
      return paramString1;
      if (paramInt == 2131689567) {
        localObject = paramt.OGe.getResources().getString(2131755905);
      } else if (paramInt == 2131689584) {
        localObject = paramt.OGe.getResources().getString(2131756018);
      } else {
        localObject = paramt.OGe.getResources().getString(2131755313);
      }
    }
  }
  
  public static d a(com.tencent.mm.ui.t paramt, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31392);
    View localView = aC(paramt.OGe, 2131493705);
    d.a locala = new d.a(paramt.OGe);
    locala.Dk(false);
    locala.Dl(false);
    x(localView, true);
    a(paramt, locala, parama, localView, paramt.OGe.getResources().getString(2131757789));
    parama = (TextView)localView.findViewById(2131299006);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(2131299003);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString2, paramString1.getTextSize()));
    paramt = (TextView)localView.findViewById(2131298999);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramt.setVisibility(8);
      paramt = (ImageView)localView.findViewById(2131299005);
      if (paramt != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label242;
        }
        Log.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        paramt.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.hs(localView);
      paramt = locala.hbn();
      paramt.show();
      AppMethodBeat.o(31392);
      return paramt;
      paramt.setText(paramString3);
      paramt.setVisibility(0);
      break;
      label242:
      paramt.setVisibility(0);
      paramt.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(232196);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(232196);
      return null;
    }
    View localView = aC(paramt.OGe, 2131493706);
    d.a locala = new d.a(paramt.OGe);
    locala.Dk(false);
    locala.Dl(false);
    x(localView, false);
    a(paramt, locala, parama, localView, paramt.OGe.getResources().getString(2131757816));
    parama = (TextView)localView.findViewById(2131299006);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString1, parama.getTextSize()));
    parama.getPaint().setFakeBoldText(true);
    paramString1 = (TextView)localView.findViewById(2131299003);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString2, paramString1.getTextSize()));
    paramt = (ImageView)localView.findViewById(2131299005);
    if (paramt != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label241;
      }
      paramt.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
    for (;;)
    {
      locala.hs(localView);
      paramt = locala.hbn();
      paramt.show();
      AppMethodBeat.o(232196);
      return paramt;
      label241:
      if (!Util.isNullOrNil(paramString3))
      {
        paramString1 = q.bcV();
        paramBitmap = new c.a();
        paramBitmap.jbq = 2131231405;
        paramBitmap.jbe = true;
        paramBitmap.iaT = true;
        paramString1.a(paramString3, paramt, paramBitmap.bdv());
      }
      else
      {
        paramt.setImageResource(2131231405);
      }
    }
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, View paramView, String paramString2, y.b paramb)
  {
    AppMethodBeat.i(31398);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31398);
      return null;
    }
    d.a locala = new d.a(paramt.OGe);
    locala.Dk(false);
    locala.Dl(false);
    a(locala, paramt.OGe, paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramt.OGe.getResources().getString(2131757789);
    }
    locala.bou(paramString1).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31343);
        if (this.Kfd != null) {
          this.Kfd.qB(true);
        }
        AppMethodBeat.o(31343);
      }
    });
    locala.aoW(2131755761).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31344);
        if (this.Kfd != null) {
          this.Kfd.qB(false);
        }
        AppMethodBeat.o(31344);
      }
    });
    locala.hs(paramView);
    paramString1 = locala.hbn();
    paramString1.ajL(paramt.OGe.getResources().getColor(2131100063));
    paramString1.show();
    AppMethodBeat.o(31398);
    return paramString1;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31381);
    paramt = a(paramt, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(31381);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, y.a parama)
  {
    AppMethodBeat.i(31377);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31377);
      return null;
    }
    View localView = View.inflate(paramt.OGe, 2131493704, null);
    d.a locala = new d.a(paramt.OGe);
    locala.Dk(false);
    locala.Dl(false);
    a(locala, paramt.OGe, paramString1);
    x(localView, paramBoolean);
    a(paramt, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(2131299003);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298999).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramt.OGe, 120.0F);
    paramt = (CdnImageView)localView.findViewById(2131299005);
    if (paramt != null) {
      paramt.aM(paramString2, i, i);
    }
    locala.hs(localView);
    paramt = locala.hbn();
    paramt.show();
    AppMethodBeat.o(31377);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31378);
    paramt = a(paramt, paramString1, paramString2, paramBoolean, paramString3, parama, paramt.OGe.getResources().getString(2131756012));
    AppMethodBeat.o(31378);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama, String paramString4)
  {
    AppMethodBeat.i(31379);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31379);
      return null;
    }
    paramString2 = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramt.OGe, paramString2, localObject);
    }
    paramString2.Di(true);
    paramString2.aB(paramString4 + paramString1).Dk(false).Dl(false);
    if (paramBoolean) {
      paramString2.Dj(true);
    }
    paramString1 = paramString2.hbn();
    a(paramt.OGe, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31379);
    return paramString1;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString, boolean paramBoolean, int paramInt, y.a parama)
  {
    AppMethodBeat.i(31390);
    paramt = a(paramt, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(31390);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, boolean paramBoolean, int paramInt, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31391);
    d.a locala = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = Util.stringsToList(((String)localObject).split(","));; localObject = null)
    {
      a(paramt.OGe, locala, localObject);
      locala.Di(true);
      switch (paramInt)
      {
      default: 
        localObject = paramt.OGe.getResources().getString(2131755313);
      }
      for (;;)
      {
        locala.aB((String)localObject + paramString1).Dk(false).Dl(false);
        if (paramBoolean) {
          locala.Dj(true);
        }
        paramString1 = locala.hbn();
        a(paramt.OGe, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(31391);
        return paramString1;
        localObject = paramt.OGe.getResources().getString(2131756018);
        continue;
        localObject = paramt.OGe.getResources().getString(2131755905);
      }
    }
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31382);
    paramt = a(paramt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31382);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31383);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(31383);
      return null;
    }
    d.a locala = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramt.OGe, locala, localObject);
    }
    locala.Di(true);
    locala.aB(paramString1).Dk(false).Dl(false);
    if (paramBoolean) {
      locala.Dj(true);
    }
    paramString1 = locala.hbn();
    a(paramt.OGe, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31383);
    return paramString1;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, byte[] paramArrayOfByte, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31386);
    paramt = a(paramt, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(31386);
    return paramt;
  }
  
  public static d a(com.tencent.mm.ui.t paramt, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, y.a parama)
  {
    AppMethodBeat.i(31387);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(31387);
      return null;
    }
    d.a locala = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramt.OGe, locala, localObject);
    }
    locala.Di(true);
    locala.Dk(false).Dl(false);
    if (paramBoolean) {
      locala.Dj(true);
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
          paramArrayOfByte = BitmapUtil.rotate((Bitmap)localObject, i);
        }
        locala.b(paramArrayOfByte, true, 3);
        a(locala, paramArrayOfByte);
        locala.Di(false);
      }
    }
    paramArrayOfByte = locala.hbn();
    a(paramt.OGe, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    AppMethodBeat.o(31387);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, d.a parama, final Object paramObject)
  {
    AppMethodBeat.i(31374);
    if (paramObject != null) {
      if ((paramObject instanceof String)) {
        paramObject = Util.stringsToList(((String)paramObject).split(","));
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramObject))
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
          int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cb.a.ez(paramContext)));
          Object localObject1 = paramContext.getString(2131764633);
          parama.az(((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i)).aoR(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramObject);
          i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cb.a.ez(paramContext)));
          if (ab.Eq(paramObject))
          {
            Object localObject2 = paramContext.getString(2131765130, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b)g.af(com.tencent.mm.plugin.chatroom.a.b.class)).Ie(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = aa.jQ(paramContext).inflate(2131493843, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(2131298297);
            final ArrayList localArrayList = new ArrayList();
            final List localList = ((com.tencent.mm.plugin.chatroom.a.b)g.af(com.tencent.mm.plugin.chatroom.a.b.class)).Ic(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new d.a.c()new o.6
            {
              public final void gpw()
              {
                AppMethodBeat.i(31342);
                Util.hideVKB(this.Kfb);
                if ((localArrayList.size() == 0) && (!Util.isNullOrNil(paramObject))) {
                  o.a(localArrayList, localList);
                }
                AppMethodBeat.o(31342);
              }
            }, new o.6());
            localGridView.setAdapter(new t(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(2131101287)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label447;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.aG(paramContext, 2131165269)));
              localGridView.setPadding(com.tencent.mm.cb.a.aG(paramContext, 2131165265), 0, com.tencent.mm.cb.a.aG(paramContext, 2131165265), 0);
            }
            for (;;)
            {
              parama.QNF.NIo = ((View)localObject2);
              AppMethodBeat.o(31374);
              return;
              label447:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cb.a.aG(paramContext, 2131165262));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new o.9());
          AppMethodBeat.o(31374);
          return;
        }
        parama.ht(d(paramContext, paramObject));
        parama.bon(paramContext.getString(2131763224)).aoR(3);
        AppMethodBeat.o(31374);
        return;
      }
      paramObject = null;
    }
  }
  
  private static void a(Context paramContext, d paramd, String paramString1, String paramString2, y.a parama1, y.a parama2)
  {
    AppMethodBeat.i(31376);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      paramString2 = paramContext.getResources().getString(2131757789);
    }
    if (!Util.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    paramContext = paramContext.getResources().getString(2131755761);
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
      if ((!paramBoolean) || (!Util.isNullOrNil(paramString))) {
        break;
      }
      paramView.setVisibility(paramInt2);
      AppMethodBeat.o(31405);
      return;
    }
    paramView.setText(paramString);
    AppMethodBeat.o(31405);
  }
  
  private static void a(View paramView, y.a parama, p paramp)
  {
    AppMethodBeat.i(31403);
    ((Button)paramView.findViewById(2131298992)).setOnClickListener(new o.4(parama, paramView, paramp));
    paramView = (Button)paramView.findViewById(2131298993);
    if (paramView != null) {
      paramView.setOnClickListener(new o.5(parama, paramp));
    }
    AppMethodBeat.o(31403);
  }
  
  private static void a(com.tencent.mm.ui.t paramt, p paramp)
  {
    AppMethodBeat.i(31406);
    try
    {
      if (!paramt.OGe.isFinishing())
      {
        paramp.setInputMethodMode(1);
        paramp.setSoftInputMode(16);
        paramp.setFocusable(true);
        paramp.setTouchable(true);
        paramp.showAtLocation(paramt.OGe.getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(31406);
      return;
    }
    catch (Exception paramt)
    {
      Log.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paramt.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMConfirmDialog", paramt, "", new Object[0]);
      AppMethodBeat.o(31406);
    }
  }
  
  private static void a(com.tencent.mm.ui.t paramt, d.a parama, y.a parama1, View paramView, String paramString)
  {
    AppMethodBeat.i(31401);
    String str;
    if (!Util.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = paramt.OGe.getResources().getString(2131757789);
    }
    parama.bou(str).c(new o.14(parama1, paramView));
    parama.aoW(2131755761).d(new o.15(parama1));
    AppMethodBeat.o(31401);
  }
  
  public static void a(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31397);
    paramt = new a(paramt.OGe).ea(paramString1).beQ(paramString2).p(Boolean.FALSE);
    paramt.Kfh = paramString3;
    paramt.a(parama).kdo.show();
    AppMethodBeat.o(31397);
  }
  
  private static void a(d.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(31402);
    parama.bon(paramString);
    parama.aoP(paramContext.getResources().getColor(2131100904));
    parama.aoQ(2);
    AppMethodBeat.o(31402);
  }
  
  private static void a(d.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31407);
    parama.a(new o.7(paramBitmap));
    AppMethodBeat.o(31407);
  }
  
  private static View aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31399);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(31399);
    return paramContext;
  }
  
  public static d b(com.tencent.mm.ui.t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31380);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31380);
      return null;
    }
    View localView = View.inflate(paramt.OGe, 2131493704, null);
    d.a locala = new d.a(paramt.OGe);
    locala.Dk(false);
    locala.Dl(false);
    a(locala, paramt.OGe, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(2131299004);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paramt, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(2131299003);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramt.OGe, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131298999).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramt.OGe, 120.0F);
    paramt = (CdnImageView)localView.findViewById(2131299005);
    if (paramt != null) {
      paramt.aM(paramString2, i, i);
    }
    locala.hs(localView);
    paramt = locala.hbn();
    paramt.show();
    AppMethodBeat.o(31380);
    return paramt;
  }
  
  public static d b(com.tencent.mm.ui.t paramt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31384);
    paramt = b(paramt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31384);
    return paramt;
  }
  
  public static d b(com.tencent.mm.ui.t paramt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31385);
    if ((paramString1 == null) || (!s.YS(paramString1)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(31385);
      return null;
    }
    d.a locala = new d.a(paramt.OGe);
    Object localObject = paramt.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramt.OGe, locala, localObject);
    }
    locala.Di(true);
    locala.Dk(false).Dl(false);
    if (paramBoolean) {
      locala.Dj(true);
    }
    if (!Util.isNullOrNil(paramString1))
    {
      localObject = BitmapUtil.getBitmapNative(paramString1);
      int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString1);
      if (localObject != null)
      {
        paramString1 = (String)localObject;
        if (i != 0) {
          paramString1 = BitmapUtil.rotate((Bitmap)localObject, i);
        }
        locala.b(paramString1, true, 3);
        a(locala, paramString1);
        locala.Di(false);
      }
    }
    paramString1 = locala.hbn();
    a(paramt.OGe, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31385);
    return paramString1;
  }
  
  private static View d(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(31375);
    paramContext = View.inflate(paramContext, 2131493711, null);
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
        ImageView localImageView = (ImageView)paramContext.findViewById(Kfa[i]);
        if (str == null) {
          break label102;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.g.a.a.c(localImageView, str);
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
  
  private static p gi(View paramView)
  {
    AppMethodBeat.i(31400);
    paramView = new p(paramView, -1, -1);
    AppMethodBeat.o(31400);
    return paramView;
  }
  
  private static void x(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(31404);
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(2131299004);
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
    final d.a Kfg;
    public String Kfh;
    public d kdo;
    Context mContext;
    public DialogInterface.OnDismissListener opQ;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(31360);
      this.Kfh = null;
      this.mContext = paramContext;
      this.Kfg = new d.a(this.mContext);
      this.Kfg.Dk(false);
      this.Kfg.Dl(false);
      this.Kfg.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(31359);
          paramAnonymousCharSequence = ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(o.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(31359);
          return paramAnonymousCharSequence;
        }
      });
      AppMethodBeat.o(31360);
    }
    
    public final a a(y.a parama)
    {
      AppMethodBeat.i(31373);
      this.kdo = this.Kfg.hbn();
      if (this.opQ != null) {
        this.kdo.setOnDismissListener(this.opQ);
      }
      o.a(this.mContext, this.kdo, this.Kfh, parama, parama);
      AppMethodBeat.o(31373);
      return this;
    }
    
    public final a a(EmojiInfo paramEmojiInfo, String paramString)
    {
      AppMethodBeat.i(232195);
      o.a(this.mContext, this.Kfg, paramEmojiInfo, paramString);
      this.Kfg.Di(false);
      AppMethodBeat.o(232195);
      return this;
    }
    
    public final a a(d.a.b paramb)
    {
      AppMethodBeat.i(31368);
      this.Kfg.c(paramb);
      AppMethodBeat.o(31368);
      return this;
    }
    
    public final a aii(int paramInt)
    {
      AppMethodBeat.i(31372);
      this.Kfh = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(31372);
      return this;
    }
    
    public final a beP(String paramString)
    {
      AppMethodBeat.i(31362);
      int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int)(20.0F * com.tencent.mm.cb.a.ez(this.mContext)));
      if (!Util.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.Kfg.az(paramString);
      }
      AppMethodBeat.o(31362);
      return this;
    }
    
    public final a beQ(String paramString)
    {
      AppMethodBeat.i(31364);
      int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cb.a.ez(this.mContext)));
      if (!Util.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.Kfg.aB(paramString);
      }
      AppMethodBeat.o(31364);
      return this;
    }
    
    public final a beR(String paramString)
    {
      AppMethodBeat.i(31365);
      this.Kfg.boq(paramString);
      AppMethodBeat.o(31365);
      return this;
    }
    
    public final a beS(String paramString)
    {
      AppMethodBeat.i(31367);
      o.a(this.mContext, this.Kfg, paramString);
      this.Kfg.Di(false);
      AppMethodBeat.o(31367);
      return this;
    }
    
    public final a ea(Object paramObject)
    {
      AppMethodBeat.i(31361);
      o.b(this.mContext, this.Kfg, paramObject);
      this.Kfg.Di(true);
      AppMethodBeat.o(31361);
      return this;
    }
    
    public final a gl(View paramView)
    {
      AppMethodBeat.i(31369);
      this.Kfg.hs(paramView);
      AppMethodBeat.o(31369);
      return this;
    }
    
    public final a gpx()
    {
      AppMethodBeat.i(31363);
      this.Kfg.aoT(2);
      AppMethodBeat.o(31363);
      return this;
    }
    
    public final a gpy()
    {
      this.Kfg.QNF.NIu = 8;
      return this;
    }
    
    public final a gpz()
    {
      AppMethodBeat.i(31371);
      this.Kfg.Di(false);
      AppMethodBeat.o(31371);
      return this;
    }
    
    public final a l(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(31366);
      this.Kfg.b(paramBitmap, true, paramInt);
      this.Kfg.Di(false);
      o.b(this.Kfg, paramBitmap);
      AppMethodBeat.o(31366);
      return this;
    }
    
    public final a p(Boolean paramBoolean)
    {
      AppMethodBeat.i(31370);
      this.Kfg.Dj(paramBoolean.booleanValue());
      if (paramBoolean.booleanValue()) {
        this.Kfg.bos(this.mContext.getString(2131757786));
      }
      AppMethodBeat.o(31370);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o
 * JD-Core Version:    0.7.0.1
 */