package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class caj
  extends dyy
{
  public String CMB;
  public String CMP;
  public eae RJA;
  public String RPP;
  public LinkedList<aji> RPm;
  public String SuR;
  public LinkedList<akh> Tek;
  public String TiM;
  
  public caj()
  {
    AppMethodBeat.i(104811);
    this.Tek = new LinkedList();
    this.RPm = new LinkedList();
    AppMethodBeat.o(104811);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.TiM == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.CMP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.CMB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.SuR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.RPP == null)
      {
        paramVarArgs = new b("Not all required fields were included: BizName");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.RJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104812);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TiM != null) {
        paramVarArgs.f(2, this.TiM);
      }
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.SuR != null) {
        paramVarArgs.f(5, this.SuR);
      }
      if (this.RPP != null) {
        paramVarArgs.f(6, this.RPP);
      }
      paramVarArgs.e(7, 8, this.Tek);
      if (this.RJA != null)
      {
        paramVarArgs.oE(8, this.RJA.computeSize());
        this.RJA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.RPm);
      AppMethodBeat.o(104812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1302;
      }
    }
    label1302:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TiM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TiM);
      }
      i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMP);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.SuR != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SuR);
      }
      paramInt = i;
      if (this.RPP != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RPP);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Tek);
      paramInt = i;
      if (this.RJA != null) {
        paramInt = i + g.a.a.a.oD(8, this.RJA.computeSize());
      }
      i = g.a.a.a.c(9, 8, this.RPm);
      AppMethodBeat.o(104812);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tek.clear();
        this.RPm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.TiM == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.CMP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.CMB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.SuR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.RPP == null)
        {
          paramVarArgs = new b("Not all required fields were included: BizName");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        if (this.RJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        caj localcaj = (caj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104812);
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
            localcaj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 2: 
          localcaj.TiM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 3: 
          localcaj.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 4: 
          localcaj.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 5: 
          localcaj.SuR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 6: 
          localcaj.RPP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104812);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akh)localObject2).parseFrom((byte[])localObject1);
            }
            localcaj.Tek.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        case 8: 
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
            localcaj.RJA = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104812);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aji();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aji)localObject2).parseFrom((byte[])localObject1);
          }
          localcaj.RPm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104812);
        return 0;
      }
      AppMethodBeat.o(104812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */