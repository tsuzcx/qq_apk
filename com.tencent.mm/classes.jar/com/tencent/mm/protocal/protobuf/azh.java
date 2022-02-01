package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azh
  extends cvw
{
  public String GPw;
  public String GPx;
  public double latitude;
  public double longitude;
  public String oIf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
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
      if (this.oIf != null) {
        paramVarArgs.d(4, this.oIf);
      }
      if (this.GPw != null) {
        paramVarArgs.d(5, this.GPw);
      }
      if (this.GPx != null) {
        paramVarArgs.d(6, this.GPx);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amD(2) + f.a.a.b.b.a.amD(3);
      paramInt = i;
      if (this.oIf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oIf);
      }
      i = paramInt;
      if (this.GPw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GPw);
      }
      paramInt = i;
      if (this.GPx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GPx);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azh localazh = (azh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
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
            localazh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localazh.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localazh.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localazh.oIf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localazh.GPw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localazh.GPx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azh
 * JD-Core Version:    0.7.0.1
 */