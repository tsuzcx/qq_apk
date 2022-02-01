package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crs
  extends com.tencent.mm.bx.a
{
  public String DCE;
  public String GfM;
  public long Hki;
  public int Hkj;
  public String Hkk;
  public String appId;
  public String cardId;
  public String data;
  public String dzP;
  public String kJY;
  public int pos;
  public String title;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207256);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aS(2, this.pos);
      paramVarArgs.aS(3, this.weight);
      paramVarArgs.aY(4, this.Hki);
      paramVarArgs.aS(5, this.Hkj);
      if (this.kJY != null) {
        paramVarArgs.d(6, this.kJY);
      }
      if (this.cardId != null) {
        paramVarArgs.d(7, this.cardId);
      }
      if (this.data != null) {
        paramVarArgs.d(8, this.data);
      }
      if (this.GfM != null) {
        paramVarArgs.d(9, this.GfM);
      }
      if (this.appId != null) {
        paramVarArgs.d(10, this.appId);
      }
      if (this.DCE != null) {
        paramVarArgs.d(11, this.DCE);
      }
      if (this.dzP != null) {
        paramVarArgs.d(12, this.dzP);
      }
      if (this.Hkk != null) {
        paramVarArgs.d(13, this.Hkk);
      }
      AppMethodBeat.o(207256);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.pos) + f.a.a.b.b.a.bz(3, this.weight) + f.a.a.b.b.a.p(4, this.Hki) + f.a.a.b.b.a.bz(5, this.Hkj);
      paramInt = i;
      if (this.kJY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.kJY);
      }
      i = paramInt;
      if (this.cardId != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.cardId);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.data);
      }
      i = paramInt;
      if (this.GfM != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GfM);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.appId);
      }
      i = paramInt;
      if (this.DCE != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DCE);
      }
      paramInt = i;
      if (this.dzP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dzP);
      }
      i = paramInt;
      if (this.Hkk != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Hkk);
      }
      AppMethodBeat.o(207256);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207256);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crs localcrs = (crs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207256);
          return -1;
        case 1: 
          localcrs.title = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 2: 
          localcrs.pos = locala.NPN.zc();
          AppMethodBeat.o(207256);
          return 0;
        case 3: 
          localcrs.weight = locala.NPN.zc();
          AppMethodBeat.o(207256);
          return 0;
        case 4: 
          localcrs.Hki = locala.NPN.zd();
          AppMethodBeat.o(207256);
          return 0;
        case 5: 
          localcrs.Hkj = locala.NPN.zc();
          AppMethodBeat.o(207256);
          return 0;
        case 6: 
          localcrs.kJY = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 7: 
          localcrs.cardId = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 8: 
          localcrs.data = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 9: 
          localcrs.GfM = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 10: 
          localcrs.appId = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 11: 
          localcrs.DCE = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        case 12: 
          localcrs.dzP = locala.NPN.readString();
          AppMethodBeat.o(207256);
          return 0;
        }
        localcrs.Hkk = locala.NPN.readString();
        AppMethodBeat.o(207256);
        return 0;
      }
      AppMethodBeat.o(207256);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crs
 * JD-Core Version:    0.7.0.1
 */