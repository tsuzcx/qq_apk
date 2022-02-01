package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.adi;
import com.tencent.mm.autogen.a.adi.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.message.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static int pMD = 1;
  private static int pME = 2;
  private static int pMF = 3;
  private static int pMG = 4;
  
  public static int T(int paramInt1, int paramInt2, boolean paramBoolean)
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
        return R.g.fmR;
      }
      return R.g.fmP;
    }
    if (paramBoolean) {
      return R.g.fmR;
    }
    return R.g.fmP;
  }
  
  public static int U(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  public static int V(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5)
    {
      if (paramBoolean) {
        return R.g.fot;
      }
      return R.g.foc;
    }
    if (paramInt1 == 4)
    {
      if (paramBoolean) {
        return R.g.fot;
      }
      return R.g.foc;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        if (paramBoolean) {
          return R.g.fot;
        }
        return R.g.foc;
      }
      if (paramBoolean) {
        return R.g.fos;
      }
      return R.g.fob;
    }
    if (paramBoolean) {
      return R.g.fos;
    }
    return R.g.fob;
  }
  
  public static float a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(253928);
    if ((paramb == null) || (paramb.nSU <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(253928);
      return 0.3F;
    }
    Object localObject = paramb.nST;
    adi localadi = new adi();
    localadi.ihs.ihu = ((String)localObject);
    localadi.publish();
    if ((localadi.iht.status == pMG) && (paramb.nSU == 5))
    {
      if (paramBoolean2)
      {
        AppMethodBeat.o(253928);
        return 0.5F;
      }
      AppMethodBeat.o(253928);
      return 0.8F;
    }
    if ((localadi.iht.status == pMF) || (localadi.iht.status == pME) || (localadi.iht.status == pMG))
    {
      AppMethodBeat.o(253928);
      return 0.3F;
    }
    localObject = i(paramb);
    switch (paramb.nSU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(253928);
      return 0.3F;
      if ((((a)localObject).role == 1) || (paramBoolean1)) {
        if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
      }
      switch (((a)localObject).aefw)
      {
      default: 
        break;
      case 1: 
      case 2: 
        if (paramBoolean2)
        {
          AppMethodBeat.o(253928);
          return 0.5F;
        }
        AppMethodBeat.o(253928);
        return 0.8F;
      case 3: 
      case 4: 
        AppMethodBeat.o(253928);
        return 0.3F;
        AppMethodBeat.o(253928);
        return 0.3F;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
          switch (((a)localObject).aefw)
          {
          default: 
            break;
          case 1: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(253928);
              return 0.5F;
            }
            AppMethodBeat.o(253928);
            return 0.8F;
          case 2: 
          case 3: 
          case 4: 
            AppMethodBeat.o(253928);
            return 0.3F;
            AppMethodBeat.o(253928);
            return 0.3F;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            AppMethodBeat.o(253928);
            return 0.3F;
          }
          AppMethodBeat.o(253928);
          return 0.3F;
          if ((((a)localObject).role == 1) || (paramBoolean1)) {
            if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
          }
          switch (((a)localObject).aefw)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(253928);
              return 0.5F;
            }
            AppMethodBeat.o(253928);
            return 0.8F;
          case 3: 
          case 4: 
            AppMethodBeat.o(253928);
            return 0.3F;
            AppMethodBeat.o(253928);
            return 0.3F;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
              switch (((a)localObject).aefw)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean2)
                {
                  AppMethodBeat.o(253928);
                  return 0.5F;
                }
                AppMethodBeat.o(253928);
                return 0.8F;
              case 2: 
              case 3: 
              case 4: 
                AppMethodBeat.o(253928);
                return 0.3F;
                AppMethodBeat.o(253928);
                return 0.3F;
              }
            }
            else
            {
              paramb = j(paramb);
              if (paramb.aefw <= 0) {
                break label707;
              }
              switch (paramb.aefw)
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
      AppMethodBeat.o(253928);
      return 0.5F;
    }
    AppMethodBeat.o(253928);
    return 0.8F;
    AppMethodBeat.o(253928);
    return 0.3F;
    label707:
    AppMethodBeat.o(253928);
    return 0.3F;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString, k.b paramb, TextView paramTextView)
  {
    AppMethodBeat.i(253931);
    Context localContext = MMApplicationContext.getContext();
    paramb = (c)paramb.aK(c.class);
    Log.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s exclusiveRecvUsername: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2), paramb.nQc });
    if (paramInt2 == 5)
    {
      paramString = localContext.getString(R.l.gMM);
      AppMethodBeat.o(253931);
      return paramString;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 4)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.gMN);
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramString = localContext.getString(R.l.gMI);
        AppMethodBeat.o(253931);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.gMN);
          AppMethodBeat.o(253931);
          return paramString;
        }
        AppMethodBeat.o(253931);
        return "";
      }
    }
    else if (paramInt1 == 0)
    {
      if (paramInt2 == 4)
      {
        if (paramBoolean1)
        {
          paramString = localContext.getString(R.l.gMI);
          AppMethodBeat.o(253931);
          return paramString;
        }
        if (paramBoolean2)
        {
          if (paramInt3 == 2)
          {
            paramString = localContext.getString(R.l.gMN);
            AppMethodBeat.o(253931);
            return paramString;
          }
          paramString = localContext.getString(R.l.gMI);
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramString = localContext.getString(R.l.gMN);
        AppMethodBeat.o(253931);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramBoolean1)
        {
          AppMethodBeat.o(253931);
          return "";
        }
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(R.l.gMN);
          AppMethodBeat.o(253931);
          return paramString;
        }
        AppMethodBeat.o(253931);
        return "";
      }
    }
    else
    {
      if ((paramInt1 == 3) && (!Util.isNullOrNil(paramb.nQc)))
      {
        paramString = aa.aV(paramb.nQc, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(R.l.gML, new Object[] { paramString });
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramString = localContext.getString(R.l.gMJ, new Object[] { paramString });
        if (paramTextView == null)
        {
          paramString = paramString + localContext.getString(R.l.gMK);
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramInt2 = paramTextView.getWidth();
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(R.l.gMK), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(253931);
        return paramString;
      }
      if (!Util.isNullOrNil(paramb.nQc))
      {
        paramString = aa.aV(paramb.nQc, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(R.l.gML, new Object[] { paramString });
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramString = localContext.getString(R.l.gMJ, new Object[] { paramString });
        if (paramTextView == null)
        {
          paramString = paramString + localContext.getString(R.l.gMK);
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramInt2 = paramTextView.getWidth();
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(R.l.gMK), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(253931);
        return paramString;
      }
      if (paramInt2 == 4)
      {
        if ((!paramBoolean2) || ((paramBoolean1) && (paramInt3 == 2)))
        {
          paramString = localContext.getString(R.l.gMN);
          AppMethodBeat.o(253931);
          return paramString;
        }
        paramString = localContext.getString(R.l.gMI);
        AppMethodBeat.o(253931);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          if (paramBoolean1)
          {
            AppMethodBeat.o(253931);
            return "";
          }
          paramString = localContext.getString(R.l.gMN);
          AppMethodBeat.o(253931);
          return paramString;
        }
        AppMethodBeat.o(253931);
        return "";
      }
    }
    AppMethodBeat.o(253931);
    return "";
  }
  
  public static String a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34309);
    if ((paramb == null) || (paramb.nSU <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      if (paramBoolean)
      {
        paramb = paramb.nSG;
        AppMethodBeat.o(34309);
        return paramb;
      }
      paramb = paramb.nSH;
      AppMethodBeat.o(34309);
      return paramb;
    }
    a locala = i(paramb);
    String str = paramb.nST;
    adi localadi = new adi();
    localadi.ihs.ihu = str;
    localadi.publish();
    switch (paramb.nSU)
    {
    }
    while (paramBoolean)
    {
      paramb = paramb.nSG;
      AppMethodBeat.o(34309);
      return paramb;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.aefw <= 0) || (locala.aefx < 0) || (locala.aefy < 0)) {}
      }
      switch (locala.aefw)
      {
      default: 
        break;
      case 1: 
        paramb = MMApplicationContext.getContext().getString(R.l.gpE);
        AppMethodBeat.o(34309);
        return paramb;
      case 2: 
        paramb = MMApplicationContext.getContext().getString(R.l.gpB, new Object[] { Integer.valueOf(locala.aefx - locala.aefy) });
        AppMethodBeat.o(34309);
        return paramb;
      case 3: 
        paramb = MMApplicationContext.getContext().getString(R.l.gpz);
        AppMethodBeat.o(34309);
        return paramb;
      case 4: 
        paramb = MMApplicationContext.getContext().getString(R.l.gpD);
        AppMethodBeat.o(34309);
        return paramb;
        paramb = MMApplicationContext.getContext().getString(R.l.gpD);
        AppMethodBeat.o(34309);
        return paramb;
        if (locala.role == 2)
        {
          if ((locala.aefw > 0) && (locala.aefz >= 0L)) {}
          switch (locala.aefw)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpw, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpv, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpy, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpx);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(R.l.gpx);
            AppMethodBeat.o(34309);
            return paramb;
          }
        }
        else
        {
          if (locala.role == 3)
          {
            paramb = MMApplicationContext.getContext().getString(R.l.gpx);
            AppMethodBeat.o(34309);
            return paramb;
          }
          paramb = MMApplicationContext.getContext().getString(R.l.gpx);
          AppMethodBeat.o(34309);
          return paramb;
          if ((locala.role == 1) || (paramBoolean)) {
            if ((locala.aefw <= 0) || (locala.aefx < 0) || (locala.aefy < 0)) {}
          }
          switch (locala.aefw)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpE);
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpC, new Object[] { Integer.valueOf(locala.aefx) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpz);
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(R.l.gpD);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(R.l.gpD);
            AppMethodBeat.o(34309);
            return paramb;
            if (locala.role == 2)
            {
              if ((locala.aefw > 0) && (locala.aefz >= 0L)) {}
              switch (locala.aefw)
              {
              default: 
                break;
              case 1: 
                paramb = MMApplicationContext.getContext().getString(R.l.gpw, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 2: 
                paramb = MMApplicationContext.getContext().getString(R.l.gpv, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 3: 
                paramb = MMApplicationContext.getContext().getString(R.l.gpy, new Object[] { Float.valueOf((float)locala.aefz / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 4: 
                paramb = MMApplicationContext.getContext().getString(R.l.gpx);
                AppMethodBeat.o(34309);
                return paramb;
                paramb = MMApplicationContext.getContext().getString(R.l.gpx);
                AppMethodBeat.o(34309);
                return paramb;
              }
            }
            else
            {
              locala = j(paramb);
              if (locala.aefw > 0)
              {
                switch (locala.aefw)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                  paramb = MMApplicationContext.getContext().getString(R.l.gpA);
                  AppMethodBeat.o(34309);
                  return paramb;
                case 4: 
                  paramb = MMApplicationContext.getContext().getString(R.l.gpx);
                  AppMethodBeat.o(34309);
                  return paramb;
                }
              }
              else
              {
                paramb = MMApplicationContext.getContext().getString(R.l.gpx);
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
    paramb = paramb.nSH;
    AppMethodBeat.o(34309);
    return paramb;
  }
  
  private static String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString, Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(253937);
    String str = paramCharSequence1.toString() + paramCharSequence2.toString();
    float f = paramPaint.measureText(str);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(253937);
      return str;
    }
    if (f < paramInt)
    {
      AppMethodBeat.o(253937);
      return str;
    }
    paramString = paramString + paramCharSequence2;
    if (paramPaint.measureText(paramString) > paramInt)
    {
      AppMethodBeat.o(253937);
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
    AppMethodBeat.o(253937);
    return paramCharSequence2;
  }
  
  public static int b(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34308);
    if ((paramb == null) || (paramb.nSU <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      i = R.k.c2c_aa_icon_close;
      AppMethodBeat.o(34308);
      return i;
    }
    a locala = i(paramb);
    switch (paramb.nSU)
    {
    }
    for (;;)
    {
      i = R.k.c2c_aa_icon_close;
      AppMethodBeat.o(34308);
      return i;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.aefw <= 0) || (locala.aefx < 0) || (locala.aefy < 0)) {}
      }
      switch (locala.aefw)
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
          if ((locala.aefw > 0) && (locala.aefz >= 0L)) {}
          switch (locala.aefw)
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
            if ((locala.aefw <= 0) || (locala.aefx < 0) || (locala.aefy < 0)) {}
          }
          switch (locala.aefw)
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
              if ((locala.aefw > 0) && (locala.aefz >= 0L)) {}
              switch (locala.aefw)
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
              paramb = j(paramb);
              if (paramb.aefw <= 0) {
                break label647;
              }
              switch (paramb.aefw)
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
    if ((paramb == null) || (paramb.nSU <= 0))
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
    Object localObject = paramb.nST;
    adi localadi = new adi();
    localadi.ihs.ihu = ((String)localObject);
    localadi.publish();
    if ((localadi.iht.status == pMG) && (paramb.nSU == 5))
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
    if ((localadi.iht.status == pMF) || (localadi.iht.status == pME) || (localadi.iht.status == pMG))
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
    localObject = i(paramb);
    switch (paramb.nSU)
    {
    }
    while (paramBoolean)
    {
      i = R.g.aa_chatto_done_bg;
      AppMethodBeat.o(34311);
      return i;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
      }
      switch (((a)localObject).aefw)
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
          if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
          switch (((a)localObject).aefw)
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
            if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
          }
          switch (((a)localObject).aefw)
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
              if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
              switch (((a)localObject).aefw)
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
              paramb = j(paramb);
              if (paramb.aefw > 0)
              {
                switch (paramb.aefw)
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
    if ((paramb == null) || (paramb.nSU <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(34312);
      return -8868722;
    }
    Object localObject = paramb.nST;
    adi localadi = new adi();
    localadi.ihs.ihu = ((String)localObject);
    localadi.publish();
    if ((localadi.iht.status == pMG) && (paramb.nSU == 5))
    {
      AppMethodBeat.o(34312);
      return -12479656;
    }
    if ((localadi.iht.status == pMF) || (localadi.iht.status == pME) || (localadi.iht.status == pMG))
    {
      AppMethodBeat.o(34312);
      return -8868722;
    }
    localObject = i(paramb);
    switch (paramb.nSU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34312);
      return -8868722;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
      }
      switch (((a)localObject).aefw)
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
          if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
          switch (((a)localObject).aefw)
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
            if ((((a)localObject).aefw <= 0) || (((a)localObject).aefx < 0) || (((a)localObject).aefy < 0)) {}
          }
          switch (((a)localObject).aefw)
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
              if ((((a)localObject).aefw > 0) && (((a)localObject).aefz >= 0L)) {}
              switch (((a)localObject).aefw)
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
              paramb = j(paramb);
              if (paramb.aefw <= 0) {
                break label671;
              }
              switch (paramb.aefw)
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
    label671:
    AppMethodBeat.o(34312);
    return -8868722;
  }
  
  public static a i(k.b paramb)
  {
    AppMethodBeat.i(34307);
    String str = z.bAM();
    if ((paramb.nSU == 2) || (paramb.nSU == 3) || (paramb.nSU == 5))
    {
      Object localObject;
      if (!Util.isNullOrNil(paramb.nSY))
      {
        localObject = paramb.nSY.iterator();
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
      if (!Util.isNullOrNil(paramb.nTa))
      {
        paramb = paramb.nTa.iterator();
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
  
  private static a j(k.b paramb)
  {
    AppMethodBeat.i(253904);
    if (((paramb.nSU == 2) || (paramb.nSU == 3) || (paramb.nSU == 5)) && (!Util.isNullOrNil(paramb.nSY)))
    {
      paramb = paramb.nSY.iterator();
      while (paramb.hasNext())
      {
        String[] arrayOfString = ((String)paramb.next()).split(",");
        if (arrayOfString.length == 4)
        {
          paramb = new a(Util.getInt(arrayOfString[1], -1), Util.getInt(arrayOfString[2], -1), Util.getInt(arrayOfString[3], -1));
          AppMethodBeat.o(253904);
          return paramb;
        }
      }
    }
    paramb = new a();
    AppMethodBeat.o(253904);
    return paramb;
  }
  
  public static final class a
  {
    public int aefw;
    public int aefx = -1;
    public int aefy = -1;
    public long aefz = -1L;
    public int role;
    
    public a()
    {
      this.role = 3;
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.role = 1;
      this.aefw = paramInt1;
      this.aefx = paramInt2;
      this.aefy = paramInt3;
    }
    
    public a(int paramInt, long paramLong)
    {
      this.role = 2;
      this.aefw = paramInt;
      this.aefz = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */