package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daa
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b Gwe;
  public int HJA;
  public int HJB;
  public int HJC;
  public int HJD;
  public int HJE;
  public int HJy;
  public int HJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gwe == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HJy);
      paramVarArgs.aS(2, this.HJz);
      paramVarArgs.aS(3, this.HJA);
      paramVarArgs.aS(4, this.HJB);
      paramVarArgs.aS(5, this.HJC);
      paramVarArgs.aS(6, this.HJD);
      paramVarArgs.aS(7, this.HJE);
      if (this.Gwe != null) {
        paramVarArgs.c(8, this.Gwe);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HJy) + 0 + f.a.a.b.b.a.bz(2, this.HJz) + f.a.a.b.b.a.bz(3, this.HJA) + f.a.a.b.b.a.bz(4, this.HJB) + f.a.a.b.b.a.bz(5, this.HJC) + f.a.a.b.b.a.bz(6, this.HJD) + f.a.a.b.b.a.bz(7, this.HJE);
      paramInt = i;
      if (this.Gwe != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Gwe);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    f.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.gCg();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (f.a.a.a.a)paramVarArgs[0];
      daa localdaa = (daa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localdaa.HJy = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localdaa.HJz = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localdaa.HJA = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localdaa.HJB = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localdaa.HJC = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localdaa.HJD = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localdaa.HJE = locala.OmT.zc();
        AppMethodBeat.o(32425);
        return 0;
      }
      localdaa.Gwe = locala.OmT.gCk();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */