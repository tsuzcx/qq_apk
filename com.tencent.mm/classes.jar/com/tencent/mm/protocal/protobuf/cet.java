package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class cet
  extends dpc
{
  public String KCL;
  public String KCy;
  public String KFs;
  public LinkedList<drb> LRN;
  public cdz Mkb;
  public String Mkl;
  public String Mkm;
  public String Mkn;
  public int Mko;
  public String keb;
  public String xMq;
  
  public cet()
  {
    AppMethodBeat.i(123616);
    this.LRN = new LinkedList();
    AppMethodBeat.o(123616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123617);
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
      if (this.Mkm != null) {
        paramVarArgs.e(3, this.Mkm);
      }
      paramVarArgs.e(4, 8, this.LRN);
      if (this.xMq != null) {
        paramVarArgs.e(5, this.xMq);
      }
      if (this.KFs != null) {
        paramVarArgs.e(6, this.KFs);
      }
      if (this.KCL != null) {
        paramVarArgs.e(7, this.KCL);
      }
      if (this.KCy != null) {
        paramVarArgs.e(8, this.KCy);
      }
      if (this.Mkn != null) {
        paramVarArgs.e(9, this.Mkn);
      }
      paramVarArgs.aM(10, this.Mko);
      if (this.Mkl != null) {
        paramVarArgs.e(11, this.Mkl);
      }
      if (this.keb != null) {
        paramVarArgs.e(12, this.keb);
      }
      AppMethodBeat.o(123617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mkb != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mkb.computeSize());
      }
      i = paramInt;
      if (this.Mkm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mkm);
      }
      i += g.a.a.a.c(4, 8, this.LRN);
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xMq);
      }
      i = paramInt;
      if (this.KFs != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KFs);
      }
      paramInt = i;
      if (this.KCL != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KCL);
      }
      i = paramInt;
      if (this.KCy != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KCy);
      }
      paramInt = i;
      if (this.Mkn != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mkn);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.Mko);
      paramInt = i;
      if (this.Mkl != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Mkl);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.keb);
      }
      AppMethodBeat.o(123617);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cet localcet = (cet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123617);
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
            localcet.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
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
            localcet.Mkb = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 3: 
          localcet.Mkm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcet.LRN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 5: 
          localcet.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 6: 
          localcet.KFs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 7: 
          localcet.KCL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 8: 
          localcet.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 9: 
          localcet.Mkn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 10: 
          localcet.Mko = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123617);
          return 0;
        case 11: 
          localcet.Mkl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123617);
          return 0;
        }
        localcet.keb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123617);
        return 0;
      }
      AppMethodBeat.o(123617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cet
 * JD-Core Version:    0.7.0.1
 */