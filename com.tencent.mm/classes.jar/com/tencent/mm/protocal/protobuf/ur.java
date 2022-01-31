package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ur
  extends com.tencent.mm.bv.a
{
  public int count;
  public int scene;
  public int wMP;
  public int wMQ;
  public int wqK;
  public String wys;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14723);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wys != null) {
        paramVarArgs.e(1, this.wys);
      }
      paramVarArgs.aO(2, this.wqK);
      paramVarArgs.aO(3, this.wMP);
      paramVarArgs.aO(4, this.wMQ);
      paramVarArgs.aO(5, this.scene);
      paramVarArgs.aO(6, this.count);
      AppMethodBeat.o(14723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wys == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.b.b.a.f(1, this.wys) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wqK);
      int j = e.a.a.b.b.a.bl(3, this.wMP);
      int k = e.a.a.b.b.a.bl(4, this.wMQ);
      int m = e.a.a.b.b.a.bl(5, this.scene);
      int n = e.a.a.b.b.a.bl(6, this.count);
      AppMethodBeat.o(14723);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14723);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ur localur = (ur)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14723);
          return -1;
        case 1: 
          localur.wys = locala.CLY.readString();
          AppMethodBeat.o(14723);
          return 0;
        case 2: 
          localur.wqK = locala.CLY.sl();
          AppMethodBeat.o(14723);
          return 0;
        case 3: 
          localur.wMP = locala.CLY.sl();
          AppMethodBeat.o(14723);
          return 0;
        case 4: 
          localur.wMQ = locala.CLY.sl();
          AppMethodBeat.o(14723);
          return 0;
        case 5: 
          localur.scene = locala.CLY.sl();
          AppMethodBeat.o(14723);
          return 0;
        }
        localur.count = locala.CLY.sl();
        AppMethodBeat.o(14723);
        return 0;
      }
      AppMethodBeat.o(14723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ur
 * JD-Core Version:    0.7.0.1
 */