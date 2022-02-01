package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajj
  extends com.tencent.mm.cd.a
{
  public ajc IcZ;
  public fbn StO;
  public fbn StP;
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
      if (this.StO == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.StP == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.f(1, this.md5);
      }
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.StO != null)
      {
        paramVarArgs.oE(3, this.StO.computeSize());
        this.StO.writeFields(paramVarArgs);
      }
      if (this.StP != null)
      {
        paramVarArgs.oE(4, this.StP.computeSize());
        this.StP.writeFields(paramVarArgs);
      }
      if (this.IcZ != null)
      {
        paramVarArgs.oE(5, this.IcZ.computeSize());
        this.IcZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label816;
      }
    }
    label816:
    for (int i = g.a.a.b.b.a.g(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.StO != null) {
        i = paramInt + g.a.a.a.oD(3, this.StO.computeSize());
      }
      paramInt = i;
      if (this.StP != null) {
        paramInt = i + g.a.a.a.oD(4, this.StP.computeSize());
      }
      i = paramInt;
      if (this.IcZ != null) {
        i = paramInt + g.a.a.a.oD(5, this.IcZ.computeSize());
      }
      AppMethodBeat.o(140926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.StO == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.StP == null)
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
        ajj localajj = (ajj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localajj.md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localajj.name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localajj.StO = ((fbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localajj.StP = ((fbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajc)localObject2).parseFrom((byte[])localObject1);
          }
          localajj.IcZ = ((ajc)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajj
 * JD-Core Version:    0.7.0.1
 */