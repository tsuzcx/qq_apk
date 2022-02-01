package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String content;
  public String ddJ;
  public String username;
  public String vIs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(2, this.ddJ);
      }
      if (this.vIs != null) {
        paramVarArgs.d(3, this.vIs);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      AppMethodBeat.o(32101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label404;
      }
    }
    label404:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ddJ);
      }
      i = paramInt;
      if (this.vIs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vIs);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      AppMethodBeat.o(32101);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32101);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32101);
          return -1;
        case 1: 
          localao.username = locala.LVo.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 2: 
          localao.ddJ = locala.LVo.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 3: 
          localao.vIs = locala.LVo.readString();
          AppMethodBeat.o(32101);
          return 0;
        }
        localao.content = locala.LVo.readString();
        AppMethodBeat.o(32101);
        return 0;
      }
      AppMethodBeat.o(32101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ao
 * JD-Core Version:    0.7.0.1
 */