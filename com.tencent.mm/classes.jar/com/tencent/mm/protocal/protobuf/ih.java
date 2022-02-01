package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ih
  extends com.tencent.mm.bw.a
{
  public byq DVX;
  public byq DVY;
  public byq DVZ;
  public byq DWa;
  public int DWb;
  public int DWc;
  public int DWd;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.DVX != null)
      {
        paramVarArgs.ln(2, this.DVX.computeSize());
        this.DVX.writeFields(paramVarArgs);
      }
      if (this.DVY != null)
      {
        paramVarArgs.ln(3, this.DVY.computeSize());
        this.DVY.writeFields(paramVarArgs);
      }
      if (this.DVZ != null)
      {
        paramVarArgs.ln(4, this.DVZ.computeSize());
        this.DVZ.writeFields(paramVarArgs);
      }
      if (this.DWa != null)
      {
        paramVarArgs.ln(11, this.DWa.computeSize());
        this.DWa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(100, this.DWb);
      paramVarArgs.aR(101, this.DWc);
      paramVarArgs.aR(102, this.DWd);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.DVX != null) {
        paramInt = i + f.a.a.a.lm(2, this.DVX.computeSize());
      }
      i = paramInt;
      if (this.DVY != null) {
        i = paramInt + f.a.a.a.lm(3, this.DVY.computeSize());
      }
      paramInt = i;
      if (this.DVZ != null) {
        paramInt = i + f.a.a.a.lm(4, this.DVZ.computeSize());
      }
      i = paramInt;
      if (this.DWa != null) {
        i = paramInt + f.a.a.a.lm(11, this.DWa.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(100, this.DWb);
      int j = f.a.a.b.b.a.bx(101, this.DWc);
      int k = f.a.a.b.b.a.bx(102, this.DWd);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ih localih = (ih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localih.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.DVX = ((byq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.DVY = ((byq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.DVZ = ((byq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.DWa = ((byq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localih.DWb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localih.DWc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118406);
        return 0;
      }
      localih.DWd = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */