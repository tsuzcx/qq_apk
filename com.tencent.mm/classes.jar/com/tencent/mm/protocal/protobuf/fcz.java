package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcz
  extends dyl
{
  public int SmH;
  public int Svu;
  public long Svv;
  public String TWw;
  public int UCE;
  public fev UCF;
  public fev UCG;
  public String UCH;
  public int UCI;
  public long UCJ;
  public int UCK;
  public int UCL;
  public LinkedList<dbt> UCM;
  
  public fcz()
  {
    AppMethodBeat.i(115857);
    this.UCM = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      if (this.TWw != null) {
        paramVarArgs.f(4, this.TWw);
      }
      paramVarArgs.aY(5, this.UCE);
      if (this.UCF != null)
      {
        paramVarArgs.oE(6, this.UCF.computeSize());
        this.UCF.writeFields(paramVarArgs);
      }
      if (this.UCG != null)
      {
        paramVarArgs.oE(7, this.UCG.computeSize());
        this.UCG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SmH);
      if (this.UCH != null) {
        paramVarArgs.f(9, this.UCH);
      }
      paramVarArgs.aY(10, this.UCI);
      paramVarArgs.bm(11, this.UCJ);
      paramVarArgs.aY(12, this.UCK);
      paramVarArgs.aY(13, this.UCL);
      paramVarArgs.e(14, 8, this.UCM);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1166;
      }
    }
    label1166:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv);
      paramInt = i;
      if (this.TWw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TWw);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UCE);
      paramInt = i;
      if (this.UCF != null) {
        paramInt = i + g.a.a.a.oD(6, this.UCF.computeSize());
      }
      i = paramInt;
      if (this.UCG != null) {
        i = paramInt + g.a.a.a.oD(7, this.UCG.computeSize());
      }
      i += g.a.a.b.b.a.bM(8, this.SmH);
      paramInt = i;
      if (this.UCH != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UCH);
      }
      i = g.a.a.b.b.a.bM(10, this.UCI);
      int j = g.a.a.b.b.a.p(11, this.UCJ);
      int k = g.a.a.b.b.a.bM(12, this.UCK);
      int m = g.a.a.b.b.a.bM(13, this.UCL);
      int n = g.a.a.a.c(14, 8, this.UCM);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
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
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcz localfcz = (fcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localfcz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localfcz.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localfcz.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localfcz.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localfcz.UCE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
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
            localfcz.UCF = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 7: 
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
            localfcz.UCG = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localfcz.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localfcz.UCH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localfcz.UCI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localfcz.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localfcz.UCK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localfcz.UCL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115858);
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
          localfcz.UCM.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcz
 * JD-Core Version:    0.7.0.1
 */