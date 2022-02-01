package com.tencent.wxhld.info;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Syllable
{
  public byte[] id;
  public int id_len;
  public String syllable;
  
  public Syllable(int paramInt)
  {
    AppMethodBeat.i(212298);
    this.id_len = paramInt;
    this.id = new byte[this.id_len];
    AppMethodBeat.o(212298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxhld.info.Syllable
 * JD-Core Version:    0.7.0.1
 */