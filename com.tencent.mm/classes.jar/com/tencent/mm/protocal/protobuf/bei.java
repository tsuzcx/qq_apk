package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bei
  extends com.tencent.mm.bx.a
{
  public bvo ZOP;
  public int ZOQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258822);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOP != null)
      {
        paramVarArgs.qD(101, this.ZOP.computeSize());
        this.ZOP.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(102, this.ZOQ);
      AppMethodBeat.o(258822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOP == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(101, this.ZOP.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(102, this.ZOQ);
      AppMethodBeat.o(258822);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bei localbei = (bei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258822);
          return -1;
        case 101: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bvo localbvo = new bvo();
            if ((localObject != null) && (localObject.length > 0)) {
              localbvo.parseFrom((byte[])localObject);
            }
            localbei.ZOP = localbvo;
            paramInt += 1;
          }
          AppMethodBeat.o(258822);
          return 0;
        }
        localbei.ZOQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258822);
        return 0;
      }
      AppMethodBeat.o(258822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bei
 * JD-Core Version:    0.7.0.1
 */