package com.tencent.wxhld.info;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Candidate
{
  public String comment;
  public byte[] id;
  public int id_len;
  public String text;
  
  public Candidate(int paramInt)
  {
    AppMethodBeat.i(212300);
    this.id_len = paramInt;
    this.id = new byte[this.id_len];
    AppMethodBeat.o(212300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxhld.info.Candidate
 * JD-Core Version:    0.7.0.1
 */