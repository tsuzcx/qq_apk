package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dte
  extends cvw
{
  public String HIE;
  public int HYM;
  public int HYN;
  public String HYO;
  public int HYP;
  public String HYQ;
  public LinkedList<diu> HYR;
  public int HYS;
  public int HYT;
  public String cVh;
  public int cbX;
  public String dpB;
  public String hDU;
  
  public dte()
  {
    AppMethodBeat.i(116818);
    this.HYR = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cVh != null) {
        paramVarArgs.d(2, this.cVh);
      }
      if (this.dpB != null) {
        paramVarArgs.d(3, this.dpB);
      }
      paramVarArgs.aS(4, this.HYM);
      paramVarArgs.aS(5, this.HYN);
      paramVarArgs.aS(6, this.cbX);
      if (this.HYO != null) {
        paramVarArgs.d(7, this.HYO);
      }
      if (this.HIE != null) {
        paramVarArgs.d(8, this.HIE);
      }
      if (this.hDU != null) {
        paramVarArgs.d(9, this.hDU);
      }
      paramVarArgs.aS(10, this.HYP);
      if (this.HYQ != null) {
        paramVarArgs.d(11, this.HYQ);
      }
      paramVarArgs.e(12, 8, this.HYR);
      paramVarArgs.aS(13, this.HYS);
      paramVarArgs.aS(14, this.HYT);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cVh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cVh);
      }
      i = paramInt;
      if (this.dpB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dpB);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HYM) + f.a.a.b.b.a.bz(5, this.HYN) + f.a.a.b.b.a.bz(6, this.cbX);
      paramInt = i;
      if (this.HYO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HYO);
      }
      i = paramInt;
      if (this.HIE != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HIE);
      }
      paramInt = i;
      if (this.hDU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hDU);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HYP);
      paramInt = i;
      if (this.HYQ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HYQ);
      }
      i = f.a.a.a.c(12, 8, this.HYR);
      int j = f.a.a.b.b.a.bz(13, this.HYS);
      int k = f.a.a.b.b.a.bz(14, this.HYT);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HYR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dte localdte = (dte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdte.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localdte.cVh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localdte.dpB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localdte.HYM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localdte.HYN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localdte.cbX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localdte.HYO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localdte.HIE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localdte.hDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localdte.HYP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localdte.HYQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new diu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((diu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdte.HYR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localdte.HYS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116819);
          return 0;
        }
        localdte.HYT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dte
 * JD-Core Version:    0.7.0.1
 */