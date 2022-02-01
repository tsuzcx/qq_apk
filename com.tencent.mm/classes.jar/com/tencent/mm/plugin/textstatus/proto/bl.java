package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.bx.a
{
  public String ToB;
  public String ToC;
  public k Tow;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289897);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Tow != null)
      {
        paramVarArgs.qD(1, this.Tow.computeSize());
        this.Tow.writeFields(paramVarArgs);
      }
      if (this.ToB != null) {
        paramVarArgs.g(2, this.ToB);
      }
      if (this.ToC != null) {
        paramVarArgs.g(3, this.ToC);
      }
      AppMethodBeat.o(289897);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tow == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.Tow.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ToB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ToB);
      }
      i = paramInt;
      if (this.ToC != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToC);
      }
      AppMethodBeat.o(289897);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289897);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289897);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            localbl.Tow = localk;
            paramInt += 1;
          }
          AppMethodBeat.o(289897);
          return 0;
        case 2: 
          localbl.ToB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289897);
          return 0;
        }
        localbl.ToC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(289897);
        return 0;
      }
      AppMethodBeat.o(289897);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bl
 * JD-Core Version:    0.7.0.1
 */