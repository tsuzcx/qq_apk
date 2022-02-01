package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfi;
import f.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public dfi zhd;
  public String zqB;
  public int zqC;
  public String zqD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zqB == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.zhd == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.zqB != null) {
        paramVarArgs.d(1, this.zqB);
      }
      if (this.zhd != null)
      {
        paramVarArgs.lC(2, this.zhd.computeSize());
        this.zhd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.zqC);
      if (this.zqD != null) {
        paramVarArgs.d(4, this.zqD);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zqB == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.zqB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zhd != null) {
        i = paramInt + f.a.a.a.lB(2, this.zhd.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.zqC);
      paramInt = i;
      if (this.zqD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zqD);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.zqB == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.zhd == null)
        {
          paramVarArgs = new b("Not all required fields were included: actionGroup");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96156);
          return -1;
        case 1: 
          locale.zqB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dfi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.zhd = ((dfi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locale.zqC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(96156);
          return 0;
        }
        locale.zqD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(96156);
        return 0;
      }
      AppMethodBeat.o(96156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e
 * JD-Core Version:    0.7.0.1
 */