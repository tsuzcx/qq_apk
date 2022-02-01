package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cy
  extends com.tencent.mm.bx.a
{
  public dl YFg;
  public String YFh;
  public b YFi;
  public boolean YFj;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259147);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFg != null)
      {
        paramVarArgs.qD(1, this.YFg.computeSize());
        this.YFg.writeFields(paramVarArgs);
      }
      if (this.YFh != null) {
        paramVarArgs.g(2, this.YFh);
      }
      paramVarArgs.bv(3, this.seq);
      if (this.YFi != null) {
        paramVarArgs.d(4, this.YFi);
      }
      paramVarArgs.di(5, this.YFj);
      AppMethodBeat.o(259147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFg == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.YFg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YFh);
      }
      i += i.a.a.b.b.a.q(3, this.seq);
      paramInt = i;
      if (this.YFi != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YFi);
      }
      i = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(259147);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259147);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259147);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dl localdl = new dl();
            if ((localObject != null) && (localObject.length > 0)) {
              localdl.parseFrom((byte[])localObject);
            }
            localcy.YFg = localdl;
            paramInt += 1;
          }
          AppMethodBeat.o(259147);
          return 0;
        case 2: 
          localcy.YFh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259147);
          return 0;
        case 3: 
          localcy.seq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259147);
          return 0;
        case 4: 
          localcy.YFi = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259147);
          return 0;
        }
        localcy.YFj = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259147);
        return 0;
      }
      AppMethodBeat.o(259147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */