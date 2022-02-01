package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvg
  extends cpx
{
  public boz Euj;
  public int FGi;
  public int Scene;
  public String hkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152692);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Euj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(152692);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Euj != null)
      {
        paramVarArgs.ln(2, this.Euj.computeSize());
        this.Euj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FGi);
      paramVarArgs.aR(4, this.Scene);
      if (this.hkR != null) {
        paramVarArgs.d(5, this.hkR);
      }
      AppMethodBeat.o(152692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Euj != null) {
        i = paramInt + f.a.a.a.lm(2, this.Euj.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.FGi) + f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hkR);
      }
      AppMethodBeat.o(152692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Euj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(152692);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152692);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvg localcvg = (cvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152692);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvg.Euj = ((boz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152692);
          return 0;
        case 3: 
          localcvg.FGi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152692);
          return 0;
        case 4: 
          localcvg.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152692);
          return 0;
        }
        localcvg.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152692);
        return 0;
      }
      AppMethodBeat.o(152692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvg
 * JD-Core Version:    0.7.0.1
 */