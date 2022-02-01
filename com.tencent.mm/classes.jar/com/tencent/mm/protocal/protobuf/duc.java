package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duc
  extends cvw
{
  public double HZG;
  public double HZH;
  public double altitude;
  public int bZk;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.e(4, this.altitude);
      paramVarArgs.e(5, this.HZG);
      paramVarArgs.e(6, this.HZH);
      paramVarArgs.aS(7, this.bZk);
      AppMethodBeat.o(123668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label585;
      }
    }
    label585:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amD(2);
      int j = f.a.a.b.b.a.amD(3);
      int k = f.a.a.b.b.a.amD(4);
      int m = f.a.a.b.b.a.amD(5);
      int n = f.a.a.b.b.a.amD(6);
      int i1 = f.a.a.b.b.a.bz(7, this.bZk);
      AppMethodBeat.o(123668);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duc localduc = (duc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123668);
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
            localduc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123668);
          return 0;
        case 2: 
          localduc.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(123668);
          return 0;
        case 3: 
          localduc.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(123668);
          return 0;
        case 4: 
          localduc.altitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(123668);
          return 0;
        case 5: 
          localduc.HZG = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(123668);
          return 0;
        case 6: 
          localduc.HZH = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(123668);
          return 0;
        }
        localduc.bZk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123668);
        return 0;
      }
      AppMethodBeat.o(123668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */