package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class bep
  extends com.tencent.mm.bv.a
{
  public String wJq;
  public String wJr;
  public int wzY;
  public int xud;
  public b xue;
  public String xuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28556);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wzY);
      paramVarArgs.aO(2, this.xud);
      if (this.xue != null) {
        paramVarArgs.c(3, this.xue);
      }
      if (this.xuf != null) {
        paramVarArgs.e(4, this.xuf);
      }
      if (this.wJq != null) {
        paramVarArgs.e(5, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(6, this.wJr);
      }
      AppMethodBeat.o(28556);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wzY) + 0 + e.a.a.b.b.a.bl(2, this.xud);
      paramInt = i;
      if (this.xue != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.xue);
      }
      i = paramInt;
      if (this.xuf != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xuf);
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wJr);
      }
      AppMethodBeat.o(28556);
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
      AppMethodBeat.o(28556);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bep localbep = (bep)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28556);
        return -1;
      case 1: 
        localbep.wzY = locala.CLY.sl();
        AppMethodBeat.o(28556);
        return 0;
      case 2: 
        localbep.xud = locala.CLY.sl();
        AppMethodBeat.o(28556);
        return 0;
      case 3: 
        localbep.xue = locala.CLY.eqS();
        AppMethodBeat.o(28556);
        return 0;
      case 4: 
        localbep.xuf = locala.CLY.readString();
        AppMethodBeat.o(28556);
        return 0;
      case 5: 
        localbep.wJq = locala.CLY.readString();
        AppMethodBeat.o(28556);
        return 0;
      }
      localbep.wJr = locala.CLY.readString();
      AppMethodBeat.o(28556);
      return 0;
    }
    AppMethodBeat.o(28556);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bep
 * JD-Core Version:    0.7.0.1
 */