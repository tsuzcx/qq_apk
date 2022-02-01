package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doc
  extends com.tencent.mm.bx.a
{
  public String PMd;
  public String aaVe;
  public String avatar;
  public String desc;
  public int hGP;
  public LinkedList<dob> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String username;
  
  public doc()
  {
    AppMethodBeat.i(258268);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(258268);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258275);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.objectId != null) {
        paramVarArgs.g(1, this.objectId);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(4, this.avatar);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      paramVarArgs.bS(6, this.hGP);
      paramVarArgs.e(7, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.g(8, this.objectNonceId);
      }
      if (this.aaVe != null) {
        paramVarArgs.g(9, this.aaVe);
      }
      if (this.PMd != null) {
        paramVarArgs.g(10, this.PMd);
      }
      AppMethodBeat.o(258275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label804;
      }
    }
    label804:
    for (int i = i.a.a.b.b.a.h(1, this.objectId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.avatar != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.avatar);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.hGP) + i.a.a.a.c(7, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.aaVe != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaVe);
      }
      paramInt = i;
      if (this.PMd != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.PMd);
      }
      AppMethodBeat.o(258275);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        doc localdoc = (doc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258275);
          return -1;
        case 1: 
          localdoc.objectId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 2: 
          localdoc.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 3: 
          localdoc.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 4: 
          localdoc.avatar = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 5: 
          localdoc.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 6: 
          localdoc.hGP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258275);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dob localdob = new dob();
            if ((localObject != null) && (localObject.length > 0)) {
              localdob.parseFrom((byte[])localObject);
            }
            localdoc.mediaList.add(localdob);
            paramInt += 1;
          }
          AppMethodBeat.o(258275);
          return 0;
        case 8: 
          localdoc.objectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        case 9: 
          localdoc.aaVe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258275);
          return 0;
        }
        localdoc.PMd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258275);
        return 0;
      }
      AppMethodBeat.o(258275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doc
 * JD-Core Version:    0.7.0.1
 */