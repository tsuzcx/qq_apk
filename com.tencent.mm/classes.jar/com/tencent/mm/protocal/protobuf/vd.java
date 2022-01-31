package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vd
  extends com.tencent.mm.bv.a
{
  public String wKH;
  public LinkedList<Integer> wNF;
  
  public vd()
  {
    AppMethodBeat.i(28366);
    this.wNF = new LinkedList();
    AppMethodBeat.o(28366);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28367);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wKH != null) {
        paramVarArgs.e(1, this.wKH);
      }
      paramVarArgs.e(2, 2, this.wNF);
      AppMethodBeat.o(28367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wKH == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = e.a.a.b.b.a.f(1, this.wKH) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 2, this.wNF);
      AppMethodBeat.o(28367);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wNF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28367);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        vd localvd = (vd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28367);
          return -1;
        case 1: 
          localvd.wKH = locala.CLY.readString();
          AppMethodBeat.o(28367);
          return 0;
        }
        localvd.wNF.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(28367);
        return 0;
      }
      AppMethodBeat.o(28367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vd
 * JD-Core Version:    0.7.0.1
 */