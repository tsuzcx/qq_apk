package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgy
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public String DWw;
  public long FQa;
  public String FQb;
  public int FQc;
  public adk FQd;
  public float size;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FQa);
      if (this.FQb != null) {
        paramVarArgs.d(2, this.FQb);
      }
      if (this.text != null) {
        paramVarArgs.d(3, this.text);
      }
      paramVarArgs.x(4, this.size);
      if (this.DNL != null)
      {
        paramVarArgs.ln(5, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FQc);
      if (this.DWw != null) {
        paramVarArgs.d(7, this.DWw);
      }
      if (this.FQd != null)
      {
        paramVarArgs.ln(8, this.FQd.computeSize());
        this.FQd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FQa) + 0;
      paramInt = i;
      if (this.FQb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FQb);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.text);
      }
      i += f.a.a.b.b.a.fK(4) + 4;
      paramInt = i;
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(5, this.DNL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FQc);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DWw);
      }
      i = paramInt;
      if (this.FQd != null) {
        i = paramInt + f.a.a.a.lm(8, this.FQd.computeSize());
      }
      AppMethodBeat.o(91713);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgy localdgy = (dgy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localdgy.FQa = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localdgy.FQb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localdgy.text = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localdgy.size = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgy.DNL = ((crj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localdgy.FQc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localdgy.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91713);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new adk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((adk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdgy.FQd = ((adk)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgy
 * JD-Core Version:    0.7.0.1
 */