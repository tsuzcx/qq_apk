package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwh
  extends com.tencent.mm.bx.a
{
  public dwj EKj;
  public dwi EKk;
  public dwk EKl;
  public dwm EKm;
  public dwl EKn;
  public dwo EKo;
  public dwg EKp;
  public dwn EKq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKj != null)
      {
        paramVarArgs.kX(1, this.EKj.computeSize());
        this.EKj.writeFields(paramVarArgs);
      }
      if (this.EKk != null)
      {
        paramVarArgs.kX(2, this.EKk.computeSize());
        this.EKk.writeFields(paramVarArgs);
      }
      if (this.EKl != null)
      {
        paramVarArgs.kX(3, this.EKl.computeSize());
        this.EKl.writeFields(paramVarArgs);
      }
      if (this.EKm != null)
      {
        paramVarArgs.kX(4, this.EKm.computeSize());
        this.EKm.writeFields(paramVarArgs);
      }
      if (this.EKn != null)
      {
        paramVarArgs.kX(5, this.EKn.computeSize());
        this.EKn.writeFields(paramVarArgs);
      }
      if (this.EKo != null)
      {
        paramVarArgs.kX(6, this.EKo.computeSize());
        this.EKo.writeFields(paramVarArgs);
      }
      if (this.EKp != null)
      {
        paramVarArgs.kX(7, this.EKp.computeSize());
        this.EKp.writeFields(paramVarArgs);
      }
      if (this.EKq != null)
      {
        paramVarArgs.kX(8, this.EKq.computeSize());
        this.EKq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKj == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = f.a.a.a.kW(1, this.EKj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EKk != null) {
        paramInt = i + f.a.a.a.kW(2, this.EKk.computeSize());
      }
      i = paramInt;
      if (this.EKl != null) {
        i = paramInt + f.a.a.a.kW(3, this.EKl.computeSize());
      }
      paramInt = i;
      if (this.EKm != null) {
        paramInt = i + f.a.a.a.kW(4, this.EKm.computeSize());
      }
      i = paramInt;
      if (this.EKn != null) {
        i = paramInt + f.a.a.a.kW(5, this.EKn.computeSize());
      }
      paramInt = i;
      if (this.EKo != null) {
        paramInt = i + f.a.a.a.kW(6, this.EKo.computeSize());
      }
      i = paramInt;
      if (this.EKp != null) {
        i = paramInt + f.a.a.a.kW(7, this.EKp.computeSize());
      }
      paramInt = i;
      if (this.EKq != null) {
        paramInt = i + f.a.a.a.kW(8, this.EKq.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwh localdwh = (dwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKj = ((dwj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKk = ((dwi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKl = ((dwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKm = ((dwm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKn = ((dwl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKo = ((dwo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwh.EKp = ((dwg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwh.EKq = ((dwn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      AppMethodBeat.o(153340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwh
 * JD-Core Version:    0.7.0.1
 */