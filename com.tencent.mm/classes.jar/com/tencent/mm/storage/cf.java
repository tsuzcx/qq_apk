package com.tencent.mm.storage;

import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storagebase.h;

public final class cf
  extends k
  implements o
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )" };
  private h hpA;
  
  public cf(h paramh)
  {
    this.hpA = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cf
 * JD-Core Version:    0.7.0.1
 */