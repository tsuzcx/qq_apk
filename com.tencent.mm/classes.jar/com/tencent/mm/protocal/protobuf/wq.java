package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wq
  extends cvp
{
  public LinkedList<wr> FVT;
  public String dpf;
  public String gOx;
  public int jpO;
  
  public wq()
  {
    AppMethodBeat.i(219293);
    this.FVT = new LinkedList();
    AppMethodBeat.o(219293);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FVT);
      if (this.dpf != null) {
        paramVarArgs.d(3, this.dpf);
      }
      paramVarArgs.aS(4, this.jpO);
      if (this.gOx != null) {
        paramVarArgs.d(5, this.gOx);
      }
      AppMethodBeat.o(219294);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FVT);
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dpf);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.jpO);
      paramInt = i;
      if (this.gOx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gOx);
      }
      AppMethodBeat.o(219294);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FVT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219294);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wq localwq = (wq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(219294);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(219294);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwq.FVT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(219294);
          return 0;
        case 3: 
          localwq.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219294);
          return 0;
        case 4: 
          localwq.jpO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(219294);
          return 0;
        }
        localwq.gOx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(219294);
        return 0;
      }
      AppMethodBeat.o(219294);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wq
 * JD-Core Version:    0.7.0.1
 */