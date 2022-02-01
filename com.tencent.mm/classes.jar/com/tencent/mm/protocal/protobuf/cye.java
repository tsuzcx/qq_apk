package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cye
  extends ckq
{
  public String DcA;
  public long Emo;
  public String mAQ;
  public int oXI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.oXI);
      if (this.DcA != null) {
        paramVarArgs.d(4, this.DcA);
      }
      paramVarArgs.aG(5, this.Emo);
      AppMethodBeat.o(118444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(3, this.oXI);
      paramInt = i;
      if (this.DcA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DcA);
      }
      i = f.a.a.b.b.a.q(5, this.Emo);
      AppMethodBeat.o(118444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cye localcye = (cye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118444);
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
            localcye.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118444);
          return 0;
        case 2: 
          localcye.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118444);
          return 0;
        case 3: 
          localcye.oXI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118444);
          return 0;
        case 4: 
          localcye.DcA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118444);
          return 0;
        }
        localcye.Emo = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(118444);
        return 0;
      }
      AppMethodBeat.o(118444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cye
 * JD-Core Version:    0.7.0.1
 */