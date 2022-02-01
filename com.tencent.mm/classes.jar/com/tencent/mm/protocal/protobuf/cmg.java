package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cmg
  extends cwj
{
  public int COB;
  public String COv;
  public LinkedList<ud> GOH;
  public String HjA;
  public boolean HjB;
  public bqi Hyc;
  public cnj Hyd;
  public String Hye;
  public int Hyf;
  public long Hyg;
  public String Hyh;
  public String Hyi;
  public String Hyj;
  public String Hyk;
  public LinkedList<csw> Hyl;
  public int oGt;
  public String oGu;
  
  public cmg()
  {
    AppMethodBeat.i(91622);
    this.GOH = new LinkedList();
    this.HjB = true;
    this.Hyl = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.Hyc != null)
      {
        paramVarArgs.lJ(4, this.Hyc.computeSize());
        this.Hyc.writeFields(paramVarArgs);
      }
      if (this.Hyd != null)
      {
        paramVarArgs.lJ(5, this.Hyd.computeSize());
        this.Hyd.writeFields(paramVarArgs);
      }
      if (this.HjA != null) {
        paramVarArgs.d(6, this.HjA);
      }
      paramVarArgs.e(7, 8, this.GOH);
      paramVarArgs.bC(8, this.HjB);
      paramVarArgs.aS(9, this.COB);
      if (this.Hye != null) {
        paramVarArgs.d(10, this.Hye);
      }
      paramVarArgs.aS(11, this.Hyf);
      paramVarArgs.aZ(12, this.Hyg);
      if (this.COv != null) {
        paramVarArgs.d(13, this.COv);
      }
      if (this.Hyh != null) {
        paramVarArgs.d(14, this.Hyh);
      }
      if (this.Hyi != null) {
        paramVarArgs.d(15, this.Hyi);
      }
      if (this.Hyj != null) {
        paramVarArgs.d(16, this.Hyj);
      }
      if (this.Hyk != null) {
        paramVarArgs.d(17, this.Hyk);
      }
      paramVarArgs.e(18, 8, this.Hyl);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1662;
      }
    }
    label1662:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.Hyc != null) {
        i = paramInt + f.a.a.a.lI(4, this.Hyc.computeSize());
      }
      paramInt = i;
      if (this.Hyd != null) {
        paramInt = i + f.a.a.a.lI(5, this.Hyd.computeSize());
      }
      i = paramInt;
      if (this.HjA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HjA);
      }
      i = i + f.a.a.a.c(7, 8, this.GOH) + f.a.a.b.b.a.amF(8) + f.a.a.b.b.a.bz(9, this.COB);
      paramInt = i;
      if (this.Hye != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hye);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Hyf) + f.a.a.b.b.a.p(12, this.Hyg);
      paramInt = i;
      if (this.COv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.COv);
      }
      i = paramInt;
      if (this.Hyh != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hyh);
      }
      paramInt = i;
      if (this.Hyi != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Hyi);
      }
      i = paramInt;
      if (this.Hyj != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Hyj);
      }
      paramInt = i;
      if (this.Hyk != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Hyk);
      }
      i = f.a.a.a.c(18, 8, this.Hyl);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOH.clear();
        this.Hyl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmg localcmg = (cmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
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
            localcmg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localcmg.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localcmg.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmg.Hyc = ((bqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmg.Hyd = ((cnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localcmg.HjA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmg.GOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localcmg.HjB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localcmg.COB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localcmg.Hye = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localcmg.Hyf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localcmg.Hyg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localcmg.COv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localcmg.Hyh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localcmg.Hyi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localcmg.Hyj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localcmg.Hyk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmg.Hyl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmg
 * JD-Core Version:    0.7.0.1
 */