package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cae
  extends com.tencent.mm.bx.a
{
  public String VDK;
  public String VDL;
  public String VDM;
  public long aaje;
  public int aajf;
  public double aajg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaje);
      paramVarArgs.bS(2, this.aajf);
      paramVarArgs.d(3, this.aajg);
      if (this.VDK != null) {
        paramVarArgs.g(4, this.VDK);
      }
      if (this.VDL != null) {
        paramVarArgs.g(5, this.VDL);
      }
      if (this.VDM != null) {
        paramVarArgs.g(6, this.VDM);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaje) + 0 + i.a.a.b.b.a.cJ(2, this.aajf) + (i.a.a.b.b.a.ko(3) + 8);
      paramInt = i;
      if (this.VDK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VDK);
      }
      i = paramInt;
      if (this.VDL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VDL);
      }
      paramInt = i;
      if (this.VDM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.VDM);
      }
      AppMethodBeat.o(91470);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cae localcae = (cae)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localcae.aaje = locala.ajGk.aaw();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localcae.aajf = locala.ajGk.aar();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localcae.aajg = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localcae.VDK = locala.ajGk.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localcae.VDL = locala.ajGk.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localcae.VDM = locala.ajGk.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cae
 * JD-Core Version:    0.7.0.1
 */