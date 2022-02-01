package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dcl
  extends com.tencent.mm.bw.a
{
  public int FLw;
  public dqy FLx;
  public int FMc;
  public int FMd;
  public int FMe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.FLx != null)
      {
        paramVarArgs.ln(1, this.FLx.computeSize());
        this.FLx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FLw);
      paramVarArgs.aR(3, this.FMc);
      paramVarArgs.aR(4, this.FMd);
      paramVarArgs.aR(5, this.FMe);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLx == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.lm(1, this.FLx.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FLw);
      int j = f.a.a.b.b.a.bx(3, this.FMc);
      int k = f.a.a.b.b.a.bx(4, this.FMd);
      int m = f.a.a.b.b.a.bx(5, this.FMe);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FLx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcl localdcl = (dcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcl.FLx = ((dqy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localdcl.FLw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localdcl.FMc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localdcl.FMd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115855);
          return 0;
        }
        localdcl.FMe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcl
 * JD-Core Version:    0.7.0.1
 */