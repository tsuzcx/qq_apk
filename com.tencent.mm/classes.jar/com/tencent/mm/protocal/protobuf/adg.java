package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adg
  extends cpx
{
  public String DPx;
  public String DRb;
  public int Eck;
  public int EfV;
  public long EvV;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vTO);
      paramVarArgs.aR(2, this.EfV);
      paramVarArgs.aR(3, this.Eck);
      if (this.DRb != null) {
        paramVarArgs.d(4, this.DRb);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.vTQ);
      if (this.DPx != null) {
        paramVarArgs.d(7, this.DPx);
      }
      paramVarArgs.aO(8, this.EvV);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vTO) + 0 + f.a.a.b.b.a.bx(2, this.EfV) + f.a.a.b.b.a.bx(3, this.Eck);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DRb);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + f.a.a.a.lm(5, this.BaseRequest.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.vTQ);
      paramInt = i;
      if (this.DPx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DPx);
      }
      i = f.a.a.b.b.a.p(8, this.EvV);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      adg localadg = (adg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localadg.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localadg.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localadg.Eck = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localadg.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new iv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadg.BaseRequest = ((iv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localadg.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localadg.DPx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localadg.EvV = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adg
 * JD-Core Version:    0.7.0.1
 */