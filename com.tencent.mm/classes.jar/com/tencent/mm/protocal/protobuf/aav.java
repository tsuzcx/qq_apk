package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aav
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b Sng;
  public com.tencent.mm.cd.b Snh;
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
      if (this.Sng == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Snh == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Sng != null) {
        paramVarArgs.c(1, this.Sng);
      }
      paramVarArgs.aY(2, this.type);
      if (this.Snh != null) {
        paramVarArgs.c(3, this.Snh);
      }
      paramVarArgs.bm(4, this.timestamp);
      paramVarArgs.aY(5, this.dataType);
      paramVarArgs.aY(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sng == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.b.b.a.b(1, this.Sng) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.Snh != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.Snh);
      }
      i = g.a.a.b.b.a.p(4, this.timestamp);
      int j = g.a.a.b.b.a.bM(5, this.dataType);
      int k = g.a.a.b.b.a.bM(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Sng == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.Snh == null)
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
        aav localaav = (aav)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localaav.Sng = locala.abFh.iUw();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localaav.type = locala.abFh.AK();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localaav.Snh = locala.abFh.iUw();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localaav.timestamp = locala.abFh.AN();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localaav.dataType = locala.abFh.AK();
          AppMethodBeat.o(145667);
          return 0;
        }
        localaav.status = locala.abFh.AK();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aav
 * JD-Core Version:    0.7.0.1
 */