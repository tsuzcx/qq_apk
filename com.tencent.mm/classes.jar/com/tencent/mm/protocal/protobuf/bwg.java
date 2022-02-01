package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwg
  extends com.tencent.mm.bx.a
{
  public int aaeL;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258606);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(2, this.object_nonce_id);
      }
      paramVarArgs.bS(3, this.aaeL);
      AppMethodBeat.o(258606);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.object_nonce_id);
      }
      i = i.a.a.b.b.a.cJ(3, this.aaeL);
      AppMethodBeat.o(258606);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258606);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bwg localbwg = (bwg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258606);
        return -1;
      case 1: 
        localbwg.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(258606);
        return 0;
      case 2: 
        localbwg.object_nonce_id = locala.ajGk.readString();
        AppMethodBeat.o(258606);
        return 0;
      }
      localbwg.aaeL = locala.ajGk.aar();
      AppMethodBeat.o(258606);
      return 0;
    }
    AppMethodBeat.o(258606);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwg
 * JD-Core Version:    0.7.0.1
 */