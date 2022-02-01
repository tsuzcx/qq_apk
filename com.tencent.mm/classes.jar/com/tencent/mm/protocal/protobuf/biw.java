package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class biw
  extends dyl
{
  public String STj;
  public String from_username;
  public String link;
  public String sWA;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202098);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.f(2, this.from_username);
      }
      if (this.sWA != null) {
        paramVarArgs.f(3, this.sWA);
      }
      if (this.STj != null) {
        paramVarArgs.f(4, this.STj);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.link != null) {
        paramVarArgs.f(6, this.link);
      }
      AppMethodBeat.o(202098);
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
      if (this.from_username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.from_username);
      }
      i = paramInt;
      if (this.sWA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sWA);
      }
      paramInt = i;
      if (this.STj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.STj);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.link);
      }
      AppMethodBeat.o(202098);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202098);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        biw localbiw = (biw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202098);
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
            localbiw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(202098);
          return 0;
        case 2: 
          localbiw.from_username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202098);
          return 0;
        case 3: 
          localbiw.sWA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202098);
          return 0;
        case 4: 
          localbiw.STj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(202098);
          return 0;
        case 5: 
          localbiw.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(202098);
          return 0;
        }
        localbiw.link = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(202098);
        return 0;
      }
      AppMethodBeat.o(202098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biw
 * JD-Core Version:    0.7.0.1
 */