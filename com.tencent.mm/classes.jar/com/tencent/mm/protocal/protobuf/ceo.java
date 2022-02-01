package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ceo
  extends cwj
{
  public String CON;
  public String COO;
  public String COP;
  public int COQ;
  public String COR;
  public String CPZ;
  public bws Hrl;
  public String Hrm;
  public ajt Hrn;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.Hrl != null)
      {
        paramVarArgs.lJ(4, this.Hrl.computeSize());
        this.Hrl.writeFields(paramVarArgs);
      }
      if (this.CON != null) {
        paramVarArgs.d(5, this.CON);
      }
      if (this.COO != null) {
        paramVarArgs.d(6, this.COO);
      }
      if (this.COP != null) {
        paramVarArgs.d(7, this.COP);
      }
      paramVarArgs.aS(8, this.COQ);
      if (this.COR != null) {
        paramVarArgs.d(9, this.COR);
      }
      if (this.Hrm != null) {
        paramVarArgs.d(10, this.Hrm);
      }
      if (this.Hrn != null)
      {
        paramVarArgs.lJ(11, this.Hrn.computeSize());
        this.Hrn.writeFields(paramVarArgs);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.Hrl != null) {
        i = paramInt + f.a.a.a.lI(4, this.Hrl.computeSize());
      }
      paramInt = i;
      if (this.CON != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CON);
      }
      i = paramInt;
      if (this.COO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.COO);
      }
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.COP);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.COQ);
      paramInt = i;
      if (this.COR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.COR);
      }
      i = paramInt;
      if (this.Hrm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hrm);
      }
      paramInt = i;
      if (this.Hrn != null) {
        paramInt = i + f.a.a.a.lI(11, this.Hrn.computeSize());
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91559);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceo localceo = (ceo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localceo.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localceo.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceo.Hrl = ((bws)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localceo.CON = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localceo.COO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localceo.COP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localceo.COQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localceo.COR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localceo.Hrm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceo.Hrn = ((ajt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localceo.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceo
 * JD-Core Version:    0.7.0.1
 */