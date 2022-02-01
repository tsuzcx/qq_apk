package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cri
  extends esc
{
  public boolean aaxX = false;
  public String nQG;
  public String nQH;
  public String text;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258825);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258825);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aaxX);
      if (this.text != null) {
        paramVarArgs.g(3, this.text);
      }
      if (this.nQG != null) {
        paramVarArgs.g(4, this.nQG);
      }
      if (this.nQH != null) {
        paramVarArgs.g(5, this.nQH);
      }
      if (this.url != null) {
        paramVarArgs.g(6, this.url);
      }
      AppMethodBeat.o(258825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label616;
      }
    }
    label616:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.text);
      }
      i = paramInt;
      if (this.nQG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.nQG);
      }
      paramInt = i;
      if (this.nQH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nQH);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.url);
      }
      AppMethodBeat.o(258825);
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
          AppMethodBeat.o(258825);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cri localcri = (cri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258825);
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
            localcri.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258825);
          return 0;
        case 2: 
          localcri.aaxX = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258825);
          return 0;
        case 3: 
          localcri.text = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258825);
          return 0;
        case 4: 
          localcri.nQG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258825);
          return 0;
        case 5: 
          localcri.nQH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258825);
          return 0;
        }
        localcri.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258825);
        return 0;
      }
      AppMethodBeat.o(258825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cri
 * JD-Core Version:    0.7.0.1
 */