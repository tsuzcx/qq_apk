package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acs
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public xu EgG;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.DNL != null)
      {
        paramVarArgs.ln(3, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      if (this.EgG != null)
      {
        paramVarArgs.ln(4, this.EgG.computeSize());
        this.EgG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91435);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.DNL != null) {
        i = paramInt + f.a.a.a.lm(3, this.DNL.computeSize());
      }
      paramInt = i;
      if (this.EgG != null) {
        paramInt = i + f.a.a.a.lm(4, this.EgG.computeSize());
      }
      AppMethodBeat.o(91435);
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
      AppMethodBeat.o(91435);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      acs localacs = (acs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91435);
        return -1;
      case 1: 
        localacs.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91435);
        return 0;
      case 2: 
        localacs.title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91435);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacs.DNL = ((crj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91435);
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
        localacs.EgG = ((xu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91435);
      return 0;
    }
    AppMethodBeat.o(91435);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acs
 * JD-Core Version:    0.7.0.1
 */