package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ass
  extends ckq
{
  public int CRs;
  public int CRt;
  public double latitude;
  public double longitude;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192648);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.offset);
      paramVarArgs.aR(3, this.CRt);
      paramVarArgs.e(4, this.latitude);
      paramVarArgs.e(5, this.longitude);
      paramVarArgs.aR(6, this.scene);
      paramVarArgs.aR(7, this.CRs);
      AppMethodBeat.o(192648);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.offset);
      int j = f.a.a.b.b.a.bA(3, this.CRt);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.bA(6, this.scene);
      int i1 = f.a.a.b.b.a.bA(7, this.CRs);
      AppMethodBeat.o(192648);
      return paramInt + i + j + (k + 8) + (m + 8) + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(192648);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192648);
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
            localass.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192648);
          return 0;
        case 2: 
          localass.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192648);
          return 0;
        case 3: 
          localass.CRt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192648);
          return 0;
        case 4: 
          localass.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(192648);
          return 0;
        case 5: 
          localass.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(192648);
          return 0;
        case 6: 
          localass.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192648);
          return 0;
        }
        localass.CRs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(192648);
        return 0;
      }
      AppMethodBeat.o(192648);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */