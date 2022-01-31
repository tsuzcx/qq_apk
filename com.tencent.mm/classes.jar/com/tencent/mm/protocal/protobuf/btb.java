package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btb
  extends com.tencent.mm.bv.a
{
  public String jKG;
  public String lGG;
  public String xGE;
  public String xGF;
  public String xGG;
  public String xtt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123515);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKG != null) {
        paramVarArgs.e(1, this.jKG);
      }
      if (this.xGE != null) {
        paramVarArgs.e(2, this.xGE);
      }
      if (this.xtt != null) {
        paramVarArgs.e(3, this.xtt);
      }
      if (this.xGF != null) {
        paramVarArgs.e(4, this.xGF);
      }
      if (this.lGG != null) {
        paramVarArgs.e(5, this.lGG);
      }
      if (this.xGG != null) {
        paramVarArgs.e(6, this.xGG);
      }
      AppMethodBeat.o(123515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKG == null) {
        break label518;
      }
    }
    label518:
    for (int i = e.a.a.b.b.a.f(1, this.jKG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xGE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xGE);
      }
      i = paramInt;
      if (this.xtt != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xtt);
      }
      paramInt = i;
      if (this.xGF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xGF);
      }
      i = paramInt;
      if (this.lGG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.lGG);
      }
      paramInt = i;
      if (this.xGG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xGG);
      }
      AppMethodBeat.o(123515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(123515);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        btb localbtb = (btb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123515);
          return -1;
        case 1: 
          localbtb.jKG = locala.CLY.readString();
          AppMethodBeat.o(123515);
          return 0;
        case 2: 
          localbtb.xGE = locala.CLY.readString();
          AppMethodBeat.o(123515);
          return 0;
        case 3: 
          localbtb.xtt = locala.CLY.readString();
          AppMethodBeat.o(123515);
          return 0;
        case 4: 
          localbtb.xGF = locala.CLY.readString();
          AppMethodBeat.o(123515);
          return 0;
        case 5: 
          localbtb.lGG = locala.CLY.readString();
          AppMethodBeat.o(123515);
          return 0;
        }
        localbtb.xGG = locala.CLY.readString();
        AppMethodBeat.o(123515);
        return 0;
      }
      AppMethodBeat.o(123515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btb
 * JD-Core Version:    0.7.0.1
 */