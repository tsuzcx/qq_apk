package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyp
  extends dyl
{
  public String CRQ;
  public String CRR;
  public int HlE;
  public long HlH;
  public eae Hnc;
  public String RII;
  public String RJQ;
  public int RVD;
  public int RYC;
  public int Sat;
  public String ScZ;
  public int Stc;
  public int Sue;
  public int TDg;
  public int UyR;
  public int UyS;
  public int lVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
        throw paramVarArgs;
      }
      if (this.CRR != null) {
        paramVarArgs.f(1, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(2, this.CRQ);
      }
      paramVarArgs.aY(3, this.Sat);
      paramVarArgs.aY(4, this.RVD);
      if (this.RJQ != null) {
        paramVarArgs.f(5, this.RJQ);
      }
      paramVarArgs.aY(6, this.HlE);
      paramVarArgs.aY(7, this.RYC);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(8, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.lVs);
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.Stc);
      if (this.RII != null) {
        paramVarArgs.f(12, this.RII);
      }
      paramVarArgs.aY(13, this.TDg);
      paramVarArgs.aY(14, this.UyR);
      paramVarArgs.aY(15, this.UyS);
      paramVarArgs.bm(16, this.HlH);
      paramVarArgs.aY(17, this.Sue);
      if (this.ScZ != null) {
        paramVarArgs.f(19, this.ScZ);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRR == null) {
        break label1270;
      }
    }
    label1270:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CRQ);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Sat) + g.a.a.b.b.a.bM(4, this.RVD);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RJQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.HlE) + g.a.a.b.b.a.bM(7, this.RYC);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(8, this.Hnc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.lVs);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + g.a.a.a.oD(10, this.BaseRequest.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Stc);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RII);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.TDg) + g.a.a.b.b.a.bM(14, this.UyR) + g.a.a.b.b.a.bM(15, this.UyS) + g.a.a.b.b.a.p(16, this.HlH) + g.a.a.b.b.a.bM(17, this.Sue);
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.ScZ);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyp localeyp = (eyp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localeyp.CRR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localeyp.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localeyp.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localeyp.RVD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localeyp.RJQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localeyp.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localeyp.RYC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
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
            localeyp.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localeyp.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localeyp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localeyp.Stc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localeyp.RII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localeyp.TDg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localeyp.UyR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localeyp.UyS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localeyp.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localeyp.Sue = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148661);
          return 0;
        }
        localeyp.ScZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyp
 * JD-Core Version:    0.7.0.1
 */