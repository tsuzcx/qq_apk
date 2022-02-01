package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderAuthInfo
  extends com.tencent.mm.bx.a
{
  public String appName;
  public FinderContact authGenerator;
  public int authIconType;
  public String authIconUrl;
  public String authProfession;
  public int auth_verify_identity;
  public int customer_type;
  public String detailLink;
  public String realName;
  public int verify_status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168936);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.realName != null) {
        paramVarArgs.g(1, this.realName);
      }
      paramVarArgs.bS(2, this.authIconType);
      if (this.authProfession != null) {
        paramVarArgs.g(3, this.authProfession);
      }
      if (this.authGenerator != null)
      {
        paramVarArgs.qD(4, this.authGenerator.computeSize());
        this.authGenerator.writeFields(paramVarArgs);
      }
      if (this.detailLink != null) {
        paramVarArgs.g(5, this.detailLink);
      }
      if (this.appName != null) {
        paramVarArgs.g(6, this.appName);
      }
      if (this.authIconUrl != null) {
        paramVarArgs.g(7, this.authIconUrl);
      }
      paramVarArgs.bS(8, this.customer_type);
      paramVarArgs.bS(9, this.auth_verify_identity);
      paramVarArgs.bS(10, this.verify_status);
      AppMethodBeat.o(168936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.realName == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = i.a.a.b.b.a.h(1, this.realName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.authIconType);
      paramInt = i;
      if (this.authProfession != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.authProfession);
      }
      i = paramInt;
      if (this.authGenerator != null) {
        i = paramInt + i.a.a.a.qC(4, this.authGenerator.computeSize());
      }
      paramInt = i;
      if (this.detailLink != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.detailLink);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.appName);
      }
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.authIconUrl);
      }
      i = i.a.a.b.b.a.cJ(8, this.customer_type);
      int j = i.a.a.b.b.a.cJ(9, this.auth_verify_identity);
      int k = i.a.a.b.b.a.cJ(10, this.verify_status);
      AppMethodBeat.o(168936);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168936);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        FinderAuthInfo localFinderAuthInfo = (FinderAuthInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168936);
          return -1;
        case 1: 
          localFinderAuthInfo.realName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 2: 
          localFinderAuthInfo.authIconType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(168936);
          return 0;
        case 3: 
          localFinderAuthInfo.authProfession = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderContact localFinderContact = new FinderContact();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderContact.parseFrom((byte[])localObject);
            }
            localFinderAuthInfo.authGenerator = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(168936);
          return 0;
        case 5: 
          localFinderAuthInfo.detailLink = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 6: 
          localFinderAuthInfo.appName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 7: 
          localFinderAuthInfo.authIconUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 8: 
          localFinderAuthInfo.customer_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(168936);
          return 0;
        case 9: 
          localFinderAuthInfo.auth_verify_identity = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(168936);
          return 0;
        }
        localFinderAuthInfo.verify_status = ((i.a.a.a.a)localObject).ajGk.aar();
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