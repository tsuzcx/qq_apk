package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bot
  extends cqk
{
  public bop Fef;
  public vg Feg;
  public dzx Feh;
  public cij Fei;
  public bd Fej;
  public cbq Fek;
  public String djj;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fef != null)
      {
        paramVarArgs.ln(2, this.Fef.computeSize());
        this.Fef.writeFields(paramVarArgs);
      }
      if (this.Feg != null)
      {
        paramVarArgs.ln(3, this.Feg.computeSize());
        this.Feg.writeFields(paramVarArgs);
      }
      if (this.Feh != null)
      {
        paramVarArgs.ln(4, this.Feh.computeSize());
        this.Feh.writeFields(paramVarArgs);
      }
      if (this.Fei != null)
      {
        paramVarArgs.ln(5, this.Fei.computeSize());
        this.Fei.writeFields(paramVarArgs);
      }
      if (this.Fej != null)
      {
        paramVarArgs.ln(6, this.Fej.computeSize());
        this.Fej.writeFields(paramVarArgs);
      }
      if (this.Fek != null)
      {
        paramVarArgs.ln(7, this.Fek.computeSize());
        this.Fek.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(8, this.djj);
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
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fef != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fef.computeSize());
      }
      i = paramInt;
      if (this.Feg != null) {
        i = paramInt + f.a.a.a.lm(3, this.Feg.computeSize());
      }
      paramInt = i;
      if (this.Feh != null) {
        paramInt = i + f.a.a.a.lm(4, this.Feh.computeSize());
      }
      i = paramInt;
      if (this.Fei != null) {
        i = paramInt + f.a.a.a.lm(5, this.Fei.computeSize());
      }
      paramInt = i;
      if (this.Fej != null) {
        paramInt = i + f.a.a.a.lm(6, this.Fej.computeSize());
      }
      i = paramInt;
      if (this.Fek != null) {
        i = paramInt + f.a.a.a.lm(7, this.Fek.computeSize());
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.djj);
      }
      AppMethodBeat.o(123625);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        bot localbot = (bot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bop();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Fef = ((bop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Feg = ((vg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Feh = ((dzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Fei = ((cij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Fej = ((bd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbot.Fek = ((cbq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        }
        localbot.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bot
 * JD-Core Version:    0.7.0.1
 */