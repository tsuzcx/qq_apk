package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cqf
  extends com.tencent.mm.cd.a
{
  public String GtI;
  public float GtJ;
  public int GtK;
  public LinkedList<Integer> GtL;
  public int GtM;
  public LinkedList<eaf> GtN;
  public float GtO;
  public String GtP;
  public eae GtQ;
  public String TxO;
  public eae TxP;
  public int TxQ;
  public int TxR;
  public String fwr;
  public int rWu;
  
  public cqf()
  {
    AppMethodBeat.i(116338);
    this.GtL = new LinkedList();
    this.GtN = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GtI != null) {
        paramVarArgs.f(1, this.GtI);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      paramVarArgs.i(3, this.GtJ);
      paramVarArgs.aY(4, this.GtK);
      paramVarArgs.f(5, 2, this.GtL);
      paramVarArgs.aY(6, this.GtM);
      paramVarArgs.e(7, 8, this.GtN);
      paramVarArgs.i(8, this.GtO);
      if (this.GtP != null) {
        paramVarArgs.f(9, this.GtP);
      }
      paramVarArgs.aY(10, this.rWu);
      if (this.GtQ != null)
      {
        paramVarArgs.oE(11, this.GtQ.computeSize());
        this.GtQ.writeFields(paramVarArgs);
      }
      if (this.TxO != null) {
        paramVarArgs.f(12, this.TxO);
      }
      if (this.TxP != null)
      {
        paramVarArgs.oE(13, this.TxP.computeSize());
        this.TxP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.TxQ);
      paramVarArgs.aY(15, this.TxR);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GtI == null) {
        break label1173;
      }
    }
    label1173:
    for (paramInt = g.a.a.b.b.a.g(1, this.GtI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + g.a.a.b.b.a.bM(4, this.GtK) + g.a.a.a.d(5, 2, this.GtL) + g.a.a.b.b.a.bM(6, this.GtM) + g.a.a.a.c(7, 8, this.GtN) + (g.a.a.b.b.a.gL(8) + 4);
      paramInt = i;
      if (this.GtP != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.GtP);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.rWu);
      paramInt = i;
      if (this.GtQ != null) {
        paramInt = i + g.a.a.a.oD(11, this.GtQ.computeSize());
      }
      i = paramInt;
      if (this.TxO != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TxO);
      }
      paramInt = i;
      if (this.TxP != null) {
        paramInt = i + g.a.a.a.oD(13, this.TxP.computeSize());
      }
      i = g.a.a.b.b.a.bM(14, this.TxQ);
      int j = g.a.a.b.b.a.bM(15, this.TxR);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GtL.clear();
        this.GtN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqf localcqf = (cqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localcqf.GtI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localcqf.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localcqf.GtJ = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localcqf.GtK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localcqf.GtL = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localcqf.GtM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
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
            localcqf.GtN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localcqf.GtO = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localcqf.GtP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localcqf.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
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
            localcqf.GtQ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localcqf.TxO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116339);
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
            localcqf.TxP = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localcqf.TxQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116339);
          return 0;
        }
        localcqf.TxR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqf
 * JD-Core Version:    0.7.0.1
 */