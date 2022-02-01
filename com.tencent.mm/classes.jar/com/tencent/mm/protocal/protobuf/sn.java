package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sn
  extends cqk
{
  public String Emu;
  public String Emv;
  public String Emw;
  public String Emx;
  public int dae;
  public String doP;
  public String oxf;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194010);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(194010);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.doP != null) {
        paramVarArgs.d(5, this.doP);
      }
      if (this.Emu != null) {
        paramVarArgs.d(6, this.Emu);
      }
      if (this.Emv != null) {
        paramVarArgs.d(7, this.Emv);
      }
      if (this.Emw != null) {
        paramVarArgs.d(8, this.Emw);
      }
      if (this.Emx != null) {
        paramVarArgs.d(9, this.Emx);
      }
      AppMethodBeat.o(194010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.doP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.doP);
      }
      i = paramInt;
      if (this.Emu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Emu);
      }
      paramInt = i;
      if (this.Emv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Emv);
      }
      i = paramInt;
      if (this.Emw != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Emw);
      }
      paramInt = i;
      if (this.Emx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Emx);
      }
      AppMethodBeat.o(194010);
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
          AppMethodBeat.o(194010);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sn localsn = (sn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194010);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194010);
          return 0;
        case 2: 
          localsn.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194010);
          return 0;
        case 3: 
          localsn.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        case 4: 
          localsn.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        case 5: 
          localsn.doP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        case 6: 
          localsn.Emu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        case 7: 
          localsn.Emv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        case 8: 
          localsn.Emw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194010);
          return 0;
        }
        localsn.Emx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(194010);
        return 0;
      }
      AppMethodBeat.o(194010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sn
 * JD-Core Version:    0.7.0.1
 */