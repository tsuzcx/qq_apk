package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adr
  extends cqk
{
  public cyu DTK;
  public bkh DYG;
  public oq DYH;
  public bxl DYI;
  public String Ewu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      if (this.DYH != null)
      {
        paramVarArgs.ln(3, this.DYH.computeSize());
        this.DYH.writeFields(paramVarArgs);
      }
      if (this.DYG != null)
      {
        paramVarArgs.ln(4, this.DYG.computeSize());
        this.DYG.writeFields(paramVarArgs);
      }
      if (this.DTK != null)
      {
        paramVarArgs.ln(5, this.DTK.computeSize());
        this.DTK.writeFields(paramVarArgs);
      }
      if (this.DYI != null)
      {
        paramVarArgs.ln(6, this.DYI.computeSize());
        this.DYI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ewu);
      }
      i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.a.lm(3, this.DYH.computeSize());
      }
      paramInt = i;
      if (this.DYG != null) {
        paramInt = i + f.a.a.a.lm(4, this.DYG.computeSize());
      }
      i = paramInt;
      if (this.DTK != null) {
        i = paramInt + f.a.a.a.lm(5, this.DTK.computeSize());
      }
      paramInt = i;
      if (this.DYI != null) {
        paramInt = i + f.a.a.a.lm(6, this.DYI.computeSize());
      }
      AppMethodBeat.o(155403);
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
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adr localadr = (adr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
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
            localadr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localadr.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadr.DYH = ((oq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadr.DYG = ((bkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadr.DTK = ((cyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadr.DYI = ((bxl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adr
 * JD-Core Version:    0.7.0.1
 */