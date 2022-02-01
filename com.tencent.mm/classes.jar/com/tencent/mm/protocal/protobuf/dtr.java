package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtr
  extends com.tencent.mm.bx.a
{
  public String scope;
  public int state;
  public String yDs;
  public int yDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.yDs != null) {
        paramVarArgs.d(2, this.yDs);
      }
      paramVarArgs.aS(3, this.state);
      paramVarArgs.aS(4, this.yDt);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yDs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yDs);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.state);
      int j = f.a.a.b.b.a.bz(4, this.yDt);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtr localdtr = (dtr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localdtr.scope = locala.NPN.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localdtr.yDs = locala.NPN.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localdtr.state = locala.NPN.zc();
          AppMethodBeat.o(74674);
          return 0;
        }
        localdtr.yDt = locala.NPN.zc();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtr
 * JD-Core Version:    0.7.0.1
 */