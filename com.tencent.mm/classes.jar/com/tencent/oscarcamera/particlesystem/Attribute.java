package com.tencent.oscarcamera.particlesystem;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Attribute
{
  public String mName;
  public Value mValue;
  public int mVarIndex;
  
  public long expression()
  {
    AppMethodBeat.i(81509);
    if (this.mValue != null)
    {
      long l = this.mValue.expression();
      AppMethodBeat.o(81509);
      return l;
    }
    AppMethodBeat.o(81509);
    return -1L;
  }
  
  public double value()
  {
    AppMethodBeat.i(81508);
    if (this.mValue != null)
    {
      double d = this.mValue.value();
      AppMethodBeat.o(81508);
      return d;
    }
    AppMethodBeat.o(81508);
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.Attribute
 * JD-Core Version:    0.7.0.1
 */