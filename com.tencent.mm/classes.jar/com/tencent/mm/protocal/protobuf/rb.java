package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rb
  extends com.tencent.mm.bw.a
{
  public String EiU;
  public String EiV;
  public String EiW;
  public int EiX;
  public rm EiY;
  public int EiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EiU != null) {
        paramVarArgs.d(1, this.EiU);
      }
      if (this.EiV != null) {
        paramVarArgs.d(2, this.EiV);
      }
      if (this.EiW != null) {
        paramVarArgs.d(3, this.EiW);
      }
      paramVarArgs.aR(4, this.EiX);
      if (this.EiY != null)
      {
        paramVarArgs.ln(5, this.EiY.computeSize());
        this.EiY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EiZ);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EiU == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.EiU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EiV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EiV);
      }
      i = paramInt;
      if (this.EiW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EiW);
      }
      i += f.a.a.b.b.a.bx(4, this.EiX);
      paramInt = i;
      if (this.EiY != null) {
        paramInt = i + f.a.a.a.lm(5, this.EiY.computeSize());
      }
      i = f.a.a.b.b.a.bx(6, this.EiZ);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localrb.EiU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localrb.EiV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localrb.EiW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localrb.EiX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrb.EiY = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localrb.EiZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */