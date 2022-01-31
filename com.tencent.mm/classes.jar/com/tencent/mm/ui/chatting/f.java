package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vo.b;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static int zwT = 1;
  private static int zwU = 2;
  private static int zwV = 3;
  
  public static int a(j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(30458);
    f.a locala = d(paramb);
    switch (paramb.fiq)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30458);
      return 2131231051;
      if ((paramBoolean) || (locala.wkh == 1))
      {
        if ((locala.zwW <= 0) || (locala.zwX < 0) || (locala.zwY < 0)) {}
      }
      else {
        switch (locala.zwW)
        {
        default: 
          break;
        case 1: 
        case 2: 
          AppMethodBeat.o(30458);
          return 2131231053;
        case 3: 
          AppMethodBeat.o(30458);
          return 2131231051;
        case 4: 
          AppMethodBeat.o(30458);
          return 2131231052;
          if (locala.wkh != 2) {
            break label230;
          }
          if ((locala.zwW > 0) && (locala.zwZ >= 0L)) {
            switch (locala.zwW)
            {
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(30458);
    return 2131231053;
    AppMethodBeat.o(30458);
    return 2131231051;
    AppMethodBeat.o(30458);
    return 2131231052;
    label230:
    AppMethodBeat.o(30458);
    return 2131231051;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30460);
    Object localObject = ah.getContext();
    ab.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean2) });
    if (paramInt2 == 5)
    {
      localObject = ((Context)localObject).getString(2131301200);
      AppMethodBeat.o(30460);
      return localObject;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 4)
      {
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131301201);
          AppMethodBeat.o(30460);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131301199);
        AppMethodBeat.o(30460);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131301201);
          AppMethodBeat.o(30460);
          return localObject;
        }
        AppMethodBeat.o(30460);
        return "";
      }
    }
    else if (paramInt1 == 0)
    {
      if (paramInt2 == 4)
      {
        if (paramBoolean1)
        {
          localObject = ((Context)localObject).getString(2131301199);
          AppMethodBeat.o(30460);
          return localObject;
        }
        if (paramBoolean2)
        {
          if (paramInt3 == 2)
          {
            localObject = ((Context)localObject).getString(2131301201);
            AppMethodBeat.o(30460);
            return localObject;
          }
          localObject = ((Context)localObject).getString(2131301199);
          AppMethodBeat.o(30460);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131301201);
        AppMethodBeat.o(30460);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramBoolean1)
        {
          AppMethodBeat.o(30460);
          return "";
        }
        if (paramInt3 == 2)
        {
          localObject = ((Context)localObject).getString(2131301201);
          AppMethodBeat.o(30460);
          return localObject;
        }
        AppMethodBeat.o(30460);
        return "";
      }
    }
    else
    {
      if (paramInt2 == 4)
      {
        if ((!paramBoolean2) || ((paramBoolean1) && (paramInt3 == 2)))
        {
          localObject = ((Context)localObject).getString(2131301201);
          AppMethodBeat.o(30460);
          return localObject;
        }
        localObject = ((Context)localObject).getString(2131301199);
        AppMethodBeat.o(30460);
        return localObject;
      }
      if (paramInt2 == 3)
      {
        if (paramInt3 == 2)
        {
          if (paramBoolean1)
          {
            AppMethodBeat.o(30460);
            return "";
          }
          localObject = ((Context)localObject).getString(2131301201);
          AppMethodBeat.o(30460);
          return localObject;
        }
        AppMethodBeat.o(30460);
        return "";
      }
    }
    AppMethodBeat.o(30460);
    return "";
  }
  
  public static String b(j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(30459);
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
        str1 = r.Zn();
        if (paramb.fiq <= 0)
        {
          if (paramBoolean)
          {
            str1 = paramb.fic;
            AppMethodBeat.o(30459);
            return str1;
          }
          str1 = paramb.fid;
          AppMethodBeat.o(30459);
          return str1;
        }
        i1 = 0;
        int i8 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        i7 = 0;
        l = -1L;
        Object localObject = paramb.fip;
        vo localvo = new vo();
        localvo.cMJ.cML = ((String)localObject);
        a.ymk.l(localvo);
        if (paramb.fiq != 2)
        {
          i3 = i6;
          i2 = i5;
          n = i4;
          if (paramb.fiq != 3) {
            break label891;
          }
        }
        i = i6;
        j = i5;
        k = i4;
        m = i8;
        if (!bo.es(paramb.fiu))
        {
          localObject = paramb.fiu.iterator();
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
            k = bo.getInt(arrayOfString[1], -1);
            j = bo.getInt(arrayOfString[2], -1);
            i = bo.getInt(arrayOfString[3], -1);
            m = 1;
          }
        }
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (bo.es(paramb.fiw)) {
          break label891;
        }
        localObject = paramb.fiw.iterator();
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (!((Iterator)localObject).hasNext()) {
          break label891;
        }
        String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
        if ((arrayOfString.length != 3) || (!arrayOfString[0].equals(str1))) {
          continue;
        }
        l = bo.getLong(arrayOfString[1], -1L);
        n = bo.getInt(arrayOfString[2], -1);
        i1 = 1;
        i2 = j;
        i3 = i;
        j = i1;
        i = n;
        if (localvo.cMK.status == zwV)
        {
          str1 = ah.getContext().getString(2131296373);
          AppMethodBeat.o(30459);
          return str1;
        }
        if (localvo.cMK.status == zwU)
        {
          str1 = ah.getContext().getString(2131296366);
          AppMethodBeat.o(30459);
          return str1;
        }
        n = paramb.fiq;
        switch (n)
        {
        }
      }
      catch (Exception localException)
      {
        String str1;
        ab.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[] { localException.getMessage() });
        continue;
        str2 = paramb.fid;
        AppMethodBeat.o(30459);
        return str2;
      }
      if (paramBoolean)
      {
        paramb = paramb.fic;
        AppMethodBeat.o(30459);
        return paramb;
        if (paramBoolean)
        {
          str1 = paramb.fic;
          AppMethodBeat.o(30459);
          return str1;
        }
        String str2;
        if ((!str2.equals(paramb.fiz)) && (!paramBoolean)) {
          if (m != 0)
          {
            break label907;
            str2 = ah.getContext().getString(2131296374);
            AppMethodBeat.o(30459);
            return str2;
            str2 = ah.getContext().getString(2131296372, new Object[] { Integer.valueOf(i2 - i3) });
            AppMethodBeat.o(30459);
            return str2;
            str2 = ah.getContext().getString(2131296371);
            AppMethodBeat.o(30459);
            return str2;
            str2 = ah.getContext().getString(2131296373);
            AppMethodBeat.o(30459);
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
                str2 = ah.getContext().getString(2131296368, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(30459);
                return str2;
              case 2: 
                str2 = ah.getContext().getString(2131296367, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(30459);
                return str2;
              case 3: 
                str2 = ah.getContext().getString(2131296370, new Object[] { Float.valueOf((float)l / 100.0F) });
                AppMethodBeat.o(30459);
                return str2;
              case 4: 
                str2 = ah.getContext().getString(2131296369);
                AppMethodBeat.o(30459);
                return str2;
              }
            }
            str2 = ah.getContext().getString(2131296369);
            AppMethodBeat.o(30459);
            return str2;
          }
        }
      }
      else
      {
        paramb = paramb.fid;
        AppMethodBeat.o(30459);
        return paramb;
        label891:
        i = -1;
        j = i7;
        k = n;
        m = i1;
        continue;
      }
      label907:
      if ((k > 0) && (i2 >= 0) && (i3 >= 0)) {
        switch (k)
        {
        }
      }
    }
  }
  
  public static int c(j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(30461);
    if (paramb == null)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(30461);
        return 2130837510;
      }
      AppMethodBeat.o(30461);
      return 2130837504;
    }
    Object localObject = paramb.fip;
    vo localvo = new vo();
    localvo.cMJ.cML = ((String)localObject);
    a.ymk.l(localvo);
    if ((localvo.cMK.status == zwV) || (localvo.cMK.status == zwU))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(30461);
        return 2130837515;
      }
      AppMethodBeat.o(30461);
      return 2130837509;
    }
    localObject = d(paramb);
    switch (paramb.fiq)
    {
    }
    while (paramBoolean)
    {
      AppMethodBeat.o(30461);
      return 2130837510;
      if ((paramBoolean) || (((f.a)localObject).wkh == 1)) {
        if ((((f.a)localObject).zwW <= 0) || (((f.a)localObject).zwX < 0) || (((f.a)localObject).zwY < 0)) {
          break;
        }
      } else {
        switch (((f.a)localObject).zwW)
        {
        default: 
          break;
        case 1: 
        case 2: 
          if (paramBoolean)
          {
            AppMethodBeat.o(30461);
            return 2130837510;
          }
          AppMethodBeat.o(30461);
          return 2130837504;
        case 3: 
        case 4: 
          if (paramBoolean)
          {
            AppMethodBeat.o(30461);
            return 2130837515;
          }
          AppMethodBeat.o(30461);
          return 2130837509;
          if (((f.a)localObject).wkh == 2)
          {
            if ((((f.a)localObject).zwW > 0) && (((f.a)localObject).zwZ >= 0L)) {
              switch (((f.a)localObject).zwW)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(30461);
                  return 2130837510;
                }
                AppMethodBeat.o(30461);
                return 2130837504;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean)
                {
                  AppMethodBeat.o(30461);
                  return 2130837515;
                }
                AppMethodBeat.o(30461);
                return 2130837509;
              }
            }
          }
          else
          {
            if (paramBoolean)
            {
              AppMethodBeat.o(30461);
              return 2130837510;
            }
            AppMethodBeat.o(30461);
            return 2130837504;
          }
          break;
        }
      }
    }
    AppMethodBeat.o(30461);
    return 2130837504;
  }
  
  public static int d(j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(30462);
    if (paramb == null)
    {
      AppMethodBeat.o(30462);
      return -12479656;
    }
    Object localObject = paramb.fip;
    vo localvo = new vo();
    localvo.cMJ.cML = ((String)localObject);
    a.ymk.l(localvo);
    if ((localvo.cMK.status == zwV) || (localvo.cMK.status == zwU))
    {
      AppMethodBeat.o(30462);
      return -8868722;
    }
    localObject = d(paramb);
    switch (paramb.fiq)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30462);
      return -12479656;
      if ((paramBoolean) || (((f.a)localObject).wkh == 1))
      {
        if ((((f.a)localObject).zwW <= 0) || (((f.a)localObject).zwX < 0) || (((f.a)localObject).zwY < 0)) {}
      }
      else {
        switch (((f.a)localObject).zwW)
        {
        default: 
          break;
        case 1: 
        case 2: 
          AppMethodBeat.o(30462);
          return -12479656;
        case 3: 
        case 4: 
          AppMethodBeat.o(30462);
          return -8868722;
          if (((f.a)localObject).wkh != 2) {
            break label293;
          }
          if ((((f.a)localObject).zwW > 0) && (((f.a)localObject).zwZ >= 0L)) {
            switch (((f.a)localObject).zwW)
            {
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(30462);
    return -12479656;
    AppMethodBeat.o(30462);
    return -8868722;
    label293:
    AppMethodBeat.o(30462);
    return -12479656;
  }
  
  public static f.a d(j.b paramb)
  {
    AppMethodBeat.i(30457);
    String str = r.Zn();
    if ((paramb.fiq == 2) || (paramb.fiq == 3))
    {
      Object localObject;
      if (!bo.es(paramb.fiu))
      {
        localObject = paramb.fiu.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          if ((arrayOfString.length == 4) && (arrayOfString[0].equals(str)))
          {
            paramb = new f.a(bo.getInt(arrayOfString[1], -1), bo.getInt(arrayOfString[2], -1), bo.getInt(arrayOfString[3], -1));
            AppMethodBeat.o(30457);
            return paramb;
          }
        }
      }
      if (!bo.es(paramb.fiw))
      {
        paramb = paramb.fiw.iterator();
        while (paramb.hasNext())
        {
          localObject = ((String)paramb.next()).split(",");
          if ((localObject.length == 3) && (localObject[0].equals(str)))
          {
            long l = bo.getLong(localObject[1], -1L);
            paramb = new f.a(bo.getInt(localObject[2], -1), l);
            AppMethodBeat.o(30457);
            return paramb;
          }
        }
      }
    }
    paramb = new f.a();
    AppMethodBeat.o(30457);
    return paramb;
  }
  
  public static int u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2130838070;
        return 2130838064;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2130838064;
      if (paramInt1 != 3) {
        break label54;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2130838064;
    if (paramBoolean) {
      return 2130838065;
    }
    return 2130838059;
    label54:
    if (paramBoolean) {
      return 2130838065;
    }
    return 2130838059;
  }
  
  public static int v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {}
    do
    {
      do
      {
        return 2130839488;
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
  
  public static int w(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 5) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return 2130839524;
        return 2130839409;
        if (paramInt1 != 4) {
          break;
        }
      } while (paramBoolean);
      return 2130839409;
      if (paramInt1 != 3) {
        break label55;
      }
      if (paramInt2 != 2) {
        break;
      }
    } while (paramBoolean);
    return 2130839409;
    if (paramBoolean) {
      return 2130839523;
    }
    return 2130839408;
    label55:
    if (paramBoolean) {
      return 2130839523;
    }
    return 2130839408;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f
 * JD-Core Version:    0.7.0.1
 */