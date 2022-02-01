package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckj
  extends com.tencent.mm.bw.a
{
  public ckk MpS;
  public ckk MpT;
  public ckk MpU;
  public String dQx;
  public int style;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200214);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      paramVarArgs.aM(2, this.style);
      if (this.MpS != null)
      {
        paramVarArgs.ni(3, this.MpS.computeSize());
        this.MpS.writeFields(paramVarArgs);
      }
      if (this.MpT != null)
      {
        paramVarArgs.ni(4, this.MpT.computeSize());
        this.MpT.writeFields(paramVarArgs);
      }
      if (this.MpU != null)
      {
        paramVarArgs.ni(5, this.MpU.computeSize());
        this.MpU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200214);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.b.b.a.f(1, this.dQx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.style);
      paramInt = i;
      if (this.MpS != null) {
        paramInt = i + g.a.a.a.nh(3, this.MpS.computeSize());
      }
      i = paramInt;
      if (this.MpT != null) {
        i = paramInt + g.a.a.a.nh(4, this.MpT.computeSize());
      }
      paramInt = i;
      if (this.MpU != null) {
        paramInt = i + g.a.a.a.nh(5, this.MpU.computeSize());
      }
      AppMethodBeat.o(200214);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200214);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ckj localckj = (ckj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200214);
          return -1;
        case 1: 
          localckj.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200214);
          return 0;
        case 2: 
          localckj.style = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200214);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckj.MpS = ((ckk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200214);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localckj.MpT = ((ckk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200214);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localckj.MpU = ((ckk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200214);
        return 0;
      }
      AppMethodBeat.o(200214);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */