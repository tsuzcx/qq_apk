package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eff
  extends com.tencent.mm.bx.a
{
  public String Krl;
  public String VmH;
  public int aaCD;
  public String aawp;
  public String abkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aawp != null) {
        paramVarArgs.g(1, this.aawp);
      }
      if (this.abkC != null) {
        paramVarArgs.g(2, this.abkC);
      }
      if (this.VmH != null) {
        paramVarArgs.g(3, this.VmH);
      }
      if (this.Krl != null) {
        paramVarArgs.g(4, this.Krl);
      }
      paramVarArgs.bS(5, this.aaCD);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aawp == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.aawp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abkC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abkC);
      }
      i = paramInt;
      if (this.VmH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VmH);
      }
      paramInt = i;
      if (this.Krl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Krl);
      }
      i = i.a.a.b.b.a.cJ(5, this.aaCD);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eff localeff = (eff)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localeff.aawp = locala.ajGk.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localeff.abkC = locala.ajGk.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localeff.VmH = locala.ajGk.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localeff.Krl = locala.ajGk.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localeff.aaCD = locala.ajGk.aar();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eff
 * JD-Core Version:    0.7.0.1
 */