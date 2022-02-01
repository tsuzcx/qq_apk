package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cjr
  extends ckq
{
  public float EeK;
  public b EeL;
  public boolean EeM;
  public boolean EeN;
  public float dpb;
  public float dqQ;
  public String dyc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.x(2, this.dqQ);
      paramVarArgs.x(3, this.dpb);
      paramVarArgs.x(4, this.EeK);
      if (this.EeL != null) {
        paramVarArgs.c(5, this.EeL);
      }
      if (this.dyc != null) {
        paramVarArgs.d(6, this.dyc);
      }
      paramVarArgs.bg(7, this.EeM);
      paramVarArgs.bg(8, this.EeN);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 4) + (f.a.a.b.b.a.fY(3) + 4) + (f.a.a.b.b.a.fY(4) + 4);
      paramInt = i;
      if (this.EeL != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.EeL);
      }
      i = paramInt;
      if (this.dyc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dyc);
      }
      paramInt = f.a.a.b.b.a.fY(7);
      int j = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(114064);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjr localcjr = (cjr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localcjr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localcjr.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localcjr.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localcjr.EeK = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localcjr.EeL = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localcjr.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localcjr.EeM = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(114064);
          return 0;
        }
        localcjr.EeN = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjr
 * JD-Core Version:    0.7.0.1
 */