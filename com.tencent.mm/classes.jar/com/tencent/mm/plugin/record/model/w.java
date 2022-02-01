package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class w
  extends com.tencent.mm.bx.a
{
  public String NAZ;
  public String brand;
  public b cookie;
  public int id;
  public int ieR;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      paramVarArgs.bS(2, this.status);
      if (this.NAZ != null) {
        paramVarArgs.g(3, this.NAZ);
      }
      if (this.brand != null) {
        paramVarArgs.g(4, this.brand);
      }
      if (this.cookie != null) {
        paramVarArgs.d(5, this.cookie);
      }
      paramVarArgs.bS(6, this.ieR);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.NAZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.NAZ);
      }
      i = paramInt;
      if (this.brand != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.brand);
      }
      paramInt = i;
      if (this.cookie != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.cookie);
      }
      i = i.a.a.b.b.a.cJ(6, this.ieR);
      AppMethodBeat.o(27828);
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
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localw.id = locala.ajGk.aar();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localw.status = locala.ajGk.aar();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localw.NAZ = locala.ajGk.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localw.brand = locala.ajGk.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localw.cookie = locala.ajGk.kFX();
        AppMethodBeat.o(27828);
        return 0;
      }
      localw.ieR = locala.ajGk.aar();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.w
 * JD-Core Version:    0.7.0.1
 */