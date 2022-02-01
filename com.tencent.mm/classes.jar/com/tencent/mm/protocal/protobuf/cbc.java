package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbc
  extends com.tencent.mm.bw.a
{
  public jm Mgs;
  public tg Mgt;
  public cop Mgu;
  public ecz Mgv;
  public drg Mgw;
  public abp Mgx;
  public ant Mgy;
  public bgc Mgz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mgs != null)
      {
        paramVarArgs.ni(1, this.Mgs.computeSize());
        this.Mgs.writeFields(paramVarArgs);
      }
      if (this.Mgt != null)
      {
        paramVarArgs.ni(2, this.Mgt.computeSize());
        this.Mgt.writeFields(paramVarArgs);
      }
      if (this.Mgu != null)
      {
        paramVarArgs.ni(3, this.Mgu.computeSize());
        this.Mgu.writeFields(paramVarArgs);
      }
      if (this.Mgv != null)
      {
        paramVarArgs.ni(4, this.Mgv.computeSize());
        this.Mgv.writeFields(paramVarArgs);
      }
      if (this.Mgw != null)
      {
        paramVarArgs.ni(6, this.Mgw.computeSize());
        this.Mgw.writeFields(paramVarArgs);
      }
      if (this.Mgx != null)
      {
        paramVarArgs.ni(7, this.Mgx.computeSize());
        this.Mgx.writeFields(paramVarArgs);
      }
      if (this.Mgy != null)
      {
        paramVarArgs.ni(8, this.Mgy.computeSize());
        this.Mgy.writeFields(paramVarArgs);
      }
      if (this.Mgz != null)
      {
        paramVarArgs.ni(9, this.Mgz.computeSize());
        this.Mgz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mgs == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = g.a.a.a.nh(1, this.Mgs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mgt != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mgt.computeSize());
      }
      i = paramInt;
      if (this.Mgu != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mgu.computeSize());
      }
      paramInt = i;
      if (this.Mgv != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mgv.computeSize());
      }
      i = paramInt;
      if (this.Mgw != null) {
        i = paramInt + g.a.a.a.nh(6, this.Mgw.computeSize());
      }
      paramInt = i;
      if (this.Mgx != null) {
        paramInt = i + g.a.a.a.nh(7, this.Mgx.computeSize());
      }
      i = paramInt;
      if (this.Mgy != null) {
        i = paramInt + g.a.a.a.nh(8, this.Mgy.computeSize());
      }
      paramInt = i;
      if (this.Mgz != null) {
        paramInt = i + g.a.a.a.nh(9, this.Mgz.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbc localcbc = (cbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(116471);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgs = ((jm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgt = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cop();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cop)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgu = ((cop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgv = ((ecz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgw = ((drg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgx = ((abp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ant();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ant)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbc.Mgy = ((ant)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbc.Mgz = ((bgc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      AppMethodBeat.o(116471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */