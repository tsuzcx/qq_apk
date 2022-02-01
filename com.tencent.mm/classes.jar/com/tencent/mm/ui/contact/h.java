package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final boolean aCh(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = x.hIe;
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
    if (x.wb(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (x.Ao(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static final Cursor iD(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = iE(paramList);
    if (paramList.size() == 0)
    {
      g.ajS();
      paramList = ((l)g.ab(l.class)).azF().fuH();
      AppMethodBeat.o(102837);
      return paramList;
    }
    g.ajS();
    paramList = ((l)g.ab(l.class)).azF().hH(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> iE(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((l)g.ab(l.class)).azL().a(x.hHV, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        au localau = new au();
        localau.convertFrom(paramList);
        int j = i;
        if (aCh(localau.field_username))
        {
          localArrayList.add(localau.field_username);
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