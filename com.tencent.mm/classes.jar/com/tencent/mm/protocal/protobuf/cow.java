package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cow
  extends ckq
{
  public int DQE;
  public int Dxp;
  public String EiQ;
  public String gKr;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152688);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      paramVarArgs.aR(4, this.DQE);
      paramVarArgs.aR(5, this.Dxp);
      if (this.EiQ != null) {
        paramVarArgs.d(6, this.EiQ);
      }
      AppMethodBeat.o(152688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      i = i + f.a.a.b.b.a.bA(4, this.DQE) + f.a.a.b.b.a.bA(5, this.Dxp);
      paramInt = i;
      if (this.EiQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EiQ);
      }
      AppMethodBeat.o(152688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152688);
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
            localcow.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152688);
          return 0;
        case 2: 
          localcow.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 3: 
          localcow.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 4: 
          localcow.DQE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152688);
          return 0;
        case 5: 
          localcow.Dxp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152688);
          return 0;
        }
        localcow.EiQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152688);
        return 0;
      }
      AppMethodBeat.o(152688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */