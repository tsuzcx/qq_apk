package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class glp
  extends com.tencent.mm.bx.a
{
  public String Jfw;
  public String Jfx;
  public String Jfy;
  public String ZQO;
  public aya achj;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257556);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.Jfw != null) {
        paramVarArgs.g(2, this.Jfw);
      }
      if (this.Jfx != null) {
        paramVarArgs.g(3, this.Jfx);
      }
      if (this.ZQO != null) {
        paramVarArgs.g(4, this.ZQO);
      }
      if (this.Jfy != null) {
        paramVarArgs.g(5, this.Jfy);
      }
      if (this.achj != null)
      {
        paramVarArgs.qD(6, this.achj.computeSize());
        this.achj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Jfw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Jfw);
      }
      i = paramInt;
      if (this.Jfx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Jfx);
      }
      paramInt = i;
      if (this.ZQO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZQO);
      }
      i = paramInt;
      if (this.Jfy != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Jfy);
      }
      paramInt = i;
      if (this.achj != null) {
        paramInt = i + i.a.a.a.qC(6, this.achj.computeSize());
      }
      AppMethodBeat.o(257556);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        glp localglp = (glp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257556);
          return -1;
        case 1: 
          localglp.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257556);
          return 0;
        case 2: 
          localglp.Jfw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257556);
          return 0;
        case 3: 
          localglp.Jfx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257556);
          return 0;
        case 4: 
          localglp.ZQO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257556);
          return 0;
        case 5: 
          localglp.Jfy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257556);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aya localaya = new aya();
          if ((localObject != null) && (localObject.length > 0)) {
            localaya.parseFrom((byte[])localObject);
          }
          localglp.achj = localaya;
          paramInt += 1;
        }
        AppMethodBeat.o(257556);
        return 0;
      }
      AppMethodBeat.o(257556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glp
 * JD-Core Version:    0.7.0.1
 */