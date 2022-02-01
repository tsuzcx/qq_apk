package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arl
  extends ckq
{
  public long CQC;
  public String CQp;
  public int CRs;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CQp != null) {
        paramVarArgs.d(2, this.CQp);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aG(5, this.CQC);
      paramVarArgs.aR(6, this.CRs);
      paramVarArgs.aR(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label608;
      }
    }
    label608:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CQp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CQp);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.b.b.a.fY(4);
      int k = f.a.a.b.b.a.q(5, this.CQC);
      int m = f.a.a.b.b.a.bA(6, this.CRs);
      int n = f.a.a.b.b.a.bA(7, this.scene);
      AppMethodBeat.o(114015);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arl localarl = (arl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localarl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localarl.CQp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localarl.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localarl.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localarl.CQC = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localarl.CRs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114015);
          return 0;
        }
        localarl.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */