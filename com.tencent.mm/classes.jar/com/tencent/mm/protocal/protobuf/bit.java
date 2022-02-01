package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bit
  extends ckq
{
  public String DFP;
  public String DFR;
  public String DFS;
  public b DFT;
  public int DFU;
  public String DFV;
  public LinkedList<bji> DFZ;
  public String cMo;
  public String dlB;
  public String signature;
  public String url;
  
  public bit()
  {
    AppMethodBeat.i(82444);
    this.DFZ = new LinkedList();
    AppMethodBeat.o(82444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.DFP != null) {
        paramVarArgs.d(4, this.DFP);
      }
      if (this.cMo != null) {
        paramVarArgs.d(5, this.cMo);
      }
      if (this.DFR != null) {
        paramVarArgs.d(6, this.DFR);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.DFS != null) {
        paramVarArgs.d(8, this.DFS);
      }
      if (this.DFT != null) {
        paramVarArgs.c(9, this.DFT);
      }
      paramVarArgs.aR(10, this.DFU);
      paramVarArgs.e(11, 8, this.DFZ);
      if (this.DFV != null) {
        paramVarArgs.d(12, this.DFV);
      }
      AppMethodBeat.o(82445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      paramInt = i;
      if (this.DFP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DFP);
      }
      i = paramInt;
      if (this.cMo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cMo);
      }
      paramInt = i;
      if (this.DFR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DFR);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.DFS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DFS);
      }
      i = paramInt;
      if (this.DFT != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.DFT);
      }
      i = i + f.a.a.b.b.a.bA(10, this.DFU) + f.a.a.a.c(11, 8, this.DFZ);
      paramInt = i;
      if (this.DFV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DFV);
      }
      AppMethodBeat.o(82445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DFZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bit localbit = (bit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82445);
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
            localbit.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 2: 
          localbit.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 3: 
          localbit.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 4: 
          localbit.DFP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 5: 
          localbit.cMo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 6: 
          localbit.DFR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 7: 
          localbit.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 8: 
          localbit.DFS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 9: 
          localbit.DFT = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(82445);
          return 0;
        case 10: 
          localbit.DFU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbit.DFZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        }
        localbit.DFV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82445);
        return 0;
      }
      AppMethodBeat.o(82445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bit
 * JD-Core Version:    0.7.0.1
 */