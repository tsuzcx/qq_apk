package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cev
  extends dpc
{
  public String KFs;
  public cdz Mkb;
  public String Mke;
  public String Mkf;
  public String Mkg;
  public dy Mkh;
  public drb Mkq;
  public aeu Mkr;
  public boolean Mks;
  public eoq Mkt;
  public com.tencent.mm.bw.b oTm;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123619);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123619);
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
      if (this.oTm != null) {
        paramVarArgs.c(3, this.oTm);
      }
      if (this.Mkq != null)
      {
        paramVarArgs.ni(4, this.Mkq.computeSize());
        this.Mkq.writeFields(paramVarArgs);
      }
      if (this.xMq != null) {
        paramVarArgs.e(5, this.xMq);
      }
      if (this.KFs != null) {
        paramVarArgs.e(6, this.KFs);
      }
      if (this.Mkr != null)
      {
        paramVarArgs.ni(7, this.Mkr.computeSize());
        this.Mkr.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(8, this.Mks);
      if (this.Mke != null) {
        paramVarArgs.e(9, this.Mke);
      }
      if (this.Mkf != null) {
        paramVarArgs.e(10, this.Mkf);
      }
      if (this.Mkg != null) {
        paramVarArgs.e(11, this.Mkg);
      }
      if (this.Mkt != null)
      {
        paramVarArgs.ni(12, this.Mkt.computeSize());
        this.Mkt.writeFields(paramVarArgs);
      }
      if (this.Mkh != null)
      {
        paramVarArgs.ni(13, this.Mkh.computeSize());
        this.Mkh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mkb != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mkb.computeSize());
      }
      i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.oTm);
      }
      paramInt = i;
      if (this.Mkq != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mkq.computeSize());
      }
      i = paramInt;
      if (this.xMq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xMq);
      }
      paramInt = i;
      if (this.KFs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KFs);
      }
      i = paramInt;
      if (this.Mkr != null) {
        i = paramInt + g.a.a.a.nh(7, this.Mkr.computeSize());
      }
      i += g.a.a.b.b.a.fS(8) + 1;
      paramInt = i;
      if (this.Mke != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Mke);
      }
      i = paramInt;
      if (this.Mkf != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Mkf);
      }
      paramInt = i;
      if (this.Mkg != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Mkg);
      }
      i = paramInt;
      if (this.Mkt != null) {
        i = paramInt + g.a.a.a.nh(12, this.Mkt.computeSize());
      }
      paramInt = i;
      if (this.Mkh != null) {
        paramInt = i + g.a.a.a.nh(13, this.Mkh.computeSize());
      }
      AppMethodBeat.o(123619);
      return paramInt;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cev localcev = (cev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
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
            localcev.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
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
            localcev.Mkb = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localcev.oTm = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(123619);
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
            localcev.Mkq = ((drb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localcev.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localcev.KFs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcev.Mkr = ((aeu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localcev.Mks = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localcev.Mke = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localcev.Mkf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localcev.Mkg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eoq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eoq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcev.Mkt = ((eoq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcev.Mkh = ((dy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      AppMethodBeat.o(123619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cev
 * JD-Core Version:    0.7.0.1
 */