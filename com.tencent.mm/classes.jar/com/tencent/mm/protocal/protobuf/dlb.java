package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dlb
  extends esc
{
  public String aaQS;
  public String aaQT;
  public int type;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124536);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124536);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.type);
      if (this.version != null) {
        paramVarArgs.g(3, this.version);
      }
      if (this.aaQS != null) {
        paramVarArgs.g(4, this.aaQS);
      }
      if (this.aaQT != null) {
        paramVarArgs.g(5, this.aaQT);
      }
      AppMethodBeat.o(124536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.version);
      }
      i = paramInt;
      if (this.aaQS != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaQS);
      }
      paramInt = i;
      if (this.aaQT != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaQT);
      }
      AppMethodBeat.o(124536);
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
          AppMethodBeat.o(124536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dlb localdlb = (dlb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124536);
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
            localdlb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(124536);
          return 0;
        case 2: 
          localdlb.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124536);
          return 0;
        case 3: 
          localdlb.version = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124536);
          return 0;
        case 4: 
          localdlb.aaQS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124536);
          return 0;
        }
        localdlb.aaQT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124536);
        return 0;
      }
      AppMethodBeat.o(124536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlb
 * JD-Core Version:    0.7.0.1
 */