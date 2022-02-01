package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ber
  extends cvw
{
  public int GjL;
  public int GjM;
  public double latitude;
  public double longitude;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114028);
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
      paramVarArgs.aS(6, this.scene);
      paramVarArgs.aS(7, this.GjL);
      AppMethodBeat.o(114028);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.offset);
      int j = f.a.a.b.b.a.bz(3, this.GjM);
      int k = f.a.a.b.b.a.amD(4);
      int m = f.a.a.b.b.a.amD(5);
      int n = f.a.a.b.b.a.bz(6, this.scene);
      int i1 = f.a.a.b.b.a.bz(7, this.GjL);
      AppMethodBeat.o(114028);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114028);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ber localber = (ber)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114028);
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
            localber.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114028);
          return 0;
        case 2: 
          localber.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114028);
          return 0;
        case 3: 
          localber.GjM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114028);
          return 0;
        case 4: 
          localber.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114028);
          return 0;
        case 5: 
          localber.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114028);
          return 0;
        case 6: 
          localber.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114028);
          return 0;
        }
        localber.GjL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114028);
        return 0;
      }
      AppMethodBeat.o(114028);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ber
 * JD-Core Version:    0.7.0.1
 */