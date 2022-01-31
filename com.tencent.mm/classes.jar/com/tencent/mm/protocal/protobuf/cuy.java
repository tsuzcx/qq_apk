package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuy
  extends com.tencent.mm.bv.a
{
  public String nqE;
  public String num;
  public String xBK;
  public String ydG;
  public String ydH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28707);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xBK != null) {
        paramVarArgs.e(1, this.xBK);
      }
      if (this.ydG != null) {
        paramVarArgs.e(2, this.ydG);
      }
      if (this.num != null) {
        paramVarArgs.e(3, this.num);
      }
      if (this.nqE != null) {
        paramVarArgs.e(4, this.nqE);
      }
      if (this.ydH != null) {
        paramVarArgs.e(5, this.ydH);
      }
      AppMethodBeat.o(28707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xBK == null) {
        break label465;
      }
    }
    label465:
    for (int i = e.a.a.b.b.a.f(1, this.xBK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ydG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ydG);
      }
      i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.num);
      }
      paramInt = i;
      if (this.nqE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqE);
      }
      i = paramInt;
      if (this.ydH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ydH);
      }
      AppMethodBeat.o(28707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28707);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cuy localcuy = (cuy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28707);
          return -1;
        case 1: 
          localcuy.xBK = locala.CLY.readString();
          AppMethodBeat.o(28707);
          return 0;
        case 2: 
          localcuy.ydG = locala.CLY.readString();
          AppMethodBeat.o(28707);
          return 0;
        case 3: 
          localcuy.num = locala.CLY.readString();
          AppMethodBeat.o(28707);
          return 0;
        case 4: 
          localcuy.nqE = locala.CLY.readString();
          AppMethodBeat.o(28707);
          return 0;
        }
        localcuy.ydH = locala.CLY.readString();
        AppMethodBeat.o(28707);
        return 0;
      }
      AppMethodBeat.o(28707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuy
 * JD-Core Version:    0.7.0.1
 */