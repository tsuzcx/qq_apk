package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cks
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int niK;
  public int nrS;
  public String ntu;
  public String wNY;
  public int wqO;
  public String xHJ;
  public String xHX;
  public String xIg;
  public String xUF;
  public String xqX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124369);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xHJ != null) {
        paramVarArgs.e(1, this.xHJ);
      }
      if (this.xUF != null) {
        paramVarArgs.e(2, this.xUF);
      }
      paramVarArgs.aO(3, this.nrS);
      if (this.xHX != null) {
        paramVarArgs.e(4, this.xHX);
      }
      if (this.ntu != null) {
        paramVarArgs.e(5, this.ntu);
      }
      paramVarArgs.aO(6, this.Scene);
      if (this.xqX != null) {
        paramVarArgs.e(7, this.xqX);
      }
      paramVarArgs.aO(8, this.wqO);
      if (this.wNY != null) {
        paramVarArgs.e(9, this.wNY);
      }
      if (this.xIg != null) {
        paramVarArgs.e(10, this.xIg);
      }
      paramVarArgs.aO(11, this.niK);
      AppMethodBeat.o(124369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xHJ == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = e.a.a.b.b.a.f(1, this.xHJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xUF != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xUF);
      }
      i += e.a.a.b.b.a.bl(3, this.nrS);
      paramInt = i;
      if (this.xHX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xHX);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ntu);
      }
      i += e.a.a.b.b.a.bl(6, this.Scene);
      paramInt = i;
      if (this.xqX != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xqX);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.wqO);
      paramInt = i;
      if (this.wNY != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wNY);
      }
      i = paramInt;
      if (this.xIg != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xIg);
      }
      paramInt = e.a.a.b.b.a.bl(11, this.niK);
      AppMethodBeat.o(124369);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124369);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cks localcks = (cks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124369);
          return -1;
        case 1: 
          localcks.xHJ = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 2: 
          localcks.xUF = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 3: 
          localcks.nrS = locala.CLY.sl();
          AppMethodBeat.o(124369);
          return 0;
        case 4: 
          localcks.xHX = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 5: 
          localcks.ntu = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 6: 
          localcks.Scene = locala.CLY.sl();
          AppMethodBeat.o(124369);
          return 0;
        case 7: 
          localcks.xqX = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 8: 
          localcks.wqO = locala.CLY.sl();
          AppMethodBeat.o(124369);
          return 0;
        case 9: 
          localcks.wNY = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        case 10: 
          localcks.xIg = locala.CLY.readString();
          AppMethodBeat.o(124369);
          return 0;
        }
        localcks.niK = locala.CLY.sl();
        AppMethodBeat.o(124369);
        return 0;
      }
      AppMethodBeat.o(124369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cks
 * JD-Core Version:    0.7.0.1
 */