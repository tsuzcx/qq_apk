package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class epi
  extends com.tencent.mm.bx.a
{
  public b ZqS;
  public int abmA;
  public String abtx;
  public int crm;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abtx != null) {
        paramVarArgs.g(1, this.abtx);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.crm);
      paramVarArgs.bS(4, this.abmA);
      if (this.ZqS != null) {
        paramVarArgs.d(5, this.ZqS);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abtx == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = i.a.a.b.b.a.h(1, this.abtx) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.crm) + i.a.a.b.b.a.cJ(4, this.abmA);
      paramInt = i;
      if (this.ZqS != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZqS);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        epi localepi = (epi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localepi.abtx = locala.ajGk.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localepi.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localepi.crm = locala.ajGk.aar();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localepi.abmA = locala.ajGk.aar();
          AppMethodBeat.o(138185);
          return 0;
        }
        localepi.ZqS = locala.ajGk.kFX();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epi
 * JD-Core Version:    0.7.0.1
 */