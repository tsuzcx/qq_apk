package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aij
  extends dyy
{
  public int HlE;
  public long HlH;
  public eae Hnc;
  public String RJQ;
  public int RVD;
  public int RYC;
  public int Sat;
  public int Stc;
  public int lVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.HlE);
      paramVarArgs.aY(2, this.Sat);
      paramVarArgs.aY(3, this.RVD);
      paramVarArgs.aY(5, this.RYC);
      if (this.RJQ != null) {
        paramVarArgs.f(6, this.RJQ);
      }
      if (this.Hnc != null)
      {
        paramVarArgs.oE(7, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.lVs);
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.Stc);
      paramVarArgs.bm(11, this.HlH);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.HlE) + 0 + g.a.a.b.b.a.bM(2, this.Sat) + g.a.a.b.b.a.bM(3, this.RVD) + g.a.a.b.b.a.bM(5, this.RYC);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RJQ);
      }
      i = paramInt;
      if (this.Hnc != null) {
        i = paramInt + g.a.a.a.oD(7, this.Hnc.computeSize());
      }
      i += g.a.a.b.b.a.bM(8, this.lVs);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.oD(9, this.BaseResponse.computeSize());
      }
      i = g.a.a.b.b.a.bM(10, this.Stc);
      int j = g.a.a.b.b.a.p(11, this.HlH);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      AppMethodBeat.o(148653);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aij localaij = (aij)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(148653);
        return -1;
      case 1: 
        localaij.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localaij.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localaij.RVD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localaij.RYC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localaij.RJQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(148653);
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
          localaij.Hnc = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localaij.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new jh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((jh)localObject2).parseFrom((byte[])localObject1);
          }
          localaij.BaseResponse = ((jh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localaij.Stc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148653);
        return 0;
      }
      localaij.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aij
 * JD-Core Version:    0.7.0.1
 */