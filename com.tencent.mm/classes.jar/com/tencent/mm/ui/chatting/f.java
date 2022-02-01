package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.abl;
import com.tencent.mm.f.a.abl.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static int mPV = 1;
  private static int mPW = 2;
  private static int mPX = 3;
  private static int mPY = 4;
  
  public static int P(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5)
    {
      if (paramBoolean) {
        return R.g.c2c_chatto_done_bg;
      }
      return R.g.c2c_chatfrom_done_bg;
    }
    if (paramInt1 == 4)
    {
      if (paramBoolean) {
        return R.g.c2c_chatto_done_bg;
      }
      return R.g.c2c_chatfrom_done_bg;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        if (paramBoolean) {
          return R.g.c2c_chatto_done_bg;
        }
        return R.g.c2c_chatfrom_done_bg;
      }
      if (paramBoolean) {
        return R.g.dmF;
      }
      return R.g.dmD;
    }
    if (paramBoolean) {
      return R.g.dmF;
    }
    return R.g.dmD;
  }
  
  public static int Q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = -1;
    int i;
    if (paramInt1 == 5) {
      i = R.g.lucky_money_opened_icon;
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (paramInt1 == 4) {
            return R.g.lucky_money_opened_icon;
          }
          i = j;
        } while (paramInt1 != 3);
        i = j;
      } while (paramInt2 != 2);
      i = j;
    } while (paramBoolean);
    return R.g.lucky_money_opened_icon;
  }
  
  public static int R(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5)
    {
      if (paramBoolean) {
        return R.g.dnV;
      }
      return R.g.dnM;
    }
    if (paramInt1 == 4)
    {
      if (paramBoolean) {
        return R.g.dnV;
      }
      return R.g.dnM;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        if (paramBoolean) {
          return R.g.dnV;
        }
        return R.g.dnM;
      }
      if (paramBoolean) {
        return R.g.dnU;
      }
      return R.g.dnL;
    }
    if (paramBoolean) {
      return R.g.dnU;
    }
    return R.g.dnL;
  }
  
  public static float a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(269251);
    if ((paramb == null) || (paramb.lnQ <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(269251);
      return 0.3F;
    }
    Object localObject = paramb.lnP;
    abl localabl = new abl();
    localabl.gbi.gbk = ((String)localObject);
    EventCenter.instance.publish(localabl);
    if ((localabl.gbj.status == mPY) && (paramb.lnQ == 5))
    {
      if (paramBoolean2)
      {
        AppMethodBeat.o(269251);
        return 0.5F;
      }
      AppMethodBeat.o(269251);
      return 0.8F;
    }
    if ((localabl.gbj.status == mPX) || (localabl.gbj.status == mPW) || (localabl.gbj.status == mPY))
    {
      AppMethodBeat.o(269251);
      return 0.3F;
    }
    localObject = h(paramb);
    switch (paramb.lnQ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269251);
      return 0.3F;
      if ((((a)localObject).role == 1) || (paramBoolean1)) {
        if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
      }
      switch (((a)localObject).WxZ)
      {
      default: 
        break;
      case 1: 
      case 2: 
        if (paramBoolean2)
        {
          AppMethodBeat.o(269251);
          return 0.5F;
        }
        AppMethodBeat.o(269251);
        return 0.8F;
      case 3: 
      case 4: 
        AppMethodBeat.o(269251);
        return 0.3F;
        AppMethodBeat.o(269251);
        return 0.3F;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(269251);
              return 0.5F;
            }
            AppMethodBeat.o(269251);
            return 0.8F;
          case 2: 
          case 3: 
          case 4: 
            AppMethodBeat.o(269251);
            return 0.3F;
            AppMethodBeat.o(269251);
            return 0.3F;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            AppMethodBeat.o(269251);
            return 0.3F;
          }
          AppMethodBeat.o(269251);
          return 0.3F;
          if ((((a)localObject).role == 1) || (paramBoolean1)) {
            if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
          }
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(269251);
              return 0.5F;
            }
            AppMethodBeat.o(269251);
            return 0.8F;
          case 3: 
          case 4: 
            AppMethodBeat.o(269251);
            return 0.3F;
            AppMethodBeat.o(269251);
            return 0.3F;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
              switch (((a)localObject).WxZ)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean2)
                {
                  AppMethodBeat.o(269251);
                  return 0.5F;
                }
                AppMethodBeat.o(269251);
                return 0.8F;
              case 2: 
              case 3: 
              case 4: 
                AppMethodBeat.o(269251);
                return 0.3F;
                AppMethodBeat.o(269251);
                return 0.3F;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.WxZ <= 0) {
                break label711;
              }
              switch (paramb.WxZ)
              {
              }
            }
            break;
          }
        }
        break;
      }
    }
    if (paramBoolean2)
    {
      AppMethodBeat.o(269251);
      return 0.5F;
    }
    AppMethodBeat.o(269251);
    return 0.8F;
    AppMethodBeat.o(269251);
    return 0.3F;
    label711:
    AppMethodBeat.o(269251);
    return 0.3F;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString, k.b paramb, TextView paramTextView)
  {
    AppMethodBeat.i(269253);
    Context localContext = MMApplicationContext.getContext();
    paramb = (c)paramb.ar(c.class);
    Log.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s exclusiveRecvUsername: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2), paramb.lln });
    if (paramInt2 == 5)
    {
      paramString = localContext.getString(R.l.eKR);
      AppMethodBeat.o(269253);
      return paramString;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 4)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.eKS);
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramString = localContext.getString(R.l.eKN);
        AppMethodBeat.o(269253);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.eKS);
          AppMethodBeat.o(269253);
          return paramString;
        }
        AppMethodBeat.o(269253);
        return "";
      }
    }
    else if (paramInt1 == 0)
    {
      if (paramInt2 == 4)
      {
        if (paramBoolean1)
        {
          paramString = localContext.getString(R.l.eKN);
          AppMethodBeat.o(269253);
          return paramString;
        }
        if (paramBoolean2)
        {
          if (paramInt3 == 2)
          {
            paramString = localContext.getString(R.l.eKS);
            AppMethodBeat.o(269253);
            return paramString;
          }
          paramString = localContext.getString(R.l.eKN);
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramString = localContext.getString(R.l.eKS);
        AppMethodBeat.o(269253);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramBoolean1)
        {
          AppMethodBeat.o(269253);
          return "";
        }
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.eKS);
          AppMethodBeat.o(269253);
          return paramString;
        }
        AppMethodBeat.o(269253);
        return "";
      }
    }
    else
    {
      if ((paramInt1 == 3) && (!Util.isNullOrNil(paramb.lln)))
      {
        paramString = aa.aL(paramb.lln, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(R.l.eKQ, new Object[] { paramString });
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramString = localContext.getString(R.l.eKO, new Object[] { paramString });
        if (paramTextView == null)
        {
          paramString = paramString + localContext.getString(R.l.eKP);
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramInt2 = paramTextView.getWidth();
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(R.l.eKP), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(269253);
        return paramString;
      }
      if (!Util.isNullOrNil(paramb.lln))
      {
        paramString = aa.aL(paramb.lln, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(R.l.eKQ, new Object[] { paramString });
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramString = localContext.getString(R.l.eKO, new Object[] { paramString });
        if (paramTextView == null)
        {
          paramString = paramString + localContext.getString(R.l.eKP);
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramInt2 = paramTextView.getWidth();
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(R.l.eKP), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(269253);
        return paramString;
      }
      if (paramInt2 == 4)
      {
        if ((!paramBoolean2) || ((paramBoolean1) && (paramInt3 == 2)))
        {
          paramString = localContext.getString(R.l.eKS);
          AppMethodBeat.o(269253);
          return paramString;
        }
        paramString = localContext.getString(R.l.eKN);
        AppMethodBeat.o(269253);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          if (paramBoolean1)
          {
            AppMethodBeat.o(269253);
            return "";
          }
          paramString = localContext.getString(R.l.eKS);
          AppMethodBeat.o(269253);
          return paramString;
        }
        AppMethodBeat.o(269253);
        return "";
      }
    }
    AppMethodBeat.o(269253);
    return "";
  }
  
  public static String a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34309);
    if ((paramb == null) || (paramb.lnQ <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      if (paramBoolean)
      {
        paramb = paramb.lnC;
        AppMethodBeat.o(34309);
        return paramb;
      }
      paramb = paramb.lnD;
      AppMethodBeat.o(34309);
      return paramb;
    }
    a locala = h(paramb);
    String str = paramb.lnP;
    abl localabl = new abl();
    localabl.gbi.gbk = str;
    EventCenter.instance.publish(localabl);
    switch (paramb.lnQ)
    {
    }
    while (paramBoolean)
    {
      paramb = paramb.lnC;
      AppMethodBeat.o(34309);
      return paramb;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.WxZ <= 0) || (locala.Wya < 0) || (locala.Wyb < 0)) {}
      }
      switch (locala.WxZ)
      {
      default: 
        break;
      case 1: 
        paramb = MMApplicationContext.getContext().getString(R.l.emB);
        AppMethodBeat.o(34309);
        return paramb;
      case 2: 
        paramb = MMApplicationContext.getContext().getString(R.l.emy, new Object[] { Integer.valueOf(locala.Wya - locala.Wyb) });
        AppMethodBeat.o(34309);
        return paramb;
      case 3: 
        paramb = MMApplicationContext.getContext().getString(R.l.emw);
        AppMethodBeat.o(34309);
        return paramb;
      case 4: 
        paramb = MMApplicationContext.getContext().getString(R.l.emA);
        AppMethodBeat.o(34309);
        return paramb;
        paramb = MMApplicationContext.getContext().getString(R.l.emA);
        AppMethodBeat.o(34309);
        return paramb;
        if (locala.role == 2)
        {
          if ((locala.WxZ > 0) && (locala.Wyc >= 0L)) {}
          switch (locala.WxZ)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(R.l.emt, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(R.l.ems, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(R.l.emv, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(R.l.emu);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(R.l.emu);
            AppMethodBeat.o(34309);
            return paramb;
          }
        }
        else
        {
          if (locala.role == 3)
          {
            paramb = MMApplicationContext.getContext().getString(R.l.emu);
            AppMethodBeat.o(34309);
            return paramb;
          }
          paramb = MMApplicationContext.getContext().getString(R.l.emu);
          AppMethodBeat.o(34309);
          return paramb;
          if ((locala.role == 1) || (paramBoolean)) {
            if ((locala.WxZ <= 0) || (locala.Wya < 0) || (locala.Wyb < 0)) {}
          }
          switch (locala.WxZ)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(R.l.emB);
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(R.l.emz, new Object[] { Integer.valueOf(locala.Wya) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(R.l.emw);
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(R.l.emA);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(R.l.emA);
            AppMethodBeat.o(34309);
            return paramb;
            if (locala.role == 2)
            {
              if ((locala.WxZ > 0) && (locala.Wyc >= 0L)) {}
              switch (locala.WxZ)
              {
              default: 
                break;
              case 1: 
                paramb = MMApplicationContext.getContext().getString(R.l.emt, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 2: 
                paramb = MMApplicationContext.getContext().getString(R.l.ems, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 3: 
                paramb = MMApplicationContext.getContext().getString(R.l.emv, new Object[] { Float.valueOf((float)locala.Wyc / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 4: 
                paramb = MMApplicationContext.getContext().getString(R.l.emu);
                AppMethodBeat.o(34309);
                return paramb;
                paramb = MMApplicationContext.getContext().getString(R.l.emu);
                AppMethodBeat.o(34309);
                return paramb;
              }
            }
            else
            {
              locala = i(paramb);
              if (locala.WxZ > 0)
              {
                switch (locala.WxZ)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                  paramb = MMApplicationContext.getContext().getString(R.l.emx);
                  AppMethodBeat.o(34309);
                  return paramb;
                case 4: 
                  paramb = MMApplicationContext.getContext().getString(R.l.emu);
                  AppMethodBeat.o(34309);
                  return paramb;
                }
              }
              else
              {
                paramb = MMApplicationContext.getContext().getString(R.l.emu);
                AppMethodBeat.o(34309);
                return paramb;
              }
            }
            break;
          }
        }
        break;
      }
    }
    paramb = paramb.lnD;
    AppMethodBeat.o(34309);
    return paramb;
  }
  
  private static String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString, Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(269254);
    String str = paramCharSequence1.toString() + paramCharSequence2.toString();
    float f = paramPaint.measureText(str);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(269254);
      return str;
    }
    if (f < paramInt)
    {
      AppMethodBeat.o(269254);
      return str;
    }
    paramString = paramString + paramCharSequence2;
    if (paramPaint.measureText(paramString) > paramInt)
    {
      AppMethodBeat.o(269254);
      return str;
    }
    paramCharSequence2 = paramCharSequence1 + paramString;
    f = paramPaint.measureText(paramCharSequence2);
    int i = 1;
    while ((f > paramInt) && (i < 100) && (i < paramCharSequence1.length()))
    {
      paramCharSequence2 = paramCharSequence1.subSequence(0, paramCharSequence1.length() - i) + paramString;
      f = paramPaint.measureText(paramCharSequence2);
      i += 1;
    }
    AppMethodBeat.o(269254);
    return paramCharSequence2;
  }
  
  public static int b(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34308);
    if ((paramb == null) || (paramb.lnQ <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      i = R.k.c2c_aa_icon_close;
      AppMethodBeat.o(34308);
      return i;
    }
    a locala = h(paramb);
    switch (paramb.lnQ)
    {
    }
    for (;;)
    {
      i = R.k.c2c_aa_icon_close;
      AppMethodBeat.o(34308);
      return i;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.WxZ <= 0) || (locala.Wya < 0) || (locala.Wyb < 0)) {}
      }
      switch (locala.WxZ)
      {
      default: 
        break;
      case 1: 
      case 2: 
        i = R.k.c2c_aa_icon_default;
        AppMethodBeat.o(34308);
        return i;
      case 3: 
        i = R.k.c2c_aa_icon_check;
        AppMethodBeat.o(34308);
        return i;
      case 4: 
        i = R.k.c2c_aa_icon_close;
        AppMethodBeat.o(34308);
        return i;
        i = R.k.c2c_aa_icon_close;
        AppMethodBeat.o(34308);
        return i;
        if (locala.role == 2)
        {
          if ((locala.WxZ > 0) && (locala.Wyc >= 0L)) {}
          switch (locala.WxZ)
          {
          default: 
            break;
          case 1: 
            i = R.k.c2c_aa_icon_default;
            AppMethodBeat.o(34308);
            return i;
          case 2: 
          case 3: 
            i = R.k.c2c_aa_icon_check;
            AppMethodBeat.o(34308);
            return i;
          case 4: 
            i = R.k.c2c_aa_icon_close;
            AppMethodBeat.o(34308);
            return i;
            i = R.k.c2c_aa_icon_close;
            AppMethodBeat.o(34308);
            return i;
          }
        }
        else
        {
          if (locala.role == 3)
          {
            i = R.k.c2c_aa_icon_close;
            AppMethodBeat.o(34308);
            return i;
          }
          i = R.k.c2c_aa_icon_close;
          AppMethodBeat.o(34308);
          return i;
          if ((locala.role == 1) || (paramBoolean)) {
            if ((locala.WxZ <= 0) || (locala.Wya < 0) || (locala.Wyb < 0)) {}
          }
          switch (locala.WxZ)
          {
          default: 
            break;
          case 1: 
          case 2: 
            i = R.k.c2c_aa_icon_default;
            AppMethodBeat.o(34308);
            return i;
          case 3: 
            i = R.k.c2c_aa_icon_check;
            AppMethodBeat.o(34308);
            return i;
          case 4: 
            i = R.k.c2c_aa_icon_close;
            AppMethodBeat.o(34308);
            return i;
            i = R.k.c2c_aa_icon_close;
            AppMethodBeat.o(34308);
            return i;
            if (locala.role == 2)
            {
              if ((locala.WxZ > 0) && (locala.Wyc >= 0L)) {}
              switch (locala.WxZ)
              {
              default: 
                break;
              case 1: 
                i = R.k.c2c_aa_icon_default;
                AppMethodBeat.o(34308);
                return i;
              case 2: 
              case 3: 
                i = R.k.c2c_aa_icon_check;
                AppMethodBeat.o(34308);
                return i;
              case 4: 
                i = R.k.c2c_aa_icon_close;
                AppMethodBeat.o(34308);
                return i;
                i = R.k.c2c_aa_icon_close;
                AppMethodBeat.o(34308);
                return i;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.WxZ <= 0) {
                break label647;
              }
              switch (paramb.WxZ)
              {
              }
            }
            break;
          }
        }
        break;
      }
    }
    int i = R.k.c2c_aa_icon_default;
    AppMethodBeat.o(34308);
    return i;
    i = R.k.c2c_aa_icon_close;
    AppMethodBeat.o(34308);
    return i;
    label647:
    i = R.k.c2c_aa_icon_close;
    AppMethodBeat.o(34308);
    return i;
  }
  
  public static int c(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34311);
    if ((paramb == null) || (paramb.lnQ <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      if (paramBoolean)
      {
        i = R.g.aa_chatto_done_bg;
        AppMethodBeat.o(34311);
        return i;
      }
      i = R.g.aa_chatfrom_done_bg;
      AppMethodBeat.o(34311);
      return i;
    }
    Object localObject = paramb.lnP;
    abl localabl = new abl();
    localabl.gbi.gbk = ((String)localObject);
    EventCenter.instance.publish(localabl);
    if ((localabl.gbj.status == mPY) && (paramb.lnQ == 5))
    {
      if (paramBoolean)
      {
        i = R.g.aa_chatto_bg;
        AppMethodBeat.o(34311);
        return i;
      }
      i = R.g.aa_chatfrom_bg;
      AppMethodBeat.o(34311);
      return i;
    }
    if ((localabl.gbj.status == mPX) || (localabl.gbj.status == mPW) || (localabl.gbj.status == mPY))
    {
      if (paramBoolean)
      {
        i = R.g.aa_chatto_done_bg;
        AppMethodBeat.o(34311);
        return i;
      }
      i = R.g.aa_chatfrom_done_bg;
      AppMethodBeat.o(34311);
      return i;
    }
    localObject = h(paramb);
    switch (paramb.lnQ)
    {
    }
    while (paramBoolean)
    {
      i = R.g.aa_chatto_done_bg;
      AppMethodBeat.o(34311);
      return i;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
      }
      switch (((a)localObject).WxZ)
      {
      default: 
        break;
      case 1: 
      case 2: 
        if (paramBoolean)
        {
          i = R.g.aa_chatto_bg;
          AppMethodBeat.o(34311);
          return i;
        }
        i = R.g.aa_chatfrom_bg;
        AppMethodBeat.o(34311);
        return i;
      case 3: 
      case 4: 
        if (paramBoolean)
        {
          i = R.g.aa_chatto_done_bg;
          AppMethodBeat.o(34311);
          return i;
        }
        i = R.g.aa_chatfrom_done_bg;
        AppMethodBeat.o(34311);
        return i;
        if (paramBoolean)
        {
          i = R.g.aa_chatto_done_bg;
          AppMethodBeat.o(34311);
          return i;
        }
        i = R.g.aa_chatfrom_done_bg;
        AppMethodBeat.o(34311);
        return i;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
            if (paramBoolean)
            {
              i = R.g.aa_chatto_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_bg;
            AppMethodBeat.o(34311);
            return i;
          case 2: 
          case 3: 
          case 4: 
            if (paramBoolean)
            {
              i = R.g.aa_chatto_done_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_done_bg;
            AppMethodBeat.o(34311);
            return i;
            if (paramBoolean)
            {
              i = R.g.aa_chatto_done_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_done_bg;
            AppMethodBeat.o(34311);
            return i;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            if (paramBoolean)
            {
              i = R.g.aa_chatto_done_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_done_bg;
            AppMethodBeat.o(34311);
            return i;
          }
          if (paramBoolean)
          {
            i = R.g.aa_chatto_done_bg;
            AppMethodBeat.o(34311);
            return i;
          }
          i = R.g.aa_chatfrom_done_bg;
          AppMethodBeat.o(34311);
          return i;
          if ((((a)localObject).role == 1) || (paramBoolean)) {
            if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
          }
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (paramBoolean)
            {
              i = R.g.aa_chatto_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_bg;
            AppMethodBeat.o(34311);
            return i;
          case 3: 
          case 4: 
            if (paramBoolean)
            {
              i = R.g.aa_chatto_done_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_done_bg;
            AppMethodBeat.o(34311);
            return i;
            if (paramBoolean)
            {
              i = R.g.aa_chatto_done_bg;
              AppMethodBeat.o(34311);
              return i;
            }
            i = R.g.aa_chatfrom_done_bg;
            AppMethodBeat.o(34311);
            return i;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
              switch (((a)localObject).WxZ)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean)
                {
                  i = R.g.aa_chatto_bg;
                  AppMethodBeat.o(34311);
                  return i;
                }
                i = R.g.aa_chatfrom_bg;
                AppMethodBeat.o(34311);
                return i;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean)
                {
                  i = R.g.aa_chatto_done_bg;
                  AppMethodBeat.o(34311);
                  return i;
                }
                i = R.g.aa_chatfrom_done_bg;
                AppMethodBeat.o(34311);
                return i;
                if (paramBoolean)
                {
                  i = R.g.aa_chatto_done_bg;
                  AppMethodBeat.o(34311);
                  return i;
                }
                i = R.g.aa_chatfrom_done_bg;
                AppMethodBeat.o(34311);
                return i;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.WxZ > 0)
              {
                switch (paramb.WxZ)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                  if (paramBoolean)
                  {
                    i = R.g.aa_chatto_bg;
                    AppMethodBeat.o(34311);
                    return i;
                  }
                  i = R.g.aa_chatfrom_bg;
                  AppMethodBeat.o(34311);
                  return i;
                case 4: 
                  if (paramBoolean)
                  {
                    i = R.g.aa_chatto_done_bg;
                    AppMethodBeat.o(34311);
                    return i;
                  }
                  i = R.g.aa_chatfrom_done_bg;
                  AppMethodBeat.o(34311);
                  return i;
                }
              }
              else
              {
                if (paramBoolean)
                {
                  i = R.g.aa_chatto_done_bg;
                  AppMethodBeat.o(34311);
                  return i;
                }
                i = R.g.aa_chatfrom_done_bg;
                AppMethodBeat.o(34311);
                return i;
              }
            }
            break;
          }
        }
        break;
      }
    }
    int i = R.g.aa_chatfrom_done_bg;
    AppMethodBeat.o(34311);
    return i;
  }
  
  public static int d(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34312);
    if ((paramb == null) || (paramb.lnQ <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(34312);
      return -8868722;
    }
    Object localObject = paramb.lnP;
    abl localabl = new abl();
    localabl.gbi.gbk = ((String)localObject);
    EventCenter.instance.publish(localabl);
    if ((localabl.gbj.status == mPY) && (paramb.lnQ == 5))
    {
      AppMethodBeat.o(34312);
      return -12479656;
    }
    if ((localabl.gbj.status == mPX) || (localabl.gbj.status == mPW) || (localabl.gbj.status == mPY))
    {
      AppMethodBeat.o(34312);
      return -8868722;
    }
    localObject = h(paramb);
    switch (paramb.lnQ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34312);
      return -8868722;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
      }
      switch (((a)localObject).WxZ)
      {
      default: 
        break;
      case 1: 
      case 2: 
        AppMethodBeat.o(34312);
        return -12479656;
      case 3: 
      case 4: 
        AppMethodBeat.o(34312);
        return -8868722;
        AppMethodBeat.o(34312);
        return -8868722;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
            AppMethodBeat.o(34312);
            return -12479656;
          case 2: 
          case 3: 
          case 4: 
            AppMethodBeat.o(34312);
            return -8868722;
            AppMethodBeat.o(34312);
            return -8868722;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            AppMethodBeat.o(34312);
            return -8868722;
          }
          AppMethodBeat.o(34312);
          return -8868722;
          if ((((a)localObject).role == 1) || (paramBoolean)) {
            if ((((a)localObject).WxZ <= 0) || (((a)localObject).Wya < 0) || (((a)localObject).Wyb < 0)) {}
          }
          switch (((a)localObject).WxZ)
          {
          default: 
            break;
          case 1: 
          case 2: 
            AppMethodBeat.o(34312);
            return -12479656;
          case 3: 
          case 4: 
            AppMethodBeat.o(34312);
            return -8868722;
            AppMethodBeat.o(34312);
            return -8868722;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).WxZ > 0) && (((a)localObject).Wyc >= 0L)) {}
              switch (((a)localObject).WxZ)
              {
              default: 
                break;
              case 1: 
                AppMethodBeat.o(34312);
                return -12479656;
              case 2: 
              case 3: 
              case 4: 
                AppMethodBeat.o(34312);
                return -8868722;
                AppMethodBeat.o(34312);
                return -8868722;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.WxZ <= 0) {
                break label675;
              }
              switch (paramb.WxZ)
              {
              }
            }
            break;
          }
        }
        break;
      }
    }
    AppMethodBeat.o(34312);
    return -12479656;
    AppMethodBeat.o(34312);
    return -8868722;
    label675:
    AppMethodBeat.o(34312);
    return -8868722;
  }
  
  public static a h(k.b paramb)
  {
    AppMethodBeat.i(34307);
    String str = z.bcZ();
    if ((paramb.lnQ == 2) || (paramb.lnQ == 3) || (paramb.lnQ == 5))
    {
      Object localObject;
      if (!Util.isNullOrNil(paramb.lnU))
      {
        localObject = paramb.lnU.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          if ((arrayOfString.length == 4) && (arrayOfString[0].equals(str)))
          {
            paramb = new a(Util.getInt(arrayOfString[1], -1), Util.getInt(arrayOfString[2], -1), Util.getInt(arrayOfString[3], -1));
            AppMethodBeat.o(34307);
            return paramb;
          }
        }
      }
      if (!Util.isNullOrNil(paramb.lnW))
      {
        paramb = paramb.lnW.iterator();
        while (paramb.hasNext())
        {
          localObject = ((String)paramb.next()).split(",");
          if ((localObject.length == 3) && (localObject[0].equals(str)))
          {
            long l = Util.getLong(localObject[1], -1L);
            paramb = new a(Util.getInt(localObject[2], -1), l);
            AppMethodBeat.o(34307);
            return paramb;
          }
        }
      }
    }
    paramb = new a();
    AppMethodBeat.o(34307);
    return paramb;
  }
  
  private static a i(k.b paramb)
  {
    AppMethodBeat.i(269246);
    if (((paramb.lnQ == 2) || (paramb.lnQ == 3) || (paramb.lnQ == 5)) && (!Util.isNullOrNil(paramb.lnU)))
    {
      paramb = paramb.lnU.iterator();
      while (paramb.hasNext())
      {
        String[] arrayOfString = ((String)paramb.next()).split(",");
        if (arrayOfString.length == 4)
        {
          paramb = new a(Util.getInt(arrayOfString[1], -1), Util.getInt(arrayOfString[2], -1), Util.getInt(arrayOfString[3], -1));
          AppMethodBeat.o(269246);
          return paramb;
        }
      }
    }
    paramb = new a();
    AppMethodBeat.o(269246);
    return paramb;
  }
  
  public static final class a
  {
    public int WxZ;
    public int Wya = -1;
    public int Wyb = -1;
    public long Wyc = -1L;
    public int role;
    
    public a()
    {
      this.role = 3;
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.role = 1;
      this.WxZ = paramInt1;
      this.Wya = paramInt2;
      this.Wyb = paramInt3;
    }
    
    public a(int paramInt, long paramLong)
    {
      this.role = 2;
      this.WxZ = paramInt;
      this.Wyc = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */