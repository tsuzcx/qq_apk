package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;

public final class g
{
  public static String a(dcb paramdcb)
  {
    AppMethodBeat.i(127237);
    if (paramdcb == null)
    {
      AppMethodBeat.o(127237);
      return "null";
    }
    paramdcb = "TipsInfo{num=" + paramdcb.glx + ", title='" + paramdcb.title + '\'' + ", url='" + paramdcb.url + '\'' + '}';
    AppMethodBeat.o(127237);
    return paramdcb;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127227);
    if (parama == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsHelper", "clearCompatTag() iNewTipsView == null");
      AppMethodBeat.o(127227);
      return;
    }
    parama.a(k.uev, false);
    parama.a(k.uew, false);
    parama.a(k.uex, false);
    parama.a(k.uey, false);
    parama.a(k.uez, false);
    parama.a(k.ueA, false);
    AppMethodBeat.o(127227);
  }
  
  private static boolean a(a parama, Pair<k, dcb> paramPair)
  {
    AppMethodBeat.i(127225);
    if (parama == null)
    {
      AppMethodBeat.o(127225);
      return false;
    }
    Pair localPair = b(parama, paramPair, false);
    String str = parama.getPath();
    if (paramPair.first != null) {}
    for (parama = (Serializable)paramPair.first;; parama = "null")
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "showNewTips() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, parama, a((dcb)paramPair.second), Boolean.FALSE, localPair.first, localPair.second });
      AppMethodBeat.o(127225);
      return true;
    }
  }
  
  public static boolean a(a parama, final Pair<k, dcb> paramPair, final boolean paramBoolean)
  {
    AppMethodBeat.i(127224);
    if ((parama == null) || (paramPair == null))
    {
      AppMethodBeat.o(127224);
      return false;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127221);
        Pair localPair = g.b(this.uen, paramPair, paramBoolean);
        String str = this.uen.getPath();
        if (paramPair.first != null) {}
        for (Object localObject = (Serializable)paramPair.first;; localObject = "null")
        {
          ad.i("MicroMsg.NewTips.NewTipsHelper", "showNewTipsMainThread() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, localObject, g.a((dcb)paramPair.second), Boolean.valueOf(paramBoolean), localPair.first, localPair.second });
          AppMethodBeat.o(127221);
          return;
        }
      }
    });
    AppMethodBeat.o(127224);
    return true;
  }
  
  public static boolean a(a parama, k paramk, Pair<k, dcb> paramPair)
  {
    boolean bool2 = true;
    AppMethodBeat.i(127235);
    if (parama == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() curNewTip == null");
      AppMethodBeat.o(127235);
      return true;
    }
    if (paramPair == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() second == null");
      AppMethodBeat.o(127235);
      return true;
    }
    if (paramk != paramPair.first)
    {
      AppMethodBeat.o(127235);
      return false;
    }
    parama = f(parama);
    paramPair = (dcb)paramPair.second;
    if ((parama == null) && (paramPair == null))
    {
      AppMethodBeat.o(127235);
      return true;
    }
    if (((parama != null) && (paramPair == null)) || ((parama == null) && (paramPair != null)))
    {
      switch (2.uep[paramk.ordinal()])
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(127235);
        return bool1;
        bool1 = true;
        continue;
        bool1 = false;
      }
    }
    boolean bool1 = bool2;
    switch (2.uep[paramk.ordinal()])
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      AppMethodBeat.o(127235);
      return bool1;
      bool1 = bool2;
      if (!bt.kU(parama.title, paramPair.title))
      {
        bool1 = false;
        continue;
        bool1 = bool2;
        if (!bt.kU(parama.url, paramPair.url))
        {
          bool1 = false;
          continue;
          if (bt.kU(parama.title, paramPair.title))
          {
            bool1 = bool2;
            if (bt.kU(parama.url, paramPair.url)) {}
          }
          else
          {
            bool1 = false;
            continue;
            bool1 = bool2;
            if (!bt.iY(parama.glx, paramPair.glx)) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(a parama, k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(127223);
    if (parama.getRoot() == null)
    {
      AppMethodBeat.o(127223);
      return false;
    }
    try
    {
      b = ((Byte)parama.getRoot().getTag(2131302802)).byteValue();
      ad.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s origin state:%s", new Object[] { parama.getPath(), Long.toBinaryString(b) });
      switch (2.uep[paramk.ordinal()])
      {
      default: 
        parama.getRoot().setTag(2131302802, Byte.valueOf(b));
        ad.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s showType:%s result:%s", new Object[] { parama.getPath(), paramk.ueB, Long.toBinaryString(b) });
        AppMethodBeat.o(127223);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { localException.toString() });
        byte b = 0;
        continue;
        if (paramBoolean)
        {
          b = (byte)(b | 0x20);
        }
        else
        {
          b = (byte)(b & 0x1F);
          continue;
          if (paramBoolean)
          {
            b = (byte)(b | 0x10);
          }
          else
          {
            b = (byte)(b & 0x2F);
            continue;
            if (paramBoolean)
            {
              b = (byte)(b | 0x8);
            }
            else
            {
              b = (byte)(b & 0x37);
              continue;
              if (paramBoolean)
              {
                b = (byte)(b | 0x4);
              }
              else
              {
                b = (byte)(b & 0x3B);
                continue;
                if (paramBoolean)
                {
                  b = (byte)(b | 0x2);
                }
                else
                {
                  b = (byte)(b & 0x3D);
                  continue;
                  if (paramBoolean) {
                    b = (byte)(b | 0x1);
                  } else {
                    b = (byte)(b & 0x3E);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(e parame)
  {
    boolean bool2 = true;
    if (parame == null) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (parame.ueG);
    boolean bool1 = bool2;
    switch (parame.path)
    {
    }
    return false;
  }
  
  public static boolean a(e parame, k paramk)
  {
    if (parame == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (parame.ueG) {
            return true;
          }
          int i = parame.path;
          if (paramk == k.ueu) {
            return true;
          }
          switch (i)
          {
          case 23: 
          default: 
            return false;
          }
        } while ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA));
        return true;
      } while ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA));
      return true;
    } while (paramk != k.uev);
    for (;;)
    {
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.ueA)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex)) {
        break;
      }
      return true;
      if ((paramk != k.uev) && (paramk != k.uew) && (paramk != k.uex) && (paramk != k.uey) && (paramk != k.uez)) {
        if (paramk != k.ueA) {
          break;
        }
      }
    }
  }
  
  public static boolean a(boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(127228);
    if (d(parama))
    {
      if (paramBoolean)
      {
        g(parama);
        AppMethodBeat.o(127228);
        return false;
      }
      AppMethodBeat.o(127228);
      return true;
    }
    AppMethodBeat.o(127228);
    return false;
  }
  
  public static int aji(String paramString)
  {
    AppMethodBeat.i(127230);
    if (bt.kU(paramString, "me"))
    {
      AppMethodBeat.o(127230);
      return 1;
    }
    if (bt.kU(paramString, "discovery"))
    {
      AppMethodBeat.o(127230);
      return 2;
    }
    if (bt.kU(paramString, "plus"))
    {
      AppMethodBeat.o(127230);
      return 3;
    }
    if (bt.kU(paramString, "plus_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 4;
    }
    if (bt.kU(paramString, "pay_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 5;
    }
    if (bt.kU(paramString, "topstories"))
    {
      AppMethodBeat.o(127230);
      return 6;
    }
    if (bt.kU(paramString, "topstories_wow"))
    {
      AppMethodBeat.o(127230);
      return 7;
    }
    if (bt.kU(paramString, "topstories_top"))
    {
      AppMethodBeat.o(127230);
      return 8;
    }
    if (bt.kU(paramString, "search"))
    {
      AppMethodBeat.o(127230);
      return 9;
    }
    if (bt.kU(paramString, "dining_nearby"))
    {
      AppMethodBeat.o(127230);
      return 10;
    }
    if (bt.kU(paramString, "shopping"))
    {
      AppMethodBeat.o(127230);
      return 11;
    }
    if (bt.kU(paramString, "game"))
    {
      AppMethodBeat.o(127230);
      return 12;
    }
    if (bt.kU(paramString, "pay"))
    {
      AppMethodBeat.o(127230);
      return 13;
    }
    if (bt.kU(paramString, "card"))
    {
      AppMethodBeat.o(127230);
      return 14;
    }
    if (bt.kU(paramString, "wallet"))
    {
      AppMethodBeat.o(127230);
      return 15;
    }
    if (bt.kU(paramString, "grouppayreddot"))
    {
      AppMethodBeat.o(127230);
      return 16;
    }
    if (bt.kU(paramString, "facingreceivereddot"))
    {
      AppMethodBeat.o(127230);
      return 17;
    }
    if (bt.kU(paramString, "f2fhongbaoreddot"))
    {
      AppMethodBeat.o(127230);
      return 18;
    }
    if (bt.kU(paramString, "rewardcodereddot"))
    {
      AppMethodBeat.o(127230);
      return 19;
    }
    if (bt.kU(paramString, "transfertoreddot"))
    {
      AppMethodBeat.o(127230);
      return 20;
    }
    if (bt.kU(paramString, "transtobankreddot"))
    {
      AppMethodBeat.o(127230);
      return 21;
    }
    if (bt.kU(paramString, "mobiletransferreddot"))
    {
      AppMethodBeat.o(127230);
      return 22;
    }
    if (bt.kU(paramString, "finder"))
    {
      AppMethodBeat.o(127230);
      return 24;
    }
    if (bt.kU(paramString, "chatroom"))
    {
      AppMethodBeat.o(127230);
      return 25;
    }
    if (bt.kU(paramString, "chatroommgr"))
    {
      AppMethodBeat.o(127230);
      return 26;
    }
    if (bt.kU(paramString, "useww"))
    {
      AppMethodBeat.o(127230);
      return 27;
    }
    if (bt.kU(paramString, "finder_tl_hot_tab"))
    {
      AppMethodBeat.o(127230);
      return 28;
    }
    if (bt.kU(paramString, "finder_tl_nearby_tab"))
    {
      AppMethodBeat.o(127230);
      return 29;
    }
    AppMethodBeat.o(127230);
    return 0;
  }
  
  static Pair<Byte, Boolean> b(a parama, Pair<k, dcb> paramPair, boolean paramBoolean)
  {
    AppMethodBeat.i(127226);
    boolean bool1;
    byte b;
    switch (2.uep[((k)paramPair.first).ordinal()])
    {
    default: 
      bool1 = false;
      b = 0;
    }
    for (;;)
    {
      Object localObject = paramPair.first;
      if (paramBoolean)
      {
        parama.getRoot().setTag(2131302800, Byte.valueOf(b));
        parama.getRoot().setTag(2131302801, paramPair.second);
      }
      for (;;)
      {
        parama = new Pair(Byte.valueOf(b), Boolean.valueOf(bool1));
        AppMethodBeat.o(127226);
        return parama;
        g(parama);
        bool1 = false;
        b = 0;
        break;
        boolean bool2 = parama.mZ(paramBoolean);
        bool1 = bool2;
        if (!bool2) {
          break label376;
        }
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 32;
        bool1 = bool2;
        break;
        bool2 = parama.na(paramBoolean);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 16;
        bool1 = bool2;
        break;
        bool2 = parama.a(paramBoolean, (dcb)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 8;
        bool1 = bool2;
        break;
        bool2 = parama.b(paramBoolean, (dcb)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 4;
        bool1 = bool2;
        break;
        bool2 = parama.c(paramBoolean, (dcb)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 2;
        bool1 = bool2;
        break;
        bool2 = parama.d(paramBoolean, (dcb)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 1;
        bool1 = bool2;
        break;
        parama.getRoot().setTag(2131302800, Integer.valueOf(0));
        parama.getRoot().setTag(2131302801, null);
      }
      label376:
      b = 0;
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(127229);
    if ((c(parama)) || (d(parama)))
    {
      AppMethodBeat.o(127229);
      return true;
    }
    AppMethodBeat.o(127229);
    return false;
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(127231);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() curNewTip is null");
      AppMethodBeat.o(127231);
      return true;
    }
    if (parama.getRoot() == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127231);
      return true;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302802)).byteValue();
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      if (i != 0)
      {
        AppMethodBeat.o(127231);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { parama.getPath(), localException.toString() });
        int i = 0;
      }
      AppMethodBeat.o(127231);
    }
    return false;
  }
  
  private static boolean d(a parama)
  {
    AppMethodBeat.i(127232);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() curNewTip is null");
      AppMethodBeat.o(127232);
      return false;
    }
    if (parama.getRoot() == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127232);
      return false;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ad.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      if (i != 0)
      {
        AppMethodBeat.o(127232);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        int i = 0;
      }
      AppMethodBeat.o(127232);
    }
    return false;
  }
  
  public static k e(a parama)
  {
    AppMethodBeat.i(127233);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() curNewTip is null");
      parama = k.ueu;
      AppMethodBeat.o(127233);
      return parama;
    }
    if (parama.getRoot() == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s root is null", new Object[] { parama.getPath() });
      parama = k.ueu;
      AppMethodBeat.o(127233);
      return parama;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      switch (i)
      {
      default: 
        parama = k.ueu;
        AppMethodBeat.o(127233);
        return parama;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        int i = 0;
        continue;
        parama = k.uev;
        continue;
        parama = k.uew;
        continue;
        parama = k.uex;
        continue;
        parama = k.uey;
        continue;
        parama = k.uez;
        continue;
        parama = k.ueA;
      }
    }
  }
  
  private static dcb f(a parama)
  {
    AppMethodBeat.i(127234);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() curNewTip is null");
      AppMethodBeat.o(127234);
      return null;
    }
    if (parama.getRoot() == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127234);
      return null;
    }
    try
    {
      dcb localdcb = (dcb)parama.getRoot().getTag(2131302800);
      ad.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s tipsInfo:%s", new Object[] { parama.getPath(), a(localdcb) });
      AppMethodBeat.o(127234);
      return localdcb;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        Object localObject = null;
      }
    }
  }
  
  private static void g(a parama)
  {
    AppMethodBeat.i(127236);
    k localk = e(parama);
    if (localk != k.ueu) {
      a(parama, new Pair(localk, new dcb()));
    }
    AppMethodBeat.o(127236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.g
 * JD-Core Version:    0.7.0.1
 */