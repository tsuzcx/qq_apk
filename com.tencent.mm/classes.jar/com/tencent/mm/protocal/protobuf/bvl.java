package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvl
  extends com.tencent.mm.bw.a
{
  public bjb DYb;
  public bjc DYc;
  public int Fll;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.DYc == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.DYb != null)
      {
        paramVarArgs.ln(1, this.DYb.computeSize());
        this.DYb.writeFields(paramVarArgs);
      }
      if (this.DYc != null)
      {
        paramVarArgs.ln(2, this.DYc.computeSize());
        this.DYc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Fll);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYb == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = f.a.a.a.lm(1, this.DYb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DYc != null) {
        i = paramInt + f.a.a.a.lm(2, this.DYc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Fll);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYb == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        if (this.DYc == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32350);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvl localbvl = (bvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvl.DYb = ((bjb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvl.DYc = ((bjc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localbvl.Fll = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvl
 * JD-Core Version:    0.7.0.1
 */