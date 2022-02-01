package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enm
  extends dyl
{
  public String SsO;
  public long UlB;
  public String UserName;
  public int vhG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118444);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.vhG);
      if (this.SsO != null) {
        paramVarArgs.f(4, this.SsO);
      }
      paramVarArgs.bm(5, this.UlB);
      AppMethodBeat.o(118444);
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
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i += g.a.a.b.b.a.bM(3, this.vhG);
      paramInt = i;
      if (this.SsO != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SsO);
      }
      i = g.a.a.b.b.a.p(5, this.UlB);
      AppMethodBeat.o(118444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        enm localenm = (enm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118444);
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
            localenm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(118444);
          return 0;
        case 2: 
          localenm.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118444);
          return 0;
        case 3: 
          localenm.vhG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118444);
          return 0;
        case 4: 
          localenm.SsO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118444);
          return 0;
        }
        localenm.UlB = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(118444);
        return 0;
      }
      AppMethodBeat.o(118444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enm
 * JD-Core Version:    0.7.0.1
 */