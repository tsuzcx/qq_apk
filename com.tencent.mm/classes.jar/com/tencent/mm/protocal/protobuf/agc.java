package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agc
  extends com.tencent.mm.bx.a
{
  public dwb Gec;
  public dwb Ged;
  public String md5;
  public String name;
  public afx xPq;
  
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
      if (this.Gec == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Ged == null)
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
      if (this.Gec != null)
      {
        paramVarArgs.lC(3, this.Gec.computeSize());
        this.Gec.writeFields(paramVarArgs);
      }
      if (this.Ged != null)
      {
        paramVarArgs.lC(4, this.Ged.computeSize());
        this.Ged.writeFields(paramVarArgs);
      }
      if (this.xPq != null)
      {
        paramVarArgs.lC(5, this.xPq.computeSize());
        this.xPq.writeFields(paramVarArgs);
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
      if (this.Gec != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gec.computeSize());
      }
      paramInt = i;
      if (this.Ged != null) {
        paramInt = i + f.a.a.a.lB(4, this.Ged.computeSize());
      }
      i = paramInt;
      if (this.xPq != null) {
        i = paramInt + f.a.a.a.lB(5, this.xPq.computeSize());
      }
      AppMethodBeat.o(140926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Gec == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Ged == null)
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
        agc localagc = (agc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localagc.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localagc.name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagc.Gec = ((dwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagc.Ged = ((dwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagc.xPq = ((afx)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agc
 * JD-Core Version:    0.7.0.1
 */