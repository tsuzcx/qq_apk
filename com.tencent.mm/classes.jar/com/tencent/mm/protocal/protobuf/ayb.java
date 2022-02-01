package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayb
  extends com.tencent.mm.bw.a
{
  public bjb DXx;
  public int EPB;
  public String Ewu;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.DXx != null)
      {
        paramVarArgs.ln(2, this.DXx.computeSize());
        this.DXx.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(3, this.Ewu);
      }
      paramVarArgs.aR(4, this.EPB);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.DXx != null) {
        paramInt = i + f.a.a.a.lm(2, this.DXx.computeSize());
      }
      i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ewu);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EPB);
      AppMethodBeat.o(82415);
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
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ayb localayb = (ayb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localayb.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayb.DXx = ((bjb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localayb.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localayb.EPB = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayb
 * JD-Core Version:    0.7.0.1
 */