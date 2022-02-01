package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asr
  extends cpx
{
  public String DLD;
  public int DLE;
  public dv EMb;
  public String appId;
  public String cJz;
  public String sign;
  public String srr;
  public String srs;
  public String srt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      if (this.srr != null) {
        paramVarArgs.d(3, this.srr);
      }
      if (this.srs != null) {
        paramVarArgs.d(4, this.srs);
      }
      if (this.srt != null) {
        paramVarArgs.d(5, this.srt);
      }
      if (this.cJz != null) {
        paramVarArgs.d(6, this.cJz);
      }
      if (this.sign != null) {
        paramVarArgs.d(7, this.sign);
      }
      if (this.EMb != null)
      {
        paramVarArgs.ln(8, this.EMb.computeSize());
        this.EMb.writeFields(paramVarArgs);
      }
      if (this.DLD != null) {
        paramVarArgs.d(9, this.DLD);
      }
      paramVarArgs.aR(10, this.DLE);
      AppMethodBeat.o(32219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.appId);
      }
      i = paramInt;
      if (this.srr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.srr);
      }
      paramInt = i;
      if (this.srs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.srs);
      }
      i = paramInt;
      if (this.srt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.srt);
      }
      paramInt = i;
      if (this.cJz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cJz);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sign);
      }
      paramInt = i;
      if (this.EMb != null) {
        paramInt = i + f.a.a.a.lm(8, this.EMb.computeSize());
      }
      i = paramInt;
      if (this.DLD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DLD);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.DLE);
      AppMethodBeat.o(32219);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asr localasr = (asr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32219);
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
            localasr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 2: 
          localasr.appId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 3: 
          localasr.srr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 4: 
          localasr.srs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 5: 
          localasr.srt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 6: 
          localasr.cJz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 7: 
          localasr.sign = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasr.EMb = ((dv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 9: 
          localasr.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32219);
          return 0;
        }
        localasr.DLE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32219);
        return 0;
      }
      AppMethodBeat.o(32219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asr
 * JD-Core Version:    0.7.0.1
 */