package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsz
  extends dyy
{
  public int CPw;
  public String ID;
  public eae RMR;
  public String RNA;
  public int RNE;
  public String RNF;
  public String RNG;
  public int RNw;
  public LinkedList<adp> RNx;
  public String RNy;
  public String RNz;
  public String Tdb;
  public long rVQ;
  public int rWu;
  
  public bsz()
  {
    AppMethodBeat.i(32227);
    this.RNx = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.f(2, this.ID);
      }
      if (this.RMR != null)
      {
        paramVarArgs.oE(3, this.RMR.computeSize());
        this.RMR.writeFields(paramVarArgs);
      }
      if (this.RNF != null) {
        paramVarArgs.f(4, this.RNF);
      }
      if (this.RNG != null) {
        paramVarArgs.f(5, this.RNG);
      }
      paramVarArgs.aY(6, this.rWu);
      paramVarArgs.aY(7, this.RNw);
      paramVarArgs.e(8, 8, this.RNx);
      if (this.Tdb != null) {
        paramVarArgs.f(9, this.Tdb);
      }
      if (this.RNy != null) {
        paramVarArgs.f(10, this.RNy);
      }
      if (this.RNz != null) {
        paramVarArgs.f(11, this.RNz);
      }
      paramVarArgs.aY(12, this.RNE);
      paramVarArgs.aY(13, this.CPw);
      paramVarArgs.bm(14, this.rVQ);
      if (this.RNA != null) {
        paramVarArgs.f(15, this.RNA);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1313;
      }
    }
    label1313:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ID);
      }
      i = paramInt;
      if (this.RMR != null) {
        i = paramInt + g.a.a.a.oD(3, this.RMR.computeSize());
      }
      paramInt = i;
      if (this.RNF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RNF);
      }
      i = paramInt;
      if (this.RNG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RNG);
      }
      i = i + g.a.a.b.b.a.bM(6, this.rWu) + g.a.a.b.b.a.bM(7, this.RNw) + g.a.a.a.c(8, 8, this.RNx);
      paramInt = i;
      if (this.Tdb != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tdb);
      }
      i = paramInt;
      if (this.RNy != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RNy);
      }
      paramInt = i;
      if (this.RNz != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RNz);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.RNE) + g.a.a.b.b.a.bM(13, this.CPw) + g.a.a.b.b.a.p(14, this.rVQ);
      paramInt = i;
      if (this.RNA != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RNA);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.RMR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsz localbsz = (bsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localbsz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localbsz.ID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
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
            localbsz.RMR = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localbsz.RNF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localbsz.RNG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localbsz.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localbsz.RNw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adp)localObject2).parseFrom((byte[])localObject1);
            }
            localbsz.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localbsz.Tdb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localbsz.RNy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localbsz.RNz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localbsz.RNE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localbsz.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localbsz.rVQ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32228);
          return 0;
        }
        localbsz.RNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsz
 * JD-Core Version:    0.7.0.1
 */