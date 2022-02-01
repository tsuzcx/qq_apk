package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vw
  extends ckq
{
  public String CFH;
  public az CPi;
  public String CWf;
  public int CXV;
  public int CXW;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public int CXo;
  public int CXq;
  public String CXr;
  public int Cxp;
  public String hnC;
  public String mAQ;
  public String sdZ;
  public String yaF;
  public String yaG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.CXk != null) {
        paramVarArgs.d(3, this.CXk);
      }
      if (this.CFH != null) {
        paramVarArgs.d(4, this.CFH);
      }
      if (this.CXl != null) {
        paramVarArgs.d(5, this.CXl);
      }
      if (this.CXm != null) {
        paramVarArgs.d(6, this.CXm);
      }
      if (this.CXn != null) {
        paramVarArgs.d(7, this.CXn);
      }
      if (this.CWf != null) {
        paramVarArgs.d(8, this.CWf);
      }
      paramVarArgs.aR(9, this.CXo);
      if (this.CPi != null)
      {
        paramVarArgs.kX(10, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(11, this.mAQ);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(12, this.sdZ);
      }
      paramVarArgs.aR(13, this.Cxp);
      paramVarArgs.aR(14, this.CXV);
      if (this.yaF != null) {
        paramVarArgs.d(15, this.yaF);
      }
      if (this.yaG != null) {
        paramVarArgs.d(16, this.yaG);
      }
      paramVarArgs.aR(17, this.CXW);
      paramVarArgs.aR(18, this.CXq);
      if (this.CXr != null) {
        paramVarArgs.d(19, this.CXr);
      }
      AppMethodBeat.o(91418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1430;
      }
    }
    label1430:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.CXk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CXk);
      }
      paramInt = i;
      if (this.CFH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFH);
      }
      i = paramInt;
      if (this.CXl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXl);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXm);
      }
      i = paramInt;
      if (this.CXn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXn);
      }
      paramInt = i;
      if (this.CWf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWf);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.CXo);
      paramInt = i;
      if (this.CPi != null) {
        paramInt = i + f.a.a.a.kW(10, this.CPi.computeSize());
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.mAQ);
      }
      paramInt = i;
      if (this.sdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sdZ);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.Cxp) + f.a.a.b.b.a.bA(14, this.CXV);
      paramInt = i;
      if (this.yaF != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.yaF);
      }
      i = paramInt;
      if (this.yaG != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.yaG);
      }
      i = i + f.a.a.b.b.a.bA(17, this.CXW) + f.a.a.b.b.a.bA(18, this.CXq);
      paramInt = i;
      if (this.CXr != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.CXr);
      }
      AppMethodBeat.o(91418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vw localvw = (vw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91418);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 2: 
          localvw.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 3: 
          localvw.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 4: 
          localvw.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 5: 
          localvw.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 6: 
          localvw.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 7: 
          localvw.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 8: 
          localvw.CWf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 9: 
          localvw.CXo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91418);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvw.CPi = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 11: 
          localvw.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 12: 
          localvw.sdZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 13: 
          localvw.Cxp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91418);
          return 0;
        case 14: 
          localvw.CXV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91418);
          return 0;
        case 15: 
          localvw.yaF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 16: 
          localvw.yaG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 17: 
          localvw.CXW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91418);
          return 0;
        case 18: 
          localvw.CXq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91418);
          return 0;
        }
        localvw.CXr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91418);
        return 0;
      }
      AppMethodBeat.o(91418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vw
 * JD-Core Version:    0.7.0.1
 */