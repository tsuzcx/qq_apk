package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class qe
  extends erp
{
  public String IdD;
  public int YLL;
  public b YPG;
  public long YPK;
  public String YQh;
  public String YQi;
  public int YQj;
  public int YQk;
  public LinkedList<nn> YQl;
  public int YUZ;
  public int source;
  
  public qe()
  {
    AppMethodBeat.i(258017);
    this.YQl = new LinkedList();
    AppMethodBeat.o(258017);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258022);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YPG != null) {
        paramVarArgs.d(2, this.YPG);
      }
      paramVarArgs.bS(3, this.source);
      if (this.IdD != null) {
        paramVarArgs.g(5, this.IdD);
      }
      if (this.YQh != null) {
        paramVarArgs.g(6, this.YQh);
      }
      if (this.YQi != null) {
        paramVarArgs.g(7, this.YQi);
      }
      paramVarArgs.bS(8, this.YUZ);
      paramVarArgs.bS(9, this.YQj);
      paramVarArgs.bS(10, this.YQk);
      paramVarArgs.e(17, 8, this.YQl);
      paramVarArgs.bv(18, this.YPK);
      paramVarArgs.bS(22, this.YLL);
      AppMethodBeat.o(258022);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YPG != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YPG);
      }
      i += i.a.a.b.b.a.cJ(3, this.source);
      paramInt = i;
      if (this.IdD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IdD);
      }
      i = paramInt;
      if (this.YQh != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YQh);
      }
      paramInt = i;
      if (this.YQi != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YQi);
      }
      i = i.a.a.b.b.a.cJ(8, this.YUZ);
      int j = i.a.a.b.b.a.cJ(9, this.YQj);
      int k = i.a.a.b.b.a.cJ(10, this.YQk);
      int m = i.a.a.a.c(17, 8, this.YQl);
      int n = i.a.a.b.b.a.q(18, this.YPK);
      int i1 = i.a.a.b.b.a.cJ(22, this.YLL);
      AppMethodBeat.o(258022);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YQl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258022);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        qe localqe = (qe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          AppMethodBeat.o(258022);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localqe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258022);
          return 0;
        case 2: 
          localqe.YPG = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258022);
          return 0;
        case 3: 
          localqe.source = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258022);
          return 0;
        case 5: 
          localqe.IdD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258022);
          return 0;
        case 6: 
          localqe.YQh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258022);
          return 0;
        case 7: 
          localqe.YQi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258022);
          return 0;
        case 8: 
          localqe.YUZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258022);
          return 0;
        case 9: 
          localqe.YQj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258022);
          return 0;
        case 10: 
          localqe.YQk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258022);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nn)localObject2).parseFrom((byte[])localObject1);
            }
            localqe.YQl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258022);
          return 0;
        case 18: 
          localqe.YPK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258022);
          return 0;
        }
        localqe.YLL = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258022);
        return 0;
      }
      AppMethodBeat.o(258022);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qe
 * JD-Core Version:    0.7.0.1
 */