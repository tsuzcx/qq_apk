package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cip
  extends cvw
{
  public String HuW;
  public cir HuX;
  public int HuY;
  public b HuZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HuW != null) {
        paramVarArgs.d(2, this.HuW);
      }
      if (this.HuX != null)
      {
        paramVarArgs.lJ(3, this.HuX.computeSize());
        this.HuX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HuY);
      if (this.HuZ != null) {
        paramVarArgs.c(5, this.HuZ);
      }
      AppMethodBeat.o(218928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HuW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HuW);
      }
      i = paramInt;
      if (this.HuX != null) {
        i = paramInt + f.a.a.a.lI(3, this.HuX.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.HuY);
      paramInt = i;
      if (this.HuZ != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.HuZ);
      }
      AppMethodBeat.o(218928);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cip localcip = (cip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcip.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218928);
          return 0;
        case 2: 
          localcip.HuW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218928);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcip.HuX = ((cir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218928);
          return 0;
        case 4: 
          localcip.HuY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218928);
          return 0;
        }
        localcip.HuZ = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(218928);
        return 0;
      }
      AppMethodBeat.o(218928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cip
 * JD-Core Version:    0.7.0.1
 */