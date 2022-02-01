package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjr
  extends com.tencent.mm.bx.a
{
  public int FqN;
  public int GEe;
  public String GEf;
  public String GEg;
  public String GtD;
  public int Ret;
  public String Title;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.GtD != null) {
        paramVarArgs.d(2, this.GtD);
      }
      paramVarArgs.aS(3, this.FqN);
      paramVarArgs.aS(4, this.GEe);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.nDo != null) {
        paramVarArgs.d(6, this.nDo);
      }
      if (this.GEf != null) {
        paramVarArgs.d(7, this.GEf);
      }
      if (this.GEg != null) {
        paramVarArgs.d(8, this.GEg);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.GtD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GtD);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FqN) + f.a.a.b.b.a.bz(4, this.GEe);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nDo);
      }
      paramInt = i;
      if (this.GEf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GEf);
      }
      i = paramInt;
      if (this.GEg != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GEg);
      }
      AppMethodBeat.o(152608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bjr localbjr = (bjr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localbjr.Ret = locala.NPN.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localbjr.GtD = locala.NPN.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localbjr.FqN = locala.NPN.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localbjr.GEe = locala.NPN.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localbjr.Title = locala.NPN.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localbjr.nDo = locala.NPN.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localbjr.GEf = locala.NPN.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localbjr.GEg = locala.NPN.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjr
 * JD-Core Version:    0.7.0.1
 */