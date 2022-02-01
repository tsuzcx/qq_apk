package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbm
  extends cpx
{
  public String ERV;
  public int ERW;
  public LinkedList<crm> ERX;
  public int ERY;
  public String tlX;
  
  public bbm()
  {
    AppMethodBeat.i(91494);
    this.ERX = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ERV != null) {
        paramVarArgs.d(2, this.ERV);
      }
      paramVarArgs.aR(3, this.ERW);
      paramVarArgs.e(4, 8, this.ERX);
      if (this.tlX != null) {
        paramVarArgs.d(5, this.tlX);
      }
      paramVarArgs.aR(6, this.ERY);
      AppMethodBeat.o(91495);
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
      if (this.ERV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ERV);
      }
      i = i + f.a.a.b.b.a.bx(3, this.ERW) + f.a.a.a.c(4, 8, this.ERX);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tlX);
      }
      i = f.a.a.b.b.a.bx(6, this.ERY);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ERX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbm localbbm = (bbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
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
            localbbm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localbbm.ERV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localbbm.ERW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbm.ERX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localbbm.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localbbm.ERY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbm
 * JD-Core Version:    0.7.0.1
 */