package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcf
  extends com.tencent.mm.bw.a
{
  public String MHa;
  public LinkedList<String> MHb;
  
  public dcf()
  {
    AppMethodBeat.i(209780);
    this.MHb = new LinkedList();
    AppMethodBeat.o(209780);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209781);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MHa != null) {
        paramVarArgs.e(1, this.MHa);
      }
      paramVarArgs.e(2, 1, this.MHb);
      AppMethodBeat.o(209781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MHa == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.MHa) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.MHb);
      AppMethodBeat.o(209781);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MHb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209781);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcf localdcf = (dcf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209781);
          return -1;
        case 1: 
          localdcf.MHa = locala.UbS.readString();
          AppMethodBeat.o(209781);
          return 0;
        }
        localdcf.MHb.add(locala.UbS.readString());
        AppMethodBeat.o(209781);
        return 0;
      }
      AppMethodBeat.o(209781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcf
 * JD-Core Version:    0.7.0.1
 */