package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tr
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String iFH;
  public String iFI;
  public String iFJ;
  public String iFK;
  public int iFL;
  public String iFM;
  public int position;
  public String username;
  public int wMm;
  public int wMn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134425);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.iFH != null) {
        paramVarArgs.e(2, this.iFH);
      }
      paramVarArgs.aO(3, this.wMm);
      paramVarArgs.aO(4, this.wMn);
      if (this.iFI != null) {
        paramVarArgs.e(5, this.iFI);
      }
      if (this.cwc != null) {
        paramVarArgs.e(6, this.cwc);
      }
      if (this.iFJ != null) {
        paramVarArgs.e(7, this.iFJ);
      }
      if (this.iFK != null) {
        paramVarArgs.e(8, this.iFK);
      }
      paramVarArgs.aO(9, this.iFL);
      if (this.iFM != null) {
        paramVarArgs.e(10, this.iFM);
      }
      paramVarArgs.aO(11, this.position);
      AppMethodBeat.o(134425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iFH != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.iFH);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wMm) + e.a.a.b.b.a.bl(4, this.wMn);
      paramInt = i;
      if (this.iFI != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.iFI);
      }
      i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.cwc);
      }
      paramInt = i;
      if (this.iFJ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.iFJ);
      }
      i = paramInt;
      if (this.iFK != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.iFK);
      }
      i += e.a.a.b.b.a.bl(9, this.iFL);
      paramInt = i;
      if (this.iFM != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.iFM);
      }
      i = e.a.a.b.b.a.bl(11, this.position);
      AppMethodBeat.o(134425);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134425);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        tr localtr = (tr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134425);
          return -1;
        case 1: 
          localtr.username = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 2: 
          localtr.iFH = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 3: 
          localtr.wMm = locala.CLY.sl();
          AppMethodBeat.o(134425);
          return 0;
        case 4: 
          localtr.wMn = locala.CLY.sl();
          AppMethodBeat.o(134425);
          return 0;
        case 5: 
          localtr.iFI = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 6: 
          localtr.cwc = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 7: 
          localtr.iFJ = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 8: 
          localtr.iFK = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        case 9: 
          localtr.iFL = locala.CLY.sl();
          AppMethodBeat.o(134425);
          return 0;
        case 10: 
          localtr.iFM = locala.CLY.readString();
          AppMethodBeat.o(134425);
          return 0;
        }
        localtr.position = locala.CLY.sl();
        AppMethodBeat.o(134425);
        return 0;
      }
      AppMethodBeat.o(134425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tr
 * JD-Core Version:    0.7.0.1
 */