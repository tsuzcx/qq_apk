package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.aae;
import com.tencent.mm.g.a.aae.b;
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
  private static int jYE = 1;
  private static int jYF = 2;
  private static int jYG = 3;
  private static int jYH = 4;
  
  public static int I(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2131231459;
        return 2131231453;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2131231453;
      if (paramInt1 != 3) {
        break label54;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2131231453;
    if (paramBoolean) {
      return 2131231454;
    }
    return 2131231448;
    label54:
    if (paramBoolean) {
      return 2131231454;
    }
    return 2131231448;
  }
  
  public static int J(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {}
    do
    {
      do
      {
        return 2131233754;
      } while (paramInt1 == 4);
      if (paramInt1 != 3) {
        break label31;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (!paramBoolean);
    return -1;
    return -1;
    label31:
    return -1;
  }
  
  public static int K(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2131233800;
        return 2131233675;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2131233675;
      if (paramInt1 != 3) {
        break label54;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2131233675;
    if (paramBoolean) {
      return 2131233799;
    }
    return 2131233674;
    label54:
    if (paramBoolean) {
      return 2131233799;
    }
    return 2131233674;
  }
  
  public static float a(k.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(232839);
    if ((paramb == null) || (paramb.iyA <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(232839);
      return 0.3F;
    }
    Object localObject = paramb.iyz;
    aae localaae = new aae();
    localaae.egS.egU = ((String)localObject);
    EventCenter.instance.publish(localaae);
    if ((localaae.egT.status == jYH) && (paramb.iyA == 5))
    {
      if (paramBoolean2)
      {
        AppMethodBeat.o(232839);
        return 0.5F;
      }
      AppMethodBeat.o(232839);
      return 0.8F;
    }
    if ((localaae.egT.status == jYG) || (localaae.egT.status == jYF) || (localaae.egT.status == jYH))
    {
      AppMethodBeat.o(232839);
      return 0.3F;
    }
    localObject = h(paramb);
    switch (paramb.iyA)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(232839);
      return 0.3F;
      if ((((a)localObject).role == 1) || (paramBoolean1)) {
        if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
      }
      switch (((a)localObject).PeH)
      {
      default: 
        break;
      case 1: 
      case 2: 
        if (paramBoolean2)
        {
          AppMethodBeat.o(232839);
          return 0.5F;
        }
        AppMethodBeat.o(232839);
        return 0.8F;
      case 3: 
      case 4: 
        AppMethodBeat.o(232839);
        return 0.3F;
        AppMethodBeat.o(232839);
        return 0.3F;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
          switch (((a)localObject).PeH)
          {
          default: 
            break;
          case 1: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(232839);
              return 0.5F;
            }
            AppMethodBeat.o(232839);
            return 0.8F;
          case 2: 
          case 3: 
          case 4: 
            AppMethodBeat.o(232839);
            return 0.3F;
            AppMethodBeat.o(232839);
            return 0.3F;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            AppMethodBeat.o(232839);
            return 0.3F;
          }
          AppMethodBeat.o(232839);
          return 0.3F;
          if ((((a)localObject).role == 1) || (paramBoolean1)) {
            if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
          }
          switch (((a)localObject).PeH)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (paramBoolean2)
            {
              AppMethodBeat.o(232839);
              return 0.5F;
            }
            AppMethodBeat.o(232839);
            return 0.8F;
          case 3: 
          case 4: 
            AppMethodBeat.o(232839);
            return 0.3F;
            AppMethodBeat.o(232839);
            return 0.3F;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
              switch (((a)localObject).PeH)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean2)
                {
                  AppMethodBeat.o(232839);
                  return 0.5F;
                }
                AppMethodBeat.o(232839);
                return 0.8F;
              case 2: 
              case 3: 
              case 4: 
                AppMethodBeat.o(232839);
                return 0.3F;
                AppMethodBeat.o(232839);
                return 0.3F;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.PeH <= 0) {
                break label711;
              }
              switch (paramb.PeH)
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
      AppMethodBeat.o(232839);
      return 0.5F;
    }
    AppMethodBeat.o(232839);
    return 0.8F;
    AppMethodBeat.o(232839);
    return 0.3F;
    label711:
    AppMethodBeat.o(232839);
    return 0.3F;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString, k.b paramb, TextView paramTextView)
  {
    AppMethodBeat.i(232840);
    Context localContext = MMApplicationContext.getContext();
    paramb = (c)paramb.as(c.class);
    Log.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s exclusiveRecvUsername: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2), paramb.iwa });
    if (paramInt2 == 5)
    {
      paramString = localContext.getString(2131762591);
      AppMethodBeat.o(232840);
      return paramString;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 4)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(2131762592);
          AppMethodBeat.o(232840);
          return paramString;
        }
        paramString = localContext.getString(2131762587);
        AppMethodBeat.o(232840);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(2131762592);
          AppMethodBeat.o(232840);
          return paramString;
        }
        AppMethodBeat.o(232840);
        return "";
      }
    }
    else if (paramInt1 == 0)
    {
      if (paramInt2 == 4)
      {
        if (paramBoolean1)
        {
          paramString = localContext.getString(2131762587);
          AppMethodBeat.o(232840);
          return paramString;
        }
        if (paramBoolean2)
        {
          if (paramInt3 == 2)
          {
            paramString = localContext.getString(2131762592);
            AppMethodBeat.o(232840);
            return paramString;
          }
          paramString = localContext.getString(2131762587);
          AppMethodBeat.o(232840);
          return paramString;
        }
        paramString = localContext.getString(2131762592);
        AppMethodBeat.o(232840);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramBoolean1)
        {
          AppMethodBeat.o(232840);
          return "";
        }
        if (paramInt3 == 2)
        {
          paramString = localContext.getString(2131762592);
          AppMethodBeat.o(232840);
          return paramString;
        }
        AppMethodBeat.o(232840);
        return "";
      }
    }
    else
    {
      if ((paramInt1 == 3) && (!Util.isNullOrNil(paramb.iwa)))
      {
        paramString = aa.getDisplayName(paramb.iwa, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(2131762590, new Object[] { paramString });
          AppMethodBeat.o(232840);
          return paramString;
        }
        paramString = localContext.getString(2131762588, new Object[] { paramString });
        paramInt1 = paramTextView.getWidth();
        if (paramInt1 <= 0) {
          a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(2131762589), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(232840);
        return paramString;
      }
      if (!Util.isNullOrNil(paramb.iwa))
      {
        paramString = aa.getDisplayName(paramb.iwa, paramString);
        if (paramInt2 == 4)
        {
          paramString = localContext.getString(2131762590, new Object[] { paramString });
          AppMethodBeat.o(232840);
          return paramString;
        }
        paramString = localContext.getString(2131762588, new Object[] { paramString });
        paramInt1 = paramTextView.getWidth();
        if (paramInt1 <= 0) {
          a.fromDPToPix(MMApplicationContext.getContext(), 150);
        }
        paramString = a(paramString, localContext.getString(2131762589), "...", paramTextView.getPaint(), paramInt1);
        AppMethodBeat.o(232840);
        return paramString;
      }
      if (paramInt2 == 4)
      {
        if ((!paramBoolean2) || ((paramBoolean1) && (paramInt3 == 2)))
        {
          paramString = localContext.getString(2131762592);
          AppMethodBeat.o(232840);
          return paramString;
        }
        paramString = localContext.getString(2131762587);
        AppMethodBeat.o(232840);
        return paramString;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          if (paramBoolean1)
          {
            AppMethodBeat.o(232840);
            return "";
          }
          paramString = localContext.getString(2131762592);
          AppMethodBeat.o(232840);
          return paramString;
        }
        AppMethodBeat.o(232840);
        return "";
      }
    }
    AppMethodBeat.o(232840);
    return "";
  }
  
  public static String a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34309);
    if ((paramb == null) || (paramb.iyA <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      if (paramBoolean)
      {
        paramb = paramb.iym;
        AppMethodBeat.o(34309);
        return paramb;
      }
      paramb = paramb.iyn;
      AppMethodBeat.o(34309);
      return paramb;
    }
    a locala = h(paramb);
    String str = paramb.iyz;
    aae localaae = new aae();
    localaae.egS.egU = str;
    EventCenter.instance.publish(localaae);
    switch (paramb.iyA)
    {
    }
    while (paramBoolean)
    {
      paramb = paramb.iym;
      AppMethodBeat.o(34309);
      return paramb;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.PeH <= 0) || (locala.PeI < 0) || (locala.PeJ < 0)) {}
      }
      switch (locala.PeH)
      {
      default: 
        break;
      case 1: 
        paramb = MMApplicationContext.getContext().getString(2131755063);
        AppMethodBeat.o(34309);
        return paramb;
      case 2: 
        paramb = MMApplicationContext.getContext().getString(2131755060, new Object[] { Integer.valueOf(locala.PeI - locala.PeJ) });
        AppMethodBeat.o(34309);
        return paramb;
      case 3: 
        paramb = MMApplicationContext.getContext().getString(2131755057);
        AppMethodBeat.o(34309);
        return paramb;
      case 4: 
        paramb = MMApplicationContext.getContext().getString(2131755062);
        AppMethodBeat.o(34309);
        return paramb;
        paramb = MMApplicationContext.getContext().getString(2131755062);
        AppMethodBeat.o(34309);
        return paramb;
        if (locala.role == 2)
        {
          if ((locala.PeH > 0) && (locala.PeK >= 0L)) {}
          switch (locala.PeH)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(2131755054, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(2131755053, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(2131755056, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(2131755055);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(2131755055);
            AppMethodBeat.o(34309);
            return paramb;
          }
        }
        else
        {
          if (locala.role == 3)
          {
            paramb = MMApplicationContext.getContext().getString(2131755055);
            AppMethodBeat.o(34309);
            return paramb;
          }
          paramb = MMApplicationContext.getContext().getString(2131755055);
          AppMethodBeat.o(34309);
          return paramb;
          if ((locala.role == 1) || (paramBoolean)) {
            if ((locala.PeH <= 0) || (locala.PeI < 0) || (locala.PeJ < 0)) {}
          }
          switch (locala.PeH)
          {
          default: 
            break;
          case 1: 
            paramb = MMApplicationContext.getContext().getString(2131755063);
            AppMethodBeat.o(34309);
            return paramb;
          case 2: 
            paramb = MMApplicationContext.getContext().getString(2131755061, new Object[] { Integer.valueOf(locala.PeI) });
            AppMethodBeat.o(34309);
            return paramb;
          case 3: 
            paramb = MMApplicationContext.getContext().getString(2131755057);
            AppMethodBeat.o(34309);
            return paramb;
          case 4: 
            paramb = MMApplicationContext.getContext().getString(2131755062);
            AppMethodBeat.o(34309);
            return paramb;
            paramb = MMApplicationContext.getContext().getString(2131755062);
            AppMethodBeat.o(34309);
            return paramb;
            if (locala.role == 2)
            {
              if ((locala.PeH > 0) && (locala.PeK >= 0L)) {}
              switch (locala.PeH)
              {
              default: 
                break;
              case 1: 
                paramb = MMApplicationContext.getContext().getString(2131755054, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 2: 
                paramb = MMApplicationContext.getContext().getString(2131755053, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 3: 
                paramb = MMApplicationContext.getContext().getString(2131755056, new Object[] { Float.valueOf((float)locala.PeK / 100.0F) });
                AppMethodBeat.o(34309);
                return paramb;
              case 4: 
                paramb = MMApplicationContext.getContext().getString(2131755055);
                AppMethodBeat.o(34309);
                return paramb;
                paramb = MMApplicationContext.getContext().getString(2131755055);
                AppMethodBeat.o(34309);
                return paramb;
              }
            }
            else
            {
              locala = i(paramb);
              if (locala.PeH > 0)
              {
                switch (locala.PeH)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                  paramb = MMApplicationContext.getContext().getString(2131755058);
                  AppMethodBeat.o(34309);
                  return paramb;
                case 4: 
                  paramb = MMApplicationContext.getContext().getString(2131755055);
                  AppMethodBeat.o(34309);
                  return paramb;
                }
              }
              else
              {
                paramb = MMApplicationContext.getContext().getString(2131755055);
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
    paramb = paramb.iyn;
    AppMethodBeat.o(34309);
    return paramb;
  }
  
  private static String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, String paramString, Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(232841);
    String str = paramCharSequence1.toString() + paramCharSequence2.toString();
    float f = paramPaint.measureText(str);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(232841);
      return str;
    }
    if (f < paramInt)
    {
      AppMethodBeat.o(232841);
      return str;
    }
    paramString = paramString + paramCharSequence2;
    if (paramPaint.measureText(paramString) > paramInt)
    {
      AppMethodBeat.o(232841);
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
    AppMethodBeat.o(232841);
    return paramCharSequence2;
  }
  
  public static int b(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34308);
    if ((paramb == null) || (paramb.iyA <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(34308);
      return 2131689858;
    }
    a locala = h(paramb);
    switch (paramb.iyA)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34308);
      return 2131689858;
      if ((locala.role == 1) || (paramBoolean)) {
        if ((locala.PeH <= 0) || (locala.PeI < 0) || (locala.PeJ < 0)) {}
      }
      switch (locala.PeH)
      {
      default: 
        break;
      case 1: 
      case 2: 
        AppMethodBeat.o(34308);
        return 2131689859;
      case 3: 
        AppMethodBeat.o(34308);
        return 2131689857;
      case 4: 
        AppMethodBeat.o(34308);
        return 2131689858;
        AppMethodBeat.o(34308);
        return 2131689858;
        if (locala.role == 2)
        {
          if ((locala.PeH > 0) && (locala.PeK >= 0L)) {}
          switch (locala.PeH)
          {
          default: 
            break;
          case 1: 
            AppMethodBeat.o(34308);
            return 2131689859;
          case 2: 
          case 3: 
            AppMethodBeat.o(34308);
            return 2131689857;
          case 4: 
            AppMethodBeat.o(34308);
            return 2131689858;
            AppMethodBeat.o(34308);
            return 2131689858;
          }
        }
        else
        {
          if (locala.role == 3)
          {
            AppMethodBeat.o(34308);
            return 2131689858;
          }
          AppMethodBeat.o(34308);
          return 2131689858;
          if ((locala.role == 1) || (paramBoolean)) {
            if ((locala.PeH <= 0) || (locala.PeI < 0) || (locala.PeJ < 0)) {}
          }
          switch (locala.PeH)
          {
          default: 
            break;
          case 1: 
          case 2: 
            AppMethodBeat.o(34308);
            return 2131689859;
          case 3: 
            AppMethodBeat.o(34308);
            return 2131689857;
          case 4: 
            AppMethodBeat.o(34308);
            return 2131689858;
            AppMethodBeat.o(34308);
            return 2131689858;
            if (locala.role == 2)
            {
              if ((locala.PeH > 0) && (locala.PeK >= 0L)) {}
              switch (locala.PeH)
              {
              default: 
                break;
              case 1: 
                AppMethodBeat.o(34308);
                return 2131689859;
              case 2: 
              case 3: 
                AppMethodBeat.o(34308);
                return 2131689857;
              case 4: 
                AppMethodBeat.o(34308);
                return 2131689858;
                AppMethodBeat.o(34308);
                return 2131689858;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.PeH <= 0) {
                break label599;
              }
              switch (paramb.PeH)
              {
              }
            }
            break;
          }
        }
        break;
      }
    }
    AppMethodBeat.o(34308);
    return 2131689859;
    AppMethodBeat.o(34308);
    return 2131689858;
    label599:
    AppMethodBeat.o(34308);
    return 2131689858;
  }
  
  public static int c(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34311);
    if ((paramb == null) || (paramb.iyA <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      if (paramBoolean)
      {
        AppMethodBeat.o(34311);
        return 2131230738;
      }
      AppMethodBeat.o(34311);
      return 2131230732;
    }
    Object localObject = paramb.iyz;
    aae localaae = new aae();
    localaae.egS.egU = ((String)localObject);
    EventCenter.instance.publish(localaae);
    if ((localaae.egT.status == jYH) && (paramb.iyA == 5))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(34311);
        return 2131230733;
      }
      AppMethodBeat.o(34311);
      return 2131230727;
    }
    if ((localaae.egT.status == jYG) || (localaae.egT.status == jYF) || (localaae.egT.status == jYH))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(34311);
        return 2131230738;
      }
      AppMethodBeat.o(34311);
      return 2131230732;
    }
    localObject = h(paramb);
    switch (paramb.iyA)
    {
    }
    while (paramBoolean)
    {
      AppMethodBeat.o(34311);
      return 2131230738;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
      }
      switch (((a)localObject).PeH)
      {
      default: 
        break;
      case 1: 
      case 2: 
        if (paramBoolean)
        {
          AppMethodBeat.o(34311);
          return 2131230733;
        }
        AppMethodBeat.o(34311);
        return 2131230727;
      case 3: 
      case 4: 
        if (paramBoolean)
        {
          AppMethodBeat.o(34311);
          return 2131230738;
        }
        AppMethodBeat.o(34311);
        return 2131230732;
        if (paramBoolean)
        {
          AppMethodBeat.o(34311);
          return 2131230738;
        }
        AppMethodBeat.o(34311);
        return 2131230732;
        if (((a)localObject).role == 2)
        {
          if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
          switch (((a)localObject).PeH)
          {
          default: 
            break;
          case 1: 
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230733;
            }
            AppMethodBeat.o(34311);
            return 2131230727;
          case 2: 
          case 3: 
          case 4: 
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230738;
            }
            AppMethodBeat.o(34311);
            return 2131230732;
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230738;
            }
            AppMethodBeat.o(34311);
            return 2131230732;
          }
        }
        else
        {
          if (((a)localObject).role == 3)
          {
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230738;
            }
            AppMethodBeat.o(34311);
            return 2131230732;
          }
          if (paramBoolean)
          {
            AppMethodBeat.o(34311);
            return 2131230738;
          }
          AppMethodBeat.o(34311);
          return 2131230732;
          if ((((a)localObject).role == 1) || (paramBoolean)) {
            if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
          }
          switch (((a)localObject).PeH)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230733;
            }
            AppMethodBeat.o(34311);
            return 2131230727;
          case 3: 
          case 4: 
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230738;
            }
            AppMethodBeat.o(34311);
            return 2131230732;
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230738;
            }
            AppMethodBeat.o(34311);
            return 2131230732;
            if (((a)localObject).role == 2)
            {
              if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
              switch (((a)localObject).PeH)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230733;
                }
                AppMethodBeat.o(34311);
                return 2131230727;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230738;
                }
                AppMethodBeat.o(34311);
                return 2131230732;
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230738;
                }
                AppMethodBeat.o(34311);
                return 2131230732;
              }
            }
            else
            {
              paramb = i(paramb);
              if (paramb.PeH > 0)
              {
                switch (paramb.PeH)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                  if (paramBoolean)
                  {
                    AppMethodBeat.o(34311);
                    return 2131230733;
                  }
                  AppMethodBeat.o(34311);
                  return 2131230727;
                case 4: 
                  if (paramBoolean)
                  {
                    AppMethodBeat.o(34311);
                    return 2131230738;
                  }
                  AppMethodBeat.o(34311);
                  return 2131230732;
                }
              }
              else
              {
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230738;
                }
                AppMethodBeat.o(34311);
                return 2131230732;
              }
            }
            break;
          }
        }
        break;
      }
    }
    AppMethodBeat.o(34311);
    return 2131230732;
  }
  
  public static int d(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34312);
    if ((paramb == null) || (paramb.iyA <= 0))
    {
      Log.i("MicroMsg.C2CAppMsgUtil", "content == null || content.c2cNewAAType <= 0");
      AppMethodBeat.o(34312);
      return -8868722;
    }
    Object localObject = paramb.iyz;
    aae localaae = new aae();
    localaae.egS.egU = ((String)localObject);
    EventCenter.instance.publish(localaae);
    if ((localaae.egT.status == jYH) && (paramb.iyA == 5))
    {
      AppMethodBeat.o(34312);
      return -12479656;
    }
    if ((localaae.egT.status == jYG) || (localaae.egT.status == jYF) || (localaae.egT.status == jYH))
    {
      AppMethodBeat.o(34312);
      return -8868722;
    }
    localObject = h(paramb);
    switch (paramb.iyA)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34312);
      return -8868722;
      if ((((a)localObject).role == 1) || (paramBoolean)) {
        if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
      }
      switch (((a)localObject).PeH)
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
          if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
          switch (((a)localObject).PeH)
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
            if ((((a)localObject).PeH <= 0) || (((a)localObject).PeI < 0) || (((a)localObject).PeJ < 0)) {}
          }
          switch (((a)localObject).PeH)
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
              if ((((a)localObject).PeH > 0) && (((a)localObject).PeK >= 0L)) {}
              switch (((a)localObject).PeH)
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
              if (paramb.PeH <= 0) {
                break label675;
              }
              switch (paramb.PeH)
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
    String str = z.aTY();
    if ((paramb.iyA == 2) || (paramb.iyA == 3) || (paramb.iyA == 5))
    {
      Object localObject;
      if (!Util.isNullOrNil(paramb.iyE))
      {
        localObject = paramb.iyE.iterator();
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
      if (!Util.isNullOrNil(paramb.iyG))
      {
        paramb = paramb.iyG.iterator();
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
    AppMethodBeat.i(232838);
    if (((paramb.iyA == 2) || (paramb.iyA == 3) || (paramb.iyA == 5)) && (!Util.isNullOrNil(paramb.iyE)))
    {
      paramb = paramb.iyE.iterator();
      while (paramb.hasNext())
      {
        String[] arrayOfString = ((String)paramb.next()).split(",");
        if (arrayOfString.length == 4)
        {
          paramb = new a(Util.getInt(arrayOfString[1], -1), Util.getInt(arrayOfString[2], -1), Util.getInt(arrayOfString[3], -1));
          AppMethodBeat.o(232838);
          return paramb;
        }
      }
    }
    paramb = new a();
    AppMethodBeat.o(232838);
    return paramb;
  }
  
  public static final class a
  {
    public int PeH;
    public int PeI = -1;
    public int PeJ = -1;
    public long PeK = -1L;
    public int role;
    
    public a()
    {
      this.role = 3;
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.role = 1;
      this.PeH = paramInt1;
      this.PeI = paramInt2;
      this.PeJ = paramInt3;
    }
    
    public a(int paramInt, long paramLong)
    {
      this.role = 2;
      this.PeH = paramInt;
      this.PeK = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */