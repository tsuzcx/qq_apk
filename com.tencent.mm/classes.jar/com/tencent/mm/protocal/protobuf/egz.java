package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class egz
  extends dyl
{
  public eae Hnc;
  public int RJP;
  public float ScP;
  public int SmH;
  public int Tjl;
  public int Tjm;
  public int Ujq;
  public float Ujr;
  public float Ujs;
  public int lVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32444);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32444);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hnc != null)
      {
        paramVarArgs.oE(2, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Ujq);
      paramVarArgs.aY(4, this.lVs);
      paramVarArgs.i(5, this.Ujr);
      paramVarArgs.aY(6, this.SmH);
      paramVarArgs.aY(7, this.RJP);
      paramVarArgs.i(8, this.Ujs);
      paramVarArgs.i(9, this.ScP);
      paramVarArgs.aY(10, this.Tjl);
      paramVarArgs.aY(11, this.Tjm);
      AppMethodBeat.o(32444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label916;
      }
    }
    label916:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hnc != null) {
        i = paramInt + g.a.a.a.oD(2, this.Hnc.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Ujq);
      int j = g.a.a.b.b.a.bM(4, this.lVs);
      int k = g.a.a.b.b.a.gL(5);
      int m = g.a.a.b.b.a.bM(6, this.SmH);
      int n = g.a.a.b.b.a.bM(7, this.RJP);
      int i1 = g.a.a.b.b.a.gL(8);
      int i2 = g.a.a.b.b.a.gL(9);
      int i3 = g.a.a.b.b.a.bM(10, this.Tjl);
      int i4 = g.a.a.b.b.a.bM(11, this.Tjm);
      AppMethodBeat.o(32444);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4) + i3 + i4;
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
          AppMethodBeat.o(32444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egz localegz = (egz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32444);
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
            localegz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 2: 
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
            localegz.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 3: 
          localegz.Ujq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32444);
          return 0;
        case 4: 
          localegz.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32444);
          return 0;
        case 5: 
          localegz.Ujr = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(32444);
          return 0;
        case 6: 
          localegz.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32444);
          return 0;
        case 7: 
          localegz.RJP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32444);
          return 0;
        case 8: 
          localegz.Ujs = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(32444);
          return 0;
        case 9: 
          localegz.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(32444);
          return 0;
        case 10: 
          localegz.Tjl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32444);
          return 0;
        }
        localegz.Tjm = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32444);
        return 0;
      }
      AppMethodBeat.o(32444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egz
 * JD-Core Version:    0.7.0.1
 */