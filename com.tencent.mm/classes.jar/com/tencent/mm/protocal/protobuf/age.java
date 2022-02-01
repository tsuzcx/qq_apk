package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class age
  extends com.tencent.mm.bx.a
{
  public int Geg;
  public String Geh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Geh == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Geg);
      if (this.Geh != null) {
        paramVarArgs.d(2, this.Geh);
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Geg) + 0;
      paramInt = i;
      if (this.Geh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Geh);
      }
      AppMethodBeat.o(104760);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Geh == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      age localage = (age)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104760);
        return -1;
      case 1: 
        localage.Geg = locala.NPN.zc();
        AppMethodBeat.o(104760);
        return 0;
      }
      localage.Geh = locala.NPN.readString();
      AppMethodBeat.o(104760);
      return 0;
    }
    AppMethodBeat.o(104760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.age
 * JD-Core Version:    0.7.0.1
 */