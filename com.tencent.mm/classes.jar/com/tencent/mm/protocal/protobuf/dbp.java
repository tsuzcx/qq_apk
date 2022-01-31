package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbp
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public int iIF;
  public int iIG;
  public int type;
  public String yhT;
  public String yhU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96346);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.yhT != null) {
        paramVarArgs.e(3, this.yhT);
      }
      if (this.yhU != null) {
        paramVarArgs.e(4, this.yhU);
      }
      paramVarArgs.aO(5, this.iIF);
      paramVarArgs.aO(6, this.iIG);
      AppMethodBeat.o(96346);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.yhT != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.yhT);
      }
      paramInt = i;
      if (this.yhU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.yhU);
      }
      i = e.a.a.b.b.a.bl(5, this.iIF);
      int j = e.a.a.b.b.a.bl(6, this.iIG);
      AppMethodBeat.o(96346);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96346);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbp localdbp = (dbp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96346);
        return -1;
      case 1: 
        localdbp.type = locala.CLY.sl();
        AppMethodBeat.o(96346);
        return 0;
      case 2: 
        localdbp.cwc = locala.CLY.readString();
        AppMethodBeat.o(96346);
        return 0;
      case 3: 
        localdbp.yhT = locala.CLY.readString();
        AppMethodBeat.o(96346);
        return 0;
      case 4: 
        localdbp.yhU = locala.CLY.readString();
        AppMethodBeat.o(96346);
        return 0;
      case 5: 
        localdbp.iIF = locala.CLY.sl();
        AppMethodBeat.o(96346);
        return 0;
      }
      localdbp.iIG = locala.CLY.sl();
      AppMethodBeat.o(96346);
      return 0;
    }
    AppMethodBeat.o(96346);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbp
 * JD-Core Version:    0.7.0.1
 */