package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rd
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public String wJp;
  public String wJq;
  public String wJr;
  public int wJs;
  public String wJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60027);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.wJp != null) {
        paramVarArgs.e(3, this.wJp);
      }
      if (this.wJq != null) {
        paramVarArgs.e(4, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(5, this.wJr);
      }
      paramVarArgs.aO(6, this.wJs);
      if (this.wJt != null) {
        paramVarArgs.e(7, this.wJt);
      }
      AppMethodBeat.o(60027);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label562;
      }
    }
    label562:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.wJp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJp);
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wJr);
      }
      i += e.a.a.b.b.a.bl(6, this.wJs);
      paramInt = i;
      if (this.wJt != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wJt);
      }
      AppMethodBeat.o(60027);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60027);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60027);
          return -1;
        case 1: 
          localrd.jJA = locala.CLY.readString();
          AppMethodBeat.o(60027);
          return 0;
        case 2: 
          localrd.jKG = locala.CLY.readString();
          AppMethodBeat.o(60027);
          return 0;
        case 3: 
          localrd.wJp = locala.CLY.readString();
          AppMethodBeat.o(60027);
          return 0;
        case 4: 
          localrd.wJq = locala.CLY.readString();
          AppMethodBeat.o(60027);
          return 0;
        case 5: 
          localrd.wJr = locala.CLY.readString();
          AppMethodBeat.o(60027);
          return 0;
        case 6: 
          localrd.wJs = locala.CLY.sl();
          AppMethodBeat.o(60027);
          return 0;
        }
        localrd.wJt = locala.CLY.readString();
        AppMethodBeat.o(60027);
        return 0;
      }
      AppMethodBeat.o(60027);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */