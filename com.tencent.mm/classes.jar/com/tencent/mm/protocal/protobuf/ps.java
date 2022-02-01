package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ps
  extends com.tencent.mm.bx.a
{
  public String FHb;
  public LinkedList<String> FKU;
  
  public ps()
  {
    AppMethodBeat.i(124465);
    this.FKU = new LinkedList();
    AppMethodBeat.o(124465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124466);
        throw paramVarArgs;
      }
      if (this.FHb != null) {
        paramVarArgs.d(2, this.FHb);
      }
      paramVarArgs.e(3, 1, this.FKU);
      AppMethodBeat.o(124466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHb == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(2, this.FHb) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(3, 1, this.FKU);
      AppMethodBeat.o(124466);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FKU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FHb == null)
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
        ps localps = (ps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124466);
          return -1;
        case 2: 
          localps.FHb = locala.NPN.readString();
          AppMethodBeat.o(124466);
          return 0;
        }
        localps.FKU.add(locala.NPN.readString());
        AppMethodBeat.o(124466);
        return 0;
      }
      AppMethodBeat.o(124466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */