package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anv
  extends com.tencent.mm.bw.a
{
  public cjt LzA;
  public cjh LzB;
  public cjt Lzv;
  public FinderFeedReportObject Lzw;
  public bal Lzx;
  public aqg Lzy;
  public cjt Lzz;
  public int kdU;
  public cjm vTj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209322);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.kdU);
      if (this.vTj != null)
      {
        paramVarArgs.ni(2, this.vTj.computeSize());
        this.vTj.writeFields(paramVarArgs);
      }
      if (this.Lzv != null)
      {
        paramVarArgs.ni(3, this.Lzv.computeSize());
        this.Lzv.writeFields(paramVarArgs);
      }
      if (this.Lzw != null)
      {
        paramVarArgs.ni(4, this.Lzw.computeSize());
        this.Lzw.writeFields(paramVarArgs);
      }
      if (this.Lzx != null)
      {
        paramVarArgs.ni(5, this.Lzx.computeSize());
        this.Lzx.writeFields(paramVarArgs);
      }
      if (this.Lzy != null)
      {
        paramVarArgs.ni(6, this.Lzy.computeSize());
        this.Lzy.writeFields(paramVarArgs);
      }
      if (this.Lzz != null)
      {
        paramVarArgs.ni(7, this.Lzz.computeSize());
        this.Lzz.writeFields(paramVarArgs);
      }
      if (this.LzA != null)
      {
        paramVarArgs.ni(8, this.LzA.computeSize());
        this.LzA.writeFields(paramVarArgs);
      }
      if (this.LzB != null)
      {
        paramVarArgs.ni(9, this.LzB.computeSize());
        this.LzB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209322);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.kdU) + 0;
      paramInt = i;
      if (this.vTj != null) {
        paramInt = i + g.a.a.a.nh(2, this.vTj.computeSize());
      }
      i = paramInt;
      if (this.Lzv != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lzv.computeSize());
      }
      paramInt = i;
      if (this.Lzw != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lzw.computeSize());
      }
      i = paramInt;
      if (this.Lzx != null) {
        i = paramInt + g.a.a.a.nh(5, this.Lzx.computeSize());
      }
      paramInt = i;
      if (this.Lzy != null) {
        paramInt = i + g.a.a.a.nh(6, this.Lzy.computeSize());
      }
      i = paramInt;
      if (this.Lzz != null) {
        i = paramInt + g.a.a.a.nh(7, this.Lzz.computeSize());
      }
      paramInt = i;
      if (this.LzA != null) {
        paramInt = i + g.a.a.a.nh(8, this.LzA.computeSize());
      }
      i = paramInt;
      if (this.LzB != null) {
        i = paramInt + g.a.a.a.nh(9, this.LzB.computeSize());
      }
      AppMethodBeat.o(209322);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209322);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      anv localanv = (anv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209322);
        return -1;
      case 1: 
        localanv.kdU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209322);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.vTj = ((cjm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.Lzv = ((cjt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderFeedReportObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderFeedReportObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.Lzw = ((FinderFeedReportObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bal();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bal)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.Lzx = ((bal)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.Lzy = ((aqg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.Lzz = ((cjt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanv.LzA = ((cjt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209322);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cjh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cjh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localanv.LzB = ((cjh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209322);
      return 0;
    }
    AppMethodBeat.o(209322);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anv
 * JD-Core Version:    0.7.0.1
 */