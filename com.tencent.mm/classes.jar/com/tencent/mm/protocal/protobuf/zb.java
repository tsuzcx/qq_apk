package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zb
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Gra;
  public com.tencent.mm.bw.b Grb;
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
      if (this.Gra == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: version");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Grb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientcheckdata");
        AppMethodBeat.o(145667);
        throw paramVarArgs;
      }
      if (this.Gra != null) {
        paramVarArgs.c(1, this.Gra);
      }
      paramVarArgs.aS(2, this.type);
      if (this.Grb != null) {
        paramVarArgs.c(3, this.Grb);
      }
      paramVarArgs.aZ(4, this.timestamp);
      paramVarArgs.aS(5, this.dataType);
      paramVarArgs.aS(6, this.status);
      AppMethodBeat.o(145667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gra == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.b(1, this.Gra) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.Grb != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Grb);
      }
      i = f.a.a.b.b.a.p(4, this.timestamp);
      int j = f.a.a.b.b.a.bz(5, this.dataType);
      int k = f.a.a.b.b.a.bz(6, this.status);
      AppMethodBeat.o(145667);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gra == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: version");
          AppMethodBeat.o(145667);
          throw paramVarArgs;
        }
        if (this.Grb == null)
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
        zb localzb = (zb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145667);
          return -1;
        case 1: 
          localzb.Gra = locala.OmT.gCk();
          AppMethodBeat.o(145667);
          return 0;
        case 2: 
          localzb.type = locala.OmT.zc();
          AppMethodBeat.o(145667);
          return 0;
        case 3: 
          localzb.Grb = locala.OmT.gCk();
          AppMethodBeat.o(145667);
          return 0;
        case 4: 
          localzb.timestamp = locala.OmT.zd();
          AppMethodBeat.o(145667);
          return 0;
        case 5: 
          localzb.dataType = locala.OmT.zc();
          AppMethodBeat.o(145667);
          return 0;
        }
        localzb.status = locala.OmT.zc();
        AppMethodBeat.o(145667);
        return 0;
      }
      AppMethodBeat.o(145667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zb
 * JD-Core Version:    0.7.0.1
 */