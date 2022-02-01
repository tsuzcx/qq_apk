package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emp
  extends com.tencent.mm.cd.a
{
  public emq Upe;
  public emo Upf;
  public emn Upg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Upe != null)
      {
        paramVarArgs.oE(1, this.Upe.computeSize());
        this.Upe.writeFields(paramVarArgs);
      }
      if (this.Upf != null)
      {
        paramVarArgs.oE(2, this.Upf.computeSize());
        this.Upf.writeFields(paramVarArgs);
      }
      if (this.Upg != null)
      {
        paramVarArgs.oE(3, this.Upg.computeSize());
        this.Upg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Upe == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.Upe.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Upf != null) {
        paramInt = i + g.a.a.a.oD(2, this.Upf.computeSize());
      }
      i = paramInt;
      if (this.Upg != null) {
        i = paramInt + g.a.a.a.oD(3, this.Upg.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emp localemp = (emp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emq)localObject2).parseFrom((byte[])localObject1);
            }
            localemp.Upe = ((emq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emo)localObject2).parseFrom((byte[])localObject1);
            }
            localemp.Upf = ((emo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new emn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((emn)localObject2).parseFrom((byte[])localObject1);
          }
          localemp.Upg = ((emn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      AppMethodBeat.o(125844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emp
 * JD-Core Version:    0.7.0.1
 */