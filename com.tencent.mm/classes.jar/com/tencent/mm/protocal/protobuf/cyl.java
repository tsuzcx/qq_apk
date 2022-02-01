package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyl
  extends com.tencent.mm.cd.a
{
  public String CQx;
  public String Izj;
  public String TGM;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CQx != null) {
        paramVarArgs.f(1, this.CQx);
      }
      if (this.TGM != null) {
        paramVarArgs.f(2, this.TGM);
      }
      if (this.Izj != null) {
        paramVarArgs.f(3, this.Izj);
      }
      paramVarArgs.aY(4, this.rWu);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQx == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.CQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TGM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TGM);
      }
      i = paramInt;
      if (this.Izj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Izj);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.rWu);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cyl localcyl = (cyl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localcyl.CQx = locala.abFh.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localcyl.TGM = locala.abFh.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localcyl.Izj = locala.abFh.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localcyl.rWu = locala.abFh.AK();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyl
 * JD-Core Version:    0.7.0.1
 */