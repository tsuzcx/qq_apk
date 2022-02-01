package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dra
  extends dyy
{
  public long SkV;
  public long SkW;
  public cjz Sra;
  public czw TXz;
  public esi TdE;
  public st TfL;
  public dzl Trs;
  public LinkedList<dje> fbZ;
  public int tqa;
  public String tqb;
  
  public dra()
  {
    AppMethodBeat.i(72560);
    this.fbZ = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.Sra != null)
      {
        paramVarArgs.oE(4, this.Sra.computeSize());
        this.Sra.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.fbZ);
      paramVarArgs.bm(6, this.SkV);
      paramVarArgs.bm(7, this.SkW);
      if (this.Trs != null)
      {
        paramVarArgs.oE(8, this.Trs.computeSize());
        this.Trs.writeFields(paramVarArgs);
      }
      if (this.TfL != null)
      {
        paramVarArgs.oE(9, this.TfL.computeSize());
        this.TfL.writeFields(paramVarArgs);
      }
      if (this.TdE != null)
      {
        paramVarArgs.oE(10, this.TdE.computeSize());
        this.TdE.writeFields(paramVarArgs);
      }
      if (this.TXz != null)
      {
        paramVarArgs.oE(11, this.TXz.computeSize());
        this.TXz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1316;
      }
    }
    label1316:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.Sra != null) {
        i = paramInt + g.a.a.a.oD(4, this.Sra.computeSize());
      }
      i = i + g.a.a.a.c(5, 8, this.fbZ) + g.a.a.b.b.a.p(6, this.SkV) + g.a.a.b.b.a.p(7, this.SkW);
      paramInt = i;
      if (this.Trs != null) {
        paramInt = i + g.a.a.a.oD(8, this.Trs.computeSize());
      }
      i = paramInt;
      if (this.TfL != null) {
        i = paramInt + g.a.a.a.oD(9, this.TfL.computeSize());
      }
      paramInt = i;
      if (this.TdE != null) {
        paramInt = i + g.a.a.a.oD(10, this.TdE.computeSize());
      }
      i = paramInt;
      if (this.TXz != null) {
        i = paramInt + g.a.a.a.oD(11, this.TXz.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fbZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dra localdra = (dra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localdra.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localdra.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localdra.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjz)localObject2).parseFrom((byte[])localObject1);
            }
            localdra.Sra = ((cjz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dje();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dje)localObject2).parseFrom((byte[])localObject1);
            }
            localdra.fbZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localdra.SkV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localdra.SkW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzl)localObject2).parseFrom((byte[])localObject1);
            }
            localdra.Trs = ((dzl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new st();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((st)localObject2).parseFrom((byte[])localObject1);
            }
            localdra.TfL = ((st)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esi)localObject2).parseFrom((byte[])localObject1);
            }
            localdra.TdE = ((esi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new czw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((czw)localObject2).parseFrom((byte[])localObject1);
          }
          localdra.TXz = ((czw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dra
 * JD-Core Version:    0.7.0.1
 */