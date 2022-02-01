package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class ta
  extends com.tencent.mm.cd.a
{
  public b Sce;
  public long Scf;
  public long Scg;
  public boolean Sch;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sce != null) {
        paramVarArgs.c(1, this.Sce);
      }
      paramVarArgs.bm(2, this.Scf);
      paramVarArgs.bm(3, this.Scg);
      paramVarArgs.co(4, this.Sch);
      paramVarArgs.bm(5, this.id);
      AppMethodBeat.o(258414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sce == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = g.a.a.b.b.a.b(1, this.Sce) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Scf);
      int j = g.a.a.b.b.a.p(3, this.Scg);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.p(5, this.id);
      AppMethodBeat.o(258414);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258414);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ta localta = (ta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258414);
          return -1;
        case 1: 
          localta.Sce = locala.abFh.iUw();
          AppMethodBeat.o(258414);
          return 0;
        case 2: 
          localta.Scf = locala.abFh.AN();
          AppMethodBeat.o(258414);
          return 0;
        case 3: 
          localta.Scg = locala.abFh.AN();
          AppMethodBeat.o(258414);
          return 0;
        case 4: 
          localta.Sch = locala.abFh.AB();
          AppMethodBeat.o(258414);
          return 0;
        }
        localta.id = locala.abFh.AN();
        AppMethodBeat.o(258414);
        return 0;
      }
      AppMethodBeat.o(258414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ta
 * JD-Core Version:    0.7.0.1
 */