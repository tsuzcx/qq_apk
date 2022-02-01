package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atg
  extends com.tencent.mm.bx.a
{
  public int Avb;
  public long FOi;
  public String ZDJ;
  public String ZDK;
  public String ZDL;
  public String svG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258278);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZDJ != null) {
        paramVarArgs.g(1, this.ZDJ);
      }
      if (this.ZDK != null) {
        paramVarArgs.g(2, this.ZDK);
      }
      if (this.ZDL != null) {
        paramVarArgs.g(3, this.ZDL);
      }
      paramVarArgs.bS(4, this.Avb);
      paramVarArgs.bv(5, this.FOi);
      if (this.svG != null) {
        paramVarArgs.g(6, this.svG);
      }
      AppMethodBeat.o(258278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZDJ == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.b.b.a.h(1, this.ZDJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZDK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZDK);
      }
      i = paramInt;
      if (this.ZDL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZDL);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.Avb) + i.a.a.b.b.a.q(5, this.FOi);
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.svG);
      }
      AppMethodBeat.o(258278);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258278);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        atg localatg = (atg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258278);
          return -1;
        case 1: 
          localatg.ZDJ = locala.ajGk.readString();
          AppMethodBeat.o(258278);
          return 0;
        case 2: 
          localatg.ZDK = locala.ajGk.readString();
          AppMethodBeat.o(258278);
          return 0;
        case 3: 
          localatg.ZDL = locala.ajGk.readString();
          AppMethodBeat.o(258278);
          return 0;
        case 4: 
          localatg.Avb = locala.ajGk.aar();
          AppMethodBeat.o(258278);
          return 0;
        case 5: 
          localatg.FOi = locala.ajGk.aaw();
          AppMethodBeat.o(258278);
          return 0;
        }
        localatg.svG = locala.ajGk.readString();
        AppMethodBeat.o(258278);
        return 0;
      }
      AppMethodBeat.o(258278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atg
 * JD-Core Version:    0.7.0.1
 */