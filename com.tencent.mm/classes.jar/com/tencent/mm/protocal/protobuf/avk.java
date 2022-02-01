package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avk
  extends com.tencent.mm.bx.a
{
  public long Tqf;
  public String ZFC;
  public long ZFw;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257482);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      paramVarArgs.bv(2, this.ZFw);
      paramVarArgs.bv(3, this.Tqf);
      if (this.ZFC != null) {
        paramVarArgs.g(4, this.ZFC);
      }
      AppMethodBeat.o(257482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0 + i.a.a.b.b.a.q(2, this.ZFw) + i.a.a.b.b.a.q(3, this.Tqf);
      paramInt = i;
      if (this.ZFC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZFC);
      }
      AppMethodBeat.o(257482);
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
      AppMethodBeat.o(257482);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      avk localavk = (avk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257482);
        return -1;
      case 1: 
        localavk.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(257482);
        return 0;
      case 2: 
        localavk.ZFw = locala.ajGk.aaw();
        AppMethodBeat.o(257482);
        return 0;
      case 3: 
        localavk.Tqf = locala.ajGk.aaw();
        AppMethodBeat.o(257482);
        return 0;
      }
      localavk.ZFC = locala.ajGk.readString();
      AppMethodBeat.o(257482);
      return 0;
    }
    AppMethodBeat.o(257482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avk
 * JD-Core Version:    0.7.0.1
 */