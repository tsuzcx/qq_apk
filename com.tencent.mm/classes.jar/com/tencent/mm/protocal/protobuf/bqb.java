package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqb
  extends com.tencent.mm.bw.a
{
  public long FeX;
  public long FeY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190883);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FeX);
      paramVarArgs.aO(2, this.FeY);
      AppMethodBeat.o(190883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FeX);
      int i = f.a.a.b.b.a.p(2, this.FeY);
      AppMethodBeat.o(190883);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190883);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqb localbqb = (bqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190883);
        return -1;
      case 1: 
        localbqb.FeX = locala.LVo.xG();
        AppMethodBeat.o(190883);
        return 0;
      }
      localbqb.FeY = locala.LVo.xG();
      AppMethodBeat.o(190883);
      return 0;
    }
    AppMethodBeat.o(190883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqb
 * JD-Core Version:    0.7.0.1
 */