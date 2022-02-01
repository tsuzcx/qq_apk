package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apb
  extends com.tencent.mm.bw.a
{
  public int EDU;
  public int EDV;
  public int EHW;
  public int EHX;
  public int EHY;
  public ani EHy;
  public int count;
  public String hlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.count);
      paramVarArgs.aR(2, this.EDU);
      paramVarArgs.aR(3, this.EDV);
      paramVarArgs.aR(4, this.EHW);
      if (this.hlG != null) {
        paramVarArgs.d(5, this.hlG);
      }
      if (this.EHy != null)
      {
        paramVarArgs.ln(6, this.EHy.computeSize());
        this.EHy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.EHX);
      paramVarArgs.aR(8, this.EHY);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.count) + 0 + f.a.a.b.b.a.bx(2, this.EDU) + f.a.a.b.b.a.bx(3, this.EDV) + f.a.a.b.b.a.bx(4, this.EHW);
      paramInt = i;
      if (this.hlG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hlG);
      }
      i = paramInt;
      if (this.EHy != null) {
        i = paramInt + f.a.a.a.lm(6, this.EHy.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(7, this.EHX);
      int j = f.a.a.b.b.a.bx(8, this.EHY);
      AppMethodBeat.o(169077);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      apb localapb = (apb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localapb.count = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localapb.EDU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localapb.EDV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localapb.EHW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localapb.hlG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ani();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ani)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapb.EHy = ((ani)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localapb.EHX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169077);
        return 0;
      }
      localapb.EHY = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apb
 * JD-Core Version:    0.7.0.1
 */