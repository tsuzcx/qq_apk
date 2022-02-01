package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fmc
  extends com.tencent.mm.cd.a
{
  public String Cqt;
  public String Md5;
  public int UKR;
  public int UKS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110860);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Cqt == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      if (this.Cqt != null) {
        paramVarArgs.f(2, this.Cqt);
      }
      paramVarArgs.aY(3, this.UKR);
      paramVarArgs.aY(4, this.UKS);
      AppMethodBeat.o(110860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.b.b.a.g(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cqt != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Cqt);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UKR);
      int j = g.a.a.b.b.a.bM(4, this.UKS);
      AppMethodBeat.o(110860);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        if (this.Cqt == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110860);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmc localfmc = (fmc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110860);
          return -1;
        case 1: 
          localfmc.Md5 = locala.abFh.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 2: 
          localfmc.Cqt = locala.abFh.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 3: 
          localfmc.UKR = locala.abFh.AK();
          AppMethodBeat.o(110860);
          return 0;
        }
        localfmc.UKS = locala.abFh.AK();
        AppMethodBeat.o(110860);
        return 0;
      }
      AppMethodBeat.o(110860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmc
 * JD-Core Version:    0.7.0.1
 */