package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;

public final class f
  extends j<ac>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(47076);
    SQL_CREATE = new String[] { j.getCreateSQLs(ac.info, "WalletKindInfo") };
    AppMethodBeat.o(47076);
  }
  
  public f(e parame)
  {
    super(parame, ac.info, "WalletKindInfo", null);
    this.db = parame;
  }
  
  public final ArrayList<ac> cVk()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(47075);
    Cursor localCursor = this.db.a("select * from WalletKindInfo", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(47075);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        ac localac = new ac();
        localac.convertFrom(localCursor);
        localArrayList.add(localac);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(47075);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.f
 * JD-Core Version:    0.7.0.1
 */