package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dv
  extends com.tencent.mm.bx.a
{
  public String dxD;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91350);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(91350);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(91350);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(91350);
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
      if (this.dxD == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91350);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(91350);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91350);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dv localdv = (dv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91350);
        return -1;
      case 1: 
        localdv.type = locala.NPN.zc();
        AppMethodBeat.o(91350);
        return 0;
      case 2: 
        localdv.dxD = locala.NPN.readString();
        AppMethodBeat.o(91350);
        return 0;
      }
      localdv.url = locala.NPN.readString();
      AppMethodBeat.o(91350);
      return 0;
    }
    AppMethodBeat.o(91350);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */