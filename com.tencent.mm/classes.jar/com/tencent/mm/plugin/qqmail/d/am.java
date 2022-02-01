package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bx.a
{
  public String charset;
  public String content;
  public int size;
  public String xbA;
  public String xcR;
  public al xcS;
  public LinkedList<al> xcT;
  public LinkedList<al> xcU;
  public LinkedList<al> xcV;
  public String xcW;
  public String xcX;
  public LinkedList<ak> xcY;
  public LinkedList<ak> xcZ;
  public av xda;
  
  public am()
  {
    AppMethodBeat.i(215227);
    this.xcT = new LinkedList();
    this.xcU = new LinkedList();
    this.xcV = new LinkedList();
    this.xcY = new LinkedList();
    this.xcZ = new LinkedList();
    AppMethodBeat.o(215227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215228);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.size);
      if (this.charset != null) {
        paramVarArgs.d(2, this.charset);
      }
      if (this.xcR != null) {
        paramVarArgs.d(3, this.xcR);
      }
      if (this.xcS != null)
      {
        paramVarArgs.lC(4, this.xcS.computeSize());
        this.xcS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xcT);
      paramVarArgs.e(6, 8, this.xcU);
      paramVarArgs.e(7, 8, this.xcV);
      if (this.xcW != null) {
        paramVarArgs.d(8, this.xcW);
      }
      if (this.xbA != null) {
        paramVarArgs.d(9, this.xbA);
      }
      if (this.xcX != null) {
        paramVarArgs.d(10, this.xcX);
      }
      if (this.content != null) {
        paramVarArgs.d(11, this.content);
      }
      paramVarArgs.e(12, 8, this.xcY);
      paramVarArgs.e(13, 8, this.xcZ);
      if (this.xda != null)
      {
        paramVarArgs.lC(14, this.xda.computeSize());
        this.xda.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215228);
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
      if (this.xcR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xcR);
      }
      paramInt = i;
      if (this.xcS != null) {
        paramInt = i + f.a.a.a.lB(4, this.xcS.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.xcT) + f.a.a.a.c(6, 8, this.xcU) + f.a.a.a.c(7, 8, this.xcV);
      paramInt = i;
      if (this.xcW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xcW);
      }
      i = paramInt;
      if (this.xbA != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.xbA);
      }
      paramInt = i;
      if (this.xcX != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xcX);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.content);
      }
      i = i + f.a.a.a.c(12, 8, this.xcY) + f.a.a.a.c(13, 8, this.xcZ);
      paramInt = i;
      if (this.xda != null) {
        paramInt = i + f.a.a.a.lB(14, this.xda.computeSize());
      }
      AppMethodBeat.o(215228);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xcT.clear();
      this.xcU.clear();
      this.xcV.clear();
      this.xcY.clear();
      this.xcZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215228);
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
        AppMethodBeat.o(215228);
        return -1;
      case 1: 
        localam.size = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215228);
        return 0;
      case 2: 
        localam.charset = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 3: 
        localam.xcR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcS = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      case 8: 
        localam.xcW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 9: 
        localam.xbA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 10: 
        localam.xcX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 11: 
        localam.content = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215228);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localam.xcZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215228);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new av();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localam.xda = ((av)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(215228);
      return 0;
    }
    AppMethodBeat.o(215228);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.am
 * JD-Core Version:    0.7.0.1
 */