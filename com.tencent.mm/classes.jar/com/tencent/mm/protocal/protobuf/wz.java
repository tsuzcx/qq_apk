package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wz
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Err;
  public com.tencent.mm.bw.b Ers;
  public int dataType;
  public int status;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Err == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Ers == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Err != null) {
        paramVarArgs.c(1, this.Err);
      }
      paramVarArgs.aR(2, this.type);
      if (this.Ers != null) {
        paramVarArgs.c(3, this.Ers);
      }
      paramVarArgs.aO(4, this.timestamp);
      paramVarArgs.aR(5, this.dataType);
      paramVarArgs.aR(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Err == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.b(1, this.Err) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.Ers != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Ers);
      }
      i = f.a.a.b.b.a.p(4, this.timestamp);
      int j = f.a.a.b.b.a.bx(5, this.dataType);
      int k = f.a.a.b.b.a.bx(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Err == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.Ers == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(145667);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wz localwz = (wz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localwz.Err = locala.LVo.gfk();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localwz.type = locala.LVo.xF();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localwz.Ers = locala.LVo.gfk();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localwz.timestamp = locala.LVo.xG();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localwz.dataType = locala.LVo.xF();
          AppMethodBeat.o(145667);
          return 0;
        }
        localwz.status = locala.LVo.xF();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wz
 * JD-Core Version:    0.7.0.1
 */