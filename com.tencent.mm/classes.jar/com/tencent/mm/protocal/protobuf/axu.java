package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axu
  extends com.tencent.mm.cd.a
{
  public String SKd;
  public bab SKe;
  public int SKf;
  public String SKg;
  public int SKo;
  public int SKp;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229582);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKd != null) {
        paramVarArgs.f(1, this.SKd);
      }
      paramVarArgs.aY(2, this.SKo);
      paramVarArgs.aY(3, this.SKp);
      if (this.SKe != null)
      {
        paramVarArgs.oE(4, this.SKe.computeSize());
        this.SKe.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.f(5, this.content);
      }
      paramVarArgs.aY(6, this.SKf);
      if (this.SKg != null) {
        paramVarArgs.f(7, this.SKg);
      }
      AppMethodBeat.o(229582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKd == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKd) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SKo) + g.a.a.b.b.a.bM(3, this.SKp);
      paramInt = i;
      if (this.SKe != null) {
        paramInt = i + g.a.a.a.oD(4, this.SKe.computeSize());
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.content);
      }
      i += g.a.a.b.b.a.bM(6, this.SKf);
      paramInt = i;
      if (this.SKg != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SKg);
      }
      AppMethodBeat.o(229582);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        axu localaxu = (axu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229582);
          return -1;
        case 1: 
          localaxu.SKd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229582);
          return 0;
        case 2: 
          localaxu.SKo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(229582);
          return 0;
        case 3: 
          localaxu.SKp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(229582);
          return 0;
        case 4: 
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
            localaxu.SKe = localbab;
            paramInt += 1;
          }
          AppMethodBeat.o(229582);
          return 0;
        case 5: 
          localaxu.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229582);
          return 0;
        case 6: 
          localaxu.SKf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(229582);
          return 0;
        }
        localaxu.SKg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(229582);
        return 0;
      }
      AppMethodBeat.o(229582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axu
 * JD-Core Version:    0.7.0.1
 */