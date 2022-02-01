package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnd
  extends ckq
{
  public String DZr;
  public int DdZ;
  public long Dea;
  public long EAY;
  public dnj EBT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZr != null) {
        paramVarArgs.d(2, this.DZr);
      }
      paramVarArgs.aR(3, this.DdZ);
      paramVarArgs.aG(4, this.Dea);
      if (this.EBT != null)
      {
        paramVarArgs.kX(5, this.EBT.computeSize());
        this.EBT.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.EAY);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DZr);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DdZ) + f.a.a.b.b.a.q(4, this.Dea);
      paramInt = i;
      if (this.EBT != null) {
        paramInt = i + f.a.a.a.kW(5, this.EBT.computeSize());
      }
      i = f.a.a.b.b.a.q(6, this.EAY);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnd localdnd = (dnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
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
            localdnd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localdnd.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localdnd.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localdnd.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnd.EBT = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localdnd.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnd
 * JD-Core Version:    0.7.0.1
 */