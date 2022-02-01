package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxh
  extends com.tencent.mm.bx.a
{
  public String FMt;
  public String GDb;
  public long GRp;
  public long GRq;
  public int nEf;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      if (this.GDb != null) {
        paramVarArgs.d(2, this.GDb);
      }
      paramVarArgs.aY(3, this.GRp);
      paramVarArgs.aY(4, this.GRq);
      if (this.FMt != null) {
        paramVarArgs.d(5, this.FMt);
      }
      paramVarArgs.aS(6, this.nEf);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0;
      paramInt = i;
      if (this.GDb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GDb);
      }
      i = paramInt + f.a.a.b.b.a.p(3, this.GRp) + f.a.a.b.b.a.p(4, this.GRq);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FMt);
      }
      i = f.a.a.b.b.a.bz(6, this.nEf);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxh localbxh = (bxh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localbxh.scene = locala.NPN.zc();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localbxh.GDb = locala.NPN.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localbxh.GRp = locala.NPN.zd();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localbxh.GRq = locala.NPN.zd();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localbxh.FMt = locala.NPN.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localbxh.nEf = locala.NPN.zc();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxh
 * JD-Core Version:    0.7.0.1
 */