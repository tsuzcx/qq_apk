package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djy
  extends com.tencent.mm.cd.a
{
  public String GHz;
  public String Ine;
  public int TRs;
  public String TRt;
  public int TRu;
  public String TRv;
  public int TRw;
  public String TRx;
  public long TRy;
  public LinkedList<djn> TRz;
  public String TsB;
  public String des;
  
  public djy()
  {
    AppMethodBeat.i(91593);
    this.TRz = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TRs);
      if (this.TRt != null) {
        paramVarArgs.f(2, this.TRt);
      }
      if (this.TsB != null) {
        paramVarArgs.f(3, this.TsB);
      }
      paramVarArgs.aY(4, this.TRu);
      if (this.GHz != null) {
        paramVarArgs.f(5, this.GHz);
      }
      if (this.TRv != null) {
        paramVarArgs.f(6, this.TRv);
      }
      if (this.Ine != null) {
        paramVarArgs.f(7, this.Ine);
      }
      paramVarArgs.aY(8, this.TRw);
      if (this.des != null) {
        paramVarArgs.f(9, this.des);
      }
      if (this.TRx != null) {
        paramVarArgs.f(10, this.TRx);
      }
      paramVarArgs.bm(11, this.TRy);
      paramVarArgs.e(12, 8, this.TRz);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TRs) + 0;
      paramInt = i;
      if (this.TRt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TRt);
      }
      i = paramInt;
      if (this.TsB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TsB);
      }
      i += g.a.a.b.b.a.bM(4, this.TRu);
      paramInt = i;
      if (this.GHz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.GHz);
      }
      i = paramInt;
      if (this.TRv != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TRv);
      }
      paramInt = i;
      if (this.Ine != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Ine);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.TRw);
      paramInt = i;
      if (this.des != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.des);
      }
      i = paramInt;
      if (this.TRx != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TRx);
      }
      paramInt = g.a.a.b.b.a.p(11, this.TRy);
      int j = g.a.a.a.c(12, 8, this.TRz);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TRz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      djy localdjy = (djy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localdjy.TRs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localdjy.TRt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localdjy.TsB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localdjy.TRu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localdjy.GHz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localdjy.TRv = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localdjy.Ine = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localdjy.TRw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localdjy.des = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localdjy.TRx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localdjy.TRy = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        djn localdjn = new djn();
        if ((localObject != null) && (localObject.length > 0)) {
          localdjn.parseFrom((byte[])localObject);
        }
        localdjy.TRz.add(localdjn);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djy
 * JD-Core Version:    0.7.0.1
 */