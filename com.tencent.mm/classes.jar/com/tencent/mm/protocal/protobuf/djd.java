package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djd
  extends com.tencent.mm.bw.a
{
  public String Adw;
  public String FEJ;
  public String HQM;
  public int HQN;
  public int doj;
  public int zMQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.zMQ);
      if (this.HQM != null) {
        paramVarArgs.d(2, this.HQM);
      }
      if (this.FEJ != null) {
        paramVarArgs.d(3, this.FEJ);
      }
      paramVarArgs.aS(4, this.doj);
      if (this.Adw != null) {
        paramVarArgs.d(5, this.Adw);
      }
      paramVarArgs.aS(6, this.HQN);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.zMQ) + 0;
      paramInt = i;
      if (this.HQM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HQM);
      }
      i = paramInt;
      if (this.FEJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FEJ);
      }
      i += f.a.a.b.b.a.bz(4, this.doj);
      paramInt = i;
      if (this.Adw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Adw);
      }
      i = f.a.a.b.b.a.bz(6, this.HQN);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djd localdjd = (djd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localdjd.zMQ = locala.OmT.zc();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localdjd.HQM = locala.OmT.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localdjd.FEJ = locala.OmT.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localdjd.doj = locala.OmT.zc();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localdjd.Adw = locala.OmT.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localdjd.HQN = locala.OmT.zc();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djd
 * JD-Core Version:    0.7.0.1
 */