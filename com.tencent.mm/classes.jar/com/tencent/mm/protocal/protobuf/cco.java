package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cco
  extends ckq
{
  public long DYU;
  public int DYV;
  public String DYW;
  public long DYX;
  public int DdZ;
  public long Dea;
  public String sdP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      if (this.sdP != null) {
        paramVarArgs.d(4, this.sdP);
      }
      paramVarArgs.aG(5, this.DYU);
      paramVarArgs.aR(6, this.DYV);
      if (this.DYW != null) {
        paramVarArgs.d(7, this.DYW);
      }
      paramVarArgs.aG(8, this.DYX);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdP);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.DYU) + f.a.a.b.b.a.bA(6, this.DYV);
      paramInt = i;
      if (this.DYW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DYW);
      }
      i = f.a.a.b.b.a.q(8, this.DYX);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cco localcco = (cco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localcco.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localcco.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localcco.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localcco.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localcco.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localcco.DYV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localcco.DYW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localcco.DYX = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cco
 * JD-Core Version:    0.7.0.1
 */