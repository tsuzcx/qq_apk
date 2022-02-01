package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class in
  extends com.tencent.mm.bx.a
{
  public String Id;
  public String YKk;
  public String YKl;
  public int YKm;
  public long YKn;
  public int YKo;
  public long YKp;
  public long YKq;
  public long YKr;
  public String YKs;
  public long YKt;
  public double YKu;
  public int YKv;
  public String YKw;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      if (this.YKk != null) {
        paramVarArgs.g(2, this.YKk);
      }
      if (this.YKl != null) {
        paramVarArgs.g(3, this.YKl);
      }
      paramVarArgs.bS(4, this.YKm);
      paramVarArgs.bv(5, this.YKn);
      paramVarArgs.bS(6, this.YKo);
      paramVarArgs.bS(7, this.vhk);
      paramVarArgs.bv(8, this.YKp);
      paramVarArgs.bv(9, this.YKq);
      paramVarArgs.bv(10, this.YKr);
      if (this.YKs != null) {
        paramVarArgs.g(11, this.YKs);
      }
      paramVarArgs.bv(12, this.YKt);
      paramVarArgs.d(13, this.YKu);
      paramVarArgs.bS(14, this.YKv);
      if (this.YKw != null) {
        paramVarArgs.g(15, this.YKw);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label897;
      }
    }
    label897:
    for (int i = i.a.a.b.b.a.h(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YKk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YKk);
      }
      i = paramInt;
      if (this.YKl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YKl);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.YKm) + i.a.a.b.b.a.q(5, this.YKn) + i.a.a.b.b.a.cJ(6, this.YKo) + i.a.a.b.b.a.cJ(7, this.vhk) + i.a.a.b.b.a.q(8, this.YKp) + i.a.a.b.b.a.q(9, this.YKq) + i.a.a.b.b.a.q(10, this.YKr);
      paramInt = i;
      if (this.YKs != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YKs);
      }
      i = paramInt + i.a.a.b.b.a.q(12, this.YKt) + (i.a.a.b.b.a.ko(13) + 8) + i.a.a.b.b.a.cJ(14, this.YKv);
      paramInt = i;
      if (this.YKw != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YKw);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        in localin = (in)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localin.Id = locala.ajGk.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localin.YKk = locala.ajGk.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localin.YKl = locala.ajGk.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localin.YKm = locala.ajGk.aar();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localin.YKn = locala.ajGk.aaw();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localin.YKo = locala.ajGk.aar();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localin.vhk = locala.ajGk.aar();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localin.YKp = locala.ajGk.aaw();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localin.YKq = locala.ajGk.aaw();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localin.YKr = locala.ajGk.aaw();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localin.YKs = locala.ajGk.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localin.YKt = locala.ajGk.aaw();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localin.YKu = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localin.YKv = locala.ajGk.aar();
          AppMethodBeat.o(87872);
          return 0;
        }
        localin.YKw = locala.ajGk.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.in
 * JD-Core Version:    0.7.0.1
 */