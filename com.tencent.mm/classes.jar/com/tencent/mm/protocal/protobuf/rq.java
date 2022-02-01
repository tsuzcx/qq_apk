package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rq
  extends com.tencent.mm.bw.a
{
  public String EjU;
  public String EjV;
  public String EjW;
  public int EjX;
  public String EjY;
  public rm EjZ;
  public String Eka;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EjU != null) {
        paramVarArgs.d(1, this.EjU);
      }
      if (this.EjV != null) {
        paramVarArgs.d(2, this.EjV);
      }
      if (this.EjW != null) {
        paramVarArgs.d(3, this.EjW);
      }
      paramVarArgs.aR(4, this.EjX);
      if (this.EjY != null) {
        paramVarArgs.d(5, this.EjY);
      }
      if (this.EjZ != null)
      {
        paramVarArgs.ln(6, this.EjZ.computeSize());
        this.EjZ.writeFields(paramVarArgs);
      }
      if (this.Eka != null) {
        paramVarArgs.d(7, this.Eka);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EjU == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.EjU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EjV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EjV);
      }
      i = paramInt;
      if (this.EjW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EjW);
      }
      i += f.a.a.b.b.a.bx(4, this.EjX);
      paramInt = i;
      if (this.EjY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EjY);
      }
      i = paramInt;
      if (this.EjZ != null) {
        i = paramInt + f.a.a.a.lm(6, this.EjZ.computeSize());
      }
      paramInt = i;
      if (this.Eka != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Eka);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rq localrq = (rq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localrq.EjU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localrq.EjV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localrq.EjW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localrq.EjX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localrq.EjY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrq.EjZ = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localrq.Eka = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rq
 * JD-Core Version:    0.7.0.1
 */