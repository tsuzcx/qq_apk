package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blw
  extends cvp
{
  public efu FWe;
  public int GGc;
  public LinkedList<ehc> GGp;
  public ehc GGq;
  public String GGr;
  public int GGs;
  public String GGt;
  public String GGu;
  public String GGv;
  public String GGw;
  
  public blw()
  {
    AppMethodBeat.i(123594);
    this.GGp = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FWe != null)
      {
        paramVarArgs.lC(2, this.FWe.computeSize());
        this.FWe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GGp);
      if (this.GGq != null)
      {
        paramVarArgs.lC(4, this.GGq.computeSize());
        this.GGq.writeFields(paramVarArgs);
      }
      if (this.GGr != null) {
        paramVarArgs.d(5, this.GGr);
      }
      paramVarArgs.aS(6, this.GGs);
      if (this.GGt != null) {
        paramVarArgs.d(7, this.GGt);
      }
      if (this.GGu != null) {
        paramVarArgs.d(8, this.GGu);
      }
      if (this.GGv != null) {
        paramVarArgs.d(9, this.GGv);
      }
      if (this.GGw != null) {
        paramVarArgs.d(10, this.GGw);
      }
      paramVarArgs.aS(11, this.GGc);
      AppMethodBeat.o(123595);
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
      int i = paramInt;
      if (this.FWe != null) {
        i = paramInt + f.a.a.a.lB(2, this.FWe.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.GGp);
      paramInt = i;
      if (this.GGq != null) {
        paramInt = i + f.a.a.a.lB(4, this.GGq.computeSize());
      }
      i = paramInt;
      if (this.GGr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GGr);
      }
      i += f.a.a.b.b.a.bz(6, this.GGs);
      paramInt = i;
      if (this.GGt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GGt);
      }
      i = paramInt;
      if (this.GGu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GGu);
      }
      paramInt = i;
      if (this.GGv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GGv);
      }
      i = paramInt;
      if (this.GGw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GGw);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GGc);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blw localblw = (blw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localblw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblw.FWe = ((efu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblw.GGp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblw.GGq = ((ehc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localblw.GGr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localblw.GGs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localblw.GGt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localblw.GGu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localblw.GGv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localblw.GGw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localblw.GGc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blw
 * JD-Core Version:    0.7.0.1
 */