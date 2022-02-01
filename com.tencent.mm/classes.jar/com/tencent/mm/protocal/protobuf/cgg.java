package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgg
  extends ckq
{
  public float COI;
  public float COJ;
  public int DfE;
  public String DfF;
  public String DfG;
  public int DfH;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127296);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.x(3, this.COI);
      paramVarArgs.x(4, this.COJ);
      paramVarArgs.aR(5, this.DfE);
      if (this.DfF != null) {
        paramVarArgs.d(6, this.DfF);
      }
      if (this.DfG != null) {
        paramVarArgs.d(7, this.DfG);
      }
      paramVarArgs.aR(8, this.DfH);
      AppMethodBeat.o(127296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode) + (f.a.a.b.b.a.fY(3) + 4) + (f.a.a.b.b.a.fY(4) + 4) + f.a.a.b.b.a.bA(5, this.DfE);
      paramInt = i;
      if (this.DfF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DfF);
      }
      i = paramInt;
      if (this.DfG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DfG);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.DfH);
      AppMethodBeat.o(127296);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127296);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgg localcgg = (cgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127296);
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
            localcgg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127296);
          return 0;
        case 2: 
          localcgg.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127296);
          return 0;
        case 3: 
          localcgg.COI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(127296);
          return 0;
        case 4: 
          localcgg.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(127296);
          return 0;
        case 5: 
          localcgg.DfE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127296);
          return 0;
        case 6: 
          localcgg.DfF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127296);
          return 0;
        case 7: 
          localcgg.DfG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127296);
          return 0;
        }
        localcgg.DfH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127296);
        return 0;
      }
      AppMethodBeat.o(127296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgg
 * JD-Core Version:    0.7.0.1
 */