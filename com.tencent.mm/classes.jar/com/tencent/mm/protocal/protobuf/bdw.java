package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdw
  extends dyl
{
  public String RLN;
  public long klE;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.klE);
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      paramVarArgs.bm(4, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(5, this.object_nonce_id);
      }
      AppMethodBeat.o(231370);
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
      int i = paramInt + g.a.a.b.b.a.p(2, this.klE);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RLN);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.object_nonce_id);
      }
      AppMethodBeat.o(231370);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bdw localbdw = (bdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231370);
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
            localbdw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(231370);
          return 0;
        case 2: 
          localbdw.klE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231370);
          return 0;
        case 3: 
          localbdw.RLN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231370);
          return 0;
        case 4: 
          localbdw.object_id = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231370);
          return 0;
        }
        localbdw.object_nonce_id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231370);
        return 0;
      }
      AppMethodBeat.o(231370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdw
 * JD-Core Version:    0.7.0.1
 */