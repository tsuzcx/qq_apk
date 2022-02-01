package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cbj
  extends com.tencent.mm.bw.a
{
  public String GnN;
  public String GnO;
  public int HoG;
  public int HoH;
  public b HoI;
  public String HoJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HoG);
      paramVarArgs.aS(2, this.HoH);
      if (this.HoI != null) {
        paramVarArgs.c(3, this.HoI);
      }
      if (this.HoJ != null) {
        paramVarArgs.d(4, this.HoJ);
      }
      if (this.GnN != null) {
        paramVarArgs.d(5, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(6, this.GnO);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HoG) + 0 + f.a.a.b.b.a.bz(2, this.HoH);
      paramInt = i;
      if (this.HoI != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.HoI);
      }
      i = paramInt;
      if (this.HoJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HoJ);
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GnO);
      }
      AppMethodBeat.o(32353);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbj localcbj = (cbj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localcbj.HoG = locala.OmT.zc();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localcbj.HoH = locala.OmT.zc();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localcbj.HoI = locala.OmT.gCk();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localcbj.HoJ = locala.OmT.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localcbj.GnN = locala.OmT.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localcbj.GnO = locala.OmT.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */