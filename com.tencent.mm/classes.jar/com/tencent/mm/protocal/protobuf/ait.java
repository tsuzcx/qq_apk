package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ait
  extends cvw
{
  public double latitude;
  public double longitude;
  public String vwq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vwq != null) {
        paramVarArgs.d(2, this.vwq);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      AppMethodBeat.o(91448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label460;
      }
    }
    label460:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vwq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vwq);
      }
      paramInt = f.a.a.b.b.a.amD(3);
      int j = f.a.a.b.b.a.amD(4);
      AppMethodBeat.o(91448);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91448);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ait localait = (ait)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91448);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localait.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91448);
          return 0;
        case 2: 
          localait.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91448);
          return 0;
        case 3: 
          localait.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91448);
          return 0;
        }
        localait.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(91448);
        return 0;
      }
      AppMethodBeat.o(91448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ait
 * JD-Core Version:    0.7.0.1
 */