package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class geq
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public b acch;
  public String appid;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259782);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.bS(2, this.Tqb);
      if (this.acch != null) {
        paramVarArgs.d(3, this.acch);
      }
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      AppMethodBeat.o(259782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Tqb);
      paramInt = i;
      if (this.acch != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.acch);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.path);
      }
      AppMethodBeat.o(259782);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259782);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        geq localgeq = (geq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259782);
          return -1;
        case 1: 
          localgeq.appid = locala.ajGk.readString();
          AppMethodBeat.o(259782);
          return 0;
        case 2: 
          localgeq.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(259782);
          return 0;
        case 3: 
          localgeq.acch = locala.ajGk.kFX();
          AppMethodBeat.o(259782);
          return 0;
        }
        localgeq.path = locala.ajGk.readString();
        AppMethodBeat.o(259782);
        return 0;
      }
      AppMethodBeat.o(259782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.geq
 * JD-Core Version:    0.7.0.1
 */