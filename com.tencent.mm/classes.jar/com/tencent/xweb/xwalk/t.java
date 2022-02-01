package com.tencent.xweb.xwalk;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements IWebViewDatabase
{
  private b aipH;
  
  public t()
  {
    AppMethodBeat.i(212802);
    this.aipH = b.dt(XWalkEnvironment.getApplicationContext(), "xweb_http_auth.db");
    AppMethodBeat.o(212802);
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212814);
    paramString1 = this.aipH.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(212814);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212808);
    b localb = this.aipH;
    if ((paramString1 == null) || (paramString2 == null) || (!localb.kja()))
    {
      AppMethodBeat.o(212808);
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("host", paramString1);
    localContentValues.put("realm", paramString2);
    localContentValues.put("username", paramString3);
    localContentValues.put("password", paramString4);
    localb.mDatabase.insert("httpauth", "host", localContentValues);
    AppMethodBeat.o(212808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.t
 * JD-Core Version:    0.7.0.1
 */