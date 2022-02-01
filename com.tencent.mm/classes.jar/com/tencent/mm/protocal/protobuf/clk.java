package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clk
  extends ckq
{
  public int CreateTime;
  public String CyF;
  public int EgJ;
  public int EgK;
  public int EgL;
  public long EgM;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CyF != null) {
        paramVarArgs.d(2, this.CyF);
      }
      paramVarArgs.aR(3, this.EgJ);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.EgK);
      if (this.sdQ != null) {
        paramVarArgs.d(6, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(7, this.sdP);
      }
      paramVarArgs.aR(8, this.EgL);
      paramVarArgs.aG(9, this.EgM);
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CyF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CyF);
      }
      i = i + f.a.a.b.b.a.bA(3, this.EgJ) + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(5, this.EgK);
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sdP);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.EgL);
      int j = f.a.a.b.b.a.q(9, this.EgM);
      AppMethodBeat.o(32415);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localclk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localclk.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localclk.EgJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localclk.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localclk.EgK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localclk.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localclk.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localclk.EgL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32415);
          return 0;
        }
        localclk.EgM = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */