package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dxm
  extends ckq
{
  public int CUg;
  public b Khv;
  public b LwJ;
  public int LwK;
  public int LwL;
  public int htk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LwJ != null) {
        paramVarArgs.c(2, this.LwJ);
      }
      paramVarArgs.aR(3, this.htk);
      if (this.Khv != null) {
        paramVarArgs.c(4, this.Khv);
      }
      paramVarArgs.aR(5, this.LwK);
      paramVarArgs.aR(6, this.LwL);
      paramVarArgs.aR(7, this.CUg);
      AppMethodBeat.o(200806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LwJ != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.LwJ);
      }
      i += f.a.a.b.b.a.bA(3, this.htk);
      paramInt = i;
      if (this.Khv != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Khv);
      }
      i = f.a.a.b.b.a.bA(5, this.LwK);
      int j = f.a.a.b.b.a.bA(6, this.LwL);
      int k = f.a.a.b.b.a.bA(7, this.CUg);
      AppMethodBeat.o(200806);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(200806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxm localdxm = (dxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200806);
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
            localdxm.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200806);
          return 0;
        case 2: 
          localdxm.LwJ = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(200806);
          return 0;
        case 3: 
          localdxm.htk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(200806);
          return 0;
        case 4: 
          localdxm.Khv = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(200806);
          return 0;
        case 5: 
          localdxm.LwK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(200806);
          return 0;
        case 6: 
          localdxm.LwL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(200806);
          return 0;
        }
        localdxm.CUg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(200806);
        return 0;
      }
      AppMethodBeat.o(200806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */