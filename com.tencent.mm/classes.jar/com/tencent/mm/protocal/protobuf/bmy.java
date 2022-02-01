package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmy
  extends com.tencent.mm.bx.a
{
  public int ZVE;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258896);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(2, this.object_nonce_id);
      }
      paramVarArgs.bv(3, this.mMJ);
      paramVarArgs.bS(4, this.ZVE);
      AppMethodBeat.o(258896);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.object_nonce_id);
      }
      i = i.a.a.b.b.a.q(3, this.mMJ);
      int j = i.a.a.b.b.a.cJ(4, this.ZVE);
      AppMethodBeat.o(258896);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258896);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmy localbmy = (bmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258896);
        return -1;
      case 1: 
        localbmy.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(258896);
        return 0;
      case 2: 
        localbmy.object_nonce_id = locala.ajGk.readString();
        AppMethodBeat.o(258896);
        return 0;
      case 3: 
        localbmy.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(258896);
        return 0;
      }
      localbmy.ZVE = locala.ajGk.aar();
      AppMethodBeat.o(258896);
      return 0;
    }
    AppMethodBeat.o(258896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */