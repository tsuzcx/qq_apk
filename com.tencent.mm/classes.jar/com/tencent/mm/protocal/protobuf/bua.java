package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bua
  extends cwj
{
  public btw Hhj;
  public xi Hhk;
  public ehs Hhl;
  public cod Hhm;
  public bd Hhn;
  public chb Hho;
  public String dwb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123625);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123625);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hhj != null)
      {
        paramVarArgs.lJ(2, this.Hhj.computeSize());
        this.Hhj.writeFields(paramVarArgs);
      }
      if (this.Hhk != null)
      {
        paramVarArgs.lJ(3, this.Hhk.computeSize());
        this.Hhk.writeFields(paramVarArgs);
      }
      if (this.Hhl != null)
      {
        paramVarArgs.lJ(4, this.Hhl.computeSize());
        this.Hhl.writeFields(paramVarArgs);
      }
      if (this.Hhm != null)
      {
        paramVarArgs.lJ(5, this.Hhm.computeSize());
        this.Hhm.writeFields(paramVarArgs);
      }
      if (this.Hhn != null)
      {
        paramVarArgs.lJ(6, this.Hhn.computeSize());
        this.Hhn.writeFields(paramVarArgs);
      }
      if (this.Hho != null)
      {
        paramVarArgs.lJ(7, this.Hho.computeSize());
        this.Hho.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(8, this.dwb);
      }
      AppMethodBeat.o(123625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1350;
      }
    }
    label1350:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hhj != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hhj.computeSize());
      }
      i = paramInt;
      if (this.Hhk != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hhk.computeSize());
      }
      paramInt = i;
      if (this.Hhl != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hhl.computeSize());
      }
      i = paramInt;
      if (this.Hhm != null) {
        i = paramInt + f.a.a.a.lI(5, this.Hhm.computeSize());
      }
      paramInt = i;
      if (this.Hhn != null) {
        paramInt = i + f.a.a.a.lI(6, this.Hhn.computeSize());
      }
      i = paramInt;
      if (this.Hho != null) {
        i = paramInt + f.a.a.a.lI(7, this.Hho.computeSize());
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dwb);
      }
      AppMethodBeat.o(123625);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bua localbua = (bua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hhj = ((btw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hhk = ((xi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hhl = ((ehs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hhm = ((cod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hhn = ((bd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbua.Hho = ((chb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        }
        localbua.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bua
 * JD-Core Version:    0.7.0.1
 */