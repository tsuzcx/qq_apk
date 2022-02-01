package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bit
  extends com.tencent.mm.bw.a
{
  public bis EPJ;
  public boolean EXG;
  public String drM;
  public int lRv;
  public String nVJ;
  public String nYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nVJ != null) {
        paramVarArgs.d(1, this.nVJ);
      }
      if (this.nYv != null) {
        paramVarArgs.d(2, this.nYv);
      }
      if (this.drM != null) {
        paramVarArgs.d(3, this.drM);
      }
      paramVarArgs.bl(4, this.EXG);
      paramVarArgs.aR(5, this.lRv);
      if (this.EPJ != null)
      {
        paramVarArgs.ln(6, this.EPJ.computeSize());
        this.EPJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nVJ == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.nVJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nYv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nYv);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.drM);
      }
      i = i + (f.a.a.b.b.a.fK(4) + 1) + f.a.a.b.b.a.bx(5, this.lRv);
      paramInt = i;
      if (this.EPJ != null) {
        paramInt = i + f.a.a.a.lm(6, this.EPJ.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bit localbit = (bit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localbit.nVJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localbit.nYv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localbit.drM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localbit.EXG = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localbit.lRv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbit.EPJ = ((bis)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bit
 * JD-Core Version:    0.7.0.1
 */