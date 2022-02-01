package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgv
  extends com.tencent.mm.cd.a
{
  public int UHg;
  public String Uht;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uht != null) {
        paramVarArgs.f(1, this.Uht);
      }
      if (this.mVH != null) {
        paramVarArgs.f(2, this.mVH);
      }
      paramVarArgs.aY(3, this.UHg);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uht == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = g.a.a.b.b.a.g(1, this.Uht) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.mVH);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UHg);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fgv localfgv = (fgv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localfgv.Uht = locala.abFh.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localfgv.mVH = locala.abFh.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localfgv.UHg = locala.abFh.AK();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgv
 * JD-Core Version:    0.7.0.1
 */