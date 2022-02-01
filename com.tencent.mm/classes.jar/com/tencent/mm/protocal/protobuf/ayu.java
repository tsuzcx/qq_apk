package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayu
  extends cqk
{
  public String Bkp;
  public boolean EQc;
  public boolean EQd;
  public String EQe;
  public String EQf;
  public int EQg;
  public String EQh;
  public int EQi;
  public String dvP;
  public String hhs;
  public String hiu;
  public String nUr;
  public String nUs;
  public String nUt;
  public int nUv;
  public String nVK;
  public String title;
  public int xxH;
  public String xxI;
  public String xxJ;
  public String xxK;
  public String xxM;
  public boolean xxN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.EQc);
      paramVarArgs.bl(3, this.EQd);
      if (this.EQe != null) {
        paramVarArgs.d(4, this.EQe);
      }
      if (this.EQf != null) {
        paramVarArgs.d(5, this.EQf);
      }
      paramVarArgs.aR(6, this.EQg);
      if (this.EQh != null) {
        paramVarArgs.d(7, this.EQh);
      }
      paramVarArgs.aR(8, this.EQi);
      if (this.nUr != null) {
        paramVarArgs.d(9, this.nUr);
      }
      if (this.dvP != null) {
        paramVarArgs.d(10, this.dvP);
      }
      if (this.title != null) {
        paramVarArgs.d(11, this.title);
      }
      if (this.nUs != null) {
        paramVarArgs.d(12, this.nUs);
      }
      if (this.nUt != null) {
        paramVarArgs.d(13, this.nUt);
      }
      if (this.nVK != null) {
        paramVarArgs.d(14, this.nVK);
      }
      if (this.hhs != null) {
        paramVarArgs.d(15, this.hhs);
      }
      if (this.hiu != null) {
        paramVarArgs.d(16, this.hiu);
      }
      paramVarArgs.aR(17, this.xxH);
      if (this.xxI != null) {
        paramVarArgs.d(18, this.xxI);
      }
      if (this.xxJ != null) {
        paramVarArgs.d(19, this.xxJ);
      }
      if (this.xxK != null) {
        paramVarArgs.d(20, this.xxK);
      }
      paramVarArgs.aR(21, this.nUv);
      if (this.xxM != null) {
        paramVarArgs.d(22, this.xxM);
      }
      if (this.Bkp != null) {
        paramVarArgs.d(23, this.Bkp);
      }
      paramVarArgs.bl(24, this.xxN);
      AppMethodBeat.o(32248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1688;
      }
    }
    label1688:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1) + (f.a.a.b.b.a.fK(3) + 1);
      paramInt = i;
      if (this.EQe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EQe);
      }
      i = paramInt;
      if (this.EQf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EQf);
      }
      i += f.a.a.b.b.a.bx(6, this.EQg);
      paramInt = i;
      if (this.EQh != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EQh);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.EQi);
      paramInt = i;
      if (this.nUr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nUr);
      }
      i = paramInt;
      if (this.dvP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dvP);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.title);
      }
      i = paramInt;
      if (this.nUs != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.nUs);
      }
      paramInt = i;
      if (this.nUt != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.nUt);
      }
      i = paramInt;
      if (this.nVK != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.nVK);
      }
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.hhs);
      }
      i = paramInt;
      if (this.hiu != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.hiu);
      }
      i += f.a.a.b.b.a.bx(17, this.xxH);
      paramInt = i;
      if (this.xxI != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.xxI);
      }
      i = paramInt;
      if (this.xxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.xxJ);
      }
      paramInt = i;
      if (this.xxK != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.xxK);
      }
      i = paramInt + f.a.a.b.b.a.bx(21, this.nUv);
      paramInt = i;
      if (this.xxM != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.xxM);
      }
      i = paramInt;
      if (this.Bkp != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Bkp);
      }
      paramInt = f.a.a.b.b.a.fK(24);
      AppMethodBeat.o(32248);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(32248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayu localayu = (ayu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32248);
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
            localayu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32248);
          return 0;
        case 2: 
          localayu.EQc = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32248);
          return 0;
        case 3: 
          localayu.EQd = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32248);
          return 0;
        case 4: 
          localayu.EQe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 5: 
          localayu.EQf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 6: 
          localayu.EQg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32248);
          return 0;
        case 7: 
          localayu.EQh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 8: 
          localayu.EQi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32248);
          return 0;
        case 9: 
          localayu.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 10: 
          localayu.dvP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 11: 
          localayu.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 12: 
          localayu.nUs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 13: 
          localayu.nUt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 14: 
          localayu.nVK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 15: 
          localayu.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 16: 
          localayu.hiu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 17: 
          localayu.xxH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32248);
          return 0;
        case 18: 
          localayu.xxI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 19: 
          localayu.xxJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 20: 
          localayu.xxK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 21: 
          localayu.nUv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32248);
          return 0;
        case 22: 
          localayu.xxM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 23: 
          localayu.Bkp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32248);
          return 0;
        }
        localayu.xxN = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(32248);
        return 0;
      }
      AppMethodBeat.o(32248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayu
 * JD-Core Version:    0.7.0.1
 */