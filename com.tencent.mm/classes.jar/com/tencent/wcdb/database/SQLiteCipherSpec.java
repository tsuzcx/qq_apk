package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SQLiteCipherSpec
{
  public static final int HMAC_DEFAULT = -1;
  public static final int HMAC_SHA1 = 0;
  public static final int HMAC_SHA256 = 1;
  public static final int HMAC_SHA512 = 2;
  public int hmacAlgorithm = -1;
  public boolean hmacEnabled = true;
  public int kdfAlgorithm = -1;
  public int kdfIteration;
  public int pageSize = SQLiteGlobal.defaultPageSize;
  
  public SQLiteCipherSpec() {}
  
  public SQLiteCipherSpec(SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.kdfIteration = paramSQLiteCipherSpec.kdfIteration;
    this.hmacEnabled = paramSQLiteCipherSpec.hmacEnabled;
    this.pageSize = paramSQLiteCipherSpec.pageSize;
  }
  
  public SQLiteCipherSpec setHmacAlgorithm(int paramInt)
  {
    this.hmacAlgorithm = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setKDFIteration(int paramInt)
  {
    this.kdfIteration = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setKdfAlgorithm(int paramInt)
  {
    this.kdfAlgorithm = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setSQLCipherVersion(int paramInt)
  {
    AppMethodBeat.i(12270);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Unsupported SQLCipher version: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(12270);
      throw localIllegalArgumentException;
    case 1: 
      this.hmacEnabled = false;
      this.kdfIteration = 4000;
      this.hmacAlgorithm = 0;
      this.kdfAlgorithm = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(12270);
      return this;
      this.hmacEnabled = true;
      this.kdfIteration = 4000;
      this.hmacAlgorithm = 0;
      this.kdfAlgorithm = 0;
      continue;
      this.hmacEnabled = true;
      this.kdfIteration = 64000;
      this.hmacAlgorithm = 0;
      this.kdfAlgorithm = 0;
      continue;
      this.hmacEnabled = true;
      this.kdfIteration = 256000;
      this.hmacAlgorithm = 2;
      this.kdfAlgorithm = 2;
    }
  }
  
  public SQLiteCipherSpec withHMACEnabled(boolean paramBoolean)
  {
    this.hmacEnabled = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCipherSpec
 * JD-Core Version:    0.7.0.1
 */