package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bty
  extends com.tencent.mm.bx.a
{
  public int DRs;
  public String desc;
  public String lmb;
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
      paramVarArgs.aR(3, this.DRs);
      if (this.lmb != null) {
        paramVarArgs.d(4, this.lmb);
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
      i += f.a.a.b.b.a.bA(3, this.DRs);
      paramInt = i;
      if (this.lmb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lmb);
      }
      AppMethodBeat.o(82463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bty localbty = (bty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localbty.scope = locala.KhF.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localbty.desc = locala.KhF.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localbty.DRs = locala.KhF.xS();
          AppMethodBeat.o(82463);
          return 0;
        }
        localbty.lmb = locala.KhF.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bty
 * JD-Core Version:    0.7.0.1
 */