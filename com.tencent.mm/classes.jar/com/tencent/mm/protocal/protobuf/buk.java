package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buk
  extends cqk
{
  public int CreateTime;
  public crm DPU;
  public int DTQ;
  public int Fkw;
  public int Ret;
  public int ndI;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Ret);
      if (this.DPU != null)
      {
        paramVarArgs.ln(2, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.vTO);
      paramVarArgs.aR(4, this.Fkw);
      paramVarArgs.aR(5, this.CreateTime);
      paramVarArgs.aR(6, this.DTQ);
      paramVarArgs.aR(7, this.ndI);
      paramVarArgs.aO(8, this.vTQ);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.DPU != null) {
        paramInt = i + f.a.a.a.lm(2, this.DPU.computeSize());
      }
      i = f.a.a.b.b.a.bx(3, this.vTO);
      int j = f.a.a.b.b.a.bx(4, this.Fkw);
      int k = f.a.a.b.b.a.bx(5, this.CreateTime);
      int m = f.a.a.b.b.a.bx(6, this.DTQ);
      int n = f.a.a.b.b.a.bx(7, this.ndI);
      int i1 = f.a.a.b.b.a.p(8, this.vTQ);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43105);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      buk localbuk = (buk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localbuk.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuk.DPU = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localbuk.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localbuk.Fkw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localbuk.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localbuk.DTQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localbuk.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43105);
        return 0;
      }
      localbuk.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */