package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bkf
  extends com.tencent.mm.cd.a
{
  public int SVh;
  public b SVi;
  public b SVj;
  public int position;
  public String wording;
  public long xee;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SVh);
      paramVarArgs.bm(2, this.xee);
      paramVarArgs.aY(3, this.position);
      if (this.wording != null) {
        paramVarArgs.f(4, this.wording);
      }
      if (this.SVi != null) {
        paramVarArgs.c(5, this.SVi);
      }
      if (this.SVj != null) {
        paramVarArgs.c(6, this.SVj);
      }
      AppMethodBeat.o(207512);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SVh) + 0 + g.a.a.b.b.a.p(2, this.xee) + g.a.a.b.b.a.bM(3, this.position);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.wording);
      }
      i = paramInt;
      if (this.SVi != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.SVi);
      }
      paramInt = i;
      if (this.SVj != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.SVj);
      }
      AppMethodBeat.o(207512);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207512);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bkf localbkf = (bkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207512);
        return -1;
      case 1: 
        localbkf.SVh = locala.abFh.AK();
        AppMethodBeat.o(207512);
        return 0;
      case 2: 
        localbkf.xee = locala.abFh.AN();
        AppMethodBeat.o(207512);
        return 0;
      case 3: 
        localbkf.position = locala.abFh.AK();
        AppMethodBeat.o(207512);
        return 0;
      case 4: 
        localbkf.wording = locala.abFh.readString();
        AppMethodBeat.o(207512);
        return 0;
      case 5: 
        localbkf.SVi = locala.abFh.iUw();
        AppMethodBeat.o(207512);
        return 0;
      }
      localbkf.SVj = locala.abFh.iUw();
      AppMethodBeat.o(207512);
      return 0;
    }
    AppMethodBeat.o(207512);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkf
 * JD-Core Version:    0.7.0.1
 */