package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axq
  extends com.tencent.mm.cd.a
{
  public String SKd;
  public bab SKe;
  public int SKf;
  public String SKg;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230376);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKd != null) {
        paramVarArgs.f(1, this.SKd);
      }
      if (this.SKe != null)
      {
        paramVarArgs.oE(2, this.SKe.computeSize());
        this.SKe.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      paramVarArgs.aY(4, this.SKf);
      if (this.SKg != null) {
        paramVarArgs.f(5, this.SKg);
      }
      AppMethodBeat.o(230376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKd == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.b.b.a.g(1, this.SKd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SKe != null) {
        paramInt = i + g.a.a.a.oD(2, this.SKe.computeSize());
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.content);
      }
      i += g.a.a.b.b.a.bM(4, this.SKf);
      paramInt = i;
      if (this.SKg != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SKg);
      }
      AppMethodBeat.o(230376);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        axq localaxq = (axq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230376);
          return -1;
        case 1: 
          localaxq.SKd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(230376);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bab localbab = new bab();
            if ((localObject != null) && (localObject.length > 0)) {
              localbab.parseFrom((byte[])localObject);
            }
            localaxq.SKe = localbab;
            paramInt += 1;
          }
          AppMethodBeat.o(230376);
          return 0;
        case 3: 
          localaxq.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(230376);
          return 0;
        case 4: 
          localaxq.SKf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(230376);
          return 0;
        }
        localaxq.SKg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230376);
        return 0;
      }
      AppMethodBeat.o(230376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axq
 * JD-Core Version:    0.7.0.1
 */