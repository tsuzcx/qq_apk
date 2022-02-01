package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adt
  extends com.tencent.mm.bw.a
{
  public dqj EwA;
  public dqj Ewz;
  public String md5;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Ewz == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.EwA == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.d(1, this.md5);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.Ewz != null)
      {
        paramVarArgs.ln(3, this.Ewz.computeSize());
        this.Ewz.writeFields(paramVarArgs);
      }
      if (this.EwA != null)
      {
        paramVarArgs.ln(4, this.EwA.computeSize());
        this.EwA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label730;
      }
    }
    label730:
    for (int i = f.a.a.b.b.a.e(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.Ewz != null) {
        i = paramInt + f.a.a.a.lm(3, this.Ewz.computeSize());
      }
      paramInt = i;
      if (this.EwA != null) {
        paramInt = i + f.a.a.a.lm(4, this.EwA.computeSize());
      }
      AppMethodBeat.o(140926);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Ewz == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.EwA == null)
        {
          paramVarArgs = new b("Not all required fields were included: showMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adt localadt = (adt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localadt.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localadt.name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadt.Ewz = ((dqj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadt.EwA = ((dqj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(140926);
        return 0;
      }
      AppMethodBeat.o(140926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adt
 * JD-Core Version:    0.7.0.1
 */