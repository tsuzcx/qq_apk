package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auk
  extends com.tencent.mm.bx.a
{
  public LinkedList<aue> GsB;
  public LinkedList<aum> GsC;
  public String GsD;
  public String GsE;
  public LinkedList<aul> GsF;
  public int GsG;
  public boolean GsH;
  public String Title;
  public int type;
  
  public auk()
  {
    AppMethodBeat.i(42642);
    this.GsB = new LinkedList();
    this.GsC = new LinkedList();
    this.GsF = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.e(3, 8, this.GsB);
      paramVarArgs.e(4, 8, this.GsC);
      if (this.GsD != null) {
        paramVarArgs.d(5, this.GsD);
      }
      if (this.GsE != null) {
        paramVarArgs.d(6, this.GsE);
      }
      paramVarArgs.e(7, 8, this.GsF);
      paramVarArgs.aS(8, this.GsG);
      paramVarArgs.bt(9, this.GsH);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type) + f.a.a.a.c(3, 8, this.GsB) + f.a.a.a.c(4, 8, this.GsC);
      paramInt = i;
      if (this.GsD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GsD);
      }
      i = paramInt;
      if (this.GsE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GsE);
      }
      paramInt = f.a.a.a.c(7, 8, this.GsF);
      int j = f.a.a.b.b.a.bz(8, this.GsG);
      int k = f.a.a.b.b.a.alV(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GsB.clear();
        this.GsC.clear();
        this.GsF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auk localauk = (auk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localauk.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localauk.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aue();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aue)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauk.GsB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aum();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aum)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauk.GsC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localauk.GsD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localauk.GsE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aul();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauk.GsF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localauk.GsG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(42643);
          return 0;
        }
        localauk.GsH = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auk
 * JD-Core Version:    0.7.0.1
 */