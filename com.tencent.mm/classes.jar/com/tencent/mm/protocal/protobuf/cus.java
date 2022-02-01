package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cus
  extends ckq
{
  public String Emw;
  public int Emx;
  public int mBH;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125782);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.Emw != null) {
        paramVarArgs.d(4, this.Emw);
      }
      paramVarArgs.aR(5, this.mBH);
      paramVarArgs.aR(6, this.Emx);
      AppMethodBeat.o(125782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.Emw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Emw);
      }
      i = f.a.a.b.b.a.bA(5, this.mBH);
      int j = f.a.a.b.b.a.bA(6, this.Emx);
      AppMethodBeat.o(125782);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cus localcus = (cus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125782);
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
            localcus.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125782);
          return 0;
        case 2: 
          localcus.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125782);
          return 0;
        case 3: 
          localcus.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125782);
          return 0;
        case 4: 
          localcus.Emw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125782);
          return 0;
        case 5: 
          localcus.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125782);
          return 0;
        }
        localcus.Emx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125782);
        return 0;
      }
      AppMethodBeat.o(125782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cus
 * JD-Core Version:    0.7.0.1
 */