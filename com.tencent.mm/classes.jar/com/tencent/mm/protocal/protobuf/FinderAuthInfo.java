package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderAuthInfo
  extends com.tencent.mm.cd.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.realName != null) {
        paramVarArgs.f(1, this.realName);
      }
      paramVarArgs.aY(2, this.authIconType);
      if (this.authProfession != null) {
        paramVarArgs.f(3, this.authProfession);
      }
      if (this.authGenerator != null)
      {
        paramVarArgs.oE(4, this.authGenerator.computeSize());
        this.authGenerator.writeFields(paramVarArgs);
      }
      if (this.detailLink != null) {
        paramVarArgs.f(5, this.detailLink);
      }
      if (this.appName != null) {
        paramVarArgs.f(6, this.appName);
      }
      if (this.authIconUrl != null) {
        paramVarArgs.f(7, this.authIconUrl);
      }
      paramVarArgs.aY(8, this.customer_type);
      paramVarArgs.aY(9, this.auth_verify_identity);
      paramVarArgs.aY(10, this.verify_status);
      AppMethodBeat.o(168936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.realName == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = g.a.a.b.b.a.g(1, this.realName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.authIconType);
      paramInt = i;
      if (this.authProfession != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.authProfession);
      }
      i = paramInt;
      if (this.authGenerator != null) {
        i = paramInt + g.a.a.a.oD(4, this.authGenerator.computeSize());
      }
      paramInt = i;
      if (this.detailLink != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.detailLink);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.appName);
      }
      paramInt = i;
      if (this.authIconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.authIconUrl);
      }
      i = g.a.a.b.b.a.bM(8, this.customer_type);
      int j = g.a.a.b.b.a.bM(9, this.auth_verify_identity);
      int k = g.a.a.b.b.a.bM(10, this.verify_status);
      AppMethodBeat.o(168936);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168936);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        FinderAuthInfo localFinderAuthInfo = (FinderAuthInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168936);
          return -1;
        case 1: 
          localFinderAuthInfo.realName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 2: 
          localFinderAuthInfo.authIconType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(168936);
          return 0;
        case 3: 
          localFinderAuthInfo.authProfession = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
          localFinderAuthInfo.detailLink = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 6: 
          localFinderAuthInfo.appName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 7: 
          localFinderAuthInfo.authIconUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168936);
          return 0;
        case 8: 
          localFinderAuthInfo.customer_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(168936);
          return 0;
        case 9: 
          localFinderAuthInfo.auth_verify_identity = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(168936);
          return 0;
        }
        localFinderAuthInfo.verify_status = ((g.a.a.a.a)localObject).abFh.AK();
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