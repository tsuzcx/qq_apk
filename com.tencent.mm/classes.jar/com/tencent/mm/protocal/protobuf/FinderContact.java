package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderContact
  extends com.tencent.mm.bx.a
{
  public FinderAuthInfo authInfo;
  public String coverImgUrl;
  public int extFlag;
  public alx extInfo;
  public int followFlag;
  public int followTime;
  public String headUrl;
  public int liveStatus;
  public alz msgInfo;
  public String nickname;
  public int originalFlag;
  public aqe originalInfo;
  public long seq;
  public String signature;
  public int spamStatus;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.d(3, this.headUrl);
      }
      paramVarArgs.aY(4, this.seq);
      if (this.signature != null) {
        paramVarArgs.d(5, this.signature);
      }
      paramVarArgs.aS(6, this.followFlag);
      paramVarArgs.aS(7, this.followTime);
      if (this.authInfo != null)
      {
        paramVarArgs.lC(8, this.authInfo.computeSize());
        this.authInfo.writeFields(paramVarArgs);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.d(9, this.coverImgUrl);
      }
      paramVarArgs.aS(10, this.spamStatus);
      paramVarArgs.aS(11, this.extFlag);
      if (this.extInfo != null)
      {
        paramVarArgs.lC(12, this.extInfo.computeSize());
        this.extInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.originalFlag);
      if (this.originalInfo != null)
      {
        paramVarArgs.lC(14, this.originalInfo.computeSize());
        this.originalInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.liveStatus);
      if (this.msgInfo != null)
      {
        paramVarArgs.lC(16, this.msgInfo.computeSize());
        this.msgInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1398;
      }
    }
    label1398:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.headUrl);
      }
      i += f.a.a.b.b.a.p(4, this.seq);
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.signature);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.followFlag) + f.a.a.b.b.a.bz(7, this.followTime);
      paramInt = i;
      if (this.authInfo != null) {
        paramInt = i + f.a.a.a.lB(8, this.authInfo.computeSize());
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.coverImgUrl);
      }
      i = i + f.a.a.b.b.a.bz(10, this.spamStatus) + f.a.a.b.b.a.bz(11, this.extFlag);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + f.a.a.a.lB(12, this.extInfo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.originalFlag);
      paramInt = i;
      if (this.originalInfo != null) {
        paramInt = i + f.a.a.a.lB(14, this.originalInfo.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.liveStatus);
      paramInt = i;
      if (this.msgInfo != null) {
        paramInt = i + f.a.a.a.lB(16, this.msgInfo.computeSize());
      }
      AppMethodBeat.o(168945);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168945);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        FinderContact localFinderContact = (FinderContact)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168945);
          return -1;
        case 1: 
          localFinderContact.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 2: 
          localFinderContact.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 3: 
          localFinderContact.headUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 4: 
          localFinderContact.seq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168945);
          return 0;
        case 5: 
          localFinderContact.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 6: 
          localFinderContact.followFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        case 7: 
          localFinderContact.followTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderAuthInfo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderContact.authInfo = ((FinderAuthInfo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 9: 
          localFinderContact.coverImgUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168945);
          return 0;
        case 10: 
          localFinderContact.spamStatus = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        case 11: 
          localFinderContact.extFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderContact.extInfo = ((alx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 13: 
          localFinderContact.originalFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localFinderContact.originalInfo = ((aqe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168945);
          return 0;
        case 15: 
          localFinderContact.liveStatus = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168945);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderContact.msgInfo = ((alz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168945);
        return 0;
      }
      AppMethodBeat.o(168945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderContact
 * JD-Core Version:    0.7.0.1
 */