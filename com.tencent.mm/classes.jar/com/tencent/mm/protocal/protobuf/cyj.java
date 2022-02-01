package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyj
  extends ckq
{
  public String Emn;
  public long Emo;
  public int EnA;
  public long Enz;
  public String mAQ;
  public int oXI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      paramVarArgs.aR(4, this.oXI);
      paramVarArgs.aG(5, this.Emo);
      paramVarArgs.aG(6, this.Enz);
      paramVarArgs.aR(7, this.EnA);
      AppMethodBeat.o(118449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Emn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.oXI);
      int j = f.a.a.b.b.a.q(5, this.Emo);
      int k = f.a.a.b.b.a.q(6, this.Enz);
      int m = f.a.a.b.b.a.bA(7, this.EnA);
      AppMethodBeat.o(118449);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyj localcyj = (cyj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118449);
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
            localcyj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118449);
          return 0;
        case 2: 
          localcyj.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 3: 
          localcyj.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 4: 
          localcyj.oXI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118449);
          return 0;
        case 5: 
          localcyj.Emo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118449);
          return 0;
        case 6: 
          localcyj.Enz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118449);
          return 0;
        }
        localcyj.EnA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118449);
        return 0;
      }
      AppMethodBeat.o(118449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyj
 * JD-Core Version:    0.7.0.1
 */