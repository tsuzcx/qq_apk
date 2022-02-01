package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azz
  extends com.tencent.mm.bw.a
{
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209625);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.e(2, this.object_nonce_id);
      }
      AppMethodBeat.o(209625);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.object_nonce_id);
      }
      AppMethodBeat.o(209625);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209625);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azz localazz = (azz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209625);
        return -1;
      case 1: 
        localazz.object_id = locala.UbS.zl();
        AppMethodBeat.o(209625);
        return 0;
      }
      localazz.object_nonce_id = locala.UbS.readString();
      AppMethodBeat.o(209625);
      return 0;
    }
    AppMethodBeat.o(209625);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azz
 * JD-Core Version:    0.7.0.1
 */