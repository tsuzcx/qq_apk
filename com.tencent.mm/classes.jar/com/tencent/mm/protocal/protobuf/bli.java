package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bli
  extends cpx
{
  public String EtG;
  public String FaR;
  public LinkedList<String> FaS;
  
  public bli()
  {
    AppMethodBeat.i(124516);
    this.FaS = new LinkedList();
    AppMethodBeat.o(124516);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EtG == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.FaR == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_name");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EtG != null) {
        paramVarArgs.d(2, this.EtG);
      }
      if (this.FaR != null) {
        paramVarArgs.d(3, this.FaR);
      }
      paramVarArgs.e(4, 1, this.FaS);
      AppMethodBeat.o(124517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EtG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EtG);
      }
      i = paramInt;
      if (this.FaR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FaR);
      }
      paramInt = f.a.a.a.c(4, 1, this.FaS);
      AppMethodBeat.o(124517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FaS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EtG == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        if (this.FaR == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_name");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bli localbli = (bli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124517);
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
            localbli.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124517);
          return 0;
        case 2: 
          localbli.EtG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124517);
          return 0;
        case 3: 
          localbli.FaR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124517);
          return 0;
        }
        localbli.FaS.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(124517);
        return 0;
      }
      AppMethodBeat.o(124517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bli
 * JD-Core Version:    0.7.0.1
 */