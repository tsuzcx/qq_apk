package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ain
  extends dyl
{
  public String appid;
  public String key;
  public String query;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123568);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.key != null) {
        paramVarArgs.f(2, this.key);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      if (this.query != null) {
        paramVarArgs.f(4, this.query);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.url != null) {
        paramVarArgs.f(6, this.url);
      }
      AppMethodBeat.o(123568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.key);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.query);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.url);
      }
      AppMethodBeat.o(123568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ain localain = (ain)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123568);
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
            localain.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123568);
          return 0;
        case 2: 
          localain.key = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 3: 
          localain.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 4: 
          localain.query = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 5: 
          localain.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123568);
          return 0;
        }
        localain.url = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123568);
        return 0;
      }
      AppMethodBeat.o(123568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ain
 * JD-Core Version:    0.7.0.1
 */