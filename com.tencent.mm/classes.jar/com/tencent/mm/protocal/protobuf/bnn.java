package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnn
  extends com.tencent.mm.bw.a
{
  public int action;
  public String dlQ;
  public String url;
  public String username;
  public String wLU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      paramVarArgs.aR(2, this.action);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.wLU != null) {
        paramVarArgs.d(5, this.wLU);
      }
      AppMethodBeat.o(72510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      paramInt = i;
      if (this.wLU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wLU);
      }
      AppMethodBeat.o(72510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72510);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnn localbnn = (bnn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72510);
          return -1;
        case 1: 
          localbnn.dlQ = locala.LVo.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 2: 
          localbnn.action = locala.LVo.xF();
          AppMethodBeat.o(72510);
          return 0;
        case 3: 
          localbnn.url = locala.LVo.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 4: 
          localbnn.username = locala.LVo.readString();
          AppMethodBeat.o(72510);
          return 0;
        }
        localbnn.wLU = locala.LVo.readString();
        AppMethodBeat.o(72510);
        return 0;
      }
      AppMethodBeat.o(72510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnn
 * JD-Core Version:    0.7.0.1
 */