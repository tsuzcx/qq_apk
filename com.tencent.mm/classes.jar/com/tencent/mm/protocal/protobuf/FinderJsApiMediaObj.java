package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderJsApiMediaObj
  extends com.tencent.mm.bx.a
{
  public String mediaPath;
  public int mediaType;
  public FinderJsApiMediaThumbInfo thumbInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169000);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mediaPath != null) {
        paramVarArgs.g(1, this.mediaPath);
      }
      paramVarArgs.bS(2, this.mediaType);
      if (this.thumbInfo != null)
      {
        paramVarArgs.qD(3, this.thumbInfo.computeSize());
        this.thumbInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaPath == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.b.b.a.h(1, this.mediaPath) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.mediaType);
      paramInt = i;
      if (this.thumbInfo != null) {
        paramInt = i + i.a.a.a.qC(3, this.thumbInfo.computeSize());
      }
      AppMethodBeat.o(169000);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        FinderJsApiMediaObj localFinderJsApiMediaObj = (FinderJsApiMediaObj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169000);
          return -1;
        case 1: 
          localFinderJsApiMediaObj.mediaPath = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169000);
          return 0;
        case 2: 
          localFinderJsApiMediaObj.mediaType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169000);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
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