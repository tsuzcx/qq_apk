package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfs
  extends com.tencent.mm.bx.a
{
  public im DCX;
  public qa DCY;
  public bpo DCZ;
  public cxs DDa;
  public cna DDb;
  public xf DDc;
  public ahg DDd;
  public and DDe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCX != null)
      {
        paramVarArgs.kX(1, this.DCX.computeSize());
        this.DCX.writeFields(paramVarArgs);
      }
      if (this.DCY != null)
      {
        paramVarArgs.kX(2, this.DCY.computeSize());
        this.DCY.writeFields(paramVarArgs);
      }
      if (this.DCZ != null)
      {
        paramVarArgs.kX(3, this.DCZ.computeSize());
        this.DCZ.writeFields(paramVarArgs);
      }
      if (this.DDa != null)
      {
        paramVarArgs.kX(4, this.DDa.computeSize());
        this.DDa.writeFields(paramVarArgs);
      }
      if (this.DDb != null)
      {
        paramVarArgs.kX(6, this.DDb.computeSize());
        this.DDb.writeFields(paramVarArgs);
      }
      if (this.DDc != null)
      {
        paramVarArgs.kX(7, this.DDc.computeSize());
        this.DDc.writeFields(paramVarArgs);
      }
      if (this.DDd != null)
      {
        paramVarArgs.kX(8, this.DDd.computeSize());
        this.DDd.writeFields(paramVarArgs);
      }
      if (this.DDe != null)
      {
        paramVarArgs.kX(9, this.DDe.computeSize());
        this.DDe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCX == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = f.a.a.a.kW(1, this.DCX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DCY != null) {
        paramInt = i + f.a.a.a.kW(2, this.DCY.computeSize());
      }
      i = paramInt;
      if (this.DCZ != null) {
        i = paramInt + f.a.a.a.kW(3, this.DCZ.computeSize());
      }
      paramInt = i;
      if (this.DDa != null) {
        paramInt = i + f.a.a.a.kW(4, this.DDa.computeSize());
      }
      i = paramInt;
      if (this.DDb != null) {
        i = paramInt + f.a.a.a.kW(6, this.DDb.computeSize());
      }
      paramInt = i;
      if (this.DDc != null) {
        paramInt = i + f.a.a.a.kW(7, this.DDc.computeSize());
      }
      i = paramInt;
      if (this.DDd != null) {
        i = paramInt + f.a.a.a.kW(8, this.DDd.computeSize());
      }
      paramInt = i;
      if (this.DDe != null) {
        paramInt = i + f.a.a.a.kW(9, this.DDe.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfs localbfs = (bfs)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new im();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((im)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DCX = ((im)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DCY = ((qa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DCZ = ((bpo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DDa = ((cxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cna();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DDb = ((cna)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DDc = ((xf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfs.DDd = ((ahg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new and();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((and)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbfs.DDe = ((and)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfs
 * JD-Core Version:    0.7.0.1
 */