package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.i;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.c.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class g
  implements q
{
  private static int[] vTn = { 2131823009, 2131823010, 2131823011, 2131823012, 2131823013, 2131823014, 2131823015, 2131823016, 2131823017 };
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.q paramq, long paramLong, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27692);
    View localView = ak(paramq.zaO, 2130969206);
    com.tencent.mm.ui.base.o localo = ez(localView);
    a(localView, parama, localo);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(27692);
      return null;
    }
    a(localView, 2131822997, paramString1, false, 0);
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)localView.findViewById(2131822992);
    localNoMeasuredTextView.setShouldEllipsize(true);
    localNoMeasuredTextView.setTextSize(0, paramq.zaO.getResources().getDimension(2131427501) * com.tencent.mm.cb.a.dr(paramq.zaO));
    localNoMeasuredTextView.setTextColor(com.tencent.mm.cb.a.l(paramq.zaO, 2131690322));
    Object localObject = ((h)com.tencent.mm.kernel.g.E(h.class)).aG(paramLong);
    String str1;
    if ((localObject != null) && (((com.tencent.mm.aj.a.c)localObject).isGroup()))
    {
      paramString1 = ((com.tencent.mm.aj.a.c)localObject).field_chatName;
      str1 = ((com.tencent.mm.aj.a.c)localObject).field_headImageUrl;
      localObject = ((com.tencent.mm.aj.a.c)localObject).field_brandUserName;
      String str2 = paramString1;
      if (paramString1 == null) {
        str2 = paramString2;
      }
      if (bo.isNullOrNil(str2)) {
        break label406;
      }
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, str2, localNoMeasuredTextView.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131823002, null, true, 8);
      paramString1 = (Button)localView.findViewById(2131822984);
      if (!bo.isNullOrNil(paramString3)) {
        paramString1.setText(paramString3);
      }
      paramString1.setOnClickListener(new g.16(parama, localView, localo));
      paramString1 = new com.tencent.mm.at.a.a.c.a();
      paramString1.eNP = com.tencent.mm.api.a.cV((String)localObject);
      paramString1.eNM = true;
      paramString1.eOe = true;
      paramString1.eNY = 2131231207;
      paramString1 = paramString1.ahY();
      if (!bo.isNullOrNil(str1)) {
        com.tencent.mm.at.o.ahG().a(str1, (ImageView)localView.findViewById(2131822991), paramString1);
      }
      a(paramq, localo);
      AppMethodBeat.o(27692);
      return localo;
      localObject = ((i)com.tencent.mm.kernel.g.E(i.class)).df(((com.tencent.mm.aj.a.c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        paramString1 = ((com.tencent.mm.aj.a.j)localObject).field_userName;
        str1 = ((com.tencent.mm.aj.a.j)localObject).field_headImageUrl;
        localObject = ((com.tencent.mm.aj.a.j)localObject).field_brandUserName;
        break;
      }
      ab.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
      AppMethodBeat.o(27692);
      return null;
      label406:
      localNoMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString2, localNoMeasuredTextView.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.q paramq, Bitmap paramBitmap, String paramString, q.a parama)
  {
    AppMethodBeat.i(27690);
    final View localView = ak(paramq.zaO, 2130969205);
    final com.tencent.mm.ui.base.o localo = ez(localView);
    a(localView, parama, localo);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
      AppMethodBeat.o(27690);
      return null;
    }
    Object localObject = (TextView)localView.findViewById(2131822992);
    ((TextView)localObject).setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString, ((TextView)localObject).getTextSize()));
    paramString = (Button)localView.findViewById(2131822984);
    localObject = (ImageView)localView.findViewById(2131822991);
    if (localObject != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label173;
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
          AppMethodBeat.i(27652);
          if (this.vTq != null) {
            this.vTq.a(true, g.eA(localView), g.eB(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(27652);
        }
      });
      a(paramq, localo);
      AppMethodBeat.o(27690);
      return localo;
      label173:
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public static com.tencent.mm.ui.base.o a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    AppMethodBeat.i(27691);
    final View localView = ak(paramq.zaO, 2130969206);
    final com.tencent.mm.ui.base.o localo = ez(localView);
    a(localView, parama, localo);
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
      AppMethodBeat.o(27691);
      return null;
    }
    a(localView, 2131822997, paramString2, false, 0);
    paramString2 = (NoMeasuredTextView)localView.findViewById(2131822992);
    paramString2.setShouldEllipsize(true);
    paramString2.setTextSize(0, paramq.zaO.getResources().getDimension(2131427501) * com.tencent.mm.cb.a.dr(paramq.zaO));
    paramString2.setTextColor(com.tencent.mm.cb.a.l(paramq.zaO, 2131690322));
    if (!bo.isNullOrNil(paramString1)) {
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).b(paramq.zaO, ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramString1), paramString2.getTextSize()));
    }
    for (;;)
    {
      a(localView, 2131823002, paramString4, true, 8);
      paramString2 = (Button)localView.findViewById(2131822984);
      if (!bo.isNullOrNil(paramString5)) {
        paramString2.setText(paramString5);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27653);
          if (this.vTq != null) {
            this.vTq.a(true, g.eA(localView), g.eB(localView));
          }
          localo.dismiss();
          localo.setFocusable(false);
          localo.setTouchable(false);
          AppMethodBeat.o(27653);
        }
      });
      if (!bo.isNullOrNil(paramString1)) {
        a.b.c((ImageView)localView.findViewById(2131822991), paramString1);
      }
      a(paramq, localo);
      AppMethodBeat.o(27691);
      return localo;
      paramString2.setText(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).b(paramq.zaO, paramString3, paramString2.getTextSize()));
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, int paramInt, String paramString, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(27684);
    paramq = a(paramq, paramInt, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(27684);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, int paramInt, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27685);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bo.P(((String)localObject).split(","));
      a(paramq.zaO, locala, localObject);
    }
    locala.rE(true);
    if (paramInt == 2131230804) {
      localObject = paramq.zaO.getResources().getString(2131296962);
    }
    for (;;)
    {
      locala.ai((String)localObject + paramString1).rG(false).rH(false);
      if (paramBoolean) {
        locala.rF(true);
      }
      paramString1 = locala.aLZ();
      a(paramq.zaO, paramString1, paramString2, null, parama, parama);
      paramString1.show();
      AppMethodBeat.o(27685);
      return paramString1;
      if (paramInt == 2131230809) {
        localObject = paramq.zaO.getResources().getString(2131297003);
      } else if (paramInt == 2131230826) {
        localObject = paramq.zaO.getResources().getString(2131297102);
      } else {
        localObject = paramq.zaO.getResources().getString(2131296543);
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27688);
    View localView = ak(paramq.zaO, 2130969203);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    locala.rG(false);
    locala.rH(false);
    v(localView, true);
    a(paramq, locala, parama, localView, paramq.zaO.getResources().getString(2131298503));
    parama = (TextView)localView.findViewById(2131822997);
    parama.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(2131822992);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString2, paramString1.getTextSize()));
    paramq = (TextView)localView.findViewById(2131822993);
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramq.setVisibility(8);
      paramq = (ImageView)localView.findViewById(2131822991);
      if (paramq != null)
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label242;
        }
        ab.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
        paramq.setVisibility(8);
      }
    }
    for (;;)
    {
      locala.fu(localView);
      paramq = locala.aLZ();
      paramq.show();
      AppMethodBeat.o(27688);
      return paramq;
      paramq.setText(paramString3);
      paramq.setVisibility(0);
      break;
      label242:
      paramq.setVisibility(0);
      paramq.setImageBitmap(paramBitmap);
      a(locala, paramBitmap);
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27689);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
      AppMethodBeat.o(27689);
      return null;
    }
    View localView = ak(paramq.zaO, 2130969204);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    locala.rG(false);
    locala.rH(false);
    v(localView, false);
    a(paramq, locala, parama, localView, paramq.zaO.getResources().getString(2131298530));
    parama = (TextView)localView.findViewById(2131822997);
    parama.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString1, parama.getTextSize()));
    paramString1 = (TextView)localView.findViewById(2131822992);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString2, paramString1.getTextSize()));
    if (paramString3.length() == 0)
    {
      localView.findViewById(2131822993).setVisibility(8);
      paramq = (ImageView)localView.findViewById(2131822991);
      if (paramq != null)
      {
        if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
          break label272;
        }
        paramq.setImageBitmap(paramBitmap);
        a(locala, paramBitmap);
      }
    }
    for (;;)
    {
      locala.fu(localView);
      paramq = locala.aLZ();
      paramq.show();
      AppMethodBeat.o(27689);
      return paramq;
      ((TextView)localView.findViewById(2131822993)).setText(paramString3);
      break;
      label272:
      paramq.setVisibility(4);
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, View paramView, String paramString2, q.b paramb)
  {
    AppMethodBeat.i(27694);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(27694);
      return null;
    }
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    locala.rG(false);
    locala.rH(false);
    a(locala, paramq.zaO, paramString1);
    if (!bo.isNullOrNil(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString1 = paramq.zaO.getResources().getString(2131298503);
    }
    locala.avs(paramString1).a(new g.3(paramb));
    locala.Rj(2131296888).b(new g.4(paramb));
    locala.fu(paramView);
    paramString1 = locala.aLZ();
    paramString1.QZ(paramq.zaO.getResources().getColor(2131689778));
    paramString1.show();
    AppMethodBeat.o(27694);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27677);
    paramq = a(paramq, paramString1, paramString2, false, "", parama);
    AppMethodBeat.o(27677);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, q.a parama)
  {
    AppMethodBeat.i(27673);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(27673);
      return null;
    }
    View localView = View.inflate(paramq.zaO, 2130969202, null);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    locala.rG(false);
    locala.rH(false);
    a(locala, paramq.zaO, paramString1);
    v(localView, paramBoolean);
    a(paramq, locala, parama, localView, paramString4);
    paramString1 = (TextView)localView.findViewById(2131822992);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131822993).setVisibility(8);
    int i = BackwardSupportUtil.b.b(paramq.zaO, 120.0F);
    paramq = (CdnImageView)localView.findViewById(2131822991);
    if (paramq != null) {
      paramq.ax(paramString2, i, i);
    }
    locala.fu(localView);
    paramq = locala.aLZ();
    paramq.show();
    AppMethodBeat.o(27673);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, boolean paramBoolean, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27674);
    paramq = a(paramq, paramString1, paramString2, paramBoolean, paramString3, parama, paramq.zaO.getResources().getString(2131297097));
    AppMethodBeat.o(27674);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, boolean paramBoolean, String paramString3, q.a parama, String paramString4)
  {
    AppMethodBeat.i(27675);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(27675);
      return null;
    }
    paramString2 = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bo.P(((String)localObject).split(","));
      a(paramq.zaO, paramString2, localObject);
    }
    paramString2.rE(true);
    paramString2.ai(paramString4 + paramString1).rG(false).rH(false);
    if (paramBoolean) {
      paramString2.rF(true);
    }
    paramString1 = paramString2.aLZ();
    a(paramq.zaO, paramString1, paramString3, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(27675);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString, boolean paramBoolean, int paramInt, q.a parama)
  {
    AppMethodBeat.i(27686);
    paramq = a(paramq, paramString, paramBoolean, paramInt, "", parama);
    AppMethodBeat.o(27686);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, boolean paramBoolean, int paramInt, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27687);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null) {}
    for (localObject = bo.P(((String)localObject).split(","));; localObject = null)
    {
      a(paramq.zaO, locala, localObject);
      locala.rE(true);
      switch (paramInt)
      {
      default: 
        localObject = paramq.zaO.getResources().getString(2131296543);
      }
      for (;;)
      {
        locala.ai((String)localObject + paramString1).rG(false).rH(false);
        if (paramBoolean) {
          locala.rF(true);
        }
        paramString1 = locala.aLZ();
        a(paramq.zaO, paramString1, paramString2, null, parama, parama);
        paramString1.show();
        AppMethodBeat.o(27687);
        return paramString1;
        localObject = paramq.zaO.getResources().getString(2131297102);
        continue;
        localObject = paramq.zaO.getResources().getString(2131297003);
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(27678);
    paramq = a(paramq, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(27678);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27679);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
      AppMethodBeat.o(27679);
      return null;
    }
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bo.P(((String)localObject).split(","));
      a(paramq.zaO, locala, localObject);
    }
    locala.rE(true);
    locala.ai(paramString1).rG(false).rH(false);
    if (paramBoolean) {
      locala.rF(true);
    }
    paramString1 = locala.aLZ();
    a(paramq.zaO, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(27679);
    return paramString1;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, byte[] paramArrayOfByte, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(27682);
    paramq = a(paramq, paramArrayOfByte, paramBoolean, "", parama);
    AppMethodBeat.o(27682);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(com.tencent.mm.ui.q paramq, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, q.a parama)
  {
    AppMethodBeat.i(27683);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
      AppMethodBeat.o(27683);
      return null;
    }
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bo.P(((String)localObject).split(","));
      a(paramq.zaO, locala, localObject);
    }
    locala.rE(true);
    locala.rG(false).rH(false);
    if (paramBoolean) {
      locala.rF(true);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      int i = com.tencent.util.d.cv(paramArrayOfByte);
      if (localObject != null)
      {
        paramArrayOfByte = (byte[])localObject;
        if (i != 0) {
          paramArrayOfByte = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, i);
        }
        locala.a(paramArrayOfByte, true, 3);
        a(locala, paramArrayOfByte);
        locala.rE(false);
      }
    }
    paramArrayOfByte = locala.aLZ();
    a(paramq.zaO, paramArrayOfByte, paramString, null, parama, parama);
    paramArrayOfByte.show();
    AppMethodBeat.o(27683);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, com.tencent.mm.ui.widget.b.c.a parama, Object paramObject)
  {
    AppMethodBeat.i(27670);
    if (paramObject != null) {
      if ((paramObject instanceof String)) {
        paramObject = bo.P(((String)paramObject).split(","));
      }
    }
    for (;;)
    {
      if (bo.es(paramObject))
      {
        AppMethodBeat.o(27670);
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
          int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(20.0F * com.tencent.mm.cb.a.dr(paramContext)));
          Object localObject1 = paramContext.getString(2131302655);
          parama.ag(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i)).Re(3);
          localObject1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(paramObject);
          i = com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(14.0F * com.tencent.mm.cb.a.dr(paramContext)));
          if (t.lA(paramObject))
          {
            Object localObject2 = paramContext.getString(2131303049, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.b.class)).nv(paramObject)) });
            localObject1 = (String)localObject1 + (String)localObject2;
            localObject1 = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i);
            localObject2 = w.hM(paramContext).inflate(2130969322, null);
            GridView localGridView = (GridView)((View)localObject2).findViewById(2131823418);
            ArrayList localArrayList = new ArrayList();
            List localList = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.b.class)).nt(paramObject);
            parama.a(paramObject, (CharSequence)localObject1, Boolean.TRUE, new g.1((View)localObject2, localArrayList, paramObject, localList), new g.7());
            localGridView.setAdapter(new l(paramContext, localList, localArrayList));
            localGridView.setSelector(new ColorDrawable(paramContext.getResources().getColor(2131690605)));
            if (localList != null)
            {
              if (localList.size() <= 16) {
                break label450;
              }
              localGridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.ao(paramContext, 2131427572)));
              localGridView.setPadding(com.tencent.mm.cb.a.ao(paramContext, 2131427568), 0, com.tencent.mm.cb.a.ao(paramContext, 2131427568), 0);
            }
            for (;;)
            {
              parama.AGP.AGe = ((View)localObject2);
              AppMethodBeat.o(27670);
              return;
              label450:
              localGridView.setPadding(0, 0, 0, com.tencent.mm.cb.a.ao(paramContext, 2131427565));
            }
          }
          parama.a(paramObject, ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).a(paramContext, ((String)localObject1).toString(), i), Boolean.FALSE, null, new c.a.a()
          {
            public final void v(ImageView paramAnonymousImageView, String paramAnonymousString)
            {
              AppMethodBeat.i(27649);
              com.tencent.mm.ui.f.a.a.c(paramAnonymousImageView, paramAnonymousString);
              AppMethodBeat.o(27649);
            }
          });
          AppMethodBeat.o(27670);
          return;
        }
        paramObject = d(paramContext, paramObject);
        parama.AGP.AGd = paramObject;
        parama.avm(paramContext.getString(2131301650)).Re(3);
        AppMethodBeat.o(27670);
        return;
      }
      paramObject = null;
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.ui.widget.b.c paramc, String paramString1, String paramString2, q.a parama1, q.a parama2)
  {
    AppMethodBeat.i(27672);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      paramString2 = paramContext.getResources().getString(2131298503);
    }
    if (!bo.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    paramContext = paramContext.getResources().getString(2131296888);
    paramc.a(paramString2, true, new g.12(paramc, parama1));
    paramc.b(paramContext, true, new g.13(paramc, parama2));
    AppMethodBeat.o(27672);
  }
  
  private static void a(View paramView, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(27701);
    paramView = (TextView)paramView.findViewById(paramInt1);
    if (paramView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((!paramBoolean) || (!bo.isNullOrNil(paramString))) {
        break;
      }
      paramView.setVisibility(paramInt2);
      AppMethodBeat.o(27701);
      return;
    }
    paramView.setText(paramString);
    AppMethodBeat.o(27701);
  }
  
  private static void a(View paramView, q.a parama, final com.tencent.mm.ui.base.o paramo)
  {
    AppMethodBeat.i(27699);
    ((Button)paramView.findViewById(2131822984)).setOnClickListener(new g.5(parama, paramView, paramo));
    paramView = (Button)paramView.findViewById(2131822983);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27644);
          if (this.vTq != null) {
            this.vTq.a(false, null, 0);
          }
          paramo.dismiss();
          paramo.setFocusable(false);
          paramo.setTouchable(false);
          AppMethodBeat.o(27644);
        }
      });
    }
    AppMethodBeat.o(27699);
  }
  
  private static void a(com.tencent.mm.ui.q paramq, com.tencent.mm.ui.base.o paramo)
  {
    AppMethodBeat.i(27702);
    try
    {
      if (!paramq.zaO.isFinishing())
      {
        paramo.setInputMethodMode(1);
        paramo.setSoftInputMode(16);
        paramo.setFocusable(true);
        paramo.setTouchable(true);
        paramo.showAtLocation(paramq.zaO.getWindow().getDecorView(), 17, 0, 0);
      }
      AppMethodBeat.o(27702);
      return;
    }
    catch (Exception paramq)
    {
      ab.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", new Object[] { paramq.getMessage() });
      ab.printErrStackTrace("MicroMsg.MMConfirmDialog", paramq, "", new Object[0]);
      AppMethodBeat.o(27702);
    }
  }
  
  private static void a(com.tencent.mm.ui.q paramq, com.tencent.mm.ui.widget.b.c.a parama, q.a parama1, View paramView, String paramString)
  {
    AppMethodBeat.i(27697);
    String str;
    if (!bo.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = paramq.zaO.getResources().getString(2131298503);
    }
    parama.avs(str).a(new g.17(parama1, paramView));
    parama.Rj(2131296888).b(new g.2(parama1));
    AppMethodBeat.o(27697);
  }
  
  public static void a(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, String paramString3, q.a parama)
  {
    AppMethodBeat.i(27693);
    paramq = new g.a(paramq.zaO).cq(paramString1).amm(paramString2).i(Boolean.FALSE);
    paramq.vTu = paramString3;
    paramq.a(parama).gwf.show();
    AppMethodBeat.o(27693);
  }
  
  private static void a(com.tencent.mm.ui.widget.b.c.a parama, Context paramContext, String paramString)
  {
    AppMethodBeat.i(27698);
    parama.avm(paramString);
    parama.Rc(paramContext.getResources().getColor(2131690322));
    parama.Rd(2);
    AppMethodBeat.o(27698);
  }
  
  private static void a(com.tencent.mm.ui.widget.b.c.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27703);
    parama.a(new g.9(paramBitmap));
    AppMethodBeat.o(27703);
  }
  
  private static View ak(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(27695);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    AppMethodBeat.o(27695);
    return paramContext;
  }
  
  public static com.tencent.mm.ui.widget.b.c b(com.tencent.mm.ui.q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama)
  {
    AppMethodBeat.i(27676);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString3 == null) || (paramString3.length() == 0)))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
      AppMethodBeat.o(27676);
      return null;
    }
    View localView = View.inflate(paramq.zaO, 2130969202, null);
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    locala.rG(false);
    locala.rH(false);
    a(locala, paramq.zaO, paramString1);
    if (localView != null)
    {
      paramString1 = (EditText)localView.findViewById(2131822990);
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1.setText(paramString4);
    }
    a(paramq, locala, parama, localView, paramString5);
    paramString1 = (TextView)localView.findViewById(2131822992);
    paramString1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramq.zaO, paramString3, paramString1.getTextSize()));
    localView.findViewById(2131822993).setVisibility(8);
    int i = BackwardSupportUtil.b.b(paramq.zaO, 120.0F);
    paramq = (CdnImageView)localView.findViewById(2131822991);
    if (paramq != null) {
      paramq.ax(paramString2, i, i);
    }
    locala.fu(localView);
    paramq = locala.aLZ();
    paramq.show();
    AppMethodBeat.o(27676);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c b(com.tencent.mm.ui.q paramq, String paramString, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(27680);
    paramq = b(paramq, paramString, paramBoolean, "", parama);
    AppMethodBeat.o(27680);
    return paramq;
  }
  
  public static com.tencent.mm.ui.widget.b.c b(com.tencent.mm.ui.q paramq, String paramString1, boolean paramBoolean, String paramString2, q.a parama)
  {
    AppMethodBeat.i(27681);
    if ((paramString1 == null) || (!e.cN(paramString1)))
    {
      ab.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
      AppMethodBeat.o(27681);
      return null;
    }
    com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(paramq.zaO);
    Object localObject = paramq.zaO.getIntent().getExtras().getString("Select_Conv_User", null);
    if (localObject != null)
    {
      localObject = bo.P(((String)localObject).split(","));
      a(paramq.zaO, locala, localObject);
    }
    locala.rE(true);
    locala.rG(false).rH(false);
    if (paramBoolean) {
      locala.rF(true);
    }
    if (!bo.isNullOrNil(paramString1))
    {
      localObject = com.tencent.mm.sdk.platformtools.d.aoV(paramString1);
      int i = BackwardSupportUtil.ExifHelper.bY(paramString1);
      if (localObject != null)
      {
        paramString1 = (String)localObject;
        if (i != 0) {
          paramString1 = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, i);
        }
        locala.a(paramString1, true, 3);
        a(locala, paramString1);
        locala.rE(false);
      }
    }
    paramString1 = locala.aLZ();
    a(paramq.zaO, paramString1, paramString2, null, parama, parama);
    paramString1.show();
    AppMethodBeat.o(27681);
    return paramString1;
  }
  
  private static View d(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(27671);
    paramContext = View.inflate(paramContext, 2130969209, null);
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
        ImageView localImageView = (ImageView)paramContext.findViewById(vTn[i]);
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
      AppMethodBeat.o(27671);
      return paramContext;
    }
  }
  
  private static com.tencent.mm.ui.base.o ez(View paramView)
  {
    AppMethodBeat.i(27696);
    paramView = new com.tencent.mm.ui.base.o(paramView, -1, -1);
    AppMethodBeat.o(27696);
    return paramView;
  }
  
  private static void v(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(27700);
    if (paramView != null)
    {
      paramView = (EditText)paramView.findViewById(2131822990);
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
      AppMethodBeat.o(27700);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g
 * JD-Core Version:    0.7.0.1
 */