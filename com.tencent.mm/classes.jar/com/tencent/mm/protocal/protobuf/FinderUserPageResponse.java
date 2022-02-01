package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderUserPageResponse
  extends cwj
{
  public FinderContact contact;
  public int continueFlag;
  public chl entranceInfo;
  public int fansCount;
  public int feedsCount;
  public String firstPageMD5;
  public int friendFollowCount;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public int originalEntranceFlag;
  public arc preloadInfo;
  public int privateLock;
  public LinkedList<String> userTags;
  public aqk verifyInfo;
  
  public FinderUserPageResponse()
  {
    AppMethodBeat.i(169071);
    this.object = new LinkedList();
    this.userTags = new LinkedList();
    this.liveObjects = new LinkedList();
    AppMethodBeat.o(169071);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169072);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169072);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.firstPageMD5 != null) {
        paramVarArgs.d(3, this.firstPageMD5);
      }
      if (this.contact != null)
      {
        paramVarArgs.lJ(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.feedsCount);
      paramVarArgs.aS(7, this.continueFlag);
      if (this.verifyInfo != null)
      {
        paramVarArgs.lJ(8, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.fansCount);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aS(11, this.friendFollowCount);
      paramVarArgs.e(12, 1, this.userTags);
      paramVarArgs.aS(13, this.originalEntranceFlag);
      if (this.entranceInfo != null)
      {
        paramVarArgs.lJ(14, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.lJ(15, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.liveObjects);
      paramVarArgs.aS(17, this.privateLock);
      AppMethodBeat.o(169072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1718;
      }
    }
    label1718:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.firstPageMD5);
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + f.a.a.a.lI(5, this.contact.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.feedsCount) + f.a.a.b.b.a.bz(7, this.continueFlag);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + f.a.a.a.lI(8, this.verifyInfo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.fansCount);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.friendFollowCount) + f.a.a.a.c(12, 1, this.userTags) + f.a.a.b.b.a.bz(13, this.originalEntranceFlag);
      paramInt = i;
      if (this.entranceInfo != null) {
        paramInt = i + f.a.a.a.lI(14, this.entranceInfo.computeSize());
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + f.a.a.a.lI(15, this.preloadInfo.computeSize());
      }
      paramInt = f.a.a.a.c(16, 8, this.liveObjects);
      int j = f.a.a.b.b.a.bz(17, this.privateLock);
      AppMethodBeat.o(169072);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.userTags.clear();
        this.liveObjects.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169072);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169072);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderUserPageResponse localFinderUserPageResponse = (FinderUserPageResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(169072);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 3: 
          localFinderUserPageResponse.firstPageMD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169072);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 6: 
          localFinderUserPageResponse.feedsCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169072);
          return 0;
        case 7: 
          localFinderUserPageResponse.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169072);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.verifyInfo = ((aqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 9: 
          localFinderUserPageResponse.fansCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169072);
          return 0;
        case 10: 
          localFinderUserPageResponse.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169072);
          return 0;
        case 11: 
          localFinderUserPageResponse.friendFollowCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169072);
          return 0;
        case 12: 
          localFinderUserPageResponse.userTags.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(169072);
          return 0;
        case 13: 
          localFinderUserPageResponse.originalEntranceFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169072);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.entranceInfo = ((chl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.preloadInfo = ((arc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderUserPageResponse.liveObjects.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169072);
          return 0;
        }
        localFinderUserPageResponse.privateLock = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169072);
        return 0;
      }
      AppMethodBeat.o(169072);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderUserPageResponse
 * JD-Core Version:    0.7.0.1
 */