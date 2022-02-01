package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ajb
  extends ckq
{
  public aht Dkw;
  public String Dls;
  public b Dlt;
  public int IoU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dls != null) {
        paramVarArgs.d(2, this.Dls);
      }
      if (this.Dlt != null) {
        paramVarArgs.c(3, this.Dlt);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(4, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.IoU);
      AppMethodBeat.o(168982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dls != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dls);
      }
      i = paramInt;
      if (this.Dlt != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Dlt);
      }
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dkw.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.IoU);
      AppMethodBeat.o(168982);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajb localajb = (ajb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168982);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        case 2: 
          localajb.Dls = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168982);
          return 0;
        case 3: 
          localajb.Dlt = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168982);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajb.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        }
        localajb.IoU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168982);
        return 0;
      }
      AppMethodBeat.o(168982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajb
 * JD-Core Version:    0.7.0.1
 */