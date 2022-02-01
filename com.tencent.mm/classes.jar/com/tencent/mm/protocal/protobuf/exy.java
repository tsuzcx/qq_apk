package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exy
  extends dyl
{
  public int Crm;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eae Hnc;
  public eaf Uyf;
  public eaf Uyg;
  public int Uyh;
  public int Uyi;
  public int Uyj;
  public int Uyk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uyf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientMediaId");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.Uyg == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataMD5");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148659);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Uyf != null)
      {
        paramVarArgs.oE(2, this.Uyf.computeSize());
        this.Uyf.writeFields(paramVarArgs);
      }
      if (this.Uyg != null)
      {
        paramVarArgs.oE(3, this.Uyg.computeSize());
        this.Uyg.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.HmZ);
      paramVarArgs.aY(5, this.Hna);
      paramVarArgs.aY(6, this.Hnb);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(7, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.Crm);
      paramVarArgs.aY(9, this.Uyh);
      paramVarArgs.aY(10, this.Uyi);
      paramVarArgs.aY(11, this.Uyj);
      paramVarArgs.aY(12, this.Uyk);
      AppMethodBeat.o(148659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uyf != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uyf.computeSize());
      }
      i = paramInt;
      if (this.Uyg != null) {
        i = paramInt + g.a.a.a.oD(3, this.Uyg.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(4, this.HmZ) + g.a.a.b.b.a.bM(5, this.Hna) + g.a.a.b.b.a.bM(6, this.Hnb);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(7, this.Hnc.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.Crm);
      int j = g.a.a.b.b.a.bM(9, this.Uyh);
      int k = g.a.a.b.b.a.bM(10, this.Uyi);
      int m = g.a.a.b.b.a.bM(11, this.Uyj);
      int n = g.a.a.b.b.a.bM(12, this.Uyk);
      AppMethodBeat.o(148659);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uyf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientMediaId");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.Uyg == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataMD5");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148659);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exy localexy = (exy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148659);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localexy.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localexy.Uyf = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localexy.Uyg = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 4: 
          localexy.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 5: 
          localexy.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 6: 
          localexy.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 7: 
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
            localexy.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148659);
          return 0;
        case 8: 
          localexy.Crm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 9: 
          localexy.Uyh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 10: 
          localexy.Uyi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        case 11: 
          localexy.Uyj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148659);
          return 0;
        }
        localexy.Uyk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(148659);
        return 0;
      }
      AppMethodBeat.o(148659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exy
 * JD-Core Version:    0.7.0.1
 */