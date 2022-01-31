package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ts;
import com.tencent.mm.h.a.ts.b;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static int vhZ = 1;
  private static int vib = 2;
  private static int vic = 3;
  
  public static int a(com.tencent.mm.ae.g.a parama, boolean paramBoolean)
  {
    g.a locala = e(parama);
    switch (parama.dSr)
    {
    }
    for (;;)
    {
      return R.k.c2c_aa_icon_check;
      if ((paramBoolean) || (locala.srB == 1))
      {
        if ((locala.vid <= 0) || (locala.vie < 0) || (locala.vif < 0)) {}
      }
      else {
        switch (locala.vid)
        {
        default: 
          break;
        case 1: 
        case 2: 
          return R.k.c2c_aa_icon_default;
        case 3: 
          return R.k.c2c_aa_icon_check;
        case 4: 
          return R.k.c2c_aa_icon_close;
          if (locala.srB != 2) {
            break label191;
          }
          if ((locala.vid > 0) && (locala.vig >= 0L)) {
            switch (locala.vid)
            {
            }
          }
          break;
        }
      }
    }
    return R.k.c2c_aa_icon_default;
    return R.k.c2c_aa_icon_check;
    return R.k.c2c_aa_icon_close;
    label191:
    return R.k.c2c_aa_icon_check;
  }
  
  public static String a(int paramInt1, int paramInt2, boolean paramBoolean, com.tencent.mm.ae.g.a parama)
  {
    Context localContext = ae.getContext();
    if (paramInt1 == 5) {
      return localContext.getString(R.l.lucky_money_chatting_expired);
    }
    if (paramInt1 == 4)
    {
      if (paramBoolean) {
        return localContext.getString(R.l.lucky_money_chatting_all_received);
      }
      return localContext.getString(R.l.lucky_money_chatting_received_receiver);
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        if (paramBoolean) {
          return parama.dSd;
        }
        return localContext.getString(R.l.lucky_money_chatting_received_receiver);
      }
      if (paramBoolean) {
        return parama.dSd;
      }
      return parama.dSe;
    }
    if (paramBoolean) {
      return parama.dSd;
    }
    return parama.dSe;
  }
  
  public static String b(com.tencent.mm.ae.g.a parama, boolean paramBoolean)
  {
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
        str = q.Gj();
        if (parama.dSr <= 0)
        {
          if (paramBoolean) {
            return parama.dSd;
          }
          return parama.dSe;
        }
        i1 = 0;
        int i8 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        i7 = 0;
        l = -1L;
        Object localObject = parama.dSq;
        ts localts = new ts();
        localts.cdW.cdY = ((String)localObject);
        a.udP.m(localts);
        if (parama.dSr != 2)
        {
          i3 = i6;
          i2 = i5;
          n = i4;
          if (parama.dSr != 3) {
            break label685;
          }
        }
        i = i6;
        j = i5;
        k = i4;
        m = i8;
        if (!bk.dk(parama.dSv))
        {
          localObject = parama.dSv.iterator();
          i = i6;
          j = i5;
          k = i4;
          m = i8;
          if (((Iterator)localObject).hasNext())
          {
            arrayOfString = ((String)((Iterator)localObject).next()).split(",");
            if ((arrayOfString.length != 4) || (!arrayOfString[0].equals(str))) {
              continue;
            }
            k = bk.getInt(arrayOfString[1], -1);
            j = bk.getInt(arrayOfString[2], -1);
            i = bk.getInt(arrayOfString[3], -1);
            m = 1;
          }
        }
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (bk.dk(parama.dSx)) {
          break label685;
        }
        localObject = parama.dSx.iterator();
        i3 = i;
        i2 = j;
        n = k;
        i1 = m;
        if (!((Iterator)localObject).hasNext()) {
          break label685;
        }
        String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
        if ((arrayOfString.length != 3) || (!arrayOfString[0].equals(str))) {
          continue;
        }
        l = bk.getLong(arrayOfString[1], -1L);
        n = bk.getInt(arrayOfString[2], -1);
        i1 = 1;
        i2 = j;
        i3 = i;
        j = i1;
        i = n;
        if (localts.cdX.status == vic) {
          return ae.getContext().getString(R.l.aa_msg_receiver_stop_receive);
        }
        if (localts.cdX.status == vib) {
          return ae.getContext().getString(R.l.aa_msg_expired);
        }
        n = parama.dSr;
        switch (n)
        {
        }
      }
      catch (Exception localException)
      {
        String str;
        y.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[] { localException.getMessage() });
        continue;
      }
      if (paramBoolean)
      {
        return parama.dSd;
        if (paramBoolean) {
          return parama.dSd;
        }
        return parama.dSe;
        if ((!str.equals(parama.dSA)) && (!paramBoolean))
        {
          if (m == 0) {
            break label751;
          }
          break label701;
          return ae.getContext().getString(R.l.aa_msg_receiver_wait_receive);
          return ae.getContext().getString(R.l.aa_msg_receiver_part_receive, new Object[] { Integer.valueOf(i2 - i3) });
          return ae.getContext().getString(R.l.aa_msg_receiver_all_receive);
          return ae.getContext().getString(R.l.aa_msg_receiver_stop_receive);
          return ae.getContext().getString(R.l.aa_msg_payer_need_pay, new Object[] { Float.valueOf((float)l / 100.0F) });
          return ae.getContext().getString(R.l.aa_msg_payer_has_pay, new Object[] { Float.valueOf((float)l / 100.0F) });
          return ae.getContext().getString(R.l.aa_msg_payer_refund, new Object[] { Float.valueOf((float)l / 100.0F) });
          return ae.getContext().getString(R.l.aa_msg_payer_not_need_pay);
          str = ae.getContext().getString(R.l.aa_msg_payer_not_need_pay);
          return str;
        }
      }
      else
      {
        return parama.dSe;
        label685:
        i = -1;
        j = i7;
        k = n;
        m = i1;
        continue;
      }
      label701:
      if ((k > 0) && (i2 >= 0) && (i3 >= 0))
      {
        switch (k)
        {
        }
        continue;
        label751:
        if (j != 0) {
          if ((i > 0) && (l >= 0L)) {
            switch (i)
            {
            }
          }
        }
      }
    }
  }
  
  public static int c(com.tencent.mm.ae.g.a parama, boolean paramBoolean)
  {
    if (parama == null)
    {
      if (paramBoolean) {
        return R.g.aa_chatto_bg;
      }
      return R.g.aa_chatfrom_bg;
    }
    Object localObject = parama.dSq;
    ts localts = new ts();
    localts.cdW.cdY = ((String)localObject);
    a.udP.m(localts);
    if ((localts.cdX.status == vic) || (localts.cdX.status == vib))
    {
      if (paramBoolean) {
        return R.g.aa_chatto_done_bg;
      }
      return R.g.aa_chatfrom_done_bg;
    }
    localObject = e(parama);
    switch (parama.dSr)
    {
    }
    while (paramBoolean)
    {
      return R.g.aa_chatto_bg;
      if ((paramBoolean) || (((g.a)localObject).srB == 1)) {
        if ((((g.a)localObject).vid <= 0) || (((g.a)localObject).vie < 0) || (((g.a)localObject).vif < 0)) {
          break;
        }
      } else {
        switch (((g.a)localObject).vid)
        {
        default: 
          break;
        case 1: 
        case 2: 
          if (paramBoolean) {
            return R.g.aa_chatto_bg;
          }
          return R.g.aa_chatfrom_bg;
        case 3: 
        case 4: 
          if (paramBoolean) {
            return R.g.aa_chatto_done_bg;
          }
          return R.g.aa_chatfrom_done_bg;
          if (((g.a)localObject).srB == 2)
          {
            if ((((g.a)localObject).vid > 0) && (((g.a)localObject).vig >= 0L)) {
              switch (((g.a)localObject).vid)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean) {
                  return R.g.aa_chatto_bg;
                }
                return R.g.aa_chatfrom_bg;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean) {
                  return R.g.aa_chatto_done_bg;
                }
                return R.g.aa_chatfrom_done_bg;
              }
            }
          }
          else
          {
            if (paramBoolean) {
              return R.g.aa_chatto_bg;
            }
            return R.g.aa_chatfrom_bg;
          }
          break;
        }
      }
    }
    return R.g.aa_chatfrom_bg;
  }
  
  public static int d(com.tencent.mm.ae.g.a parama, boolean paramBoolean)
  {
    if (parama == null) {}
    Object localObject;
    do
    {
      do
      {
        return -12479656;
        localObject = parama.dSq;
        ts localts = new ts();
        localts.cdW.cdY = ((String)localObject);
        a.udP.m(localts);
        if ((localts.cdX.status == vic) || (localts.cdX.status == vib)) {
          return -8868722;
        }
        localObject = e(parama);
        switch (parama.dSr)
        {
        default: 
          return -12479656;
        }
        if ((!paramBoolean) && (((g.a)localObject).srB != 1)) {
          break;
        }
      } while ((((g.a)localObject).vid <= 0) || (((g.a)localObject).vie < 0) || (((g.a)localObject).vif < 0));
      switch (((g.a)localObject).vid)
      {
      case 1: 
      case 2: 
      default: 
        return -12479656;
      }
      return -8868722;
    } while ((((g.a)localObject).srB != 2) || (((g.a)localObject).vid <= 0) || (((g.a)localObject).vig < 0L));
    switch (((g.a)localObject).vid)
    {
    case 1: 
    default: 
      return -12479656;
    }
    return -8868722;
  }
  
  public static g.a e(com.tencent.mm.ae.g.a parama)
  {
    String str = q.Gj();
    if ((parama.dSr == 2) || (parama.dSr == 3))
    {
      Object localObject;
      if (!bk.dk(parama.dSv))
      {
        localObject = parama.dSv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          if ((arrayOfString.length == 4) && (arrayOfString[0].equals(str))) {
            return new g.a(bk.getInt(arrayOfString[1], -1), bk.getInt(arrayOfString[2], -1), bk.getInt(arrayOfString[3], -1));
          }
        }
      }
      if (!bk.dk(parama.dSx))
      {
        parama = parama.dSx.iterator();
        while (parama.hasNext())
        {
          localObject = ((String)parama.next()).split(",");
          if ((localObject.length == 3) && (localObject[0].equals(str)))
          {
            long l = bk.getLong(localObject[1], -1L);
            return new g.a(bk.getInt(localObject[2], -1), l);
          }
        }
      }
    }
    return new g.a();
  }
  
  public static int s(int paramInt1, int paramInt2, boolean paramBoolean)
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
          return R.g.c2c_chatto_bg;
        }
        return R.g.c2c_chatfrom_done_bg;
      }
      if (paramBoolean) {
        return R.g.c2c_chatto_bg;
      }
      return R.g.c2c_chatfrom_bg;
    }
    if (paramBoolean) {
      return R.g.c2c_chatto_bg;
    }
    return R.g.c2c_chatfrom_bg;
  }
  
  public static int t(int paramInt1, int paramInt2, boolean paramBoolean)
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
        if (paramInt2 != 2) {
          break;
        }
        i = j;
      } while (paramBoolean);
      return R.g.lucky_money_opened_icon;
      i = j;
    } while (paramBoolean);
    return R.g.lucky_money_opened_icon;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */