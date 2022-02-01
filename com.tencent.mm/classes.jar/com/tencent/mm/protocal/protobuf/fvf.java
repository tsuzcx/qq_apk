package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvf
  extends com.tencent.mm.bx.a
{
  public int abTD;
  public String city;
  public float latitude;
  public float longitude;
  public String province;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258716);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.longitude);
      paramVarArgs.l(2, this.latitude);
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      if (this.province != null) {
        paramVarArgs.g(8, this.province);
      }
      paramVarArgs.bS(9, this.abTD);
      AppMethodBeat.o(258716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4);
      paramInt = i;
      if (this.city != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.city);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.province);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.abTD);
      AppMethodBeat.o(258716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258716);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fvf localfvf = (fvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        AppMethodBeat.o(258716);
        return -1;
      case 1: 
        localfvf.longitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258716);
        return 0;
      case 2: 
        localfvf.latitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258716);
        return 0;
      case 3: 
        localfvf.city = locala.ajGk.readString();
        AppMethodBeat.o(258716);
        return 0;
      case 8: 
        localfvf.province = locala.ajGk.readString();
        AppMethodBeat.o(258716);
        return 0;
      }
      localfvf.abTD = locala.ajGk.aar();
      AppMethodBeat.o(258716);
      return 0;
    }
    AppMethodBeat.o(258716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvf
 * JD-Core Version:    0.7.0.1
 */