package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cx
  extends com.tencent.mm.bv.a
{
  public String gwQ;
  public String gwR;
  public String gwY;
  public String jJA;
  public String nqY;
  public String wpj;
  public String wpk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gwY != null) {
        paramVarArgs.e(1, this.gwY);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(2, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(3, this.gwR);
      }
      if (this.nqY != null) {
        paramVarArgs.e(4, this.nqY);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      if (this.wpj != null) {
        paramVarArgs.e(6, this.wpj);
      }
      if (this.wpk != null) {
        paramVarArgs.e(7, this.wpk);
      }
      AppMethodBeat.o(56701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gwY == null) {
        break label578;
      }
    }
    label578:
    for (int i = e.a.a.b.b.a.f(1, this.gwY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gwR);
      }
      paramInt = i;
      if (this.nqY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqY);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      paramInt = i;
      if (this.wpj != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wpj);
      }
      i = paramInt;
      if (this.wpk != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wpk);
      }
      AppMethodBeat.o(56701);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56701);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cx localcx = (cx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56701);
          return -1;
        case 1: 
          localcx.gwY = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        case 2: 
          localcx.gwQ = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        case 3: 
          localcx.gwR = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        case 4: 
          localcx.nqY = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        case 5: 
          localcx.jJA = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        case 6: 
          localcx.wpj = locala.CLY.readString();
          AppMethodBeat.o(56701);
          return 0;
        }
        localcx.wpk = locala.CLY.readString();
        AppMethodBeat.o(56701);
        return 0;
      }
      AppMethodBeat.o(56701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cx
 * JD-Core Version:    0.7.0.1
 */