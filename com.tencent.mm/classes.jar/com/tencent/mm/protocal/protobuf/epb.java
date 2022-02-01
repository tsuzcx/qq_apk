package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class epb
  extends com.tencent.mm.bw.a
{
  public long LmC;
  public String LmD;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121106);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(121106);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      paramVarArgs.bb(2, this.LmC);
      if (this.LmD != null) {
        paramVarArgs.e(3, this.LmD);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LmC);
      paramInt = i;
      if (this.LmD != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LmD);
      }
      AppMethodBeat.o(121106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        epb localepb = (epb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121106);
          return -1;
        case 1: 
          localepb.key = locala.UbS.readString();
          AppMethodBeat.o(121106);
          return 0;
        case 2: 
          localepb.LmC = locala.UbS.zl();
          AppMethodBeat.o(121106);
          return 0;
        }
        localepb.LmD = locala.UbS.readString();
        AppMethodBeat.o(121106);
        return 0;
      }
      AppMethodBeat.o(121106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epb
 * JD-Core Version:    0.7.0.1
 */