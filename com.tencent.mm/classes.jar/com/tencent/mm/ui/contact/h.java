package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final boolean aqA(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = w.gMw;
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
    if (w.pF(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (w.sE(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static final Cursor hU(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = hV(paramList);
    if (paramList.size() == 0)
    {
      g.afC();
      paramList = ((k)g.ab(k.class)).apM().eLc();
      AppMethodBeat.o(102837);
      return paramList;
    }
    g.afC();
    paramList = ((k)g.ab(k.class)).apM().gY(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> hV(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((k)g.ab(k.class)).apR().a(w.gMn, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        am localam = new am();
        localam.convertFrom(paramList);
        int j = i;
        if (aqA(localam.field_username))
        {
          localArrayList.add(localam.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.h
 * JD-Core Version:    0.7.0.1
 */