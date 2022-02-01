package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pz
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public String DWw;
  public int EgE;
  public bld EgF;
  public xu EgG;
  public int nWg;
  public int state;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.state);
      if (this.DNL != null)
      {
        paramVarArgs.ln(2, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EgE);
      if (this.EgF != null)
      {
        paramVarArgs.ln(4, this.EgF.computeSize());
        this.EgF.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.d(5, this.text);
      }
      if (this.DWw != null) {
        paramVarArgs.d(6, this.DWw);
      }
      paramVarArgs.aR(7, this.nWg);
      if (this.EgG != null)
      {
        paramVarArgs.ln(8, this.EgG.computeSize());
        this.EgG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.state) + 0;
      paramInt = i;
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(2, this.DNL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EgE);
      paramInt = i;
      if (this.EgF != null) {
        paramInt = i + f.a.a.a.lm(4, this.EgF.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.text);
      }
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DWw);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.nWg);
      paramInt = i;
      if (this.EgG != null) {
        paramInt = i + f.a.a.a.lm(8, this.EgG.computeSize());
      }
      AppMethodBeat.o(91384);
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
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pz localpz = (pz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localpz.state = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpz.DNL = ((crj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localpz.EgE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bld();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpz.EgF = ((bld)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localpz.text = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localpz.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localpz.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xu();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((xu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localpz.EgG = ((xu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */