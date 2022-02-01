package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzv
  extends cpx
{
  public String FQS;
  public LinkedList<String> GfP;
  public boolean GfQ;
  public String GfR;
  public boolean GfS;
  public String djj;
  
  public dzv()
  {
    AppMethodBeat.i(153313);
    this.GfP = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      paramVarArgs.e(3, 1, this.GfP);
      paramVarArgs.bl(4, this.GfQ);
      if (this.GfR != null) {
        paramVarArgs.d(5, this.GfR);
      }
      paramVarArgs.bl(6, this.GfS);
      if (this.FQS != null) {
        paramVarArgs.d(7, this.FQS);
      }
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i = i + f.a.a.a.c(3, 1, this.GfP) + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.GfR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GfR);
      }
      i = paramInt + (f.a.a.b.b.a.fK(6) + 1);
      paramInt = i;
      if (this.FQS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQS);
      }
      AppMethodBeat.o(153314);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GfP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzv localdzv = (dzv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localdzv.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localdzv.GfP.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localdzv.GfQ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localdzv.GfR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localdzv.GfS = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153314);
          return 0;
        }
        localdzv.FQS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzv
 * JD-Core Version:    0.7.0.1
 */