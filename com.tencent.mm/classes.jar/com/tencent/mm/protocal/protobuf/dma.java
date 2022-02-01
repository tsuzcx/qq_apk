package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dma
  extends com.tencent.mm.cd.a
{
  public dlt TSZ;
  public dmd TTa;
  public dmh TTb;
  public LinkedList<dme> TTc;
  public LinkedList<dlz> TTd;
  public LinkedList<dlx> TTe;
  public dmk TTf;
  public dlu TTg;
  public dmj TTh;
  public dmo TTi;
  public dls TTj;
  public LinkedList<dmm> TTk;
  public dme TTl;
  public LinkedList<dmi> TTm;
  public dmg TTn;
  public LinkedList<dmn> TTo;
  
  public dma()
  {
    AppMethodBeat.i(199285);
    this.TTc = new LinkedList();
    this.TTd = new LinkedList();
    this.TTe = new LinkedList();
    this.TTk = new LinkedList();
    this.TTm = new LinkedList();
    this.TTo = new LinkedList();
    AppMethodBeat.o(199285);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199301);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSZ != null)
      {
        paramVarArgs.oE(1, this.TSZ.computeSize());
        this.TSZ.writeFields(paramVarArgs);
      }
      if (this.TTa != null)
      {
        paramVarArgs.oE(2, this.TTa.computeSize());
        this.TTa.writeFields(paramVarArgs);
      }
      if (this.TTb != null)
      {
        paramVarArgs.oE(3, this.TTb.computeSize());
        this.TTb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.TTc);
      paramVarArgs.e(5, 8, this.TTd);
      paramVarArgs.e(6, 8, this.TTe);
      if (this.TTf != null)
      {
        paramVarArgs.oE(7, this.TTf.computeSize());
        this.TTf.writeFields(paramVarArgs);
      }
      if (this.TTg != null)
      {
        paramVarArgs.oE(8, this.TTg.computeSize());
        this.TTg.writeFields(paramVarArgs);
      }
      if (this.TTh != null)
      {
        paramVarArgs.oE(9, this.TTh.computeSize());
        this.TTh.writeFields(paramVarArgs);
      }
      if (this.TTi != null)
      {
        paramVarArgs.oE(10, this.TTi.computeSize());
        this.TTi.writeFields(paramVarArgs);
      }
      if (this.TTj != null)
      {
        paramVarArgs.oE(11, this.TTj.computeSize());
        this.TTj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 8, this.TTk);
      if (this.TTl != null)
      {
        paramVarArgs.oE(13, this.TTl.computeSize());
        this.TTl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(14, 8, this.TTm);
      if (this.TTn != null)
      {
        paramVarArgs.oE(15, this.TTn.computeSize());
        this.TTn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.TTo);
      AppMethodBeat.o(199301);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSZ == null) {
        break label2198;
      }
    }
    label2198:
    for (int i = g.a.a.a.oD(1, this.TSZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TTa != null) {
        paramInt = i + g.a.a.a.oD(2, this.TTa.computeSize());
      }
      i = paramInt;
      if (this.TTb != null) {
        i = paramInt + g.a.a.a.oD(3, this.TTb.computeSize());
      }
      i = i + g.a.a.a.c(4, 8, this.TTc) + g.a.a.a.c(5, 8, this.TTd) + g.a.a.a.c(6, 8, this.TTe);
      paramInt = i;
      if (this.TTf != null) {
        paramInt = i + g.a.a.a.oD(7, this.TTf.computeSize());
      }
      i = paramInt;
      if (this.TTg != null) {
        i = paramInt + g.a.a.a.oD(8, this.TTg.computeSize());
      }
      paramInt = i;
      if (this.TTh != null) {
        paramInt = i + g.a.a.a.oD(9, this.TTh.computeSize());
      }
      i = paramInt;
      if (this.TTi != null) {
        i = paramInt + g.a.a.a.oD(10, this.TTi.computeSize());
      }
      paramInt = i;
      if (this.TTj != null) {
        paramInt = i + g.a.a.a.oD(11, this.TTj.computeSize());
      }
      i = paramInt + g.a.a.a.c(12, 8, this.TTk);
      paramInt = i;
      if (this.TTl != null) {
        paramInt = i + g.a.a.a.oD(13, this.TTl.computeSize());
      }
      i = paramInt + g.a.a.a.c(14, 8, this.TTm);
      paramInt = i;
      if (this.TTn != null) {
        paramInt = i + g.a.a.a.oD(15, this.TTn.computeSize());
      }
      i = g.a.a.a.c(16, 8, this.TTo);
      AppMethodBeat.o(199301);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TTc.clear();
        this.TTd.clear();
        this.TTe.clear();
        this.TTk.clear();
        this.TTm.clear();
        this.TTo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199301);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dma localdma = (dma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199301);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlt)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TSZ = ((dlt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmd)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTa = ((dmd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmh)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTb = ((dmh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dme)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlz)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlx)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmk)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTf = ((dmk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlu)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTg = ((dlu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmj)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTh = ((dmj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmo)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTi = ((dmo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dls();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dls)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTj = ((dls)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmm)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dme)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTl = ((dme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmi)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmg)localObject2).parseFrom((byte[])localObject1);
            }
            localdma.TTn = ((dmg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199301);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmn)localObject2).parseFrom((byte[])localObject1);
          }
          localdma.TTo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199301);
        return 0;
      }
      AppMethodBeat.o(199301);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dma
 * JD-Core Version:    0.7.0.1
 */