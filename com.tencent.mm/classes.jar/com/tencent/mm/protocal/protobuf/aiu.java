package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aiu
  extends com.tencent.mm.bw.a
{
  public ain Cgj;
  public erc Lsp;
  public erc Lsq;
  public String md5;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140926);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Lsp == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Lsq == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.e(1, this.md5);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.Lsp != null)
      {
        paramVarArgs.ni(3, this.Lsp.computeSize());
        this.Lsp.writeFields(paramVarArgs);
      }
      if (this.Lsq != null)
      {
        paramVarArgs.ni(4, this.Lsq.computeSize());
        this.Lsq.writeFields(paramVarArgs);
      }
      if (this.Cgj != null)
      {
        paramVarArgs.ni(5, this.Cgj.computeSize());
        this.Cgj.writeFields(paramVarArgs);
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
    for (int i = g.a.a.b.b.a.f(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.Lsp != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lsp.computeSize());
      }
      paramInt = i;
      if (this.Lsq != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lsq.computeSize());
      }
      i = paramInt;
      if (this.Cgj != null) {
        i = paramInt + g.a.a.a.nh(5, this.Cgj.computeSize());
      }
      AppMethodBeat.o(140926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Lsp == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Lsq == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aiu localaiu = (aiu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localaiu.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localaiu.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaiu.Lsp = ((erc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaiu.Lsq = ((erc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ain();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ain)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaiu.Cgj = ((ain)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiu
 * JD-Core Version:    0.7.0.1
 */