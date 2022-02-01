package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class le
  extends ckq
{
  public String CGC;
  public String CGD;
  public long CGE;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CGC != null) {
        paramVarArgs.d(2, this.CGC);
      }
      if (this.CGD != null) {
        paramVarArgs.d(3, this.CGD);
      }
      if (this.mac != null) {
        paramVarArgs.d(4, this.mac);
      }
      paramVarArgs.aG(5, this.CGE);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CGC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CGC);
      }
      i = paramInt;
      if (this.CGD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CGD);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mac);
      }
      i = f.a.a.b.b.a.q(5, this.CGE);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        le localle = (le)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
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
            localle.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          localle.CGC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          localle.CGD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          localle.mac = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        localle.CGE = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.le
 * JD-Core Version:    0.7.0.1
 */