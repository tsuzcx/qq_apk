package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjr
  extends esc
{
  public String Zji;
  public com.tencent.mm.bx.b aasm;
  public float aasn;
  public String aaso;
  public long aasp;
  public String action_data;
  public String color_data;
  public String person_id;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.person_id != null) {
        paramVarArgs.g(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.g(5, this.action_data);
      }
      paramVarArgs.l(6, this.aasn);
      if (this.Zji != null) {
        paramVarArgs.g(7, this.Zji);
      }
      if (this.aaso != null) {
        paramVarArgs.g(8, this.aaso);
      }
      if (this.color_data != null) {
        paramVarArgs.g(9, this.color_data);
      }
      if (this.aasm != null) {
        paramVarArgs.d(10, this.aasm);
      }
      paramVarArgs.bv(11, this.aasp);
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label899;
      }
    }
    label899:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.action_data);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.Zji != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zji);
      }
      i = paramInt;
      if (this.aaso != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaso);
      }
      paramInt = i;
      if (this.color_data != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.color_data);
      }
      i = paramInt;
      if (this.aasm != null) {
        i = paramInt + i.a.a.b.b.a.c(10, this.aasm);
      }
      paramInt = i.a.a.b.b.a.q(11, this.aasp);
      AppMethodBeat.o(104370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjr localcjr = (cjr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcjr.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localcjr.wuz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localcjr.wuA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localcjr.person_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localcjr.action_data = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localcjr.aasn = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localcjr.Zji = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 8: 
          localcjr.aaso = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 9: 
          localcjr.color_data = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 10: 
          localcjr.aasm = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(104370);
          return 0;
        }
        localcjr.aasp = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjr
 * JD-Core Version:    0.7.0.1
 */