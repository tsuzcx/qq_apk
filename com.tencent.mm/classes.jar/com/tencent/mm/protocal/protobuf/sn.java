package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sn
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String ppA;
  public String qlQ;
  public String title;
  public int wKU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48821);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.ppA != null) {
        paramVarArgs.e(3, this.ppA);
      }
      if (this.qlQ != null) {
        paramVarArgs.e(4, this.qlQ);
      }
      paramVarArgs.aO(5, this.wKU);
      AppMethodBeat.o(48821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.ppA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ppA);
      }
      paramInt = i;
      if (this.qlQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.qlQ);
      }
      i = e.a.a.b.b.a.bl(5, this.wKU);
      AppMethodBeat.o(48821);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48821);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        sn localsn = (sn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48821);
          return -1;
        case 1: 
          localsn.title = locala.CLY.readString();
          AppMethodBeat.o(48821);
          return 0;
        case 2: 
          localsn.cyA = locala.CLY.readString();
          AppMethodBeat.o(48821);
          return 0;
        case 3: 
          localsn.ppA = locala.CLY.readString();
          AppMethodBeat.o(48821);
          return 0;
        case 4: 
          localsn.qlQ = locala.CLY.readString();
          AppMethodBeat.o(48821);
          return 0;
        }
        localsn.wKU = locala.CLY.sl();
        AppMethodBeat.o(48821);
        return 0;
      }
      AppMethodBeat.o(48821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sn
 * JD-Core Version:    0.7.0.1
 */