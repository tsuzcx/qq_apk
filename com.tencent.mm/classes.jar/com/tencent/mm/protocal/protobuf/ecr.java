package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecr
  extends com.tencent.mm.bw.a
{
  public int Gih;
  public int Gii;
  public int Gij;
  public int score;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32570);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aR(2, this.score);
      paramVarArgs.aR(3, this.Gih);
      paramVarArgs.aR(4, this.Gii);
      paramVarArgs.aR(5, this.Gij);
      AppMethodBeat.o(32570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.score);
      int j = f.a.a.b.b.a.bx(3, this.Gih);
      int k = f.a.a.b.b.a.bx(4, this.Gii);
      int m = f.a.a.b.b.a.bx(5, this.Gij);
      AppMethodBeat.o(32570);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecr localecr = (ecr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32570);
          return -1;
        case 1: 
          localecr.username = locala.LVo.readString();
          AppMethodBeat.o(32570);
          return 0;
        case 2: 
          localecr.score = locala.LVo.xF();
          AppMethodBeat.o(32570);
          return 0;
        case 3: 
          localecr.Gih = locala.LVo.xF();
          AppMethodBeat.o(32570);
          return 0;
        case 4: 
          localecr.Gii = locala.LVo.xF();
          AppMethodBeat.o(32570);
          return 0;
        }
        localecr.Gij = locala.LVo.xF();
        AppMethodBeat.o(32570);
        return 0;
      }
      AppMethodBeat.o(32570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecr
 * JD-Core Version:    0.7.0.1
 */