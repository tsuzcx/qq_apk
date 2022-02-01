package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class elw
  extends esc
{
  public elt abqi;
  public int abqx;
  public int abqy;
  public String abqz;
  public String appusername;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqi == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.abqi != null)
      {
        paramVarArgs.qD(1, this.abqi.computeSize());
        this.abqi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abqx);
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.appusername != null) {
        paramVarArgs.g(4, this.appusername);
      }
      paramVarArgs.bS(5, this.abqy);
      if (this.abqz != null) {
        paramVarArgs.g(6, this.abqz);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abqi == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = i.a.a.a.qC(1, this.abqi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abqx);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + i.a.a.a.qC(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.appusername != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.appusername);
      }
      i += i.a.a.b.b.a.cJ(5, this.abqy);
      paramInt = i;
      if (this.abqz != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abqz);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abqi == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        elw localelw = (elw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elt)localObject2).parseFrom((byte[])localObject1);
            }
            localelw.abqi = ((elt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localelw.abqx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localelw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localelw.appusername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localelw.abqy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32404);
          return 0;
        }
        localelw.abqz = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elw
 * JD-Core Version:    0.7.0.1
 */