package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yu
  extends com.tencent.mm.bw.a
{
  public String DSl;
  public int EsY;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EsY);
      if (this.DSl != null) {
        paramVarArgs.d(2, this.DSl);
      }
      paramVarArgs.aR(3, this.status);
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EsY) + 0;
      paramInt = i;
      if (this.DSl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DSl);
      }
      i = f.a.a.b.b.a.bx(3, this.status);
      AppMethodBeat.o(90961);
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
      AppMethodBeat.o(90961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yu localyu = (yu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90961);
        return -1;
      case 1: 
        localyu.EsY = locala.LVo.xF();
        AppMethodBeat.o(90961);
        return 0;
      case 2: 
        localyu.DSl = locala.LVo.readString();
        AppMethodBeat.o(90961);
        return 0;
      }
      localyu.status = locala.LVo.xF();
      AppMethodBeat.o(90961);
      return 0;
    }
    AppMethodBeat.o(90961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yu
 * JD-Core Version:    0.7.0.1
 */