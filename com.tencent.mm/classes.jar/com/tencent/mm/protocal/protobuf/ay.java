package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ay
  extends com.tencent.mm.bx.a
{
  public String CuV;
  public String CuW;
  public String CuX;
  public aw CuY;
  public String CuZ;
  public dv Cva;
  public ej Cvb;
  public ei Cvc;
  public ei Cvd;
  public int Scene;
  public String Url;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aR(3, this.Scene);
      if (this.CuV != null) {
        paramVarArgs.d(4, this.CuV);
      }
      if (this.CuW != null) {
        paramVarArgs.d(5, this.CuW);
      }
      if (this.CuX != null) {
        paramVarArgs.d(6, this.CuX);
      }
      if (this.CuY != null)
      {
        paramVarArgs.kX(7, this.CuY.computeSize());
        this.CuY.writeFields(paramVarArgs);
      }
      if (this.CuZ != null) {
        paramVarArgs.d(8, this.CuZ);
      }
      if (this.Cva != null)
      {
        paramVarArgs.kX(9, this.Cva.computeSize());
        this.Cva.writeFields(paramVarArgs);
      }
      if (this.Cvb != null)
      {
        paramVarArgs.kX(10, this.Cvb.computeSize());
        this.Cvb.writeFields(paramVarArgs);
      }
      if (this.Cvc != null)
      {
        paramVarArgs.kX(11, this.Cvc.computeSize());
        this.Cvc.writeFields(paramVarArgs);
      }
      if (this.Cvd != null)
      {
        paramVarArgs.kX(12, this.Cvd.computeSize());
        this.Cvd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.CuV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CuV);
      }
      i = paramInt;
      if (this.CuW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CuW);
      }
      paramInt = i;
      if (this.CuX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CuX);
      }
      i = paramInt;
      if (this.CuY != null) {
        i = paramInt + f.a.a.a.kW(7, this.CuY.computeSize());
      }
      paramInt = i;
      if (this.CuZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CuZ);
      }
      i = paramInt;
      if (this.Cva != null) {
        i = paramInt + f.a.a.a.kW(9, this.Cva.computeSize());
      }
      paramInt = i;
      if (this.Cvb != null) {
        paramInt = i + f.a.a.a.kW(10, this.Cvb.computeSize());
      }
      i = paramInt;
      if (this.Cvc != null) {
        i = paramInt + f.a.a.a.kW(11, this.Cvc.computeSize());
      }
      paramInt = i;
      if (this.Cvd != null) {
        paramInt = i + f.a.a.a.kW(12, this.Cvd.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125689);
        return -1;
      case 1: 
        localay.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localay.Url = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localay.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localay.CuV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localay.CuW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localay.CuX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.CuY = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localay.CuZ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.Cva = ((dv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ej();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.Cvb = ((ej)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ei();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.Cvc = ((ei)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ei();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localay.Cvd = ((ei)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */