package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class git
  extends com.tencent.mm.bx.a
{
  public String ZCY;
  public String ZDa;
  public gis aceY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZCY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.ZDa == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.aceY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.ZCY != null) {
        paramVarArgs.g(1, this.ZCY);
      }
      if (this.ZDa != null) {
        paramVarArgs.g(2, this.ZDa);
      }
      if (this.aceY != null)
      {
        paramVarArgs.qD(3, this.aceY.computeSize());
        this.aceY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZCY == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.b.b.a.h(1, this.ZCY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZDa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZDa);
      }
      i = paramInt;
      if (this.aceY != null) {
        i = paramInt + i.a.a.a.qC(3, this.aceY.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZCY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.ZDa == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.aceY == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        git localgit = (git)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localgit.ZCY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localgit.ZDa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gis localgis = new gis();
          if ((localObject != null) && (localObject.length > 0)) {
            localgis.parseFrom((byte[])localObject);
          }
          localgit.aceY = localgis;
          paramInt += 1;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      AppMethodBeat.o(110858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.git
 * JD-Core Version:    0.7.0.1
 */