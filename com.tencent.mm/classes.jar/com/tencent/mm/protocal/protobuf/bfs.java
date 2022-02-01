package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bfs
  extends com.tencent.mm.cd.a
{
  public int SQv;
  public String groupId;
  public bfg musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198600);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.musicInfo != null)
      {
        paramVarArgs.oE(1, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      if (this.groupId != null) {
        paramVarArgs.f(2, this.groupId);
      }
      paramVarArgs.aY(3, this.SQv);
      AppMethodBeat.o(198600);
      return 0;
    }
    if (paramInt == 1) {
      if (this.musicInfo == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.musicInfo.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.groupId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.groupId);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.SQv);
      AppMethodBeat.o(198600);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198600);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bfs localbfs = (bfs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198600);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bfg localbfg = new bfg();
            if ((localObject != null) && (localObject.length > 0)) {
              localbfg.parseFrom((byte[])localObject);
            }
            localbfs.musicInfo = localbfg;
            paramInt += 1;
          }
          AppMethodBeat.o(198600);
          return 0;
        case 2: 
          localbfs.groupId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198600);
          return 0;
        }
        localbfs.SQv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198600);
        return 0;
      }
      AppMethodBeat.o(198600);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfs
 * JD-Core Version:    0.7.0.1
 */