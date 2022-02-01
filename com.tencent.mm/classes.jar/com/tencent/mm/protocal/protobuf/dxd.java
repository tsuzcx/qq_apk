package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxd
  extends com.tencent.mm.bx.a
{
  public int ZRR;
  public String abdc;
  public String abdd;
  public int abde;
  public String abdf;
  public String abdg;
  public String abdh;
  public int abdi;
  public int abdj;
  public long abdk;
  public String announcement;
  public String cXV;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.cXV != null) {
        paramVarArgs.g(1, this.cXV);
      }
      if (this.abdc != null) {
        paramVarArgs.g(2, this.abdc);
      }
      if (this.abdd != null) {
        paramVarArgs.g(3, this.abdd);
      }
      paramVarArgs.bS(4, this.abde);
      if (this.topic != null) {
        paramVarArgs.g(5, this.topic);
      }
      if (this.abdf != null) {
        paramVarArgs.g(6, this.abdf);
      }
      if (this.abdg != null) {
        paramVarArgs.g(7, this.abdg);
      }
      if (this.announcement != null) {
        paramVarArgs.g(8, this.announcement);
      }
      if (this.abdh != null) {
        paramVarArgs.g(9, this.abdh);
      }
      paramVarArgs.bS(10, this.abdi);
      paramVarArgs.bS(11, this.abdj);
      paramVarArgs.bS(12, this.ZRR);
      paramVarArgs.bv(13, this.abdk);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cXV == null) {
        break label874;
      }
    }
    label874:
    for (int i = i.a.a.b.b.a.h(1, this.cXV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abdc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abdc);
      }
      i = paramInt;
      if (this.abdd != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdd);
      }
      i += i.a.a.b.b.a.cJ(4, this.abde);
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.topic);
      }
      i = paramInt;
      if (this.abdf != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abdf);
      }
      paramInt = i;
      if (this.abdg != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abdg);
      }
      i = paramInt;
      if (this.announcement != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.announcement);
      }
      paramInt = i;
      if (this.abdh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abdh);
      }
      i = i.a.a.b.b.a.cJ(10, this.abdi);
      int j = i.a.a.b.b.a.cJ(11, this.abdj);
      int k = i.a.a.b.b.a.cJ(12, this.ZRR);
      int m = i.a.a.b.b.a.q(13, this.abdk);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dxd localdxd = (dxd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localdxd.cXV = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localdxd.abdc = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localdxd.abdd = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localdxd.abde = locala.ajGk.aar();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localdxd.topic = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localdxd.abdf = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localdxd.abdg = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localdxd.announcement = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localdxd.abdh = locala.ajGk.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localdxd.abdi = locala.ajGk.aar();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localdxd.abdj = locala.ajGk.aar();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localdxd.ZRR = locala.ajGk.aar();
          AppMethodBeat.o(152632);
          return 0;
        }
        localdxd.abdk = locala.ajGk.aaw();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxd
 * JD-Core Version:    0.7.0.1
 */