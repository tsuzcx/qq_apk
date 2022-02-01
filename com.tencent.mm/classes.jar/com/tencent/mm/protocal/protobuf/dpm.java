package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpm
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String FSC;
  public int HWL;
  public int HWM;
  public long udl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HWL);
      if (this.FSC != null) {
        paramVarArgs.d(2, this.FSC);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(3, this.AesKey);
      }
      paramVarArgs.aS(4, this.HWM);
      paramVarArgs.aZ(5, this.udl);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HWL) + 0;
      paramInt = i;
      if (this.FSC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSC);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HWM);
      int j = f.a.a.b.b.a.p(5, this.udl);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpm localdpm = (dpm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localdpm.HWL = locala.OmT.zc();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localdpm.FSC = locala.OmT.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localdpm.AesKey = locala.OmT.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localdpm.HWM = locala.OmT.zc();
        AppMethodBeat.o(127506);
        return 0;
      }
      localdpm.udl = locala.OmT.zd();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpm
 * JD-Core Version:    0.7.0.1
 */