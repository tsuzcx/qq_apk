package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vg
  extends ckq
{
  public String CFH;
  public az CPi;
  public String CWf;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public int CXo;
  public String CXp;
  public int CXq;
  public String CXr;
  public int Cxp;
  public String hnC;
  public String mAQ;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
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
      if (this.CXp != null) {
        paramVarArgs.d(11, this.CXp);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(12, this.mAQ);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(13, this.sdZ);
      }
      paramVarArgs.aR(14, this.Cxp);
      paramVarArgs.aR(15, this.CXq);
      if (this.CXr != null) {
        paramVarArgs.d(16, this.CXr);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1278;
      }
    }
    label1278:
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
      if (this.CXp != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CXp);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.mAQ);
      }
      i = paramInt;
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.sdZ);
      }
      i = i + f.a.a.b.b.a.bA(14, this.Cxp) + f.a.a.b.b.a.bA(15, this.CXq);
      paramInt = i;
      if (this.CXr != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CXr);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vg localvg = (vg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
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
            localvg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localvg.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localvg.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localvg.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localvg.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localvg.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localvg.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localvg.CWf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localvg.CXo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91416);
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
            localvg.CPi = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localvg.CXp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localvg.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localvg.sdZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localvg.Cxp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localvg.CXq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91416);
          return 0;
        }
        localvg.CXr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */