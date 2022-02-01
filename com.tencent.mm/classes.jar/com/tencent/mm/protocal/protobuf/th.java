package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class th
  extends cpx
{
  public b EmO;
  public int Enq;
  public String Enr;
  public int Ens;
  public int uiK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194011);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Enq);
      paramVarArgs.aR(3, this.uiK);
      if (this.Enr != null) {
        paramVarArgs.d(4, this.Enr);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aR(6, this.Ens);
      if (this.EmO != null) {
        paramVarArgs.c(7, this.EmO);
      }
      AppMethodBeat.o(194011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Enq) + f.a.a.b.b.a.bx(3, this.uiK);
      paramInt = i;
      if (this.Enr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Enr);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      i += f.a.a.b.b.a.bx(6, this.Ens);
      paramInt = i;
      if (this.EmO != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.EmO);
      }
      AppMethodBeat.o(194011);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        th localth = (th)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194011);
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
            localth.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194011);
          return 0;
        case 2: 
          localth.Enq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194011);
          return 0;
        case 3: 
          localth.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194011);
          return 0;
        case 4: 
          localth.Enr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194011);
          return 0;
        case 5: 
          localth.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194011);
          return 0;
        case 6: 
          localth.Ens = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194011);
          return 0;
        }
        localth.EmO = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(194011);
        return 0;
      }
      AppMethodBeat.o(194011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.th
 * JD-Core Version:    0.7.0.1
 */