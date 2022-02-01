package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SQLiteCustomFunction
{
  public final SQLiteDatabase.CustomFunction callback;
  public final String name;
  public final int numArgs;
  
  public SQLiteCustomFunction(String paramString, int paramInt, SQLiteDatabase.CustomFunction paramCustomFunction)
  {
    AppMethodBeat.i(3104);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("name must not be null.");
      AppMethodBeat.o(3104);
      throw paramString;
    }
    this.name = paramString;
    this.numArgs = paramInt;
    this.callback = paramCustomFunction;
    AppMethodBeat.o(3104);
  }
  
  private void dispatchCallback(String[] paramArrayOfString)
  {
    AppMethodBeat.i(3105);
    this.callback.callback(paramArrayOfString);
    AppMethodBeat.o(3105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCustomFunction
 * JD-Core Version:    0.7.0.1
 */