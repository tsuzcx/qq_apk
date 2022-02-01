package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awg
  extends dyy
{
  public int SDr;
  public int SIA;
  public int SIB;
  public fhl SIC;
  public LinkedList<axc> SID;
  public int SIE;
  public long SIF;
  public bki SIG;
  public LinkedList<String> SIH;
  public String SII;
  public int SIJ;
  public LinkedList<FinderContact> SIy;
  public LinkedList<bkd> SIz;
  public eae SfI;
  public int continueFlag;
  public LinkedList<aqt> wqP;
  
  public awg()
  {
    AppMethodBeat.i(168998);
    this.SIy = new LinkedList();
    this.wqP = new LinkedList();
    this.SIz = new LinkedList();
    this.SID = new LinkedList();
    this.SIH = new LinkedList();
    AppMethodBeat.o(168998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168999);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SIy);
      if (this.SfI != null)
      {
        paramVarArgs.oE(3, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.wqP);
      paramVarArgs.aY(5, this.continueFlag);
      paramVarArgs.aY(6, this.SDr);
      paramVarArgs.e(7, 8, this.SIz);
      paramVarArgs.aY(8, this.SIA);
      paramVarArgs.aY(9, this.SIB);
      if (this.SIC != null)
      {
        paramVarArgs.oE(10, this.SIC.computeSize());
        this.SIC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.SID);
      paramVarArgs.aY(12, this.SIE);
      paramVarArgs.bm(13, this.SIF);
      if (this.SIG != null)
      {
        paramVarArgs.oE(14, this.SIG.computeSize());
        this.SIG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.SIH);
      if (this.SII != null) {
        paramVarArgs.f(16, this.SII);
      }
      paramVarArgs.aY(17, this.SIJ);
      AppMethodBeat.o(168999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SIy);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(3, this.SfI.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.wqP) + g.a.a.b.b.a.bM(5, this.continueFlag) + g.a.a.b.b.a.bM(6, this.SDr) + g.a.a.a.c(7, 8, this.SIz) + g.a.a.b.b.a.bM(8, this.SIA) + g.a.a.b.b.a.bM(9, this.SIB);
      paramInt = i;
      if (this.SIC != null) {
        paramInt = i + g.a.a.a.oD(10, this.SIC.computeSize());
      }
      i = paramInt + g.a.a.a.c(11, 8, this.SID) + g.a.a.b.b.a.bM(12, this.SIE) + g.a.a.b.b.a.p(13, this.SIF);
      paramInt = i;
      if (this.SIG != null) {
        paramInt = i + g.a.a.a.oD(14, this.SIG.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 1, this.SIH);
      paramInt = i;
      if (this.SII != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.SII);
      }
      i = g.a.a.b.b.a.bM(17, this.SIJ);
      AppMethodBeat.o(168999);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SIy.clear();
        this.wqP.clear();
        this.SIz.clear();
        this.SID.clear();
        this.SIH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awg localawg = (awg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168999);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.SIy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localawg.SfI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqt)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.wqP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 5: 
          localawg.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168999);
          return 0;
        case 6: 
          localawg.SDr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168999);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkd)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.SIz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 8: 
          localawg.SIA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168999);
          return 0;
        case 9: 
          localawg.SIB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168999);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhl)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.SIC = ((fhl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new axc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((axc)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.SID.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 12: 
          localawg.SIE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168999);
          return 0;
        case 13: 
          localawg.SIF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168999);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bki();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bki)localObject2).parseFrom((byte[])localObject1);
            }
            localawg.SIG = ((bki)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168999);
          return 0;
        case 15: 
          localawg.SIH.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(168999);
          return 0;
        case 16: 
          localawg.SII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168999);
          return 0;
        }
        localawg.SIJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168999);
        return 0;
      }
      AppMethodBeat.o(168999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awg
 * JD-Core Version:    0.7.0.1
 */