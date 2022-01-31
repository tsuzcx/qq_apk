package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkg
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String fBA;
  public String iFH;
  public String iFI;
  public String iFM;
  public int position;
  public String username;
  public int wpE;
  public int xyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134434);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.iFH != null) {
        paramVarArgs.e(2, this.iFH);
      }
      if (this.fBA != null) {
        paramVarArgs.e(3, this.fBA);
      }
      if (this.iFI != null) {
        paramVarArgs.e(4, this.iFI);
      }
      if (this.cwc != null) {
        paramVarArgs.e(5, this.cwc);
      }
      if (this.iFM != null) {
        paramVarArgs.e(6, this.iFM);
      }
      paramVarArgs.aO(7, this.position);
      paramVarArgs.aO(8, this.xyI);
      paramVarArgs.aO(9, this.wpE);
      AppMethodBeat.o(134434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iFH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.iFH);
      }
      i = paramInt;
      if (this.fBA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fBA);
      }
      paramInt = i;
      if (this.iFI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.iFI);
      }
      i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cwc);
      }
      paramInt = i;
      if (this.iFM != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.iFM);
      }
      i = e.a.a.b.b.a.bl(7, this.position);
      int j = e.a.a.b.b.a.bl(8, this.xyI);
      int k = e.a.a.b.b.a.bl(9, this.wpE);
      AppMethodBeat.o(134434);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134434);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134434);
          return -1;
        case 1: 
          localbkg.username = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 2: 
          localbkg.iFH = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 3: 
          localbkg.fBA = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 4: 
          localbkg.iFI = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 5: 
          localbkg.cwc = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 6: 
          localbkg.iFM = locala.CLY.readString();
          AppMethodBeat.o(134434);
          return 0;
        case 7: 
          localbkg.position = locala.CLY.sl();
          AppMethodBeat.o(134434);
          return 0;
        case 8: 
          localbkg.xyI = locala.CLY.sl();
          AppMethodBeat.o(134434);
          return 0;
        }
        localbkg.wpE = locala.CLY.sl();
        AppMethodBeat.o(134434);
        return 0;
      }
      AppMethodBeat.o(134434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkg
 * JD-Core Version:    0.7.0.1
 */