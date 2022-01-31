package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctr
  extends com.tencent.mm.bv.a
{
  public String ycF;
  public String ycG;
  public LinkedList<String> ycH;
  public int ycI;
  
  public ctr()
  {
    AppMethodBeat.i(102395);
    this.ycH = new LinkedList();
    AppMethodBeat.o(102395);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102396);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ycF != null) {
        paramVarArgs.e(1, this.ycF);
      }
      if (this.ycG != null) {
        paramVarArgs.e(2, this.ycG);
      }
      paramVarArgs.e(3, 1, this.ycH);
      paramVarArgs.aO(4, this.ycI);
      AppMethodBeat.o(102396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ycF == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.ycF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ycG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ycG);
      }
      paramInt = e.a.a.a.c(3, 1, this.ycH);
      int j = e.a.a.b.b.a.bl(4, this.ycI);
      AppMethodBeat.o(102396);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ycH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102396);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ctr localctr = (ctr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102396);
          return -1;
        case 1: 
          localctr.ycF = locala.CLY.readString();
          AppMethodBeat.o(102396);
          return 0;
        case 2: 
          localctr.ycG = locala.CLY.readString();
          AppMethodBeat.o(102396);
          return 0;
        case 3: 
          localctr.ycH.add(locala.CLY.readString());
          AppMethodBeat.o(102396);
          return 0;
        }
        localctr.ycI = locala.CLY.sl();
        AppMethodBeat.o(102396);
        return 0;
      }
      AppMethodBeat.o(102396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctr
 * JD-Core Version:    0.7.0.1
 */