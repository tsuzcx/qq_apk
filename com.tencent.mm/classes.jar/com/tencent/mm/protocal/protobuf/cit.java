package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cit
  extends com.tencent.mm.bw.a
{
  public String EIM;
  public int ESB;
  public int Exi;
  public int FwO;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ESB);
      if (this.EIM != null) {
        paramVarArgs.d(2, this.EIM);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aR(4, this.Exi);
      paramVarArgs.aR(5, this.FwO);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ESB) + 0;
      paramInt = i;
      if (this.EIM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIM);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Exi);
      int j = f.a.a.b.b.a.bx(5, this.FwO);
      AppMethodBeat.o(155451);
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
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cit localcit = (cit)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localcit.ESB = locala.LVo.xF();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localcit.EIM = locala.LVo.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localcit.MD5 = locala.LVo.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localcit.Exi = locala.LVo.xF();
        AppMethodBeat.o(155451);
        return 0;
      }
      localcit.FwO = locala.LVo.xF();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */