package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class em
  extends com.tencent.mm.bx.a
{
  public String YGB;
  public LinkedList<fhu> YGC;
  public String title;
  
  public em()
  {
    AppMethodBeat.i(32112);
    this.YGC = new LinkedList();
    AppMethodBeat.o(32112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32113);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGB != null) {
        paramVarArgs.g(1, this.YGB);
      }
      paramVarArgs.e(2, 8, this.YGC);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      AppMethodBeat.o(32113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGB == null) {
        break label401;
      }
    }
    label401:
    for (paramInt = i.a.a.b.b.a.h(1, this.YGB) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YGC);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      AppMethodBeat.o(32113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YGC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        em localem = (em)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32113);
          return -1;
        case 1: 
          localem.YGB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32113);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fhu localfhu = new fhu();
            if ((localObject != null) && (localObject.length > 0)) {
              localfhu.parseFrom((byte[])localObject);
            }
            localem.YGC.add(localfhu);
            paramInt += 1;
          }
          AppMethodBeat.o(32113);
          return 0;
        }
        localem.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32113);
        return 0;
      }
      AppMethodBeat.o(32113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.em
 * JD-Core Version:    0.7.0.1
 */