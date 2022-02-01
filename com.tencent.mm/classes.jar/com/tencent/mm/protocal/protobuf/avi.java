package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avi
  extends ckq
{
  public String DtA;
  public int DuK;
  public int wVR;
  public long wVT;
  public String wxc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.wVT);
      paramVarArgs.aR(3, this.DuK);
      if (this.DtA != null) {
        paramVarArgs.d(4, this.DtA);
      }
      if (this.wxc != null) {
        paramVarArgs.d(5, this.wxc);
      }
      paramVarArgs.aR(6, this.wVR);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.wVT) + f.a.a.b.b.a.bA(3, this.DuK);
      paramInt = i;
      if (this.DtA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DtA);
      }
      i = paramInt;
      if (this.wxc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.wxc);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.wVR);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avi localavi = (avi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localavi.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localavi.wVT = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localavi.DuK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localavi.DtA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localavi.wxc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localavi.wVR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avi
 * JD-Core Version:    0.7.0.1
 */