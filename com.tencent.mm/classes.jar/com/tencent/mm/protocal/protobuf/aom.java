package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aom
  extends com.tencent.mm.bw.a
{
  public long EHA;
  public String EHB;
  public int EHv;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EHA);
      if (this.EHB != null) {
        paramVarArgs.d(2, this.EHB);
      }
      paramVarArgs.aR(3, this.EHv);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      AppMethodBeat.o(195119);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.EHA) + 0;
      paramInt = i;
      if (this.EHB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EHB);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EHv);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      AppMethodBeat.o(195119);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195119);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aom localaom = (aom)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195119);
        return -1;
      case 1: 
        localaom.EHA = locala.LVo.xG();
        AppMethodBeat.o(195119);
        return 0;
      case 2: 
        localaom.EHB = locala.LVo.readString();
        AppMethodBeat.o(195119);
        return 0;
      case 3: 
        localaom.EHv = locala.LVo.xF();
        AppMethodBeat.o(195119);
        return 0;
      }
      localaom.username = locala.LVo.readString();
      AppMethodBeat.o(195119);
      return 0;
    }
    AppMethodBeat.o(195119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aom
 * JD-Core Version:    0.7.0.1
 */