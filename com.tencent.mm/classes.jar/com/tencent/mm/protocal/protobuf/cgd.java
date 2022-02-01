package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgd
  extends com.tencent.mm.bw.a
{
  public zj Fun;
  public zj Fuo;
  public zj Fup;
  public zj Fuq;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.left);
      paramVarArgs.aR(2, this.top);
      paramVarArgs.aR(3, this.right);
      paramVarArgs.aR(4, this.bottom);
      if (this.Fun != null)
      {
        paramVarArgs.ln(5, this.Fun.computeSize());
        this.Fun.writeFields(paramVarArgs);
      }
      if (this.Fuo != null)
      {
        paramVarArgs.ln(6, this.Fuo.computeSize());
        this.Fuo.writeFields(paramVarArgs);
      }
      if (this.Fup != null)
      {
        paramVarArgs.ln(7, this.Fup.computeSize());
        this.Fup.writeFields(paramVarArgs);
      }
      if (this.Fuq != null)
      {
        paramVarArgs.ln(8, this.Fuq.computeSize());
        this.Fuq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.left) + 0 + f.a.a.b.b.a.bx(2, this.top) + f.a.a.b.b.a.bx(3, this.right) + f.a.a.b.b.a.bx(4, this.bottom);
      paramInt = i;
      if (this.Fun != null) {
        paramInt = i + f.a.a.a.lm(5, this.Fun.computeSize());
      }
      i = paramInt;
      if (this.Fuo != null) {
        i = paramInt + f.a.a.a.lm(6, this.Fuo.computeSize());
      }
      paramInt = i;
      if (this.Fup != null) {
        paramInt = i + f.a.a.a.lm(7, this.Fup.computeSize());
      }
      i = paramInt;
      if (this.Fuq != null) {
        i = paramInt + f.a.a.a.lm(8, this.Fuq.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cgd localcgd = (cgd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localcgd.left = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localcgd.top = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localcgd.right = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localcgd.bottom = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgd.Fun = ((zj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgd.Fuo = ((zj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgd.Fup = ((zj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgd.Fuq = ((zj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localcgd.type = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgd
 * JD-Core Version:    0.7.0.1
 */