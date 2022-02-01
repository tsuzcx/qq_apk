package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class com
  extends cvp
{
  public long FWu;
  public long FWv;
  public cwb GJb;
  public bom Gbv;
  public dnn Gxg;
  public rs GyZ;
  public cbj Hht;
  public LinkedList<cio> cTn;
  public int ozR;
  public String ozS;
  
  public com()
  {
    AppMethodBeat.i(72560);
    this.cTn = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.Gbv != null)
      {
        paramVarArgs.lC(4, this.Gbv.computeSize());
        this.Gbv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.cTn);
      paramVarArgs.aY(6, this.FWu);
      paramVarArgs.aY(7, this.FWv);
      if (this.GJb != null)
      {
        paramVarArgs.lC(8, this.GJb.computeSize());
        this.GJb.writeFields(paramVarArgs);
      }
      if (this.GyZ != null)
      {
        paramVarArgs.lC(9, this.GyZ.computeSize());
        this.GyZ.writeFields(paramVarArgs);
      }
      if (this.Gxg != null)
      {
        paramVarArgs.lC(10, this.Gxg.computeSize());
        this.Gxg.writeFields(paramVarArgs);
      }
      if (this.Hht != null)
      {
        paramVarArgs.lC(11, this.Hht.computeSize());
        this.Hht.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.Gbv != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gbv.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.cTn) + f.a.a.b.b.a.p(6, this.FWu) + f.a.a.b.b.a.p(7, this.FWv);
      paramInt = i;
      if (this.GJb != null) {
        paramInt = i + f.a.a.a.lB(8, this.GJb.computeSize());
      }
      i = paramInt;
      if (this.GyZ != null) {
        i = paramInt + f.a.a.a.lB(9, this.GyZ.computeSize());
      }
      paramInt = i;
      if (this.Gxg != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gxg.computeSize());
      }
      i = paramInt;
      if (this.Hht != null) {
        i = paramInt + f.a.a.a.lB(11, this.Hht.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.cTn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        com localcom = (com)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localcom.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localcom.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localcom.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bom();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bom)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcom.Gbv = ((bom)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcom.cTn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localcom.FWu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localcom.FWv = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcom.GJb = ((cwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcom.GyZ = ((rs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcom.Gxg = ((dnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcom.Hht = ((cbj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.com
 * JD-Core Version:    0.7.0.1
 */