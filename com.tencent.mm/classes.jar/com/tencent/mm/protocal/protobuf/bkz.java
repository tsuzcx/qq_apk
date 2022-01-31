package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkz
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String kmm;
  public String wFW;
  public int xzF;
  public String xzG;
  public String xzH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56884);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      paramVarArgs.aO(2, this.xzF);
      if (this.xzG != null) {
        paramVarArgs.e(3, this.xzG);
      }
      if (this.xzH != null) {
        paramVarArgs.e(4, this.xzH);
      }
      if (this.wFW != null) {
        paramVarArgs.e(5, this.wFW);
      }
      if (this.kmm != null) {
        paramVarArgs.e(6, this.kmm);
      }
      AppMethodBeat.o(56884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xzF);
      paramInt = i;
      if (this.xzG != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xzG);
      }
      i = paramInt;
      if (this.xzH != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xzH);
      }
      paramInt = i;
      if (this.wFW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wFW);
      }
      i = paramInt;
      if (this.kmm != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.kmm);
      }
      AppMethodBeat.o(56884);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56884);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkz localbkz = (bkz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56884);
          return -1;
        case 1: 
          localbkz.cwc = locala.CLY.readString();
          AppMethodBeat.o(56884);
          return 0;
        case 2: 
          localbkz.xzF = locala.CLY.sl();
          AppMethodBeat.o(56884);
          return 0;
        case 3: 
          localbkz.xzG = locala.CLY.readString();
          AppMethodBeat.o(56884);
          return 0;
        case 4: 
          localbkz.xzH = locala.CLY.readString();
          AppMethodBeat.o(56884);
          return 0;
        case 5: 
          localbkz.wFW = locala.CLY.readString();
          AppMethodBeat.o(56884);
          return 0;
        }
        localbkz.kmm = locala.CLY.readString();
        AppMethodBeat.o(56884);
        return 0;
      }
      AppMethodBeat.o(56884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkz
 * JD-Core Version:    0.7.0.1
 */