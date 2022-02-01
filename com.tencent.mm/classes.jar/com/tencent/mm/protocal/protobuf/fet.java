package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fet
  extends dyl
{
  public int Svu;
  public long Svv;
  public int TWl;
  public int UCL;
  public LinkedList<dbt> UCM;
  public int UFk;
  public int UFl;
  public LinkedList<few> UFm;
  public int UFn;
  public int UFo;
  public int UFp;
  
  public fet()
  {
    AppMethodBeat.i(115905);
    this.UFm = new LinkedList();
    this.UCM = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
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
      paramVarArgs.aY(4, this.TWl);
      paramVarArgs.aY(5, this.UFk);
      paramVarArgs.aY(6, this.UFl);
      paramVarArgs.e(7, 8, this.UFm);
      paramVarArgs.aY(8, this.UFn);
      paramVarArgs.aY(9, this.UCL);
      paramVarArgs.e(10, 8, this.UCM);
      paramVarArgs.aY(11, this.UFo);
      paramVarArgs.aY(12, this.UFp);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label956;
      }
    }
    label956:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.b.b.a.bM(4, this.TWl);
      int m = g.a.a.b.b.a.bM(5, this.UFk);
      int n = g.a.a.b.b.a.bM(6, this.UFl);
      int i1 = g.a.a.a.c(7, 8, this.UFm);
      int i2 = g.a.a.b.b.a.bM(8, this.UFn);
      int i3 = g.a.a.b.b.a.bM(9, this.UCL);
      int i4 = g.a.a.a.c(10, 8, this.UCM);
      int i5 = g.a.a.b.b.a.bM(11, this.UFo);
      int i6 = g.a.a.b.b.a.bM(12, this.UFp);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UFm.clear();
        this.UCM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fet localfet = (fet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
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
            localfet.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localfet.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localfet.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localfet.TWl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localfet.UFk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localfet.UFl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new few();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((few)localObject2).parseFrom((byte[])localObject1);
            }
            localfet.UFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localfet.UFn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localfet.UCL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
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
            localfet.UCM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localfet.UFo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115906);
          return 0;
        }
        localfet.UFp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fet
 * JD-Core Version:    0.7.0.1
 */