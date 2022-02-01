package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ap
  extends dyl
{
  public int REC;
  public String REE;
  public boolean REG;
  public String chatroom_name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.REC);
      if (this.REE != null) {
        paramVarArgs.f(3, this.REE);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.f(4, this.chatroom_name);
      }
      paramVarArgs.co(5, this.REG);
      AppMethodBeat.o(113927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.REC);
      paramInt = i;
      if (this.REE != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.REE);
      }
      i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.chatroom_name);
      }
      paramInt = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(113927);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113927);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localap.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(113927);
          return 0;
        case 2: 
          localap.REC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113927);
          return 0;
        case 3: 
          localap.REE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113927);
          return 0;
        case 4: 
          localap.chatroom_name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113927);
          return 0;
        }
        localap.REG = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(113927);
        return 0;
      }
      AppMethodBeat.o(113927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */