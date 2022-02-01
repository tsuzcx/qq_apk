package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class w
  extends cwj
{
  public String FIA;
  public long FIB;
  public int FIC;
  public long FID;
  public int FIE;
  public int FIF;
  public int FIG;
  public int FIH;
  public long FII;
  public long FIJ;
  public long FIK;
  public int FIL;
  public String FIM;
  public int FIN;
  public long FIO;
  public String FIe;
  public LinkedList<u> FIj;
  public String FIm;
  public String FIn;
  public String FIw;
  public int dmy;
  public String phe;
  public int role;
  public int state;
  public String title;
  public int type;
  
  public w()
  {
    AppMethodBeat.i(91334);
    this.dmy = 268513600;
    this.phe = "请求不成功，请稍候再试";
    this.FIj = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.FIe != null) {
        paramVarArgs.d(4, this.FIe);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.aS(6, this.type);
      if (this.FIA != null) {
        paramVarArgs.d(7, this.FIA);
      }
      paramVarArgs.aZ(8, this.FIB);
      paramVarArgs.aS(9, this.FIC);
      paramVarArgs.aZ(10, this.FID);
      paramVarArgs.aS(11, this.FIE);
      paramVarArgs.aS(12, this.state);
      paramVarArgs.aS(13, this.FIF);
      paramVarArgs.aS(14, this.FIG);
      paramVarArgs.aS(15, this.role);
      paramVarArgs.aS(16, this.FIH);
      paramVarArgs.aZ(17, this.FII);
      paramVarArgs.aZ(18, this.FIJ);
      paramVarArgs.aZ(19, this.FIK);
      paramVarArgs.aS(20, this.FIL);
      if (this.FIw != null) {
        paramVarArgs.d(21, this.FIw);
      }
      paramVarArgs.e(22, 8, this.FIj);
      if (this.FIM != null) {
        paramVarArgs.d(23, this.FIM);
      }
      paramVarArgs.aS(24, this.FIN);
      paramVarArgs.aZ(25, this.FIO);
      if (this.FIm != null) {
        paramVarArgs.d(26, this.FIm);
      }
      if (this.FIn != null) {
        paramVarArgs.d(27, this.FIn);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.FIe != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FIe);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.FIA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FIA);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.FIB) + f.a.a.b.b.a.bz(9, this.FIC) + f.a.a.b.b.a.p(10, this.FID) + f.a.a.b.b.a.bz(11, this.FIE) + f.a.a.b.b.a.bz(12, this.state) + f.a.a.b.b.a.bz(13, this.FIF) + f.a.a.b.b.a.bz(14, this.FIG) + f.a.a.b.b.a.bz(15, this.role) + f.a.a.b.b.a.bz(16, this.FIH) + f.a.a.b.b.a.p(17, this.FII) + f.a.a.b.b.a.p(18, this.FIJ) + f.a.a.b.b.a.p(19, this.FIK) + f.a.a.b.b.a.bz(20, this.FIL);
      paramInt = i;
      if (this.FIw != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FIw);
      }
      i = paramInt + f.a.a.a.c(22, 8, this.FIj);
      paramInt = i;
      if (this.FIM != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FIM);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.FIN) + f.a.a.b.b.a.p(25, this.FIO);
      paramInt = i;
      if (this.FIm != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FIm);
      }
      i = paramInt;
      if (this.FIn != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.FIn);
      }
      AppMethodBeat.o(91335);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localw.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localw.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localw.FIe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localw.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localw.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localw.FIA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localw.FIB = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localw.FIC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localw.FID = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localw.FIE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localw.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localw.FIF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localw.FIG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localw.role = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localw.FIH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localw.FII = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localw.FIJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localw.FIK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localw.FIL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localw.FIw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.FIj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localw.FIM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localw.FIN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localw.FIO = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localw.FIm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91335);
          return 0;
        }
        localw.FIn = ((f.a.a.a.a)localObject1).OmT.readString();
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