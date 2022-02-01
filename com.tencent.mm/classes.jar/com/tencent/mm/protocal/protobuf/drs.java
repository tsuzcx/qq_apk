package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drs
  extends dyy
{
  public LinkedList<m> RDn;
  public efh TYB;
  public o TYC;
  public int fwx;
  public long gbJ;
  public String llO;
  public String mKO;
  public String mKQ;
  public String remark;
  public String tVo;
  
  public drs()
  {
    AppMethodBeat.i(91649);
    this.fwx = 268513600;
    this.tVo = "请求不成功，请稍候再试";
    this.RDn = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      paramVarArgs.bm(4, this.gbJ);
      if (this.llO != null) {
        paramVarArgs.f(5, this.llO);
      }
      paramVarArgs.e(6, 8, this.RDn);
      if (this.mKO != null) {
        paramVarArgs.f(7, this.mKO);
      }
      if (this.remark != null) {
        paramVarArgs.f(8, this.remark);
      }
      if (this.TYB != null)
      {
        paramVarArgs.oE(9, this.TYB.computeSize());
        this.TYB.writeFields(paramVarArgs);
      }
      if (this.mKQ != null) {
        paramVarArgs.f(10, this.mKQ);
      }
      if (this.TYC != null)
      {
        paramVarArgs.oE(11, this.TYC.computeSize());
        this.TYC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.gbJ);
      paramInt = i;
      if (this.llO != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.llO);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.RDn);
      paramInt = i;
      if (this.mKO != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.mKO);
      }
      i = paramInt;
      if (this.remark != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.remark);
      }
      paramInt = i;
      if (this.TYB != null) {
        paramInt = i + g.a.a.a.oD(9, this.TYB.computeSize());
      }
      i = paramInt;
      if (this.mKQ != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.mKQ);
      }
      paramInt = i;
      if (this.TYC != null) {
        paramInt = i + g.a.a.a.oD(11, this.TYC.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RDn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drs localdrs = (drs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdrs.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localdrs.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localdrs.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localdrs.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localdrs.llO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localdrs.RDn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localdrs.mKO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localdrs.remark = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efh)localObject2).parseFrom((byte[])localObject1);
            }
            localdrs.TYB = ((efh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localdrs.mKQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new o();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((o)localObject2).parseFrom((byte[])localObject1);
          }
          localdrs.TYC = ((o)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drs
 * JD-Core Version:    0.7.0.1
 */