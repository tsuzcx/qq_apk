package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbr
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String cwc;
  public String username;
  public int wwX;
  public int xmQ;
  public int xqL;
  public int xqM;
  public String xqN;
  public int xqO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102382);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aO(3, this.xmQ);
      paramVarArgs.aO(4, this.wwX);
      paramVarArgs.aO(5, this.Scene);
      paramVarArgs.aO(6, this.xqL);
      paramVarArgs.aO(7, this.xqM);
      if (this.xqN != null) {
        paramVarArgs.e(8, this.xqN);
      }
      paramVarArgs.aO(9, this.xqO);
      AppMethodBeat.o(102382);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.username);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xmQ) + e.a.a.b.b.a.bl(4, this.wwX) + e.a.a.b.b.a.bl(5, this.Scene) + e.a.a.b.b.a.bl(6, this.xqL) + e.a.a.b.b.a.bl(7, this.xqM);
      paramInt = i;
      if (this.xqN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xqN);
      }
      i = e.a.a.b.b.a.bl(9, this.xqO);
      AppMethodBeat.o(102382);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102382);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bbr localbbr = (bbr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102382);
          return -1;
        case 1: 
          localbbr.cwc = locala.CLY.readString();
          AppMethodBeat.o(102382);
          return 0;
        case 2: 
          localbbr.username = locala.CLY.readString();
          AppMethodBeat.o(102382);
          return 0;
        case 3: 
          localbbr.xmQ = locala.CLY.sl();
          AppMethodBeat.o(102382);
          return 0;
        case 4: 
          localbbr.wwX = locala.CLY.sl();
          AppMethodBeat.o(102382);
          return 0;
        case 5: 
          localbbr.Scene = locala.CLY.sl();
          AppMethodBeat.o(102382);
          return 0;
        case 6: 
          localbbr.xqL = locala.CLY.sl();
          AppMethodBeat.o(102382);
          return 0;
        case 7: 
          localbbr.xqM = locala.CLY.sl();
          AppMethodBeat.o(102382);
          return 0;
        case 8: 
          localbbr.xqN = locala.CLY.readString();
          AppMethodBeat.o(102382);
          return 0;
        }
        localbbr.xqO = locala.CLY.sl();
        AppMethodBeat.o(102382);
        return 0;
      }
      AppMethodBeat.o(102382);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbr
 * JD-Core Version:    0.7.0.1
 */