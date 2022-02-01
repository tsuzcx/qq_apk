package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cep
  extends dpc
{
  public String KFs;
  public LinkedList<drb> LRN;
  public cdz Mkb;
  public String Mke;
  public String Mkf;
  public String Mkg;
  public dy Mkh;
  public com.tencent.mm.bw.b Mki;
  public String Mkj;
  public String xMq;
  
  public cep()
  {
    AppMethodBeat.i(123609);
    this.LRN = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mkb != null)
      {
        paramVarArgs.ni(2, this.Mkb.computeSize());
        this.Mkb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.LRN);
      if (this.xMq != null) {
        paramVarArgs.e(4, this.xMq);
      }
      if (this.KFs != null) {
        paramVarArgs.e(5, this.KFs);
      }
      if (this.Mke != null) {
        paramVarArgs.e(6, this.Mke);
      }
      if (this.Mkf != null) {
        paramVarArgs.e(7, this.Mkf);
      }
      if (this.Mkg != null) {
        paramVarArgs.e(8, this.Mkg);
      }
      if (this.Mkh != null)
      {
        paramVarArgs.ni(9, this.Mkh.computeSize());
        this.Mkh.writeFields(paramVarArgs);
      }
      if (this.Mki != null) {
        paramVarArgs.c(10, this.Mki);
      }
      if (this.Mkj != null) {
        paramVarArgs.e(11, this.Mkj);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1238;
      }
    }
    label1238:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mkb != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mkb.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.LRN);
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xMq);
      }
      i = paramInt;
      if (this.KFs != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KFs);
      }
      paramInt = i;
      if (this.Mke != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mke);
      }
      i = paramInt;
      if (this.Mkf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mkf);
      }
      paramInt = i;
      if (this.Mkg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mkg);
      }
      i = paramInt;
      if (this.Mkh != null) {
        i = paramInt + g.a.a.a.nh(9, this.Mkh.computeSize());
      }
      paramInt = i;
      if (this.Mki != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.Mki);
      }
      i = paramInt;
      if (this.Mkj != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Mkj);
      }
      AppMethodBeat.o(123610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LRN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cep localcep = (cep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcep.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcep.Mkb = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcep.LRN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localcep.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localcep.KFs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localcep.Mke = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localcep.Mkf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localcep.Mkg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcep.Mkh = ((dy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 10: 
          localcep.Mki = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(123610);
          return 0;
        }
        localcep.Mkj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cep
 * JD-Core Version:    0.7.0.1
 */