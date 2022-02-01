package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckb
  extends cwj
{
  public String HwD;
  public int HwE;
  public long HwF;
  public int dxd;
  public String dxe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dxd);
      if (this.dxe != null) {
        paramVarArgs.d(3, this.dxe);
      }
      if (this.HwD != null) {
        paramVarArgs.d(4, this.HwD);
      }
      paramVarArgs.aS(5, this.HwE);
      paramVarArgs.aZ(100, this.HwF);
      AppMethodBeat.o(197199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dxd);
      paramInt = i;
      if (this.dxe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dxe);
      }
      i = paramInt;
      if (this.HwD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HwD);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HwE);
      int j = f.a.a.b.b.a.p(100, this.HwF);
      AppMethodBeat.o(197199);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckb localckb = (ckb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197199);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197199);
          return 0;
        case 2: 
          localckb.dxd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197199);
          return 0;
        case 3: 
          localckb.dxe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197199);
          return 0;
        case 4: 
          localckb.HwD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197199);
          return 0;
        case 5: 
          localckb.HwE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197199);
          return 0;
        }
        localckb.HwF = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(197199);
        return 0;
      }
      AppMethodBeat.o(197199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckb
 * JD-Core Version:    0.7.0.1
 */