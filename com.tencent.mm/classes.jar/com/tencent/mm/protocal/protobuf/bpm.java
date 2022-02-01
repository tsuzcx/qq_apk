package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpm
  extends com.tencent.mm.bw.a
{
  public int HcX;
  public bpp HcY;
  public bpo HcZ;
  public bpn Hda;
  public bpl Hdb;
  public bpq Hdc;
  public bpr Hdd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HcX);
      if (this.HcY != null)
      {
        paramVarArgs.lJ(2, this.HcY.computeSize());
        this.HcY.writeFields(paramVarArgs);
      }
      if (this.HcZ != null)
      {
        paramVarArgs.lJ(3, this.HcZ.computeSize());
        this.HcZ.writeFields(paramVarArgs);
      }
      if (this.Hda != null)
      {
        paramVarArgs.lJ(4, this.Hda.computeSize());
        this.Hda.writeFields(paramVarArgs);
      }
      if (this.Hdb != null)
      {
        paramVarArgs.lJ(5, this.Hdb.computeSize());
        this.Hdb.writeFields(paramVarArgs);
      }
      if (this.Hdc != null)
      {
        paramVarArgs.lJ(6, this.Hdc.computeSize());
        this.Hdc.writeFields(paramVarArgs);
      }
      if (this.Hdd != null)
      {
        paramVarArgs.lJ(7, this.Hdd.computeSize());
        this.Hdd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HcX) + 0;
      paramInt = i;
      if (this.HcY != null) {
        paramInt = i + f.a.a.a.lI(2, this.HcY.computeSize());
      }
      i = paramInt;
      if (this.HcZ != null) {
        i = paramInt + f.a.a.a.lI(3, this.HcZ.computeSize());
      }
      paramInt = i;
      if (this.Hda != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hda.computeSize());
      }
      i = paramInt;
      if (this.Hdb != null) {
        i = paramInt + f.a.a.a.lI(5, this.Hdb.computeSize());
      }
      paramInt = i;
      if (this.Hdc != null) {
        paramInt = i + f.a.a.a.lI(6, this.Hdc.computeSize());
      }
      i = paramInt;
      if (this.Hdd != null) {
        i = paramInt + f.a.a.a.lI(7, this.Hdd.computeSize());
      }
      AppMethodBeat.o(32324);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpm localbpm = (bpm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localbpm.HcX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.HcY = ((bpp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.HcZ = ((bpo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.Hda = ((bpn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.Hdb = ((bpl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.Hdc = ((bpq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bpr();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bpr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbpm.Hdd = ((bpr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpm
 * JD-Core Version:    0.7.0.1
 */