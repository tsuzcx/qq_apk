package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddw
  extends ckq
{
  public String Evw;
  public String Evx;
  public String Evy;
  public String Evz;
  public int bvJ;
  public String vCZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.bvJ);
      if (this.Evw != null) {
        paramVarArgs.d(3, this.Evw);
      }
      if (this.Evx != null) {
        paramVarArgs.d(4, this.Evx);
      }
      if (this.vCZ != null) {
        paramVarArgs.d(5, this.vCZ);
      }
      if (this.Evy != null) {
        paramVarArgs.d(6, this.Evy);
      }
      if (this.Evz != null) {
        paramVarArgs.d(7, this.Evz);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.bvJ);
      paramInt = i;
      if (this.Evw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Evw);
      }
      i = paramInt;
      if (this.Evx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Evx);
      }
      paramInt = i;
      if (this.vCZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vCZ);
      }
      i = paramInt;
      if (this.Evy != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Evy);
      }
      paramInt = i;
      if (this.Evz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Evz);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddw localddw = (ddw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
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
            localddw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localddw.bvJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localddw.Evw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localddw.Evx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localddw.vCZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localddw.Evy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localddw.Evz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddw
 * JD-Core Version:    0.7.0.1
 */