package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyv
  extends com.tencent.mm.bw.a
{
  public boolean Gff;
  public boolean Gfg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.Gff);
      paramVarArgs.bl(2, this.Gfg);
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(110855);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyv localdyv = (dyv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110855);
        return -1;
      case 1: 
        localdyv.Gff = locala.LVo.fZX();
        AppMethodBeat.o(110855);
        return 0;
      }
      localdyv.Gfg = locala.LVo.fZX();
      AppMethodBeat.o(110855);
      return 0;
    }
    AppMethodBeat.o(110855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyv
 * JD-Core Version:    0.7.0.1
 */