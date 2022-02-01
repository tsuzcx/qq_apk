package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.bw.a
{
  public String content;
  public String xrr;
  public LinkedList<al> xsK;
  public LinkedList<al> xsL;
  public LinkedList<al> xsM;
  public int xsS;
  public al xsT;
  public LinkedList<ak> xsU;
  public LinkedList<ak> xsV;
  public String xsW;
  public boolean xsX;
  
  public an()
  {
    AppMethodBeat.i(217975);
    this.xsK = new LinkedList();
    this.xsL = new LinkedList();
    this.xsM = new LinkedList();
    this.xsU = new LinkedList();
    this.xsV = new LinkedList();
    AppMethodBeat.o(217975);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217976);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xsS);
      if (this.xsT != null)
      {
        paramVarArgs.lJ(2, this.xsT.computeSize());
        this.xsT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xsK);
      paramVarArgs.e(4, 8, this.xsL);
      paramVarArgs.e(5, 8, this.xsM);
      if (this.xrr != null) {
        paramVarArgs.d(6, this.xrr);
      }
      if (this.content != null) {
        paramVarArgs.d(7, this.content);
      }
      paramVarArgs.e(8, 8, this.xsU);
      paramVarArgs.e(9, 8, this.xsV);
      if (this.xsW != null) {
        paramVarArgs.d(10, this.xsW);
      }
      paramVarArgs.bC(11, this.xsX);
      AppMethodBeat.o(217976);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xsS) + 0;
      paramInt = i;
      if (this.xsT != null) {
        paramInt = i + f.a.a.a.lI(2, this.xsT.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.xsK) + f.a.a.a.c(4, 8, this.xsL) + f.a.a.a.c(5, 8, this.xsM);
      paramInt = i;
      if (this.xrr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.xrr);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.content);
      }
      i = i + f.a.a.a.c(8, 8, this.xsU) + f.a.a.a.c(9, 8, this.xsV);
      paramInt = i;
      if (this.xsW != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xsW);
      }
      i = f.a.a.b.b.a.amF(11);
      AppMethodBeat.o(217976);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xsK.clear();
      this.xsL.clear();
      this.xsM.clear();
      this.xsU.clear();
      this.xsV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(217976);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      an localan = (an)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(217976);
        return -1;
      case 1: 
        localan.xsS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217976);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsT = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 6: 
        localan.xrr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217976);
        return 0;
      case 7: 
        localan.content = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217976);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xsV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217976);
        return 0;
      case 10: 
        localan.xsW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217976);
        return 0;
      }
      localan.xsX = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(217976);
      return 0;
    }
    AppMethodBeat.o(217976);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.an
 * JD-Core Version:    0.7.0.1
 */