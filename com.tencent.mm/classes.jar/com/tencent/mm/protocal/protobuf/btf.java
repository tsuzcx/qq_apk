package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class btf
  extends com.tencent.mm.bw.a
{
  public int HgA;
  public b HgB;
  public int HgH;
  public int HgI;
  public int nID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HgA);
      if (this.HgB != null) {
        paramVarArgs.c(2, this.HgB);
      }
      paramVarArgs.aS(3, this.HgH);
      paramVarArgs.aS(4, this.nID);
      paramVarArgs.aS(5, this.HgI);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HgA) + 0;
      paramInt = i;
      if (this.HgB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HgB);
      }
      i = f.a.a.b.b.a.bz(3, this.HgH);
      int j = f.a.a.b.b.a.bz(4, this.nID);
      int k = f.a.a.b.b.a.bz(5, this.HgI);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btf localbtf = (btf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localbtf.HgA = locala.OmT.zc();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localbtf.HgB = locala.OmT.gCk();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localbtf.HgH = locala.OmT.zc();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localbtf.nID = locala.OmT.zc();
        AppMethodBeat.o(116337);
        return 0;
      }
      localbtf.HgI = locala.OmT.zc();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */