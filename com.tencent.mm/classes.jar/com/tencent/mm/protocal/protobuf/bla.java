package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bla
  extends com.tencent.mm.bx.a
{
  public b ZTU;
  public boolean ZUd;
  public b ZUe;
  public int cancel;
  public long id;
  public String jump_id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259355);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.di(2, this.ZUd);
      if (this.ZTU != null) {
        paramVarArgs.d(3, this.ZTU);
      }
      paramVarArgs.bS(4, this.cancel);
      paramVarArgs.bv(5, this.id);
      if (this.jump_id != null) {
        paramVarArgs.g(6, this.jump_id);
      }
      if (this.ZUe != null) {
        paramVarArgs.d(7, this.ZUe);
      }
      AppMethodBeat.o(259355);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.ZTU != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZTU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.cancel) + i.a.a.b.b.a.q(5, this.id);
      paramInt = i;
      if (this.jump_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.jump_id);
      }
      i = paramInt;
      if (this.ZUe != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.ZUe);
      }
      AppMethodBeat.o(259355);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259355);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bla localbla = (bla)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259355);
        return -1;
      case 1: 
        localbla.type = locala.ajGk.aar();
        AppMethodBeat.o(259355);
        return 0;
      case 2: 
        localbla.ZUd = locala.ajGk.aai();
        AppMethodBeat.o(259355);
        return 0;
      case 3: 
        localbla.ZTU = locala.ajGk.kFX();
        AppMethodBeat.o(259355);
        return 0;
      case 4: 
        localbla.cancel = locala.ajGk.aar();
        AppMethodBeat.o(259355);
        return 0;
      case 5: 
        localbla.id = locala.ajGk.aaw();
        AppMethodBeat.o(259355);
        return 0;
      case 6: 
        localbla.jump_id = locala.ajGk.readString();
        AppMethodBeat.o(259355);
        return 0;
      }
      localbla.ZUe = locala.ajGk.kFX();
      AppMethodBeat.o(259355);
      return 0;
    }
    AppMethodBeat.o(259355);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */