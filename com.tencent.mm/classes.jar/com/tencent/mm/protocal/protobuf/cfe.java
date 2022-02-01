package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfe
  extends cld
{
  public LinkedList<j> Csn;
  public cqo Ebt;
  public l Ebu;
  public long dEb;
  public int dcG;
  public String iaB;
  public String iaw;
  public String iay;
  public String iaz;
  public String nTK;
  
  public cfe()
  {
    AppMethodBeat.i(91649);
    this.dcG = 268513600;
    this.nTK = "请求不成功，请稍候再试";
    this.Csn = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.aG(4, this.dEb);
      if (this.iaw != null) {
        paramVarArgs.d(5, this.iaw);
      }
      paramVarArgs.e(6, 8, this.Csn);
      if (this.iay != null) {
        paramVarArgs.d(7, this.iay);
      }
      if (this.iaz != null) {
        paramVarArgs.d(8, this.iaz);
      }
      if (this.Ebt != null)
      {
        paramVarArgs.kX(9, this.Ebt.computeSize());
        this.Ebt.writeFields(paramVarArgs);
      }
      if (this.iaB != null) {
        paramVarArgs.d(10, this.iaB);
      }
      if (this.Ebu != null)
      {
        paramVarArgs.kX(11, this.Ebu.computeSize());
        this.Ebu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.b.b.a.q(4, this.dEb);
      paramInt = i;
      if (this.iaw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iaw);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.Csn);
      paramInt = i;
      if (this.iay != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iay);
      }
      i = paramInt;
      if (this.iaz != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iaz);
      }
      paramInt = i;
      if (this.Ebt != null) {
        paramInt = i + f.a.a.a.kW(9, this.Ebt.computeSize());
      }
      i = paramInt;
      if (this.iaB != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iaB);
      }
      paramInt = i;
      if (this.Ebu != null) {
        paramInt = i + f.a.a.a.kW(11, this.Ebu.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Csn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91650);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfe localcfe = (cfe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
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
            localcfe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localcfe.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localcfe.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localcfe.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localcfe.iaw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfe.Csn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localcfe.iay = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localcfe.iaz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfe.Ebt = ((cqo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localcfe.iaB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfe.Ebu = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      AppMethodBeat.o(91650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfe
 * JD-Core Version:    0.7.0.1
 */