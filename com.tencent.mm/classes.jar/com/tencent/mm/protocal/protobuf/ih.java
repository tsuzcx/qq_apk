package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ih
  extends com.tencent.mm.bw.a
{
  public String Dmk;
  public String Dmm;
  public String Dmp;
  public String Dmq;
  public String FTA;
  public String FTB;
  public String FTC;
  public String FTD;
  public ii FTE;
  public cni FTF;
  public String FTp;
  public String FTq;
  public String FTr;
  public String FTs;
  public String FTt;
  public String FTu;
  public String FTv;
  public String FTw;
  public String FTx;
  public long FTy;
  public int FTz;
  public String dAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91351);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTp != null) {
        paramVarArgs.d(1, this.FTp);
      }
      if (this.FTq != null) {
        paramVarArgs.d(2, this.FTq);
      }
      if (this.FTr != null) {
        paramVarArgs.d(3, this.FTr);
      }
      if (this.FTs != null) {
        paramVarArgs.d(4, this.FTs);
      }
      if (this.FTt != null) {
        paramVarArgs.d(5, this.FTt);
      }
      if (this.FTu != null) {
        paramVarArgs.d(6, this.FTu);
      }
      if (this.FTv != null) {
        paramVarArgs.d(7, this.FTv);
      }
      if (this.FTw != null) {
        paramVarArgs.d(8, this.FTw);
      }
      if (this.dAs != null) {
        paramVarArgs.d(9, this.dAs);
      }
      if (this.FTx != null) {
        paramVarArgs.d(10, this.FTx);
      }
      if (this.Dmm != null) {
        paramVarArgs.d(11, this.Dmm);
      }
      if (this.Dmq != null) {
        paramVarArgs.d(12, this.Dmq);
      }
      if (this.Dmp != null) {
        paramVarArgs.d(13, this.Dmp);
      }
      paramVarArgs.aZ(14, this.FTy);
      paramVarArgs.aS(15, this.FTz);
      if (this.FTA != null) {
        paramVarArgs.d(16, this.FTA);
      }
      if (this.FTB != null) {
        paramVarArgs.d(17, this.FTB);
      }
      if (this.FTC != null) {
        paramVarArgs.d(18, this.FTC);
      }
      if (this.Dmk != null) {
        paramVarArgs.d(19, this.Dmk);
      }
      if (this.FTD != null) {
        paramVarArgs.d(20, this.FTD);
      }
      if (this.FTE != null)
      {
        paramVarArgs.lJ(21, this.FTE.computeSize());
        this.FTE.writeFields(paramVarArgs);
      }
      if (this.FTF != null)
      {
        paramVarArgs.lJ(23, this.FTF.computeSize());
        this.FTF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FTp == null) {
        break label1670;
      }
    }
    label1670:
    for (int i = f.a.a.b.b.a.e(1, this.FTp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FTq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FTq);
      }
      i = paramInt;
      if (this.FTr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTr);
      }
      paramInt = i;
      if (this.FTs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FTs);
      }
      i = paramInt;
      if (this.FTt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FTt);
      }
      paramInt = i;
      if (this.FTu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTu);
      }
      i = paramInt;
      if (this.FTv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FTv);
      }
      paramInt = i;
      if (this.FTw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FTw);
      }
      i = paramInt;
      if (this.dAs != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.dAs);
      }
      paramInt = i;
      if (this.FTx != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FTx);
      }
      i = paramInt;
      if (this.Dmm != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Dmm);
      }
      paramInt = i;
      if (this.Dmq != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Dmq);
      }
      i = paramInt;
      if (this.Dmp != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Dmp);
      }
      i = i + f.a.a.b.b.a.p(14, this.FTy) + f.a.a.b.b.a.bz(15, this.FTz);
      paramInt = i;
      if (this.FTA != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FTA);
      }
      i = paramInt;
      if (this.FTB != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FTB);
      }
      paramInt = i;
      if (this.FTC != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FTC);
      }
      i = paramInt;
      if (this.Dmk != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Dmk);
      }
      paramInt = i;
      if (this.FTD != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FTD);
      }
      i = paramInt;
      if (this.FTE != null) {
        i = paramInt + f.a.a.a.lI(21, this.FTE.computeSize());
      }
      paramInt = i;
      if (this.FTF != null) {
        paramInt = i + f.a.a.a.lI(23, this.FTF.computeSize());
      }
      AppMethodBeat.o(91351);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ih localih = (ih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 22: 
        default: 
          AppMethodBeat.o(91351);
          return -1;
        case 1: 
          localih.FTp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 2: 
          localih.FTq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 3: 
          localih.FTr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 4: 
          localih.FTs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 5: 
          localih.FTt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 6: 
          localih.FTu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 7: 
          localih.FTv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 8: 
          localih.FTw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 9: 
          localih.dAs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 10: 
          localih.FTx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 11: 
          localih.Dmm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 12: 
          localih.Dmq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 13: 
          localih.Dmp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 14: 
          localih.FTy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91351);
          return 0;
        case 15: 
          localih.FTz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91351);
          return 0;
        case 16: 
          localih.FTA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 17: 
          localih.FTB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 18: 
          localih.FTC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 19: 
          localih.Dmk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 20: 
          localih.FTD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localih.FTE = ((ii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91351);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cni();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.FTF = ((cni)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91351);
        return 0;
      }
      AppMethodBeat.o(91351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */