package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class w
  extends com.tencent.mm.bw.a
{
  public b AqP;
  public String BHr;
  public String brand;
  public int eeA;
  public int id;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      paramVarArgs.aM(2, this.status);
      if (this.BHr != null) {
        paramVarArgs.e(3, this.BHr);
      }
      if (this.brand != null) {
        paramVarArgs.e(4, this.brand);
      }
      if (this.AqP != null) {
        paramVarArgs.c(5, this.AqP);
      }
      paramVarArgs.aM(6, this.eeA);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.status);
      paramInt = i;
      if (this.BHr != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.BHr);
      }
      i = paramInt;
      if (this.brand != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.brand);
      }
      paramInt = i;
      if (this.AqP != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.AqP);
      }
      i = g.a.a.b.b.a.bu(6, this.eeA);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localw.id = locala.UbS.zi();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localw.status = locala.UbS.zi();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localw.BHr = locala.UbS.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localw.brand = locala.UbS.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localw.AqP = locala.UbS.hPo();
        AppMethodBeat.o(27828);
        return 0;
      }
      localw.eeA = locala.UbS.zi();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.w
 * JD-Core Version:    0.7.0.1
 */