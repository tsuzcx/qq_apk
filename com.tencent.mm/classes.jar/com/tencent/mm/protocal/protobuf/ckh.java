package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckh
  extends cqk
{
  public LinkedList<j> DKF;
  public cvv Fyo;
  public l Fyp;
  public long dBN;
  public int dae;
  public String iAB;
  public String iAC;
  public String iAE;
  public String iAz;
  public String oxf;
  
  public ckh()
  {
    AppMethodBeat.i(91649);
    this.dae = 268513600;
    this.oxf = "请求不成功，请稍候再试";
    this.DKF = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.aO(4, this.dBN);
      if (this.iAz != null) {
        paramVarArgs.d(5, this.iAz);
      }
      paramVarArgs.e(6, 8, this.DKF);
      if (this.iAB != null) {
        paramVarArgs.d(7, this.iAB);
      }
      if (this.iAC != null) {
        paramVarArgs.d(8, this.iAC);
      }
      if (this.Fyo != null)
      {
        paramVarArgs.ln(9, this.Fyo.computeSize());
        this.Fyo.writeFields(paramVarArgs);
      }
      if (this.iAE != null) {
        paramVarArgs.d(10, this.iAE);
      }
      if (this.Fyp != null)
      {
        paramVarArgs.ln(11, this.Fyp.computeSize());
        this.Fyp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.dBN);
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iAz);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.DKF);
      paramInt = i;
      if (this.iAB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iAB);
      }
      i = paramInt;
      if (this.iAC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iAC);
      }
      paramInt = i;
      if (this.Fyo != null) {
        paramInt = i + f.a.a.a.lm(9, this.Fyo.computeSize());
      }
      i = paramInt;
      if (this.iAE != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iAE);
      }
      paramInt = i;
      if (this.Fyp != null) {
        paramInt = i + f.a.a.a.lm(11, this.Fyp.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DKF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91650);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckh localckh = (ckh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
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
            localckh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localckh.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localckh.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localckh.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localckh.iAz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckh.DKF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localckh.iAB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localckh.iAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckh.Fyo = ((cvv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localckh.iAE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckh.Fyp = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      AppMethodBeat.o(91650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckh
 * JD-Core Version:    0.7.0.1
 */