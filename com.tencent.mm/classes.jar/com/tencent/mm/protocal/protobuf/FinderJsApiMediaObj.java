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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mediaPath != null) {
        paramVarArgs.d(1, this.mediaPath);
      }
      paramVarArgs.aR(2, this.mediaType);
      if (this.thumbInfo != null)
      {
        paramVarArgs.kX(3, this.thumbInfo.computeSize());
        this.thumbInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaPath == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.mediaPath) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mediaType);
      paramInt = i;
      if (this.thumbInfo != null) {
        paramInt = i + f.a.a.a.kW(3, this.thumbInfo.computeSize());
      }
      AppMethodBeat.o(169000);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderJsApiMediaObj localFinderJsApiMediaObj = (FinderJsApiMediaObj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169000);
          return -1;
        case 1: 
          localFinderJsApiMediaObj.mediaPath = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169000);
          return 0;
        case 2: 
          localFinderJsApiMediaObj.mediaType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169000);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderJsApiMediaThumbInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderJsApiMediaThumbInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderJsApiMediaObj.thumbInfo = ((FinderJsApiMediaThumbInfo)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj
 * JD-Core Version:    0.7.0.1
 */