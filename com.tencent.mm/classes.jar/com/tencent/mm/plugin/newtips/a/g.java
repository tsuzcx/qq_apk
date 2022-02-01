package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.Serializable;

public final class g
{
  public static String a(dhn paramdhn)
  {
    AppMethodBeat.i(127237);
    if (paramdhn == null)
    {
      AppMethodBeat.o(127237);
      return "null";
    }
    paramdhn = "TipsInfo{num=" + paramdhn.gMk + ", title='" + paramdhn.title + '\'' + ", url='" + paramdhn.url + '\'' + '}';
    AppMethodBeat.o(127237);
    return paramdhn;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127227);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsHelper", "clearCompatTag() iNewTipsView == null");
      AppMethodBeat.o(127227);
      return;
    }
    parama.a(k.vnt, false);
    parama.a(k.vnu, false);
    parama.a(k.vnv, false);
    parama.a(k.vnw, false);
    parama.a(k.vnx, false);
    parama.a(k.vny, false);
    AppMethodBeat.o(127227);
  }
  
  private static boolean a(a parama, Pair<k, dhn> paramPair)
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
      ac.i("MicroMsg.NewTips.NewTipsHelper", "showNewTips() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, parama, a((dhn)paramPair.second), Boolean.FALSE, localPair.first, localPair.second });
      AppMethodBeat.o(127225);
      return true;
    }
  }
  
  public static boolean a(a parama, final Pair<k, dhn> paramPair, final boolean paramBoolean)
  {
    AppMethodBeat.i(127224);
    if ((parama == null) || (paramPair == null))
    {
      AppMethodBeat.o(127224);
      return false;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127221);
        Pair localPair = g.b(this.vnl, paramPair, paramBoolean);
        String str = this.vnl.getPath();
        if (paramPair.first != null) {}
        for (Object localObject = (Serializable)paramPair.first;; localObject = "null")
        {
          ac.i("MicroMsg.NewTips.NewTipsHelper", "showNewTipsMainThread() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, localObject, g.a((dhn)paramPair.second), Boolean.valueOf(paramBoolean), localPair.first, localPair.second });
          AppMethodBeat.o(127221);
          return;
        }
      }
    });
    AppMethodBeat.o(127224);
    return true;
  }
  
  public static boolean a(a parama, k paramk, Pair<k, dhn> paramPair)
  {
    boolean bool2 = true;
    AppMethodBeat.i(127235);
    if (parama == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() curNewTip == null");
      AppMethodBeat.o(127235);
      return true;
    }
    if (paramPair == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() second == null");
      AppMethodBeat.o(127235);
      return true;
    }
    if (paramk != paramPair.first)
    {
      AppMethodBeat.o(127235);
      return false;
    }
    parama = f(parama);
    paramPair = (dhn)paramPair.second;
    if ((parama == null) && (paramPair == null))
    {
      AppMethodBeat.o(127235);
      return true;
    }
    if (((parama != null) && (paramPair == null)) || ((parama == null) && (paramPair != null)))
    {
      switch (2.vnn[paramk.ordinal()])
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
    switch (2.vnn[paramk.ordinal()])
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      AppMethodBeat.o(127235);
      return bool1;
      bool1 = bool2;
      if (!bs.lr(parama.title, paramPair.title))
      {
        bool1 = false;
        continue;
        bool1 = bool2;
        if (!bs.lr(parama.url, paramPair.url))
        {
          bool1 = false;
          continue;
          if (bs.lr(parama.title, paramPair.title))
          {
            bool1 = bool2;
            if (bs.lr(parama.url, paramPair.url)) {}
          }
          else
          {
            bool1 = false;
            continue;
            bool1 = bool2;
            if (!bs.jl(parama.gMk, paramPair.gMk)) {
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
      ac.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s origin state:%s", new Object[] { parama.getPath(), Long.toBinaryString(b) });
      switch (2.vnn[paramk.ordinal()])
      {
      default: 
        parama.getRoot().setTag(2131302802, Byte.valueOf(b));
        ac.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s showType:%s result:%s", new Object[] { parama.getPath(), paramk.vnz, Long.toBinaryString(b) });
        AppMethodBeat.o(127223);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.i("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { localException.toString() });
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
    } while (parame.vnF);
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
          if (parame.vnF) {
            return true;
          }
          int i = parame.path;
          if (paramk == k.vns) {
            return true;
          }
          switch (i)
          {
          case 23: 
          default: 
            return false;
          }
        } while ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny));
        return true;
      } while ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny));
      return true;
    } while (paramk != k.vnt);
    for (;;)
    {
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vny)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv)) {
        break;
      }
      return true;
      if ((paramk != k.vnt) && (paramk != k.vnu) && (paramk != k.vnv) && (paramk != k.vnw) && (paramk != k.vnx)) {
        if (paramk != k.vny) {
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
  
  public static int aog(String paramString)
  {
    AppMethodBeat.i(127230);
    if (bs.lr(paramString, "me"))
    {
      AppMethodBeat.o(127230);
      return 1;
    }
    if (bs.lr(paramString, "discovery"))
    {
      AppMethodBeat.o(127230);
      return 2;
    }
    if (bs.lr(paramString, "plus"))
    {
      AppMethodBeat.o(127230);
      return 3;
    }
    if (bs.lr(paramString, "plus_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 4;
    }
    if (bs.lr(paramString, "pay_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 5;
    }
    if (bs.lr(paramString, "topstories"))
    {
      AppMethodBeat.o(127230);
      return 6;
    }
    if (bs.lr(paramString, "topstories_wow"))
    {
      AppMethodBeat.o(127230);
      return 7;
    }
    if (bs.lr(paramString, "topstories_top"))
    {
      AppMethodBeat.o(127230);
      return 8;
    }
    if (bs.lr(paramString, "search"))
    {
      AppMethodBeat.o(127230);
      return 9;
    }
    if (bs.lr(paramString, "dining_nearby"))
    {
      AppMethodBeat.o(127230);
      return 10;
    }
    if (bs.lr(paramString, "shopping"))
    {
      AppMethodBeat.o(127230);
      return 11;
    }
    if (bs.lr(paramString, "game"))
    {
      AppMethodBeat.o(127230);
      return 12;
    }
    if (bs.lr(paramString, "pay"))
    {
      AppMethodBeat.o(127230);
      return 13;
    }
    if (bs.lr(paramString, "card"))
    {
      AppMethodBeat.o(127230);
      return 14;
    }
    if (bs.lr(paramString, "wallet"))
    {
      AppMethodBeat.o(127230);
      return 15;
    }
    if (bs.lr(paramString, "grouppayreddot"))
    {
      AppMethodBeat.o(127230);
      return 16;
    }
    if (bs.lr(paramString, "facingreceivereddot"))
    {
      AppMethodBeat.o(127230);
      return 17;
    }
    if (bs.lr(paramString, "f2fhongbaoreddot"))
    {
      AppMethodBeat.o(127230);
      return 18;
    }
    if (bs.lr(paramString, "rewardcodereddot"))
    {
      AppMethodBeat.o(127230);
      return 19;
    }
    if (bs.lr(paramString, "transfertoreddot"))
    {
      AppMethodBeat.o(127230);
      return 20;
    }
    if (bs.lr(paramString, "transtobankreddot"))
    {
      AppMethodBeat.o(127230);
      return 21;
    }
    if (bs.lr(paramString, "mobiletransferreddot"))
    {
      AppMethodBeat.o(127230);
      return 22;
    }
    if (bs.lr(paramString, "finder"))
    {
      AppMethodBeat.o(127230);
      return 24;
    }
    if (bs.lr(paramString, "chatroom"))
    {
      AppMethodBeat.o(127230);
      return 25;
    }
    if (bs.lr(paramString, "chatroommgr"))
    {
      AppMethodBeat.o(127230);
      return 26;
    }
    if (bs.lr(paramString, "useww"))
    {
      AppMethodBeat.o(127230);
      return 27;
    }
    if (bs.lr(paramString, "finder_tl_hot_tab"))
    {
      AppMethodBeat.o(127230);
      return 28;
    }
    if (bs.lr(paramString, "finder_tl_nearby_tab"))
    {
      AppMethodBeat.o(127230);
      return 29;
    }
    AppMethodBeat.o(127230);
    return 0;
  }
  
  static Pair<Byte, Boolean> b(a parama, Pair<k, dhn> paramPair, boolean paramBoolean)
  {
    AppMethodBeat.i(127226);
    boolean bool1;
    byte b;
    switch (2.vnn[((k)paramPair.first).ordinal()])
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
        boolean bool2 = parama.nS(paramBoolean);
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
        bool2 = parama.nT(paramBoolean);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 16;
        bool1 = bool2;
        break;
        bool2 = parama.a(paramBoolean, (dhn)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 8;
        bool1 = bool2;
        break;
        bool2 = parama.b(paramBoolean, (dhn)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 4;
        bool1 = bool2;
        break;
        bool2 = parama.c(paramBoolean, (dhn)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 2;
        bool1 = bool2;
        break;
        bool2 = parama.d(paramBoolean, (dhn)paramPair.second);
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
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() curNewTip is null");
      AppMethodBeat.o(127231);
      return true;
    }
    if (parama.getRoot() == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127231);
      return true;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302802)).byteValue();
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        ac.e("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { parama.getPath(), localException.toString() });
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
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() curNewTip is null");
      AppMethodBeat.o(127232);
      return false;
    }
    if (parama.getRoot() == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127232);
      return false;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ac.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        ac.e("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
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
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() curNewTip is null");
      parama = k.vns;
      AppMethodBeat.o(127233);
      return parama;
    }
    if (parama.getRoot() == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s root is null", new Object[] { parama.getPath() });
      parama = k.vns;
      AppMethodBeat.o(127233);
      return parama;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      switch (i)
      {
      default: 
        parama = k.vns;
        AppMethodBeat.o(127233);
        return parama;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        int i = 0;
        continue;
        parama = k.vnt;
        continue;
        parama = k.vnu;
        continue;
        parama = k.vnv;
        continue;
        parama = k.vnw;
        continue;
        parama = k.vnx;
        continue;
        parama = k.vny;
      }
    }
  }
  
  private static dhn f(a parama)
  {
    AppMethodBeat.i(127234);
    if (parama == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() curNewTip is null");
      AppMethodBeat.o(127234);
      return null;
    }
    if (parama.getRoot() == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127234);
      return null;
    }
    try
    {
      dhn localdhn = (dhn)parama.getRoot().getTag(2131302800);
      ac.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s tipsInfo:%s", new Object[] { parama.getPath(), a(localdhn) });
      AppMethodBeat.o(127234);
      return localdhn;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        Object localObject = null;
      }
    }
  }
  
  private static void g(a parama)
  {
    AppMethodBeat.i(127236);
    k localk = e(parama);
    if (localk != k.vns) {
      a(parama, new Pair(localk, new dhn()));
    }
    AppMethodBeat.o(127236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.g
 * JD-Core Version:    0.7.0.1
 */