package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dix
  extends com.tencent.mm.bw.a
{
  public int AnI;
  public int AoA;
  public int AoB;
  public float AoC;
  public long Aox;
  public long Aoy;
  public long Aoz;
  public aad FSo;
  public long bvf;
  public long gOz;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206865);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(206865);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aR(2, this.type);
      paramVarArgs.aO(3, this.bvf);
      paramVarArgs.aO(4, this.gOz);
      paramVarArgs.aO(5, this.Aox);
      paramVarArgs.aO(6, this.Aoy);
      paramVarArgs.aO(7, this.Aoz);
      paramVarArgs.aR(8, this.AoA);
      paramVarArgs.aR(9, this.AoB);
      paramVarArgs.x(10, this.AoC);
      if (this.FSo != null)
      {
        paramVarArgs.ln(11, this.FSo.computeSize());
        this.FSo.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.AnI);
      AppMethodBeat.o(206865);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label857;
      }
    }
    label857:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type) + f.a.a.b.b.a.p(3, this.bvf) + f.a.a.b.b.a.p(4, this.gOz) + f.a.a.b.b.a.p(5, this.Aox) + f.a.a.b.b.a.p(6, this.Aoy) + f.a.a.b.b.a.p(7, this.Aoz) + f.a.a.b.b.a.bx(8, this.AoA) + f.a.a.b.b.a.bx(9, this.AoB) + (f.a.a.b.b.a.fK(10) + 4);
      paramInt = i;
      if (this.FSo != null) {
        paramInt = i + f.a.a.a.lm(11, this.FSo.computeSize());
      }
      i = f.a.a.b.b.a.bx(12, this.AnI);
      AppMethodBeat.o(206865);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(206865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dix localdix = (dix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206865);
          return -1;
        case 1: 
          localdix.path = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206865);
          return 0;
        case 2: 
          localdix.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206865);
          return 0;
        case 3: 
          localdix.bvf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(206865);
          return 0;
        case 4: 
          localdix.gOz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(206865);
          return 0;
        case 5: 
          localdix.Aox = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(206865);
          return 0;
        case 6: 
          localdix.Aoy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(206865);
          return 0;
        case 7: 
          localdix.Aoz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(206865);
          return 0;
        case 8: 
          localdix.AoA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206865);
          return 0;
        case 9: 
          localdix.AoB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206865);
          return 0;
        case 10: 
          localdix.AoC = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(206865);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aad();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aad)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdix.FSo = ((aad)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206865);
          return 0;
        }
        localdix.AnI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(206865);
        return 0;
      }
      AppMethodBeat.o(206865);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */