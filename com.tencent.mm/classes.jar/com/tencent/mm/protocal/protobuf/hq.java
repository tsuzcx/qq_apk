package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class hq
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int lGw;
  public b wup;
  public b wuq;
  public int wur;
  public b wus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58892);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wup != null) {
        paramVarArgs.c(1, this.wup);
      }
      paramVarArgs.aO(2, this.lGw);
      if (this.wuq != null) {
        paramVarArgs.c(3, this.wuq);
      }
      paramVarArgs.aO(4, this.wur);
      if (this.wus != null) {
        paramVarArgs.c(5, this.wus);
      }
      paramVarArgs.aO(6, this.Scene);
      AppMethodBeat.o(58892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wup == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = e.a.a.b.b.a.b(1, this.wup) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.lGw);
      paramInt = i;
      if (this.wuq != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wuq);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wur);
      paramInt = i;
      if (this.wus != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.wus);
      }
      i = e.a.a.b.b.a.bl(6, this.Scene);
      AppMethodBeat.o(58892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58892);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hq localhq = (hq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(58892);
          return -1;
        case 1: 
          localhq.wup = locala.CLY.eqS();
          AppMethodBeat.o(58892);
          return 0;
        case 2: 
          localhq.lGw = locala.CLY.sl();
          AppMethodBeat.o(58892);
          return 0;
        case 3: 
          localhq.wuq = locala.CLY.eqS();
          AppMethodBeat.o(58892);
          return 0;
        case 4: 
          localhq.wur = locala.CLY.sl();
          AppMethodBeat.o(58892);
          return 0;
        case 5: 
          localhq.wus = locala.CLY.eqS();
          AppMethodBeat.o(58892);
          return 0;
        }
        localhq.Scene = locala.CLY.sl();
        AppMethodBeat.o(58892);
        return 0;
      }
      AppMethodBeat.o(58892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hq
 * JD-Core Version:    0.7.0.1
 */