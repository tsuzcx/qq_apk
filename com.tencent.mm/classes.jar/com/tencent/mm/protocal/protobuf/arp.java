package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arp
  extends ckq
{
  public String DrR;
  public String DrS;
  public double latitude;
  public double longitude;
  public String nvj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      if (this.nvj != null) {
        paramVarArgs.d(4, this.nvj);
      }
      if (this.DrR != null) {
        paramVarArgs.d(5, this.DrR);
      }
      if (this.DrS != null) {
        paramVarArgs.d(6, this.DrS);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 8) + (f.a.a.b.b.a.fY(3) + 8);
      paramInt = i;
      if (this.nvj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nvj);
      }
      i = paramInt;
      if (this.DrR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DrR);
      }
      paramInt = i;
      if (this.DrS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DrS);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arp localarp = (arp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
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
            localarp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localarp.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localarp.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localarp.nvj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localarp.DrR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localarp.DrS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */