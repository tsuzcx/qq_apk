package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dsl
  extends com.tencent.mm.bw.a
{
  public int ABT;
  public cnz FZV;
  public acu FZW;
  public int FZX;
  public LinkedList<Integer> FZY;
  public int FZZ;
  public LinkedList<Integer> Gaa;
  public cnz Gab;
  
  public dsl()
  {
    AppMethodBeat.i(115897);
    this.FZY = new LinkedList();
    this.Gaa = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZV != null)
      {
        paramVarArgs.ln(1, this.FZV.computeSize());
        this.FZV.writeFields(paramVarArgs);
      }
      if (this.FZW != null)
      {
        paramVarArgs.ln(2, this.FZW.computeSize());
        this.FZW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FZX);
      paramVarArgs.f(4, 2, this.FZY);
      paramVarArgs.aR(5, this.FZZ);
      paramVarArgs.f(6, 2, this.Gaa);
      paramVarArgs.aR(7, this.ABT);
      if (this.Gab != null)
      {
        paramVarArgs.ln(8, this.Gab.computeSize());
        this.Gab.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZV == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = f.a.a.a.lm(1, this.FZV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZW != null) {
        i = paramInt + f.a.a.a.lm(2, this.FZW.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.FZX) + f.a.a.a.d(4, 2, this.FZY) + f.a.a.b.b.a.bx(5, this.FZZ) + f.a.a.a.d(6, 2, this.Gaa) + f.a.a.b.b.a.bx(7, this.ABT);
      paramInt = i;
      if (this.Gab != null) {
        paramInt = i + f.a.a.a.lm(8, this.Gab.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZY.clear();
        this.Gaa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsl localdsl = (dsl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsl.FZV = ((cnz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsl.FZW = ((acu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localdsl.FZX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localdsl.FZY = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localdsl.FZZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localdsl.Gaa = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localdsl.ABT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsl.Gab = ((cnz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsl
 * JD-Core Version:    0.7.0.1
 */