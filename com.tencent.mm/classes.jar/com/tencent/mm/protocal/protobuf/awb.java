package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awb
  extends ckq
{
  public int Dvv;
  public LinkedList<bpz> Dvw;
  public int Dvx;
  public LinkedList<bmz> Dvy;
  public String MD5;
  public int Scene;
  public int fVE;
  
  public awb()
  {
    AppMethodBeat.i(155408);
    this.Dvw = new LinkedList();
    this.Dvy = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fVE);
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aR(4, this.Dvv);
      paramVarArgs.e(5, 8, this.Dvw);
      paramVarArgs.aR(6, this.Dvx);
      paramVarArgs.e(7, 8, this.Dvy);
      paramVarArgs.aR(8, this.Scene);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.fVE);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.MD5);
      }
      i = f.a.a.b.b.a.bA(4, this.Dvv);
      int j = f.a.a.a.c(5, 8, this.Dvw);
      int k = f.a.a.b.b.a.bA(6, this.Dvx);
      int m = f.a.a.a.c(7, 8, this.Dvy);
      int n = f.a.a.b.b.a.bA(8, this.Scene);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dvw.clear();
        this.Dvy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awb localawb = (awb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
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
            localawb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localawb.fVE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localawb.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localawb.Dvv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawb.Dvw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localawb.Dvx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawb.Dvy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localawb.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awb
 * JD-Core Version:    0.7.0.1
 */