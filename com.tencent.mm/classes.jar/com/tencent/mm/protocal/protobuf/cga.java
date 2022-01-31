package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cga
  extends com.tencent.mm.bv.a
{
  public String appName;
  public int brG;
  public String xQL;
  public boolean xQM;
  public boolean xQN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55723);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQL != null) {
        paramVarArgs.e(1, this.xQL);
      }
      if (this.appName != null) {
        paramVarArgs.e(2, this.appName);
      }
      paramVarArgs.aO(3, this.brG);
      paramVarArgs.aS(4, this.xQM);
      paramVarArgs.aS(5, this.xQN);
      AppMethodBeat.o(55723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xQL == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = e.a.a.b.b.a.f(1, this.xQL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.appName);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.brG);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(55723);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55723);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cga localcga = (cga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55723);
          return -1;
        case 1: 
          localcga.xQL = locala.CLY.readString();
          AppMethodBeat.o(55723);
          return 0;
        case 2: 
          localcga.appName = locala.CLY.readString();
          AppMethodBeat.o(55723);
          return 0;
        case 3: 
          localcga.brG = locala.CLY.sl();
          AppMethodBeat.o(55723);
          return 0;
        case 4: 
          localcga.xQM = locala.CLY.emu();
          AppMethodBeat.o(55723);
          return 0;
        }
        localcga.xQN = locala.CLY.emu();
        AppMethodBeat.o(55723);
        return 0;
      }
      AppMethodBeat.o(55723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cga
 * JD-Core Version:    0.7.0.1
 */