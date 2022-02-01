package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdv
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public ehf Mjp;
  public LinkedList<egf> Mjq;
  public ehf Mjr;
  
  public cdv()
  {
    AppMethodBeat.i(91526);
    this.Mjq = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mjp != null)
      {
        paramVarArgs.ni(1, this.Mjp.computeSize());
        this.Mjp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Mjq);
      if (this.Mjr != null)
      {
        paramVarArgs.ni(3, this.Mjr.computeSize());
        this.Mjr.writeFields(paramVarArgs);
      }
      if (this.KNW != null) {
        paramVarArgs.e(4, this.KNW);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mjp == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = g.a.a.a.nh(1, this.Mjp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Mjq);
      paramInt = i;
      if (this.Mjr != null) {
        paramInt = i + g.a.a.a.nh(3, this.Mjr.computeSize());
      }
      i = paramInt;
      if (this.KNW != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KNW);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mjq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdv localcdv = (cdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdv.Mjp = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdv.Mjq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
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
            localcdv.Mjr = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localcdv.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdv
 * JD-Core Version:    0.7.0.1
 */