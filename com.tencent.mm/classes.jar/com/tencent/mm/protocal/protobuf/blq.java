package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class blq
  extends dpc
{
  public String ID;
  public SKBuiltinBuffer_t KLU;
  public int KMC;
  public LinkedList<adi> KMD;
  public String KME;
  public String KMF;
  public String KMG;
  public int KMK;
  public String KML;
  public String KMM;
  public String LUt;
  public int Scene;
  public long oTS;
  public int oUv;
  
  public blq()
  {
    AppMethodBeat.i(32227);
    this.KMD = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.e(2, this.ID);
      }
      if (this.KLU != null)
      {
        paramVarArgs.ni(3, this.KLU.computeSize());
        this.KLU.writeFields(paramVarArgs);
      }
      if (this.KML != null) {
        paramVarArgs.e(4, this.KML);
      }
      if (this.KMM != null) {
        paramVarArgs.e(5, this.KMM);
      }
      paramVarArgs.aM(6, this.oUv);
      paramVarArgs.aM(7, this.KMC);
      paramVarArgs.e(8, 8, this.KMD);
      if (this.LUt != null) {
        paramVarArgs.e(9, this.LUt);
      }
      if (this.KME != null) {
        paramVarArgs.e(10, this.KME);
      }
      if (this.KMF != null) {
        paramVarArgs.e(11, this.KMF);
      }
      paramVarArgs.aM(12, this.KMK);
      paramVarArgs.aM(13, this.Scene);
      paramVarArgs.bb(14, this.oTS);
      if (this.KMG != null) {
        paramVarArgs.e(15, this.KMG);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ID);
      }
      i = paramInt;
      if (this.KLU != null) {
        i = paramInt + g.a.a.a.nh(3, this.KLU.computeSize());
      }
      paramInt = i;
      if (this.KML != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KML);
      }
      i = paramInt;
      if (this.KMM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KMM);
      }
      i = i + g.a.a.b.b.a.bu(6, this.oUv) + g.a.a.b.b.a.bu(7, this.KMC) + g.a.a.a.c(8, 8, this.KMD);
      paramInt = i;
      if (this.LUt != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LUt);
      }
      i = paramInt;
      if (this.KME != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KME);
      }
      paramInt = i;
      if (this.KMF != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KMF);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.KMK) + g.a.a.b.b.a.bu(13, this.Scene) + g.a.a.b.b.a.r(14, this.oTS);
      paramInt = i;
      if (this.KMG != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KMG);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KMD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.KLU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        blq localblq = (blq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localblq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localblq.ID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblq.KLU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localblq.KML = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localblq.KMM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localblq.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localblq.KMC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblq.KMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localblq.LUt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localblq.KME = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localblq.KMF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localblq.KMK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localblq.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localblq.oTS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32228);
          return 0;
        }
        localblq.KMG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blq
 * JD-Core Version:    0.7.0.1
 */