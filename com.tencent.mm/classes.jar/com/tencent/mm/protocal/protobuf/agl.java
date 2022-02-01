package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agl
  extends com.tencent.mm.bw.a
{
  public dww GwJ;
  public dww GwK;
  public String md5;
  public String name;
  public agg yfj;
  
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
      if (this.GwJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.GwK == null)
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
      if (this.GwJ != null)
      {
        paramVarArgs.lJ(3, this.GwJ.computeSize());
        this.GwJ.writeFields(paramVarArgs);
      }
      if (this.GwK != null)
      {
        paramVarArgs.lJ(4, this.GwK.computeSize());
        this.GwK.writeFields(paramVarArgs);
      }
      if (this.yfj != null)
      {
        paramVarArgs.lJ(5, this.yfj.computeSize());
        this.yfj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label882;
      }
    }
    label882:
    for (int i = f.a.a.b.b.a.e(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.GwJ != null) {
        i = paramInt + f.a.a.a.lI(3, this.GwJ.computeSize());
      }
      paramInt = i;
      if (this.GwK != null) {
        paramInt = i + f.a.a.a.lI(4, this.GwK.computeSize());
      }
      i = paramInt;
      if (this.yfj != null) {
        i = paramInt + f.a.a.a.lI(5, this.yfj.computeSize());
      }
      AppMethodBeat.o(140926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.GwJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.GwK == null)
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
        agl localagl = (agl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localagl.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localagl.name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagl.GwJ = ((dww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagl.GwK = ((dww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagl.yfj = ((agg)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agl
 * JD-Core Version:    0.7.0.1
 */