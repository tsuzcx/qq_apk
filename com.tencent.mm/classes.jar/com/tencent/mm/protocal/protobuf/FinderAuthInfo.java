package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderAuthInfo
  extends com.tencent.mm.bw.a
{
  public String appName;
  public FinderContact authGenerator;
  public int authIconType;
  public String authIconUrl;
  public String authProfession;
  public String detailLink;
  public String realName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168936);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.realName != null) {
        paramVarArgs.e(1, this.realName);
      }
      paramVarArgs.aM(2, this.authIconType);
      if (this.authProfession != null) {
        paramVarArgs.e(3, this.authProfession);
      }
      if (this.authGenerator != null)
      {
        paramVarArgs.ni(4, this.authGenerator.computeSize());
        this.authGenerator.writeFields(paramVarArgs);
      }
      if (this.detailLink != null) {
        paramVarArgs.e(5, this.detailLink);
      }
      if (this.appName != null) {
        paramVarArgs.e(6, this.appName);
      }
      if (this.authIconUrl != null) {
        paramVarArgs.e(7, this.authIconUrl);
      }
      AppMethodBeat.o(168936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.realName == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.b.b.a.f(1, this.realName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.authIconType);
      paramInt = i;
      if (this.authProfession != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.authProfession);
      }
      i = paramInt;
      if (this.authGenerator != null) {
        i = paramInt + g.a.a.a.nh(4, this.authGenerator.computeSize());
      }
      paramInt = i;
      if (this.detailLink != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.detailLink);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.appName);
      }
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.authIconUrl);
      }
      AppMethodBeat.o(168936);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168936);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        FinderAuthInfo localFinderAuthInfo = (FinderAuthInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168936);
          return -1;
        case 1: 
          localFinderAuthInfo.realName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 2: 
          localFinderAuthInfo.authIconType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168936);
          return 0;
        case 3: 
          localFinderAuthInfo.authProfession = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localFinderAuthInfo.authGenerator = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168936);
          return 0;
        case 5: 
          localFinderAuthInfo.detailLink = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 6: 
          localFinderAuthInfo.appName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168936);
          return 0;
        }
        localFinderAuthInfo.authIconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(168936);
        return 0;
      }
      AppMethodBeat.o(168936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderAuthInfo
 * JD-Core Version:    0.7.0.1
 */