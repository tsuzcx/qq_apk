package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayq
  extends cwj
{
  public rz FWY;
  public rz FWZ;
  public rz FXa;
  public SKBuiltinBuffer_t FXb;
  public SKBuiltinBuffer_t FXc;
  public rz FXd;
  public int FXe;
  public ry FXf;
  public ry FXg;
  public int GPk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.FWY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DnsInfo");
        AppMethodBeat.o(152567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FWY != null)
      {
        paramVarArgs.lJ(2, this.FWY.computeSize());
        this.FWY.writeFields(paramVarArgs);
      }
      if (this.FWZ != null)
      {
        paramVarArgs.lJ(3, this.FWZ.computeSize());
        this.FWZ.writeFields(paramVarArgs);
      }
      if (this.FXa != null)
      {
        paramVarArgs.lJ(4, this.FXa.computeSize());
        this.FXa.writeFields(paramVarArgs);
      }
      if (this.FXb != null)
      {
        paramVarArgs.lJ(5, this.FXb.computeSize());
        this.FXb.writeFields(paramVarArgs);
      }
      if (this.FXc != null)
      {
        paramVarArgs.lJ(6, this.FXc.computeSize());
        this.FXc.writeFields(paramVarArgs);
      }
      if (this.FXd != null)
      {
        paramVarArgs.lJ(7, this.FXd.computeSize());
        this.FXd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FXe);
      if (this.FXf != null)
      {
        paramVarArgs.lJ(9, this.FXf.computeSize());
        this.FXf.writeFields(paramVarArgs);
      }
      if (this.FXg != null)
      {
        paramVarArgs.lJ(10, this.FXg.computeSize());
        this.FXg.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.GPk);
      AppMethodBeat.o(152567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWY != null) {
        paramInt = i + f.a.a.a.lI(2, this.FWY.computeSize());
      }
      i = paramInt;
      if (this.FWZ != null) {
        i = paramInt + f.a.a.a.lI(3, this.FWZ.computeSize());
      }
      paramInt = i;
      if (this.FXa != null) {
        paramInt = i + f.a.a.a.lI(4, this.FXa.computeSize());
      }
      i = paramInt;
      if (this.FXb != null) {
        i = paramInt + f.a.a.a.lI(5, this.FXb.computeSize());
      }
      paramInt = i;
      if (this.FXc != null) {
        paramInt = i + f.a.a.a.lI(6, this.FXc.computeSize());
      }
      i = paramInt;
      if (this.FXd != null) {
        i = paramInt + f.a.a.a.lI(7, this.FXd.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.FXe);
      paramInt = i;
      if (this.FXf != null) {
        paramInt = i + f.a.a.a.lI(9, this.FXf.computeSize());
      }
      i = paramInt;
      if (this.FXg != null) {
        i = paramInt + f.a.a.a.lI(10, this.FXg.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GPk);
      AppMethodBeat.o(152567);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        if (this.FWY == null)
        {
          paramVarArgs = new b("Not all required fields were included: DnsInfo");
          AppMethodBeat.o(152567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayq localayq = (ayq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152567);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FWY = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FWZ = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXa = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXd = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 8: 
          localayq.FXe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152567);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXf = ((ry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayq.FXg = ((ry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152567);
          return 0;
        }
        localayq.GPk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152567);
        return 0;
      }
      AppMethodBeat.o(152567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayq
 * JD-Core Version:    0.7.0.1
 */