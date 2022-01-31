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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.api.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class g
  implements q
{
  private static int[] sce = { R.h.title_image_0, R.h.title_image_1, R.h.title_image_2, R.h.title_image_3, R.h.title_image_4, R.h.title_image_5, R.h.title_image_6, R.h.title_image_7, R.h.title_image_8 };
  
  private static View W(Context paramContext, int paramInt)
  {
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
  }
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.s params, long paramLong, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    View localView = W(params.uMN, R.i.confirm_dialog_item8);
    com.tencent.mm.ui.base.o localo = dt(localView);
    a(localView, parama, localo);
    if (bk.bl(paramString1))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, params.uMN.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.cb.a.cJ(params.uMN));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cb.a.h(params.uMN, R.e.normal_text_color));
    Object localObject = ((com.tencent.mm.api.g)com.tencent.mm.kernel.g.r(com.tencent.mm.api.g.class)).aj(paramLong);
    String str1;
    if ((localObject != null) && (((com.tencent.mm.ai.a.c)localObject).isGroup()))
    {
      paramString1 = ((com.tencent.mm.ai.a.c)localObject).field_chatName;
      str1 = ((com.tencent.mm.ai.a.c)localObject).field_headImageUrl;
      localObject = ((com.tencent.mm.ai.a.c)localObject).field_brandUserName;
      String str2 = paramString1;
      if (paramString1 == null) {
        str2 = paramString2;
      }
      if (bk.bl(str2)) {
        break label393;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.confirm_dialog_count_tv, null, true, 8);
      paramString1 = (Button)localView.findViewById(R.h.confirm_dialog_btn1);
      if (!bk.bl(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new g.16(parama, localView, localo));
      paramString1 = new com.tencent.mm.as.a.a.c.a();
      paramString1.eri = com.tencent.mm.api.a.bT((String)localObject);
      paramString1.erf = true;
      paramString1.erC = true;
      paramString1.eru = R.k.default_avatar;
      paramString1 = paramString1.OV();
      if (!bk.bl(str1)) {
        com.tencent.mm.as.o.ON().a(str1, (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(params, localo);
      return localo;
      localObject = ((h)com.tencent.mm.kernel.g.r(h.class)).bY(((com.tencent.mm.ai.a.c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.ai.a.j)localObject).field_userName;
        str1 = ((com.tencent.mm.ai.a.j)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.ai.a.j)localObject).field_brandUserName;
        break;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      return null;
      label393:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.s params, Bitmap paramBitmap, String paramString, q.a parama)
  {
    final View localView = W(params.uMN, R.i.confirm_dialog_item7);
    final com.tencent.mm.ui.base.o localo = dt(localView);
    a(localView, parama, localo);
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
      return null;
    }
    Object localObject = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    ((TextView)localObject).setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString, ((TextView)localObject).getTextSize()));
    paramString = (Button)localView.findViewById(R.h.confirm_dialog_btn1);
    localObject = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (localObject != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label160;
      }
      ((ImageView)localObject).setImageBitmap(paramBitmap);
      localo.setOnDismissListener(new g.8(paramBitmap));
    }
    for (;;)
    {
      paramString.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (this.sch != null) {
            this.sch.a(true, g.du(localView), g.dv(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
        }
      });
      a(params, localo);
      return localo;
      label160:
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    final View localView = W(params.uMN, R.i.confirm_dialog_item8);
    final com.tencent.mm.ui.base.o localo = dt(localView);
    a(localView, parama, localo);
    if (bk.bl(paramString2))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      return null;
    }
    a(localView, R.h.confirm_dialog_title_tv, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, params.uMN.getResources().getDimension(R.f.BigTextSize) * com.tencent.mm.cb.a.cJ(params.uMN));
    paramString2.setTextColor(com.tencent.mm.cb.a.h(params.uMN, R.e.normal_text_color));
    if (!bk.bl(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(params.uMN, ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, R.h.confirm_dialog_count_tv, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(R.h.confirm_dialog_btn1);
      if (!bk.bl(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (this.sch != null) {
            this.sch.a(true, g.du(localView), g.dv(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
        }
      });
      if (!bk.bl(paramString1)) {
        a.b.a((ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv), paramString1);
      }
      a(params, localo);
      return localo;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(params.uMN, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, int paramInt, String paramString, boolean paramBoolean, q.a parama)
  {
    return a(params, paramInt, paramString, paramBoolean, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, int paramInt, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bk.G(((String)localObject).split(","));
      a(params.uMN, locala, localObject);
    }
    locala.nU(true);
    if (paramInt == R.k.app_attach_file_icon_file) {
      localObject = params.uMN.getResources().getString(R.l.app_file);
    }
    for (;;)
    {
      locala.U((String)localObject + paramString1).nW(false).nX(false);
      if (paramBoolean) {
        locala.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
      }
      paramString1 = locala.aoP();
      a(params.uMN, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      return paramString1;
      if (paramInt == R.k.app_attach_file_icon_music) {
        localObject = params.uMN.getResources().getString(R.l.app_music);
      } else if (paramInt == R.k.app_attach_file_icon_video) {
        localObject = params.uMN.getResources().getString(R.l.app_video);
      } else {
        localObject = params.uMN.getResources().getString(R.l.app_app);
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    View localView = W(params.uMN, R.i.confirm_dialog_item4);
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.nW(false);
    locala.nX(false);
    o(localView, true);
    a(params, locala, parama, localView, params.uMN.getResources().getString(R.l.confirm_dialog_share));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString2, paramString1.getTextSize()));
    params = (TextView)localView.findViewById(R.h.confirm_dialog_content_desc_tv);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      params.setVisibility(8);
      params = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
      if (params != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label233;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        params.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.ei(localView);
      params = locala.aoP();
      params.show();
      return params;
      params.setText(paramString3);
      params.setVisibility(0);
      break;
      label233:
      params.setVisibility(0);
      params.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt, q.a parama)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      return null;
    }
    View localView = W(params.uMN, R.i.confirm_dialog_item6);
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.nW(false);
    locala.nX(false);
    o(localView, false);
    a(params, locala, parama, localView, params.uMN.getResources().getString(paramInt));
    parama = (TextView)localView.findViewById(R.h.confirm_dialog_title_tv);
    parama.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString2, paramString1.getTextSize()));
    if (paramString3.length() == 0)
    {
      localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
      params = (ImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
      if (params != null)
      {
        if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
          break label256;
        }
        params.setImageBitmap(paramBitmap);
        a(locala, paramBitmap);
      }
    }
    for (;;)
    {
      locala.ei(localView);
      params = locala.aoP();
      params.show();
      return params;
      ((TextView)localView.findViewById(R.h.confirm_dialog_content_desc_tv)).setText(paramString3);
      break;
      label256:
      params.setVisibility(4);
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, View paramView, String paramString2, q.b paramb)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      return null;
    }
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.nW(false);
    locala.nX(false);
    a(locala, params.uMN, paramString1);
    if (!bk.bl(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = params.uMN.getResources().getString(R.l.confirm_dialog_share);
    }
    locala.aeD(paramString1).a(new g.3(paramb));
    locala.It(R.l.app_cancel).b(new g.4(paramb));
    locala.ei(paramView);
    paramString1 = locala.aoP();
    paramString1.In(params.uMN.getResources().getColor(R.e.wechat_green));
    paramString1.show();
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, String paramString2, q.a parama)
  {
    return a(params, paramString1, paramString2, false, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, String paramString2, String paramString3, q.a parama1, q.a parama2)
  {
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.a(com.tencent.mm.compatible.g.a.decodeResource(params.uMN.getResources(), R.k.dialog_successful_icon), false, 3);
    locala.nW(false);
    locala.nX(false);
    locala.wmT.wlC = paramString1;
    locala.Ir(17);
    paramString1 = locala.aoP();
    a(params.uMN, paramString1, paramString3, paramString2, parama2, parama1);
    paramString1.Io(params.uMN.getResources().getColor(R.e.green_text_color));
    paramString1.show();
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, q.a parama)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      return null;
    }
    View localView = View.inflate(params.uMN, R.i.confirm_dialog_item1, null);
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.nW(false);
    locala.nX(false);
    a(locala, params.uMN, paramString1);
    o(localView, paramBoolean);
    a(params, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.b.b(params.uMN, 120.0F);
    params = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (params != null) {
      params.ah(paramString2, i, i);
    }
    locala.ei(localView);
    params = locala.aoP();
    params.show();
    return params;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, String paramString2, boolean paramBoolean, String paramString3, q.a parama)
  {
    return a(params, paramString1, paramString2, paramBoolean, paramString3, parama, params.uMN.getResources().getString(R.l.app_url));
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, String paramString2, boolean paramBoolean, String paramString3, q.a parama, String paramString4)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      return null;
    }
    paramString2 = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bk.G(((String)localObject).split(","));
      a(params.uMN, paramString2, localObject);
    }
    paramString2.nU(true);
    paramString2.U(paramString4 + paramString1).nW(false).nX(false);
    if (paramBoolean) {
      paramString2.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
    }
    paramString1 = paramString2.aoP();
    a(params.uMN, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString, boolean paramBoolean, int paramInt, q.a parama)
  {
    return a(params, paramString, paramBoolean, paramInt, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, boolean paramBoolean, int paramInt, String paramString2, q.a parama)
  {
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = bk.G(((String)localObject).split(","));; localObject = null)
    {
      a(params.uMN, locala, localObject);
      locala.nU(true);
      switch (paramInt)
      {
      default: 
        localObject = params.uMN.getResources().getString(R.l.app_app);
      }
      for (;;)
      {
        locala.U((String)localObject + paramString1).nW(false).nX(false);
        if (paramBoolean) {
          locala.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
        }
        paramString1 = locala.aoP();
        a(params.uMN, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        return paramString1;
        localObject = params.uMN.getResources().getString(R.l.app_video);
        continue;
        localObject = params.uMN.getResources().getString(R.l.app_music);
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString, boolean paramBoolean, q.a parama)
  {
    return a(params, paramString, paramBoolean, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      return null;
    }
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bk.G(((String)localObject).split(","));
      a(params.uMN, locala, localObject);
    }
    locala.nU(true);
    locala.U(paramString1).nW(false).nX(false);
    if (paramBoolean) {
      locala.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
    }
    paramString1 = locala.aoP();
    a(params.uMN, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, byte[] paramArrayOfByte, boolean paramBoolean, q.a parama)
  {
    return a(params, paramArrayOfByte, paramBoolean, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c a(com.tencent.mm.ui.s params, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, q.a parama)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      return null;
    }
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bk.G(((String)localObject).split(","));
      a(params.uMN, locala, localObject);
    }
    locala.nU(true);
    locala.nW(false).nX(false);
    if (paramBoolean) {
      locala.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (paramArrayOfByte != null)
      {
        locala.a(paramArrayOfByte, true, 3);
        a(locala, paramArrayOfByte);
        locala.nU(false);
      }
    }
    paramArrayOfByte = locala.aoP();
    a(params.uMN, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, com.tencent.mm.ui.widget.a.c.a parama, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof String)) {
        break label33;
      }
      paramObject = bk.G(((String)paramObject).split(","));
    }
    for (;;)
    {
      if (bk.dk(paramObject))
      {
        return;
        label33:
        if ((paramObject instanceof List)) {
          paramObject = (List)paramObject;
        }
      }
      else
      {
        if (paramObject.size() == 1)
        {
          paramObject = (String)paramObject.get(0);
          int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cb.a.cJ(paramContext)));
          Object localObject1 = paramContext.getString(R.l.retransmit_to_conv_comfirm);
          parama.S(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(((String)localObject1).toString(), i));
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramObject);
          i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cb.a.cJ(paramContext)));
          if (com.tencent.mm.model.s.fn(paramObject))
          {
            Object localObject2 = paramContext.getString(R.l.select_contact_num, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.b.class)).gM(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(((String)localObject1).toString(), i);
            localObject2 = com.tencent.mm.ui.y.gt(paramContext).inflate(R.i.dialog_chatroom_avater_detail, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(R.h.chatroom_avatar_detail);
            ArrayList localArrayList = new ArrayList();
            List localList = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.b.class)).gK(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.valueOf(true), new g.1((View)localObject2, localArrayList, paramObject, localList), new g.7());
            localGridView.setAdapter(new l(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(R.e.transparent)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label427;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.aa(paramContext, R.f.DialogTitleDetailMaxHeight)));
              localGridView.setPadding(com.tencent.mm.cb.a.aa(paramContext, R.f.DialogEdgePadding), 0, com.tencent.mm.cb.a.aa(paramContext, R.f.DialogEdgePadding), 0);
            }
            for (;;)
            {
              parama.wmT.wmi = ((View)localObject2);
              return;
              label427:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cb.a.aa(paramContext, R.f.DialogAvatarLinePadding));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(((String)localObject1).toString(), i), Boolean.valueOf(false), null, new g.11());
          return;
        }
        paramObject = d(paramContext, paramObject);
        parama.wmT.wmh = paramObject;
        parama.aez(paramContext.getString(R.l.multi_retransmit_comfirm));
        return;
      }
      paramObject = null;
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.ui.widget.a.c paramc, String paramString1, String paramString2, final q.a parama1, final q.a parama2)
  {
    String str;
    if (!bk.bl(paramString1))
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = paramContext.getResources().getString(R.l.confirm_dialog_share);
    }
    if (!bk.bl(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramContext.getResources().getString(R.l.app_cancel);
    }
    paramc.a(str, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.sck.dismiss();
        String str;
        com.tencent.mm.ui.widget.a.c localc;
        if (parama1 != null)
        {
          paramAnonymousDialogInterface = parama1;
          str = this.sck.cKe();
          localc = this.sck;
          if (!(localc.ln instanceof PasterEditText)) {
            break label66;
          }
        }
        label66:
        for (paramAnonymousInt = ((PasterEditText)localc.ln).getPasterLen();; paramAnonymousInt = 0)
        {
          paramAnonymousDialogInterface.a(true, str, paramAnonymousInt);
          return;
        }
      }
    });
    paramc.b(paramString1, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.sck.dismiss();
        if (parama2 != null) {
          parama2.a(false, null, 0);
        }
      }
    });
  }
  
  private static void a(View paramView, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    paramView = (TextView)paramView.findViewById(paramInt1);
    if (paramView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((!paramBoolean) || (!bk.bl(paramString))) {
        break;
      }
      paramView.setVisibility(paramInt2);
      return;
    }
    paramView.setText(paramString);
  }
  
  private static void a(View paramView, q.a parama, com.tencent.mm.ui.base.o paramo)
  {
    ((Button)paramView.findViewById(R.h.confirm_dialog_btn1)).setOnClickListener(new g.5(parama, paramView, paramo));
    paramView = (Button)paramView.findViewById(R.h.confirm_dialog_btn2);
    if (paramView != null) {
      paramView.setOnClickListener(new g.6(parama, paramo));
    }
  }
  
  private static void a(com.tencent.mm.ui.s params, com.tencent.mm.ui.base.o paramo)
  {
    try
    {
      if (!params.uMN.isFinishing())
      {
        paramo.setInputMethodMode(1);
        paramo.setSoftInputMode(16);
        paramo.setFocusable(true);
        paramo.setTouchable(true);
        paramo.showAtLocation(params.uMN.getWindow().getDecorView(), 17, 0, 0);
      }
      return;
    }
    catch (Exception params)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { params.getMessage() });
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMConfirmDialog", params, "", new Object[0]);
    }
  }
  
  private static void a(com.tencent.mm.ui.s params, com.tencent.mm.ui.widget.a.c.a parama, q.a parama1, View paramView, String paramString)
  {
    String str;
    if (!bk.bl(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = params.uMN.getResources().getString(R.l.confirm_dialog_share);
    }
    parama.aeD(str).a(new g.17(parama1, paramView));
    parama.It(R.l.app_cancel).b(new g.2(parama1));
  }
  
  public static void a(com.tencent.mm.ui.s params, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    params = new g.a(params.uMN).bM(paramString1).WF(paramString2).g(Boolean.valueOf(false));
    params.sco = paramString3;
    params.a(parama).few.show();
  }
  
  private static void a(com.tencent.mm.ui.widget.a.c.a parama, Context paramContext, String paramString)
  {
    parama.aez(paramString);
    int i = paramContext.getResources().getColor(R.e.normal_text_color);
    parama.wmT.rYa = i;
    parama.wmT.wmj = 2;
  }
  
  private static void a(com.tencent.mm.ui.widget.a.c.a parama, Bitmap paramBitmap)
  {
    parama.a(new g.9(paramBitmap));
  }
  
  public static com.tencent.mm.ui.widget.a.c b(com.tencent.mm.ui.s params, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      return null;
    }
    View localView = View.inflate(params.uMN, R.i.confirm_dialog_item1, null);
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    locala.nW(false);
    locala.nX(false);
    a(locala, params.uMN, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(R.h.confirm_dialog_text_et);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(params, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(R.h.confirm_dialog_message_tv);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(params.uMN, paramString3, paramString1.getTextSize()));
    localView.findViewById(R.h.confirm_dialog_content_desc_tv).setVisibility(8);
    int i = BackwardSupportUtil.b.b(params.uMN, 120.0F);
    params = (CdnImageView)localView.findViewById(R.h.confirm_dialog_thumb_iv);
    if (params != null) {
      params.ah(paramString2, i, i);
    }
    locala.ei(localView);
    params = locala.aoP();
    params.show();
    return params;
  }
  
  public static com.tencent.mm.ui.widget.a.c b(com.tencent.mm.ui.s params, String paramString, boolean paramBoolean, q.a parama)
  {
    return b(params, paramString, paramBoolean, "", parama);
  }
  
  public static com.tencent.mm.ui.widget.a.c b(com.tencent.mm.ui.s params, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    if ((paramString1 == null) || (!e.bK(paramString1)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      return null;
    }
    com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(params.uMN);
    Object localObject = params.uMN.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bk.G(((String)localObject).split(","));
      a(params.uMN, locala, localObject);
    }
    locala.nU(true);
    locala.nW(false).nX(false);
    if (paramBoolean) {
      locala.aeC(params.uMN.getString(R.l.confirm_dialog_edittext_hint));
    }
    if (!bk.bl(paramString1))
    {
      paramString1 = com.tencent.mm.sdk.platformtools.c.YW(paramString1);
      if (paramString1 != null)
      {
        locala.a(paramString1, true, 3);
        a(locala, paramString1);
        locala.nU(false);
      }
    }
    paramString1 = locala.aoP();
    a(params.uMN, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    return paramString1;
  }
  
  private static View d(Context paramContext, List<String> paramList)
  {
    paramContext = View.inflate(paramContext, R.i.confirm_dialog_title_multi_image, null);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((i > 8) || (paramContext == null)) {
          break label90;
        }
        ImageView localImageView = (ImageView)paramContext.findViewById(sce[i]);
        if (str == null) {
          break label90;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.e.a.a.a(localImageView, str);
        i += 1;
      }
    }
    label90:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
  
  private static com.tencent.mm.ui.base.o dt(View paramView)
  {
    return new com.tencent.mm.ui.base.o(paramView, -1, -1);
  }
  
  private static void o(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(R.h.confirm_dialog_text_et);
      if (paramView != null) {
        if (!paramBoolean) {
          break label31;
        }
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g
 * JD-Core Version:    0.7.0.1
 */