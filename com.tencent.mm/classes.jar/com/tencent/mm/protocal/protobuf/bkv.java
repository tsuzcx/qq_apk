package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bkv
  extends com.tencent.mm.bx.a
{
  public b ZTU;
  public boolean ZTV;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.bS(2, this.type);
      if (this.ZTU != null) {
        paramVarArgs.d(3, this.ZTU);
      }
      paramVarArgs.di(4, this.ZTV);
      AppMethodBeat.o(259445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.ZTU != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZTU);
      }
      i = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259445);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259445);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bkv localbkv = (bkv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259445);
        return -1;
      case 1: 
        localbkv.id = locala.ajGk.aaw();
        AppMethodBeat.o(259445);
        return 0;
      case 2: 
        localbkv.type = locala.ajGk.aar();
        AppMethodBeat.o(259445);
        return 0;
      case 3: 
        localbkv.ZTU = locala.ajGk.kFX();
        AppMethodBeat.o(259445);
        return 0;
      }
      localbkv.ZTV = locala.ajGk.aai();
      AppMethodBeat.o(259445);
      return 0;
    }
    AppMethodBeat.o(259445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkv
 * JD-Core Version:    0.7.0.1
 */