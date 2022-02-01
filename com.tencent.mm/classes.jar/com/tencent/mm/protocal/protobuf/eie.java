package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eie
  extends dyy
{
  public String TKZ;
  public String UfT;
  public hh Uil;
  public int Ukb;
  public hg Ukc;
  public LinkedList<hi> Ukd;
  public String Uke;
  public String Ukf;
  public hj Ukg;
  public LinkedList<hj> Ukh;
  public faw Uki;
  public boolean Ukj;
  public String Ukk;
  public hf Ukl;
  public String fAo;
  public String lnp;
  public String title;
  
  public eie()
  {
    AppMethodBeat.i(123652);
    this.Ukd = new LinkedList();
    this.Ukh = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Uil != null)
      {
        paramVarArgs.oE(2, this.Uil.computeSize());
        this.Uil.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Ukb);
      if (this.Ukc != null)
      {
        paramVarArgs.oE(4, this.Ukc.computeSize());
        this.Ukc.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      if (this.TKZ != null) {
        paramVarArgs.f(6, this.TKZ);
      }
      if (this.lnp != null) {
        paramVarArgs.f(7, this.lnp);
      }
      if (this.UfT != null) {
        paramVarArgs.f(8, this.UfT);
      }
      paramVarArgs.e(9, 8, this.Ukd);
      if (this.Uke != null) {
        paramVarArgs.f(10, this.Uke);
      }
      if (this.Ukf != null) {
        paramVarArgs.f(11, this.Ukf);
      }
      if (this.Ukg != null)
      {
        paramVarArgs.oE(12, this.Ukg.computeSize());
        this.Ukg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.Ukh);
      if (this.fAo != null) {
        paramVarArgs.f(14, this.fAo);
      }
      if (this.Uki != null)
      {
        paramVarArgs.oE(15, this.Uki.computeSize());
        this.Uki.writeFields(paramVarArgs);
      }
      paramVarArgs.co(16, this.Ukj);
      if (this.Ukk != null) {
        paramVarArgs.f(17, this.Ukk);
      }
      if (this.Ukl != null)
      {
        paramVarArgs.oE(19, this.Ukl.computeSize());
        this.Ukl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1830;
      }
    }
    label1830:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uil != null) {
        i = paramInt + g.a.a.a.oD(2, this.Uil.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.Ukb);
      paramInt = i;
      if (this.Ukc != null) {
        paramInt = i + g.a.a.a.oD(4, this.Ukc.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.title);
      }
      paramInt = i;
      if (this.TKZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TKZ);
      }
      i = paramInt;
      if (this.lnp != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lnp);
      }
      paramInt = i;
      if (this.UfT != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UfT);
      }
      i = paramInt + g.a.a.a.c(9, 8, this.Ukd);
      paramInt = i;
      if (this.Uke != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Uke);
      }
      i = paramInt;
      if (this.Ukf != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Ukf);
      }
      paramInt = i;
      if (this.Ukg != null) {
        paramInt = i + g.a.a.a.oD(12, this.Ukg.computeSize());
      }
      i = paramInt + g.a.a.a.c(13, 8, this.Ukh);
      paramInt = i;
      if (this.fAo != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.fAo);
      }
      i = paramInt;
      if (this.Uki != null) {
        i = paramInt + g.a.a.a.oD(15, this.Uki.computeSize());
      }
      i += g.a.a.b.b.a.gL(16) + 1;
      paramInt = i;
      if (this.Ukk != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Ukk);
      }
      i = paramInt;
      if (this.Ukl != null) {
        i = paramInt + g.a.a.a.oD(19, this.Ukl.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ukd.clear();
        this.Ukh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eie localeie = (eie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
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
            localeie.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hh)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Uil = ((hh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localeie.Ukb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hg)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Ukc = ((hg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localeie.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localeie.TKZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localeie.lnp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localeie.UfT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hi)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Ukd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localeie.Uke = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localeie.Ukf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hj)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Ukg = ((hj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hj)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Ukh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localeie.fAo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new faw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((faw)localObject2).parseFrom((byte[])localObject1);
            }
            localeie.Uki = ((faw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localeie.Ukj = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localeie.Ukk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((hf)localObject2).parseFrom((byte[])localObject1);
          }
          localeie.Ukl = ((hf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eie
 * JD-Core Version:    0.7.0.1
 */