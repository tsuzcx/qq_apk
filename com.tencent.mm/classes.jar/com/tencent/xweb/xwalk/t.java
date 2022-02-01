package com.tencent.xweb.xwalk;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements IWebViewDatabase
{
  b MxG;
  
  public t()
  {
    AppMethodBeat.i(195578);
    this.MxG = b.cG(XWalkEnvironment.getApplicationContext(), "xweb_http_auth.db");
    AppMethodBeat.o(195578);
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195580);
    paramString1 = this.MxG.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(195580);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(195579);
    b localb = this.MxG;
    if ((paramString1 == null) || (paramString2 == null) || (!localb.gcO()))
    {
      AppMethodBeat.o(195579);
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("host", paramString1);
    localContentValues.put("realm", paramString2);
    localContentValues.put("username", paramString3);
    localContentValues.put("password", paramString4);
    localb.mDatabase.insert("httpauth", "host", localContentValues);
    AppMethodBeat.o(195579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.t
 * JD-Core Version:    0.7.0.1
 */