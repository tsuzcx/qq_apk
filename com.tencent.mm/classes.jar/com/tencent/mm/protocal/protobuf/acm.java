package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acm
  extends com.tencent.mm.bw.a
{
  public int EuX;
  public LinkedList<yg> EuY;
  public String nUs;
  public String title;
  
  public acm()
  {
    AppMethodBeat.i(113996);
    this.EuY = new LinkedList();
    AppMethodBeat.o(113996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.nUs != null) {
        paramVarArgs.d(2, this.nUs);
      }
      paramVarArgs.aR(3, this.EuX);
      paramVarArgs.e(4, 8, this.EuY);
      AppMethodBeat.o(113997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nUs);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.EuX);
      int j = f.a.a.a.c(4, 8, this.EuY);
      AppMethodBeat.o(113997);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EuY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acm localacm = (acm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113997);
          return -1;
        case 1: 
          localacm.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 2: 
          localacm.nUs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 3: 
          localacm.EuX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacm.EuY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      AppMethodBeat.o(113997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acm
 * JD-Core Version:    0.7.0.1
 */