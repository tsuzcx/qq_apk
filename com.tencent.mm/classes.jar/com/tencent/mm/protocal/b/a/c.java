package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahh;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String DKy;
  public ahh DKz;
  public String desc;
  public LinkedList<agx> hkS;
  public long pmI;
  public String title;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.hkS = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.hkS);
      if (this.DKy != null) {
        paramVarArgs.d(4, this.DKy);
      }
      if (this.DKz != null)
      {
        paramVarArgs.ln(5, this.DKz.computeSize());
        this.DKz.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.pmI);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.a.c(3, 8, this.hkS);
      paramInt = i;
      if (this.DKy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DKy);
      }
      i = paramInt;
      if (this.DKz != null) {
        i = paramInt + f.a.a.a.lm(5, this.DKz.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.pmI);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hkS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.hkS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.DKy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.DKz = ((ahh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.pmI = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */