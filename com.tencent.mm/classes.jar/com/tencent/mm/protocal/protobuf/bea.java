package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bea
  extends cpx
{
  public String code;
  public String dvO;
  public String nUr;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114034);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dvO != null) {
        paramVarArgs.d(2, this.dvO);
      }
      paramVarArgs.aR(3, this.scene);
      if (this.nUr != null) {
        paramVarArgs.d(4, this.nUr);
      }
      if (this.code != null) {
        paramVarArgs.d(5, this.code);
      }
      AppMethodBeat.o(114034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dvO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dvO);
      }
      i += f.a.a.b.b.a.bx(3, this.scene);
      paramInt = i;
      if (this.nUr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nUr);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.code);
      }
      AppMethodBeat.o(114034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bea localbea = (bea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114034);
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
            localbea.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114034);
          return 0;
        case 2: 
          localbea.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114034);
          return 0;
        case 3: 
          localbea.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114034);
          return 0;
        case 4: 
          localbea.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114034);
          return 0;
        }
        localbea.code = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114034);
        return 0;
      }
      AppMethodBeat.o(114034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bea
 * JD-Core Version:    0.7.0.1
 */