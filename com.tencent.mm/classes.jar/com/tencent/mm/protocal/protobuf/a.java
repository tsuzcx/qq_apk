package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public int dEu;
  public String dyI;
  public String kCZ;
  public String kDa;
  public String phk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91310);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dEu);
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.kCZ != null) {
        paramVarArgs.d(3, this.kCZ);
      }
      if (this.kDa != null) {
        paramVarArgs.d(4, this.kDa);
      }
      if (this.phk != null) {
        paramVarArgs.d(5, this.phk);
      }
      AppMethodBeat.o(91310);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dEu) + 0;
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.kCZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kCZ);
      }
      paramInt = i;
      if (this.kDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.kDa);
      }
      i = paramInt;
      if (this.phk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.phk);
      }
      AppMethodBeat.o(91310);
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
      AppMethodBeat.o(91310);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91310);
        return -1;
      case 1: 
        locala1.dEu = locala.OmT.zc();
        AppMethodBeat.o(91310);
        return 0;
      case 2: 
        locala1.dyI = locala.OmT.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 3: 
        locala1.kCZ = locala.OmT.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 4: 
        locala1.kDa = locala.OmT.readString();
        AppMethodBeat.o(91310);
        return 0;
      }
      locala1.phk = locala.OmT.readString();
      AppMethodBeat.o(91310);
      return 0;
    }
    AppMethodBeat.o(91310);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a
 * JD-Core Version:    0.7.0.1
 */