package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afc
  extends ckq
{
  public int Dff;
  public int dDN;
  public double latitude;
  public double longitude;
  public int nTB;
  public int uxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nTB);
      paramVarArgs.aR(3, this.uxV);
      paramVarArgs.aR(4, this.dDN);
      paramVarArgs.aR(5, this.Dff);
      paramVarArgs.e(6, this.latitude);
      paramVarArgs.e(7, this.longitude);
      AppMethodBeat.o(91456);
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
      int i = f.a.a.b.b.a.bA(2, this.nTB);
      int j = f.a.a.b.b.a.bA(3, this.uxV);
      int k = f.a.a.b.b.a.bA(4, this.dDN);
      int m = f.a.a.b.b.a.bA(5, this.Dff);
      int n = f.a.a.b.b.a.fY(6);
      int i1 = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(91456);
      return paramInt + i + j + k + m + (n + 8) + (i1 + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afc localafc = (afc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91456);
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
            localafc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91456);
          return 0;
        case 2: 
          localafc.nTB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91456);
          return 0;
        case 3: 
          localafc.uxV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91456);
          return 0;
        case 4: 
          localafc.dDN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91456);
          return 0;
        case 5: 
          localafc.Dff = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91456);
          return 0;
        case 6: 
          localafc.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91456);
          return 0;
        }
        localafc.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91456);
        return 0;
      }
      AppMethodBeat.o(91456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afc
 * JD-Core Version:    0.7.0.1
 */