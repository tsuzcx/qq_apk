package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final boolean aRc(String paramString)
  {
    AppMethodBeat.i(102839);
    String[] arrayOfString = ab.iCO;
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
    if (ab.Eq(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    if (ab.IT(paramString))
    {
      AppMethodBeat.o(102839);
      return false;
    }
    AppMethodBeat.o(102839);
    return true;
  }
  
  public static final Cursor jG(List<String> paramList)
  {
    AppMethodBeat.i(102837);
    paramList = jH(paramList);
    if (paramList.size() == 0)
    {
      g.aAi();
      paramList = ((l)g.af(l.class)).aSN().gCo();
      AppMethodBeat.o(102837);
      return paramList;
    }
    g.aAi();
    paramList = ((l)g.af(l.class)).aSN().iL(paramList);
    AppMethodBeat.o(102837);
    return paramList;
  }
  
  private static final List<String> jH(List<String> paramList)
  {
    AppMethodBeat.i(102838);
    ArrayList localArrayList = new ArrayList();
    paramList = ((l)g.af(l.class)).aST().b(ab.iCF, paramList, a.gNj, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        az localaz = new az();
        localaz.convertFrom(paramList);
        int j = i;
        if (aRc(localaz.field_username))
        {
          localArrayList.add(localaz.field_username);
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