package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rt
  extends com.tencent.mm.bw.a
{
  public rv KZb;
  public dso KZe;
  public sc KZf;
  public String oUJ;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.KZe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.oUJ != null) {
        paramVarArgs.e(1, this.oUJ);
      }
      if (this.KZb != null)
      {
        paramVarArgs.ni(2, this.KZb.computeSize());
        this.KZb.writeFields(paramVarArgs);
      }
      if (this.KZe != null)
      {
        paramVarArgs.ni(3, this.KZe.computeSize());
        this.KZe.writeFields(paramVarArgs);
      }
      if (this.KZf != null)
      {
        paramVarArgs.ni(4, this.KZf.computeSize());
        this.KZf.writeFields(paramVarArgs);
      }
      if (this.xIy != null) {
        paramVarArgs.e(5, this.xIy);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUJ == null) {
        break label834;
      }
    }
    label834:
    for (int i = g.a.a.b.b.a.f(1, this.oUJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KZb != null) {
        paramInt = i + g.a.a.a.nh(2, this.KZb.computeSize());
      }
      i = paramInt;
      if (this.KZe != null) {
        i = paramInt + g.a.a.a.nh(3, this.KZe.computeSize());
      }
      paramInt = i;
      if (this.KZf != null) {
        paramInt = i + g.a.a.a.nh(4, this.KZf.computeSize());
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xIy);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oUJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.KZe == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rt localrt = (rt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localrt.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrt.KZb = ((rv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dso();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dso)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrt.KZe = ((dso)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrt.KZf = ((sc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localrt.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rt
 * JD-Core Version:    0.7.0.1
 */