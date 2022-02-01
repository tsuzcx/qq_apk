package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ke
  extends com.tencent.mm.bw.a
{
  public String DXq;
  public String DXv;
  public bva DXw;
  public bjb DXx;
  public int Ret;
  public String ncV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.DXv != null) {
        paramVarArgs.d(2, this.DXv);
      }
      if (this.DXw != null)
      {
        paramVarArgs.ln(3, this.DXw.computeSize());
        this.DXw.writeFields(paramVarArgs);
      }
      if (this.DXq != null) {
        paramVarArgs.d(4, this.DXq);
      }
      if (this.ncV != null) {
        paramVarArgs.d(5, this.ncV);
      }
      if (this.DXx != null)
      {
        paramVarArgs.ln(6, this.DXx.computeSize());
        this.DXx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.DXv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXv);
      }
      i = paramInt;
      if (this.DXw != null) {
        i = paramInt + f.a.a.a.lm(3, this.DXw.computeSize());
      }
      paramInt = i;
      if (this.DXq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DXq);
      }
      i = paramInt;
      if (this.ncV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncV);
      }
      paramInt = i;
      if (this.DXx != null) {
        paramInt = i + f.a.a.a.lm(6, this.DXx.computeSize());
      }
      AppMethodBeat.o(82393);
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
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ke localke = (ke)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localke.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localke.DXv = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bva();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localke.DXw = ((bva)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localke.DXq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localke.ncV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localke.DXx = ((bjb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ke
 * JD-Core Version:    0.7.0.1
 */