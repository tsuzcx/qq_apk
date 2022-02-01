package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccu
  extends ckq
{
  public int CYi;
  public long DYU;
  public int DYV;
  public String DYW;
  public int DZd;
  public int DZe;
  public int DZf;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      if (this.DYW != null) {
        paramVarArgs.d(3, this.DYW);
      }
      paramVarArgs.aR(4, this.CYi);
      paramVarArgs.aG(5, this.DYU);
      paramVarArgs.aR(6, this.DYV);
      if (this.sdP != null) {
        paramVarArgs.d(7, this.sdP);
      }
      paramVarArgs.aR(8, this.DZe);
      paramVarArgs.aR(9, this.DZd);
      paramVarArgs.aR(10, this.DZf);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdQ);
      }
      i = paramInt;
      if (this.DYW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYW);
      }
      i = i + f.a.a.b.b.a.bA(4, this.CYi) + f.a.a.b.b.a.q(5, this.DYU) + f.a.a.b.b.a.bA(6, this.DYV);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sdP);
      }
      i = f.a.a.b.b.a.bA(8, this.DZe);
      int j = f.a.a.b.b.a.bA(9, this.DZd);
      int k = f.a.a.b.b.a.bA(10, this.DZf);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccu localccu = (ccu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
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
            localccu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localccu.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localccu.DYW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localccu.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localccu.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localccu.DYV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localccu.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localccu.DZe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localccu.DZd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32378);
          return 0;
        }
        localccu.DZf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccu
 * JD-Core Version:    0.7.0.1
 */