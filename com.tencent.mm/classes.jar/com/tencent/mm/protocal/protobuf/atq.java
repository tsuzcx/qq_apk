package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atq
  extends ckq
{
  public String DtA;
  public String dcm;
  public String dlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dcm != null) {
        paramVarArgs.d(2, this.dcm);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.DtA != null) {
        paramVarArgs.d(4, this.DtA);
      }
      AppMethodBeat.o(108143);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dcm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dcm);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      paramInt = i;
      if (this.DtA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DtA);
      }
      AppMethodBeat.o(108143);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(108143);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atq localatq = (atq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108143);
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
            localatq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108143);
          return 0;
        case 2: 
          localatq.dcm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108143);
          return 0;
        case 3: 
          localatq.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(108143);
          return 0;
        }
        localatq.DtA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(108143);
        return 0;
      }
      AppMethodBeat.o(108143);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atq
 * JD-Core Version:    0.7.0.1
 */