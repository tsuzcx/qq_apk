package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byb
  extends com.tencent.mm.bw.a
{
  public int EfS;
  public SKBuiltinBuffer_t Eki;
  public xw Ekl;
  public int Fnm;
  public int Fnn;
  public int Ret;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ekl == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.Ekl != null)
      {
        paramVarArgs.ln(2, this.Ekl.computeSize());
        this.Ekl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EfS);
      if (this.Eki != null)
      {
        paramVarArgs.ln(4, this.Eki.computeSize());
        this.Eki.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ndj);
      paramVarArgs.aR(6, this.Fnm);
      paramVarArgs.aR(7, this.Fnn);
      AppMethodBeat.o(133187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.Ekl != null) {
        paramInt = i + f.a.a.a.lm(2, this.Ekl.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EfS);
      paramInt = i;
      if (this.Eki != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eki.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.ndj);
      int j = f.a.a.b.b.a.bx(6, this.Fnm);
      int k = f.a.a.b.b.a.bx(7, this.Fnn);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Ekl == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.Eki == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byb localbyb = (byb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localbyb.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133187);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyb.Ekl = ((xw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localbyb.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyb.Eki = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localbyb.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localbyb.Fnm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133187);
        return 0;
      }
      localbyb.Fnn = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byb
 * JD-Core Version:    0.7.0.1
 */