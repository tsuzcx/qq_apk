package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bw.a
{
  public String charset;
  public String content;
  public int size;
  public String xrr;
  public String xsI;
  public al xsJ;
  public LinkedList<al> xsK;
  public LinkedList<al> xsL;
  public LinkedList<al> xsM;
  public String xsN;
  public String xsO;
  public LinkedList<ak> xsP;
  public LinkedList<ak> xsQ;
  public av xsR;
  
  public am()
  {
    AppMethodBeat.i(217973);
    this.xsK = new LinkedList();
    this.xsL = new LinkedList();
    this.xsM = new LinkedList();
    this.xsP = new LinkedList();
    this.xsQ = new LinkedList();
    AppMethodBeat.o(217973);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217974);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.size);
      if (this.charset != null) {
        paramVarArgs.d(2, this.charset);
      }
      if (this.xsI != null) {
        paramVarArgs.d(3, this.xsI);
      }
      if (this.xsJ != null)
      {
        paramVarArgs.lJ(4, this.xsJ.computeSize());
        this.xsJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xsK);
      paramVarArgs.e(6, 8, this.xsL);
      paramVarArgs.e(7, 8, this.xsM);
      if (this.xsN != null) {
        paramVarArgs.d(8, this.xsN);
      }
      if (this.xrr != null) {
        paramVarArgs.d(9, this.xrr);
      }
      if (this.xsO != null) {
        paramVarArgs.d(10, this.xsO);
      }
      if (this.content != null) {
        paramVarArgs.d(11, this.content);
      }
      paramVarArgs.e(12, 8, this.xsP);
      paramVarArgs.e(13, 8, this.xsQ);
      if (this.xsR != null)
      {
        paramVarArgs.lJ(14, this.xsR.computeSize());
        this.xsR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(217974);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.size) + 0;
      paramInt = i;
      if (this.charset != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.charset);
      }
      i = paramInt;
      if (this.xsI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xsI);
      }
      paramInt = i;
      if (this.xsJ != null) {
        paramInt = i + f.a.a.a.lI(4, this.xsJ.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.xsK) + f.a.a.a.c(6, 8, this.xsL) + f.a.a.a.c(7, 8, this.xsM);
      paramInt = i;
      if (this.xsN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xsN);
      }
      i = paramInt;
      if (this.xrr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.xrr);
      }
      paramInt = i;
      if (this.xsO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xsO);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.content);
      }
      i = i + f.a.a.a.c(12, 8, this.xsP) + f.a.a.a.c(13, 8, this.xsQ);
      paramInt = i;
      if (this.xsR != null) {
        paramInt = i + f.a.a.a.lI(14, this.xsR.computeSize());
      }
      AppMethodBeat.o(217974);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xsK.clear();
      this.xsL.clear();
      this.xsM.clear();
      this.xsP.clear();
      this.xsQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(217974);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(217974);
        return -1;
      case 1: 
        localam.size = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217974);
        return 0;
      case 2: 
        localam.charset = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
        return 0;
      case 3: 
        localam.xsI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
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
          localam.xsJ = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
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
          localam.xsK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xsL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xsM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
        return 0;
      case 8: 
        localam.xsN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
        return 0;
      case 9: 
        localam.xrr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
        return 0;
      case 10: 
        localam.xsO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
        return 0;
      case 11: 
        localam.content = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(217974);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xsP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xsQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217974);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new av();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localam.xsR = ((av)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(217974);
      return 0;
    }
    AppMethodBeat.o(217974);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.am
 * JD-Core Version:    0.7.0.1
 */