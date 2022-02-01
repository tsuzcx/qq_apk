package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btx
  extends com.tencent.mm.bw.a
{
  public String DSu;
  public int Fdz;
  public int Fje;
  public int sVK;
  public int sVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sVo);
      paramVarArgs.aR(2, this.sVK);
      paramVarArgs.aR(3, this.Fje);
      if (this.DSu != null) {
        paramVarArgs.d(4, this.DSu);
      }
      paramVarArgs.aR(5, this.Fdz);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.sVo) + 0 + f.a.a.b.b.a.bx(2, this.sVK) + f.a.a.b.b.a.bx(3, this.Fje);
      paramInt = i;
      if (this.DSu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DSu);
      }
      i = f.a.a.b.b.a.bx(5, this.Fdz);
      AppMethodBeat.o(125742);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btx localbtx = (btx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localbtx.sVo = locala.LVo.xF();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localbtx.sVK = locala.LVo.xF();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localbtx.Fje = locala.LVo.xF();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localbtx.DSu = locala.LVo.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localbtx.Fdz = locala.LVo.xF();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btx
 * JD-Core Version:    0.7.0.1
 */