package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eum
  extends dyy
{
  public String InV;
  public String InW;
  public String RDD;
  public dwg UvI;
  public String UvM;
  public String Uwb;
  public String Uwd;
  public int Uwe;
  public int Uwf;
  public dwg Uwg;
  public aai Uwh;
  public dwh Uwi;
  public String fHb;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72608);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.Uwe);
      if (this.UvI != null)
      {
        paramVarArgs.oE(5, this.UvI.computeSize());
        this.UvI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Uwf);
      if (this.Uwg != null)
      {
        paramVarArgs.oE(7, this.Uwg.computeSize());
        this.Uwg.writeFields(paramVarArgs);
      }
      if (this.Uwh != null)
      {
        paramVarArgs.oE(8, this.Uwh.computeSize());
        this.Uwh.writeFields(paramVarArgs);
      }
      if (this.Uwi != null)
      {
        paramVarArgs.oE(9, this.Uwi.computeSize());
        this.Uwi.writeFields(paramVarArgs);
      }
      if (this.fHb != null) {
        paramVarArgs.f(10, this.fHb);
      }
      if (this.RDD != null) {
        paramVarArgs.f(11, this.RDD);
      }
      if (this.InV != null) {
        paramVarArgs.f(12, this.InV);
      }
      if (this.Uwb != null) {
        paramVarArgs.f(13, this.Uwb);
      }
      if (this.InW != null) {
        paramVarArgs.f(14, this.InW);
      }
      if (this.Uwd != null) {
        paramVarArgs.f(15, this.Uwd);
      }
      if (this.UvM != null) {
        paramVarArgs.f(16, this.UvM);
      }
      AppMethodBeat.o(72608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1452;
      }
    }
    label1452:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Uwe);
      paramInt = i;
      if (this.UvI != null) {
        paramInt = i + g.a.a.a.oD(5, this.UvI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Uwf);
      paramInt = i;
      if (this.Uwg != null) {
        paramInt = i + g.a.a.a.oD(7, this.Uwg.computeSize());
      }
      i = paramInt;
      if (this.Uwh != null) {
        i = paramInt + g.a.a.a.oD(8, this.Uwh.computeSize());
      }
      paramInt = i;
      if (this.Uwi != null) {
        paramInt = i + g.a.a.a.oD(9, this.Uwi.computeSize());
      }
      i = paramInt;
      if (this.fHb != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.fHb);
      }
      paramInt = i;
      if (this.RDD != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RDD);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.InV);
      }
      paramInt = i;
      if (this.Uwb != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Uwb);
      }
      i = paramInt;
      if (this.InW != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.InW);
      }
      paramInt = i;
      if (this.Uwd != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.Uwd);
      }
      i = paramInt;
      if (this.UvM != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.UvM);
      }
      AppMethodBeat.o(72608);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eum localeum = (eum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72608);
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
            localeum.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 2: 
          localeum.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72608);
          return 0;
        case 3: 
          localeum.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 4: 
          localeum.Uwe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72608);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwg)localObject2).parseFrom((byte[])localObject1);
            }
            localeum.UvI = ((dwg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 6: 
          localeum.Uwf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72608);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwg)localObject2).parseFrom((byte[])localObject1);
            }
            localeum.Uwg = ((dwg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aai)localObject2).parseFrom((byte[])localObject1);
            }
            localeum.Uwh = ((aai)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwh)localObject2).parseFrom((byte[])localObject1);
            }
            localeum.Uwi = ((dwh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72608);
          return 0;
        case 10: 
          localeum.fHb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 11: 
          localeum.RDD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 12: 
          localeum.InV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 13: 
          localeum.Uwb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 14: 
          localeum.InW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        case 15: 
          localeum.Uwd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72608);
          return 0;
        }
        localeum.UvM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72608);
        return 0;
      }
      AppMethodBeat.o(72608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eum
 * JD-Core Version:    0.7.0.1
 */