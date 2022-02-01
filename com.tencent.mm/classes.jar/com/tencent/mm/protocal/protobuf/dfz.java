package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfz
  extends com.tencent.mm.bw.a
{
  public String DPF;
  public eby FPm;
  public String Fed;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153307);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fed == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(153307);
        throw paramVarArgs;
      }
      if (this.Fed != null) {
        paramVarArgs.d(1, this.Fed);
      }
      if (this.FPm != null)
      {
        paramVarArgs.ln(2, this.FPm.computeSize());
        this.FPm.writeFields(paramVarArgs);
      }
      if (this.DPF != null) {
        paramVarArgs.d(3, this.DPF);
      }
      AppMethodBeat.o(153307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fed == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.Fed) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FPm != null) {
        paramInt = i + f.a.a.a.lm(2, this.FPm.computeSize());
      }
      i = paramInt;
      if (this.DPF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DPF);
      }
      AppMethodBeat.o(153307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fed == null)
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
        dfz localdfz = (dfz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153307);
          return -1;
        case 1: 
          localdfz.Fed = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153307);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eby();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfz.FPm = ((eby)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153307);
          return 0;
        }
        localdfz.DPF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153307);
        return 0;
      }
      AppMethodBeat.o(153307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfz
 * JD-Core Version:    0.7.0.1
 */