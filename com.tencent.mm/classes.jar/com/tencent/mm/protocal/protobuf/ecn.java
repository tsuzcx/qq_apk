package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecn
  extends com.tencent.mm.bw.a
{
  public String oGf;
  public String pqW;
  public int type;
  public String wSB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188962);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.wSB != null) {
        paramVarArgs.d(2, this.wSB);
      }
      if (this.pqW != null) {
        paramVarArgs.d(3, this.pqW);
      }
      if (this.oGf != null) {
        paramVarArgs.d(4, this.oGf);
      }
      AppMethodBeat.o(188962);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.wSB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wSB);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pqW);
      }
      paramInt = i;
      if (this.oGf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGf);
      }
      AppMethodBeat.o(188962);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188962);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecn localecn = (ecn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(188962);
        return -1;
      case 1: 
        localecn.type = locala.OmT.zc();
        AppMethodBeat.o(188962);
        return 0;
      case 2: 
        localecn.wSB = locala.OmT.readString();
        AppMethodBeat.o(188962);
        return 0;
      case 3: 
        localecn.pqW = locala.OmT.readString();
        AppMethodBeat.o(188962);
        return 0;
      }
      localecn.oGf = locala.OmT.readString();
      AppMethodBeat.o(188962);
      return 0;
    }
    AppMethodBeat.o(188962);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecn
 * JD-Core Version:    0.7.0.1
 */