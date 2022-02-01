package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cky
  extends com.tencent.mm.bx.a
{
  public int Egv;
  public String Egw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egw == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Egv);
      if (this.Egw != null) {
        paramVarArgs.d(2, this.Egw);
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Egv) + 0;
      paramInt = i;
      if (this.Egw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Egw);
      }
      AppMethodBeat.o(152669);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Egw == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cky localcky = (cky)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152669);
        return -1;
      case 1: 
        localcky.Egv = locala.KhF.xS();
        AppMethodBeat.o(152669);
        return 0;
      }
      localcky.Egw = locala.KhF.readString();
      AppMethodBeat.o(152669);
      return 0;
    }
    AppMethodBeat.o(152669);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */