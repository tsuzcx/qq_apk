package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.bx.a
{
  public String content;
  public String dpf;
  public String username;
  public String wPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dpf != null) {
        paramVarArgs.d(2, this.dpf);
      }
      if (this.wPz != null) {
        paramVarArgs.d(3, this.wPz);
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
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dpf);
      }
      i = paramInt;
      if (this.wPz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wPz);
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
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localao.username = locala.NPN.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 2: 
          localao.dpf = locala.NPN.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 3: 
          localao.wPz = locala.NPN.readString();
          AppMethodBeat.o(32101);
          return 0;
        }
        localao.content = locala.NPN.readString();
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