package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;

public final class g
{
  public static String a(erx paramerx)
  {
    AppMethodBeat.i(127237);
    if (paramerx == null)
    {
      AppMethodBeat.o(127237);
      return "null";
    }
    paramerx = "TipsInfo{num=" + paramerx.num + ", title='" + paramerx.title + '\'' + ", url='" + paramerx.url + '\'' + '}';
    AppMethodBeat.o(127237);
    return paramerx;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127227);
    if (parama == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsHelper", "clearCompatTag() iNewTipsView == null");
      AppMethodBeat.o(127227);
      return;
    }
    parama.a(k.GwK, false);
    parama.a(k.GwL, false);
    parama.a(k.GwM, false);
    parama.a(k.GwN, false);
    parama.a(k.GwO, false);
    parama.a(k.GwP, false);
    AppMethodBeat.o(127227);
  }
  
  private static boolean a(a parama, Pair<k, erx> paramPair)
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
      Log.i("MicroMsg.NewTips.NewTipsHelper", "showNewTips() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, parama, a((erx)paramPair.second), Boolean.FALSE, localPair.first, localPair.second });
      AppMethodBeat.o(127225);
      return true;
    }
  }
  
  public static boolean a(a parama, final Pair<k, erx> paramPair, final boolean paramBoolean)
  {
    AppMethodBeat.i(127224);
    if ((parama == null) || (paramPair == null))
    {
      AppMethodBeat.o(127224);
      return false;
    }
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127221);
        Pair localPair = g.b(this.GwB, paramPair, paramBoolean);
        String str = this.GwB.getPath();
        if (paramPair.first != null) {}
        for (Object localObject = (Serializable)paramPair.first;; localObject = "null")
        {
          Log.i("MicroMsg.NewTips.NewTipsHelper", "showNewTipsMainThread() path:%s pair:(%s, %s) show:%s state:%s result:%s", new Object[] { str, localObject, g.a((erx)paramPair.second), Boolean.valueOf(paramBoolean), localPair.first, localPair.second });
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
      b = ((Byte)parama.getRoot().getTag(b.c.new_tips_tag_show_type_old)).byteValue();
      Log.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s origin state:%s", new Object[] { parama.getPath(), Long.toBinaryString(b) });
      switch (2.GwD[paramk.ordinal()])
      {
      default: 
        parama.getRoot().setTag(b.c.new_tips_tag_show_type_old, Byte.valueOf(b));
        Log.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s showType:%s result:%s", new Object[] { parama.getPath(), paramk.GwQ, Long.toBinaryString(b) });
        AppMethodBeat.o(127223);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { localException.toString() });
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
          if (parame.GwW) {
            return true;
          }
          int i = parame.path;
          if (paramk == k.GwJ) {
            return true;
          }
          switch (i)
          {
          case 23: 
          case 28: 
          case 29: 
          default: 
            return false;
          }
        } while ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP));
        return true;
      } while ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP));
      return true;
    } while (paramk != k.GwK);
    for (;;)
    {
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwP)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM)) {
        break;
      }
      return true;
      if ((paramk != k.GwK) && (paramk != k.GwL) && (paramk != k.GwM) && (paramk != k.GwN) && (paramk != k.GwO)) {
        if (paramk != k.GwP) {
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
  
  public static boolean aSV(String paramString)
  {
    AppMethodBeat.i(186358);
    boolean bool = getKV().getBoolean(paramString, false);
    AppMethodBeat.o(186358);
    return bool;
  }
  
  public static int aSW(String paramString)
  {
    AppMethodBeat.i(127230);
    if (Util.isEqual(paramString, "me"))
    {
      AppMethodBeat.o(127230);
      return 1;
    }
    if (Util.isEqual(paramString, "discovery"))
    {
      AppMethodBeat.o(127230);
      return 2;
    }
    if (Util.isEqual(paramString, "plus"))
    {
      AppMethodBeat.o(127230);
      return 3;
    }
    if (Util.isEqual(paramString, "plus_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 4;
    }
    if (Util.isEqual(paramString, "pay_receiveorpay"))
    {
      AppMethodBeat.o(127230);
      return 5;
    }
    if (Util.isEqual(paramString, "topstories"))
    {
      AppMethodBeat.o(127230);
      return 6;
    }
    if (Util.isEqual(paramString, "topstories_wow"))
    {
      AppMethodBeat.o(127230);
      return 7;
    }
    if (Util.isEqual(paramString, "topstories_top"))
    {
      AppMethodBeat.o(127230);
      return 8;
    }
    if (Util.isEqual(paramString, "search"))
    {
      AppMethodBeat.o(127230);
      return 9;
    }
    if (Util.isEqual(paramString, "dining_nearby"))
    {
      AppMethodBeat.o(127230);
      return 10;
    }
    if (Util.isEqual(paramString, "shopping"))
    {
      AppMethodBeat.o(127230);
      return 11;
    }
    if (Util.isEqual(paramString, "game"))
    {
      AppMethodBeat.o(127230);
      return 12;
    }
    if (Util.isEqual(paramString, "pay"))
    {
      AppMethodBeat.o(127230);
      return 13;
    }
    if (Util.isEqual(paramString, "card"))
    {
      AppMethodBeat.o(127230);
      return 14;
    }
    if (Util.isEqual(paramString, "wallet"))
    {
      AppMethodBeat.o(127230);
      return 15;
    }
    if (Util.isEqual(paramString, "grouppayreddot"))
    {
      AppMethodBeat.o(127230);
      return 16;
    }
    if (Util.isEqual(paramString, "facingreceivereddot"))
    {
      AppMethodBeat.o(127230);
      return 17;
    }
    if (Util.isEqual(paramString, "f2fhongbaoreddot"))
    {
      AppMethodBeat.o(127230);
      return 18;
    }
    if (Util.isEqual(paramString, "rewardcodereddot"))
    {
      AppMethodBeat.o(127230);
      return 19;
    }
    if (Util.isEqual(paramString, "transfertoreddot"))
    {
      AppMethodBeat.o(127230);
      return 20;
    }
    if (Util.isEqual(paramString, "transtobankreddot"))
    {
      AppMethodBeat.o(127230);
      return 21;
    }
    if (Util.isEqual(paramString, "mobiletransferreddot"))
    {
      AppMethodBeat.o(127230);
      return 22;
    }
    if (Util.isEqual(paramString, "finder"))
    {
      AppMethodBeat.o(127230);
      return 24;
    }
    if (Util.isEqual(paramString, "chatroom"))
    {
      AppMethodBeat.o(127230);
      return 25;
    }
    if (Util.isEqual(paramString, "chatroommgr"))
    {
      AppMethodBeat.o(127230);
      return 26;
    }
    if (Util.isEqual(paramString, "useww"))
    {
      AppMethodBeat.o(127230);
      return 27;
    }
    if (Util.isEqual(paramString, "finder_tl_hot_tab"))
    {
      AppMethodBeat.o(127230);
      return 28;
    }
    if (Util.isEqual(paramString, "finder_tl_nearby_tab"))
    {
      AppMethodBeat.o(127230);
      return 29;
    }
    if (Util.isEqual(paramString, "screenShare"))
    {
      AppMethodBeat.o(127230);
      return 35;
    }
    if (Util.isEqual(paramString, "setting"))
    {
      AppMethodBeat.o(127230);
      return 30;
    }
    if (Util.isEqual(paramString, "general"))
    {
      AppMethodBeat.o(127230);
      return 31;
    }
    if (Util.isEqual(paramString, "wechattools"))
    {
      AppMethodBeat.o(127230);
      return 32;
    }
    if (Util.isEqual(paramString, "inputmethod"))
    {
      AppMethodBeat.o(127230);
      return 33;
    }
    if (Util.isEqual(paramString, "plugin"))
    {
      AppMethodBeat.o(127230);
      return 34;
    }
    AppMethodBeat.o(127230);
    return 0;
  }
  
  static Pair<Byte, Boolean> b(a parama, Pair<k, erx> paramPair, boolean paramBoolean)
  {
    AppMethodBeat.i(127226);
    boolean bool1;
    byte b;
    switch (2.GwD[((k)paramPair.first).ordinal()])
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
        parama.getRoot().setTag(b.c.new_tips_tag_show_type_new, Byte.valueOf(b));
        parama.getRoot().setTag(b.c.new_tips_tag_show_type_new_tipsinfo, paramPair.second);
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
        boolean bool2 = parama.tY(paramBoolean);
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
        bool2 = parama.tZ(paramBoolean);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 16;
        bool1 = bool2;
        break;
        bool2 = parama.a(paramBoolean, (erx)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 8;
        bool1 = bool2;
        break;
        bool2 = parama.b(paramBoolean, (erx)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 4;
        bool1 = bool2;
        break;
        bool2 = parama.c(paramBoolean, (erx)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 2;
        bool1 = bool2;
        break;
        bool2 = parama.d(paramBoolean, (erx)paramPair.second);
        bool1 = bool2;
        if (!paramBoolean) {
          break label376;
        }
        b = 1;
        bool1 = bool2;
        break;
        parama.getRoot().setTag(b.c.new_tips_tag_show_type_new, Integer.valueOf(0));
        parama.getRoot().setTag(b.c.new_tips_tag_show_type_new_tipsinfo, null);
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
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() curNewTip is null");
      AppMethodBeat.o(127231);
      return true;
    }
    if (parama.getRoot() == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127231);
      return true;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(b.c.new_tips_tag_show_type_old)).byteValue();
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        Log.e("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s getTag(R.id.new_tips_tag_show_type_old) [%s]", new Object[] { parama.getPath(), localException.toString() });
        int i = 0;
      }
      AppMethodBeat.o(127231);
    }
    return false;
  }
  
  public static boolean d(a parama)
  {
    AppMethodBeat.i(127232);
    if (parama == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() curNewTip is null");
      AppMethodBeat.o(127232);
      return false;
    }
    if (parama.getRoot() == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127232);
      return false;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(b.c.new_tips_tag_show_type_new)).byteValue();
      Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
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
        Log.e("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
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
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() curNewTip is null");
      parama = k.GwJ;
      AppMethodBeat.o(127233);
      return parama;
    }
    if (parama.getRoot() == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s root is null", new Object[] { parama.getPath() });
      parama = k.GwJ;
      AppMethodBeat.o(127233);
      return parama;
    }
    try
    {
      i = ((Byte)parama.getRoot().getTag(b.c.new_tips_tag_show_type_new)).byteValue();
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s state:%s", new Object[] { parama.getPath(), Long.toBinaryString(i) });
      switch (i)
      {
      default: 
        parama = k.GwJ;
        AppMethodBeat.o(127233);
        return parama;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        int i = 0;
        continue;
        parama = k.GwK;
        continue;
        parama = k.GwL;
        continue;
        parama = k.GwM;
        continue;
        parama = k.GwN;
        continue;
        parama = k.GwO;
        continue;
        parama = k.GwP;
      }
    }
  }
  
  public static erx f(a parama)
  {
    AppMethodBeat.i(127234);
    if (parama == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() curNewTip is null");
      AppMethodBeat.o(127234);
      return null;
    }
    if (parama.getRoot() == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s root is null", new Object[] { parama.getPath() });
      AppMethodBeat.o(127234);
      return null;
    }
    try
    {
      erx localerx = (erx)parama.getRoot().getTag(b.c.new_tips_tag_show_type_new);
      Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s tipsInfo:%s", new Object[] { parama.getPath(), a(localerx) });
      AppMethodBeat.o(127234);
      return localerx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() getTag(R.id.new_tips_tag_show_type_new) [%s]", new Object[] { localException.toString() });
        Object localObject = null;
      }
    }
  }
  
  private static void g(a parama)
  {
    AppMethodBeat.i(127236);
    k localk = e(parama);
    if (localk != k.GwJ) {
      a(parama, new Pair(localk, new erx()));
    }
    AppMethodBeat.o(127236);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(186356);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("new_tips_" + b.aGP());
    AppMethodBeat.o(186356);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.g
 * JD-Core Version:    0.7.0.1
 */