package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bte
  extends ckq
{
  public int DQh;
  public int DQi;
  public b DQj;
  public int DQk;
  public String DQl;
  public String DQm;
  public String DQn;
  public b Dvq;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DQh);
      paramVarArgs.aR(3, this.DQi);
      if (this.DQj != null) {
        paramVarArgs.c(4, this.DQj);
      }
      paramVarArgs.aR(5, this.DQk);
      if (this.Dvq != null) {
        paramVarArgs.c(6, this.Dvq);
      }
      if (this.DQl != null) {
        paramVarArgs.d(7, this.DQl);
      }
      if (this.DQm != null) {
        paramVarArgs.d(8, this.DQm);
      }
      if (this.DQn != null) {
        paramVarArgs.d(9, this.DQn);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DQh) + f.a.a.b.b.a.bA(3, this.DQi);
      paramInt = i;
      if (this.DQj != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DQj);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DQk);
      paramInt = i;
      if (this.Dvq != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.Dvq);
      }
      i = paramInt;
      if (this.DQl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DQl);
      }
      paramInt = i;
      if (this.DQm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DQm);
      }
      i = paramInt;
      if (this.DQn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DQn);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Scene);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bte localbte = (bte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
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
            localbte.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localbte.DQh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localbte.DQi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localbte.DQj = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localbte.DQk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localbte.Dvq = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localbte.DQl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localbte.DQm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localbte.DQn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localbte.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bte
 * JD-Core Version:    0.7.0.1
 */