package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byp
  extends com.tencent.mm.bw.a
{
  public int FnK;
  public String desc;
  public String lLR;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82463);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.aR(3, this.FnK);
      if (this.lLR != null) {
        paramVarArgs.d(4, this.lLR);
      }
      AppMethodBeat.o(82463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.b.b.a.bx(3, this.FnK);
      paramInt = i;
      if (this.lLR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lLR);
      }
      AppMethodBeat.o(82463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byp localbyp = (byp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localbyp.scope = locala.LVo.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localbyp.desc = locala.LVo.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localbyp.FnK = locala.LVo.xF();
          AppMethodBeat.o(82463);
          return 0;
        }
        localbyp.lLR = locala.LVo.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */