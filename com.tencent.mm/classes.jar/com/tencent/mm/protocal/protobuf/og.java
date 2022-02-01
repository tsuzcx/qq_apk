package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class og
  extends com.tencent.mm.bx.a
{
  public String CIQ;
  public LinkedList<String> CLT;
  
  public og()
  {
    AppMethodBeat.i(124465);
    this.CLT = new LinkedList();
    AppMethodBeat.o(124465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124466);
        throw paramVarArgs;
      }
      if (this.CIQ != null) {
        paramVarArgs.d(2, this.CIQ);
      }
      paramVarArgs.e(3, 1, this.CLT);
      AppMethodBeat.o(124466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIQ == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(2, this.CIQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(3, 1, this.CLT);
      AppMethodBeat.o(124466);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CLT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CIQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124466);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124466);
          return -1;
        case 2: 
          localog.CIQ = locala.KhF.readString();
          AppMethodBeat.o(124466);
          return 0;
        }
        localog.CLT.add(locala.KhF.readString());
        AppMethodBeat.o(124466);
        return 0;
      }
      AppMethodBeat.o(124466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */