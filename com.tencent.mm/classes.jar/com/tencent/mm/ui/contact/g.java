package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  private static final boolean Po(String paramString)
  {
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!paramString.equals(arrayOfString[i])) {}
    }
    while ((s.fn(paramString)) || (s.hl(paramString)))
    {
      return false;
      i += 1;
      break;
    }
    return true;
  }
  
  static final List<String> ek(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(s.dUT, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        ak localak = new ak();
        localak.d(paramList);
        int j = i;
        if (Po(localak.field_username))
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
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */