package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aaq
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b LlW;
  public com.tencent.mm.bw.b LlX;
  public int dataType;
  public int status;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LlW == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.LlX == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.LlW != null) {
        paramVarArgs.c(1, this.LlW);
      }
      paramVarArgs.aM(2, this.type);
      if (this.LlX != null) {
        paramVarArgs.c(3, this.LlX);
      }
      paramVarArgs.bb(4, this.timestamp);
      paramVarArgs.aM(5, this.dataType);
      paramVarArgs.aM(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LlW == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.b.b.a.b(1, this.LlW) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.LlX != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LlX);
      }
      i = g.a.a.b.b.a.r(4, this.timestamp);
      int j = g.a.a.b.b.a.bu(5, this.dataType);
      int k = g.a.a.b.b.a.bu(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LlW == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.LlX == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: clientcheckdata");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(145667);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aaq localaaq = (aaq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localaaq.LlW = locala.UbS.hPo();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localaaq.type = locala.UbS.zi();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localaaq.LlX = locala.UbS.hPo();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localaaq.timestamp = locala.UbS.zl();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localaaq.dataType = locala.UbS.zi();
          AppMethodBeat.o(145667);
          return 0;
        }
        localaaq.status = locala.UbS.zi();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaq
 * JD-Core Version:    0.7.0.1
 */