package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxt
  extends cpx
{
  public dcq DMo;
  public String EMQ;
  public int FHq;
  public cym FHr;
  public String Fdk;
  public int dvQ;
  public LinkedList<cxv> hkS;
  
  public cxt()
  {
    AppMethodBeat.i(114070);
    this.hkS = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FHq);
      paramVarArgs.e(3, 8, this.hkS);
      if (this.Fdk != null) {
        paramVarArgs.d(4, this.Fdk);
      }
      if (this.EMQ != null) {
        paramVarArgs.d(5, this.EMQ);
      }
      if (this.FHr != null)
      {
        paramVarArgs.ln(6, this.FHr.computeSize());
        this.FHr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.dvQ);
      if (this.DMo != null)
      {
        paramVarArgs.ln(8, this.DMo.computeSize());
        this.DMo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FHq) + f.a.a.a.c(3, 8, this.hkS);
      paramInt = i;
      if (this.Fdk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fdk);
      }
      i = paramInt;
      if (this.EMQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EMQ);
      }
      paramInt = i;
      if (this.FHr != null) {
        paramInt = i + f.a.a.a.lm(6, this.FHr.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.dvQ);
      paramInt = i;
      if (this.DMo != null) {
        paramInt = i + f.a.a.a.lm(8, this.DMo.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hkS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localcxt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localcxt.FHq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxt.hkS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localcxt.Fdk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localcxt.EMQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxt.FHr = ((cym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localcxt.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxt.DMo = ((dcq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */