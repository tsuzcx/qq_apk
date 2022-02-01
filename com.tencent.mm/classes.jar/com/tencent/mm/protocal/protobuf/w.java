package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class w
  extends cvp
{
  public String FpG;
  public LinkedList<u> FpL;
  public String FpO;
  public String FpP;
  public String FpY;
  public String Fqc;
  public long Fqd;
  public int Fqe;
  public long Fqf;
  public int Fqg;
  public int Fqh;
  public int Fqi;
  public int Fqj;
  public long Fqk;
  public long Fql;
  public long Fqm;
  public int Fqn;
  public String Fqo;
  public int Fqp;
  public long Fqq;
  public int dlw;
  public String paA;
  public int role;
  public int state;
  public String title;
  public int type;
  
  public w()
  {
    AppMethodBeat.i(91334);
    this.dlw = 268513600;
    this.paA = "请求不成功，请稍候再试";
    this.FpL = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.FpG != null) {
        paramVarArgs.d(4, this.FpG);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.aS(6, this.type);
      if (this.Fqc != null) {
        paramVarArgs.d(7, this.Fqc);
      }
      paramVarArgs.aY(8, this.Fqd);
      paramVarArgs.aS(9, this.Fqe);
      paramVarArgs.aY(10, this.Fqf);
      paramVarArgs.aS(11, this.Fqg);
      paramVarArgs.aS(12, this.state);
      paramVarArgs.aS(13, this.Fqh);
      paramVarArgs.aS(14, this.Fqi);
      paramVarArgs.aS(15, this.role);
      paramVarArgs.aS(16, this.Fqj);
      paramVarArgs.aY(17, this.Fqk);
      paramVarArgs.aY(18, this.Fql);
      paramVarArgs.aY(19, this.Fqm);
      paramVarArgs.aS(20, this.Fqn);
      if (this.FpY != null) {
        paramVarArgs.d(21, this.FpY);
      }
      paramVarArgs.e(22, 8, this.FpL);
      if (this.Fqo != null) {
        paramVarArgs.d(23, this.Fqo);
      }
      paramVarArgs.aS(24, this.Fqp);
      paramVarArgs.aY(25, this.Fqq);
      if (this.FpO != null) {
        paramVarArgs.d(26, this.FpO);
      }
      if (this.FpP != null) {
        paramVarArgs.d(27, this.FpP);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.FpG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FpG);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.Fqc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fqc);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.Fqd) + f.a.a.b.b.a.bz(9, this.Fqe) + f.a.a.b.b.a.p(10, this.Fqf) + f.a.a.b.b.a.bz(11, this.Fqg) + f.a.a.b.b.a.bz(12, this.state) + f.a.a.b.b.a.bz(13, this.Fqh) + f.a.a.b.b.a.bz(14, this.Fqi) + f.a.a.b.b.a.bz(15, this.role) + f.a.a.b.b.a.bz(16, this.Fqj) + f.a.a.b.b.a.p(17, this.Fqk) + f.a.a.b.b.a.p(18, this.Fql) + f.a.a.b.b.a.p(19, this.Fqm) + f.a.a.b.b.a.bz(20, this.Fqn);
      paramInt = i;
      if (this.FpY != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FpY);
      }
      i = paramInt + f.a.a.a.c(22, 8, this.FpL);
      paramInt = i;
      if (this.Fqo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Fqo);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.Fqp) + f.a.a.b.b.a.p(25, this.Fqq);
      paramInt = i;
      if (this.FpO != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FpO);
      }
      i = paramInt;
      if (this.FpP != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.FpP);
      }
      AppMethodBeat.o(91335);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FpL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localw.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localw.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localw.FpG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localw.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localw.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localw.Fqc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localw.Fqd = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localw.Fqe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localw.Fqf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localw.Fqg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localw.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localw.Fqh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localw.Fqi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localw.role = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localw.Fqj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localw.Fqk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localw.Fql = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localw.Fqm = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localw.Fqn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localw.FpY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.FpL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localw.Fqo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localw.Fqp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localw.Fqq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localw.FpO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91335);
          return 0;
        }
        localw.FpP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91335);
        return 0;
      }
      AppMethodBeat.o(91335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.w
 * JD-Core Version:    0.7.0.1
 */