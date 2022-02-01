package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cn
  extends ckq
{
  public int Cxp;
  public String Cxq;
  public String Cxr;
  public String gKn;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(2, this.gKn);
      }
      paramVarArgs.aR(3, this.mBH);
      paramVarArgs.aR(4, this.Cxp);
      if (this.Cxq != null) {
        paramVarArgs.d(5, this.Cxq);
      }
      if (this.Cxr != null) {
        paramVarArgs.d(6, this.Cxr);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gKn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gKn);
      }
      i = i + f.a.a.b.b.a.bA(3, this.mBH) + f.a.a.b.b.a.bA(4, this.Cxp);
      paramInt = i;
      if (this.Cxq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Cxq);
      }
      i = paramInt;
      if (this.Cxr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Cxr);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
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
            localcn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localcn.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localcn.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localcn.Cxp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localcn.Cxq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localcn.Cxr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cn
 * JD-Core Version:    0.7.0.1
 */