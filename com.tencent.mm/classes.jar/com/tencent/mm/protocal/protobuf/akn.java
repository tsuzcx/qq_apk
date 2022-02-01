package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class akn
  extends com.tencent.mm.bx.a
{
  public String ACS;
  public String GjF;
  public int cao;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ACS == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.GjF == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.ACS != null) {
        paramVarArgs.d(1, this.ACS);
      }
      if (this.GjF != null) {
        paramVarArgs.d(2, this.GjF);
      }
      paramVarArgs.aS(3, this.cao);
      AppMethodBeat.o(127485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ACS == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.ACS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GjF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GjF);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.cao);
      AppMethodBeat.o(127485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ACS == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        if (this.GjF == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127485);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akn localakn = (akn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127485);
          return -1;
        case 1: 
          localakn.ACS = locala.NPN.readString();
          AppMethodBeat.o(127485);
          return 0;
        case 2: 
          localakn.GjF = locala.NPN.readString();
          AppMethodBeat.o(127485);
          return 0;
        }
        localakn.cao = locala.NPN.zc();
        AppMethodBeat.o(127485);
        return 0;
      }
      AppMethodBeat.o(127485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akn
 * JD-Core Version:    0.7.0.1
 */