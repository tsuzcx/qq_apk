package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bog
  extends com.tencent.mm.bx.a
{
  public String Fwt;
  public long GIT;
  public int GyM;
  public String ihU;
  public String nDo;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.xbt);
      paramVarArgs.aY(2, this.GIT);
      if (this.ihU != null) {
        paramVarArgs.d(3, this.ihU);
      }
      paramVarArgs.aS(4, this.GyM);
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(6, this.Fwt);
      }
      AppMethodBeat.o(219262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.xbt) + 0 + f.a.a.b.b.a.p(2, this.GIT);
      paramInt = i;
      if (this.ihU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ihU);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GyM);
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nDo);
      }
      i = paramInt;
      if (this.Fwt != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fwt);
      }
      AppMethodBeat.o(219262);
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
      AppMethodBeat.o(219262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bog localbog = (bog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(219262);
        return -1;
      case 1: 
        localbog.xbt = locala.NPN.zd();
        AppMethodBeat.o(219262);
        return 0;
      case 2: 
        localbog.GIT = locala.NPN.zd();
        AppMethodBeat.o(219262);
        return 0;
      case 3: 
        localbog.ihU = locala.NPN.readString();
        AppMethodBeat.o(219262);
        return 0;
      case 4: 
        localbog.GyM = locala.NPN.zc();
        AppMethodBeat.o(219262);
        return 0;
      case 5: 
        localbog.nDo = locala.NPN.readString();
        AppMethodBeat.o(219262);
        return 0;
      }
      localbog.Fwt = locala.NPN.readString();
      AppMethodBeat.o(219262);
      return 0;
    }
    AppMethodBeat.o(219262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */