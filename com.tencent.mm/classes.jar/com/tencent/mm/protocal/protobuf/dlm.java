package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlm
  extends com.tencent.mm.bx.a
{
  public String FuU;
  public String GNH;
  public eie HzX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153307);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(153307);
        throw paramVarArgs;
      }
      if (this.GNH != null) {
        paramVarArgs.d(1, this.GNH);
      }
      if (this.HzX != null)
      {
        paramVarArgs.lC(2, this.HzX.computeSize());
        this.HzX.writeFields(paramVarArgs);
      }
      if (this.FuU != null) {
        paramVarArgs.d(3, this.FuU);
      }
      AppMethodBeat.o(153307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GNH == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.GNH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HzX != null) {
        paramInt = i + f.a.a.a.lB(2, this.HzX.computeSize());
      }
      i = paramInt;
      if (this.FuU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FuU);
      }
      AppMethodBeat.o(153307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(153307);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlm localdlm = (dlm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153307);
          return -1;
        case 1: 
          localdlm.GNH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153307);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eie();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlm.HzX = ((eie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153307);
          return 0;
        }
        localdlm.FuU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153307);
        return 0;
      }
      AppMethodBeat.o(153307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlm
 * JD-Core Version:    0.7.0.1
 */