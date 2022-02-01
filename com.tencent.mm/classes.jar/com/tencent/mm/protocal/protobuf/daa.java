package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daa
  extends com.tencent.mm.cd.a
{
  public String IKh;
  public int Sjq;
  public String TiP;
  public int block;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IKh != null) {
        paramVarArgs.f(1, this.IKh);
      }
      paramVarArgs.aY(2, this.block);
      if (this.TiP != null) {
        paramVarArgs.f(3, this.TiP);
      }
      paramVarArgs.aY(4, this.Sjq);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IKh == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.IKh) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.block);
      paramInt = i;
      if (this.TiP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TiP);
      }
      i = g.a.a.b.b.a.bM(4, this.Sjq);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        daa localdaa = (daa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localdaa.IKh = locala.abFh.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localdaa.block = locala.abFh.AK();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localdaa.TiP = locala.abFh.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localdaa.Sjq = locala.abFh.AK();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */