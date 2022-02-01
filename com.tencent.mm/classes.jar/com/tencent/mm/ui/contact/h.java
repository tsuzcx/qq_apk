package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final boolean avJ(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = w.hmW;
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
    if (w.sQ(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (w.wH(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static final Cursor ih(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = ii(paramList);
    if (paramList.size() == 0)
    {
      g.agS();
      paramList = ((k)g.ab(k.class)).awB().faE();
      AppMethodBeat.o(102837);
      return paramList;
    }
    g.agS();
    paramList = ((k)g.ab(k.class)).awB().hl(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> ii(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((k)g.ab(k.class)).awG().a(w.hmN, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        ap localap = new ap();
        localap.convertFrom(paramList);
        int j = i;
        if (avJ(localap.field_username))
        {
          localArrayList.add(localap.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.h
 * JD-Core Version:    0.7.0.1
 */