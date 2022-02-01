package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.a.k;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.a.a;
import com.tencent.mm.ui.widget.a.e.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o
  implements y
{
  private static int[] GGM = { R.h.title_image_0, R.h.title_image_1, R.h.title_image_2, R.h.title_image_3, R.h.title_image_4, R.h.title_image_5, R.h.title_image_6, R.h.title_image_7, R.h.title_image_8 };
  
  private static void F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(31404);
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(R.h.confirm_dialog_text_et);
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
  
  public static v a(com.tencent.mm.ui.y paramy, long paramLong, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31396);
    final View localView = bn(paramy.getContext(), R.i.confirm_dialog_item8);
    final v localv = kI(localView);
    a(localView, parama, localv);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31396);
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, paramy.getContext().getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.cd.a.getScaleSize(paramy.getContext()));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cd.a.l(paramy.getContext(), R.e.normal_text_color));
    Object localObject = ((l)h.ax(l.class)).dW(paramLong);
    String str1;
    if ((localObject != null) && (((c)localObject).bHx()))
    {
      paramString1 = ((c)localObject).field_chatName;
      str1 = ((c)localObject).field_headImageUrl;
      localObject = ((c)localObject).field_brandUserName;
      String str2 = paramString1;
      if (paramString1 == null) {
        str2 = paramString2;
      }
      if (Util.isNullOrNil(str2)) {
        break label417;
      }
      localNoMeasuredTextView.setText(p.b(paramy.getContext(), str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.confirm_dialog_count_tv, null, true, 8);
      paramString1 = (Button)localView.findViewById(R.h.confirm_dialog_btn1);
      if (!Util.isNullOrNil(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (o.this != null) {
            o.this.onDialogClick(true, o.kJ(localView), o.kK(localView));
          }
          localv.dismiss();
          localv.setFocusable(false);
          localv.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31356);
        }
      });
      paramString1 = new c.a();
      paramString1.prefixPath = com.tencent.mm.api.a.hx((String)localObject);
      paramString1.oKp = true;
      paramString1.nqa = true;
      paramString1.oKB = R.k.default_avatar;
      paramString1 = paramString1.bKx();
      if (!Util.isNullOrNil(str1)) {
        r.bKe().a(str1, (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(paramy, localv);
      AppMethodBeat.o(31396);
      return localv;
      localObject = ((m)h.ax(m.class)).hM(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((k)localObject).field_userName;
        str1 = ((k)localObject).field_headImageUrl;
        localObject = ((k)localObject).field_brandUserName;
        break;
      }
      Log.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(31396);
      return null;
      label417:
      localNoMeasuredTextView.setText(p.b(paramy.getContext(), paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static v a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31395);
    final View localView = bn(paramy.getContext(), R.i.confirm_dialog_item8);
    final v localv = kI(localView);
    a(localView, parama, localv);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31395);
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, paramy.getContext().getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.cd.a.getScaleSize(paramy.getContext()));
    paramString2.setTextColor(com.tencent.mm.cd.a.l(paramy.getContext(), R.e.normal_text_color));
    if (!Util.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).b(paramy.getContext(), ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.confirm_dialog_count_tv, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(R.h.confirm_dialog_btn1);
      if (!Util.isNullOrNil(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31355);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (o.this != null) {
            o.this.onDialogClick(true, o.kJ(localView), o.kK(localView));
          }
          localv.dismiss();
          localv.setFocusable(false);
          localv.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31355);
        }
      });
      if (!Util.isNullOrNil(paramString1)) {
        a.b.g((ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(paramy, localv);
      AppMethodBeat.o(31395);
      return localv;
      paramString2.setText(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).b(paramy.getContext(), paramString3, paramString2.getTextSize()));
    }
  }
  
  public static e a(com.tencent.mm.ui.y paramy, int paramInt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31388);
    paramy = a(paramy, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31388);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, int paramInt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31389);
    e.a locala = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      b(paramy.getContext(), locala, localObject);
    }
    locala.NA(true);
    if (paramInt == R.k.app_attach_file_icon_file) {
      localObject = paramy.getContext().getResources().getString(R.l.app_file);
    }
    for (;;)
    {
      locala.be((String)localObject + paramString1).NC(false).ND(false);
      if (paramBoolean) {
        locala.NB(true);
      }
      paramString1 = locala.jHH();
      a(paramy.getContext(), paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(31389);
      return paramString1;
      if (paramInt == R.k.app_attach_file_icon_music) {
        localObject = paramy.getContext().getResources().getString(R.l.app_music);
      } else if (paramInt == R.k.app_attach_file_icon_video) {
        localObject = paramy.getContext().getResources().getString(R.l.app_video);
      } else {
        localObject = paramy.getContext().getResources().getString(R.l.app_app);
      }
    }
  }
  
  public static e a(com.tencent.mm.ui.y paramy, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31392);
    View localView = bn(paramy.getContext(), R.i.confirm_dialog_item4);
    e.a locala = new e.a(paramy.getContext());
    locala.NC(false);
    locala.ND(false);
    F(localView, true);
    a(paramy, locala, parama, localView, paramy.getContext().getResources().getString(R.l.confirm_dialog_share));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(p.b(paramy.getContext(), paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(p.b(paramy.getContext(), paramString2, paramString1.getTextSize()));
    paramy = (TextView)localView.findViewById(R.h.confirm_dialog_content_desc_tv);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramy.setVisibility(8);
      paramy = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
      if (paramy != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label245;
        }
        Log.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        paramy.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.md(localView);
      paramy = locala.jHH();
      paramy.show();
      AppMethodBeat.o(31392);
      return paramy;
      paramy.setText(paramString3);
      paramy.setVisibility(0);
      break;
      label245:
      paramy.setVisibility(0);
      paramy.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt, y.a parama)
  {
    AppMethodBeat.i(245284);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(245284);
      return null;
    }
    View localView = bn(paramy.getContext(), R.i.confirm_dialog_item6);
    e.a locala = new e.a(paramy.getContext());
    locala.NC(false);
    locala.ND(false);
    F(localView, false);
    a(paramy, locala, parama, localView, paramy.getContext().getResources().getString(paramInt));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(p.b(paramy.getContext(), paramString1, parama.getTextSize()));
    parama.getPaint().setFakeBoldText(true);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(p.b(paramy.getContext(), paramString2, paramString1.getTextSize()));
    paramy = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramy != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label243;
      }
      paramy.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
    for (;;)
    {
      locala.md(localView);
      paramy = locala.jHH();
      paramy.show();
      AppMethodBeat.o(245284);
      return paramy;
      label243:
      if (!Util.isNullOrNil(paramString3))
      {
        paramString1 = r.bKe();
        paramBitmap = new c.a();
        paramBitmap.oKB = R.g.brand_default_head;
        paramBitmap.oKo = true;
        paramBitmap.nrc = true;
        paramString1.a(paramString3, paramy, paramBitmap.bKx());
      }
      else
      {
        paramy.setImageResource(R.g.brand_default_head);
      }
    }
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, View paramView, String paramString2, y.b paramb)
  {
    AppMethodBeat.i(31398);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31398);
      return null;
    }
    e.a locala = new e.a(paramy.getContext());
    locala.NC(false);
    locala.ND(false);
    a(locala, paramy.getContext(), paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramy.getContext().getResources().getString(R.l.confirm_dialog_share);
    }
    locala.bDC(paramString1).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31343);
        if (o.this != null) {
          o.this.onDialogClick(true);
        }
        AppMethodBeat.o(31343);
      }
    });
    locala.aES(R.l.app_cancel).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31344);
        if (o.this != null) {
          o.this.onDialogClick(false);
        }
        AppMethodBeat.o(31344);
      }
    });
    locala.md(paramView);
    paramString1 = locala.jHH();
    paramString1.ayi(paramy.getContext().getResources().getColor(R.e.brand_text_color));
    paramString1.show();
    AppMethodBeat.o(31398);
    return paramString1;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31381);
    paramy = a(paramy, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(31381);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, y.a parama)
  {
    AppMethodBeat.i(31377);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31377);
      return null;
    }
    View localView = View.inflate(paramy.getContext(), R.i.confirm_dialog_item1, null);
    e.a locala = new e.a(paramy.getContext());
    locala.NC(false);
    locala.ND(false);
    a(locala, paramy.getContext(), paramString1);
    F(localView, paramBoolean);
    a(paramy, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(p.b(paramy.getContext(), paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramy.getContext(), 120.0F);
    paramy = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramy != null) {
      paramy.aW(paramString2, i, i);
    }
    locala.md(localView);
    paramy = locala.jHH();
    paramy.show();
    AppMethodBeat.o(31377);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31378);
    paramy = a(paramy, paramString1, paramString2, paramBoolean, paramString3, parama, paramy.getContext().getResources().getString(R.l.app_url));
    AppMethodBeat.o(31378);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama, String paramString4)
  {
    AppMethodBeat.i(31379);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31379);
      return null;
    }
    paramString2 = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      b(paramy.getContext(), paramString2, localObject);
    }
    paramString2.NA(true);
    paramString2.be(paramString4 + paramString1).NC(false).ND(false);
    if (paramBoolean) {
      paramString2.NB(true);
    }
    paramString1 = paramString2.jHH();
    a(paramy.getContext(), paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31379);
    return paramString1;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString, boolean paramBoolean, int paramInt, y.a parama)
  {
    AppMethodBeat.i(31390);
    paramy = a(paramy, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(31390);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, boolean paramBoolean, int paramInt, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31391);
    e.a locala = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = Util.stringsToList(((String)localObject).split(","));; localObject = null)
    {
      b(paramy.getContext(), locala, localObject);
      locala.NA(true);
      switch (paramInt)
      {
      default: 
        localObject = paramy.getContext().getResources().getString(R.l.app_app);
      }
      for (;;)
      {
        locala.be((String)localObject + paramString1).NC(false).ND(false);
        if (paramBoolean) {
          locala.NB(true);
        }
        paramString1 = locala.jHH();
        a(paramy.getContext(), paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(31391);
        return paramString1;
        localObject = paramy.getContext().getResources().getString(R.l.app_video);
        continue;
        localObject = paramy.getContext().getResources().getString(R.l.app_music);
      }
    }
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31382);
    paramy = a(paramy, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31382);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31383);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(31383);
      return null;
    }
    e.a locala = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      b(paramy.getContext(), locala, localObject);
    }
    locala.NA(true);
    locala.be(paramString1).NC(false).ND(false);
    if (paramBoolean) {
      locala.NB(true);
    }
    paramString1 = locala.jHH();
    a(paramy.getContext(), paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31383);
    return paramString1;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, byte[] paramArrayOfByte, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31386);
    paramy = a(paramy, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(31386);
    return paramy;
  }
  
  public static e a(com.tencent.mm.ui.y paramy, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, y.a parama)
  {
    AppMethodBeat.i(31387);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(31387);
      return null;
    }
    e.a locala = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      b(paramy.getContext(), locala, localObject);
    }
    locala.NA(true);
    locala.NC(false).ND(false);
    if (paramBoolean) {
      locala.NB(true);
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
        locala.NA(false);
      }
    }
    paramArrayOfByte = locala.jHH();
    a(paramy.getContext(), paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    AppMethodBeat.o(31387);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, e parame, String paramString1, String paramString2, y.a parama1, y.a parama2)
  {
    AppMethodBeat.i(31376);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      paramString2 = paramContext.getResources().getString(R.l.confirm_dialog_share);
    }
    if (!Util.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    paramContext = paramContext.getResources().getString(R.l.app_cancel);
    parame.a(paramString2, true, new o.10(parame, parama1));
    parame.b(paramContext, true, new o.11(parame, parama2));
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
  
  private static void a(final View paramView, y.a parama, final v paramv)
  {
    AppMethodBeat.i(31403);
    ((Button)paramView.findViewById(R.h.confirm_dialog_btn1)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(245233);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (o.this != null) {
          o.this.onDialogClick(true, o.kJ(paramView), o.kK(paramView));
        }
        paramv.dismiss();
        paramv.setFocusable(false);
        paramv.setTouchable(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245233);
      }
    });
    paramView = (Button)paramView.findViewById(R.h.confirm_dialog_btn2);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31346);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (o.this != null) {
            o.this.onDialogClick(false, null, 0);
          }
          paramv.dismiss();
          paramv.setFocusable(false);
          paramv.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31346);
        }
      });
    }
    AppMethodBeat.o(31403);
  }
  
  private static void a(e.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(31402);
    parama.bDv(paramString);
    parama.aEL(paramContext.getResources().getColor(R.e.normal_text_color));
    parama.aEM(2);
    AppMethodBeat.o(31402);
  }
  
  private static void a(e.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31407);
    parama.c(new o.7(paramBitmap));
    AppMethodBeat.o(31407);
  }
  
  private static void a(com.tencent.mm.ui.y paramy, v paramv)
  {
    AppMethodBeat.i(31406);
    try
    {
      if (!paramy.getContext().isFinishing())
      {
        paramv.setInputMethodMode(1);
        paramv.setSoftInputMode(16);
        paramv.setFocusable(true);
        paramv.setTouchable(true);
        paramv.showAtLocation(paramy.getContext().getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(31406);
      return;
    }
    catch (Exception paramy)
    {
      Log.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paramy.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMConfirmDialog", paramy, "", new Object[0]);
      AppMethodBeat.o(31406);
    }
  }
  
  private static void a(com.tencent.mm.ui.y paramy, e.a parama, y.a parama1, final View paramView, String paramString)
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
      str = paramy.getContext().getResources().getString(R.l.confirm_dialog_share);
    }
    parama.bDC(str).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(245287);
        if (o.this != null) {
          o.this.onDialogClick(true, o.kJ(paramView), o.kK(paramView));
        }
        AppMethodBeat.o(245287);
      }
    });
    parama.aES(R.l.app_cancel).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31358);
        if (o.this != null) {
          o.this.onDialogClick(false, null, 0);
        }
        AppMethodBeat.o(31358);
      }
    });
    AppMethodBeat.o(31401);
  }
  
  public static void a(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31397);
    paramy = new o.a(paramy.getContext()).gA(paramString1).JH(true).bra(paramString2).I(Boolean.FALSE);
    paramy.GGQ = paramString3;
    paramy.b(parama).pRv.show();
    AppMethodBeat.o(31397);
  }
  
  public static e b(com.tencent.mm.ui.y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31380);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31380);
      return null;
    }
    View localView = View.inflate(paramy.getContext(), R.i.confirm_dialog_item1, null);
    e.a locala = new e.a(paramy.getContext());
    locala.NC(false);
    locala.ND(false);
    a(locala, paramy.getContext(), paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(R.h.confirm_dialog_text_et);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paramy, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(p.b(paramy.getContext(), paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramy.getContext(), 120.0F);
    paramy = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramy != null) {
      paramy.aW(paramString2, i, i);
    }
    locala.md(localView);
    paramy = locala.jHH();
    paramy.show();
    AppMethodBeat.o(31380);
    return paramy;
  }
  
  public static e b(com.tencent.mm.ui.y paramy, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31384);
    paramy = b(paramy, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31384);
    return paramy;
  }
  
  public static e b(com.tencent.mm.ui.y paramy, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31385);
    if ((paramString1 == null) || (!com.tencent.mm.vfs.y.ZC(paramString1)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(31385);
      return null;
    }
    e.a locala = new e.a(paramy.getContext());
    Object localObject = paramy.getContext().getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      b(paramy.getContext(), locala, localObject);
    }
    locala.NA(true);
    locala.NC(false).ND(false);
    if (paramBoolean) {
      locala.NB(true);
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
        locala.NA(false);
      }
    }
    paramString1 = locala.jHH();
    a(paramy.getContext(), paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31385);
    return paramString1;
  }
  
  private static void b(Context paramContext, e.a parama, final Object paramObject)
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
          int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cd.a.getScaleSize(paramContext)));
          Object localObject1 = paramContext.getString(R.l.retransmit_to_conv_comfirm);
          parama.bc(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(paramContext, ((String)localObject1).toString(), i)).aEN(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramObject);
          i = com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cd.a.getScaleSize(paramContext)));
          if (au.bwE(paramObject))
          {
            Object localObject2 = paramContext.getString(R.l.gUy, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.a)h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).getMembersCountByChatRoomName(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = af.mU(paramContext).inflate(R.i.dialog_chatroom_avater_detail, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(R.h.chatroom_avatar_detail);
            final ArrayList localArrayList = new ArrayList();
            final List localList = ((com.tencent.mm.plugin.chatroom.a.a)h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).Il(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new e.a.c()new e.a.a
            {
              public final void flT()
              {
                AppMethodBeat.i(31342);
                Util.hideVKB(o.this);
                if ((localArrayList.size() == 0) && (!Util.isNullOrNil(paramObject))) {
                  o.a(localArrayList, localList);
                }
                AppMethodBeat.o(31342);
              }
            }, new e.a.a()
            {
              public final void k(ImageView paramAnonymousImageView, String paramAnonymousString)
              {
                AppMethodBeat.i(31348);
                com.tencent.mm.ui.i.a.a.g(paramAnonymousImageView, paramAnonymousString);
                AppMethodBeat.o(31348);
              }
            });
            localGridView.setAdapter(new t(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(R.e.transparent)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label448;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.br(paramContext, R.f.DialogTitleDetailMaxHeight)));
              localGridView.setPadding(com.tencent.mm.cd.a.br(paramContext, R.f.DialogEdgePadding), 0, com.tencent.mm.cd.a.br(paramContext, R.f.DialogEdgePadding), 0);
            }
            for (;;)
            {
              parama.mf((View)localObject2);
              AppMethodBeat.o(31374);
              return;
              label448:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cd.a.br(paramContext, R.f.DialogAvatarLinePadding));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new e.a.a()
          {
            public final void k(ImageView paramAnonymousImageView, String paramAnonymousString)
            {
              AppMethodBeat.i(31352);
              com.tencent.mm.ui.i.a.a.g(paramAnonymousImageView, paramAnonymousString);
              AppMethodBeat.o(31352);
            }
          });
          AppMethodBeat.o(31374);
          return;
        }
        parama.me(c(paramContext, paramObject));
        parama.bDv(paramContext.getString(R.l.multi_retransmit_comfirm)).aEN(3);
        AppMethodBeat.o(31374);
        return;
      }
      paramObject = null;
    }
  }
  
  private static View bn(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31399);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(31399);
    return paramContext;
  }
  
  private static View c(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(31375);
    paramContext = View.inflate(paramContext, R.i.confirm_dialog_title_multi_image, null);
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
        ImageView localImageView = (ImageView)paramContext.findViewById(GGM[i]);
        if (str == null) {
          break label102;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.i.a.a.g(localImageView, str);
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
  
  private static v kI(View paramView)
  {
    AppMethodBeat.i(31400);
    paramView = new v(paramView, -1, -1);
    AppMethodBeat.o(31400);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o
 * JD-Core Version:    0.7.0.1
 */