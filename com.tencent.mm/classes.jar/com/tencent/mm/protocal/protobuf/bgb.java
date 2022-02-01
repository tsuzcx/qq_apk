package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bgb
  extends com.tencent.mm.cd.a
{
  public int SQX;
  public int SQY;
  public b SQZ;
  public int SRa;
  public String uLJ;
  public long xee;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204153);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xee);
      if (this.uLJ != null) {
        paramVarArgs.f(2, this.uLJ);
      }
      paramVarArgs.aY(3, this.SQX);
      paramVarArgs.aY(4, this.SQY);
      if (this.SQZ != null) {
        paramVarArgs.c(5, this.SQZ);
      }
      paramVarArgs.aY(6, this.SRa);
      AppMethodBeat.o(204153);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xee) + 0;
      paramInt = i;
      if (this.uLJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.uLJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SQX) + g.a.a.b.b.a.bM(4, this.SQY);
      paramInt = i;
      if (this.SQZ != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SQZ);
      }
      i = g.a.a.b.b.a.bM(6, this.SRa);
      AppMethodBeat.o(204153);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(204153);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bgb localbgb = (bgb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(204153);
        return -1;
      case 1: 
        localbgb.xee = locala.abFh.AN();
        AppMethodBeat.o(204153);
        return 0;
      case 2: 
        localbgb.uLJ = locala.abFh.readString();
        AppMethodBeat.o(204153);
        return 0;
      case 3: 
        localbgb.SQX = locala.abFh.AK();
        AppMethodBeat.o(204153);
        return 0;
      case 4: 
        localbgb.SQY = locala.abFh.AK();
        AppMethodBeat.o(204153);
        return 0;
      case 5: 
        localbgb.SQZ = locala.abFh.iUw();
        AppMethodBeat.o(204153);
        return 0;
      }
      localbgb.SRa = locala.abFh.AK();
      AppMethodBeat.o(204153);
      return 0;
    }
    AppMethodBeat.o(204153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgb
 * JD-Core Version:    0.7.0.1
 */