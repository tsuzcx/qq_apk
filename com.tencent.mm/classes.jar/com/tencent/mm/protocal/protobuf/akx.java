package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class akx
  extends com.tencent.mm.bw.a
{
  public String LtA;
  public String LtL;
  public LinkedList<String> LtM;
  public boolean LtN;
  
  public akx()
  {
    AppMethodBeat.i(32203);
    this.LtM = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.LtA != null) {
        paramVarArgs.e(1, this.LtA);
      }
      if (this.LtL != null) {
        paramVarArgs.e(2, this.LtL);
      }
      paramVarArgs.e(3, 1, this.LtM);
      paramVarArgs.cc(4, this.LtN);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LtA == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.b.b.a.f(1, this.LtA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LtL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LtL);
      }
      paramInt = g.a.a.a.c(3, 1, this.LtM);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(32204);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LtM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LtA == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32204);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localakx.LtA = locala.UbS.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localakx.LtL = locala.UbS.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localakx.LtM.add(locala.UbS.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localakx.LtN = locala.UbS.yZ();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */