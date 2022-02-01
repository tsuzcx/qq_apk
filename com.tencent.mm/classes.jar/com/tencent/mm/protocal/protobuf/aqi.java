package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class aqi
  extends com.tencent.mm.bw.a
{
  public int GHf;
  public int GHg;
  public b GHh;
  public String cUB;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.cUB != null) {
        paramVarArgs.d(1, this.cUB);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      paramVarArgs.aS(3, this.GHf);
      paramVarArgs.aS(4, this.GHg);
      if (this.GHh != null) {
        paramVarArgs.c(5, this.GHh);
      }
      AppMethodBeat.o(195196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cUB == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.cUB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GHf) + f.a.a.b.b.a.bz(4, this.GHg);
      paramInt = i;
      if (this.GHh != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.GHh);
      }
      AppMethodBeat.o(195196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(195196);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqi localaqi = (aqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195196);
          return -1;
        case 1: 
          localaqi.cUB = locala.OmT.readString();
          AppMethodBeat.o(195196);
          return 0;
        case 2: 
          localaqi.sessionId = locala.OmT.readString();
          AppMethodBeat.o(195196);
          return 0;
        case 3: 
          localaqi.GHf = locala.OmT.zc();
          AppMethodBeat.o(195196);
          return 0;
        case 4: 
          localaqi.GHg = locala.OmT.zc();
          AppMethodBeat.o(195196);
          return 0;
        }
        localaqi.GHh = locala.OmT.gCk();
        AppMethodBeat.o(195196);
        return 0;
      }
      AppMethodBeat.o(195196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqi
 * JD-Core Version:    0.7.0.1
 */