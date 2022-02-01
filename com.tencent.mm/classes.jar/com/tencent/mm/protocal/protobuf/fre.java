package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fre
  extends com.tencent.mm.bx.a
{
  public dhx abQH;
  public dhx abQI;
  public String content;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72616);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.g(2, this.content);
      }
      if (this.abQH != null)
      {
        paramVarArgs.qD(3, this.abQH.computeSize());
        this.abQH.writeFields(paramVarArgs);
      }
      if (this.abQI != null)
      {
        paramVarArgs.qD(4, this.abQI.computeSize());
        this.abQI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.content);
      }
      i = paramInt;
      if (this.abQH != null) {
        i = paramInt + i.a.a.a.qC(3, this.abQH.computeSize());
      }
      paramInt = i;
      if (this.abQI != null) {
        paramInt = i + i.a.a.a.qC(4, this.abQI.computeSize());
      }
      AppMethodBeat.o(72616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fre localfre = (fre)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dhx localdhx;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72616);
          return -1;
        case 1: 
          localfre.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 2: 
          localfre.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdhx = new dhx();
            if ((localObject != null) && (localObject.length > 0)) {
              localdhx.parseFrom((byte[])localObject);
            }
            localfre.abQH = localdhx;
            paramInt += 1;
          }
          AppMethodBeat.o(72616);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdhx = new dhx();
          if ((localObject != null) && (localObject.length > 0)) {
            localdhx.parseFrom((byte[])localObject);
          }
          localfre.abQI = localdhx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fre
 * JD-Core Version:    0.7.0.1
 */