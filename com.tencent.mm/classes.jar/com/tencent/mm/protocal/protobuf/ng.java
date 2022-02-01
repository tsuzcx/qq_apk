package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ng
  extends cqk
{
  public String EcO;
  public long Edf;
  public int Edg;
  public int Edh;
  public long Edi;
  public int Edj;
  public LinkedList<ne> Edk;
  public int Edl;
  
  public ng()
  {
    AppMethodBeat.i(124440);
    this.Edk = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Edf);
      paramVarArgs.aR(3, this.Edg);
      paramVarArgs.aR(4, this.Edh);
      paramVarArgs.aO(5, this.Edi);
      paramVarArgs.aR(6, this.Edj);
      paramVarArgs.e(7, 8, this.Edk);
      paramVarArgs.aR(8, this.Edl);
      if (this.EcO != null) {
        paramVarArgs.d(9, this.EcO);
      }
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Edf) + f.a.a.b.b.a.bx(3, this.Edg) + f.a.a.b.b.a.bx(4, this.Edh) + f.a.a.b.b.a.p(5, this.Edi) + f.a.a.b.b.a.bx(6, this.Edj) + f.a.a.a.c(7, 8, this.Edk) + f.a.a.b.b.a.bx(8, this.Edl);
      paramInt = i;
      if (this.EcO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EcO);
      }
      AppMethodBeat.o(124441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Edk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ng localng = (ng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124441);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localng.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localng.Edf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localng.Edg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localng.Edh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localng.Edi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localng.Edj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ne();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ne)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localng.Edk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localng.Edl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124441);
          return 0;
        }
        localng.EcO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ng
 * JD-Core Version:    0.7.0.1
 */