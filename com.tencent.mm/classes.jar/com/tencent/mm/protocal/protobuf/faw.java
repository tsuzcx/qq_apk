package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class faw
  extends com.tencent.mm.bw.a
{
  public String Nxh;
  public LinkedList<String> Nxi;
  
  public faw()
  {
    AppMethodBeat.i(212146);
    this.Nxi = new LinkedList();
    AppMethodBeat.o(212146);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212147);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nxh != null) {
        paramVarArgs.e(1, this.Nxh);
      }
      paramVarArgs.e(2, 1, this.Nxi);
      AppMethodBeat.o(212147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nxh == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nxh) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.Nxi);
      AppMethodBeat.o(212147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nxi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212147);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        faw localfaw = (faw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212147);
          return -1;
        case 1: 
          localfaw.Nxh = locala.UbS.readString();
          AppMethodBeat.o(212147);
          return 0;
        }
        localfaw.Nxi.add(locala.UbS.readString());
        AppMethodBeat.o(212147);
        return 0;
      }
      AppMethodBeat.o(212147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faw
 * JD-Core Version:    0.7.0.1
 */