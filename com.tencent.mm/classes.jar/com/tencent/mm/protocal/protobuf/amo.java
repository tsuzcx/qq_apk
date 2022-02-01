package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class amo
  extends com.tencent.mm.bx.a
{
  public amh NZv;
  public fxy ZtA;
  public fxy Ztz;
  public String md5;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140926);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Ztz == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.ZtA == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.g(1, this.md5);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.Ztz != null)
      {
        paramVarArgs.qD(3, this.Ztz.computeSize());
        this.Ztz.writeFields(paramVarArgs);
      }
      if (this.ZtA != null)
      {
        paramVarArgs.qD(4, this.ZtA.computeSize());
        this.ZtA.writeFields(paramVarArgs);
      }
      if (this.NZv != null)
      {
        paramVarArgs.qD(5, this.NZv.computeSize());
        this.NZv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label812;
      }
    }
    label812:
    for (int i = i.a.a.b.b.a.h(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.Ztz != null) {
        i = paramInt + i.a.a.a.qC(3, this.Ztz.computeSize());
      }
      paramInt = i;
      if (this.ZtA != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZtA.computeSize());
      }
      i = paramInt;
      if (this.NZv != null) {
        i = paramInt + i.a.a.a.qC(5, this.NZv.computeSize());
      }
      AppMethodBeat.o(140926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Ztz == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.ZtA == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        amo localamo = (amo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localamo.md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localamo.name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxy)localObject2).parseFrom((byte[])localObject1);
            }
            localamo.Ztz = ((fxy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxy)localObject2).parseFrom((byte[])localObject1);
            }
            localamo.ZtA = ((fxy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new amh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((amh)localObject2).parseFrom((byte[])localObject1);
          }
          localamo.NZv = ((amh)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */