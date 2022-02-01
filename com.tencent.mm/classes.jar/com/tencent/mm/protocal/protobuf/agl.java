package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agl
  extends cqk
{
  public LinkedList<bog> Eng;
  public chn Eyt;
  public String Eyu;
  public String Eyv;
  public String Eyw;
  public String Eyx;
  public float Eyy;
  public String Eyz;
  public int qwx;
  public String qwy;
  
  public agl()
  {
    AppMethodBeat.i(104361);
    this.Eng = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Eng);
      if (this.Eyt != null)
      {
        paramVarArgs.ln(3, this.Eyt.computeSize());
        this.Eyt.writeFields(paramVarArgs);
      }
      if (this.Eyu != null) {
        paramVarArgs.d(4, this.Eyu);
      }
      if (this.Eyv != null) {
        paramVarArgs.d(5, this.Eyv);
      }
      if (this.Eyw != null) {
        paramVarArgs.d(6, this.Eyw);
      }
      if (this.Eyx != null) {
        paramVarArgs.d(7, this.Eyx);
      }
      paramVarArgs.x(8, this.Eyy);
      paramVarArgs.aR(9, this.qwx);
      if (this.qwy != null) {
        paramVarArgs.d(10, this.qwy);
      }
      if (this.Eyz != null) {
        paramVarArgs.d(11, this.Eyz);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1113;
      }
    }
    label1113:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Eng);
      paramInt = i;
      if (this.Eyt != null) {
        paramInt = i + f.a.a.a.lm(3, this.Eyt.computeSize());
      }
      i = paramInt;
      if (this.Eyu != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Eyu);
      }
      paramInt = i;
      if (this.Eyv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Eyv);
      }
      i = paramInt;
      if (this.Eyw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Eyw);
      }
      paramInt = i;
      if (this.Eyx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Eyx);
      }
      i = paramInt + (f.a.a.b.b.a.fK(8) + 4) + f.a.a.b.b.a.bx(9, this.qwx);
      paramInt = i;
      if (this.qwy != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qwy);
      }
      i = paramInt;
      if (this.Eyz != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Eyz);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eng.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agl localagl = (agl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
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
            localagl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bog();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bog)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagl.Eng.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagl.Eyt = ((chn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localagl.Eyu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localagl.Eyv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localagl.Eyw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localagl.Eyx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localagl.Eyy = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localagl.qwx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localagl.qwy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localagl.Eyz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agl
 * JD-Core Version:    0.7.0.1
 */