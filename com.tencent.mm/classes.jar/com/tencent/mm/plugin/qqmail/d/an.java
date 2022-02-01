package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.bx.a
{
  public String content;
  public String xbA;
  public LinkedList<al> xcT;
  public LinkedList<al> xcU;
  public LinkedList<al> xcV;
  public int xdb;
  public al xdc;
  public LinkedList<ak> xdd;
  public LinkedList<ak> xde;
  public String xdf;
  public boolean xdg;
  
  public an()
  {
    AppMethodBeat.i(215229);
    this.xcT = new LinkedList();
    this.xcU = new LinkedList();
    this.xcV = new LinkedList();
    this.xdd = new LinkedList();
    this.xde = new LinkedList();
    AppMethodBeat.o(215229);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215230);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xdb);
      if (this.xdc != null)
      {
        paramVarArgs.lC(2, this.xdc.computeSize());
        this.xdc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xcT);
      paramVarArgs.e(4, 8, this.xcU);
      paramVarArgs.e(5, 8, this.xcV);
      if (this.xbA != null) {
        paramVarArgs.d(6, this.xbA);
      }
      if (this.content != null) {
        paramVarArgs.d(7, this.content);
      }
      paramVarArgs.e(8, 8, this.xdd);
      paramVarArgs.e(9, 8, this.xde);
      if (this.xdf != null) {
        paramVarArgs.d(10, this.xdf);
      }
      paramVarArgs.bt(11, this.xdg);
      AppMethodBeat.o(215230);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xdb) + 0;
      paramInt = i;
      if (this.xdc != null) {
        paramInt = i + f.a.a.a.lB(2, this.xdc.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.xcT) + f.a.a.a.c(4, 8, this.xcU) + f.a.a.a.c(5, 8, this.xcV);
      paramInt = i;
      if (this.xbA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.xbA);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.content);
      }
      i = i + f.a.a.a.c(8, 8, this.xdd) + f.a.a.a.c(9, 8, this.xde);
      paramInt = i;
      if (this.xdf != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xdf);
      }
      i = f.a.a.b.b.a.alV(11);
      AppMethodBeat.o(215230);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xcT.clear();
      this.xcU.clear();
      this.xcV.clear();
      this.xdd.clear();
      this.xde.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215230);
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
        AppMethodBeat.o(215230);
        return -1;
      case 1: 
        localan.xdb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215230);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xdc = ((al)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new al();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xcT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
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
          localan.xcU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
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
          localan.xcV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
        return 0;
      case 6: 
        localan.xbA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215230);
        return 0;
      case 7: 
        localan.content = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215230);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xdd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.xde.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215230);
        return 0;
      case 10: 
        localan.xdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215230);
        return 0;
      }
      localan.xdg = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(215230);
      return 0;
    }
    AppMethodBeat.o(215230);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.an
 * JD-Core Version:    0.7.0.1
 */