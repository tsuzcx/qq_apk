package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class daf
  extends dpc
{
  public String IbC;
  public exm MFq;
  public exj MFr;
  public exd MFs;
  public exk MFt;
  public boolean MFu;
  public LinkedList<String> MFv;
  public exh MFw;
  public int dIZ;
  public String dJa;
  public int zjs;
  
  public daf()
  {
    AppMethodBeat.i(91588);
    this.MFv = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dIZ);
      if (this.dJa != null) {
        paramVarArgs.e(3, this.dJa);
      }
      if (this.MFq != null)
      {
        paramVarArgs.ni(4, this.MFq.computeSize());
        this.MFq.writeFields(paramVarArgs);
      }
      if (this.MFr != null)
      {
        paramVarArgs.ni(5, this.MFr.computeSize());
        this.MFr.writeFields(paramVarArgs);
      }
      if (this.MFs != null)
      {
        paramVarArgs.ni(6, this.MFs.computeSize());
        this.MFs.writeFields(paramVarArgs);
      }
      if (this.MFt != null)
      {
        paramVarArgs.ni(7, this.MFt.computeSize());
        this.MFt.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.zjs);
      paramVarArgs.cc(9, this.MFu);
      if (this.IbC != null) {
        paramVarArgs.e(10, this.IbC);
      }
      paramVarArgs.e(11, 1, this.MFv);
      if (this.MFw != null)
      {
        paramVarArgs.ni(12, this.MFw.computeSize());
        this.MFw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1450;
      }
    }
    label1450:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dIZ);
      paramInt = i;
      if (this.dJa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dJa);
      }
      i = paramInt;
      if (this.MFq != null) {
        i = paramInt + g.a.a.a.nh(4, this.MFq.computeSize());
      }
      paramInt = i;
      if (this.MFr != null) {
        paramInt = i + g.a.a.a.nh(5, this.MFr.computeSize());
      }
      i = paramInt;
      if (this.MFs != null) {
        i = paramInt + g.a.a.a.nh(6, this.MFs.computeSize());
      }
      paramInt = i;
      if (this.MFt != null) {
        paramInt = i + g.a.a.a.nh(7, this.MFt.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.zjs) + (g.a.a.b.b.a.fS(9) + 1);
      paramInt = i;
      if (this.IbC != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.IbC);
      }
      i = paramInt + g.a.a.a.c(11, 1, this.MFv);
      paramInt = i;
      if (this.MFw != null) {
        paramInt = i + g.a.a.a.nh(12, this.MFw.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        daf localdaf = (daf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
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
            localdaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localdaf.dIZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localdaf.dJa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdaf.MFq = ((exm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdaf.MFr = ((exj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdaf.MFs = ((exd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdaf.MFt = ((exk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localdaf.zjs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localdaf.MFu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localdaf.IbC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localdaf.MFv.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new exh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((exh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdaf.MFw = ((exh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daf
 * JD-Core Version:    0.7.0.1
 */