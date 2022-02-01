package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bht
  extends cwj
{
  public boolean Dgp;
  public String Djb;
  public String Djc;
  public String GVK;
  public String GVL;
  public String GVM;
  public String GVN;
  public String GVO;
  public boolean GVP;
  public String GVQ;
  public long GVR;
  public boolean GVS;
  public boolean GVT;
  public boolean GVU;
  public String GVV;
  public String GVW;
  public String GVX;
  public String GVY;
  public boolean GVZ;
  public LinkedList<String> GWa;
  public bst GWb;
  public boolean GWc;
  public boolean GWd;
  public boolean GWe;
  public LinkedList<crv> GWf;
  public boolean GWg;
  public din GWh;
  public int dmy;
  public String phe;
  
  public bht()
  {
    AppMethodBeat.i(91509);
    this.GWa = new LinkedList();
    this.GWf = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
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
      if (this.GVK != null) {
        paramVarArgs.d(4, this.GVK);
      }
      if (this.GVL != null) {
        paramVarArgs.d(5, this.GVL);
      }
      if (this.GVM != null) {
        paramVarArgs.d(6, this.GVM);
      }
      if (this.GVN != null) {
        paramVarArgs.d(7, this.GVN);
      }
      if (this.GVO != null) {
        paramVarArgs.d(8, this.GVO);
      }
      paramVarArgs.bC(9, this.GVP);
      if (this.GVQ != null) {
        paramVarArgs.d(10, this.GVQ);
      }
      paramVarArgs.aZ(11, this.GVR);
      paramVarArgs.bC(12, this.GVS);
      paramVarArgs.bC(13, this.GVT);
      paramVarArgs.bC(14, this.GVU);
      if (this.GVV != null) {
        paramVarArgs.d(15, this.GVV);
      }
      if (this.GVW != null) {
        paramVarArgs.d(16, this.GVW);
      }
      if (this.GVX != null) {
        paramVarArgs.d(17, this.GVX);
      }
      if (this.GVY != null) {
        paramVarArgs.d(18, this.GVY);
      }
      paramVarArgs.bC(19, this.GVZ);
      paramVarArgs.e(20, 1, this.GWa);
      paramVarArgs.bC(21, this.Dgp);
      if (this.GWb != null)
      {
        paramVarArgs.lJ(22, this.GWb.computeSize());
        this.GWb.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(23, this.GWc);
      paramVarArgs.bC(26, this.GWd);
      paramVarArgs.bC(27, this.GWe);
      paramVarArgs.e(28, 8, this.GWf);
      if (this.Djb != null) {
        paramVarArgs.d(29, this.Djb);
      }
      if (this.Djc != null) {
        paramVarArgs.d(30, this.Djc);
      }
      paramVarArgs.bC(31, this.GWg);
      if (this.GWh != null)
      {
        paramVarArgs.lJ(32, this.GWh.computeSize());
        this.GWh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2174;
      }
    }
    label2174:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.GVK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GVK);
      }
      paramInt = i;
      if (this.GVL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GVL);
      }
      i = paramInt;
      if (this.GVM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GVM);
      }
      paramInt = i;
      if (this.GVN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GVN);
      }
      i = paramInt;
      if (this.GVO != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GVO);
      }
      i += f.a.a.b.b.a.amF(9);
      paramInt = i;
      if (this.GVQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GVQ);
      }
      i = paramInt + f.a.a.b.b.a.p(11, this.GVR) + f.a.a.b.b.a.amF(12) + f.a.a.b.b.a.amF(13) + f.a.a.b.b.a.amF(14);
      paramInt = i;
      if (this.GVV != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GVV);
      }
      i = paramInt;
      if (this.GVW != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.GVW);
      }
      paramInt = i;
      if (this.GVX != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GVX);
      }
      i = paramInt;
      if (this.GVY != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GVY);
      }
      i = i + f.a.a.b.b.a.amF(19) + f.a.a.a.c(20, 1, this.GWa) + f.a.a.b.b.a.amF(21);
      paramInt = i;
      if (this.GWb != null) {
        paramInt = i + f.a.a.a.lI(22, this.GWb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.amF(23) + f.a.a.b.b.a.amF(26) + f.a.a.b.b.a.amF(27) + f.a.a.a.c(28, 8, this.GWf);
      paramInt = i;
      if (this.Djb != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.Djb);
      }
      i = paramInt;
      if (this.Djc != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Djc);
      }
      i += f.a.a.b.b.a.amF(31);
      paramInt = i;
      if (this.GWh != null) {
        paramInt = i + f.a.a.a.lI(32, this.GWh.computeSize());
      }
      AppMethodBeat.o(91510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GWa.clear();
        this.GWf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bht localbht = (bht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
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
            localbht.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localbht.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localbht.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localbht.GVK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localbht.GVL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localbht.GVM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localbht.GVN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localbht.GVO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localbht.GVP = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localbht.GVQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localbht.GVR = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localbht.GVS = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localbht.GVT = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localbht.GVU = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localbht.GVV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localbht.GVW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localbht.GVX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localbht.GVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localbht.GVZ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localbht.GWa.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localbht.Dgp = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bst();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bst)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbht.GWb = ((bst)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localbht.GWc = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localbht.GWd = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localbht.GWe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbht.GWf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localbht.Djb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localbht.Djc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 31: 
          localbht.GWg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new din();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((din)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbht.GWh = ((din)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bht
 * JD-Core Version:    0.7.0.1
 */