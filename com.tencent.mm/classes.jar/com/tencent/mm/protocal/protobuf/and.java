package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class and
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String axa;
  public LinkedList<String> xdD;
  
  public and()
  {
    AppMethodBeat.i(80085);
    this.xdD = new LinkedList();
    AppMethodBeat.o(80085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80086);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.axa != null) {
        paramVarArgs.e(1, this.axa);
      }
      if (this.app_id != null) {
        paramVarArgs.e(2, this.app_id);
      }
      paramVarArgs.e(3, 1, this.xdD);
      AppMethodBeat.o(80086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.axa == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = e.a.a.b.b.a.f(1, this.axa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.app_id);
      }
      paramInt = e.a.a.a.c(3, 1, this.xdD);
      AppMethodBeat.o(80086);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xdD.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80086);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        and localand = (and)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80086);
          return -1;
        case 1: 
          localand.axa = locala.CLY.readString();
          AppMethodBeat.o(80086);
          return 0;
        case 2: 
          localand.app_id = locala.CLY.readString();
          AppMethodBeat.o(80086);
          return 0;
        }
        localand.xdD.add(locala.CLY.readString());
        AppMethodBeat.o(80086);
        return 0;
      }
      AppMethodBeat.o(80086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.and
 * JD-Core Version:    0.7.0.1
 */