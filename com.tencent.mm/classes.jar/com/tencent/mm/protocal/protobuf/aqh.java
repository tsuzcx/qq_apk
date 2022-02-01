package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aqh
  extends esc
{
  public String CAf;
  public String KoF;
  public String KoG;
  public int ZxB;
  public int hAV;
  public String wYI;
  public String ytZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.CAf != null) {
        paramVarArgs.g(4, this.CAf);
      }
      if (this.ytZ != null) {
        paramVarArgs.g(5, this.ytZ);
      }
      paramVarArgs.bS(6, this.ZxB);
      if (this.KoG != null) {
        paramVarArgs.g(7, this.KoG);
      }
      if (this.KoF != null) {
        paramVarArgs.g(8, this.KoF);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.CAf);
      }
      paramInt = i;
      if (this.ytZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ytZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZxB);
      paramInt = i;
      if (this.KoG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.KoG);
      }
      i = paramInt;
      if (this.KoF != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.KoF);
      }
      AppMethodBeat.o(91455);
      return i;
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqh localaqh = (aqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
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
            localaqh.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localaqh.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localaqh.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localaqh.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localaqh.ytZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localaqh.ZxB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localaqh.KoG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localaqh.KoF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */