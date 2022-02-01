package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgc;
import f.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String zHQ;
  public int zHR;
  public String zHS;
  public dgc zxT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zHQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.zxT == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.zHQ != null) {
        paramVarArgs.d(1, this.zHQ);
      }
      if (this.zxT != null)
      {
        paramVarArgs.lJ(2, this.zxT.computeSize());
        this.zxT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.zHR);
      if (this.zHS != null) {
        paramVarArgs.d(4, this.zHS);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zHQ == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.zHQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zxT != null) {
        i = paramInt + f.a.a.a.lI(2, this.zxT.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.zHR);
      paramInt = i;
      if (this.zHS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zHS);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.zHQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.zxT == null)
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
          locale.zHQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.zxT = ((dgc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locale.zHR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(96156);
          return 0;
        }
        locale.zHS = ((f.a.a.a.a)localObject1).OmT.readString();
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