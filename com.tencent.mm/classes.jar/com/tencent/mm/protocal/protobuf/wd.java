package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wd
  extends dyy
{
  public String IkZ;
  public String OMa;
  public int SiA;
  public LinkedList<Integer> SiB;
  public String SiC;
  public int SiD;
  public int SiE;
  public dtj Sih;
  public boolean Siy;
  public String Siz;
  public String desc;
  public int fwx;
  public String szv;
  public String tVo;
  public String tpM;
  
  public wd()
  {
    AppMethodBeat.i(72433);
    this.SiB = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      paramVarArgs.co(4, this.Siy);
      if (this.IkZ != null) {
        paramVarArgs.f(5, this.IkZ);
      }
      if (this.Siz != null) {
        paramVarArgs.f(6, this.Siz);
      }
      if (this.szv != null) {
        paramVarArgs.f(7, this.szv);
      }
      paramVarArgs.aY(8, this.SiA);
      if (this.desc != null) {
        paramVarArgs.f(9, this.desc);
      }
      if (this.OMa != null) {
        paramVarArgs.f(10, this.OMa);
      }
      paramVarArgs.e(11, 2, this.SiB);
      if (this.SiC != null) {
        paramVarArgs.f(12, this.SiC);
      }
      if (this.tpM != null) {
        paramVarArgs.f(13, this.tpM);
      }
      paramVarArgs.aY(14, this.SiD);
      paramVarArgs.aY(15, this.SiE);
      if (this.Sih != null)
      {
        paramVarArgs.oE(16, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1249;
      }
    }
    label1249:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.IkZ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.IkZ);
      }
      i = paramInt;
      if (this.Siz != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Siz);
      }
      paramInt = i;
      if (this.szv != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.szv);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.SiA);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.desc);
      }
      i = paramInt;
      if (this.OMa != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.OMa);
      }
      i += g.a.a.a.c(11, 2, this.SiB);
      paramInt = i;
      if (this.SiC != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SiC);
      }
      i = paramInt;
      if (this.tpM != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.tpM);
      }
      i = i + g.a.a.b.b.a.bM(14, this.SiD) + g.a.a.b.b.a.bM(15, this.SiE);
      paramInt = i;
      if (this.Sih != null) {
        paramInt = i + g.a.a.a.oD(16, this.Sih.computeSize());
      }
      AppMethodBeat.o(72434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SiB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wd localwd = (wd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
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
            localwd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localwd.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localwd.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localwd.Siy = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localwd.IkZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localwd.Siz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localwd.szv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localwd.SiA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localwd.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localwd.OMa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localwd.SiB.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localwd.SiC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localwd.tpM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localwd.SiD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localwd.SiE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72434);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtj)localObject2).parseFrom((byte[])localObject1);
          }
          localwd.Sih = ((dtj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wd
 * JD-Core Version:    0.7.0.1
 */