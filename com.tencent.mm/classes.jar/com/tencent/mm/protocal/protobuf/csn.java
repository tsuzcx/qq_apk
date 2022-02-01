package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csn
  extends com.tencent.mm.bx.a
{
  public int CLl;
  public String dyc;
  public int nvh;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      paramVarArgs.aR(2, this.nvh);
      paramVarArgs.aR(3, this.CLl);
      paramVarArgs.aG(4, this.seq);
      AppMethodBeat.o(114074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyc) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.nvh);
      int j = f.a.a.b.b.a.bA(3, this.CLl);
      int k = f.a.a.b.b.a.q(4, this.seq);
      AppMethodBeat.o(114074);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114074);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csn localcsn = (csn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114074);
          return -1;
        case 1: 
          localcsn.dyc = locala.KhF.readString();
          AppMethodBeat.o(114074);
          return 0;
        case 2: 
          localcsn.nvh = locala.KhF.xS();
          AppMethodBeat.o(114074);
          return 0;
        case 3: 
          localcsn.CLl = locala.KhF.xS();
          AppMethodBeat.o(114074);
          return 0;
        }
        localcsn.seq = locala.KhF.xT();
        AppMethodBeat.o(114074);
        return 0;
      }
      AppMethodBeat.o(114074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csn
 * JD-Core Version:    0.7.0.1
 */