package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffm
  extends esc
{
  public int IcW;
  public LinkedList<SnsObject> YMT;
  public int aaWr;
  public gol abCX;
  public String abDu;
  public int abDy;
  public ffb abDz;
  public int abFi;
  public int abFj;
  public LinkedList<ef> abFk;
  public int abFl;
  public LinkedList<emq> abFm;
  public int abFn;
  public LinkedList<ahv> abFo;
  public int abFp;
  public LinkedList<Long> abFq;
  public LinkedList<Integer> abFr;
  public gol abFs;
  
  public ffm()
  {
    AppMethodBeat.i(125828);
    this.YMT = new LinkedList();
    this.abFk = new LinkedList();
    this.abFm = new LinkedList();
    this.abFo = new LinkedList();
    this.abFq = new LinkedList();
    this.abFr = new LinkedList();
    AppMethodBeat.o(125828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125829);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bS(3, this.aaWr);
      paramVarArgs.e(4, 8, this.YMT);
      paramVarArgs.bS(5, this.abFi);
      paramVarArgs.bS(6, this.abDy);
      paramVarArgs.bS(7, this.IcW);
      if (this.abDz != null)
      {
        paramVarArgs.qD(8, this.abDz.computeSize());
        this.abDz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.abFj);
      paramVarArgs.e(10, 8, this.abFk);
      if (this.abCX != null)
      {
        paramVarArgs.qD(11, this.abCX.computeSize());
        this.abCX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.abFl);
      paramVarArgs.e(13, 8, this.abFm);
      paramVarArgs.bS(14, this.abFn);
      paramVarArgs.e(15, 8, this.abFo);
      paramVarArgs.bS(16, this.abFp);
      paramVarArgs.f(17, 3, this.abFq);
      paramVarArgs.f(18, 2, this.abFr);
      if (this.abFs != null)
      {
        paramVarArgs.qD(19, this.abFs.computeSize());
        this.abFs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1760;
      }
    }
    label1760:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aaWr) + i.a.a.a.c(4, 8, this.YMT) + i.a.a.b.b.a.cJ(5, this.abFi) + i.a.a.b.b.a.cJ(6, this.abDy) + i.a.a.b.b.a.cJ(7, this.IcW);
      paramInt = i;
      if (this.abDz != null) {
        paramInt = i + i.a.a.a.qC(8, this.abDz.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.abFj) + i.a.a.a.c(10, 8, this.abFk);
      paramInt = i;
      if (this.abCX != null) {
        paramInt = i + i.a.a.a.qC(11, this.abCX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.abFl) + i.a.a.a.c(13, 8, this.abFm) + i.a.a.b.b.a.cJ(14, this.abFn) + i.a.a.a.c(15, 8, this.abFo) + i.a.a.b.b.a.cJ(16, this.abFp) + i.a.a.a.d(17, 3, this.abFq) + i.a.a.a.d(18, 2, this.abFr);
      paramInt = i;
      if (this.abFs != null) {
        paramInt = i + i.a.a.a.qC(19, this.abFs.computeSize());
      }
      AppMethodBeat.o(125829);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMT.clear();
        this.abFk.clear();
        this.abFm.clear();
        this.abFo.clear();
        this.abFq.clear();
        this.abFr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffm localffm = (ffm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localffm.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localffm.aaWr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.YMT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localffm.abFi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localffm.abDy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localffm.IcW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffb)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.abDz = ((ffb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localffm.abFj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ef();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ef)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.abFk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localffm.abCX = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localffm.abFl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emq)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.abFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localffm.abFn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahv)localObject2).parseFrom((byte[])localObject1);
            }
            localffm.abFo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localffm.abFp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localffm.abFq = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFW();
          AppMethodBeat.o(125829);
          return 0;
        case 18: 
          localffm.abFr = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(125829);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localffm.abFs = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffm
 * JD-Core Version:    0.7.0.1
 */