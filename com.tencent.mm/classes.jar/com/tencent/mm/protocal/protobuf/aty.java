package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aty
  extends com.tencent.mm.bw.a
{
  public String DmG;
  public String DmH;
  public String DmI;
  public long GKO;
  public int GKP;
  public double GKQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GKO);
      paramVarArgs.aS(2, this.GKP);
      paramVarArgs.e(3, this.GKQ);
      if (this.DmG != null) {
        paramVarArgs.d(4, this.DmG);
      }
      if (this.DmH != null) {
        paramVarArgs.d(5, this.DmH);
      }
      if (this.DmI != null) {
        paramVarArgs.d(6, this.DmI);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GKO) + 0 + f.a.a.b.b.a.bz(2, this.GKP) + f.a.a.b.b.a.amD(3);
      paramInt = i;
      if (this.DmG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DmG);
      }
      i = paramInt;
      if (this.DmH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DmH);
      }
      paramInt = i;
      if (this.DmI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DmI);
      }
      AppMethodBeat.o(91470);
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
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aty localaty = (aty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localaty.GKO = locala.OmT.zd();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localaty.GKP = locala.OmT.zc();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localaty.GKQ = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localaty.DmG = locala.OmT.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localaty.DmH = locala.OmT.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localaty.DmI = locala.OmT.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aty
 * JD-Core Version:    0.7.0.1
 */