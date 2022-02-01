package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aou
  extends cpx
{
  public aiu EDL;
  public String EHL;
  public b Ewb;
  public int cUq;
  public int hux;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169068);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hux);
      paramVarArgs.aR(3, this.cUq);
      if (this.Ewb != null) {
        paramVarArgs.c(4, this.Ewb);
      }
      if (this.EHL != null) {
        paramVarArgs.d(5, this.EHL);
      }
      paramVarArgs.aR(6, this.scene);
      if (this.EDL != null)
      {
        paramVarArgs.ln(7, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.hux) + f.a.a.b.b.a.bx(3, this.cUq);
      paramInt = i;
      if (this.Ewb != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Ewb);
      }
      i = paramInt;
      if (this.EHL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EHL);
      }
      i += f.a.a.b.b.a.bx(6, this.scene);
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(7, this.EDL.computeSize());
      }
      AppMethodBeat.o(169068);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aou localaou = (aou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169068);
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
            localaou.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169068);
          return 0;
        case 2: 
          localaou.hux = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169068);
          return 0;
        case 3: 
          localaou.cUq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169068);
          return 0;
        case 4: 
          localaou.Ewb = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(169068);
          return 0;
        case 5: 
          localaou.EHL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169068);
          return 0;
        case 6: 
          localaou.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169068);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaou.EDL = ((aiu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169068);
        return 0;
      }
      AppMethodBeat.o(169068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aou
 * JD-Core Version:    0.7.0.1
 */