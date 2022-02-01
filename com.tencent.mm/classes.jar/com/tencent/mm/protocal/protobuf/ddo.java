package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ddo
  extends com.tencent.mm.bw.a
{
  public String yaF;
  public int yaG;
  public String yaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(118441);
        throw paramVarArgs;
      }
      if (this.yaF != null) {
        paramVarArgs.d(1, this.yaF);
      }
      paramVarArgs.aR(2, this.yaG);
      if (this.yaH != null) {
        paramVarArgs.d(3, this.yaH);
      }
      AppMethodBeat.o(118441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yaF == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.yaF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.yaG);
      paramInt = i;
      if (this.yaH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.yaH);
      }
      AppMethodBeat.o(118441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.yaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(118441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118441);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddo localddo = (ddo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118441);
          return -1;
        case 1: 
          localddo.yaF = locala.LVo.readString();
          AppMethodBeat.o(118441);
          return 0;
        case 2: 
          localddo.yaG = locala.LVo.xF();
          AppMethodBeat.o(118441);
          return 0;
        }
        localddo.yaH = locala.LVo.readString();
        AppMethodBeat.o(118441);
        return 0;
      }
      AppMethodBeat.o(118441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddo
 * JD-Core Version:    0.7.0.1
 */