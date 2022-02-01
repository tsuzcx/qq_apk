package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czv;
import f.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public czv xRj;
  public String yaF;
  public int yaG;
  public String yaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.xRj == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.yaF != null) {
        paramVarArgs.d(1, this.yaF);
      }
      if (this.xRj != null)
      {
        paramVarArgs.ln(2, this.xRj.computeSize());
        this.xRj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.yaG);
      if (this.yaH != null) {
        paramVarArgs.d(4, this.yaH);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yaF == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.yaF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xRj != null) {
        i = paramInt + f.a.a.a.lm(2, this.xRj.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.yaG);
      paramInt = i;
      if (this.yaH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yaH);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.yaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.xRj == null)
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
          locale.yaF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((czv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.xRj = ((czv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locale.yaG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(96156);
          return 0;
        }
        locale.yaH = ((f.a.a.a.a)localObject1).LVo.readString();
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