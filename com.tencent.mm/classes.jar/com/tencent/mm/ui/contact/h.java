package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.l.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.c.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.s;

public final class h
{
  public static void bBN(String paramString)
  {
    AppMethodBeat.i(252839);
    ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().bzq(paramString);
    AppMethodBeat.o(252839);
  }
  
  private static final boolean baJ(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = ab.oko;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(102839);
        return false;
      }
      i += 1;
    }
    if (au.bwE(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (ab.IS(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static List<String> jyr()
  {
    AppMethodBeat.i(252834);
    if (jyv())
    {
      List localList = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().azl(2);
      Log.i("MicroMsg.RecentForwardInfoStorage", s.X("[query] list size=", Integer.valueOf(localList.size())));
      AppMethodBeat.o(252834);
      return localList;
    }
    AppMethodBeat.o(252834);
    return null;
  }
  
  public static List<String> jys()
  {
    AppMethodBeat.i(252838);
    if (jyv())
    {
      List localList = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().azl(1);
      Log.i("MicroMsg.RecentForwardInfoStorage", s.X("[query] list size=", Integer.valueOf(localList.size())));
      AppMethodBeat.o(252838);
      return localList;
    }
    AppMethodBeat.o(252838);
    return null;
  }
  
  public static List<String> jyt()
  {
    AppMethodBeat.i(252842);
    if (jyv())
    {
      List localList = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().jdQ();
      AppMethodBeat.o(252842);
      return localList;
    }
    AppMethodBeat.o(252842);
    return null;
  }
  
  public static int jyu()
  {
    AppMethodBeat.i(252845);
    Log.i("ContactSelectLogic", "getRecentForwardControlSwitch: " + ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVN, 1));
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVN, 1);
    AppMethodBeat.o(252845);
    return i;
  }
  
  public static boolean jyv()
  {
    AppMethodBeat.i(252847);
    if (jyu() == 1)
    {
      AppMethodBeat.o(252847);
      return true;
    }
    AppMethodBeat.o(252847);
    return false;
  }
  
  public static boolean jyw()
  {
    AppMethodBeat.i(252849);
    if (jyv())
    {
      Log.i("ContactSelectLogic", "getRecentForwardSecondControlSwitch: " + ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVO, 1));
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVO, 1) == 1)
      {
        AppMethodBeat.o(252849);
        return true;
      }
    }
    AppMethodBeat.o(252849);
    return false;
  }
  
  public static final Cursor nR(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = nS(paramList);
    if (paramList.size() == 0)
    {
      com.tencent.mm.kernel.h.baF();
      paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().jaF();
      AppMethodBeat.o(102837);
      return paramList;
    }
    com.tencent.mm.kernel.h.baF();
    paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().mQ(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> nS(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(1, paramList, a.maX, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        bb localbb = new bb();
        localbb.convertFrom(paramList);
        int j = i;
        if (baJ(localbb.field_username))
        {
          localArrayList.add(localbb.field_username);
          j = i + 1;
          if (j >= 4) {
            break;
          }
        }
        i = j;
      } while (paramList.moveToNext());
    }
    paramList.close();
    AppMethodBeat.o(102838);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.h
 * JD-Core Version:    0.7.0.1
 */