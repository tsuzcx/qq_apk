package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgz
  extends dyy
{
  public fne SkF;
  public String ToA;
  public int Tog;
  public LinkedList<fom> Tot;
  public fom Tou;
  public String Tov;
  public int Tow;
  public String Tox;
  public String Toy;
  public String Toz;
  
  public cgz()
  {
    AppMethodBeat.i(123594);
    this.Tot = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SkF != null)
      {
        paramVarArgs.oE(2, this.SkF.computeSize());
        this.SkF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Tot);
      if (this.Tou != null)
      {
        paramVarArgs.oE(4, this.Tou.computeSize());
        this.Tou.writeFields(paramVarArgs);
      }
      if (this.Tov != null) {
        paramVarArgs.f(5, this.Tov);
      }
      paramVarArgs.aY(6, this.Tow);
      if (this.Tox != null) {
        paramVarArgs.f(7, this.Tox);
      }
      if (this.Toy != null) {
        paramVarArgs.f(8, this.Toy);
      }
      if (this.Toz != null) {
        paramVarArgs.f(9, this.Toz);
      }
      if (this.ToA != null) {
        paramVarArgs.f(10, this.ToA);
      }
      paramVarArgs.aY(11, this.Tog);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SkF != null) {
        i = paramInt + g.a.a.a.oD(2, this.SkF.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.Tot);
      paramInt = i;
      if (this.Tou != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tou.computeSize());
      }
      i = paramInt;
      if (this.Tov != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tov);
      }
      i += g.a.a.b.b.a.bM(6, this.Tow);
      paramInt = i;
      if (this.Tox != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Tox);
      }
      i = paramInt;
      if (this.Toy != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Toy);
      }
      paramInt = i;
      if (this.Toz != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Toz);
      }
      i = paramInt;
      if (this.ToA != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ToA);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.Tog);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tot.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgz localcgz = (cgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localcgz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fne)localObject2).parseFrom((byte[])localObject1);
            }
            localcgz.SkF = ((fne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fom();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fom)localObject2).parseFrom((byte[])localObject1);
            }
            localcgz.Tot.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fom();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fom)localObject2).parseFrom((byte[])localObject1);
            }
            localcgz.Tou = ((fom)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localcgz.Tov = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localcgz.Tow = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localcgz.Tox = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localcgz.Toy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localcgz.Toz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localcgz.ToA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localcgz.Tog = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgz
 * JD-Core Version:    0.7.0.1
 */