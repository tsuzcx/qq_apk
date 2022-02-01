package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aun
  extends cpx
{
  public String DMk;
  public String DMl;
  public int DMm;
  public LinkedList<rl> DMp;
  public String EMQ;
  public int dvQ;
  public String oGB;
  public String oHj;
  public String sign;
  
  public aun()
  {
    AppMethodBeat.i(114012);
    this.DMp = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DMp);
      paramVarArgs.aR(3, this.dvQ);
      if (this.oHj != null) {
        paramVarArgs.d(4, this.oHj);
      }
      if (this.oGB != null) {
        paramVarArgs.d(5, this.oGB);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.DMk != null) {
        paramVarArgs.d(7, this.DMk);
      }
      if (this.DMl != null) {
        paramVarArgs.d(8, this.DMl);
      }
      if (this.EMQ != null) {
        paramVarArgs.d(9, this.EMQ);
      }
      paramVarArgs.aR(10, this.DMm);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DMp) + f.a.a.b.b.a.bx(3, this.dvQ);
      paramInt = i;
      if (this.oHj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oHj);
      }
      i = paramInt;
      if (this.oGB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oGB);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.DMk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DMk);
      }
      paramInt = i;
      if (this.DMl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DMl);
      }
      i = paramInt;
      if (this.EMQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EMQ);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.DMm);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DMp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aun localaun = (aun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
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
            localaun.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaun.DMp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localaun.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localaun.oHj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localaun.oGB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localaun.sign = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localaun.DMk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localaun.DMl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localaun.EMQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localaun.DMm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aun
 * JD-Core Version:    0.7.0.1
 */