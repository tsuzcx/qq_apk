package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.nw.b;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.b.a;
import com.tencent.mm.plugin.msgquote.b.b;
import com.tencent.mm.plugin.msgquote.b.c;
import com.tencent.mm.plugin.msgquote.b.d;
import com.tencent.mm.plugin.msgquote.b.e;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ba;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.util.g;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  static final com.tencent.mm.modelimage.loader.a.c lCf;
  
  static
  {
    AppMethodBeat.i(269366);
    com.tencent.mm.modelimage.loader.a.c.a locala1 = new com.tencent.mm.modelimage.loader.a.c.a();
    locala1.oKB = b.d.app_brand_app_default_icon_for_tail;
    com.tencent.mm.modelimage.loader.a.c.a locala2 = locala1.eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.nrc = true;
    locala2.oKp = true;
    locala2.oKn = true;
    lCf = locala1.bKx();
    AppMethodBeat.o(269366);
  }
  
  private static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269314);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    paramInt2 = 0;
    int j = 0;
    int i = bd.bs(paramContext, b.b.Edge_4A);
    paramInt1 = bd.bs(paramContext, b.b.Edge_5A);
    if ((f > 0.0F) && (f < 0.5D))
    {
      paramInt1 = (int)(i / f);
      paramInt2 = i;
    }
    for (;;)
    {
      paramContext = localObject;
      if (paramInt2 > 0)
      {
        paramContext = localObject;
        if (paramInt1 > 0)
        {
          paramContext = localObject;
          if (paramBitmap != null) {
            paramContext = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
          }
        }
      }
      AppMethodBeat.o(269314);
      return paramContext;
      if ((f >= 0.5D) && (f < 1.0F))
      {
        paramInt2 = (int)(paramInt1 * f);
      }
      else if ((f >= 1.0F) && (f < 2.0F))
      {
        i = (int)(paramInt1 / f);
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      else
      {
        paramInt1 = j;
        if (f >= 2.0F)
        {
          paramInt2 = (int)(i * f);
          paramInt1 = i;
        }
      }
    }
  }
  
  private static Drawable a(Context paramContext, cc paramcc)
  {
    AppMethodBeat.i(269282);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    Object localObject = null;
    paramContext = localObject;
    switch (paramcc.getType())
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(269282);
      return paramContext;
      paramContext = bb.m(localContext, b.d.icons_outlined_quote_location, localContext.getResources().getColor(b.a.BW_BG_5A));
      paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
      continue;
      paramContext = bb.m(localContext, b.d.icons_outlined_quote_voice, localContext.getResources().getColor(b.a.BW_BG_5A));
      paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
      continue;
      paramContext = bb.m(localContext, b.d.icons_outlined_me, localContext.getResources().getColor(b.a.BW_BG_5A));
      paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
      continue;
      paramcc = k.b.Hf(paramcc.field_content);
      paramContext = localObject;
      if (paramcc != null)
      {
        paramContext = localObject;
        switch (paramcc.type)
        {
        case 1: 
        case 4: 
        case 8: 
        case 53: 
        case 57: 
        default: 
          paramContext = localObject;
          break;
        case 3: 
        case 76: 
          paramContext = bb.m(localContext, b.d.icons_outlined_quote_music, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 6: 
          paramContext = bb.m(localContext, b.d.icons_outlined_document, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 5: 
        case 82: 
          paramContext = bb.m(localContext, b.d.icons_outlined_quote_link, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 33: 
        case 36: 
        case 44: 
        case 48: 
          paramContext = bb.m(localContext, b.d.icons_outlined_quote_mini_program, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 24: 
          paramContext = bb.m(localContext, b.d.icons_outlined_quote_pencil, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 2001: 
          if ("1001".equals(paramcc.nSK)) {}
          for (paramContext = bb.m(localContext, b.d.icons_outlined_accounts, localContext.getResources().getColor(b.a.BW_BG_5A));; paramContext = bb.m(localContext, b.d.icons_outlined_envelopes, localContext.getResources().getColor(b.a.BW_BG_5A)))
          {
            paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
            break;
          }
        case 2000: 
          paramContext = bb.m(localContext, b.d.icons_outlined_accounts, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 51: 
        case 63: 
        case 65: 
        case 88: 
          paramContext = bb.m(localContext, b.d.icons_outlined_video, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 60: 
          paramContext = bb.m(localContext, b.d.icons_outlined_live, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
          break;
        case 50: 
        case 69: 
          paramContext = bb.m(localContext, b.d.icons_outlined_me, localContext.getResources().getColor(b.a.BW_BG_5A));
          paramContext.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F), com.tencent.mm.cd.a.fromDPToPix(localContext, 16.0F));
        }
      }
    }
  }
  
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, cc paramcc, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().su(paramMsgQuoteItem.LgU);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(b.e.LgO));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, Util.nullAs(paramMsgQuoteItem.LgX, "null"), paramFloat));
    localStringBuilder.append("：");
    cc localcc = new cc();
    localcc.setType(paramMsgQuoteItem.type);
    localcc.setContent(paramMsgQuoteItem.content);
    localcc.setMsgId(paramcc.field_msgId);
    localcc.BS(paramMsgQuoteItem.LgV);
    if (paramContext == null) {}
    for (Context localContext = MMApplicationContext.getContext();; localContext = paramContext)
    {
      String str = "";
      paramcc = str;
      switch (localcc.getType())
      {
      default: 
        paramcc = localContext.getString(b.e.Lgx);
      case 3: 
      case 13: 
      case 23: 
      case 33: 
      case 39: 
      case 43: 
      case 44: 
      case 47: 
      case 62: 
      case 268435505: 
      case 1: 
      case 11: 
      case 21: 
      case 31: 
      case 36: 
      case 301989937: 
      case 48: 
        for (;;)
        {
          paramMsgQuoteItem = paramcc;
          if (!Util.isNullOrNil(paramcc)) {
            paramMsgQuoteItem = paramcc.replace('\n', ' ');
          }
          if (localb != null) {
            break label2413;
          }
          Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
          if (!Util.isNullOrNil(localStringBuilder.toString())) {
            break label2413;
          }
          paramContext = new Pair(Boolean.FALSE, "");
          AppMethodBeat.o(88796);
          return paramContext;
          paramMsgQuoteItem = localcc.field_content;
          paramcc = paramMsgQuoteItem;
          if (paramMsgQuoteItem != null)
          {
            paramcc = paramMsgQuoteItem.trim();
            continue;
            paramcc = str;
            if (com.tencent.mm.br.c.blq("location"))
            {
              paramcc = new nw();
              paramcc.hQs.hQm = 1;
              paramcc.hQs.hzO = localcc;
              paramcc.publish();
              paramMsgQuoteItem = paramcc.hQt.hQv;
              str = paramcc.hQt.hLS;
              if (!h(paramMsgQuoteItem, localContext)) {
                break;
              }
              paramcc = "" + paramMsgQuoteItem;
            }
          }
        }
        if (!aMB(paramcc.hQt.hLS)) {
          break;
        }
      }
      for (paramcc = "" + str;; paramcc = "")
      {
        break;
        Object localObject = localcc.field_content;
        paramcc = (cc)localObject;
        if (paramMsgQuoteItem != null)
        {
          paramcc = (cc)localObject;
          if (localcc.field_content != null)
          {
            paramcc = (cc)localObject;
            if (!localcc.field_content.contains(paramMsgQuoteItem.LgW))
            {
              paramcc = paramMsgQuoteItem.LgW;
              paramcc = paramcc + ":" + (String)localObject;
            }
          }
        }
        paramcc = new com.tencent.mm.modelvoice.p(paramcc);
        float f = s.jh(paramcc.time);
        if (paramcc.time > 0L)
        {
          paramcc = localContext.getResources().getString(b.e.LgS, new Object[] { Integer.valueOf((int)f) });
          break;
        }
        localContext.getString(b.e.LgT);
        paramcc = str;
        break;
        paramcc = str;
        if (!localcc.jbB()) {
          break;
        }
        com.tencent.mm.kernel.h.baF();
        paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(localcc.field_content).nickname;
        break;
        if (localcc.jbB())
        {
          com.tencent.mm.kernel.h.baF();
          paramMsgQuoteItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(localcc.field_content).nickname;
          paramcc = str;
          if (paramMsgQuoteItem == null) {
            break;
          }
          paramcc = paramMsgQuoteItem;
          break;
        }
        paramcc = localContext.getString(b.e.Lgw, new Object[] { "" });
        break;
        localObject = k.b.Hf(localcc.field_content);
        paramcc = str;
        if (localObject == null) {
          break;
        }
        paramcc = str;
        switch (((k.b)localObject).type)
        {
        case 8: 
        default: 
          paramcc = localContext.getString(b.e.Lgx);
          break;
        case 1: 
        case 53: 
        case 57: 
          paramcc = str;
          if (((k.b)localObject).title == null) {
            break;
          }
          paramcc = str;
          if (((k.b)localObject).title.length() <= 0) {
            break;
          }
          paramcc = ((k.b)localObject).title;
          break;
        case 6: 
        case 74: 
          if ((((k.b)localObject).title != null) && (((k.b)localObject).title.length() > 0))
          {
            paramcc = ((k.b)localObject).title;
            break;
          }
          paramcc = localContext.getString(b.e.Lgz, new Object[] { "" });
          break;
        case 5: 
          if ((((k.b)localObject).title != null) && (((k.b)localObject).title.length() > 0))
          {
            paramcc = ((k.b)localObject).title;
            break;
          }
          paramcc = localContext.getString(b.e.LgQ, new Object[] { "" });
          break;
        case 33: 
        case 36: 
        case 44: 
        case 48: 
          if ((((k.b)localObject).title != null) && (((k.b)localObject).title.length() > 0))
          {
            paramcc = ((k.b)localObject).title;
            break;
          }
          paramcc = localContext.getString(b.e.Lgv, new Object[] { "" });
          break;
        case 24: 
          paramcc = e((k.b)localObject);
          break;
        case 3: 
        case 76: 
          if ((((k.b)localObject).title != null) && (((k.b)localObject).title.length() > 0))
          {
            paramcc = ((k.b)localObject).title;
            break;
          }
          paramcc = localContext.getString(b.e.LgI, new Object[] { "" });
          break;
        case 4: 
          paramcc = localContext.getString(b.e.LgR);
          break;
        case 2001: 
          if (localcc.field_isSend == 1) {}
          for (paramMsgQuoteItem = ((k.b)localObject).nSF;; paramMsgQuoteItem = ((k.b)localObject).nSE)
          {
            if (paramMsgQuoteItem != null)
            {
              paramcc = paramMsgQuoteItem;
              if (paramMsgQuoteItem.length() > 0) {
                break;
              }
            }
            if (!"1001".equals(((k.b)localObject).nSK)) {
              break label1537;
            }
            paramcc = localContext.getString(b.e.Lgu);
            break;
          }
          paramcc = localContext.getString(b.e.LgF);
          break;
        case 2000: 
          if ((((k.b)localObject).nTs != null) && (((k.b)localObject).nTs.length() > 0))
          {
            paramcc = ((k.b)localObject).nTs;
            break;
          }
          paramcc = localContext.getString(b.e.LgK);
          break;
        case 51: 
          paramMsgQuoteItem = (f)((k.b)localObject).aK(f.class);
          if ((paramMsgQuoteItem != null) && (paramMsgQuoteItem.oUc != null) && ((!Util.isNullOrNil(paramMsgQuoteItem.getNickname())) || (!Util.isNullOrNil(paramMsgQuoteItem.oUc.desc))))
          {
            if (!Util.isNullOrNil(paramMsgQuoteItem.getNickname())) {
              str = "" + paramMsgQuoteItem.getNickname();
            }
            paramcc = str;
            if (Util.isNullOrNil(paramMsgQuoteItem.oUc.desc)) {
              break;
            }
            paramcc = str + "·";
            paramcc = paramcc + paramMsgQuoteItem.oUc.desc;
            break;
          }
          localContext.getResources().getString(b.e.LgA);
          paramcc = str;
          break;
        case 65: 
          paramMsgQuoteItem = (com.tencent.mm.plugin.findersdk.a.a)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.a.class);
          if ((paramMsgQuoteItem != null) && (paramMsgQuoteItem.HbV != null) && ((!Util.isNullOrNil(paramMsgQuoteItem.HbV.nickName)) || (!Util.isNullOrNil(paramMsgQuoteItem.HbV.desc))))
          {
            if (!Util.isNullOrNil(paramMsgQuoteItem.HbV.nickName)) {
              str = "" + paramMsgQuoteItem.HbV.nickName;
            }
            paramcc = str;
            if (Util.isNullOrNil(paramMsgQuoteItem.HbV.desc)) {
              break;
            }
            paramcc = str + "·";
            paramcc = paramcc + paramMsgQuoteItem.HbV.desc;
            break;
          }
          localContext.getResources().getString(b.e.LgA);
          paramcc = str;
          break;
        case 63: 
        case 88: 
          paramcc = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.b.class);
          if ((paramcc != null) && (paramcc.HbV != null) && ((!Util.isNullOrNil(paramcc.HbV.nickName)) || (!Util.isNullOrNil(paramcc.HbV.desc))))
          {
            if (!Util.isNullOrNil(paramcc.HbV.nickName)) {
              str = "" + paramcc.HbV.nickName;
            }
            paramcc = localContext.getString(b.e.LgB, new Object[] { str });
            break;
          }
          localContext.getResources().getString(b.e.LgA);
          paramcc = str;
          break;
        case 82: 
          paramcc = (com.tencent.mm.plugin.findersdk.a.h)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.h.class);
          if ((paramcc != null) && (!Util.isNullOrNil(paramcc.HbZ.aabi)))
          {
            paramcc = paramcc.HbZ.aabi;
            break;
          }
          paramcc = localContext.getString(b.e.LgQ, new Object[] { "" });
          break;
        case 60: 
          if ((((k.b)localObject).title != null) && (((k.b)localObject).title.length() > 0))
          {
            paramcc = ((k.b)localObject).title;
            break;
          }
          paramcc = localContext.getString(b.e.LgH);
          break;
        case 19: 
          paramMsgQuoteItem = localContext.getString(b.e.LgN);
          paramcc = paramMsgQuoteItem;
          if (((k.b)localObject).title == null) {
            break;
          }
          paramcc = paramMsgQuoteItem;
          if (((k.b)localObject).title.length() <= 0) {
            break;
          }
          paramcc = paramMsgQuoteItem + ((k.b)localObject).title;
          break;
        case 50: 
          if (localObject != null)
          {
            paramcc = (e)((k.b)localObject).aK(e.class);
            if ((paramcc != null) && (!Util.isNullOrNil(paramcc.nickname)))
            {
              paramcc = paramcc.nickname;
              break;
            }
            paramcc = localContext.getString(b.e.LgC, new Object[] { "" });
            break;
          }
          paramcc = localContext.getString(b.e.LgC, new Object[] { "" });
          break;
        case 69: 
          label1537:
          if ((((k.b)localObject).description != null) && (((k.b)localObject).description.length() > 0))
          {
            paramcc = ((k.b)localObject).description;
            break;
          }
          paramcc = localContext.getString(b.e.LgD, new Object[] { "" });
          break;
          paramcc = k.b.Hf(localcc.field_content);
          if ((paramcc.title != null) && (paramcc.title.length() > 0))
          {
            paramcc = localContext.getString(b.e.LgI, new Object[] { paramcc.title });
            break;
          }
          paramcc = localContext.getString(b.e.LgI, new Object[] { "" });
          break;
          label2413:
          if (!Util.isNullOrNil(paramMsgQuoteItem))
          {
            paramcc = a(paramContext, localcc);
            if (paramcc != null)
            {
              paramContext = new Pair(Boolean.TRUE, com.tencent.mm.pluginsdk.ui.span.p.a(paramContext, localStringBuilder, com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramMsgQuoteItem, paramFloat), paramFloat, paramcc));
              AppMethodBeat.o(88796);
              return paramContext;
            }
            localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramMsgQuoteItem, paramFloat));
          }
          do
          {
            paramContext = new Pair(Boolean.TRUE, localStringBuilder);
            AppMethodBeat.o(88796);
            return paramContext;
            paramContext = a(paramContext, localcc);
          } while (paramContext == null);
          paramContext = new Pair(Boolean.TRUE, com.tencent.mm.pluginsdk.ui.span.p.a(localStringBuilder, paramContext));
          AppMethodBeat.o(88796);
          return paramContext;
        }
      }
    }
  }
  
  public static MsgQuoteItem a(cc paramcc, int paramInt1, CharSequence paramCharSequence, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(269353);
    if (paramcc == null)
    {
      AppMethodBeat.o(269353);
      return null;
    }
    MsgQuoteItem localMsgQuoteItem = new MsgQuoteItem();
    localMsgQuoteItem.type = paramInt1;
    localMsgQuoteItem.LgU = paramcc.field_msgSvrId;
    localMsgQuoteItem.LgV = Util.nullAs(paramcc.field_talker, "");
    localMsgQuoteItem.LgW = Util.nullAs(g.dP(paramcc), "");
    if (Util.isNullOrNil(paramCharSequence))
    {
      paramCharSequence = "";
      localMsgQuoteItem.LgX = Util.nullAs(paramCharSequence, "");
      localMsgQuoteItem.LgY = Util.nullAs(paramcc.jUr, "");
      if (!paramcc.jbS()) {
        break label311;
      }
      paramCharSequence = Util.nullAs(g.dQ(paramcc), "");
    }
    for (;;)
    {
      try
      {
        paramInt1 = paramCharSequence.indexOf("<refermsg>", 0);
        int i = paramCharSequence.lastIndexOf("</refermsg>");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCharSequence.substring(0, paramInt1));
        localStringBuilder.append("<refermsg>");
        localStringBuilder.append(paramCharSequence.substring(i));
        localMsgQuoteItem.content = localStringBuilder.toString();
        paramcc = g.c(((com.tencent.mm.plugin.messenger.foundation.a.aa)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.aa.class)).ak(paramcc), paramHashMap, paramInt2);
        if (!Util.isNullOrNil(paramcc)) {
          Log.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", new Object[] { paramcc });
        }
        localMsgQuoteItem.jUr = Util.nullAs(paramcc, "");
        AppMethodBeat.o(269353);
        return localMsgQuoteItem;
        paramCharSequence = paramCharSequence.toString();
      }
      catch (Exception localException)
      {
        localMsgQuoteItem.content = paramCharSequence;
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getMsgQuoteItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
      }
      label311:
      localMsgQuoteItem.content = Util.nullAs(g.dQ(paramcc), "");
    }
  }
  
  public static CharSequence a(Context paramContext, float paramFloat, cc paramcc)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = bg(paramcc);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {}
    }
    else
    {
      localObject1 = "null";
    }
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)localObject1, paramFloat));
    localStringBuilder.append("：");
    boolean bool = au.bwE(paramcc.field_talker);
    if (paramContext == null) {}
    for (Object localObject3 = MMApplicationContext.getContext();; localObject3 = paramContext)
    {
      if (paramcc == null)
      {
        paramcc = "";
        if (!Util.isNullOrNil(paramcc)) {
          localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramcc, paramFloat));
        }
        AppMethodBeat.o(88795);
        return localStringBuilder;
      }
      localObject2 = "";
      switch (paramcc.getType())
      {
      default: 
        localObject1 = ((Context)localObject3).getString(b.e.Lgx);
      }
      for (;;)
      {
        paramcc = (cc)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          break;
        }
        paramcc = ((String)localObject1).replace('\n', ' ');
        break;
        localObject1 = paramcc.field_content;
        localObject2 = localObject1;
        if (bool) {
          if (paramcc.field_isSend != 1) {
            break label532;
          }
        }
        label532:
        for (int i = 1;; i = 0)
        {
          localObject2 = localObject1;
          if (i == 0)
          {
            i = br.JG((String)localObject1);
            localObject2 = localObject1;
            if (i != -1) {
              localObject2 = ((String)localObject1).substring(i + 1);
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((String)localObject2).trim();
          break;
        }
        localObject1 = ((Context)localObject3).getString(b.e.LgM);
        continue;
        localObject1 = ((Context)localObject3).getString(b.e.LgR);
        continue;
        localObject1 = ((Context)localObject3).getString(b.e.LgE);
        localObject2 = localObject1;
        if (com.tencent.mm.br.c.blq("location"))
        {
          localObject2 = new nw();
          ((nw)localObject2).hQs.hQm = 1;
          ((nw)localObject2).hQs.hzO = paramcc;
          ((nw)localObject2).publish();
          paramcc = ((nw)localObject2).hQt.hQv;
          Object localObject4 = ((nw)localObject2).hQt.hLS;
          if (h(paramcc, (Context)localObject3))
          {
            localObject1 = (String)localObject1 + paramcc;
          }
          else
          {
            paramcc = (cc)localObject1;
            if (aMB(((nw)localObject2).hQt.hLS)) {
              paramcc = (String)localObject1 + (String)localObject4;
            }
            localObject1 = paramcc;
            continue;
            localObject1 = ((Context)localObject3).getString(b.e.Lgy);
            continue;
            localObject2 = ((Context)localObject3).getString(b.e.LgT);
            paramcc = new com.tencent.mm.modelvoice.p(paramcc.field_content);
            float f = s.jh(paramcc.time);
            localObject1 = localObject2;
            if (paramcc.time > 0L)
            {
              localObject1 = (String)localObject2 + ((Context)localObject3).getResources().getString(b.e.LgS, new Object[] { Integer.valueOf((int)f) });
              continue;
              if (paramcc.jbB())
              {
                com.tencent.mm.kernel.h.baF();
                paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(paramcc.field_content).nickname;
                localObject1 = ((Context)localObject3).getString(b.e.LgP, new Object[] { paramcc });
              }
              else
              {
                localObject1 = ((Context)localObject3).getString(b.e.LgP, new Object[] { "" });
                continue;
                if (paramcc.jbB())
                {
                  com.tencent.mm.kernel.h.baF();
                  paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(paramcc.field_content).nickname;
                  localObject1 = ((Context)localObject3).getString(b.e.Lgw, new Object[] { paramcc });
                }
                else
                {
                  localObject1 = ((Context)localObject3).getString(b.e.Lgw, new Object[] { "" });
                  continue;
                  localObject4 = k.b.Hf(paramcc.field_content);
                  localObject1 = localObject2;
                  if (localObject4 != null)
                  {
                    localObject1 = localObject2;
                    switch (((k.b)localObject4).type)
                    {
                    case 8: 
                    default: 
                      localObject1 = ((Context)localObject3).getString(b.e.Lgx);
                      break;
                    case 1: 
                    case 53: 
                    case 57: 
                      localObject1 = localObject2;
                      if (((k.b)localObject4).title == null) {
                        continue;
                      }
                      localObject1 = localObject2;
                      if (((k.b)localObject4).title.length() <= 0) {
                        continue;
                      }
                      localObject1 = ((k.b)localObject4).title;
                      break;
                    case 6: 
                    case 74: 
                      if ((((k.b)localObject4).title != null) && (((k.b)localObject4).title.length() > 0))
                      {
                        localObject1 = ((Context)localObject3).getString(b.e.Lgz, new Object[] { ((k.b)localObject4).title });
                        continue;
                      }
                      localObject1 = ((Context)localObject3).getString(b.e.Lgz, new Object[] { "" });
                      break;
                    case 5: 
                      if ((((k.b)localObject4).title != null) && (((k.b)localObject4).title.length() > 0))
                      {
                        localObject1 = ((Context)localObject3).getString(b.e.LgQ, new Object[] { ((k.b)localObject4).title });
                        continue;
                      }
                      localObject1 = ((Context)localObject3).getString(b.e.LgQ, new Object[] { "" });
                      break;
                    case 33: 
                    case 36: 
                    case 44: 
                    case 48: 
                      if ((((k.b)localObject4).title != null) && (((k.b)localObject4).title.length() > 0))
                      {
                        localObject1 = ((Context)localObject3).getString(b.e.Lgv, new Object[] { ((k.b)localObject4).title });
                        continue;
                      }
                      localObject1 = ((Context)localObject3).getString(b.e.Lgv, new Object[] { "" });
                      break;
                    case 24: 
                      localObject1 = ((Context)localObject3).getString(b.e.LgJ, new Object[] { e((k.b)localObject4) });
                      break;
                    case 3: 
                    case 76: 
                      if ((((k.b)localObject4).title != null) && (((k.b)localObject4).title.length() > 0))
                      {
                        localObject1 = ((Context)localObject3).getString(b.e.LgI, new Object[] { ((k.b)localObject4).title });
                        continue;
                      }
                      localObject1 = ((Context)localObject3).getString(b.e.LgI, new Object[] { "" });
                      break;
                    case 4: 
                      localObject1 = ((Context)localObject3).getString(b.e.LgR);
                      break;
                    case 2001: 
                      if ("1001".equals(((k.b)localObject4).nSK))
                      {
                        localObject1 = ((Context)localObject3).getString(b.e.Lgt);
                        if (paramcc.field_isSend != 1) {
                          break label1669;
                        }
                      }
                      for (paramcc = ((k.b)localObject4).nSF;; paramcc = ((k.b)localObject4).nSE)
                      {
                        localObject2 = localObject1;
                        if (paramcc == null) {
                          break label2695;
                        }
                        localObject2 = localObject1;
                        if (paramcc.length() <= 0) {
                          break label2695;
                        }
                        localObject1 = (String)localObject1 + paramcc;
                        break;
                        localObject1 = ((Context)localObject3).getString(b.e.LgG);
                        break label1599;
                      }
                    case 2000: 
                      paramcc = ((Context)localObject3).getString(b.e.LgL);
                      localObject1 = paramcc;
                      if (((k.b)localObject4).nTs == null) {
                        continue;
                      }
                      localObject1 = paramcc;
                      if (((k.b)localObject4).nTs.length() <= 0) {
                        continue;
                      }
                      localObject1 = paramcc + ((k.b)localObject4).nTs;
                      break;
                    case 51: 
                      localObject2 = ((Context)localObject3).getResources().getString(b.e.LgA);
                      localObject3 = (f)((k.b)localObject4).aK(f.class);
                      localObject1 = localObject2;
                      if (localObject3 == null) {
                        continue;
                      }
                      localObject1 = localObject2;
                      if (((f)localObject3).oUc == null) {
                        continue;
                      }
                      if (Util.isNullOrNil(((f)localObject3).getNickname()))
                      {
                        localObject1 = localObject2;
                        if (Util.isNullOrNil(((f)localObject3).oUc.desc)) {
                          continue;
                        }
                      }
                      paramcc = (cc)localObject2;
                      if (!Util.isNullOrNil(((f)localObject3).getNickname())) {
                        paramcc = (String)localObject2 + ((f)localObject3).getNickname();
                      }
                      localObject1 = paramcc;
                      if (Util.isNullOrNil(((f)localObject3).oUc.desc)) {
                        continue;
                      }
                      paramcc = paramcc + "·";
                      localObject1 = paramcc + ((f)localObject3).oUc.desc;
                      break;
                    case 65: 
                      localObject2 = ((Context)localObject3).getResources().getString(b.e.LgA);
                      localObject3 = (com.tencent.mm.plugin.findersdk.a.a)((k.b)localObject4).aK(com.tencent.mm.plugin.findersdk.a.a.class);
                      localObject1 = localObject2;
                      if (localObject3 == null) {
                        continue;
                      }
                      localObject1 = localObject2;
                      if (((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV == null) {
                        continue;
                      }
                      if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.nickName))
                      {
                        localObject1 = localObject2;
                        if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.desc)) {
                          continue;
                        }
                      }
                      paramcc = (cc)localObject2;
                      if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.nickName)) {
                        paramcc = (String)localObject2 + ((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.nickName;
                      }
                      localObject1 = paramcc;
                      if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.desc)) {
                        continue;
                      }
                      paramcc = paramcc + "·";
                      localObject1 = paramcc + ((com.tencent.mm.plugin.findersdk.a.a)localObject3).HbV.desc;
                      break;
                    case 63: 
                    case 88: 
                      paramcc = ((Context)localObject3).getResources().getString(b.e.LgA);
                      localObject2 = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject4).aK(com.tencent.mm.plugin.findersdk.a.b.class);
                      localObject1 = paramcc;
                      if (localObject2 == null) {
                        continue;
                      }
                      localObject1 = paramcc;
                      if (((com.tencent.mm.plugin.findersdk.a.b)localObject2).HbV == null) {
                        continue;
                      }
                      if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.b)localObject2).HbV.nickName))
                      {
                        localObject1 = paramcc;
                        if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.b)localObject2).HbV.desc)) {
                          continue;
                        }
                      }
                      if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.b)localObject2).HbV.nickName)) {
                        paramcc = paramcc + ((com.tencent.mm.plugin.findersdk.a.b)localObject2).HbV.nickName;
                      }
                    case 82: 
                    case 60: 
                    case 19: 
                    case 50: 
                    case 69: 
                      for (;;)
                      {
                        label1599:
                        localObject1 = ((Context)localObject3).getString(b.e.LgB, new Object[] { paramcc });
                        label1669:
                        break;
                        paramcc = ((Context)localObject3).getString(b.e.LgQ, new Object[] { "" });
                        localObject2 = (com.tencent.mm.plugin.findersdk.a.h)((k.b)localObject4).aK(com.tencent.mm.plugin.findersdk.a.h.class);
                        localObject1 = paramcc;
                        if (localObject2 == null) {
                          break;
                        }
                        localObject1 = paramcc;
                        if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.h)localObject2).HbZ.aabi)) {
                          break;
                        }
                        localObject1 = paramcc + ((com.tencent.mm.plugin.findersdk.a.h)localObject2).HbZ.aabi;
                        break;
                        paramcc = ((Context)localObject3).getString(b.e.LgH);
                        localObject1 = paramcc;
                        if (((k.b)localObject4).title == null) {
                          break;
                        }
                        localObject1 = paramcc;
                        if (((k.b)localObject4).title.length() <= 0) {
                          break;
                        }
                        localObject1 = paramcc + ((k.b)localObject4).title;
                        break;
                        paramcc = ((Context)localObject3).getString(b.e.LgN);
                        localObject1 = paramcc;
                        if (((k.b)localObject4).title == null) {
                          break;
                        }
                        localObject1 = paramcc;
                        if (((k.b)localObject4).title.length() <= 0) {
                          break;
                        }
                        localObject1 = paramcc + ((k.b)localObject4).title;
                        break;
                        if (localObject4 != null)
                        {
                          paramcc = (e)((k.b)localObject4).aK(e.class);
                          if ((paramcc != null) && (!Util.isNullOrNil(paramcc.nickname)))
                          {
                            localObject1 = ((Context)localObject3).getString(b.e.LgC, new Object[] { paramcc.nickname });
                            break;
                          }
                          localObject1 = ((Context)localObject3).getString(b.e.LgC, new Object[] { "" });
                          break;
                        }
                        localObject1 = ((Context)localObject3).getString(b.e.LgC, new Object[] { "" });
                        break;
                        if ((((k.b)localObject4).description != null) && (((k.b)localObject4).description.length() > 0))
                        {
                          localObject1 = ((Context)localObject3).getString(b.e.LgD, new Object[] { ((k.b)localObject4).description });
                          break;
                        }
                        localObject1 = ((Context)localObject3).getString(b.e.LgD, new Object[] { "" });
                        break;
                        paramcc = k.b.Hf(paramcc.field_content);
                        if ((paramcc.title != null) && (paramcc.title.length() > 0))
                        {
                          localObject1 = ((Context)localObject3).getString(b.e.LgI, new Object[] { paramcc.title });
                          break;
                        }
                        localObject1 = ((Context)localObject3).getString(b.e.LgI, new Object[] { "" });
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          label2695:
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private static boolean a(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, cc paramcc)
  {
    AppMethodBeat.i(269297);
    if (paramcc == null)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteVideo() msg is null");
      AppMethodBeat.o(269297);
      return false;
    }
    String str = paramcc.field_imgPath;
    Bitmap localBitmap = bi(paramcc);
    paramcc = localBitmap;
    if (localBitmap == null)
    {
      paramcc = localBitmap;
      if (str != null)
      {
        paramcc = BitmapUtil.getBitmapNative(str, 120, 120, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()));
        int j = Exif.fromFile(str).getOrientationInDegree();
        int i = j;
        if (j < 0) {
          i = 0;
        }
        paramcc = BitmapUtil.rotate(paramcc, i);
      }
    }
    if (paramcc == null)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteVideo() imgThumb is null");
      AppMethodBeat.o(269297);
      return false;
    }
    paramImageView1.setImageBitmap(ba.b(a(paramContext, paramcc, paramcc.getWidth(), paramcc.getHeight()), bd.fromDPToPix(paramContext, 3)));
    paramImageView2.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, b.d.shortvideo_play_btn));
    p(paramImageView1);
    AppMethodBeat.o(269297);
    return true;
  }
  
  public static boolean a(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(269295);
    if (paramcc == null)
    {
      AppMethodBeat.o(269295);
      return false;
    }
    switch (paramcc.getType())
    {
    }
    Object localObject;
    for (;;)
    {
      AppMethodBeat.o(269295);
      return false;
      paramBoolean = a(paramContext, paramImageView1, paramcc);
      AppMethodBeat.o(269295);
      return paramBoolean;
      paramBoolean = a(paramContext, paramImageView1, paramImageView2, paramcc);
      AppMethodBeat.o(269295);
      return paramBoolean;
      if (paramcc == null)
      {
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteEmoji() msg is null");
        AppMethodBeat.o(269295);
        return false;
      }
      paramImageView2 = paramcc.field_imgPath;
      if (Util.isNullOrNil(paramImageView2))
      {
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteEmoji() msgPath is null");
        AppMethodBeat.o(269295);
        return false;
      }
      paramImageView2 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramImageView2);
      if (paramImageView2 == null)
      {
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteEmoji() emoji is null");
        AppMethodBeat.o(269295);
        return false;
      }
      if (y.ZC(paramImageView2.kMo()))
      {
        localObject = y.bi(paramImageView2.kMo(), 0, -1);
        paramImageView2 = null;
      }
      for (;;)
      {
        paramcc = paramImageView2;
        if (localObject != null)
        {
          paramcc = paramImageView2;
          if (localObject.length > 0)
          {
            paramImageView2 = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
            paramcc = new Exif();
            paramcc.parseFrom((byte[])localObject);
            int i = paramcc.getOrientationInDegree();
            paramcc = paramImageView2;
            if (paramImageView2 != null)
            {
              paramcc = paramImageView2;
              if (i != 0) {
                paramcc = BitmapUtil.rotate(paramImageView2, i);
              }
            }
          }
        }
        if (paramcc != null) {
          break;
        }
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteEmoji() thumbBmp is null");
        AppMethodBeat.o(269295);
        return false;
        paramImageView2 = paramImageView2.kMc();
        localObject = null;
      }
      paramImageView1.setImageBitmap(ba.b(a(paramContext, paramcc, paramcc.getWidth(), paramcc.getHeight()), bd.fromDPToPix(paramContext, 3)));
      AppMethodBeat.o(269295);
      return true;
      paramImageView1.setImageBitmap(r.bKa().b(b.c.location_msg, b.c.map_bg_mask_normal, bd.bs(paramContext, b.b.Edge_4A), bd.bs(paramContext, b.b.Edge_4A), paramBoolean));
      p(paramImageView1);
      AppMethodBeat.o(269295);
      return true;
      com.tencent.mm.kernel.h.baF();
      paramImageView2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(paramcc.field_content);
      if (ab.uY(paramImageView2.WAW))
      {
        paramContext = paramImageView2.hgk;
        if (Util.isNullOrNil(paramContext)) {
          paramImageView1.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.c.brand_default_head));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(269295);
        return true;
        a.b.h(paramImageView1, paramContext);
        continue;
        paramImageView1.setImageDrawable(paramContext.getResources().getDrawable(b.c.default_avatar));
        paramContext = paramImageView2.hgk;
        if (Util.isNullOrNil(paramContext)) {
          paramImageView1.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(b.c.default_avatar));
        } else {
          a.b.g(paramImageView1, paramContext);
        }
      }
      localObject = k.b.Hf(paramcc.field_content);
      if (localObject != null) {
        switch (((k.b)localObject).type)
        {
        }
      }
    }
    paramBoolean = a(paramContext, paramImageView1, paramcc);
    AppMethodBeat.o(269295);
    return paramBoolean;
    paramBoolean = a(paramContext, paramImageView1, paramImageView2, paramcc);
    AppMethodBeat.o(269295);
    return paramBoolean;
    paramBoolean = a(paramContext, paramImageView1, paramcc);
    AppMethodBeat.o(269295);
    return paramBoolean;
    if (localObject != null) {}
    switch (((k.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(269295);
      return false;
    }
    paramContext = r.bKa().d(paramcc.field_imgPath, false, true);
    com.tencent.mm.modelappbrand.a.b.bEY().a(paramImageView1, "file://".concat(String.valueOf(paramContext)), ((k)com.tencent.mm.kernel.h.ax(k.class)).eE(240, 192));
    p(paramImageView1);
    AppMethodBeat.o(269295);
    return true;
    paramBoolean = a(paramContext, paramImageView1, paramcc);
    AppMethodBeat.o(269295);
    return paramBoolean;
    paramBoolean = a(paramImageView1, (k.b)localObject);
    AppMethodBeat.o(269295);
    return paramBoolean;
    paramImageView1.setImageResource(b.d.app_attach_file_icon_hongbao);
    AppMethodBeat.o(269295);
    return true;
    if (Util.isImageExt(((k.b)localObject).nRe)) {
      if (aw.isDarkMode()) {
        paramImageView1.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, b.d.app_attach_file_icon_photo_dark));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(269295);
      return true;
      paramImageView1.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, b.d.app_attach_file_icon_photo));
      continue;
      paramImageView1.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, x.bpB(((k.b)localObject).nRe)));
    }
    if (!"1001".equals(((k.b)localObject).nSK)) {
      paramImageView1.setImageResource(b.c.c2c_hongbao_icon_cn);
    }
    AppMethodBeat.o(269295);
    return true;
    paramBoolean = a(paramImageView1, (k.b)localObject);
    AppMethodBeat.o(269295);
    return paramBoolean;
    paramBoolean = a(paramContext, paramImageView1, paramcc);
    AppMethodBeat.o(269295);
    return paramBoolean;
  }
  
  private static boolean a(Context paramContext, ImageView paramImageView, cc paramcc)
  {
    AppMethodBeat.i(269304);
    if (paramcc == null)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteImg() msg is null");
      AppMethodBeat.o(269304);
      return false;
    }
    Object localObject1 = null;
    if (paramcc.field_msgId > 0L) {
      localObject1 = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
    }
    if (((localObject1 == null) || (((com.tencent.mm.modelimage.h)localObject1).localId <= 0L)) && (paramcc.field_msgSvrId > 0L)) {}
    for (Object localObject2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);; localObject2 = localObject1)
    {
      if (localObject2 == null)
      {
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteImg() imgInfo is null");
        AppMethodBeat.o(269304);
        return false;
      }
      String str = r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", "");
      localObject1 = str;
      if (Util.isNullOrNil(str)) {
        localObject1 = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGt);
      }
      paramcc = bj(paramcc);
      if ((paramcc == null) && (localObject1 != null))
      {
        paramcc = BitmapUtil.getBitmapNative((String)localObject1, 120, 120, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()));
        int j = Exif.fromFile((String)localObject1).getOrientationInDegree();
        int i = j;
        if (j < 0) {
          i = 0;
        }
        paramcc = BitmapUtil.rotate(paramcc, i);
      }
      for (;;)
      {
        if (paramcc == null)
        {
          Log.e("MicroMsg.msgquote.MsgQuoteHelp", "dealQuoteImg() imgThumb is null");
          AppMethodBeat.o(269304);
          return false;
        }
        paramImageView.setImageBitmap(ba.b(a(paramContext, paramcc, paramcc.getWidth(), paramcc.getHeight()), bd.fromDPToPix(paramContext, 3)));
        p(paramImageView);
        AppMethodBeat.o(269304);
        return true;
      }
    }
  }
  
  private static boolean a(ImageView paramImageView, k.b paramb)
  {
    AppMethodBeat.i(269299);
    if (paramb != null) {
      switch (paramb.type)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        AppMethodBeat.o(269299);
                        return false;
                        paramb = (f)paramb.aK(f.class);
                      } while ((paramb == null) || (paramb.oUc == null));
                      paramb = paramb.oUc.mediaList;
                    } while (paramb.isEmpty());
                    Object localObject = (bvj)paramb.get(0);
                    paramb = ((bvj)localObject).HaI;
                    localObject = ((bvj)localObject).thumbUrl;
                    if (!Util.isNullOrNil(paramb)) {}
                    for (;;)
                    {
                      ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(paramb, paramImageView);
                      p(paramImageView);
                      AppMethodBeat.o(269299);
                      return true;
                      paramb = (k.b)localObject;
                    }
                    paramb = (com.tencent.mm.plugin.findersdk.a.a)paramb.aK(com.tencent.mm.plugin.findersdk.a.a.class);
                  } while ((paramb == null) || (paramb.HbV == null));
                  paramb = paramb.HbV.coverUrl;
                } while (Util.isNullOrNil(paramb));
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(paramb, paramImageView);
                p(paramImageView);
                AppMethodBeat.o(269299);
                return true;
                paramb = (com.tencent.mm.plugin.findersdk.a.b)paramb.aK(com.tencent.mm.plugin.findersdk.a.b.class);
              } while ((paramb == null) || (paramb.HbV == null));
              paramb = paramb.HbV.coverUrl;
            } while (Util.isNullOrNil(paramb));
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(paramb, paramImageView);
            p(paramImageView);
            AppMethodBeat.o(269299);
            return true;
            paramb = (e)paramb.aK(e.class);
          } while (paramb == null);
          paramb = paramb.avatar;
        } while (Util.isNullOrNil(paramb));
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(paramb, paramImageView);
        p(paramImageView);
        AppMethodBeat.o(269299);
        return true;
        paramb = (com.tencent.mm.plugin.findersdk.a.h)paramb.aK(com.tencent.mm.plugin.findersdk.a.h.class);
      } while (paramb == null);
      paramb = paramb.HbZ.coverUrl;
    } while (Util.isNullOrNil(paramb));
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadNotWxUrlImage(paramb, paramImageView);
    p(paramImageView);
    AppMethodBeat.o(269299);
    return true;
  }
  
  private static boolean aMB(String paramString)
  {
    AppMethodBeat.i(88799);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals("err_not_started")))
    {
      AppMethodBeat.o(88799);
      return true;
    }
    AppMethodBeat.o(88799);
    return false;
  }
  
  public static boolean bf(cc paramcc)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(269280);
    if (paramcc == null)
    {
      AppMethodBeat.o(269280);
      return false;
    }
    switch (paramcc.getType())
    {
    default: 
      bool1 = bool2;
    case 1: 
    case 3: 
    case 11: 
    case 13: 
    case 21: 
    case 23: 
    case 31: 
    case 33: 
    case 36: 
    case 39: 
    case 43: 
    case 44: 
    case 48: 
    case 62: 
    case 268435505: 
    case 301989937: 
    case 805306417: 
    case 822083633: 
    case 1040187441: 
    case 34: 
    case 42: 
    case 66: 
    case 1048625: 
    case 754974769: 
    case 771751985: 
    case 855638065: 
    case 939524145: 
    case 973078577: 
    case 974127153: 
    case 975175729: 
      do
      {
        AppMethodBeat.o(269280);
        return bool1;
        bool1 = true;
      } while (!gdM());
    }
    for (;;)
    {
      bool1 = true;
      break;
      bool1 = true;
      break;
      bool1 = true;
      break;
      paramcc = k.b.Hf(paramcc.field_content);
      bool1 = bool2;
      if (paramcc == null) {
        break;
      }
      switch (paramcc.type)
      {
      case 3: 
      case 24: 
      default: 
        bool1 = bool2;
        break;
      case 1: 
      case 4: 
      case 5: 
      case 6: 
      case 33: 
      case 36: 
      case 44: 
      case 48: 
      case 53: 
        bool1 = true;
        break;
      case 19: 
        bool1 = bool2;
        if (!gdM()) {
          break;
        }
      }
    }
  }
  
  public static String bg(cc paramcc)
  {
    AppMethodBeat.i(88794);
    if (paramcc == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = g.dP(paramcc);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (au.bwE(paramcc.field_talker))
    {
      paramcc = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramcc.field_talker);
      localObject1 = localObject2;
      if (paramcc != null)
      {
        paramcc = paramcc.getDisplayName(str);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramcc)) {
          localObject1 = paramcc;
        }
      }
    }
    paramcc = (cc)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
      paramcc = (cc)localObject1;
      if (localObject2 != null)
      {
        localObject1 = ((az)localObject2).field_nickname;
        if (localObject1 != null)
        {
          paramcc = (cc)localObject1;
          if (!((String)localObject1).trim().equals("")) {}
        }
        else
        {
          paramcc = ((au)localObject2).aJs();
        }
      }
    }
    localObject1 = paramcc;
    if (Util.isNullOrNil(paramcc)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  public static int bh(cc paramcc)
  {
    AppMethodBeat.i(269285);
    if (paramcc == null)
    {
      AppMethodBeat.o(269285);
      return -1;
    }
    switch (paramcc.getType())
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(269285);
        return -1;
        AppMethodBeat.o(269285);
        return 1;
        AppMethodBeat.o(269285);
        return 2;
        AppMethodBeat.o(269285);
        return 3;
        AppMethodBeat.o(269285);
        return 6;
        AppMethodBeat.o(269285);
        return 1;
        AppMethodBeat.o(269285);
        return 4;
        paramcc = k.b.Hf(paramcc.field_content);
        if (paramcc != null) {
          switch (paramcc.type)
          {
          }
        }
      }
      AppMethodBeat.o(269285);
      return 6;
      AppMethodBeat.o(269285);
      return 2;
      AppMethodBeat.o(269285);
      return 1;
      AppMethodBeat.o(269285);
      return 10;
      AppMethodBeat.o(269285);
      return 9;
      AppMethodBeat.o(269285);
      return 8;
      AppMethodBeat.o(269285);
      return 7;
    } while ("1001".equals(paramcc.nSK));
    AppMethodBeat.o(269285);
    return 5;
  }
  
  private static Bitmap bi(cc paramcc)
  {
    AppMethodBeat.i(269307);
    v.bOh();
    paramcc = com.tencent.mm.modelvideo.aa.PY(paramcc.field_imgPath);
    if (paramcc == null)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getVideoThumb() imgPath is null");
      AppMethodBeat.o(269307);
      return null;
    }
    if (!com.tencent.mm.plugin.a.c.Sm(paramcc))
    {
      Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.Pf(paramcc);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        paramcc = BitmapUtil.getBitmapNative(paramcc);
        AppMethodBeat.o(269307);
        return paramcc;
      }
      AppMethodBeat.o(269307);
      return localBitmap;
    }
    paramcc = BitmapUtil.getBitmapNative(paramcc);
    AppMethodBeat.o(269307);
    return paramcc;
  }
  
  private static Bitmap bj(cc paramcc)
  {
    AppMethodBeat.i(269310);
    if (paramcc == null)
    {
      AppMethodBeat.o(269310);
      return null;
    }
    String str = paramcc.field_imgPath;
    localBitmap = r.bKa().Oa(str);
    paramcc = localBitmap;
    if (localBitmap != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramcc = BitmapUtil.rotate(localBitmap, i);
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.msgquote.MsgQuoteHelp", paramcc, "unexpected exception.", new Object[0]);
        paramcc = localBitmap;
      }
    }
    AppMethodBeat.o(269310);
    return paramcc;
  }
  
  private static String e(k.b paramb)
  {
    AppMethodBeat.i(88800);
    Object localObject1 = new tr();
    ((tr)localObject1).hXt.type = 0;
    ((tr)localObject1).hXt.hXv = paramb.nRF;
    ((tr)localObject1).publish();
    localObject1 = ((tr)localObject1).hXu.hXD;
    if (localObject1 == null)
    {
      AppMethodBeat.o(88800);
      return "";
    }
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).nUC.iterator();
    int i = 0;
    arf localarf;
    while (((Iterator)localObject2).hasNext())
    {
      localarf = (arf)((Iterator)localObject2).next();
      if ((!l.j(localarf)) || (Util.isNullOrNil(localarf.ZzG)) || (!localarf.ZzG.equals("WeNoteHtmlFile"))) {
        switch (localarf.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localarf.desc;
            if (!Util.isNullOrNil(str))
            {
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label368;
              }
              paramb = localarf.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
          break;
        }
      }
    }
    label368:
    for (;;)
    {
      i = 1;
      break;
      if (paramb != null)
      {
        paramb = paramb.split("\n", 2);
        localObject2 = new ArrayList();
        if (paramb.length > 0)
        {
          int j = paramb.length;
          i = 0;
          while (i < j)
          {
            localarf = paramb[i];
            if (localarf.length() > 0) {
              ((ArrayList)localObject2).add(localarf);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).nUC.size() == 2)) {
          paramb = "";
        }
      }
      for (paramb = paramb.trim();; paramb = "")
      {
        localObject1 = paramb;
        if (paramb != null) {
          localObject1 = paramb.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        AppMethodBeat.o(88800);
        return localObject1;
        paramb = (String)((ArrayList)localObject2).get(0);
        break;
      }
    }
  }
  
  private static boolean gdM()
  {
    AppMethodBeat.i(269360);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zlb, 0) == 1)
    {
      AppMethodBeat.o(269360);
      return true;
    }
    AppMethodBeat.o(269360);
    return false;
  }
  
  public static boolean gdN()
  {
    AppMethodBeat.i(269362);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zlc, 1) == 1)
    {
      AppMethodBeat.o(269362);
      return true;
    }
    AppMethodBeat.o(269362);
    return false;
  }
  
  private static boolean h(String paramString, Context paramContext)
  {
    AppMethodBeat.i(88798);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(paramContext.getResources().getString(b.e.LgE))))
    {
      AppMethodBeat.o(88798);
      return true;
    }
    AppMethodBeat.o(88798);
    return false;
  }
  
  private static void p(ImageView paramImageView)
  {
    AppMethodBeat.i(269364);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setClipToOutline(true);
      paramImageView.setBackgroundResource(b.c.Lgs);
    }
    AppMethodBeat.o(269364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.a
 * JD-Core Version:    0.7.0.1
 */