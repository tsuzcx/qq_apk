package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cfo
  extends ckq
{
  public il CWP;
  public int CXV;
  public int CXW;
  public int EbD;
  public b EbE;
  public b EbF;
  public b EbG;
  public int EbH;
  public cfp EbI;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CWP != null)
      {
        paramVarArgs.kX(2, this.CWP.computeSize());
        this.CWP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EbD);
      if (this.EbE != null) {
        paramVarArgs.c(4, this.EbE);
      }
      if (this.EbF != null) {
        paramVarArgs.c(5, this.EbF);
      }
      if (this.EbG != null) {
        paramVarArgs.c(6, this.EbG);
      }
      paramVarArgs.aR(7, this.CXW);
      paramVarArgs.aR(8, this.CXV);
      paramVarArgs.aR(9, this.EbH);
      paramVarArgs.aG(10, this.timestamp);
      if (this.EbI != null)
      {
        paramVarArgs.kX(11, this.EbI.computeSize());
        this.EbI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CWP != null) {
        i = paramInt + f.a.a.a.kW(2, this.CWP.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.EbD);
      paramInt = i;
      if (this.EbE != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EbE);
      }
      i = paramInt;
      if (this.EbF != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.EbF);
      }
      paramInt = i;
      if (this.EbG != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.EbG);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CXW) + f.a.a.b.b.a.bA(8, this.CXV) + f.a.a.b.b.a.bA(9, this.EbH) + f.a.a.b.b.a.q(10, this.timestamp);
      paramInt = i;
      if (this.EbI != null) {
        paramInt = i + f.a.a.a.kW(11, this.EbI.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfo localcfo = (cfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
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
            localcfo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new il();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((il)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfo.CWP = ((il)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localcfo.EbD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localcfo.EbE = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localcfo.EbF = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localcfo.EbG = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localcfo.CXW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localcfo.CXV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localcfo.EbH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localcfo.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfo.EbI = ((cfp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfo
 * JD-Core Version:    0.7.0.1
 */