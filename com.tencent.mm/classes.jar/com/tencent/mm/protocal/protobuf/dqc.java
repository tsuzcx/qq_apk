package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqc
  extends ckq
{
  public int AGn;
  public double EFU;
  public double EFV;
  public String EFW;
  public LinkedList<dix> EFX;
  public int scene;
  public String sessionId;
  
  public dqc()
  {
    AppMethodBeat.i(121112);
    this.EFX = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.EFU);
      paramVarArgs.e(3, this.EFV);
      if (this.EFW != null) {
        paramVarArgs.d(4, this.EFW);
      }
      paramVarArgs.aR(5, this.AGn);
      if (this.sessionId != null) {
        paramVarArgs.d(6, this.sessionId);
      }
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.e(8, 8, this.EFX);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 8) + (f.a.a.b.b.a.fY(3) + 8);
      paramInt = i;
      if (this.EFW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EFW);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.AGn);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sessionId);
      }
      i = f.a.a.b.b.a.bA(7, this.scene);
      int j = f.a.a.a.c(8, 8, this.EFX);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EFX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqc localdqc = (dqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localdqc.EFU = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localdqc.EFV = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localdqc.EFW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localdqc.AGn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localdqc.sessionId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localdqc.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dix();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqc.EFX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqc
 * JD-Core Version:    0.7.0.1
 */