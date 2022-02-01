package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bns
  extends com.tencent.mm.bx.a
{
  public String ZWp;
  public long mMJ;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258682);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      paramVarArgs.bv(2, this.mMJ);
      paramVarArgs.bS(3, this.scene);
      if (this.ZWp != null) {
        paramVarArgs.g(4, this.ZWp);
      }
      AppMethodBeat.o(258682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0 + i.a.a.b.b.a.q(2, this.mMJ) + i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.ZWp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZWp);
      }
      AppMethodBeat.o(258682);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258682);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bns localbns = (bns)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258682);
        return -1;
      case 1: 
        localbns.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(258682);
        return 0;
      case 2: 
        localbns.mMJ = locala.ajGk.aaw();
        AppMethodBeat.o(258682);
        return 0;
      case 3: 
        localbns.scene = locala.ajGk.aar();
        AppMethodBeat.o(258682);
        return 0;
      }
      localbns.ZWp = locala.ajGk.readString();
      AppMethodBeat.o(258682);
      return 0;
    }
    AppMethodBeat.o(258682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bns
 * JD-Core Version:    0.7.0.1
 */