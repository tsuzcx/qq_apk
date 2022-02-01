package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class eld
  extends dyl
{
  public String UlA;
  public long UlB;
  public eae Uld;
  public int Ulf;
  public long UmO;
  public int UmP;
  public long UmQ;
  public int UmR;
  public LinkedList<Long> UmS;
  public int UmT;
  public int UmU;
  public long UmV;
  public long UmW;
  public long UmX;
  public int UmY;
  public long UmZ;
  public eae Una;
  
  public eld()
  {
    AppMethodBeat.i(125826);
    this.UmS = new LinkedList();
    AppMethodBeat.o(125826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      paramVarArgs.bm(3, this.UlB);
      paramVarArgs.bm(4, this.UmO);
      paramVarArgs.aY(5, this.UmP);
      paramVarArgs.bm(6, this.UmQ);
      if (this.Uld != null)
      {
        paramVarArgs.oE(7, this.Uld.computeSize());
        this.Uld.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.Ulf);
      paramVarArgs.aY(11, this.UmR);
      paramVarArgs.f(12, 3, this.UmS);
      paramVarArgs.aY(13, this.UmT);
      paramVarArgs.aY(14, this.UmU);
      paramVarArgs.bm(15, this.UmV);
      paramVarArgs.bm(16, this.UmW);
      paramVarArgs.bm(17, this.UmX);
      paramVarArgs.aY(18, this.UmY);
      paramVarArgs.bm(19, this.UmZ);
      if (this.Una != null)
      {
        paramVarArgs.oE(20, this.Una.computeSize());
        this.Una.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1267;
      }
    }
    label1267:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = i + g.a.a.b.b.a.p(3, this.UlB) + g.a.a.b.b.a.p(4, this.UmO) + g.a.a.b.b.a.bM(5, this.UmP) + g.a.a.b.b.a.p(6, this.UmQ);
      paramInt = i;
      if (this.Uld != null) {
        paramInt = i + g.a.a.a.oD(7, this.Uld.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Ulf) + g.a.a.b.b.a.bM(11, this.UmR) + g.a.a.a.d(12, 3, this.UmS) + g.a.a.b.b.a.bM(13, this.UmT) + g.a.a.b.b.a.bM(14, this.UmU) + g.a.a.b.b.a.p(15, this.UmV) + g.a.a.b.b.a.p(16, this.UmW) + g.a.a.b.b.a.p(17, this.UmX) + g.a.a.b.b.a.bM(18, this.UmY) + g.a.a.b.b.a.p(19, this.UmZ);
      paramInt = i;
      if (this.Una != null) {
        paramInt = i + g.a.a.a.oD(20, this.Una.computeSize());
      }
      AppMethodBeat.o(125827);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UmS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eld localeld = (eld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(125827);
          return -1;
        case 1: 
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
            localeld.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localeld.UlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localeld.UlB = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localeld.UmO = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localeld.UmP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localeld.UmQ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
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
            localeld.Uld = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localeld.Ulf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localeld.UmR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localeld.UmS = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUv();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localeld.UmT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localeld.UmU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localeld.UmV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 16: 
          localeld.UmW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 17: 
          localeld.UmX = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        case 18: 
          localeld.UmY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125827);
          return 0;
        case 19: 
          localeld.UmZ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125827);
          return 0;
        }
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
          localeld.Una = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eld
 * JD-Core Version:    0.7.0.1
 */