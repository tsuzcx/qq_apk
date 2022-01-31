package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clh
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public long niJ;
  public String wDs;
  public int xVx;
  public int xVy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51437);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xVx);
      if (this.wDs != null) {
        paramVarArgs.e(2, this.wDs);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(3, this.AesKey);
      }
      paramVarArgs.aO(4, this.xVy);
      paramVarArgs.am(5, this.niJ);
      AppMethodBeat.o(51437);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xVx) + 0;
      paramInt = i;
      if (this.wDs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wDs);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.AesKey);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xVy);
      int j = e.a.a.b.b.a.p(5, this.niJ);
      AppMethodBeat.o(51437);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51437);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      clh localclh = (clh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51437);
        return -1;
      case 1: 
        localclh.xVx = locala.CLY.sl();
        AppMethodBeat.o(51437);
        return 0;
      case 2: 
        localclh.wDs = locala.CLY.readString();
        AppMethodBeat.o(51437);
        return 0;
      case 3: 
        localclh.AesKey = locala.CLY.readString();
        AppMethodBeat.o(51437);
        return 0;
      case 4: 
        localclh.xVy = locala.CLY.sl();
        AppMethodBeat.o(51437);
        return 0;
      }
      localclh.niJ = locala.CLY.sm();
      AppMethodBeat.o(51437);
      return 0;
    }
    AppMethodBeat.o(51437);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */