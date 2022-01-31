package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cva
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String ProductID;
  public String Title;
  public String nQe;
  public int woE;
  public String xBK;
  public String ydJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28709);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.xBK != null) {
        paramVarArgs.e(2, this.xBK);
      }
      if (this.nQe != null) {
        paramVarArgs.e(3, this.nQe);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.ydJ != null) {
        paramVarArgs.e(5, this.ydJ);
      }
      paramVarArgs.aO(6, this.woE);
      if (this.ProductID != null) {
        paramVarArgs.e(7, this.ProductID);
      }
      AppMethodBeat.o(28709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label575;
      }
    }
    label575:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xBK != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xBK);
      }
      i = paramInt;
      if (this.nQe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nQe);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.ydJ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ydJ);
      }
      i += e.a.a.b.b.a.bl(6, this.woE);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.ProductID);
      }
      AppMethodBeat.o(28709);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28709);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cva localcva = (cva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28709);
          return -1;
        case 1: 
          localcva.Title = locala.CLY.readString();
          AppMethodBeat.o(28709);
          return 0;
        case 2: 
          localcva.xBK = locala.CLY.readString();
          AppMethodBeat.o(28709);
          return 0;
        case 3: 
          localcva.nQe = locala.CLY.readString();
          AppMethodBeat.o(28709);
          return 0;
        case 4: 
          localcva.Desc = locala.CLY.readString();
          AppMethodBeat.o(28709);
          return 0;
        case 5: 
          localcva.ydJ = locala.CLY.readString();
          AppMethodBeat.o(28709);
          return 0;
        case 6: 
          localcva.woE = locala.CLY.sl();
          AppMethodBeat.o(28709);
          return 0;
        }
        localcva.ProductID = locala.CLY.readString();
        AppMethodBeat.o(28709);
        return 0;
      }
      AppMethodBeat.o(28709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cva
 * JD-Core Version:    0.7.0.1
 */