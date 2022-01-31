package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeb
  extends com.tencent.mm.bv.a
{
  public int csV;
  public String id;
  public int mLg;
  public String wWY;
  public long wWZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28409);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      paramVarArgs.aO(2, this.mLg);
      if (this.wWY != null) {
        paramVarArgs.e(3, this.wWY);
      }
      paramVarArgs.am(4, this.wWZ);
      paramVarArgs.aO(5, this.csV);
      AppMethodBeat.o(28409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = e.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.mLg);
      paramInt = i;
      if (this.wWY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wWY);
      }
      i = e.a.a.b.b.a.p(4, this.wWZ);
      int j = e.a.a.b.b.a.bl(5, this.csV);
      AppMethodBeat.o(28409);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28409);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aeb localaeb = (aeb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28409);
          return -1;
        case 1: 
          localaeb.id = locala.CLY.readString();
          AppMethodBeat.o(28409);
          return 0;
        case 2: 
          localaeb.mLg = locala.CLY.sl();
          AppMethodBeat.o(28409);
          return 0;
        case 3: 
          localaeb.wWY = locala.CLY.readString();
          AppMethodBeat.o(28409);
          return 0;
        case 4: 
          localaeb.wWZ = locala.CLY.sm();
          AppMethodBeat.o(28409);
          return 0;
        }
        localaeb.csV = locala.CLY.sl();
        AppMethodBeat.o(28409);
        return 0;
      }
      AppMethodBeat.o(28409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeb
 * JD-Core Version:    0.7.0.1
 */