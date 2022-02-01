package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhb
  extends dpc
{
  public String ANo;
  public ti MLA;
  public String MLB;
  public String MLC;
  public ejh MLD;
  public String MLy;
  public String MLz;
  public String dDj;
  public String iwv;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.MLy != null) {
        paramVarArgs.e(4, this.MLy);
      }
      if (this.iwv != null) {
        paramVarArgs.e(5, this.iwv);
      }
      if (this.MLz != null) {
        paramVarArgs.e(6, this.MLz);
      }
      if (this.MLA != null)
      {
        paramVarArgs.ni(7, this.MLA.computeSize());
        this.MLA.writeFields(paramVarArgs);
      }
      if (this.MLB != null) {
        paramVarArgs.e(8, this.MLB);
      }
      if (this.ANo != null) {
        paramVarArgs.e(9, this.ANo);
      }
      if (this.dDj != null) {
        paramVarArgs.e(10, this.dDj);
      }
      if (this.MLC != null) {
        paramVarArgs.e(11, this.MLC);
      }
      if (this.MLD != null)
      {
        paramVarArgs.ni(12, this.MLD.computeSize());
        this.MLD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MLy != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MLy);
      }
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iwv);
      }
      i = paramInt;
      if (this.MLz != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MLz);
      }
      paramInt = i;
      if (this.MLA != null) {
        paramInt = i + g.a.a.a.nh(7, this.MLA.computeSize());
      }
      i = paramInt;
      if (this.MLB != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MLB);
      }
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.ANo);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.dDj);
      }
      paramInt = i;
      if (this.MLC != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MLC);
      }
      i = paramInt;
      if (this.MLD != null) {
        i = paramInt + g.a.a.a.nh(12, this.MLD.computeSize());
      }
      AppMethodBeat.o(72556);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhb localdhb = (dhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localdhb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localdhb.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localdhb.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localdhb.MLy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localdhb.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localdhb.MLz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhb.MLA = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localdhb.MLB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localdhb.ANo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localdhb.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localdhb.MLC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdhb.MLD = ((ejh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */