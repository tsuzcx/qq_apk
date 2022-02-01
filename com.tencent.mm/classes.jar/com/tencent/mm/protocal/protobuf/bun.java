package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bun
  extends com.tencent.mm.bx.a
{
  public int FHr;
  public long Fsa;
  public String GOA;
  public String GOz;
  public String Gbw;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Fsa);
      if (this.GOz != null) {
        paramVarArgs.d(2, this.GOz);
      }
      paramVarArgs.aS(3, this.rotation);
      if (this.Gbw != null) {
        paramVarArgs.d(4, this.Gbw);
      }
      paramVarArgs.aS(5, this.FHr);
      if (this.GOA != null) {
        paramVarArgs.d(6, this.GOA);
      }
      AppMethodBeat.o(211959);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Fsa) + 0;
      paramInt = i;
      if (this.GOz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GOz);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.rotation);
      paramInt = i;
      if (this.Gbw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gbw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FHr);
      paramInt = i;
      if (this.GOA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GOA);
      }
      AppMethodBeat.o(211959);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(211959);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bun localbun = (bun)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211959);
        return -1;
      case 1: 
        localbun.Fsa = locala.NPN.zd();
        AppMethodBeat.o(211959);
        return 0;
      case 2: 
        localbun.GOz = locala.NPN.readString();
        AppMethodBeat.o(211959);
        return 0;
      case 3: 
        localbun.rotation = locala.NPN.zc();
        AppMethodBeat.o(211959);
        return 0;
      case 4: 
        localbun.Gbw = locala.NPN.readString();
        AppMethodBeat.o(211959);
        return 0;
      case 5: 
        localbun.FHr = locala.NPN.zc();
        AppMethodBeat.o(211959);
        return 0;
      }
      localbun.GOA = locala.NPN.readString();
      AppMethodBeat.o(211959);
      return 0;
    }
    AppMethodBeat.o(211959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bun
 * JD-Core Version:    0.7.0.1
 */