package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjb
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String ProductID;
  public String ZtY;
  public String Zul;
  public String Zuw;
  public int Zvi;
  public String akkA;
  public String akkB;
  public String akkC;
  public String akka;
  public String akkb;
  public String akkc;
  public int akkd;
  public int akke;
  public int akkh;
  public String akki;
  public String akkj;
  public String akkk;
  public String akko;
  public int akkv;
  public int akkw;
  public String akkz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104781);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.g(1, this.ProductID);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.Zul != null) {
        paramVarArgs.g(3, this.Zul);
      }
      if (this.akka != null) {
        paramVarArgs.g(4, this.akka);
      }
      if (this.akkb != null) {
        paramVarArgs.g(5, this.akkb);
      }
      if (this.akkc != null) {
        paramVarArgs.g(6, this.akkc);
      }
      paramVarArgs.bS(7, this.akkd);
      paramVarArgs.bS(8, this.akke);
      if (this.ZtY != null) {
        paramVarArgs.g(9, this.ZtY);
      }
      paramVarArgs.bS(10, this.akkh);
      if (this.akki != null) {
        paramVarArgs.g(11, this.akki);
      }
      paramVarArgs.bS(12, this.Zvi);
      if (this.akkk != null) {
        paramVarArgs.g(13, this.akkk);
      }
      if (this.akkj != null) {
        paramVarArgs.g(14, this.akkj);
      }
      if (this.Zuw != null) {
        paramVarArgs.g(15, this.Zuw);
      }
      if (this.akkz != null) {
        paramVarArgs.g(16, this.akkz);
      }
      if (this.akko != null) {
        paramVarArgs.g(17, this.akko);
      }
      if (this.akkA != null) {
        paramVarArgs.g(18, this.akkA);
      }
      if (this.akkB != null) {
        paramVarArgs.g(19, this.akkB);
      }
      if (this.akkC != null) {
        paramVarArgs.g(20, this.akkC);
      }
      paramVarArgs.bS(21, this.akkv);
      paramVarArgs.bS(22, this.akkw);
      AppMethodBeat.o(104781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label1410;
      }
    }
    label1410:
    for (int i = i.a.a.b.b.a.h(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.Zul != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zul);
      }
      paramInt = i;
      if (this.akka != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.akka);
      }
      i = paramInt;
      if (this.akkb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.akkb);
      }
      paramInt = i;
      if (this.akkc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.akkc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.akkd) + i.a.a.b.b.a.cJ(8, this.akke);
      paramInt = i;
      if (this.ZtY != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZtY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.akkh);
      paramInt = i;
      if (this.akki != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.akki);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Zvi);
      paramInt = i;
      if (this.akkk != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.akkk);
      }
      i = paramInt;
      if (this.akkj != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.akkj);
      }
      paramInt = i;
      if (this.Zuw != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Zuw);
      }
      i = paramInt;
      if (this.akkz != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.akkz);
      }
      paramInt = i;
      if (this.akko != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.akko);
      }
      i = paramInt;
      if (this.akkA != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.akkA);
      }
      paramInt = i;
      if (this.akkB != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.akkB);
      }
      i = paramInt;
      if (this.akkC != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.akkC);
      }
      paramInt = i.a.a.b.b.a.cJ(21, this.akkv);
      int j = i.a.a.b.b.a.cJ(22, this.akkw);
      AppMethodBeat.o(104781);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104781);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cjb localcjb = (cjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104781);
          return -1;
        case 1: 
          localcjb.ProductID = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 2: 
          localcjb.IHo = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 3: 
          localcjb.Zul = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 4: 
          localcjb.akka = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 5: 
          localcjb.akkb = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 6: 
          localcjb.akkc = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 7: 
          localcjb.akkd = locala.ajGk.aar();
          AppMethodBeat.o(104781);
          return 0;
        case 8: 
          localcjb.akke = locala.ajGk.aar();
          AppMethodBeat.o(104781);
          return 0;
        case 9: 
          localcjb.ZtY = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 10: 
          localcjb.akkh = locala.ajGk.aar();
          AppMethodBeat.o(104781);
          return 0;
        case 11: 
          localcjb.akki = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 12: 
          localcjb.Zvi = locala.ajGk.aar();
          AppMethodBeat.o(104781);
          return 0;
        case 13: 
          localcjb.akkk = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 14: 
          localcjb.akkj = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 15: 
          localcjb.Zuw = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 16: 
          localcjb.akkz = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 17: 
          localcjb.akko = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 18: 
          localcjb.akkA = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 19: 
          localcjb.akkB = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 20: 
          localcjb.akkC = locala.ajGk.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 21: 
          localcjb.akkv = locala.ajGk.aar();
          AppMethodBeat.o(104781);
          return 0;
        }
        localcjb.akkw = locala.ajGk.aar();
        AppMethodBeat.o(104781);
        return 0;
      }
      AppMethodBeat.o(104781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjb
 * JD-Core Version:    0.7.0.1
 */