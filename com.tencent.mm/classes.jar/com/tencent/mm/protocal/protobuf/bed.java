package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bed
  extends com.tencent.mm.bx.a
{
  public LinkedList<bgh> ZOH;
  public String content;
  
  public bed()
  {
    AppMethodBeat.i(258785);
    this.ZOH = new LinkedList();
    AppMethodBeat.o(258785);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258788);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      paramVarArgs.e(2, 8, this.ZOH);
      AppMethodBeat.o(258788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.content) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZOH);
      AppMethodBeat.o(258788);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZOH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bed localbed = (bed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258788);
          return -1;
        case 1: 
          localbed.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258788);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bgh localbgh = new bgh();
          if ((localObject != null) && (localObject.length > 0)) {
            localbgh.parseFrom((byte[])localObject);
          }
          localbed.ZOH.add(localbgh);
          paramInt += 1;
        }
        AppMethodBeat.o(258788);
        return 0;
      }
      AppMethodBeat.o(258788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bed
 * JD-Core Version:    0.7.0.1
 */