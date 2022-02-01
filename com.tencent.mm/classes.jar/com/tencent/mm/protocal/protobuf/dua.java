package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dua
  extends erp
{
  public String UserName;
  public gol aaZy;
  public gol aaZz;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133181);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaZy == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.aaZz == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.aaZy != null)
      {
        paramVarArgs.qD(3, this.aaZy.computeSize());
        this.aaZy.writeFields(paramVarArgs);
      }
      if (this.aaZz != null)
      {
        paramVarArgs.qD(4, this.aaZz.computeSize());
        this.aaZz.writeFields(paramVarArgs);
      }
      if (this.yts != null) {
        paramVarArgs.g(5, this.yts);
      }
      AppMethodBeat.o(133181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.aaZy != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaZy.computeSize());
      }
      paramInt = i;
      if (this.aaZz != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaZz.computeSize());
      }
      i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.yts);
      }
      AppMethodBeat.o(133181);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaZy == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        if (this.aaZz == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dua localdua = (dua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133181);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdua.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 2: 
          localdua.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133181);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdua.aaZy = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdua.aaZz = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        }
        localdua.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(133181);
        return 0;
      }
      AppMethodBeat.o(133181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dua
 * JD-Core Version:    0.7.0.1
 */