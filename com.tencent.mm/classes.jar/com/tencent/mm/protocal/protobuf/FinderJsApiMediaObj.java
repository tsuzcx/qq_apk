package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderJsApiMediaObj
  extends com.tencent.mm.cd.a
{
  public String mediaPath;
  public int mediaType;
  public FinderJsApiMediaThumbInfo thumbInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mediaPath != null) {
        paramVarArgs.f(1, this.mediaPath);
      }
      paramVarArgs.aY(2, this.mediaType);
      if (this.thumbInfo != null)
      {
        paramVarArgs.oE(3, this.thumbInfo.computeSize());
        this.thumbInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaPath == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.b.b.a.g(1, this.mediaPath) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.mediaType);
      paramInt = i;
      if (this.thumbInfo != null) {
        paramInt = i + g.a.a.a.oD(3, this.thumbInfo.computeSize());
      }
      AppMethodBeat.o(169000);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        FinderJsApiMediaObj localFinderJsApiMediaObj = (FinderJsApiMediaObj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169000);
          return -1;
        case 1: 
          localFinderJsApiMediaObj.mediaPath = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169000);
          return 0;
        case 2: 
          localFinderJsApiMediaObj.mediaType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169000);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderJsApiMediaThumbInfo localFinderJsApiMediaThumbInfo = new FinderJsApiMediaThumbInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderJsApiMediaThumbInfo.parseFrom((byte[])localObject);
          }
          localFinderJsApiMediaObj.thumbInfo = localFinderJsApiMediaThumbInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(169000);
        return 0;
      }
      AppMethodBeat.o(169000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj
 * JD-Core Version:    0.7.0.1
 */