package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eax
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String RXY;
  public int UfR;
  public String UfS;
  public String UfT;
  public String auth_desc;
  public String qDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXY != null) {
        paramVarArgs.f(1, this.RXY);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      paramVarArgs.aY(3, this.UfR);
      if (this.qDz != null) {
        paramVarArgs.f(4, this.qDz);
      }
      if (this.auth_desc != null) {
        paramVarArgs.f(5, this.auth_desc);
      }
      if (this.UfS != null) {
        paramVarArgs.f(6, this.UfS);
      }
      if (this.UfT != null) {
        paramVarArgs.f(7, this.UfT);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXY == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.g(1, this.RXY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMB);
      }
      i += g.a.a.b.b.a.bM(3, this.UfR);
      paramInt = i;
      if (this.qDz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.qDz);
      }
      i = paramInt;
      if (this.auth_desc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.auth_desc);
      }
      paramInt = i;
      if (this.UfS != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UfS);
      }
      i = paramInt;
      if (this.UfT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UfT);
      }
      AppMethodBeat.o(123643);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eax localeax = (eax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localeax.RXY = locala.abFh.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localeax.CMB = locala.abFh.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localeax.UfR = locala.abFh.AK();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localeax.qDz = locala.abFh.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localeax.auth_desc = locala.abFh.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 6: 
          localeax.UfS = locala.abFh.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localeax.UfT = locala.abFh.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eax
 * JD-Core Version:    0.7.0.1
 */