package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyk
  extends com.tencent.mm.bw.a
{
  public String MDj;
  public cft MDk;
  public boolean MDl = false;
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
        paramVarArgs.e(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.e(2, this.dataPath);
      }
      if (this.action != null) {
        paramVarArgs.e(3, this.action);
      }
      if (this.MDj != null) {
        paramVarArgs.e(4, this.MDj);
      }
      if (this.MDk != null)
      {
        paramVarArgs.ni(5, this.MDk.computeSize());
        this.MDk.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(6, this.MDl);
      AppMethodBeat.o(122524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label594;
      }
    }
    label594:
    for (int i = g.a.a.b.b.a.f(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dataPath);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.action);
      }
      paramInt = i;
      if (this.MDj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MDj);
      }
      i = paramInt;
      if (this.MDk != null) {
        i = paramInt + g.a.a.a.nh(5, this.MDk.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(122524);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyk localcyk = (cyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122524);
          return -1;
        case 1: 
          localcyk.className = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 2: 
          localcyk.dataPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 3: 
          localcyk.action = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 4: 
          localcyk.MDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cft();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cft)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcyk.MDk = ((cft)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122524);
          return 0;
        }
        localcyk.MDl = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122524);
        return 0;
      }
      AppMethodBeat.o(122524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyk
 * JD-Core Version:    0.7.0.1
 */