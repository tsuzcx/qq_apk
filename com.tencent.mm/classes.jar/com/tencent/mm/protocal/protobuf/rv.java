package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class rv
  extends com.tencent.mm.bw.a
{
  public b Ggp;
  public long Ggq;
  public long Ggr;
  public boolean Ggs;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217515);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ggp != null) {
        paramVarArgs.c(1, this.Ggp);
      }
      paramVarArgs.aZ(2, this.Ggq);
      paramVarArgs.aZ(3, this.Ggr);
      paramVarArgs.bC(4, this.Ggs);
      paramVarArgs.aZ(5, this.id);
      AppMethodBeat.o(217515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ggp == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = f.a.a.b.b.a.b(1, this.Ggp) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.Ggq);
      int j = f.a.a.b.b.a.p(3, this.Ggr);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.p(5, this.id);
      AppMethodBeat.o(217515);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217515);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rv localrv = (rv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(217515);
          return -1;
        case 1: 
          localrv.Ggp = locala.OmT.gCk();
          AppMethodBeat.o(217515);
          return 0;
        case 2: 
          localrv.Ggq = locala.OmT.zd();
          AppMethodBeat.o(217515);
          return 0;
        case 3: 
          localrv.Ggr = locala.OmT.zd();
          AppMethodBeat.o(217515);
          return 0;
        case 4: 
          localrv.Ggs = locala.OmT.gvY();
          AppMethodBeat.o(217515);
          return 0;
        }
        localrv.id = locala.OmT.zd();
        AppMethodBeat.o(217515);
        return 0;
      }
      AppMethodBeat.o(217515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rv
 * JD-Core Version:    0.7.0.1
 */