package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cfz
  extends dyy
{
  public String CMB;
  public String CNP;
  public int TmR;
  public LinkedList<fgv> TmS;
  public String Tnh;
  public String Tni;
  public String Tnj;
  public String Tnk;
  public String Tnl;
  public String Tnm;
  public fhb Tnn;
  public String Tno;
  public String Tnp;
  public String Tnq;
  public String Tnr;
  public String Tns;
  public String fwr;
  
  public cfz()
  {
    AppMethodBeat.i(32308);
    this.TmS = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tnh != null) {
        paramVarArgs.f(2, this.Tnh);
      }
      if (this.CNP != null) {
        paramVarArgs.f(3, this.CNP);
      }
      if (this.fwr != null) {
        paramVarArgs.f(4, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(5, this.CMB);
      }
      if (this.Tni != null) {
        paramVarArgs.f(6, this.Tni);
      }
      if (this.Tnj != null) {
        paramVarArgs.f(7, this.Tnj);
      }
      if (this.Tnk != null) {
        paramVarArgs.f(8, this.Tnk);
      }
      if (this.Tnl != null) {
        paramVarArgs.f(9, this.Tnl);
      }
      if (this.Tnm != null) {
        paramVarArgs.f(10, this.Tnm);
      }
      if (this.Tnn != null)
      {
        paramVarArgs.oE(11, this.Tnn.computeSize());
        this.Tnn.writeFields(paramVarArgs);
      }
      if (this.Tno != null) {
        paramVarArgs.f(12, this.Tno);
      }
      if (this.Tnp != null) {
        paramVarArgs.f(13, this.Tnp);
      }
      if (this.Tnq != null) {
        paramVarArgs.f(14, this.Tnq);
      }
      if (this.Tnr != null) {
        paramVarArgs.f(15, this.Tnr);
      }
      if (this.Tns != null) {
        paramVarArgs.f(16, this.Tns);
      }
      paramVarArgs.aY(17, this.TmR);
      paramVarArgs.e(18, 8, this.TmS);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1524;
      }
    }
    label1524:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tnh != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tnh);
      }
      i = paramInt;
      if (this.CNP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNP);
      }
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fwr);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMB);
      }
      paramInt = i;
      if (this.Tni != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tni);
      }
      i = paramInt;
      if (this.Tnj != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tnj);
      }
      paramInt = i;
      if (this.Tnk != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tnk);
      }
      i = paramInt;
      if (this.Tnl != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Tnl);
      }
      paramInt = i;
      if (this.Tnm != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Tnm);
      }
      i = paramInt;
      if (this.Tnn != null) {
        i = paramInt + g.a.a.a.oD(11, this.Tnn.computeSize());
      }
      paramInt = i;
      if (this.Tno != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Tno);
      }
      i = paramInt;
      if (this.Tnp != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.Tnp);
      }
      paramInt = i;
      if (this.Tnq != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Tnq);
      }
      i = paramInt;
      if (this.Tnr != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Tnr);
      }
      paramInt = i;
      if (this.Tns != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Tns);
      }
      i = g.a.a.b.b.a.bM(17, this.TmR);
      int j = g.a.a.a.c(18, 8, this.TmS);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TmS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
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
            localcfz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localcfz.Tnh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localcfz.CNP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localcfz.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localcfz.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localcfz.Tni = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localcfz.Tnj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localcfz.Tnk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localcfz.Tnl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localcfz.Tnm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhb)localObject2).parseFrom((byte[])localObject1);
            }
            localcfz.Tnn = ((fhb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localcfz.Tno = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localcfz.Tnp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localcfz.Tnq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localcfz.Tnr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localcfz.Tns = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localcfz.TmR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgv)localObject2).parseFrom((byte[])localObject1);
          }
          localcfz.TmS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */