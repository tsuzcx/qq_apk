package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdd
  extends dyl
{
  public int SmH;
  public int Svu;
  public long Svv;
  public String TWw;
  public fev UCF;
  public fev UCG;
  public long UCJ;
  public int UCK;
  public int UCL;
  public LinkedList<dbt> UCM;
  public int UCW;
  public int UCX;
  
  public fdd()
  {
    AppMethodBeat.i(115863);
    this.UCM = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      paramVarArgs.aY(3, this.Svu);
      paramVarArgs.aY(4, this.UCW);
      if (this.UCF != null)
      {
        paramVarArgs.oE(5, this.UCF.computeSize());
        this.UCF.writeFields(paramVarArgs);
      }
      if (this.UCG != null)
      {
        paramVarArgs.oE(6, this.UCG.computeSize());
        this.UCG.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(7, this.Svv);
      paramVarArgs.aY(8, this.SmH);
      paramVarArgs.bm(9, this.UCJ);
      paramVarArgs.aY(10, this.UCX);
      paramVarArgs.aY(11, this.UCK);
      paramVarArgs.aY(12, this.UCL);
      paramVarArgs.e(13, 8, this.UCM);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1110;
      }
    }
    label1110:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Svu) + g.a.a.b.b.a.bM(4, this.UCW);
      paramInt = i;
      if (this.UCF != null) {
        paramInt = i + g.a.a.a.oD(5, this.UCF.computeSize());
      }
      i = paramInt;
      if (this.UCG != null) {
        i = paramInt + g.a.a.a.oD(6, this.UCG.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(7, this.Svv);
      int j = g.a.a.b.b.a.bM(8, this.SmH);
      int k = g.a.a.b.b.a.p(9, this.UCJ);
      int m = g.a.a.b.b.a.bM(10, this.UCX);
      int n = g.a.a.b.b.a.bM(11, this.UCK);
      int i1 = g.a.a.b.b.a.bM(12, this.UCL);
      int i2 = g.a.a.a.c(13, 8, this.UCM);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fdd localfdd = (fdd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
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
            localfdd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localfdd.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localfdd.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localfdd.UCW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfdd.UCF = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfdd.UCG = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localfdd.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localfdd.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localfdd.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localfdd.UCX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localfdd.UCK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localfdd.UCL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115864);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbt)localObject2).parseFrom((byte[])localObject1);
          }
          localfdd.UCM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdd
 * JD-Core Version:    0.7.0.1
 */