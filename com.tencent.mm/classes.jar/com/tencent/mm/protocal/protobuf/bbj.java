package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bbj
  extends dyy
{
  public String RND;
  public b SNf;
  public bbh live_notice_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.live_notice_info != null)
      {
        paramVarArgs.oE(2, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      if (this.SNf != null) {
        paramVarArgs.c(3, this.SNf);
      }
      if (this.RND != null) {
        paramVarArgs.f(4, this.RND);
      }
      AppMethodBeat.o(230918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + g.a.a.a.oD(2, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.SNf != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SNf);
      }
      paramInt = i;
      if (this.RND != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RND);
      }
      AppMethodBeat.o(230918);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbj localbbj = (bbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230918);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbbj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230918);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbh)localObject2).parseFrom((byte[])localObject1);
            }
            localbbj.live_notice_info = ((bbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230918);
          return 0;
        case 3: 
          localbbj.SNf = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230918);
          return 0;
        }
        localbbj.RND = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230918);
        return 0;
      }
      AppMethodBeat.o(230918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbj
 * JD-Core Version:    0.7.0.1
 */