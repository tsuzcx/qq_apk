package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bw.a
{
  public String FKT;
  public String FKU;
  public String FKV;
  public ay FKW;
  public String FKX;
  public dy FKY;
  public ep FKZ;
  public eo FLa;
  public eo FLb;
  public int Scene;
  public String Url;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aS(3, this.Scene);
      if (this.FKT != null) {
        paramVarArgs.d(4, this.FKT);
      }
      if (this.FKU != null) {
        paramVarArgs.d(5, this.FKU);
      }
      if (this.FKV != null) {
        paramVarArgs.d(6, this.FKV);
      }
      if (this.FKW != null)
      {
        paramVarArgs.lJ(7, this.FKW.computeSize());
        this.FKW.writeFields(paramVarArgs);
      }
      if (this.FKX != null) {
        paramVarArgs.d(8, this.FKX);
      }
      if (this.FKY != null)
      {
        paramVarArgs.lJ(9, this.FKY.computeSize());
        this.FKY.writeFields(paramVarArgs);
      }
      if (this.FKZ != null)
      {
        paramVarArgs.lJ(10, this.FKZ.computeSize());
        this.FKZ.writeFields(paramVarArgs);
      }
      if (this.FLa != null)
      {
        paramVarArgs.lJ(11, this.FLa.computeSize());
        this.FLa.writeFields(paramVarArgs);
      }
      if (this.FLb != null)
      {
        paramVarArgs.lJ(12, this.FLb.computeSize());
        this.FLb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.FKT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FKT);
      }
      i = paramInt;
      if (this.FKU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FKU);
      }
      paramInt = i;
      if (this.FKV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FKV);
      }
      i = paramInt;
      if (this.FKW != null) {
        i = paramInt + f.a.a.a.lI(7, this.FKW.computeSize());
      }
      paramInt = i;
      if (this.FKX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FKX);
      }
      i = paramInt;
      if (this.FKY != null) {
        i = paramInt + f.a.a.a.lI(9, this.FKY.computeSize());
      }
      paramInt = i;
      if (this.FKZ != null) {
        paramInt = i + f.a.a.a.lI(10, this.FKZ.computeSize());
      }
      i = paramInt;
      if (this.FLa != null) {
        i = paramInt + f.a.a.a.lI(11, this.FLa.computeSize());
      }
      paramInt = i;
      if (this.FLb != null) {
        paramInt = i + f.a.a.a.lI(12, this.FLb.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ba localba = (ba)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localba.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localba.Url = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localba.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localba.FKT = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localba.FKU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localba.FKV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ay();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FKW = ((ay)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localba.FKX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FKY = ((dy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ep();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ep)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FKZ = ((ep)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.FLa = ((eo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localba.FLb = ((eo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    AppMethodBeat.o(125689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ba
 * JD-Core Version:    0.7.0.1
 */