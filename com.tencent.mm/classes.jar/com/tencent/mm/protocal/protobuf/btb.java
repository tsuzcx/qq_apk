package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class btb
  extends com.tencent.mm.bw.a
{
  public int GvJ;
  public int HgA;
  public b HgB;
  public int HgC;
  public int HgD;
  public int nID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HgA);
      if (this.HgB != null) {
        paramVarArgs.c(2, this.HgB);
      }
      paramVarArgs.aS(3, this.HgC);
      paramVarArgs.aS(4, this.GvJ);
      paramVarArgs.aS(5, this.nID);
      paramVarArgs.aS(6, this.HgD);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HgA) + 0;
      paramInt = i;
      if (this.HgB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HgB);
      }
      i = f.a.a.b.b.a.bz(3, this.HgC);
      int j = f.a.a.b.b.a.bz(4, this.GvJ);
      int k = f.a.a.b.b.a.bz(5, this.nID);
      int m = f.a.a.b.b.a.bz(6, this.HgD);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btb localbtb = (btb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localbtb.HgA = locala.OmT.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localbtb.HgB = locala.OmT.gCk();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localbtb.HgC = locala.OmT.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localbtb.GvJ = locala.OmT.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localbtb.nID = locala.OmT.zc();
        AppMethodBeat.o(143982);
        return 0;
      }
      localbtb.HgD = locala.OmT.zc();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btb
 * JD-Core Version:    0.7.0.1
 */