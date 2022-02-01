package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gkb
  extends esc
{
  public int abns;
  public int acfW;
  public int acfX;
  public String hOQ;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      paramVarArgs.bS(4, this.version);
      paramVarArgs.bS(5, this.acfW);
      paramVarArgs.bS(6, this.abns);
      paramVarArgs.bS(7, this.acfX);
      if (this.hOQ != null) {
        paramVarArgs.g(8, this.hOQ);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label688;
      }
    }
    label688:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.version) + i.a.a.b.b.a.cJ(5, this.acfW) + i.a.a.b.b.a.cJ(6, this.abns) + i.a.a.b.b.a.cJ(7, this.acfX);
      paramInt = i;
      if (this.hOQ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.hOQ);
      }
      AppMethodBeat.o(123686);
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
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gkb localgkb = (gkb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
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
            localgkb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localgkb.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localgkb.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localgkb.version = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localgkb.acfW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localgkb.abns = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localgkb.acfX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123686);
          return 0;
        }
        localgkb.hOQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkb
 * JD-Core Version:    0.7.0.1
 */