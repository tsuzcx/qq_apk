package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddd
  extends com.tencent.mm.bw.a
{
  public int MIi;
  public acl MIj;
  public sf MIk;
  public sf MIl;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200218);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.aM(3, this.MIi);
      if (this.MIj != null)
      {
        paramVarArgs.ni(4, this.MIj.computeSize());
        this.MIj.writeFields(paramVarArgs);
      }
      if (this.MIk != null)
      {
        paramVarArgs.ni(5, this.MIk.computeSize());
        this.MIk.writeFields(paramVarArgs);
      }
      if (this.MIl != null)
      {
        paramVarArgs.ni(6, this.MIl.computeSize());
        this.MIl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.desc);
      }
      i += g.a.a.b.b.a.bu(3, this.MIi);
      paramInt = i;
      if (this.MIj != null) {
        paramInt = i + g.a.a.a.nh(4, this.MIj.computeSize());
      }
      i = paramInt;
      if (this.MIk != null) {
        i = paramInt + g.a.a.a.nh(5, this.MIk.computeSize());
      }
      paramInt = i;
      if (this.MIl != null) {
        paramInt = i + g.a.a.a.nh(6, this.MIl.computeSize());
      }
      AppMethodBeat.o(200218);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200218);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddd localddd = (ddd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200218);
          return -1;
        case 1: 
          localddd.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200218);
          return 0;
        case 2: 
          localddd.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200218);
          return 0;
        case 3: 
          localddd.MIi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200218);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddd.MIj = ((acl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200218);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddd.MIk = ((sf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200218);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddd.MIl = ((sf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200218);
        return 0;
      }
      AppMethodBeat.o(200218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddd
 * JD-Core Version:    0.7.0.1
 */