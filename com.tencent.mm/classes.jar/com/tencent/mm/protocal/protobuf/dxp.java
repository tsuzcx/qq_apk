package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxp
  extends ckq
{
  public String EEF;
  public long LwA;
  public boolean LwO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.LwA);
      if (this.EEF != null) {
        paramVarArgs.d(3, this.EEF);
      }
      paramVarArgs.bg(4, this.LwO);
      AppMethodBeat.o(202484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.LwA);
      paramInt = i;
      if (this.EEF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EEF);
      }
      i = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(202484);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxp localdxp = (dxp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202484);
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
            localdxp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202484);
          return 0;
        case 2: 
          localdxp.LwA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(202484);
          return 0;
        case 3: 
          localdxp.EEF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(202484);
          return 0;
        }
        localdxp.LwO = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(202484);
        return 0;
      }
      AppMethodBeat.o(202484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxp
 * JD-Core Version:    0.7.0.1
 */