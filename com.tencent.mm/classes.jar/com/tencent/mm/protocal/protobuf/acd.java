package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class acd
  extends esc
{
  public String ZkD;
  public String data;
  public String dbg;
  public int status;
  public String tGK;
  public String tGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123566);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123566);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.status);
      if (this.tGK != null) {
        paramVarArgs.g(3, this.tGK);
      }
      if (this.dbg != null) {
        paramVarArgs.g(4, this.dbg);
      }
      if (this.ZkD != null) {
        paramVarArgs.g(5, this.ZkD);
      }
      if (this.tGL != null) {
        paramVarArgs.g(6, this.tGL);
      }
      if (this.data != null) {
        paramVarArgs.g(7, this.data);
      }
      AppMethodBeat.o(123566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.tGK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.tGK);
      }
      i = paramInt;
      if (this.dbg != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.dbg);
      }
      paramInt = i;
      if (this.ZkD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZkD);
      }
      i = paramInt;
      if (this.tGL != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.tGL);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.data);
      }
      AppMethodBeat.o(123566);
      return paramInt;
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        acd localacd = (acd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123566);
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
            localacd.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(123566);
          return 0;
        case 2: 
          localacd.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123566);
          return 0;
        case 3: 
          localacd.tGK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 4: 
          localacd.dbg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 5: 
          localacd.ZkD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 6: 
          localacd.tGL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123566);
          return 0;
        }
        localacd.data = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123566);
        return 0;
      }
      AppMethodBeat.o(123566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acd
 * JD-Core Version:    0.7.0.1
 */