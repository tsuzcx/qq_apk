package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class end
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> YVA;
  public String YVK;
  public long abrB;
  
  public end()
  {
    AppMethodBeat.i(259972);
    this.YVA = new LinkedList();
    AppMethodBeat.o(259972);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259976);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVK != null) {
        paramVarArgs.g(1, this.YVK);
      }
      paramVarArgs.bv(2, this.abrB);
      paramVarArgs.e(3, 1, this.YVA);
      AppMethodBeat.o(259976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVK == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.YVK) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abrB);
      int j = i.a.a.a.c(3, 1, this.YVA);
      AppMethodBeat.o(259976);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YVA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259976);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        end localend = (end)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259976);
          return -1;
        case 1: 
          localend.YVK = locala.ajGk.readString();
          AppMethodBeat.o(259976);
          return 0;
        case 2: 
          localend.abrB = locala.ajGk.aaw();
          AppMethodBeat.o(259976);
          return 0;
        }
        localend.YVA.add(locala.ajGk.readString());
        AppMethodBeat.o(259976);
        return 0;
      }
      AppMethodBeat.o(259976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.end
 * JD-Core Version:    0.7.0.1
 */