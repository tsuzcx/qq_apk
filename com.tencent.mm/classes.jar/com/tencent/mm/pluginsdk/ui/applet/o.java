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
import com.tencent.mm.ao.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.d.a.a;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.ui.widget.a.d.a.c;
import com.tencent.mm.ui.widget.a.d.a.d;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o
  implements y
{
  private static int[] RfO = { R.h.title_image_0, R.h.title_image_1, R.h.title_image_2, R.h.title_image_3, R.h.title_image_4, R.h.title_image_5, R.h.title_image_6, R.h.title_image_7, R.h.title_image_8 };
  
  public static r a(w paramw, long paramLong, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31396);
    final View localView = aU(paramw.VZx, R.i.confirm_dialog_item8);
    final r localr = hs(localView);
    a(localView, parama, localr);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31396);
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, paramw.VZx.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.ci.a.ez(paramw.VZx));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.ci.a.l(paramw.VZx, R.e.normal_text_color));
    Object localObject = ((com.tencent.mm.api.k)h.ae(com.tencent.mm.api.k.class)).bF(paramLong);
    String str1;
    if ((localObject != null) && (((c)localObject).bjM()))
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
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, str2, localNoMeasuredTextView.getTextSize()));
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.RfS != null) {
            this.RfS.a(true, o.ht(localView), o.hu(localView));
          }
          localr.dismiss();
          localr.setFocusable(false);
          localr.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31356);
        }
      });
      paramString1 = new c.a();
      paramString1.prefixPath = com.tencent.mm.api.a.fU((String)localObject);
      paramString1.lRD = true;
      paramString1.kOl = true;
      paramString1.lRP = R.k.default_avatar;
      paramString1 = paramString1.bmL();
      if (!Util.isNullOrNil(str1)) {
        q.bml().a(str1, (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(paramw, localr);
      AppMethodBeat.o(31396);
      return localr;
      localObject = ((com.tencent.mm.api.l)h.ae(com.tencent.mm.api.l.class)).gm(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.ao.a.k)localObject).field_userName;
        str1 = ((com.tencent.mm.ao.a.k)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.ao.a.k)localObject).field_brandUserName;
        break;
      }
      Log.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(31396);
      return null;
      label417:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static r a(w paramw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31395);
    final View localView = aU(paramw.VZx, R.i.confirm_dialog_item8);
    final r localr = hs(localView);
    a(localView, parama, localr);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(31395);
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, paramw.VZx.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.ci.a.ez(paramw.VZx));
    paramString2.setTextColor(com.tencent.mm.ci.a.l(paramw.VZx, R.e.normal_text_color));
    if (!Util.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).b(paramw.VZx, ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramString1), paramString2.getTextSize()));
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.RfS != null) {
            this.RfS.a(true, o.ht(localView), o.hu(localView));
          }
          localr.dismiss();
          localr.setFocusable(false);
          localr.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31355);
        }
      });
      if (!Util.isNullOrNil(paramString1)) {
        a.b.c((ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(paramw, localr);
      AppMethodBeat.o(31395);
      return localr;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).b(paramw.VZx, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static d a(w paramw, int paramInt, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31388);
    paramw = a(paramw, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31388);
    return paramw;
  }
  
  public static d a(w paramw, int paramInt, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31389);
    d.a locala = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramw.VZx, locala, localObject);
    }
    locala.HE(true);
    if (paramInt == R.k.app_attach_file_icon_file) {
      localObject = paramw.VZx.getResources().getString(R.l.app_file);
    }
    for (;;)
    {
      locala.aQ((String)localObject + paramString1).HG(false).HH(false);
      if (paramBoolean) {
        locala.HF(true);
      }
      paramString1 = locala.icu();
      a(paramw.VZx, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(31389);
      return paramString1;
      if (paramInt == R.k.app_attach_file_icon_music) {
        localObject = paramw.VZx.getResources().getString(R.l.app_music);
      } else if (paramInt == R.k.app_attach_file_icon_video) {
        localObject = paramw.VZx.getResources().getString(R.l.app_video);
      } else {
        localObject = paramw.VZx.getResources().getString(R.l.app_app);
      }
    }
  }
  
  public static d a(w paramw, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31392);
    View localView = aU(paramw.VZx, R.i.confirm_dialog_item4);
    d.a locala = new d.a(paramw.VZx);
    locala.HG(false);
    locala.HH(false);
    z(localView, true);
    a(paramw, locala, parama, localView, paramw.VZx.getResources().getString(R.l.confirm_dialog_share));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString2, paramString1.getTextSize()));
    paramw = (TextView)localView.findViewById(R.h.confirm_dialog_content_desc_tv);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramw.setVisibility(8);
      paramw = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
      if (paramw != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label245;
        }
        Log.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        paramw.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.iI(localView);
      paramw = locala.icu();
      paramw.show();
      AppMethodBeat.o(31392);
      return paramw;
      paramw.setText(paramString3);
      paramw.setVisibility(0);
      break;
      label245:
      paramw.setVisibility(0);
      paramw.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static d a(w paramw, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt, y.a parama)
  {
    AppMethodBeat.i(292427);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(292427);
      return null;
    }
    View localView = aU(paramw.VZx, R.i.confirm_dialog_item6);
    d.a locala = new d.a(paramw.VZx);
    locala.HG(false);
    locala.HH(false);
    z(localView, false);
    a(paramw, locala, parama, localView, paramw.VZx.getResources().getString(paramInt));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString1, parama.getTextSize()));
    parama.getPaint().setFakeBoldText(true);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString2, paramString1.getTextSize()));
    paramw = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramw != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label243;
      }
      paramw.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
    for (;;)
    {
      locala.iI(localView);
      paramw = locala.icu();
      paramw.show();
      AppMethodBeat.o(292427);
      return paramw;
      label243:
      if (!Util.isNullOrNil(paramString3))
      {
        paramString1 = q.bml();
        paramBitmap = new c.a();
        paramBitmap.lRP = R.g.brand_default_head;
        paramBitmap.lRC = true;
        paramBitmap.kPz = true;
        paramString1.a(paramString3, paramw, paramBitmap.bmL());
      }
      else
      {
        paramw.setImageResource(R.g.brand_default_head);
      }
    }
  }
  
  public static d a(w paramw, String paramString1, View paramView, String paramString2, y.b paramb)
  {
    AppMethodBeat.i(31398);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31398);
      return null;
    }
    d.a locala = new d.a(paramw.VZx);
    locala.HG(false);
    locala.HH(false);
    a(locala, paramw.VZx, paramString1);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramw.VZx.getResources().getString(R.l.confirm_dialog_share);
    }
    locala.bBj(paramString1).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31343);
        if (this.RfR != null) {
          this.RfR.tD(true);
        }
        AppMethodBeat.o(31343);
      }
    });
    locala.ayk(R.l.app_cancel).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31344);
        if (this.RfR != null) {
          this.RfR.tD(false);
        }
        AppMethodBeat.o(31344);
      }
    });
    locala.iI(paramView);
    paramString1 = locala.icu();
    paramString1.asd(paramw.VZx.getResources().getColor(R.e.brand_text_color));
    paramString1.show();
    AppMethodBeat.o(31398);
    return paramString1;
  }
  
  public static d a(w paramw, String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31381);
    paramw = a(paramw, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(31381);
    return paramw;
  }
  
  public static d a(w paramw, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, y.a parama)
  {
    AppMethodBeat.i(31377);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31377);
      return null;
    }
    View localView = View.inflate(paramw.VZx, R.i.confirm_dialog_item1, null);
    d.a locala = new d.a(paramw.VZx);
    locala.HG(false);
    locala.HH(false);
    a(locala, paramw.VZx, paramString1);
    z(localView, paramBoolean);
    a(paramw, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramw.VZx, 120.0F);
    paramw = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramw != null) {
      paramw.aO(paramString2, i, i);
    }
    locala.iI(localView);
    paramw = locala.icu();
    paramw.show();
    AppMethodBeat.o(31377);
    return paramw;
  }
  
  public static d a(w paramw, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31378);
    paramw = a(paramw, paramString1, paramString2, paramBoolean, paramString3, parama, paramw.VZx.getResources().getString(R.l.app_url));
    AppMethodBeat.o(31378);
    return paramw;
  }
  
  public static d a(w paramw, String paramString1, String paramString2, boolean paramBoolean, String paramString3, y.a parama, String paramString4)
  {
    AppMethodBeat.i(31379);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31379);
      return null;
    }
    paramString2 = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramw.VZx, paramString2, localObject);
    }
    paramString2.HE(true);
    paramString2.aQ(paramString4 + paramString1).HG(false).HH(false);
    if (paramBoolean) {
      paramString2.HF(true);
    }
    paramString1 = paramString2.icu();
    a(paramw.VZx, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31379);
    return paramString1;
  }
  
  public static d a(w paramw, String paramString, boolean paramBoolean, int paramInt, y.a parama)
  {
    AppMethodBeat.i(31390);
    paramw = a(paramw, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(31390);
    return paramw;
  }
  
  public static d a(w paramw, String paramString1, boolean paramBoolean, int paramInt, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31391);
    d.a locala = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = Util.stringsToList(((String)localObject).split(","));; localObject = null)
    {
      a(paramw.VZx, locala, localObject);
      locala.HE(true);
      switch (paramInt)
      {
      default: 
        localObject = paramw.VZx.getResources().getString(R.l.app_app);
      }
      for (;;)
      {
        locala.aQ((String)localObject + paramString1).HG(false).HH(false);
        if (paramBoolean) {
          locala.HF(true);
        }
        paramString1 = locala.icu();
        a(paramw.VZx, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(31391);
        return paramString1;
        localObject = paramw.VZx.getResources().getString(R.l.app_video);
        continue;
        localObject = paramw.VZx.getResources().getString(R.l.app_music);
      }
    }
  }
  
  public static d a(w paramw, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31382);
    paramw = a(paramw, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31382);
    return paramw;
  }
  
  public static d a(w paramw, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31383);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(31383);
      return null;
    }
    d.a locala = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramw.VZx, locala, localObject);
    }
    locala.HE(true);
    locala.aQ(paramString1).HG(false).HH(false);
    if (paramBoolean) {
      locala.HF(true);
    }
    paramString1 = locala.icu();
    a(paramw.VZx, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31383);
    return paramString1;
  }
  
  public static d a(w paramw, byte[] paramArrayOfByte, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31386);
    paramw = a(paramw, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(31386);
    return paramw;
  }
  
  public static d a(w paramw, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, y.a parama)
  {
    AppMethodBeat.i(31387);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(31387);
      return null;
    }
    d.a locala = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramw.VZx, locala, localObject);
    }
    locala.HE(true);
    locala.HG(false).HH(false);
    if (paramBoolean) {
      locala.HF(true);
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
        locala.HE(false);
      }
    }
    paramArrayOfByte = locala.icu();
    a(paramw.VZx, paramArrayOfByte, paramString, null, parama, parama);
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
          int i = com.tencent.mm.ci.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.ci.a.ez(paramContext)));
          Object localObject1 = paramContext.getString(R.l.retransmit_to_conv_comfirm);
          parama.aO(((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i)).ayf(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramObject);
          i = com.tencent.mm.ci.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.ci.a.ez(paramContext)));
          if (ab.Lj(paramObject))
          {
            Object localObject2 = paramContext.getString(R.l.eRR, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.a)h.ae(com.tencent.mm.plugin.chatroom.a.a.class)).Pu(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = ad.kS(paramContext).inflate(R.i.dialog_chatroom_avater_detail, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(R.h.chatroom_avatar_detail);
            final ArrayList localArrayList = new ArrayList();
            final List localList = ((com.tencent.mm.plugin.chatroom.a.a)h.ae(com.tencent.mm.plugin.chatroom.a.a.class)).Ps(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new d.a.c()new d.a.a
            {
              public final void hku()
              {
                AppMethodBeat.i(31342);
                Util.hideVKB(this.RfP);
                if ((localArrayList.size() == 0) && (!Util.isNullOrNil(paramObject))) {
                  o.a(localArrayList, localList);
                }
                AppMethodBeat.o(31342);
              }
            }, new d.a.a()
            {
              public final void E(ImageView paramAnonymousImageView, String paramAnonymousString)
              {
                AppMethodBeat.i(31348);
                com.tencent.mm.ui.h.a.a.c(paramAnonymousImageView, paramAnonymousString);
                AppMethodBeat.o(31348);
              }
            });
            localGridView.setAdapter(new t(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(R.e.transparent)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label450;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.ci.a.aY(paramContext, R.f.DialogTitleDetailMaxHeight)));
              localGridView.setPadding(com.tencent.mm.ci.a.aY(paramContext, R.f.DialogEdgePadding), 0, com.tencent.mm.ci.a.aY(paramContext, R.f.DialogEdgePadding), 0);
            }
            for (;;)
            {
              parama.Ymv.UVP = ((View)localObject2);
              AppMethodBeat.o(31374);
              return;
              label450:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.ci.a.aY(paramContext, R.f.DialogAvatarLinePadding));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new d.a.a()
          {
            public final void E(ImageView paramAnonymousImageView, String paramAnonymousString)
            {
              AppMethodBeat.i(31352);
              com.tencent.mm.ui.h.a.a.c(paramAnonymousImageView, paramAnonymousString);
              AppMethodBeat.o(31352);
            }
          });
          AppMethodBeat.o(31374);
          return;
        }
        parama.iJ(d(paramContext, paramObject));
        parama.bBc(paramContext.getString(R.l.multi_retransmit_comfirm)).ayf(3);
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
      paramString2 = paramContext.getResources().getString(R.l.confirm_dialog_share);
    }
    if (!Util.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    paramContext = paramContext.getResources().getString(R.l.app_cancel);
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
  
  private static void a(final View paramView, y.a parama, final r paramr)
  {
    AppMethodBeat.i(31403);
    ((Button)paramView.findViewById(R.h.confirm_dialog_btn1)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288467);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.RfS != null) {
          this.RfS.a(true, o.ht(paramView), o.hu(paramView));
        }
        paramr.dismiss();
        paramr.setFocusable(false);
        paramr.setTouchable(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288467);
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.RfS != null) {
            this.RfS.a(false, null, 0);
          }
          paramr.dismiss();
          paramr.setFocusable(false);
          paramr.setTouchable(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31346);
        }
      });
    }
    AppMethodBeat.o(31403);
  }
  
  private static void a(w paramw, r paramr)
  {
    AppMethodBeat.i(31406);
    try
    {
      if (!paramw.VZx.isFinishing())
      {
        paramr.setInputMethodMode(1);
        paramr.setSoftInputMode(16);
        paramr.setFocusable(true);
        paramr.setTouchable(true);
        paramr.showAtLocation(paramw.VZx.getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(31406);
      return;
    }
    catch (Exception paramw)
    {
      Log.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paramw.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMConfirmDialog", paramw, "", new Object[0]);
      AppMethodBeat.o(31406);
    }
  }
  
  private static void a(w paramw, d.a parama, y.a parama1, final View paramView, String paramString)
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
      str = paramw.VZx.getResources().getString(R.l.confirm_dialog_share);
    }
    parama.bBj(str).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(273247);
        if (this.RfS != null) {
          this.RfS.a(true, o.ht(paramView), o.hu(paramView));
        }
        AppMethodBeat.o(273247);
      }
    });
    parama.ayk(R.l.app_cancel).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(31358);
        if (this.RfS != null) {
          this.RfS.a(false, null, 0);
        }
        AppMethodBeat.o(31358);
      }
    });
    AppMethodBeat.o(31401);
  }
  
  public static void a(w paramw, String paramString1, String paramString2, String paramString3, y.a parama)
  {
    AppMethodBeat.i(31397);
    paramw = new a(paramw.VZx).ee(paramString1).brm(paramString2).w(Boolean.FALSE);
    paramw.RfV = paramString3;
    paramw.a(parama).mUO.show();
    AppMethodBeat.o(31397);
  }
  
  private static void a(d.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(31402);
    parama.bBc(paramString);
    parama.ayd(paramContext.getResources().getColor(R.e.normal_text_color));
    parama.aye(2);
    AppMethodBeat.o(31402);
  }
  
  private static void a(d.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31407);
    parama.a(new o.7(paramBitmap));
    AppMethodBeat.o(31407);
  }
  
  private static View aU(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(31399);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(31399);
    return paramContext;
  }
  
  public static d b(w paramw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama)
  {
    AppMethodBeat.i(31380);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(31380);
      return null;
    }
    View localView = View.inflate(paramw.VZx, R.i.confirm_dialog_item1, null);
    d.a locala = new d.a(paramw.VZx);
    locala.HG(false);
    locala.HH(false);
    a(locala, paramw.VZx, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(R.h.confirm_dialog_text_et);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paramw, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramw.VZx, paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramw.VZx, 120.0F);
    paramw = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (paramw != null) {
      paramw.aO(paramString2, i, i);
    }
    locala.iI(localView);
    paramw = locala.icu();
    paramw.show();
    AppMethodBeat.o(31380);
    return paramw;
  }
  
  public static d b(w paramw, String paramString, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(31384);
    paramw = b(paramw, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(31384);
    return paramw;
  }
  
  public static d b(w paramw, String paramString1, boolean paramBoolean, String paramString2, y.a parama)
  {
    AppMethodBeat.i(31385);
    if ((paramString1 == null) || (!u.agG(paramString1)))
    {
      Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(31385);
      return null;
    }
    d.a locala = new d.a(paramw.VZx);
    Object localObject = paramw.VZx.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = Util.stringsToList(((String)localObject).split(","));
      a(paramw.VZx, locala, localObject);
    }
    locala.HE(true);
    locala.HG(false).HH(false);
    if (paramBoolean) {
      locala.HF(true);
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
        locala.HE(false);
      }
    }
    paramString1 = locala.icu();
    a(paramw.VZx, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(31385);
    return paramString1;
  }
  
  private static View d(Context paramContext, List<String> paramList)
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
        ImageView localImageView = (ImageView)paramContext.findViewById(RfO[i]);
        if (str == null) {
          break label102;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.h.a.a.c(localImageView, str);
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
  
  private static r hs(View paramView)
  {
    AppMethodBeat.i(31400);
    paramView = new r(paramView, -1, -1);
    AppMethodBeat.o(31400);
    return paramView;
  }
  
  private static void z(View paramView, boolean paramBoolean)
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
  
  public static final class a
  {
    final d.a RfU;
    public String RfV;
    Context mContext;
    public d mUO;
    public DialogInterface.OnDismissListener rrn;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(31360);
      this.RfV = null;
      this.mContext = paramContext;
      this.RfU = new d.a(this.mContext);
      this.RfU.HG(false);
      this.RfU.HH(false);
      this.RfU.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(31359);
          paramAnonymousCharSequence = ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(o.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(31359);
          return paramAnonymousCharSequence;
        }
      });
      AppMethodBeat.o(31360);
    }
    
    public final a a(y.a parama)
    {
      AppMethodBeat.i(31373);
      this.mUO = this.RfU.icu();
      if (this.rrn != null) {
        this.mUO.setOnDismissListener(this.rrn);
      }
      o.a(this.mContext, this.mUO, this.RfV, parama, parama);
      AppMethodBeat.o(31373);
      return this;
    }
    
    public final a a(EmojiInfo paramEmojiInfo, String paramString)
    {
      AppMethodBeat.i(288836);
      o.a(this.mContext, this.RfU, paramEmojiInfo, paramString);
      this.RfU.HE(false);
      AppMethodBeat.o(288836);
      return this;
    }
    
    public final a a(d.a.b paramb)
    {
      AppMethodBeat.i(31368);
      this.RfU.c(paramb);
      AppMethodBeat.o(31368);
      return this;
    }
    
    public final a aqk(int paramInt)
    {
      AppMethodBeat.i(31372);
      this.RfV = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(31372);
      return this;
    }
    
    public final a brl(String paramString)
    {
      AppMethodBeat.i(31362);
      int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, (int)(20.0F * com.tencent.mm.ci.a.ez(this.mContext)));
      if (!Util.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.RfU.aO(paramString);
      }
      AppMethodBeat.o(31362);
      return this;
    }
    
    public final a brm(String paramString)
    {
      AppMethodBeat.i(31364);
      int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.ci.a.ez(this.mContext)));
      if (!Util.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.a)h.ae(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
        this.RfU.aQ(paramString);
      }
      AppMethodBeat.o(31364);
      return this;
    }
    
    public final a brn(String paramString)
    {
      AppMethodBeat.i(31365);
      this.RfU.bBf(paramString);
      AppMethodBeat.o(31365);
      return this;
    }
    
    public final a bro(String paramString)
    {
      AppMethodBeat.i(31367);
      o.a(this.mContext, this.RfU, paramString);
      this.RfU.HE(false);
      AppMethodBeat.o(31367);
      return this;
    }
    
    public final a ee(Object paramObject)
    {
      AppMethodBeat.i(31361);
      o.b(this.mContext, this.RfU, paramObject);
      this.RfU.HE(true);
      AppMethodBeat.o(31361);
      return this;
    }
    
    public final a hkv()
    {
      AppMethodBeat.i(31363);
      this.RfU.ayh(2);
      AppMethodBeat.o(31363);
      return this;
    }
    
    public final a hkw()
    {
      this.RfU.Ymv.UVV = 8;
      return this;
    }
    
    public final a hkx()
    {
      AppMethodBeat.i(31371);
      this.RfU.HE(false);
      AppMethodBeat.o(31371);
      return this;
    }
    
    public final a hv(View paramView)
    {
      AppMethodBeat.i(31369);
      this.RfU.iI(paramView);
      AppMethodBeat.o(31369);
      return this;
    }
    
    public final a m(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(31366);
      this.RfU.b(paramBitmap, true, paramInt);
      this.RfU.HE(false);
      o.b(this.RfU, paramBitmap);
      AppMethodBeat.o(31366);
      return this;
    }
    
    public final a w(Boolean paramBoolean)
    {
      AppMethodBeat.i(31370);
      this.RfU.HF(paramBoolean.booleanValue());
      if (paramBoolean.booleanValue()) {
        this.RfU.bBh(this.mContext.getString(R.l.confirm_dialog_edittext_hint));
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