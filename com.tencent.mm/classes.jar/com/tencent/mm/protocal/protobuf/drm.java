package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drm
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> EGA;
  public boolean EGB;
  
  public drm()
  {
    AppMethodBeat.i(32543);
    this.EGA = new LinkedList();
    AppMethodBeat.o(32543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.EGA);
      paramVarArgs.bg(2, this.EGB);
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 2, this.EGA);
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(32544);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EGA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drm localdrm = (drm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32544);
        return -1;
      case 1: 
        localdrm.EGA.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(32544);
        return 0;
      }
      localdrm.EGB = locala.KhF.fHu();
      AppMethodBeat.o(32544);
      return 0;
    }
    AppMethodBeat.o(32544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drm
 * JD-Core Version:    0.7.0.1
 */