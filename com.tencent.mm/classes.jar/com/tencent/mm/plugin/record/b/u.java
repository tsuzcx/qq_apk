package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class u
  extends com.tencent.mm.bv.a
{
  public int cKx;
  public String fwM;
  public int id;
  public String pYY;
  public b pYZ;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153605);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      paramVarArgs.aO(2, this.status);
      if (this.pYY != null) {
        paramVarArgs.e(3, this.pYY);
      }
      if (this.fwM != null) {
        paramVarArgs.e(4, this.fwM);
      }
      if (this.pYZ != null) {
        paramVarArgs.c(5, this.pYZ);
      }
      paramVarArgs.aO(6, this.cKx);
      AppMethodBeat.o(153605);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0 + e.a.a.b.b.a.bl(2, this.status);
      paramInt = i;
      if (this.pYY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.pYY);
      }
      i = paramInt;
      if (this.fwM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.fwM);
      }
      paramInt = i;
      if (this.pYZ != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.pYZ);
      }
      i = e.a.a.b.b.a.bl(6, this.cKx);
      AppMethodBeat.o(153605);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(153605);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153605);
        return -1;
      case 1: 
        localu.id = locala.CLY.sl();
        AppMethodBeat.o(153605);
        return 0;
      case 2: 
        localu.status = locala.CLY.sl();
        AppMethodBeat.o(153605);
        return 0;
      case 3: 
        localu.pYY = locala.CLY.readString();
        AppMethodBeat.o(153605);
        return 0;
      case 4: 
        localu.fwM = locala.CLY.readString();
        AppMethodBeat.o(153605);
        return 0;
      case 5: 
        localu.pYZ = locala.CLY.eqS();
        AppMethodBeat.o(153605);
        return 0;
      }
      localu.cKx = locala.CLY.sl();
      AppMethodBeat.o(153605);
      return 0;
    }
    AppMethodBeat.o(153605);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */