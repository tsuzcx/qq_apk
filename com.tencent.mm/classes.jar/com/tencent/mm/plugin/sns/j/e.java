package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuj;
import f.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public cuj wEO;
  public String wNY;
  public int wNZ;
  public String wOa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wNY == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.wEO == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.wNY != null) {
        paramVarArgs.d(1, this.wNY);
      }
      if (this.wEO != null)
      {
        paramVarArgs.kX(2, this.wEO.computeSize());
        this.wEO.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.wNZ);
      if (this.wOa != null) {
        paramVarArgs.d(4, this.wOa);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wNY == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.wNY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wEO != null) {
        i = paramInt + f.a.a.a.kW(2, this.wEO.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.wNZ);
      paramInt = i;
      if (this.wOa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wOa);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.wNY == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.wEO == null)
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
          locale.wNY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cuj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.wEO = ((cuj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locale.wNZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(96156);
          return 0;
        }
        locale.wOa = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(96156);
        return 0;
      }
      AppMethodBeat.o(96156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.e
 * JD-Core Version:    0.7.0.1
 */