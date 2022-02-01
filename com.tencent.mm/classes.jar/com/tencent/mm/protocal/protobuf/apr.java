package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class apr
  extends esc
{
  public String UserName;
  public int YJz;
  public String muE;
  public int vhk;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259331);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259331);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.yth);
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      paramVarArgs.bS(4, this.vhk);
      paramVarArgs.bS(5, this.YJz);
      if (this.muE != null) {
        paramVarArgs.g(6, this.muE);
      }
      AppMethodBeat.o(259331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.yth);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.UserName);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.vhk) + i.a.a.b.b.a.cJ(5, this.YJz);
      paramInt = i;
      if (this.muE != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.muE);
      }
      AppMethodBeat.o(259331);
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
          AppMethodBeat.o(259331);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259331);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apr localapr = (apr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259331);
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
            localapr.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259331);
          return 0;
        case 2: 
          localapr.yth = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259331);
          return 0;
        case 3: 
          localapr.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259331);
          return 0;
        case 4: 
          localapr.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259331);
          return 0;
        case 5: 
          localapr.YJz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259331);
          return 0;
        }
        localapr.muE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259331);
        return 0;
      }
      AppMethodBeat.o(259331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apr
 * JD-Core Version:    0.7.0.1
 */