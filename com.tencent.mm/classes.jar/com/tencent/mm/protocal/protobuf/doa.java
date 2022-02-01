package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doa
  extends com.tencent.mm.bw.a
{
  public String scope;
  public int state;
  public String xoN;
  public int xoO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.xoN != null) {
        paramVarArgs.d(2, this.xoN);
      }
      paramVarArgs.aR(3, this.state);
      paramVarArgs.aR(4, this.xoO);
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
      if (this.xoN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xoN);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.state);
      int j = f.a.a.b.b.a.bx(4, this.xoO);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doa localdoa = (doa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localdoa.scope = locala.LVo.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localdoa.xoN = locala.LVo.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localdoa.state = locala.LVo.xF();
          AppMethodBeat.o(74674);
          return 0;
        }
        localdoa.xoO = locala.LVo.xF();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doa
 * JD-Core Version:    0.7.0.1
 */