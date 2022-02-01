package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amh
  extends com.tencent.mm.bw.a
{
  public int EFF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195099);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aR(1, this.EFF);
      AppMethodBeat.o(195099);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EFF);
      AppMethodBeat.o(195099);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195099);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amh localamh = (amh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195099);
        return -1;
      }
      localamh.EFF = locala.LVo.xF();
      AppMethodBeat.o(195099);
      return 0;
    }
    AppMethodBeat.o(195099);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amh
 * JD-Core Version:    0.7.0.1
 */