package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class qv
  extends com.tencent.mm.bw.a
{
  public String KTt;
  public LinkedList<String> KXK;
  
  public qv()
  {
    AppMethodBeat.i(124465);
    this.KXK = new LinkedList();
    AppMethodBeat.o(124465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124466);
        throw paramVarArgs;
      }
      if (this.KTt != null) {
        paramVarArgs.e(2, this.KTt);
      }
      paramVarArgs.e(3, 1, this.KXK);
      AppMethodBeat.o(124466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTt == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.f(2, this.KTt) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(3, 1, this.KXK);
      AppMethodBeat.o(124466);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KXK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KTt == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qv localqv = (qv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124466);
          return -1;
        case 2: 
          localqv.KTt = locala.UbS.readString();
          AppMethodBeat.o(124466);
          return 0;
        }
        localqv.KXK.add(locala.UbS.readString());
        AppMethodBeat.o(124466);
        return 0;
      }
      AppMethodBeat.o(124466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */