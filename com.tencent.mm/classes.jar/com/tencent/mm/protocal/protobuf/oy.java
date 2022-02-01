package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class oy
  extends dpc
{
  public int KUq;
  public long KVL;
  public int KVM;
  public int KVN;
  public long KVO;
  public LinkedList<ow> KVP;
  public int KVQ;
  public LinkedList<dkn> KVR;
  public dkm KVS;
  public String KVe;
  public String buffer;
  public int cSx;
  public int oKV;
  
  public oy()
  {
    AppMethodBeat.i(124440);
    this.KVP = new LinkedList();
    this.KVR = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KVL);
      paramVarArgs.aM(3, this.KVM);
      paramVarArgs.aM(4, this.KVN);
      paramVarArgs.bb(5, this.KVO);
      paramVarArgs.aM(6, this.KUq);
      paramVarArgs.e(7, 8, this.KVP);
      paramVarArgs.aM(8, this.KVQ);
      if (this.KVe != null) {
        paramVarArgs.e(9, this.KVe);
      }
      paramVarArgs.aM(10, this.oKV);
      paramVarArgs.aM(11, this.cSx);
      paramVarArgs.e(12, 8, this.KVR);
      if (this.buffer != null) {
        paramVarArgs.e(14, this.buffer);
      }
      if (this.KVS != null)
      {
        paramVarArgs.ni(16, this.KVS.computeSize());
        this.KVS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1274;
      }
    }
    label1274:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KVL) + g.a.a.b.b.a.bu(3, this.KVM) + g.a.a.b.b.a.bu(4, this.KVN) + g.a.a.b.b.a.r(5, this.KVO) + g.a.a.b.b.a.bu(6, this.KUq) + g.a.a.a.c(7, 8, this.KVP) + g.a.a.b.b.a.bu(8, this.KVQ);
      paramInt = i;
      if (this.KVe != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KVe);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.oKV) + g.a.a.b.b.a.bu(11, this.cSx) + g.a.a.a.c(12, 8, this.KVR);
      paramInt = i;
      if (this.buffer != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.buffer);
      }
      i = paramInt;
      if (this.KVS != null) {
        i = paramInt + g.a.a.a.nh(16, this.KVS.computeSize());
      }
      AppMethodBeat.o(124441);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KVP.clear();
        this.KVR.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oy localoy = (oy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 13: 
        case 15: 
        default: 
          AppMethodBeat.o(124441);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localoy.KVL = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localoy.KVM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localoy.KVN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localoy.KVO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localoy.KUq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ow();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ow)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoy.KVP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localoy.KVQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 9: 
          localoy.KVe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 10: 
          localoy.oKV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 11: 
          localoy.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124441);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoy.KVR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 14: 
          localoy.buffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124441);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localoy.KVS = ((dkm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oy
 * JD-Core Version:    0.7.0.1
 */