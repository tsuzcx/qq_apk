package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eet
  extends com.tencent.mm.bx.a
{
  public float MpO;
  public float abkn;
  public float abko;
  public float abkp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259851);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.MpO);
      paramVarArgs.l(2, this.abkn);
      paramVarArgs.l(3, this.abko);
      paramVarArgs.l(4, this.abkp);
      AppMethodBeat.o(259851);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259851);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259851);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eet localeet = (eet)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259851);
        return -1;
      case 1: 
        localeet.MpO = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259851);
        return 0;
      case 2: 
        localeet.abkn = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259851);
        return 0;
      case 3: 
        localeet.abko = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259851);
        return 0;
      }
      localeet.abkp = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(259851);
      return 0;
    }
    AppMethodBeat.o(259851);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eet
 * JD-Core Version:    0.7.0.1
 */