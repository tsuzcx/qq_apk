package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbg
  extends com.tencent.mm.bw.a
{
  public ehf KEN;
  public ehf KEO;
  public LinkedList<uq> LEy;
  public ccy MGn;
  public cte MGo;
  
  public dbg()
  {
    AppMethodBeat.i(91613);
    this.LEy = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGn != null)
      {
        paramVarArgs.ni(1, this.MGn.computeSize());
        this.MGn.writeFields(paramVarArgs);
      }
      if (this.KEN != null)
      {
        paramVarArgs.ni(2, this.KEN.computeSize());
        this.KEN.writeFields(paramVarArgs);
      }
      if (this.KEO != null)
      {
        paramVarArgs.ni(3, this.KEO.computeSize());
        this.KEO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.LEy);
      if (this.MGo != null)
      {
        paramVarArgs.ni(5, this.MGo.computeSize());
        this.MGo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGn == null) {
        break label914;
      }
    }
    label914:
    for (int i = g.a.a.a.nh(1, this.MGn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KEN != null) {
        paramInt = i + g.a.a.a.nh(2, this.KEN.computeSize());
      }
      i = paramInt;
      if (this.KEO != null) {
        i = paramInt + g.a.a.a.nh(3, this.KEO.computeSize());
      }
      i += g.a.a.a.c(4, 8, this.LEy);
      paramInt = i;
      if (this.MGo != null) {
        paramInt = i + g.a.a.a.nh(5, this.MGo.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LEy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbg localdbg = (dbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbg.MGn = ((ccy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbg.KEN = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbg.KEO = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbg.LEy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cte();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbg.MGo = ((cte)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbg
 * JD-Core Version:    0.7.0.1
 */