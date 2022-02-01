package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeq
  extends com.tencent.mm.bx.a
{
  public String GcB;
  public String GcC;
  public String kcQ;
  public String model;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.kcQ != null) {
        paramVarArgs.d(1, this.kcQ);
      }
      if (this.model != null) {
        paramVarArgs.d(2, this.model);
      }
      if (this.GcB != null) {
        paramVarArgs.d(3, this.GcB);
      }
      if (this.GcC != null) {
        paramVarArgs.d(4, this.GcC);
      }
      AppMethodBeat.o(210578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kcQ == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.kcQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.model != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.model);
      }
      i = paramInt;
      if (this.GcB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GcB);
      }
      paramInt = i;
      if (this.GcC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GcC);
      }
      AppMethodBeat.o(210578);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210578);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aeq localaeq = (aeq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210578);
          return -1;
        case 1: 
          localaeq.kcQ = locala.NPN.readString();
          AppMethodBeat.o(210578);
          return 0;
        case 2: 
          localaeq.model = locala.NPN.readString();
          AppMethodBeat.o(210578);
          return 0;
        case 3: 
          localaeq.GcB = locala.NPN.readString();
          AppMethodBeat.o(210578);
          return 0;
        }
        localaeq.GcC = locala.NPN.readString();
        AppMethodBeat.o(210578);
        return 0;
      }
      AppMethodBeat.o(210578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeq
 * JD-Core Version:    0.7.0.1
 */