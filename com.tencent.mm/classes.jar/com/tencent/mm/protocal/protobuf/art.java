package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class art
  extends cvp
{
  public String GpR;
  public String GpS;
  public int GpT;
  public int GpU;
  public int GpV;
  public ama GpW;
  public int GpX;
  public LinkedList<FinderObject> GpY;
  public ash GpZ;
  public alm Gqa;
  public String Gqb;
  public arr Gqc;
  public String Gqd;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public arg rJv;
  public int saT;
  public aqn saW;
  public arq sba;
  
  public art()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.GpY = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.GpR != null) {
        paramVarArgs.d(4, this.GpR);
      }
      if (this.GpS != null) {
        paramVarArgs.d(5, this.GpS);
      }
      paramVarArgs.aS(6, this.saT);
      paramVarArgs.aS(7, this.GpT);
      paramVarArgs.aS(8, this.GpU);
      paramVarArgs.aS(9, this.GpV);
      if (this.saW != null)
      {
        paramVarArgs.lC(10, this.saW.computeSize());
        this.saW.writeFields(paramVarArgs);
      }
      if (this.GpW != null)
      {
        paramVarArgs.lC(11, this.GpW.computeSize());
        this.GpW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.GpX);
      paramVarArgs.e(13, 8, this.GpY);
      if (this.GpZ != null)
      {
        paramVarArgs.lC(14, this.GpZ.computeSize());
        this.GpZ.writeFields(paramVarArgs);
      }
      if (this.Gqa != null)
      {
        paramVarArgs.lC(15, this.Gqa.computeSize());
        this.Gqa.writeFields(paramVarArgs);
      }
      if (this.Gqb != null) {
        paramVarArgs.d(16, this.Gqb);
      }
      if (this.rJv != null)
      {
        paramVarArgs.lC(17, this.rJv.computeSize());
        this.rJv.writeFields(paramVarArgs);
      }
      if (this.Gqc != null)
      {
        paramVarArgs.lC(18, this.Gqc.computeSize());
        this.Gqc.writeFields(paramVarArgs);
      }
      if (this.sba != null)
      {
        paramVarArgs.lC(19, this.sba.computeSize());
        this.sba.writeFields(paramVarArgs);
      }
      if (this.Gqd != null) {
        paramVarArgs.d(20, this.Gqd);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2258;
      }
    }
    label2258:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.GpR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GpR);
      }
      paramInt = i;
      if (this.GpS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GpS);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.saT) + f.a.a.b.b.a.bz(7, this.GpT) + f.a.a.b.b.a.bz(8, this.GpU) + f.a.a.b.b.a.bz(9, this.GpV);
      paramInt = i;
      if (this.saW != null) {
        paramInt = i + f.a.a.a.lB(10, this.saW.computeSize());
      }
      i = paramInt;
      if (this.GpW != null) {
        i = paramInt + f.a.a.a.lB(11, this.GpW.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(12, this.GpX) + f.a.a.a.c(13, 8, this.GpY);
      paramInt = i;
      if (this.GpZ != null) {
        paramInt = i + f.a.a.a.lB(14, this.GpZ.computeSize());
      }
      i = paramInt;
      if (this.Gqa != null) {
        i = paramInt + f.a.a.a.lB(15, this.Gqa.computeSize());
      }
      paramInt = i;
      if (this.Gqb != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Gqb);
      }
      i = paramInt;
      if (this.rJv != null) {
        i = paramInt + f.a.a.a.lB(17, this.rJv.computeSize());
      }
      paramInt = i;
      if (this.Gqc != null) {
        paramInt = i + f.a.a.a.lB(18, this.Gqc.computeSize());
      }
      i = paramInt;
      if (this.sba != null) {
        i = paramInt + f.a.a.a.lB(19, this.sba.computeSize());
      }
      paramInt = i;
      if (this.Gqd != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.Gqd);
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.GpY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        art localart = (art)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
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
            localart.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localart.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localart.GpR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localart.GpS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localart.saT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localart.GpT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localart.GpU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localart.GpV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.saW = ((aqn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ama();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ama)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.GpW = ((ama)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localart.GpX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.GpY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ash();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ash)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.GpZ = ((ash)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.Gqa = ((alm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localart.Gqb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.rJv = ((arg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.Gqc = ((arr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localart.sba = ((arq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        localart.Gqd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.art
 * JD-Core Version:    0.7.0.1
 */