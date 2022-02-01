package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czv
  extends com.tencent.mm.bx.a
{
  public String CIt;
  public LinkedList<bkn> CNr;
  public String DKS;
  public String ErA;
  public String ErB;
  public int ErC;
  public int Ert;
  public int Eru;
  public int Erv;
  public int Erw;
  public int Erx;
  public int Ery;
  public int Erz;
  public String Title;
  
  public czv()
  {
    AppMethodBeat.i(152702);
    this.CNr = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKS != null) {
        paramVarArgs.d(1, this.DKS);
      }
      paramVarArgs.aR(2, this.Ert);
      paramVarArgs.aR(3, this.Eru);
      paramVarArgs.aR(4, this.Erv);
      paramVarArgs.aR(5, this.Erw);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      paramVarArgs.e(7, 8, this.CNr);
      paramVarArgs.aR(8, this.Erx);
      if (this.CIt != null) {
        paramVarArgs.d(9, this.CIt);
      }
      paramVarArgs.aR(10, this.Ery);
      paramVarArgs.aR(11, this.Erz);
      if (this.ErA != null) {
        paramVarArgs.d(12, this.ErA);
      }
      if (this.ErB != null) {
        paramVarArgs.d(13, this.ErB);
      }
      paramVarArgs.aR(14, this.ErC);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKS == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.DKS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ert) + f.a.a.b.b.a.bA(3, this.Eru) + f.a.a.b.b.a.bA(4, this.Erv) + f.a.a.b.b.a.bA(5, this.Erw);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.CNr) + f.a.a.b.b.a.bA(8, this.Erx);
      paramInt = i;
      if (this.CIt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CIt);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Ery) + f.a.a.b.b.a.bA(11, this.Erz);
      paramInt = i;
      if (this.ErA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ErA);
      }
      i = paramInt;
      if (this.ErB != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ErB);
      }
      paramInt = f.a.a.b.b.a.bA(14, this.ErC);
      AppMethodBeat.o(152703);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CNr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czv localczv = (czv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localczv.DKS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localczv.Ert = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localczv.Eru = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localczv.Erv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localczv.Erw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localczv.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczv.CNr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localczv.Erx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localczv.CIt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localczv.Ery = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localczv.Erz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localczv.ErA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localczv.ErB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152703);
          return 0;
        }
        localczv.ErC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czv
 * JD-Core Version:    0.7.0.1
 */