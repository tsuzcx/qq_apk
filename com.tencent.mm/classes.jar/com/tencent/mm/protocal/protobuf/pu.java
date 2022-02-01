package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class pu
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public int YBh;
  public String YTl;
  public ok YTm;
  public int friend_follow_count;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257793);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ADE != null) {
        paramVarArgs.g(1, this.ADE);
      }
      if (this.YTl != null) {
        paramVarArgs.g(2, this.YTl);
      }
      if (this.xkY != null) {
        paramVarArgs.g(3, this.xkY);
      }
      paramVarArgs.bS(4, this.YBh);
      paramVarArgs.bS(5, this.friend_follow_count);
      if (this.YTm != null)
      {
        paramVarArgs.qD(6, this.YTm.computeSize());
        this.YTm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ADE == null) {
        break label552;
      }
    }
    label552:
    for (int i = i.a.a.b.b.a.h(1, this.ADE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YTl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YTl);
      }
      i = paramInt;
      if (this.xkY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xkY);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.YBh) + i.a.a.b.b.a.cJ(5, this.friend_follow_count);
      paramInt = i;
      if (this.YTm != null) {
        paramInt = i + i.a.a.a.qC(6, this.YTm.computeSize());
      }
      AppMethodBeat.o(257793);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pu localpu = (pu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257793);
          return -1;
        case 1: 
          localpu.ADE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257793);
          return 0;
        case 2: 
          localpu.YTl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257793);
          return 0;
        case 3: 
          localpu.xkY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257793);
          return 0;
        case 4: 
          localpu.YBh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257793);
          return 0;
        case 5: 
          localpu.friend_follow_count = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257793);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ok localok = new ok();
          if ((localObject != null) && (localObject.length > 0)) {
            localok.parseFrom((byte[])localObject);
          }
          localpu.YTm = localok;
          paramInt += 1;
        }
        AppMethodBeat.o(257793);
        return 0;
      }
      AppMethodBeat.o(257793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pu
 * JD-Core Version:    0.7.0.1
 */