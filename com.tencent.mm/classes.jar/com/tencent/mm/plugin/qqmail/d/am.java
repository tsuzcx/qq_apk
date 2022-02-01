package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bw.a
{
  public String Bru;
  public String BsL;
  public al BsM;
  public LinkedList<al> BsN;
  public LinkedList<al> BsO;
  public LinkedList<al> BsP;
  public String BsQ;
  public String BsR;
  public LinkedList<ak> BsS;
  public LinkedList<ak> BsT;
  public av BsU;
  public String charset;
  public String content;
  public int size;
  
  public am()
  {
    AppMethodBeat.i(198629);
    this.BsN = new LinkedList();
    this.BsO = new LinkedList();
    this.BsP = new LinkedList();
    this.BsS = new LinkedList();
    this.BsT = new LinkedList();
    AppMethodBeat.o(198629);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.size);
      if (this.charset != null) {
        paramVarArgs.e(2, this.charset);
      }
      if (this.BsL != null) {
        paramVarArgs.e(3, this.BsL);
      }
      if (this.BsM != null)
      {
        paramVarArgs.ni(4, this.BsM.computeSize());
        this.BsM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.BsN);
      paramVarArgs.e(6, 8, this.BsO);
      paramVarArgs.e(7, 8, this.BsP);
      if (this.BsQ != null) {
        paramVarArgs.e(8, this.BsQ);
      }
      if (this.Bru != null) {
        paramVarArgs.e(9, this.Bru);
      }
      if (this.BsR != null) {
        paramVarArgs.e(10, this.BsR);
      }
      if (this.content != null) {
        paramVarArgs.e(11, this.content);
      }
      paramVarArgs.e(12, 8, this.BsS);
      paramVarArgs.e(13, 8, this.BsT);
      if (this.BsU != null)
      {
        paramVarArgs.ni(14, this.BsU.computeSize());
        this.BsU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198630);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.size) + 0;
      paramInt = i;
      if (this.charset != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.charset);
      }
      i = paramInt;
      if (this.BsL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.BsL);
      }
      paramInt = i;
      if (this.BsM != null) {
        paramInt = i + g.a.a.a.nh(4, this.BsM.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.BsN) + g.a.a.a.c(6, 8, this.BsO) + g.a.a.a.c(7, 8, this.BsP);
      paramInt = i;
      if (this.BsQ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.BsQ);
      }
      i = paramInt;
      if (this.Bru != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Bru);
      }
      paramInt = i;
      if (this.BsR != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.BsR);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.content);
      }
      i = i + g.a.a.a.c(12, 8, this.BsS) + g.a.a.a.c(13, 8, this.BsT);
      paramInt = i;
      if (this.BsU != null) {
        paramInt = i + g.a.a.a.nh(14, this.BsU.computeSize());
      }
      AppMethodBeat.o(198630);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BsN.clear();
      this.BsO.clear();
      this.BsP.clear();
      this.BsS.clear();
      this.BsT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(198630);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198630);
        return -1;
      case 1: 
        localam.size = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(198630);
        return 0;
      case 2: 
        localam.charset = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
        return 0;
      case 3: 
        localam.BsL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
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
          localam.BsM = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
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
          localam.BsN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localam.BsO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localam.BsP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
        return 0;
      case 8: 
        localam.BsQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
        return 0;
      case 9: 
        localam.Bru = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
        return 0;
      case 10: 
        localam.BsR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
        return 0;
      case 11: 
        localam.content = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(198630);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localam.BsS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localam.BsT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(198630);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new av();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localam.BsU = ((av)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(198630);
      return 0;
    }
    AppMethodBeat.o(198630);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.am
 * JD-Core Version:    0.7.0.1
 */