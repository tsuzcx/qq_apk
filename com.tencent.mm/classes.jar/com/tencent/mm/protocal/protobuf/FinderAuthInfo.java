package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderAuthInfo
  extends com.tencent.mm.bx.a
{
  public String appName;
  public FinderContact authGenerator;
  public int authIconType;
  public String authProfession;
  public String detailLink;
  public String realName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168936);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.realName != null) {
        paramVarArgs.d(1, this.realName);
      }
      paramVarArgs.aR(2, this.authIconType);
      if (this.authProfession != null) {
        paramVarArgs.d(3, this.authProfession);
      }
      if (this.authGenerator != null)
      {
        paramVarArgs.kX(4, this.authGenerator.computeSize());
        this.authGenerator.writeFields(paramVarArgs);
      }
      if (this.detailLink != null) {
        paramVarArgs.d(5, this.detailLink);
      }
      if (this.appName != null) {
        paramVarArgs.d(6, this.appName);
      }
      AppMethodBeat.o(168936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.realName == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.realName) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.authIconType);
      paramInt = i;
      if (this.authProfession != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.authProfession);
      }
      i = paramInt;
      if (this.authGenerator != null) {
        i = paramInt + f.a.a.a.kW(4, this.authGenerator.computeSize());
      }
      paramInt = i;
      if (this.detailLink != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.detailLink);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.appName);
      }
      AppMethodBeat.o(168936);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168936);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderAuthInfo localFinderAuthInfo = (FinderAuthInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168936);
          return -1;
        case 1: 
          localFinderAuthInfo.realName = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 2: 
          localFinderAuthInfo.authIconType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168936);
          return 0;
        case 3: 
          localFinderAuthInfo.authProfession = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderAuthInfo.authGenerator = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168936);
          return 0;
        case 5: 
          localFinderAuthInfo.detailLink = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168936);
          return 0;
        }
        localFinderAuthInfo.appName = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(168936);
        return 0;
      }
      AppMethodBeat.o(168936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderAuthInfo
 * JD-Core Version:    0.7.0.1
 */