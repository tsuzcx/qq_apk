package com.tencent.xweb.xwalk;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class t
  implements IWebViewDatabase
{
  b aajJ;
  
  public t()
  {
    AppMethodBeat.i(204687);
    this.aajJ = b.dk(XWalkEnvironment.getApplicationContext(), "xweb_http_auth.db");
    AppMethodBeat.o(204687);
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204694);
    paramString1 = this.aajJ.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(204694);
    return paramString1;
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(204692);
    b localb = this.aajJ;
    if ((paramString1 == null) || (paramString2 == null) || (!localb.iyy()))
    {
      AppMethodBeat.o(204692);
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("host", paramString1);
    localContentValues.put("realm", paramString2);
    localContentValues.put("username", paramString3);
    localContentValues.put("password", paramString4);
    localb.mDatabase.insert("httpauth", "host", localContentValues);
    AppMethodBeat.o(204692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.t
 * JD-Core Version:    0.7.0.1
 */