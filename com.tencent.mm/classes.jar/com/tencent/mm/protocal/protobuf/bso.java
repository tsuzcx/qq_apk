package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bso
  extends com.tencent.mm.bx.a
{
  public float aaas;
  public float aaat;
  public int aaau;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(8, this.longitude);
      paramVarArgs.l(9, this.latitude);
      paramVarArgs.l(10, this.aaas);
      paramVarArgs.l(11, this.aaat);
      paramVarArgs.bS(12, this.aaau);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(8);
      int i = i.a.a.b.b.a.ko(9);
      int j = i.a.a.b.b.a.ko(10);
      int k = i.a.a.b.b.a.ko(11);
      int m = i.a.a.b.b.a.cJ(12, this.aaau);
      AppMethodBeat.o(169035);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bso localbso = (bso)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localbso.longitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localbso.latitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localbso.aaas = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localbso.aaat = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(169035);
        return 0;
      }
      localbso.aaau = locala.ajGk.aar();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bso
 * JD-Core Version:    0.7.0.1
 */