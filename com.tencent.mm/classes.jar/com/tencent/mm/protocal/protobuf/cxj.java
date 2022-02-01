package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxj
  extends cqk
{
  public String dvP;
  public String hhs;
  public String hiu;
  public String nUr;
  public String nUs;
  public String nUt;
  public int nUv;
  public String nVK;
  public int nWg;
  public String title;
  public int xxE;
  public int xxH;
  public String xxI;
  public String xxJ;
  public String xxK;
  public String xxL;
  public String xxM;
  public boolean xxN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWg);
      if (this.nUr != null) {
        paramVarArgs.d(3, this.nUr);
      }
      if (this.dvP != null) {
        paramVarArgs.d(4, this.dvP);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.nUs != null) {
        paramVarArgs.d(6, this.nUs);
      }
      if (this.nUt != null) {
        paramVarArgs.d(7, this.nUt);
      }
      if (this.nVK != null) {
        paramVarArgs.d(8, this.nVK);
      }
      if (this.hhs != null) {
        paramVarArgs.d(9, this.hhs);
      }
      if (this.hiu != null) {
        paramVarArgs.d(10, this.hiu);
      }
      paramVarArgs.aR(11, this.xxE);
      paramVarArgs.aR(12, this.xxH);
      if (this.xxI != null) {
        paramVarArgs.d(13, this.xxI);
      }
      if (this.xxJ != null) {
        paramVarArgs.d(14, this.xxJ);
      }
      if (this.xxK != null) {
        paramVarArgs.d(19, this.xxK);
      }
      if (this.xxL != null) {
        paramVarArgs.d(21, this.xxL);
      }
      paramVarArgs.aR(22, this.nUv);
      if (this.xxM != null) {
        paramVarArgs.d(23, this.xxM);
      }
      paramVarArgs.bl(24, this.xxN);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1431;
      }
    }
    label1431:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWg);
      paramInt = i;
      if (this.nUr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nUr);
      }
      i = paramInt;
      if (this.dvP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dvP);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.nUs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nUs);
      }
      paramInt = i;
      if (this.nUt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nUt);
      }
      i = paramInt;
      if (this.nVK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nVK);
      }
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hhs);
      }
      i = paramInt;
      if (this.hiu != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hiu);
      }
      i = i + f.a.a.b.b.a.bx(11, this.xxE) + f.a.a.b.b.a.bx(12, this.xxH);
      paramInt = i;
      if (this.xxI != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.xxI);
      }
      i = paramInt;
      if (this.xxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.xxJ);
      }
      paramInt = i;
      if (this.xxK != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.xxK);
      }
      i = paramInt;
      if (this.xxL != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.xxL);
      }
      i += f.a.a.b.b.a.bx(22, this.nUv);
      paramInt = i;
      if (this.xxM != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.xxM);
      }
      i = f.a.a.b.b.a.fK(24);
      AppMethodBeat.o(32439);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxj localcxj = (cxj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
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
            localcxj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localcxj.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localcxj.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localcxj.dvP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localcxj.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localcxj.nUs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localcxj.nUt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localcxj.nVK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localcxj.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localcxj.hiu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localcxj.xxE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localcxj.xxH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localcxj.xxI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localcxj.xxJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localcxj.xxK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localcxj.xxL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localcxj.nUv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localcxj.xxM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localcxj.xxN = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */