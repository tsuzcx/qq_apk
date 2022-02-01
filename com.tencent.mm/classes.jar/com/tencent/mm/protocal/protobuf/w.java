package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class w
  extends cqk
{
  public String DKA;
  public LinkedList<u> DKF;
  public String DKI;
  public String DKJ;
  public String DKS;
  public String DKW;
  public long DKX;
  public int DKY;
  public long DKZ;
  public int DLa;
  public int DLb;
  public int DLc;
  public int DLd;
  public long DLe;
  public long DLf;
  public long DLg;
  public int DLh;
  public String DLi;
  public int DLj;
  public long DLk;
  public int dae;
  public String oxf;
  public int role;
  public int state;
  public String title;
  public int type;
  
  public w()
  {
    AppMethodBeat.i(91334);
    this.dae = 268513600;
    this.oxf = "请求不成功，请稍候再试";
    this.DKF = new LinkedList();
    AppMethodBeat.o(91334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91335);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91335);
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
      if (this.DKA != null) {
        paramVarArgs.d(4, this.DKA);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.aR(6, this.type);
      if (this.DKW != null) {
        paramVarArgs.d(7, this.DKW);
      }
      paramVarArgs.aO(8, this.DKX);
      paramVarArgs.aR(9, this.DKY);
      paramVarArgs.aO(10, this.DKZ);
      paramVarArgs.aR(11, this.DLa);
      paramVarArgs.aR(12, this.state);
      paramVarArgs.aR(13, this.DLb);
      paramVarArgs.aR(14, this.DLc);
      paramVarArgs.aR(15, this.role);
      paramVarArgs.aR(16, this.DLd);
      paramVarArgs.aO(17, this.DLe);
      paramVarArgs.aO(18, this.DLf);
      paramVarArgs.aO(19, this.DLg);
      paramVarArgs.aR(20, this.DLh);
      if (this.DKS != null) {
        paramVarArgs.d(21, this.DKS);
      }
      paramVarArgs.e(22, 8, this.DKF);
      if (this.DLi != null) {
        paramVarArgs.d(23, this.DLi);
      }
      paramVarArgs.aR(24, this.DLj);
      paramVarArgs.aO(25, this.DLk);
      if (this.DKI != null) {
        paramVarArgs.d(26, this.DKI);
      }
      if (this.DKJ != null) {
        paramVarArgs.d(27, this.DKJ);
      }
      AppMethodBeat.o(91335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1746;
      }
    }
    label1746:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.DKA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DKA);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.type);
      paramInt = i;
      if (this.DKW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DKW);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.DKX) + f.a.a.b.b.a.bx(9, this.DKY) + f.a.a.b.b.a.p(10, this.DKZ) + f.a.a.b.b.a.bx(11, this.DLa) + f.a.a.b.b.a.bx(12, this.state) + f.a.a.b.b.a.bx(13, this.DLb) + f.a.a.b.b.a.bx(14, this.DLc) + f.a.a.b.b.a.bx(15, this.role) + f.a.a.b.b.a.bx(16, this.DLd) + f.a.a.b.b.a.p(17, this.DLe) + f.a.a.b.b.a.p(18, this.DLf) + f.a.a.b.b.a.p(19, this.DLg) + f.a.a.b.b.a.bx(20, this.DLh);
      paramInt = i;
      if (this.DKS != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DKS);
      }
      i = paramInt + f.a.a.a.c(22, 8, this.DKF);
      paramInt = i;
      if (this.DLi != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DLi);
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.DLj) + f.a.a.b.b.a.p(25, this.DLk);
      paramInt = i;
      if (this.DKI != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.DKI);
      }
      i = paramInt;
      if (this.DKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.DKJ);
      }
      AppMethodBeat.o(91335);
      return i;
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
          AppMethodBeat.o(91335);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91335);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91335);
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
            localw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localw.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localw.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localw.DKA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localw.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localw.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localw.DKW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localw.DKX = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localw.DKY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localw.DKZ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localw.DLa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localw.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localw.DLb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localw.DLc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localw.role = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localw.DLd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localw.DLe = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localw.DLf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localw.DLg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localw.DLh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localw.DKS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.DKF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localw.DLi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localw.DLj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localw.DLk = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localw.DKI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91335);
          return 0;
        }
        localw.DKJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91335);
        return 0;
      }
      AppMethodBeat.o(91335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.w
 * JD-Core Version:    0.7.0.1
 */