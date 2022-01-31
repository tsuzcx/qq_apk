package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avp
  extends com.tencent.mm.bv.a
{
  public String Label;
  public float wzW;
  public float wzX;
  public float xla;
  public String xlb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28526);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.wzW);
      paramVarArgs.q(2, this.wzX);
      paramVarArgs.q(3, this.xla);
      if (this.Label != null) {
        paramVarArgs.e(4, this.Label);
      }
      if (this.xlb != null) {
        paramVarArgs.e(5, this.xlb);
      }
      AppMethodBeat.o(28526);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 4 + 0 + (e.a.a.b.b.a.eW(2) + 4) + (e.a.a.b.b.a.eW(3) + 4);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Label);
      }
      i = paramInt;
      if (this.xlb != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xlb);
      }
      AppMethodBeat.o(28526);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28526);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      avp localavp = (avp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28526);
        return -1;
      case 1: 
        localavp.wzW = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(28526);
        return 0;
      case 2: 
        localavp.wzX = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(28526);
        return 0;
      case 3: 
        localavp.xla = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(28526);
        return 0;
      case 4: 
        localavp.Label = locala.CLY.readString();
        AppMethodBeat.o(28526);
        return 0;
      }
      localavp.xlb = locala.CLY.readString();
      AppMethodBeat.o(28526);
      return 0;
    }
    AppMethodBeat.o(28526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avp
 * JD-Core Version:    0.7.0.1
 */