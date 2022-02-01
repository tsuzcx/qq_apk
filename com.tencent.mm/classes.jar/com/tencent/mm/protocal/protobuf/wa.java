package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wa
  extends ckq
{
  public String CLB;
  public dky CXZ;
  public int Scene;
  public String sdP;
  public String sdQ;
  public int uKQ;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CLB != null) {
        paramVarArgs.d(2, this.CLB);
      }
      paramVarArgs.aR(3, this.uKQ);
      paramVarArgs.aR(4, this.uKX);
      if (this.CXZ != null)
      {
        paramVarArgs.kX(5, this.CXZ.computeSize());
        this.CXZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.uKZ);
      paramVarArgs.aR(7, this.Scene);
      if (this.sdQ != null) {
        paramVarArgs.d(8, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(9, this.sdP);
      }
      AppMethodBeat.o(32166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CLB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CLB);
      }
      i = i + f.a.a.b.b.a.bA(3, this.uKQ) + f.a.a.b.b.a.bA(4, this.uKX);
      paramInt = i;
      if (this.CXZ != null) {
        paramInt = i + f.a.a.a.kW(5, this.CXZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.uKZ) + f.a.a.b.b.a.bA(7, this.Scene);
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.sdP);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wa localwa = (wa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
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
            localwa.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localwa.CLB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localwa.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localwa.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwa.CXZ = ((dky)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localwa.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localwa.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localwa.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localwa.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wa
 * JD-Core Version:    0.7.0.1
 */