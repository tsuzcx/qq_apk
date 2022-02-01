package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class bkj
  extends com.tencent.mm.cd.a
{
  public b DgQ;
  public String MGG;
  public int SVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGG != null) {
        paramVarArgs.f(1, this.MGG);
      }
      paramVarArgs.aY(2, this.SVp);
      if (this.DgQ != null) {
        paramVarArgs.c(3, this.DgQ);
      }
      AppMethodBeat.o(201760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGG == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.MGG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SVp);
      paramInt = i;
      if (this.DgQ != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.DgQ);
      }
      AppMethodBeat.o(201760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(201760);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bkj localbkj = (bkj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(201760);
          return -1;
        case 1: 
          localbkj.MGG = locala.abFh.readString();
          AppMethodBeat.o(201760);
          return 0;
        case 2: 
          localbkj.SVp = locala.abFh.AK();
          AppMethodBeat.o(201760);
          return 0;
        }
        localbkj.DgQ = locala.abFh.iUw();
        AppMethodBeat.o(201760);
        return 0;
      }
      AppMethodBeat.o(201760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkj
 * JD-Core Version:    0.7.0.1
 */