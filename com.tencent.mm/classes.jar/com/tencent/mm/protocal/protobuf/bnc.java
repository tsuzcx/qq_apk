package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnc
  extends cpx
{
  public String DKB;
  public String ENF;
  public String Fbl;
  public String djj;
  public int oxC;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90969);
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
      if (this.DKB != null) {
        paramVarArgs.d(3, this.DKB);
      }
      if (this.signature != null) {
        paramVarArgs.d(4, this.signature);
      }
      paramVarArgs.aR(5, this.oxC);
      if (this.Fbl != null) {
        paramVarArgs.d(6, this.Fbl);
      }
      if (this.ENF != null) {
        paramVarArgs.d(7, this.ENF);
      }
      AppMethodBeat.o(90969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.DKB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DKB);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.signature);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.oxC);
      paramInt = i;
      if (this.Fbl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fbl);
      }
      i = paramInt;
      if (this.ENF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ENF);
      }
      AppMethodBeat.o(90969);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(90969);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnc localbnc = (bnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90969);
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
            localbnc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90969);
          return 0;
        case 2: 
          localbnc.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 3: 
          localbnc.DKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 4: 
          localbnc.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 5: 
          localbnc.oxC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(90969);
          return 0;
        case 6: 
          localbnc.Fbl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(90969);
          return 0;
        }
        localbnc.ENF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(90969);
        return 0;
      }
      AppMethodBeat.o(90969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnc
 * JD-Core Version:    0.7.0.1
 */