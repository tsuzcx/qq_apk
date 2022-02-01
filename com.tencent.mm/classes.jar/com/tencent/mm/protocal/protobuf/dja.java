package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dja
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String DUJ;
  public int FSp;
  public int FSq;
  public long sVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FSp);
      if (this.DUJ != null) {
        paramVarArgs.d(2, this.DUJ);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(3, this.AesKey);
      }
      paramVarArgs.aR(4, this.FSq);
      paramVarArgs.aO(5, this.sVP);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FSp) + 0;
      paramInt = i;
      if (this.DUJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUJ);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.FSq);
      int j = f.a.a.b.b.a.p(5, this.sVP);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dja localdja = (dja)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localdja.FSp = locala.LVo.xF();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localdja.DUJ = locala.LVo.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localdja.AesKey = locala.LVo.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localdja.FSq = locala.LVo.xF();
        AppMethodBeat.o(127506);
        return 0;
      }
      localdja.sVP = locala.LVo.xG();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dja
 * JD-Core Version:    0.7.0.1
 */