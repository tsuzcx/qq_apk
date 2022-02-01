package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bta
  extends com.tencent.mm.bw.a
{
  public String hKR;
  public String key;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(196271);
        throw paramVarArgs;
      }
      if (this.hKR == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(196271);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.hKR != null) {
        paramVarArgs.d(3, this.hKR);
      }
      AppMethodBeat.o(196271);
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
      if (this.hKR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hKR);
      }
      AppMethodBeat.o(196271);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(196271);
        throw paramVarArgs;
      }
      if (this.hKR == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(196271);
        throw paramVarArgs;
      }
      AppMethodBeat.o(196271);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bta localbta = (bta)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196271);
        return -1;
      case 1: 
        localbta.type = locala.OmT.zc();
        AppMethodBeat.o(196271);
        return 0;
      case 2: 
        localbta.key = locala.OmT.readString();
        AppMethodBeat.o(196271);
        return 0;
      }
      localbta.hKR = locala.OmT.readString();
      AppMethodBeat.o(196271);
      return 0;
    }
    AppMethodBeat.o(196271);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bta
 * JD-Core Version:    0.7.0.1
 */