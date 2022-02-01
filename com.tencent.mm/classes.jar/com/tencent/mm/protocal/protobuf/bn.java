package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bn
  extends dyl
{
  public String adExtInfo;
  public int enterScene;
  public String owd;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260916);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.owd != null) {
        paramVarArgs.f(2, this.owd);
      }
      if (this.uxInfo != null) {
        paramVarArgs.f(3, this.uxInfo);
      }
      paramVarArgs.aY(4, this.enterScene);
      if (this.adExtInfo != null) {
        paramVarArgs.f(5, this.adExtInfo);
      }
      AppMethodBeat.o(260916);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.owd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.owd);
      }
      i = paramInt;
      if (this.uxInfo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.uxInfo);
      }
      i += g.a.a.b.b.a.bM(4, this.enterScene);
      paramInt = i;
      if (this.adExtInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.adExtInfo);
      }
      AppMethodBeat.o(260916);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(260916);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260916);
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
            localbn.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(260916);
          return 0;
        case 2: 
          localbn.owd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260916);
          return 0;
        case 3: 
          localbn.uxInfo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260916);
          return 0;
        case 4: 
          localbn.enterScene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(260916);
          return 0;
        }
        localbn.adExtInfo = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(260916);
        return 0;
      }
      AppMethodBeat.o(260916);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bn
 * JD-Core Version:    0.7.0.1
 */