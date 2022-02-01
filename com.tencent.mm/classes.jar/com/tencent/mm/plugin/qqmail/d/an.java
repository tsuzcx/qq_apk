package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.bw.a
{
  public String Bru;
  public LinkedList<al> BsN;
  public LinkedList<al> BsO;
  public LinkedList<al> BsP;
  public int BsV;
  public al BsW;
  public LinkedList<ak> BsX;
  public LinkedList<ak> BsY;
  public String BsZ;
  public boolean Bta;
  public String content;
  
  public an()
  {
    AppMethodBeat.i(198631);
    this.BsN = new LinkedList();
    this.BsO = new LinkedList();
    this.BsP = new LinkedList();
    this.BsX = new LinkedList();
    this.BsY = new LinkedList();
    AppMethodBeat.o(198631);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.BsV);
      if (this.BsW != null)
      {
        paramVarArgs.ni(2, this.BsW.computeSize());
        this.BsW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.BsN);
      paramVarArgs.e(4, 8, this.BsO);
      paramVarArgs.e(5, 8, this.BsP);
      if (this.Bru != null) {
        paramVarArgs.e(6, this.Bru);
      }
      if (this.content != null) {
        paramVarArgs.e(7, this.content);
      }
      paramVarArgs.e(8, 8, this.BsX);
      paramVarArgs.e(9, 8, this.BsY);
      if (this.BsZ != null) {
        paramVarArgs.e(10, this.BsZ);
      }
      paramVarArgs.cc(11, this.Bta);
      AppMethodBeat.o(198632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.BsV) + 0;
      paramInt = i;
      if (this.BsW != null) {
        paramInt = i + g.a.a.a.nh(2, this.BsW.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.BsN) + g.a.a.a.c(4, 8, this.BsO) + g.a.a.a.c(5, 8, this.BsP);
      paramInt = i;
      if (this.Bru != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Bru);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.content);
      }
      i = i + g.a.a.a.c(8, 8, this.BsX) + g.a.a.a.c(9, 8, this.BsY);
      paramInt = i;
      if (this.BsZ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.BsZ);
      }
      i = g.a.a.b.b.a.fS(11);
      AppMethodBeat.o(198632);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BsN.clear();
      this.BsO.clear();
      this.BsP.clear();
      this.BsX.clear();
      this.BsY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(198632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      an localan = (an)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198632);
        return -1;
      case 1: 
        localan.BsV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(198632);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsW = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 6: 
        localan.Bru = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198632);
        return 0;
      case 7: 
        localan.content = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198632);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localan.BsY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198632);
        return 0;
      case 10: 
        localan.BsZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198632);
        return 0;
      }
      localan.Bta = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(198632);
      return 0;
    }
    AppMethodBeat.o(198632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.an
 * JD-Core Version:    0.7.0.1
 */