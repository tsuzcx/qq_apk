package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.Serializable;

public final class g
{
  public static String a(dnz paramdnz)
  {
    AppMethodBeat.i(127237);
    if (paramdnz == null)
    {
      AppMethodBeat.o(127237);
      return "null";
    }
    paramdnz = "TipsInfo{num=" + paramdnz.hiV + ", title='" + paramdnz.title + '\'' + ", url='" + paramdnz.url + '\'' + '}';
    AppMethodBeat.o(127237);
    return paramdnz;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127227);
    if (parama == null)
    {
      ae.e("MicroMsg.NewTips.NewTipsHelper", "clearCompatTag() iNewTipsView == null");
      AppMethodBeat.o(127227);
      return;
    }
    parama.a(k.wIv, false);
    parama.a(k.wIw, false);
    parama.a(k.wIx, false);
    parama.a(k.wIy, false);
    parama.a(k.wIz, false);
    parama.a(k.wIA, false);
    AppMethodBeat.o(127227);
  }
  
  private static boolean a(a parama, Pair<k, dnz> paramPair)
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
      ae.i("MicroMsg.NewTips.NewTipsHelper", "showNewTips() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, parama, a((dnz)paramPair.second), Boolean.FALSE, localPair.first, localPair.second });
      AppMethodBeat.o(127225);
      return true;
    }
  }
  
  public static boolean a(a parama, final Pair<k, dnz> paramPair, final boolean paramBoolean)
  {
    AppMethodBeat.i(127224);
    if ((parama == null) || (paramPair == null))
    {
      AppMethodBeat.o(127224);
      return false;
    }
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127221);
        Pair localPair = g.b(this.wIm, paramPair, paramBoolean);
        String str = this.wIm.getPath();
        if (paramPair.first != null) {}
        for (Object localObject = (Serializable)paramPair.first;; localObject = "null")
        {
          ae.i("MicroMsg.NewTips.NewTipsHelper", "showNewTipsMainThread() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, localObject, g.a((dnz)paramPair.second), Boolean.valueOf(paramBoolean), localPair.first, localPair.second });
          AppMethodBeat.o(127221);
          return;
        }
      }
    });
    AppMethodBeat.o(127224);
    return true;
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
      ae.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s origin state:%s", new Object[] { parama.getPath(), Long.toBinaryString(b) });
      switch (2.wIo[paramk.ordinal()])
      {
      default: 
        parama.getRoot().setTag(2131302802, Byte.valueOf(b));
        ae.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s showType:%s result:%s", new Object[] { parama.getPath(), paramk.wIB, Long.toBinaryString(b) });
        AppMethodBeat.o(127223);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { localException.toString() });
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
          if (parame.wIH) {
            return true;
          }
          int i = parame.path;
          if (paramk == k.wIu) {
            return true;
          }
          switch (i)
          {
          case 23: 
          default: 
            return false;
          }
        } while ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA));
        return true;
      } while ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA));
      return true;
    } while (paramk != k.wIv);
    for (;;)
    {
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIA)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx)) {
        break;
      }
      return true;
      if ((paramk != k.wIv) && (paramk != k.wIw) && (paramk != k.wIx) && (paramk != k.wIy) && (paramk != k.wIz)) {
        if (paramk != k.wIA) {
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
  
  public static int aus(String paramString)
  {
    AppMethodBeat.i(127230);
    if (bu.lX(paramString, "me"))
    {
      AppMethodBeat.o(127230);
      return 1;
    }
    if (bu.lX(paramString, "discovery"))
    {
      AppMethodBeat.o(127230);
      return 2;
    }
    if (bu.lX(paramString, "plus"))
    {
      AppMethodBeat.o(127230);
      return 3;
    }
    if (bu.lX(paramString, "plus_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 4;
    }
    if (bu.lX(paramString, "pay_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 5;
    }
    if (bu.lX(paramString, "topstories"))
    {
      AppMethodBeat.o(127230);
      return 6;
    }
    if (bu.lX(paramString, "topstories_wow"))
    {
      AppMethodBeat.o(127230);
      return 7;
    }
    if (bu.lX(paramString, "topstories_top"))
    {
      AppMethodBeat.o(127230);
      return 8;
    }
    if (bu.lX(paramString, "search"))
    {
      AppMethodBeat.o(127230);
      return 9;
    }
    if (bu.lX(paramString, "dining_nearby"))
    {
      AppMethodBeat.o(127230);
      return 10;
    }
    if (bu.lX(paramString, "shopping"))
    {
      AppMethodBeat.o(127230);
      return 11;
    }
    if (bu.lX(paramString, "game"))
    {
      AppMethodBeat.o(127230);
      return 12;
    }
    if (bu.lX(paramString, "pay"))
    {
      AppMethodBeat.o(127230);
      return 13;
    }
    if (bu.lX(paramString, "card"))
    {
      AppMethodBeat.o(127230);
      return 14;
    }
    if (bu.lX(paramString, "wallet"))
    {
      AppMethodBeat.o(127230);
      return 15;
    }
    if (bu.lX(paramString, "grouppayreddot"))
    {
      AppMethodBeat.o(127230);
      return 16;
    }
    if (bu.lX(paramString, "facingreceivereddot"))
    {
      AppMethodBeat.o(127230);
      return 17;
    }
    if (bu.lX(paramString, "f2fhongbaoreddot"))
    {
      AppMethodBeat.o(127230);
      return 18;
    }
    if (bu.lX(paramString, "rewardcodereddot"))
    {
      AppMethodBeat.o(127230);
      return 19;
    }
    if (bu.lX(paramString, "transfertoreddot"))
    {
      AppMethodBeat.o(127230);
      return 20;
    }
    if (bu.lX(paramString, "transtobankreddot"))
    {
      AppMethodBeat.o(127230);
      return 21;
    }
    if (bu.lX(paramString, "mobiletransferreddot"))
    {
      AppMethodBeat.o(127230);
      return 22;
    }
    if (bu.lX(paramString, "finder"))
    {
      AppMethodBeat.o(127230);
      return 24;
    }
    if (bu.lX(paramString, "chatroom"))
    {
      AppMethodBeat.o(127230);
      return 25;
    }
    if (bu.lX(paramString, "chatroommgr"))
    {
      AppMethodBeat.o(127230);
      return 26;
    }
    if (bu.lX(paramString, "useww"))
    {
      AppMethodBeat.o(127230);
      return 27;
    }
    if (bu.lX(paramString, "finder_tl_hot_tab"))
    {
      AppMethodBeat.o(127230);
      return 28;
    }
    if (bu.lX(paramString, "finder_tl_nearby_tab"))
    {
      AppMethodBeat.o(127230);
      return 29;
    }
    AppMethodBeat.o(127230);
    return 0;
  }
  
  static Pair<Byte, Boolean> b(a parama, Pair<k, dnz> paramPair, boolean paramBoolean)
  {
    AppMethodBeat.i(127226);
    boolean bool1;
    byte b;
    switch (2.wIo[((k)paramPair.first).ordinal()])
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
        boolean bool2 = parama.or(paramBoolean);
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
        bool2 = parama.os(paramBoolean);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 16;
        bool1 = bool2;
        break;
        bool2 = parama.a(paramBoolean, (dnz)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 8;
        bool1 = bool2;
        break;
        bool2 = parama.b(paramBoolean, (dnz)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 4;
        bool1 = bool2;
        break;
        bool2 = parama.c(paramBoolean, (dnz)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 2;
        bool1 = bool2;
        break;
        bool2 = parama.d(paramBoolean, (dnz)paramPair.second);
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
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() curNewTip is null");
      AppMethodBeat.o(127231);
      return true;
    }
    if (parama.getRoot() == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127231);
      return true;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302802)).byteValue();
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        ae.e("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { parama.getPath(), localException.toString() });
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
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() curNewTip is null");
      AppMethodBeat.o(127232);
      return false;
    }
    if (parama.getRoot() == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127232);
      return false;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ae.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        ae.e("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
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
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() curNewTip is null");
      parama = k.wIu;
      AppMethodBeat.o(127233);
      return parama;
    }
    if (parama.getRoot() == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s root is null", new Object[] { parama.getPath() });
      parama = k.wIu;
      AppMethodBeat.o(127233);
      return parama;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(2131302800)).byteValue();
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      switch (i)
      {
      default: 
        parama = k.wIu;
        AppMethodBeat.o(127233);
        return parama;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        int i = 0;
        continue;
        parama = k.wIv;
        continue;
        parama = k.wIw;
        continue;
        parama = k.wIx;
        continue;
        parama = k.wIy;
        continue;
        parama = k.wIz;
        continue;
        parama = k.wIA;
      }
    }
  }
  
  public static dnz f(a parama)
  {
    AppMethodBeat.i(127234);
    if (parama == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() curNewTip is null");
      AppMethodBeat.o(127234);
      return null;
    }
    if (parama.getRoot() == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127234);
      return null;
    }
    try
    {
      dnz localdnz = (dnz)parama.getRoot().getTag(2131302800);
      ae.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s tipsInfo:%s", new Object[] { parama.getPath(), a(localdnz) });
      AppMethodBeat.o(127234);
      return localdnz;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        Object localObject = null;
      }
    }
  }
  
  private static void g(a parama)
  {
    AppMethodBeat.i(127236);
    k localk = e(parama);
    if (localk != k.wIu) {
      a(parama, new Pair(localk, new dnz()));
    }
    AppMethodBeat.o(127236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.g
 * JD-Core Version:    0.7.0.1
 */