package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akg
  extends com.tencent.mm.bw.a
{
  public int KZx;
  public String Name;
  public String PriceType;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91446);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      paramVarArgs.aM(2, this.KZx);
      if (this.PriceType != null) {
        paramVarArgs.e(3, this.PriceType);
      }
      paramVarArgs.aM(4, this.xNF);
      AppMethodBeat.o(91446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KZx);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.PriceType);
      }
      i = g.a.a.b.b.a.bu(4, this.xNF);
      AppMethodBeat.o(91446);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91446);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akg localakg = (akg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91446);
          return -1;
        case 1: 
          localakg.Name = locala.UbS.readString();
          AppMethodBeat.o(91446);
          return 0;
        case 2: 
          localakg.KZx = locala.UbS.zi();
          AppMethodBeat.o(91446);
          return 0;
        case 3: 
          localakg.PriceType = locala.UbS.readString();
          AppMethodBeat.o(91446);
          return 0;
        }
        localakg.xNF = locala.UbS.zi();
        AppMethodBeat.o(91446);
        return 0;
      }
      AppMethodBeat.o(91446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akg
 * JD-Core Version:    0.7.0.1
 */