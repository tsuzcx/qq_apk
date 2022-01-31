package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcv
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public int ayi;
  public String cqq;
  public int cte;
  public String cwc;
  public int ePG;
  public int nkT;
  public String token;
  public String videoPath;
  public int xrU;
  public bcp xsK;
  public int xsL;
  public LinkedList<bcp> xsM;
  public String xsN;
  public String xsO;
  public String xsP;
  public bby xsQ;
  public int xsR;
  public String xsn;
  public int xso;
  public int xsp;
  public int xsx;
  public String xsy;
  
  public bcv()
  {
    AppMethodBeat.i(94543);
    this.xsM = new LinkedList();
    AppMethodBeat.o(94543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94544);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xso);
      paramVarArgs.aO(2, this.xsp);
      paramVarArgs.aO(3, this.xrU);
      if (this.xsK != null)
      {
        paramVarArgs.iQ(4, this.xsK.computeSize());
        this.xsK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xsL);
      paramVarArgs.e(6, 8, this.xsM);
      paramVarArgs.aO(7, this.ePG);
      paramVarArgs.aO(8, this.nkT);
      if (this.Desc != null) {
        paramVarArgs.e(9, this.Desc);
      }
      if (this.xsN != null) {
        paramVarArgs.e(10, this.xsN);
      }
      if (this.token != null) {
        paramVarArgs.e(11, this.token);
      }
      if (this.xsy != null) {
        paramVarArgs.e(12, this.xsy);
      }
      paramVarArgs.aO(13, this.xsx);
      if (this.videoPath != null) {
        paramVarArgs.e(14, this.videoPath);
      }
      if (this.xsO != null) {
        paramVarArgs.e(15, this.xsO);
      }
      if (this.xsP != null) {
        paramVarArgs.e(16, this.xsP);
      }
      if (this.cqq != null) {
        paramVarArgs.e(17, this.cqq);
      }
      if (this.cwc != null) {
        paramVarArgs.e(18, this.cwc);
      }
      paramVarArgs.aO(19, this.ayi);
      paramVarArgs.aO(20, this.cte);
      if (this.xsn != null) {
        paramVarArgs.e(21, this.xsn);
      }
      if (this.xsQ != null)
      {
        paramVarArgs.iQ(22, this.xsQ.computeSize());
        this.xsQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(23, this.xsR);
      AppMethodBeat.o(94544);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xso) + 0 + e.a.a.b.b.a.bl(2, this.xsp) + e.a.a.b.b.a.bl(3, this.xrU);
      paramInt = i;
      if (this.xsK != null) {
        paramInt = i + e.a.a.a.iP(4, this.xsK.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xsL) + e.a.a.a.c(6, 8, this.xsM) + e.a.a.b.b.a.bl(7, this.ePG) + e.a.a.b.b.a.bl(8, this.nkT);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.Desc);
      }
      i = paramInt;
      if (this.xsN != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xsN);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.token);
      }
      i = paramInt;
      if (this.xsy != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xsy);
      }
      i += e.a.a.b.b.a.bl(13, this.xsx);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.videoPath);
      }
      i = paramInt;
      if (this.xsO != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xsO);
      }
      paramInt = i;
      if (this.xsP != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xsP);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.cqq);
      }
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.cwc);
      }
      i = paramInt + e.a.a.b.b.a.bl(19, this.ayi) + e.a.a.b.b.a.bl(20, this.cte);
      paramInt = i;
      if (this.xsn != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.xsn);
      }
      i = paramInt;
      if (this.xsQ != null) {
        i = paramInt + e.a.a.a.iP(22, this.xsQ.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(23, this.xsR);
      AppMethodBeat.o(94544);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xsM.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94544);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bcv localbcv = (bcv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94544);
        return -1;
      case 1: 
        localbcv.xso = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 2: 
        localbcv.xsp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 3: 
        localbcv.xrU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbcv.xsK = ((bcp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94544);
        return 0;
      case 5: 
        localbcv.xsL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbcv.xsM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94544);
        return 0;
      case 7: 
        localbcv.ePG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 8: 
        localbcv.nkT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 9: 
        localbcv.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 10: 
        localbcv.xsN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 11: 
        localbcv.token = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 12: 
        localbcv.xsy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 13: 
        localbcv.xsx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 14: 
        localbcv.videoPath = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 15: 
        localbcv.xsO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 16: 
        localbcv.xsP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 17: 
        localbcv.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 18: 
        localbcv.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 19: 
        localbcv.ayi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 20: 
        localbcv.cte = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94544);
        return 0;
      case 21: 
        localbcv.xsn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94544);
        return 0;
      case 22: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bby();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bby)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbcv.xsQ = ((bby)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94544);
        return 0;
      }
      localbcv.xsR = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(94544);
      return 0;
    }
    AppMethodBeat.o(94544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcv
 * JD-Core Version:    0.7.0.1
 */