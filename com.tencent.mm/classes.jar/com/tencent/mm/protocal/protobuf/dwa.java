package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dwa
  extends com.tencent.mm.bx.a
{
  public int CRV;
  public int abbK;
  public int abbL;
  public boolean abbM;
  public String finderUsername;
  public String hJW;
  public String hLv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258672);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abbK);
      if (this.finderUsername != null) {
        paramVarArgs.g(2, this.finderUsername);
      }
      if (this.hLv != null) {
        paramVarArgs.g(3, this.hLv);
      }
      if (this.hJW != null) {
        paramVarArgs.g(4, this.hJW);
      }
      paramVarArgs.bS(5, this.abbL);
      paramVarArgs.di(6, this.abbM);
      paramVarArgs.bS(7, this.CRV);
      AppMethodBeat.o(258672);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abbK) + 0;
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.finderUsername);
      }
      i = paramInt;
      if (this.hLv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hLv);
      }
      paramInt = i;
      if (this.hJW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hJW);
      }
      i = i.a.a.b.b.a.cJ(5, this.abbL);
      int j = i.a.a.b.b.a.ko(6);
      int k = i.a.a.b.b.a.cJ(7, this.CRV);
      AppMethodBeat.o(258672);
      return paramInt + i + (j + 1) + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258672);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dwa localdwa = (dwa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258672);
        return -1;
      case 1: 
        localdwa.abbK = locala.ajGk.aar();
        AppMethodBeat.o(258672);
        return 0;
      case 2: 
        localdwa.finderUsername = locala.ajGk.readString();
        AppMethodBeat.o(258672);
        return 0;
      case 3: 
        localdwa.hLv = locala.ajGk.readString();
        AppMethodBeat.o(258672);
        return 0;
      case 4: 
        localdwa.hJW = locala.ajGk.readString();
        AppMethodBeat.o(258672);
        return 0;
      case 5: 
        localdwa.abbL = locala.ajGk.aar();
        AppMethodBeat.o(258672);
        return 0;
      case 6: 
        localdwa.abbM = locala.ajGk.aai();
        AppMethodBeat.o(258672);
        return 0;
      }
      localdwa.CRV = locala.ajGk.aar();
      AppMethodBeat.o(258672);
      return 0;
    }
    AppMethodBeat.o(258672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwa
 * JD-Core Version:    0.7.0.1
 */