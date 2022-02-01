package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bev
  extends cvw
{
  public int GjM;
  public double latitude;
  public double longitude;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114030);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.offset);
      paramVarArgs.aS(3, this.GjM);
      paramVarArgs.e(4, this.latitude);
      paramVarArgs.e(5, this.longitude);
      AppMethodBeat.o(114030);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.offset);
      int j = f.a.a.b.b.a.bz(3, this.GjM);
      int k = f.a.a.b.b.a.amD(4);
      int m = f.a.a.b.b.a.amD(5);
      AppMethodBeat.o(114030);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114030);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bev localbev = (bev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114030);
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
            localbev.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114030);
          return 0;
        case 2: 
          localbev.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114030);
          return 0;
        case 3: 
          localbev.GjM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114030);
          return 0;
        case 4: 
          localbev.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114030);
          return 0;
        }
        localbev.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(114030);
        return 0;
      }
      AppMethodBeat.o(114030);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bev
 * JD-Core Version:    0.7.0.1
 */