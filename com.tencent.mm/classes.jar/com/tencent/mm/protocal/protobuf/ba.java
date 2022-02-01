package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bw.a
{
  public String DNq;
  public String DNr;
  public String DNs;
  public ay DNt;
  public String DNu;
  public dx DNv;
  public el DNw;
  public ek DNx;
  public ek DNy;
  public int Scene;
  public String Url;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125689);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      paramVarArgs.aR(3, this.Scene);
      if (this.DNq != null) {
        paramVarArgs.d(4, this.DNq);
      }
      if (this.DNr != null) {
        paramVarArgs.d(5, this.DNr);
      }
      if (this.DNs != null) {
        paramVarArgs.d(6, this.DNs);
      }
      if (this.DNt != null)
      {
        paramVarArgs.ln(7, this.DNt.computeSize());
        this.DNt.writeFields(paramVarArgs);
      }
      if (this.DNu != null) {
        paramVarArgs.d(8, this.DNu);
      }
      if (this.DNv != null)
      {
        paramVarArgs.ln(9, this.DNv.computeSize());
        this.DNv.writeFields(paramVarArgs);
      }
      if (this.DNw != null)
      {
        paramVarArgs.ln(10, this.DNw.computeSize());
        this.DNw.writeFields(paramVarArgs);
      }
      if (this.DNx != null)
      {
        paramVarArgs.ln(11, this.DNx.computeSize());
        this.DNx.writeFields(paramVarArgs);
      }
      if (this.DNy != null)
      {
        paramVarArgs.ln(12, this.DNy.computeSize());
        this.DNy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.DNq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DNq);
      }
      i = paramInt;
      if (this.DNr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DNr);
      }
      paramInt = i;
      if (this.DNs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DNs);
      }
      i = paramInt;
      if (this.DNt != null) {
        i = paramInt + f.a.a.a.lm(7, this.DNt.computeSize());
      }
      paramInt = i;
      if (this.DNu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DNu);
      }
      i = paramInt;
      if (this.DNv != null) {
        i = paramInt + f.a.a.a.lm(9, this.DNv.computeSize());
      }
      paramInt = i;
      if (this.DNw != null) {
        paramInt = i + f.a.a.a.lm(10, this.DNw.computeSize());
      }
      i = paramInt;
      if (this.DNx != null) {
        i = paramInt + f.a.a.a.lm(11, this.DNx.computeSize());
      }
      paramInt = i;
      if (this.DNy != null) {
        paramInt = i + f.a.a.a.lm(12, this.DNy.computeSize());
      }
      AppMethodBeat.o(125689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localba.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125689);
        return 0;
      case 2: 
        localba.Url = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 3: 
        localba.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125689);
        return 0;
      case 4: 
        localba.DNq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 5: 
        localba.DNr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 6: 
        localba.DNs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ay();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.DNt = ((ay)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 8: 
        localba.DNu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125689);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.DNv = ((dx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new el();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.DNw = ((el)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ek();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.DNx = ((ek)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125689);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ek();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localba.DNy = ((ek)localObject1);
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