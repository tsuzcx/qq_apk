package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acs
  extends com.tencent.mm.bv.a
{
  public int cIT;
  public String cpW;
  public int index;
  public int kbN;
  public String mtm;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51406);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.scene);
      paramVarArgs.aO(2, this.kbN);
      paramVarArgs.aO(3, this.index);
      if (this.cpW != null) {
        paramVarArgs.e(4, this.cpW);
      }
      if (this.query != null) {
        paramVarArgs.e(5, this.query);
      }
      if (this.mtm != null) {
        paramVarArgs.e(6, this.mtm);
      }
      paramVarArgs.aO(7, this.cIT);
      AppMethodBeat.o(51406);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.scene) + 0 + e.a.a.b.b.a.bl(2, this.kbN) + e.a.a.b.b.a.bl(3, this.index);
      paramInt = i;
      if (this.cpW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cpW);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.query);
      }
      paramInt = i;
      if (this.mtm != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.mtm);
      }
      i = e.a.a.b.b.a.bl(7, this.cIT);
      AppMethodBeat.o(51406);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51406);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      acs localacs = (acs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51406);
        return -1;
      case 1: 
        localacs.scene = locala.CLY.sl();
        AppMethodBeat.o(51406);
        return 0;
      case 2: 
        localacs.kbN = locala.CLY.sl();
        AppMethodBeat.o(51406);
        return 0;
      case 3: 
        localacs.index = locala.CLY.sl();
        AppMethodBeat.o(51406);
        return 0;
      case 4: 
        localacs.cpW = locala.CLY.readString();
        AppMethodBeat.o(51406);
        return 0;
      case 5: 
        localacs.query = locala.CLY.readString();
        AppMethodBeat.o(51406);
        return 0;
      case 6: 
        localacs.mtm = locala.CLY.readString();
        AppMethodBeat.o(51406);
        return 0;
      }
      localacs.cIT = locala.CLY.sl();
      AppMethodBeat.o(51406);
      return 0;
    }
    AppMethodBeat.o(51406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acs
 * JD-Core Version:    0.7.0.1
 */