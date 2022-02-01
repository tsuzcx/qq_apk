package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cni
  extends cqk
{
  public String AYl;
  public String FAA;
  public String FAB;
  public String FAC;
  public boolean FAx;
  public boolean FAy;
  public String FAz;
  public int FuS;
  public int nWx;
  public String nWy;
  public int status;
  public String tGS;
  public String vxk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.bl(4, this.FAx);
      paramVarArgs.bl(5, this.FAy);
      paramVarArgs.aR(6, this.status);
      if (this.FAz != null) {
        paramVarArgs.d(7, this.FAz);
      }
      if (this.FAA != null) {
        paramVarArgs.d(8, this.FAA);
      }
      paramVarArgs.aR(9, this.FuS);
      if (this.tGS != null) {
        paramVarArgs.d(10, this.tGS);
      }
      if (this.vxk != null) {
        paramVarArgs.d(11, this.vxk);
      }
      if (this.FAB != null) {
        paramVarArgs.d(12, this.FAB);
      }
      if (this.FAC != null) {
        paramVarArgs.d(13, this.FAC);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1122;
      }
    }
    label1122:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 1) + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.b.b.a.bx(6, this.status);
      paramInt = i;
      if (this.FAz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FAz);
      }
      i = paramInt;
      if (this.FAA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FAA);
      }
      i += f.a.a.b.b.a.bx(9, this.FuS);
      paramInt = i;
      if (this.tGS != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tGS);
      }
      i = paramInt;
      if (this.vxk != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.vxk);
      }
      paramInt = i;
      if (this.FAB != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FAB);
      }
      i = paramInt;
      if (this.FAC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FAC);
      }
      paramInt = i;
      if (this.AYl != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cni localcni = (cni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcni.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localcni.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localcni.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localcni.FAx = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localcni.FAy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localcni.status = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localcni.FAz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localcni.FAA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localcni.FuS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localcni.tGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localcni.vxk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localcni.FAB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localcni.FAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91666);
          return 0;
        }
        localcni.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cni
 * JD-Core Version:    0.7.0.1
 */