package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlj
  extends com.tencent.mm.cd.a
{
  public String Hma;
  public long gbJ;
  public int state;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hma != null) {
        paramVarArgs.f(1, this.Hma);
      }
      paramVarArgs.bm(2, this.gbJ);
      paramVarArgs.aY(3, this.state);
      if (this.wording != null) {
        paramVarArgs.f(4, this.wording);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hma == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.Hma) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.gbJ) + g.a.a.b.b.a.bM(3, this.state);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.wording);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlj localdlj = (dlj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localdlj.Hma = locala.abFh.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localdlj.gbJ = locala.abFh.AN();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localdlj.state = locala.abFh.AK();
          AppMethodBeat.o(91619);
          return 0;
        }
        localdlj.wording = locala.abFh.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlj
 * JD-Core Version:    0.7.0.1
 */