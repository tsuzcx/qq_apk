package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnw
  extends com.tencent.mm.cd.a
{
  public ezl SYO;
  public bne SYT;
  public bnr SYU;
  public String error_msg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SYO != null)
      {
        paramVarArgs.oE(1, this.SYO.computeSize());
        this.SYO.writeFields(paramVarArgs);
      }
      if (this.SYT != null)
      {
        paramVarArgs.oE(2, this.SYT.computeSize());
        this.SYT.writeFields(paramVarArgs);
      }
      if (this.error_msg != null) {
        paramVarArgs.f(3, this.error_msg);
      }
      if (this.SYU != null)
      {
        paramVarArgs.oE(4, this.SYU.computeSize());
        this.SYU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SYO == null) {
        break label612;
      }
    }
    label612:
    for (int i = g.a.a.a.oD(1, this.SYO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SYT != null) {
        paramInt = i + g.a.a.a.oD(2, this.SYT.computeSize());
      }
      i = paramInt;
      if (this.error_msg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.error_msg);
      }
      paramInt = i;
      if (this.SYU != null) {
        paramInt = i + g.a.a.a.oD(4, this.SYU.computeSize());
      }
      AppMethodBeat.o(197824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnw localbnw = (bnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197824);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezl)localObject2).parseFrom((byte[])localObject1);
            }
            localbnw.SYO = ((ezl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197824);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bne)localObject2).parseFrom((byte[])localObject1);
            }
            localbnw.SYT = ((bne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197824);
          return 0;
        case 3: 
          localbnw.error_msg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(197824);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnr)localObject2).parseFrom((byte[])localObject1);
          }
          localbnw.SYU = ((bnr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197824);
        return 0;
      }
      AppMethodBeat.o(197824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnw
 * JD-Core Version:    0.7.0.1
 */