package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dah
  extends dpc
{
  public int HZp;
  public int MFA;
  public LinkedList<dye> MFB;
  public dak MFx;
  public czw MFy;
  public LinkedList<czv> MFz;
  public int rBL;
  public String rBM;
  
  public dah()
  {
    AppMethodBeat.i(91591);
    this.MFz = new LinkedList();
    this.MFB = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(3, this.rBM);
      }
      if (this.MFx != null)
      {
        paramVarArgs.ni(4, this.MFx.computeSize());
        this.MFx.writeFields(paramVarArgs);
      }
      if (this.MFy != null)
      {
        paramVarArgs.ni(5, this.MFy.computeSize());
        this.MFy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.MFz);
      paramVarArgs.aM(7, this.MFA);
      paramVarArgs.e(8, 8, this.MFB);
      paramVarArgs.aM(9, this.HZp);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1154;
      }
    }
    label1154:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBM);
      }
      i = paramInt;
      if (this.MFx != null) {
        i = paramInt + g.a.a.a.nh(4, this.MFx.computeSize());
      }
      paramInt = i;
      if (this.MFy != null) {
        paramInt = i + g.a.a.a.nh(5, this.MFy.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.MFz);
      int j = g.a.a.b.b.a.bu(7, this.MFA);
      int k = g.a.a.a.c(8, 8, this.MFB);
      int m = g.a.a.b.b.a.bu(9, this.HZp);
      AppMethodBeat.o(91592);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFz.clear();
        this.MFB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dah localdah = (dah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
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
            localdah.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localdah.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localdah.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dak();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dak)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdah.MFx = ((dak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdah.MFy = ((czw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdah.MFz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 7: 
          localdah.MFA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91592);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dye();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dye)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdah.MFB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localdah.HZp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dah
 * JD-Core Version:    0.7.0.1
 */