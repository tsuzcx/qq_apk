package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cph
  extends cvp
{
  public LinkedList<j> FpL;
  public dbh Hit;
  public l Hiu;
  public long dOa;
  public int dlw;
  public String iTJ;
  public String iTL;
  public String iTM;
  public String iTO;
  public String paA;
  
  public cph()
  {
    AppMethodBeat.i(91649);
    this.dlw = 268513600;
    this.paA = "请求不成功，请稍候再试";
    this.FpL = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.aY(4, this.dOa);
      if (this.iTJ != null) {
        paramVarArgs.d(5, this.iTJ);
      }
      paramVarArgs.e(6, 8, this.FpL);
      if (this.iTL != null) {
        paramVarArgs.d(7, this.iTL);
      }
      if (this.iTM != null) {
        paramVarArgs.d(8, this.iTM);
      }
      if (this.Hit != null)
      {
        paramVarArgs.lC(9, this.Hit.computeSize());
        this.Hit.writeFields(paramVarArgs);
      }
      if (this.iTO != null) {
        paramVarArgs.d(10, this.iTO);
      }
      if (this.Hiu != null)
      {
        paramVarArgs.lC(11, this.Hiu.computeSize());
        this.Hiu.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.dOa);
      paramInt = i;
      if (this.iTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iTJ);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.FpL);
      paramInt = i;
      if (this.iTL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iTL);
      }
      i = paramInt;
      if (this.iTM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iTM);
      }
      paramInt = i;
      if (this.Hit != null) {
        paramInt = i + f.a.a.a.lB(9, this.Hit.computeSize());
      }
      i = paramInt;
      if (this.iTO != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iTO);
      }
      paramInt = i;
      if (this.Hiu != null) {
        paramInt = i + f.a.a.a.lB(11, this.Hiu.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FpL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        cph localcph = (cph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcph.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localcph.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localcph.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localcph.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localcph.iTJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcph.FpL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localcph.iTL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localcph.iTM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcph.Hit = ((dbh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localcph.iTO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcph.Hiu = ((l)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cph
 * JD-Core Version:    0.7.0.1
 */