package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwx
  extends ckq
{
  public com.tencent.mm.bx.b DKa;
  public String EoU;
  public String EoV;
  public String EoW;
  public int EoX;
  public int EoY;
  public int EoZ;
  public int Epa;
  public cwv Epb;
  public cwv Epc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.EoU == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.EoV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.EoW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DKa != null) {
        paramVarArgs.c(2, this.DKa);
      }
      if (this.EoU != null) {
        paramVarArgs.d(3, this.EoU);
      }
      if (this.EoV != null) {
        paramVarArgs.d(4, this.EoV);
      }
      if (this.EoW != null) {
        paramVarArgs.d(5, this.EoW);
      }
      paramVarArgs.aR(6, this.EoX);
      paramVarArgs.aR(7, this.EoY);
      paramVarArgs.aR(8, this.EoZ);
      paramVarArgs.aR(9, this.Epa);
      if (this.Epb != null)
      {
        paramVarArgs.kX(10, this.Epb.computeSize());
        this.Epb.writeFields(paramVarArgs);
      }
      if (this.Epc != null)
      {
        paramVarArgs.kX(11, this.Epc.computeSize());
        this.Epc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DKa != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DKa);
      }
      i = paramInt;
      if (this.EoU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EoU);
      }
      paramInt = i;
      if (this.EoV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EoV);
      }
      i = paramInt;
      if (this.EoW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EoW);
      }
      i = i + f.a.a.b.b.a.bA(6, this.EoX) + f.a.a.b.b.a.bA(7, this.EoY) + f.a.a.b.b.a.bA(8, this.EoZ) + f.a.a.b.b.a.bA(9, this.Epa);
      paramInt = i;
      if (this.Epb != null) {
        paramInt = i + f.a.a.a.kW(10, this.Epb.computeSize());
      }
      i = paramInt;
      if (this.Epc != null) {
        i = paramInt + f.a.a.a.kW(11, this.Epc.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DKa == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.EoU == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.EoV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.EoW == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwx localcwx = (cwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
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
            localcwx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localcwx.DKa = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localcwx.EoU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localcwx.EoV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localcwx.EoW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localcwx.EoX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localcwx.EoY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localcwx.EoZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localcwx.Epa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwx.Epb = ((cwv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwx.Epc = ((cwv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      AppMethodBeat.o(133198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */