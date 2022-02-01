package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String iWA;
  public String iWB;
  public int iWv;
  public int iWw;
  public int iWx;
  public long iWy;
  public long iWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91323);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.iWv);
      paramVarArgs.aS(2, this.iWw);
      paramVarArgs.aS(3, this.iWx);
      paramVarArgs.aZ(4, this.iWy);
      paramVarArgs.aZ(5, this.iWz);
      if (this.iWA != null) {
        paramVarArgs.d(6, this.iWA);
      }
      if (this.iWB != null) {
        paramVarArgs.d(7, this.iWB);
      }
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.iWv) + 0 + f.a.a.b.b.a.bz(2, this.iWw) + f.a.a.b.b.a.bz(3, this.iWx) + f.a.a.b.b.a.p(4, this.iWy) + f.a.a.b.b.a.p(5, this.iWz);
      paramInt = i;
      if (this.iWA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iWA);
      }
      i = paramInt;
      if (this.iWB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iWB);
      }
      AppMethodBeat.o(91323);
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
      AppMethodBeat.o(91323);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91323);
        return -1;
      case 1: 
        locall.iWv = locala.OmT.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 2: 
        locall.iWw = locala.OmT.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 3: 
        locall.iWx = locala.OmT.zc();
        AppMethodBeat.o(91323);
        return 0;
      case 4: 
        locall.iWy = locala.OmT.zd();
        AppMethodBeat.o(91323);
        return 0;
      case 5: 
        locall.iWz = locala.OmT.zd();
        AppMethodBeat.o(91323);
        return 0;
      case 6: 
        locall.iWA = locala.OmT.readString();
        AppMethodBeat.o(91323);
        return 0;
      }
      locall.iWB = locala.OmT.readString();
      AppMethodBeat.o(91323);
      return 0;
    }
    AppMethodBeat.o(91323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.l
 * JD-Core Version:    0.7.0.1
 */