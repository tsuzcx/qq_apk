package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aal
  extends com.tencent.mm.bw.a
{
  public int FQb;
  public String FQc;
  public int GrH;
  public int GrI;
  public int count;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQc != null) {
        paramVarArgs.d(1, this.FQc);
      }
      paramVarArgs.aS(2, this.FQb);
      paramVarArgs.aS(3, this.GrH);
      paramVarArgs.aS(4, this.GrI);
      paramVarArgs.aS(5, this.scene);
      paramVarArgs.aS(6, this.count);
      AppMethodBeat.o(103205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQc == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.FQc) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FQb);
      int j = f.a.a.b.b.a.bz(3, this.GrH);
      int k = f.a.a.b.b.a.bz(4, this.GrI);
      int m = f.a.a.b.b.a.bz(5, this.scene);
      int n = f.a.a.b.b.a.bz(6, this.count);
      AppMethodBeat.o(103205);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103205);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aal localaal = (aal)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103205);
          return -1;
        case 1: 
          localaal.FQc = locala.OmT.readString();
          AppMethodBeat.o(103205);
          return 0;
        case 2: 
          localaal.FQb = locala.OmT.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 3: 
          localaal.GrH = locala.OmT.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 4: 
          localaal.GrI = locala.OmT.zc();
          AppMethodBeat.o(103205);
          return 0;
        case 5: 
          localaal.scene = locala.OmT.zc();
          AppMethodBeat.o(103205);
          return 0;
        }
        localaal.count = locala.OmT.zc();
        AppMethodBeat.o(103205);
        return 0;
      }
      AppMethodBeat.o(103205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aal
 * JD-Core Version:    0.7.0.1
 */