package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxv
  extends cvp
{
  public int CreateTime;
  public int GeI;
  public long GeJ;
  public int HKd;
  public String HKm;
  public LinkedList<dyx> HKn;
  public int fLb;
  
  public dxv()
  {
    AppMethodBeat.i(115879);
    this.HKn = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(6, this.fLb);
      paramVarArgs.e(7, 8, this.HKn);
      if (this.HKm != null) {
        paramVarArgs.d(8, this.HKm);
      }
      paramVarArgs.aS(9, this.HKd);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(6, this.fLb) + f.a.a.a.c(7, 8, this.HKn);
      paramInt = i;
      if (this.HKm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HKm);
      }
      i = f.a.a.b.b.a.bz(9, this.HKd);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxv localdxv = (dxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localdxv.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localdxv.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localdxv.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localdxv.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxv.HKn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localdxv.HKm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localdxv.HKd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxv
 * JD-Core Version:    0.7.0.1
 */