package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ub
  extends com.tencent.mm.bx.a
{
  public int YZL;
  public int YZM;
  public int item_type;
  public b wuZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259210);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YZL);
      paramVarArgs.bS(2, this.item_type);
      if (this.wuZ != null) {
        paramVarArgs.d(3, this.wuZ);
      }
      paramVarArgs.bS(4, this.YZM);
      AppMethodBeat.o(259210);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YZL) + 0 + i.a.a.b.b.a.cJ(2, this.item_type);
      paramInt = i;
      if (this.wuZ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.wuZ);
      }
      i = i.a.a.b.b.a.cJ(4, this.YZM);
      AppMethodBeat.o(259210);
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
      AppMethodBeat.o(259210);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ub localub = (ub)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259210);
        return -1;
      case 1: 
        localub.YZL = locala.ajGk.aar();
        AppMethodBeat.o(259210);
        return 0;
      case 2: 
        localub.item_type = locala.ajGk.aar();
        AppMethodBeat.o(259210);
        return 0;
      case 3: 
        localub.wuZ = locala.ajGk.kFX();
        AppMethodBeat.o(259210);
        return 0;
      }
      localub.YZM = locala.ajGk.aar();
      AppMethodBeat.o(259210);
      return 0;
    }
    AppMethodBeat.o(259210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */