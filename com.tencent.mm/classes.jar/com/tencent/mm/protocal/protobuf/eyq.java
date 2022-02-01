package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyq
  extends dyy
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public int HlE;
  public long HlH;
  public String RJQ;
  public int RVD;
  public int RYC;
  public int Sat;
  public int Sda;
  public int Stc;
  public int lVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
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
      paramVarArgs.aY(5, this.CreateTime);
      if (this.RJQ != null) {
        paramVarArgs.f(6, this.RJQ);
      }
      paramVarArgs.aY(7, this.HlE);
      paramVarArgs.aY(8, this.RYC);
      paramVarArgs.aY(9, this.lVs);
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.Stc);
      paramVarArgs.bm(12, this.HlH);
      paramVarArgs.aY(13, this.Sda);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRR == null) {
        break label924;
      }
    }
    label924:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CRQ);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Sat) + g.a.a.b.b.a.bM(4, this.RVD) + g.a.a.b.b.a.bM(5, this.CreateTime);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RJQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.HlE) + g.a.a.b.b.a.bM(8, this.RYC) + g.a.a.b.b.a.bM(9, this.lVs);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.oD(10, this.BaseResponse.computeSize());
      }
      i = g.a.a.b.b.a.bM(11, this.Stc);
      int j = g.a.a.b.b.a.p(12, this.HlH);
      int k = g.a.a.b.b.a.bM(13, this.Sda);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eyq localeyq = (eyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localeyq.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localeyq.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localeyq.Sat = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localeyq.RVD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localeyq.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localeyq.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localeyq.HlE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localeyq.RYC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localeyq.lVs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localeyq.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localeyq.Stc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localeyq.HlH = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(148662);
          return 0;
        }
        localeyq.Sda = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyq
 * JD-Core Version:    0.7.0.1
 */