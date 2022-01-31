package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zh
  extends com.tencent.mm.bv.a
{
  public String cqq;
  public String name;
  public cqz wQk;
  public cqz wQl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2531);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(2531);
        throw paramVarArgs;
      }
      if (this.wQk == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(2531);
        throw paramVarArgs;
      }
      if (this.wQl == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(2531);
        throw paramVarArgs;
      }
      if (this.cqq != null) {
        paramVarArgs.e(1, this.cqq);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.wQk != null)
      {
        paramVarArgs.iQ(3, this.wQk.computeSize());
        this.wQk.writeFields(paramVarArgs);
      }
      if (this.wQl != null)
      {
        paramVarArgs.iQ(4, this.wQl.computeSize());
        this.wQl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(2531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cqq == null) {
        break label744;
      }
    }
    label744:
    for (int i = e.a.a.b.b.a.f(1, this.cqq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.wQk != null) {
        i = paramInt + e.a.a.a.iP(3, this.wQk.computeSize());
      }
      paramInt = i;
      if (this.wQl != null) {
        paramInt = i + e.a.a.a.iP(4, this.wQl.computeSize());
      }
      AppMethodBeat.o(2531);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.cqq == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(2531);
          throw paramVarArgs;
        }
        if (this.wQk == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(2531);
          throw paramVarArgs;
        }
        if (this.wQl == null)
        {
          paramVarArgs = new b("Not all required fields were included: showMatrix");
          AppMethodBeat.o(2531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(2531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zh localzh = (zh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(2531);
          return -1;
        case 1: 
          localzh.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2531);
          return 0;
        case 2: 
          localzh.name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(2531);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzh.wQk = ((cqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2531);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzh.wQl = ((cqz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(2531);
        return 0;
      }
      AppMethodBeat.o(2531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zh
 * JD-Core Version:    0.7.0.1
 */