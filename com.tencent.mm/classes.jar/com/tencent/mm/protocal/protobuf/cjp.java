package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjp
  extends ckq
{
  public int EeJ;
  public String dyc;
  public double latitude;
  public double longitude;
  public String nrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.aR(4, this.EeJ);
      if (this.nrr != null) {
        paramVarArgs.d(5, this.nrr);
      }
      if (this.dyc != null) {
        paramVarArgs.d(6, this.dyc);
      }
      AppMethodBeat.o(114062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 8) + (f.a.a.b.b.a.fY(3) + 8) + f.a.a.b.b.a.bA(4, this.EeJ);
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nrr);
      }
      i = paramInt;
      if (this.dyc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dyc);
      }
      AppMethodBeat.o(114062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjp localcjp = (cjp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114062);
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
            localcjp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114062);
          return 0;
        case 2: 
          localcjp.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114062);
          return 0;
        case 3: 
          localcjp.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114062);
          return 0;
        case 4: 
          localcjp.EeJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114062);
          return 0;
        case 5: 
          localcjp.nrr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114062);
          return 0;
        }
        localcjp.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114062);
        return 0;
      }
      AppMethodBeat.o(114062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjp
 * JD-Core Version:    0.7.0.1
 */