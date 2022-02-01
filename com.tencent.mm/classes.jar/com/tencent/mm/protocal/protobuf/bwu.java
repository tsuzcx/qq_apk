package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bwu
  extends cld
{
  public cgx CTW;
  public int Csl;
  public int DTa;
  public int DTb;
  public int DTc;
  public long DTd;
  public long DTe;
  public LinkedList<bez> DTf;
  public String DTg;
  public String DTh;
  public String DTi;
  public int DTj;
  public int DTk;
  public String DTl;
  public long dEb;
  public int sYr;
  public int sYs;
  public String sYt;
  public String sYu;
  public String sYv;
  
  public bwu()
  {
    AppMethodBeat.i(91566);
    this.DTf = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DTa);
      paramVarArgs.aR(3, this.DTb);
      paramVarArgs.aR(4, this.sYr);
      paramVarArgs.aG(5, this.dEb);
      paramVarArgs.aR(6, this.DTc);
      paramVarArgs.aG(7, this.DTd);
      paramVarArgs.aR(8, this.Csl);
      paramVarArgs.aG(9, this.DTe);
      paramVarArgs.aR(10, this.sYs);
      paramVarArgs.e(11, 8, this.DTf);
      if (this.sYt != null) {
        paramVarArgs.d(12, this.sYt);
      }
      if (this.DTg != null) {
        paramVarArgs.d(13, this.DTg);
      }
      if (this.DTh != null) {
        paramVarArgs.d(14, this.DTh);
      }
      if (this.DTi != null) {
        paramVarArgs.d(15, this.DTi);
      }
      paramVarArgs.aR(16, this.DTj);
      if (this.sYv != null) {
        paramVarArgs.d(17, this.sYv);
      }
      paramVarArgs.aR(18, this.DTk);
      if (this.sYu != null) {
        paramVarArgs.d(19, this.sYu);
      }
      if (this.CTW != null)
      {
        paramVarArgs.kX(20, this.CTW.computeSize());
        this.CTW.writeFields(paramVarArgs);
      }
      if (this.DTl != null) {
        paramVarArgs.d(21, this.DTl);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DTa) + f.a.a.b.b.a.bA(3, this.DTb) + f.a.a.b.b.a.bA(4, this.sYr) + f.a.a.b.b.a.q(5, this.dEb) + f.a.a.b.b.a.bA(6, this.DTc) + f.a.a.b.b.a.q(7, this.DTd) + f.a.a.b.b.a.bA(8, this.Csl) + f.a.a.b.b.a.q(9, this.DTe) + f.a.a.b.b.a.bA(10, this.sYs) + f.a.a.a.c(11, 8, this.DTf);
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sYt);
      }
      i = paramInt;
      if (this.DTg != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DTg);
      }
      paramInt = i;
      if (this.DTh != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DTh);
      }
      i = paramInt;
      if (this.DTi != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DTi);
      }
      i += f.a.a.b.b.a.bA(16, this.DTj);
      paramInt = i;
      if (this.sYv != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.sYv);
      }
      i = paramInt + f.a.a.b.b.a.bA(18, this.DTk);
      paramInt = i;
      if (this.sYu != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.sYu);
      }
      i = paramInt;
      if (this.CTW != null) {
        i = paramInt + f.a.a.a.kW(20, this.CTW.computeSize());
      }
      paramInt = i;
      if (this.DTl != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DTl);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwu localbwu = (bwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localbwu.DTa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localbwu.DTb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localbwu.sYr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localbwu.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localbwu.DTc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localbwu.DTd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localbwu.Csl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localbwu.DTe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localbwu.sYs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bez();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwu.DTf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localbwu.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localbwu.DTg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localbwu.DTh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localbwu.DTi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localbwu.DTj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localbwu.sYv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localbwu.DTk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localbwu.sYu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwu.CTW = ((cgx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localbwu.DTl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwu
 * JD-Core Version:    0.7.0.1
 */