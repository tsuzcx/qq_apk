package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwy
  extends ckq
{
  public String CBO;
  public String EKS;
  public String oXs;
  public int rZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oXs != null) {
        paramVarArgs.d(2, this.oXs);
      }
      if (this.CBO != null) {
        paramVarArgs.d(3, this.CBO);
      }
      if (this.EKS != null) {
        paramVarArgs.d(4, this.EKS);
      }
      paramVarArgs.aR(5, this.rZz);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oXs);
      }
      i = paramInt;
      if (this.CBO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CBO);
      }
      paramInt = i;
      if (this.EKS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKS);
      }
      i = f.a.a.b.b.a.bA(5, this.rZz);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwy localdwy = (dwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwy.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localdwy.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localdwy.CBO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localdwy.EKS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localdwy.rZz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */