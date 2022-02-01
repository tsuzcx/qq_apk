package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzi
  extends cld
{
  public String Aia;
  public dpx DVW;
  public dpu DVX;
  public dpq DVY;
  public dpv DVZ;
  public boolean DWa;
  public LinkedList<String> DWb;
  public dps DWc;
  public int dhR;
  public String dhS;
  public int tso;
  
  public bzi()
  {
    AppMethodBeat.i(91588);
    this.DWb = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dhR);
      if (this.dhS != null) {
        paramVarArgs.d(3, this.dhS);
      }
      if (this.DVW != null)
      {
        paramVarArgs.kX(4, this.DVW.computeSize());
        this.DVW.writeFields(paramVarArgs);
      }
      if (this.DVX != null)
      {
        paramVarArgs.kX(5, this.DVX.computeSize());
        this.DVX.writeFields(paramVarArgs);
      }
      if (this.DVY != null)
      {
        paramVarArgs.kX(6, this.DVY.computeSize());
        this.DVY.writeFields(paramVarArgs);
      }
      if (this.DVZ != null)
      {
        paramVarArgs.kX(7, this.DVZ.computeSize());
        this.DVZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.tso);
      paramVarArgs.bg(9, this.DWa);
      if (this.Aia != null) {
        paramVarArgs.d(10, this.Aia);
      }
      paramVarArgs.e(11, 1, this.DWb);
      if (this.DWc != null)
      {
        paramVarArgs.kX(12, this.DWc.computeSize());
        this.DWc.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dhR);
      paramInt = i;
      if (this.dhS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dhS);
      }
      i = paramInt;
      if (this.DVW != null) {
        i = paramInt + f.a.a.a.kW(4, this.DVW.computeSize());
      }
      paramInt = i;
      if (this.DVX != null) {
        paramInt = i + f.a.a.a.kW(5, this.DVX.computeSize());
      }
      i = paramInt;
      if (this.DVY != null) {
        i = paramInt + f.a.a.a.kW(6, this.DVY.computeSize());
      }
      paramInt = i;
      if (this.DVZ != null) {
        paramInt = i + f.a.a.a.kW(7, this.DVZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.tso) + (f.a.a.b.b.a.fY(9) + 1);
      paramInt = i;
      if (this.Aia != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Aia);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.DWb);
      paramInt = i;
      if (this.DWc != null) {
        paramInt = i + f.a.a.a.kW(12, this.DWc.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzi localbzi = (bzi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localbzi.dhR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localbzi.dhS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzi.DVW = ((dpx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzi.DVX = ((dpu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzi.DVY = ((dpq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzi.DVZ = ((dpv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localbzi.tso = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localbzi.DWa = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localbzi.Aia = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localbzi.DWb.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dps();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.DWc = ((dps)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzi
 * JD-Core Version:    0.7.0.1
 */