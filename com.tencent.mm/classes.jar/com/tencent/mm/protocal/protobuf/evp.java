package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evp
  extends com.tencent.mm.cd.a
{
  public crc UwZ;
  public crc Uxa;
  public String content;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72616);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      if (this.UwZ != null)
      {
        paramVarArgs.oE(3, this.UwZ.computeSize());
        this.UwZ.writeFields(paramVarArgs);
      }
      if (this.Uxa != null)
      {
        paramVarArgs.oE(4, this.Uxa.computeSize());
        this.Uxa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.content);
      }
      i = paramInt;
      if (this.UwZ != null) {
        i = paramInt + g.a.a.a.oD(3, this.UwZ.computeSize());
      }
      paramInt = i;
      if (this.Uxa != null) {
        paramInt = i + g.a.a.a.oD(4, this.Uxa.computeSize());
      }
      AppMethodBeat.o(72616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        evp localevp = (evp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        crc localcrc;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72616);
          return -1;
        case 1: 
          localevp.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 2: 
          localevp.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcrc = new crc();
            if ((localObject != null) && (localObject.length > 0)) {
              localcrc.parseFrom((byte[])localObject);
            }
            localevp.UwZ = localcrc;
            paramInt += 1;
          }
          AppMethodBeat.o(72616);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcrc = new crc();
          if ((localObject != null) && (localObject.length > 0)) {
            localcrc.parseFrom((byte[])localObject);
          }
          localevp.Uxa = localcrc;
          paramInt += 1;
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      AppMethodBeat.o(72616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evp
 * JD-Core Version:    0.7.0.1
 */