package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dix
  extends com.tencent.mm.bx.a
{
  public long CZi;
  public String CZj;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(121106);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.aG(2, this.CZi);
      if (this.CZj != null) {
        paramVarArgs.d(3, this.CZj);
      }
      AppMethodBeat.o(121106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.CZi);
      paramInt = i;
      if (this.CZj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CZj);
      }
      AppMethodBeat.o(121106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(121106);
          throw paramVarArgs;
        }
        AppMethodBeat.o(121106);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dix localdix = (dix)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121106);
          return -1;
        case 1: 
          localdix.key = locala.KhF.readString();
          AppMethodBeat.o(121106);
          return 0;
        case 2: 
          localdix.CZi = locala.KhF.xT();
          AppMethodBeat.o(121106);
          return 0;
        }
        localdix.CZj = locala.KhF.readString();
        AppMethodBeat.o(121106);
        return 0;
      }
      AppMethodBeat.o(121106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */