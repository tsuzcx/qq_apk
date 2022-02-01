package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final boolean aAQ(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = w.hFm;
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
    if (w.vF(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (w.zE(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static final Cursor it(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = iu(paramList);
    if (paramList.size() == 0)
    {
      g.ajD();
      paramList = ((l)g.ab(l.class)).azp().fqH();
      AppMethodBeat.o(102837);
      return paramList;
    }
    g.ajD();
    paramList = ((l)g.ab(l.class)).azp().hx(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> iu(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((l)g.ab(l.class)).azv().a(w.hFd, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        at localat = new at();
        localat.convertFrom(paramList);
        int j = i;
        if (aAQ(localat.field_username))
        {
          localArrayList.add(localat.field_username);
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