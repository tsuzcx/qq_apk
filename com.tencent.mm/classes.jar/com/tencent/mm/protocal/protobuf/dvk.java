package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvk
  extends com.tencent.mm.cd.a
{
  public dvl Tkp;
  public String Ubo;
  public String content;
  public String llG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.f(1, this.content);
      }
      if (this.llG != null) {
        paramVarArgs.f(2, this.llG);
      }
      if (this.Ubo != null) {
        paramVarArgs.f(3, this.Ubo);
      }
      if (this.Tkp != null)
      {
        paramVarArgs.oE(4, this.Tkp.computeSize());
        this.Tkp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.b.b.a.g(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.llG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.llG);
      }
      i = paramInt;
      if (this.Ubo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ubo);
      }
      paramInt = i;
      if (this.Tkp != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tkp.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dvk localdvk = (dvk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localdvk.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localdvk.llG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localdvk.Ubo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvl localdvl = new dvl();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvl.parseFrom((byte[])localObject);
          }
          localdvk.Tkp = localdvl;
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvk
 * JD-Core Version:    0.7.0.1
 */