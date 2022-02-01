package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfr
  extends cld
{
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
  
  public cfr()
  {
    AppMethodBeat.i(91656);
    this.DTf = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.dEb);
      paramVarArgs.aR(3, this.DTc);
      paramVarArgs.aG(4, this.DTd);
      paramVarArgs.aR(5, this.Csl);
      paramVarArgs.aG(6, this.DTe);
      paramVarArgs.aR(9, this.sYs);
      paramVarArgs.e(10, 8, this.DTf);
      if (this.sYt != null) {
        paramVarArgs.d(11, this.sYt);
      }
      if (this.DTg != null) {
        paramVarArgs.d(12, this.DTg);
      }
      if (this.DTh != null) {
        paramVarArgs.d(13, this.DTh);
      }
      if (this.DTi != null) {
        paramVarArgs.d(14, this.DTi);
      }
      paramVarArgs.aR(15, this.DTj);
      if (this.sYv != null) {
        paramVarArgs.d(16, this.sYv);
      }
      paramVarArgs.aR(17, this.DTk);
      if (this.sYu != null) {
        paramVarArgs.d(18, this.sYu);
      }
      paramVarArgs.aR(19, this.DTb);
      paramVarArgs.aR(20, this.sYr);
      paramVarArgs.aR(21, this.DTa);
      if (this.DTl != null) {
        paramVarArgs.d(22, this.DTl);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.dEb) + f.a.a.b.b.a.bA(3, this.DTc) + f.a.a.b.b.a.q(4, this.DTd) + f.a.a.b.b.a.bA(5, this.Csl) + f.a.a.b.b.a.q(6, this.DTe) + f.a.a.b.b.a.bA(9, this.sYs) + f.a.a.a.c(10, 8, this.DTf);
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sYt);
      }
      i = paramInt;
      if (this.DTg != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DTg);
      }
      paramInt = i;
      if (this.DTh != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DTh);
      }
      i = paramInt;
      if (this.DTi != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DTi);
      }
      i += f.a.a.b.b.a.bA(15, this.DTj);
      paramInt = i;
      if (this.sYv != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.sYv);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.DTk);
      paramInt = i;
      if (this.sYu != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.sYu);
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.DTb) + f.a.a.b.b.a.bA(20, this.sYr) + f.a.a.b.b.a.bA(21, this.DTa);
      paramInt = i;
      if (this.DTl != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DTl);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfr localcfr = (cfr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localcfr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localcfr.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localcfr.DTc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localcfr.DTd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localcfr.Csl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localcfr.DTe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localcfr.sYs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bez();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfr.DTf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localcfr.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localcfr.DTg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localcfr.DTh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localcfr.DTi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localcfr.DTj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localcfr.sYv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localcfr.DTk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localcfr.sYu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localcfr.DTb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localcfr.sYr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localcfr.DTa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91657);
          return 0;
        }
        localcfr.DTl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfr
 * JD-Core Version:    0.7.0.1
 */