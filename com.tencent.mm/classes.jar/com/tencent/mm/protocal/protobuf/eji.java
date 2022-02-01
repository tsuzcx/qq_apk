package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eji
  extends com.tencent.mm.cd.a
{
  public int Cqs;
  public int CreateTime;
  public int IsNotRichText;
  public dwf RJc;
  public String Svt;
  public String TWw;
  public String Ulk;
  public String Ull;
  public int Ulm;
  public int Uln;
  public long Ulo;
  public long Ulp;
  public eae Ulq;
  public int Ulr;
  public LinkedList<eju> Uls;
  public int Ult;
  public String lpy;
  public int rWu;
  
  public eji()
  {
    AppMethodBeat.i(125770);
    this.Uls = new LinkedList();
    AppMethodBeat.o(125770);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125771);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TWw != null) {
        paramVarArgs.f(1, this.TWw);
      }
      if (this.Svt != null) {
        paramVarArgs.f(2, this.Svt);
      }
      if (this.Ulk != null) {
        paramVarArgs.f(3, this.Ulk);
      }
      if (this.Ull != null) {
        paramVarArgs.f(4, this.Ull);
      }
      paramVarArgs.aY(5, this.rWu);
      paramVarArgs.aY(6, this.Cqs);
      paramVarArgs.aY(7, this.CreateTime);
      if (this.lpy != null) {
        paramVarArgs.f(8, this.lpy);
      }
      paramVarArgs.aY(9, this.Ulm);
      paramVarArgs.aY(10, this.Uln);
      paramVarArgs.aY(11, this.IsNotRichText);
      paramVarArgs.bm(12, this.Ulo);
      paramVarArgs.bm(13, this.Ulp);
      if (this.Ulq != null)
      {
        paramVarArgs.oE(14, this.Ulq.computeSize());
        this.Ulq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.Ulr);
      if (this.RJc != null)
      {
        paramVarArgs.oE(16, this.RJc.computeSize());
        this.RJc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.Uls);
      paramVarArgs.aY(18, this.Ult);
      AppMethodBeat.o(125771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TWw == null) {
        break label1296;
      }
    }
    label1296:
    for (int i = g.a.a.b.b.a.g(1, this.TWw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Svt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Svt);
      }
      i = paramInt;
      if (this.Ulk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ulk);
      }
      paramInt = i;
      if (this.Ull != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ull);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.rWu) + g.a.a.b.b.a.bM(6, this.Cqs) + g.a.a.b.b.a.bM(7, this.CreateTime);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Ulm) + g.a.a.b.b.a.bM(10, this.Uln) + g.a.a.b.b.a.bM(11, this.IsNotRichText) + g.a.a.b.b.a.p(12, this.Ulo) + g.a.a.b.b.a.p(13, this.Ulp);
      paramInt = i;
      if (this.Ulq != null) {
        paramInt = i + g.a.a.a.oD(14, this.Ulq.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.Ulr);
      paramInt = i;
      if (this.RJc != null) {
        paramInt = i + g.a.a.a.oD(16, this.RJc.computeSize());
      }
      i = g.a.a.a.c(17, 8, this.Uls);
      int j = g.a.a.b.b.a.bM(18, this.Ult);
      AppMethodBeat.o(125771);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uls.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eji localeji = (eji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125771);
          return -1;
        case 1: 
          localeji.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 2: 
          localeji.Svt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 3: 
          localeji.Ulk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 4: 
          localeji.Ull = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 5: 
          localeji.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 6: 
          localeji.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 7: 
          localeji.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 8: 
          localeji.lpy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125771);
          return 0;
        case 9: 
          localeji.Ulm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 10: 
          localeji.Uln = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 11: 
          localeji.IsNotRichText = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 12: 
          localeji.Ulo = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125771);
          return 0;
        case 13: 
          localeji.Ulp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125771);
          return 0;
        case 14: 
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
            localeji.Ulq = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 15: 
          localeji.Ulr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125771);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwf)localObject2).parseFrom((byte[])localObject1);
            }
            localeji.RJc = ((dwf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eju();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eju)localObject2).parseFrom((byte[])localObject1);
            }
            localeji.Uls.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125771);
          return 0;
        }
        localeji.Ult = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125771);
        return 0;
      }
      AppMethodBeat.o(125771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eji
 * JD-Core Version:    0.7.0.1
 */