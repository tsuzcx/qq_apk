package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class w
  extends cld
{
  public String CsB;
  public String CsF;
  public long CsG;
  public int CsH;
  public long CsI;
  public int CsJ;
  public int CsK;
  public int CsL;
  public int CsM;
  public long CsN;
  public long CsO;
  public long CsP;
  public int CsQ;
  public String CsR;
  public int CsS;
  public long CsT;
  public String Csi;
  public LinkedList<u> Csn;
  public String Csq;
  public String Csr;
  public int dcG;
  public String nTK;
  public int role;
  public int state;
  public String title;
  public int type;
  
  public w()
  {
    AppMethodBeat.i(91334);
    this.dcG = 268513600;
    this.nTK = "请求不成功，请稍候再试";
    this.Csn = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.Csi != null) {
        paramVarArgs.d(4, this.Csi);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.aR(6, this.type);
      if (this.CsF != null) {
        paramVarArgs.d(7, this.CsF);
      }
      paramVarArgs.aG(8, this.CsG);
      paramVarArgs.aR(9, this.CsH);
      paramVarArgs.aG(10, this.CsI);
      paramVarArgs.aR(11, this.CsJ);
      paramVarArgs.aR(12, this.state);
      paramVarArgs.aR(13, this.CsK);
      paramVarArgs.aR(14, this.CsL);
      paramVarArgs.aR(15, this.role);
      paramVarArgs.aR(16, this.CsM);
      paramVarArgs.aG(17, this.CsN);
      paramVarArgs.aG(18, this.CsO);
      paramVarArgs.aG(19, this.CsP);
      paramVarArgs.aR(20, this.CsQ);
      if (this.CsB != null) {
        paramVarArgs.d(21, this.CsB);
      }
      paramVarArgs.e(22, 8, this.Csn);
      if (this.CsR != null) {
        paramVarArgs.d(23, this.CsR);
      }
      paramVarArgs.aR(24, this.CsS);
      paramVarArgs.aG(25, this.CsT);
      if (this.Csq != null) {
        paramVarArgs.d(26, this.Csq);
      }
      if (this.Csr != null) {
        paramVarArgs.d(27, this.Csr);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.Csi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Csi);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.type);
      paramInt = i;
      if (this.CsF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CsF);
      }
      i = paramInt + f.a.a.b.b.a.q(8, this.CsG) + f.a.a.b.b.a.bA(9, this.CsH) + f.a.a.b.b.a.q(10, this.CsI) + f.a.a.b.b.a.bA(11, this.CsJ) + f.a.a.b.b.a.bA(12, this.state) + f.a.a.b.b.a.bA(13, this.CsK) + f.a.a.b.b.a.bA(14, this.CsL) + f.a.a.b.b.a.bA(15, this.role) + f.a.a.b.b.a.bA(16, this.CsM) + f.a.a.b.b.a.q(17, this.CsN) + f.a.a.b.b.a.q(18, this.CsO) + f.a.a.b.b.a.q(19, this.CsP) + f.a.a.b.b.a.bA(20, this.CsQ);
      paramInt = i;
      if (this.CsB != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CsB);
      }
      i = paramInt + f.a.a.a.c(22, 8, this.Csn);
      paramInt = i;
      if (this.CsR != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.CsR);
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.CsS) + f.a.a.b.b.a.q(25, this.CsT);
      paramInt = i;
      if (this.Csq != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Csq);
      }
      i = paramInt;
      if (this.Csr != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.Csr);
      }
      AppMethodBeat.o(91335);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Csn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localw.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localw.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localw.Csi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localw.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localw.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localw.CsF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localw.CsG = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localw.CsH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localw.CsI = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localw.CsJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localw.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localw.CsK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localw.CsL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localw.role = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localw.CsM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localw.CsN = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localw.CsO = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localw.CsP = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localw.CsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localw.CsB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.Csn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localw.CsR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localw.CsS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localw.CsT = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localw.Csq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91335);
          return 0;
        }
        localw.Csr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91335);
        return 0;
      }
      AppMethodBeat.o(91335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.w
 * JD-Core Version:    0.7.0.1
 */