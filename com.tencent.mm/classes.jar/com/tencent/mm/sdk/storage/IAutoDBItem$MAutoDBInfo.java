package com.tencent.mm.sdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class IAutoDBItem$MAutoDBInfo
{
  public Map<String, String> colsMap;
  public String[] columns;
  public Field[] fields;
  public String primaryKey;
  public String sql;
  
  public IAutoDBItem$MAutoDBInfo()
  {
    AppMethodBeat.i(158082);
    this.colsMap = new HashMap();
    AppMethodBeat.o(158082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo
 * JD-Core Version:    0.7.0.1
 */