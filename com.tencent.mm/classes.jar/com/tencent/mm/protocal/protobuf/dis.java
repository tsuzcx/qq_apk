package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dis
  extends com.tencent.mm.bw.a
{
  public b Efq;
  public int Efr;
  public int FSm;
  public int FSn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(7, this.FSm);
      if (this.Efq != null) {
        paramVarArgs.c(8, this.Efq);
      }
      paramVarArgs.aR(9, this.Efr);
      paramVarArgs.aR(10, this.FSn);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(7, this.FSm) + 0;
      paramInt = i;
      if (this.Efq != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Efq);
      }
      i = f.a.a.b.b.a.bx(9, this.Efr);
      int j = f.a.a.b.b.a.bx(10, this.FSn);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dis localdis = (dis)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localdis.FSm = locala.LVo.xF();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localdis.Efq = locala.LVo.gfk();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localdis.Efr = locala.LVo.xF();
        AppMethodBeat.o(91718);
        return 0;
      }
      localdis.FSn = locala.LVo.xF();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dis
 * JD-Core Version:    0.7.0.1
 */