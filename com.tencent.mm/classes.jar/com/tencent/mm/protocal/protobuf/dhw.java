package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhw
  extends com.tencent.mm.cd.a
{
  public String TOS;
  public cop TOT;
  public boolean TOU = false;
  public String action;
  public String className;
  public String dataPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122524);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.f(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.f(2, this.dataPath);
      }
      if (this.action != null) {
        paramVarArgs.f(3, this.action);
      }
      if (this.TOS != null) {
        paramVarArgs.f(4, this.TOS);
      }
      if (this.TOT != null)
      {
        paramVarArgs.oE(5, this.TOT.computeSize());
        this.TOT.writeFields(paramVarArgs);
      }
      paramVarArgs.co(6, this.TOU);
      AppMethodBeat.o(122524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label572;
      }
    }
    label572:
    for (int i = g.a.a.b.b.a.g(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.dataPath);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.action);
      }
      paramInt = i;
      if (this.TOS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TOS);
      }
      i = paramInt;
      if (this.TOT != null) {
        i = paramInt + g.a.a.a.oD(5, this.TOT.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(122524);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dhw localdhw = (dhw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122524);
          return -1;
        case 1: 
          localdhw.className = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 2: 
          localdhw.dataPath = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 3: 
          localdhw.action = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 4: 
          localdhw.TOS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cop localcop = new cop();
            if ((localObject != null) && (localObject.length > 0)) {
              localcop.parseFrom((byte[])localObject);
            }
            localdhw.TOT = localcop;
            paramInt += 1;
          }
          AppMethodBeat.o(122524);
          return 0;
        }
        localdhw.TOU = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(122524);
        return 0;
      }
      AppMethodBeat.o(122524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhw
 * JD-Core Version:    0.7.0.1
 */