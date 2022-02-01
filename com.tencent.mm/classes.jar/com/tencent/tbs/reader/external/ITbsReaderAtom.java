package com.tencent.tbs.reader.external;

public abstract interface ITbsReaderAtom
{
  public static final int TBS_READER_ATOM_SUCCESS = 0;
  public static final int TBS_READER_ATOM_TYPE_TOKEN = 0;
  
  public abstract int getAtomType();
  
  public abstract int init(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tbs.reader.external.ITbsReaderAtom
 * JD-Core Version:    0.7.0.1
 */