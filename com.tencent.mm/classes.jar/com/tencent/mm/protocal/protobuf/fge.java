package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fge
  extends com.tencent.mm.bx.a
{
  public String abGa;
  public String abGb;
  public String abGc;
  public int abGd;
  public String abGe;
  public String abGf;
  public String abGg;
  public String pSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257898);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pSi != null) {
        paramVarArgs.g(1, this.pSi);
      }
      if (this.abGa != null) {
        paramVarArgs.g(2, this.abGa);
      }
      paramVarArgs.bS(3, this.abGd);
      if (this.abGb != null) {
        paramVarArgs.g(4, this.abGb);
      }
      if (this.abGe != null) {
        paramVarArgs.g(5, this.abGe);
      }
      if (this.abGf != null) {
        paramVarArgs.g(6, this.abGf);
      }
      if (this.abGg != null) {
        paramVarArgs.g(7, this.abGg);
      }
      if (this.abGc != null) {
        paramVarArgs.g(8, this.abGc);
      }
      AppMethodBeat.o(257898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pSi == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = i.a.a.b.b.a.h(1, this.pSi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abGa != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abGa);
      }
      i += i.a.a.b.b.a.cJ(3, this.abGd);
      paramInt = i;
      if (this.abGb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abGb);
      }
      i = paramInt;
      if (this.abGe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abGe);
      }
      paramInt = i;
      if (this.abGf != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abGf);
      }
      i = paramInt;
      if (this.abGg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abGg);
      }
      paramInt = i;
      if (this.abGc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abGc);
      }
      AppMethodBeat.o(257898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257898);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fge localfge = (fge)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257898);
          return -1;
        case 1: 
          localfge.pSi = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        case 2: 
          localfge.abGa = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        case 3: 
          localfge.abGd = locala.ajGk.aar();
          AppMethodBeat.o(257898);
          return 0;
        case 4: 
          localfge.abGb = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        case 5: 
          localfge.abGe = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        case 6: 
          localfge.abGf = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        case 7: 
          localfge.abGg = locala.ajGk.readString();
          AppMethodBeat.o(257898);
          return 0;
        }
        localfge.abGc = locala.ajGk.readString();
        AppMethodBeat.o(257898);
        return 0;
      }
      AppMethodBeat.o(257898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fge
 * JD-Core Version:    0.7.0.1
 */