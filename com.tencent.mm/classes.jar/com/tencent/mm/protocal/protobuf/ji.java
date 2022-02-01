package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ji
  extends com.tencent.mm.bw.a
{
  public String KNR;
  public String KNS;
  public String KNT;
  public String KNU;
  public String KNV;
  public String pTL;
  public String qGB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNR != null) {
        paramVarArgs.e(1, this.KNR);
      }
      if (this.KNS != null) {
        paramVarArgs.e(2, this.KNS);
      }
      if (this.KNT != null) {
        paramVarArgs.e(3, this.KNT);
      }
      if (this.qGB != null) {
        paramVarArgs.e(4, this.qGB);
      }
      if (this.pTL != null) {
        paramVarArgs.e(5, this.pTL);
      }
      if (this.KNU != null) {
        paramVarArgs.e(6, this.KNU);
      }
      if (this.KNV != null) {
        paramVarArgs.e(7, this.KNV);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNR == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.KNR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KNS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KNS);
      }
      i = paramInt;
      if (this.KNT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KNT);
      }
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGB);
      }
      i = paramInt;
      if (this.pTL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.pTL);
      }
      paramInt = i;
      if (this.KNU != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNU);
      }
      i = paramInt;
      if (this.KNV != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KNV);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ji localji = (ji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localji.KNR = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localji.KNS = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localji.KNT = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localji.qGB = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localji.pTL = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localji.KNU = locala.UbS.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localji.KNV = locala.UbS.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ji
 * JD-Core Version:    0.7.0.1
 */