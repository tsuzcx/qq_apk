package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class os
  extends com.tencent.mm.bw.a
{
  public String KSV;
  public LinkedList<String> KUB;
  public String KUE;
  
  public os()
  {
    AppMethodBeat.i(212244);
    this.KUB = new LinkedList();
    AppMethodBeat.o(212244);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212245);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KSV != null) {
        paramVarArgs.e(1, this.KSV);
      }
      paramVarArgs.e(2, 1, this.KUB);
      if (this.KUE != null) {
        paramVarArgs.e(3, this.KUE);
      }
      AppMethodBeat.o(212245);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KSV == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.f(1, this.KSV) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.KUB);
      paramInt = i;
      if (this.KUE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KUE);
      }
      AppMethodBeat.o(212245);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212245);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        os localos = (os)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212245);
          return -1;
        case 1: 
          localos.KSV = locala.UbS.readString();
          AppMethodBeat.o(212245);
          return 0;
        case 2: 
          localos.KUB.add(locala.UbS.readString());
          AppMethodBeat.o(212245);
          return 0;
        }
        localos.KUE = locala.UbS.readString();
        AppMethodBeat.o(212245);
        return 0;
      }
      AppMethodBeat.o(212245);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.os
 * JD-Core Version:    0.7.0.1
 */