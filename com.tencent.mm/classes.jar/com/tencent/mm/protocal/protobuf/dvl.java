package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvl
  extends com.tencent.mm.bw.a
{
  public cyl MWs;
  public cyh MWt;
  public cyl MWu;
  public cyh MWv;
  public boolean MWw = false;
  public boolean MWx = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MWs != null)
      {
        paramVarArgs.ni(1, this.MWs.computeSize());
        this.MWs.writeFields(paramVarArgs);
      }
      if (this.MWt != null)
      {
        paramVarArgs.ni(2, this.MWt.computeSize());
        this.MWt.writeFields(paramVarArgs);
      }
      if (this.MWu != null)
      {
        paramVarArgs.ni(3, this.MWu.computeSize());
        this.MWu.writeFields(paramVarArgs);
      }
      if (this.MWv != null)
      {
        paramVarArgs.ni(4, this.MWv.computeSize());
        this.MWv.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(5, this.MWw);
      paramVarArgs.cc(6, this.MWx);
      AppMethodBeat.o(220726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MWs == null) {
        break label862;
      }
    }
    label862:
    for (int i = g.a.a.a.nh(1, this.MWs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MWt != null) {
        paramInt = i + g.a.a.a.nh(2, this.MWt.computeSize());
      }
      i = paramInt;
      if (this.MWu != null) {
        i = paramInt + g.a.a.a.nh(3, this.MWu.computeSize());
      }
      paramInt = i;
      if (this.MWv != null) {
        paramInt = i + g.a.a.a.nh(4, this.MWv.computeSize());
      }
      i = g.a.a.b.b.a.fS(5);
      int j = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(220726);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvl localdvl = (dvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220726);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvl.MWs = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220726);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvl.MWt = ((cyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220726);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvl.MWu = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220726);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvl.MWv = ((cyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220726);
          return 0;
        case 5: 
          localdvl.MWw = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(220726);
          return 0;
        }
        localdvl.MWx = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(220726);
        return 0;
      }
      AppMethodBeat.o(220726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvl
 * JD-Core Version:    0.7.0.1
 */