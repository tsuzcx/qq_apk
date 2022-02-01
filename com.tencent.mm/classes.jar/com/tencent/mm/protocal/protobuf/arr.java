package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arr
  extends dyy
{
  public int RUO;
  public bau SEJ;
  public int SEK;
  public bht SEL;
  public FinderObject SEM;
  public LinkedList<bda> SEN;
  public bda SEO;
  public LinkedList<ayj> SEP;
  public int SEQ;
  public int SER;
  public int SES;
  public int SET;
  public elx SEU;
  public ayk SEV;
  public bbu SEW;
  public int SEX;
  public LinkedList<bbt> SEY;
  public bbh live_notice_info;
  
  public arr()
  {
    AppMethodBeat.i(229742);
    this.SEN = new LinkedList();
    this.SEP = new LinkedList();
    this.SEY = new LinkedList();
    AppMethodBeat.o(229742);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229748);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SEJ != null)
      {
        paramVarArgs.oE(2, this.SEJ.computeSize());
        this.SEJ.writeFields(paramVarArgs);
      }
      if (this.live_notice_info != null)
      {
        paramVarArgs.oE(3, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.RUO);
      paramVarArgs.aY(5, this.SEK);
      if (this.SEL != null)
      {
        paramVarArgs.oE(6, this.SEL.computeSize());
        this.SEL.writeFields(paramVarArgs);
      }
      if (this.SEM != null)
      {
        paramVarArgs.oE(7, this.SEM.computeSize());
        this.SEM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.SEN);
      if (this.SEO != null)
      {
        paramVarArgs.oE(9, this.SEO.computeSize());
        this.SEO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.SEP);
      paramVarArgs.aY(11, this.SEQ);
      paramVarArgs.aY(12, this.SER);
      paramVarArgs.aY(13, this.SES);
      paramVarArgs.aY(14, this.SET);
      if (this.SEU != null)
      {
        paramVarArgs.oE(15, this.SEU.computeSize());
        this.SEU.writeFields(paramVarArgs);
      }
      if (this.SEV != null)
      {
        paramVarArgs.oE(18, this.SEV.computeSize());
        this.SEV.writeFields(paramVarArgs);
      }
      if (this.SEW != null)
      {
        paramVarArgs.oE(19, this.SEW.computeSize());
        this.SEW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(20, this.SEX);
      paramVarArgs.e(21, 8, this.SEY);
      AppMethodBeat.o(229748);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2034;
      }
    }
    label2034:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SEJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.SEJ.computeSize());
      }
      i = paramInt;
      if (this.live_notice_info != null) {
        i = paramInt + g.a.a.a.oD(3, this.live_notice_info.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(4, this.RUO) + g.a.a.b.b.a.bM(5, this.SEK);
      paramInt = i;
      if (this.SEL != null) {
        paramInt = i + g.a.a.a.oD(6, this.SEL.computeSize());
      }
      i = paramInt;
      if (this.SEM != null) {
        i = paramInt + g.a.a.a.oD(7, this.SEM.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.SEN);
      paramInt = i;
      if (this.SEO != null) {
        paramInt = i + g.a.a.a.oD(9, this.SEO.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.SEP) + g.a.a.b.b.a.bM(11, this.SEQ) + g.a.a.b.b.a.bM(12, this.SER) + g.a.a.b.b.a.bM(13, this.SES) + g.a.a.b.b.a.bM(14, this.SET);
      paramInt = i;
      if (this.SEU != null) {
        paramInt = i + g.a.a.a.oD(15, this.SEU.computeSize());
      }
      i = paramInt;
      if (this.SEV != null) {
        i = paramInt + g.a.a.a.oD(18, this.SEV.computeSize());
      }
      paramInt = i;
      if (this.SEW != null) {
        paramInt = i + g.a.a.a.oD(19, this.SEW.computeSize());
      }
      i = g.a.a.b.b.a.bM(20, this.SEX);
      int j = g.a.a.a.c(21, 8, this.SEY);
      AppMethodBeat.o(229748);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SEN.clear();
        this.SEP.clear();
        this.SEY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229748);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arr localarr = (arr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(229748);
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
            localarr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bau)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEJ = ((bau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbh)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.live_notice_info = ((bbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 4: 
          localarr.RUO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 5: 
          localarr.SEK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bht)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEL = ((bht)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEM = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bda();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bda)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bda();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bda)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEO = ((bda)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayj)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 11: 
          localarr.SEQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 12: 
          localarr.SER = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 13: 
          localarr.SES = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 14: 
          localarr.SET = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elx)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEU = ((elx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ayk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ayk)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEV = ((ayk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbu)localObject2).parseFrom((byte[])localObject1);
            }
            localarr.SEW = ((bbu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229748);
          return 0;
        case 20: 
          localarr.SEX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229748);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbt)localObject2).parseFrom((byte[])localObject1);
          }
          localarr.SEY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229748);
        return 0;
      }
      AppMethodBeat.o(229748);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arr
 * JD-Core Version:    0.7.0.1
 */