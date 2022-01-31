package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class beb
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public String ntn;
  public String qsu;
  public String xtQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51432);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntn != null) {
        paramVarArgs.e(1, this.ntn);
      }
      if (this.xtQ != null) {
        paramVarArgs.e(2, this.xtQ);
      }
      if (this.qsu != null) {
        paramVarArgs.e(3, this.qsu);
      }
      paramVarArgs.aO(4, this.jKs);
      AppMethodBeat.o(51432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntn == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.ntn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xtQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xtQ);
      }
      i = paramInt;
      if (this.qsu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qsu);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.jKs);
      AppMethodBeat.o(51432);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51432);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        beb localbeb = (beb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51432);
          return -1;
        case 1: 
          localbeb.ntn = locala.CLY.readString();
          AppMethodBeat.o(51432);
          return 0;
        case 2: 
          localbeb.xtQ = locala.CLY.readString();
          AppMethodBeat.o(51432);
          return 0;
        case 3: 
          localbeb.qsu = locala.CLY.readString();
          AppMethodBeat.o(51432);
          return 0;
        }
        localbeb.jKs = locala.CLY.sl();
        AppMethodBeat.o(51432);
        return 0;
      }
      AppMethodBeat.o(51432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beb
 * JD-Core Version:    0.7.0.1
 */