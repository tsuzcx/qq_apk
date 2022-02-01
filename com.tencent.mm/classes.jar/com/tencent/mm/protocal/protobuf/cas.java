package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cas
  extends com.tencent.mm.bw.a
{
  public ehz MfV;
  public dgp MfW;
  public dgp MfX;
  public String dQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MfV != null)
      {
        paramVarArgs.ni(1, this.MfV.computeSize());
        this.MfV.writeFields(paramVarArgs);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.MfW != null)
      {
        paramVarArgs.ni(3, this.MfW.computeSize());
        this.MfW.writeFields(paramVarArgs);
      }
      if (this.MfX != null)
      {
        paramVarArgs.ni(4, this.MfX.computeSize());
        this.MfX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MfV == null) {
        break label678;
      }
    }
    label678:
    for (int i = g.a.a.a.nh(1, this.MfV.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.MfW != null) {
        i = paramInt + g.a.a.a.nh(3, this.MfW.computeSize());
      }
      paramInt = i;
      if (this.MfX != null) {
        paramInt = i + g.a.a.a.nh(4, this.MfX.computeSize());
      }
      AppMethodBeat.o(200207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cas localcas = (cas)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200207);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcas.MfV = ((ehz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200207);
          return 0;
        case 2: 
          localcas.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200207);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcas.MfW = ((dgp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200207);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcas.MfX = ((dgp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200207);
        return 0;
      }
      AppMethodBeat.o(200207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cas
 * JD-Core Version:    0.7.0.1
 */