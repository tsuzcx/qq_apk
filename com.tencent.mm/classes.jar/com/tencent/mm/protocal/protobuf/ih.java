package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ih
  extends com.tencent.mm.cd.a
{
  public int HlE;
  public long HlH;
  public eaf RID;
  public eaf RIE;
  public eaf RIF;
  public String RII;
  public String RJQ;
  public int RNH;
  public int RNI;
  public int RNJ;
  public LinkedList<eaf> RNK;
  public LinkedList<eag> RNL;
  public eae RNM;
  public int RNN;
  public int RNO;
  public int RNP;
  public long RNQ;
  public int RNR;
  public int rWu;
  
  public ih()
  {
    AppMethodBeat.i(32137);
    this.RNK = new LinkedList();
    this.RNL = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.RIF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.rWu);
      if (this.RJQ != null) {
        paramVarArgs.f(2, this.RJQ);
      }
      if (this.RID != null)
      {
        paramVarArgs.oE(3, this.RID.computeSize());
        this.RID.writeFields(paramVarArgs);
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(4, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      if (this.RIF != null)
      {
        paramVarArgs.oE(5, this.RIF.computeSize());
        this.RIF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.RNH);
      paramVarArgs.aY(7, this.RNI);
      if (this.RII != null) {
        paramVarArgs.f(8, this.RII);
      }
      paramVarArgs.aY(9, this.HlE);
      paramVarArgs.aY(10, this.RNJ);
      paramVarArgs.e(11, 8, this.RNK);
      paramVarArgs.e(12, 8, this.RNL);
      if (this.RNM != null)
      {
        paramVarArgs.oE(13, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.RNN);
      paramVarArgs.aY(15, this.RNO);
      paramVarArgs.bm(16, this.HlH);
      paramVarArgs.aY(17, this.RNP);
      paramVarArgs.bm(18, this.RNQ);
      paramVarArgs.aY(19, this.RNR);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJQ);
      }
      i = paramInt;
      if (this.RID != null) {
        i = paramInt + g.a.a.a.oD(3, this.RID.computeSize());
      }
      paramInt = i;
      if (this.RIE != null) {
        paramInt = i + g.a.a.a.oD(4, this.RIE.computeSize());
      }
      i = paramInt;
      if (this.RIF != null) {
        i = paramInt + g.a.a.a.oD(5, this.RIF.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(6, this.RNH) + g.a.a.b.b.a.bM(7, this.RNI);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RII);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.HlE) + g.a.a.b.b.a.bM(10, this.RNJ) + g.a.a.a.c(11, 8, this.RNK) + g.a.a.a.c(12, 8, this.RNL);
      paramInt = i;
      if (this.RNM != null) {
        paramInt = i + g.a.a.a.oD(13, this.RNM.computeSize());
      }
      i = g.a.a.b.b.a.bM(14, this.RNN);
      int j = g.a.a.b.b.a.bM(15, this.RNO);
      int k = g.a.a.b.b.a.p(16, this.HlH);
      int m = g.a.a.b.b.a.bM(17, this.RNP);
      int n = g.a.a.b.b.a.p(18, this.RNQ);
      int i1 = g.a.a.b.b.a.bM(19, this.RNR);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RNK.clear();
      this.RNL.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.RIF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32138);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ih localih = (ih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localih.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localih.RJQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localih.RID = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localih.RIE = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localih.RIF = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localih.RNH = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localih.RNI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localih.RII = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localih.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localih.RNJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localih.RNK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eag();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eag)localObject2).df((byte[])localObject1);
          }
          localih.RNL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localih.RNM = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localih.RNN = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localih.RNO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localih.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localih.RNP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localih.RNQ = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(32138);
        return 0;
      }
      localih.RNR = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */