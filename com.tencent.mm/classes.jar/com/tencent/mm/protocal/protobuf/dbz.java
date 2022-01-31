package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dbz
  extends com.tencent.mm.bv.a
{
  public int score;
  public String username;
  public int yih;
  public int yii;
  public int yij;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28771);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(28771);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aO(2, this.score);
      paramVarArgs.aO(3, this.yih);
      paramVarArgs.aO(4, this.yii);
      paramVarArgs.aO(5, this.yij);
      AppMethodBeat.o(28771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.score);
      int j = e.a.a.b.b.a.bl(3, this.yih);
      int k = e.a.a.b.b.a.bl(4, this.yii);
      int m = e.a.a.b.b.a.bl(5, this.yij);
      AppMethodBeat.o(28771);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(28771);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28771);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dbz localdbz = (dbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28771);
          return -1;
        case 1: 
          localdbz.username = locala.CLY.readString();
          AppMethodBeat.o(28771);
          return 0;
        case 2: 
          localdbz.score = locala.CLY.sl();
          AppMethodBeat.o(28771);
          return 0;
        case 3: 
          localdbz.yih = locala.CLY.sl();
          AppMethodBeat.o(28771);
          return 0;
        case 4: 
          localdbz.yii = locala.CLY.sl();
          AppMethodBeat.o(28771);
          return 0;
        }
        localdbz.yij = locala.CLY.sl();
        AppMethodBeat.o(28771);
        return 0;
      }
      AppMethodBeat.o(28771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbz
 * JD-Core Version:    0.7.0.1
 */