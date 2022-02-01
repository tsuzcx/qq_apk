package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.ArrayList;

public final class o
{
  public static final String XQZ;
  
  static
  {
    AppMethodBeat.i(244751);
    XQZ = "content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_GWALLET_QUERYPROVIDER();
    AppMethodBeat.o(244751);
  }
  
  public static void a(Context paramContext, final String[] paramArrayOfString, final a parama)
  {
    AppMethodBeat.i(151634);
    if ((parama == null) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramContext = new IllegalArgumentException();
      AppMethodBeat.o(151634);
      throw paramContext;
    }
    new AsyncTask() {}.execute(new Void[0]);
    AppMethodBeat.o(151634);
  }
  
  public static abstract interface a
  {
    public abstract void ac(ArrayList<w> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */