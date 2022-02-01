package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaw
  extends com.tencent.mm.bw.a
{
  public boolean Ggx;
  public boolean Ggy;
  public int Ggz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.Ggx);
      paramVarArgs.bl(2, this.Ggy);
      paramVarArgs.aR(3, this.Ggz);
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.bx(3, this.Ggz);
      AppMethodBeat.o(50120);
      return paramInt + 1 + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaw localeaw = (eaw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50120);
        return -1;
      case 1: 
        localeaw.Ggx = locala.LVo.fZX();
        AppMethodBeat.o(50120);
        return 0;
      case 2: 
        localeaw.Ggy = locala.LVo.fZX();
        AppMethodBeat.o(50120);
        return 0;
      }
      localeaw.Ggz = locala.LVo.xF();
      AppMethodBeat.o(50120);
      return 0;
    }
    AppMethodBeat.o(50120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */