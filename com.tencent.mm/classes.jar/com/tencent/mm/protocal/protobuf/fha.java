package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fha
  extends com.tencent.mm.bx.a
{
  public String abHs;
  public int abHt;
  public boolean abHu;
  public boolean abHv;
  public String appName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abHs != null) {
        paramVarArgs.g(1, this.abHs);
      }
      if (this.appName != null) {
        paramVarArgs.g(2, this.appName);
      }
      paramVarArgs.bS(3, this.abHt);
      paramVarArgs.di(4, this.abHu);
      paramVarArgs.di(5, this.abHv);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abHs == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = i.a.a.b.b.a.h(1, this.abHs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appName);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abHt);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(116816);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fha localfha = (fha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localfha.abHs = locala.ajGk.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localfha.appName = locala.ajGk.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localfha.abHt = locala.ajGk.aar();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localfha.abHu = locala.ajGk.aai();
          AppMethodBeat.o(116816);
          return 0;
        }
        localfha.abHv = locala.ajGk.aai();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fha
 * JD-Core Version:    0.7.0.1
 */