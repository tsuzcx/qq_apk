package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bsg
  extends com.tencent.mm.bx.a
{
  public String hHZ;
  public String key;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210604);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(210604);
        throw paramVarArgs;
      }
      if (this.hHZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(210604);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.hHZ != null) {
        paramVarArgs.d(3, this.hHZ);
      }
      AppMethodBeat.o(210604);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.hHZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hHZ);
      }
      AppMethodBeat.o(210604);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(210604);
        throw paramVarArgs;
      }
      if (this.hHZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(210604);
        throw paramVarArgs;
      }
      AppMethodBeat.o(210604);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsg localbsg = (bsg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210604);
        return -1;
      case 1: 
        localbsg.type = locala.NPN.zc();
        AppMethodBeat.o(210604);
        return 0;
      case 2: 
        localbsg.key = locala.NPN.readString();
        AppMethodBeat.o(210604);
        return 0;
      }
      localbsg.hHZ = locala.NPN.readString();
      AppMethodBeat.o(210604);
      return 0;
    }
    AppMethodBeat.o(210604);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsg
 * JD-Core Version:    0.7.0.1
 */