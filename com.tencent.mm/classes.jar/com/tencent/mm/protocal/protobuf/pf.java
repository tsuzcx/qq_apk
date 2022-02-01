package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pf
  extends cpx
{
  public dj EeP;
  public int EfJ;
  public dhy Efl;
  public String Efm;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Efl == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.EeP == null)
      {
        paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.token == null)
      {
        paramVarArgs = new b("Not all required fields were included: token");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Efl != null)
      {
        paramVarArgs.ln(2, this.Efl.computeSize());
        this.Efl.writeFields(paramVarArgs);
      }
      if (this.EeP != null)
      {
        paramVarArgs.ln(3, this.EeP.computeSize());
        this.EeP.writeFields(paramVarArgs);
      }
      if (this.Efm != null) {
        paramVarArgs.d(4, this.Efm);
      }
      paramVarArgs.aR(5, this.EfJ);
      if (this.token != null) {
        paramVarArgs.d(6, this.token);
      }
      AppMethodBeat.o(91381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Efl != null) {
        paramInt = i + f.a.a.a.lm(2, this.Efl.computeSize());
      }
      i = paramInt;
      if (this.EeP != null) {
        i = paramInt + f.a.a.a.lm(3, this.EeP.computeSize());
      }
      paramInt = i;
      if (this.Efm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Efm);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EfJ);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Efl == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.EeP == null)
        {
          paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.token == null)
        {
          paramVarArgs = new b("Not all required fields were included: token");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pf localpf = (pf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
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
            localpf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpf.Efl = ((dhy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpf.EeP = ((dj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localpf.Efm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localpf.EfJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91381);
          return 0;
        }
        localpf.token = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */