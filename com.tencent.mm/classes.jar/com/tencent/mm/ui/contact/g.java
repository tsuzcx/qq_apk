package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  private static final boolean ach(String paramString)
  {
    AppMethodBeat.i(105203);
    String[] arrayOfString = t.fll;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(105203);
        return false;
      }
      i += 1;
    }
    if (t.lA(paramString))
    {
      AppMethodBeat.o(105203);
      return false;
    }
    if (t.nU(paramString))
    {
      AppMethodBeat.o(105203);
      return false;
    }
    AppMethodBeat.o(105203);
    return true;
  }
  
  public static final Cursor fu(List<String> paramList)
  {
    AppMethodBeat.i(105201);
    paramList = fv(paramList);
    if (paramList.size() == 0)
    {
      com.tencent.mm.kernel.g.RM();
      paramList = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().dwZ();
      AppMethodBeat.o(105201);
      return paramList;
    }
    com.tencent.mm.kernel.g.RM();
    paramList = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eE(paramList);
    AppMethodBeat.o(105201);
    return paramList;
  }
  
  private static final List<String> fv(List<String> paramList)
  {
    AppMethodBeat.i(105202);
    ArrayList localArrayList = new ArrayList();
    paramList = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(t.flc, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        ak localak = new ak();
        localak.convertFrom(paramList);
        int j = i;
        if (ach(localak.field_username))
        {
          localArrayList.add(localak.field_username);
          j = i + 1;
          if (j >= 4) {
            break;
          }
        }
        i = j;
      } while (paramList.moveToNext());
    }
    paramList.close();
    AppMethodBeat.o(105202);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */