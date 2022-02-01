package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asv
  extends dyl
{
  public String SFX;
  public String SFY;
  public String clientId;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.clientId != null) {
        paramVarArgs.f(2, this.clientId);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.SFX != null) {
        paramVarArgs.f(4, this.SFX);
      }
      if (this.SFY != null) {
        paramVarArgs.f(5, this.SFY);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(6, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(202122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.clientId);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      paramInt = i;
      if (this.SFX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SFX);
      }
      i = paramInt;
      if (this.SFY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SFY);
      }
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + g.a.a.a.oD(6, this.BaseRequest.computeSize());
      }
      AppMethodBeat.o(202122);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202122);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        asv localasv = (asv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202122);
          return -1;
        case 1: 
          localasv.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202122);
          return 0;
        case 2: 
          localasv.clientId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202122);
          return 0;
        case 3: 
          localasv.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202122);
          return 0;
        case 4: 
          localasv.SFX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202122);
          return 0;
        case 5: 
          localasv.SFY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202122);
          return 0;
        }
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
          localasv.BaseRequest = localjg;
          paramInt += 1;
        }
        AppMethodBeat.o(202122);
        return 0;
      }
      AppMethodBeat.o(202122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asv
 * JD-Core Version:    0.7.0.1
 */