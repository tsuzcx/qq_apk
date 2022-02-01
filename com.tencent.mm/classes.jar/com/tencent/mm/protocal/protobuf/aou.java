package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aou
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int IMf;
  public int YYF;
  public String Zuw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91446);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      paramVarArgs.bS(2, this.YYF);
      if (this.Zuw != null) {
        paramVarArgs.g(3, this.Zuw);
      }
      paramVarArgs.bS(4, this.IMf);
      AppMethodBeat.o(91446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YYF);
      paramInt = i;
      if (this.Zuw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zuw);
      }
      i = i.a.a.b.b.a.cJ(4, this.IMf);
      AppMethodBeat.o(91446);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91446);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aou localaou = (aou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91446);
          return -1;
        case 1: 
          localaou.IGU = locala.ajGk.readString();
          AppMethodBeat.o(91446);
          return 0;
        case 2: 
          localaou.YYF = locala.ajGk.aar();
          AppMethodBeat.o(91446);
          return 0;
        case 3: 
          localaou.Zuw = locala.ajGk.readString();
          AppMethodBeat.o(91446);
          return 0;
        }
        localaou.IMf = locala.ajGk.aar();
        AppMethodBeat.o(91446);
        return 0;
      }
      AppMethodBeat.o(91446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aou
 * JD-Core Version:    0.7.0.1
 */