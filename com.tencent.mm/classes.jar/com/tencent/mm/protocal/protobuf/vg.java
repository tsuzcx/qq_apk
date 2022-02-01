package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class vg
  extends com.tencent.mm.bw.a
{
  public b Epw;
  public LinkedList<b> Epx;
  
  public vg()
  {
    AppMethodBeat.i(123563);
    this.Epx = new LinkedList();
    AppMethodBeat.o(123563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Epw != null) {
        paramVarArgs.c(1, this.Epw);
      }
      paramVarArgs.e(2, 6, this.Epx);
      AppMethodBeat.o(123564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Epw == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.Epw) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.Epx);
      AppMethodBeat.o(123564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Epx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vg localvg = (vg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123564);
          return -1;
        case 1: 
          localvg.Epw = locala.LVo.gfk();
          AppMethodBeat.o(123564);
          return 0;
        }
        localvg.Epx.add(locala.LVo.gfk());
        AppMethodBeat.o(123564);
        return 0;
      }
      AppMethodBeat.o(123564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */