package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bae
  extends cqk
{
  public int ENU;
  public ccw ERg;
  public ccx ERh;
  public ccx ERi;
  public int nWx;
  public String nWy;
  public int oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114033);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114033);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.oGs);
      paramVarArgs.aR(5, this.ENU);
      if (this.ERg != null)
      {
        paramVarArgs.ln(6, this.ERg.computeSize());
        this.ERg.writeFields(paramVarArgs);
      }
      if (this.ERh != null)
      {
        paramVarArgs.ln(7, this.ERh.computeSize());
        this.ERh.writeFields(paramVarArgs);
      }
      if (this.ERi != null)
      {
        paramVarArgs.ln(8, this.ERi.computeSize());
        this.ERi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.oGs) + f.a.a.b.b.a.bx(5, this.ENU);
      paramInt = i;
      if (this.ERg != null) {
        paramInt = i + f.a.a.a.lm(6, this.ERg.computeSize());
      }
      i = paramInt;
      if (this.ERh != null) {
        i = paramInt + f.a.a.a.lm(7, this.ERh.computeSize());
      }
      paramInt = i;
      if (this.ERi != null) {
        paramInt = i + f.a.a.a.lm(8, this.ERi.computeSize());
      }
      AppMethodBeat.o(114033);
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
          AppMethodBeat.o(114033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bae localbae = (bae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114033);
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
            localbae.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 2: 
          localbae.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114033);
          return 0;
        case 3: 
          localbae.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114033);
          return 0;
        case 4: 
          localbae.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114033);
          return 0;
        case 5: 
          localbae.ENU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114033);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbae.ERg = ((ccw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbae.ERh = ((ccx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbae.ERi = ((ccx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      AppMethodBeat.o(114033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bae
 * JD-Core Version:    0.7.0.1
 */