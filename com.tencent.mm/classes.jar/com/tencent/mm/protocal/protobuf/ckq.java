package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckq
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String Title;
  public int niK;
  public String ntu;
  public String wNY;
  public int wqO;
  public String xHJ;
  public String xHX;
  public String xIg;
  public String xUC;
  public String xUD;
  public String xUE;
  public String xqX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124367);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xHX != null) {
        paramVarArgs.e(1, this.xHX);
      }
      if (this.xHJ != null) {
        paramVarArgs.e(2, this.xHJ);
      }
      if (this.ntu != null) {
        paramVarArgs.e(3, this.ntu);
      }
      if (this.xUC != null) {
        paramVarArgs.e(4, this.xUC);
      }
      if (this.xUD != null) {
        paramVarArgs.e(5, this.xUD);
      }
      if (this.xUE != null) {
        paramVarArgs.e(6, this.xUE);
      }
      if (this.Title != null) {
        paramVarArgs.e(7, this.Title);
      }
      if (this.xqX != null) {
        paramVarArgs.e(8, this.xqX);
      }
      paramVarArgs.aO(9, this.Scene);
      paramVarArgs.aO(10, this.wqO);
      if (this.xIg != null) {
        paramVarArgs.e(11, this.xIg);
      }
      if (this.wNY != null) {
        paramVarArgs.e(12, this.wNY);
      }
      paramVarArgs.aO(13, this.niK);
      AppMethodBeat.o(124367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xHX == null) {
        break label902;
      }
    }
    label902:
    for (int i = e.a.a.b.b.a.f(1, this.xHX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xHJ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xHJ);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntu);
      }
      paramInt = i;
      if (this.xUC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xUC);
      }
      i = paramInt;
      if (this.xUD != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xUD);
      }
      paramInt = i;
      if (this.xUE != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xUE);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.Title);
      }
      paramInt = i;
      if (this.xqX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xqX);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.Scene) + e.a.a.b.b.a.bl(10, this.wqO);
      paramInt = i;
      if (this.xIg != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xIg);
      }
      i = paramInt;
      if (this.wNY != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wNY);
      }
      paramInt = e.a.a.b.b.a.bl(13, this.niK);
      AppMethodBeat.o(124367);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124367);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckq localckq = (ckq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124367);
          return -1;
        case 1: 
          localckq.xHX = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 2: 
          localckq.xHJ = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 3: 
          localckq.ntu = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 4: 
          localckq.xUC = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 5: 
          localckq.xUD = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 6: 
          localckq.xUE = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 7: 
          localckq.Title = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 8: 
          localckq.xqX = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 9: 
          localckq.Scene = locala.CLY.sl();
          AppMethodBeat.o(124367);
          return 0;
        case 10: 
          localckq.wqO = locala.CLY.sl();
          AppMethodBeat.o(124367);
          return 0;
        case 11: 
          localckq.xIg = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        case 12: 
          localckq.wNY = locala.CLY.readString();
          AppMethodBeat.o(124367);
          return 0;
        }
        localckq.niK = locala.CLY.sl();
        AppMethodBeat.o(124367);
        return 0;
      }
      AppMethodBeat.o(124367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckq
 * JD-Core Version:    0.7.0.1
 */