package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bra
  extends com.tencent.mm.bw.a
{
  public LinkedList<brb> Fge;
  public LinkedList<brb> Fgf;
  public brb Fgg;
  public int Fgh;
  public long dpl;
  public String key;
  public int tyQ;
  
  public bra()
  {
    AppMethodBeat.i(194045);
    this.Fge = new LinkedList();
    this.Fgf = new LinkedList();
    AppMethodBeat.o(194045);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Fge);
      paramVarArgs.e(2, 8, this.Fgf);
      if (this.Fgg != null)
      {
        paramVarArgs.ln(3, this.Fgg.computeSize());
        this.Fgg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.tyQ);
      paramVarArgs.aR(5, this.Fgh);
      paramVarArgs.aO(6, this.dpl);
      if (this.key != null) {
        paramVarArgs.d(7, this.key);
      }
      AppMethodBeat.o(194046);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Fge) + 0 + f.a.a.a.c(2, 8, this.Fgf);
      paramInt = i;
      if (this.Fgg != null) {
        paramInt = i + f.a.a.a.lm(3, this.Fgg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.tyQ) + f.a.a.b.b.a.bx(5, this.Fgh) + f.a.a.b.b.a.p(6, this.dpl);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.key);
      }
      AppMethodBeat.o(194046);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fge.clear();
      this.Fgf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(194046);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bra localbra = (bra)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194046);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbra.Fge.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194046);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbra.Fgf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194046);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((brb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbra.Fgg = ((brb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194046);
        return 0;
      case 4: 
        localbra.tyQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194046);
        return 0;
      case 5: 
        localbra.Fgh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194046);
        return 0;
      case 6: 
        localbra.dpl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(194046);
        return 0;
      }
      localbra.key = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(194046);
      return 0;
    }
    AppMethodBeat.o(194046);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bra
 * JD-Core Version:    0.7.0.1
 */