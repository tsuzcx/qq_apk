package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deo
  extends com.tencent.mm.bx.a
{
  public String dca;
  public String szi;
  public String vuN;
  public String vuO;
  public String vuP;
  public String vuQ;
  public String vur;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vuN != null) {
        paramVarArgs.d(1, this.vuN);
      }
      if (this.vuO != null) {
        paramVarArgs.d(2, this.vuO);
      }
      if (this.vur != null) {
        paramVarArgs.d(3, this.vur);
      }
      if (this.szi != null) {
        paramVarArgs.d(4, this.szi);
      }
      if (this.dca != null) {
        paramVarArgs.d(5, this.dca);
      }
      if (this.vuP != null) {
        paramVarArgs.d(6, this.vuP);
      }
      if (this.vuQ != null) {
        paramVarArgs.d(7, this.vuQ);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vuN == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.vuN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vuO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vuO);
      }
      i = paramInt;
      if (this.vur != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vur);
      }
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.szi);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dca);
      }
      paramInt = i;
      if (this.vuP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vuP);
      }
      i = paramInt;
      if (this.vuQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vuQ);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deo localdeo = (deo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localdeo.vuN = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localdeo.vuO = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localdeo.vur = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localdeo.szi = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localdeo.dca = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localdeo.vuP = locala.KhF.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localdeo.vuQ = locala.KhF.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deo
 * JD-Core Version:    0.7.0.1
 */