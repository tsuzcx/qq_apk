package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class due
  extends com.tencent.mm.cd.a
{
  public String PzO;
  public String SwG;
  public long Uaw;
  public int Uax;
  public String Uay;
  public String appId;
  public String businessId;
  public String cardId;
  public String data;
  public String fMh;
  public int pos;
  public String title;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      paramVarArgs.aY(2, this.pos);
      paramVarArgs.aY(3, this.weight);
      paramVarArgs.bm(4, this.Uaw);
      paramVarArgs.aY(5, this.Uax);
      if (this.businessId != null) {
        paramVarArgs.f(6, this.businessId);
      }
      if (this.cardId != null) {
        paramVarArgs.f(7, this.cardId);
      }
      if (this.data != null) {
        paramVarArgs.f(8, this.data);
      }
      if (this.SwG != null) {
        paramVarArgs.f(9, this.SwG);
      }
      if (this.appId != null) {
        paramVarArgs.f(10, this.appId);
      }
      if (this.PzO != null) {
        paramVarArgs.f(11, this.PzO);
      }
      if (this.fMh != null) {
        paramVarArgs.f(12, this.fMh);
      }
      if (this.Uay != null) {
        paramVarArgs.f(13, this.Uay);
      }
      AppMethodBeat.o(208958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.pos) + g.a.a.b.b.a.bM(3, this.weight) + g.a.a.b.b.a.p(4, this.Uaw) + g.a.a.b.b.a.bM(5, this.Uax);
      paramInt = i;
      if (this.businessId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.businessId);
      }
      i = paramInt;
      if (this.cardId != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.cardId);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.data);
      }
      i = paramInt;
      if (this.SwG != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SwG);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.appId);
      }
      i = paramInt;
      if (this.PzO != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.PzO);
      }
      paramInt = i;
      if (this.fMh != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.fMh);
      }
      i = paramInt;
      if (this.Uay != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.Uay);
      }
      AppMethodBeat.o(208958);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208958);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        due localdue = (due)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208958);
          return -1;
        case 1: 
          localdue.title = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 2: 
          localdue.pos = locala.abFh.AK();
          AppMethodBeat.o(208958);
          return 0;
        case 3: 
          localdue.weight = locala.abFh.AK();
          AppMethodBeat.o(208958);
          return 0;
        case 4: 
          localdue.Uaw = locala.abFh.AN();
          AppMethodBeat.o(208958);
          return 0;
        case 5: 
          localdue.Uax = locala.abFh.AK();
          AppMethodBeat.o(208958);
          return 0;
        case 6: 
          localdue.businessId = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 7: 
          localdue.cardId = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 8: 
          localdue.data = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 9: 
          localdue.SwG = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 10: 
          localdue.appId = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 11: 
          localdue.PzO = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        case 12: 
          localdue.fMh = locala.abFh.readString();
          AppMethodBeat.o(208958);
          return 0;
        }
        localdue.Uay = locala.abFh.readString();
        AppMethodBeat.o(208958);
        return 0;
      }
      AppMethodBeat.o(208958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.due
 * JD-Core Version:    0.7.0.1
 */