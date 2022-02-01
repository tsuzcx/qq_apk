package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static int ieA = 4;
  private static int iex = 1;
  private static int iey = 2;
  private static int iez = 3;
  
  public static int E(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2131231395;
        return 2131231389;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2131231389;
      if (paramInt1 != 3) {
        break label54;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2131231389;
    if (paramBoolean) {
      return 2131231390;
    }
    return 2131231384;
    label54:
    if (paramBoolean) {
      return 2131231390;
    }
    return 2131231384;
  }
  
  public static int F(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {}
    do
    {
      do
      {
        return 2131233101;
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
  
  public static int G(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2131233143;
        return 2131233022;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2131233022;
      if (paramInt1 != 3) {
        break label54;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2131233022;
    if (paramBoolean) {
      return 2131233142;
    }
    return 2131233021;
    label54:
    if (paramBoolean) {
      return 2131233142;
    }
    return 2131233021;
  }
  
  public static int a(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34308);
    a locala = g(paramb);
    switch (paramb.gIX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34308);
      return 2131689842;
      if ((paramBoolean) || (locala.role == 1))
      {
        if ((locala.Glg <= 0) || (locala.Glh < 0) || (locala.Gli < 0)) {}
      }
      else {
        switch (locala.Glg)
        {
        default: 
          break;
        case 1: 
        case 2: 
          AppMethodBeat.o(34308);
          return 2131689844;
        case 3: 
          AppMethodBeat.o(34308);
          return 2131689842;
        case 4: 
          AppMethodBeat.o(34308);
          return 2131689843;
          if (locala.role != 2) {
            break label223;
          }
          if ((locala.Glg > 0) && (locala.Glj >= 0L)) {
            switch (locala.Glg)
            {
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(34308);
    return 2131689844;
    AppMethodBeat.o(34308);
    return 2131689842;
    AppMethodBeat.o(34308);
    return 2131689843;
    label223:
    AppMethodBeat.o(34308);
    return 2131689842;
  }
  
  public static String b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34310);
    Object localObject = aj.getContext();
    ad.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2) });
    if (paramInt2 == 5)
    {
      localObject = ((Context)localObject).getString(2131760834);
      AppMethodBeat.o(34310);
      return localObject;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 4)
      {
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131760835);
          AppMethodBeat.o(34310);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131760833);
        AppMethodBeat.o(34310);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131760835);
          AppMethodBeat.o(34310);
          return localObject;
        }
        AppMethodBeat.o(34310);
        return "";
      }
    }
    else if (paramInt1 == 0)
    {
      if (paramInt2 == 4)
      {
        if (paramBoolean1)
        {
          localObject = ((Context)localObject).getString(2131760833);
          AppMethodBeat.o(34310);
          return localObject;
        }
        if (paramBoolean2)
        {
          if (paramInt3 == 2)
          {
            localObject = ((Context)localObject).getString(2131760835);
            AppMethodBeat.o(34310);
            return localObject;
          }
          localObject = ((Context)localObject).getString(2131760833);
          AppMethodBeat.o(34310);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131760835);
        AppMethodBeat.o(34310);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramBoolean1)
        {
          AppMethodBeat.o(34310);
          return "";
        }
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131760835);
          AppMethodBeat.o(34310);
          return localObject;
        }
        AppMethodBeat.o(34310);
        return "";
      }
    }
    else
    {
      if (paramInt2 == 4)
      {
        if ((!paramBoolean2) || ((paramBoolean1) && (paramInt3 == 2)))
        {
          localObject = ((Context)localObject).getString(2131760835);
          AppMethodBeat.o(34310);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131760833);
        AppMethodBeat.o(34310);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          if (paramBoolean1)
          {
            AppMethodBeat.o(34310);
            return "";
          }
          localObject = ((Context)localObject).getString(2131760835);
          AppMethodBeat.o(34310);
          return localObject;
        }
        AppMethodBeat.o(34310);
        return "";
      }
    }
    AppMethodBeat.o(34310);
    return "";
  }
  
  public static String b(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34309);
    for (;;)
    {
      int i1;
      int i7;
      long l;
      int i3;
      int i2;
      int n;
      int i;
      int j;
      int k;
      int m;
      try
      {
        str1 = u.aqG();
        if (paramb.gIX <= 0)
        {
          if (paramBoolean)
          {
            str1 = paramb.gIJ;
            AppMethodBeat.o(34309);
            return str1;
          }
          str1 = paramb.gIK;
          AppMethodBeat.o(34309);
          return str1;
        }
        i1 = 0;
        int i8 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        i7 = 0;
        l = -1L;
        Object localObject = paramb.gIW;
        xo localxo = new xo();
        localxo.dDH.dDJ = ((String)localObject);
        a.ESL.l(localxo);
        if (paramb.gIX != 2)
        {
          i3 = i6;
          i2 = i5;
          n = i4;
          if (paramb.gIX != 3) {
            break label905;
          }
        }
        i = i6;
        j = i5;
        k = i4;
        m = i8;
        if (!bt.gL(paramb.gJb))
        {
          localObject = paramb.gJb.iterator();
          i = i6;
          j = i5;
          k = i4;
          m = i8;
          if (((Iterator)localObject).hasNext())
          {
            arrayOfString = ((String)((Iterator)localObject).next()).split(",");
            if ((arrayOfString.length != 4) || (!arrayOfString[0].equals(str1))) {
              continue;
            }
            k = bt.getInt(arrayOfString[1], -1);
            j = bt.getInt(arrayOfString[2], -1);
            i = bt.getInt(arrayOfString[3], -1);
            m = 1;
          }
        }
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (bt.gL(paramb.gJd)) {
          break label905;
        }
        localObject = paramb.gJd.iterator();
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (!((Iterator)localObject).hasNext()) {
          break label905;
        }
        String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
        if ((arrayOfString.length != 3) || (!arrayOfString[0].equals(str1))) {
          continue;
        }
        l = bt.getLong(arrayOfString[1], -1L);
        n = bt.getInt(arrayOfString[2], -1);
        i1 = 1;
        i2 = j;
        i3 = i;
        j = i1;
        i = n;
        if (localxo.dDI.status == iez)
        {
          str1 = aj.getContext().getString(2131755055);
          AppMethodBeat.o(34309);
          return str1;
        }
        if (localxo.dDI.status == iey)
        {
          str1 = aj.getContext().getString(2131755047);
          AppMethodBeat.o(34309);
          return str1;
        }
        if (localxo.dDI.status == ieA)
        {
          str1 = aj.getContext().getString(2131755053);
          AppMethodBeat.o(34309);
          return str1;
        }
        n = paramb.gIX;
        switch (n)
        {
        }
      }
      catch (Exception localException)
      {
        String str1;
        ad.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[] { localException.getMessage() });
        continue;
        str2 = paramb.gIK;
        AppMethodBeat.o(34309);
        return str2;
      }
      if (paramBoolean)
      {
        paramb = paramb.gIJ;
        AppMethodBeat.o(34309);
        return paramb;
        if (paramBoolean)
        {
          str1 = paramb.gIJ;
          AppMethodBeat.o(34309);
          return str1;
        }
        String str2;
        if ((!str2.equals(paramb.gJg)) && (!paramBoolean)) {
          if (m != 0)
          {
            break label921;
            str2 = aj.getContext().getString(2131755056);
            AppMethodBeat.o(34309);
            return str2;
            str2 = aj.getContext().getString(2131755054, new Object[] { Integer.valueOf(i2 - i3) });
            AppMethodBeat.o(34309);
            return str2;
            str2 = aj.getContext().getString(2131755052);
            AppMethodBeat.o(34309);
            return str2;
            str2 = aj.getContext().getString(2131755055);
            AppMethodBeat.o(34309);
            return str2;
          }
          else
          {
            if (j != 0)
            {
              if ((i <= 0) || (l < 0L)) {
                continue;
              }
              switch (i)
              {
              default: 
                break;
              case 1: 
                str2 = aj.getContext().getString(2131755049, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(34309);
                return str2;
              case 2: 
                str2 = aj.getContext().getString(2131755048, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(34309);
                return str2;
              case 3: 
                str2 = aj.getContext().getString(2131755051, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(34309);
                return str2;
              case 4: 
                str2 = aj.getContext().getString(2131755050);
                AppMethodBeat.o(34309);
                return str2;
              }
            }
            str2 = aj.getContext().getString(2131755050);
            AppMethodBeat.o(34309);
            return str2;
          }
        }
      }
      else
      {
        paramb = paramb.gIK;
        AppMethodBeat.o(34309);
        return paramb;
        label905:
        i = -1;
        j = i7;
        k = n;
        m = i1;
        continue;
      }
      label921:
      if ((k > 0) && (i2 >= 0) && (i3 >= 0)) {
        switch (k)
        {
        }
      }
    }
  }
  
  public static int c(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34311);
    if (paramb == null)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(34311);
        return 2131230732;
      }
      AppMethodBeat.o(34311);
      return 2131230726;
    }
    Object localObject = paramb.gIW;
    xo localxo = new xo();
    localxo.dDH.dDJ = ((String)localObject);
    a.ESL.l(localxo);
    if ((localxo.dDI.status == iez) || (localxo.dDI.status == iey) || (localxo.dDI.status == ieA))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(34311);
        return 2131230737;
      }
      AppMethodBeat.o(34311);
      return 2131230731;
    }
    localObject = g(paramb);
    switch (paramb.gIX)
    {
    }
    while (paramBoolean)
    {
      AppMethodBeat.o(34311);
      return 2131230732;
      if ((paramBoolean) || (((a)localObject).role == 1)) {
        if ((((a)localObject).Glg <= 0) || (((a)localObject).Glh < 0) || (((a)localObject).Gli < 0)) {
          break;
        }
      } else {
        switch (((a)localObject).Glg)
        {
        default: 
          break;
        case 1: 
        case 2: 
          if (paramBoolean)
          {
            AppMethodBeat.o(34311);
            return 2131230732;
          }
          AppMethodBeat.o(34311);
          return 2131230726;
        case 3: 
        case 4: 
          if (paramBoolean)
          {
            AppMethodBeat.o(34311);
            return 2131230737;
          }
          AppMethodBeat.o(34311);
          return 2131230731;
          if (((a)localObject).role == 2)
          {
            if ((((a)localObject).Glg > 0) && (((a)localObject).Glj >= 0L)) {
              switch (((a)localObject).Glg)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230732;
                }
                AppMethodBeat.o(34311);
                return 2131230726;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(34311);
                  return 2131230737;
                }
                AppMethodBeat.o(34311);
                return 2131230731;
              }
            }
          }
          else
          {
            if (paramBoolean)
            {
              AppMethodBeat.o(34311);
              return 2131230732;
            }
            AppMethodBeat.o(34311);
            return 2131230726;
          }
          break;
        }
      }
    }
    AppMethodBeat.o(34311);
    return 2131230726;
  }
  
  public static int d(k.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(34312);
    if (paramb == null)
    {
      AppMethodBeat.o(34312);
      return -12479656;
    }
    Object localObject = paramb.gIW;
    xo localxo = new xo();
    localxo.dDH.dDJ = ((String)localObject);
    a.ESL.l(localxo);
    if ((localxo.dDI.status == iez) || (localxo.dDI.status == iey) || (localxo.dDI.status == ieA))
    {
      AppMethodBeat.o(34312);
      return -8868722;
    }
    localObject = g(paramb);
    switch (paramb.gIX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34312);
      return -12479656;
      if ((paramBoolean) || (((a)localObject).role == 1))
      {
        if ((((a)localObject).Glg <= 0) || (((a)localObject).Glh < 0) || (((a)localObject).Gli < 0)) {}
      }
      else {
        switch (((a)localObject).Glg)
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
          if (((a)localObject).role != 2) {
            break label307;
          }
          if ((((a)localObject).Glg > 0) && (((a)localObject).Glj >= 0L)) {
            switch (((a)localObject).Glg)
            {
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(34312);
    return -12479656;
    AppMethodBeat.o(34312);
    return -8868722;
    label307:
    AppMethodBeat.o(34312);
    return -12479656;
  }
  
  public static a g(k.b paramb)
  {
    AppMethodBeat.i(34307);
    String str = u.aqG();
    if ((paramb.gIX == 2) || (paramb.gIX == 3))
    {
      Object localObject;
      if (!bt.gL(paramb.gJb))
      {
        localObject = paramb.gJb.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          if ((arrayOfString.length == 4) && (arrayOfString[0].equals(str)))
          {
            paramb = new a(bt.getInt(arrayOfString[1], -1), bt.getInt(arrayOfString[2], -1), bt.getInt(arrayOfString[3], -1));
            AppMethodBeat.o(34307);
            return paramb;
          }
        }
      }
      if (!bt.gL(paramb.gJd))
      {
        paramb = paramb.gJd.iterator();
        while (paramb.hasNext())
        {
          localObject = ((String)paramb.next()).split(",");
          if ((localObject.length == 3) && (localObject[0].equals(str)))
          {
            long l = bt.getLong(localObject[1], -1L);
            paramb = new a(bt.getInt(localObject[2], -1), l);
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
  
  public static final class a
  {
    public int Glg;
    public int Glh = -1;
    public int Gli = -1;
    public long Glj = -1L;
    public int role;
    
    public a()
    {
      this.role = 3;
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.role = 1;
      this.Glg = paramInt1;
      this.Glh = paramInt2;
      this.Gli = paramInt3;
    }
    
    public a(int paramInt, long paramLong)
    {
      this.role = 2;
      this.Glg = paramInt;
      this.Glj = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */