package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgi
  extends cld
{
  public LinkedList<bgj> DEf;
  public cai DEg;
  public clp DEh;
  public boolean DEi;
  public ih DEj;
  public int ntx;
  public String nty;
  
  public bgi()
  {
    AppMethodBeat.i(72502);
    this.DEf = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.e(4, 8, this.DEf);
      if (this.DEg != null)
      {
        paramVarArgs.kX(5, this.DEg.computeSize());
        this.DEg.writeFields(paramVarArgs);
      }
      if (this.DEh != null)
      {
        paramVarArgs.kX(6, this.DEh.computeSize());
        this.DEh.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(7, this.DEi);
      if (this.DEj != null)
      {
        paramVarArgs.kX(8, this.DEj.computeSize());
        this.DEj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.DEf);
      paramInt = i;
      if (this.DEg != null) {
        paramInt = i + f.a.a.a.kW(5, this.DEg.computeSize());
      }
      i = paramInt;
      if (this.DEh != null) {
        i = paramInt + f.a.a.a.kW(6, this.DEh.computeSize());
      }
      i += f.a.a.b.b.a.fY(7) + 1;
      paramInt = i;
      if (this.DEj != null) {
        paramInt = i + f.a.a.a.kW(8, this.DEj.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DEf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgi localbgi = (bgi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
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
            localbgi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localbgi.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localbgi.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgi.DEf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgi.DEg = ((cai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgi.DEh = ((clp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localbgi.DEi = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ih();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgi.DEj = ((ih)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      AppMethodBeat.o(72503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgi
 * JD-Core Version:    0.7.0.1
 */